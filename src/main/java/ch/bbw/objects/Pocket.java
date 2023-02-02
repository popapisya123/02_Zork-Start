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
    for (Key key : keys) {
      totalWeight += key.getWeight();
    }

    totalWeight += crowbar.getWeight();

    return totalWeight <= 30;
  }
}
