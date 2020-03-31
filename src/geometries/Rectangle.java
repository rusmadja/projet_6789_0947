package geometries;

import primitives.Point3D;

public class Rectangle extends Polygon {
    public Rectangle(Point3D p1, Point3D p2, Point3D p3,Point3D p4) {
        super(new Point3D[]{p1, p2, p3,p4});
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Rectangle)) return false;
        Rectangle tr = (Rectangle) obj;

        return _vertices.get(0).equals(tr._vertices.get(0)) &&
                _vertices.get(1).equals(tr._vertices.get(1)) &&
                _vertices.get(2).equals(tr._vertices.get(2)) &&
                _vertices.get(3).equals(tr._vertices.get(3));
    }

    @Override
    public primitives.Vector getNormal(Point3D point) {
        return super.getNormal(point);
    }

    @Override
    public String toString() {
        String result = "";
        for (Point3D p : _vertices ) {
            result += p.toString();
        }
        return  result;
    }

}
