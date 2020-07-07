package geometries;

import elements.Material;
import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

/**
 * interface Geometry is the basic interface for all geometric objects
 * who are implementing getNormal method.
 *
 * @author
 */
public abstract class Geometry implements Intersectable {

    protected Color _emission;
    protected Material _material;
    protected Point3D max;
    protected Point3D min;

    public Geometry(Color _emission, Material _material) {
        this(_emission,_material,new Point3D(Double.MAX_VALUE,Double.MAX_VALUE,Double.MAX_VALUE),
                new Point3D(Double.MIN_VALUE,Double.MIN_VALUE,Double.MIN_VALUE));
    }
    public Geometry(Color _emission, Material _material,Point3D max , Point3D min) {
        this._emission = _emission;
        this._material = _material;
        this.max = new Point3D(max);
        this.min = new Point3D(min);
    }
    public Geometry(Color _emission) {
        this(_emission, new Material(0d, 0d, 0));
    }


    public Color getEmissionLight() {
        return (_emission);
    }

    public Material getMaterial() {
        return _material;
    }

    public Point3D getMax() {
        return max;
    }

    public Point3D getMin() {
        return max;
    }
    abstract public Vector getNormal(Point3D p);
}