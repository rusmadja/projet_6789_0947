package Private;

import elements.AmbientLight;
import elements.Camera;
import elements.Material;
import elements.SpotLight;
import geometries.Intersectable;
import geometries.Polygon;
import geometries.Sphere;
import geometries.Triangle;
import org.junit.Test;
import primitives.Color;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Wolf_1Test {

    @Test
    public void testConstructor() {
        try{
            List<Triangle> list = new ArrayList<Triangle>();
            Color emissionLight = new Color(0, 0, 200);
            Material material=    new Material(0, 0, 1);
            Wolf_1 test = new Wolf_1(
                    new Color(0, 0, 200),
                    new Material(0, 0, 1));




        } catch (IllegalArgumentException e) {

            System.out.println(e);}

    }
    @Test
    public void findIntersections() {
        Wolf_1 test = new Wolf_1(
                new Color(0, 0, 200),
                new Material(0, 0, 1));
        Ray ray = new Ray(new Point3D(0,0,-1000),new Vector(0,0,1)) ;

        List<Intersectable.GeoPoint> TesterList = test.findIntersections(ray, Double.POSITIVE_INFINITY);

        assertEquals( "bad number intersection",TesterList.size() , 1 );


    }

    @Test
    public void test1_8() {
         /*
                Y axis – screen top to bottom
                X axis – screen left to right
                Z axis – view from camera into scene
        */
        Scene scene;
        scene = new Scene.SceneBuilder("Test scene")
                .addAmbientLight(new AmbientLight(Color.BLACK, 0.5))
                /*.addCamera(new Camera(
                        new Point3D(-1000, 50, -1000),
                        new Vector(1, 0, 1),
                        new Vector(0,1 ,0 )))*/
               /* .addCamera(new Camera( // vue de face
                        new Point3D(0, 50, -8000),
                        new Vector(0, 0, 1),
                        new Vector(0,1 ,0 )))*/
                .addCamera(new Camera( // vue de profile
                        new Point3D(-8000, 50, 0),
                        new Vector(1, 0, 0),
                        new Vector(0,1 ,0 )))
                .addDistance(2000)
                .addBackground(Color.BLACK)
                .build();

        scene.addGeometries( //
                             new Sphere(new Color(100, 120, 120), new Material(0, 0.8, 60,1,0),200,
                                        new Point3D(0, 112.7280955, -13.568478)),

                             new Cube(new Color(100, 120, 120), new Material(0, 0.8, 60),
                                        new Point3D(-200, -160, -220), 400, 159.59,420),

                             new Wolf_1(
                                  new Color(167, 103, 38),
                                 new Material(0, 0, 30)),
                             new Wolf_2(
                                     new Color(167, 103, 38),
                                    new Material(0, 0, 30))

        );

        scene.addLights(new SpotLight(new Color(700, 400, 400),
                                      new Point3D(0, -250, 50),
                                      new Vector(0.5, 1, 0),
                                      1, 4E-4, 2E-5));



        ImageWriter imageWriter = new ImageWriter("test1.8", 200, 200, 600, 600);
        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();


    }
}