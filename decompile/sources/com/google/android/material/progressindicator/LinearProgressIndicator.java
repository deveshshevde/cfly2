package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.R;
import t.ac;

public final class LinearProgressIndicator extends BaseProgressIndicator<LinearProgressIndicatorSpec> {

    /* renamed from: d  reason: collision with root package name */
    public static final int f19439d = R.style.Widget_MaterialComponents_LinearProgressIndicator;

    public LinearProgressIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public LinearProgressIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.linearProgressIndicatorStyle);
    }

    public LinearProgressIndicator(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2, f19439d);
        c();
    }

    private void c() {
        setIndeterminateDrawable(i.a(getContext(), (LinearProgressIndicatorSpec) this.f19417b));
        setProgressDrawable(e.a(getContext(), (LinearProgressIndicatorSpec) this.f19417b));
    }

    public void a(int i2, boolean z2) {
        if (this.f19417b == null || ((LinearProgressIndicatorSpec) this.f19417b).f19440g != 0 || !isIndeterminate()) {
            super.a(i2, z2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public LinearProgressIndicatorSpec a(Context context, AttributeSet attributeSet) {
        return new LinearProgressIndicatorSpec(context, attributeSet);
    }

    public int getIndeterminateAnimationType() {
        return ((LinearProgressIndicatorSpec) this.f19417b).f19440g;
    }

    public int getIndicatorDirection() {
        return ((LinearProgressIndicatorSpec) this.f19417b).f19441h;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) this.f19417b;
        boolean z3 = true;
        if (!(((LinearProgressIndicatorSpec) this.f19417b).f19441h == 1 || ((ac.i(this) == 1 && ((LinearProgressIndicatorSpec) this.f19417b).f19441h == 2) || (ac.i(this) == 0 && ((LinearProgressIndicatorSpec) this.f19417b).f19441h == 3)))) {
            z3 = false;
        }
        linearProgressIndicatorSpec.f19442i = z3;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        int paddingLeft = i2 - (getPaddingLeft() + getPaddingRight());
        int paddingTop = i3 - (getPaddingTop() + getPaddingBottom());
        i indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
        e progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
    }

    public void setIndeterminateAnimationType(int i2) {
        i iVar;
        h hVar;
        if (((LinearProgressIndicatorSpec) this.f19417b).f19440g != i2) {
            if (!a() || !isIndeterminate()) {
                ((LinearProgressIndicatorSpec) this.f19417b).f19440g = i2;
                ((LinearProgressIndicatorSpec) this.f19417b).c();
                if (i2 == 0) {
                    iVar = getIndeterminateDrawable();
                    hVar = new k((LinearProgressIndicatorSpec) this.f19417b);
                } else {
                    iVar = getIndeterminateDrawable();
                    hVar = new l(getContext(), (LinearProgressIndicatorSpec) this.f19417b);
                }
                iVar.a((h<ObjectAnimator>) hVar);
                invalidate();
                return;
            }
            throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
        }
    }

    public void setIndicatorColor(int... iArr) {
        super.setIndicatorColor(iArr);
        ((LinearProgressIndicatorSpec) this.f19417b).c();
    }

    public void setIndicatorDirection(int i2) {
        ((LinearProgressIndicatorSpec) this.f19417b).f19441h = i2;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) this.f19417b;
        boolean z2 = true;
        if (!(i2 == 1 || ((ac.i(this) == 1 && ((LinearProgressIndicatorSpec) this.f19417b).f19441h == 2) || (ac.i(this) == 0 && i2 == 3)))) {
            z2 = false;
        }
        linearProgressIndicatorSpec.f19442i = z2;
        invalidate();
    }

    public void setTrackCornerRadius(int i2) {
        super.setTrackCornerRadius(i2);
        ((LinearProgressIndicatorSpec) this.f19417b).c();
        invalidate();
    }
}
