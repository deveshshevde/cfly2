package com.github.mikephil.charting.components;

import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.Entry;
import fa.d;
import fg.e;
import java.lang.ref.WeakReference;

public class MarkerView extends RelativeLayout implements d {

    /* renamed from: a  reason: collision with root package name */
    private e f14908a;

    /* renamed from: b  reason: collision with root package name */
    private e f14909b;

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<Chart> f14910c;

    private void setupLayoutResource(int i2) {
        View inflate = LayoutInflater.from(getContext()).inflate(i2, this);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        inflate.layout(0, 0, inflate.getMeasuredWidth(), inflate.getMeasuredHeight());
    }

    public e a(float f2, float f3) {
        e offset = getOffset();
        this.f14909b.f27222a = offset.f27222a;
        this.f14909b.f27223b = offset.f27223b;
        Chart chartView = getChartView();
        float width = (float) getWidth();
        float height = (float) getHeight();
        if (this.f14909b.f27222a + f2 < 0.0f) {
            this.f14909b.f27222a = -f2;
        } else if (chartView != null && f2 + width + this.f14909b.f27222a > ((float) chartView.getWidth())) {
            this.f14909b.f27222a = (((float) chartView.getWidth()) - f2) - width;
        }
        if (this.f14909b.f27223b + f3 < 0.0f) {
            this.f14909b.f27223b = -f3;
        } else if (chartView != null && f3 + height + this.f14909b.f27223b > ((float) chartView.getHeight())) {
            this.f14909b.f27223b = (((float) chartView.getHeight()) - f3) - height;
        }
        return this.f14909b;
    }

    public void a(Canvas canvas, float f2, float f3) {
        e a2 = a(f2, f3);
        int save = canvas.save();
        canvas.translate(f2 + a2.f27222a, f3 + a2.f27223b);
        draw(canvas);
        canvas.restoreToCount(save);
    }

    public void a(Entry entry, d dVar) {
        measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    public Chart getChartView() {
        WeakReference<Chart> weakReference = this.f14910c;
        if (weakReference == null) {
            return null;
        }
        return (Chart) weakReference.get();
    }

    public e getOffset() {
        return this.f14908a;
    }

    public void setChartView(Chart chart) {
        this.f14910c = new WeakReference<>(chart);
    }

    public void setOffset(e eVar) {
        this.f14908a = eVar;
        if (eVar == null) {
            this.f14908a = new e();
        }
    }
}
