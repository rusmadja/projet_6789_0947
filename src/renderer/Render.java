package renderer;

import elements.Camera;
import elements.DirectionalLight;
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

/**
 *
 */
public class Render {
    private final ImageWriter _imageWriter;
    private final Scene _scene;
    private double sceneDistance = 0;
    private static final double DELTA = 0.1;
    private static boolean isTransparency = true;
    private static final int MAX_CALC_COLOR_LEVEL = 30;
    private static final double MIN_CALC_COLOR_K = 0.001;
    private int _superSampling = 1;
    private double _glossyBlurryDistance = 0d;
    private int _threads = 20;
    private final int SPARE_THREADS = 2; // Spare threads if trying to use all the cores
    private boolean _print = false; // printing progress percentage
    /**
     * Pixel is an internal helper class whose objects are associated with a Render object that
     * they are generated in scope of. It is used for multithreading in the Renderer and for follow up
     * its progress.<br/>
     * There is a main follow up object and several secondary objects - one in each thread.
     *
     * @author Dan
     */
    private class Pixel {
        private long _maxRows = 0;
        private long _maxCols = 0;
        private long _pixels = 0;
        public volatile int row = 0;
        public volatile int col = -1;
        private long _counter = 0;
        private int _percents = 0;
        private long _nextCounter = 0;

        /**
         * The constructor for initializing the main follow up Pixel object
         *
         * @param maxRows the amount of pixel rows
         * @param maxCols the amount of pixel columns
         */
        public Pixel(int maxRows, int maxCols) {
            _maxRows = maxRows;
            _maxCols = maxCols;
            _pixels = maxRows * maxCols;
            _nextCounter = _pixels / 100;
            if (Render.this._print) synchronized (System.out) {
                System.out.printf("\r %02d%%", _percents);
            }
        }

        /**
         * Default constructor for secondary Pixel objects
         */
        public Pixel() {
        }

        /**
         * Internal function for thread-safe manipulating of main follow up Pixel object - this function is
         * critical section for all the threads, and main Pixel object data is the shared data of this critical
         * section.<br/>
         * The function provides next pixel number each call.
         *
         * @param target target secondary Pixel object to copy the row/column of the next pixel
         * @return the progress percentage for follow up: if it is 0 - nothing to print, if it is -1 - the task is
         * finished, any other value - the progress percentage (only when it changes)
         */
        private synchronized int nextP(Pixel target) {
            ++col;
            ++_counter;
            if (col < _maxCols) {
                target.row = this.row;
                target.col = this.col;
                if (_print && _counter == _nextCounter) {
                    ++_percents;
                    _nextCounter = _pixels * (_percents + 1) / 100;
                    return _percents;
                }
                return 0;
            }
            ++row;
            if (row < _maxRows) {
                col = 0;
                if (_print && _counter == _nextCounter) {
                    ++_percents;
                    _nextCounter = _pixels * (_percents + 1) / 100;
                    return _percents;
                }
                return 0;
            }
            return -1;
        }

        /**
         * Public function for getting next pixel number into secondary Pixel object.
         * The function prints also progress percentage in the console window.
         *
         * @param target target secondary Pixel object to copy the row/column of the next pixel
         * @return true if the work still in progress, -1 if it's done
         */
        public boolean nextPixel(Pixel target) {
            int percents = nextP(target);
            if (_print && percents > 0)
                synchronized (System.out) {
                    System.out.printf("\r %02d%%", percents);
                }
            if (percents >= 0)
                return true;
            if (_print) synchronized (System.out) {
                System.out.printf("\r %02d%%", 100);
            }
            return false;
        }
    }

    public Render setIsTransparency(boolean isTransparency) {
        Render.isTransparency = isTransparency;
        return this;
    }

    public Render setSuperSampling(int superSampling) {
        _superSampling = superSampling;
        return this;
    }

    public Render setGlossyBlurryDistance(double glossyBlurryDistance) {
        _glossyBlurryDistance = glossyBlurryDistance;
        return this;
    }

    public Render setThreads(int threads) {
        _threads = threads;
        return this;
    }

    public Render(ImageWriter imageWriter, Scene scene) {
        this._imageWriter = imageWriter;
        this._scene = scene;
    }

    /**
     * Function : printGrid
     * Meaning : print a grid in function of interval received
     * @Return : this function doesn't return anything
     */
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

    /**
     * Function : writeToImage
     * Meaning : finalize the picture creation by creating the file and saving it in HDD
     * @Return : this function doesn't return anything
     */
    public void writeToImage() {
        _imageWriter.writeToImage();
    }

    /**
     * Function : renderImage
     * Parameter : this function doesn't take in parameter anything
     * Meaning : pick up all of point3D from _scene and realize image representing it
     * @Return : this function doesn’t return anything
     */
   /* public void renderImage() {
        Camera camera = _scene.getCamera();
        /*Intersectable geometries = _scene.getGeometries();
        java.awt.Color background = _scene.getBackground().getColor();
        AmbientLight ambientLight = _scene.getAmbientLight();
        double distance = _scene.getDistance();
        int Nx = _imageWriter.getNx();
        int Ny = _imageWriter.getNy();
        double width = _imageWriter.getWidth();
        double height = _imageWriter.getHeight();


        ExecutorService executor = Executors.newFixedThreadPool(_threads);
        for (int i = 0; i < Ny; ++i) { // go by pixel rows
            final int row = i;
            final Runnable rowTask = () -> {
                for (int j = 0; j < Nx; ++j) { // go by pixel in row
                    List<Ray> rays = camera.constructRaysThroughPixel(Nx, Ny, j, row, distance, width, height);
                    _imageWriter.writePixel(j, row, calcColor(rays).getColor());
                }
            };
            if (_threads == 1)
                rowTask.run();
            else
                executor.execute(rowTask);
        }
        if (_threads != 1) {
            executor.shutdown();
            while (!executor.isTerminated()) {
                try {
                    Thread.sleep(1);
                } catch (Exception e) {}
            }
        }
    }*/
    private volatile int max = 0;
    public void renderImage() {
        final Camera camera = _scene.getCamera();
        final Intersectable geometries = _scene.getGeometries();
        final java.awt.Color background = _scene.getBackground().getColor();
        double distance = _scene.getDistance();
        int Nx = _imageWriter.getNx();
        int Ny = _imageWriter.getNy();
        double width = _imageWriter.getWidth();
        double height = _imageWriter.getHeight();

        // Multi-threading
        final Pixel thePixel = new Pixel(Ny, Nx);
        // Generate threads
        Thread[] threads = new Thread[_threads];
        for (int i = _threads - 1; i >= 0; --i) {
            threads[i] = new Thread(() -> {
                Pixel pixel = new Pixel();
                max = 0;
                while (thePixel.nextPixel(pixel)) {
                    List<Ray> rays = camera.constructRaysThroughPixel(Nx, Ny, pixel.col, pixel.row, distance, width, height);
                    if(rays!=null)
                        _imageWriter.writePixel( pixel.col, pixel.row, calcColor(rays).getColor());

                }
            });
        }
        for (Thread thread : threads) thread.start();
        for (Thread thread : threads)
            try {
                thread.join();
            } catch (InterruptedException e) {
            }
        if (_print) synchronized (System.out) {
            System.out.printf("\r100%%\n");
        }
    }

    /**
     *
     * this fonction check the closest point from p0 in the list of instersectionPoints
     * @param intersectionPoints
     * @return the closest Point
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
     * Calculate the color  in a ray. every ray send from the camera
     * come back with a color that color the pixel who the ray arrive
     *
     * @param inRay the ray list
     * @return the color level
     */
    private Color calcColor(List<Ray> inRay){
        return calcColor( inRay,MAX_CALC_COLOR_LEVEL,1,1);
    }

    private Color calcColor(List<Ray> inRay,int level,double k,double factor){
        Color bkg = _scene.getBackground();
        Color color = Color.BLACK;
        double k_factor = k* factor;
        for (Ray ray:inRay) {
            //if(ray.getPointAtDistance())
            GeoPoint gp = findClosestIntersection(ray);
            color = color.add(gp == null ? bkg : calcColor(gp, ray, level-1 ,k_factor));
        }
        color = color.add(_scene.getAmbientLight().getIntensity());
        int size = inRay.size();
        return (size == 1) ? color : color.reduce(size);
    }

    /**
         * Calculate the color level to the GeoPoint
         * @param coloredPoint the point to calculate de color
         * @param inRay  the ray in the point
         * @param level
         * @param k
         * @return the color in the point
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

        if (lightSources != null) {
            for (LightSource lightSource : lightSources) {
                Vector l = lightSource.getL(coloredPoint.getPoint());
                double nl = alignZero(n.dotProduct(l));
                double nv = alignZero(n.dotProduct(v));
                double ktr = 0;

                if(isTransparency)
                    ktr = transparencySoftShadow(lightSource, l, n, alignZero(nl*nv)>=0 , nv , coloredPoint);
                else if (nl * nv > 0)
                    ktr = unshaded(lightSource, l, n, coloredPoint);

                if (ktr * k > MIN_CALC_COLOR_K) {
                    Color ip = lightSource.getIntensity(coloredPoint.getPoint()).scale(ktr);
                    result = result.add(
                            calcDiffusive(kd, nl, ip),
                            calcSpecular(ks, l, n, nl, v, nShininess, ip));
                }
            }
        }

        if (level == 1)
            return Color.BLACK;
        //reflected
        double kr = material.getkR();
        double kkr = k * kr ;
        if (kkr > MIN_CALC_COLOR_K) {
            List<Ray> reflectedRay = constructReflectedRayBeam(coloredPoint, inRay, n,material.getKglossy());
            result = result.add(calcColor(reflectedRay,level, k, kr));
        }
        //refracted
        double kt = material.getkT();
        double kkt = k* kt;

        if (kkt > MIN_CALC_COLOR_K) {
            List<Ray> refractedRay = constructRefractedRayBeam(coloredPoint, inRay, n,material.getKmatt());
            result = result.add(calcColor(refractedRay,level, k, kt));
        }
        return result;
    }

    /**
     * Function : constructRefractedRay
     * Meaning : We want to get the new refracted ray.
     *           So we calculate the new point of origin of our new ray by
     *           calculating copyPoint = point + 2*normal*(the sign of the result of the dot product between n and the direction of the ray)
     *           This is the new POO of our Ray with the small direction that inRay
     * In our state there are the same direction so we just create a new ray with same direction,
     * and start point = point who intersect the new environment
     * @param coloredPoint
     * @param inRay
     * @param n
     * @return The new Ray that we have calculated
     */
    private Ray constructRefractedRay(GeoPoint coloredPoint, Ray inRay, Vector n) {
        return new Ray(coloredPoint.getPoint(),inRay.getDirection(),n);
    }
    /**
     * Function : constructRefractedRayBeam
     * Meaning : We want to get the new refracted ray.
     *           So we calculate the new point of origin of our new ray by
     *           calculating copyPoint = point + 2*normal*(the sign of the result of the dot product between n and the direction of the ray)
     *           This is the new POO of our Ray with the small direction that inRay
     * In our state there are the same direction so we just create a new ray with same direction,
     * and start point = point who intersect the new environment
     *  @param pointGeo
     *  @param inRay
     *  @param n
     *  @param radius
     * @return The new Ray that we have calculated
     */
    private List<Ray> constructRefractedRayBeam(GeoPoint pointGeo, Ray inRay, Vector n, double radius) {
        Vector vector = inRay.getDirection();
        if(_superSampling != 1 && alignZero(radius)!=0)
            return Ray.ConstructRayBeam(pointGeo.getPoint(), vector, n, n.dotProduct(vector), _glossyBlurryDistance, radius, _superSampling);
        return List.of(new Ray(pointGeo.getPoint(),vector,n));
    }

    /**
     * Function : constructReflectedRay
     * Meaning : We want to get the new reflected ray.
     *           So we calculate the new origin point of our new ray by
     *           calculating copyPoint= point + 2*normal*(the sign of the result of the dot product between n and the direction of the ray)
     *           This is the new POO of our Ray
     *           Now we get the direction of the Ray by the formula R=D- 2*(D*N)*N
     *
     * @param pointGeo
     * @param inRay
     * @param n
     * @return  𝒓=𝒗−𝟐∙𝒗∙𝒏∙𝒏  the new Ray that we have calculated with its new POO and its new direction
     */
    private Ray constructReflectedRay(GeoPoint pointGeo, Ray inRay, Vector n){
        double VdotN = inRay.getDirection().dotProduct(n);
        if (alignZero(VdotN) == 0)
            return null ;
        return new Ray(pointGeo.getPoint(),inRay.getDirection().add(n.scale(-2 * VdotN)),n);
    }

    /**
     * to make it glossy
     * Function : constructReflectedRay
     *  Meaning : We want to get the new reflected ray.
     *            So we calculate the new origin point of our new ray by
     *            calculating copyPoint= point + 2*normal*(the sign of the result of the dot product between n and the direction of the ray)
     *            This is the new POO of our Ray
     *            Now we get the direction of the Ray by the formula R=D- 2*(D*N)*N
     *            the goal is to create many other vector : if it's glossy or not
     *
     *  @param pointGeo
     *  @param inRay
     *  @param n
     *  @return   many rays by this 𝒓=𝒗−𝟐∙𝒗∙𝒏∙𝒏
     *
     */
    private List<Ray> constructReflectedRayBeam(GeoPoint pointGeo, Ray inRay, Vector n,double radius){
        double VdotN = inRay.getDirection().dotProduct(n);
        if (alignZero(VdotN) == 0)
            return null ;
        Vector vector = inRay.getDirection().add(n.scale(-2 * VdotN));
        if(_superSampling != 1 && alignZero(radius)!=0)
            return Ray.ConstructRayBeam(pointGeo.getPoint(), vector, n,VdotN, _glossyBlurryDistance, radius, _superSampling);
        return List.of(new Ray(pointGeo.getPoint(),vector,n));
    }

    /**
     * Calculate Specular component of light reflection.
     *
     * @param ks         material parameter
     * @param l          the light source vector
     * @param n          the normal vector of the geometry
     * @param nl         dot-product n*l
     * @param v          vector between the point and the scene origin
     * @param nShininess the shininess parameter of the geometry
     * @param ip         light intensity at the point
     * @return specular component light effect at the point
     * @author reouven & raphael
     * Meaning : We obtain a new Vector r that is calculated by the formula l-(2*l·normal)*normal.
     *            We multiply ks with the v-r dot product, all is upped to shininess power.
     *            We multiply the result to the whole of lightIntensity composites.
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
     * @param kd material parameter
     * @param nl dot-product n*l
     * @param ip light intensity at the point
     * @return diffusive component of light reflection
     * @author reouven et  raphael
     * Meaning : Calculation of the diffuse color from the the material.
     *      Get a material coefficient (kd) and multiply to the dot product of normal and l, two vectors.
     *      We multiply the result to the whole of lightIntensity composites
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
    /**
     * unusual
     * @param l
     * @param n
     * @param geopoint
     * @return
     */
    private boolean unshaded(Vector l, Vector n, GeoPoint geopoint) {
        Vector lightDirection = l.scale(-1); // from point to light source
        Vector delta = n.scale(n.dotProduct(lightDirection) > 0 ? DELTA : - DELTA);
        Point3D point = geopoint.getPoint().add(delta);
        Ray lightRay = new Ray(point, lightDirection);
        List<GeoPoint> intersections = _scene.getGeometries().findIntersections(lightRay);
        return intersections == null;
    }

    /**
     *
     * @param light
     * @param l
     * @param n
     * @param geopoint
     * @return
     */
    private int unshaded(LightSource light, Vector l, Vector n, GeoPoint geopoint) {

        Vector lightDirection = l.scale(-1); // from point to light source
        Vector delta = n.scale(n.dotProduct(lightDirection) > 0 ? DELTA : -DELTA);
        Point3D point = geopoint.getPoint().add(delta);
        Ray lightRay = new Ray(point, lightDirection);
        List<GeoPoint> intersections = _scene.getGeometries().findIntersections(lightRay);

        if (intersections == null)
            return 1;

        double lightDistance = light.getDistance(geopoint.getPoint());
        for (GeoPoint gp : intersections)
            if (alignZero(gp.getPoint().distance(geopoint.getPoint()) - lightDistance) <= 0)
                return 0;

        return 1;
    }

    /**
     * @Meaning the goal of this function is to make a 3D shape transparency if a
     * sphere in behind a triangle we can make the triangle transparent in order
     * to be able to see the sphere who is behind
     * @param light light source
     * @param l
     * @param n
     * @param geopoint
     * @return ktr more or less shadow to the point I want the transparency
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
    /**
     *
     * @param
     * @param l
     * @param n
     * @param geopoint
     * @return
     */
    private double transparencySoftShadow(LightSource light, Vector l, Vector n, boolean nvnl, double nv, GeoPoint geopoint) {
        Vector lightDirection = l.scale(-1); // from point to light source
        double radius = light.getRadius();
        double distance =  light.getDistance(geopoint.getPoint());
        List<Ray> lightRays;
        Ray lightRay = new Ray(geopoint.getPoint(), lightDirection, n);

        if(light instanceof DirectionalLight)
        {
            return transparency(light,l,n,geopoint);
        }
        if (_superSampling == 1 || isZero(radius)) {
            if (nvnl)
                return 0d;
            lightRays = List.of(lightRay);
        } else {
            lightRays = Ray.ConstructRayBeam(geopoint.getPoint(), lightRay.getDirection(), n, -nv, distance, radius, _superSampling);
        }


        double totalKtr = 0d;
        for (Ray ray : lightRays) {
            List<GeoPoint> intersections = _scene.getGeometries().findIntersections(ray, distance);
            if (intersections == null) {
                totalKtr += 1d;
                continue;
            }

            double ktr = 1d;
            for (GeoPoint gp : intersections) {
                ktr = ktr * gp.getGeometry().getMaterial().getkT();
                if (ktr < MIN_CALC_COLOR_K) {
                    ktr = 0;
                    break;
                }
            }
            totalKtr += ktr;
        }
        totalKtr /=lightRays.size();
        return  totalKtr;
    }
    public Render setMultithreading(int threads) {
        if (threads < 0)
            throw new IllegalArgumentException("Multithreading parameter must be 0 or higher");
        if (threads != 0)
            _threads = threads;
        else {
            int cores = Runtime.getRuntime().availableProcessors() - SPARE_THREADS;
            _threads = cores <= 2 ? 1 : cores;
        }
        return this;
    }


}