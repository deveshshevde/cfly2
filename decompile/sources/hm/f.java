package hm;

import com.huantansheng.easyphotos.models.puzzle.Line;

public class f extends e {
    public f(int i2) {
        super(i2);
    }

    public void a() {
        Line.Direction direction;
        int i2 = this.f13366a;
        if (i2 != 0) {
            if (i2 == 1) {
                direction = Line.Direction.VERTICAL;
                a(0, direction, 0.5f);
            } else if (i2 == 2) {
                a(0, 0.5f);
                return;
            } else if (i2 == 3) {
                a(0, 2, 1);
                return;
            } else if (i2 == 4) {
                a(0, 1, 2);
                return;
            } else if (i2 == 5) {
                a(0, 2, 2);
                return;
            }
        }
        direction = Line.Direction.HORIZONTAL;
        a(0, direction, 0.5f);
    }

    public int i() {
        return 6;
    }
}
