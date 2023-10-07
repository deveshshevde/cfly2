package com.scwang.smartrefresh.layout.internal;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

public abstract class b extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    protected Paint f12194a;

    protected b() {
        Paint paint = new Paint();
        this.f12194a = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f12194a.setAntiAlias(true);
        this.f12194a.setColor(-5592406);
    }

    public void a(int i2) {
        this.f12194a.setColor(i2);
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i2) {
        this.f12194a.setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f12194a.setColorFilter(colorFilter);
    }
}
