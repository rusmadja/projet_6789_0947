package geometries;

import org.junit.Test;
import org.junit.jupiter.api.DynamicTest;
import primitives.*;

import static org.junit.Assert.*;

public class TubeTest {

    @org.junit.Test
    public void testGetNormal() {
        /**
         *  creation of the ray r1 who start from the Point (0,0,0) and have a Direction of the vector (0,2,0)
         */
        Vector v1 = new Vector(new Point3D(0,2,0));
        Ray r1 = new Ray(new Point3D(0,0,0),v1);
        /**
         * v2 is equal to the vector normal of t1 who is on the horizontal to the X axe
         */
        Point3D p3=new Point3D(1,2,0);
        Vector v2 = new Vector(new Point3D(1.0,0.0,0.0));

        Tube t1 = new Tube(2,r1 );

        try{
            System.out.println( t1.getNormal(p3).toString()+ v2.toString());

        }catch (AssertionError e)
        {
            fail(" the result need to be a Vector (1.0,0.0,0.0");
        }
    }

    }
