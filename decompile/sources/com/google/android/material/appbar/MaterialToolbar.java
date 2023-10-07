package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.a;
import com.blankj.utilcode.constant.MemoryConstants;
import com.google.android.material.R;
import com.google.android.material.internal.m;
import gw.h;
import gw.i;
import t.ac;

public class MaterialToolbar extends Toolbar {

    /* renamed from: e  reason: collision with root package name */
    private static final int f18474e = R.style.Widget_MaterialComponents_Toolbar;

    /* renamed from: f  reason: collision with root package name */
    private Integer f18475f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f18476g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f18477h;

    public MaterialToolbar(Context context) {
        this(context, (AttributeSet) null);
    }

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialToolbar(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = f18474e
            android.content.Context r8 = gx.a.a(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            android.content.Context r8 = r7.getContext()
            int[] r2 = com.google.android.material.R.styleable.MaterialToolbar
            r6 = 0
            int[] r5 = new int[r6]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.l.a(r0, r1, r2, r3, r4, r5)
            int r10 = com.google.android.material.R.styleable.MaterialToolbar_navigationIconTint
            boolean r10 = r9.hasValue(r10)
            if (r10 == 0) goto L_0x002b
            int r10 = com.google.android.material.R.styleable.MaterialToolbar_navigationIconTint
            r0 = -1
            int r10 = r9.getColor(r10, r0)
            r7.setNavigationIconTint(r10)
        L_0x002b:
            int r10 = com.google.android.material.R.styleable.MaterialToolbar_titleCentered
            boolean r10 = r9.getBoolean(r10, r6)
            r7.f18476g = r10
            int r10 = com.google.android.material.R.styleable.MaterialToolbar_subtitleCentered
            boolean r10 = r9.getBoolean(r10, r6)
            r7.f18477h = r10
            r9.recycle()
            r7.a((android.content.Context) r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.MaterialToolbar.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private Drawable a(Drawable drawable) {
        if (drawable == null || this.f18475f == null) {
            return drawable;
        }
        Drawable g2 = a.g(drawable);
        a.a(g2, this.f18475f.intValue());
        return g2;
    }

    private Pair<Integer, Integer> a(TextView textView, TextView textView2) {
        int measuredWidth = getMeasuredWidth();
        int i2 = measuredWidth / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = measuredWidth - getPaddingRight();
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (!(childAt.getVisibility() == 8 || childAt == textView || childAt == textView2)) {
                if (childAt.getRight() < i2 && childAt.getRight() > paddingLeft) {
                    paddingLeft = childAt.getRight();
                }
                if (childAt.getLeft() > i2 && childAt.getLeft() < paddingRight) {
                    paddingRight = childAt.getLeft();
                }
            }
        }
        return new Pair<>(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
    }

    private void a(Context context) {
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            h hVar = new h();
            hVar.g(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : 0));
            hVar.a(context);
            hVar.r(ac.s(this));
            ac.a((View) this, (Drawable) hVar);
        }
    }

    private void a(View view, Pair<Integer, Integer> pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = view.getMeasuredWidth();
        int i2 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i3 = measuredWidth2 + i2;
        int max = Math.max(Math.max(((Integer) pair.first).intValue() - i2, 0), Math.max(i3 - ((Integer) pair.second).intValue(), 0));
        if (max > 0) {
            i2 += max;
            i3 -= max;
            view.measure(View.MeasureSpec.makeMeasureSpec(i3 - i2, MemoryConstants.GB), view.getMeasuredHeightAndState());
        }
        view.layout(i2, view.getTop(), i3, view.getBottom());
    }

    private void m() {
        if (this.f18476g || this.f18477h) {
            TextView a2 = m.a(this);
            TextView b2 = m.b(this);
            if (a2 != null || b2 != null) {
                Pair<Integer, Integer> a3 = a(a2, b2);
                if (this.f18476g && a2 != null) {
                    a((View) a2, a3);
                }
                if (this.f18477h && b2 != null) {
                    a((View) b2, a3);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.a((View) this);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        m();
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        i.a((View) this, f2);
    }

    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(a(drawable));
    }

    public void setNavigationIconTint(int i2) {
        this.f18475f = Integer.valueOf(i2);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z2) {
        if (this.f18477h != z2) {
            this.f18477h = z2;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z2) {
        if (this.f18476g != z2) {
            this.f18476g = z2;
            requestLayout();
        }
    }
}
