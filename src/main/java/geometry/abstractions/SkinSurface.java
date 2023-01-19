package geometry.abstractions;

import geometry.abstractions.Figure2D;

public abstract class SkinSurface {
    private Figure2D _area;
    private double _height;

    public SkinSurface(Figure2D area, double height) {
        this.setArea(area);
        this.setHeight(height);
    }

    public Figure2D getArea() {
        return this._area;
    }

    public void setArea(Figure2D area) {
        if (area == null) throw new IllegalArgumentException("Area cannot be null!");

        this._area = area;
    }

    public double getHeight() {
        return this._height;
    }

    public void setHeight(double height) {
        if (height < 0) throw new IllegalArgumentException("Height cannot be less than 0!");

        this._height = height;
    }

    public abstract double skinSurface();
}