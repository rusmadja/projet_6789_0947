package geometries;

import primitives.Point3D;
import primitives.Vector;
import primitives.*;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;


public class Plane implements Geometry {
    Point3D _p;
    Vector _normal;

    public Plane(Point3D vertex1, Point3D vertex2, Point3D vertex3) {
        _p = new Point3D(vertex1);

        Vector U = new Vector(vertex1,vertex2);
        Vector V = new Vector(vertex1,vertex3);
        //N = U x V
        _normal = U.crossProduct(V);
        _normal =_normal.normalize();

    }
    public Plane(Point3D _p, Vector _normal) {
        this._p = new Point3D(_p.get_x(),_p.get_y(),_p.get_z());
        this._normal = new Vector (_normal.get_head());
    }

    @Override
    public Vector getNormal(Point3D _point3D)
    {
        return new Vector(_normal);
    }

    //because polygon
    public Vector getNormal() {
        return getNormal(null);
    }

    @Override
    public String toString() {
        return "Plane{" +
                "_p=" + _p +
                ", _normal=" + _normal +
                '}';
    }


    @Override
    public java.util.List<primitives.Point3D> findIntersections(primitives.Ray ray) throws ArithmeticException {

        //Plane points: N ∙ 𝑄0 − 𝑃 = 0
        //𝑁 ∙ 𝑣
        double denominator = this.getNormal().dotProduct(ray.getDirection());
        // zeroes in denominator
        if (isZero(denominator))
            throw new ArithmeticException("impossible to divide by 0");

        try { // if  Q0 = P0 that reject Illegal Argument Exception
            //𝑁 ∙ (𝑄0 − 𝑃0)
            double numerator = this.getNormal().dotProduct(this._p.subtract(ray.getPoint()));

            //𝑡 = [𝑁 ∙ (𝑄0 − 𝑃0)] / [𝑁 ∙ 𝑣]
            double t = numerator / denominator;
            java.util.List temp = new java.util.ArrayList();

            Point3D P;
            // take only 𝒕 > 0
            if (alignZero(t) > 0) {
                //Ray points: 𝑃 = 𝑃0 + 𝑡 ∙ 𝑣, 𝑡 ≥ 0
                P = ray.getP(t);
                temp.add(P);
            }
            return temp;
        }catch (IllegalArgumentException IAe ){
            return java.util.Collections.EMPTY_LIST;
        }
    }

}
