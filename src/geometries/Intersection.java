package geometries;
import primitives.*;
import java.util.List;

public interface Intersection {
    List<Point3D> findIntersections(Ray ray);
}