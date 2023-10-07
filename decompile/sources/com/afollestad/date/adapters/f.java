package com.afollestad.date.adapters;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import as.e;
import kotlin.jvm.internal.h;

public final class f extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f7377a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final e f7378b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(View view, e eVar) {
        super(view);
        h.c(view, "itemView");
        h.c(eVar, "adapter");
        this.f7378b = eVar;
        this.f7377a = (TextView) view;
        e.a(view, new YearViewHolder$1(this));
    }

    public final TextView a() {
        return this.f7377a;
    }
}
