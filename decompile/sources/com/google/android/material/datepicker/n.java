package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;

class n {

    /* renamed from: a  reason: collision with root package name */
    private static final n f19019a = new n((Long) null, (TimeZone) null);

    /* renamed from: b  reason: collision with root package name */
    private final Long f19020b;

    /* renamed from: c  reason: collision with root package name */
    private final TimeZone f19021c;

    private n(Long l2, TimeZone timeZone) {
        this.f19020b = l2;
        this.f19021c = timeZone;
    }

    static n a() {
        return f19019a;
    }

    /* access modifiers changed from: package-private */
    public Calendar a(TimeZone timeZone) {
        Calendar instance = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l2 = this.f19020b;
        if (l2 != null) {
            instance.setTimeInMillis(l2.longValue());
        }
        return instance;
    }

    /* access modifiers changed from: package-private */
    public Calendar b() {
        return a(this.f19021c);
    }
}
