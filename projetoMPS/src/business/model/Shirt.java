package business.model;

import java.util.ArrayList;


public class Shirt extends Product{
    private Collar collar;
    private Character size, genre;

    public Shirt(String name, String description, String brand, Color color, ArrayList<Enbroidery> enbroideries,
            Collar collar, Character size, Character genre) {
        super(name, description, brand, color, enbroideries);
        this.collar = collar;
        this.size = size;
        this.genre = genre;
    }
    
    public Character getSize() {
        return size;
    }

    public void setSize(Character size) {
        this.size = size;
    }

    public Collar getCollar() {
        return collar;
    }

    public void setCollar(Collar collar) {
        this.collar = collar;
    }

    public Character getGenre() {
        return genre;
    }

    public void setGenre(Character genre) {
        this.genre = genre;
    }
}
