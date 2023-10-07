package com.afollestad.date.data;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import java.util.List;
import kotlin.jvm.internal.h;

public final class b {
    public static final void a(List<? extends f> list, List<? extends f> list2, RecyclerView.Adapter<?> adapter) {
        h.c(adapter, "adapter");
        if (list == null || list2 == null) {
            adapter.notifyDataSetChanged();
            return;
        }
        g.d a2 = g.a(new g(list, list2));
        h.a((Object) a2, "DiffUtil.calculateDiff(\n…thNewDays\n        )\n    )");
        a2.a((RecyclerView.Adapter) adapter);
    }
}
