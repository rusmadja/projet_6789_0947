package geometries;

import primitives.Point3D;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @org.junit.Test
    public void findIntsersections() {
        Triangle triangle = new Triangle(new Point3D(5,5,0),
                new Point3D(10,0,0),
                new Point3D(0,0,0));
        //===========================================================//
        //===================EP: Three cases:=======================//
        // TC01: Inside triangle (1 point)

        // TC02:  Outside against edge (0 point)

        // TC02: Outside against vertex (0 points)
        //===========================================================//
        //===BVA: Three cases (the ray begins "before" the plane)===//

        // TC11:  On edge (0 points)

        // TC12: In vertex (0 points)

        // TC13: On edge's continuation (0 points)

    }
}