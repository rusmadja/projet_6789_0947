package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.ArrayList;
import java.util.List;

public class Geometries implements Intersection {

    private List<Intersection> _geometries = new ArrayList<Intersection>();

    public Geometries(Intersection... _geometries) {
        add( _geometries);
    }

    public void add(Intersection... geometries) {
        for (Intersection geo : geometries ) {
            _geometries.add(geo);
        }
    }

    /**
     * @param ray
     * @return
     */
    @Override
    public List<Point3D> findIntersections(Ray ray) {
        List<Point3D> intersections = null;

        for (Intersection geometry : _geometries) {
            List<Point3D> tempIntersections = geometry.findIntersections(ray);
            if (tempIntersections != null) {
                if (intersections == null)
                    intersections = new ArrayList<Point3D>();
                intersections.addAll(tempIntersections);
            }
        }
        return intersections;

    }
}