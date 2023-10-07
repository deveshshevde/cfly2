package com.afollestad.date.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import as.i;
import com.afollestad.date.R;
import java.util.Calendar;
import kotlin.jvm.internal.h;
import kotlin.l;
import mm.b;

public final class a extends RecyclerView.Adapter<d> {

    /* renamed from: a  reason: collision with root package name */
    private Integer f7358a;

    /* renamed from: b  reason: collision with root package name */
    private final Calendar f7359b = Calendar.getInstance();

    /* renamed from: c  reason: collision with root package name */
    private final int f7360c;

    /* renamed from: d  reason: collision with root package name */
    private final Typeface f7361d;

    /* renamed from: e  reason: collision with root package name */
    private final Typeface f7362e;

    /* renamed from: f  reason: collision with root package name */
    private final com.afollestad.date.data.a f7363f;

    /* renamed from: g  reason: collision with root package name */
    private final b<Integer, l> f7364g;

    public a(int i2, Typeface typeface, Typeface typeface2, com.afollestad.date.data.a aVar, b<? super Integer, l> bVar) {
        h.c(typeface, "normalFont");
        h.c(typeface2, "mediumFont");
        h.c(aVar, "dateFormatter");
        h.c(bVar, "onSelection");
        this.f7360c = i2;
        this.f7361d = typeface;
        this.f7362e = typeface2;
        this.f7363f = aVar;
        this.f7364g = bVar;
        setHasStableIds(true);
    }

    private final String b(int i2) {
        Calendar calendar = this.f7359b;
        h.a((Object) calendar, "calendar");
        com.afollestad.date.a.b(calendar, i2);
        com.afollestad.date.data.a aVar = this.f7363f;
        Calendar calendar2 = this.f7359b;
        h.a((Object) calendar2, "calendar");
        return aVar.d(calendar2);
    }

    /* renamed from: a */
    public d onCreateViewHolder(ViewGroup viewGroup, int i2) {
        h.c(viewGroup, "parent");
        Context context = viewGroup.getContext();
        d dVar = new d(i.a(viewGroup, R.layout.year_list_row), this);
        TextView a2 = dVar.a();
        as.h hVar = as.h.f5572a;
        h.a((Object) context, "context");
        a2.setTextColor(hVar.a(context, this.f7360c, false));
        return dVar;
    }

    public final Integer a() {
        return this.f7358a;
    }

    public final void a(int i2) {
        Integer valueOf = Integer.valueOf(i2);
        this.f7364g.invoke(Integer.valueOf(valueOf.intValue()));
        a(valueOf);
    }

    /* renamed from: a */
    public void onBindViewHolder(d dVar, int i2) {
        h.c(dVar, "holder");
        Integer num = this.f7358a;
        boolean z2 = num != null && i2 == num.intValue();
        View view = dVar.itemView;
        h.a((Object) view, "holder.itemView");
        Context context = view.getContext();
        h.a((Object) context, "holder.itemView.context");
        Resources resources = context.getResources();
        dVar.a().setText(b(i2));
        dVar.a().setSelected(z2);
        dVar.a().setTextSize(0, resources.getDimension(z2 ? R.dimen.year_month_list_text_size_selected : R.dimen.year_month_list_text_size));
        dVar.a().setTypeface(z2 ? this.f7362e : this.f7361d);
    }

    public final void a(Integer num) {
        Integer num2 = this.f7358a;
        this.f7358a = num;
        if (num2 != null) {
            notifyItemChanged(num2.intValue());
        }
        if (num != null) {
            notifyItemChanged(num.intValue());
        }
    }

    public int getItemCount() {
        return this.f7359b.getActualMaximum(2) + 1;
    }

    public long getItemId(int i2) {
        return (long) i2;
    }
}
