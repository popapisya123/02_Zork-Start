package ch.bbw.objects;

import ch.bbw.zork.Room;

import java.util.ArrayList;

public class Pocket {

  private final ArrayList<Item> items = new ArrayList<>();

  public ArrayList<Item> getItems() {
    return items;
  }

  public boolean isAbleToAddItem() {
    double totalWeight = 0;

    if (items.size() > 0) {
      for (Item item : items) {
        totalWeight += item.getWeight();
      }
    }

    return totalWeight <= 20;
  }

  public boolean isItemInPocket(Item givenItem) {
    boolean itemInPocket = false;
    for (Item pocketItem : items) {
      if (pocketItem.getId() == givenItem.getId()) {
        itemInPocket = true;
        break;
      }
    }

    return itemInPocket;
  }

  public void showItems() {
    if (items.size() > 0) {
      System.out.println("You have following items in your pocket:");
      for (Item item : items) {
        System.out.println("  - " + item.getDescription() + " (" + item.getId() + ")");
      }
    } else {
      System.out.println("You have no item in your pocket.");
    }
  }

  public void dropItem(int itemId, Room room) {
    for (Item item : items) {
      if (item.getId() == itemId) {
        room.getItems().add(item);
        items.remove(item);
        break;
      }
    }
  }
}
