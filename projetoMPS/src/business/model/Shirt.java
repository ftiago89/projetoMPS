package business.model;


public class Shirt extends Product{
    private Collar collar;
    private Genre genre;

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

    public Shirt(Collar collar, Genre genre) {
        this.collar = collar;
        this.genre = genre;
    }
}
