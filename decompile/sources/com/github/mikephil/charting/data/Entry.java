package com.github.mikephil.charting.data;

import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;

public class Entry extends e implements Parcelable {
    public static final Parcelable.Creator<Entry> CREATOR = new Parcelable.Creator<Entry>() {
        /* renamed from: a */
        public Entry createFromParcel(Parcel parcel) {
            return new Entry(parcel);
        }

        /* renamed from: a */
        public Entry[] newArray(int i2) {
            return new Entry[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private float f14976a = 0.0f;

    public Entry() {
    }

    protected Entry(Parcel parcel) {
        this.f14976a = parcel.readFloat();
        a(parcel.readFloat());
        if (parcel.readInt() == 1) {
            a((Object) parcel.readParcelable(Object.class.getClassLoader()));
        }
    }

    public int describeContents() {
        return 0;
    }

    public float i() {
        return this.f14976a;
    }

    public String toString() {
        return "Entry, x: " + this.f14976a + " y: " + b();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeFloat(this.f14976a);
        parcel.writeFloat(b());
        if (h() == null) {
            parcel.writeInt(0);
        } else if (h() instanceof Parcelable) {
            parcel.writeInt(1);
            parcel.writeParcelable((Parcelable) h(), i2);
        } else {
            throw new ParcelFormatException("Cannot parcel an Entry with non-parcelable data");
        }
    }
}
