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

    /** Cylinder constructor
     *
     * @param _radius
     * @param _axisRay
     * @param _height
     */
    public Cylinder(double _radius, Ray _axisRay, double _height) {
        super(_radius, _axisRay);
        this._height = _height;
    }
    public Cylinder(Cylinder other) {
        super(other._radius, other._axisRay);
        this._height = other._height;
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

   /* @Override
    public List<Point3D> findIntersections(Ray ray) {
        return super.findIntersections(ray);
    }
*/

    public double get_height() {
        return _height;
    }
}














//Ray points: 𝑃 = 𝑃0 + 𝑡 ∙ 𝑣, 𝑡 ≥ 0
//Sphere points: 𝑃 − 𝑂
//2 − 𝑟
//2 = 0
//𝑢 = 𝑂 − 𝑃0
//𝑡𝑚 = 𝑣 ∙ 𝑢
//𝑑 = 𝑢
//2 − 𝑡𝑚
//2 ⇨ if (d>r) there are no intersections
//𝑡ℎ = 𝑟
//2 − 𝑑
//2
//𝑡1,2 = 𝑡𝑚 ± 𝑡ℎ, 𝑃𝑖 = 𝑃0 + 𝑡𝑖
//∙ 𝑣, ⇨ take only 𝒕 > �