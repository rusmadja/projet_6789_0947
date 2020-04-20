package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Util;
import primitives.Vector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

/**
 * Represents an infinite tube in the 3D space.
 * That is, the cylinder does not have a length.
 */

public class Tube extends RadialGeometry {
    /**
     * represents the direction and the reference point
     */
    protected final Ray _axisRay;

    /**
     * constructor for a new Cylinder object
     *
     * @param _radius
     *         the radius of the cylinder
     * @param _axisRay
     *         the direction of the cylinder from a center point
     *
     * @throws Exception
     *         in case of a negative radius
     */
    public Tube(double _radius, Ray _axisRay) {
        super(_radius);
        this._axisRay = new Ray(_axisRay);
    }

    /**
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
     * @param point
     *         point to calculate the normal
     *
     * @return returns normal vector
     */

    @Override
    public Vector getNormal(Point3D point) {
        //The vector from the point of the cylinder to the given point
        Point3D p0 = _axisRay.getPoint();
        Vector v = _axisRay.getDirection();
        Point3D O = new Point3D(0, 0, 0);

        //We need the projection to multiply the _direction unit vector
        //𝑡 = 𝑣 ∙ (𝑃 − 𝑃0)

        double t = v.dotProduct(point.subtract(p0));
        if (!isZero(t)) {
            // projection of P-O on the ray:
            //𝑂 = 𝑃0 + 𝑡 ∙ 𝑣
            O = p0.add(v.scale(t));
        }

        //This vector is orthogonal to the _direction vector.
        //n = normalize(P - O)
        Vector n = point.subtract(O);
        return n.normalize();
    }

    /**
     * Function for finding intersections points with an infinite
     * tube.
     * @param ray The ray that we check if it intersects the tube.
     * @return A list of intersection points, if any.
     *                  There are two points on the cylinder that we hit (it can be the same point twice).
     *                  We have to calculate two m values and test whether they fall in the range of [0,maxm].
     *                  If any falls out, we can either throw the point that corresponds to it away (the cylinder will have a hole)
     *                  or we can cap the cylinder with planes.
     *                  One of the planes is defined by a pair (C,-V) and the other by (C+V*maxm,V).
     *                  We hit the planes like a typical plane; the dot products we have already calculated, we only need to do the division(s).
     */

    @Override
    public java.util.List<primitives.Point3D> findIntsersections(primitives.Ray ray)  {
        Vector VA = this._axisRay.getDirection();
        Vector v = ray.getDirection();
        Point3D p0 = ray.getPoint();

       

        double V_dot_Va = v.dotProduct(VA);
        Vector Va_scale_V_dot_Va;
        Vector vMinusVa_scale_V_dot_Va;
        // if the ray is orthogonal to the axis
        if (alignZero(V_dot_Va) == 0) 
            vMinusVa_scale_V_dot_Va = v;
        else {
            Va_scale_V_dot_Va = VA.scale(V_dot_Va);
            try {
                vMinusVa_scale_V_dot_Va = v.subtract(Va_scale_V_dot_Va);
            }
            // if the rays is parallel to axis it throws Illegal Argument Exception
            catch (IllegalArgumentException e)  
            {
                return Collections.emptyList();
            }
        }
        // A = (v-(v°va)°va) * (v-(v°va)°va)
        double a = vMinusVa_scale_V_dot_Va.lengthSquared();

        Vector deltaP = null;
        try {
            deltaP = p0.subtract(this._axisRay.getPoint());
        } catch (IllegalArgumentException e1) { // the ray begins at axis P0
            if (alignZero(V_dot_Va )== 0) // the ray is orthogonal to Axis
                return List.of(ray.getP(_radius));
            return List.of(ray.getP(Math.sqrt(_radius * _radius / vMinusVa_scale_V_dot_Va.lengthSquared())));
        }

        double deltaP_dot_VA = deltaP.dotProduct(VA);
        Vector VA_scale_deltaP_dot_VA, dPMinusVA_scale_deltaP_dot_VA;
        if (alignZero(deltaP_dot_VA) == 0)
            dPMinusVA_scale_deltaP_dot_VA = deltaP;
        else {
            VA_scale_deltaP_dot_VA = VA.scale(deltaP_dot_VA);
            try {
                dPMinusVA_scale_deltaP_dot_VA = deltaP.subtract(VA_scale_deltaP_dot_VA);
            } catch (IllegalArgumentException e) {
                return List.of(ray.getP(Math.sqrt(_radius * _radius / a)));
            }
        }
        // c = (dp - va*(dp°vA))*(dp - va*(dp°vA)) - radius*radius
        double c = dPMinusVA_scale_deltaP_dot_VA.lengthSquared() - _radius * _radius;
        // b/2 = (v - va*(v°va)) * (dp - va*(dp°va)))
        double b = 2 * alignZero(vMinusVa_scale_V_dot_Va.dotProduct(dPMinusVA_scale_deltaP_dot_VA));

        // to resolve : a*t^2 + b*t + c = 0
        double delta = b * b - 4 * a * c;
        // if delta <= 0 that's means there is no solution
        //if delta < 0 that's means ray is outside
        //if delta = 0 that's means ray is tangent
        if (alignZero(delta) <= 0)
            return Collections.emptyList();
        //else delta > 0 that's means ray is intersect

        // the ray is tangent to the tube
        if (isZero(Math.sqrt(delta)))
            return Collections.emptyList(); 
        // we are looking for the 2 solutions of the equation   a*t^2 + b*t + c = 0
        double t1 = (-b - Math.sqrt(delta) )/ 2 * a ;
        double t2 = (-b + Math.sqrt(delta) )/ 2 * a ;

        List<primitives.Point3D> toReturn = new ArrayList<primitives.Point3D>();

        if (alignZero(t1 )> 0)
            toReturn.add(ray.getP(t1));
        if (alignZero(t2) > 0)
            toReturn.add(ray.getP(t2));

        return toReturn ;
    }

}
  

