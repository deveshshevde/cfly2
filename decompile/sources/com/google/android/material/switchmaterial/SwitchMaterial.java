package com.google.android.material.switchmaterial;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.R;
import com.google.android.material.internal.s;
import gq.a;

public class SwitchMaterial extends SwitchCompat {

    /* renamed from: c  reason: collision with root package name */
    private static final int f19651c = R.style.Widget_MaterialComponents_CompoundButton_Switch;

    /* renamed from: d  reason: collision with root package name */
    private static final int[][] f19652d = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};

    /* renamed from: e  reason: collision with root package name */
    private final a f19653e;

    /* renamed from: f  reason: collision with root package name */
    private ColorStateList f19654f;

    /* renamed from: g  reason: collision with root package name */
    private ColorStateList f19655g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f19656h;

    public SwitchMaterial(Context context) {
        this(context, (AttributeSet) null);
    }

    public SwitchMaterial(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.switchStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SwitchMaterial(android.content.Context r7, android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = f19651c
            android.content.Context r7 = gx.a.a(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            android.content.Context r0 = r6.getContext()
            gq.a r7 = new gq.a
            r7.<init>(r0)
            r6.f19653e = r7
            int[] r2 = com.google.android.material.R.styleable.SwitchMaterial
            r7 = 0
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = com.google.android.material.internal.l.a(r0, r1, r2, r3, r4, r5)
            int r9 = com.google.android.material.R.styleable.SwitchMaterial_useMaterialThemeColors
            boolean r7 = r8.getBoolean(r9, r7)
            r6.f19656h = r7
            r8.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.switchmaterial.SwitchMaterial.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        if (this.f19654f == null) {
            int a2 = gn.a.a((View) this, R.attr.colorSurface);
            int a3 = gn.a.a((View) this, R.attr.colorControlActivated);
            float dimension = getResources().getDimension(R.dimen.mtrl_switch_thumb_elevation);
            if (this.f19653e.a()) {
                dimension += s.d(this);
            }
            int a4 = this.f19653e.a(a2, dimension);
            int[][] iArr = f19652d;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = gn.a.a(a2, a3, 1.0f);
            iArr2[1] = a4;
            iArr2[2] = gn.a.a(a2, a3, 0.38f);
            iArr2[3] = a4;
            this.f19654f = new ColorStateList(iArr, iArr2);
        }
        return this.f19654f;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.f19655g == null) {
            int[][] iArr = f19652d;
            int[] iArr2 = new int[iArr.length];
            int a2 = gn.a.a((View) this, R.attr.colorSurface);
            int a3 = gn.a.a((View) this, R.attr.colorControlActivated);
            int a4 = gn.a.a((View) this, R.attr.colorOnSurface);
            iArr2[0] = gn.a.a(a2, a3, 0.54f);
            iArr2[1] = gn.a.a(a2, a4, 0.32f);
            iArr2[2] = gn.a.a(a2, a3, 0.12f);
            iArr2[3] = gn.a.a(a2, a4, 0.12f);
            this.f19655g = new ColorStateList(iArr, iArr2);
        }
        return this.f19655g;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f19656h && getThumbTintList() == null) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
        }
        if (this.f19656h && getTrackTintList() == null) {
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        }
    }

    public void setUseMaterialThemeColors(boolean z2) {
        ColorStateList colorStateList;
        this.f19656h = z2;
        if (z2) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
            colorStateList = getMaterialThemeColorsTrackTintList();
        } else {
            colorStateList = null;
            setThumbTintList((ColorStateList) null);
        }
        setTrackTintList(colorStateList);
    }
}
