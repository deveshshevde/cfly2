package com.google.android.material.datepicker;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Collection;

class i extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    static final int f19002a = o.c().getMaximum(4);

    /* renamed from: b  reason: collision with root package name */
    final Month f19003b;

    /* renamed from: c  reason: collision with root package name */
    final DateSelector<?> f19004c;

    /* renamed from: d  reason: collision with root package name */
    b f19005d;

    /* renamed from: e  reason: collision with root package name */
    final CalendarConstraints f19006e;

    /* renamed from: f  reason: collision with root package name */
    private Collection<Long> f19007f;

    i(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints) {
        this.f19003b = month;
        this.f19004c = dateSelector;
        this.f19006e = calendarConstraints;
        this.f19007f = dateSelector.c();
    }

    private void a(Context context) {
        if (this.f19005d == null) {
            this.f19005d = new b(context);
        }
    }

    private void a(TextView textView, long j2) {
        a aVar;
        if (textView != null) {
            if (this.f19006e.a().a(j2)) {
                textView.setEnabled(true);
                if (a(j2)) {
                    aVar = this.f19005d.f18953b;
                } else {
                    int i2 = (o.b().getTimeInMillis() > j2 ? 1 : (o.b().getTimeInMillis() == j2 ? 0 : -1));
                    b bVar = this.f19005d;
                    aVar = i2 == 0 ? bVar.f18954c : bVar.f18952a;
                }
            } else {
                textView.setEnabled(false);
                aVar = this.f19005d.f18958g;
            }
            aVar.a(textView);
        }
    }

    private void a(MaterialCalendarGridView materialCalendarGridView, long j2) {
        if (Month.a(j2).equals(this.f19003b)) {
            a((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().c(this.f19003b.b(j2)) - materialCalendarGridView.getFirstVisiblePosition()), j2);
        }
    }

    private boolean a(long j2) {
        for (Long longValue : this.f19004c.c()) {
            if (o.a(j2) == o.a(longValue.longValue())) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.f19003b.b();
    }

    /* JADX WARNING: type inference failed for: r7v12, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.widget.TextView getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            android.content.Context r0 = r8.getContext()
            r5.a((android.content.Context) r0)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L_0x001e
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r0 = com.google.android.material.R.layout.mtrl_calendar_day
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x001e:
            int r7 = r5.a()
            int r7 = r6 - r7
            if (r7 < 0) goto L_0x0074
            com.google.android.material.datepicker.Month r8 = r5.f19003b
            int r8 = r8.f18925d
            if (r7 < r8) goto L_0x002d
            goto L_0x0074
        L_0x002d:
            r8 = 1
            int r7 = r7 + r8
            com.google.android.material.datepicker.Month r2 = r5.f19003b
            r0.setTag(r2)
            android.content.res.Resources r2 = r0.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
            java.util.Locale r2 = r2.locale
            java.lang.Object[] r3 = new java.lang.Object[r8]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
            r3[r1] = r4
            java.lang.String r4 = "%d"
            java.lang.String r2 = java.lang.String.format(r2, r4, r3)
            r0.setText(r2)
            com.google.android.material.datepicker.Month r2 = r5.f19003b
            long r2 = r2.a((int) r7)
            com.google.android.material.datepicker.Month r7 = r5.f19003b
            int r7 = r7.f18923b
            com.google.android.material.datepicker.Month r4 = com.google.android.material.datepicker.Month.a()
            int r4 = r4.f18923b
            if (r7 != r4) goto L_0x0066
            java.lang.String r7 = com.google.android.material.datepicker.d.c(r2)
            goto L_0x006a
        L_0x0066:
            java.lang.String r7 = com.google.android.material.datepicker.d.d(r2)
        L_0x006a:
            r0.setContentDescription(r7)
            r0.setVisibility(r1)
            r0.setEnabled(r8)
            goto L_0x007c
        L_0x0074:
            r7 = 8
            r0.setVisibility(r7)
            r0.setEnabled(r1)
        L_0x007c:
            java.lang.Long r6 = r5.getItem((int) r6)
            if (r6 != 0) goto L_0x0083
            return r0
        L_0x0083:
            long r6 = r6.longValue()
            r5.a((android.widget.TextView) r0, (long) r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.i.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }

    /* renamed from: a */
    public Long getItem(int i2) {
        if (i2 < this.f19003b.b() || i2 > b()) {
            return null;
        }
        return Long.valueOf(this.f19003b.a(b(i2)));
    }

    public void a(MaterialCalendarGridView materialCalendarGridView) {
        for (Long longValue : this.f19007f) {
            a(materialCalendarGridView, longValue.longValue());
        }
        DateSelector<?> dateSelector = this.f19004c;
        if (dateSelector != null) {
            for (Long longValue2 : dateSelector.c()) {
                a(materialCalendarGridView, longValue2.longValue());
            }
            this.f19007f = this.f19004c.c();
        }
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return (this.f19003b.b() + this.f19003b.f18925d) - 1;
    }

    /* access modifiers changed from: package-private */
    public int b(int i2) {
        return (i2 - this.f19003b.b()) + 1;
    }

    /* access modifiers changed from: package-private */
    public int c(int i2) {
        return a() + (i2 - 1);
    }

    /* access modifiers changed from: package-private */
    public boolean d(int i2) {
        return i2 >= a() && i2 <= b();
    }

    /* access modifiers changed from: package-private */
    public boolean e(int i2) {
        return i2 % this.f19003b.f18924c == 0;
    }

    /* access modifiers changed from: package-private */
    public boolean f(int i2) {
        return (i2 + 1) % this.f19003b.f18924c == 0;
    }

    public int getCount() {
        return this.f19003b.f18925d + a();
    }

    public long getItemId(int i2) {
        return (long) (i2 / this.f19003b.f18924c);
    }

    public boolean hasStableIds() {
        return true;
    }
}
