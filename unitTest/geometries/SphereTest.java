package geometries;
import geometries.Intersectable.GeoPoint;
import org.junit.Test;
import primitives.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing Sphere
 * @author Reouven & raphael
 */
public class SphereTest {
    /**
     * Test method for
     * {@link geometries.Sphere#getNormal(primitives.Point3D)}.
     *
     */
    @Test
    public void getNormalTest() {
        Sphere s1 = new Sphere(4, new Point3D(0.0,0.0,0.0));
        Sphere s2 = new Sphere(1, new Point3D(1,1,1));

        try{
            assertTrue(s1.getNormal(new Point3D(0,0,4)) .equals(new Vector(new Point3D(0,0,1))));
            assertTrue(s1.getNormal(new Point3D(0,0,-4)) .equals (new Vector(new Point3D(0,0,-1))));

        }catch (AssertionError e)
        {fail("the vector normal need to be (0,0,1) or a scale of it " + e.getMessage());}

        try{
            assertTrue(s1.getNormal(new Point3D(0,4,0)).equals(new Vector(new Point3D(0,1,0))));
            assertTrue(s1.getNormal(new Point3D(0,-4,0)).equals(new Vector(new Point3D(0,-1,0))));
        }catch (AssertionError e)
        {fail("the vector normal need to be (0,1,0) or a scale of it");}

        try{
            assertTrue(s1.getNormal(new Point3D(4,0,0)) .equals(new Vector(new Point3D(1,0,0))));
            assertTrue(s1.getNormal(new Point3D(-4,0,0)) .equals(new Vector(new Point3D(-1,0,0))));
        }catch (AssertionError e)
        {fail("the vector normal need to be (1,0,0) or a scale of it");}

        try{
            assertFalse(s1.getNormal(new Point3D(7,7,7))==null);
        }catch (AssertionError e)
        {fail("the normal can't be a vector null ");}


    }

    /**
     * Test method for {@link Sphere#findIntersections(Ray)}.
     */

    @org.junit.Test
    public void findIntsersections() {
        geometries.Sphere sphere = new geometries.Sphere(1d, new primitives.Point3D(1, 0, 0));

        // ============ Equivalence Partitions Tests ==============

        // TC01: Ray's line is outside the sphere (0 points)
        assertEquals(null, sphere.findIntersections(new primitives.Ray(new primitives.Point3D(-1, 0, 0), new primitives.Vector(1, 1, 0))),
                "Ray's line out of sphere");

        // TC02: Ray starts before and crosses the sphere (2 points)
        primitives.Point3D p1 = new primitives.Point3D(0.0651530771650466, 0.355051025721682, 0);
        primitives.Point3D p2 = new primitives.Point3D(1.53484692283495, 0.844948974278318, 0);
        List<GeoPoint> result = sphere.findIntersections(new Ray(new Point3D(-1, 0, 0),
                new Vector(3, 1, 0)));
        assertEquals( 2, result.size(),"Wrong number of points");
        if (result.get(0).getPoint().get_x().get() > result.get(1).getPoint().get_x().get())
        {
            result = java.util.List.of(result.get(1), result.get(0));
        }
        assertEquals(java.util.List.of(p1, p2), List.of(result.get(0).getPoint(),result.get(1).getPoint()), "Ray crosses sphere");

        // TC03: Ray starts inside the sphere (1 point)
        primitives.Point3D p3 = new primitives.Point3D(1, 1, 0);
        List<GeoPoint> resultTC03 = sphere.findIntersections(new Ray(new Point3D(1, 0.5, 0),
                                                                         new Vector(0, 1, 0)));
        assertEquals( 1, resultTC03.size(),"Wrong number of points");

        assertEquals(java.util.List.of(p3), List.of(resultTC03.get(0).getPoint()), "Ray crosses sphere");

        // TC04: Ray starts after the sphere (0 points)...

        List<GeoPoint> resultTC04 = sphere.findIntersections(new Ray(new Point3D(1, 1.5, 0),
                new Vector(0, 1, 0)));
        assertEquals( null, resultTC04,"Wrong number of points");

        // =============== Boundary Values Tests ==================

        // **** Group: Ray's line crosses the sphere (but not the center)
        // TC11: Ray starts at sphere and goes inside (1 points)
        primitives.Point3D p11 = new primitives.Point3D(1.5999999999999996, 0.8, 0);
        List<GeoPoint> resultTC11 = sphere.findIntersections(new Ray(new Point3D(0.4, 0.8, 0),
                new Vector(1, 0, 0)));
        assertEquals( 1, resultTC11.size(),"Wrong number of points");

        assertEquals(java.util.List.of(p11), List.of(resultTC11.get(0).getPoint()), "Ray crosses sphere");

        // TC12: Ray starts at sphere and goes outside (0 points)
        List<GeoPoint> resultTC12 = sphere.findIntersections(new Ray(new Point3D(1.6, 0.8, 0),
                new Vector(1, 0, 0)));
        assertEquals( null, resultTC12,"Wrong number of points");

        // **** Group: Ray's line goes through the center
        // TC13: Ray starts before the sphere (2 points)
        primitives.Point3D p131 = new primitives.Point3D(2, 0, 0);
        primitives.Point3D p132 = new primitives.Point3D(0, 0, 0);
        List<GeoPoint> resultTC13 = sphere.findIntersections(new Ray(new Point3D(-1, 0, 0),
                new Vector(1, 0, 0)));
        assertEquals( 2, resultTC13.size(),"Wrong number of points");

        assertEquals(java.util.List.of(p132, p131), List.of(resultTC13.get(0).getPoint(),resultTC13.get(1).getPoint()), "Ray crosses sphere");

        // TC14: Ray starts at sphere and goes inside (1 points)
        primitives.Point3D p14 = new primitives.Point3D(2, 0, 0);
        List<GeoPoint> resultTC14 = sphere.findIntersections(new Ray(new Point3D(0, 0, 0),
                new Vector(1, 0, 0)));
        assertEquals( 1, resultTC14.size(),"Wrong number of points");

        assertEquals(java.util.List.of(p14), List.of(resultTC14.get(0).getPoint()), "Ray crosses sphere");

        // TC15: Ray starts inside (1 points)
        primitives.Point3D p15 = new primitives.Point3D(2, 0, 0);
        List<GeoPoint> resultTC15 = sphere.findIntersections(new Ray(new Point3D(0.5, 0, 0),
                new Vector(1, 0, 0)));
        assertEquals( 1, resultTC15.size(),"Wrong number of points");

        assertEquals(java.util.List.of(p15), List.of(resultTC15.get(0).getPoint()), "Ray crosses sphere");
        // TC16: Ray starts at the center (1 points)
        primitives.Point3D p16 = new primitives.Point3D(1, 1, 0);
        List<GeoPoint> resultTC16 = sphere.findIntersections(new Ray(new Point3D(1, 0, 0),
                new Vector(0, 0.75, 0)));
        assertEquals( 1, resultTC16.size(),"Wrong number of points");

        assertEquals(java.util.List.of(p16), List.of(resultTC16.get(0).getPoint()), "Ray crosses sphere");

        // TC17: Ray starts at sphere and goes outside (0 points)
        List<GeoPoint> resultTC17 = sphere.findIntersections(new Ray(new Point3D(1.8, 0.6, 0),
                new Vector(1, 0, 0)));
        assertEquals( null, resultTC17,"Wrong number of points");

        // TC18: Ray starts after sphere (0 points)
        List<GeoPoint> resultTC18 = sphere.findIntersections(new Ray(new Point3D(5, 0, 0),
                new Vector(1, 0, 0)));

        assertEquals( null, resultTC18,"Wrong number of points");

        // **** Group: Ray's line is tangent to the sphere (all tests 0 points)
        // TC19: Ray starts before the tangent point
        List<GeoPoint> resultTC19 = sphere.findIntersections(new Ray(new Point3D(2, -1, 0),
                new Vector(0, 1, 0)));
        assertEquals( null, resultTC19,"Wrong number of points");

        // TC20: Ray starts at the tangent point

        List<GeoPoint> resultTC20 = sphere.findIntersections(new Ray(new Point3D(1, 1, 0),
                new Vector(1, 0, 0)));
        assertEquals( null, resultTC20,"Wrong number of points");

        // TC21: Ray starts after the tangent point
        List<GeoPoint> resultTC21 = sphere.findIntersections(new Ray(new Point3D(2, 1, 0),
                new Vector(1, 0, 0)));
        assertEquals( null, resultTC21,"Wrong number of points");

        // **** Group: Special cases
        // TC22: Ray's line is outside, ray is orthogonal to ray start to sphere's center line
        List<GeoPoint> resultTC22 = sphere.findIntersections(new Ray(new Point3D(1, 2, 0),
                new Vector(1, 0, 0)));
        assertEquals( null, resultTC21,"Wrong number of points");
    }
}


