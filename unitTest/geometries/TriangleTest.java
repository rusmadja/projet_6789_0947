package geometries;

import geometries.Intersectable.GeoPoint;
import primitives.Point3D;

import java.util.List;

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
        Triangle triangle = new Triangle(new Point3D(0,0,0),
                new Point3D(1,2,0),
                new Point3D(2,0,0));
        //===========================================================//
        //===================EP: Three cases:=======================//
        // TC01: Inside triangle (1 point)
        primitives.Ray TC01 = new primitives.Ray(new primitives.Point3D(1.0,1.0,-1.0), new primitives.Vector(0.0,0.0,1.0));
        List<GeoPoint> resultTC01 = triangle.findIntersections(TC01);

        assertEquals( 1, resultTC01.size(),"Wrong number of points");

        assertEquals(new primitives.Point3D(1,1,0), resultTC01.get(0).getPoint(), "Ray crosses Triangle");
        // TC021:  Outside against edge (0 point)
        primitives.Ray TC021 = new primitives.Ray(new primitives.Point3D(2.0,1.0,-1.0), new primitives.Vector(0.0,0.0,1.0));
        List<GeoPoint> resultTC021 = triangle.findIntersections(TC021);

        assertEquals( null, resultTC021,"Wrong number of points");

        // TC022: Outside against vertex (0 points)
        primitives.Ray TC022 = new primitives.Ray(new primitives.Point3D(2.0,-0.5,-1.0), new primitives.Vector(0.0,0.0,1.0));
        List<GeoPoint> resultTC022 = triangle.findIntersections(TC022);

        assertEquals( null, resultTC022,"Wrong number of points");

        //===========================================================//
        //===BVA: Three cases (the ray begins "before" the plane)===//

        // TC11:  On edge (0 points)
        primitives.Ray TC11 = new primitives.Ray(new primitives.Point3D(1.0,0.0,-1.0), new primitives.Vector(0.0,0.0,1.0));
        List<GeoPoint> resultTC11 = triangle.findIntersections(TC11);

        assertEquals( null, resultTC11,"Wrong number of points");

        // TC12: In vertex (0 points)
        primitives.Ray TC12 = new primitives.Ray(new primitives.Point3D(1.0,2.0,-1.0), new primitives.Vector(0.0,0.0,1.0));
        List<GeoPoint> resultTC12 = triangle.findIntersections(TC12);

        assertEquals( null, resultTC12,"Wrong number of points");

        // TC13: On edge's continuation (0 points)
        primitives.Ray TC13 = new primitives.Ray(new primitives.Point3D(1.0,2.0,-1.0), new primitives.Vector(0.0,0.0,1.0));
        List<GeoPoint> resultTC13 = triangle.findIntersections(TC13);

        assertEquals( null, resultTC13,"Wrong number of points");


    }
}