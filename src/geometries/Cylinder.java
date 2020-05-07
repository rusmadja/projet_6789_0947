package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

/**
 *  Cylinder: Finite Tube with a certain _height
 */
public class Cylinder extends Tube {
    /**
     *
     */
    private double _height;

    /**
     * Cylinder constructor
     *
     * @param _radius
     * @param _ray
     * @param _height
     */
    public Cylinder(double _radius, Ray _ray, double _height) {
        super(_radius, _ray);
        this._height = _height;
    }

    public Cylinder(Cylinder other) {
        super(other._radius, other._axisRay);
        this._height = other._height;
    }
    public double get_height() {
        return _height;
    }

      /**
     * @param point point to calculate the normal
     * @return normal
     */

    @Override
    public Vector getNormal(Point3D point) {
        Point3D o = _axisRay.getPoint();
        Vector v = _axisRay.getDirection();
        // projection of P-O on the ray:
        double t;
        try {
            t = alignZero(point.subtract(o).dotProduct(v));
        } catch (IllegalArgumentException e) { // P = O
            return v;
        }
        // if the point is at a base
        if (t == 0 || isZero(_height - t)) // if it's close to 0, we'll get ZERO vector exception
            return v;
        o = o.add(v.scale(t));
        return point.subtract(o).normalize();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cylinder cylinder = (Cylinder) o;
        return  super.equals((Tube)o) && isZero(this._height - this._height);
    }


    @Override
    public List<GeoPoint> findIntersections(Ray ray) {
        List<GeoPoint> intersections = super.findIntersections(ray);
        if (intersections != null) {
            for (GeoPoint geoPoint : intersections) {
                geoPoint._geometry = this;
            }
        }
        return intersections;
    }



}
