package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

final class Month implements Parcelable, Comparable<Month> {
    public static final Parcelable.Creator<Month> CREATOR = new Parcelable.Creator<Month>() {
        /* renamed from: a */
        public Month createFromParcel(Parcel parcel) {
            return Month.a(parcel.readInt(), parcel.readInt());
        }

        /* renamed from: a */
        public Month[] newArray(int i2) {
            return new Month[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final int f18922a;

    /* renamed from: b  reason: collision with root package name */
    final int f18923b;

    /* renamed from: c  reason: collision with root package name */
    final int f18924c;

    /* renamed from: d  reason: collision with root package name */
    final int f18925d;

    /* renamed from: e  reason: collision with root package name */
    final long f18926e;

    /* renamed from: f  reason: collision with root package name */
    private final Calendar f18927f;

    /* renamed from: g  reason: collision with root package name */
    private String f18928g;

    private Month(Calendar calendar) {
        calendar.set(5, 1);
        Calendar b2 = o.b(calendar);
        this.f18927f = b2;
        this.f18922a = b2.get(2);
        this.f18923b = b2.get(1);
        this.f18924c = b2.getMaximum(7);
        this.f18925d = b2.getActualMaximum(5);
        this.f18926e = b2.getTimeInMillis();
    }

    static Month a() {
        return new Month(o.b());
    }

    static Month a(int i2, int i3) {
        Calendar c2 = o.c();
        c2.set(1, i2);
        c2.set(2, i3);
        return new Month(c2);
    }

    static Month a(long j2) {
        Calendar c2 = o.c();
        c2.setTimeInMillis(j2);
        return new Month(c2);
    }

    /* renamed from: a */
    public int compareTo(Month month) {
        return this.f18927f.compareTo(month.f18927f);
    }

    /* access modifiers changed from: package-private */
    public long a(int i2) {
        Calendar b2 = o.b(this.f18927f);
        b2.set(5, i2);
        return b2.getTimeInMillis();
    }

    /* access modifiers changed from: package-private */
    public String a(Context context) {
        if (this.f18928g == null) {
            this.f18928g = d.a(context, this.f18927f.getTimeInMillis());
        }
        return this.f18928g;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        int firstDayOfWeek = this.f18927f.get(7) - this.f18927f.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.f18924c : firstDayOfWeek;
    }

    /* access modifiers changed from: package-private */
    public int b(long j2) {
        Calendar b2 = o.b(this.f18927f);
        b2.setTimeInMillis(j2);
        return b2.get(5);
    }

    /* access modifiers changed from: package-private */
    public int b(Month month) {
        if (this.f18927f instanceof GregorianCalendar) {
            return ((month.f18923b - this.f18923b) * 12) + (month.f18922a - this.f18922a);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    /* access modifiers changed from: package-private */
    public Month b(int i2) {
        Calendar b2 = o.b(this.f18927f);
        b2.add(2, i2);
        return new Month(b2);
    }

    /* access modifiers changed from: package-private */
    public long c() {
        return this.f18927f.getTimeInMillis();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        return this.f18922a == month.f18922a && this.f18923b == month.f18923b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f18922a), Integer.valueOf(this.f18923b)});
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f18923b);
        parcel.writeInt(this.f18922a);
    }
}
