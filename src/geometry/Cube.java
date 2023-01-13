package geometry;

public class Cube extends StraightPrism {
    public Cube(double a, double b, double height) {
        super(new Rectangle(a,b), height);
    }
}