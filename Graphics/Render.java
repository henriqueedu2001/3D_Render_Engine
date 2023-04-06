package Graphics;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Geometry.Point;
import Geometry.Projector;
import Geometry.Vector;

public class Render {
    JFrame main_window;
    Panel main_panel;
    
    int default_width = 640;
    int default_height = 360;

    public Render() {
        main_window = new JFrame("3D Render Engine");
        main_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_panel = new Panel();
        main_panel.setSize(default_width, default_height);
        main_window.add(main_panel);
    }
    
    public void show() {
        main_window.setVisible(true);
        main_window.setSize(default_width, default_height);
    }
}

class Panel extends JPanel {
    Graphics graphics;

    private double focus_distance = 1.00;
    private double scaling_factor = 100.00;
    private int center_x = 320;
    private int center_y = 180;

    public Panel() {

    }

    public void paintComponent(Graphics g) {
        graphics = g;
        super.paintComponent( graphics );
        draw(graphics);
    }

    public void draw(Graphics g) {
        Point A = new Point(1.0, 1.0, 1.0);
        Point B = new Point(1.0, 1.0, 3.0);
        Point C = new Point(1.0, -1.0, 3.0);
        Point D = new Point(1.0, -1.0, 1.0);

        Point E = new Point(3.0, 1.0, 1.0);
        Point F = new Point(3.0, 1.0, 3.0);
        Point G = new Point(3.0, -1.0, 3.0);
        Point H = new Point(3.0, -1.0, 1.0);
        draw_3D_line(A, B, g);
        draw_3D_line(B, C, g);
        draw_3D_line(C, D, g);

        draw_3D_line(D, A, g);
        draw_3D_line(E, F, g);
        draw_3D_line(F, G, g);
        draw_3D_line(G, H, g);
        draw_3D_line(H, E, g);

        draw_3D_line(A, E, g);
        draw_3D_line(B, F, g);
        draw_3D_line(C, G, g);
        draw_3D_line(D, H, g);
    }

    public void draw_3D_line(Point A, Point B, Graphics g) {
        double[] A_coordinates = Projector.planar_projection(A, focus_distance);
        double[] B_coordinates = Projector.planar_projection(B, focus_distance);

        int[] A_center_coord = at_center(A_coordinates[0], A_coordinates[1]);
        int[] B_center_coord = at_center(B_coordinates[0], B_coordinates[1]);

        g.drawLine(A_center_coord[0], A_center_coord[1], B_center_coord[0], B_center_coord[1]);
    }

    private int[] at_center(double x, double y) {
        int[] coordinates = {center_x, center_y};

        coordinates[0] = coordinates[0] + (int) (scaling_factor*x);
        coordinates[1] = coordinates[1] - (int) (scaling_factor*y);

        return coordinates;
    }
}