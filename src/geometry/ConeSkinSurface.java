package geometry;

import geometry.abstractions.SkinSurface;

public final class ConeSkinSurface extends SkinSurface {
    public ConeSkinSurface(Circle circle, double height) {
        super(circle, height);
    }

    public double skinSurface() {
        Circle circle = (Circle)super.getArea();

        return Math.PI * circle.getRadius() * Math.sqrt(Math.pow(circle.getRadius(), 2) + Math.pow(super.getHeight(), 2));
    }
}