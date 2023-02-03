package ch.bbw.zork;import ch.bbw.objects.*;import java.util.ArrayList;/** * Class Game - the main class of the "Zork" game. * <p> * Author:  Michael Kolling, 1.1, March 2000 * refactoring: Rinaldo Lanza, September 2020 */public class Game {  private final Parser parser;  private Room currentRoom;  private Room lastRoom;  private final Room laboratory;  private final Room patientRoom;  private final Room treatmentRoom;  private final Room groupRoom;  private final Room doctorsOffice;  private final Room xRayRoom;  private final Room outside;  private final Pocket pocket = new Pocket();  public Game() {    parser = new Parser(System.in);    Key keyOpenPatientRoom = new Key(1, "key to open patient room");    Key keyExit = new Key(3, "key to exit psychiatry");    Key keyOpenGroupRoom = new Key(4, "key open group room");    Crowbar crowbarOpenXrayRoom = new Crowbar(2, "crowbar to open x-ray room");    laboratory = new Room("laboratory", null, null, false);    patientRoom = new Room("patient room", keyOpenPatientRoom, null, true);    treatmentRoom = new Room("treatment room", null, null, false);    groupRoom = new Room("group room", keyOpenGroupRoom, null, true);    doctorsOffice = new Room("doctor's office", null, null, false);    xRayRoom = new Room("x-ray room", null, crowbarOpenXrayRoom, true);    outside = new Room("outside the clinic", keyExit, null, true);    laboratory.setExits(null, treatmentRoom, null, null);    patientRoom.setExits(treatmentRoom, groupRoom, outside, xRayRoom);    treatmentRoom.setExits(null, null, patientRoom, laboratory);    groupRoom.setExits(doctorsOffice, null, null, patientRoom);    doctorsOffice.setExits(null, null, groupRoom, null);    xRayRoom.setExits(null, patientRoom, null, null);    outside.setExits(patientRoom, null, null, null);    laboratory.getItems().add(keyOpenPatientRoom);    laboratory.getItems().add(new Furniture(5, "table", 100));    patientRoom.getItems().add(crowbarOpenXrayRoom);    patientRoom.getItems().add(new Furniture(6, "chair", 40));    treatmentRoom.getItems().add(new Furniture(7, "bed", 200));    groupRoom.getItems().add(new Furniture(8, "couch", 300));    doctorsOffice.getItems().add(keyExit);    doctorsOffice.getItems().add(new Furniture(9, "desk", 250));    xRayRoom.getItems().add(keyOpenGroupRoom);    xRayRoom.getItems().add(new Furniture(10, "X-ray machine", 600));    currentRoom = treatmentRoom; // start game in treatment room  }  /**   * Main play routine.  Loops until end of play.   */  public void play() {    printWelcome();    // Enter the main command loop.  Here we repeatedly read commands and    // execute them until the game is over.    boolean finished = false;    boolean win = false;    while (!finished) {      if (currentRoom == outside) {        finished = true;        win = true;        break;      }      Command command = parser.getCommand();      finished = processCommand(command);    }    if (win) {      System.out.println("You won!!!");    }    System.out.println("\nThank you for playing.  Good bye.");  }  private void printWelcome() {    System.out.println("\nWelcome to Zork!");    System.out.println("You woke up alone at night in a psychiatric clinic.");    System.out.println("Your goal is to escape the clinic.");    System.out.println("Type 'help' if you need help.");    System.out.println();    System.out.println(currentRoom.longDescription());  }  private boolean processCommand(Command command) {    if (command.isUnknown()) {      System.out.println("I don't know what you mean...");      return false;    }    String commandWord = command.getCommandWord();    switch (commandWord) {      case "help":        printHelp();        break;      case "go":        lastRoom = currentRoom;        goRoom(command);        break;      case "back":        goRoom(command);        break;      case "search":        searchItems();        break;      case "use":        useItem(command);        break;      case "items":        pocket.showItems();        break;      case "drop":        dropItem(command);        break;      case "quit":        if (command.hasSecondWord()) {          System.out.println("Quit what?");        } else {          return true; // signal that we want to quit        }        break;    }    return false;  }  private void printHelp() {    System.out.println("Your command words are:");    System.out.println(parser.showCommands());  }  private void goRoom(Command command) {    if (command.getCommandWord().equals("back")) {      currentRoom = lastRoom;      System.out.println(currentRoom.longDescription());      return;    }    if (!command.hasSecondWord()) {      System.out.println("Go where?");    } else {      String direction = command.getSecondWord();      // Try to leave current room.      Room nextRoom = currentRoom.nextRoom(direction);      if (nextRoom == null) {        System.out.println("There is no door!");      } else {        if (!nextRoom.isLocked() || nextRoom.getCrowbarToOpen() == null && nextRoom.getKeyToOpen() == null) {          currentRoom = nextRoom;          System.out.println(currentRoom.longDescription());          return;        }        boolean found = false;        for (Item item : pocket.getItems()) {          if (nextRoom.getKeyToOpen() == item || nextRoom.getCrowbarToOpen() == item) {            nextRoom.setLocked(false);            currentRoom = nextRoom;            System.out.println(currentRoom.longDescription());            found = true;            break;          }        }        if (!found && nextRoom.getCrowbarToOpen() != null) {          System.out.println("This door is locked, but can be opened with a crowbar!");        } else if (!found && nextRoom.getKeyToOpen() != null) {          System.out.println("This door is locked! Find a key to open.");        }      }    }  }  private void searchItems() {    if (currentRoom != null) {      ArrayList<Item> items = currentRoom.getItems();      if (items.size() > 0) {        System.out.println("Following items are in " + currentRoom.getDescription() + ":");        for (Item item : items) {          System.out.println("  - " + item.getDescription() + " (" + item.getId() + ")");        }      } else {        System.out.println("This room seems to be empty.");      }    }  }  private void useItem(Command command) {    if (!command.hasSecondWord()) {      System.out.println("Use what?");      return;    }    if (pocket.isAbleToAddItem()) {      int itemId = 0;      try {        itemId = Integer.parseInt(command.getSecondWord());      } catch (NumberFormatException e) {        System.out.println("You need to use the ID (number) of the item.");      }      ArrayList<Item> items = currentRoom.getItems();      if (items.size() > 0) {        for (Item item : items) {          if (itemId != 0 && item.getId() == itemId) {            if (item.isPickable() && !pocket.isItemInPocket(item)) {              pocket.getItems().add(item);              currentRoom.getItems().remove(item);              pocket.showItems();            } else {              System.out.println("You cannot use this item.");            }            break;          }        }      } else {        System.out.println("There are no items to use in this room.");      }    } else {      System.out.println("You have too much weight on you. Drop an item to use another one.");    }  }  private void dropItem(Command command) {    if (!command.hasSecondWord()) {      System.out.println("Drop what?");      return;    }    if (pocket.getItems().size() > 0) {      int itemId = 0;      try {        itemId = Integer.parseInt(command.getSecondWord());      } catch (NumberFormatException e) {        System.out.println("You need to use the ID (number) of the item.");      }      if (itemId > 0) {        pocket.dropItem(itemId, currentRoom);        System.out.println("Removed item from pocket.");        pocket.showItems();      }    } else {      System.out.println("You have no item to drop from your pocket.");    }  }}