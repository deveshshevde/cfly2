package com.afollestad.materialdialogs.datetime.internal;

import android.view.View;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.h;
import kotlin.l;
import mm.b;

final class WrapContentViewPager$onMeasure$1 extends Lambda implements b<View, l> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f7564a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Ref.IntRef f7565b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WrapContentViewPager$onMeasure$1(int i2, Ref.IntRef intRef) {
        super(1);
        this.f7564a = i2;
        this.f7565b = intRef;
    }

    public final void a(View view) {
        h.c(view, "child");
        view.measure(this.f7564a, View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredHeight = view.getMeasuredHeight();
        if (measuredHeight > this.f7565b.f30236a) {
            this.f7565b.f30236a = measuredHeight;
        }
    }

    public /* synthetic */ Object invoke(Object obj) {
        a((View) obj);
        return l.f30254a;
    }
}
