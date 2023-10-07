package com.afollestad.date.managers;

import android.widget.TextView;
import com.afollestad.date.managers.DatePickerLayoutManager;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;
import mm.b;

final class DatePickerLayoutManager$setupHeaderViews$$inlined$apply$lambda$2 extends Lambda implements b<TextView, l> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DatePickerLayoutManager f7454a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerLayoutManager$setupHeaderViews$$inlined$apply$lambda$2(DatePickerLayoutManager datePickerLayoutManager) {
        super(1);
        this.f7454a = datePickerLayoutManager;
    }

    public final void a(TextView textView) {
        h.c(textView, "it");
        this.f7454a.a(DatePickerLayoutManager.Mode.CALENDAR);
    }

    public /* synthetic */ Object invoke(Object obj) {
        a((TextView) obj);
        return l.f30254a;
    }
}
