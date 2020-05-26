package primitives;

import java.util.Objects;

/**
 * Class Point3D is the basic class representing a point in a
 * 3D system.
 *
 * @author reouv&raph
 */
public class Point3D {
    Coordinate _x;
    Coordinate _y;
    Coordinate _z;

    /**
     * @param _x coordinate on the X axis
     * @param _y coordinate on the Y axis
     * @param _z coordinate on the Z axis
     */
    public final static Point3D ZERO = new Point3D(0.0, 0.0, 0.0);

    public Point3D(Coordinate _x, Coordinate _y, Coordinate _z) {
        this._x = _x;
        this._y = _y;
        this._z = _z;
    }

    public Point3D(Point3D p) {
        this._x = new Coordinate(p._x);
        this._y = new Coordinate(p._y);
        this._z = new Coordinate(p._z);
    }


    public Point3D(double _x, double _y, double _z) {
        this(new Coordinate(_x), new Coordinate(_y), new Coordinate(_z));
    }

    /**
     * Getters
     */
    public Coordinate get_x() {
        return new Coordinate(_x);
    }

    public Coordinate get_y() {
        return new Coordinate(_y);
    }

    public Coordinate get_z() {
        return new Coordinate(_z);
    }

    /**
     * @param p
     * @return a new vector which is the subtraction of our verctor's head and a Point 3D
     */
    public Vector subtract(Point3D p) {
        return new Vector(new Point3D(
                this._x._coord - p._x._coord,
                this._y._coord - p._y._coord,
                this._z._coord - p._z._coord));
    }

    /**
     * @param other
     * @return distance between two Point 3D without the sqrt() :
     * (Bx-Ax)² + (By-Ay)² + (Bz-Az)²
     */
    public double distanceSquared(Point3D other)
    {
        return ( (other._x._coord - this._x._coord) * (other._x._coord - this._x._coord) +
                (other._y._coord - this._y._coord) * (other._y._coord - this._y._coord) +
                (other._z._coord - this._z._coord) * (other._z._coord - this._z._coord));
    }

    /**
     * @param other
     * @return distance between two Point 3D with the sqrt():
     *  sqrt( (Bx-Ax)² + (By-Ay)² + (Bz-Az)² )
     */
    public double distance (Point3D other){
        return Math.sqrt(distanceSquared(other));
    }

    /**
     * @param v
     * @return a new Point 3D which is the new vector's head after the addition of a Vector with our Point 3D
     * ( Px + Vx )
     * ( Py + Vy )
     * ( Pz + Vz )
     */
    public Point3D add(Vector v) {
        return new Point3D(this._x._coord + v._head._x._coord,
                this._y._coord + v._head._y._coord,
                this._z._coord + v._head._z._coord);
    }

    /**
     * @return true or false if the 2 Points 3D are equals
     * A == B ?
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3D point3D = (Point3D) o;
        return _x.equals(point3D._x) &&
                _y.equals(point3D._y) &&
                _z.equals(point3D._z);
    }

    /**
     * Print the props of the Point3D
     */
    @Override
    public String toString() {
        return "Point3D{" +
                "_x=" + _x +
                ", _y=" + _y +
                ", _z=" + _z +
                '}';
    }

}
