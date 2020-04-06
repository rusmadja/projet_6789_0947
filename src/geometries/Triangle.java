package geometries;

import primitives.*;

public class Triangle extends Polygon
{
    public Triangle(Point3D p1, Point3D p2, Point3D p3) {
        super(new Point3D[]{p1, p2, p3});
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Triangle)) return false;
        Triangle tr = (Triangle) obj;

        return _vertices.get(0).equals(tr._vertices.get(0)) &&
                _vertices.get(1).equals(tr._vertices.get(1)) &&
                _vertices.get(2).equals(tr._vertices.get(2));
    }


    @Override
    public String toString() {
        String result = "";
        for (Point3D p : _vertices ) {
            result += p.toString();
        }
        return  result;
    }

    @Override
    public Vector getNormal(Point3D point) {
        return super.getNormal(point);
    }

    @Override
    public java.util.List<Point3D> findIntsersections(Ray ray) {

        //𝑣1 = 𝑃1 − 𝑃0
        Vector v1 = this._vertices.get(0).subtract(ray.getPoint());
        //𝑣2 = 𝑃2 − 𝑃0
        Vector v2 = this._vertices.get(1).subtract(ray.getPoint());
        //𝑣3 = 𝑃3 − 𝑃0
        Vector v3 = this._vertices.get(2).subtract(ray.getPoint());
        //𝑁1 = 𝑛𝑜𝑟𝑚𝑎𝑙𝑖𝑧𝑒 𝑣1 × 𝑣2
        Vector N1 = v1.crossProduct(v2).normalize();
        //𝑁2 = 𝑛𝑜𝑟𝑚𝑎𝑙𝑖𝑧𝑒 𝑣2 × 𝑣3
        Vector N2 = v2.crossProduct(v3).normalize();
        //𝑁3 = 𝑛𝑜𝑟𝑚𝑎𝑙𝑖𝑧𝑒 𝑣3 × 𝑣1
        Vector N3 = v3.crossProduct(v1).normalize();

        boolean All_Bigger_Than_0 =      ray.getDirection().dotProduct(N1) < 0 &&
                                        ray.getDirection().dotProduct(N1) < 0 &&
                                        ray.getDirection().dotProduct(N1) < 0 ;
        boolean All_Smaller_Than_0 =    ray.getDirection().dotProduct(N1) < 0 &&
                                        ray.getDirection().dotProduct(N1) < 0 &&
                                        ray.getDirection().dotProduct(N1) < 0 ;

        if( All_Bigger_Than_0 || All_Smaller_Than_0)
            return this._plane.findIntsersections(ray);

        return null;


    }
}
