package geometry;

import geometry.abstractions.RoundFigure;

public class Cone extends RoundFigure {
    private double _height;

    public Cone(double radius, double height) {
        super(radius);
    }

    public double getHeight() {
        return this._height;
    }

    public void setHeight(double height) {
        if (height < 0) throw new IllegalArgumentException("Height cannot be less than 0!");

        this._height = height;
    }

    public double volume() {
        return 1d / 3 * Math.PI * super.getRadius() * super.getRadius();
    }

    public double surface() {
        return Math.PI * super.getRadius() * (super.getRadius() + Math.sqrt(Math.pow(super.getRadius(), 2) + Math.pow(this.getHeight(), 2)));
    }
}