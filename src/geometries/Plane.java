package geometries;

import primitives.Point3D;
import primitives.Vector;


public class Plane implements Geometry {
    Point3D _p;
    Vector _normal;

    public Plane(Point3D vertex1, Point3D vertex2, Point3D vertex3) {
        _p = new Point3D(vertex1);

        Vector U = new Vector(vertex1, vertex2);
        Vector V = new Vector(vertex1, vertex3);
        //N = U x V
        Vector N = U.crossProduct(V);
        N.normalize();

        _normal = N.scale(-1);

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


}
