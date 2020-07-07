package primitives;

/**
 * Utilclass is used for some internal utilities, e.g. controlling accuracy
 *
 * @author Dan
 */
public abstract class Util {
    // It is binary, equivalent to ~1/1,000,000,000,000 in decimal (12 digits)
    private static final int ACCURACY = -40;

    // double store format (bit level): seee eeee eeee (1.)mmmm � mmmm
    // 1 bit sign, 11 bits exponent, 53 bits (52 stored) normalized mantissa
    // the number is m+2^e where 1<=m<2
    // NB: exponent is stored "normalized" (i.e. always positive by adding 1023)
    private static int getExp(double num) {
        // 1. doubleToRawLongBits: "convert" the stored number to set of bits
        // 2. Shift all 52 bits to the right (removing mantissa)
        // 3. Zero the sign of number bit by mask 0x7FF
        // 4. "De-normalize" the exponent by subtracting 1023
        return (int)((Double.doubleToRawLongBits(num) >> 52) & 0x7FFL) - 1023;
    }

    /**
     * Checks whether the number is [almost] zero
     *
     * @param number
     * @return true if the number is zero or almost zero, false otherwise
     */
    public static boolean isZero(double number) {
        return getExp(number) < ACCURACY;
    }

    /**
     * Aligns the number to zero if it is almost zero
     *
     * @param number
     * @return 0.0 if the number is very close to zero, the number itself otherwise
     */
    public static double alignZero(double number) {
        return getExp(number) < ACCURACY ? 0.0 : number;
    }

    public static Point3D getMax(Point3D ... vertice) {
        double x = Double.MIN_VALUE;
        double y = Double.MIN_VALUE;
        double z = Double.MIN_VALUE;
        for (var p:
             vertice) {
            if(p!=null){
                double thisx = p.get_x().get();
                double thisy = p.get_y().get();
                double thisz = p.get_z().get();
                if (x < thisx)
                    x = thisx;
                if (y < thisy)
                    y = thisy;
                if (z < thisz)
                    z = thisz;
            }
        }
        return new Point3D(x,y,z);
    }
    public static Point3D getMin(Point3D ... vertice) {
        double x = Double.MAX_VALUE;
        double y = Double.MAX_VALUE;
        double z = Double.MAX_VALUE;
        for (var p:
                vertice) {
            if(p!=null) {
                double thisx = p.get_x().get();
                double thisy = p.get_y().get();
                double thisz = p.get_z().get();
                if (x >= thisx)
                    x = thisx;
                if (y >= thisy)
                    y = thisy;
                if (z >= thisz)
                    z = thisz;
            }
        }
        return new Point3D(x,y,z);
    }
    public static Point3D getMax(Point3D point3D , double radius) {
        double x = point3D.get_x().get() + radius;
        double y = point3D.get_y().get() + radius;
        double z = point3D.get_z().get() + radius;

        return new Point3D(x,y,z);
    }
    public static Point3D getMin(Point3D point3D , double radius) {
        double x = point3D.get_x().get() - radius ;
        double y = point3D.get_y().get() - radius ;
        double z = point3D.get_z().get() - radius ;

        return new Point3D(x,y,z);
    }
}
