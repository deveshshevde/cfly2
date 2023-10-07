package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.a;
import com.github.mikephil.charting.data.g;
import com.github.mikephil.charting.data.i;
import com.github.mikephil.charting.data.j;
import com.github.mikephil.charting.data.o;
import fa.c;
import fa.d;
import fb.f;
import fc.b;

public class CombinedChart extends BarLineChartBase<i> implements f {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f14807a = false;

    /* renamed from: aa  reason: collision with root package name */
    protected DrawOrder[] f14808aa;

    /* renamed from: ab  reason: collision with root package name */
    private boolean f14809ab = true;

    /* renamed from: ac  reason: collision with root package name */
    private boolean f14810ac = false;

    public enum DrawOrder {
        BAR,
        BUBBLE,
        LINE,
        CANDLE,
        SCATTER
    }

    public CombinedChart(Context context) {
        super(context);
    }

    public CombinedChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CombinedChart(Context context, AttributeSet attributeSet, int i2) {
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
        this.f14808aa = new DrawOrder[]{DrawOrder.BAR, DrawOrder.BUBBLE, DrawOrder.LINE, DrawOrder.CANDLE, DrawOrder.SCATTER};
        setHighlighter(new c(this, this));
        setHighlightFullBarEnabled(true);
        this.O = new fe.f(this, this.R, this.Q);
    }

    /* access modifiers changed from: protected */
    public void c(Canvas canvas) {
        if (this.V != null && C() && x()) {
            for (d dVar : this.S) {
                b<? extends Entry> b2 = ((i) this.C).b(dVar);
                Entry a2 = ((i) this.C).a(dVar);
                if (a2 != null && ((float) b2.b(a2)) <= ((float) b2.u()) * this.R.b()) {
                    float[] a3 = a(dVar);
                    if (this.Q.b(a3[0], a3[1])) {
                        this.V.a(a2, dVar);
                        this.V.a(canvas, a3[0], a3[1]);
                    }
                }
            }
        }
    }

    public boolean c() {
        return this.f14809ab;
    }

    public boolean d() {
        return this.f14810ac;
    }

    public boolean e() {
        return this.f14807a;
    }

    public a getBarData() {
        if (this.C == null) {
            return null;
        }
        return ((i) this.C).l();
    }

    public com.github.mikephil.charting.data.f getBubbleData() {
        if (this.C == null) {
            return null;
        }
        return ((i) this.C).a();
    }

    public g getCandleData() {
        if (this.C == null) {
            return null;
        }
        return ((i) this.C).n();
    }

    public i getCombinedData() {
        return (i) this.C;
    }

    public DrawOrder[] getDrawOrder() {
        return this.f14808aa;
    }

    public j getLineData() {
        if (this.C == null) {
            return null;
        }
        return ((i) this.C).k();
    }

    public o getScatterData() {
        if (this.C == null) {
            return null;
        }
        return ((i) this.C).m();
    }

    public void setData(i iVar) {
        super.setData(iVar);
        setHighlighter(new c(this, this));
        ((fe.f) this.O).b();
        this.O.a();
    }

    public void setDrawBarShadow(boolean z2) {
        this.f14810ac = z2;
    }

    public void setDrawOrder(DrawOrder[] drawOrderArr) {
        if (drawOrderArr != null && drawOrderArr.length > 0) {
            this.f14808aa = drawOrderArr;
        }
    }

    public void setDrawValueAboveBar(boolean z2) {
        this.f14809ab = z2;
    }

    public void setHighlightFullBarEnabled(boolean z2) {
        this.f14807a = z2;
    }
}
