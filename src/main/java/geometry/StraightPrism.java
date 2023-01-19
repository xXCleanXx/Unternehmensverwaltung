package geometry;

import geometry.abstractions.Figure2D;
import geometry.abstractions.Figure3D;

@SuppressWarnings("unused")
public class StraightPrism extends Figure3D {
    private double _height;
    private Figure2D _area;

    public StraightPrism(Figure2D area, double height) {
        this.setHeight(height);
        this.setArea(area);
    }

    public double getHeight() {
        return this._height;
    }

    public void setHeight(double height) {
        if (height < 0) throw new IllegalArgumentException("Height cannot be less than 0!");

        this._height = height;
    }

    public Figure2D getArea() {
        return this._area;
    }

    public void setArea(Figure2D area) {
        if (area == null) throw new IllegalArgumentException("Area cannot be null!");

        this._area = area;
    }

    public double volume() {
        return this.getArea().area() * this.getHeight();
    }

    public double surface() {
        return this.getArea().perimeter() * this.getHeight() * 2 * this.getArea().area();
    }
}