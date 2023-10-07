package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.ArrayList;
import java.util.List;
import s.f;

public final class CompositeDateValidator implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<CompositeDateValidator> CREATOR = new Parcelable.Creator<CompositeDateValidator>() {
        /* renamed from: a */
        public CompositeDateValidator createFromParcel(Parcel parcel) {
            ArrayList readArrayList = parcel.readArrayList(CalendarConstraints.DateValidator.class.getClassLoader());
            int readInt = parcel.readInt();
            return new CompositeDateValidator((List) f.a(readArrayList), (readInt != 2 && readInt == 1) ? CompositeDateValidator.f18878c : CompositeDateValidator.f18879d);
        }

        /* renamed from: a */
        public CompositeDateValidator[] newArray(int i2) {
            return new CompositeDateValidator[i2];
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final a f18878c = new a() {
        public int a() {
            return 1;
        }

        public boolean a(List<CalendarConstraints.DateValidator> list, long j2) {
            for (CalendarConstraints.DateValidator next : list) {
                if (next != null && next.a(j2)) {
                    return true;
                }
            }
            return false;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final a f18879d = new a() {
        public int a() {
            return 2;
        }

        public boolean a(List<CalendarConstraints.DateValidator> list, long j2) {
            for (CalendarConstraints.DateValidator next : list) {
                if (next != null && !next.a(j2)) {
                    return false;
                }
            }
            return true;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final a f18880a;

    /* renamed from: b  reason: collision with root package name */
    private final List<CalendarConstraints.DateValidator> f18881b;

    private interface a {
        int a();

        boolean a(List<CalendarConstraints.DateValidator> list, long j2);
    }

    private CompositeDateValidator(List<CalendarConstraints.DateValidator> list, a aVar) {
        this.f18881b = list;
        this.f18880a = aVar;
    }

    public boolean a(long j2) {
        return this.f18880a.a(this.f18881b, j2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompositeDateValidator)) {
            return false;
        }
        CompositeDateValidator compositeDateValidator = (CompositeDateValidator) obj;
        return this.f18881b.equals(compositeDateValidator.f18881b) && this.f18880a.a() == compositeDateValidator.f18880a.a();
    }

    public int hashCode() {
        return this.f18881b.hashCode();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeList(this.f18881b);
        parcel.writeInt(this.f18880a.a());
    }
}
