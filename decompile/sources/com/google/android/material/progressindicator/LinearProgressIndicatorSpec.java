package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R;
import com.google.android.material.internal.l;

public final class LinearProgressIndicatorSpec extends b {

    /* renamed from: g  reason: collision with root package name */
    public int f19440g;

    /* renamed from: h  reason: collision with root package name */
    public int f19441h;

    /* renamed from: i  reason: collision with root package name */
    boolean f19442i;

    public LinearProgressIndicatorSpec(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.linearProgressIndicatorStyle);
    }

    public LinearProgressIndicatorSpec(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, LinearProgressIndicator.f19439d);
    }

    public LinearProgressIndicatorSpec(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        boolean z2 = false;
        TypedArray a2 = l.a(context, attributeSet, R.styleable.LinearProgressIndicator, R.attr.linearProgressIndicatorStyle, LinearProgressIndicator.f19439d, new int[0]);
        this.f19440g = a2.getInt(R.styleable.LinearProgressIndicator_indeterminateAnimationType, 1);
        this.f19441h = a2.getInt(R.styleable.LinearProgressIndicator_indicatorDirectionLinear, 0);
        a2.recycle();
        c();
        this.f19442i = this.f19441h == 1 ? true : z2;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.f19440g != 0) {
            return;
        }
        if (this.f19445b > 0) {
            throw new IllegalArgumentException("Rounded corners are not supported in contiguous indeterminate animation.");
        } else if (this.f19446c.length < 3) {
            throw new IllegalArgumentException("Contiguous indeterminate animation must be used with 3 or more indicator colors.");
        }
    }
}
