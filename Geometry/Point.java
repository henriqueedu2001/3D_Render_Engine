package Geometry;

public class Point {
    private double x;
    private double y;
    private double z;
    private String label;
    private String id;

    /**
     * full constructor of the point, with label, id and coordinates
     * @param point_label
     * @param point_id
     * @param x_coordinate the initial x coordinate of the point
     * @param y_coordinate the initial y coordinate of the point
     * @param z_coordinate the initial z coordinate of the point
     */
    public Point(String point_label, String point_id, double x_coordinate, double y_coordinate, double z_coordinate) {
        label = point_label;
        id = point_id;
        x = x_coordinate;
        y = y_coordinate;
        z = z_coordinate;
    }

    /**
     * simple constructor, with just coordinates
     * @param x_coordinate the initial x coordinate of the point
     * @param y_coordinate the initial y coordinate of the point
     * @param z_coordinate the initial z coordinate of the point
     */
    public Point(double x_coordinate, double y_coordinate, double z_coordinate) {
        label = null;
        id = null;
        x = x_coordinate;
        y = y_coordinate;
        z = z_coordinate;
    }

    /**
     * simples constructor, for null points
     */
    public Point() {
        x = 0.0;
        y = 0.0;
        z = 0.0;
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
     * get the point id of the point
     * @return a String with the id
     */
    public String get_id() {
        return id;
    }

    /**
     * get the point label of the point
     * @return a String with the label
     */
    public String get_label() {
        return label;
    }

    public String showInfo() {
        String info = "";

        info += "label: " + label + "\n";
        info += "id: " + id + "\n";
        info += "x: " + x + "\n";
        info += "y: " + y + "\n";
        info += "z: " + z;

        return info;
    }

    /**
     * sets the coordinates of the point
     * @param x_coordinate the new x coordinate
     * @param y_coordinate the new y coordinate
     * @param z_coordinate the new z coordinate
     */
    public void set_coordinates(double x_coordinate, double y_coordinate, double z_coordinate) {
        x = x_coordinate;
        y = y_coordinate;
        z = z_coordinate;
    }

    /**
     * sets a new x coordinate for the point
     * @param new_x the new x coordinate of the point
     */
    public void set_x(double new_x) {
        x = new_x;
    }

    /**
     * sets a new y coordinate for the point
     * @param new_y the new xy coordinate of the point
     */
    public void set_y(double new_y) {
        y = new_y;
    }

    /**
     * sets a new z coordinate for the point
     * @param new_z the new z coordinate of the point
     */
    public void set_z(double new_z) {
        z = new_z;
    }

    /**
     * sets a new label for the point
     * @param new_label the new label
     */
    public void set_label(String new_label) {
        label = new_label;
    }

    /**
     * sets a new id for the point
     * @param new_id the new id
     */
    public void set_id(String new_id) {
        id = new_id;
    }
    
}
