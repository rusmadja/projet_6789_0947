package elements;

public class Material {
    private double _kD;
    private double _kS;
    private double _kR;
    private double _kT;
    private int _nShininess;
    double Kglossy;//improve: mekadem glossy surface
    double Kmatt;//improve: mekdaem diffuse glass

    public Material(double kD, double kS, int nShininess, double kT, double kR, double kglossy, double kmatt) {
        _kD = kD;
        _kS = kS;
        _kR = kR;
        _kT = kT;
        _nShininess = nShininess;
        Kglossy = kglossy;
        Kmatt = kmatt;
    }

    public Material(double kD, double kS, int nShininess, double kT, double kR) {
        this(kD, kS,nShininess,kT,kR,0,0);
    }

    public Material(double _kD, double _kS, int _nShininess) {
        this(_kD,_kS,_nShininess,0,0);
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

    public double getKglossy() {
        return Kglossy;
    }

    public double getKmatt() {
        return Kmatt;
    }

    public void setKglossy(double kglossy) {
        Kglossy = kglossy;
    }

    public void setKmatt(double kmatt) {
        Kmatt = kmatt;
    }
}