package com.afollestad.date.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import as.c;
import com.afollestad.date.R;
import com.blankj.utilcode.constant.MemoryConstants;
import kotlin.TypeCastException;
import kotlin.jvm.internal.h;

public final class DayOfMonthRootView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final float f7485a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f7486b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DayOfMonthRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.c(context, "context");
        this.f7485a = c.a(context, R.dimen.day_of_month_height_ratio);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        View childAt = getChildAt(0);
        if (childAt != null) {
            this.f7486b = (TextView) childAt;
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int i4 = (int) (((float) size) * this.f7485a);
        setMeasuredDimension(size, i4);
        TextView textView = this.f7486b;
        if (textView == null) {
            h.b("textView");
        }
        textView.measure(View.MeasureSpec.makeMeasureSpec(i4, MemoryConstants.GB), View.MeasureSpec.makeMeasureSpec(i4, MemoryConstants.GB));
    }

    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        TextView textView = this.f7486b;
        if (textView == null) {
            h.b("textView");
        }
        textView.setEnabled(z2);
    }
}
