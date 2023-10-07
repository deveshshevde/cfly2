package com.afollestad.date.adapters;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import as.e;
import kotlin.jvm.internal.h;

public final class d extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f7369a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final a f7370b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(View view, a aVar) {
        super(view);
        h.c(view, "itemView");
        h.c(aVar, "adapter");
        this.f7370b = aVar;
        this.f7369a = (TextView) view;
        e.a(view, new MonthViewHolder$1(this));
    }

    public final TextView a() {
        return this.f7369a;
    }
}
