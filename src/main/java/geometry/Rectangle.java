package geometry;

import geometry.abstractions.Figure2D;

@SuppressWarnings("unused")
public class Rectangle extends Figure2D {
    private double _length;
    private double _width;

    public Rectangle(double length, double width) {
        this.setLength(length);
        this.setWidth(width);
    }

    public double getLength() {
        return this._length;
    }

    public void setLength(double length) {
        if (length < 0) throw new IllegalArgumentException("Length cannot be less than 0!");

        this._length = length;
    }

    public double getWidth() {
        return this._width;
    }

    public void setWidth(double width) {
        if (width < 0) throw new IllegalArgumentException("Width cannot be less than 0!");

        this._width = width;
    }

    public double area() {
        return this.getLength() * this.getWidth();
    }

    public double perimeter() {
        return this.getLength() * 2 + this.getWidth() * 2;
    }
}