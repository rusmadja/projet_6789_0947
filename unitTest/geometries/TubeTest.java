package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testing Tube
 *
 * @author Reouven & raphael
 */

public class TubeTest {

    // THE CONSTRUCTION OF THE TUBE //

    /** the tube has a radius of 1 and his axis on the Y axe  that's mean like a tube who is standing on a table
     *  his vector normal is parallel to the table ( the table as for base the X axe )
     *
     *  creation of the ray r1 who start from the Point (0,0,0) and have a Direction of the vector (0,2,0)
     */
    Vector v1 = new Vector(new Point3D(0,1,0));
    Ray r1 = new Ray(new Point3D(0,0,0),v1);
    /**
     * v2 is equal to the vector normal of t1 who is on the horizontal to the X axe
     */
    Point3D p3=new Point3D(1,2,0);
    Vector v2 = new Vector(new Point3D(1.0,0.0,0.0));


    /**
     * Test method for {@link geometries.Cylinder#getNormal(primitives.Point3D)}.
     */
    @org.junit.Test
    public void testGetNormal() {

        Tube t1 = new Tube(1,r1 );

        try{
            assertEquals( t1.getNormal(p3), v2);

        }catch (AssertionError e)
        {
            fail(" the result need to be a Vector (1.0,0.0,0.0");
        }
    }
    /**
     * Test method for {@link geometries.Cylinder#findIntsersections(Ray)}.
     * imagine a bottle standing on a table with a radius of 1
     */
    @org.junit.Test
    public void testFindIntsersections() {

        geometries.Tube tube = new geometries.Tube(1, new primitives.Ray(new primitives.Point3D(0,0,0),new primitives.Vector(0,5,0)));

        // ============ Equivalence Partitions Tests ==============

        // TC01: Ray's line is outside the tube (0 points)

        primitives.Ray TC01= new primitives.Ray(new primitives.Point3D(-2,0,0),new primitives.Vector(0,5,0));
        java.util.List<primitives.Point3D> resultTC01 = tube.findIntsersections(TC01);

         assertEquals(0,resultTC01.size());

        // TC02: Ray starts before and crosses the tube (2 points)

        primitives.Ray TC02 = new primitives.Ray(new primitives.Point3D(-2,0,0.8),new primitives.Vector(3,0,0));
        java.util.List<primitives.Point3D> resultTC02 = tube.findIntsersections(TC02);

        assertEquals(2,resultTC02.size());
        primitives.Point3D p1 = new primitives.Point3D(-0.5999999999999996,0.0,0.8);
        primitives.Point3D p2 = new primitives.Point3D(0.5999999999999996,0.0,0.8);
        assertEquals(java.util.List.of(p1,p2),resultTC02);

        // TC03: Ray starts inside the tube (1 point)
        primitives.Ray TC03= new primitives.Ray(new primitives.Point3D(0.5,0,0.8),new primitives.Vector(5,0,0));
        java.util.List<primitives.Point3D> resultTC03 = tube.findIntsersections(TC03);

        assertEquals(1,resultTC03.size());

        primitives.Point3D p3 = new primitives.Point3D(0.5999999999999999,0.0,0.8);
        assertEquals(java.util.List.of(p3),resultTC03);

        // TC04: Ray starts after the tube (0 points)...
        primitives.Ray TC04= new primitives.Ray(new primitives.Point3D(2,0,0),new primitives.Vector(5,0,0));
        java.util.List<primitives.Point3D> resultTC04 = tube.findIntsersections(TC04);

        assertEquals(0,resultTC04.size());

        // =============== Boundary Values Tests ==================

        // **** Group: Ray's line crosses the tube (but not the center)
        // TC11: Ray starts at tube and goes inside (1 points)
        primitives.Ray TC11= new primitives.Ray(new primitives.Point3D(-1,0,0),new primitives.Vector(3,0,1));
        java.util.List<primitives.Point3D> resultTC11 = tube.findIntsersections(TC11);

        assertEquals(1,resultTC11.size());

        primitives.Point3D p4 = new primitives.Point3D(0.7999999999999996,0.0,0.6);
        assertEquals(java.util.List.of(p4),resultTC11);
        
        // TC12: Ray starts at tube and goes outside (0 points)
        primitives.Ray TC12= new primitives.Ray(new primitives.Point3D(1,0,0),new primitives.Vector(3,0,1));
        java.util.List<primitives.Point3D> resultTC12 = tube.findIntsersections(TC12);

        assertEquals(0,resultTC12.size());
        
        // **** Group: Ray's line goes through the center
        // TC13: Ray starts before the tube (2 points)
        primitives.Ray TC13 = new primitives.Ray(new primitives.Point3D(0,0,-2),new primitives.Vector(0,0,5));
        java.util.List<primitives.Point3D> resultTC13 = tube.findIntsersections(TC13);

        assertEquals(2,resultTC13.size());
        primitives.Point3D p5 = new primitives.Point3D(0.0,0.0,-1.0);
        primitives.Point3D p6 = new primitives.Point3D(0.0,0.0,1.0);
        assertEquals(java.util.List.of(p5,p6),resultTC13);
        
        // TC14: Ray starts at tube and goes inside (1 points)
        primitives.Ray TC14= new primitives.Ray(new primitives.Point3D(-1,0,0),new primitives.Vector(3,0,0));
        java.util.List<primitives.Point3D> resultTC14 = tube.findIntsersections(TC14);

        assertEquals(1,resultTC14.size());

        primitives.Point3D p7 = new primitives.Point3D(1.0,0.0,0.0);
        assertEquals(java.util.List.of(p7),resultTC14);

        // TC15: Ray starts inside (1 points)
        primitives.Ray TC15= new primitives.Ray(new primitives.Point3D(0,0,-0.5),new primitives.Vector(0,0,2));
        java.util.List<primitives.Point3D> resultTC15 = tube.findIntsersections(TC15);

        assertEquals(1,resultTC15.size());

        primitives.Point3D p8 = new primitives.Point3D(0.0,0.0,1.0);
        assertEquals(java.util.List.of(p8),resultTC15);
        
        // TC16: Ray starts at the center (1 points)
        primitives.Ray TC16= new primitives.Ray(new primitives.Point3D(0,0,0),new primitives.Vector(0,0,2));
        java.util.List<primitives.Point3D> resultTC16 = tube.findIntsersections(TC16);

        assertEquals(1,resultTC16.size());

        primitives.Point3D p9 = new primitives.Point3D(0.0,0.0,1.0);
        assertEquals(java.util.List.of(p9),resultTC16);

        // TC17: Ray starts at tube and goes outside (0 points)
        primitives.Ray TC17= new primitives.Ray(new primitives.Point3D(1,0,0),new primitives.Vector(5,0,0));
        java.util.List<primitives.Point3D> resultTC17 = tube.findIntsersections(TC17);

        assertEquals(0,resultTC17.size());


        // TC18: Ray starts after tube (0 points)

        primitives.Ray TC18= new primitives.Ray(new primitives.Point3D(5,0,0),new primitives.Vector(5,0,0));
        java.util.List<primitives.Point3D> resultTC18 = tube.findIntsersections(TC18);

        assertEquals(0,resultTC18.size());

        // **** Group: Ray's line is tangent to the tube (all tests 0 points)
        // TC19: Ray starts before the tangent point
        primitives.Ray TC19= new primitives.Ray(new primitives.Point3D(1,5,-1),new primitives.Vector(0,0,5));

        java.util.List<primitives.Point3D> resultTC19 = tube.findIntsersections(TC19);
       
        assertEquals(0,resultTC19.size());

        // TC20: Ray starts at the tangent point
        primitives.Ray TC20= new primitives.Ray(new primitives.Point3D(1,0,0),new primitives.Vector(0,0,5));

        java.util.List<primitives.Point3D> resultTC20 = tube.findIntsersections(TC20);

        assertEquals(0,resultTC20.size());
        // TC21: Ray starts after the tangent point
        primitives.Ray TC21= new primitives.Ray(new primitives.Point3D(1,0,2),new primitives.Vector(0,0,5));

        java.util.List<primitives.Point3D> resultTC21 = tube.findIntsersections(TC21);

        assertEquals(0,resultTC21.size());
        // **** Group: Special cases
        // TC22: Ray's line is outside, ray is orthogonal to ray start to tube's center line
        primitives.Ray TC22= new primitives.Ray(new primitives.Point3D(2,0,0),new primitives.Vector(0,0,5));

        java.util.List<primitives.Point3D> resultTC22 = tube.findIntsersections(TC22);
        assertEquals( 0, resultTC22.size(),"Wrong number of points");

    }

}
