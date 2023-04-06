package Geometry;

public class UnitVector extends Vector {
    public UnitVector(double x_coordinate, double y_coordinate, double z_coordinate) {
        x = x_coordinate;
        y = y_coordinate;
        z = z_coordinate;
        radius = 1.0;

        compute_spherical_coordinates();
        normalize();
    }

    public UnitVector(double theta_angle, double phi_angle) {
        theta = theta_angle; phi = phi_angle;
        radius = 1.0;

        compute_cartesian_coordinates();
    }

    public UnitVector(Vector direction) {
        x = direction.x;
        y = direction.y;
        z = direction.z;
        
        compute_spherical_coordinates();
        normalize();
    }
}
