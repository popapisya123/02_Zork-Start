package ch.bbw.objects;

import java.util.ArrayList;

public class Pocket {

  private ArrayList<Key> keys = new ArrayList<>();
  private Crowbar crowbar;

  public ArrayList<Key> getKeys() {
    return keys;
  }

  public void setKeys(ArrayList<Key> keys) {
    this.keys = keys;
  }

  public Crowbar getCrowbar() {
    return crowbar;
  }

  public void setCrowbar(Crowbar crowbar) {
    this.crowbar = crowbar;
  }

  public boolean isAbleToAddItem() {
    double totalWeight = 0;
    if (keys.size() > 0) {
      for (Key key : keys) {
        totalWeight += key.getWeight();
      }
    }

    if (crowbar != null) {
      totalWeight += crowbar.getWeight();
    }

    return totalWeight <= 20;
  }

  public void showItems() {
    System.out.print("You have following items in your pocket");
    if (keys.size() > 0) {
      for (Key key : keys) {
        System.out.print(", " + key.getDescription());
      }
    }
    if (crowbar != null) {
      System.out.println(", " + getCrowbar().getDescription());
    }
  }
}
