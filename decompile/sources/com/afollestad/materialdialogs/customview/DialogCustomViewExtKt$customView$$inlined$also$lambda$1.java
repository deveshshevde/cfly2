package com.afollestad.materialdialogs.customview;

import android.view.View;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;
import mm.b;

final class DialogCustomViewExtKt$customView$$inlined$also$lambda$1 extends Lambda implements b<View, l> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.afollestad.materialdialogs.b f7556a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f7557b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DialogCustomViewExtKt$customView$$inlined$also$lambda$1(com.afollestad.materialdialogs.b bVar, boolean z2) {
        super(1);
        this.f7556a = bVar;
        this.f7557b = z2;
    }

    public final void a(View view) {
        h.c(view, "$receiver");
        com.afollestad.materialdialogs.b.a(this.f7556a, (Integer) null, Integer.valueOf(view.getMeasuredWidth()), 1, (Object) null);
    }

    public /* synthetic */ Object invoke(Object obj) {
        a((View) obj);
        return l.f30254a;
    }
}
