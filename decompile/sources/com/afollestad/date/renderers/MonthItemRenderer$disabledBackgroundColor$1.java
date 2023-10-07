package com.afollestad.date.renderers;

import as.b;
import as.c;
import com.afollestad.date.renderers.a;
import kotlin.jvm.internal.Lambda;
import mm.a;

final class MonthItemRenderer$disabledBackgroundColor$1 extends Lambda implements a<Integer> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f7476a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MonthItemRenderer$disabledBackgroundColor$1(a aVar) {
        super(0);
        this.f7476a = aVar;
    }

    public final int b() {
        int a2 = c.a(this.f7476a.f7481d, 16842808, (a) null, 2, (Object) null);
        a.C0071a unused = a.f7478a;
        return b.a(a2, 0.3f);
    }

    public /* synthetic */ Object e_() {
        return Integer.valueOf(b());
    }
}
