package Private;

import elements.Material;
import geometries.Geometries;
import geometries.Intersectable;
import geometries.Polygon;
import geometries.Triangle;
import primitives.Color;
import primitives.Point3D;
import primitives.Ray;

import java.util.LinkedList;
import java.util.List;

public class Marche extends Geometries {

    Triangle high, low;
    Polygon left, back, right;

    Marche(Color emissionLight, Material material, Point3D position, Point3D p2, Point3D p3, double epaisseur) {
        double x = position.get_x().get();
        double y = position.get_y().get();
        double z = position.get_z().get();

        low = new Triangle(emissionLight, material,
                           new Point3D(x, y, z),
                           new Point3D(p2.get_x().get(), p2.get_y().get(), p2.get_z().get()),
                           new Point3D(p3.get_x().get(), p3.get_y().get(), p3.get_z().get()));

        high = new Triangle(emissionLight, material,
                            new Point3D(x, y + epaisseur, z),
                            new Point3D(p2.get_x().get(), p2.get_y().get() + epaisseur, p2.get_z().get()),
                            new Point3D(p3.get_x().get(), p3.get_y().get() + epaisseur, p3.get_z().get()));

        left = new Polygon(emissionLight, material,
                           new Point3D(x, y, z),
                           new Point3D(p2.get_x().get(), p2.get_y().get(), p2.get_z().get()),
                           new Point3D(p2.get_x().get(), p2.get_y().get() + epaisseur, p2.get_z().get()),
                           new Point3D(x, y + epaisseur, z));

        back = new Polygon(emissionLight, material,
                           new Point3D(p2.get_x().get(), p2.get_y().get(), p2.get_z().get()),
                           new Point3D(p3.get_x().get(), p3.get_y().get(), p3.get_z().get()),
                           new Point3D(p3.get_x().get(), p3.get_y().get() + epaisseur, p3.get_z().get()),
                           new Point3D(p2.get_x().get(), p2.get_y().get() + epaisseur, p2.get_z().get()));

        right = new Polygon(emissionLight, material,
                            new Point3D(p3.get_x().get(), p3.get_y().get(), p3.get_z().get()),
                            new Point3D(x, y, z),
                            new Point3D(x, y + epaisseur, z),
                            new Point3D(p3.get_x().get(), p3.get_y().get() + epaisseur, p3.get_z().get()));
    }

    public List<Intersectable.GeoPoint> findIntersections(Ray ray, double MAXDISTANCE) {

        List<Intersectable.GeoPoint> intersections = new LinkedList<Intersectable.GeoPoint>();

        List<Intersectable.GeoPoint> GeoPoint_Thigh= high.findIntersections(ray, MAXDISTANCE);
        if(GeoPoint_Thigh != null ) intersections.add(GeoPoint_Thigh.get(0));

        List<Intersectable.GeoPoint> GeoPoint_Tlow= low.findIntersections(ray, MAXDISTANCE);
        if(GeoPoint_Tlow != null ) intersections.add(GeoPoint_Tlow.get(0));

        List<Intersectable.GeoPoint> GeoPoint_Pleft= left.findIntersections(ray, MAXDISTANCE);
        if(GeoPoint_Pleft != null ) intersections.add(GeoPoint_Pleft.get(0));

        List<Intersectable.GeoPoint> GeoPoint_Pback= back.findIntersections(ray, MAXDISTANCE);
        if(GeoPoint_Pback != null ) intersections.add(GeoPoint_Pback.get(0));

        List<Intersectable.GeoPoint> GeoPoint_Pright= right.findIntersections(ray, MAXDISTANCE);
        if(GeoPoint_Pright != null ) intersections.add(GeoPoint_Pright.get(0));


        return intersections;
    }
}
