package geometries;

import primitives.Point3D;
import primitives.Vector;
/**
 * interface Geometry is the basic interface for all geometric objects
 * who are implementing getNormal method.
 *
 * @author raph et reouven
 */

public interface Geometry extends Intersectable{
    Vector getNormal(Point3D _point3D);
}
