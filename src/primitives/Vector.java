
package primitives;

/**
 * Vector is the
 * space representation of 2 Point 3D we can do some operations with it
 * we can calculate the length of it or calculate the normal vector of two of them
 * Vector is essential in the geometric representation.
 * @author Reouven and Raphael
 */
public class Vector {
    Point3D _head;

    /** Vector constructor
     * @param p
     */
    public Vector(Point3D p) {
        if (p.equals(Point3D.ZERO)) {
            throw new IllegalArgumentException("Point3D(0,0,0) not valid for vector head");
        }
        this._head = new Point3D(p._x._coord, p._y._coord, p._z._coord);
    }

    /** Vector constructor
     * @param v
     */
    public Vector(Vector v) {
        this(v._head);
    }
    /** Vector constructor
     * @param p1
     * @param p2
     */
    public Vector(Point3D p1, Point3D p2) {
        this(p1.subtract(p2));
    }
    /** Vector constructor
     * @param x
     * @param y
     * @param z
     */
    public Vector(double x,double y, double z) {
        this(new Point3D(x,y,z));
    }

    /**
     * @return a Point 3D : the vector's head
     */
    public Point3D get_head() {
        return new Point3D(_head._x._coord, _head._y._coord, _head._z._coord);
    }

    /**
     * @param vector
     * @return a Vector which is the addition of 2 others
     * A+B
     */
    public Vector add(Vector vector) {
        return new Vector( this._head.add(vector));
    }

    /**
     * @param vector
     * @return a Vector which is the subtraction of 2 others
     * A-B
     */
    public Vector subtract(Vector vector) {
        return this._head.subtract(vector._head);
    }

    /**
     * @param factorScale
     * @return a Vector which is the scale product of a number
     * A x number
     */
    public Vector scale(double factorScale) {
        return new Vector(
                new Point3D(
                        new Coordinate(factorScale * _head._x._coord),
                        new Coordinate(factorScale * _head._y._coord),
                        new Coordinate(factorScale * _head._z._coord)));
    }

    /**
     * @param o
     * @return true or false if the 2 vectors are equals
     * A == B ?
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return _head.equals(vector._head);
    }

    /**
     * @param v
     * @return a number which is the result of this: Ax*Bx + Ay*By + Az*Bz
     * U . V
     * Ax*Bx + Ay*By + Az*Bz
     */
    public double dotProduct(Vector v) {
        return (this._head._x._coord * v._head._x._coord +
                this._head._y._coord * v._head._y._coord +
                this._head._z._coord * v._head._z._coord);
    }

    /**
     * @param v
     * @return a NEW Vector which is the result of the product of two vectors
     * U x V
     * (Ay*Bz - Az*By)
     * (Az*Bx - Ax*Bz)
     * (Ax*By - Ay*Bx)
     */
    public Vector crossProduct(Vector v) {
        double w1 = this._head._y._coord * v._head._z._coord - this._head._z._coord * v._head._y._coord;
        double w2 = this._head._z._coord * v._head._x._coord - this._head._x._coord * v._head._z._coord;
        double w3 = this._head._x._coord * v._head._y._coord - this._head._y._coord * v._head._x._coord;

        return new Vector(new Point3D(w1, w2, w3));
    }

    /**
     * @return length² of our vector
     * with
     * operation x² + y² + z²
     */
    public double lengthSquared() {
        double xx = this._head._x._coord * this._head._x._coord;
        double yy = this._head._y._coord * this._head._y._coord;
        double zz = this._head._z._coord * this._head._z._coord;

        return xx + yy + zz;

    }

    /**
     * @return length of our vector
     * with
     * operation sqrt(x² + y² + z²)
     */
    public double length() {
        return Math.sqrt(lengthSquared());
    }

    /**
     * @return the same Vector after normalisation
     * @throws ArithmeticException if length = 0
     */
    public Vector normalize() {

        double x = this._head._x._coord;
        double y = this._head._y._coord;
        double z = this._head._z._coord;

        double length = this.length();

        if (length == 0)
            throw new ArithmeticException("divide by Zero");

        this._head._x = new Coordinate(x / length);
        this._head._y = new Coordinate(y / length);
        this._head._z = new Coordinate(z / length);

        return this;
    }
    /**
     * @return a new vector the same one of our Vector but it was normalized to keep our vector free
     */
    public Vector normalized() {
        Vector vector = new Vector(this);
        vector.normalize();
        return vector;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "_head=" + _head +
                '}';
    }
}
