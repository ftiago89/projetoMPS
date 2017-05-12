package business.model;


public class Product {
    private String name; //product name
    private String description;
    private Color color;

    public Product(String name, String description, Color color) {
        this.name = name;
        this.description = description;
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
