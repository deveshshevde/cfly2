package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import s.c;

public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new Parcelable.Creator<CalendarConstraints>() {
        /* renamed from: a */
        public CalendarConstraints createFromParcel(Parcel parcel) {
            return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()));
        }

        /* renamed from: a */
        public CalendarConstraints[] newArray(int i2) {
            return new CalendarConstraints[i2];
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Month f18866a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Month f18867b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final DateValidator f18868c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Month f18869d;

    /* renamed from: e  reason: collision with root package name */
    private final int f18870e;

    /* renamed from: f  reason: collision with root package name */
    private final int f18871f;

    public interface DateValidator extends Parcelable {
        boolean a(long j2);
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final long f18872a = o.a(Month.a(1900, 0).f18926e);

        /* renamed from: b  reason: collision with root package name */
        static final long f18873b = o.a(Month.a(2100, 11).f18926e);

        /* renamed from: c  reason: collision with root package name */
        private long f18874c = f18872a;

        /* renamed from: d  reason: collision with root package name */
        private long f18875d = f18873b;

        /* renamed from: e  reason: collision with root package name */
        private Long f18876e;

        /* renamed from: f  reason: collision with root package name */
        private DateValidator f18877f = DateValidatorPointForward.b(Long.MIN_VALUE);

        public a() {
        }

        a(CalendarConstraints calendarConstraints) {
            this.f18874c = calendarConstraints.f18866a.f18926e;
            this.f18875d = calendarConstraints.f18867b.f18926e;
            this.f18876e = Long.valueOf(calendarConstraints.f18869d.f18926e);
            this.f18877f = calendarConstraints.f18868c;
        }

        public a a(long j2) {
            this.f18876e = Long.valueOf(j2);
            return this;
        }

        public CalendarConstraints a() {
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f18877f);
            Month a2 = Month.a(this.f18874c);
            Month a3 = Month.a(this.f18875d);
            DateValidator dateValidator = (DateValidator) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l2 = this.f18876e;
            return new CalendarConstraints(a2, a3, dateValidator, l2 == null ? null : Month.a(l2.longValue()));
        }
    }

    private CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3) {
        this.f18866a = month;
        this.f18867b = month2;
        this.f18869d = month3;
        this.f18868c = dateValidator;
        if (month3 != null && month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        } else if (month3 == null || month3.compareTo(month2) <= 0) {
            this.f18871f = month.b(month2) + 1;
            this.f18870e = (month2.f18923b - month.f18923b) + 1;
        } else {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
    }

    public DateValidator a() {
        return this.f18868c;
    }

    /* access modifiers changed from: package-private */
    public Month a(Month month) {
        return month.compareTo(this.f18866a) < 0 ? this.f18866a : month.compareTo(this.f18867b) > 0 ? this.f18867b : month;
    }

    /* access modifiers changed from: package-private */
    public boolean a(long j2) {
        if (this.f18866a.a(1) <= j2) {
            Month month = this.f18867b;
            if (j2 <= month.a(month.f18925d)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public Month b() {
        return this.f18866a;
    }

    /* access modifiers changed from: package-private */
    public Month c() {
        return this.f18867b;
    }

    /* access modifiers changed from: package-private */
    public Month d() {
        return this.f18869d;
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f18871f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        return this.f18866a.equals(calendarConstraints.f18866a) && this.f18867b.equals(calendarConstraints.f18867b) && c.a((Object) this.f18869d, (Object) calendarConstraints.f18869d) && this.f18868c.equals(calendarConstraints.f18868c);
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f18870e;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f18866a, this.f18867b, this.f18869d, this.f18868c});
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f18866a, 0);
        parcel.writeParcelable(this.f18867b, 0);
        parcel.writeParcelable(this.f18869d, 0);
        parcel.writeParcelable(this.f18868c, 0);
    }
}
