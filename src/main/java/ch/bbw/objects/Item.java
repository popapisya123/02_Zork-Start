package ch.bbw.objects;

public class Item {

    private String type;
    private String name;
    private String description;
    private double weight;

    public Item(String type, String name, String description, double weight) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
