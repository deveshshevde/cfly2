package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.Arrays;

public class DateValidatorPointForward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointForward> CREATOR = new Parcelable.Creator<DateValidatorPointForward>() {
        /* renamed from: a */
        public DateValidatorPointForward createFromParcel(Parcel parcel) {
            return new DateValidatorPointForward(parcel.readLong());
        }

        /* renamed from: a */
        public DateValidatorPointForward[] newArray(int i2) {
            return new DateValidatorPointForward[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final long f18883a;

    private DateValidatorPointForward(long j2) {
        this.f18883a = j2;
    }

    public static DateValidatorPointForward b(long j2) {
        return new DateValidatorPointForward(j2);
    }

    public boolean a(long j2) {
        return j2 >= this.f18883a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DateValidatorPointForward) && this.f18883a == ((DateValidatorPointForward) obj).f18883a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f18883a)});
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f18883a);
    }
}
