package elements;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static primitives.Util.isZero;

public class Camera {
    Point3D _p0;
    Vector _vTo;
    Vector _vUp;
    Vector _vRight;
    private int _superSampling = 0;
    private double _aperture = 0d;
    private double _focus = 0;
    private int _dofSampling = 0;

    public Camera(Point3D _p0, Vector _vTo, Vector _vUp) {

        //if the the vectors are not orthogonal, throw exception.
        if (_vUp.dotProduct(_vTo) != 0)
            throw new IllegalArgumentException("the vectors must be orthogonal");

        this._p0 = new Point3D(_p0);
        this._vTo = _vTo.normalized();
        this._vUp = _vUp.normalized();

        _vRight = this._vTo.crossProduct(this._vUp).normalize();

    }


    public Point3D getP0() {
        return new Point3D(_p0);
    }

    public Vector getVTo() {
        return new Vector(_vTo);
    }

    public Vector getVUp() {
        return new Vector(_vUp);
    }

    public Vector getVRight() {
        return new Vector(_vRight);
    }
    /**
     * The function constructs a beam of rays from Camera location throw the pixel
     * (i,j) in the view plane - the ray starts at the pixel if Depth of Field is
     * activated!!!
     *
     * @param nX  number of pixels in a row of view plane
     * @param nY  number of pixels in a column of view plane
     * @param j  number of the pixel in a row
     * @param i  number of the pixel in a column
     * @param screenDistance distance from the camera to the view plane
     * @param screenWidth     view plane width
     * @param screenHeight view plane height
     * @returnthe beam of rays from pixel (if DoF is active) or from camera
     */

    public List<Ray> constructRaysThroughPixel(int nX, int nY,
                                                 int j, int i, double screenDistance,
                                                 double screenWidth, double screenHeight,double precision) {
        if (isZero(screenDistance)) {
            throw new IllegalArgumentException("distance cannot be 0");
        }
        List<Ray> _final = new LinkedList<>();
        Point3D Pc = _p0.add(_vTo.scale(screenDistance));

        double Ry = screenHeight / nY;
        double Rx = screenWidth / nX;

        double yi = ((i - nY / 2d) * Ry + Ry / 2d);
        double xj = ((j - nX / 2d) * Rx + Rx / 2d);
        // we have the middle of pixel and adding it in final list:
        Point3D _middle_pixel = Pc.add(_vRight.scale(xj).subtract(_vUp.scale(yi)));
        double x = _middle_pixel.get_x().get();
        double y = _middle_pixel.get_y().get();
        double z = _middle_pixel.get_z().get();


        for (int _index_x = (int) -(precision); _index_x <= (precision); _index_x++) {
            for (int _index_y = (int) -(precision); _index_y <= (precision); _index_y++) {
                Point3D tmp = new Point3D(
                        x + _index_x * Rx / (precision + 1),
                        y + _index_y * Ry / (precision + 1),
                        z);
                _final.add(new Ray(_p0, new Vector(tmp.subtract(_p0)).normalized()));


            }
        }
        return _final;
    }
    public List<Ray> constructRaysThroughPixelWithFocal(int nX, int nY,
                                                 int j, int i, double screenDistance,
                                                 double screenWidth, double screenHeight,double precision) {
        if (isZero(screenDistance)) {
            throw new IllegalArgumentException("distance cannot be 0");
        }
        List<Ray> _final = new LinkedList<>();
        Point3D Pc = _p0.add(_vTo.scale(screenDistance));

        double Ry = screenHeight / nY;
        double Rx = screenWidth / nX;

        double yi = ((i - nY / 2d) * Ry + Ry / 2d);
        double xj = ((j - nX / 2d) * Rx + Rx / 2d);
        // we have the middle of pixel and adding it in final list:
        Point3D _middle_pixel = Pc.add(_vRight.scale(xj).subtract(_vUp.scale(yi)));

        if (_superSampling == 0)
            return constructFocalRays(_middle_pixel);

        double x = _middle_pixel.get_x().get();
        double y = _middle_pixel.get_y().get();
        double z = _middle_pixel.get_z().get();


        for (int _index_x = (int) -(precision); _index_x <= (precision); _index_x++) {
            for (int _index_y = (int) -(precision); _index_y <= (precision); _index_y++) {
                Point3D tmp = new Point3D(
                        x + _index_x * Rx / (precision + 1),
                        y + _index_y * Ry / (precision + 1),
                        z);
                _final.addAll(constructFocalRays(tmp));
            }
        }
        return _final;
    }

     private static Random rnd = new Random();

    /**
     * Create beam of rays from view plane aperture hole through focal point
     *
     * @param pnt point at View Plane
     * @return beam of rays
     */
    private List<Ray> constructFocalRays(Point3D pnt) {
        Vector v = pnt.subtract(_p0);
        if (_dofSampling == 0)
            return List.of(new Ray(_p0, v));

        v.normalize();
        Point3D f = pnt.add(v.scale(_focus / _vTo.dotProduct(v)));

        List<Ray> rays = new LinkedList<>();
        for (int i = _dofSampling; i > 0; --i) {
            double x = rnd.nextDouble() * 2 - 1;
            double y = Math.sqrt(1 - x * x);
            Point3D p = pnt;
            double mult = (rnd.nextDouble() - 0.5) * _aperture;
            if (!isZero(x))
                p.add(_vRight.scale(x * mult));
            if (!isZero(y))
                p.add(_vUp.scale(y * mult));
            rays.add(new Ray(p, f.subtract(p)));
        }
        return rays;
    }
    public List<Ray> constructRayBeamThroughPixel(int nX, int nY, int j, int i,
                                                  double screenDistance, double screenWidth, double screenHeight,
                                                  double density, int amount) {
        if (isZero(screenDistance)) {
            throw new IllegalArgumentException("distance cannot be 0");
        }

        List<Ray> rays = new LinkedList<>();

        Point3D Pc = _p0.add(_vTo.scale(screenDistance));

        double Ry = screenHeight / nY;
        double Rx = screenWidth / nX;

        double yi = ((i - nY / 2d) * Ry + Ry / 2d);
        double xj = ((j - nX / 2d) * Rx + Rx / 2d);

        Point3D Pij = Pc;

        if (!isZero(xj)) {
            Pij = Pij.add(_vRight.scale(xj));
        }
        if (!isZero(yi)) {
            Pij = Pij.add(_vUp.scale(-yi)); // Pij.add(_vUp.scale(-yi))
        }

        //antialiasing density >= 1
        double radius = (Rx + Ry) / 2d * density;


        for (int counter = 0; counter < amount; counter++) {
            Point3D point = new Point3D(Pij);
            double cosTheta = 2 * rnd.nextDouble() - 1;
            double sinTheta = Math.sqrt(1d - cosTheta * cosTheta);

            double d = radius * (2 * rnd.nextDouble() - 1);
            double x = d * cosTheta;
            double y = d * sinTheta;

            if (!isZero(x)) {
                point = point.add(_vRight.scale(x));
            }
            if (!isZero(y)) {
                point = point.add(_vUp.scale(y));
            }
            rays.add(new Ray(_p0, point.subtract(_p0)));
        }
        return rays;
    }


    public Ray constructRayThroughPixel(int nX, int nY,
                                        int j, int i, double screenDistance,
                                        double screenWidth, double screenHeight) {
        if (isZero(screenDistance)) {
            throw new IllegalArgumentException("distance cannot be 0");
        }

        Point3D Pc = _p0.add(_vTo.scale(screenDistance));

        double Ry = screenHeight / nY;
        double Rx = screenWidth / nX;

        double yi = ((i - nY / 2d) * Ry + Ry / 2d);
        double xj = ((j - nX / 2d) * Rx + Rx / 2d);

        Point3D Pij = Pc;

        if (!isZero(xj)) {
            Pij = Pij.add(_vRight.scale(xj));
        }
        if (!isZero(yi)) {
            Pij = Pij.add(_vUp.scale(-yi)); // Pij.add(_vUp.scale(-yi))
        }

        Vector Vij = Pij.subtract(_p0);

        return new Ray(_p0, Vij);

    }
}
