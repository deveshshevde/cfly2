package hm;

import com.huantansheng.easyphotos.models.puzzle.Line;

public class k extends e {

    /* renamed from: b  reason: collision with root package name */
    private float f13367b = 0.5f;

    public k(int i2) {
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
                        direction3 = Line.Direction.HORIZONTAL;
                    } else if (i2 == 4) {
                        direction2 = Line.Direction.VERTICAL;
                    } else if (i2 == 5) {
                        direction3 = Line.Direction.VERTICAL;
                    }
                    a(0, direction3, 0.6666667f);
                    return;
                }
                direction2 = Line.Direction.HORIZONTAL;
                a(0, direction2, 0.33333334f);
                return;
            }
            direction = Line.Direction.VERTICAL;
            a(0, direction, this.f13367b);
        }
        direction = Line.Direction.HORIZONTAL;
        a(0, direction, this.f13367b);
    }

    public int i() {
        return 6;
    }
}
