package geometries;

import elements.Material;
import primitives.*;

import java.util.List;

import static primitives.Util.alignZero;


public class Sphere extends RadialGeometry {
    Point3D _center;

    /**
     * constructor for a new sphere object.
     *
     * @param radius
     *         the radius of the sphere
     * @param center
     *         the center point of the sphere
     *
     * @throws Exception
     *         in case of negative or zero radius from RadialGeometry constructor
     */

    public Sphere(Color emissionLight, Material material, double radius, Point3D center) {
        super(emissionLight,material, radius,Util.getMax(center,radius),Util.getMin(center,radius));
        this._center = new Point3D(center);
    }

    public Sphere(Color emissionLight, double radius, Point3D center) {
        this(emissionLight, new Material(0, 0, 0), radius, center);
    }

    public Sphere(double radius, Point3D center) {
        this(Color.BLACK, new Material(0, 0, 0), radius, center);
    }

    public Point3D get_center() {
        return new Point3D(_center.get_x(), _center.get_y(), _center.get_z());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Sphere)) return false;
        Sphere other = (Sphere) o;
        return this._center.equals(other._center) && (Util.isZero(this._radius - other._radius));
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
        Vector v = _point3D.subtract(get_center());
        v = v.normalize();
        return v;
    }

    /**
     * @param ray
     *
     * @return point3D if...
     */
    @Override
    public List<GeoPoint> findIntersections(Ray ray, double maxDistance) {
        Point3D p0 = ray.getPoint();
        Vector v = ray.getDirection();
        Vector u;
        try {
            u = _center.subtract(p0);   // p0 == _center
        } catch (IllegalArgumentException e) {
            return List.of(new GeoPoint(this, (ray.getTargetPoint(_radius))));
        }
        double tm = alignZero(v.dotProduct(u));
        double dSquared = (tm == 0) ? u.lengthSquared() : u.lengthSquared() - tm * tm;
        double thSquared = alignZero(_radius * _radius - dSquared);

        if (thSquared <= 0) return null;

        double th = alignZero(Math.sqrt(thSquared));
        if (th == 0) return null;

        double t1 = alignZero(tm - th);
        double t2 = alignZero(tm + th);

        double t1dist = alignZero(maxDistance - t1);
        double t2dist = alignZero(maxDistance - t2);

        if (t1 <= 0 && t2 <= 0) {
            return null;
        }

        if (t1 > 0 && t2 > 0) {
            if (t1dist > 0 && t2dist > 0) {
                return List.of(
                        new GeoPoint(this, (ray.getTargetPoint(t1))),
                        new GeoPoint(this, (ray.getTargetPoint(t2)))); //P1 , P2
            } else if (t1dist > 0) {
                return List.of(
                        new GeoPoint(this, (ray.getTargetPoint(t1))));
            } else if (t2dist > 0) {
                return List.of(
                        new GeoPoint(this, (ray.getTargetPoint(t2))));
            }
        }

        if ((t1 > 0) && (t1dist > 0))
            return List.of(new GeoPoint(this, (ray.getTargetPoint(t1))));
        else if ((t2 > 0) && (t2dist > 0))
            return List.of(new GeoPoint(this, (ray.getTargetPoint(t2))));
        return null;
    }
}
