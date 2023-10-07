package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.m;
import fa.d;
import fa.g;
import fc.i;
import fg.e;
import java.util.List;

public class PieChart extends PieRadarChartBase<m> {

    /* renamed from: a  reason: collision with root package name */
    protected float f14819a = 55.0f;

    /* renamed from: b  reason: collision with root package name */
    protected float f14820b = 360.0f;

    /* renamed from: e  reason: collision with root package name */
    private RectF f14821e = new RectF();

    /* renamed from: f  reason: collision with root package name */
    private boolean f14822f = true;

    /* renamed from: g  reason: collision with root package name */
    private float[] f14823g = new float[1];

    /* renamed from: h  reason: collision with root package name */
    private float[] f14824h = new float[1];

    /* renamed from: i  reason: collision with root package name */
    private boolean f14825i = true;

    /* renamed from: j  reason: collision with root package name */
    private boolean f14826j = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f14827k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f14828l = false;

    /* renamed from: m  reason: collision with root package name */
    private CharSequence f14829m = "";

    /* renamed from: n  reason: collision with root package name */
    private e f14830n = e.a(0.0f, 0.0f);

    /* renamed from: o  reason: collision with root package name */
    private float f14831o = 50.0f;

    /* renamed from: p  reason: collision with root package name */
    private boolean f14832p = true;

    /* renamed from: q  reason: collision with root package name */
    private float f14833q = 100.0f;

    /* renamed from: r  reason: collision with root package name */
    private float f14834r = 0.0f;

    public PieChart(Context context) {
        super(context);
    }

    public PieChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PieChart(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    private float e(float f2, float f3) {
        return (f2 / f3) * this.f14820b;
    }

    private void l() {
        int i2 = ((m) this.C).i();
        if (this.f14823g.length != i2) {
            this.f14823g = new float[i2];
        } else {
            for (int i3 = 0; i3 < i2; i3++) {
                this.f14823g[i3] = 0.0f;
            }
        }
        if (this.f14824h.length != i2) {
            this.f14824h = new float[i2];
        } else {
            for (int i4 = 0; i4 < i2; i4++) {
                this.f14824h[i4] = 0.0f;
            }
        }
        float k2 = ((m) this.C).k();
        List h2 = ((m) this.C).h();
        float f2 = this.f14834r;
        boolean z2 = f2 != 0.0f && ((float) i2) * f2 <= this.f14820b;
        float[] fArr = new float[i2];
        float f3 = 0.0f;
        float f4 = 0.0f;
        int i5 = 0;
        for (int i6 = 0; i6 < ((m) this.C).c(); i6++) {
            i iVar = (i) h2.get(i6);
            for (int i7 = 0; i7 < iVar.u(); i7++) {
                float e2 = e(Math.abs(((PieEntry) iVar.d(i7)).b()), k2);
                if (z2) {
                    float f5 = this.f14834r;
                    float f6 = e2 - f5;
                    if (f6 <= 0.0f) {
                        fArr[i5] = f5;
                        f3 += -f6;
                    } else {
                        fArr[i5] = e2;
                        f4 += f6;
                    }
                }
                float[] fArr2 = this.f14823g;
                fArr2[i5] = e2;
                float[] fArr3 = this.f14824h;
                if (i5 == 0) {
                    fArr3[i5] = fArr2[i5];
                } else {
                    fArr3[i5] = fArr3[i5 - 1] + fArr2[i5];
                }
                i5++;
            }
        }
        if (z2) {
            for (int i8 = 0; i8 < i2; i8++) {
                fArr[i8] = fArr[i8] - (((fArr[i8] - this.f14834r) / f4) * f3);
                if (i8 == 0) {
                    this.f14824h[0] = fArr[0];
                } else {
                    float[] fArr4 = this.f14824h;
                    fArr4[i8] = fArr4[i8 - 1] + fArr[i8];
                }
            }
            this.f14823g = fArr;
        }
    }

    public int a(float f2) {
        float c2 = fg.i.c(f2 - getRotationAngle());
        int i2 = 0;
        while (true) {
            float[] fArr = this.f14824h;
            if (i2 >= fArr.length) {
                return -1;
            }
            if (fArr[i2] > c2) {
                return i2;
            }
            i2++;
        }
    }

    /* access modifiers changed from: protected */
    public void a() {
        super.a();
        this.O = new fe.m(this, this.R, this.Q);
        this.H = null;
        this.P = new g(this);
    }

    public boolean a(int i2) {
        if (!x()) {
            return false;
        }
        for (d a2 : this.S) {
            if (((int) a2.a()) == i2) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public float[] a(d dVar) {
        e centerCircleBox = getCenterCircleBox();
        float radius = getRadius();
        float f2 = (radius / 10.0f) * 3.6f;
        if (d()) {
            f2 = (radius - ((radius / 100.0f) * getHoleRadius())) / 2.0f;
        }
        float f3 = radius - f2;
        float rotationAngle = getRotationAngle();
        int a2 = (int) dVar.a();
        float f4 = this.f14823g[a2] / 2.0f;
        double d2 = (double) f3;
        double cos = Math.cos(Math.toRadians((double) (((this.f14824h[a2] + rotationAngle) - f4) * this.R.a())));
        Double.isNaN(d2);
        double d3 = (double) centerCircleBox.f27222a;
        Double.isNaN(d3);
        float f5 = (float) ((cos * d2) + d3);
        double sin = Math.sin(Math.toRadians((double) (((rotationAngle + this.f14824h[a2]) - f4) * this.R.a())));
        Double.isNaN(d2);
        double d4 = d2 * sin;
        double d5 = (double) centerCircleBox.f27223b;
        Double.isNaN(d5);
        e.b(centerCircleBox);
        return new float[]{f5, (float) (d4 + d5)};
    }

    /* access modifiers changed from: protected */
    public void b() {
        l();
    }

    public boolean c() {
        return this.f14826j;
    }

    public boolean d() {
        return this.f14825i;
    }

    public boolean e() {
        return this.f14832p;
    }

    public boolean f() {
        return this.f14822f;
    }

    public boolean g() {
        return this.f14828l;
    }

    public float[] getAbsoluteAngles() {
        return this.f14824h;
    }

    public e getCenterCircleBox() {
        return e.a(this.f14821e.centerX(), this.f14821e.centerY());
    }

    public CharSequence getCenterText() {
        return this.f14829m;
    }

    public e getCenterTextOffset() {
        return e.a(this.f14830n.f27222a, this.f14830n.f27223b);
    }

    public float getCenterTextRadiusPercent() {
        return this.f14833q;
    }

    public RectF getCircleBox() {
        return this.f14821e;
    }

    public float[] getDrawAngles() {
        return this.f14823g;
    }

    public float getHoleRadius() {
        return this.f14831o;
    }

    public float getMaxAngle() {
        return this.f14820b;
    }

    public float getMinAngleForSlices() {
        return this.f14834r;
    }

    public float getRadius() {
        RectF rectF = this.f14821e;
        if (rectF == null) {
            return 0.0f;
        }
        return Math.min(rectF.width() / 2.0f, this.f14821e.height() / 2.0f);
    }

    /* access modifiers changed from: protected */
    public float getRequiredBaseOffset() {
        return 0.0f;
    }

    /* access modifiers changed from: protected */
    public float getRequiredLegendOffset() {
        return this.N.a().getTextSize() * 2.0f;
    }

    public float getTransparentCircleRadius() {
        return this.f14819a;
    }

    @Deprecated
    public XAxis getXAxis() {
        throw new RuntimeException("PieChart has no XAxis");
    }

    public boolean i() {
        return this.f14827k;
    }

    public void j() {
        super.j();
        if (this.C != null) {
            float diameter = getDiameter() / 2.0f;
            e centerOffsets = getCenterOffsets();
            float B = ((m) this.C).a().B();
            this.f14821e.set((centerOffsets.f27222a - diameter) + B, (centerOffsets.f27223b - diameter) + B, (centerOffsets.f27222a + diameter) - B, (centerOffsets.f27223b + diameter) - B);
            e.b(centerOffsets);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (this.O != null && (this.O instanceof fe.m)) {
            ((fe.m) this.O).f();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.C != null) {
            this.O.a(canvas);
            if (x()) {
                this.O.a(canvas, this.S);
            }
            this.O.c(canvas);
            this.O.b(canvas);
            this.N.a(canvas);
            b(canvas);
            c(canvas);
        }
    }

    public void setCenterText(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.f14829m = charSequence;
    }

    public void setCenterTextColor(int i2) {
        ((fe.m) this.O).d().setColor(i2);
    }

    public void setCenterTextRadiusPercent(float f2) {
        this.f14833q = f2;
    }

    public void setCenterTextSize(float f2) {
        ((fe.m) this.O).d().setTextSize(fg.i.a(f2));
    }

    public void setCenterTextSizePixels(float f2) {
        ((fe.m) this.O).d().setTextSize(f2);
    }

    public void setCenterTextTypeface(Typeface typeface) {
        ((fe.m) this.O).d().setTypeface(typeface);
    }

    public void setDrawCenterText(boolean z2) {
        this.f14832p = z2;
    }

    public void setDrawEntryLabels(boolean z2) {
        this.f14822f = z2;
    }

    public void setDrawHoleEnabled(boolean z2) {
        this.f14825i = z2;
    }

    public void setDrawRoundedSlices(boolean z2) {
        this.f14828l = z2;
    }

    @Deprecated
    public void setDrawSliceText(boolean z2) {
        this.f14822f = z2;
    }

    public void setDrawSlicesUnderHole(boolean z2) {
        this.f14826j = z2;
    }

    public void setEntryLabelColor(int i2) {
        ((fe.m) this.O).e().setColor(i2);
    }

    public void setEntryLabelTextSize(float f2) {
        ((fe.m) this.O).e().setTextSize(fg.i.a(f2));
    }

    public void setEntryLabelTypeface(Typeface typeface) {
        ((fe.m) this.O).e().setTypeface(typeface);
    }

    public void setHoleColor(int i2) {
        ((fe.m) this.O).b().setColor(i2);
    }

    public void setHoleRadius(float f2) {
        this.f14831o = f2;
    }

    public void setMaxAngle(float f2) {
        if (f2 > 360.0f) {
            f2 = 360.0f;
        }
        if (f2 < 90.0f) {
            f2 = 90.0f;
        }
        this.f14820b = f2;
    }

    public void setMinAngleForSlices(float f2) {
        float f3 = this.f14820b;
        if (f2 > f3 / 2.0f) {
            f2 = f3 / 2.0f;
        } else if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.f14834r = f2;
    }

    public void setTransparentCircleAlpha(int i2) {
        ((fe.m) this.O).c().setAlpha(i2);
    }

    public void setTransparentCircleColor(int i2) {
        Paint c2 = ((fe.m) this.O).c();
        int alpha = c2.getAlpha();
        c2.setColor(i2);
        c2.setAlpha(alpha);
    }

    public void setTransparentCircleRadius(float f2) {
        this.f14819a = f2;
    }

    public void setUsePercentValues(boolean z2) {
        this.f14827k = z2;
    }
}
