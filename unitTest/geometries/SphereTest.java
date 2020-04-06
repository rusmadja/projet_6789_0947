package geometries;
import  static primitives.Util.*;
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
     * Test method for {@link Sphere#findIntsersections(Ray)}.
     */

    @org.junit.Test
    public void findIntsersections() {
        geometries.Sphere sphere = new geometries.Sphere(1d, new primitives.Point3D(1, 0, 0));

        // ============ Equivalence Partitions Tests ==============

        // TC01: Ray's line is outside the sphere (0 points)
        assertEquals(null, sphere.findIntsersections(new primitives.Ray(new primitives.Point3D(-1, 0, 0), new primitives.Vector(1, 1, 0))),
                "Ray's line out of sphere");

        // TC02: Ray starts before and crosses the sphere (2 points)
        primitives.Point3D p1 = new primitives.Point3D(0.0651530771650466, 0.355051025721682, 0);
        primitives.Point3D p2 = new primitives.Point3D(1.53484692283495, 0.844948974278318, 0);
        List<primitives.Point3D> result = sphere.findIntsersections(new primitives.Ray(new primitives.Point3D(-1, 0, 0),
                new primitives.Vector(3, 1, 0)));
        assertEquals( 2, result.size(),"Wrong number of points");
        if (result.get(0).get_x().get() > result.get(1).get_x().get())
        {
            result = java.util.List.of(result.get(1), result.get(0));
        }
        assertEquals(java.util.List.of(p1, p2), result, "Ray crosses sphere");

        // TC03: Ray starts inside the sphere (1 point)...
        // TC04: Ray starts after the sphere (0 points)...

        // =============== Boundary Values Tests ==================

        // **** Group: Ray's line crosses the sphere (but not the center)
        // TC11: Ray starts at sphere and goes inside (1 points)
        // TC12: Ray starts at sphere and goes outside (0 points)

        // **** Group: Ray's line goes through the center
        // TC13: Ray starts before the sphere (2 points)
        // TC14: Ray starts at sphere and goes inside (1 points)
        // TC15: Ray starts inside (1 points)
        // TC16: Ray starts at the center (1 points)
        // TC17: Ray starts at sphere and goes outside (0 points)
        // TC18: Ray starts after sphere (0 points)

        // **** Group: Ray's line is tangent to the sphere (all tests 0 points)
        // TC19: Ray starts before the tangent point
        // TC20: Ray starts at the tangent point
        // TC21: Ray starts after the tangent point

        // **** Group: Special cases
        // TC19: Ray's line is outside, ray is orthogonal to ray start to sphere's center line

    }
}


