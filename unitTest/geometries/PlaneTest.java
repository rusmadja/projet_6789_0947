package geometries;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlaneTest {
    /**
     * @link
     */
    @Test
    public void testGetNormal() {
        geometries.Plane s1 = new Plane(new primitives.Point3D(1.0,0.0,0.0),
                new primitives.Point3D(0.0,1.0,0.0),
                new primitives.Point3D(0.0,0.0,1.0));
        geometries.Plane s2 = new Plane(new primitives.Point3D(1,1,1),
                new primitives.Point3D(1.0,1.0,0.0),
                new primitives.Point3D(1.0,0.0,0.0));

        try {
            assertEquals(s1.getNormal(new primitives.Point3D(0.0, 0.0, 1.0)), s1.getNormal(new primitives.Point3D(1.0, 0.0, 0.0)));
        }catch(IllegalArgumentException e)
        {
            fail("same plane must be have same normal ");
        }
        try {
            assertFalse(s1.getNormal(new primitives.Point3D(0.0,0.0,1.0))==s2.getNormal(new primitives.Point3D(1.0,0.0,0.0)));
        }catch(IllegalArgumentException e)
        {
            fail("isn't the same plane and must havn't the same normal ");
        }
        /**
         *
         */
        try {
            assertFalse(s2.getNormal(new primitives.Point3D(0.0,0.0,1.0)).scale(3)==s2.getNormal(new primitives.Point3D(1.0,0.0,0.0)));
        }catch(IllegalArgumentException e)
        {
            fail("same plane must be have same normal ");
        }

    }

}