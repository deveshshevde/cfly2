package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import fa.d;
import fa.e;
import fe.r;
import fe.u;
import fg.c;
import fg.h;
import fg.i;

public class HorizontalBarChart extends BarChart {

    /* renamed from: aa  reason: collision with root package name */
    protected float[] f14817aa = new float[2];

    /* renamed from: ab  reason: collision with root package name */
    private RectF f14818ab = new RectF();

    public HorizontalBarChart(Context context) {
        super(context);
    }

    public HorizontalBarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HorizontalBarChart(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public d a(float f2, float f3) {
        if (this.C != null) {
            return getHighlighter().a(f3, f2);
        }
        if (!this.B) {
            return null;
        }
        Log.e("MPAndroidChart", "Can't select by touch. No data set.");
        return null;
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.Q = new c();
        super.a();
        this.f14785s = new h(this.Q);
        this.f14786t = new h(this.Q);
        this.O = new fe.h(this, this.R, this.Q);
        setHighlighter(new e(this));
        this.f14783q = new u(this.Q, this.f14781o, this.f14785s);
        this.f14784r = new u(this.Q, this.f14782p, this.f14786t);
        this.f14787u = new r(this.Q, this.H, this.f14785s, this);
    }

    /* access modifiers changed from: protected */
    public float[] a(d dVar) {
        return new float[]{dVar.j(), dVar.i()};
    }

    /* access modifiers changed from: protected */
    public void f() {
        this.f14786t.a(this.f14782p.f14943u, this.f14782p.f14944v, this.H.f14944v, this.H.f14943u);
        this.f14785s.a(this.f14781o.f14943u, this.f14781o.f14944v, this.H.f14944v, this.H.f14943u);
    }

    public float getHighestVisibleX() {
        a(YAxis.AxisDependency.LEFT).a(this.Q.f(), this.Q.e(), this.f14792z);
        return (float) Math.min((double) this.H.f14942t, this.f14792z.f27219b);
    }

    public float getLowestVisibleX() {
        a(YAxis.AxisDependency.LEFT).a(this.Q.f(), this.Q.h(), this.f14791y);
        return (float) Math.max((double) this.H.f14943u, this.f14791y.f27219b);
    }

    public void j() {
        a(this.f14818ab);
        float f2 = this.f14818ab.left + 0.0f;
        float f3 = this.f14818ab.top + 0.0f;
        float f4 = this.f14818ab.right + 0.0f;
        float f5 = this.f14818ab.bottom + 0.0f;
        if (this.f14781o.L()) {
            f3 += this.f14781o.b(this.f14783q.a());
        }
        if (this.f14782p.L()) {
            f5 += this.f14782p.b(this.f14784r.a());
        }
        float f6 = (float) this.H.E;
        if (this.H.y()) {
            if (this.H.z() == XAxis.XAxisPosition.BOTTOM) {
                f2 += f6;
            } else {
                if (this.H.z() != XAxis.XAxisPosition.TOP) {
                    if (this.H.z() == XAxis.XAxisPosition.BOTH_SIDED) {
                        f2 += f6;
                    }
                }
                f4 += f6;
            }
        }
        float extraTopOffset = f3 + getExtraTopOffset();
        float extraRightOffset = f4 + getExtraRightOffset();
        float extraBottomOffset = f5 + getExtraBottomOffset();
        float extraLeftOffset = f2 + getExtraLeftOffset();
        float a2 = i.a(this.f14778l);
        this.Q.a(Math.max(a2, extraLeftOffset), Math.max(a2, extraTopOffset), Math.max(a2, extraRightOffset), Math.max(a2, extraBottomOffset));
        if (this.B) {
            Log.i("MPAndroidChart", "offsetLeft: " + extraLeftOffset + ", offsetTop: " + extraTopOffset + ", offsetRight: " + extraRightOffset + ", offsetBottom: " + extraBottomOffset);
            StringBuilder sb = new StringBuilder();
            sb.append("Content: ");
            sb.append(this.Q.k().toString());
            Log.i("MPAndroidChart", sb.toString());
        }
        g();
        f();
    }

    public void setVisibleXRangeMaximum(float f2) {
        this.Q.c(this.H.f14944v / f2);
    }

    public void setVisibleXRangeMinimum(float f2) {
        this.Q.d(this.H.f14944v / f2);
    }
}
