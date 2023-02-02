package ch.bbw.objects;

public class Crowbar extends Item {

  private int id;

  public Crowbar(String type, String name, String description, double weight, int id) {
    super(type, name, description, weight);
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
