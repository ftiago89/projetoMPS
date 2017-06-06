package business.model;

import java.util.ArrayList;
import java.util.List;


public class Product extends Entity{
    private String name, description, brand;
    private List<Enbroidery> enbroideries;
    private Color color;

    public Product(String name, String description, String brand, Color color, ArrayList<Enbroidery> enbroideries) {
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.color = color;
        this.enbroideries = enbroideries;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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
}
