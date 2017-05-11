package business.model;

//line modelling
public class Line {
    private Color color;
    private double thickness;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    public Line(Color color, double thickness) {
        this.color = color;
        this.thickness = thickness;
    }
}
