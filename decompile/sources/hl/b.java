package hl;

import com.huantansheng.easyphotos.models.puzzle.Line;

public class b extends a {
    public b(int i2) {
        super(i2);
    }

    public void a() {
        Line.Direction direction;
        int i2 = this.f13365a;
        if (i2 == 0) {
            direction = Line.Direction.HORIZONTAL;
        } else if (i2 == 1) {
            direction = Line.Direction.VERTICAL;
        } else if (i2 == 2) {
            a(0, 0.56f, 0.44f, 0.56f, 0.44f);
            return;
        } else if (i2 == 3) {
            a(0, 1, 2);
            return;
        } else {
            return;
        }
        a(0, direction, 0.56f, 0.44f);
    }

    public int i() {
        return 4;
    }
}
