package otherTests;

import elements.*;
import geometries.Cube;
import geometries.Damier;
import geometries.Polygon;
import geometries.Sphere;
import org.junit.jupiter.api.Test;
import primitives.Color;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;


public class test_glossy_and_diffuse {

    @Test
    public void twoSpheresGlossy() {
        Scene scene = new Scene.SceneBuilder("Test scene")
                .addAmbientLight(new AmbientLight(Color.BLACK, 0))
                .addCamera(
                        new Camera(
                                new Point3D(20, -10, -1000),
                                new Vector(0, 0, 1),
                                new Vector(0, -1, 0)))
                .addDistance(750)
                .addBackground(Color.BLACK)
                .build();

        scene.addGeometries(

                new Polygon(//bas
                        new Color(java.awt.Color.LIGHT_GRAY),
                        new Material(0.4, 0.3, 100, 0.2, 0),
                        new Point3D(0, 0, 0),
                        new Point3D(0, 0, 200),
                        new Point3D(200, 0, 200),
                        new Point3D(200, 0, 0)),

                new Sphere(
                        new Color(java.awt.Color.BLACK),
                        new Material(0.5, 0.5, 100, 0, 1, 5, 0),
                        50,
                        new Point3D(20, -50, 70))

        );

        scene.addLights(
                new PointLight(new Color(1000, 600, 0),
                        new Point3D(100, -100, 100))
        );

        ImageWriter imageWriter = new ImageWriter("testGlossy", 150, 150, 500, 500);
        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }

    @Test
    public void twoSpheresDiffuse() {
        Scene scene = new Scene.SceneBuilder("Test scene")
                .addAmbientLight(new AmbientLight(Color.BLACK, 0))
                .addCamera(
                        new Camera(
                                new Point3D(0, -500, 50),
                                new Vector(0, 1, 0),
                                new Vector(0, 0, -1)))
                .addDistance(500)
                .addBackground(Color.BLACK)
                .build();

        scene.addGeometries(

                new Sphere(
                        new Color(java.awt.Color.RED),
                        new Material(0.5, 0.5, 100),
                        25,
                        new Point3D(0, 10, 50)),
                new Polygon(
                        new Color(java.awt.Color.LIGHT_GRAY),
                        new Material(0.1, 0.2, 100, 1, 0,0,0.5),
                        new Point3D(-60, -60, 50), new Point3D(-50, -60, 100),
                        new Point3D(100, -60, 50)
                ));
        scene.addLights(
                new SpotLight(
                        new Color(1000, 600, 0),
                        new Point3D(-100, 100, -500),
                        new Vector(-1, 1, 2),
                        1, 0.0004, 0.0000006));

        ImageWriter imageWriter = new ImageWriter("testDiffuse", 150, 150, 500, 500);
        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }

    @Test
    public void MirrorGlossyTest() {
         /*
                Y axis – screen top to bottom
                X axis – screen left to right
                Z axis – view from camera into scene
        */
        Scene scene;
        scene = new Scene.SceneBuilder("Test scene")
                .addAmbientLight(new AmbientLight(Color.BLACK, 0.5))

                .addCamera(new Camera( // vue de haut gauche
                        new Point3D(-1499, 1200, -1559),
                        new Vector(1, -0.5, 1),
                        new Vector(0.5, 2, 0.5)))
                .addDistance(180)
                .addBackground(Color.BLACK)
                .build();

        scene.addGeometries( //
                new Sphere(new Color(20 , 0, 0), new Material(0.5, 0.5, 30, 0, 0.3 , 0,0), 500,
                       new Point3D(-50, 324.7280955, -43.568478)),

                new Cube(new Color(3, 3, 3), new Material(0.5, 0.5, 30, 0, 0.8),
                        new Point3D(-1500, -160, -1560), 3000, 3000, 3120),

                new Damier(new Material(0.5, 0.5, 30),
                        new Point3D(-1500, -159.9999, -1560), 3000, 3120)
                 );
        scene.addLights(new SpotLight(new Color(400, 240, 0),
                new Point3D(-500, 2700, 0),
                new Vector(500, -2588, -13),
                1, 0.00004, 0.00001));

        scene.addLights(new SpotLight(new Color(java.awt.Color.GREEN),
                new Point3D(500, 2700, 0),
                new Vector(-500, -2588, -13),
                1, 0.00004, 0.00001));


        ImageWriter imageWriter = new ImageWriter("MirrorGlossyTest", 200, 200, 600, 600);
        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }
}
