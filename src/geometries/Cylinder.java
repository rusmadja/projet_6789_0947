package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Cylinder  extends Tube{
    double _height;
    public Cylinder(double _radius) {
        super(_radius);
    }
    public Vector getNormal(Point3D _point3D) {
        //TODO
        //O is projection of P on cylinder's ray:
        //𝑡 = 𝑣 ∙ (𝑃 − 𝑃0)
        //𝑂 = 𝑃0 + 𝑡 ∙ v
        Point3D _projection=  new Point3D(3,3,3);
        //n = normalize(P - O)
        Vector v = _point3D.subtract(_projection);
        return v.normalize();
    }
}
