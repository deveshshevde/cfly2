package com.google.android.exoplayer2.extractor.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.ad;
import java.util.Arrays;

public final class MdtaMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<MdtaMetadataEntry> CREATOR = new Parcelable.Creator<MdtaMetadataEntry>() {
        /* renamed from: a */
        public MdtaMetadataEntry createFromParcel(Parcel parcel) {
            return new MdtaMetadataEntry(parcel);
        }

        /* renamed from: a */
        public MdtaMetadataEntry[] newArray(int i2) {
            return new MdtaMetadataEntry[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f15511a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f15512b;

    /* renamed from: c  reason: collision with root package name */
    public final int f15513c;

    /* renamed from: d  reason: collision with root package name */
    public final int f15514d;

    private MdtaMetadataEntry(Parcel parcel) {
        this.f15511a = (String) ad.a(parcel.readString());
        byte[] bArr = new byte[parcel.readInt()];
        this.f15512b = bArr;
        parcel.readByteArray(bArr);
        this.f15513c = parcel.readInt();
        this.f15514d = parcel.readInt();
    }

    public MdtaMetadataEntry(String str, byte[] bArr, int i2, int i3) {
        this.f15511a = str;
        this.f15512b = bArr;
        this.f15513c = i2;
        this.f15514d = i3;
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
        MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) obj;
        return this.f15511a.equals(mdtaMetadataEntry.f15511a) && Arrays.equals(this.f15512b, mdtaMetadataEntry.f15512b) && this.f15513c == mdtaMetadataEntry.f15513c && this.f15514d == mdtaMetadataEntry.f15514d;
    }

    public int hashCode() {
        return ((((((527 + this.f15511a.hashCode()) * 31) + Arrays.hashCode(this.f15512b)) * 31) + this.f15513c) * 31) + this.f15514d;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f15511a);
        return valueOf.length() != 0 ? "mdta: key=".concat(valueOf) : new String("mdta: key=");
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f15511a);
        parcel.writeInt(this.f15512b.length);
        parcel.writeByteArray(this.f15512b);
        parcel.writeInt(this.f15513c);
        parcel.writeInt(this.f15514d);
    }
}
