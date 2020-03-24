package geometries;

/**
 * @author raph et reouven
 * RadialGeometry is ana abstract class that defines
 * all radial geometries.
 */
abstract class RadialGeometry implements Geometry {
   double _radius;

    public RadialGeometry(double _radius) {
        this._radius = _radius;
    }
    public RadialGeometry(RadialGeometry other) {
        this._radius = other._radius;
    }
    public double get_radius() {
        return _radius;
    }
}
