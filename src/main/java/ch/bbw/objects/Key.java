package ch.bbw.objects;

public class Key extends Item {

  private int id;

  public Key (String name, String description, int id) {
    super("key", name, description, 5);
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
