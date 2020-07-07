package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Geometries implements Intersectable {

    private Point3D max;
    private Point3D min;
    private List<Intersectable> _geometries = new LinkedList<>();

    public Geometries(Intersectable... _geometries) {
        add(_geometries);
        double xmax = Double.MIN_VALUE;
        double ymax = Double.MIN_VALUE;
        double zmax = Double.MIN_VALUE;
        double xmin = Double.MAX_VALUE;
        double ymin = Double.MAX_VALUE;
        double zmin = Double.MAX_VALUE;
        for (Intersectable geo:
             _geometries) {
            Point3D pointmax = geo.getMax();
            Point3D pointmin = geo.getMin();
            if (xmax < pointmax.get_x().get())
                xmax = pointmax.get_x().get();
            if (ymax < pointmax.get_y().get())
                ymax = pointmax.get_y().get();
            if (zmax < pointmax.get_z().get())
                zmax = pointmax.get_z().get();
            if (xmin < pointmin.get_x().get())
                xmin = pointmin.get_x().get();
            if (ymin < pointmin.get_y().get())
                ymin = pointmin.get_y().get();
            if (zmin < pointmin.get_z().get())
                zmin = pointmin.get_z().get();
        }
        max = new Point3D(xmax,ymax,zmax);
       min = new Point3D(xmin,ymin,zmin);
    }

    /**
     * TODO
     * @param geometries
     */
    public void add(Intersectable... geometries)
    {
        _geometries.addAll(Arrays.asList(geometries));
    }

    /**
     * TODO
     * @param ray the ray that intersect the geometries
     * @return list of Point3D that intersect the osef
     */
    @Override
    public List<GeoPoint> findIntersections(Ray ray,double MAXDISTANCE) {
        List<GeoPoint> intersections = null;

        for (Intersectable geo : _geometries) {
            List<GeoPoint> tempIntersections = geo.findIntersections(ray , MAXDISTANCE);
            if (tempIntersections != null) {
                if (intersections == null)
                    intersections = new ArrayList<>();
                intersections.addAll(tempIntersections);
            }
        }
        return intersections;

    }
    public void remove(Intersectable... intersectables) {
        for (Intersectable geo : _geometries) {
            _geometries.remove(geo);
        }
    }
    public Point3D getMax()
    {
        return max;
    }

    @Override
    public Point3D getMin() {
        return min;
    }

    public List<Intersectable> getGeometries() {
        return _geometries;
    }


}