package business.model;

import java.util.ArrayList;


public class Towel extends Product{

    public Towel(String name, String description, String brand, Color color, ArrayList<Enbroidery> enbroideries) {
        super(name, description, brand, color, enbroideries);
    }
}
