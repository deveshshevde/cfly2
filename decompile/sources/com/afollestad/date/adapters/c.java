package com.afollestad.date.adapters;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.date.R;
import kotlin.jvm.internal.h;

public final class c extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f7368a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(View view) {
        super(view);
        h.c(view, "itemView");
        View findViewById = view.findViewById(R.id.textView);
        h.a((Object) findViewById, "itemView.findViewById(R.id.textView)");
        this.f7368a = (TextView) findViewById;
    }

    public final TextView a() {
        return this.f7368a;
    }
}
