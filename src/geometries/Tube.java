package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Util;
import primitives.Vector;

import static primitives.Util.isZero;

/**
 * Represents an infinite tube in the 3D space.
 * That is, the cylinder does not have a length.
 */

public class Tube extends RadialGeometry {
    /**
     *  represents the direction and the reference point
     */
    protected final Ray _axisRay;

    /**
     * constructor for a new Cylinder object
     *
     * @param _radius the radius of the cylinder
     * @param _axisRay    the direction of the cylinder from a center point
     * @throws Exception in case of a negative radius
     */
    public Tube(double _radius, Ray _axisRay) {
        super(_radius);
        this._axisRay = new Ray(_axisRay);
    }

    /**
     *
     * @return ray
     */
    public Ray get_axisRay() {
        return new Ray(_axisRay);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Tube))
            return false;
        if (this == obj)
            return true;
        Tube other = (Tube) obj;

        //the two vectors needs to be in the same direction,
        //but not necessary to have the same length.
        try {
            Vector v = _axisRay.getDirection().crossProduct(other._axisRay.getDirection());
        } catch (IllegalArgumentException ex) {
            return (Util.isZero(this._radius - other._radius) && _axisRay.getPoint().equals((_axisRay.getPoint())));
        }
        throw new IllegalArgumentException("direction cross product with parameter.direction == Vector(0,0,0)");
    }

    @Override
    public String toString() {
        return "ray: " + _axisRay +
                ", radius: " + _radius;
    }

    /**
     *
     * @param point point to calculate the normal
     * @return returns normal vector
     */

    @Override
    public Vector getNormal(Point3D point) {
        //The vector from the point of the cylinder to the given point
        Point3D p0 = _axisRay.getPoint();
        Vector v = _axisRay.getDirection();
        Point3D O = new Point3D(0,0,0);

        //We need the projection to multiply the _direction unit vector
        //𝑡 = 𝑣 ∙ (𝑃 − 𝑃0)

        double t = v.dotProduct(point.subtract(p0));
        if(!isZero(t))
        {
            // projection of P-O on the ray:
            //𝑂 = 𝑃0 + 𝑡 ∙ 𝑣
            O = p0.add(v.scale(t));
        }

        //This vector is orthogonal to the _direction vector.
        //n = normalize(P - O)
        Vector n = point.subtract(O);
        return n.normalize();
    }


    @Override
    public java.util.List<primitives.Point3D> findIntsersections(primitives.Ray ray) {
        return null;
    }
}