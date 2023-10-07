package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;
import t.ac;

class j extends RecyclerView.Adapter<a> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f19008a;

    /* renamed from: b  reason: collision with root package name */
    private final CalendarConstraints f19009b;

    /* renamed from: c  reason: collision with root package name */
    private final DateSelector<?> f19010c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final MaterialCalendar.a f19011d;

    /* renamed from: e  reason: collision with root package name */
    private final int f19012e;

    public static class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f19015a;

        /* renamed from: b  reason: collision with root package name */
        final MaterialCalendarGridView f19016b;

        a(LinearLayout linearLayout, boolean z2) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R.id.month_title);
            this.f19015a = textView;
            ac.c((View) textView, true);
            this.f19016b = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
            if (!z2) {
                textView.setVisibility(8);
            }
        }
    }

    j(Context context, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints, MaterialCalendar.a aVar) {
        Month b2 = calendarConstraints.b();
        Month c2 = calendarConstraints.c();
        Month d2 = calendarConstraints.d();
        if (b2.compareTo(d2) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        } else if (d2.compareTo(c2) <= 0) {
            int a2 = i.f19002a * MaterialCalendar.a(context);
            int a3 = f.a(context) ? MaterialCalendar.a(context) : 0;
            this.f19008a = context;
            this.f19012e = a2 + a3;
            this.f19009b = calendarConstraints;
            this.f19010c = dateSelector;
            this.f19011d = aVar;
            setHasStableIds(true);
        } else {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
    }

    /* access modifiers changed from: package-private */
    public int a(Month month) {
        return this.f19009b.b().b(month);
    }

    /* renamed from: a */
    public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!f.a(viewGroup.getContext())) {
            return new a(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.f19012e));
        return new a(linearLayout, true);
    }

    /* access modifiers changed from: package-private */
    public CharSequence a(int i2) {
        return b(i2).a(this.f19008a);
    }

    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i2) {
        Month b2 = this.f19009b.b().b(i2);
        aVar.f19015a.setText(b2.a(aVar.itemView.getContext()));
        final MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) aVar.f19016b.findViewById(R.id.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !b2.equals(materialCalendarGridView.getAdapter().f19003b)) {
            i iVar = new i(b2, this.f19010c, this.f19009b);
            materialCalendarGridView.setNumColumns(b2.f18924c);
            materialCalendarGridView.setAdapter((ListAdapter) iVar);
        } else {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter().a(materialCalendarGridView);
        }
        materialCalendarGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                if (materialCalendarGridView.getAdapter().d(i2)) {
                    j.this.f19011d.a(materialCalendarGridView.getAdapter().getItem(i2).longValue());
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public Month b(int i2) {
        return this.f19009b.b().b(i2);
    }

    public int getItemCount() {
        return this.f19009b.e();
    }

    public long getItemId(int i2) {
        return this.f19009b.b().b(i2).c();
    }
}
