package geometry.abstractions;

public abstract class RoundFigure extends Figure3D {
    private double _radius;

    public RoundFigure(double radius) {
        this.setRadius(radius);
    }

    public double getRadius() {
        return this._radius;
    }

    public void setRadius(double radius) {
        if (radius < 0) throw new IllegalArgumentException("Radius cannot be null!");

        this._radius = radius;
    }
}