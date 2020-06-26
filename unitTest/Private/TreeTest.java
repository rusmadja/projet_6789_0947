package Private;

import elements.AmbientLight;
import elements.Camera;
import elements.Material;
import elements.SpotLight;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TreeTest {

    @Test
    public void testConstructor() {
        try {
            List<Triangle> list = new ArrayList<Triangle>();
            Color emissionLight = new Color(0, 0, 200);
            Material material = new Material(0, 0, 1);
            Tree test = new Tree(
                    new Color(0, 0, 200),
                    new Material(0, 0, 1) , new Point3D(0,0,0),1);


        } catch (IllegalArgumentException e) {

            System.out.println(e);
        }

    }

    @Test
    public void findIntersections() {
        Tree test = new Tree(
                new Color(0, 0, 200),
                new Material(0, 0, 1),new Point3D(0,0,0),1);
        Ray ray = new Ray(new Point3D(0, 0, -1000), new Vector(0, 0, 1));

        List<Intersectable.GeoPoint> TesterList = test.findIntersections(ray, Double.POSITIVE_INFINITY);

        assertEquals("bad number intersection", TesterList.size(), 1);


    }

    @Test
    public void test1_9() {
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
                /*.addCamera(new Camera( // vue de haut bas gauche
                                       new Point3D(-1499, 1200, -1559),
                                       new Vector(1, -0.5, 1),
                                       new Vector(0.5  ,2,0.5   )))*/
                /*.addCamera(new Camera( // vue de haut haut droit
                                       new Point3D(1499, 1100, 1559),
                                       new Vector(-1, -0.5, -1),
                                       new Vector(-0.5  ,2,-0.5   ))) */
                .addCamera(new Camera( // vue de haut haut droit
                                       new Point3D(1499, 600, 1559),
                                       new Vector(-1, -0.25, -1),
                                       new Vector(-0.25  ,2,-0.25   )))

                /*.addCamera(new Camera( // vue de face
                        new Point3D(0, 50, -8000),
                        new Vector(0, 0, 1),
                        new Vector(0,1 ,0 )))*/
              /*  .addCamera(new Camera( // vue de profile arbre devant loup
                                       new Point3D(-8000, 50, 0),
                                       new Vector(1, 0, 0),
                                       new Vector(0, 1, 0))) */
               /* .addCamera(new Camera( // vue de profile loup devant arbre
                                       new Point3D(8000, 50, 0),
                                       new Vector(-1, 0, 0),
                                       new Vector(0, 1, 0))) */
                .addDistance(500)
                .addBackground(Color.BLACK)
                .build();

        scene.addGeometries( //
                             /*new Sphere(new Color(100, 120, 120), new Material(0, 0.8, 60,1,0),200,
                                        new Point3D(0, 112.7280955, -13.568478)),

                             new Cube(new Color(100, 120, 120), new Material(0, 0.8, 60),
                                      new Point3D(0, -10, 0), 10, 10,10),*/

                             new Wolf_1(
                                  new Color(60,60,60),
                                 new Material(0.5, 0.5, 30),new Point3D(0,0,0),1),
                             new Wolf_2(
                                   new Color(80,80,80),
                                new Material(0, 0, 30),new Point3D(0,0,0),1),
                             new Wolf_3(
                                     new Color(100,100,100),
                                     new Material(0, 0, 30),new Point3D(0,0,0),1),

                             new Tree( // tronc
                                     new Color(136, 66, 29),
                                     new Material(0, 0, 30),new Point3D(-200,0,-200),2.5), // deplace le tronc de 60 a droite
                             new Tree_2( // feuille
                                     new Color(52, 201, 36),
                                     new Material(0, 0, 30),new Point3D(-200,0,-200),2.5),
                             new Tree_3( // feuille
                                         new Color(52, 180, 36),
                                         new Material(0, 0, 30),new Point3D(-200,0,-200),2.5),// // deplace les feuille de 60 a droite
                             new Polygon(
                                        new Color(192,192,192),
                                          new Material(0.5, 0.5, 30,0,0.6),
                                        new Point3D(-11500, 0, -11560),
                                         new Point3D(-11500, 0, 11560),
                                         new Point3D(11500, 0, 11560),
                                         new Point3D(11500, 0, -11560))

        );

        scene.addLights(new SpotLight(new Color(700, 400, 400),
                                      new Point3D(0, -250, 50),
                                      new Vector(0.5, 1, 0),
                                      1, 4E-4, 2E-5));


        ImageWriter imageWriter = new ImageWriter("test1.9", 200, 200, 600, 600);
        Render render = new Render(imageWriter, scene).setMultithreading(20);

        render.renderImage();
        render.writeToImage();


    }
}