package Geometry;

public class Vector {
    private double x;
    private double y;
    private double z;
    private double radius;
    private double theta;
    private double phi;
    private String label;
    private String id;

    /**
     * full constructor, with label, id and cartesian coordinates
     * @param x_value x coordinate in cartesian coordinates
     * @param y_value y coordinate in cartesian coordinates
     * @param z_value z coordinate in cartesian coordinates
     */
    public Vector(String vector_label, String vector_id, double x_value, double y_value, double z_value) {
        label = vector_label;
        id = vector_id;
        x = x_value; y = y_value; z = z_value;
        compute_spherical_coordinates();
    }

    /**
     * explicit constructor, for given cartesian coordinates
     * @param x_value x coordinate in cartesian coordinates
     * @param y_value y coordinate in cartesian coordinates
     * @param z_value z coordinate in cartesian coordinates
     */
    public Vector(double x_value, double y_value, double z_value) {
        label = null; id = null;
        x = x_value; y = y_value; z = z_value;
        compute_spherical_coordinates();
    }
    
    public Vector() {
        label = null; id = null;
        x = 0.0; y = 0.0; z = 0.0;
        radius = 0.0; theta = 0.0; phi = 0.0;
    }

    /**
     * get the x coordinate of the point
     * @return a double with the x coordinate
     */
    public double get_x() {
        return x;
    }

    /**
     * get the y coordinate of the point
     * @return a double with the y coordinate
     */
    public double get_y() {
        return y;
    }

    /**
     * get the z coordinate of the point
     * @return a double with the z coordinate
     */
    public double get_z() {
        return z;
    }

    /**
     * get the radius of the Vector (spherical coordinates)
     * @return the radius (norm) of the Vector
     */
    public double get_radius() {
        return radius;
    }

    /**
     * get the theta angle of the Vector (spherical coordinates)
     * @return the theta angle of the Vector
     */
    public double get_theta() {
        return theta;
    }

    /**
     * get the phi angle of the Vector (spherical coordinates)
     * @return the phi angle of the Vector
     */
    public double get_phi() {
        return phi;
    }

    public String basic_info() {
        String info = "";

        info += "label: " + label + "\n";
        info += "id: " + id + "\n";
        info += "x: " + x + "\n";
        info += "y: " + y + "\n";
        info += "z: " + z + "\n";
        info += "radius: " + radius + "\n";
        info += "theta: " + theta + "\n";
        info += "phi: " + phi + "\n";

        return info;
    }

    /**
     * sets the coordinates of the vector to a new set of coordinates
     * @param x_coordinate the new x coordinate
     * @param y_coordinate the new y coordinate
     * @param z_coordinate the new z coordinate
     */
    public void set_cartesian_coordinates(double x_coordinate, double y_coordinate, double z_coordinate) {
        x = x_coordinate; y = y_coordinate; z = z_coordinate;
        compute_spherical_coordinates();
    }

    /**
     * sets the x coordinate of the vector to a new x coordinate
     * @param x_coordinate
     */
    public void set_x(double x_coordinate) {
        x = x_coordinate;
        compute_spherical_coordinates();
    }

    /**
     * sets the y coordinate of the vector to a new y coordinate
     * @param y_coordinate
     */
    public void set_y(double y_coordinate) {
        y = y_coordinate;
        compute_spherical_coordinates();
    }

    /**
     * sets the z coordinate of the vector to a new z coordinate
     * @param z_coordinate
     */
    public void set_z(double z_coordinate) {
        z = z_coordinate;
        compute_spherical_coordinates();
    }

    /**
     * sets the spherical coordinates in to a new set of
     * @param radius_coordinate
     * @param theta_coordinate
     * @param phi_coordinate
     */
    public void set_cartesian_spherical(double radius_coordinate, double theta_coordinate, double phi_coordinate) {
        radius = radius_coordinate; theta = theta_coordinate; phi = phi_coordinate;
        compute_cartesian_coordinates();
    }

    /**
     * sets the radius coordinate in to a new radius coordinate value
     * @param radius_coordinate the new radius coordinate
     */
    public void set_radius(double radius_coordinate) {
        radius = radius_coordinate;
        compute_cartesian_coordinates();
    }

    /**
     * sets the theta coordinate in to a new theta coordinate value
     * @param theta_coordinate
     */
    public void set_theta(double theta_coordinate) {
        theta = theta_coordinate;
        compute_cartesian_coordinates();
    }

    /**
     * sets the phi coordinate in to a new phi coordinate value
     * @param phi_coordinate
     */
    public void set_phi(double phi_coordinate) {
        phi = phi_coordinate;
        compute_cartesian_coordinates();
    }

    /**
     * evaluates the spherical coordinates, with the alredy registered cartesian coordinates
     */
    private void compute_spherical_coordinates() {
        radius = Math.sqrt(x*x + y*y + z*z);

        if(z == 0)
            phi = Math.PI/2;
        else
            phi = Math.atan((x*x + y*y)/z);

        if(x == 0)
            theta = Math.PI/2;
        else
            theta = Math.atan(y/x);
    }

    /**
     * evaluates the spherical cartesian, with the alredy registered spherical coordinates
     */
    private void compute_cartesian_coordinates() {
        x = radius*Math.sin(theta)*Math.cos(phi);
        y = radius*Math.sin(theta)*Math.sin(phi);
        z = radius*Math.cos(theta);
    }

    /**
     * Multiplies the Vector by a scalar
     * @param scalar the scalar factor
     * @return the Vector multiplied by the scalar
     */
    public Vector scale(double scalar) {
        x *= scalar; y *= scalar; z *= scalar; 
        compute_spherical_coordinates();

        return this;
    }

    /**
     * Normalizes the Vector
     * @return the Vector normalized
     */
    public Vector normalize() {
        scale(1.0/radius);
        return this;
    }

    /**
     * makes the sum of two Vectors A and B
     * @param A first Vector
     * @param B second Vector
     * @return the Vector sum S = A + B
     */
    public static Vector sum(Vector A, Vector B) {
        Vector result = new Vector(
            A.x + B.x,
            A.y + B.y,
            A.z + B.z
        );

        return result;
    }

    /**
     * evaluates the dot product of the Vectors A and B
     * @param A first Vector of the product
     * @param B second Vector of the product
     * @return the dot product of A and B <A,B>
     */
    public static double dot_product(Vector A, Vector B) {
        return (A.x * B.x) + (A.y * B.y) + (A.z * B.z);
    }

    /**
     * evaluates the cross product of the Vectors A and B
     * @param A first Vector of the product
     * @param B second Vector of the product
     * @return the cross product of A and B AxB
     */
    public static Vector cross_product(Vector A, Vector B) {
        double x_value = A.y*B.z - A.z*B.y;
        double y_value = A.z*B.x - B.x*B.z;
        double z_value = A.x*B.y - A.y*B.x;

        return new Vector(x_value, y_value, z_value);
    }
}
