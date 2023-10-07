package com.recyclerview.swipe;

import android.view.View;
import android.widget.OverScroller;
import com.recyclerview.swipe.e;

class f extends e {
    public f(View view) {
        super(1, view);
    }

    public e.a a(int i2, int i3) {
        this.f21532a.f21535a = i2;
        this.f21532a.f21536b = i3;
        this.f21532a.f21537c = false;
        if (this.f21532a.f21535a == 0) {
            this.f21532a.f21537c = true;
        }
        if (this.f21532a.f21535a >= 0) {
            this.f21532a.f21535a = 0;
        }
        if (this.f21532a.f21535a <= (-c().getWidth())) {
            this.f21532a.f21535a = -c().getWidth();
        }
        return this.f21532a;
    }

    public void a(OverScroller overScroller, int i2, int i3) {
        overScroller.startScroll(Math.abs(i2), 0, c().getWidth() - Math.abs(i2), 0, i3);
    }

    public boolean a(int i2, float f2) {
        return f2 > ((float) c().getWidth());
    }

    public void b(OverScroller overScroller, int i2, int i3) {
        overScroller.startScroll(-Math.abs(i2), 0, Math.abs(i2), 0, i3);
    }

    public boolean b(int i2) {
        int b2 = (-c().getWidth()) * b();
        return i2 <= b2 && b2 != 0;
    }

    public boolean c(int i2) {
        return i2 < (-c().getWidth()) * b();
    }
}
