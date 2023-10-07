package com.afollestad.materialdialogs;

import android.content.Context;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import mm.a;

final class MaterialDialog$invalidateBackgroundColorAndRadius$1 extends Lambda implements a<Float> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f7490a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MaterialDialog$invalidateBackgroundColorAndRadius$1(b bVar) {
        super(0);
        this.f7490a = bVar;
    }

    public final float b() {
        Context context = this.f7490a.getContext();
        h.a((Object) context, "context");
        return context.getResources().getDimension(R.dimen.md_dialog_default_corner_radius);
    }

    public /* synthetic */ Object e_() {
        return Float.valueOf(b());
    }
}
