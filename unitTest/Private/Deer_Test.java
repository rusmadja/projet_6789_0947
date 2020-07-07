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

import geometries.Triangle;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Deer_Test {

        @Test
        public void testConstructor() {
            try{
                List<Triangle> list = new ArrayList<Triangle>();
                Color emissionLight = new Color(0, 0, 200);
                Material material=    new Material(0, 0, 1);
                Deer_1 test = new Deer_1(
                        new Color(0, 0, 200),
                        new Material(0, 0, 1),new Point3D(0,0,0),1);




            } catch (IllegalArgumentException e) {

                System.out.println(e);}

        }
        @Test
        public void findIntersections() {
            Deer_1 test = new Deer_1(
                    new Color(0, 0, 200),
                    new Material(0, 0, 1),new Point3D(0,0,0),1);
            Ray ray = new Ray(new Point3D(0, 0, -1000), new Vector(0, 0, 1)) ;

            List<Intersectable.GeoPoint> TesterList = test.findIntersections(ray, Double.POSITIVE_INFINITY);

            assertEquals( "bad number intersection",TesterList.size() , 1 );


        }

        @Test
        public void test1_7() {
         /*
                Y axis – screen top to bottom
                X axis – screen left to right
                Z axis – view from camera into scene
        */
            Scene scene = (new SceneBuilder("Test scene"))
                    .addAmbientLight(new AmbientLight(Color.BLACK, 0.5D))
                    .addCamera(new Camera(new Point3D(1499.0D, 600.0D, 1559.0D),
                                          new Vector(-1.0D, -0.25D, -1.0D),
                                          new Vector(-0.25D, 2.0D, -0.25D)))
                    .addDistance(500.0D).addBackground(Color.BLACK).build();
            scene.addGeometries(
             //new Intersectable[]{
                                 new Wolf_1(new Color(60.0D, 60.0D, 60.0D),
                                            new Material(0.5D, 0.5D, 30),
                                            new Point3D(0.0D, 0.0D, 0.0D), 1.0D),
                                 /*new Wolf_2(new Color(80.0D, 80.0D, 80.0D),
                                            new Material(0.0D, 0.0D, 30),
                                            new Point3D(0.0D, 0.0D, 0.0D), 1.0D),
                                 new Wolf_3(new Color(100.0D, 100.0D, 100.0D),
                                            new Material(0.0D, 0.0D, 30),
                                            new Point3D(0.0D, 0.0D, 0.0D), 1.0D),*/
                                 new Tree(new Color(136.0D, 66.0D, 29.0D),
                                          new Material(0.0D, 0.0D, 30),
                                          new Point3D(-200.0D, 0.0D, -200.0D), 2.5D),
                                 /*new Tree_2(new Color(52.0D, 201.0D, 36.0D),
                                            new Material(0.0D, 0.0D, 30),
                                            new Point3D(-200.0D, 0.0D, -200.0D), 2.5D),
                                 new Tree_3(new Color(52.0D, 180.0D, 36.0D),
                                            new Material(0.0D, 0.0D, 30),
                                            new Point3D(-200.0D, 0.0D, -200.0D), 2.5D),*/
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
                                 new Deer_1(
                                         new Color(200, 000, 000),
                                         new Material(0, 0, 30),new Point3D(0,0,0),0.1)
                                 /*new Deer_2(
                                         new Color(000, 200, 000),
                                         new Material(0, 0, 30),new Point3D(0,0,0),1);
                                 new Deer_3(
                                         new Color(000, 000, 200),
                                         new Material(0, 0, 30),new Point3D(0,0,0),1)*/
            );

            scene.addLights(new SpotLight(new Color(700, 400, 400),
                                          new Point3D(0, -250, 50),
                                          new Vector(0.5, 1, 0),
                                          1, 4E-4, 2E-5));



            ImageWriter imageWriter = new ImageWriter("test1.deer", 200, 200, 600, 600);
            Render render = new Render(imageWriter, scene).setMultithreading(20);

            render.renderImage();
            render.writeToImage();

        }
    }

