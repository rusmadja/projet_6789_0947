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

public class EscalierColiTest {

    @Test
    public void testConstructor() {
        try {
            EscalierColi test = new EscalierColi(
                    new Color(0, 0, 200),
                    new Material(0, 0, 1),
                    new Point3D(0, 0, 0),

                    48,16,1);


        } catch (IllegalArgumentException e) {

            System.out.println(e);
        }

    }


    @Test
    public void TestfindIntersections() {
        EscalierColi test = new EscalierColi(
                new Color(0, 0, 200),
                new Material(0, 0, 1),
                new Point3D(0, 0, 0),
                48,16,1);

        Ray ray = new Ray(new Point3D(7, 4.5, -30), new Vector(0, 0, 1));

        List<Intersectable.GeoPoint> TesterList = test.findIntersections(ray, Double.POSITIVE_INFINITY);

        assertEquals("bad number intersection", TesterList.size(), 2);

    /*    assertEquals("bad number intersection",
                     List.of(TesterList.get(0).getPoint(), TesterList.get(1).getPoint()),
                     List.of(new Point3D(25.0, 2.0, 12.5), new Point3D(25.0, 2.0, 37.5)));
    */}

    @Test
    public void test1_6() {
         /*
                Y axis – screen top to bottom
                X axis – screen left to right
                Z axis – view from camera into scene
        */
        Scene scene;
        scene = new Scene.SceneBuilder("Test scene")
                .addAmbientLight(new AmbientLight(Color.BLACK, 0.5))
                .addCamera(new Camera(
                        new Point3D(0, 10, -200),
                        new Vector(0, 0, 1),
                        new Vector(0, 1, 0)))
                .addDistance(1000)
                .addBackground(Color.BLACK)
                .build();

        scene.addGeometries( //
                             new Polygon(new Color(100, 100, 100), new Material(0, 0.8, 40),
                                         new Point3D(-150, -30, -200),
                                         new Point3D(150, -30, -200),
                                         new Point3D(150, 50, 2000),
                                         new Point3D(-150, 50, 2000)

                             ),
                             new EscalierColi(
                                     new Color(100, 200, 200),
                                     new Material(0, 0, 1),
                                     new Point3D(0, 0, 0),
                                     48,16,1)
        );

        scene.addLights(
                new SpotLight(new Color(700, 400, 400),
                              new Point3D(0, 10, -100),
                              new Vector(0, 0, 1),
                              1, 4E-4, 2E-5));


        ImageWriter imageWriter = new ImageWriter("test1.6", 200, 200, 600, 600);
        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }
}