package geometries;

import org.junit.Test;
import primitives.Point3D;
import primitives.Vector;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testing Plane
 * @author Reouven & raphael
 *
 */
public class PlaneTest{
    /**
     Test method for
     * {@link geometries.Plane#getNormal(primitives.Point3D)}.
     */
    @Test
    public void testGetNormal() {
        geometries.Plane s1 = new Plane(new primitives.Point3D(1.0,0.0,0.0),
                new primitives.Point3D(0.0,1.0,0.0),
                new primitives.Point3D(0.0,0.0,1.0));
        geometries.Plane s2 = new Plane(new primitives.Point3D(1,1,1),
                new primitives.Point3D(1.0,1.0,0.0),
                new primitives.Point3D(1.0,0.0,0.0));

        // creation of a plate plan like a table with a Vector normal who need to be (0,1,0) perpendicular to the the X and Z axes
        geometries.Plane table = new Plane(new primitives.Point3D(0,0,0),
                new primitives.Point3D(1.0,0.0,0.0),
                new primitives.Point3D(0.0,0.0,1.0));
        Vector normalOfTable = new Vector(0.0,1.0,0.0);

        try {
            assertEquals(s1.getNormal(new primitives.Point3D(0.0, 0.0, 1.0)), s1.getNormal(new primitives.Point3D(1.0, 0.0, 0.0)));
        }catch(AssertionError e)
        {
            fail("same plane must be have same normal ");
        }

        try {
            assertFalse(s1.getNormal(new primitives.Point3D(0.0,0.0,1.0))==s2.getNormal(new primitives.Point3D(1.0,0.0,0.0)));
        }catch(AssertionError e)
        {
            fail("isn't the same plane and must have not the same normal ");
        }
        /**
         *
         */
        try {
            assertFalse(s2.getNormal(new primitives.Point3D(0.0,0.0,1.0)).scale(3)==s2.getNormal(new primitives.Point3D(1.0,0.0,0.0)));
        }catch(AssertionError e)
        {
            fail("same plane must have same normal ");
        }

        /**
         * Test if the vector normal of the "table" (who on the X and Z axe) is a Vector who is on the Y axe any Vector (0.0,1.0,0.0) or a scale of it.
         */
        try{
            assertEquals(table._normal,normalOfTable.scale(-1));
        }catch(AssertionError e)
        {
            fail("the vector of the plane table need to be (0.0,1.0,0.0)" );
        }

    }

    @org.junit.Test
    public void findIntsersections() {
        geometries.Plane s1 = new Plane(new primitives.Point3D(1.0,0.0,0.0),
                new primitives.Point3D(0.0,0.0,0.0),
                new primitives.Point3D(0.0,0.0,1.0));
        //EP: The Ray must be neither orthogonal nor parallel to the plane
        //• Ray intersects the plane
        primitives.Ray EP11 = new primitives.Ray(new primitives.Point3D(-1.0,-1.0,0.0), new primitives.Vector(1.0,1.0,0.0));
        java.util.List<primitives.Point3D> resultEP11 = s1.findIntsersections(EP11);
        
        assertEquals( 1, resultEP11.size(),"Wrong number of points");

        assertEquals(java.util.List.of(new primitives.Point3D(0,0,0)), resultEP11, "Ray crosses Plane");
        //• Ray does not intersect the plane
        primitives.Ray EP12 = new primitives.Ray(new primitives.Point3D(5.0,5.0,0.0), new primitives.Vector(1.0,1.0,0.0));
        java.util.List<primitives.Point3D> resultEP12 = s1.findIntsersections(EP12);
        
        assertEquals( 0, resultEP12.size(),"Wrong number of points");
        
        //BVA: 7 cases
        //• Ray is parallel to the plane
        //• Two cases – the ray included  
        primitives.Ray EP211 = new primitives.Ray(new primitives.Point3D(0.0,0.0,0.0), new primitives.Vector(1.0,0.0,0.0));
        try{
            java.util.List<primitives.Point3D> resultEP211 = s1.findIntsersections(EP211);
            // if not reject Arithmetic exception that's mean that the ray is not parallel to the plane
            // and so it's reject a fail test
            fail("must be parallel because the ray is inside the plane ");
        }
        catch(ArithmeticException Ae) {}


        //not included in the plane
        primitives.Ray EP212 = new primitives.Ray(new primitives.Point3D(0.0,1.0,0.0), new primitives.Vector(1.0,0.0,0.0));
        try {
            java.util.List<primitives.Point3D> resultEP212 = s1.findIntsersections(EP212);
            // if not reject Arithmetic exception that's mean that the ray is not parallel to the plane
            // and so it's reject a fail test
            fail("must be parallel ");
        }
        catch(ArithmeticException Ae) {}

        //• Ray is orthogonal to the plane
        //• Three cases – according to 𝑃0 (before, in, after the plane)
        //========================BEFORE========================//
        primitives.Ray EP221 = new primitives.Ray(new primitives.Point3D(0.0,-1.0,0.0), new primitives.Vector(0.0,5.0,0.0));
        java.util.List<primitives.Point3D> resultEP221 = s1.findIntsersections(EP221);

        assertEquals( 1, resultEP221.size(),"Wrong number of points");

        assertEquals(java.util.List.of(new primitives.Point3D(0,0,0)), resultEP221, "Ray crosses Plane");
        //======================== AFTER ========================//
        primitives.Ray EP222 = new primitives.Ray(new primitives.Point3D(0.0,1.0,0.0), new primitives.Vector(0.0,5.0,0.0));
        java.util.List<primitives.Point3D> resultEP222 = s1.findIntsersections(EP222);

        assertEquals( 0, resultEP222.size(),"Wrong number of points");

        //======================== IN ========================//
        primitives.Ray EP223 = new primitives.Ray(new primitives.Point3D(0.0,0.0,0.0), new primitives.Vector(0.0,5.0,0.0));
        java.util.List<primitives.Point3D> resultEP223 = s1.findIntsersections(EP223);

        assertEquals( 0, resultEP223.size(),"Wrong number of points");

        //• Ray is neither orthogonal nor parallel to and begins at the plane(𝑃0 is in the plane, but not the ray)

        //======================== IN ========================//
        primitives.Ray EP23 = new primitives.Ray(new primitives.Point3D(1.0,0.0,0.0), new primitives.Vector(5.0,5.0,0.0));
        java.util.List<primitives.Point3D> resultEP23 = s1.findIntsersections(EP23);

        assertEquals( 0, resultEP23.size(),"Wrong number of points");

        //• Ray is neither orthogonal nor parallel to the plane and begins in the same point which appears as reference point in the plane (Q)
        //======================== IN ========================//
        primitives.Ray EP24 = new primitives.Ray(new primitives.Point3D(1.0,0.0,0.0), new primitives.Vector(5.0,5.0,0.0));
        java.util.List<primitives.Point3D> resultEP24 = s1.findIntsersections(EP24);

        assertEquals( 0, resultEP24.size(),"Wrong number of points");
    }
}