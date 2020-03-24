package geometries;

import primitives.*;


public class Plane implements Geometry {
    Point3D _p;
    Vector _normal;

    public Plane(Point3D vertex1, Point3D vertex2, Point3D vertex3) {
        Vector _vector1 = new Vector(vertex1,vertex2);
        Vector _vector2 = new Vector(vertex1,vertex3);
        this._p = new Point3D(vertex1.get_x(),vertex1.get_y(),vertex1.get_z());
        this._normal= null/*new Vector(_vector1.crossProduct(_vector2))*/;
    }
    public Plane(Point3D _p, Vector _normal) {
        this._p = new Point3D(_p.get_x(),_p.get_y(),_p.get_z());
        this._normal = new Vector (_normal.get_head());
    }
    @Override
    public Vector getNormal(Point3D _point3D)
    {
        return new Vector(_normal.get_head());
    }

    @Override
    public String toString() {
        return "Plane{" +
                "_p=" + _p +
                ", _normal=" + _normal +
                '}';
    }
}
