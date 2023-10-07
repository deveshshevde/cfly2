package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.a;
import java.util.Arrays;

public final class IcyInfo implements Metadata.Entry {
    public static final Parcelable.Creator<IcyInfo> CREATOR = new Parcelable.Creator<IcyInfo>() {
        /* renamed from: a */
        public IcyInfo createFromParcel(Parcel parcel) {
            return new IcyInfo(parcel);
        }

        /* renamed from: a */
        public IcyInfo[] newArray(int i2) {
            return new IcyInfo[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f15881a;

    /* renamed from: b  reason: collision with root package name */
    public final String f15882b;

    /* renamed from: c  reason: collision with root package name */
    public final String f15883c;

    IcyInfo(Parcel parcel) {
        this.f15881a = (byte[]) a.b(parcel.createByteArray());
        this.f15882b = parcel.readString();
        this.f15883c = parcel.readString();
    }

    public IcyInfo(byte[] bArr, String str, String str2) {
        this.f15881a = bArr;
        this.f15882b = str;
        this.f15883c = str2;
    }

    public /* synthetic */ Format a() {
        return Metadata.Entry.CC.$default$a(this);
    }

    public /* synthetic */ byte[] b() {
        return Metadata.Entry.CC.$default$b(this);
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
        return Arrays.equals(this.f15881a, ((IcyInfo) obj).f15881a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f15881a);
    }

    public String toString() {
        return String.format("ICY: title=\"%s\", url=\"%s\", rawMetadata.length=\"%s\"", new Object[]{this.f15882b, this.f15883c, Integer.valueOf(this.f15881a.length)});
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByteArray(this.f15881a);
        parcel.writeString(this.f15882b);
        parcel.writeString(this.f15883c);
    }
}
