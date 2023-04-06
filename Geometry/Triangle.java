package Geometry;

public class Triangle {
    Point A;
    Point B;
    Point C;
    Point[] points;

    public Triangle(Point A_Point, Point B_Point, Point C_Point) {
        A = A_Point;
        B = B_Point;
        C = C_Point;
        Point[] new_points = {A_Point, B_Point, C_Point};
        points = new_points;
    }
}
