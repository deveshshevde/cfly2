package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;
import java.util.Calendar;
import java.util.Locale;

class p extends RecyclerView.Adapter<a> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final MaterialCalendar<?> f19023a;

    public static class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f19026a;

        a(TextView textView) {
            super(textView);
            this.f19026a = textView;
        }
    }

    p(MaterialCalendar<?> materialCalendar) {
        this.f19023a = materialCalendar;
    }

    private View.OnClickListener c(final int i2) {
        return new View.OnClickListener() {
            public void onClick(View view) {
                p.this.f19023a.a(p.this.f19023a.b().a(Month.a(i2, p.this.f19023a.a().f18922a)));
                p.this.f19023a.a(MaterialCalendar.CalendarSelector.DAY);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public int a(int i2) {
        return i2 - this.f19023a.b().b().f18923b;
    }

    /* renamed from: a */
    public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, viewGroup, false));
    }

    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i2) {
        int b2 = b(i2);
        String string = aVar.f19026a.getContext().getString(R.string.mtrl_picker_navigate_to_year_description);
        aVar.f19026a.setText(String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf(b2)}));
        aVar.f19026a.setContentDescription(String.format(string, new Object[]{Integer.valueOf(b2)}));
        b d2 = this.f19023a.d();
        Calendar b3 = o.b();
        a aVar2 = b3.get(1) == b2 ? d2.f18957f : d2.f18955d;
        for (Long longValue : this.f19023a.c().c()) {
            b3.setTimeInMillis(longValue.longValue());
            if (b3.get(1) == b2) {
                aVar2 = d2.f18956e;
            }
        }
        aVar2.a(aVar.f19026a);
        aVar.f19026a.setOnClickListener(c(b2));
    }

    /* access modifiers changed from: package-private */
    public int b(int i2) {
        return this.f19023a.b().b().f18923b + i2;
    }

    public int getItemCount() {
        return this.f19023a.b().f();
    }
}
