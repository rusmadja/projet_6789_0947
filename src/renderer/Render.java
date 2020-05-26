package renderer;

import elements.AmbientLight;
import elements.Camera;
import elements.LightSource;
import elements.Material;
import geometries.Intersectable;
import primitives.Color;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import scene.Scene;

import java.util.List;

import static geometries.Intersectable.GeoPoint;
import static primitives.Util.alignZero;
import static primitives.Util.isZero;


public class Render {
    private final ImageWriter _imageWriter;
    private final Scene _scene;

    private static final double DELTA = 0.1;
    private static final int MAX_CALC_COLOR_LEVEL = 30;
    private static final double MIN_CALC_COLOR_K = 0.001;

    public Render(ImageWriter imageWriter, Scene scene) {
        this._imageWriter = imageWriter;
        this._scene = scene;
    }

    public void printGrid(int interval, java.awt.Color color) {
        int Nx = _imageWriter.getNx();
        int Ny = _imageWriter.getNy();
        for (int i = 0; i < Ny; i++) {
            for (int j = 0; j < Nx; j++) {
                if (i % interval == 0 || j % interval == 0) {
                    _imageWriter.writePixel(j, i, color);
                }
            }
        }
    }

    public void writeToImage() {
        _imageWriter.writeToImage();
    }

    public void renderImage() {
        Camera camera = _scene.getCamera();
        Intersectable geometries = _scene.getGeometries();
        java.awt.Color background = _scene.getBackground().getColor();
        AmbientLight ambientLight = _scene.getAmbientLight();
        double distance = _scene.getDistance();

        int Nx = _imageWriter.getNx();
        int Ny = _imageWriter.getNy();
        double width = _imageWriter.getWidth();
        double height = _imageWriter.getHeight();

        for (int row = 0; row < Ny; row++) {
            for (int collumn = 0; collumn < Nx; collumn++) {
                Ray ray = camera.constructRayThroughPixel(Nx, Ny, collumn, row, distance, width, height);
                GeoPoint closestPoint = findClosestIntersection(ray);
                if (closestPoint == null) {
                    _imageWriter.writePixel(collumn, row, background);
                } else {
                    _imageWriter.writePixel(collumn, row, calcColor(closestPoint, ray).getColor());
                }
            }
        }

    }

    /**
     * TODO
     * @param intersectionPoints
     * @return
     */
    private GeoPoint getClosestPoint(List<GeoPoint> intersectionPoints) {
        Point3D p0 = _scene.getCamera().getP0();
        double minDist = Double.MAX_VALUE;
        double currentDistance = 0;

        GeoPoint pt = null;

        for (GeoPoint geoPoint : intersectionPoints) {
            currentDistance = p0.distance(geoPoint.getPoint());
            if (currentDistance < minDist) {
                minDist = currentDistance;
                pt = geoPoint;
            }
        }
        return pt;
    }
    /**
     * Find intersections of a ray with the scene geometries and get the
     * intersection point that is closest to the ray head. If there are no
     * intersections, null will be returned.
     *
     * @param ray intersecting the scene
     * @return the closest point
     */
    private GeoPoint findClosestIntersection(Ray ray) {
        if (ray == null) {
            return null;
        }
        GeoPoint closestPoint = null;
        double closestDistance = Double.MAX_VALUE;
        Point3D ray_p0 = ray.getPoint();

        List<GeoPoint> intersections = _scene.getGeometries().findIntersections(ray);
        if (intersections == null)
            return null;

        for (GeoPoint geoPoint : intersections) {
            double distance = ray_p0.distance(geoPoint.getPoint());
            if (distance < closestDistance) {
                closestPoint = geoPoint;
                closestDistance = distance;
            }
        }
        return closestPoint;
    }
    /**
     * TODO
     * @param coloredPoint
     * @param inRay
     * @return
     */
    private Color calcColor(GeoPoint coloredPoint, Ray inRay){
        Color color = calcColor(coloredPoint, inRay, MAX_CALC_COLOR_LEVEL, 1.0);
        color = color.add(_scene.getAmbientLight().getIntensity());
        return color;
    }
    /**
     * TODO
     * @param coloredPoint
     * @param inRay
     * @param level
     * @param k
     * @return
     */
    private Color calcColor(GeoPoint coloredPoint, Ray inRay, int level, double k) {
        if (level == 0 || k<MIN_CALC_COLOR_K)
            return Color.BLACK;

        List<LightSource> lightSources = _scene.getLightSources();
        Color result = _scene.getAmbientLight().getIntensity();
        result = result.add(coloredPoint.getGeometry().getEmissionLight());

        Vector v = coloredPoint.getPoint().subtract(_scene.getCamera().getP0()).normalize();
        Vector n = coloredPoint.getGeometry().getNormal(coloredPoint.getPoint());

        Material material = coloredPoint.getGeometry().getMaterial();
        int nShininess = material.getnShininess();
        double kd = material.getkD();
        double ks = material.getkS();
        double kr = material.getkR();
        double kkr = k * kr ;
        double kt = material.getkT();
        double kkt = k* kt;

        if (lightSources != null) {
            for (LightSource lightSource : lightSources) {
                Vector l = lightSource.getL(coloredPoint.getPoint());
                double nl = alignZero(n.dotProduct(l));
                double nv = alignZero(n.dotProduct(v));
                if (nl * nv > 0) {
                    double ktr = transparency(lightSource, l, n, coloredPoint);
                    if (ktr * k > MIN_CALC_COLOR_K) {
                        Color ip = lightSource.getIntensity(coloredPoint.getPoint()).scale(ktr);
                        result = result.add(
                                calcDiffusive(kd, nl, ip),
                                calcSpecular(ks, l, n, nl, v, nShininess, ip));
                    }
                }
            }
        }
        if (level == 1)
            return Color.BLACK;

        if (kkr > MIN_CALC_COLOR_K) {
            Ray reflectedRay = constructReflectedRay(coloredPoint, inRay, n);
            GeoPoint reflectedPoint = findClosestIntersection(reflectedRay);
            if (reflectedPoint != null) {
                result = result.add(calcColor(reflectedPoint, reflectedRay, level - 1, kkr).scale(kr));
            }
        }
        if (kkt > MIN_CALC_COLOR_K) {
            Ray refractedRay = constructRefractedRay(coloredPoint, inRay, n);
            GeoPoint refractedPoint = findClosestIntersection(refractedRay);
            if (refractedPoint != null) {
                result = result.add(calcColor(refractedPoint, refractedRay, level - 1, kkt).scale(kt));
            }
        }
        return result;
    }
    /**
     * In our state there are the same direction so we just create a new ray with same direction,
     * and start point = point who intersect the new environment
     * @param coloredPoint
     * @param inRay
     * @param n
     * @return
     */
    private Ray constructRefractedRay(GeoPoint coloredPoint, Ray inRay, Vector n) {
        return new Ray(coloredPoint.getPoint(),inRay.getDirection(),n);
    }
    /**
     * @param pointGeo
     * @param inRay
     * @param n
     * @return  𝒓=𝒗−𝟐∙𝒗∙𝒏∙𝒏
     */
    private Ray constructReflectedRay(GeoPoint pointGeo, Ray inRay, Vector n){
        double VdotN = inRay.getDirection().dotProduct(n);
        if (alignZero(VdotN) == 0)
            return null ;
        return new Ray(pointGeo.getPoint(),inRay.getDirection().add(n.scale(-2 * VdotN)),n);
    }
    /**
     * Calculate Specular component of light reflection.
     *
     * @param ks         specular component coef
     * @param l          direction from light to point
     * @param n          normal to surface at the point
     * @param nl         dot-product n*l
     * @param v          direction from point of view to point
     * @param nShininess shininess level
     * @param ip         light intensity at the point
     * @return specular component light effect at the point
     * @author Dan Zilberstein
     * <p>
     * Finally, the Phong model has a provision for a highlight, or specular, component, which reflects light in a
     * shiny way. This is defined by [rs,gs,bs](-V.R)^p, where R is the mirror reflection direction vector we discussed
     * in class (and also used for ray tracing), and where p is a specular power. The higher the value of p, the shinier
     * the surface.
     */
    private Color calcSpecular(double ks, Vector l, Vector n, double nl, Vector v, int nShininess, Color ip) {
        double p = nShininess;
        if(isZero(nl)){
            throw new IllegalArgumentException("nl cannot be Zero for scaling the normal vector");
        }
        Vector R = l.add(n.scale(-2 * nl));
        double VR = alignZero(v.dotProduct(R));
        if (VR >= 0) {
            return Color.BLACK;
        }
        // [rs,gs,bs](-V.R)^p
        return ip.scale(ks * Math.pow(-1d*VR, p));
    }
    /**
     * Calculate Diffusive component of light reflection.
     *
     * @param kd diffusive component coef
     * @param nl dot-product n*l
     * @param ip light intensity at the point
     * @return diffusive component of light reflection
     * @author Dan Zilberstein
     * <p>
     * The diffuse component is that dot product n•L that we discussed in class. It approximates light, originally
     * from light source L, reflecting from a surface which is diffuse, or non-glossy. One example of a non-glossy
     * surface is paper. In general, you'll also want this to have a non-gray color value,
     * so this term would in general be a color defined as: [rd,gd,bd](n•L)
     */
    private Color calcDiffusive(double kd, double nl, Color ip) {
        if (nl < 0) {
            nl = -nl;
        }

        return ip.scale(nl * kd);
    }

    private boolean sign(double val) {
        return (val > 0d);
    }
    private boolean unshaded(Vector l, Vector n, GeoPoint geopoint) {
        Vector lightDirection = l.scale(-1); // from point to light source
        Vector delta = n.scale(n.dotProduct(lightDirection) > 0 ? DELTA : - DELTA);
        Point3D point = geopoint.getPoint().add(delta);
        Ray lightRay = new Ray(point, lightDirection);
        List<GeoPoint> intersections = _scene.getGeometries().findIntersections(lightRay);
        return intersections == null;
    }
    private boolean unshaded(LightSource light, Vector l, Vector n, GeoPoint geopoint) {
        Vector lightDirection = l.scale(-1); // from point to light source
        Vector delta = n.scale(n.dotProduct(lightDirection) > 0 ? DELTA : -DELTA);
        Point3D point = geopoint.getPoint().add(delta);
        Ray lightRay = new Ray(point, lightDirection);
        List<GeoPoint> intersections = _scene.getGeometries().findIntersections(lightRay);

        if (intersections == null) {
            return true;
        }
        double lightDistance = light.getDistance(geopoint.getPoint());
        for (GeoPoint gp : intersections) {
            if (alignZero(gp.getPoint().distance(geopoint.getPoint()) - lightDistance) <= 0)
                return false;
        }

        return true;
    }
    /**
     * TODO checker cette fonction
     * @param light
     * @param l
     * @param n
     * @param geopoint
     * @return
     */
    private double transparency(LightSource light, Vector l, Vector n, GeoPoint geopoint) {
        Vector lightDirection = l.scale(-1); // from point to light source
        Ray lightRay = new Ray(geopoint.getPoint(), lightDirection, n);
        Point3D pointGeo = geopoint.getPoint();


        List<GeoPoint> intersections = _scene.getGeometries().findIntersections(lightRay);
        if (intersections == null) {
            return 1d;
        }
        double lightDistance = light.getDistance(pointGeo);
        double ktr = 1d;
        for (GeoPoint gp : intersections) {
            if (alignZero(gp.getPoint().distance(pointGeo) - lightDistance) <= 0) {
                ktr *= gp.getGeometry().getMaterial().getkT();
                if (ktr < MIN_CALC_COLOR_K) {
                    return 0.0;
                }
            }
        }
        return ktr;
    }

}