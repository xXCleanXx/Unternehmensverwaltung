package geometry;

import geometry.abstractions.SkinSurface;

public final class PyramidSkinSurface extends SkinSurface {
    public PyramidSkinSurface(Polygon polygon, double height) {
        super(polygon, height);
    }

    public double skinSurface() {
        Polygon polygon = (Polygon)this.getArea();
        Triangle s = new Triangle(polygon.getLength(), Math.sqrt(Math.pow(polygon.getLength() / 2, 2) + Math.pow(super.getHeight(), 2)));

        return polygon.getCorners() * s.area();
    }
}
