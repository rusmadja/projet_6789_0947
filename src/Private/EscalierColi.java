package Private;

import elements.Material;
import geometries.Cylinder;
import geometries.Geometries;
import geometries.Intersectable;
import geometries.Tube;
import primitives.Color;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.LinkedList;
import java.util.List;

public class EscalierColi extends Geometries {
    Cylinder T;
    Marche M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22,M23,M24;

    EscalierColi(Color emissionLight, Material material, Point3D position,double hauteur,double largeur, double epaisseurMarche)
    {
        double x = position.get_x().get();
        double y = position.get_y().get();
        double z = position.get_z().get();

        double x0=x-(largeur/2);
        double x1=x-((largeur/2)+largeur/8);
        double x2=x-(largeur/8);
        double x3=x+(largeur/8);
        double x4=x+((largeur/2)-largeur/8);
        double x5=x+(largeur/2);

        double z0=z-(largeur/2);
        double z1=z-((largeur/2)+largeur/8);
        double z2=z-(largeur/8);
        double z3=z+(largeur/8);
        double z4=z+((largeur/2)-largeur/8);
        double z5=z+(largeur/2);

        double h=(hauteur/24);

/*
        T = new Cylinder(
                    largeur/8,
                    new Ray(position,new Vector(0,1,0)),
                          hauteur);
*/
        M1 = new Marche(emissionLight, material,
                        new Point3D(x,y,z),
                        new Point3D(x2,y,z0),
                        new Point3D(x3,y,z0),
                        epaisseurMarche);

        M2 = new Marche(emissionLight, material,
                        new Point3D(x,y+h,z),
                        new Point3D(x3,y+h,z0),
                        new Point3D(x4,y+h,z1),
                        epaisseurMarche);

        M3 = new Marche(emissionLight, material,
                        new Point3D(x,y+2*h,z),
                        new Point3D(x4,y+2*h,z1),
                        new Point3D(x5,y+2*h,z2),
                        epaisseurMarche);

        M4 = new Marche(emissionLight, material,
                        new Point3D(x,y+3*h,z),
                        new Point3D(x5,y+3*h,z2),
                        new Point3D(x5,y+3*h,z3),
                        epaisseurMarche);

        M5 = new Marche(emissionLight, material,
                        new Point3D(x,y+4*h,z),
                        new Point3D(x5,y+4*h,z3),
                        new Point3D(x4,y+4*h,z4),
                        epaisseurMarche);

        M6 = new Marche(emissionLight, material,
                        new Point3D(x,y+5*h,z),
                        new Point3D(x4,y+5*h,z4),
                        new Point3D(x3,y+5*h,z5),
                        epaisseurMarche);

        M7 = new Marche(emissionLight, material,
                        new Point3D(x,y+6*h,z),
                        new Point3D(x3,y+6*h,z5),
                        new Point3D(x2,y+6*h,z5),
                        epaisseurMarche);

        M8 = new Marche(emissionLight, material,
                        new Point3D(x,y+7*h,z),
                        new Point3D(x2,y+7*h,z5),
                        new Point3D(x1,y+7*h,z4),
                        epaisseurMarche);

        M9 = new Marche(emissionLight, material,
                        new Point3D(x,y+8*h,z),
                        new Point3D(x1,y+8*h,z4),
                        new Point3D(x0,y+8*h,z3),
                        epaisseurMarche);

        M10 = new Marche(emissionLight, material,
                        new Point3D(x,y+9*h,z),
                        new Point3D(x0,y+9*h,z3),
                        new Point3D(x0,y+9*h,z2),
                        epaisseurMarche);

        M11 = new Marche(emissionLight, material,
                         new Point3D(x,y+10*h,z),
                         new Point3D(x0,y+10*h,z2),
                         new Point3D(x1,y+10*h,z1),
                         epaisseurMarche);

        M12 = new Marche(emissionLight, material,
                         new Point3D(x,y+11*h,z),
                         new Point3D(x1,y+11*h,z1),
                         new Point3D(x2,y+11*h,z0),
                         epaisseurMarche);

        M13 = new Marche(emissionLight, material,
                        new Point3D(x,y+12*h,z),
                        new Point3D(x2,y+12*h,z0),
                        new Point3D(x3,y+12*h,z0),
                        epaisseurMarche);

        M14 = new Marche(emissionLight, material,
                        new Point3D(x,y+13*h,z),
                        new Point3D(x3,y+13*h,z0),
                        new Point3D(x4,y+13*h,z1),
                        epaisseurMarche);

        M15 = new Marche(emissionLight, material,
                        new Point3D(x,y+14*h,z),
                        new Point3D(x4,y+14*h,z1),
                        new Point3D(x5,y+14*h,z2),
                        epaisseurMarche);

        M16 = new Marche(emissionLight, material,
                        new Point3D(x,y+15*h,z),
                        new Point3D(x5,y+15*h,z2),
                        new Point3D(x5,y+15*h,z3),
                        epaisseurMarche);

        M17 = new Marche(emissionLight, material,
                        new Point3D(x,y+16*h,z),
                        new Point3D(x5,y+16*h,z3),
                        new Point3D(x4,y+16*h,z4),
                        epaisseurMarche);

        M18 = new Marche(emissionLight, material,
                        new Point3D(x,y+17*h,z),
                        new Point3D(x4,y+17*h,z4),
                        new Point3D(x3,y+17*h,z5),
                        epaisseurMarche);

        M19 = new Marche(emissionLight, material,
                        new Point3D(x,y+18*h,z),
                        new Point3D(x3,y+18*h,z5),
                        new Point3D(x2,y+18*h,z5),
                        epaisseurMarche);

        M20 = new Marche(emissionLight, material,
                        new Point3D(x,y+19*h,z),
                        new Point3D(x2,y+19*h,z5),
                        new Point3D(x1,y+19*h,z4),
                        epaisseurMarche);

        M21 = new Marche(emissionLight, material,
                        new Point3D(x,y+20*h,z),
                        new Point3D(x1,y+20*h,z4),
                        new Point3D(x0,y+20*h,z3),
                        epaisseurMarche);

        M22 = new Marche(emissionLight, material,
                         new Point3D(x,y+21*h,z),
                         new Point3D(x0,y+21*h,z3),
                         new Point3D(x0,y+21*h,z2),
                         epaisseurMarche);

        M23 = new Marche(emissionLight, material,
                         new Point3D(x,y+22*h,z),
                         new Point3D(x0,y+22*h,z2),
                         new Point3D(x1,y+22*h,z1),
                         epaisseurMarche);

        M24 = new Marche(emissionLight, material,
                         new Point3D(x,y+23*h,z),
                         new Point3D(x1,y+23*h,z1),
                         new Point3D(x2,y+23*h,z0),
                         epaisseurMarche);
    }

    public List<Intersectable.GeoPoint> findIntersections(Ray ray, double MAXDISTANCE) {

        List<Intersectable.GeoPoint> intersections = new LinkedList<Intersectable.GeoPoint>();

       /* List<Intersectable.GeoPoint> GeoPoint_M= T.findIntersections(ray, MAXDISTANCE);
        if(GeoPoint_M != null )
            for (GeoPoint p: GeoPoint_M) {intersections.add(p);}
*/
        List<GeoPoint> GeoPoint_M= M1.findIntersections(ray, MAXDISTANCE);
        if(GeoPoint_M != null )
            for (GeoPoint p: GeoPoint_M) {intersections.add(p);}

        GeoPoint_M= M2.findIntersections(ray, MAXDISTANCE);
        if(GeoPoint_M != null )
            for (GeoPoint p: GeoPoint_M) {intersections.add(p);}

        GeoPoint_M= M3.findIntersections(ray, MAXDISTANCE);
        if(GeoPoint_M != null )
            for (GeoPoint p: GeoPoint_M) {intersections.add(p);}

        GeoPoint_M= M4.findIntersections(ray, MAXDISTANCE);
        if(GeoPoint_M != null )
            for (GeoPoint p: GeoPoint_M) {intersections.add(p);}

        GeoPoint_M= M5.findIntersections(ray, MAXDISTANCE);
        if(GeoPoint_M != null )
            for (GeoPoint p: GeoPoint_M) {intersections.add(p);}

        GeoPoint_M= M6.findIntersections(ray, MAXDISTANCE);
        if(GeoPoint_M != null )
            for (GeoPoint p: GeoPoint_M) {intersections.add(p);}

        GeoPoint_M= M7.findIntersections(ray, MAXDISTANCE);
        if(GeoPoint_M != null )
            for (GeoPoint p: GeoPoint_M) {intersections.add(p);}

        GeoPoint_M= M8.findIntersections(ray, MAXDISTANCE);
        if(GeoPoint_M != null )
            for (GeoPoint p: GeoPoint_M) {intersections.add(p);}

        GeoPoint_M= M9.findIntersections(ray, MAXDISTANCE);
        if(GeoPoint_M != null )
            for (GeoPoint p: GeoPoint_M) {intersections.add(p);}

        GeoPoint_M= M10.findIntersections(ray, MAXDISTANCE);
        if(GeoPoint_M != null )
            for (GeoPoint p: GeoPoint_M) {intersections.add(p);}

        GeoPoint_M= M11.findIntersections(ray, MAXDISTANCE);
        if(GeoPoint_M != null )
            for (GeoPoint p: GeoPoint_M) {intersections.add(p);}

        GeoPoint_M= M12.findIntersections(ray, MAXDISTANCE);
        if(GeoPoint_M != null )
            for (GeoPoint p: GeoPoint_M) {intersections.add(p);}

        GeoPoint_M= M13.findIntersections(ray, MAXDISTANCE);
        if(GeoPoint_M != null )
            for (GeoPoint p: GeoPoint_M) {intersections.add(p);}

        GeoPoint_M= M14.findIntersections(ray, MAXDISTANCE);
        if(GeoPoint_M != null )
            for (GeoPoint p: GeoPoint_M) {intersections.add(p);}

        GeoPoint_M= M15.findIntersections(ray, MAXDISTANCE);
        if(GeoPoint_M != null )
            for (GeoPoint p: GeoPoint_M) {intersections.add(p);}

        GeoPoint_M= M16.findIntersections(ray, MAXDISTANCE);
        if(GeoPoint_M != null )
            for (GeoPoint p: GeoPoint_M) {intersections.add(p);}

        GeoPoint_M= M17.findIntersections(ray, MAXDISTANCE);
        if(GeoPoint_M != null )
            for (GeoPoint p: GeoPoint_M) {intersections.add(p);}

        GeoPoint_M= M18.findIntersections(ray, MAXDISTANCE);
        if(GeoPoint_M != null )
            for (GeoPoint p: GeoPoint_M) {intersections.add(p);}

        GeoPoint_M= M19.findIntersections(ray, MAXDISTANCE);
        if(GeoPoint_M != null )
            for (GeoPoint p: GeoPoint_M) {intersections.add(p);}

        GeoPoint_M= M20.findIntersections(ray, MAXDISTANCE);
        if(GeoPoint_M != null )
            for (GeoPoint p: GeoPoint_M) {intersections.add(p);}

        GeoPoint_M= M21.findIntersections(ray, MAXDISTANCE);
        if(GeoPoint_M != null )
            for (GeoPoint p: GeoPoint_M) {intersections.add(p);}

        GeoPoint_M= M22.findIntersections(ray, MAXDISTANCE);
        if(GeoPoint_M != null )
            for (GeoPoint p: GeoPoint_M) {intersections.add(p);}

        GeoPoint_M= M23.findIntersections(ray, MAXDISTANCE);
        if(GeoPoint_M != null )
            for (GeoPoint p: GeoPoint_M) {intersections.add(p);}

        GeoPoint_M= M24.findIntersections(ray, MAXDISTANCE);
        if(GeoPoint_M != null )
            for (GeoPoint p: GeoPoint_M) {intersections.add(p);}

        GeoPoint_M= M24.findIntersections(ray, MAXDISTANCE);
        if(GeoPoint_M != null )
            for (GeoPoint p: GeoPoint_M) {intersections.add(p);}


        return intersections;

    }
}
