package com.google.android.exoplayer2.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.ad;
import java.util.Arrays;

public final class ColorInfo implements Parcelable {
    public static final Parcelable.Creator<ColorInfo> CREATOR = new Parcelable.Creator<ColorInfo>() {
        /* renamed from: a */
        public ColorInfo createFromParcel(Parcel parcel) {
            return new ColorInfo(parcel);
        }

        /* renamed from: a */
        public ColorInfo[] newArray(int i2) {
            return new ColorInfo[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final int f17196a;

    /* renamed from: b  reason: collision with root package name */
    public final int f17197b;

    /* renamed from: c  reason: collision with root package name */
    public final int f17198c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f17199d;

    /* renamed from: e  reason: collision with root package name */
    private int f17200e;

    public ColorInfo(int i2, int i3, int i4, byte[] bArr) {
        this.f17196a = i2;
        this.f17197b = i3;
        this.f17198c = i4;
        this.f17199d = bArr;
    }

    ColorInfo(Parcel parcel) {
        this.f17196a = parcel.readInt();
        this.f17197b = parcel.readInt();
        this.f17198c = parcel.readInt();
        this.f17199d = ad.a(parcel) ? parcel.createByteArray() : null;
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
        ColorInfo colorInfo = (ColorInfo) obj;
        return this.f17196a == colorInfo.f17196a && this.f17197b == colorInfo.f17197b && this.f17198c == colorInfo.f17198c && Arrays.equals(this.f17199d, colorInfo.f17199d);
    }

    public int hashCode() {
        if (this.f17200e == 0) {
            this.f17200e = ((((((527 + this.f17196a) * 31) + this.f17197b) * 31) + this.f17198c) * 31) + Arrays.hashCode(this.f17199d);
        }
        return this.f17200e;
    }

    public String toString() {
        int i2 = this.f17196a;
        int i3 = this.f17197b;
        int i4 = this.f17198c;
        boolean z2 = this.f17199d != null;
        StringBuilder sb = new StringBuilder(55);
        sb.append("ColorInfo(");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(i4);
        sb.append(", ");
        sb.append(z2);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f17196a);
        parcel.writeInt(this.f17197b);
        parcel.writeInt(this.f17198c);
        ad.a(parcel, this.f17199d != null);
        byte[] bArr = this.f17199d;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }
}
