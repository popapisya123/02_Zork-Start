package ch.bbw.objects;

public class Furniture extends Item {

  public Furniture(int id, String description, double weight) {
    super(id, Type.FURNITURE, description, weight, false);
  }
}
