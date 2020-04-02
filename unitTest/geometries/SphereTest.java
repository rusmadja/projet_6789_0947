package geometries;

import org.junit.Test;
import primitives.*;

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

}


