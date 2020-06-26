package finalTEst;

import elements.AmbientLight;
import elements.Camera;
import elements.Material;
import elements.SpotLight;
import geometries.Cube;
import geometries.Polygon;
import objects.*;
import org.junit.jupiter.api.Test;
import primitives.Color;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class final2 {
    @Test
    public void LoupTest(){
          /*
                Y axis – screen top to bottom
                X axis – screen left to right
                Z axis – view from camera into scene
        */
        Scene scene;
        scene = new Scene.SceneBuilder("Test scene")
                .addAmbientLight(new AmbientLight(new Color(150,20,150), 0.5))
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
                .addCamera(new Camera( // vue de haut haut droit
                        new Point3D(1499, 1100, 1559),
                        new Vector(-1, -0.5, -1),
                        new Vector(-0.5  ,2,-0.5   )))
                .addDistance(110)
                .addBackground(Color.BLACK)
                .build();
        scene.addGeometries( //
                // cube du bas
                 new Wolf_1(new Color(212,175,55),
                         new Material(0.5, 0.5, 120),
                         new Point3D(0,330,0),4.5),
               new Wolf_2(
                     new Color(207,181,59),
                        new Material(0.5, 0.5, 120),
                        new Point3D(0,330,0),4.5),

                new Wolf_3(
                        new Color(197,179,88),
                        new Material(0.5, 0.5, 120),
                        new Point3D(0,330,0),4.5),
                new Cube(new Color(java.awt.Color.GREEN), new Material(0.1, 0.2, 15),
                        new Point3D(-450, 280, -490), 900, 50, 940),

                new Cube(new Color(java.awt.Color.BLUE), new Material(0.1, 0.2, 15),
                        new Point3D(-400, -120, -440), 800, 400, 840),

                new Cube(new Color(java.awt.Color.YELLOW), new Material(0.1, 0.2, 15),
                        new Point3D(-330, -50, 380), 660, 260, 40),

                new Polygon(new Color(java.awt.Color.RED) ,
                        new Point3D(-400, -120, -440),new Point3D(400, -120, -440),
                       new Point3D(450, -160, -490), new Point3D(-450, -160, -490)),

                new Polygon(new Color(java.awt.Color.RED) ,
                        new Point3D(400, -120, -440),new Point3D(450, -160, -490),
                        new Point3D(450, -160, 450), new Point3D(400, -120, 400)),

                new Polygon(new Color(java.awt.Color.RED) ,
                        new Point3D(-400, -120, -440),new Point3D(-450, -160, -490),
                        new Point3D(-450, -160, 450), new Point3D(-400, -120, 400)),

                new Polygon(new Color(java.awt.Color.RED) ,
                        new Point3D(450, -160, 450), new Point3D(400, -120, 400),
                        new Point3D(-400, -120, 400), new Point3D(-450, -160, 450)),

                new Polygon(
                        new Color(192,192,192),
                        new Material(0.5, 0.5, 30,0,0.6),
                        new Point3D(-1500, -159.9999, -1560),
                        new Point3D(-1500, -159.9999, 1560),
                        new Point3D(1500, -159.9999, 1560),
                        new Point3D(1500, -159.9999, -1560))
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
        Render render = new Render(imageWriter, scene).setMultithreading(20);

        render.renderImage();
        render.writeToImage();
    }
    @Test
    public void LoupTest2(){
          /*
                Y axis – screen top to bottom
                X axis – screen left to right
                Z axis – view from camera into scene
        */
        Scene scene;
        scene = new Scene.SceneBuilder("Test scene")
                .addAmbientLight(new AmbientLight(new Color(0,0,0), 0.5))
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
                .addCamera(new Camera( // vue de haut haut droit
                        new Point3D(1499, 1100, 1559),
                        new Vector(-1, -0.5, -1),
                        new Vector(-0.5  ,2,-0.5   )))
                .addDistance(110)
                .addBackground(new Color(135,206,235))
                .build();
        scene.addGeometries(

                new Montagne(new Color(175,175,175),
                       new Material(0.5,0.5,120),
                       new Point3D(0,330,0),150),
                new Montagne_2(new Color(75,63,52),
                    new Material(0.5,0.5,120),
                    new Point3D(0,330,0),150),
               /* new Cube(new Color(java.awt.Color.GREEN), new Material(0.1, 0.2, 15),
                        new Point3D(-450, 280, -490), 900, 50, 940),

                new Cube(new Color(java.awt.Color.BLUE), new Material(0.1, 0.2, 15),
                        new Point3D(-400, -120, -440), 800, 400, 840),

                new Cube(new Color(java.awt.Color.YELLOW), new Material(0.1, 0.2, 15),
                        new Point3D(-330, -50, 380), 660, 260, 40),

                new Polygon(new Color(java.awt.Color.RED) ,
                        new Point3D(-400, -120, -440),new Point3D(400, -120, -440),
                        new Point3D(450, -160, -490), new Point3D(-450, -160, -490)),

                new Polygon(new Color(java.awt.Color.RED) ,
                        new Point3D(400, -120, -440),new Point3D(450, -160, -490),
                        new Point3D(450, -160, 450), new Point3D(400, -120, 400)),

                new Polygon(new Color(java.awt.Color.RED) ,
                        new Point3D(-400, -120, -440),new Point3D(-450, -160, -490),
                        new Point3D(-450, -160, 450), new Point3D(-400, -120, 400)),

                new Polygon(new Color(java.awt.Color.RED) ,
                        new Point3D(450, -160, 450), new Point3D(400, -120, 400),
                        new Point3D(-400, -120, 400), new Point3D(-450, -160, 450)),*/

                new Polygon(
                        new Color(58,157,35),
                        new Material(0.4, 0.2, 15),
                        new Point3D(-1600, -159.9999, -1700),
                        new Point3D(-1600, -159.9999, 1700),
                        new Point3D(1700, -159.9999, 1700),
                        new Point3D(1700, -159.9999, -1700))
        );
        scene.addLights(new SpotLight(new Color(400,240,0),
                new Point3D(-500, 2700, 0),
                new Vector(500, -2588, -13),
                1, 0.00004, 0.00001));

        scene.addLights(new SpotLight(new Color(java.awt.Color.GREEN),
                new Point3D(500, 2700, 0),
                new Vector(-500, -2588, -13),
                1, 0.00004, 0.00001));



        ImageWriter imageWriter = new ImageWriter("test1.9", 200, 200, 600, 600);
        Render render = new Render(imageWriter, scene).setMultithreading(20);

        render.renderImage();
        render.writeToImage();
    }
}
