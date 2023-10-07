package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Build;
import android.text.format.DateUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

class d {
    static String a(long j2) {
        return a(j2, Locale.getDefault());
    }

    static String a(long j2, SimpleDateFormat simpleDateFormat) {
        Calendar b2 = o.b();
        Calendar c2 = o.c();
        c2.setTimeInMillis(j2);
        return simpleDateFormat != null ? simpleDateFormat.format(new Date(j2)) : b2.get(1) == c2.get(1) ? b(j2) : a(j2);
    }

    static String a(long j2, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? o.a(locale).format(new Date(j2)) : o.e(locale).format(new Date(j2));
    }

    static String a(Context context, long j2) {
        return DateUtils.formatDateTime(context, j2 - ((long) TimeZone.getDefault().getOffset(j2)), 36);
    }

    static s.d<String, String> a(Long l2, Long l3) {
        return a(l2, l3, (SimpleDateFormat) null);
    }

    static s.d<String, String> a(Long l2, Long l3, SimpleDateFormat simpleDateFormat) {
        if (l2 == null && l3 == null) {
            return s.d.a(null, null);
        }
        if (l2 == null) {
            return s.d.a(null, a(l3.longValue(), simpleDateFormat));
        }
        if (l3 == null) {
            return s.d.a(a(l2.longValue(), simpleDateFormat), null);
        }
        Calendar b2 = o.b();
        Calendar c2 = o.c();
        c2.setTimeInMillis(l2.longValue());
        Calendar c3 = o.c();
        c3.setTimeInMillis(l3.longValue());
        if (simpleDateFormat == null) {
            return c2.get(1) == c3.get(1) ? c2.get(1) == b2.get(1) ? s.d.a(b(l2.longValue(), Locale.getDefault()), b(l3.longValue(), Locale.getDefault())) : s.d.a(b(l2.longValue(), Locale.getDefault()), a(l3.longValue(), Locale.getDefault())) : s.d.a(a(l2.longValue(), Locale.getDefault()), a(l3.longValue(), Locale.getDefault()));
        }
        return s.d.a(simpleDateFormat.format(new Date(l2.longValue())), simpleDateFormat.format(new Date(l3.longValue())));
    }

    static String b(long j2) {
        return b(j2, Locale.getDefault());
    }

    static String b(long j2, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? o.b(locale).format(new Date(j2)) : o.f(locale).format(new Date(j2));
    }

    static String c(long j2) {
        return c(j2, Locale.getDefault());
    }

    static String c(long j2, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? o.c(locale).format(new Date(j2)) : o.g(locale).format(new Date(j2));
    }

    static String d(long j2) {
        return d(j2, Locale.getDefault());
    }

    static String d(long j2, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? o.d(locale).format(new Date(j2)) : o.g(locale).format(new Date(j2));
    }

    static String e(long j2) {
        return a(j2, (SimpleDateFormat) null);
    }
}
