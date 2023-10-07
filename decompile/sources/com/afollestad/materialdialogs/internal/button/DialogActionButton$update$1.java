package com.afollestad.materialdialogs.internal.button;

import android.content.Context;
import ay.e;
import com.afollestad.materialdialogs.R;
import kotlin.jvm.internal.Lambda;
import mm.a;

final class DialogActionButton$update$1 extends Lambda implements a<Integer> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f7574a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DialogActionButton$update$1(Context context) {
        super(0);
        this.f7574a = context;
    }

    public final int b() {
        return e.a(e.f5573a, this.f7574a, (Integer) null, Integer.valueOf(R.attr.colorPrimary), (a) null, 10, (Object) null);
    }

    public /* synthetic */ Object e_() {
        return Integer.valueOf(b());
    }
}
