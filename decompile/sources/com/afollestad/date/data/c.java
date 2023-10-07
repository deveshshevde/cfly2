package com.afollestad.date.data;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.h;

public final class c {
    public static final DayOfWeek a(int i2) {
        DayOfWeek dayOfWeek = null;
        boolean z2 = false;
        for (DayOfWeek dayOfWeek2 : DayOfWeek.values()) {
            if (dayOfWeek2.a() == i2) {
                if (!z2) {
                    dayOfWeek = dayOfWeek2;
                    z2 = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z2) {
            return dayOfWeek;
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final List<DayOfWeek> a(DayOfWeek dayOfWeek) {
        h.c(dayOfWeek, "$this$andTheRest");
        List<DayOfWeek> arrayList = new ArrayList<>();
        int a2 = dayOfWeek.a();
        int a3 = DayOfWeek.SATURDAY.a();
        if (a2 <= a3) {
            while (true) {
                arrayList.add(a(a2));
                if (a2 == a3) {
                    break;
                }
                a2++;
            }
        }
        int a4 = dayOfWeek.a();
        for (int a5 = DayOfWeek.SUNDAY.a(); a5 < a4; a5++) {
            arrayList.add(a(a5));
        }
        return arrayList;
    }

    public static final DayOfWeek b(DayOfWeek dayOfWeek) {
        h.c(dayOfWeek, "$this$nextDayOfWeek");
        switch (d.f7415a[dayOfWeek.ordinal()]) {
            case 1:
                return DayOfWeek.MONDAY;
            case 2:
                return DayOfWeek.TUESDAY;
            case 3:
                return DayOfWeek.WEDNESDAY;
            case 4:
                return DayOfWeek.THURSDAY;
            case 5:
                return DayOfWeek.FRIDAY;
            case 6:
                return DayOfWeek.SATURDAY;
            case 7:
                return DayOfWeek.SUNDAY;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
