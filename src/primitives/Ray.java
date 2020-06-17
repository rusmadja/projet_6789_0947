package primitives;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

/**
 * Class Ray: representing a ray in a 3D plane
 * with Point 3D and directional vector
 * @author reouven & raphael
 */
public class Ray {
    private static final double DELTA = 0.1;
    private static final Random rnd = new Random();
    /**
     * The point from which the ray starts.
     */
    private final Point3D _point;
    /**
     * The direction of the ray.
     */
    private final Vector _direction;

    /**
     * the Ray Constructor
     *
     * @param point the start of the ray.
     * @param direction the direction of the ray.
     */
    public Ray(Point3D point, Vector direction) {
        _point = new Point3D(point.get_x(), point.get_y(), point.get_z());
        _direction = new Vector(direction).normalized();
    }

    /**
     * the Ray Constructor
     *
     * @param point the start of the ray.
     * @param direction the direction of the ray.
     * @param n the vector for the dot product
     * @return this.ray = head+ normal.scale(±DELTA)
     */
    public Ray(Point3D point, Vector direction, Vector n) {

        _direction = new Vector(direction).normalized();

        double nv = n.dotProduct(direction);

        Vector normalDelta = n.scale((nv > 0 ? DELTA : -DELTA));
        _point = point.add(normalDelta);

    }


    public Point3D getTargetPoint(double length) {
        return isZero(length) ? _point : new Point3D(_point).add(_direction.scale(length));
    }


    /**
     * the Copy constructor
     *
     * @param other the ray that we will copy
     */
    public Ray(Ray other) {
        this._point = new Point3D(other._point.get_x(), other._point.get_y(), other._point.get_z());
        this._direction = other._direction.normalized();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Ray))
            return false;
        if (this == obj)
            return true;
        Ray other = (Ray) obj;
        return (_point.equals(other._point) &&
                _direction.equals(other._direction));
    }

    @Override
    public String toString() {
        return "Ray{" +
                "_point=" + _point +
                ", _direction=" + _direction +
                '}';
    }

    /**
     * Getter
     *
     * @return A new Point3D that represents the ray's starts.
     */
    public Point3D getPoint() {
        return new Point3D(_point);
    }

    /**
     * @param distance the scale of scaleProduct operation
     * @Means this fonction return the point who located at the distance t
     * @return P= P0 + t∙v
     */
    public Point3D getPointAtDistance(double distance) {
        return isZero(distance) ? _point : new Point3D(_point).add(_direction.scale(distance));
    }


    /**
     * Getter for the direction of the ray that is
     * represented by this object.
     *
     * @return A new Vector that represents the
     *         direction of the ray that is
     *         represented by this object.
     */
    public Vector getDirection() {
        return new Vector(_direction);
    }


    /**
     *@param point         start point
     * @param vector       vector for the direction
     * @param normal       vector normal
     * @param distance     between the start point and the center
     * @param radius       of the target area
     * @Means Create ray beam from start point
     *
     * @return  a list of rays
     */
    public static List<Ray> ConstructRayBeam(Point3D point, Vector vector, Vector normal, double side, double distance, double radius,
                                             int count) {

        point = point.add(normal.scale(side >= 0 ? DELTA : -DELTA));
        Ray ray = new Ray(point, vector);
        if (count <= 1)
            return List.of(ray);
        List<Ray> rays = new LinkedList<>();
        rays.add(ray);
        Point3D pc = ray.getPointAtDistance(distance);

        Vector vX = vector.CreateOrtogonal();
        Vector vY = vector.crossProduct(vX);

        double radius2 = radius * 2;
        for (int i = count - 1; i > 0; --i) {
            double x = rnd.nextDouble() * 2 - 1;
            double y = Math.sqrt(1 - x * x);
            Point3D tP = pc;
            double mult = rnd.nextDouble() * radius2 - radius;
            x *= mult;
            y *= mult;
            if (!isZero(x))
                tP = tP.add(vX.scale(x));
            if (!isZero(y))
                tP = tP.add(vY.scale(y));
            Vector tV = tP.subtract(point);
            if (side * alignZero(normal.dotProduct(tV)) > 0)
                rays.add(new Ray(point, tV));
        }
        return rays;

    }
}
