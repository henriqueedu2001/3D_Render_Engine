package Geometry;

public class Projector {
    public static double[] planar_projection(Point P, double focus_distance) {
        double coordinates[] = {0.0, 0.0};

        double factor = focus_distance/(P.get_z() + focus_distance);
        double x = factor*P.get_x();
        double y = factor*P.get_y();

        coordinates[0] = x; 
        coordinates[1] = y;

        return coordinates;
    }
}
