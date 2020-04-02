package geometries;

import primitives.*;

import static org.junit.Assert.*;
/**
 * Testing Cylinder FINITE
 * @author Reouven & raphael
 *
 */
public class CylinderTest {

    // THE CONSTRUCTION OF THE CYLINDER//
    /** the Cylinder has a radius of 1 and his axis on the Y axe  that's mean like a tube who is standing on a table
     *  his vector normal is parallel to the table ( the table as for base the X axe )
     *
     *  creation of the ray r1 who start from the Point (0,0,0) and have a Direction of the vector (0,2,0)
     */
    Vector v1 = new Vector(new Point3D(0,2,0));
    Ray r1 = new Ray(new Point3D(0,0,0),v1);
    /**
     * v2 is equal to the vector normal of c1 who is on the horizontal to the X axe
     */
    Point3D p3=new Point3D(1,2,0);
    Vector v2 = new Vector(new Point3D(1.0,0.0,0.0));

    Cylinder c1 = new Cylinder(1,r1,4 );


    /**
     * Test method for {@link geometries.Cylinder#getNormal(primitives.Point3D)}.
     */
    @org.junit.Test
    public void testGetNormal_valid() {

        try{
            assertEquals( c1.getNormal(p3),v2);

        }catch (AssertionError e)
        {
            fail(" the result need to be a Vector (1,0,0)");
        }


    }
    @org.junit.Test
    public void testGetNormal_invalid(){
        //we use an invalid Vector in order to verify if its reject an exception

        try{
            assertEquals(c1.getNormal(p3), new Vector(1,1,0));
            System.out.println(c1.getNormal(p3).toString() );
        }
        catch (AssertionError e)
        {
            // if an error has rejected here that's mean that the the two vectors are different
            return;
        }

        // if no error are catch that's mean that the assertEqual run well
        // and the two vectors are the same and they need to be different
        fail( "the two vectors are the same" );
    }

    }
