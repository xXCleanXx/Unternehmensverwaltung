package geometry;

import geometry.abstractions.Figure3D;
import geometry.abstractions.SkinSurface;

public class PyramidLike extends Figure3D {
    private SkinSurface _skinSurface;

    public PyramidLike(SkinSurface skinSurface) {
        this.setSkinSurface(skinSurface);
    }

    public SkinSurface getSkinSurface() {
        return this._skinSurface;
    }

    public void setSkinSurface(SkinSurface skinSurface) {
        if (skinSurface == null) throw new IllegalArgumentException("Skin surface cannot be null!");

        this._skinSurface = skinSurface;
    }

    public double volume() {
        return (this.getSkinSurface().getArea().area() * this.getSkinSurface().getHeight()) / 3;
    }

    public double surface() {
        return this.getSkinSurface().getArea().area() + this.getSkinSurface().skinSurface();
    }
}