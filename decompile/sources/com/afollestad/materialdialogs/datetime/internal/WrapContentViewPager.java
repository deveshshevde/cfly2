package com.afollestad.materialdialogs.datetime.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import ay.e;
import com.blankj.utilcode.constant.MemoryConstants;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.h;
import kotlin.l;
import mm.b;

public final class WrapContentViewPager extends ViewPager {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WrapContentViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.c(context, "context");
    }

    private final void a(b<? super View, l> bVar) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            h.a((Object) childAt, "child");
            bVar.invoke(childAt);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.f30236a = 0;
        a(new WrapContentViewPager$onMeasure$1(i2, intRef));
        int size = View.MeasureSpec.getSize(i3);
        if (intRef.f30236a > size) {
            intRef.f30236a = size;
        }
        e eVar = e.f5573a;
        int i4 = intRef.f30236a;
        if (i4 != 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(i4, MemoryConstants.GB);
        }
        super.onMeasure(i2, i3);
    }
}
