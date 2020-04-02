package geometries;

import primitives.Point3D;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

/**
 * Testing Triangle
 * @author Reouven & raphael
 *
 */
public class TriangleTest{
    /**
     * Test method for
     * {@link geometries.Triangle#getNormal(primitives.Point3D)}.
     *
     */
    @org.junit.Test
    public void testGetNormal() {
        geometries.Triangle s1 = new Triangle(new primitives.Point3D(1.0,0.0,0.0),
                new primitives.Point3D(0.0,1.0,0.0),
                new primitives.Point3D(0.0,0.0,1.0));
        geometries.Triangle s2 = new Triangle(new primitives.Point3D(1,1,1),
                new primitives.Point3D(1.0,1.0,0.0),
                new primitives.Point3D(1.0,0.0,0.0));
        try {
            assertEquals(s1.getNormal(new primitives.Point3D(0.0, 0.0, 1.0)), s1.getNormal(new primitives.Point3D(1.0, 0.0, 0.0)));
        }catch(AssertionError  e)
        {
            fail("same Triangle must be have same normal ");
        }
        try {
            assertFalse(s1.getNormal(new primitives.Point3D(0.0,0.0,1.0))==s2.getNormal(new primitives.Point3D(1.0,0.0,0.0)));
        }catch(AssertionError e)
        {
            fail("isn't the same triangle and must have not the same normal ");
        }


    }
}