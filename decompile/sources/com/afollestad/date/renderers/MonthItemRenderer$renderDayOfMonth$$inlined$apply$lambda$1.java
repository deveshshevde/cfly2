package com.afollestad.date.renderers;

import android.widget.TextView;
import com.afollestad.date.data.f;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;
import mm.b;

final class MonthItemRenderer$renderDayOfMonth$$inlined$apply$lambda$1 extends Lambda implements b<TextView, l> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f7473a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f7474b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ f.a f7475c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MonthItemRenderer$renderDayOfMonth$$inlined$apply$lambda$1(a aVar, b bVar, f.a aVar2) {
        super(1);
        this.f7473a = aVar;
        this.f7474b = bVar;
        this.f7475c = aVar2;
    }

    public final void a(TextView textView) {
        h.c(textView, "it");
        this.f7474b.invoke(this.f7475c);
    }

    public /* synthetic */ Object invoke(Object obj) {
        a((TextView) obj);
        return l.f30254a;
    }
}
