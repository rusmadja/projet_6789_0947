package geometries;

import primitives.*;
import static  primitives.Util.*;


public class Sphere extends RadialGeometry {
    Point3D _center;

    public Sphere(double _radius, Point3D _center) {
        super(_radius);
        this._center = new Point3D(_center);
    }
    public Sphere(RadialGeometry other, Point3D _center) {
        super(other);
        this._center = new Point3D(_center);
    }

    public Point3D get_center() {
        return new Point3D(_center.get_x(),_center.get_y(),_center.get_z());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null ) return false;
        if (!(o instanceof Sphere)) return  false;
        Sphere other = (Sphere) o;
        return this._center.equals(other._center) && (Util.isZero(this._radius - other._radius));
    }
    @Override
    public String toString() {
        return "Sphere{" +
                "_center=" + _center +
                ", _radius=" + _radius +
                '}';
    }


    @Override
    public Vector getNormal(Point3D _point3D) {
        Vector v = _point3D.subtract(get_center());
        v =  v.normalize();
        return v ;
    }

    /**
     * @param ray
     * @return null if ...
     * @return point3D if...
     */
    @Override
    public java.util.List<primitives.Point3D> findIntsersections(Ray ray) {
        //Ray points: 𝑃 = 𝑃0 + 𝑡 ∙ 𝑣, 𝑡 ≥ 0
        //Sphere points: abs(𝑃² − 𝑂²)- r² = 0
        /// start calcule
        //𝑢 = 𝑂 − 𝑃0

        try {
            Vector u;
            u = this.get_center().subtract(ray.getPoint());
            //𝑡𝑚 = 𝑣 ∙ 𝑢
            double tm = ray.getDirection().dotProduct(u);
            //𝑑 = sqrt[ 𝑢.length()² - tm²]
            double d = Math.sqrt(u.length() * u.length() - tm * tm);

            //⇨ if (d>r) there are no intersections
            if (alignZero(d -  this._radius) >0)
                return java.util.Collections.emptyList();
            else {
                //𝑡ℎ = sqrt[𝑟² - d² ]
                double th = Math.sqrt(this.get_radius() * this.get_radius() - d * d);
                //𝑡1,2 = 𝑡𝑚 ± 𝑡ℎ, 𝑃𝑖 = 𝑃0 + 𝑡𝑖
                double t1 = tm + th;
                double t2 = tm - th;

                java.util.List<primitives.Point3D> temp = new java.util.ArrayList<primitives.Point3D>();
                Vector v = ray.getDirection();
                if (alignZero(t1) > 0)
                    temp.add(new primitives.Point3D(ray.getPoint().add(v.scale(t1))));
                if (alignZero(t2) > 0)
                    temp.add(new primitives.Point3D(ray.getPoint().add(v.scale(t2))));
                return temp;
            }
        } catch (IllegalArgumentException e) {
            // if we  try to give p0 = center
            // => return center + radius
            //Point3D p2 = new primitives.Point3D(ray.getPoint().add(ray.getDirection().scale(this._radius)));
            Point3D p2 = new primitives.Point3D(ray.getPoint().add(ray.getDirection().scale(this._radius)));
            return java.util.List.of(p2);
        }




    }
}
