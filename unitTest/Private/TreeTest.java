//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package Private;

import elements.AmbientLight;
import elements.Camera;
import elements.Material;
import elements.PointLight;
import elements.SpotLight;
import geometries.Intersectable;
import geometries.Polygon;
import geometries.Sphere;
import geometries.Intersectable.GeoPoint;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import primitives.Color;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;
import scene.Scene.SceneBuilder;

public class TreeTest {
    public TreeTest() {
    }

    @Test
    public void testConstructor() {
        try {
            new ArrayList();
            new Color(0.0D, 0.0D, 200.0D);
            new Material(0.0D, 0.0D, 1);
            new Tree(new Color(0.0D, 0.0D, 200.0D), new Material(0.0D, 0.0D, 1), new Point3D(0.0D, 0.0D, 0.0D), 1.0D);
        } catch (IllegalArgumentException var5) {
            System.out.println(var5);
        }

    }

    @Test
    public void findIntersections() {
        Tree test = new Tree(new Color(0.0D, 0.0D, 200.0D), new Material(0.0D, 0.0D, 1), new Point3D(0.0D, 0.0D, 0.0D), 1.0D);
        Ray ray = new Ray(new Point3D(0.0D, 0.0D, -1000.0D), new Vector(0.0D, 0.0D, 1.0D));
        List<GeoPoint> TesterList = test.findIntersections(ray, 1.0D / 0.0);
        Assert.assertEquals("bad number intersection", (long)TesterList.size(), 1L);
    }

    @Test
    public void test1_9() {
        Scene scene = (new SceneBuilder("Test scene"))
                .addAmbientLight(new AmbientLight(Color.BLACK, 0.5D))
                .addCamera(new Camera(new Point3D(1499.0D, 600.0D, 1559.0D),
                                      new Vector(-1.0D, -0.25D, -1.0D),
                                      new Vector(-0.25D, 2.0D, -0.25D)))
                .addDistance(500.0D).addBackground(Color.BLACK).build();
        scene.addGeometries(new Intersectable[]{
                new Wolf_1(new Color(60.0D, 60.0D, 60.0D),
                           new Material(0.5D, 0.5D, 30),
                           new Point3D(0.0D, 0.0D, 0.0D), 1.0D),
                new Wolf_2(new Color(80.0D, 80.0D, 80.0D),
                           new Material(0.0D, 0.0D, 30),
                           new Point3D(0.0D, 0.0D, 0.0D), 1.0D),
                new Wolf_3(new Color(100.0D, 100.0D, 100.0D),
                           new Material(0.0D, 0.0D, 30),
                           new Point3D(0.0D, 0.0D, 0.0D), 1.0D),
                new Tree(new Color(136.0D, 66.0D, 29.0D),
                         new Material(0.0D, 0.0D, 30),
                         new Point3D(-200.0D, 0.0D, -200.0D), 2.5D),
                new Tree_2(new Color(52.0D, 201.0D, 36.0D),
                           new Material(0.0D, 0.0D, 30),
                           new Point3D(-200.0D, 0.0D, -200.0D), 2.5D),
                new Tree_3(new Color(52.0D, 180.0D, 36.0D),
                           new Material(0.0D, 0.0D, 30),
                           new Point3D(-200.0D, 0.0D, -200.0D), 2.5D),
                new Polygon(new Color(130.0D, 192.0D, 130.0D),
                            new Material(0.5D, 0.5D, 30, 0.0D, 0.1D),
                            new Point3D[]{new Point3D(-1500.0D, 0.0D, -1560.0D),
                                    new Point3D(-1500.0D, 0.0D, 1560.0D),
                                    new Point3D(1500.0D, 0.0D, 1560.0D),
                                    new Point3D(1500.0D, 0.0D, -1560.0D)}),
                new Polygon(new Color(16.0D, 52.0D, 166.0D),
                            new Material(0.5D, 0.5D, 20, 0.5D, 0.0D),
                            new Point3D[]{new Point3D(-1500.0D, 0.0D, -1560.0D),
                                    new Point3D(-1500.0D, 1500.0D, -1560.0D),
                                    new Point3D(1500.0D, 1500.0D, -1560.0D),
                                    new Point3D(1500.0D, 0.0D, -1560.0D)}),
                new Polygon(new Color(16.0D, 52.0D, 166.0D),
                            new Material(0.5D, 0.5D, 20, 0.5D, 0.2D),
                            new Point3D[]{new Point3D(-1500.0D, 0.0D, 1560.0D),
                                    new Point3D(-1500.0D, 1500.0D, 1560.0D),
                                    new Point3D(-1500.0D, 1500.0D, -1560.0D),
                                    new Point3D(-1500.0D, 0.0D, -1560.0D)}),
                new Sphere(new Color(255.0D, 0.0D, 0.0D),
                           new Material(0.0D, 0.0D, 50, 1.0D, 0.0D), 50.0D,
                           new Point3D(350.0D, 0.0D, 350.0D)),
                new Sphere(new Color(255.0D, 0.0D, 0.0D),
                           new Material(0.0D, 0.0D, 50, 1.0D, 0.0D), 50.0D,
                           new Point3D(300.0D, 0.0D, -20.0D)),
                new Sphere(new Color(255.0D, 0.0D, 0.0D),
                           new Material(0.0D, 0.0D, 50, 1.0D, 0.0D), 50.0D,
                           new Point3D(100.0D, 0.0D, 400.0D)),
                new Sphere(new Color(255.0D, 0.0D, 0.0D),
                           new Material(0.0D, 0.0D, 50, 1.0D, 0.0D), 50.0D,
                           new Point3D(-300.0D, 0.0D, 220.0D)),
                new Sphere(new Color(255.0D, 0.0D, 0.0D),
                           new Material(0.0D, 0.0D, 50, 1.0D, 0.0D), 50.0D,
                           new Point3D(0.0D, 0.0D, -500.0D))});
        scene.addLights(
                new SpotLight(new Color(700.0D, 400.0D, 400.0D),
                              new Point3D(0.0D, -250.0D, 50.0D),
                              new Vector(0.5D, 1.0D, 0.0D), 1.0D, 4.0E-4D, 2.0E-5D));
        scene.addLights(
                new PointLight(new Color(700.0D, 400.0D, 400.0D),
                               new Point3D(-200.0D, 500.0D, -700.0D), 1.0D, 4.0E-4D, 2.0E-5D));
        ImageWriter imageWriter = new ImageWriter("test1.9", 200.0D, 200.0D, 600, 600);
        Render render = (new Render(imageWriter, scene)).setMultithreading(20);
        render.renderImage();
        render.writeToImage();
    }
}