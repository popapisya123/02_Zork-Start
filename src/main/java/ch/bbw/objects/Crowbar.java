package ch.bbw.objects;

public class Crowbar extends Item {

  private int id;

  public Crowbar(String name, String description, int id) {
    super("crowbar", name, description, 30, true);
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
