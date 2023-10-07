package com.afollestad.date.adapters;

import android.view.View;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;
import mm.b;

final class YearViewHolder$1 extends Lambda implements b<View, l> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f7357a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    YearViewHolder$1(f fVar) {
        super(1);
        this.f7357a = fVar;
    }

    public final void a(View view) {
        h.c(view, "it");
        this.f7357a.f7378b.a(this.f7357a.getAdapterPosition());
    }

    public /* synthetic */ Object invoke(Object obj) {
        a((View) obj);
        return l.f30254a;
    }
}
