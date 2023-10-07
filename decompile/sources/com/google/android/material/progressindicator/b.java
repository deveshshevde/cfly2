package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R;
import com.google.android.material.internal.l;
import gn.a;
import gt.c;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public int f19444a;

    /* renamed from: b  reason: collision with root package name */
    public int f19445b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f19446c = new int[0];

    /* renamed from: d  reason: collision with root package name */
    public int f19447d;

    /* renamed from: e  reason: collision with root package name */
    public int f19448e;

    /* renamed from: f  reason: collision with root package name */
    public int f19449f;

    protected b(Context context, AttributeSet attributeSet, int i2, int i3) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_track_thickness);
        TypedArray a2 = l.a(context, attributeSet, R.styleable.BaseProgressIndicator, i2, i3, new int[0]);
        this.f19444a = c.a(context, a2, R.styleable.BaseProgressIndicator_trackThickness, dimensionPixelSize);
        this.f19445b = Math.min(c.a(context, a2, R.styleable.BaseProgressIndicator_trackCornerRadius, 0), this.f19444a / 2);
        this.f19448e = a2.getInt(R.styleable.BaseProgressIndicator_showAnimationBehavior, 0);
        this.f19449f = a2.getInt(R.styleable.BaseProgressIndicator_hideAnimationBehavior, 0);
        a(context, a2);
        b(context, a2);
        a2.recycle();
    }

    private void a(Context context, TypedArray typedArray) {
        if (!typedArray.hasValue(R.styleable.BaseProgressIndicator_indicatorColor)) {
            this.f19446c = new int[]{a.a(context, R.attr.colorPrimary, -1)};
        } else if (typedArray.peekValue(R.styleable.BaseProgressIndicator_indicatorColor).type != 1) {
            this.f19446c = new int[]{typedArray.getColor(R.styleable.BaseProgressIndicator_indicatorColor, -1)};
        } else {
            int[] intArray = context.getResources().getIntArray(typedArray.getResourceId(R.styleable.BaseProgressIndicator_indicatorColor, -1));
            this.f19446c = intArray;
            if (intArray.length == 0) {
                throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
            }
        }
    }

    private void b(Context context, TypedArray typedArray) {
        int b2;
        if (typedArray.hasValue(R.styleable.BaseProgressIndicator_trackColor)) {
            b2 = typedArray.getColor(R.styleable.BaseProgressIndicator_trackColor, -1);
        } else {
            this.f19447d = this.f19446c[0];
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16842803});
            float f2 = obtainStyledAttributes.getFloat(0, 0.2f);
            obtainStyledAttributes.recycle();
            b2 = a.b(this.f19447d, (int) (f2 * 255.0f));
        }
        this.f19447d = b2;
    }

    public boolean a() {
        return this.f19448e != 0;
    }

    public boolean b() {
        return this.f19449f != 0;
    }

    /* access modifiers changed from: package-private */
    public abstract void c();
}
