package geometry;

import geometry.Triangle;
import geometry.abstractions.Figure2D;

public class Polygon extends Figure2D {
    private double _length;
    private int _corners;
    private Triangle _triangle;

    public Polygon(int corners, double length) {
        this.setCorners(corners);
        this.setLength(length);
    }

    public double getLength() {
        return this._length;
    }

    private void setLength(double length) {
        if (length < 0) throw new IllegalArgumentException("Length cannot be less than 0!");

        this._length = length;
    }

    private Triangle getTriangle() {
        if (this._triangle == null) this._triangle = new Triangle(this.getLength());

        return this._triangle;
    }

    public int getCorners() {
        return this._corners;
    }

    private void setCorners(int corners) {
        if (corners < 0) throw new IllegalArgumentException("Corners cannot be less than 0!");

        this._corners = corners;
    }

    public double area() {
        return this.getTriangle().area() * this.getCorners();
    }

    public double perimeter() {
        return this.getLength() * this.getCorners();
    }
}