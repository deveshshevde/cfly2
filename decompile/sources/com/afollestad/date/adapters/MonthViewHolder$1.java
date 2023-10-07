package com.afollestad.date.adapters;

import android.view.View;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;
import mm.b;

final class MonthViewHolder$1 extends Lambda implements b<View, l> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f7356a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MonthViewHolder$1(d dVar) {
        super(1);
        this.f7356a = dVar;
    }

    public final void a(View view) {
        h.c(view, "it");
        this.f7356a.f7370b.a(this.f7356a.getAdapterPosition());
    }

    public /* synthetic */ Object invoke(Object obj) {
        a((View) obj);
        return l.f30254a;
    }
}
