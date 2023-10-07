package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import df.c;
import java.util.Arrays;

public class RoundedCornersDrawable extends g implements h {

    /* renamed from: a  reason: collision with root package name */
    Type f11134a = Type.OVERLAY_COLOR;

    /* renamed from: c  reason: collision with root package name */
    final float[] f11135c = new float[8];

    /* renamed from: d  reason: collision with root package name */
    final Paint f11136d = new Paint(1);

    /* renamed from: e  reason: collision with root package name */
    private final RectF f11137e = new RectF();

    /* renamed from: f  reason: collision with root package name */
    private RectF f11138f;

    /* renamed from: g  reason: collision with root package name */
    private Matrix f11139g;

    /* renamed from: h  reason: collision with root package name */
    private final float[] f11140h = new float[8];

    /* renamed from: i  reason: collision with root package name */
    private boolean f11141i = false;

    /* renamed from: j  reason: collision with root package name */
    private float f11142j = 0.0f;

    /* renamed from: k  reason: collision with root package name */
    private int f11143k = 0;

    /* renamed from: l  reason: collision with root package name */
    private int f11144l = 0;

    /* renamed from: m  reason: collision with root package name */
    private float f11145m = 0.0f;

    /* renamed from: n  reason: collision with root package name */
    private boolean f11146n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f11147o = false;

    /* renamed from: p  reason: collision with root package name */
    private final Path f11148p = new Path();

    /* renamed from: q  reason: collision with root package name */
    private final Path f11149q = new Path();

    /* renamed from: r  reason: collision with root package name */
    private final RectF f11150r = new RectF();

    /* renamed from: com.facebook.drawee.drawable.RoundedCornersDrawable$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f11151a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.facebook.drawee.drawable.RoundedCornersDrawable$Type[] r0 = com.facebook.drawee.drawable.RoundedCornersDrawable.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f11151a = r0
                com.facebook.drawee.drawable.RoundedCornersDrawable$Type r1 = com.facebook.drawee.drawable.RoundedCornersDrawable.Type.CLIPPING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f11151a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.drawee.drawable.RoundedCornersDrawable$Type r1 = com.facebook.drawee.drawable.RoundedCornersDrawable.Type.OVERLAY_COLOR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.drawable.RoundedCornersDrawable.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Type {
        OVERLAY_COLOR,
        CLIPPING
    }

    public RoundedCornersDrawable(Drawable drawable) {
        super((Drawable) c.a(drawable));
    }

    private void c() {
        float[] fArr;
        this.f11148p.reset();
        this.f11149q.reset();
        this.f11150r.set(getBounds());
        RectF rectF = this.f11150r;
        float f2 = this.f11145m;
        rectF.inset(f2, f2);
        this.f11148p.addRect(this.f11150r, Path.Direction.CW);
        if (this.f11141i) {
            this.f11148p.addCircle(this.f11150r.centerX(), this.f11150r.centerY(), Math.min(this.f11150r.width(), this.f11150r.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.f11148p.addRoundRect(this.f11150r, this.f11140h, Path.Direction.CW);
        }
        RectF rectF2 = this.f11150r;
        float f3 = this.f11145m;
        rectF2.inset(-f3, -f3);
        RectF rectF3 = this.f11150r;
        float f4 = this.f11142j;
        rectF3.inset(f4 / 2.0f, f4 / 2.0f);
        if (this.f11141i) {
            this.f11149q.addCircle(this.f11150r.centerX(), this.f11150r.centerY(), Math.min(this.f11150r.width(), this.f11150r.height()) / 2.0f, Path.Direction.CW);
        } else {
            int i2 = 0;
            while (true) {
                fArr = this.f11135c;
                if (i2 >= fArr.length) {
                    break;
                }
                fArr[i2] = (this.f11140h[i2] + this.f11145m) - (this.f11142j / 2.0f);
                i2++;
            }
            this.f11149q.addRoundRect(this.f11150r, fArr, Path.Direction.CW);
        }
        RectF rectF4 = this.f11150r;
        float f5 = this.f11142j;
        rectF4.inset((-f5) / 2.0f, (-f5) / 2.0f);
    }

    public void a(float f2) {
        this.f11145m = f2;
        c();
        invalidateSelf();
    }

    public void a(int i2) {
        this.f11144l = i2;
        invalidateSelf();
    }

    public void a(int i2, float f2) {
        this.f11143k = i2;
        this.f11142j = f2;
        c();
        invalidateSelf();
    }

    public void a(boolean z2) {
        this.f11141i = z2;
        c();
        invalidateSelf();
    }

    public void a(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.f11140h, 0.0f);
        } else {
            c.a(fArr.length == 8, (Object) "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.f11140h, 0, 8);
        }
        c();
        invalidateSelf();
    }

    public void b(boolean z2) {
        this.f11146n = z2;
        c();
        invalidateSelf();
    }

    public boolean b() {
        return this.f11147o;
    }

    public void c(boolean z2) {
        if (this.f11147o != z2) {
            this.f11147o = z2;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        this.f11137e.set(getBounds());
        int i2 = AnonymousClass1.f11151a[this.f11134a.ordinal()];
        if (i2 == 1) {
            int save = canvas.save();
            this.f11148p.setFillType(Path.FillType.EVEN_ODD);
            canvas.clipPath(this.f11148p);
            super.draw(canvas);
            canvas.restoreToCount(save);
        } else if (i2 == 2) {
            if (this.f11146n) {
                RectF rectF = this.f11138f;
                if (rectF == null) {
                    this.f11138f = new RectF(this.f11137e);
                    this.f11139g = new Matrix();
                } else {
                    rectF.set(this.f11137e);
                }
                RectF rectF2 = this.f11138f;
                float f2 = this.f11142j;
                rectF2.inset(f2, f2);
                this.f11139g.setRectToRect(this.f11137e, this.f11138f, Matrix.ScaleToFit.FILL);
                int save2 = canvas.save();
                canvas.clipRect(this.f11137e);
                canvas.concat(this.f11139g);
                super.draw(canvas);
                canvas.restoreToCount(save2);
            } else {
                super.draw(canvas);
            }
            this.f11136d.setStyle(Paint.Style.FILL);
            this.f11136d.setColor(this.f11144l);
            this.f11136d.setStrokeWidth(0.0f);
            this.f11136d.setFilterBitmap(b());
            this.f11148p.setFillType(Path.FillType.EVEN_ODD);
            canvas.drawPath(this.f11148p, this.f11136d);
            if (this.f11141i) {
                float width = ((this.f11137e.width() - this.f11137e.height()) + this.f11142j) / 2.0f;
                float height = ((this.f11137e.height() - this.f11137e.width()) + this.f11142j) / 2.0f;
                if (width > 0.0f) {
                    Canvas canvas2 = canvas;
                    canvas2.drawRect(this.f11137e.left, this.f11137e.top, this.f11137e.left + width, this.f11137e.bottom, this.f11136d);
                    canvas2.drawRect(this.f11137e.right - width, this.f11137e.top, this.f11137e.right, this.f11137e.bottom, this.f11136d);
                }
                if (height > 0.0f) {
                    Canvas canvas3 = canvas;
                    canvas3.drawRect(this.f11137e.left, this.f11137e.top, this.f11137e.right, this.f11137e.top + height, this.f11136d);
                    canvas3.drawRect(this.f11137e.left, this.f11137e.bottom - height, this.f11137e.right, this.f11137e.bottom, this.f11136d);
                }
            }
        }
        if (this.f11143k != 0) {
            this.f11136d.setStyle(Paint.Style.STROKE);
            this.f11136d.setColor(this.f11143k);
            this.f11136d.setStrokeWidth(this.f11142j);
            this.f11148p.setFillType(Path.FillType.EVEN_ODD);
            canvas.drawPath(this.f11149q, this.f11136d);
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        c();
    }
}
