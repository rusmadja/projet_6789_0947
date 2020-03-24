
package primitives;

/**
 * Vector is the
 *
 *
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
            throw new IllegalArgumentException("ZERO point not valid for vector");
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

    public Vector(double x,double y, double z) {
        this(new Point3D(x,y,z));
    }

    /**
     * @return
     */
    public Point3D get_head() {
        return new Point3D(_head._x._coord, _head._y._coord, _head._z._coord);
    }

    /**
     * @param vector
     */
    public void add(Vector vector) {
        this._head.add(vector);
    }

    /**
     * @param vector
     */
    public void subtract(Vector vector) {
        this._head.subtract(vector._head);
    }

    /**
     * @param scalingFacor
     */
    public Vector scale(double scalingFacor) {
        return new Vector(
                new Point3D(
                        new Coordinate(scalingFacor * _head._x._coord),
                        new Coordinate(scalingFacor * _head._y._coord),
                        new Coordinate(scalingFacor * _head._z._coord)));
    }

    /**
     * @param o
     * @return
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
     * @return
     */
    public double dotProduct(Vector v) {
        return (this._head._x._coord * v._head._x._coord +
                this._head._y._coord * v._head._y._coord +
                this._head._z._coord * v._head._z._coord);
    }

    /**
     * @param v
     * @return
     */
    public Vector crossProduct(Vector v) {
        double w1 = this._head._y._coord * v._head._z._coord - this._head._z._coord * v._head._y._coord;
        double w2 = this._head._z._coord * v._head._x._coord - this._head._x._coord * v._head._z._coord;
        double w3 = this._head._x._coord * v._head._y._coord - this._head._y._coord * v._head._x._coord;

        return new Vector(new Point3D(w1, w2, w3));
    }

    /**
     * @return
     */
    public double lengthSquared() {
        double xx = this._head._x._coord * this._head._x._coord;
        double yy = this._head._y._coord * this._head._y._coord;
        double zz = this._head._z._coord * this._head._z._coord;

        return xx + yy + zz;

    }

    /**
     * @return
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

    public Vector normalized() {
        Vector vector = new Vector(this);
        vector.normalize();
        return vector;
    }
}
/*package primitives;
import java.lang.Math;

public class Vector {
    Point3D head;

    public Vector subtract(Vector other)
    {
        return new Vector(
                other.head.x._coord-this.head.x._coord,
                other.head.y._coord-this.head.y._coord,
                other.head.z._coord-this.head.z._coord);
    }
    public Vector add(Vector other)
    {
        return new Vector(this.head.x._coord + other.head.x._coord,
                this.head.y._coord + other.head.y._coord,
                this.head.z._coord + other.head.z._coord);
    }
    public Vector scale(int a)
    {
        return new Vector(this.head.x._coord*a,
                this.head.y._coord*a,
                this.head.z._coord*a);
    }

    public double dotProduct(Vector other){
        return (this.head.x._coord * other.head.x._coord +
         this.head.y._coord * other.head.y._coord +
         this.head.z._coord * other.head.z._coord );
    }

    public Vector crossProduct(Vector other){
        return new Vector( this.head.y._coord * other.head.z._coord - this.head.z._coord * other.head.y._coord ,
                            this.head.z._coord * other.head.x._coord - this.head.x._coord * other.head.z._coord ,
                            this.head.x._coord * other.head.y._coord - this.head.y._coord * other.head.x._coord );
    }
    public double lengthSquared(){
        return
                ((this.head.x._coord)*(this.head.x._coord)+
                (this.head.y._coord)*(this.head.y._coord)+
                (this.head.z._coord)*(this.head.z._coord));
    }
    public double length(){
        return  Math.sqrt(lengthSquared());
    }
    public Vector  normalize(){
        //TODO
        return this;
    }
    public Vector  normalized(){
        //TODO
        return this;
    }

    public Vector(Point3D OTHER)
            throws IllegalArgumentException{
        this(OTHER.getX(),OTHER.getY(),OTHER.getZ());
    }
    public Vector(Coordinate x,Coordinate y, Coordinate z)
            throws IllegalArgumentException{
        this.head = new Point3D(x,y,z);
    }
    public Vector(double x,double y, double z)
            throws IllegalArgumentException {
        this.head = new Point3D(x,y,z);
    }
    // pas de throws ici
    public Vector(Vector other) {
        if(! (other == null))
            this.head = other.head;
    }

    public Point3D gethead() {
        return head;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o==null) return false;
        if (!(o instanceof Vector)) return false;
        Vector vector = (Vector) o;
        return this.head.equals(vector.head);
    }
    @Override
    public String toString() {
        return "Vector{" +
                "head=" + head.toString() +
                '}';
    }

}*/