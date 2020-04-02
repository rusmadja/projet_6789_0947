package geometries;

import org.junit.Test;
import org.junit.jupiter.api.DynamicTest;
import primitives.*;
/**
 * Testing Tube
 * @author Reouven & raphael
 */
import static org.junit.Assert.*;

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

    }
