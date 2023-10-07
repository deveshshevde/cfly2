package com.afollestad.materialdialogs.customview;

import android.view.View;
import ay.e;
import com.afollestad.materialdialogs.b;
import kotlin.jvm.internal.h;

public final class a {
    public static final View a(b bVar) {
        h.c(bVar, "$this$getCustomView");
        View customView = bVar.b().getContentLayout().getCustomView();
        if (customView != null) {
            return customView;
        }
        throw new IllegalStateException("You have not setup this dialog as a customView dialog.".toString());
    }

    public static final b a(b bVar, Integer num, View view, boolean z2, boolean z3, boolean z4, boolean z5) {
        h.c(bVar, "$this$customView");
        e.f5573a.a("customView", (Object) view, num);
        bVar.a().put("md.custom_view_no_vertical_padding", Boolean.valueOf(z3));
        if (z5) {
            b.a(bVar, (Integer) null, (Integer) 0, 1, (Object) null);
        }
        View a2 = bVar.b().getContentLayout().a(num, view, z2, z3, z4);
        if (z5) {
            e.f5573a.a(a2, new DialogCustomViewExtKt$customView$$inlined$also$lambda$1(bVar, z5));
        }
        return bVar;
    }

    public static /* synthetic */ b a(b bVar, Integer num, View view, boolean z2, boolean z3, boolean z4, boolean z5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = null;
        }
        if ((i2 & 2) != 0) {
            view = null;
        }
        View view2 = view;
        boolean z6 = false;
        boolean z7 = (i2 & 4) != 0 ? false : z2;
        boolean z8 = (i2 & 8) != 0 ? false : z3;
        boolean z9 = (i2 & 16) != 0 ? false : z4;
        if ((i2 & 32) == 0) {
            z6 = z5;
        }
        return a(bVar, num, view2, z7, z8, z9, z6);
    }
}
