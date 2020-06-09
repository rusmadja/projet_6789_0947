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

import static java.lang.Math.sqrt;
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
                    new Material(0, 0, 1),new Point3D(0,0,0),1);




        } catch (IllegalArgumentException e) {

            System.out.println(e);}

    }
    @Test
    public void findIntersections() {
        Wolf_1 test = new Wolf_1(
                new Color(0, 0, 200),
                new Material(0, 0, 1),new Point3D(0,0,0),1);
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
                /*.addCamera(new Camera( // vue de face
                        new Point3D(0, 50, -8000),
                        new Vector(0, 0, 1),
                        new Vector(0,1 ,0 )))*/
                /*.addCamera(new Camera( // vue de profile
                        new Point3D(-8000, 50, 0),
                        new Vector(1, 0, 0),
                        new Vector(0,1 ,0 )))*/
               /* .addCamera(new Camera( // vue de haut
                        new Point3D(0, -1000, 0),
                        new Vector(0, 1, 0),
                        new Vector(1,0 ,0 )))*/
                .addCamera(new Camera( // vue de haut gauche
                         new Point3D(-1499, 1200, -1559),
                         new Vector(1, -0.5, 1),
                         new Vector(0.5  ,2,0.5   )))
                .addDistance(180)
                .addBackground(Color.BLACK)
                .build();

        scene.addGeometries( //
                             new Sphere(new Color(100, 120, 120), new Material(0.5, 0.5, 30,0.6,0),500,
                                        new Point3D(-50, 324.7280955, -43.568478)),

                            // cube du bas
                             new Cube(new Color(java.awt.Color.BLUE), new Material(0.5, 0.5, 30),
                                    new Point3D(-400, -160, -440), 800, 159.59, 840),

                             new Cube(new Color(96, 96, 96), new Material(0.5, 0.5, 30,0,1),
                                      new Point3D(-1500, -160, -1560), 3000, 3000,3120),

                             new Damier(new Material(0.5, 0.5, 30),
                                new Point3D(-1500, -159.9999, -1560), 3000,3120),
                             /*new Wolf_1(
                                  new Color(Color.BLACK),
                                 new Material(0.5, 0.5, 30),new Point3D(0,0,0),1)*/
                             //new Wolf_2(
                               //      new Color(167, 103, 38),
                                 //   new Material(0, 0, 30),new Point3D(0,0,0),1)
                             new Tree( // tronc
                                       new Color(136, 66, 29),
                                       new Material(0, 0, 30),new Point3D(-50,0,-43),3.5), // deplace le tronc de 60 a droite
                             new Tree_2( // feuille
                                        new Color(52, 201, 36),
                                       new Material(0, 0, 30),new Point3D(-50,0,-43),3.5) // // deplace les feuille de 60 a droite


        );

        scene.addLights(new SpotLight(new Color(400,240,0),
                                      new Point3D(-500, 2700, 0),
                                      new Vector(500, -2588, -13),
                                      1, 0.00004, 0.00001));

        scene.addLights(new SpotLight(new Color(java.awt.Color.GREEN),
                                      new Point3D(500, 2700, 0),
                                      new Vector(-500, -2588, -13),
                                      1, 0.00004, 0.00001));



        ImageWriter imageWriter = new ImageWriter("test1.8", 200, 200, 600, 600);
        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();


    }


}