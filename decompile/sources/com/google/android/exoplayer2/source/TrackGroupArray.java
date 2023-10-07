package com.google.android.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public final class TrackGroupArray implements Parcelable {
    public static final Parcelable.Creator<TrackGroupArray> CREATOR = new Parcelable.Creator<TrackGroupArray>() {
        /* renamed from: a */
        public TrackGroupArray createFromParcel(Parcel parcel) {
            return new TrackGroupArray(parcel);
        }

        /* renamed from: a */
        public TrackGroupArray[] newArray(int i2) {
            return new TrackGroupArray[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public static final TrackGroupArray f16008a = new TrackGroupArray(new TrackGroup[0]);

    /* renamed from: b  reason: collision with root package name */
    public final int f16009b;

    /* renamed from: c  reason: collision with root package name */
    private final TrackGroup[] f16010c;

    /* renamed from: d  reason: collision with root package name */
    private int f16011d;

    TrackGroupArray(Parcel parcel) {
        int readInt = parcel.readInt();
        this.f16009b = readInt;
        this.f16010c = new TrackGroup[readInt];
        for (int i2 = 0; i2 < this.f16009b; i2++) {
            this.f16010c[i2] = (TrackGroup) parcel.readParcelable(TrackGroup.class.getClassLoader());
        }
    }

    public TrackGroupArray(TrackGroup... trackGroupArr) {
        this.f16010c = trackGroupArr;
        this.f16009b = trackGroupArr.length;
    }

    public int a(TrackGroup trackGroup) {
        for (int i2 = 0; i2 < this.f16009b; i2++) {
            if (this.f16010c[i2] == trackGroup) {
                return i2;
            }
        }
        return -1;
    }

    public TrackGroup a(int i2) {
        return this.f16010c[i2];
    }

    public boolean a() {
        return this.f16009b == 0;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TrackGroupArray trackGroupArray = (TrackGroupArray) obj;
        return this.f16009b == trackGroupArray.f16009b && Arrays.equals(this.f16010c, trackGroupArray.f16010c);
    }

    public int hashCode() {
        if (this.f16011d == 0) {
            this.f16011d = Arrays.hashCode(this.f16010c);
        }
        return this.f16011d;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f16009b);
        for (int i3 = 0; i3 < this.f16009b; i3++) {
            parcel.writeParcelable(this.f16010c[i3], 0);
        }
    }
}
