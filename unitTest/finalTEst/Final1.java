package finalTEst;

import elements.*;
import geometries.Polygon;
import org.junit.jupiter.api.Test;
import primitives.Color;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class Final1 {
    @Test
    public void twoSpheresDiffuse() {
        Scene scene = new Scene.SceneBuilder("Test scene")
                .addAmbientLight(new AmbientLight(Color.BLACK, 0))
                .addCamera(new Camera( // vue de face
                        new Point3D(0, 50, -8000),
                        new Vector(0, 0, 1),
                        new Vector(0,1 ,0 )))
                        .addDistance(500)
                .addBackground(Color.BLACK)
                .build();

        scene.addGeometries(
                new Private.Tree( // tronc
                        new Color(136, 66, 29),
                        new Material(0, 0, 30),new Point3D(-60,0,0),3), // deplace le tronc de 60 a droite
                new Private.Tree_2( // feuille
                        new Color(52, 201, 36),
                        new Material(0, 0, 30),new Point3D(-60,0,0),3), // // deplace les feuille de 60 a droite

                new Polygon(
                        new Color(java.awt.Color.LIGHT_GRAY),
                        new Material(0.5, 0.5, 100, 1, 0,0,0.5),
                        new Point3D(-500, 0, -200), new Point3D(-500, 500, -200),
                        new Point3D(500, 500, -200),new Point3D(500, 0, -200)
                ));
        scene.addLights(

                new SpotLight(
                        new Color(1000, 600, 0),
                        new Point3D(-100, 100, -500),
                        new Vector(-1, 1, 2),
                        1, 0.0004, 0.0000006));
        scene.addLights(

                new PointLight(
                        new Color(1000, 600, 0),
                        new Point3D(-250, 250, -300),
                        1, 0.0004, 0.0000006));

        ImageWriter imageWriter = new ImageWriter("testDiffuseTree", 150, 150, 500, 500);
        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }
}
