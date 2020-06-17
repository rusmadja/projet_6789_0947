package geometries;

import elements.Material;
import primitives.Color;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.LinkedList;
import java.util.List;

public class Cube extends Geometries {

    Polygon Polygon_bottom ;
    Polygon Polygon_up ;
    Polygon Polygon_down ;
    Polygon Polygon_left_side ;
    Polygon Polygon_right_side ;
    Polygon Polygon_front ;

    public Cube(Color emissionLight, Material material, Point3D position, double longueur, double hauteur, double profondeur)
    {
        double x = position.get_x().get();
        double y = position.get_y().get();
        double z = position.get_z().get();


        Polygon_bottom = new Polygon(
                emissionLight,
                material,
                new Point3D(x, y, z+profondeur),
                new Point3D(x+longueur, y, z+profondeur),
                new Point3D(x+longueur, y+hauteur, z+profondeur),
                new Point3D(x, y+hauteur, z+profondeur)
        );
        Polygon_front      = new Polygon(
                emissionLight,
                material,
                new Point3D(x, y, z),
                new Point3D(x+longueur, y, z),
                new Point3D(x+longueur, y+hauteur, z),
                new Point3D(x, y+hauteur, z)
        );
        Polygon_up         = new Polygon(
                emissionLight,
                material,
                new Point3D( x,y+hauteur,z),
                new Point3D(x+longueur, y+hauteur, z),
                new Point3D(x+longueur, y+hauteur, z+profondeur),
                new Point3D(x, y+hauteur, z+profondeur)


        );
        Polygon_down       = new Polygon(
                emissionLight,
                material,
                new Point3D( x,y,z),
                new Point3D(x+longueur, y, z),
                new Point3D(x+longueur, y, z+profondeur),
                new Point3D(x, y, z+profondeur)
        );

        Polygon_left_side  = new Polygon(
                emissionLight,
                material,
                new Point3D(x, y, z),
                new Point3D(x, y, z+profondeur),
                new Point3D(x, y+hauteur, z+profondeur),
                new Point3D(x, y+hauteur, z)
        );

        Polygon_right_side = new Polygon(
                emissionLight,
                material,
                new Point3D(x+longueur, y, z),
                new Point3D(x+longueur, y, z+profondeur),
                new Point3D(x+longueur, y+hauteur, z+profondeur),
                new Point3D(x+longueur, y+hauteur, z)
        );
/*
        double l_5=longueur/5;
        double p_5=profondeur/5;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +0*l_5,  y, z + 0* p_5 ) ,new Point3D(x +1*l_5,  y, z + 0* p_5 ) ,new Point3D(x +1*l_5,  y, z + 1* p_5 ) ,new Point3D(x +0*l_5,  y, z + 1* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +1*l_5,  y, z + 0* p_5 ) ,new Point3D(x +2*l_5,  y, z + 0* p_5 ) ,new Point3D(x +2*l_5,  y, z + 1* p_5 ) ,new Point3D(x +1*l_5,  y, z + 1* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +2*l_5,  y, z + 0* p_5 ) ,new Point3D(x +3*l_5,  y, z + 0* p_5 ) ,new Point3D(x +3*l_5,  y, z + 1* p_5 ) ,new Point3D(x +2*l_5,  y, z + 1* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +3*l_5,  y, z + 0* p_5 ) ,new Point3D(x +4*l_5,  y, z + 0* p_5 ) ,new Point3D(x +4*l_5,  y, z + 1* p_5 ) ,new Point3D(x +3*l_5,  y, z + 1* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +4*l_5,  y, z + 0* p_5 ) ,new Point3D(x +5*l_5,  y, z + 0* p_5 ) ,new Point3D(x +5*l_5,  y, z + 1* p_5 ) ,new Point3D(x +4*l_5,  y, z + 1* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +0*l_5,  y, z + 1* p_5 ) ,new Point3D(x +1*l_5,  y, z + 1* p_5 ) ,new Point3D(x +1*l_5,  y, z + 2* p_5 ) ,new Point3D(x +0*l_5,  y, z + 2* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +1*l_5,  y, z + 1* p_5 ) ,new Point3D(x +2*l_5,  y, z + 1* p_5 ) ,new Point3D(x +2*l_5,  y, z + 2* p_5 ) ,new Point3D(x +1*l_5,  y, z + 2* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +2*l_5,  y, z + 1* p_5 ) ,new Point3D(x +3*l_5,  y, z + 1* p_5 ) ,new Point3D(x +3*l_5,  y, z + 2* p_5 ) ,new Point3D(x +2*l_5,  y, z + 2* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +3*l_5,  y, z + 1* p_5 ) ,new Point3D(x +4*l_5,  y, z + 1* p_5 ) ,new Point3D(x +4*l_5,  y, z + 2* p_5 ) ,new Point3D(x +3*l_5,  y, z + 2* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +4*l_5,  y, z + 1* p_5 ) ,new Point3D(x +5*l_5,  y, z + 1* p_5 ) ,new Point3D(x +5*l_5,  y, z + 2* p_5 ) ,new Point3D(x +4*l_5,  y, z + 2* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +0*l_5,  y, z + 2* p_5 ) ,new Point3D(x +1*l_5,  y, z + 2* p_5 ) ,new Point3D(x +1*l_5,  y, z + 3* p_5 ) ,new Point3D(x +0*l_5,  y, z + 3* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +1*l_5,  y, z + 2* p_5 ) ,new Point3D(x +2*l_5,  y, z + 2* p_5 ) ,new Point3D(x +2*l_5,  y, z + 3* p_5 ) ,new Point3D(x +1*l_5,  y, z + 3* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +2*l_5,  y, z + 2* p_5 ) ,new Point3D(x +3*l_5,  y, z + 2* p_5 ) ,new Point3D(x +3*l_5,  y, z + 3* p_5 ) ,new Point3D(x +2*l_5,  y, z + 3* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +3*l_5,  y, z + 2* p_5 ) ,new Point3D(x +4*l_5,  y, z + 2* p_5 ) ,new Point3D(x +4*l_5,  y, z + 3* p_5 ) ,new Point3D(x +3*l_5,  y, z + 3* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +4*l_5,  y, z + 2* p_5 ) ,new Point3D(x +5*l_5,  y, z + 2* p_5 ) ,new Point3D(x +5*l_5,  y, z + 3* p_5 ) ,new Point3D(x +4*l_5,  y, z + 3* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +0*l_5,  y, z + 3* p_5 ) ,new Point3D(x +1*l_5,  y, z + 3* p_5 ) ,new Point3D(x +1*l_5,  y, z + 4* p_5 ) ,new Point3D(x +0*l_5,  y, z + 4* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +1*l_5,  y, z + 3* p_5 ) ,new Point3D(x +2*l_5,  y, z + 3* p_5 ) ,new Point3D(x +2*l_5,  y, z + 4* p_5 ) ,new Point3D(x +1*l_5,  y, z + 4* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +2*l_5,  y, z + 3* p_5 ) ,new Point3D(x +3*l_5,  y, z + 3* p_5 ) ,new Point3D(x +3*l_5,  y, z + 4* p_5 ) ,new Point3D(x +2*l_5,  y, z + 4* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +3*l_5,  y, z + 3* p_5 ) ,new Point3D(x +4*l_5,  y, z + 3* p_5 ) ,new Point3D(x +4*l_5,  y, z + 4* p_5 ) ,new Point3D(x +3*l_5,  y, z + 4* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +4*l_5,  y, z + 3* p_5 ) ,new Point3D(x +5*l_5,  y, z + 3* p_5 ) ,new Point3D(x +5*l_5,  y, z + 4* p_5 ) ,new Point3D(x +4*l_5,  y, z + 4* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +0*l_5,  y, z + 4* p_5 ) ,new Point3D(x +1*l_5,  y, z + 4* p_5 ) ,new Point3D(x +1*l_5,  y, z + 5* p_5 ) ,new Point3D(x +0*l_5,  y, z + 5* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +1*l_5,  y, z + 4* p_5 ) ,new Point3D(x +2*l_5,  y, z + 4* p_5 ) ,new Point3D(x +2*l_5,  y, z + 5* p_5 ) ,new Point3D(x +1*l_5,  y, z + 5* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +2*l_5,  y, z + 4* p_5 ) ,new Point3D(x +3*l_5,  y, z + 4* p_5 ) ,new Point3D(x +3*l_5,  y, z + 5* p_5 ) ,new Point3D(x +2*l_5,  y, z + 5* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +3*l_5,  y, z + 4* p_5 ) ,new Point3D(x +4*l_5,  y, z + 4* p_5 ) ,new Point3D(x +4*l_5,  y, z + 5* p_5 ) ,new Point3D(x +3*l_5,  y, z + 5* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +4*l_5,  y, z + 4* p_5 ) ,new Point3D(x +5*l_5,  y, z + 4* p_5 ) ,new Point3D(x +5*l_5,  y, z + 5* p_5 ) ,new Point3D(x +4*l_5,  y, z + 5* p_5 ) )) ;
*/

    }


    public Vector getNormal(Point3D p) {
        return null;
    }

    public List<GeoPoint> findIntersections(Ray ray, double MAXDISTANCE) {

        List<Intersectable.GeoPoint> intersections = new LinkedList<GeoPoint>();

        List<GeoPoint> GeoPoint_Bottom = Polygon_bottom.findIntersections(ray,MAXDISTANCE);
        if(GeoPoint_Bottom != null ) intersections.add(GeoPoint_Bottom.get(0));

        List<GeoPoint> GeoPoint_front = Polygon_front.findIntersections(ray,MAXDISTANCE);
        if(GeoPoint_front != null ) intersections.add(GeoPoint_front.get(0));

        List<GeoPoint> GeoPoint_up= Polygon_up.findIntersections(ray,MAXDISTANCE);
        if(GeoPoint_up != null ) intersections.add(GeoPoint_up.get(0));

        List<GeoPoint> GeoPoint_down = Polygon_down.findIntersections(ray,MAXDISTANCE);
        if(GeoPoint_down != null ) intersections.add(GeoPoint_down.get(0));
        /*for (Polygon x :list
        ) {
            List<GeoPoint> _geopoints = x.findIntersections(ray, MAXDISTANCE);
            if(_geopoints != null )intersections.add(_geopoints.get(0)); }*/

        List<GeoPoint> GeoPoint_left_side = Polygon_left_side.findIntersections(ray,MAXDISTANCE);
        if(GeoPoint_left_side != null ) intersections.add(GeoPoint_left_side.get(0));

        List<GeoPoint> GeoPoint_right_side = Polygon_right_side.findIntersections(ray,MAXDISTANCE);
        if(GeoPoint_right_side != null ) intersections.add(GeoPoint_right_side.get(0));


        return intersections;
    }
}