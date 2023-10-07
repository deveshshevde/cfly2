package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.cardview.R;

class g extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    static a f1651a;

    /* renamed from: b  reason: collision with root package name */
    private static final double f1652b = Math.cos(Math.toRadians(45.0d));

    /* renamed from: c  reason: collision with root package name */
    private final int f1653c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f1654d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f1655e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f1656f;

    /* renamed from: g  reason: collision with root package name */
    private final RectF f1657g;

    /* renamed from: h  reason: collision with root package name */
    private float f1658h;

    /* renamed from: i  reason: collision with root package name */
    private Path f1659i;

    /* renamed from: j  reason: collision with root package name */
    private float f1660j;

    /* renamed from: k  reason: collision with root package name */
    private float f1661k;

    /* renamed from: l  reason: collision with root package name */
    private float f1662l;

    /* renamed from: m  reason: collision with root package name */
    private ColorStateList f1663m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f1664n = true;

    /* renamed from: o  reason: collision with root package name */
    private final int f1665o;

    /* renamed from: p  reason: collision with root package name */
    private final int f1666p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f1667q = true;

    /* renamed from: r  reason: collision with root package name */
    private boolean f1668r = false;

    interface a {
        void a(Canvas canvas, RectF rectF, float f2, Paint paint);
    }

    g(Resources resources, ColorStateList colorStateList, float f2, float f3, float f4) {
        this.f1665o = resources.getColor(R.color.cardview_shadow_start_color);
        this.f1666p = resources.getColor(R.color.cardview_shadow_end_color);
        this.f1653c = resources.getDimensionPixelSize(R.dimen.cardview_compat_inset_shadow);
        this.f1654d = new Paint(5);
        b(colorStateList);
        Paint paint = new Paint(5);
        this.f1655e = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f1658h = (float) ((int) (f2 + 0.5f));
        this.f1657g = new RectF();
        Paint paint2 = new Paint(this.f1655e);
        this.f1656f = paint2;
        paint2.setAntiAlias(false);
        a(f3, f4);
    }

    static float a(float f2, float f3, boolean z2) {
        float f4 = f2 * 1.5f;
        if (!z2) {
            return f4;
        }
        double d2 = (double) f4;
        double d3 = (double) f3;
        Double.isNaN(d3);
        Double.isNaN(d2);
        return (float) (d2 + ((1.0d - f1652b) * d3));
    }

    private void a(float f2, float f3) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f2 + ". Must be >= 0");
        } else if (f3 >= 0.0f) {
            float d2 = (float) d(f2);
            float d3 = (float) d(f3);
            if (d2 > d3) {
                if (!this.f1668r) {
                    this.f1668r = true;
                }
                d2 = d3;
            }
            if (this.f1662l != d2 || this.f1660j != d3) {
                this.f1662l = d2;
                this.f1660j = d3;
                this.f1661k = (float) ((int) ((d2 * 1.5f) + ((float) this.f1653c) + 0.5f));
                this.f1664n = true;
                invalidateSelf();
            }
        } else {
            throw new IllegalArgumentException("Invalid max shadow size " + f3 + ". Must be >= 0");
        }
    }

    private void a(Canvas canvas) {
        float f2 = this.f1658h;
        float f3 = (-f2) - this.f1661k;
        float f4 = f2 + ((float) this.f1653c) + (this.f1662l / 2.0f);
        float f5 = f4 * 2.0f;
        boolean z2 = this.f1657g.width() - f5 > 0.0f;
        boolean z3 = this.f1657g.height() - f5 > 0.0f;
        int save = canvas.save();
        canvas.translate(this.f1657g.left + f4, this.f1657g.top + f4);
        canvas.drawPath(this.f1659i, this.f1655e);
        if (z2) {
            canvas.drawRect(0.0f, f3, this.f1657g.width() - f5, -this.f1658h, this.f1656f);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        canvas.translate(this.f1657g.right - f4, this.f1657g.bottom - f4);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f1659i, this.f1655e);
        if (z2) {
            canvas.drawRect(0.0f, f3, this.f1657g.width() - f5, (-this.f1658h) + this.f1661k, this.f1656f);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        canvas.translate(this.f1657g.left + f4, this.f1657g.bottom - f4);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f1659i, this.f1655e);
        if (z3) {
            canvas.drawRect(0.0f, f3, this.f1657g.height() - f5, -this.f1658h, this.f1656f);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        canvas.translate(this.f1657g.right - f4, this.f1657g.top + f4);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f1659i, this.f1655e);
        if (z3) {
            canvas.drawRect(0.0f, f3, this.f1657g.height() - f5, -this.f1658h, this.f1656f);
        }
        canvas.restoreToCount(save4);
    }

    static float b(float f2, float f3, boolean z2) {
        if (!z2) {
            return f2;
        }
        double d2 = (double) f2;
        double d3 = (double) f3;
        Double.isNaN(d3);
        Double.isNaN(d2);
        return (float) (d2 + ((1.0d - f1652b) * d3));
    }

    private void b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f1663m = colorStateList;
        this.f1654d.setColor(colorStateList.getColorForState(getState(), this.f1663m.getDefaultColor()));
    }

    private void b(Rect rect) {
        float f2 = this.f1660j * 1.5f;
        this.f1657g.set(((float) rect.left) + this.f1660j, ((float) rect.top) + f2, ((float) rect.right) - this.f1660j, ((float) rect.bottom) - f2);
        g();
    }

    private int d(float f2) {
        int i2 = (int) (f2 + 0.5f);
        return i2 % 2 == 1 ? i2 - 1 : i2;
    }

    private void g() {
        float f2 = this.f1658h;
        RectF rectF = new RectF(-f2, -f2, f2, f2);
        RectF rectF2 = new RectF(rectF);
        float f3 = this.f1661k;
        rectF2.inset(-f3, -f3);
        Path path = this.f1659i;
        if (path == null) {
            this.f1659i = new Path();
        } else {
            path.reset();
        }
        this.f1659i.setFillType(Path.FillType.EVEN_ODD);
        this.f1659i.moveTo(-this.f1658h, 0.0f);
        this.f1659i.rLineTo(-this.f1661k, 0.0f);
        this.f1659i.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f1659i.arcTo(rectF, 270.0f, -90.0f, false);
        this.f1659i.close();
        float f4 = this.f1658h;
        float f5 = f4 / (this.f1661k + f4);
        Paint paint = this.f1655e;
        float f6 = this.f1658h + this.f1661k;
        int i2 = this.f1665o;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f6, new int[]{i2, i2, this.f1666p}, new float[]{0.0f, f5, 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.f1656f;
        float f7 = this.f1658h;
        float f8 = this.f1661k;
        int i3 = this.f1665o;
        paint2.setShader(new LinearGradient(0.0f, (-f7) + f8, 0.0f, (-f7) - f8, new int[]{i3, i3, this.f1666p}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f1656f.setAntiAlias(false);
    }

    /* access modifiers changed from: package-private */
    public float a() {
        return this.f1658h;
    }

    /* access modifiers changed from: package-private */
    public void a(float f2) {
        if (f2 >= 0.0f) {
            float f3 = (float) ((int) (f2 + 0.5f));
            if (this.f1658h != f3) {
                this.f1658h = f3;
                this.f1664n = true;
                invalidateSelf();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid radius " + f2 + ". Must be >= 0");
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        b(colorStateList);
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public void a(Rect rect) {
        getPadding(rect);
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        this.f1667q = z2;
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public float b() {
        return this.f1662l;
    }

    /* access modifiers changed from: package-private */
    public void b(float f2) {
        a(f2, this.f1660j);
    }

    /* access modifiers changed from: package-private */
    public float c() {
        return this.f1660j;
    }

    /* access modifiers changed from: package-private */
    public void c(float f2) {
        a(this.f1662l, f2);
    }

    /* access modifiers changed from: package-private */
    public float d() {
        float f2 = this.f1660j;
        return (Math.max(f2, this.f1658h + ((float) this.f1653c) + (f2 / 2.0f)) * 2.0f) + ((this.f1660j + ((float) this.f1653c)) * 2.0f);
    }

    public void draw(Canvas canvas) {
        if (this.f1664n) {
            b(getBounds());
            this.f1664n = false;
        }
        canvas.translate(0.0f, this.f1662l / 2.0f);
        a(canvas);
        canvas.translate(0.0f, (-this.f1662l) / 2.0f);
        f1651a.a(canvas, this.f1657g, this.f1658h, this.f1654d);
    }

    /* access modifiers changed from: package-private */
    public float e() {
        float f2 = this.f1660j;
        return (Math.max(f2, this.f1658h + ((float) this.f1653c) + ((f2 * 1.5f) / 2.0f)) * 2.0f) + (((this.f1660j * 1.5f) + ((float) this.f1653c)) * 2.0f);
    }

    /* access modifiers changed from: package-private */
    public ColorStateList f() {
        return this.f1663m;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) a(this.f1660j, this.f1658h, this.f1667q));
        int ceil2 = (int) Math.ceil((double) b(this.f1660j, this.f1658h, this.f1667q));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.f1663m;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f1664n = true;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.f1663m;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f1654d.getColor() == colorForState) {
            return false;
        }
        this.f1654d.setColor(colorForState);
        this.f1664n = true;
        invalidateSelf();
        return true;
    }

    public void setAlpha(int i2) {
        this.f1654d.setAlpha(i2);
        this.f1655e.setAlpha(i2);
        this.f1656f.setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1654d.setColorFilter(colorFilter);
    }
}
