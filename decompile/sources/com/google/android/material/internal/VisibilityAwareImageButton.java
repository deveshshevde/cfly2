package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class VisibilityAwareImageButton extends ImageButton {

    /* renamed from: a  reason: collision with root package name */
    private int f19231a;

    public VisibilityAwareImageButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f19231a = getVisibility();
    }

    public final void a(int i2, boolean z2) {
        super.setVisibility(i2);
        if (z2) {
            this.f19231a = i2;
        }
    }

    public final int getUserSetVisibility() {
        return this.f19231a;
    }

    public void setVisibility(int i2) {
        a(i2, true);
    }
}
