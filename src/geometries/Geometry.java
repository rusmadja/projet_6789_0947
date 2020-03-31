package geometries;

import primitives.Point3D;
import primitives.Vector;
/**
 * interface Geometry is the basic interface for all geometric objects
 * who are implementing getNormal method.
 *
 * @author raph et ouriel
 */

public interface Geometry extends Intersection{
    Vector getNormal(Point3D _point3D);
}
