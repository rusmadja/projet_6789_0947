package elements;

import primitives.Color;

public class AmbientLight {
    private Color _intensity;

    public java.awt.Color getIntensity() {
        return _intensity.getColor();
    }

    public void setIntensity(Color _intensity) {
        this._intensity = _intensity;
    }

    public AmbientLight(Color _intensity, int ka) {
        // ka is always 1 so we don't use it
        this._intensity = _intensity;
    }

}