package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public final class dr extends View {

    /* renamed from: a  reason: collision with root package name */
    public static final int f8282a = Color.argb(255, 235, 235, 235);

    /* renamed from: b  reason: collision with root package name */
    public static final int f8283b = Color.argb(255, 21, 21, 21);

    /* renamed from: c  reason: collision with root package name */
    private Paint f8284c;

    public dr(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f8284c = paint;
        paint.setAntiAlias(true);
        this.f8284c.setColor(f8282a);
    }

    public final void a() {
        setVisibility(8);
    }

    public final void a(int i2) {
        Paint paint = this.f8284c;
        if (paint != null) {
            paint.setColor(i2);
            try {
                postInvalidate();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.f8284c);
    }
}
