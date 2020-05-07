package geometries;

import primitives.Color;

import static primitives.Util.isZero;

/**
 * @author Reouven and raphael
 * RadialGeometry is ana abstract class that defines
 * all radial geometries.
 */
public abstract class RadialGeometry extends Geometry{
    double  _radius;

    /**
     *
     * @param _radius
     */
    public RadialGeometry(Color emissionLight, double _radius) {
        super(emissionLight);
        if (isZero(_radius) || (_radius < 0.0))
            throw new IllegalArgumentException("radius "+ _radius +" is not valid");
        this._radius = _radius;
    }

    public RadialGeometry(RadialGeometry other){
        super(Color.BLACK);
        this._radius= other._radius;
    }
    public double get_radius() {
        return _radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RadialGeometry that = (RadialGeometry) o;

        return isZero(this._radius -that._radius);
    }
}