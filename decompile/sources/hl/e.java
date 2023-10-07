package hl;

import com.huantansheng.easyphotos.models.puzzle.Line;

public class e extends a {
    public e(int i2) {
        super(i2);
    }

    public void a() {
        Line.Direction direction;
        int i2 = this.f13365a;
        if (i2 == 0) {
            direction = Line.Direction.HORIZONTAL;
        } else if (i2 == 1) {
            direction = Line.Direction.VERTICAL;
        } else {
            return;
        }
        a(0, direction, 0.56f, 0.44f);
    }

    public int i() {
        return 2;
    }
}
