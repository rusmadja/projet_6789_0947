package geometries;

import primitives.*;

/**
 * Infinite Cylinder
 */
public class Tube extends RadialGeometry{
    Ray _axisRay ;

    /**
     * @constructor use father's constructor
     * @param _radius
     */
    public Tube(double _radius) {
        super(_radius);
    }

    /**
     *
     * @param _point3D
     *  @returnget Infinite Cylinder normal
     */
    @Override
    public Vector getNormal(Point3D _point3D) {
        //TODO
        //O is projection of P on cylinder's ray:
        //𝑡 = 𝑣 ∙ (𝑃 − 𝑃0)
        double t = _axisRay.get_dir().dotProduct(_axisRay.get_p0().subtract(_point3D));
        //𝑂 = 𝑃0 + 𝑡 ∙ v
        Point3D _projection=  _axisRay.get_p0().add(_axisRay.get_dir().scale(t));
        //n = normalize(P - O)
        Vector v = _point3D.subtract(_projection);
        return v.normalize();
    }
}
