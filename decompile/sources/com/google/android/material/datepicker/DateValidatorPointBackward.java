package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.Arrays;

public class DateValidatorPointBackward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointBackward> CREATOR = new Parcelable.Creator<DateValidatorPointBackward>() {
        /* renamed from: a */
        public DateValidatorPointBackward createFromParcel(Parcel parcel) {
            return new DateValidatorPointBackward(parcel.readLong());
        }

        /* renamed from: a */
        public DateValidatorPointBackward[] newArray(int i2) {
            return new DateValidatorPointBackward[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final long f18882a;

    private DateValidatorPointBackward(long j2) {
        this.f18882a = j2;
    }

    public boolean a(long j2) {
        return j2 <= this.f18882a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DateValidatorPointBackward) && this.f18882a == ((DateValidatorPointBackward) obj).f18882a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f18882a)});
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f18882a);
    }
}
