package business.control;

//Prototype for a basic shirt
public class BasicShirtPrototype extends ShirtPrototype{
    
    protected BasicShirtPrototype(BasicShirtPrototype basicPrototype){
        this.price = basicPrototype.getPrice();
    }
    
    public BasicShirtPrototype(){
        this.price = 0.0;
    }

    @Override
    public String Information() {
        return("Basic Shirt, with only one enbroidery on the front. Price: " + getPrice());
    }

    @Override
    public ShirtPrototype makeClone() {
        return new BasicShirtPrototype(this);
    } 
}
