package elements;

import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.Assert.assertEquals;

/**
 * Testing Camera Class
 * @author reouven et raphael
 *
 */
public class CameraTest {

    /**
     * Test method for
     * {@link elements.Camera#constructRayThroughPixel(int, int, int, int, double, double, double)}.
     */
    @Test
    public void testConstructRayThroughPixel() {
        Camera camera = new Camera(Point3D.ZERO, new Vector(0, 0, 1), new Vector(0, -1, 0));

        // ============ Equivalence Partitions Tests ==============
        // TC01: 3X3 Corner (0,0)
        assertEquals("Bad ray", new Ray(Point3D.ZERO, new Vector(-2, -2, 10)),
                camera.constructRayThroughPixel(3, 3, 0, 0, 10, 6, 6));

        // TC02: 4X4 Corner (0,0)
        assertEquals("Bad ray", new Ray(Point3D.ZERO, new Vector(-3, -3, 10)),
                camera.constructRayThroughPixel(4, 4, 0, 0, 10, 8, 8));

        // TC03: 4X4 Side (0,1)
        assertEquals("Bad ray", new Ray(Point3D.ZERO, new Vector(-1, -3, 10)),
                camera.constructRayThroughPixel(4, 4, 1, 0, 10, 8, 8));

        // TC04: 4X4 Inside (1,1)
        assertEquals("Bad ray", new Ray(Point3D.ZERO, new Vector(-1, -1, 10)),
                camera.constructRayThroughPixel(4, 4, 1, 1, 10, 8, 8));

        // =============== Boundary Values Tests ==================
        // TC11: 3X3 Center (1,1)
        assertEquals("Bad ray", new Ray(Point3D.ZERO, new Vector(0, 0, 10)),
                camera.constructRayThroughPixel(3, 3, 1, 1, 10, 6, 6));

        // TC12: 3X3 Center of Upper Side (0,1)
        assertEquals("Bad ray", new Ray(Point3D.ZERO, new Vector(0, -2, 10)),
                camera.constructRayThroughPixel(3, 3, 1, 0, 10, 6, 6));

        // TC13: 3X3 Center of Left Side (1,0)
        assertEquals("Bad ray", new Ray(Point3D.ZERO, new Vector(-2, 0, 10)),
                camera.constructRayThroughPixel(3, 3, 0, 1, 10, 6, 6));

    }

    /**
     * How would you test the ray intersection method?
     * • Position Camera and a 3D Model geometry
     * • Generate rays through all pixels of View Plane 3x3 (WxH 3x3)
     * • Summarize amount of intersections of all the rays
     * • Check the expected amount and the summarized amount
     */
    @Test
    public void testIntersectionRayWithSphere() {
        int numberOfIntersection = 0;
        Camera camera_test1 = new Camera(Point3D.ZERO, new Vector(0, 0, 1), new Vector(0, -1, 0));
        Camera camera_test2 = new Camera(new primitives.Point3D(0,0,-0.5), new Vector(0, 0, 1), new Vector(0, -1, 0));
        Camera camera_test3 = new Camera(new primitives.Point3D(0,0,-0.5), new Vector(0, 0, 1), new Vector(0, -1, 0));
        Camera camera_test4 = new Camera(new primitives.Point3D(0,0,-0.5), new Vector(0, 0, 1), new Vector(0, -1, 0));
        Camera camera_test5 = new Camera(Point3D.ZERO, new Vector(0, 0, 1), new Vector(0, -1, 0));

        //initialisation tab of ray for all of 3 camera_test and implement it.

        java.util.List<primitives.Ray> rayList_camera_test1 = new java.util.ArrayList<primitives.Ray>();
        java.util.List<primitives.Ray> rayList_camera_test2 = new java.util.ArrayList<primitives.Ray>();
        java.util.List<primitives.Ray> rayList_camera_test3 = new java.util.ArrayList<primitives.Ray>();
        java.util.List<primitives.Ray> rayList_camera_test4 = new java.util.ArrayList<primitives.Ray>();
        java.util.List<primitives.Ray> rayList_camera_test5 = new java.util.ArrayList<primitives.Ray>();

        for(int i = 0 ; i < 3 ;i++ ) {
            for(int j = 0 ; j < 3 ; j++ )
            {
                rayList_camera_test1.add( camera_test1.constructRayThroughPixel(3,3,j,i,1,3,3));
                rayList_camera_test2.add( camera_test2.constructRayThroughPixel(3,3,j,i,1,3,3));
                rayList_camera_test3.add(camera_test3.constructRayThroughPixel(3,3,j,i,1,3,3));
                rayList_camera_test4.add(camera_test4.constructRayThroughPixel(3,3,j,i,1,3,3));
                rayList_camera_test5.add(camera_test5.constructRayThroughPixel(3,3,j,i,1,3,3));
            }
        }

        /**
         * First test case Sphere r=1
         * 3x3, HxW=3x3
         * camera point (0,0,0) distance with screen d=1
         * we have Two intersection points
         * the sphere is forward the screen just the ray who through the middle of the screen through the sphere
         */

        geometries.Sphere sphere1 = new geometries.Sphere(1,new primitives.Point3D(0,0,3));
        for (primitives.Ray ray :rayList_camera_test1) {
            if(sphere1.findIntersections(ray) != null)
                numberOfIntersection += sphere1.findIntersections(ray).size();
        }
        assertEquals("Wrong number of intersection point", 2,numberOfIntersection);


        /**
         * Second test case (r=2.5)
         * 3x3, HxW=3x3
         * camera point (0,0,-0.5) distance with screen d=1
         * we have 18 intersection points
         * all the 9 rays who through the screen intersect two times the sphere
         */

        geometries.Sphere sphere2 = new geometries.Sphere(2.5,new primitives.Point3D(0,0,2.5));
        numberOfIntersection = 0;
        for (primitives.Ray ray :rayList_camera_test2) {
            if (sphere2.findIntersections(ray) != null)
                numberOfIntersection += sphere2.findIntersections(ray).size();
        }
        assertEquals("Wrong number of intersection point", 18,numberOfIntersection);

        /**
         * Third test case (r=2)
         * 3x3, HxW=3x3
         * camera point (0,0,-0.5) distance with screen d=1
         * we have 10 intersection points
         * only 5 rays who through the screen intersect two times the sphere
         * excepted the rays who through corner of the screen
         */
        geometries.Sphere sphere3 = new geometries.Sphere(2,new primitives.Point3D(0,0,2));
        numberOfIntersection = 0;
        for (primitives.Ray ray :rayList_camera_test3)
            if(sphere3.findIntersections(ray) != null)
                numberOfIntersection += sphere3.findIntersections(ray).size();

        assertEquals("Wrong number of intersection point", 10,numberOfIntersection);

        /**
         * Fourth test case (r=4)
         * 3x3, HxW=3x3
         * camera point (0,0,-0.5) distance with screen d=1
         * we have 9 intersection points
         * the screen and the camera are inside the sphere
         * so all the 9 rays who through the screen intersect one times the sphere
         */
        geometries.Sphere sphere4 = new geometries.Sphere(4,new primitives.Point3D(0,0,2));
        numberOfIntersection = 0;
        for (primitives.Ray ray :rayList_camera_test4)
            if(sphere4.findIntersections(ray) != null)
                numberOfIntersection += sphere4.findIntersections(ray).size();

        assertEquals("Wrong number of intersection point", 9,numberOfIntersection);

        /**
         * Fifth test case (r=0.5)
         * 3x3, HxW=3x3
         * camera point (0,0,-0.5) distance with screen d=1
         * we have 0 intersection points
         * the sphere is backward the view point so we can't have any rays intersections
         */
        geometries.Sphere sphere5 = new geometries.Sphere(0.5,new primitives.Point3D(0,0,-1));
        numberOfIntersection = 0;
        for (primitives.Ray ray :rayList_camera_test5)
            if(sphere5.findIntersections(ray) != null)
                numberOfIntersection += sphere5.findIntersections(ray).size();

        assertEquals("Wrong number of intersection point", 0,numberOfIntersection);


    }
    @Test
    public void testIntersectionRayWithPlane() {
        int numberOfIntersection = 0;
        Camera camera_test1 = new Camera(Point3D.ZERO, new Vector(0, 0, 1), new Vector(0, -1, 0));
        Camera camera_test2 = new Camera(Point3D.ZERO, new Vector(0, 0, 1), new Vector(0, -1, 0));
        Camera camera_test3 = new Camera(Point3D.ZERO, new Vector(0, 0, 1), new Vector(0, -1, 0));

        //initialisation tab of ray for all of 3 camera_test and implement it.

        java.util.List<primitives.Ray> rayList_camera_test1 = new java.util.ArrayList<primitives.Ray>();
        java.util.List<primitives.Ray> rayList_camera_test2 = new java.util.ArrayList<primitives.Ray>();
        java.util.List<primitives.Ray> rayList_camera_test3 = new java.util.ArrayList<primitives.Ray>();

        for(int i = 0 ; i < 3 ;i++ ) {
            for(int j = 0 ; j < 3 ; j++ )
            {
                rayList_camera_test1.add( camera_test1.constructRayThroughPixel(3,3,j,i,1,3,3));
                rayList_camera_test2.add( camera_test2.constructRayThroughPixel(3,3,j,i,1,3,3));
                rayList_camera_test3.add(camera_test3.constructRayThroughPixel(3,3,j,i,1,3,3));
                }
        }

        /**
         * First test case plane parallel to screen
         * 3x3, HxW=3x3
         * camera point (0,0,0) distance with screen d=1
         * we have 9 intersection points
         * all the 9 rays who through the screen intersect the plane
         */

        geometries.Plane plane1 = new geometries.Plane(new primitives.Point3D(0,0,3),new primitives.Point3D(1,0,3),new primitives.Point3D(0,1,3));
        for (primitives.Ray ray :rayList_camera_test1)
            numberOfIntersection += plane1.findIntersections(ray).size();

        assertEquals("Wrong number of intersection point", 9,numberOfIntersection);

        /**
         * Second test case the plane is not parallel to the screen
         * 3x3, HxW=3x3
         * camera point (0,0,0) distance with screen d=1
         * we have 9 intersection points
         * all the 9 rays who through the screen intersect the plane despite the tilt of the screen
         */

        geometries.Plane plane2 = new geometries.Plane(new primitives.Point3D(0,0,3),new primitives.Point3D(1,0,2.5),new primitives.Point3D(0,5,2));
        numberOfIntersection = 0;
        for (primitives.Ray ray :rayList_camera_test2)
            numberOfIntersection += plane2.findIntersections(ray).size();

        assertEquals("Wrong number of intersection point", 9,numberOfIntersection);

        /**
         * Third test case the plane is not parallel to the screen
         * 3x3, HxW=3x3
         * camera point (0,0,-0.5) distance with screen d=1
         * we have 6 intersection points
         * all the 6 rays who through the screen intersect the plane
         * all bottom's rays of the screen don't intersect the plane
         */

        geometries.Plane plane3 = new geometries.Plane(new primitives.Point3D(0,0,10),new primitives.Point3D(2,0,5),new primitives.Point3D(0,3,2.5));
         numberOfIntersection = 0;
        for (primitives.Ray ray :rayList_camera_test3)
            if(plane3.findIntersections(ray)!=null)
                numberOfIntersection += plane3.findIntersections(ray).size();

        assertEquals("Wrong number of intersection point", 6,numberOfIntersection);


    }
    @Test
    public void testIntersectionRayWithTriangle() {
        int numberOfIntersection = 0;
        Camera camera_test1 = new Camera(Point3D.ZERO, new Vector(0, 0, 1), new Vector(0, -1, 0));
        Camera camera_test2 = new Camera(Point3D.ZERO, new Vector(0, 0, 1), new Vector(0, -1, 0));

        //initialisation tab of ray for all of 3 camera_test and implement it.

        java.util.List<primitives.Ray> rayList_camera_test1 = new java.util.ArrayList<primitives.Ray>();
        java.util.List<primitives.Ray> rayList_camera_test2 = new java.util.ArrayList<primitives.Ray>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                rayList_camera_test1.add(camera_test1.constructRayThroughPixel(3, 3, j, i, 1, 3, 3));
                rayList_camera_test2.add(camera_test2.constructRayThroughPixel(3, 3, j, i, 1, 3, 3));
            }
        }

        /**
         * First test case triangle parallel to screen
         * 3x3, HxW=3x3
         * camera point (0,0,0) distance with screen d=1
         * we have 1 intersection points
         */

        geometries.Triangle triangle1 = new geometries.Triangle(new primitives.Point3D(0, -1, 2), new primitives.Point3D(1, 1, 2), new primitives.Point3D(-1, 1, 2));
        for (primitives.Ray ray : rayList_camera_test1)
            if(triangle1.findIntersections(ray) != null)
                numberOfIntersection += triangle1.findIntersections(ray).size();

        assertEquals("Wrong number of intersection point", 1, numberOfIntersection);

        /**
         * Second test case triangle parallel to screen
         * 3x3, HxW=3x3
         * camera point (0,0,0) distance with screen d=1
         * we have 2 intersection points
         */

        geometries.Triangle triangle2 = new geometries.Triangle(new primitives.Point3D(0, -20, 2), new primitives.Point3D(1, 1, 2), new primitives.Point3D(-1, 1, 2));
        numberOfIntersection = 0;
        for (primitives.Ray ray : rayList_camera_test2)
            if(triangle2.findIntersections(ray) != null)
                numberOfIntersection += triangle2.findIntersections(ray).size();

        assertEquals("Wrong number of intersection point", 2, numberOfIntersection);

    }

}
