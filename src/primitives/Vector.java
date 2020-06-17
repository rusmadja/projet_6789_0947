
package primitives;

import static java.lang.StrictMath.abs;

/**
 * Vector is the representing in a 3D plane
 * create from a 3D point
 *
 * @author Reouven and Raphael
 */
public class Vector {
    Point3D _head;

    /**
     * @param p
     */
    public Vector(Point3D p) {
        if (p.equals(Point3D.ZERO)) {
            throw new IllegalArgumentException("Point3D(0,0,0) not valid for vector head");
        }
        this._head = new Point3D(p._x._coord, p._y._coord, p._z._coord);
    }

    /**
     * @param v
     */
    public Vector(Vector v) {
        this(v._head);
    }

    public Vector(Point3D p1, Point3D p2) {
        this(p1.subtract(p2));
    }

    /**
     * Constructor with 3  values
     *
     * @param x value on X axe
     * @param y value on Y axe
     * @param z value on Z axe
     *
     */
    public Vector(double x,double y, double z) {
        this(new Point3D(x,y,z));
    }

    /**
     * getter for the head point
     *
     * @return header point of the vector
     */
    public Point3D get_head() {
        return new Point3D(_head._x._coord, _head._y._coord, _head._z._coord);
    }

    /**
     * add 2 vectors, mine and another
     *
     * @param vector vector
     * @return new vector:
     */
    public Vector add(Vector vector) {
        return new Vector( this._head.add(vector));
    }

    /**
     * sub 2 vectors, mine and another
     *
     * @param vector vector
     * @return new vector:
     */
    public Vector subtract(Vector vector) {
        return this._head.subtract(vector._head);
    }

    /**
     * scale my vector with the value
     *
     * @param factorScale the value of scal
     * @return new vector:
     */
    public Vector scale(double factorScale) {
        return new Vector(
                new Point3D(
                        new Coordinate(factorScale * _head._x._coord),
                        new Coordinate(factorScale * _head._y._coord),
                        new Coordinate(factorScale * _head._z._coord)));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return _head.equals(vector._head);
    }

    /**
     * dot product of my vector and the param
     *
     * @param v
     * @return
     * U . V
     */
    public double dotProduct(Vector v) {
        return (this._head._x._coord * v._head._x._coord +
                this._head._y._coord * v._head._y._coord +
                this._head._z._coord * v._head._z._coord);
    }

    /**
     * cross product of my vector and the param
     * @param v
     * @return
     * U x V
     */
    public Vector crossProduct(Vector v) {
        double w1 = this._head._y._coord * v._head._z._coord - this._head._z._coord * v._head._y._coord;
        double w2 = this._head._z._coord * v._head._x._coord - this._head._x._coord * v._head._z._coord;
        double w3 = this._head._x._coord * v._head._y._coord - this._head._y._coord * v._head._x._coord;

        return new Vector(new Point3D(w1, w2, w3));
    }

    /**
     * @return lenght² of our vector
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
     * @return lenght of our vector
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
     * normalizing the vector I keep the same direction
     *
     * @return the vector normalized
     */
    public Vector normalized() {
        Vector vector = new Vector(this);
        vector.normalize();
        return vector;
    }

    /**
     * create an orthogonal vector => dotProduct of orthogonal
     * vectors == 0
     *
     * @return an orthogonal vector
     */
    public Vector CreateOrtogonal() {
        double x = _head.get_x()._coord;
        double y = _head.get_y()._coord;
        double z = _head.get_z()._coord;

        double absX=abs(_head.get_x()._coord);
        double absY=abs(_head.get_y()._coord);
        double absZ=abs(_head.get_z()._coord);

        return (absX <= absY && absX<= absZ)?
                new Vector(0, -z, y).normalize():
                ((absY<= absX&& absY<= absZ)?
                        new Vector(-z, 0, x).normalize():
                        new Vector(-y, x, 0).normalize()
                );
    }

    @Override
    public String toString() {
        return "Vector{" +
                "_head=" + _head +
                '}';
    }
}
