package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.R;
import gt.c;
import gw.h;
import gw.m;
import s.f;
import t.ac;

final class a {

    /* renamed from: a  reason: collision with root package name */
    private final Rect f18946a;

    /* renamed from: b  reason: collision with root package name */
    private final ColorStateList f18947b;

    /* renamed from: c  reason: collision with root package name */
    private final ColorStateList f18948c;

    /* renamed from: d  reason: collision with root package name */
    private final ColorStateList f18949d;

    /* renamed from: e  reason: collision with root package name */
    private final int f18950e;

    /* renamed from: f  reason: collision with root package name */
    private final m f18951f;

    private a(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i2, m mVar, Rect rect) {
        f.a(rect.left);
        f.a(rect.top);
        f.a(rect.right);
        f.a(rect.bottom);
        this.f18946a = rect;
        this.f18947b = colorStateList2;
        this.f18948c = colorStateList;
        this.f18949d = colorStateList3;
        this.f18950e = i2;
        this.f18951f = mVar;
    }

    static a a(Context context, int i2) {
        f.a(i2 != 0, (Object) "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, R.styleable.MaterialCalendarItem);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetLeft, 0), obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetTop, 0), obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetRight, 0), obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList a2 = c.a(context, obtainStyledAttributes, R.styleable.MaterialCalendarItem_itemFillColor);
        ColorStateList a3 = c.a(context, obtainStyledAttributes, R.styleable.MaterialCalendarItem_itemTextColor);
        ColorStateList a4 = c.a(context, obtainStyledAttributes, R.styleable.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialCalendarItem_itemStrokeWidth, 0);
        m a5 = m.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearance, 0), obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).a();
        obtainStyledAttributes.recycle();
        return new a(a2, a3, a4, dimensionPixelSize, a5, rect);
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.f18946a.top;
    }

    /* access modifiers changed from: package-private */
    public void a(TextView textView) {
        h hVar = new h();
        h hVar2 = new h();
        hVar.setShapeAppearanceModel(this.f18951f);
        hVar2.setShapeAppearanceModel(this.f18951f);
        hVar.g(this.f18948c);
        hVar.a((float) this.f18950e, this.f18949d);
        textView.setTextColor(this.f18947b);
        ac.a((View) textView, (Drawable) new InsetDrawable(Build.VERSION.SDK_INT >= 21 ? new RippleDrawable(this.f18947b.withAlpha(30), hVar, hVar2) : hVar, this.f18946a.left, this.f18946a.top, this.f18946a.right, this.f18946a.bottom));
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f18946a.bottom;
    }
}
