package Private;

import elements.*;
import geometries.Intersectable;
import geometries.Polygon;
import geometries.Triangle;
import org.junit.Test;
import primitives.Color;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

import java.util.List;

import static org.junit.Assert.*;

public class CubeTableTest {

    @Test
    public void testConstructor() {
        try{
            CubeTable test = new CubeTable(
                    new Color(0, 0, 200),
                    new Material(0, 0, 1),
                    new Point3D(0, 0, 0), 20, 10, 12,1,2);


        } catch (IllegalArgumentException e) {

            System.out.println(e);}

    }

    /**
     *
     */
    @Test
    public void TestfindIntersections() {
        CubeTable test = new CubeTable(
                new Color(0, 0, 200),
                new Material(0, 0, 1),
                new Point3D(0, 0, 0), 20, 10, 12,1,2);

        Ray ray = new Ray(new Point3D(5,0,5),new Vector(0,1,0)) ;

        List<Intersectable.GeoPoint> TesterList = test.findIntersections(ray, Double.POSITIVE_INFINITY);

        assertEquals( "bad number intersection",TesterList.size() , 2 );

        assertEquals("bad number intersection",
                List.of( TesterList.get(0).getPoint(),TesterList.get(1).getPoint()) ,
                List.of(new Point3D(5,11,5), new Point3D(5,10,5)));

    }

    /**
     *
     */
    @Test
    public void test1_3() {
         /*
                Y axis – screen top to bottom
                X axis – screen left to right
                Z axis – view from camera into scene
        */
        Scene scene;
        scene = new Scene.SceneBuilder("Test scene")
                .addAmbientLight(new AmbientLight(Color.BLACK, 0.5))
                .addCamera(new Camera(
                            new Point3D(-500, -1000, -50),
                            new Vector(0.7, 1, 0.2),
                            new Vector(1,-0.7 ,0 )))
                .addDistance(1000)
                .addBackground(Color.BLACK)
                .build();

        scene.addGeometries( //
               new Polygon(new Color(100,120,120), new Material(0, 0.8, 60),
                           new Point3D(-150,-100, -200),
                           new Point3D(150, -100,-200),
                           new Point3D(150, -100,200),
                           new Point3D(-150, -100, 200)

               ),
                 new CubeTable(
                         new Color(java.awt.Color.BLUE),
                         new Material(0.5, 0.5, 30),
                         new Point3D(20, -200, 20),
                        60, 50, 60,5,5)
        );

        scene.addLights(new SpotLight(new Color(700, 400, 400),
                                      new Point3D(0, -250, 50),
                                      new Vector(0.5, 1, 0),
                                      1, 4E-4, 2E-5));



        ImageWriter imageWriter = new ImageWriter("test1.3", 200, 200, 600, 600);
        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }

}