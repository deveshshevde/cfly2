package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.b;
import com.google.android.material.R;
import gw.c;
import gw.h;
import gw.k;
import t.ac;

class RadialViewGroup extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f19923a;

    /* renamed from: b  reason: collision with root package name */
    private int f19924b;

    /* renamed from: c  reason: collision with root package name */
    private h f19925c;

    public RadialViewGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RadialViewGroup(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        LayoutInflater.from(context).inflate(R.layout.material_radial_view_group, this);
        ac.a((View) this, c());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RadialViewGroup, i2, 0);
        this.f19924b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RadialViewGroup_materialCircleRadius, 0);
        this.f19923a = new Runnable() {
            public void run() {
                RadialViewGroup.this.a();
            }
        };
        obtainStyledAttributes.recycle();
    }

    private static boolean b(View view) {
        return "skip".equals(view.getTag());
    }

    private Drawable c() {
        h hVar = new h();
        this.f19925c = hVar;
        hVar.a((c) new k(0.5f));
        this.f19925c.g(ColorStateList.valueOf(-1));
        return this.f19925c;
    }

    private void d() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.f19923a);
            handler.post(this.f19923a);
        }
    }

    /* access modifiers changed from: protected */
    public void a() {
        int childCount = getChildCount();
        int i2 = 1;
        for (int i3 = 0; i3 < childCount; i3++) {
            if (b(getChildAt(i3))) {
                i2++;
            }
        }
        b bVar = new b();
        bVar.b((ConstraintLayout) this);
        float f2 = 0.0f;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getId() != R.id.circle_center && !b(childAt)) {
                bVar.a(childAt.getId(), R.id.circle_center, this.f19924b, f2);
                f2 += 360.0f / ((float) (childCount - i2));
            }
        }
        bVar.c((ConstraintLayout) this);
    }

    public void a(int i2) {
        this.f19924b = i2;
        a();
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        if (view.getId() == -1) {
            view.setId(ac.a());
        }
        d();
    }

    public int b() {
        return this.f19924b;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        a();
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        d();
    }

    public void setBackgroundColor(int i2) {
        this.f19925c.g(ColorStateList.valueOf(i2));
    }
}
