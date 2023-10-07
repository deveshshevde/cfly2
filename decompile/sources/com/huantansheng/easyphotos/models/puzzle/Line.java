package com.huantansheng.easyphotos.models.puzzle;

import android.graphics.PointF;

public interface Line {

    public enum Direction {
        HORIZONTAL,
        VERTICAL
    }

    PointF a();

    void a(Line line);

    boolean a(float f2, float f3);

    boolean a(float f2, float f3, float f4);

    PointF b();

    void b(float f2, float f3);

    void b(Line line);

    Line c();

    Line d();

    Line e();

    Line f();

    Direction g();

    void h();

    float i();

    float j();

    float k();

    float l();
}
