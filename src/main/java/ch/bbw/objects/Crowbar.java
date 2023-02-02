package ch.bbw.objects;

public class Crowbar extends Item {

  private int id;

  public Crowbar(String type, String name, String description, double weight, int id, boolean isPickable) {
    super(type, name, description, weight, isPickable);
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
