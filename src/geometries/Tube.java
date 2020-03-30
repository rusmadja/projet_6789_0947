package geometries;

import primitives.*;

public class Tube extends RadialGeometry{
    Ray _axisRay ;
    public Tube(double _radius) {
        super(_radius);
    }

    @Override
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
