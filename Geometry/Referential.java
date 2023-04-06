package Geometry;

public class Referential {
    UnitVector i;
    UnitVector j;
    UnitVector k;
    Point origin;

    public Referential(UnitVector i_direction, UnitVector j_direction, UnitVector k_direction, Point origin_point) {
        i = i_direction;
        j = j_direction;
        k = k_direction;
        origin = origin_point;
    }
}
