package com.afollestad.date;

import com.afollestad.date.data.DayOfWeek;
import com.afollestad.date.data.c;
import java.util.Calendar;
import kotlin.TypeCastException;
import kotlin.jvm.internal.h;

public final class a {
    public static final int a(Calendar calendar) {
        h.c(calendar, "$this$year");
        return calendar.get(1);
    }

    public static final void a(Calendar calendar, int i2) {
        h.c(calendar, "$this$year");
        calendar.set(1, i2);
    }

    public static final int b(Calendar calendar) {
        h.c(calendar, "$this$month");
        return calendar.get(2);
    }

    public static final void b(Calendar calendar, int i2) {
        h.c(calendar, "$this$month");
        calendar.set(2, i2);
    }

    public static final int c(Calendar calendar) {
        h.c(calendar, "$this$dayOfMonth");
        return calendar.get(5);
    }

    public static final void c(Calendar calendar, int i2) {
        h.c(calendar, "$this$dayOfMonth");
        calendar.set(5, i2);
    }

    public static final int d(Calendar calendar) {
        h.c(calendar, "$this$totalDaysInMonth");
        return calendar.getActualMaximum(5);
    }

    public static final Calendar e(Calendar calendar) {
        h.c(calendar, "$this$incrementMonth");
        Object clone = calendar.clone();
        if (clone != null) {
            Calendar calendar2 = (Calendar) clone;
            calendar2.add(2, 1);
            calendar2.set(5, 1);
            return calendar2;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.util.Calendar");
    }

    public static final Calendar f(Calendar calendar) {
        h.c(calendar, "$this$decrementMonth");
        Object clone = calendar.clone();
        if (clone != null) {
            Calendar calendar2 = (Calendar) clone;
            calendar2.add(2, -1);
            calendar2.set(5, d(calendar2));
            return calendar2;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.util.Calendar");
    }

    public static final DayOfWeek g(Calendar calendar) {
        h.c(calendar, "$this$dayOfWeek");
        return c.a(calendar.get(7));
    }
}
