package com.google.android.material.datepicker;

import android.content.res.Resources;
import android.icu.text.DateFormat;
import com.google.android.material.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

class o {

    /* renamed from: a  reason: collision with root package name */
    static AtomicReference<n> f19022a = new AtomicReference<>();

    private static int a(String str, String str2, int i2, int i3) {
        while (i3 >= 0 && i3 < str.length() && str2.indexOf(str.charAt(i3)) == -1) {
            if (str.charAt(i3) == '\'') {
                do {
                    i3 += i2;
                    if (i3 < 0) {
                        break;
                    } else if (i3 >= str.length()) {
                        break;
                    }
                } while (str.charAt(i3) == '\'');
            }
            i3 += i2;
        }
        return i3;
    }

    static long a(long j2) {
        Calendar c2 = c();
        c2.setTimeInMillis(j2);
        return b(c2).getTimeInMillis();
    }

    private static DateFormat a(String str, Locale locale) {
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(f());
        return instanceForSkeleton;
    }

    static DateFormat a(Locale locale) {
        return a("yMMMd", locale);
    }

    static n a() {
        n nVar = f19022a.get();
        return nVar == null ? n.a() : nVar;
    }

    static String a(Resources resources, SimpleDateFormat simpleDateFormat) {
        String localizedPattern = simpleDateFormat.toLocalizedPattern();
        return localizedPattern.replaceAll("d", resources.getString(R.string.mtrl_picker_text_input_day_abbr)).replaceAll("M", resources.getString(R.string.mtrl_picker_text_input_month_abbr)).replaceAll("y", resources.getString(R.string.mtrl_picker_text_input_year_abbr));
    }

    private static String a(String str) {
        int a2 = a(str, "yY", 1, 0);
        if (a2 >= str.length()) {
            return str;
        }
        String str2 = "EMd";
        int a3 = a(str, str2, 1, a2);
        if (a3 < str.length()) {
            str2 = str2 + ",";
        }
        return str.replace(str.substring(a(str, str2, -1, a2) + 1, a3), " ").trim();
    }

    private static java.text.DateFormat a(int i2, Locale locale) {
        java.text.DateFormat dateInstance = java.text.DateFormat.getDateInstance(i2, locale);
        dateInstance.setTimeZone(e());
        return dateInstance;
    }

    static Calendar a(Calendar calendar) {
        Calendar instance = Calendar.getInstance(e());
        if (calendar == null) {
            instance.clear();
        } else {
            instance.setTimeInMillis(calendar.getTimeInMillis());
        }
        return instance;
    }

    static DateFormat b(Locale locale) {
        return a("MMMd", locale);
    }

    static Calendar b() {
        Calendar b2 = a().b();
        b2.set(11, 0);
        b2.set(12, 0);
        b2.set(13, 0);
        b2.set(14, 0);
        b2.setTimeZone(e());
        return b2;
    }

    static Calendar b(Calendar calendar) {
        Calendar a2 = a(calendar);
        Calendar c2 = c();
        c2.set(a2.get(1), a2.get(2), a2.get(5));
        return c2;
    }

    static DateFormat c(Locale locale) {
        return a("MMMEd", locale);
    }

    static Calendar c() {
        return a((Calendar) null);
    }

    static DateFormat d(Locale locale) {
        return a("yMMMEd", locale);
    }

    static SimpleDateFormat d() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(((SimpleDateFormat) java.text.DateFormat.getDateInstance(3, Locale.getDefault())).toLocalizedPattern().replaceAll("\\s+", ""), Locale.getDefault());
        simpleDateFormat.setTimeZone(e());
        simpleDateFormat.setLenient(false);
        return simpleDateFormat;
    }

    static java.text.DateFormat e(Locale locale) {
        return a(2, locale);
    }

    private static TimeZone e() {
        return TimeZone.getTimeZone("UTC");
    }

    private static android.icu.util.TimeZone f() {
        return android.icu.util.TimeZone.getTimeZone("UTC");
    }

    static java.text.DateFormat f(Locale locale) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) e(locale);
        simpleDateFormat.applyPattern(a(simpleDateFormat.toPattern()));
        return simpleDateFormat;
    }

    static java.text.DateFormat g(Locale locale) {
        return a(0, locale);
    }
}
