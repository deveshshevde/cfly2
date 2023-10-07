package com.facebook.drawee.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import ds.b;
import java.lang.ref.WeakReference;

public class i extends k {

    /* renamed from: w  reason: collision with root package name */
    private final Paint f11187w;

    /* renamed from: x  reason: collision with root package name */
    private final Paint f11188x;

    /* renamed from: y  reason: collision with root package name */
    private final Bitmap f11189y;

    /* renamed from: z  reason: collision with root package name */
    private WeakReference<Bitmap> f11190z;

    public i(Resources resources, Bitmap bitmap, Paint paint) {
        super(new BitmapDrawable(resources, bitmap));
        Paint paint2 = new Paint();
        this.f11187w = paint2;
        Paint paint3 = new Paint(1);
        this.f11188x = paint3;
        this.f11189y = bitmap;
        if (paint != null) {
            paint2.set(paint);
        }
        paint2.setFlags(1);
        paint3.setStyle(Paint.Style.STROKE);
    }

    private void e() {
        WeakReference<Bitmap> weakReference = this.f11190z;
        if (weakReference == null || weakReference.get() != this.f11189y) {
            this.f11190z = new WeakReference<>(this.f11189y);
            this.f11187w.setShader(new BitmapShader(this.f11189y, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            this.f11210e = true;
        }
        if (this.f11210e) {
            this.f11187w.getShader().setLocalMatrix(this.f11227v);
            this.f11210e = false;
        }
        this.f11187w.setFilterBitmap(b());
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return super.a() && this.f11189y != null;
    }

    public void draw(Canvas canvas) {
        if (b.b()) {
            b.a("RoundedBitmapDrawable#draw");
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
        e();
        int save = canvas.save();
        canvas.concat(this.f11224s);
        canvas.drawPath(this.f11209d, this.f11187w);
        if (this.f11208c > 0.0f) {
            this.f11188x.setStrokeWidth(this.f11208c);
            this.f11188x.setColor(e.a(this.f11211f, this.f11187w.getAlpha()));
            canvas.drawPath(this.f11212g, this.f11188x);
        }
        canvas.restoreToCount(save);
        if (b.b()) {
            b.a();
        }
    }

    public void setAlpha(int i2) {
        super.setAlpha(i2);
        if (i2 != this.f11187w.getAlpha()) {
            this.f11187w.setAlpha(i2);
            super.setAlpha(i2);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
        this.f11187w.setColorFilter(colorFilter);
    }
}
