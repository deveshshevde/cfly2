package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import df.c;
import java.util.Arrays;

public class j extends Drawable implements h {

    /* renamed from: a  reason: collision with root package name */
    final float[] f11191a = new float[8];

    /* renamed from: b  reason: collision with root package name */
    float[] f11192b;

    /* renamed from: c  reason: collision with root package name */
    final Paint f11193c = new Paint(1);

    /* renamed from: d  reason: collision with root package name */
    final Path f11194d = new Path();

    /* renamed from: e  reason: collision with root package name */
    final Path f11195e = new Path();

    /* renamed from: f  reason: collision with root package name */
    private final float[] f11196f = new float[8];

    /* renamed from: g  reason: collision with root package name */
    private boolean f11197g = false;

    /* renamed from: h  reason: collision with root package name */
    private float f11198h = 0.0f;

    /* renamed from: i  reason: collision with root package name */
    private float f11199i = 0.0f;

    /* renamed from: j  reason: collision with root package name */
    private int f11200j = 0;

    /* renamed from: k  reason: collision with root package name */
    private boolean f11201k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f11202l = false;

    /* renamed from: m  reason: collision with root package name */
    private int f11203m = 0;

    /* renamed from: n  reason: collision with root package name */
    private final RectF f11204n = new RectF();

    /* renamed from: o  reason: collision with root package name */
    private int f11205o = 255;

    public j(int i2) {
        a(i2);
    }

    public static j a(ColorDrawable colorDrawable) {
        return new j(colorDrawable.getColor());
    }

    private void b() {
        float[] fArr;
        float[] fArr2;
        this.f11194d.reset();
        this.f11195e.reset();
        this.f11204n.set(getBounds());
        RectF rectF = this.f11204n;
        float f2 = this.f11198h;
        rectF.inset(f2 / 2.0f, f2 / 2.0f);
        int i2 = 0;
        if (this.f11197g) {
            this.f11195e.addCircle(this.f11204n.centerX(), this.f11204n.centerY(), Math.min(this.f11204n.width(), this.f11204n.height()) / 2.0f, Path.Direction.CW);
        } else {
            int i3 = 0;
            while (true) {
                fArr2 = this.f11191a;
                if (i3 >= fArr2.length) {
                    break;
                }
                fArr2[i3] = (this.f11196f[i3] + this.f11199i) - (this.f11198h / 2.0f);
                i3++;
            }
            this.f11195e.addRoundRect(this.f11204n, fArr2, Path.Direction.CW);
        }
        RectF rectF2 = this.f11204n;
        float f3 = this.f11198h;
        rectF2.inset((-f3) / 2.0f, (-f3) / 2.0f);
        float f4 = this.f11199i + (this.f11201k ? this.f11198h : 0.0f);
        this.f11204n.inset(f4, f4);
        if (this.f11197g) {
            this.f11194d.addCircle(this.f11204n.centerX(), this.f11204n.centerY(), Math.min(this.f11204n.width(), this.f11204n.height()) / 2.0f, Path.Direction.CW);
        } else if (this.f11201k) {
            if (this.f11192b == null) {
                this.f11192b = new float[8];
            }
            while (true) {
                fArr = this.f11192b;
                if (i2 >= fArr.length) {
                    break;
                }
                fArr[i2] = this.f11196f[i2] - this.f11198h;
                i2++;
            }
            this.f11194d.addRoundRect(this.f11204n, fArr, Path.Direction.CW);
        } else {
            this.f11194d.addRoundRect(this.f11204n, this.f11196f, Path.Direction.CW);
        }
        float f5 = -f4;
        this.f11204n.inset(f5, f5);
    }

    public void a(float f2) {
        if (this.f11199i != f2) {
            this.f11199i = f2;
            b();
            invalidateSelf();
        }
    }

    public void a(int i2) {
        if (this.f11203m != i2) {
            this.f11203m = i2;
            invalidateSelf();
        }
    }

    public void a(int i2, float f2) {
        if (this.f11200j != i2) {
            this.f11200j = i2;
            invalidateSelf();
        }
        if (this.f11198h != f2) {
            this.f11198h = f2;
            b();
            invalidateSelf();
        }
    }

    public void a(boolean z2) {
        this.f11197g = z2;
        b();
        invalidateSelf();
    }

    public void a(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.f11196f, 0.0f);
        } else {
            c.a(fArr.length == 8, (Object) "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.f11196f, 0, 8);
        }
        b();
        invalidateSelf();
    }

    public boolean a() {
        return this.f11202l;
    }

    public void b(boolean z2) {
        if (this.f11201k != z2) {
            this.f11201k = z2;
            b();
            invalidateSelf();
        }
    }

    public void c(boolean z2) {
        if (this.f11202l != z2) {
            this.f11202l = z2;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        this.f11193c.setColor(e.a(this.f11203m, this.f11205o));
        this.f11193c.setStyle(Paint.Style.FILL);
        this.f11193c.setFilterBitmap(a());
        canvas.drawPath(this.f11194d, this.f11193c);
        if (this.f11198h != 0.0f) {
            this.f11193c.setColor(e.a(this.f11200j, this.f11205o));
            this.f11193c.setStyle(Paint.Style.STROKE);
            this.f11193c.setStrokeWidth(this.f11198h);
            canvas.drawPath(this.f11195e, this.f11193c);
        }
    }

    public int getAlpha() {
        return this.f11205o;
    }

    public int getOpacity() {
        return e.a(e.a(this.f11203m, this.f11205o));
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        b();
    }

    public void setAlpha(int i2) {
        if (i2 != this.f11205o) {
            this.f11205o = i2;
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
