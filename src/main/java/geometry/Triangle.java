package geometry;

import geometry.abstractions.Figure2D;

@SuppressWarnings("unused")
public class Triangle extends Figure2D {
    private double _a;
    private double _b;

    public Triangle(double a) {
        this.setA(a);
        this.setB(a);
    }

    public Triangle(double a, double b) {
        this.setA(a);
        this.setB(b);
    }

    public double getA() {
        return this._a;
    }

    public void setA(double a) {
        if (a < 0) throw new IllegalArgumentException("A cannot be less than 0!");

        this._a = a;
    }

    public double getB() {
        return this._b;
    }

    public void setB(double b) {
        if (b < 0) throw new IllegalArgumentException("B cannot be less than 0!");

        this._b = b;
    }

    public double area() {
        return (this.getA() * this.getB()) / 2;
    }

    public double perimeter() {
        // c² = a² + b²
        return this.getA() + this.getB() + Math.sqrt(Math.pow(this.getA(), 2) + Math.pow(this.getB(), 2));
    }
}