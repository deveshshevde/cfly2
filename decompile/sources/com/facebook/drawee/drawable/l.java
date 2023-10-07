package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.NinePatchDrawable;
import ds.b;

public class l extends k {
    public l(NinePatchDrawable ninePatchDrawable) {
        super(ninePatchDrawable);
    }

    public void draw(Canvas canvas) {
        if (b.b()) {
            b.a("RoundedNinePatchDrawable#draw");
        }
        if (!a()) {
            super.draw(canvas);
            if (b.b()) {
                b.a();
                return;
            }
            return;
        }
        c();
        d();
        canvas.clipPath(this.f11209d);
        super.draw(canvas);
        if (b.b()) {
            b.a();
        }
    }
}
