package com.google.android.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.a;
import java.util.Arrays;

public final class TrackGroup implements Parcelable {
    public static final Parcelable.Creator<TrackGroup> CREATOR = new Parcelable.Creator<TrackGroup>() {
        /* renamed from: a */
        public TrackGroup createFromParcel(Parcel parcel) {
            return new TrackGroup(parcel);
        }

        /* renamed from: a */
        public TrackGroup[] newArray(int i2) {
            return new TrackGroup[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final int f16005a;

    /* renamed from: b  reason: collision with root package name */
    private final Format[] f16006b;

    /* renamed from: c  reason: collision with root package name */
    private int f16007c;

    TrackGroup(Parcel parcel) {
        int readInt = parcel.readInt();
        this.f16005a = readInt;
        this.f16006b = new Format[readInt];
        for (int i2 = 0; i2 < this.f16005a; i2++) {
            this.f16006b[i2] = (Format) parcel.readParcelable(Format.class.getClassLoader());
        }
    }

    public TrackGroup(Format... formatArr) {
        a.b(formatArr.length > 0);
        this.f16006b = formatArr;
        this.f16005a = formatArr.length;
    }

    public int a(Format format) {
        int i2 = 0;
        while (true) {
            Format[] formatArr = this.f16006b;
            if (i2 >= formatArr.length) {
                return -1;
            }
            if (format == formatArr[i2]) {
                return i2;
            }
            i2++;
        }
    }

    public Format a(int i2) {
        return this.f16006b[i2];
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
        TrackGroup trackGroup = (TrackGroup) obj;
        return this.f16005a == trackGroup.f16005a && Arrays.equals(this.f16006b, trackGroup.f16006b);
    }

    public int hashCode() {
        if (this.f16007c == 0) {
            this.f16007c = 527 + Arrays.hashCode(this.f16006b);
        }
        return this.f16007c;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f16005a);
        for (int i3 = 0; i3 < this.f16005a; i3++) {
            parcel.writeParcelable(this.f16006b[i3], 0);
        }
    }
}
