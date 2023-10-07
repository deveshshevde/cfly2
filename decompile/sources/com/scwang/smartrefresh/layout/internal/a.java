package com.scwang.smartrefresh.layout.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;

public class a extends b {

    /* renamed from: b  reason: collision with root package name */
    private int f12191b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f12192c = 0;

    /* renamed from: d  reason: collision with root package name */
    private Path f12193d = new Path();

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        if (!(this.f12191b == width && this.f12192c == height)) {
            this.f12193d.reset();
            float f2 = (float) ((width * 30) / 225);
            float f3 = f2 * 0.70710677f;
            float f4 = f2 / 0.70710677f;
            float f5 = (float) width;
            float f6 = f5 / 2.0f;
            float f7 = (float) height;
            this.f12193d.moveTo(f6, f7);
            float f8 = f7 / 2.0f;
            this.f12193d.lineTo(0.0f, f8);
            float f9 = f8 - f3;
            this.f12193d.lineTo(f3, f9);
            float f10 = f2 / 2.0f;
            float f11 = f6 - f10;
            float f12 = (f7 - f4) - f10;
            this.f12193d.lineTo(f11, f12);
            this.f12193d.lineTo(f11, 0.0f);
            float f13 = f6 + f10;
            this.f12193d.lineTo(f13, 0.0f);
            this.f12193d.lineTo(f13, f12);
            this.f12193d.lineTo(f5 - f3, f9);
            this.f12193d.lineTo(f5, f8);
            this.f12193d.close();
            this.f12191b = width;
            this.f12192c = height;
        }
        canvas.drawPath(this.f12193d, this.f12194a);
    }
}
