package elements;

/**
 * Class material who contain every informations about it
 *
 * @author Reouven & Raphael
 *
 */
public class Material {
    private double _kD;
    private double _kS;
    private double _kR;
    private double _kT;
    private int _nShininess;
    private double Kglossy;
    private double Kmatt;

    /**
     * Constructor: in order to set every params of the material
     * with Golssy and Matt
     */
    public Material(double kD, double kS, int nShininess, double kT, double kR, double kglossy, double kmatt) {
        _kD = kD;
        _kS = kS;
        _kR = kR;
        _kT = kT;
        _nShininess = nShininess;
        Kglossy = kglossy;
        Kmatt = kmatt;
    }

    /**
     * Constructor: in order to set every params of the material
     * with transparency and reflection
     */
    public Material(double kD, double kS, int nShininess, double kT, double kR) {
        this(kD, kS,nShininess,kT,kR,0,0);
    }

    /**
     * Constructor: in order to set every params of the material
     *
     */
    public Material(double _kD, double _kS, int _nShininess) {
        this(_kD,_kS,_nShininess,0,0);
    }
    /**
     * getter Diffusion
     * @return the factor
     */
    public double getkD() {
        return _kD;
    }
    /**
     *  getter Specular
     * @return the factor
     */
    public double getkS() {
        return _kS;
    }
    /**
     * getter Reflection
     * @return the factor
     */
    public double getkR() {
        return _kR;
    }

    /**
     * getter Transparency
     * @return the factor
     */
    public double getkT() {
        return _kT;
    }
    /**
     * getter Shininess
     * @return shininess value
     */
    public int getnShininess() {
        return _nShininess;
    }

    /**
     * getter Glossy
     * @return glossy value
     */

    public double getKglossy() {
        return Kglossy;
    }

    /**
     * getter Matt
     * @return matt value
     */
    public double getKmatt() {
        return Kmatt;
    }

    /**
     * setter Glossy value
     * @param kglossy the value to set
     */
    public void setKglossy(double kglossy) {
        Kglossy = kglossy;
    }

    /**
     * setter Matt value
     * @param kmatt the value to set
     */
    public void setKmatt(double kmatt) {
        Kmatt = kmatt;
    }
}