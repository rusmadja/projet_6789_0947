package elements;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static primitives.Util.isZero;

/**
 * Class Camera create a Camera with 3 vectors and a Point3D
 *
 * @author Reouven & Raphael
 */

public class Camera {
    Point3D _p0;
    Vector _vTo;
    Vector _vUp;
    Vector _vRight;
    private static Random rnd = new Random();
    private int _superSampling =1;
    private double _aperture = 0d;
    private double _focus = 0;
    private int _dofSampling = 0;

    /**
     * Constructor :
     * create a Camera with the orientations of all the vector
     * @throws  IllegalArgumentException the vectors must be orthogonal (vUP and vTO )
     *
     *
     * @param _p0 camera position
     * @param _vTo camera direction TOWARDS
     * @param _vUp camera direction UP
     */
    public Camera(Point3D _p0, Vector _vTo, Vector _vUp) {

        //if the the vectors are not orthogonal, throw exception.
        if (_vUp.dotProduct(_vTo) != 0)
            throw new IllegalArgumentException("the vectors must be orthogonal");

        this._p0 = new Point3D(_p0);
        this._vTo = _vTo.normalized();
        this._vUp = _vUp.normalized();

        _vRight = this._vTo.crossProduct(this._vUp).normalize();

    }


    /**
     * Getter camera's position
     *
     * @return the position Point3D
     */
    public Point3D getP0() {
        return new Point3D(_p0);
    }

    /**
     * Getter  direction of vectorTOWARD
     *
     * @return vector vTo
     */
    public Vector getVTo() {
        return new Vector(_vTo);
    }

    /**
     * Getter  direction of vectorUP
     *
     * @return vector vUP
     */
    public Vector getVUp() {
        return new Vector(_vUp);
    }
    /**
     * Getter  direction of vectorRight
     *
     * @return vector vRight
     */
    public Vector getVRight() {
        return new Vector(_vRight);
    }

    public Camera setDepthOfField(double aperture, double focus, int dofSampling) {
        _aperture = aperture;
        _focus = focus;
        _dofSampling = dofSampling;
        return this;
    }

    public Camera setSuperSampling(int superSampling) {
        _superSampling = superSampling;
        return this;
    }
    /**
     * Function : ConstructRayThroughPixels WITH SUPERSAMPLING
     * WITHOUT DOF
     *
     * @param   nX: number of pixels in width axis
     * @param   nY: number of pixels in height axis
     * @param   i: coordinate x in the screen
     * @param   j: coordinate y in the screen
     * @param   screenDistance: distance between the camera eye and the screen
     * @param   screenWidth: screen width definition
     * @param   screenHeight: screen height definition
     *
     * Meaning : We must find the ray from the eye of the camera that passes in pixels of the scene
     *          for a given Point2D(X,Y).
     *          First we have PC=P0+Vto*screenDistance(the center of the screen).
     *          Then we calculate i = (x - (Nx) / 2) * Rx this  is the number
     *          of pixels we need to move and the X axis. We multiply Vright by it
     *          We do the same thing for j=(y - (Ny) / 2) * Ry but this time it is on the up axis and we
     *          multiply Vup.
     *          We add to PC the difference between Vright and Vup and we get P.
     *          P= PC+ [Vright*i- Vup*j]
     *          The ray is the vector from P0 to P with P0 as POO.
     *
     *
     * Return : The all rays that passes through the pixels
     *
     */
    public List<Ray> constructRaysThroughPixel(int nX, int nY,
                                                 int j, int i, double screenDistance,
                                                 double screenWidth, double screenHeight,double superSampling) {
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


        for (int _index_x = (int) -(superSampling); _index_x <= (superSampling); _index_x++) {
            for (int _index_y = (int) -(superSampling); _index_y <= (superSampling); _index_y++) {
                Point3D tmp = new Point3D(
                        x + _index_x * Rx / (superSampling + 1),
                        y + _index_y * Ry / (superSampling + 1),
                        z);
                _final.addAll(constructFocalRays(tmp));
                //_final.add(new Ray(_p0, new Vector(tmp.subtract(_p0)).normalized()));
            }
        }
        return _final;
    }

    /**
     * Function : ConstructRayThroughPixels WITH DOF
     *
     * @param  nX: number of pixels in width axis
     * @param   nY: number of pixels in height axis
     * @param   i: coordinate x in the screen
     * @param   j: coordinate y in the screen
     * @param   dist: distance between the camera eye and the screen
     * @param   width: screen width definition
     * @param   height: screen height definition
     *
     * Meaning : We must find the ray from the eye of the camera that passes in pixels of the scene
     *          for a given Point2D(X,Y).
     *          First we have PC=P0+Vto*screenDistance(the center of the screen).
     *          Then we calculate i = (x - (Nx) / 2) * Rx this  is the number
     *          of pixels we need to move and the X axis. We multiply Vright by it
     *          We do the same thing for j=(y - (Ny) / 2) * Ry but this time it is on the up axis and we
     *          multiply Vup.
     *          We add to PC the difference between Vright and Vup and we get P.
     *          P= PC+ [Vright*i- Vup*j]
     *          The ray is the vector from P0 to P with P0 as POO.
     *
     *
     * Return : The ray that passes through the pixels and call for every rays
     *                the FocalRays function
     *
     */
    public List<Ray> constructRaysThroughPixel(int nX, int nY, int j, int i, double dist, double width, double height) {
        double rX = width / nX;
        double rY = height / nY;
        double xJ = (j - (nX - 1) / 2d) * rX;
        double yI = (i - (nY - 1) / 2d) * rY;
        Point3D pIJ = _p0.add(_vTo.scale(dist)); // the view plane center point
        if (xJ != 0)
            pIJ = pIJ.add(_vRight.scale(xJ));
        if (yI != 0)
            pIJ = pIJ.add(_vUp.scale(-yI)); // it's possible pIJ.subtract(_vUp.scale(yI));

        if (_superSampling == 0)
            return constructFocalRays(pIJ);

        List<Ray> rays = new LinkedList<>();
        double y = -rY / 2d;
        double dY = rY / _superSampling;
        double xStart = -rX / 2d;
        double dX = rX / _superSampling;
        for (int row = _superSampling; row >= 0; --row, y += dY) {
            double x = xStart;
            for (int col = _superSampling; col >= 0; --col, x += dX) {
                Point3D p = pIJ;
                if (!isZero(x))
                    p = pIJ.add(_vRight.scale(x));
                if (!isZero(y))
                    p = p.add(_vUp.scale(y));
                rays.add(new Ray(p,new Vector(p.subtract(_p0)).normalized()));
               // rays.addAll(constructFocalRays(p));
            }
        }
        return rays;
    }

    /**
     * Function : ConstructRayThroughPixels
     *
     * @param   nX: number of pixels in width axis
     * @param   nY: number of pixels in height axis
     * @param   i: coordinate x in the screen
     * @param   j: coordinate y in the screen
     * @param   screenDistance: distance between the camera eye and the screen
     * @param   screenWidth: screen width definition
     * @param   screenHeight: screen height definition
     *
     * Meaning : We must find the ray from the eye of the camera that passes in pixels of the scene
     *          for a given Point2D(X,Y).
     *          First we have PC=P0+Vto*screenDistance(the center of the screen).
     *          Then we calculate i = (x - (Nx) / 2) * Rx this  is the number
     *          of pixels we need to move and the X axis. We multiply Vright by it
     *          We do the same thing for j=(y - (Ny) / 2) * Ry but this time it is on the up axis and we
     *          multiply Vup.
     *          We add to PC the difference between Vright and Vup and we get P.
     *          P= PC+ [Vright*i- Vup*j]
     *          The ray is the vector from P0 to P with P0 as POO.
     *
     *
     * Return : The ray that passes through the pixels
     *
     */
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




    /**
     * Create rays from the view plane and pass in the focal point
     *
     * @param pnt point to the View Plane
     * @return list of rays
     */
    private List<Ray> constructFocalRays(Point3D pnt) {
       return null;
    }

}
