package business.control;

//prototype for a v collar shirt
public class VCollarShirtPrototype extends ShirtPrototype{
    protected VCollarShirtPrototype(VCollarShirtPrototype vPrototype){
        this.price = vPrototype.getPrice();
    }
    
    public VCollarShirtPrototype(){
        this.price = 0.0;
    }

    @Override
    public String Information() {
        return("V collar Shirt, with only one enbroidery on the front. Price: " + getPrice());
    }

    @Override
    public ShirtPrototype makeClone() {
        return new VCollarShirtPrototype(this);
    } 
}
