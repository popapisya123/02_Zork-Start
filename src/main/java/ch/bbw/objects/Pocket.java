package ch.bbw.objects;

import java.util.ArrayList;

public class Pocket {

  private final ArrayList<Item> items = new ArrayList<>();
  private double totalWeight = 0;

  public ArrayList<Item> getItems() {
    return items;
  }

  public boolean isAbleToAddItem() {
    if (items.size() > 0) {
      for (Item item : items) {
        totalWeight += item.getWeight();
      }
    }

    return totalWeight <= 20;
  }

  public void showItems() {
    if (items.size() > 0) {
      System.out.println("You have following items in your pocket:");
      for (Item item : items) {
        System.out.println("  - " + item.getDescription());
      }
    } else {
      System.out.println("You have no item in your pocket.");
    }
  }
}
