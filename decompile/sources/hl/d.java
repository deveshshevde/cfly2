package hl;

import com.huantansheng.easyphotos.models.puzzle.Line;

public class d extends a {
    public d(int i2) {
        super(i2);
    }

    public void a() {
        Line.Direction direction;
        Line.Direction direction2;
        int i2 = this.f13365a;
        if (i2 != 0) {
            if (i2 == 1) {
                a(0, Line.Direction.HORIZONTAL, 0.5f);
                direction2 = Line.Direction.VERTICAL;
            } else if (i2 == 2) {
                a(0, Line.Direction.VERTICAL, 0.5f);
                direction = Line.Direction.HORIZONTAL;
                a(0, direction, 0.56f, 0.44f);
            } else if (i2 == 3) {
                a(0, Line.Direction.VERTICAL, 0.5f);
                direction2 = Line.Direction.HORIZONTAL;
            } else if (i2 == 4) {
                a(0, Line.Direction.HORIZONTAL, 0.44f, 0.56f);
            } else if (i2 == 5) {
                a(0, Line.Direction.VERTICAL, 0.56f, 0.44f);
                a(1, Line.Direction.HORIZONTAL, 0.44f, 0.56f);
                return;
            } else {
                return;
            }
            a(1, direction2, 0.56f, 0.44f);
            return;
        }
        a(0, Line.Direction.HORIZONTAL, 0.5f);
        direction = Line.Direction.VERTICAL;
        a(0, direction, 0.56f, 0.44f);
    }

    public int i() {
        return 6;
    }
}
