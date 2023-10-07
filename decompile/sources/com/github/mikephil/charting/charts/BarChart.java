package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.a;
import fa.d;
import fe.b;

public class BarChart extends BarLineChartBase<a> implements fb.a {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f14756a = false;

    /* renamed from: aa  reason: collision with root package name */
    private boolean f14757aa = true;

    /* renamed from: ab  reason: collision with root package name */
    private boolean f14758ab = false;

    /* renamed from: ac  reason: collision with root package name */
    private boolean f14759ac = false;

    public BarChart(Context context) {
        super(context);
    }

    public BarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BarChart(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public d a(float f2, float f3) {
        if (this.C == null) {
            Log.e("MPAndroidChart", "Can't select by touch. No data set.");
            return null;
        }
        d a2 = getHighlighter().a(f2, f3);
        return (a2 == null || !e()) ? a2 : new d(a2.a(), a2.b(), a2.c(), a2.d(), a2.f(), -1, a2.h());
    }

    /* access modifiers changed from: protected */
    public void a() {
        super.a();
        this.O = new b(this, this.R, this.Q);
        setHighlighter(new fa.a(this));
        getXAxis().a(0.5f);
        getXAxis().b(0.5f);
    }

    /* access modifiers changed from: protected */
    public void b() {
        float f2;
        float f3;
        XAxis xAxis;
        if (this.f14759ac) {
            xAxis = this.H;
            f3 = ((a) this.C).f() - (((a) this.C).a() / 2.0f);
            f2 = ((a) this.C).g() + (((a) this.C).a() / 2.0f);
        } else {
            xAxis = this.H;
            f3 = ((a) this.C).f();
            f2 = ((a) this.C).g();
        }
        xAxis.a(f3, f2);
        this.f14781o.a(((a) this.C).a(YAxis.AxisDependency.LEFT), ((a) this.C).b(YAxis.AxisDependency.LEFT));
        this.f14782p.a(((a) this.C).a(YAxis.AxisDependency.RIGHT), ((a) this.C).b(YAxis.AxisDependency.RIGHT));
    }

    public boolean c() {
        return this.f14757aa;
    }

    public boolean d() {
        return this.f14758ab;
    }

    public boolean e() {
        return this.f14756a;
    }

    public a getBarData() {
        return (a) this.C;
    }

    public void setDrawBarShadow(boolean z2) {
        this.f14758ab = z2;
    }

    public void setDrawValueAboveBar(boolean z2) {
        this.f14757aa = z2;
    }

    public void setFitBars(boolean z2) {
        this.f14759ac = z2;
    }

    public void setHighlightFullBarEnabled(boolean z2) {
        this.f14756a = z2;
    }
}
