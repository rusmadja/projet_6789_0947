package primitives;

import elements.AmbientLight;
import elements.Camera;
import geometries.Geometries;
import geometries.Polygon;
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

/**
 * @author raphael et Reouven
 * We made this fonction in order to transform any XML files in Scene and ImageWriter
 * We used a DOM method
 */
public class convertXML
{

    Scene _scene ;
    ImageWriter _imageWriter;
    Geometries _geometries;

    /**
     * @return all 3D models who are in the file
     */
    public Geometries getGeometries() {
        return _geometries;
    }

    /**
     * @return the scene of this XML file
     */
    public Scene getScene() {
        return _scene;
    }

    /**
     *
     * @return the ImageWriter of this XML file
     */
    public ImageWriter getImageWriter() {
        return _imageWriter;
    }

    /**
     * our CTOR to convert the XML file by its path
     * and transform it...
     */
    public convertXML(String Path)
    {
        //we add Path name to scene
        _scene = new Scene(Path);
        // we need to create an instance to begin...
        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try
        {
            final DocumentBuilder builder = factory.newDocumentBuilder();
            //we open the XML file that we will use
            final Document my_xml_document= builder.parse(new File(Path));
            //we take the root (or main element of) file
            final Element scene = my_xml_document.getDocumentElement();
            /* PART 1 EXTRACTION OF SCENE'S ATTRIBUTES */
            //we take the background's data and we initialise the scene's background
            //we uses split function to break the string who content the rgb values
            String[] scene_background = scene.getAttribute("background-color").split(" ");;
            _scene.setBackground( new Color(Integer.parseInt(scene_background[0]),
                                                     Integer.parseInt(scene_background[1])
                                                    ,Integer.parseInt(scene_background[2])));
            // we extract another scene's attribute: distance
            _scene.setDistance(Integer.parseInt(scene.getAttribute("screen-distance")));

            /* PART 2 EXTRACTION OF ALL OTHERS NODES */
            final Element image = (Element)scene.getElementsByTagName("image").item(0);
            final Element camera = (Element) scene.getElementsByTagName("camera").item(0);
            final Element ambient_light = (Element)scene.getElementsByTagName("ambient-light").item(0);
            final Element geometries = (Element)scene.getElementsByTagName("geometries").item(0) ;

            /*PART 2.1 EXTRACTION OF THE IMAGE'S ATTRIBUTES*/
            //we initialise here imageWriter
            int image_screen_width = Integer.parseInt(image.getAttribute("screen-width"));
            int image_screen_height = Integer.parseInt(image.getAttribute("screen-height"));
            int image_Nx = Integer.parseInt((image.getAttribute("Nx")));
            int image_Ny = Integer.parseInt(image.getAttribute("Ny"));
            _imageWriter = new ImageWriter(Path,image_screen_width,image_screen_height,image_Nx,image_Ny);

            /*PART 2.2 EXTRACTION OF THE CAMERA'S ATTRIBUTES*/
            //we extract p0,  Vto and Vup
            String[]P0  = camera.getAttribute("P0").split(" ");
            String[]Vto = camera.getAttribute("Vto").split(" ");
            String[]Vup = camera.getAttribute("Vup").split(" ");
            _scene.setCamera(new Camera(
                    new Point3D(Double.parseDouble(P0[0]),Double.parseDouble(P0[1]),Double.parseDouble(P0[2])),
                    new Vector(Double.parseDouble(Vto[0]),Double.parseDouble(Vto[1]),Double.parseDouble(Vto[2])),
                    new Vector(Double.parseDouble(Vup[0]),Double.parseDouble(Vup[1]),Double.parseDouble(Vup[2]))));

            /*PART 2.3 EXTRACTION OF THE Ambient-Light'S ATTRIBUTES */
            String[] ambient_lights = ambient_light.getAttribute("color").split(" ");
            Color ambient_light_color = new Color(
                                                    Integer.parseInt(ambient_lights[0]),
                                                    Integer.parseInt(ambient_lights[1]),
                                                    Integer.parseInt(ambient_lights[2]));
            _scene.setAmbientLight(new AmbientLight( ambient_light_color , 1));

            /*PART 2.4 EXTRACTION OF THE GEOMETRIES'S ATTRIBUTES */
            _geometries = new Geometries();
            final NodeList list_triangles = geometries.getElementsByTagName("triangle");
            final NodeList list_spheres = geometries.getElementsByTagName("sphere");
            final NodeList list_polygon = geometries.getElementsByTagName("polygon");

            //add triangle to geometries
            for (int i=0; i < list_triangles.getLength();i++) {
                String[] points =((Element)list_triangles.item(i)).getAttribute("p0").split(" ");
                Point3D _p0 = new Point3D(Double.parseDouble(points[0]),Double.parseDouble(points[1]),Double.parseDouble(points[2]));
                points = ((Element)list_triangles.item(i)).getAttribute("p1").split(" ");
                Point3D _p1 = new Point3D(Double.parseDouble(points[0]),Double.parseDouble(points[1]),Double.parseDouble(points[2]));
                points =((Element)list_triangles.item(i)).getAttribute("p2").split(" ");
                Point3D _p2 = new Point3D(Double.parseDouble(points[0]),Double.parseDouble(points[1]),Double.parseDouble(points[2]));
                _geometries.add(new Triangle(_p0,_p1,_p2));
            }
            //add sphere to geometries
            for (int i=0; i < list_spheres.getLength();i++) {
                String[] _center =((Element)list_spheres.item(i)).getAttribute("center").split(" ");
                double _radius =Double.parseDouble(((Element)list_spheres.item(i)).getAttribute("radius"));
                _geometries.add(new Sphere(_radius,new Point3D(Double.parseDouble(_center[0]),Double.parseDouble(_center[1]),Double.parseDouble(_center[2]))));
            }
            //add polygon to geometries
            for (int i=0; i < list_polygon.getLength();i++) {

                int numberOfPoint =list_polygon.item(i).getAttributes().getLength();
                Point3D[] all_Points = new Point3D[numberOfPoint];
                for(int j =0 ; j<numberOfPoint;j++){
                    String[] points =((Element)list_polygon.item(i)).getAttribute("p"+j).split(" ");
                    all_Points[j]=new Point3D(
                            Double.parseDouble(points[0]),
                            Double.parseDouble(points[1]),
                            Double.parseDouble(points[2]));
                }
                _geometries.add(new Polygon(all_Points));
            }

            //and finaly we add the geometries into scene
            _scene.addGeometries(_geometries);
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
