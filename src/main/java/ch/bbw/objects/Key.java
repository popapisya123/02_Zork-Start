package ch.bbw.objects;

public class Key {

  private int id;
  private double weight;

  public Key(int name, double weight) {
    this.id = name;
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
