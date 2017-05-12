package business.model;


public class Shirt extends Product{
    private Collar collar;
    private Genre genre;
    private Character size;
    
    public Shirt(String name, String description, Collar collar, Genre genre,
        Color color) {
        super(name, description, color);
        this.collar = collar;
        this.genre = genre;
        this.size = size;
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

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
