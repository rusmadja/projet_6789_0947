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

public class Diamond extends Geometries {

    // 8 triangle
    Triangle T1,T2,T3,T4,T5,T6,T7,T8;
    //8 polygon
    Polygon P1,P2,P3,P4,P5,P6,P7,p8;
    // 8 small triangle
    Triangle T11,T21,T31,T41,T51,T61,T71,T81;

    Diamond(Color emissionLight, Material material, Point3D position, int longueur, int hauteur)
    {
        double x = position.get_x().get();
        double y = position.get_y().get();
        double z = position.get_z().get();

        T1 = new Triangle( emissionLight,material,
                           new Point3D(x,y,z) ,
                            new Point3D(x,y+hauteur,z-(longueur/2)),
                            new Point3D(x+((longueur/2)-((longueur/2)/4)),y+hauteur,z-((longueur/2)+((longueur/2)/4))));

        T2 = new Triangle( emissionLight,material,
                           new Point3D(x,y,z) ,
                           new Point3D(x+((longueur/2)-((longueur/2)/4)),y+hauteur,z-((longueur/2)+((longueur/2)/4))),
                           new Point3D(x+(longueur/2),y+hauteur,z));

        T3 = new Triangle( emissionLight,material,
                           new Point3D(x,y,z) ,
                           new Point3D(x+(longueur/2),y+hauteur,z),
                           new Point3D(x+((longueur/2)-((longueur/2)/4)),y+hauteur,z+((longueur/2)-((longueur/2)/4))));

        T4 = new Triangle( emissionLight,material,
                           new Point3D(x,y,z) ,
                           new Point3D(x+((longueur/2)-((longueur/2)/4)),y+hauteur,z+((longueur/2)-((longueur/2)/4))),
                           new Point3D(x,y+hauteur,z+(longueur/2)));

        T5 = new Triangle( emissionLight,material,
                           new Point3D(x,y,z) ,
                           new Point3D(x,y+hauteur,z+(longueur/2)),
                           new Point3D(x-(longueur/2)+((longueur/2)/4),y+hauteur,z+(longueur/2)-((longueur/2)/4)));

        T6 = new Triangle( emissionLight,material,
                           new Point3D(x,y,z) ,
                           new Point3D(x-(longueur/2)+((longueur/2)/4),y+hauteur,z+(longueur/2)-((longueur/2)/4)),
                           new Point3D(x-(longueur/2),y+hauteur,z));

        T7 = new Triangle( emissionLight,material,
                           new Point3D(x,y,z) ,
                           new Point3D(x-(longueur/2),y+hauteur,z),
                           new Point3D(x-(longueur/2)+((longueur/2)/4),y+hauteur,z-(longueur/2)+((longueur/2)/4)));

        T8 = new Triangle(emissionLight,material,
                          new Point3D(x,y,z) ,
                           new Point3D(x-(longueur/2)+((longueur/2)/4),y+hauteur,z-(longueur/2)+((longueur/2)/4)),
                           new Point3D(x,y+hauteur,z-(longueur/2)));


    }

    public List<GeoPoint> findIntersections(Ray ray, double MAXDISTANCE) {

        List<Intersectable.GeoPoint> intersections = new LinkedList<GeoPoint>();

        List<GeoPoint> GeoPoint_T1= T1.findIntersections(ray,MAXDISTANCE);
        if(GeoPoint_T1 != null ) intersections.add(GeoPoint_T1.get(0));

        List<GeoPoint> GeoPoint_T2= T2.findIntersections(ray,MAXDISTANCE);
        if(GeoPoint_T2 != null ) intersections.add(GeoPoint_T2.get(0));

        List<GeoPoint> GeoPoint_T3= T3.findIntersections(ray,MAXDISTANCE);
        if(GeoPoint_T3 != null ) intersections.add(GeoPoint_T3.get(0));

        List<GeoPoint> GeoPoint_T4= T4.findIntersections(ray,MAXDISTANCE);
        if(GeoPoint_T4 != null ) intersections.add(GeoPoint_T4.get(0));

        List<GeoPoint> GeoPoint_T5= T5.findIntersections(ray,MAXDISTANCE);
        if(GeoPoint_T5 != null ) intersections.add(GeoPoint_T5.get(0));

        List<GeoPoint> GeoPoint_T6= T6.findIntersections(ray,MAXDISTANCE);
        if(GeoPoint_T6 != null ) intersections.add(GeoPoint_T6.get(0));

        List<GeoPoint> GeoPoint_T7= T7.findIntersections(ray,MAXDISTANCE);
        if(GeoPoint_T7 != null ) intersections.add(GeoPoint_T7.get(0));

        List<GeoPoint> GeoPoint_T8= T8.findIntersections(ray,MAXDISTANCE);
        if(GeoPoint_T8 != null ) intersections.add(GeoPoint_T8.get(0));


        return intersections;
    }
}
