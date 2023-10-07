package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import com.google.android.material.R;
import gt.c;

final class b {

    /* renamed from: a  reason: collision with root package name */
    final a f18952a;

    /* renamed from: b  reason: collision with root package name */
    final a f18953b;

    /* renamed from: c  reason: collision with root package name */
    final a f18954c;

    /* renamed from: d  reason: collision with root package name */
    final a f18955d;

    /* renamed from: e  reason: collision with root package name */
    final a f18956e;

    /* renamed from: f  reason: collision with root package name */
    final a f18957f;

    /* renamed from: g  reason: collision with root package name */
    final a f18958g;

    /* renamed from: h  reason: collision with root package name */
    final Paint f18959h;

    b(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(gt.b.a(context, R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), R.styleable.MaterialCalendar);
        this.f18952a = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayStyle, 0));
        this.f18958g = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayInvalidStyle, 0));
        this.f18953b = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_daySelectedStyle, 0));
        this.f18954c = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList a2 = c.a(context, obtainStyledAttributes, R.styleable.MaterialCalendar_rangeFillColor);
        this.f18955d = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearStyle, 0));
        this.f18956e = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearSelectedStyle, 0));
        this.f18957f = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearTodayStyle, 0));
        Paint paint = new Paint();
        this.f18959h = paint;
        paint.setColor(a2.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
