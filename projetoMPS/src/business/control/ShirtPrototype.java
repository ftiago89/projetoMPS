package business.control;

//Abstract class for all shirt's prototypes.
public abstract class ShirtPrototype {
    protected double price;
    
    public abstract String Information();
    
    public abstract ShirtPrototype makeClone();

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
