package primitives;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static primitives.Util.isZero;

/**
 * Ray class
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
     * Constructor for creating a new instance of this class
     * @param point the start of the ray.
     * @param direction the direction of the ray.
     */
    public Ray(Point3D point, Vector direction) {
        _point = new Point3D(point.get_x(),point.get_y(),point.get_z());
        _direction = new Vector(direction).normalized();
    }

    /**
     * TODO
     * @param point
     * @param direction
     * @param n
     * this.ray = head+ normal.scale(±DELTA)
     */
    public Ray(Point3D point, Vector direction, Vector n) {

        _direction = new Vector(direction).normalized();

        double nv = n.dotProduct(direction);

        Vector normalDelta = n.scale((nv > 0 ? DELTA : -DELTA));
        _point = point.add(normalDelta);

    }


    public Point3D getTargetPoint(double length) {
        return isZero(length ) ? _point : new Point3D(_point).add(_direction.scale(length));
    }


    /**
     * Copy constructor for a deep copy of an Ray object.
     * @param other the object that being copied
     */
    public Ray(Ray other) {
        this._point = new Point3D(other._point.get_x(),other._point.get_y(), other._point.get_z());
        this._direction = other._direction.normalized();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Ray))
            return false;
        if (this == obj)
            return true;
        Ray other = (Ray)obj;
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
     * Getter for the point from which the ray starts.
     * @return A new Point3D that represents the
     * point from which the ray starts.
     */
    public Point3D getPoint() {
        return new Point3D(_point);
    }

    /**
     * Getter for the direction of the ray that is
     * represented by this object.
     * @return A new Vector that represents the
     * direction of the ray that is
     * represented by this object.
     */
    public Vector getDirection() {
        return new Vector(_direction);
    }

    /**
     *
     * @param t = the scale of scaleProduct operation
     * @return P= P0 + t∙v
     */
    public Point3D getP(double t)
    {
        return new primitives.Point3D(this.getPoint().add(this.getDirection().scale(t)));
    }

    public List<Ray> constructRayBeam(Point3D targetPoint, double delta, int amount) {

        if (isZero(_point.distance(targetPoint))) {
            throw new IllegalArgumentException("distance cannot be 0");
        }
        Vector direction = this._direction.normalized();
        Point3D point = direction.get_head();

        Vector v = this._point.subtract(targetPoint);
        Point3D referPoint = v.get_head();

        Vector n1 = new Vector(referPoint.get_y()._coord * -1d, referPoint.get_x()._coord, 0d).normalized();
        Vector n2 = direction.crossProduct(n1).normalized();
        double x;
        double y;

        LinkedList<Ray> rays = new LinkedList<>();
        rays.add(this);

        double[] doubles = rnd.doubles(amount * 2, -1 * delta, delta)
                .distinct()
                .toArray();

        for (int i = 0; i < doubles.length; i++) {
            x = doubles[i];
            y = doubles[++i];
            Point3D Pxy = new Point3D(point);

            boolean n1_Normal_to_getnormal = n1.dotProduct(direction) == 0;
            Pxy = point.add(n1.scale(x));

            boolean n2_Normal_to_getnormal = n2.dotProduct(direction) == 0;
            Pxy = point.add(n2.scale(y));
            Vector Vxy = Pxy.subtract(point);
            rays.add(new Ray(point, Vxy));
        }
        return rays;

    }
    public static List<Ray> createRayBeam(Point3D point, Vector vector, Vector n, double dotProduct, double glossyBlurryDistance, double radius, int superSampling) {
        double x;
        double y;

        LinkedList<Ray> rays = new LinkedList<>();
        //rays.add(this);

        double[] doubles = rnd.doubles(superSampling * 2, -1 * dotProduct, dotProduct)
                .distinct()
                .toArray();
        Vector n2 = n.crossProduct(vector);
        for (int i = 0; i < doubles.length; i++) {
            x = doubles[i];
            y = doubles[++i];
            Point3D Pxy ;
            Pxy = point.add(n.scale(x)).add(n2.scale(y));
            Vector Vxy = Pxy.subtract(point);
            rays.add(new Ray(point, Vxy));
        }
        return rays;
    }
}