package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Sphere extends RadialGeometry {
    Point3D _center;

    public Sphere(double _radius, Point3D _center) {
        super(_radius);
        this._center = new Point3D(this.get_center());
    }
    public Sphere(RadialGeometry other, Point3D _center) {
        super(other);
        this._center = new Point3D(this.get_center());
    }

    public Point3D get_center() {
        return new Point3D(_center.get_x(),_center.get_y(),_center.get_z());
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "_center=" + _center +
                ", _radius=" + _radius +
                '}';
    }


    @Override
    public Vector getNormal(Point3D _point3D) {
        return null;
    }
}
