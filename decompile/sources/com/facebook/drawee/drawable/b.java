package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import df.c;

public class b extends g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    float f11163a;

    /* renamed from: c  reason: collision with root package name */
    private int f11164c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11165d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f11166e;

    public b(Drawable drawable, int i2) {
        this(drawable, i2, true);
    }

    public b(Drawable drawable, int i2, boolean z2) {
        super((Drawable) c.a(drawable));
        this.f11163a = 0.0f;
        this.f11166e = false;
        this.f11164c = i2;
        this.f11165d = z2;
    }

    private void b() {
        if (!this.f11166e) {
            this.f11166e = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int c() {
        return (int) ((20.0f / ((float) this.f11164c)) * 360.0f);
    }

    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i2 = bounds.right - bounds.left;
        int i3 = bounds.bottom - bounds.top;
        float f2 = this.f11163a;
        if (!this.f11165d) {
            f2 = 360.0f - f2;
        }
        canvas.rotate(f2, (float) (bounds.left + (i2 / 2)), (float) (bounds.top + (i3 / 2)));
        super.draw(canvas);
        canvas.restoreToCount(save);
        b();
    }

    public void run() {
        this.f11166e = false;
        this.f11163a += (float) c();
        invalidateSelf();
    }
}
