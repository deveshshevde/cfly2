package com.afollestad.date.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import java.io.Serializable;
import java.util.Calendar;
import kotlin.jvm.internal.h;

public final class DatePickerSavedState extends View.BaseSavedState {
    public static final a CREATOR = new a((f) null);

    /* renamed from: a  reason: collision with root package name */
    private Calendar f7484a;

    public static final class a implements Parcelable.Creator<DatePickerSavedState> {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        /* renamed from: a */
        public DatePickerSavedState createFromParcel(Parcel parcel) {
            h.c(parcel, "parcel");
            return new DatePickerSavedState(parcel);
        }

        /* renamed from: a */
        public DatePickerSavedState[] newArray(int i2) {
            return new DatePickerSavedState[i2];
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DatePickerSavedState(Parcel parcel) {
        super(parcel);
        h.c(parcel, "source");
        Serializable readSerializable = parcel.readSerializable();
        this.f7484a = (Calendar) (!(readSerializable instanceof Calendar) ? null : readSerializable);
    }

    public DatePickerSavedState(Calendar calendar, Parcelable parcelable) {
        super(parcelable);
        this.f7484a = calendar;
    }

    public final Calendar a() {
        return this.f7484a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        h.c(parcel, "parcel");
        super.writeToParcel(parcel, i2);
        parcel.writeSerializable(this.f7484a);
    }
}
