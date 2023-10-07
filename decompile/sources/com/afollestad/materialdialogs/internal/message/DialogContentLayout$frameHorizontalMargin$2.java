package com.afollestad.materialdialogs.internal.message;

import com.afollestad.materialdialogs.R;
import kotlin.jvm.internal.Lambda;
import mm.a;

final class DialogContentLayout$frameHorizontalMargin$2 extends Lambda implements a<Integer> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DialogContentLayout f7625a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DialogContentLayout$frameHorizontalMargin$2(DialogContentLayout dialogContentLayout) {
        super(0);
        this.f7625a = dialogContentLayout;
    }

    public final int b() {
        return this.f7625a.getResources().getDimensionPixelSize(R.dimen.md_dialog_frame_margin_horizontal);
    }

    public /* synthetic */ Object e_() {
        return Integer.valueOf(b());
    }
}
