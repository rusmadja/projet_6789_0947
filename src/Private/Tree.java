package Private;

import elements.Material;
import geometries.Geometries;
import geometries.Intersectable;
import geometries.Triangle;
import primitives.Color;
import primitives.Point3D;
import primitives.Ray;

import java.util.LinkedList;
import java.util.List;

public class Tree extends Geometries {

    // centre du tronc :
    //  xmin= -64.2282 xmax= 13.3135  x= -50,9147
    //  ymin= 0.0 ymax= 195.27        y= 0
    //  zmin= -61.6335 zmax= 40.432   z=- 21,2015


    List<Triangle> list = new LinkedList<Triangle>();

    public Tree(Color emissionLight, Material material, Point3D position, double coef) {

        double x = position.get_x().get();
        double y = position.get_y().get();
        double z = position.get_z().get();

        Triangle T2 = new Triangle(emissionLight, material, new Point3D((6.97709) * coef + x, (0.0) * coef + y, (4.07666) * coef + z), new Point3D((0.876735) * coef + x, (53.9898) * coef + y, (12.4731) * coef + z), new Point3D((6.97709) * coef + x, (53.9898) * coef + y, (4.07666) * coef + z));
        list.add(T2);
        Triangle T3 = new Triangle(emissionLight, material, new Point3D((6.97709) * coef + x, (0.0) * coef + y, (4.07666) * coef + z), new Point3D((0.876735) * coef + x, (0.0) * coef + y, (12.4731) * coef + z), new Point3D((0.876735) * coef + x, (53.9898) * coef + y, (12.4731) * coef + z));
        list.add(T3);
        Triangle T4 = new Triangle(emissionLight, material, new Point3D((0.876735) * coef + x, (0.0) * coef + y, (12.4731) * coef + z), new Point3D((-8.99385) * coef + x, (53.9898) * coef + y, (9.26593) * coef + z), new Point3D((0.876735) * coef + x, (53.9898) * coef + y, (12.4731) * coef + z));
        list.add(T4);
        Triangle T5 = new Triangle(emissionLight, material, new Point3D((0.876735) * coef + x, (0.0) * coef + y, (12.4731) * coef + z), new Point3D((-8.99385) * coef + x, (0.0) * coef + y, (9.26593) * coef + z), new Point3D((-8.99385) * coef + x, (53.9898) * coef + y, (9.26593) * coef + z));
        list.add(T5);
        Triangle T6 = new Triangle(emissionLight, material, new Point3D((-8.99385) * coef + x, (0.0) * coef + y, (9.26593) * coef + z), new Point3D((-8.99385) * coef + x, (53.9898) * coef + y, (-1.11262) * coef + z), new Point3D((-8.99385) * coef + x, (53.9898) * coef + y, (9.26593) * coef + z));
        list.add(T6);
        Triangle T7 = new Triangle(emissionLight, material, new Point3D((-8.99385) * coef + x, (0.0) * coef + y, (9.26593) * coef + z), new Point3D((-8.99385) * coef + x, (0.0) * coef + y, (-1.11262) * coef + z), new Point3D((-8.99385) * coef + x, (53.9898) * coef + y, (-1.11262) * coef + z));
        list.add(T7);
        Triangle T8 = new Triangle(emissionLight, material, new Point3D((-8.99385) * coef + x, (0.0) * coef + y, (-1.11262) * coef + z), new Point3D((0.876737) * coef + x, (53.9898) * coef + y, (-4.31977) * coef + z), new Point3D((-8.99385) * coef + x, (53.9898) * coef + y, (-1.11262) * coef + z));
        list.add(T8);
        Triangle T9 = new Triangle(emissionLight, material, new Point3D((-8.99385) * coef + x, (0.0) * coef + y, (-1.11262) * coef + z), new Point3D((0.876737) * coef + x, (0.0) * coef + y, (-4.31977) * coef + z), new Point3D((0.876737) * coef + x, (53.9898) * coef + y, (-4.31977) * coef + z));
        list.add(T9);
        Triangle T10 = new Triangle(emissionLight, material, new Point3D((0.876737) * coef + x, (0.0) * coef + y, (-4.31977) * coef + z), new Point3D((6.97709) * coef + x, (53.9898) * coef + y, (4.07666) * coef + z), new Point3D((0.876737) * coef + x, (53.9898) * coef + y, (-4.31977) * coef + z));
        list.add(T10);
        Triangle T11 = new Triangle(emissionLight, material, new Point3D((0.876737) * coef + x, (0.0) * coef + y, (-4.31977) * coef + z), new Point3D((6.97709) * coef + x, (0.0) * coef + y, (4.07666) * coef + z), new Point3D((6.97709) * coef + x, (53.9898) * coef + y, (4.07666) * coef + z));
        list.add(T11);
        Triangle T12 = new Triangle(emissionLight, material, new Point3D((-0.0326525) * coef + x, (87.3258) * coef + y, (18.1652) * coef + z), new Point3D((4.03425) * coef + x, (87.3258) * coef + y, (12.5676) * coef + z), new Point3D((6.97709) * coef + x, (53.9898) * coef + y, (4.07666) * coef + z));
        list.add(T12);
        Triangle T13 = new Triangle(emissionLight, material, new Point3D((6.97709) * coef + x, (53.9898) * coef + y, (4.07666) * coef + z), new Point3D((0.876735) * coef + x, (53.9898) * coef + y, (12.4731) * coef + z), new Point3D((-0.0326525) * coef + x, (87.3258) * coef + y, (18.1652) * coef + z));
        list.add(T13);
        Triangle T14 = new Triangle(emissionLight, material, new Point3D((-6.61304) * coef + x, (87.3258) * coef + y, (16.0271) * coef + z), new Point3D((-0.0326525) * coef + x, (87.3258) * coef + y, (18.1652) * coef + z), new Point3D((0.876735) * coef + x, (53.9898) * coef + y, (12.4731) * coef + z));
        list.add(T14);
        Triangle T15 = new Triangle(emissionLight, material, new Point3D((0.876735) * coef + x, (53.9898) * coef + y, (12.4731) * coef + z), new Point3D((-8.99385) * coef + x, (53.9898) * coef + y, (9.26593) * coef + z), new Point3D((-6.61304) * coef + x, (87.3258) * coef + y, (16.0271) * coef + z));
        list.add(T15);
        Triangle T16 = new Triangle(emissionLight, material, new Point3D((-6.61304) * coef + x, (87.3258) * coef + y, (9.10804) * coef + z), new Point3D((-6.61304) * coef + x, (87.3258) * coef + y, (16.0271) * coef + z), new Point3D((-8.99385) * coef + x, (53.9898) * coef + y, (9.26593) * coef + z));
        list.add(T16);
        Triangle T17 = new Triangle(emissionLight, material, new Point3D((-8.99385) * coef + x, (53.9898) * coef + y, (9.26593) * coef + z), new Point3D((-8.99385) * coef + x, (53.9898) * coef + y, (-1.11262) * coef + z), new Point3D((-6.61304) * coef + x, (87.3258) * coef + y, (9.10804) * coef + z));
        list.add(T17);
        Triangle T18 = new Triangle(emissionLight, material, new Point3D((-0.0326515) * coef + x, (87.3258) * coef + y, (6.96994) * coef + z), new Point3D((-6.61304) * coef + x, (87.3258) * coef + y, (9.10804) * coef + z), new Point3D((-8.99385) * coef + x, (53.9898) * coef + y, (-1.11262) * coef + z));
        list.add(T18);
        Triangle T19 = new Triangle(emissionLight, material, new Point3D((-8.99385) * coef + x, (53.9898) * coef + y, (-1.11262) * coef + z), new Point3D((0.876737) * coef + x, (53.9898) * coef + y, (-4.31977) * coef + z), new Point3D((-0.0326515) * coef + x, (87.3258) * coef + y, (6.96994) * coef + z));
        list.add(T19);
        Triangle T20 = new Triangle(emissionLight, material, new Point3D((4.03425) * coef + x, (87.3258) * coef + y, (12.5676) * coef + z), new Point3D((-0.0326515) * coef + x, (87.3258) * coef + y, (6.96994) * coef + z), new Point3D((0.876737) * coef + x, (53.9898) * coef + y, (-4.31977) * coef + z));
        list.add(T20);
        Triangle T21 = new Triangle(emissionLight, material, new Point3D((0.876737) * coef + x, (53.9898) * coef + y, (-4.31977) * coef + z), new Point3D((6.97709) * coef + x, (53.9898) * coef + y, (4.07666) * coef + z), new Point3D((4.03425) * coef + x, (87.3258) * coef + y, (12.5676) * coef + z));
        list.add(T21);
        Triangle T22 = new Triangle(emissionLight, material, new Point3D((-0.372749) * coef + x, (116.471) * coef + y, (13.8411) * coef + z), new Point3D((2.93368) * coef + x, (116.471) * coef + y, (9.2902) * coef + z), new Point3D((4.03425) * coef + x, (87.3258) * coef + y, (12.5676) * coef + z));
        list.add(T22);
        Triangle T23 = new Triangle(emissionLight, material, new Point3D((4.03425) * coef + x, (87.3258) * coef + y, (12.5676) * coef + z), new Point3D((-0.0326525) * coef + x, (87.3258) * coef + y, (18.1652) * coef + z), new Point3D((-0.372749) * coef + x, (116.471) * coef + y, (13.8411) * coef + z));
        list.add(T23);
        Triangle T24 = new Triangle(emissionLight, material, new Point3D((-5.72266) * coef + x, (116.471) * coef + y, (12.1028) * coef + z), new Point3D((-0.372749) * coef + x, (116.471) * coef + y, (13.8411) * coef + z), new Point3D((-0.0326525) * coef + x, (87.3258) * coef + y, (18.1652) * coef + z));
        list.add(T24);
        Triangle T25 = new Triangle(emissionLight, material, new Point3D((-0.0326525) * coef + x, (87.3258) * coef + y, (18.1652) * coef + z), new Point3D((-6.61304) * coef + x, (87.3258) * coef + y, (16.0271) * coef + z), new Point3D((-5.72266) * coef + x, (116.471) * coef + y, (12.1028) * coef + z));
        list.add(T25);
        Triangle T26 = new Triangle(emissionLight, material, new Point3D((-5.72266) * coef + x, (116.471) * coef + y, (6.47758) * coef + z), new Point3D((-5.72266) * coef + x, (116.471) * coef + y, (12.1028) * coef + z), new Point3D((-6.61304) * coef + x, (87.3258) * coef + y, (16.0271) * coef + z));
        list.add(T26);
        Triangle T27 = new Triangle(emissionLight, material, new Point3D((-6.61304) * coef + x, (87.3258) * coef + y, (16.0271) * coef + z), new Point3D((-6.61304) * coef + x, (87.3258) * coef + y, (9.10804) * coef + z), new Point3D((-5.72266) * coef + x, (116.471) * coef + y, (6.47758) * coef + z));
        list.add(T27);
        Triangle T28 = new Triangle(emissionLight, material, new Point3D((-0.372748) * coef + x, (116.471) * coef + y, (4.73929) * coef + z), new Point3D((-5.72266) * coef + x, (116.471) * coef + y, (6.47758) * coef + z), new Point3D((-6.61304) * coef + x, (87.3258) * coef + y, (9.10804) * coef + z));
        list.add(T28);
        Triangle T29 = new Triangle(emissionLight, material, new Point3D((-6.61304) * coef + x, (87.3258) * coef + y, (9.10804) * coef + z), new Point3D((-0.0326515) * coef + x, (87.3258) * coef + y, (6.96994) * coef + z), new Point3D((-0.372748) * coef + x, (116.471) * coef + y, (4.73929) * coef + z));
        list.add(T29);
        Triangle T30 = new Triangle(emissionLight, material, new Point3D((2.93368) * coef + x, (116.471) * coef + y, (9.2902) * coef + z), new Point3D((-0.372748) * coef + x, (116.471) * coef + y, (4.73929) * coef + z), new Point3D((-0.0326515) * coef + x, (87.3258) * coef + y, (6.96994) * coef + z));
        list.add(T30);
        Triangle T31 = new Triangle(emissionLight, material, new Point3D((-0.0326515) * coef + x, (87.3258) * coef + y, (6.96994) * coef + z), new Point3D((4.03425) * coef + x, (87.3258) * coef + y, (12.5676) * coef + z), new Point3D((2.93368) * coef + x, (116.471) * coef + y, (9.2902) * coef + z));
        list.add(T31);
        Triangle T32 = new Triangle(emissionLight, material, new Point3D((11.9359) * coef + x, (158.991) * coef + y, (17.0786) * coef + z), new Point3D((13.3135) * coef + x, (158.991) * coef + y, (15.1824) * coef + z), new Point3D((2.93368) * coef + x, (116.471) * coef + y, (9.2902) * coef + z));
        list.add(T32);
        Triangle T33 = new Triangle(emissionLight, material, new Point3D((2.93368) * coef + x, (116.471) * coef + y, (9.2902) * coef + z), new Point3D((-0.372749) * coef + x, (116.471) * coef + y, (13.8411) * coef + z), new Point3D((11.9359) * coef + x, (158.991) * coef + y, (17.0786) * coef + z));
        list.add(T33);
        Triangle T34 = new Triangle(emissionLight, material, new Point3D((9.70674) * coef + x, (158.991) * coef + y, (16.3543) * coef + z), new Point3D((11.9359) * coef + x, (158.991) * coef + y, (17.0786) * coef + z), new Point3D((-0.372749) * coef + x, (116.471) * coef + y, (13.8411) * coef + z));
        list.add(T34);
        Triangle T35 = new Triangle(emissionLight, material, new Point3D((-0.372749) * coef + x, (116.471) * coef + y, (13.8411) * coef + z), new Point3D((-5.72266) * coef + x, (116.471) * coef + y, (12.1028) * coef + z), new Point3D((9.70674) * coef + x, (158.991) * coef + y, (16.3543) * coef + z));
        list.add(T35);
        Triangle T36 = new Triangle(emissionLight, material, new Point3D((9.70674) * coef + x, (158.991) * coef + y, (14.0104) * coef + z), new Point3D((9.70674) * coef + x, (158.991) * coef + y, (16.3543) * coef + z), new Point3D((-5.72266) * coef + x, (116.471) * coef + y, (12.1028) * coef + z));
        list.add(T36);
        Triangle T37 = new Triangle(emissionLight, material, new Point3D((-5.72266) * coef + x, (116.471) * coef + y, (12.1028) * coef + z), new Point3D((-5.72266) * coef + x, (116.471) * coef + y, (6.47758) * coef + z), new Point3D((9.70674) * coef + x, (158.991) * coef + y, (14.0104) * coef + z));
        list.add(T37);
        Triangle T38 = new Triangle(emissionLight, material, new Point3D((11.9359) * coef + x, (158.991) * coef + y, (13.2862) * coef + z), new Point3D((9.70674) * coef + x, (158.991) * coef + y, (14.0104) * coef + z), new Point3D((-5.72266) * coef + x, (116.471) * coef + y, (6.47758) * coef + z));
        list.add(T38);
        Triangle T39 = new Triangle(emissionLight, material, new Point3D((-5.72266) * coef + x, (116.471) * coef + y, (6.47758) * coef + z), new Point3D((-0.372748) * coef + x, (116.471) * coef + y, (4.73929) * coef + z), new Point3D((11.9359) * coef + x, (158.991) * coef + y, (13.2862) * coef + z));
        list.add(T39);
        Triangle T40 = new Triangle(emissionLight, material, new Point3D((13.3135) * coef + x, (158.991) * coef + y, (15.1824) * coef + z), new Point3D((11.9359) * coef + x, (158.991) * coef + y, (13.2862) * coef + z), new Point3D((-0.372748) * coef + x, (116.471) * coef + y, (4.73929) * coef + z));
        list.add(T40);
        Triangle T41 = new Triangle(emissionLight, material, new Point3D((-0.372748) * coef + x, (116.471) * coef + y, (4.73929) * coef + z), new Point3D((2.93368) * coef + x, (116.471) * coef + y, (9.2902) * coef + z), new Point3D((13.3135) * coef + x, (158.991) * coef + y, (15.1824) * coef + z));
        list.add(T41);
        Triangle T42 = new Triangle(emissionLight, material, new Point3D((11.6423) * coef + x, (195.27) * coef + y, (13.7253) * coef + z), new Point3D((12.3636) * coef + x, (195.27) * coef + y, (12.7325) * coef + z), new Point3D((13.3135) * coef + x, (158.991) * coef + y, (15.1824) * coef + z));
        list.add(T42);
        Triangle T43 = new Triangle(emissionLight, material, new Point3D((13.3135) * coef + x, (158.991) * coef + y, (15.1824) * coef + z), new Point3D((11.9359) * coef + x, (158.991) * coef + y, (17.0786) * coef + z), new Point3D((11.6423) * coef + x, (195.27) * coef + y, (13.7253) * coef + z));
        list.add(T43);
        Triangle T44 = new Triangle(emissionLight, material, new Point3D((10.4752) * coef + x, (195.27) * coef + y, (13.3461) * coef + z), new Point3D((11.6423) * coef + x, (195.27) * coef + y, (13.7253) * coef + z), new Point3D((11.9359) * coef + x, (158.991) * coef + y, (17.0786) * coef + z));
        list.add(T44);
        Triangle T45 = new Triangle(emissionLight, material, new Point3D((11.9359) * coef + x, (158.991) * coef + y, (17.0786) * coef + z), new Point3D((9.70674) * coef + x, (158.991) * coef + y, (16.3543) * coef + z), new Point3D((10.4752) * coef + x, (195.27) * coef + y, (13.3461) * coef + z));
        list.add(T45);
        Triangle T46 = new Triangle(emissionLight, material, new Point3D((10.4752) * coef + x, (195.27) * coef + y, (12.1189) * coef + z), new Point3D((10.4752) * coef + x, (195.27) * coef + y, (13.3461) * coef + z), new Point3D((9.70674) * coef + x, (158.991) * coef + y, (16.3543) * coef + z));
        list.add(T46);
        Triangle T47 = new Triangle(emissionLight, material, new Point3D((9.70674) * coef + x, (158.991) * coef + y, (16.3543) * coef + z), new Point3D((9.70674) * coef + x, (158.991) * coef + y, (14.0104) * coef + z), new Point3D((10.4752) * coef + x, (195.27) * coef + y, (12.1189) * coef + z));
        list.add(T47);
        Triangle T48 = new Triangle(emissionLight, material, new Point3D((11.6423) * coef + x, (195.27) * coef + y, (11.7397) * coef + z), new Point3D((10.4752) * coef + x, (195.27) * coef + y, (12.1189) * coef + z), new Point3D((9.70674) * coef + x, (158.991) * coef + y, (14.0104) * coef + z));
        list.add(T48);
        Triangle T49 = new Triangle(emissionLight, material, new Point3D((9.70674) * coef + x, (158.991) * coef + y, (14.0104) * coef + z), new Point3D((11.9359) * coef + x, (158.991) * coef + y, (13.2862) * coef + z), new Point3D((11.6423) * coef + x, (195.27) * coef + y, (11.7397) * coef + z));
        list.add(T49);
        Triangle T50 = new Triangle(emissionLight, material, new Point3D((12.3636) * coef + x, (195.27) * coef + y, (12.7325) * coef + z), new Point3D((11.6423) * coef + x, (195.27) * coef + y, (11.7397) * coef + z), new Point3D((11.9359) * coef + x, (158.991) * coef + y, (13.2862) * coef + z));
        list.add(T50);
        Triangle T51 = new Triangle(emissionLight, material, new Point3D((11.9359) * coef + x, (158.991) * coef + y, (13.2862) * coef + z), new Point3D((13.3135) * coef + x, (158.991) * coef + y, (15.1824) * coef + z), new Point3D((12.3636) * coef + x, (195.27) * coef + y, (12.7325) * coef + z));
        list.add(T51);
        Triangle T52 = new Triangle(emissionLight, material, new Point3D((-6.73516) * coef + x, (29.0442) * coef + y, (-0.250705) * coef + z), new Point3D((-29.7708) * coef + x, (70.3205) * coef + y, (18.3379) * coef + z), new Point3D((-34.1467) * coef + x, (67.5808) * coef + y, (17.2886) * coef + z));
        list.add(T52);
        Triangle T53 = new Triangle(emissionLight, material, new Point3D((-6.73516) * coef + x, (29.0442) * coef + y, (-0.250705) * coef + z), new Point3D((-0.91051) * coef + x, (32.6909) * coef + y, (1.14595) * coef + z), new Point3D((-29.7708) * coef + x, (70.3205) * coef + y, (18.3379) * coef + z));
        list.add(T53);
        Triangle T54 = new Triangle(emissionLight, material, new Point3D((-0.91051) * coef + x, (32.6909) * coef + y, (1.14595) * coef + z), new Point3D((-28.3456) * coef + x, (69.274) * coef + y, (23.3006) * coef + z), new Point3D((-29.7708) * coef + x, (70.3205) * coef + y, (18.3379) * coef + z));
        list.add(T54);
        Triangle T55 = new Triangle(emissionLight, material, new Point3D((-0.91051) * coef + x, (32.6909) * coef + y, (1.14595) * coef + z), new Point3D((0.986535) * coef + x, (31.298) * coef + y, (7.75175) * coef + z), new Point3D((-28.3456) * coef + x, (69.274) * coef + y, (23.3006) * coef + z));
        list.add(T55);
        Triangle T56 = new Triangle(emissionLight, material, new Point3D((0.986535) * coef + x, (31.298) * coef + y, (7.75175) * coef + z), new Point3D((-31.8407) * coef + x, (65.8876) * coef + y, (25.3185) * coef + z), new Point3D((-28.3456) * coef + x, (69.274) * coef + y, (23.3006) * coef + z));
        list.add(T56);
        Triangle T57 = new Triangle(emissionLight, material, new Point3D((0.986535) * coef + x, (31.298) * coef + y, (7.75175) * coef + z), new Point3D((-3.66568) * coef + x, (26.7904) * coef + y, (10.4377) * coef + z), new Point3D((-31.8407) * coef + x, (65.8876) * coef + y, (25.3185) * coef + z));
        list.add(T57);
        Triangle T58 = new Triangle(emissionLight, material, new Point3D((-3.66568) * coef + x, (26.7904) * coef + y, (10.4377) * coef + z), new Point3D((-35.426) * coef + x, (64.8411) * coef + y, (21.6029) * coef + z), new Point3D((-31.8407) * coef + x, (65.8876) * coef + y, (25.3185) * coef + z));
        list.add(T58);
        Triangle T59 = new Triangle(emissionLight, material, new Point3D((-3.66568) * coef + x, (26.7904) * coef + y, (10.4377) * coef + z), new Point3D((-8.43795) * coef + x, (25.3975) * coef + y, (5.49192) * coef + z), new Point3D((-35.426) * coef + x, (64.8411) * coef + y, (21.6029) * coef + z));
        list.add(T59);
        Triangle T60 = new Triangle(emissionLight, material, new Point3D((-8.43795) * coef + x, (25.3975) * coef + y, (5.49192) * coef + z), new Point3D((-34.1467) * coef + x, (67.5808) * coef + y, (17.2886) * coef + z), new Point3D((-35.426) * coef + x, (64.8411) * coef + y, (21.6029) * coef + z));
        list.add(T60);
        Triangle T61 = new Triangle(emissionLight, material, new Point3D((-8.43795) * coef + x, (25.3975) * coef + y, (5.49192) * coef + z), new Point3D((-6.73516) * coef + x, (29.0442) * coef + y, (-0.250705) * coef + z), new Point3D((-34.1467) * coef + x, (67.5808) * coef + y, (17.2886) * coef + z));
        list.add(T61);
        Triangle T62 = new Triangle(emissionLight, material, new Point3D((-43.7433) * coef + x, (99.9701) * coef + y, (27.19) * coef + z), new Point3D((-45.9708) * coef + x, (98.5755) * coef + y, (26.6558) * coef + z), new Point3D((-34.1467) * coef + x, (67.5808) * coef + y, (17.2886) * coef + z));
        list.add(T62);
        Triangle T63 = new Triangle(emissionLight, material, new Point3D((-34.1467) * coef + x, (67.5808) * coef + y, (17.2886) * coef + z), new Point3D((-29.7708) * coef + x, (70.3205) * coef + y, (18.3379) * coef + z), new Point3D((-43.7433) * coef + x, (99.9701) * coef + y, (27.19) * coef + z));
        list.add(T63);
        Triangle T64 = new Triangle(emissionLight, material, new Point3D((-43.0178) * coef + x, (99.4374) * coef + y, (29.7162) * coef + z), new Point3D((-43.7433) * coef + x, (99.9701) * coef + y, (27.19) * coef + z), new Point3D((-29.7708) * coef + x, (70.3205) * coef + y, (18.3379) * coef + z));
        list.add(T64);
        Triangle T65 = new Triangle(emissionLight, material, new Point3D((-29.7708) * coef + x, (70.3205) * coef + y, (18.3379) * coef + z), new Point3D((-28.3456) * coef + x, (69.274) * coef + y, (23.3006) * coef + z), new Point3D((-43.0178) * coef + x, (99.4374) * coef + y, (29.7162) * coef + z));
        list.add(T65);
        Triangle T66 = new Triangle(emissionLight, material, new Point3D((-44.7969) * coef + x, (97.7136) * coef + y, (30.7434) * coef + z), new Point3D((-43.0178) * coef + x, (99.4374) * coef + y, (29.7162) * coef + z), new Point3D((-28.3456) * coef + x, (69.274) * coef + y, (23.3006) * coef + z));
        list.add(T66);
        Triangle T67 = new Triangle(emissionLight, material, new Point3D((-28.3456) * coef + x, (69.274) * coef + y, (23.3006) * coef + z), new Point3D((-31.8407) * coef + x, (65.8876) * coef + y, (25.3185) * coef + z), new Point3D((-44.7969) * coef + x, (97.7136) * coef + y, (30.7434) * coef + z));
        list.add(T67);
        Triangle T68 = new Triangle(emissionLight, material, new Point3D((-46.622) * coef + x, (97.1809) * coef + y, (28.852) * coef + z), new Point3D((-44.7969) * coef + x, (97.7136) * coef + y, (30.7434) * coef + z), new Point3D((-31.8407) * coef + x, (65.8876) * coef + y, (25.3185) * coef + z));
        list.add(T68);
        Triangle T69 = new Triangle(emissionLight, material, new Point3D((-31.8407) * coef + x, (65.8876) * coef + y, (25.3185) * coef + z), new Point3D((-35.426) * coef + x, (64.8411) * coef + y, (21.6029) * coef + z), new Point3D((-46.622) * coef + x, (97.1809) * coef + y, (28.852) * coef + z));
        list.add(T69);
        Triangle T70 = new Triangle(emissionLight, material, new Point3D((-45.9708) * coef + x, (98.5755) * coef + y, (26.6558) * coef + z), new Point3D((-46.622) * coef + x, (97.1809) * coef + y, (28.852) * coef + z), new Point3D((-35.426) * coef + x, (64.8411) * coef + y, (21.6029) * coef + z));
        list.add(T70);
        Triangle T71 = new Triangle(emissionLight, material, new Point3D((-35.426) * coef + x, (64.8411) * coef + y, (21.6029) * coef + z), new Point3D((-34.1467) * coef + x, (67.5808) * coef + y, (17.2886) * coef + z), new Point3D((-45.9708) * coef + x, (98.5755) * coef + y, (26.6558) * coef + z));
        list.add(T71);
        Triangle T72 = new Triangle(emissionLight, material, new Point3D((-62.6222) * coef + x, (119.573) * coef + y, (38.4496) * coef + z), new Point3D((-63.8649) * coef + x, (118.795) * coef + y, (38.1517) * coef + z), new Point3D((-45.9708) * coef + x, (98.5755) * coef + y, (26.6558) * coef + z));
        list.add(T72);
        Triangle T73 = new Triangle(emissionLight, material, new Point3D((-45.9708) * coef + x, (98.5755) * coef + y, (26.6558) * coef + z), new Point3D((-43.7433) * coef + x, (99.9701) * coef + y, (27.19) * coef + z), new Point3D((-62.6222) * coef + x, (119.573) * coef + y, (38.4496) * coef + z));
        list.add(T73);
        Triangle T74 = new Triangle(emissionLight, material, new Point3D((-62.2175) * coef + x, (119.276) * coef + y, (39.8589) * coef + z), new Point3D((-62.6222) * coef + x, (119.573) * coef + y, (38.4496) * coef + z), new Point3D((-43.7433) * coef + x, (99.9701) * coef + y, (27.19) * coef + z));
        list.add(T74);
        Triangle T75 = new Triangle(emissionLight, material, new Point3D((-43.7433) * coef + x, (99.9701) * coef + y, (27.19) * coef + z), new Point3D((-43.0178) * coef + x, (99.4374) * coef + y, (29.7162) * coef + z), new Point3D((-62.2175) * coef + x, (119.276) * coef + y, (39.8589) * coef + z));
        list.add(T75);
        Triangle T76 = new Triangle(emissionLight, material, new Point3D((-63.21) * coef + x, (118.314) * coef + y, (40.432) * coef + z), new Point3D((-62.2175) * coef + x, (119.276) * coef + y, (39.8589) * coef + z), new Point3D((-43.0178) * coef + x, (99.4374) * coef + y, (29.7162) * coef + z));
        list.add(T76);
        Triangle T77 = new Triangle(emissionLight, material, new Point3D((-43.0178) * coef + x, (99.4374) * coef + y, (29.7162) * coef + z), new Point3D((-44.7969) * coef + x, (97.7136) * coef + y, (30.7434) * coef + z), new Point3D((-63.21) * coef + x, (118.314) * coef + y, (40.432) * coef + z));
        list.add(T77);
        Triangle T78 = new Triangle(emissionLight, material, new Point3D((-64.2282) * coef + x, (118.017) * coef + y, (39.3768) * coef + z), new Point3D((-63.21) * coef + x, (118.314) * coef + y, (40.432) * coef + z), new Point3D((-44.7969) * coef + x, (97.7136) * coef + y, (30.7434) * coef + z));
        list.add(T78);
        Triangle T79 = new Triangle(emissionLight, material, new Point3D((-44.7969) * coef + x, (97.7136) * coef + y, (30.7434) * coef + z), new Point3D((-46.622) * coef + x, (97.1809) * coef + y, (28.852) * coef + z), new Point3D((-64.2282) * coef + x, (118.017) * coef + y, (39.3768) * coef + z));
        list.add(T79);
        Triangle T80 = new Triangle(emissionLight, material, new Point3D((-63.8649) * coef + x, (118.795) * coef + y, (38.1517) * coef + z), new Point3D((-64.2282) * coef + x, (118.017) * coef + y, (39.3768) * coef + z), new Point3D((-46.622) * coef + x, (97.1809) * coef + y, (28.852) * coef + z));
        list.add(T80);
        Triangle T81 = new Triangle(emissionLight, material, new Point3D((-46.622) * coef + x, (97.1809) * coef + y, (28.852) * coef + z), new Point3D((-45.9708) * coef + x, (98.5755) * coef + y, (26.6558) * coef + z), new Point3D((-63.8649) * coef + x, (118.795) * coef + y, (38.1517) * coef + z));
        list.add(T81);
        Triangle T82 = new Triangle(emissionLight, material, new Point3D((4.11379) * coef + x, (74.5779) * coef + y, (7.97069) * coef + z), new Point3D((-0.466572) * coef + x, (115.854) * coef + y, (-21.2731) * coef + z), new Point3D((2.63006) * coef + x, (113.114) * coef + y, (-24.5381) * coef + z));
        list.add(T82);
        Triangle T83 = new Triangle(emissionLight, material, new Point3D((4.11379) * coef + x, (74.5779) * coef + y, (7.97069) * coef + z), new Point3D((-0.00807464) * coef + x, (78.2246) * coef + y, (12.3167) * coef + z), new Point3D((-0.466572) * coef + x, (115.854) * coef + y, (-21.2731) * coef + z));
        list.add(T83);
        Triangle T84 = new Triangle(emissionLight, material, new Point3D((-0.00807464) * coef + x, (78.2246) * coef + y, (12.3167) * coef + z), new Point3D((-5.47702) * coef + x, (114.808) * coef + y, (-22.5202) * coef + z), new Point3D((-0.466572) * coef + x, (115.854) * coef + y, (-21.2731) * coef + z));
        list.add(T84);
        Triangle T85 = new Triangle(emissionLight, material, new Point3D((-0.00807464) * coef + x, (78.2246) * coef + y, (12.3167) * coef + z), new Point3D((-6.67739) * coef + x, (76.8316) * coef + y, (10.6567) * coef + z), new Point3D((-5.47702) * coef + x, (114.808) * coef + y, (-22.5202) * coef + z));
        list.add(T85);
        Triangle T86 = new Triangle(emissionLight, material, new Point3D((-6.67739) * coef + x, (76.8316) * coef + y, (10.6567) * coef + z), new Point3D((-5.47702) * coef + x, (111.421) * coef + y, (-26.5559) * coef + z), new Point3D((-5.47702) * coef + x, (114.808) * coef + y, (-22.5202) * coef + z));
        list.add(T86);
        Triangle T87 = new Triangle(emissionLight, material, new Point3D((-6.67739) * coef + x, (76.8316) * coef + y, (10.6567) * coef + z), new Point3D((-6.67739) * coef + x, (72.3241) * coef + y, (5.28474) * coef + z), new Point3D((-5.47702) * coef + x, (111.421) * coef + y, (-26.5559) * coef + z));
        list.add(T87);
        Triangle T88 = new Triangle(emissionLight, material, new Point3D((-6.67739) * coef + x, (72.3241) * coef + y, (5.28474) * coef + z), new Point3D((-0.466572) * coef + x, (110.375) * coef + y, (-27.803) * coef + z), new Point3D((-5.47702) * coef + x, (111.421) * coef + y, (-26.5559) * coef + z));
        list.add(T88);
        Triangle T89 = new Triangle(emissionLight, material, new Point3D((-6.67739) * coef + x, (72.3241) * coef + y, (5.28474) * coef + z), new Point3D((-0.00807369) * coef + x, (70.9312) * coef + y, (3.62473) * coef + z), new Point3D((-0.466572) * coef + x, (110.375) * coef + y, (-27.803) * coef + z));
        list.add(T89);
        Triangle T90 = new Triangle(emissionLight, material, new Point3D((-0.00807369) * coef + x, (70.9312) * coef + y, (3.62473) * coef + z), new Point3D((2.63006) * coef + x, (113.114) * coef + y, (-24.5381) * coef + z), new Point3D((-0.466572) * coef + x, (110.375) * coef + y, (-27.803) * coef + z));
        list.add(T90);
        Triangle T91 = new Triangle(emissionLight, material, new Point3D((-0.00807369) * coef + x, (70.9312) * coef + y, (3.62473) * coef + z), new Point3D((4.11379) * coef + x, (74.5779) * coef + y, (7.97069) * coef + z), new Point3D((2.63006) * coef + x, (113.114) * coef + y, (-24.5381) * coef + z));
        list.add(T91);
        Triangle T92 = new Triangle(emissionLight, material, new Point3D((-1.14647) * coef + x, (145.504) * coef + y, (-37.7996) * coef + z), new Point3D((0.429846) * coef + x, (144.109) * coef + y, (-39.4616) * coef + z), new Point3D((2.63006) * coef + x, (113.114) * coef + y, (-24.5381) * coef + z));
        list.add(T92);
        Triangle T93 = new Triangle(emissionLight, material, new Point3D((2.63006) * coef + x, (113.114) * coef + y, (-24.5381) * coef + z), new Point3D((-0.466572) * coef + x, (115.854) * coef + y, (-21.2731) * coef + z), new Point3D((-1.14647) * coef + x, (145.504) * coef + y, (-37.7996) * coef + z));
        list.add(T93);
        Triangle T94 = new Triangle(emissionLight, material, new Point3D((-3.69701) * coef + x, (144.971) * coef + y, (-38.4344) * coef + z), new Point3D((-1.14647) * coef + x, (145.504) * coef + y, (-37.7996) * coef + z), new Point3D((-0.466572) * coef + x, (115.854) * coef + y, (-21.2731) * coef + z));
        list.add(T94);
        Triangle T95 = new Triangle(emissionLight, material, new Point3D((-0.466572) * coef + x, (115.854) * coef + y, (-21.2731) * coef + z), new Point3D((-5.47702) * coef + x, (114.808) * coef + y, (-22.5202) * coef + z), new Point3D((-3.69701) * coef + x, (144.971) * coef + y, (-38.4344) * coef + z));
        list.add(T95);
        Triangle T96 = new Triangle(emissionLight, material, new Point3D((-3.69701) * coef + x, (143.247) * coef + y, (-40.4888) * coef + z), new Point3D((-3.69701) * coef + x, (144.971) * coef + y, (-38.4344) * coef + z), new Point3D((-5.47702) * coef + x, (114.808) * coef + y, (-22.5202) * coef + z));
        list.add(T96);
        Triangle T97 = new Triangle(emissionLight, material, new Point3D((-5.47702) * coef + x, (114.808) * coef + y, (-22.5202) * coef + z), new Point3D((-5.47702) * coef + x, (111.421) * coef + y, (-26.5559) * coef + z), new Point3D((-3.69701) * coef + x, (143.247) * coef + y, (-40.4888) * coef + z));
        list.add(T97);
        Triangle T98 = new Triangle(emissionLight, material, new Point3D((-1.14647) * coef + x, (142.715) * coef + y, (-41.1236) * coef + z), new Point3D((-3.69701) * coef + x, (143.247) * coef + y, (-40.4888) * coef + z), new Point3D((-5.47702) * coef + x, (111.421) * coef + y, (-26.5559) * coef + z));
        list.add(T98);
        Triangle T99 = new Triangle(emissionLight, material, new Point3D((-5.47702) * coef + x, (111.421) * coef + y, (-26.5559) * coef + z), new Point3D((-0.466572) * coef + x, (110.375) * coef + y, (-27.803) * coef + z), new Point3D((-1.14647) * coef + x, (142.715) * coef + y, (-41.1236) * coef + z));
        list.add(T99);
        Triangle T100 = new Triangle(emissionLight, material, new Point3D((0.429846) * coef + x, (144.109) * coef + y, (-39.4616) * coef + z), new Point3D((-1.14647) * coef + x, (142.715) * coef + y, (-41.1236) * coef + z), new Point3D((-0.466572) * coef + x, (110.375) * coef + y, (-27.803) * coef + z));
        list.add(T100);
        Triangle T101 = new Triangle(emissionLight, material, new Point3D((-0.466572) * coef + x, (110.375) * coef + y, (-27.803) * coef + z), new Point3D((2.63006) * coef + x, (113.114) * coef + y, (-24.5381) * coef + z), new Point3D((0.429846) * coef + x, (144.109) * coef + y, (-39.4616) * coef + z));
        list.add(T101);
        Triangle T102 = new Triangle(emissionLight, material, new Point3D((-1.45816) * coef + x, (165.107) * coef + y, (-59.7791) * coef + z), new Point3D((-0.57879) * coef + x, (164.329) * coef + y, (-60.7063) * coef + z), new Point3D((0.429846) * coef + x, (144.109) * coef + y, (-39.4616) * coef + z));
        list.add(T102);
        Triangle T103 = new Triangle(emissionLight, material, new Point3D((0.429846) * coef + x, (144.109) * coef + y, (-39.4616) * coef + z), new Point3D((-1.14647) * coef + x, (145.504) * coef + y, (-37.7996) * coef + z), new Point3D((-1.45816) * coef + x, (165.107) * coef + y, (-59.7791) * coef + z));
        list.add(T103);
        Triangle T104 = new Triangle(emissionLight, material, new Point3D((-2.88101) * coef + x, (164.81) * coef + y, (-60.1333) * coef + z), new Point3D((-1.45816) * coef + x, (165.107) * coef + y, (-59.7791) * coef + z), new Point3D((-1.14647) * coef + x, (145.504) * coef + y, (-37.7996) * coef + z));
        list.add(T104);
        Triangle T105 = new Triangle(emissionLight, material, new Point3D((-1.14647) * coef + x, (145.504) * coef + y, (-37.7996) * coef + z), new Point3D((-3.69701) * coef + x, (144.971) * coef + y, (-38.4344) * coef + z), new Point3D((-2.88101) * coef + x, (164.81) * coef + y, (-60.1333) * coef + z));
        list.add(T105);
        Triangle T106 = new Triangle(emissionLight, material, new Point3D((-2.88101) * coef + x, (163.848) * coef + y, (-61.2793) * coef + z), new Point3D((-2.88101) * coef + x, (164.81) * coef + y, (-60.1333) * coef + z), new Point3D((-3.69701) * coef + x, (144.971) * coef + y, (-38.4344) * coef + z));
        list.add(T106);
        Triangle T107 = new Triangle(emissionLight, material, new Point3D((-3.69701) * coef + x, (144.971) * coef + y, (-38.4344) * coef + z), new Point3D((-3.69701) * coef + x, (143.247) * coef + y, (-40.4888) * coef + z), new Point3D((-2.88101) * coef + x, (163.848) * coef + y, (-61.2793) * coef + z));
        list.add(T107);
        Triangle T108 = new Triangle(emissionLight, material, new Point3D((-1.45816) * coef + x, (163.551) * coef + y, (-61.6335) * coef + z), new Point3D((-2.88101) * coef + x, (163.848) * coef + y, (-61.2793) * coef + z), new Point3D((-3.69701) * coef + x, (143.247) * coef + y, (-40.4888) * coef + z));
        list.add(T108);
        Triangle T109 = new Triangle(emissionLight, material, new Point3D((-3.69701) * coef + x, (143.247) * coef + y, (-40.4888) * coef + z), new Point3D((-1.14647) * coef + x, (142.715) * coef + y, (-41.1236) * coef + z), new Point3D((-1.45816) * coef + x, (163.551) * coef + y, (-61.6335) * coef + z));
        list.add(T109);

    }


    public List<Intersectable.GeoPoint> findIntersections(Ray ray, double MAXDISTANCE) {

        List<Intersectable.GeoPoint> intersections = new LinkedList<Intersectable.GeoPoint>();

       /*for (Triangle t : list) {
            if (t.findIntersections(ray, MAXDISTANCE) != null)
                intersections.add(t.findIntersections(ray, MAXDISTANCE).get(0));
        }*/
        for (Triangle x :list
        ) {
            List<GeoPoint> _geopoints = x.findIntersections(ray, MAXDISTANCE);
            if(_geopoints != null )intersections.add(_geopoints.get(0)); }

        return intersections;
    }
}
