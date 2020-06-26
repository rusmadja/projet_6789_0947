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

public class Tree_3 extends Geometries {


    List<Triangle> list = new LinkedList<Triangle>();

    public Tree_3(Color emissionLight, Material material,Point3D position,double coef) {
        double x = position.get_x().get();
        double y = position.get_y().get();
        double z = position.get_z().get();


        Triangle T111 = new Triangle(emissionLight,material,new Point3D( (-1.14647 )* coef+ x,  (142.715 )* coef+ y,  (-41.1236 )* coef+ z ) ,new Point3D( (0.429846 )* coef+ x,  (144.109 )* coef+ y,  (-39.4616 )* coef+ z ) ,new Point3D( (-0.57879 )* coef+ x,  (164.329 )* coef+ y,  (-60.7063 )* coef+ z ) );
        list.add(T111);

        Triangle T113 = new Triangle(emissionLight,material,new Point3D( (-57.3525 )* coef+ x,  (137.838 )* coef+ y,  (33.321 )* coef+ z ) ,new Point3D( (-78.0047 )* coef+ x,  (141.877 )* coef+ y,  (31.3866 )* coef+ z ) ,new Point3D( (-74.2681 )* coef+ x,  (136.173 )* coef+ y,  (21.0471 )* coef+ z ) );
        list.add(T113);

        Triangle T115 = new Triangle(emissionLight,material,new Point3D( (-57.3525 )* coef+ x,  (137.838 )* coef+ y,  (33.321 )* coef+ z ) ,new Point3D( (-65.8762 )* coef+ x,  (134.84 )* coef+ y,  (13.9733 )* coef+ z ) ,new Point3D( (-55.0777 )* coef+ x,  (139.735 )* coef+ y,  (12.0606 )* coef+ z ) );
        list.add(T115);

        Triangle T117 = new Triangle(emissionLight,material,new Point3D( (-57.3525 )* coef+ x,  (137.838 )* coef+ y,  (33.321 )* coef+ z ) ,new Point3D( (-37.3074 )* coef+ x,  (141.555 )* coef+ y,  (12.3436 )* coef+ z ) ,new Point3D( (-2.55465 )* coef+ x,  (128.048 )* coef+ y,  (7.85799 )* coef+ z ) );
        list.add(T117);

        Triangle T119 = new Triangle(emissionLight,material,new Point3D( (-57.3525 )* coef+ x,  (137.838 )* coef+ y,  (33.321 )* coef+ z ) ,new Point3D( (-28.3256 )* coef+ x,  (141.987 )* coef+ y,  (31.6052 )* coef+ z ) ,new Point3D( (-37.7381 )* coef+ x,  (140.484 )* coef+ y,  (49.2455 )* coef+ z ) );
        list.add(T119);

        Triangle T121 = new Triangle(emissionLight,material,new Point3D( (-57.3525 )* coef+ x,  (137.838 )* coef+ y,  (33.321 )* coef+ z ) ,new Point3D( (-47.9126 )* coef+ x,  (135.705 )* coef+ y,  (52.4964 )* coef+ z ) ,new Point3D( (-58.7112 )* coef+ x,  (136.921 )* coef+ y,  (54.4091 )* coef+ z ) );
        list.add(T121);

        Triangle T123 = new Triangle(emissionLight,material,new Point3D( (-57.3525 )* coef+ x,  (137.838 )* coef+ y,  (33.321 )* coef+ z ) ,new Point3D( (-69.0229 )* coef+ x,  (142.309 )* coef+ y,  (50.6481 )* coef+ z ) ,new Point3D( (-76.0848 )* coef+ x,  (141.867 )* coef+ y,  (42.2213 )* coef+ z ) );
        list.add(T123);

        Triangle T125 = new Triangle(emissionLight,material,new Point3D( (-76.0848 )* coef+ x,  (141.867 )* coef+ y,  (42.2213 )* coef+ z ) ,new Point3D( (-98.328 )* coef+ x,  (118.07 )* coef+ y,  (16.6716 )* coef+ z ) ,new Point3D( (-78.0047 )* coef+ x,  (141.877 )* coef+ y,  (31.3866 )* coef+ z ) );
        list.add(T125);

        Triangle T127 = new Triangle(emissionLight,material,new Point3D( (-78.0047 )* coef+ x,  (141.877 )* coef+ y,  (31.3866 )* coef+ z ) ,new Point3D( (-75.9532 )* coef+ x,  (125.936 )* coef+ y,  (12.9045 )* coef+ z ) ,new Point3D( (-74.2681 )* coef+ x,  (136.173 )* coef+ y,  (21.0471 )* coef+ z ) );
        list.add(T127);

        Triangle T129 = new Triangle(emissionLight,material,new Point3D( (-74.2681 )* coef+ x,  (136.173 )* coef+ y,  (21.0471 )* coef+ z ) ,new Point3D( (-68.117 )* coef+ x,  (120.688 )* coef+ y,  (-16.5978 )* coef+ z ) ,new Point3D( (-65.8762 )* coef+ x,  (134.84 )* coef+ y,  (13.9733 )* coef+ z ) );
        list.add(T129);

        Triangle T131 = new Triangle(emissionLight,material,new Point3D( (-65.8762 )* coef+ x,  (134.84 )* coef+ y,  (13.9733 )* coef+ z ) ,new Point3D( (-52.5604 )* coef+ x,  (128.854 )* coef+ y,  (1.93085 )* coef+ z ) ,new Point3D( (-55.0777 )* coef+ x,  (139.735 )* coef+ y,  (12.0606 )* coef+ z ) );
        list.add(T131);

        Triangle T133 = new Triangle(emissionLight,material,new Point3D( (-55.0777 )* coef+ x,  (139.735 )* coef+ y,  (12.0606 )* coef+ z ) ,new Point3D( (-39.4186 )* coef+ x,  (130.189 )* coef+ y,  (-7.41807 )* coef+ z ) ,new Point3D( (-37.3074 )* coef+ x,  (141.555 )* coef+ y,  (12.3436 )* coef+ z ) );
        list.add(T133);

        Triangle T135 = new Triangle(emissionLight,material,new Point3D( (-37.3074 )* coef+ x,  (141.555 )* coef+ y,  (12.3436 )* coef+ z ) ,new Point3D( (-10.5777 )* coef+ x,  (109.915 )* coef+ y,  (11.9196 )* coef+ z ) ,new Point3D( (-2.55465 )* coef+ x,  (128.048 )* coef+ y,  (7.85799 )* coef+ z ) );
        list.add(T135);

        Triangle T137 = new Triangle(emissionLight,material,new Point3D( (-2.55465 )* coef+ x,  (128.048 )* coef+ y,  (7.85799 )* coef+ z ) ,new Point3D( (-4.84215 )* coef+ x,  (109.898 )* coef+ y,  (33.3409 )* coef+ z ) ,new Point3D( (-28.3256 )* coef+ x,  (141.987 )* coef+ y,  (31.6052 )* coef+ z ) );
        list.add(T137);

        Triangle T139 = new Triangle(emissionLight,material,new Point3D( (-28.3256 )* coef+ x,  (141.987 )* coef+ y,  (31.6052 )* coef+ z ) ,new Point3D( (-27.2309 )* coef+ x,  (130.151 )* coef+ y,  (50.5064 )* coef+ z ) ,new Point3D( (-37.7381 )* coef+ x,  (140.484 )* coef+ y,  (49.2455 )* coef+ z ) );
        list.add(T139);

        Triangle T141 = new Triangle(emissionLight,material,new Point3D( (-37.7381 )* coef+ x,  (140.484 )* coef+ y,  (49.2455 )* coef+ z ) ,new Point3D( (-26.7728 )* coef+ x,  (122.185 )* coef+ y,  (72.0652 )* coef+ z ) ,new Point3D( (-47.9126 )* coef+ x,  (135.705 )* coef+ y,  (52.4964 )* coef+ z ) );
        list.add(T141);

        Triangle T143 = new Triangle(emissionLight,material,new Point3D( (-47.9126 )* coef+ x,  (135.705 )* coef+ y,  (52.4964 )* coef+ z ) ,new Point3D( (-58.8424 )* coef+ x,  (127.232 )* coef+ y,  (63.2746 )* coef+ z ) ,new Point3D( (-58.7112 )* coef+ x,  (136.921 )* coef+ y,  (54.4091 )* coef+ z ) );
        list.add(T143);

        Triangle T145 = new Triangle(emissionLight,material,new Point3D( (-58.7112 )* coef+ x,  (136.921 )* coef+ y,  (54.4091 )* coef+ z ) ,new Point3D( (-72.8611 )* coef+ x,  (139.214 )* coef+ y,  (71.2857 )* coef+ z ) ,new Point3D( (-69.0229 )* coef+ x,  (142.309 )* coef+ y,  (50.6481 )* coef+ z ) );
        list.add(T145);

        Triangle T147 = new Triangle(emissionLight,material,new Point3D( (-69.0229 )* coef+ x,  (142.309 )* coef+ y,  (50.6481 )* coef+ z ) ,new Point3D( (-96.6447 )* coef+ x,  (126.422 )* coef+ y,  (52.1843 )* coef+ z ) ,new Point3D( (-76.0848 )* coef+ x,  (141.867 )* coef+ y,  (42.2213 )* coef+ z ) );
        list.add(T147);

        Triangle T149 = new Triangle(emissionLight,material,new Point3D( (-96.6447 )* coef+ x,  (126.422 )* coef+ y,  (52.1843 )* coef+ z ) ,new Point3D( (-102.275 )* coef+ x,  (94.5919 )* coef+ y,  (15.8547 )* coef+ z ) ,new Point3D( (-98.328 )* coef+ x,  (118.07 )* coef+ y,  (16.6716 )* coef+ z ) );
        list.add(T149);

        Triangle T151 = new Triangle(emissionLight,material,new Point3D( (-98.328 )* coef+ x,  (118.07 )* coef+ y,  (16.6716 )* coef+ z ) ,new Point3D( (-81.5091 )* coef+ x,  (95.5089 )* coef+ y,  (10.5342 )* coef+ z ) ,new Point3D( (-75.9532 )* coef+ x,  (125.936 )* coef+ y,  (12.9045 )* coef+ z ) );
        list.add(T151);

        Triangle T153 = new Triangle(emissionLight,material,new Point3D( (-75.9532 )* coef+ x,  (125.936 )* coef+ y,  (12.9045 )* coef+ z ) ,new Point3D( (-77.5649 )* coef+ x,  (102.715 )* coef+ y,  (-18.0 )* coef+ z ) ,new Point3D( (-68.117 )* coef+ x,  (120.688 )* coef+ y,  (-16.5978 )* coef+ z ) );
        list.add(T153);

        Triangle T155 = new Triangle(emissionLight,material,new Point3D( (-68.117 )* coef+ x,  (120.688 )* coef+ y,  (-16.5978 )* coef+ z ) ,new Point3D( (-50.3641 )* coef+ x,  (93.0318 )* coef+ y,  (-4.06446 )* coef+ z ) ,new Point3D( (-52.5604 )* coef+ x,  (128.854 )* coef+ y,  (1.93085 )* coef+ z ) );
        list.add(T155);

        Triangle T157 = new Triangle(emissionLight,material,new Point3D( (-52.5604 )* coef+ x,  (128.854 )* coef+ y,  (1.93085 )* coef+ z ) ,new Point3D( (-34.4594 )* coef+ x,  (89.8826 )* coef+ y,  (-12.4056 )* coef+ z ) ,new Point3D( (-39.4186 )* coef+ x,  (130.189 )* coef+ y,  (-7.41807 )* coef+ z ) );
        list.add(T157);

        Triangle T159 = new Triangle(emissionLight,material,new Point3D( (-39.4186 )* coef+ x,  (130.189 )* coef+ y,  (-7.41807 )* coef+ z ) ,new Point3D( (-15.5527 )* coef+ x,  (106.82 )* coef+ y,  (14.7048 )* coef+ z ) ,new Point3D( (-10.5777 )* coef+ x,  (109.915 )* coef+ y,  (11.9196 )* coef+ z ) );
        list.add(T159);

        Triangle T161 = new Triangle(emissionLight,material,new Point3D( (-10.5777 )* coef+ x,  (109.915 )* coef+ y,  (11.9196 )* coef+ z ) ,new Point3D( (-2.9238 )* coef+ x,  (96.3003 )* coef+ y,  (36.0548 )* coef+ z ) ,new Point3D( (-4.84215 )* coef+ x,  (109.898 )* coef+ y,  (33.3409 )* coef+ z ) );
        list.add(T161);

        Triangle T163 = new Triangle(emissionLight,material,new Point3D( (-4.84215 )* coef+ x,  (109.898 )* coef+ y,  (33.3409 )* coef+ z ) ,new Point3D( (-20.8662 )* coef+ x,  (94.5293 )* coef+ y,  (53.4504 )* coef+ z ) ,new Point3D( (-27.2309 )* coef+ x,  (130.151 )* coef+ y,  (50.5064 )* coef+ z ) );
        list.add(T163);

        Triangle T165 = new Triangle(emissionLight,material,new Point3D( (-27.2309 )* coef+ x,  (130.151 )* coef+ y,  (50.5064 )* coef+ z ) ,new Point3D( (-31.4074 )* coef+ x,  (104.444 )* coef+ y,  (80.9851 )* coef+ z ) ,new Point3D( (-26.7728 )* coef+ x,  (122.185 )* coef+ y,  (72.0652 )* coef+ z ) );
        list.add(T165);

        Triangle T167 = new Triangle(emissionLight,material,new Point3D( (-26.7728 )* coef+ x,  (122.185 )* coef+ y,  (72.0652 )* coef+ z ) ,new Point3D( (-57.6197 )* coef+ x,  (97.0064 )* coef+ y,  (68.6265 )* coef+ z ) ,new Point3D( (-58.8424 )* coef+ x,  (127.232 )* coef+ y,  (63.2746 )* coef+ z ) );
        list.add(T167);

        Triangle T169 = new Triangle(emissionLight,material,new Point3D( (-58.8424 )* coef+ x,  (127.232 )* coef+ y,  (63.2746 )* coef+ z ) ,new Point3D( (-74.4014 )* coef+ x,  (95.4565 )* coef+ y,  (75.6299 )* coef+ z ) ,new Point3D( (-72.8611 )* coef+ x,  (139.214 )* coef+ y,  (71.2857 )* coef+ z ) );
        list.add(T169);

        Triangle T171 = new Triangle(emissionLight,material,new Point3D( (-72.8611 )* coef+ x,  (139.214 )* coef+ y,  (71.2857 )* coef+ z ) ,new Point3D( (-106.242 )* coef+ x,  (107.422 )* coef+ y,  (57.1453 )* coef+ z ) ,new Point3D( (-96.6447 )* coef+ x,  (126.422 )* coef+ y,  (52.1843 )* coef+ z ) );
        list.add(T171);

        Triangle T173 = new Triangle(emissionLight,material,new Point3D( (1.55457 )* coef+ x,  (196.796 )* coef+ y,  (6.4757 )* coef+ z ) ,new Point3D( (-17.5213 )* coef+ x,  (204.146 )* coef+ y,  (39.0532 )* coef+ z ) ,new Point3D( (-31.702 )* coef+ x,  (193.765 )* coef+ y,  (24.937 )* coef+ z ) );
        list.add(T173);

        Triangle T175 = new Triangle(emissionLight,material,new Point3D( (1.55457 )* coef+ x,  (196.796 )* coef+ y,  (6.4757 )* coef+ z ) ,new Point3D( (-36.9153 )* coef+ x,  (191.339 )* coef+ y,  (5.65385 )* coef+ z ) ,new Point3D( (-31.7644 )* coef+ x,  (200.248 )* coef+ y,  (-13.6293 )* coef+ z ) );
        list.add(T175);

        Triangle T177 = new Triangle(emissionLight,material,new Point3D( (1.55457 )* coef+ x,  (196.796 )* coef+ y,  (6.4757 )* coef+ z ) ,new Point3D( (-17.6293 )* coef+ x,  (203.561 )* coef+ y,  (-42.7233 )* coef+ z ) ,new Point3D( (1.70234 )* coef+ x,  (178.978 )* coef+ y,  (-103.497 )* coef+ z ) );
        list.add(T177);

        Triangle T179 = new Triangle(emissionLight,material,new Point3D( (1.55457 )* coef+ x,  (196.796 )* coef+ y,  (6.4757 )* coef+ z ) ,new Point3D( (21.0507 )* coef+ x,  (204.347 )* coef+ y,  (-42.7233 )* coef+ z ) ,new Point3D( (42.9083 )* coef+ x,  (201.611 )* coef+ y,  (-13.6293 )* coef+ z ) );
        list.add(T179);

        Triangle T181 = new Triangle(emissionLight,material,new Point3D( (1.55457 )* coef+ x,  (196.796 )* coef+ y,  (6.4757 )* coef+ z ) ,new Point3D( (40.4447 )* coef+ x,  (192.913 )* coef+ y,  (5.65386 )* coef+ z ) ,new Point3D( (35.2938 )* coef+ x,  (195.127 )* coef+ y,  (24.937 )* coef+ z ) );
        list.add(T181);

        Triangle T183 = new Triangle(emissionLight,material,new Point3D( (1.55457 )* coef+ x,  (196.796 )* coef+ y,  (6.4757 )* coef+ z ) ,new Point3D( (21.1587 )* coef+ x,  (204.933 )* coef+ y,  (39.0532 )* coef+ z ) ,new Point3D( (1.82708 )* coef+ x,  (204.129 )* coef+ y,  (44.2201 )* coef+ z ) );
        list.add(T183);

        Triangle T185 = new Triangle(emissionLight,material,new Point3D( (1.82708 )* coef+ x,  (204.129 )* coef+ y,  (44.2201 )* coef+ z ) ,new Point3D( (-57.4253 )* coef+ x,  (160.818 )* coef+ y,  (61.2579 )* coef+ z ) ,new Point3D( (-17.5213 )* coef+ x,  (204.146 )* coef+ y,  (39.0532 )* coef+ z ) );
        list.add(T185);

        Triangle T187 = new Triangle(emissionLight,material,new Point3D( (-17.5213 )* coef+ x,  (204.146 )* coef+ y,  (39.0532 )* coef+ z ) ,new Point3D( (-46.4291 )* coef+ x,  (175.133 )* coef+ y,  (21.4536 )* coef+ z ) ,new Point3D( (-31.702 )* coef+ x,  (193.765 )* coef+ y,  (24.937 )* coef+ z ) );
        list.add(T187);

        Triangle T189 = new Triangle(emissionLight,material,new Point3D( (-31.702 )* coef+ x,  (193.765 )* coef+ y,  (24.937 )* coef+ z ) ,new Point3D( (-89.0652 )* coef+ x,  (165.582 )* coef+ y,  (-14.1642 )* coef+ z ) ,new Point3D( (-36.9153 )* coef+ x,  (191.339 )* coef+ y,  (5.65385 )* coef+ z ) );
        list.add(T189);

        Triangle T191 = new Triangle(emissionLight,material,new Point3D( (-36.9153 )* coef+ x,  (191.339 )* coef+ y,  (5.65385 )* coef+ z ) ,new Point3D( (-46.537 )* coef+ x,  (180.445 )* coef+ y,  (-25.573 )* coef+ z ) ,new Point3D( (-31.7644 )* coef+ x,  (200.248 )* coef+ y,  (-13.6293 )* coef+ z ) );
        list.add(T191);

        Triangle T193 = new Triangle(emissionLight,material,new Point3D( (-31.7644 )* coef+ x,  (200.248 )* coef+ y,  (-13.6293 )* coef+ z ) ,new Point3D( (-51.8497 )* coef+ x,  (182.874 )* coef+ y,  (-54.4409 )* coef+ z ) ,new Point3D( (-17.6293 )* coef+ x,  (203.561 )* coef+ y,  (-42.7233 )* coef+ z ) );
        list.add(T193);

        Triangle T195 = new Triangle(emissionLight,material,new Point3D( (-17.6293 )* coef+ x,  (203.561 )* coef+ y,  (-42.7233 )* coef+ z ) ,new Point3D( (2.2308 )* coef+ x,  (145.975 )* coef+ y,  (-87.1396 )* coef+ z ) ,new Point3D( (1.70234 )* coef+ x,  (178.978 )* coef+ y,  (-103.497 )* coef+ z ) );
        list.add(T195);

        Triangle T197 = new Triangle(emissionLight,material,new Point3D( (1.70234 )* coef+ x,  (178.978 )* coef+ y,  (-103.497 )* coef+ z ) ,new Point3D( (41.9765 )* coef+ x,  (145.945 )* coef+ y,  (-80.1237 )* coef+ z ) ,new Point3D( (21.0507 )* coef+ x,  (204.347 )* coef+ y,  (-42.7233 )* coef+ z ) );
        list.add(T197);

        Triangle T199 = new Triangle(emissionLight,material,new Point3D( (21.0507 )* coef+ x,  (204.347 )* coef+ y,  (-42.7233 )* coef+ z ) ,new Point3D( (53.0699 )* coef+ x,  (182.805 )* coef+ y,  (-29.9908 )* coef+ z ) ,new Point3D( (42.9083 )* coef+ x,  (201.611 )* coef+ y,  (-13.6293 )* coef+ z ) );
        list.add(T199);

        Triangle T201 = new Triangle(emissionLight,material,new Point3D( (42.9083 )* coef+ x,  (201.611 )* coef+ y,  (-13.6293 )* coef+ z ) ,new Point3D( (88.9831 )* coef+ x,  (168.308 )* coef+ y,  (-14.1642 )* coef+ z ) ,new Point3D( (40.4447 )* coef+ x,  (192.913 )* coef+ y,  (5.65386 )* coef+ z ) );
        list.add(T201);

        Triangle T203 = new Triangle(emissionLight,material,new Point3D( (40.4447 )* coef+ x,  (192.913 )* coef+ y,  (5.65386 )* coef+ z ) ,new Point3D( (49.8164 )* coef+ x,  (177.493 )* coef+ y,  (31.9726 )* coef+ z ) ,new Point3D( (35.2938 )* coef+ x,  (195.127 )* coef+ y,  (24.937 )* coef+ z ) );
        list.add(T203);

        Triangle T205 = new Triangle(emissionLight,material,new Point3D( (35.2938 )* coef+ x,  (195.127 )* coef+ y,  (24.937 )* coef+ z ) ,new Point3D( (52.2478 )* coef+ x,  (199.3 )* coef+ y,  (61.2579 )* coef+ z ) ,new Point3D( (21.1587 )* coef+ x,  (204.933 )* coef+ y,  (39.0532 )* coef+ z ) );
        list.add(T205);

        Triangle T207 = new Triangle(emissionLight,material,new Point3D( (21.1587 )* coef+ x,  (204.933 )* coef+ y,  (39.0532 )* coef+ z ) ,new Point3D( (2.44687 )* coef+ x,  (176.019 )* coef+ y,  (85.7964 )* coef+ z ) ,new Point3D( (1.82708 )* coef+ x,  (204.129 )* coef+ y,  (44.2201 )* coef+ z ) );
        list.add(T207);

        Triangle T209 = new Triangle(emissionLight,material,new Point3D( (2.44687 )* coef+ x,  (176.019 )* coef+ y,  (85.7964 )* coef+ z ) ,new Point3D( (-61.8087 )* coef+ x,  (118.088 )* coef+ y,  (67.1401 )* coef+ z ) ,new Point3D( (-57.4253 )* coef+ x,  (160.818 )* coef+ y,  (61.2579 )* coef+ z ) );
        list.add(T209);

        Triangle T211 = new Triangle(emissionLight,material,new Point3D( (-57.4253 )* coef+ x,  (160.818 )* coef+ y,  (61.2579 )* coef+ z ) ,new Point3D( (-54.6122 )* coef+ x,  (119.757 )* coef+ y,  (28.7947 )* coef+ z ) ,new Point3D( (-46.4291 )* coef+ x,  (175.133 )* coef+ y,  (21.4536 )* coef+ z ) );
        list.add(T211);

        Triangle T213 = new Triangle(emissionLight,material,new Point3D( (-46.4291 )* coef+ x,  (175.133 )* coef+ y,  (21.4536 )* coef+ z ) ,new Point3D( (-98.6452 )* coef+ x,  (132.872 )* coef+ y,  (0.341349 )* coef+ z ) ,new Point3D( (-89.0652 )* coef+ x,  (165.582 )* coef+ y,  (-14.1642 )* coef+ z ) );
        list.add(T213);

        Triangle T215 = new Triangle(emissionLight,material,new Point3D( (-89.0652 )* coef+ x,  (165.582 )* coef+ y,  (-14.1642 )* coef+ z ) ,new Point3D( (-54.7368 )* coef+ x,  (115.248 )* coef+ y,  (-33.8071 )* coef+ z ) ,new Point3D( (-46.537 )* coef+ x,  (180.445 )* coef+ y,  (-25.573 )* coef+ z ) );
        list.add(T215);

        Triangle T217 = new Triangle(emissionLight,material,new Point3D( (-46.537 )* coef+ x,  (180.445 )* coef+ y,  (-25.573 )* coef+ z ) ,new Point3D( (-56.2621 )* coef+ x,  (109.517 )* coef+ y,  (-66.4574 )* coef+ z ) ,new Point3D( (-51.8497 )* coef+ x,  (182.874 )* coef+ y,  (-54.4409 )* coef+ z ) );
        list.add(T217);

        Triangle T219 = new Triangle(emissionLight,material,new Point3D( (-51.8497 )* coef+ x,  (182.874 )* coef+ y,  (-54.4409 )* coef+ z ) ,new Point3D( (2.99836 )* coef+ x,  (140.343 )* coef+ y,  (-76.7912 )* coef+ z ) ,new Point3D( (2.2308 )* coef+ x,  (145.975 )* coef+ y,  (-87.1396 )* coef+ z ) );
        list.add(T219);

        Triangle T221 = new Triangle(emissionLight,material,new Point3D( (2.2308 )* coef+ x,  (145.975 )* coef+ y,  (-87.1396 )* coef+ z ) ,new Point3D( (47.9284 )* coef+ x,  (121.197 )* coef+ y,  (-81.2006 )* coef+ z ) ,new Point3D( (41.9765 )* coef+ x,  (145.945 )* coef+ y,  (-80.1237 )* coef+ z ) );
        list.add(T221);

        Triangle T223 = new Triangle(emissionLight,material,new Point3D( (41.9765 )* coef+ x,  (145.945 )* coef+ y,  (-80.1237 )* coef+ z ) ,new Point3D( (62.8215 )* coef+ x,  (117.974 )* coef+ y,  (-38.2249 )* coef+ z ) ,new Point3D( (53.0699 )* coef+ x,  (182.805 )* coef+ y,  (-29.9908 )* coef+ z ) );
        list.add(T223);

        Triangle T225 = new Triangle(emissionLight,material,new Point3D( (53.0699 )* coef+ x,  (182.805 )* coef+ y,  (-29.9908 )* coef+ z ) ,new Point3D( (100.132 )* coef+ x,  (136.019 )* coef+ y,  (0.341367 )* coef+ z ) ,new Point3D( (88.9831 )* coef+ x,  (168.308 )* coef+ y,  (-14.1642 )* coef+ z ) );
        list.add(T225);

        Triangle T227 = new Triangle(emissionLight,material,new Point3D( (88.9831 )* coef+ x,  (168.308 )* coef+ y,  (-14.1642 )* coef+ z ) ,new Point3D( (59.5848 )* coef+ x,  (122.482 )* coef+ y,  (34.0723 )* coef+ z ) ,new Point3D( (49.8164 )* coef+ x,  (177.493 )* coef+ y,  (31.9726 )* coef+ z ) );
        list.add(T227);

        Triangle T229 = new Triangle(emissionLight,material,new Point3D( (49.8164 )* coef+ x,  (177.493 )* coef+ y,  (31.9726 )* coef+ z ) ,new Point3D( (58.2287 )* coef+ x,  (119.661 )* coef+ y,  (67.1401 )* coef+ z ) ,new Point3D( (52.2478 )* coef+ x,  (199.3 )* coef+ y,  (61.2579 )* coef+ z ) );
        list.add(T229);

        Triangle T231 = new Triangle(emissionLight,material,new Point3D( (52.2478 )* coef+ x,  (199.3 )* coef+ y,  (61.2579 )* coef+ z ) ,new Point3D( (3.24784 )* coef+ x,  (141.439 )* coef+ y,  (105.443 )* coef+ z ) ,new Point3D( (2.44687 )* coef+ x,  (176.019 )* coef+ y,  (85.7964 )* coef+ z ) );
        list.add(T231);

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
