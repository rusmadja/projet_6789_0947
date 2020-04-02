package geometries;

import org.junit.Test;
import primitives.Point3D;
import primitives.Vector;

import static org.junit.Assert.*;
/**
 * Testing Plane
 * @author Reouven & raphael
 *
 */
public class PlaneTest {
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

}