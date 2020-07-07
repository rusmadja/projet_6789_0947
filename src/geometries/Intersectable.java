package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.List;

/**
 * Intersectable is a common interface for all geometries that are able
 * to intersect from a ray to their entity (Shape)
 */
public interface Intersectable {

   /**
    * @param ray ray pointing toward a Gepmtry
    * @return List<GeoPoint> return values
    */
   default List<GeoPoint> findIntersections(Ray ray){
      return findIntersections(ray, Double.POSITIVE_INFINITY);
   }

   List<GeoPoint> findIntersections(Ray ray,double MAXDISTANCE);
   Point3D getMax();
   Point3D getMin();
   public static class GeoPoint {

      Geometry _geometry;
      Point3D point;

      public GeoPoint(Geometry _geometry, Point3D pt) {
         this._geometry= _geometry;
         point =pt;
      }

      public Point3D getPoint() {
         return  new Point3D(point);
      }
      public Geometry getGeometry() {
         return  _geometry;
      }
   }

}