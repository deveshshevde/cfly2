package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R;
import com.google.android.material.internal.l;
import gt.c;

public final class CircularProgressIndicatorSpec extends b {

    /* renamed from: g  reason: collision with root package name */
    public int f19436g;

    /* renamed from: h  reason: collision with root package name */
    public int f19437h;

    /* renamed from: i  reason: collision with root package name */
    public int f19438i;

    public CircularProgressIndicatorSpec(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.circularProgressIndicatorStyle);
    }

    public CircularProgressIndicatorSpec(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, CircularProgressIndicator.f19435d);
    }

    public CircularProgressIndicatorSpec(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_circular_size_medium);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_circular_inset_medium);
        TypedArray a2 = l.a(context, attributeSet, R.styleable.CircularProgressIndicator, i2, i3, new int[0]);
        this.f19436g = Math.max(c.a(context, a2, R.styleable.CircularProgressIndicator_indicatorSize, dimensionPixelSize), this.f19444a * 2);
        this.f19437h = c.a(context, a2, R.styleable.CircularProgressIndicator_indicatorInset, dimensionPixelSize2);
        this.f19438i = a2.getInt(R.styleable.CircularProgressIndicator_indicatorDirectionCircular, 0);
        a2.recycle();
        c();
    }

    /* access modifiers changed from: package-private */
    public void c() {
    }
}
