package primitives;

import static primitives.Util.isZero;

/**
 * Ray class
 */
public class Ray {

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
        _point = new Point3D(point);
        _direction = new Vector(direction).normalized();
    }
    public Point3D getTargetPoint(double length) {
        return isZero(length ) ? _point : new Point3D(_point).add(_direction.scale(length));
    }


    /**
     * Copy constructor for a deep copy of an Ray object.
     * @param other the object that being copied
     */
    public Ray(Ray other) {
        this._point = new Point3D(other._point);
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
}