package geometry;

import geometry.abstractions.Figure2D;

@SuppressWarnings("unused")
public class Circle extends Figure2D {
    private double _radius;

    public Circle(double radius) {
        this.setRadius(radius);
    }

    public double getRadius() {
        return this._radius;
    }

    public void setRadius(double radius) {
        if (radius < 0) throw new IllegalArgumentException();

        this._radius = radius;
    }

    public double area() {
        return Math.PI * Math.pow(this.getRadius(), 2);
    }

    public double perimeter() {
        return 2 * Math.PI * this.getRadius();
    }
}