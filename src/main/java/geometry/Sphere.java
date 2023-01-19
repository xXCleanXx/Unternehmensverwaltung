package geometry;

import geometry.abstractions.RoundFigure;

public class Sphere extends RoundFigure {
    public Sphere(double radius) {
        super(radius);
    }

    public double volume() {
        return 4d / 3 * Math.PI * Math.pow(super.getRadius(), 3);
    }
    public double surface() {
        return 4 * Math.PI * Math.pow(super.getRadius(), 2);
    }
}