package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.ad;
import java.util.Arrays;

public final class GeobFrame extends Id3Frame {
    public static final Parcelable.Creator<GeobFrame> CREATOR = new Parcelable.Creator<GeobFrame>() {
        /* renamed from: a */
        public GeobFrame createFromParcel(Parcel parcel) {
            return new GeobFrame(parcel);
        }

        /* renamed from: a */
        public GeobFrame[] newArray(int i2) {
            return new GeobFrame[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f15906a;

    /* renamed from: b  reason: collision with root package name */
    public final String f15907b;

    /* renamed from: c  reason: collision with root package name */
    public final String f15908c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f15909d;

    GeobFrame(Parcel parcel) {
        super("GEOB");
        this.f15906a = (String) ad.a(parcel.readString());
        this.f15907b = (String) ad.a(parcel.readString());
        this.f15908c = (String) ad.a(parcel.readString());
        this.f15909d = (byte[]) ad.a(parcel.createByteArray());
    }

    public GeobFrame(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.f15906a = str;
        this.f15907b = str2;
        this.f15908c = str3;
        this.f15909d = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GeobFrame geobFrame = (GeobFrame) obj;
        return ad.a((Object) this.f15906a, (Object) geobFrame.f15906a) && ad.a((Object) this.f15907b, (Object) geobFrame.f15907b) && ad.a((Object) this.f15908c, (Object) geobFrame.f15908c) && Arrays.equals(this.f15909d, geobFrame.f15909d);
    }

    public int hashCode() {
        String str = this.f15906a;
        int i2 = 0;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f15907b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f15908c;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return ((hashCode2 + i2) * 31) + Arrays.hashCode(this.f15909d);
    }

    public String toString() {
        String str = this.f15910f;
        String str2 = this.f15906a;
        String str3 = this.f15907b;
        String str4 = this.f15908c;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 36 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append(str);
        sb.append(": mimeType=");
        sb.append(str2);
        sb.append(", filename=");
        sb.append(str3);
        sb.append(", description=");
        sb.append(str4);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f15906a);
        parcel.writeString(this.f15907b);
        parcel.writeString(this.f15908c);
        parcel.writeByteArray(this.f15909d);
    }
}
