package ch.bbw.objects;

public class Item {

    private int id;
    private Type type;
    private String description;
    private double weight;
    private boolean isPickable;

    public Item(int id, Type type, String description, double weight, boolean isPickable) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.weight = weight;
        this.isPickable = isPickable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isPickable() {
        return isPickable;
    }

    public void setPickable(boolean pickable) {
        isPickable = pickable;
    }
}
