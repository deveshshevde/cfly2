package com.afollestad.date.data;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import kotlin.jvm.internal.h;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final SimpleDateFormat f7411a = new SimpleDateFormat("MMMM yyyy", Locale.getDefault());

    /* renamed from: b  reason: collision with root package name */
    private final SimpleDateFormat f7412b = new SimpleDateFormat("yyyy", Locale.getDefault());

    /* renamed from: c  reason: collision with root package name */
    private final SimpleDateFormat f7413c = new SimpleDateFormat("EEE, MMM dd", Locale.getDefault());

    /* renamed from: d  reason: collision with root package name */
    private final SimpleDateFormat f7414d = new SimpleDateFormat("MMMM", Locale.getDefault());

    public final String a(Calendar calendar) {
        h.c(calendar, "calendar");
        String format = this.f7411a.format(calendar.getTime());
        h.a((Object) format, "monthAndYearFormatter.format(calendar.time)");
        return format;
    }

    public final String b(Calendar calendar) {
        h.c(calendar, "calendar");
        String format = this.f7412b.format(calendar.getTime());
        h.a((Object) format, "yearFormatter.format(calendar.time)");
        return format;
    }

    public final String c(Calendar calendar) {
        h.c(calendar, "calendar");
        String format = this.f7413c.format(calendar.getTime());
        h.a((Object) format, "dateFormatter.format(calendar.time)");
        return format;
    }

    public final String d(Calendar calendar) {
        h.c(calendar, "calendar");
        String format = this.f7414d.format(calendar.getTime());
        h.a((Object) format, "monthFormatter.format(calendar.time)");
        return format;
    }
}
