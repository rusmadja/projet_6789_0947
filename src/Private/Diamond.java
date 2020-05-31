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

    // 8 triangles of the low part
    Triangle T1,T2,T3,T4,T5,T6,T7,T8;
    // 12 small triangles of high top
    Triangle T11,T12,T22,T33,T34,T44,T55,T56,T66,T77,T78,T88;
    //1 polygon the top
    Polygon P1;

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

        // high part of the diamond
        T11 = new Triangle(emissionLight,material,
                         new Point3D(x,y+hauteur,z-(longueur/2)),
                         new Point3D(x+((longueur/2)-((longueur/2)/4)),y+hauteur,z-((longueur/2)+((longueur/2)/4))) ,
                         new Point3D(x,y+(hauteur+(hauteur/8)),z-(longueur/8)));

        T12 = new Triangle(emissionLight,material,
                           new Point3D(x+((longueur/2)-((longueur/2)/4)),y+hauteur,z-((longueur/2)+((longueur/2)/4))) ,
                           new Point3D(x,y+(hauteur+(hauteur/8)),z-(longueur/8)),
                           new Point3D(x+(longueur/4),y+(hauteur+(hauteur/8)),z));

        T22 = new Triangle(emissionLight,material,
                           new Point3D(x+((longueur/2)-((longueur/2)/4)),y+hauteur,z-((longueur/2)+((longueur/2)/4))) ,
                           new Point3D(x+(longueur/4),y+(hauteur+(hauteur/8)),z),
                           new Point3D(x+(longueur/2),y+hauteur,z));

        T33 = new Triangle(emissionLight,material,
                           new Point3D(x+(longueur/2),y+hauteur,z),
                           new Point3D(x+(longueur/4),y+(hauteur+(hauteur/8)),z),
                           new Point3D(x+((longueur/2)-((longueur/2)/4)),y+hauteur,z+((longueur/2)-((longueur/2)/4))));

        T34 = new Triangle(emissionLight,material,
                           new Point3D(x+((longueur/2)-((longueur/2)/4)),y+hauteur,z+((longueur/2)-((longueur/2)/4))),
                           new Point3D(x+(longueur/4),y+(hauteur+(hauteur/8)),z),
                           new Point3D(x,y+(hauteur+(hauteur/8)),z+(longueur/8)));

        T44 = new Triangle(emissionLight,material,
                           new Point3D(x+((longueur/2)-((longueur/2)/4)),y+hauteur,z+((longueur/2)-((longueur/2)/4))),
                           new Point3D(x,y+(hauteur+(hauteur/8)),z+(longueur/8)),
                           new Point3D(x,y+hauteur,z+(longueur/2)));

        T55 = new Triangle(emissionLight,material,
                           new Point3D(x,y+hauteur,z+(longueur/2)),
                           new Point3D(x,y+(hauteur+(hauteur/8)),z+(longueur/8)),
                           new Point3D(x-(longueur/2)+((longueur/2)/4),y+hauteur,z+(longueur/2)-((longueur/2)/4)));

        T56 = new Triangle(emissionLight,material,
                           new Point3D(x-(longueur/2)+((longueur/2)/4),y+hauteur,z+(longueur/2)-((longueur/2)/4)),
                           new Point3D(x,y+(hauteur+(hauteur/8)),z+(longueur/8)),
                           new Point3D(x-(longueur/4),y+(hauteur+(hauteur/8)),z));

        T66 = new Triangle(emissionLight,material,
                           new Point3D(x-(longueur/2)+((longueur/2)/4),y+hauteur,z+(longueur/2)-((longueur/2)/4)),
                           new Point3D(x-(longueur/4),y+(hauteur+(hauteur/8)),z),
                           new Point3D(x-(longueur/2),y+hauteur,z));

        T77 = new Triangle(emissionLight,material,
                           new Point3D(x-(longueur/2),y+hauteur,z),
                           new Point3D(x-(longueur/4),y+(hauteur+(hauteur/8)),z),
                           new Point3D(x-(longueur/2)+((longueur/2)/4),y+hauteur,z-(longueur/2)+((longueur/2)/4)));

        T78 = new Triangle(emissionLight,material,
                           new Point3D(x-(longueur/2)+((longueur/2)/4),y+hauteur,z-(longueur/2)+((longueur/2)/4)),
                           new Point3D(x-(longueur/4),y+(hauteur+(hauteur/8)),z),
                           new Point3D(x,y+(hauteur+(hauteur/8)),z-(longueur/8)));

        T88 = new Triangle(emissionLight,material,
                           new Point3D(x-(longueur/2)+((longueur/2)/4),y+hauteur,z-(longueur/2)+((longueur/2)/4)),
                           new Point3D(x,y+hauteur,z-(longueur/2)),
                           new Point3D(x,y+(hauteur+(hauteur/8)),z-(longueur/8)));

        P1 = new Polygon(new Point3D(x,y+(hauteur+(hauteur/8)),z-(longueur/8)),
                         new Point3D(x+(longueur/4),y+(hauteur+(hauteur/8)),z),
                         new Point3D(x,y+(hauteur+(hauteur/8)),z+(longueur/8)),
                         new Point3D(x-(longueur/4),y+(hauteur+(hauteur/8)),z));


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

        List<GeoPoint> GeoPoint_T11= T11.findIntersections(ray,MAXDISTANCE);
        if(GeoPoint_T11 != null ) intersections.add(GeoPoint_T11.get(0));

        List<GeoPoint> GeoPoint_T12= T12.findIntersections(ray,MAXDISTANCE);
        if(GeoPoint_T12 != null ) intersections.add(GeoPoint_T12.get(0));

        List<GeoPoint> GeoPoint_T22= T22.findIntersections(ray,MAXDISTANCE);
        if(GeoPoint_T22 != null ) intersections.add(GeoPoint_T22.get(0));

        List<GeoPoint> GeoPoint_T33= T33.findIntersections(ray,MAXDISTANCE);
        if(GeoPoint_T33 != null ) intersections.add(GeoPoint_T33.get(0));

        List<GeoPoint> GeoPoint_T34= T34.findIntersections(ray,MAXDISTANCE);
        if(GeoPoint_T34 != null ) intersections.add(GeoPoint_T34.get(0));

        List<GeoPoint> GeoPoint_T44= T44.findIntersections(ray,MAXDISTANCE);
        if(GeoPoint_T44 != null ) intersections.add(GeoPoint_T44.get(0));

        List<GeoPoint> GeoPoint_T55= T55.findIntersections(ray,MAXDISTANCE);
        if(GeoPoint_T55 != null ) intersections.add(GeoPoint_T55.get(0));

        List<GeoPoint> GeoPoint_T56= T56.findIntersections(ray,MAXDISTANCE);
        if(GeoPoint_T56 != null ) intersections.add(GeoPoint_T56.get(0));

        List<GeoPoint> GeoPoint_T66= T66.findIntersections(ray,MAXDISTANCE);
        if(GeoPoint_T66 != null ) intersections.add(GeoPoint_T66.get(0));

        List<GeoPoint> GeoPoint_T77= T77.findIntersections(ray,MAXDISTANCE);
        if(GeoPoint_T77 != null ) intersections.add(GeoPoint_T77.get(0));

        List<GeoPoint> GeoPoint_T78= T78.findIntersections(ray,MAXDISTANCE);
        if(GeoPoint_T78 != null ) intersections.add(GeoPoint_T78.get(0));

        List<GeoPoint> GeoPoint_T88= T88.findIntersections(ray,MAXDISTANCE);
        if(GeoPoint_T88 != null ) intersections.add(GeoPoint_T88.get(0));

        List<GeoPoint> GeoPoint_P1= P1.findIntersections(ray,MAXDISTANCE);
        if(GeoPoint_P1 != null ) intersections.add(GeoPoint_P1.get(0));


        return intersections;
    }
}
