package primitives;

import elements.AmbientLight;
import elements.Camera;
import geometries.Geometries;
import geometries.Sphere;
import geometries.Triangle;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import renderer.ImageWriter;
import scene.Scene;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class convertXML
{
    Scene _scene ;
    ImageWriter _imageWriter;
    Geometries _geometries = new Geometries();

    public Geometries getGeometries() {
        return _geometries;
    }

    public Scene getScene() {
        return _scene;
    }

    public ImageWriter getImageWriter() {
        return _imageWriter;
    }

    public convertXML(String Path)
    {
        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try
        {
            final DocumentBuilder builder = factory.newDocumentBuilder();
            //j ouvre le fichier xml en question
            final Document my_xml_document= builder.parse(new File(Path));
            final Element scene = my_xml_document.getDocumentElement(); // il nous rend scene
            /* PARTIE 1 EXTRACTION DONNEE DE A SCENE */
            
            String[] scene_background = scene.getAttribute("background-color").split(" ");;
            Color scene_background_color = new Color(Integer.parseInt(scene_background[0]),
                                                     Integer.parseInt(scene_background[1])
                                                    ,Integer.parseInt(scene_background[2]));

            int scene_screen_width = Integer.parseInt(scene.getAttribute("screen-width"));
            int scene_screen_height = Integer.parseInt(scene.getAttribute("screen-height"));
            int scene_screen_distance = Integer.parseInt(scene.getAttribute("screen-distance"));
            /* PARTIE 2 EXTRACTION DE TOUS LES NODE */
            final Element image = (Element)scene.getElementsByTagName("image").item(0);
            final Element camera = (Element) scene.getElementsByTagName("camera").item(0);
            final Element ambient_light = (Element)scene.getElementsByTagName("ambient-light").item(0);
            final Element geometries = (Element)scene.getElementsByTagName("geometries").item(0) ;

            /*----------------- PARTIE 2.1 EXTRACTION DONNEE DE image */
            int image_screen_width = Integer.parseInt(image.getAttribute("screen-width"));
            int image_screen_height = Integer.parseInt(image.getAttribute("screen-height"));
            int image_Nx = Integer.parseInt((image.getAttribute("Nx")));
            int image_Ny = Integer.parseInt(image.getAttribute("Ny"));
            /*----------------- PARTIE 2.2 EXTRACTION DONNEE DE camera */
            String[]P0  = camera.getAttribute("P0").split(" ");
            String[]Vto = camera.getAttribute("Vto").split(" ");
            String[]Vup = camera.getAttribute("Vup").split(" ");
            Camera _camera = new Camera(new Point3D(Double.parseDouble(P0[0]),Double.parseDouble(P0[1]),Double.parseDouble(P0[2])),
                    new Vector(Double.parseDouble(Vto[0]),Double.parseDouble(Vto[1]),Double.parseDouble(Vto[2])),
                    new Vector(Double.parseDouble(Vup[0]),Double.parseDouble(Vup[1]),Double.parseDouble(Vup[2])));

            /*---------------- PARTIE 2.3 EXTRACTION DONNEE DE ambient_light */
            String[] ambient_lights = ambient_light.getAttribute("color").split(" ");
            Color ambient_light_color = new Color(Integer.parseInt(ambient_lights[0]),
                    Integer.parseInt(ambient_lights[1])
                    ,Integer.parseInt(ambient_lights[2]));

            /*---------------- PARTIE 2.4 EXTRACTION DONNEE DE geometries */
            final NodeList list_triangles = geometries.getElementsByTagName("triangle");
            for (int i=0; i < list_triangles.getLength();i++)
            {
                String[] points =((Element)list_triangles.item(i)).getAttribute("p0").split(" ");
                Point3D _p0 = new Point3D(Double.parseDouble(points[0]),Double.parseDouble(points[1]),Double.parseDouble(points[2]));
                points = ((Element)list_triangles.item(i)).getAttribute("p1").split(" ");
                Point3D _p1 = new Point3D(Double.parseDouble(points[0]),Double.parseDouble(points[1]),Double.parseDouble(points[2]));
                points =((Element)list_triangles.item(i)).getAttribute("p2").split(" ");
                Point3D _p2 = new Point3D(Double.parseDouble(points[0]),Double.parseDouble(points[1]),Double.parseDouble(points[2]));
                _geometries.add(new Triangle(_p0,_p1,_p2));
            }
            final NodeList list_spheres = geometries.getElementsByTagName("sphere");
            for (int i=0; i < list_spheres.getLength();i++)
            {
                String[] _center =((Element)list_spheres.item(i)).getAttribute("center").split(" ");
                double _radius =Double.parseDouble(((Element)list_spheres.item(i)).getAttribute("radius"));
                _geometries.add(new Sphere(_radius,new Point3D(Double.parseDouble(_center[0]),Double.parseDouble(_center[1]),Double.parseDouble(_center[2]))));
            }
            _scene = new Scene(Path);
            _scene.setAmbientLight(new AmbientLight( ambient_light_color , 1));
            _scene.setBackground(scene_background_color);
            _scene.setCamera(_camera);
            _scene.setDistance(scene_screen_distance);
            _scene.addGeometries(_geometries);
            _imageWriter = new ImageWriter(Path,image_screen_width,image_screen_height,image_Nx,image_Ny);
        }
        catch (final ParserConfigurationException e)
        {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       
        
    }
}
