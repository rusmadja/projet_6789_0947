package geometries;
import primitives.*;
import java.util.*;
public class Geometries implements Intersectable {

    private List<Intersectable> _geometries = new ArrayList<Intersectable>();

    public Geometries(Intersectable... _geometries) {
        add( _geometries);
    }

    public void add(Intersectable... geometries) {
        for (Intersectable geo : geometries ) {
            _geometries.add(geo);
        }
    }

    /**
     *
     * @param ray
     * @return list of Point3D that intersect the osef
     */
    @Override
    public List<Point3D> findIntersections(Ray ray) {
        List<Point3D> intersections = new ArrayList<Point3D>();

        for (Intersectable geo : _geometries) {
                intersections.addAll(geo.findIntersections(ray));
        }
        return intersections;

    }

}