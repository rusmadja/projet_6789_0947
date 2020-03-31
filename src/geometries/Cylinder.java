package geometries;

import primitives.Point3D;
import primitives.Vector;

/**
 *
 * Finite Cylinder
 */
public class Cylinder  extends Tube{

    double _height;
    public Cylinder(double _radius) {
        super(_radius);
    }
    // get Finite Cylinder normal

    /**
     *
     * @param _point3D=middle of our cylinder
     * @returnget Finite Cylinder normal
     */
    public Vector getNormal(Point3D _point3D) {
        //TO VERIFY
        // _p = _point3D + _axisRay.vector
       Point3D _p =_point3D.add(_axisRay.get_dir());
       // return the new vector _p - _point3D
        return new primitives.Vector(_p.subtract(_point3D));
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