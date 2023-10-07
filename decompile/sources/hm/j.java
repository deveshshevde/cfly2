package hm;

import com.huantansheng.easyphotos.models.puzzle.Line;

public class j extends e {
    public j(int i2) {
        super(i2);
    }

    public void a() {
        Line.Direction direction;
        Line.Direction direction2;
        Line.Direction direction3;
        int i2 = this.f13366a;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        a(0, Line.Direction.HORIZONTAL, 0.5f);
                        direction3 = Line.Direction.VERTICAL;
                    } else if (i2 == 4) {
                        a(0, Line.Direction.VERTICAL, 0.5f);
                        direction2 = Line.Direction.HORIZONTAL;
                    } else if (i2 == 5) {
                        a(0, Line.Direction.VERTICAL, 0.5f);
                        direction3 = Line.Direction.HORIZONTAL;
                    }
                    a(1, direction3, 0.5f);
                    return;
                }
                a(0, Line.Direction.HORIZONTAL, 0.5f);
                direction2 = Line.Direction.VERTICAL;
                a(0, direction2, 0.5f);
                return;
            }
            direction = Line.Direction.VERTICAL;
            a(0, 3, direction);
        }
        direction = Line.Direction.HORIZONTAL;
        a(0, 3, direction);
    }

    public int i() {
        return 6;
    }
}
