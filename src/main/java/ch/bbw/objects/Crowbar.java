package ch.bbw.objects;

public class Crowbar extends Item {

  private int id;
  private double weight;

  public Crowbar(String type, String name, String description, int id, double weight) {
    super(type, name, description);
    this.id = id;
    this.weight = weight;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }
}
