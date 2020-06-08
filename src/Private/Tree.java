package Private;

import elements.Material;
import geometries.Geometries;
import geometries.Intersectable;
import geometries.Polygon;
import geometries.Triangle;
import primitives.Color;
import primitives.Point3D;
import primitives.Ray;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tree extends Geometries {


    List<Triangle> list = new LinkedList<Triangle>();

    public Tree(Color emissionLight, Material material) {

        Triangle T2 = new Triangle(emissionLight,material,new Point3D(6.97709, 0.0, 4.07666 ) ,new Point3D(0.876735, 53.9898, 12.4731 ) ,new Point3D(6.97709, 53.9898, 4.07666)  );
        list.add(T2);
        Triangle T3 = new Triangle(emissionLight,material,new Point3D(6.97709, 0.0, 4.07666 ) ,new Point3D(0.876735, 0.0, 12.4731 ) ,new Point3D(0.876735, 53.9898, 12.4731)  );
        list.add(T3);
        Triangle T4 = new Triangle(emissionLight,material,new Point3D(0.876735, 0.0, 12.4731 ) ,new Point3D(-8.99385, 53.9898, 9.26593 ) ,new Point3D(0.876735, 53.9898, 12.4731)  );
        list.add(T4);
        Triangle T5 = new Triangle(emissionLight,material,new Point3D(0.876735, 0.0, 12.4731 ) ,new Point3D(-8.99385, 0.0, 9.26593 ) ,new Point3D(-8.99385, 53.9898, 9.26593)  );
        list.add(T5);
        Triangle T6 = new Triangle(emissionLight,material,new Point3D(-8.99385, 0.0, 9.26593 ) ,new Point3D(-8.99385, 53.9898, -1.11262 ) ,new Point3D(-8.99385, 53.9898, 9.26593)  );
        list.add(T6);
        Triangle T7 = new Triangle(emissionLight,material,new Point3D(-8.99385, 0.0, 9.26593 ) ,new Point3D(-8.99385, 0.0, -1.11262 ) ,new Point3D(-8.99385, 53.9898, -1.11262)  );
        list.add(T7);
        Triangle T8 = new Triangle(emissionLight,material,new Point3D(-8.99385, 0.0, -1.11262 ) ,new Point3D(0.876737, 53.9898, -4.31977 ) ,new Point3D(-8.99385, 53.9898, -1.11262)  );
        list.add(T8);
        Triangle T9 = new Triangle(emissionLight,material,new Point3D(-8.99385, 0.0, -1.11262 ) ,new Point3D(0.876737, 0.0, -4.31977 ) ,new Point3D(0.876737, 53.9898, -4.31977)  );
        list.add(T9);
        Triangle T10 = new Triangle(emissionLight,material,new Point3D(0.876737, 0.0, -4.31977 ) ,new Point3D(6.97709, 53.9898, 4.07666 ) ,new Point3D(0.876737, 53.9898, -4.31977)  );
        list.add(T10);
        Triangle T11 = new Triangle(emissionLight,material,new Point3D(0.876737, 0.0, -4.31977 ) ,new Point3D(6.97709, 0.0, 4.07666 ) ,new Point3D(6.97709, 53.9898, 4.07666)  );
        list.add(T11);
        Triangle T12 = new Triangle(emissionLight,material,new Point3D(-0.0326525, 87.3258, 18.1652 ) ,new Point3D(4.03425, 87.3258, 12.5676 ) ,new Point3D(6.97709, 53.9898, 4.07666)  );
        list.add(T12);
        Triangle T13 = new Triangle(emissionLight,material,new Point3D(6.97709, 53.9898, 4.07666 ) ,new Point3D(0.876735, 53.9898, 12.4731 ) ,new Point3D(-0.0326525, 87.3258, 18.1652)  );
        list.add(T13);
        Triangle T14 = new Triangle(emissionLight,material,new Point3D(-6.61304, 87.3258, 16.0271 ) ,new Point3D(-0.0326525, 87.3258, 18.1652 ) ,new Point3D(0.876735, 53.9898, 12.4731)  );
        list.add(T14);
        Triangle T15 = new Triangle(emissionLight,material,new Point3D(0.876735, 53.9898, 12.4731 ) ,new Point3D(-8.99385, 53.9898, 9.26593 ) ,new Point3D(-6.61304, 87.3258, 16.0271)  );
        list.add(T15);
        Triangle T16 = new Triangle(emissionLight,material,new Point3D(-6.61304, 87.3258, 9.10804 ) ,new Point3D(-6.61304, 87.3258, 16.0271 ) ,new Point3D(-8.99385, 53.9898, 9.26593)  );
        list.add(T16);
        Triangle T17 = new Triangle(emissionLight,material,new Point3D(-8.99385, 53.9898, 9.26593 ) ,new Point3D(-8.99385, 53.9898, -1.11262 ) ,new Point3D(-6.61304, 87.3258, 9.10804)  );
        list.add(T17);
        Triangle T18 = new Triangle(emissionLight,material,new Point3D(-0.0326515, 87.3258, 6.96994 ) ,new Point3D(-6.61304, 87.3258, 9.10804 ) ,new Point3D(-8.99385, 53.9898, -1.11262)  );
        list.add(T18);
        Triangle T19 = new Triangle(emissionLight,material,new Point3D(-8.99385, 53.9898, -1.11262 ) ,new Point3D(0.876737, 53.9898, -4.31977 ) ,new Point3D(-0.0326515, 87.3258, 6.96994)  );
        list.add(T19);
        Triangle T20 = new Triangle(emissionLight,material,new Point3D(4.03425, 87.3258, 12.5676 ) ,new Point3D(-0.0326515, 87.3258, 6.96994 ) ,new Point3D(0.876737, 53.9898, -4.31977)  );
        list.add(T20);
        Triangle T21 = new Triangle(emissionLight,material,new Point3D(0.876737, 53.9898, -4.31977 ) ,new Point3D(6.97709, 53.9898, 4.07666 ) ,new Point3D(4.03425, 87.3258, 12.5676)  );
        list.add(T21);
        Triangle T22 = new Triangle(emissionLight,material,new Point3D(-0.372749, 116.471, 13.8411 ) ,new Point3D(2.93368, 116.471, 9.2902 ) ,new Point3D(4.03425, 87.3258, 12.5676)  );
        list.add(T22);
        Triangle T23 = new Triangle(emissionLight,material,new Point3D(4.03425, 87.3258, 12.5676 ) ,new Point3D(-0.0326525, 87.3258, 18.1652 ) ,new Point3D(-0.372749, 116.471, 13.8411)  );
        list.add(T23);
        Triangle T24 = new Triangle(emissionLight,material,new Point3D(-5.72266, 116.471, 12.1028 ) ,new Point3D(-0.372749, 116.471, 13.8411 ) ,new Point3D(-0.0326525, 87.3258, 18.1652)  );
        list.add(T24);
        Triangle T25 = new Triangle(emissionLight,material,new Point3D(-0.0326525, 87.3258, 18.1652 ) ,new Point3D(-6.61304, 87.3258, 16.0271 ) ,new Point3D(-5.72266, 116.471, 12.1028)  );
        list.add(T25);
        Triangle T26 = new Triangle(emissionLight,material,new Point3D(-5.72266, 116.471, 6.47758 ) ,new Point3D(-5.72266, 116.471, 12.1028 ) ,new Point3D(-6.61304, 87.3258, 16.0271)  );
        list.add(T26);
        Triangle T27 = new Triangle(emissionLight,material,new Point3D(-6.61304, 87.3258, 16.0271 ) ,new Point3D(-6.61304, 87.3258, 9.10804 ) ,new Point3D(-5.72266, 116.471, 6.47758)  );
        list.add(T27);
        Triangle T28 = new Triangle(emissionLight,material,new Point3D(-0.372748, 116.471, 4.73929 ) ,new Point3D(-5.72266, 116.471, 6.47758 ) ,new Point3D(-6.61304, 87.3258, 9.10804)  );
        list.add(T28);
        Triangle T29 = new Triangle(emissionLight,material,new Point3D(-6.61304, 87.3258, 9.10804 ) ,new Point3D(-0.0326515, 87.3258, 6.96994 ) ,new Point3D(-0.372748, 116.471, 4.73929)  );
        list.add(T29);
        Triangle T30 = new Triangle(emissionLight,material,new Point3D(2.93368, 116.471, 9.2902 ) ,new Point3D(-0.372748, 116.471, 4.73929 ) ,new Point3D(-0.0326515, 87.3258, 6.96994)  );
        list.add(T30);
        Triangle T31 = new Triangle(emissionLight,material,new Point3D(-0.0326515, 87.3258, 6.96994 ) ,new Point3D(4.03425, 87.3258, 12.5676 ) ,new Point3D(2.93368, 116.471, 9.2902)  );
        list.add(T31);
        Triangle T32 = new Triangle(emissionLight,material,new Point3D(11.9359, 158.991, 17.0786 ) ,new Point3D(13.3135, 158.991, 15.1824 ) ,new Point3D(2.93368, 116.471, 9.2902)  );
        list.add(T32);
        Triangle T33 = new Triangle(emissionLight,material,new Point3D(2.93368, 116.471, 9.2902 ) ,new Point3D(-0.372749, 116.471, 13.8411 ) ,new Point3D(11.9359, 158.991, 17.0786)  );
        list.add(T33);
        Triangle T34 = new Triangle(emissionLight,material,new Point3D(9.70674, 158.991, 16.3543 ) ,new Point3D(11.9359, 158.991, 17.0786 ) ,new Point3D(-0.372749, 116.471, 13.8411)  );
        list.add(T34);
        Triangle T35 = new Triangle(emissionLight,material,new Point3D(-0.372749, 116.471, 13.8411 ) ,new Point3D(-5.72266, 116.471, 12.1028 ) ,new Point3D(9.70674, 158.991, 16.3543)  );
        list.add(T35);
        Triangle T36 = new Triangle(emissionLight,material,new Point3D(9.70674, 158.991, 14.0104 ) ,new Point3D(9.70674, 158.991, 16.3543 ) ,new Point3D(-5.72266, 116.471, 12.1028)  );
        list.add(T36);
        Triangle T37 = new Triangle(emissionLight,material,new Point3D(-5.72266, 116.471, 12.1028 ) ,new Point3D(-5.72266, 116.471, 6.47758 ) ,new Point3D(9.70674, 158.991, 14.0104)  );
        list.add(T37);
        Triangle T38 = new Triangle(emissionLight,material,new Point3D(11.9359, 158.991, 13.2862 ) ,new Point3D(9.70674, 158.991, 14.0104 ) ,new Point3D(-5.72266, 116.471, 6.47758)  );
        list.add(T38);
        Triangle T39 = new Triangle(emissionLight,material,new Point3D(-5.72266, 116.471, 6.47758 ) ,new Point3D(-0.372748, 116.471, 4.73929 ) ,new Point3D(11.9359, 158.991, 13.2862)  );
        list.add(T39);
        Triangle T40 = new Triangle(emissionLight,material,new Point3D(13.3135, 158.991, 15.1824 ) ,new Point3D(11.9359, 158.991, 13.2862 ) ,new Point3D(-0.372748, 116.471, 4.73929)  );
        list.add(T40);
        Triangle T41 = new Triangle(emissionLight,material,new Point3D(-0.372748, 116.471, 4.73929 ) ,new Point3D(2.93368, 116.471, 9.2902 ) ,new Point3D(13.3135, 158.991, 15.1824)  );
        list.add(T41);
        Triangle T42 = new Triangle(emissionLight,material,new Point3D(11.6423, 195.27, 13.7253 ) ,new Point3D(12.3636, 195.27, 12.7325 ) ,new Point3D(13.3135, 158.991, 15.1824)  );
        list.add(T42);
        Triangle T43 = new Triangle(emissionLight,material,new Point3D(13.3135, 158.991, 15.1824 ) ,new Point3D(11.9359, 158.991, 17.0786 ) ,new Point3D(11.6423, 195.27, 13.7253)  );
        list.add(T43);
        Triangle T44 = new Triangle(emissionLight,material,new Point3D(10.4752, 195.27, 13.3461 ) ,new Point3D(11.6423, 195.27, 13.7253 ) ,new Point3D(11.9359, 158.991, 17.0786)  );
        list.add(T44);
        Triangle T45 = new Triangle(emissionLight,material,new Point3D(11.9359, 158.991, 17.0786 ) ,new Point3D(9.70674, 158.991, 16.3543 ) ,new Point3D(10.4752, 195.27, 13.3461)  );
        list.add(T45);
        Triangle T46 = new Triangle(emissionLight,material,new Point3D(10.4752, 195.27, 12.1189 ) ,new Point3D(10.4752, 195.27, 13.3461 ) ,new Point3D(9.70674, 158.991, 16.3543)  );
        list.add(T46);
        Triangle T47 = new Triangle(emissionLight,material,new Point3D(9.70674, 158.991, 16.3543 ) ,new Point3D(9.70674, 158.991, 14.0104 ) ,new Point3D(10.4752, 195.27, 12.1189)  );
        list.add(T47);
        Triangle T48 = new Triangle(emissionLight,material,new Point3D(11.6423, 195.27, 11.7397 ) ,new Point3D(10.4752, 195.27, 12.1189 ) ,new Point3D(9.70674, 158.991, 14.0104)  );
        list.add(T48);
        Triangle T49 = new Triangle(emissionLight,material,new Point3D(9.70674, 158.991, 14.0104 ) ,new Point3D(11.9359, 158.991, 13.2862 ) ,new Point3D(11.6423, 195.27, 11.7397)  );
        list.add(T49);
        Triangle T50 = new Triangle(emissionLight,material,new Point3D(12.3636, 195.27, 12.7325 ) ,new Point3D(11.6423, 195.27, 11.7397 ) ,new Point3D(11.9359, 158.991, 13.2862)  );
        list.add(T50);
        Triangle T51 = new Triangle(emissionLight,material,new Point3D(11.9359, 158.991, 13.2862 ) ,new Point3D(13.3135, 158.991, 15.1824 ) ,new Point3D(12.3636, 195.27, 12.7325)  );
        list.add(T51);
        Triangle T52 = new Triangle(emissionLight,material,new Point3D(-6.73516, 29.0442, -0.250705 ) ,new Point3D(-29.7708, 70.3205, 18.3379 ) ,new Point3D(-34.1467, 67.5808, 17.2886)  );
        list.add(T52);
        Triangle T53 = new Triangle(emissionLight,material,new Point3D(-6.73516, 29.0442, -0.250705 ) ,new Point3D(-0.91051, 32.6909, 1.14595 ) ,new Point3D(-29.7708, 70.3205, 18.3379)  );
        list.add(T53);
        Triangle T54 = new Triangle(emissionLight,material,new Point3D(-0.91051, 32.6909, 1.14595 ) ,new Point3D(-28.3456, 69.274, 23.3006 ) ,new Point3D(-29.7708, 70.3205, 18.3379)  );
        list.add(T54);
        Triangle T55 = new Triangle(emissionLight,material,new Point3D(-0.91051, 32.6909, 1.14595 ) ,new Point3D(0.986535, 31.298, 7.75175 ) ,new Point3D(-28.3456, 69.274, 23.3006)  );
        list.add(T55);
        Triangle T56 = new Triangle(emissionLight,material,new Point3D(0.986535, 31.298, 7.75175 ) ,new Point3D(-31.8407, 65.8876, 25.3185 ) ,new Point3D(-28.3456, 69.274, 23.3006)  );
        list.add(T56);
        Triangle T57 = new Triangle(emissionLight,material,new Point3D(0.986535, 31.298, 7.75175 ) ,new Point3D(-3.66568, 26.7904, 10.4377 ) ,new Point3D(-31.8407, 65.8876, 25.3185)  );
        list.add(T57);
        Triangle T58 = new Triangle(emissionLight,material,new Point3D(-3.66568, 26.7904, 10.4377 ) ,new Point3D(-35.426, 64.8411, 21.6029 ) ,new Point3D(-31.8407, 65.8876, 25.3185)  );
        list.add(T58);
        Triangle T59 = new Triangle(emissionLight,material,new Point3D(-3.66568, 26.7904, 10.4377 ) ,new Point3D(-8.43795, 25.3975, 5.49192 ) ,new Point3D(-35.426, 64.8411, 21.6029)  );
        list.add(T59);
        Triangle T60 = new Triangle(emissionLight,material,new Point3D(-8.43795, 25.3975, 5.49192 ) ,new Point3D(-34.1467, 67.5808, 17.2886 ) ,new Point3D(-35.426, 64.8411, 21.6029)  );
        list.add(T60);
        Triangle T61 = new Triangle(emissionLight,material,new Point3D(-8.43795, 25.3975, 5.49192 ) ,new Point3D(-6.73516, 29.0442, -0.250705 ) ,new Point3D(-34.1467, 67.5808, 17.2886)  );
        list.add(T61);
        Triangle T62 = new Triangle(emissionLight,material,new Point3D(-43.7433, 99.9701, 27.19 ) ,new Point3D(-45.9708, 98.5755, 26.6558 ) ,new Point3D(-34.1467, 67.5808, 17.2886)  );
        list.add(T62);
        Triangle T63 = new Triangle(emissionLight,material,new Point3D(-34.1467, 67.5808, 17.2886 ) ,new Point3D(-29.7708, 70.3205, 18.3379 ) ,new Point3D(-43.7433, 99.9701, 27.19)  );
        list.add(T63);
        Triangle T64 = new Triangle(emissionLight,material,new Point3D(-43.0178, 99.4374, 29.7162 ) ,new Point3D(-43.7433, 99.9701, 27.19 ) ,new Point3D(-29.7708, 70.3205, 18.3379)  );
        list.add(T64);
        Triangle T65 = new Triangle(emissionLight,material,new Point3D(-29.7708, 70.3205, 18.3379 ) ,new Point3D(-28.3456, 69.274, 23.3006 ) ,new Point3D(-43.0178, 99.4374, 29.7162)  );
        list.add(T65);
        Triangle T66 = new Triangle(emissionLight,material,new Point3D(-44.7969, 97.7136, 30.7434 ) ,new Point3D(-43.0178, 99.4374, 29.7162 ) ,new Point3D(-28.3456, 69.274, 23.3006)  );
        list.add(T66);
        Triangle T67 = new Triangle(emissionLight,material,new Point3D(-28.3456, 69.274, 23.3006 ) ,new Point3D(-31.8407, 65.8876, 25.3185 ) ,new Point3D(-44.7969, 97.7136, 30.7434)  );
        list.add(T67);
        Triangle T68 = new Triangle(emissionLight,material,new Point3D(-46.622, 97.1809, 28.852 ) ,new Point3D(-44.7969, 97.7136, 30.7434 ) ,new Point3D(-31.8407, 65.8876, 25.3185)  );
        list.add(T68);
        Triangle T69 = new Triangle(emissionLight,material,new Point3D(-31.8407, 65.8876, 25.3185 ) ,new Point3D(-35.426, 64.8411, 21.6029 ) ,new Point3D(-46.622, 97.1809, 28.852)  );
        list.add(T69);
        Triangle T70 = new Triangle(emissionLight,material,new Point3D(-45.9708, 98.5755, 26.6558 ) ,new Point3D(-46.622, 97.1809, 28.852 ) ,new Point3D(-35.426, 64.8411, 21.6029)  );
        list.add(T70);
        Triangle T71 = new Triangle(emissionLight,material,new Point3D(-35.426, 64.8411, 21.6029 ) ,new Point3D(-34.1467, 67.5808, 17.2886 ) ,new Point3D(-45.9708, 98.5755, 26.6558)  );
        list.add(T71);
        Triangle T72 = new Triangle(emissionLight,material,new Point3D(-62.6222, 119.573, 38.4496 ) ,new Point3D(-63.8649, 118.795, 38.1517 ) ,new Point3D(-45.9708, 98.5755, 26.6558)  );
        list.add(T72);
        Triangle T73 = new Triangle(emissionLight,material,new Point3D(-45.9708, 98.5755, 26.6558 ) ,new Point3D(-43.7433, 99.9701, 27.19 ) ,new Point3D(-62.6222, 119.573, 38.4496)  );
        list.add(T73);
        Triangle T74 = new Triangle(emissionLight,material,new Point3D(-62.2175, 119.276, 39.8589 ) ,new Point3D(-62.6222, 119.573, 38.4496 ) ,new Point3D(-43.7433, 99.9701, 27.19)  );
        list.add(T74);
        Triangle T75 = new Triangle(emissionLight,material,new Point3D(-43.7433, 99.9701, 27.19 ) ,new Point3D(-43.0178, 99.4374, 29.7162 ) ,new Point3D(-62.2175, 119.276, 39.8589)  );
        list.add(T75);
        Triangle T76 = new Triangle(emissionLight,material,new Point3D(-63.21, 118.314, 40.432 ) ,new Point3D(-62.2175, 119.276, 39.8589 ) ,new Point3D(-43.0178, 99.4374, 29.7162)  );
        list.add(T76);
        Triangle T77 = new Triangle(emissionLight,material,new Point3D(-43.0178, 99.4374, 29.7162 ) ,new Point3D(-44.7969, 97.7136, 30.7434 ) ,new Point3D(-63.21, 118.314, 40.432)  );
        list.add(T77);
        Triangle T78 = new Triangle(emissionLight,material,new Point3D(-64.2282, 118.017, 39.3768 ) ,new Point3D(-63.21, 118.314, 40.432 ) ,new Point3D(-44.7969, 97.7136, 30.7434)  );
        list.add(T78);
        Triangle T79 = new Triangle(emissionLight,material,new Point3D(-44.7969, 97.7136, 30.7434 ) ,new Point3D(-46.622, 97.1809, 28.852 ) ,new Point3D(-64.2282, 118.017, 39.3768)  );
        list.add(T79);
        Triangle T80 = new Triangle(emissionLight,material,new Point3D(-63.8649, 118.795, 38.1517 ) ,new Point3D(-64.2282, 118.017, 39.3768 ) ,new Point3D(-46.622, 97.1809, 28.852)  );
        list.add(T80);
        Triangle T81 = new Triangle(emissionLight,material,new Point3D(-46.622, 97.1809, 28.852 ) ,new Point3D(-45.9708, 98.5755, 26.6558 ) ,new Point3D(-63.8649, 118.795, 38.1517)  );
        list.add(T81);
        Triangle T82 = new Triangle(emissionLight,material,new Point3D(4.11379, 74.5779, 7.97069 ) ,new Point3D(-0.466572, 115.854, -21.2731 ) ,new Point3D(2.63006, 113.114, -24.5381)  );
        list.add(T82);
        Triangle T83 = new Triangle(emissionLight,material,new Point3D(4.11379, 74.5779, 7.97069 ) ,new Point3D(-0.00807464, 78.2246, 12.3167 ) ,new Point3D(-0.466572, 115.854, -21.2731)  );
        list.add(T83);
        Triangle T84 = new Triangle(emissionLight,material,new Point3D(-0.00807464, 78.2246, 12.3167 ) ,new Point3D(-5.47702, 114.808, -22.5202 ) ,new Point3D(-0.466572, 115.854, -21.2731)  );
        list.add(T84);
        Triangle T85 = new Triangle(emissionLight,material,new Point3D(-0.00807464, 78.2246, 12.3167 ) ,new Point3D(-6.67739, 76.8316, 10.6567 ) ,new Point3D(-5.47702, 114.808, -22.5202)  );
        list.add(T85);
        Triangle T86 = new Triangle(emissionLight,material,new Point3D(-6.67739, 76.8316, 10.6567 ) ,new Point3D(-5.47702, 111.421, -26.5559 ) ,new Point3D(-5.47702, 114.808, -22.5202)  );
        list.add(T86);
        Triangle T87 = new Triangle(emissionLight,material,new Point3D(-6.67739, 76.8316, 10.6567 ) ,new Point3D(-6.67739, 72.3241, 5.28474 ) ,new Point3D(-5.47702, 111.421, -26.5559)  );
        list.add(T87);
        Triangle T88 = new Triangle(emissionLight,material,new Point3D(-6.67739, 72.3241, 5.28474 ) ,new Point3D(-0.466572, 110.375, -27.803 ) ,new Point3D(-5.47702, 111.421, -26.5559)  );
        list.add(T88);
        Triangle T89 = new Triangle(emissionLight,material,new Point3D(-6.67739, 72.3241, 5.28474 ) ,new Point3D(-0.00807369, 70.9312, 3.62473 ) ,new Point3D(-0.466572, 110.375, -27.803)  );
        list.add(T89);
        Triangle T90 = new Triangle(emissionLight,material,new Point3D(-0.00807369, 70.9312, 3.62473 ) ,new Point3D(2.63006, 113.114, -24.5381 ) ,new Point3D(-0.466572, 110.375, -27.803)  );
        list.add(T90);
        Triangle T91 = new Triangle(emissionLight,material,new Point3D(-0.00807369, 70.9312, 3.62473 ) ,new Point3D(4.11379, 74.5779, 7.97069 ) ,new Point3D(2.63006, 113.114, -24.5381)  );
        list.add(T91);
        Triangle T92 = new Triangle(emissionLight,material,new Point3D(-1.14647, 145.504, -37.7996 ) ,new Point3D(0.429846, 144.109, -39.4616 ) ,new Point3D(2.63006, 113.114, -24.5381)  );
        list.add(T92);
        Triangle T93 = new Triangle(emissionLight,material,new Point3D(2.63006, 113.114, -24.5381 ) ,new Point3D(-0.466572, 115.854, -21.2731 ) ,new Point3D(-1.14647, 145.504, -37.7996)  );
        list.add(T93);
        Triangle T94 = new Triangle(emissionLight,material,new Point3D(-3.69701, 144.971, -38.4344 ) ,new Point3D(-1.14647, 145.504, -37.7996 ) ,new Point3D(-0.466572, 115.854, -21.2731)  );
        list.add(T94);
        Triangle T95 = new Triangle(emissionLight,material,new Point3D(-0.466572, 115.854, -21.2731 ) ,new Point3D(-5.47702, 114.808, -22.5202 ) ,new Point3D(-3.69701, 144.971, -38.4344)  );
        list.add(T95);
        Triangle T96 = new Triangle(emissionLight,material,new Point3D(-3.69701, 143.247, -40.4888 ) ,new Point3D(-3.69701, 144.971, -38.4344 ) ,new Point3D(-5.47702, 114.808, -22.5202)  );
        list.add(T96);
        Triangle T97 = new Triangle(emissionLight,material,new Point3D(-5.47702, 114.808, -22.5202 ) ,new Point3D(-5.47702, 111.421, -26.5559 ) ,new Point3D(-3.69701, 143.247, -40.4888)  );
        list.add(T97);
        Triangle T98 = new Triangle(emissionLight,material,new Point3D(-1.14647, 142.715, -41.1236 ) ,new Point3D(-3.69701, 143.247, -40.4888 ) ,new Point3D(-5.47702, 111.421, -26.5559)  );
        list.add(T98);
        Triangle T99 = new Triangle(emissionLight,material,new Point3D(-5.47702, 111.421, -26.5559 ) ,new Point3D(-0.466572, 110.375, -27.803 ) ,new Point3D(-1.14647, 142.715, -41.1236)  );
        list.add(T99);
        Triangle T100 = new Triangle(emissionLight,material,new Point3D(0.429846, 144.109, -39.4616 ) ,new Point3D(-1.14647, 142.715, -41.1236 ) ,new Point3D(-0.466572, 110.375, -27.803)  );
        list.add(T100);
        Triangle T101 = new Triangle(emissionLight,material,new Point3D(-0.466572, 110.375, -27.803 ) ,new Point3D(2.63006, 113.114, -24.5381 ) ,new Point3D(0.429846, 144.109, -39.4616)  );
        list.add(T101);
        Triangle T102 = new Triangle(emissionLight,material,new Point3D(-1.45816, 165.107, -59.7791 ) ,new Point3D(-0.57879, 164.329, -60.7063 ) ,new Point3D(0.429846, 144.109, -39.4616)  );
        list.add(T102);
        Triangle T103 = new Triangle(emissionLight,material,new Point3D(0.429846, 144.109, -39.4616 ) ,new Point3D(-1.14647, 145.504, -37.7996 ) ,new Point3D(-1.45816, 165.107, -59.7791)  );
        list.add(T103);
        Triangle T104 = new Triangle(emissionLight,material,new Point3D(-2.88101, 164.81, -60.1333 ) ,new Point3D(-1.45816, 165.107, -59.7791 ) ,new Point3D(-1.14647, 145.504, -37.7996)  );
        list.add(T104);
        Triangle T105 = new Triangle(emissionLight,material,new Point3D(-1.14647, 145.504, -37.7996 ) ,new Point3D(-3.69701, 144.971, -38.4344 ) ,new Point3D(-2.88101, 164.81, -60.1333)  );
        list.add(T105);
        Triangle T106 = new Triangle(emissionLight,material,new Point3D(-2.88101, 163.848, -61.2793 ) ,new Point3D(-2.88101, 164.81, -60.1333 ) ,new Point3D(-3.69701, 144.971, -38.4344)  );
        list.add(T106);
        Triangle T107 = new Triangle(emissionLight,material,new Point3D(-3.69701, 144.971, -38.4344 ) ,new Point3D(-3.69701, 143.247, -40.4888 ) ,new Point3D(-2.88101, 163.848, -61.2793)  );
        list.add(T107);
        Triangle T108 = new Triangle(emissionLight,material,new Point3D(-1.45816, 163.551, -61.6335 ) ,new Point3D(-2.88101, 163.848, -61.2793 ) ,new Point3D(-3.69701, 143.247, -40.4888)  );
        list.add(T108);
        Triangle T109 = new Triangle(emissionLight,material,new Point3D(-3.69701, 143.247, -40.4888 ) ,new Point3D(-1.14647, 142.715, -41.1236 ) ,new Point3D(-1.45816, 163.551, -61.6335)  );
        list.add(T109);





    }



    public List<Intersectable.GeoPoint> findIntersections(Ray ray, double MAXDISTANCE) {

        List<Intersectable.GeoPoint> intersections = new LinkedList<Intersectable.GeoPoint>();

        for (Triangle t : list) {
            if( t.findIntersections(ray, MAXDISTANCE)!=null)
                intersections.add(t.findIntersections(ray, MAXDISTANCE).get(0));
        }

        return intersections;
    }
}
