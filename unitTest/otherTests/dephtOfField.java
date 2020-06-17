package otherTests;

import elements.AmbientLight;
import elements.Camera;
import elements.Material;
import elements.PointLight;
import geometries.Sphere;
import org.junit.jupiter.api.Test;
import primitives.Color;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;


public class dephtOfField {
    @Test
    public void twoSpheresGlossy() {
        Scene scene = new Scene.SceneBuilder("Test scene")
                .addAmbientLight(new AmbientLight(Color.BLACK, 0))
                .addCamera(
                        new Camera(
                                new Point3D(0, 0, 0),
                                new Vector(0, 0, 1),
                                new Vector(0, -1, 0)))
                .addDistance(1000)
                .addBackground(Color.BLACK)
                .build();

        scene.addGeometries(

                new Sphere(
                        new Color(java.awt.Color.BLUE),
                        new Material(0.5, 0.5, 30),
                        30,
                        new Point3D(-20, -50, 1250)),
                new Sphere(
                        new Color(java.awt.Color.red),
                        new Material(0.5, 0.5, 30),
                        16,
                        new Point3D(-60, 60, 1500)),
                new Sphere(
                        new Color(java.awt.Color.GREEN),
                        new Material(0.5, 0.5, 30),
                        20,
                        new Point3D(10, 10, 1000)),
                new Sphere(
                        new Color(new java.awt.Color(200,200,200)),
                        new Material(0.5, 0.5, 30),
                        30,
                        new Point3D(60, -60, 1750)),
                new Sphere(
                        new Color(java.awt.Color.BLUE),
                        new Material(0.5, 0.5, 30),
                        20,
                        new Point3D(60, 60, 1500)),
                new Sphere(
                        new Color(java.awt.Color.GREEN),
                        new Material(0.5, 0.5, 30),
                        15,
                        new Point3D(-30, -10, 2000))

        );

        scene.addLights(
                new PointLight(
                        new Color(300, 10, 10),
                        new Point3D(35, -25, 50),
                        //new Vector(0, 1, 0),
                        1, 1E-6, 1.5E-9));

        ImageWriter imageWriter = new ImageWriter("DephtOfFieldtest", 150, 150, 500, 500);
        Render render = new Render(imageWriter, scene.setCamera(scene.getCamera().setDepthOfField(50,500,10)));

        render.renderImage();
        render.writeToImage();
    }

}
