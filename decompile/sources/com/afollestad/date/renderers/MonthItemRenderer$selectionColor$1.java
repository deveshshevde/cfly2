package com.afollestad.date.renderers;

import as.c;
import com.afollestad.date.R;
import kotlin.jvm.internal.Lambda;
import mm.a;

final class MonthItemRenderer$selectionColor$1 extends Lambda implements a<Integer> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f7477a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MonthItemRenderer$selectionColor$1(a aVar) {
        super(0);
        this.f7477a = aVar;
    }

    public final int b() {
        return c.a(this.f7477a.f7481d, R.attr.colorAccent, (a) null, 2, (Object) null);
    }

    public /* synthetic */ Object e_() {
        return Integer.valueOf(b());
    }
}
