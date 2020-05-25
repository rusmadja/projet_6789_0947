package elements;

public class Material {
    private double _kD;
    private double _kS;
    private double _kR;
    private double _kT;
    private int _nShininess;


    public Material(double kD, double kS, double kR, double kT, int nShininess) {
        _kD = kD;
        _kS = kS;
        _kR = kR;
        _kT = kT;
        _nShininess = nShininess;
    }

    public Material(double _kD, double _kS, int _nShininess) {
        this(_kD,_kS,0,0,_nShininess);
    }

    public double getkD() {
        return _kD;
    }

    public double getkS() {
        return _kS;
    }
    public double getkR() {
        return _kR;
    }

    public double getkT() {
        return _kT;
    }
    public int getnShininess() {
        return _nShininess;
    }
}