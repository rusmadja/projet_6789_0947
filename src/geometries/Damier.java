package geometries;


import elements.Material;
import primitives.Color;
import primitives.Point3D;
import primitives.Ray;

import java.util.LinkedList;
import java.util.List;

public class Damier extends Geometries {

    List<Polygon> list = new LinkedList<Polygon>();

    public Damier( Material material, Point3D position, double longueur, double profondeur)
    {
        double x = position.get_x().get();
        double y = position.get_y().get();
        double z = position.get_z().get();
        double l_5=longueur/8;
        double p_5=profondeur/8;

        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +0*l_5,  y, z + 0* p_5 ) ,new Point3D(x +1*l_5,  y, z +0* p_5 ) ,new Point3D(x +1*l_5,  y, z + 1* p_5 ) ,new Point3D(x +0*l_5,  y, z + 1* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +1*l_5,  y, z + 0* p_5 ) ,new Point3D(x +2*l_5,  y, z + 0* p_5 ) ,new Point3D(x +2*l_5,  y, z + 1* p_5 ) ,new Point3D(x +1*l_5,  y, z + 1* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +2*l_5,  y, z + 0* p_5 ) ,new Point3D(x +3*l_5,  y, z + 0* p_5 ) ,new Point3D(x +3*l_5,  y, z + 1* p_5 ) ,new Point3D(x +2*l_5,  y, z + 1* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +3*l_5,  y, z + 0* p_5 ) ,new Point3D(x +4*l_5,  y, z + 0* p_5 ) ,new Point3D(x +4*l_5,  y, z + 1* p_5 ) ,new Point3D(x +3*l_5,  y, z + 1* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +4*l_5,  y, z + 0* p_5 ) ,new Point3D(x +5*l_5,  y, z + 0* p_5 ) ,new Point3D(x +5*l_5,  y, z + 1* p_5 ) ,new Point3D(x +4*l_5,  y, z + 1* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +5*l_5,  y, z + 0* p_5 ) ,new Point3D(x +6*l_5,  y, z + 0* p_5 ) ,new Point3D(x +6*l_5,  y, z + 1* p_5 ) ,new Point3D(x +5*l_5,  y, z + 1* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +6*l_5,  y, z + 0* p_5 ) ,new Point3D(x +7*l_5,  y, z + 0* p_5 ) ,new Point3D(x +7*l_5,  y, z + 1* p_5 ) ,new Point3D(x +6*l_5,  y, z + 1* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +7*l_5,  y, z + 0* p_5 ) ,new Point3D(x +8*l_5,  y, z + 0* p_5 ) ,new Point3D(x +8*l_5,  y, z + 1* p_5 ) ,new Point3D(x +7*l_5,  y, z + 1* p_5 ) )) ;

        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +0*l_5,  y, z + 1* p_5 ) ,new Point3D(x +1*l_5,  y, z +1* p_5 ) ,new Point3D(x +1*l_5,  y, z + 2* p_5 ) ,new Point3D(x +0*l_5,  y, z + 2* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +1*l_5,  y, z + 1* p_5 ) ,new Point3D(x +2*l_5,  y, z + 1* p_5 ) ,new Point3D(x +2*l_5,  y, z + 2* p_5 ) ,new Point3D(x +1*l_5,  y, z + 2* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +2*l_5,  y, z + 1* p_5 ) ,new Point3D(x +3*l_5,  y, z + 1* p_5 ) ,new Point3D(x +3*l_5,  y, z + 2* p_5 ) ,new Point3D(x +2*l_5,  y, z + 2* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +3*l_5,  y, z + 1* p_5 ) ,new Point3D(x +4*l_5,  y, z + 1* p_5 ) ,new Point3D(x +4*l_5,  y, z + 2* p_5 ) ,new Point3D(x +3*l_5,  y, z + 2* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +4*l_5,  y, z + 1* p_5 ) ,new Point3D(x +5*l_5,  y, z + 1* p_5 ) ,new Point3D(x +5*l_5,  y, z + 2* p_5 ) ,new Point3D(x +4*l_5,  y, z + 2* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +5*l_5,  y, z + 1* p_5 ) ,new Point3D(x +6*l_5,  y, z + 1* p_5 ) ,new Point3D(x +6*l_5,  y, z + 2* p_5 ) ,new Point3D(x +5*l_5,  y, z + 2* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +6*l_5,  y, z + 1* p_5 ) ,new Point3D(x +7*l_5,  y, z + 1* p_5 ) ,new Point3D(x +7*l_5,  y, z + 2* p_5 ) ,new Point3D(x +6*l_5,  y, z + 2* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +7*l_5,  y, z + 1* p_5 ) ,new Point3D(x +8*l_5,  y, z + 1* p_5 ) ,new Point3D(x +8*l_5,  y, z + 2* p_5 ) ,new Point3D(x +7*l_5,  y, z + 2* p_5 ) )) ;

        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +0*l_5,  y, z + 2* p_5 ) ,new Point3D(x +1*l_5,  y, z +2* p_5 ) ,new Point3D(x +1*l_5,  y, z + 3* p_5 ) ,new Point3D(x +0*l_5,  y, z + 3* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +1*l_5,  y, z + 2* p_5 ) ,new Point3D(x +2*l_5,  y, z + 2* p_5 ) ,new Point3D(x +2*l_5,  y, z + 3* p_5 ) ,new Point3D(x +1*l_5,  y, z + 3* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +2*l_5,  y, z + 2* p_5 ) ,new Point3D(x +3*l_5,  y, z + 2* p_5 ) ,new Point3D(x +3*l_5,  y, z + 3* p_5 ) ,new Point3D(x +2*l_5,  y, z + 3* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +3*l_5,  y, z + 2* p_5 ) ,new Point3D(x +4*l_5,  y, z + 2* p_5 ) ,new Point3D(x +4*l_5,  y, z + 3* p_5 ) ,new Point3D(x +3*l_5,  y, z + 3* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +4*l_5,  y, z + 2* p_5 ) ,new Point3D(x +5*l_5,  y, z + 2* p_5 ) ,new Point3D(x +5*l_5,  y, z + 3* p_5 ) ,new Point3D(x +4*l_5,  y, z + 3* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +5*l_5,  y, z + 2* p_5 ) ,new Point3D(x +6*l_5,  y, z + 2* p_5 ) ,new Point3D(x +6*l_5,  y, z + 3* p_5 ) ,new Point3D(x +5*l_5,  y, z + 3* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +6*l_5,  y, z + 2* p_5 ) ,new Point3D(x +7*l_5,  y, z + 2* p_5 ) ,new Point3D(x +7*l_5,  y, z + 3* p_5 ) ,new Point3D(x +6*l_5,  y, z + 3* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +7*l_5,  y, z + 2* p_5 ) ,new Point3D(x +8*l_5,  y, z + 2* p_5 ) ,new Point3D(x +8*l_5,  y, z + 3* p_5 ) ,new Point3D(x +7*l_5,  y, z + 3* p_5 ) )) ;

        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +0*l_5,  y, z + 3* p_5 ) ,new Point3D(x +1*l_5,  y, z +3* p_5 ) ,new Point3D(x +1*l_5,  y, z + 4* p_5 ) ,new Point3D(x +0*l_5,  y, z + 4* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +1*l_5,  y, z + 3* p_5 ) ,new Point3D(x +2*l_5,  y, z + 3* p_5 ) ,new Point3D(x +2*l_5,  y, z + 4* p_5 ) ,new Point3D(x +1*l_5,  y, z + 4* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +2*l_5,  y, z + 3* p_5 ) ,new Point3D(x +3*l_5,  y, z + 3* p_5 ) ,new Point3D(x +3*l_5,  y, z + 4* p_5 ) ,new Point3D(x +2*l_5,  y, z + 4* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +3*l_5,  y, z + 3* p_5 ) ,new Point3D(x +4*l_5,  y, z + 3* p_5 ) ,new Point3D(x +4*l_5,  y, z + 4* p_5 ) ,new Point3D(x +3*l_5,  y, z + 4* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +4*l_5,  y, z + 3* p_5 ) ,new Point3D(x +5*l_5,  y, z + 3* p_5 ) ,new Point3D(x +5*l_5,  y, z + 4* p_5 ) ,new Point3D(x +4*l_5,  y, z + 4* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +5*l_5,  y, z + 3* p_5 ) ,new Point3D(x +6*l_5,  y, z + 3* p_5 ) ,new Point3D(x +6*l_5,  y, z + 4* p_5 ) ,new Point3D(x +5*l_5,  y, z + 4* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +6*l_5,  y, z + 3* p_5 ) ,new Point3D(x +7*l_5,  y, z + 3* p_5 ) ,new Point3D(x +7*l_5,  y, z + 4* p_5 ) ,new Point3D(x +6*l_5,  y, z + 4* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +7*l_5,  y, z + 3* p_5 ) ,new Point3D(x +8*l_5,  y, z + 3* p_5 ) ,new Point3D(x +8*l_5,  y, z + 4* p_5 ) ,new Point3D(x +7*l_5,  y, z + 4* p_5 ) )) ;

        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +0*l_5,  y, z + 4* p_5 ) ,new Point3D(x +1*l_5,  y, z +4* p_5 ) ,new Point3D(x +1*l_5,  y, z + 5* p_5 ) ,new Point3D(x +0*l_5,  y, z + 5* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +1*l_5,  y, z + 4* p_5 ) ,new Point3D(x +2*l_5,  y, z + 4* p_5 ) ,new Point3D(x +2*l_5,  y, z + 5* p_5 ) ,new Point3D(x +1*l_5,  y, z + 5* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +2*l_5,  y, z + 4* p_5 ) ,new Point3D(x +3*l_5,  y, z + 4* p_5 ) ,new Point3D(x +3*l_5,  y, z + 5* p_5 ) ,new Point3D(x +2*l_5,  y, z + 5* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +3*l_5,  y, z + 4* p_5 ) ,new Point3D(x +4*l_5,  y, z + 4* p_5 ) ,new Point3D(x +4*l_5,  y, z + 5* p_5 ) ,new Point3D(x +3*l_5,  y, z + 5* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +4*l_5,  y, z + 4* p_5 ) ,new Point3D(x +5*l_5,  y, z + 4* p_5 ) ,new Point3D(x +5*l_5,  y, z + 5* p_5 ) ,new Point3D(x +4*l_5,  y, z + 5* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +5*l_5,  y, z + 4* p_5 ) ,new Point3D(x +6*l_5,  y, z + 4* p_5 ) ,new Point3D(x +6*l_5,  y, z + 5* p_5 ) ,new Point3D(x +5*l_5,  y, z + 5* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +6*l_5,  y, z + 4* p_5 ) ,new Point3D(x +7*l_5,  y, z + 4* p_5 ) ,new Point3D(x +7*l_5,  y, z + 5* p_5 ) ,new Point3D(x +6*l_5,  y, z + 5* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +7*l_5,  y, z + 4* p_5 ) ,new Point3D(x +8*l_5,  y, z + 4* p_5 ) ,new Point3D(x +8*l_5,  y, z + 5* p_5 ) ,new Point3D(x +7*l_5,  y, z + 5* p_5 ) )) ;

        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +0*l_5,  y, z + 5* p_5 ) ,new Point3D(x +1*l_5,  y, z +5* p_5 ) ,new Point3D(x +1*l_5,  y, z + 6* p_5 ) ,new Point3D(x +0*l_5,  y, z + 6* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +1*l_5,  y, z + 5* p_5 ) ,new Point3D(x +2*l_5,  y, z + 5* p_5 ) ,new Point3D(x +2*l_5,  y, z + 6* p_5 ) ,new Point3D(x +1*l_5,  y, z + 6* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +2*l_5,  y, z + 5* p_5 ) ,new Point3D(x +3*l_5,  y, z + 5* p_5 ) ,new Point3D(x +3*l_5,  y, z + 6* p_5 ) ,new Point3D(x +2*l_5,  y, z + 6* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +3*l_5,  y, z + 5* p_5 ) ,new Point3D(x +4*l_5,  y, z + 5* p_5 ) ,new Point3D(x +4*l_5,  y, z + 6* p_5 ) ,new Point3D(x +3*l_5,  y, z + 6* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +4*l_5,  y, z + 5* p_5 ) ,new Point3D(x +5*l_5,  y, z + 5* p_5 ) ,new Point3D(x +5*l_5,  y, z + 6* p_5 ) ,new Point3D(x +4*l_5,  y, z + 6* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +5*l_5,  y, z + 5* p_5 ) ,new Point3D(x +6*l_5,  y, z + 5* p_5 ) ,new Point3D(x +6*l_5,  y, z + 6* p_5 ) ,new Point3D(x +5*l_5,  y, z + 6* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +6*l_5,  y, z + 5* p_5 ) ,new Point3D(x +7*l_5,  y, z + 5* p_5 ) ,new Point3D(x +7*l_5,  y, z + 6* p_5 ) ,new Point3D(x +6*l_5,  y, z + 6* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +7*l_5,  y, z + 5* p_5 ) ,new Point3D(x +8*l_5,  y, z + 5* p_5 ) ,new Point3D(x +8*l_5,  y, z + 6* p_5 ) ,new Point3D(x +7*l_5,  y, z + 6* p_5 ) )) ;

        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +0*l_5,  y, z + 6* p_5 ) ,new Point3D(x +1*l_5,  y, z +6* p_5 ) ,new Point3D(x +1*l_5,  y, z + 7* p_5 ) ,new Point3D(x +0*l_5,  y, z + 7* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +1*l_5,  y, z + 6* p_5 ) ,new Point3D(x +2*l_5,  y, z + 6* p_5 ) ,new Point3D(x +2*l_5,  y, z + 7* p_5 ) ,new Point3D(x +1*l_5,  y, z + 7* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +2*l_5,  y, z + 6* p_5 ) ,new Point3D(x +3*l_5,  y, z + 6* p_5 ) ,new Point3D(x +3*l_5,  y, z + 7* p_5 ) ,new Point3D(x +2*l_5,  y, z + 7* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +3*l_5,  y, z + 6* p_5 ) ,new Point3D(x +4*l_5,  y, z + 6* p_5 ) ,new Point3D(x +4*l_5,  y, z + 7* p_5 ) ,new Point3D(x +3*l_5,  y, z + 7* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +4*l_5,  y, z + 6* p_5 ) ,new Point3D(x +5*l_5,  y, z + 6* p_5 ) ,new Point3D(x +5*l_5,  y, z + 7* p_5 ) ,new Point3D(x +4*l_5,  y, z + 7* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +5*l_5,  y, z + 6* p_5 ) ,new Point3D(x +6*l_5,  y, z + 6* p_5 ) ,new Point3D(x +6*l_5,  y, z + 7* p_5 ) ,new Point3D(x +5*l_5,  y, z + 7* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +6*l_5,  y, z + 6* p_5 ) ,new Point3D(x +7*l_5,  y, z + 6* p_5 ) ,new Point3D(x +7*l_5,  y, z + 7* p_5 ) ,new Point3D(x +6*l_5,  y, z + 7* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +7*l_5,  y, z + 6* p_5 ) ,new Point3D(x +8*l_5,  y, z + 6* p_5 ) ,new Point3D(x +8*l_5,  y, z + 7* p_5 ) ,new Point3D(x +7*l_5,  y, z + 7* p_5 ) )) ;

        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +0*l_5,  y, z + 7* p_5 ) ,new Point3D(x +1*l_5,  y, z + 7* p_5 ) ,new Point3D(x +1*l_5,  y, z + 8* p_5 ) ,new Point3D(x +0*l_5,  y, z + 8* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +1*l_5,  y, z + 7* p_5 ) ,new Point3D(x +2*l_5,  y, z + 7* p_5 ) ,new Point3D(x +2*l_5,  y, z + 8* p_5 ) ,new Point3D(x +1*l_5,  y, z + 8* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +2*l_5,  y, z + 7* p_5 ) ,new Point3D(x +3*l_5,  y, z + 7* p_5 ) ,new Point3D(x +3*l_5,  y, z + 8* p_5 ) ,new Point3D(x +2*l_5,  y, z + 8* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +3*l_5,  y, z + 7* p_5 ) ,new Point3D(x +4*l_5,  y, z + 7* p_5 ) ,new Point3D(x +4*l_5,  y, z + 8* p_5 ) ,new Point3D(x +3*l_5,  y, z + 8* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +4*l_5,  y, z + 7* p_5 ) ,new Point3D(x +5*l_5,  y, z + 7* p_5 ) ,new Point3D(x +5*l_5,  y, z + 8* p_5 ) ,new Point3D(x +4*l_5,  y, z + 8* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +5*l_5,  y, z + 7* p_5 ) ,new Point3D(x +6*l_5,  y, z + 7* p_5 ) ,new Point3D(x +6*l_5,  y, z + 8* p_5 ) ,new Point3D(x +5*l_5,  y, z + 8* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.WHITE),material,new Point3D(x +6*l_5,  y, z + 7* p_5 ) ,new Point3D(x +7*l_5,  y, z + 7* p_5 ) ,new Point3D(x +7*l_5,  y, z + 8* p_5 ) ,new Point3D(x +6*l_5,  y, z + 8* p_5 ) )) ;
        list.add( new Polygon(new Color(java.awt.Color.BLACK),material,new Point3D(x +7*l_5,  y, z + 7* p_5 ) ,new Point3D(x +8*l_5,  y, z + 7* p_5 ) ,new Point3D(x +8*l_5,  y, z + 8* p_5 ) ,new Point3D(x +7*l_5,  y, z + 8* p_5 ) )) ;
    }

    public List<Intersectable.GeoPoint> findIntersections(Ray ray, double MAXDISTANCE) {

        List<Intersectable.GeoPoint> intersections = new LinkedList<Intersectable.GeoPoint>();

        for (Polygon x :list
        ) {
            List<GeoPoint> _geopoints = x.findIntersections(ray, MAXDISTANCE);
            if(_geopoints != null )intersections.add(_geopoints.get(0)); }


        return intersections;
    }
}