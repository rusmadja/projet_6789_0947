package geometries;

import elements.Material;
import primitives.Color;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

public class Plane extends Geometry {

    Point3D _p; //Q
    Vector _normal;

    public Plane(Color emissionLight, Material material, Point3D p1, Point3D p2, Point3D p3) {
        super(emissionLight, material);

        _p = new Point3D(p1);

        Vector U = new Vector(p1, p2);
        Vector V = new Vector(p1, p3);
        Vector N = U.crossProduct(V);
        N.normalize();

        _normal = N;

    }

    public Plane(Color emissionLight, Point3D p1, Point3D p2, Point3D p3) {
        this(emissionLight, new Material(0, 0, 0), p1, p2, p3);
    }

    public Plane(Point3D p1, Point3D p2, Point3D p3) {
        this(Color.BLACK, p1, p2, p3);
    }

    public Plane(Point3D _p, Vector _normal) {
        super(Color.BLACK, new Material(0, 0, 0));

        this._p = new Point3D(_p);
        this._normal = new Vector(_normal);
    }

    @Override
    public Vector getNormal(Point3D p) {
        return _normal;
    }

    //because polygon needs geNormal without parameter
    public Vector getNormal() {
        return getNormal(null);
    }

    @Override
    public List<GeoPoint> findIntersections(Ray ray, double maxDistance) {
        //Plane points: N ∙ 𝑄0 − 𝑃 = 0
        //𝑁 ∙ 𝑣
        double denominator = this.getNormal().dotProduct(ray.getDirection());
        // zeroes in denominator
        if (isZero(denominator))
            return null;

        try { // if  Q0 = P0 that reject Illegal Argument Exception
            //𝑁 ∙ (𝑄0 − 𝑃0)
            double numerator = this.getNormal().dotProduct(this._p.subtract(ray.getPoint()));

            //𝑡 = [𝑁 ∙ (𝑄0 − 𝑃0)] / [𝑁 ∙ 𝑣]
            double t = numerator / denominator;
            double tdist = alignZero(maxDistance - t);
            List<GeoPoint> temp = null;

            Point3D P;
            // take only 𝒕 > 0
            if (alignZero(t) > 0 || tdist <= 0) {
                //Ray points: 𝑃 = 𝑃0 + 𝑡 ∙ 𝑣, 𝑡 ≥ 0
                P = ray.getP(t);
                if (temp == null) {
                    temp = new ArrayList<>();
                    temp.add(new GeoPoint(this, P));
                }
            }
            return temp;
        } catch (IllegalArgumentException IAe) {
            return null;
        }
    }

}
