package elements;

import primitives.*;
import primitives.Point3D;
import primitives.Ray;
import primitives.Util;
import primitives.Vector;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

public class Camera {
    /**
     *@param _p0
     * @param _vTo
     * @param _vUp
     * @param _vRight
     */
    Point3D _p0;
    Vector _vTo;
    Vector _vUp;
    Vector _vRight;

    /**
     * the constructor take point p0
     * and two vector : Vector towards and vector up
     * we normalized the two vectors
     * and after we make cross Product of the two vector
     * that result vector right.
     * @param _p0 Point3D p0
     * @param _vTo Vector towards
     * @param _vUp vector up
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
     * @author reouven and raphael
     * @param nX coordinate on X's axis
     * @param nY coordinate on Y's axis
     * @param j number of screen's columns
     * @param i number of screen's lines
     * @param screenDistance distance between the point of view p0 and the screen
     * @param screenWidth width of the screen
     * @param screenHeight Height of the screen
     * @return ray who starts from p0 to each pixels
     */
    public Ray constructRayThroughPixel(int nX, int nY,
                                        int j, int i, double screenDistance,
                                        double screenWidth, double screenHeight) {
        if (alignZero(screenDistance) == 0) {
            throw new IllegalArgumentException("distance cannot be zero");
        }
        // Image center
        //Pc = P0 + d∙Vto
        Point3D Pc = _p0.add(_vTo.scale(screenDistance));

        //Ratio (pixel width & height)
        //Ry = h/Ny
        //Rx = w/Nx
        double Ry = screenHeight / nY;
        double Rx = screenWidth / nX;

        //yi = (i – Ny/2)∙Ry + Ry/2
        //xj = (j – Nx/2)∙Rx + Rx/2
        double yi = ((i - nY / 2d) * Ry + Ry / 2d);
        double xj = ((j - nX / 2d) * Rx + Rx / 2d);

        //Pixel[i,j] center
        //The final equation : Pi,j = Pc + (xj∙vright – yi∙vup)
        //pIJ = pCenter;
        Point3D Pij = Pc;

        //if (xJ != 0) pIJ = pIJ.add(vRight.scale(xJ));
        if (!isZero(xj)) {
            Pij = Pij.add(_vRight.scale(xj));
        }
        //if (yI != 0) pIJ = pIJ.add(vUp.scale(-yI));
        if (!isZero(yi)) {
            Pij = Pij.add(_vUp.scale(-yi));
        }

        //vi,j = Pi,j – P0
        Vector Vij = Pij.subtract(_p0);

        //Ray: {_p0 = P0, _direction = normalize(Vi,j) }
        return new Ray(_p0, Vij);

    }

    /**
     * @return point  P0
     */
    public Point3D get_p0() {
        return new Point3D(_p0);
    }

    /**
     * @return vector towards
     */
    public Vector get_vTo() {
        return new Vector(_vTo);
    }
    /**
     * @return vector up
     */
    public Vector get_vUp() {
        return new Vector(_vUp);
    }

    /**
     * @return vector right
     */
    public Vector get_vRight() {
        return new Vector(_vRight);
    }
}