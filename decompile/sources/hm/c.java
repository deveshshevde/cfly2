package hm;

import com.huantansheng.easyphotos.models.puzzle.Line;

public class c extends e {
    public c(int i2) {
        super(i2);
    }

    public void a() {
        Line.Direction direction;
        Line.Direction direction2;
        int i2 = this.f13366a;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    a(0, Line.Direction.HORIZONTAL, 0.6666667f);
                    direction2 = Line.Direction.VERTICAL;
                } else if (i2 == 3) {
                    a(0, Line.Direction.VERTICAL, 0.33333334f);
                    direction = Line.Direction.HORIZONTAL;
                } else if (i2 == 4) {
                    a(0, Line.Direction.VERTICAL, 0.6666667f);
                    direction2 = Line.Direction.HORIZONTAL;
                } else if (i2 != 5) {
                    a(0, 4, Line.Direction.HORIZONTAL);
                    return;
                } else {
                    a(0, Line.Direction.VERTICAL, 0.5f);
                    a(1, Line.Direction.HORIZONTAL, 0.6666667f);
                    a(1, Line.Direction.HORIZONTAL, 0.33333334f);
                    return;
                }
                a(1, 3, direction2);
                return;
            }
            a(0, Line.Direction.HORIZONTAL, 0.33333334f);
            direction = Line.Direction.VERTICAL;
            a(0, 3, direction);
            return;
        }
        a(0, 0.5f);
    }

    public int i() {
        return 6;
    }
}
