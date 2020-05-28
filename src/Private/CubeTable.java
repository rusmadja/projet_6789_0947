package Private;

import elements.Material;
import geometries.Geometries;
import geometries.Intersectable;
import primitives.Color;
import primitives.Point3D;
import primitives.Ray;

import java.util.LinkedList;
import java.util.List;

public class CubeTable extends Geometries {

    Cube up_table;
    Cube front_left_foot_table;
    Cube front_right_foot_table;
    Cube rear_left_foot_table;
    Cube rear_right_foot_table;

    /**
     *
     * @param emissionLight
     * @param material
     * @param position
     * @param longueur
     * @param hauteur
     * @param largeur
     * @param epaisseur_table
     * @param epaisseur_pied
     */
    public CubeTable(Color emissionLight, Material material, Point3D position, int longueur, int hauteur, int largeur,int epaisseur_table,int epaisseur_pied) {
        double x = position.get_x().get();
        double y = position.get_y().get();
        double z = position.get_z().get();

        up_table = new Cube (
                emissionLight,
                material,
                new Point3D(x,y,z),
                longueur,epaisseur_table,largeur
        );
        front_left_foot_table = new Cube(emissionLight,
                                         material,
                                         new Point3D(x , y, z  ),
                                         epaisseur_pied, hauteur, epaisseur_pied);
        front_right_foot_table = new Cube(
                emissionLight,
                material,
                new Point3D(x , y, z + largeur - epaisseur_pied),
                epaisseur_pied, hauteur, epaisseur_pied
        );
        rear_left_foot_table = new Cube(
                emissionLight, material,
                new Point3D(x + longueur - epaisseur_pied , y, z ),
                epaisseur_pied, hauteur, epaisseur_pied
        );
        rear_right_foot_table = new Cube(
                emissionLight, material,
                new Point3D(x+ longueur - epaisseur_pied, y, z + largeur - epaisseur_pied),
                epaisseur_pied, hauteur, epaisseur_pied
        );

    }

    /**
     *
     * @param ray the ray that intersect the geometries
     * @param MAXDISTANCE
     * @return
     */
    public List<Intersectable.GeoPoint> findIntersections(Ray ray, double MAXDISTANCE) {

        List<Intersectable.GeoPoint> intersections = new LinkedList<Intersectable.GeoPoint>();
List<GeoPoint> _geopoints = up_table.findIntersections(ray, MAXDISTANCE);
        for (GeoPoint p:_geopoints ) { intersections.add(p); }

        _geopoints =front_left_foot_table.findIntersections(ray, MAXDISTANCE);
        for (GeoPoint p:_geopoints ) { intersections.add(p); }

        _geopoints =front_right_foot_table.findIntersections(ray, MAXDISTANCE);
        for (GeoPoint p:_geopoints ) { intersections.add(p); }

        _geopoints =rear_left_foot_table.findIntersections(ray, MAXDISTANCE);
        for (GeoPoint p:_geopoints ) { intersections.add(p); }

        _geopoints =rear_right_foot_table.findIntersections(ray, MAXDISTANCE);
        for (GeoPoint p:_geopoints ) { intersections.add(p); }

        return intersections;
    }
}
