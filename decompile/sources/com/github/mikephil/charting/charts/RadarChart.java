package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.h;
import com.github.mikephil.charting.data.n;
import fc.j;
import fe.s;
import fe.v;
import fg.i;

public class RadarChart extends PieRadarChartBase<n> {

    /* renamed from: a  reason: collision with root package name */
    protected v f14842a;

    /* renamed from: b  reason: collision with root package name */
    protected s f14843b;

    /* renamed from: e  reason: collision with root package name */
    private float f14844e = 2.5f;

    /* renamed from: f  reason: collision with root package name */
    private float f14845f = 1.5f;

    /* renamed from: g  reason: collision with root package name */
    private int f14846g = Color.rgb(122, 122, 122);

    /* renamed from: h  reason: collision with root package name */
    private int f14847h = Color.rgb(122, 122, 122);

    /* renamed from: i  reason: collision with root package name */
    private int f14848i = 150;

    /* renamed from: j  reason: collision with root package name */
    private boolean f14849j = true;

    /* renamed from: k  reason: collision with root package name */
    private int f14850k = 0;

    /* renamed from: l  reason: collision with root package name */
    private YAxis f14851l;

    public RadarChart(Context context) {
        super(context);
    }

    public RadarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RadarChart(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public int a(float f2) {
        float c2 = i.c(f2 - getRotationAngle());
        float sliceAngle = getSliceAngle();
        int u2 = ((j) ((n) this.C).j()).u();
        int i2 = 0;
        while (i2 < u2) {
            int i3 = i2 + 1;
            if ((((float) i3) * sliceAngle) - (sliceAngle / 2.0f) > c2) {
                return i2;
            }
            i2 = i3;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void a() {
        super.a();
        this.f14851l = new YAxis(YAxis.AxisDependency.LEFT);
        this.f14844e = i.a(1.5f);
        this.f14845f = i.a(0.75f);
        this.O = new fe.n(this, this.R, this.Q);
        this.f14842a = new v(this.Q, this.f14851l, this);
        this.f14843b = new s(this.Q, this.H, this);
        this.P = new fa.i(this);
    }

    /* access modifiers changed from: protected */
    public void b() {
        super.b();
        this.f14851l.a(((n) this.C).a(YAxis.AxisDependency.LEFT), ((n) this.C).b(YAxis.AxisDependency.LEFT));
        this.H.a(0.0f, (float) ((j) ((n) this.C).j()).u());
    }

    public float getFactor() {
        RectF k2 = this.Q.k();
        return Math.min(k2.width() / 2.0f, k2.height() / 2.0f) / this.f14851l.f14944v;
    }

    public float getRadius() {
        RectF k2 = this.Q.k();
        return Math.min(k2.width() / 2.0f, k2.height() / 2.0f);
    }

    /* access modifiers changed from: protected */
    public float getRequiredBaseOffset() {
        return (!this.H.y() || !this.H.h()) ? i.a(10.0f) : (float) this.H.E;
    }

    /* access modifiers changed from: protected */
    public float getRequiredLegendOffset() {
        return this.N.a().getTextSize() * 4.0f;
    }

    public int getSkipWebLineCount() {
        return this.f14850k;
    }

    public float getSliceAngle() {
        return 360.0f / ((float) ((j) ((n) this.C).j()).u());
    }

    public int getWebAlpha() {
        return this.f14848i;
    }

    public int getWebColor() {
        return this.f14846g;
    }

    public int getWebColorInner() {
        return this.f14847h;
    }

    public float getWebLineWidth() {
        return this.f14844e;
    }

    public float getWebLineWidthInner() {
        return this.f14845f;
    }

    public YAxis getYAxis() {
        return this.f14851l;
    }

    public float getYChartMax() {
        return this.f14851l.f14942t;
    }

    public float getYChartMin() {
        return this.f14851l.f14943u;
    }

    public float getYRange() {
        return this.f14851l.f14944v;
    }

    public void h() {
        if (this.C != null) {
            b();
            this.f14842a.a(this.f14851l.f14943u, this.f14851l.f14942t, this.f14851l.F());
            this.f14843b.a(this.H.f14943u, this.H.f14942t, false);
            if (this.K != null && !this.K.c()) {
                this.N.a((h<?>) this.C);
            }
            j();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.C != null) {
            if (this.H.y()) {
                this.f14843b.a(this.H.f14943u, this.H.f14942t, false);
            }
            this.f14843b.a(canvas);
            if (this.f14849j) {
                this.O.c(canvas);
            }
            if (this.f14851l.y() && this.f14851l.n()) {
                this.f14842a.e(canvas);
            }
            this.O.a(canvas);
            if (x()) {
                this.O.a(canvas, this.S);
            }
            if (this.f14851l.y() && !this.f14851l.n()) {
                this.f14842a.e(canvas);
            }
            this.f14842a.a(canvas);
            this.O.b(canvas);
            this.N.a(canvas);
            b(canvas);
            c(canvas);
        }
    }

    public void setDrawWeb(boolean z2) {
        this.f14849j = z2;
    }

    public void setSkipWebLineCount(int i2) {
        this.f14850k = Math.max(0, i2);
    }

    public void setWebAlpha(int i2) {
        this.f14848i = i2;
    }

    public void setWebColor(int i2) {
        this.f14846g = i2;
    }

    public void setWebColorInner(int i2) {
        this.f14847h = i2;
    }

    public void setWebLineWidth(float f2) {
        this.f14844e = i.a(f2);
    }

    public void setWebLineWidthInner(float f2) {
        this.f14845f = i.a(f2);
    }
}
