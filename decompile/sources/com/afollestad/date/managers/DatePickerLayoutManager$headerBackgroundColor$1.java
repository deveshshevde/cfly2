package com.afollestad.date.managers;

import android.content.Context;
import as.c;
import com.afollestad.date.R;
import kotlin.jvm.internal.Lambda;
import mm.a;

final class DatePickerLayoutManager$headerBackgroundColor$1 extends Lambda implements a<Integer> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f7466a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerLayoutManager$headerBackgroundColor$1(Context context) {
        super(0);
        this.f7466a = context;
    }

    public final int b() {
        return c.a(this.f7466a, R.attr.colorAccent, (a) null, 2, (Object) null);
    }

    public /* synthetic */ Object e_() {
        return Integer.valueOf(b());
    }
}
