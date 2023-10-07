package com.google.android.material.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.widget.c;
import com.google.android.material.R;
import gn.a;

public class MaterialCheckBox extends AppCompatCheckBox {

    /* renamed from: a  reason: collision with root package name */
    private static final int f18764a = R.style.Widget_MaterialComponents_CompoundButton_CheckBox;

    /* renamed from: b  reason: collision with root package name */
    private static final int[][] f18765b = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};

    /* renamed from: c  reason: collision with root package name */
    private ColorStateList f18766c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f18767d;

    public MaterialCheckBox(Context context) {
        this(context, (AttributeSet) null);
    }

    public MaterialCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkboxStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialCheckBox(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = f18764a
            android.content.Context r8 = gx.a.a(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            android.content.Context r8 = r7.getContext()
            int[] r2 = com.google.android.material.R.styleable.MaterialCheckBox
            r6 = 0
            int[] r5 = new int[r6]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.l.a(r0, r1, r2, r3, r4, r5)
            int r10 = com.google.android.material.R.styleable.MaterialCheckBox_buttonTint
            boolean r10 = r9.hasValue(r10)
            if (r10 == 0) goto L_0x002a
            int r10 = com.google.android.material.R.styleable.MaterialCheckBox_buttonTint
            android.content.res.ColorStateList r8 = gt.c.a((android.content.Context) r8, (android.content.res.TypedArray) r9, (int) r10)
            androidx.core.widget.c.a((android.widget.CompoundButton) r7, (android.content.res.ColorStateList) r8)
        L_0x002a:
            int r8 = com.google.android.material.R.styleable.MaterialCheckBox_useMaterialThemeColors
            boolean r8 = r9.getBoolean(r8, r6)
            r7.f18767d = r8
            r9.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.checkbox.MaterialCheckBox.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f18766c == null) {
            int[][] iArr = f18765b;
            int[] iArr2 = new int[iArr.length];
            int a2 = a.a((View) this, R.attr.colorControlActivated);
            int a3 = a.a((View) this, R.attr.colorSurface);
            int a4 = a.a((View) this, R.attr.colorOnSurface);
            iArr2[0] = a.a(a3, a2, 1.0f);
            iArr2[1] = a.a(a3, a4, 0.54f);
            iArr2[2] = a.a(a3, a4, 0.38f);
            iArr2[3] = a.a(a3, a4, 0.38f);
            this.f18766c = new ColorStateList(iArr, iArr2);
        }
        return this.f18766c;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f18767d && c.a(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z2) {
        this.f18767d = z2;
        c.a((CompoundButton) this, z2 ? getMaterialThemeColorsTintList() : null);
    }
}
