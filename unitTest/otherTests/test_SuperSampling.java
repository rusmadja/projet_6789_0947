package otherTests;

import elements.AmbientLight;
import elements.Camera;
import elements.Material;
import elements.PointLight;
import geometries.Polygon;
import geometries.Sphere;
import org.junit.jupiter.api.Test;
import primitives.Color;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;


public class test_SuperSampling {

    @Test
    public void SuperSampling() {
        Scene scene = new Scene.SceneBuilder("Test scene")
                .addAmbientLight(new AmbientLight(Color.BLACK, 0))
                .addCamera(
                        new Camera(
                                new Point3D(25, -12, 350),
                                new Vector(0, 0, -1),
                                new Vector(0, -1, 0)))
                .addDistance(300)
                .addBackground(Color.BLACK)
                .build();

        scene.addGeometries(
                new Polygon(//bas
                        new Color(java.awt.Color.DARK_GRAY),
                        new Material(0.4, 0.3, 100),
                        new Point3D(-50, 20, -100),
                        new Point3D(-50, 20, 300),
                        new Point3D(75, 20, 300),
                        new Point3D(75, 20, -100)),
                new Sphere(
                        new Color(java.awt.Color.BLUE),
                        new Material(0.5, 0.5, 30),
                        25,
                        new Point3D(30, -5, 50))
               );
        scene.addLights(
                new PointLight(
                        new Color(400, 240, 0),
                        new Point3D(35, -100, -60),
                        //new Vector(0, 0, 2),
                        1, 1E-5, 1.5E-7));

        ImageWriter imageWriter = new ImageWriter("testSuperSamplingWithLight", 150, 150, 500, 500);
        Render render = new Render(imageWriter, scene);


        render.renderImage();
        render.writeToImage();
    }
    @Test
    public void SuperSampling2() {
        Scene scene = new Scene.SceneBuilder("Test scene")
                .addAmbientLight(new AmbientLight(Color.BLACK, 0))
                .addCamera(
                        new Camera(
                                new Point3D(25, -12, 350),
                                new Vector(0, 0, -1),
                                new Vector(0, -1, 0)))
                .addDistance(500)
                .addBackground(Color.BLACK)
                .build();

        scene.addGeometries(
                new Polygon(//bas
                        new Color(java.awt.Color.DARK_GRAY),
                        new Material(0.4, 0.3, 100),
                        new Point3D(-50, 20, -100),
                        new Point3D(-50, 20, 300),
                        new Point3D(75, 20, 300),
                        new Point3D(75, 20, -100)),
                new Sphere(
                        new Color(java.awt.Color.RED),
                        new Material(0.5, 0.5, 30,1,0,0,0.5),
                        25,
                        new Point3D(30, -5, 50))
        );
        scene.addLights(
                new PointLight(
                        new Color(150, 0, 0),
                        new Point3D(35, -25, 50),
                        //new Vector(0, 0, 2),
                        1, 1E-5, 1.5E-7));

        ImageWriter imageWriter = new ImageWriter("testSuperSamplingWithLight2", 150, 150, 500, 500);
        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }
}

