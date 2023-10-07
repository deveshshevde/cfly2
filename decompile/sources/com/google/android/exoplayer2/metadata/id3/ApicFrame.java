package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.ad;
import java.util.Arrays;

public final class ApicFrame extends Id3Frame {
    public static final Parcelable.Creator<ApicFrame> CREATOR = new Parcelable.Creator<ApicFrame>() {
        /* renamed from: a */
        public ApicFrame createFromParcel(Parcel parcel) {
            return new ApicFrame(parcel);
        }

        /* renamed from: a */
        public ApicFrame[] newArray(int i2) {
            return new ApicFrame[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f15887a;

    /* renamed from: b  reason: collision with root package name */
    public final String f15888b;

    /* renamed from: c  reason: collision with root package name */
    public final int f15889c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f15890d;

    ApicFrame(Parcel parcel) {
        super("APIC");
        this.f15887a = (String) ad.a(parcel.readString());
        this.f15888b = parcel.readString();
        this.f15889c = parcel.readInt();
        this.f15890d = (byte[]) ad.a(parcel.createByteArray());
    }

    public ApicFrame(String str, String str2, int i2, byte[] bArr) {
        super("APIC");
        this.f15887a = str;
        this.f15888b = str2;
        this.f15889c = i2;
        this.f15890d = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ApicFrame apicFrame = (ApicFrame) obj;
        return this.f15889c == apicFrame.f15889c && ad.a((Object) this.f15887a, (Object) apicFrame.f15887a) && ad.a((Object) this.f15888b, (Object) apicFrame.f15888b) && Arrays.equals(this.f15890d, apicFrame.f15890d);
    }

    public int hashCode() {
        int i2 = (527 + this.f15889c) * 31;
        String str = this.f15887a;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f15888b;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return ((hashCode + i3) * 31) + Arrays.hashCode(this.f15890d);
    }

    public String toString() {
        String str = this.f15910f;
        String str2 = this.f15887a;
        String str3 = this.f15888b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 25 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append(": mimeType=");
        sb.append(str2);
        sb.append(", description=");
        sb.append(str3);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f15887a);
        parcel.writeString(this.f15888b);
        parcel.writeInt(this.f15889c);
        parcel.writeByteArray(this.f15890d);
    }
}
