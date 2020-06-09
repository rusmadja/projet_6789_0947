package Private;

import elements.AmbientLight;
import elements.Camera;
import elements.Material;
import elements.SpotLight;
import geometries.Sphere;
import org.junit.Test;
import primitives.Color;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

import static org.junit.Assert.*;

public class DamierTest {

    @Test
    public void findIntersections() {
    }

    @Test
    public void test1_10() {
        Scene scene;
        scene = new Scene.SceneBuilder("Test scene")
                .addAmbientLight(new AmbientLight(Color.BLACK, 0))
                .addCamera(new Camera(
                        new Point3D(0, 3000, 0),
                        new Vector(0, -1, 0),
                        new Vector(1, 0, 0)))
                .addDistance(150)
                .addBackground(Color.BLACK)
                .build();

        scene.addGeometries( //
              /*  new Triangle(Color.BLACK, new Material(0, 0.8, 60), //
                        new Point3D(-150, 150, 115), new Point3D(150, 150, 135), new Point3D(75, -75, 150)), //
                new Triangle(Color.BLACK, new Material(0, 0.8, 60), //
                        new Point3D(-150, 150, 115), new Point3D(-70, -70, 140), new Point3D(75, -75, 150)), */ //
                             new Damier(new Material(0.5, 0.5, 30,0,1),
                                        new Point3D(-1500, -159, -1560), 3000,3120)
                             );



        scene.addLights(new SpotLight(new Color(700, 400, 400), //
                                      new Point3D(40, -40, -115), new Vector(-1, 1, 4), 1, 4E-4, 2E-5));

        scene.addLights(new SpotLight(new Color(700, 400, 400), //
                                      new Point3D(35, -40, 175), new Vector(0, 1, 0), 1, 4E-4, 2E-5));

        // scene.addLights(new SpotLight(new Color(700, 400, 400), //
        //         new Point3D(-50, 0, 150), new Vector(0, 1, 0), 1, 4E-4, 2E-5));

        ImageWriter imageWriter = new ImageWriter("test1.10", 200, 200, 600, 600);
        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }
}