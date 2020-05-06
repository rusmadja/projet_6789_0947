package scene;

import elements.AmbientLight;
import elements.Camera;
import geometries.Geometries;
import geometries.Intersectable;
import primitives.Color;

public class Scene {
    private final String _name;
    private Geometries _geometries;

    private Color _background;
    private Camera _camera;
    private double _distance;
    private AmbientLight _ambientLight;


    public Scene(String _sceneName){
        this._name= _sceneName;
        _geometries = new Geometries();
    }

    public String getName() {
        return _name;
    }

    public Geometries getGeometries() {
        return _geometries;
    }

    public Color getBackground() {
        return _background;
    }

    public void setBackground(Color background) {
        _background = background;
    }

    public Camera getCamera() {
        return _camera;
    }

    public void setCamera(Camera camera) {
        _camera = camera;
    }

    public double getDistance() {
        return _distance;
    }

    public void setDistance(double distance) {
        _distance = distance;
    }

    public AmbientLight getAmbientLight() {
        return _ambientLight;
    }

    public void setAmbientLight(AmbientLight ambientLight) {
        _ambientLight = ambientLight;
    }

    public void addGeometries(Intersectable... intersectables) {
            _geometries.add(intersectables);
    }


}