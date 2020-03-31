package primitives;

import org.junit.Test;
import static org.junit.Assert.*;
import static primitives.Util.isZero;

/**
 * Unit tests for primitives.Vector class
 * @author reouven and raphael
 */

public class VectorTest{
    /**
     * Test method for {@link primitives.Vector#add(primitives.Vector)}.
     */
    @Test
    public void testAdd() {
        Vector v1 = new Vector(1.0, 1.0, 1.0);
        Vector v2 = new Vector(-1.0, -1.0, -1.5);

        v1 = v1.add(v2);
        assertEquals(new Vector(0.0,0.0,-0.5),v1);

        v2 = v2.add(v1);
        assertEquals(new Vector(-1.0, -1.0, -2.0),v2);

    }
    /**
     * Test method for {@link primitives.Vector#subtract(primitives.Vector)}.
     */
    @Test
    public void testSubtract() {
        Vector v1 = new Vector(1.0, 1.0, 1.0);
        Vector v2 = new Vector(-1.0, -1.0, -1.0);
        Vector v3 = new Vector(-1.0, -1.0, -1.0);

        assertEquals(new Vector(2.0,2.0,2.0),v1.subtract(v2));

        assertEquals(new Vector(-2.0, -2.0, -2.0),v2.subtract(v1));

        assertFalse(new Vector(-3.0, -2.0, -2.0)==v3.subtract(v1));
    }
    /**
     * Test method for {@link primitives.Vector#scale(double)}.
     */
    @Test
    public void testScale() {
        Vector v1 = new Vector(1.0, 1.0, 1.0);
        Vector v2 = new Vector(-1.0, -1.0, -1.0);
        Vector v3 = new Vector(-1.0, -1.5, -1.5);
        try {
            assertEquals(v1.scale(-1), v2);
        }catch(IllegalArgumentException e)
        {
            fail("(1,1,1) * -1 must be (-1,-1,-1)");
        }
        try {
            assertFalse(v1.scale(-2)== v2);
        }catch(IllegalArgumentException e)
        {
            fail("(1,1,1) * -2 must be (-2,-2,-2) and not be  (-1,-1,-1) ");
        }
        try {
            assertFalse(v1.scale(-1)== v3);
        }catch(IllegalArgumentException e)
        {
            fail("(1,1,1) * -1 must be (-1,-1,-1) and not be  (-1,-1.5,-1.5) ");
        }

    }
    /**
     * Test method for {@link primitives.Vector#dotProduct(primitives.Vector)}.
     */
    @Test
    public void testDotProduct() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(3, 2, 1);
        Vector v3 = new Vector(-2, -4, -6);

        try{
            assertTrue(v1.dotProduct(v2)==10.0);
        }catch (AssertionError e)
        {
            fail("1*3+2*2+3*1=10 and not an other result");
        }

        try{
            assertFalse(v1.dotProduct(v3)==22);
        }catch (AssertionError e)
        {
            fail("1*(-2)+2*(-4)+3*(-6)=-22 and not an other result");
        }

    }

    /**
     * Test method for {@link primitives.Vector#crossProduct(primitives.Vector)}.
     */
    @Test
    public void testCrossProduct() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(-2, -4, -6);

        // ============ Equivalence Partitions Tests ==============
        Vector v3 = new Vector(0, 3, -2);
        Vector vr = v1.crossProduct(v3);

        // Test that length of cross-product is proper (orthogonal vectors taken for simplicity)
        assertEquals("crossProduct() wrong result length", v1.length() * v3.length(), vr.length(), 0.00001);

        // Test cross-product result orthogonality to its operands
        assertTrue("crossProduct() result is not orthogonal to 1st operand", isZero(vr.dotProduct(v1)));
        assertTrue("crossProduct() result is not orthogonal to 2nd operand", isZero(vr.dotProduct(v3)));

        // =============== Boundary Values Tests ==================
        // test zero vector from cross-productof co-lined vectors
        try {
            v1.crossProduct(v2);
            fail("crossProduct() for parallel vectors does not throw an exception");
        } catch (Exception e) {}
    }


    /**
     * Test method for {@link Vector#lengthSquared()}.
     */
    @Test
    public void testLengthSquared()
    {
        Vector v1= new primitives.Vector(1.0,0.0,0.0);
        Vector v2 = new primitives.Vector(0.0,5.0,0.0);

        try{
            assertTrue(v1.lengthSquared()==1);
        }catch(IllegalArgumentException e)
        {
            fail("1²+0²+0²=1 and not an other result");
        }
        try{
            assertTrue(v2.lengthSquared()==25);
        }catch(IllegalArgumentException e)
        {
            fail("0²+5²+0²=25 and not an other result");
        }



    }
    /**
     * Test method for {@link Vector#length()}.
     */
    @Test
    public void testLength() {
        Vector v1= new primitives.Vector(1.0,0.0,0.0);
        Vector v2 = new primitives.Vector(0.0,5.0,0.0);

        try{
            assertTrue(v1.length()==1);
        }catch(IllegalArgumentException e)
        {
            fail("sqrt(1²+0²+0²)=1 and not an other result");
        }
        try{
            assertTrue(v2.length()==5);
        }catch(IllegalArgumentException e)
        {
            fail("sqrt(0²+5²+0²)=5 and not an other result");
        }
    }
    /**
     * Test method for {@link Vector#normalize()}.
     */
    @Test
    public void testNormalize() {
        Vector v = new Vector(3.5, -5, 10);
        v.normalize();
        assertEquals(1, v.length(), 1e-10);

        try {
            Vector v1 = new Vector(0, 0, 0);
            v.normalize();
            fail("Didn't throw divide by zero exception!");
        } catch (IllegalArgumentException ex) {
            assertEquals("Point3D(0,0,0) not valid for vector head", ex.getMessage());
        }
        assertTrue(true);
    }
    /**
     * Test method for {@link Vector#normalized()}.
     */
    @Test
    public void testNormalized() {

    }
}