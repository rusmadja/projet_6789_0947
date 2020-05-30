package Private;

import elements.AmbientLight;
import elements.Camera;
import elements.Material;
import elements.SpotLight;
import geometries.Intersectable;
import geometries.Polygon;
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

public class DiamondTest {

    public void testConstructor() {
        try{
            Diamond test = new Diamond(
                    new Color(0, 0, 200),
                    new Material(0, 0, 1),
                    new Point3D(0, 0, 0), 8, 14);


        } catch (IllegalArgumentException e) {

            System.out.println(e);}

    }

    @Test
    public void findIntersections() {
        Diamond test = new Diamond(
                new Color(0, 0, 200),
                new Material(0, 0, 1),
                new Point3D(0, 0, 0), 8, 14);

        Ray ray = new Ray(new Point3D(1, 10, -20), new Vector(0, 0, 1)) ;

        List<Intersectable.GeoPoint> TesterList = test.findIntersections(ray, Double.POSITIVE_INFINITY);

        assertEquals( "bad number intersection",TesterList.size() , 2);

        assertEquals("bad number intersection",
                     List.of( TesterList.get(0).getPoint(),TesterList.get(1).getPoint()) ,
                     List.of(new Point3D(1,10,-3.19047619047619), new Point3D(1,10,2.5238095238095255)));
    }

    @Test
    public void test1_4() {
         /*
                Y axis – screen top to bottom
                X axis – screen left to right
                Z axis – view from camera into scene
        */
        Scene scene;
        scene = new Scene.SceneBuilder("Test scene")
                .addAmbientLight(new AmbientLight(Color.BLACK, 0.5))
                .addCamera(new Camera(
                        new Point3D(0, -10, -100),
                        new Vector(0, 0.2, 1),
                        new Vector(0,1 ,-0.2 )))
                .addDistance(1000)
                .addBackground(Color.BLACK)
                .build();

        scene.addGeometries( //
                             new Polygon(new Color(100, 100, 100), new Material(0, 0.8, 40),
                                         new Point3D(-150,10, -200),
                                         new Point3D(150, 10,-200),
                                         new Point3D(150, 10,2000),
                                         new Point3D(-150, 10, 2000)

                             ),
                             new Diamond(
                        new Color(115, 200, 150),
                        new Material(0, 0, 30),
                        new Point3D(0, 2, 0), 32, 28)
        );

        scene.addLights(
        new SpotLight(new Color(700, 400, 400),
                      new Point3D(0, 10, -100),
                      new Vector(0, 0, 1),
                      1, 4E-4, 2E-5));




        ImageWriter imageWriter = new ImageWriter("test1.4", 200, 200, 600, 600);
        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }

}