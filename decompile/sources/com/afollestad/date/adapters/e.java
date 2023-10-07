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
import com.afollestad.date.a;
import java.util.Calendar;
import kotlin.Pair;
import kotlin.jvm.internal.h;
import kotlin.l;
import mm.b;

public final class e extends RecyclerView.Adapter<f> {

    /* renamed from: a  reason: collision with root package name */
    private Integer f7371a;

    /* renamed from: b  reason: collision with root package name */
    private final Pair<Integer, Integer> f7372b;

    /* renamed from: c  reason: collision with root package name */
    private final Typeface f7373c;

    /* renamed from: d  reason: collision with root package name */
    private final Typeface f7374d;

    /* renamed from: e  reason: collision with root package name */
    private final int f7375e;

    /* renamed from: f  reason: collision with root package name */
    private final b<Integer, l> f7376f;

    public e(Typeface typeface, Typeface typeface2, int i2, b<? super Integer, l> bVar) {
        h.c(typeface, "normalFont");
        h.c(typeface2, "mediumFont");
        h.c(bVar, "onSelection");
        this.f7373c = typeface;
        this.f7374d = typeface2;
        this.f7375e = i2;
        this.f7376f = bVar;
        Calendar instance = Calendar.getInstance();
        h.a((Object) instance, "Calendar.getInstance()");
        int a2 = a.a(instance);
        this.f7372b = new Pair<>(Integer.valueOf(a2 - 100), Integer.valueOf(a2 + 100));
        setHasStableIds(true);
    }

    private final int b(int i2) {
        return (i2 - this.f7372b.a().intValue()) - 1;
    }

    private final int c(int i2) {
        return i2 + 1 + this.f7372b.a().intValue();
    }

    /* renamed from: a */
    public f onCreateViewHolder(ViewGroup viewGroup, int i2) {
        h.c(viewGroup, "parent");
        Context context = viewGroup.getContext();
        f fVar = new f(i.a(viewGroup, R.layout.year_list_row), this);
        TextView a2 = fVar.a();
        as.h hVar = as.h.f5572a;
        h.a((Object) context, "context");
        a2.setTextColor(hVar.a(context, this.f7375e, false));
        return fVar;
    }

    public final Integer a() {
        Integer num = this.f7371a;
        if (num != null) {
            return Integer.valueOf(b(num.intValue()));
        }
        return null;
    }

    public final void a(int i2) {
        Integer valueOf = Integer.valueOf(c(i2));
        this.f7376f.invoke(Integer.valueOf(valueOf.intValue()));
        a(valueOf);
    }

    /* renamed from: a */
    public void onBindViewHolder(f fVar, int i2) {
        h.c(fVar, "holder");
        int c2 = c(i2);
        Integer num = this.f7371a;
        boolean z2 = num != null && c2 == num.intValue();
        View view = fVar.itemView;
        h.a((Object) view, "holder.itemView");
        Context context = view.getContext();
        h.a((Object) context, "holder.itemView.context");
        Resources resources = context.getResources();
        fVar.a().setText(String.valueOf(c2));
        fVar.a().setSelected(z2);
        fVar.a().setTextSize(0, resources.getDimension(z2 ? R.dimen.year_month_list_text_size_selected : R.dimen.year_month_list_text_size));
        fVar.a().setTypeface(z2 ? this.f7374d : this.f7373c);
    }

    public final void a(Integer num) {
        Integer num2 = this.f7371a;
        this.f7371a = num;
        if (num2 != null) {
            notifyItemChanged(b(num2.intValue()));
        }
        if (num != null) {
            notifyItemChanged(b(num.intValue()));
        }
    }

    public int getItemCount() {
        return this.f7372b.b().intValue() - this.f7372b.a().intValue();
    }

    public long getItemId(int i2) {
        return (long) c(i2);
    }
}
