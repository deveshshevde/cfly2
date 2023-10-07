package com.google.android.exoplayer2.offline;

import android.os.Parcel;
import android.os.Parcelable;

public final class StreamKey implements Parcelable, Comparable<StreamKey> {
    public static final Parcelable.Creator<StreamKey> CREATOR = new Parcelable.Creator<StreamKey>() {
        /* renamed from: a */
        public StreamKey createFromParcel(Parcel parcel) {
            return new StreamKey(parcel);
        }

        /* renamed from: a */
        public StreamKey[] newArray(int i2) {
            return new StreamKey[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final int f15980a;

    /* renamed from: b  reason: collision with root package name */
    public final int f15981b;

    /* renamed from: c  reason: collision with root package name */
    public final int f15982c;

    StreamKey(Parcel parcel) {
        this.f15980a = parcel.readInt();
        this.f15981b = parcel.readInt();
        this.f15982c = parcel.readInt();
    }

    /* renamed from: a */
    public int compareTo(StreamKey streamKey) {
        int i2 = this.f15980a - streamKey.f15980a;
        if (i2 != 0) {
            return i2;
        }
        int i3 = this.f15981b - streamKey.f15981b;
        return i3 == 0 ? this.f15982c - streamKey.f15982c : i3;
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
        StreamKey streamKey = (StreamKey) obj;
        return this.f15980a == streamKey.f15980a && this.f15981b == streamKey.f15981b && this.f15982c == streamKey.f15982c;
    }

    public int hashCode() {
        return (((this.f15980a * 31) + this.f15981b) * 31) + this.f15982c;
    }

    public String toString() {
        int i2 = this.f15980a;
        int i3 = this.f15981b;
        int i4 = this.f15982c;
        StringBuilder sb = new StringBuilder(35);
        sb.append(i2);
        sb.append(".");
        sb.append(i3);
        sb.append(".");
        sb.append(i4);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f15980a);
        parcel.writeInt(this.f15981b);
        parcel.writeInt(this.f15982c);
    }
}
