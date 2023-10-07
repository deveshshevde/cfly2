package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.ad;
import java.util.Arrays;

public final class PrivFrame extends Id3Frame {
    public static final Parcelable.Creator<PrivFrame> CREATOR = new Parcelable.Creator<PrivFrame>() {
        /* renamed from: a */
        public PrivFrame createFromParcel(Parcel parcel) {
            return new PrivFrame(parcel);
        }

        /* renamed from: a */
        public PrivFrame[] newArray(int i2) {
            return new PrivFrame[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f15919a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f15920b;

    PrivFrame(Parcel parcel) {
        super("PRIV");
        this.f15919a = (String) ad.a(parcel.readString());
        this.f15920b = (byte[]) ad.a(parcel.createByteArray());
    }

    public PrivFrame(String str, byte[] bArr) {
        super("PRIV");
        this.f15919a = str;
        this.f15920b = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PrivFrame privFrame = (PrivFrame) obj;
        return ad.a((Object) this.f15919a, (Object) privFrame.f15919a) && Arrays.equals(this.f15920b, privFrame.f15920b);
    }

    public int hashCode() {
        String str = this.f15919a;
        return ((527 + (str != null ? str.hashCode() : 0)) * 31) + Arrays.hashCode(this.f15920b);
    }

    public String toString() {
        String str = this.f15910f;
        String str2 = this.f15919a;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 8 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(": owner=");
        sb.append(str2);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f15919a);
        parcel.writeByteArray(this.f15920b);
    }
}
