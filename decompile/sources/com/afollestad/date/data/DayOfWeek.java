package com.afollestad.date.data;

public enum DayOfWeek {
    SUNDAY(1),
    MONDAY(2),
    TUESDAY(3),
    WEDNESDAY(4),
    THURSDAY(5),
    FRIDAY(6),
    SATURDAY(7);
    

    /* renamed from: i  reason: collision with root package name */
    private final int f7410i;

    private DayOfWeek(int i2) {
        this.f7410i = i2;
    }

    public final int a() {
        return this.f7410i;
    }
}
