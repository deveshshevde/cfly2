package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.ad;

public final class InternalFrame extends Id3Frame {
    public static final Parcelable.Creator<InternalFrame> CREATOR = new Parcelable.Creator<InternalFrame>() {
        /* renamed from: a */
        public InternalFrame createFromParcel(Parcel parcel) {
            return new InternalFrame(parcel);
        }

        /* renamed from: a */
        public InternalFrame[] newArray(int i2) {
            return new InternalFrame[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f15911a;

    /* renamed from: b  reason: collision with root package name */
    public final String f15912b;

    /* renamed from: c  reason: collision with root package name */
    public final String f15913c;

    InternalFrame(Parcel parcel) {
        super("----");
        this.f15911a = (String) ad.a(parcel.readString());
        this.f15912b = (String) ad.a(parcel.readString());
        this.f15913c = (String) ad.a(parcel.readString());
    }

    public InternalFrame(String str, String str2, String str3) {
        super("----");
        this.f15911a = str;
        this.f15912b = str2;
        this.f15913c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        InternalFrame internalFrame = (InternalFrame) obj;
        return ad.a((Object) this.f15912b, (Object) internalFrame.f15912b) && ad.a((Object) this.f15911a, (Object) internalFrame.f15911a) && ad.a((Object) this.f15913c, (Object) internalFrame.f15913c);
    }

    public int hashCode() {
        String str = this.f15911a;
        int i2 = 0;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f15912b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f15913c;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        String str = this.f15910f;
        String str2 = this.f15911a;
        String str3 = this.f15912b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 23 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append(": domain=");
        sb.append(str2);
        sb.append(", description=");
        sb.append(str3);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f15910f);
        parcel.writeString(this.f15911a);
        parcel.writeString(this.f15913c);
    }
}
