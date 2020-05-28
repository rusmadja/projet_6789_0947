package Private;

import elements.AmbientLight;
import elements.Camera;
import elements.Material;
import elements.SpotLight;
import geometries.Intersectable.GeoPoint;
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

import static org.junit.Assert.assertEquals;


public class CubeTest {

    @Test
    public void testConstructor() {
        try{
            Cube test = new Cube(
                    new Color(0, 0, 200),
                    new Material(0, 0, 1),
                    new Point3D(0, 0, 0), 4, 4, 4);


        } catch (IllegalArgumentException e) {

        System.out.println(e);}

    }


    @Test
    public void TestfindIntersections() {
        Cube test = new Cube(
                new Color(0, 0, 200),
                new Material(0, 0, 1),
                new Point3D(0, 0, 0), 4, 4, 4);
        Ray ray = new Ray(new Point3D(2,2,-2),new Vector(0,0,1)) ;

        List<GeoPoint> TesterList = test.findIntersections(ray, Double.POSITIVE_INFINITY);

        assertEquals( "bad number intersection",TesterList.size() , 2 );

        assertEquals("bad number intersection",
                List.of( TesterList.get(0).getPoint(),TesterList.get(1).getPoint()) ,
                List.of(new Point3D(2,2,4), new Point3D(2,2,0)));
    }


    @Test
    public void test1_1() {
        /*
                Y axis – screen top to bottom
                X axis – screen left to right
                Z axis – view from camera into scene
        */
        Scene scene = new Scene.SceneBuilder("Test scene")
                .addCamera(
                        new Camera(
                                new Point3D(50, -20, -500),
                                new Vector(0, 0.1, 1),
                                new Vector(-1, -1, 0.1)))
                .addDistance(1000)
                .addAmbientLight(new AmbientLight(new Color(java.awt.Color.BLUE), 0.15))
                .addBackground(Color.BLACK)
                .build();
        scene.addGeometries(
                new Cube(
                        new Color(200,200,100),
                        new Material(0.5, 0.5, 60 , 1,0),
                        new Point3D(0,0,0),
                        50,50,100)
        );
        scene.addLights(new SpotLight(new Color(700, 400, 400), //
                new Point3D(60, -50, 0), new Vector(0, 0, 1), 1, 4E-5, 2E-7));

        ImageWriter imageWriter = new ImageWriter("test1.0", 200, 200, 600, 600);
        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }
    @Test
    public void test1_2() {
        Scene scene;
        scene = new Scene.SceneBuilder("Test scene")
                .addAmbientLight(new AmbientLight(Color.BLACK, 0))
                .addCamera(new Camera(
                        new Point3D(-1100, -1100, -1000),
                        new Vector(1, 1, 1),
                        new Vector(0, -1, 1)))
                .addDistance(1000)
                .addBackground(Color.BLACK)
                .build();

        scene.addGeometries( //
              /*  new Triangle(Color.BLACK, new Material(0, 0.8, 60), //
                        new Point3D(-150, 150, 115), new Point3D(150, 150, 135), new Point3D(75, -75, 150)), //
                new Triangle(Color.BLACK, new Material(0, 0.8, 60), //
                        new Point3D(-150, 150, 115), new Point3D(-70, -70, 140), new Point3D(75, -75, 150)), */ //
                new Cube(new Color(java.awt.Color.BLUE),
                        new Material(0.5, 0.5, 30),
                        new Point3D(0, 0, 115),
                        100,100,100));

        scene.addLights(new SpotLight(new Color(700, 400, 400), //
                new Point3D(40, -40, -115), new Vector(-1, 1, 4), 1, 4E-4, 2E-5));

        scene.addLights(new SpotLight(new Color(700, 400, 400), //
                new Point3D(35, -40, 175), new Vector(0, 1, 0), 1, 4E-4, 2E-5));

       // scene.addLights(new SpotLight(new Color(700, 400, 400), //
       //         new Point3D(-50, 0, 150), new Vector(0, 1, 0), 1, 4E-4, 2E-5));

        ImageWriter imageWriter = new ImageWriter("test1.2", 200, 200, 600, 600);
        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }
}
