package com.afollestad.date.adapters;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import as.i;
import com.afollestad.date.R;
import com.afollestad.date.data.f;
import com.afollestad.date.renderers.a;
import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.l;

public final class b extends RecyclerView.Adapter<c> {

    /* renamed from: a  reason: collision with root package name */
    private List<? extends f> f7365a;

    /* renamed from: b  reason: collision with root package name */
    private final a f7366b;

    /* renamed from: c  reason: collision with root package name */
    private final mm.b<f.a, l> f7367c;

    public b(a aVar, mm.b<? super f.a, l> bVar) {
        h.c(aVar, "itemRenderer");
        h.c(bVar, "onSelection");
        this.f7366b = aVar;
        this.f7367c = bVar;
        setHasStableIds(true);
    }

    /* renamed from: a */
    public c onCreateViewHolder(ViewGroup viewGroup, int i2) {
        h.c(viewGroup, "parent");
        return new c(i.a(viewGroup, i2));
    }

    /* renamed from: a */
    public void onBindViewHolder(c cVar, int i2) {
        f fVar;
        h.c(cVar, "holder");
        List<? extends f> list = this.f7365a;
        if (list == null || (fVar = (f) list.get(i2)) == null) {
            throw new IllegalStateException("Impossible!".toString());
        }
        a aVar = this.f7366b;
        View view = cVar.itemView;
        h.a((Object) view, "holder.itemView");
        aVar.a(fVar, view, cVar.a(), (mm.b<? super f.a, l>) this.f7367c);
    }

    public final void a(List<? extends f> list) {
        List<? extends f> list2 = this.f7365a;
        this.f7365a = list;
        com.afollestad.date.data.b.a(list2, list, this);
    }

    public int getItemCount() {
        List<? extends f> list = this.f7365a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public long getItemId(int i2) {
        return (long) i2;
    }

    public int getItemViewType(int i2) {
        List<? extends f> list = this.f7365a;
        return (list != null ? (f) list.get(i2) : null) instanceof f.b ? R.layout.month_grid_header : R.layout.month_grid_item;
    }
}
