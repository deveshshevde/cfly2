package com.google.android.exoplayer2.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.ad;
import java.util.Arrays;

public final class PictureFrame implements Metadata.Entry {
    public static final Parcelable.Creator<PictureFrame> CREATOR = new Parcelable.Creator<PictureFrame>() {
        /* renamed from: a */
        public PictureFrame createFromParcel(Parcel parcel) {
            return new PictureFrame(parcel);
        }

        /* renamed from: a */
        public PictureFrame[] newArray(int i2) {
            return new PictureFrame[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final int f15865a;

    /* renamed from: b  reason: collision with root package name */
    public final String f15866b;

    /* renamed from: c  reason: collision with root package name */
    public final String f15867c;

    /* renamed from: d  reason: collision with root package name */
    public final int f15868d;

    /* renamed from: e  reason: collision with root package name */
    public final int f15869e;

    /* renamed from: f  reason: collision with root package name */
    public final int f15870f;

    /* renamed from: g  reason: collision with root package name */
    public final int f15871g;

    /* renamed from: h  reason: collision with root package name */
    public final byte[] f15872h;

    public PictureFrame(int i2, String str, String str2, int i3, int i4, int i5, int i6, byte[] bArr) {
        this.f15865a = i2;
        this.f15866b = str;
        this.f15867c = str2;
        this.f15868d = i3;
        this.f15869e = i4;
        this.f15870f = i5;
        this.f15871g = i6;
        this.f15872h = bArr;
    }

    PictureFrame(Parcel parcel) {
        this.f15865a = parcel.readInt();
        this.f15866b = (String) ad.a(parcel.readString());
        this.f15867c = (String) ad.a(parcel.readString());
        this.f15868d = parcel.readInt();
        this.f15869e = parcel.readInt();
        this.f15870f = parcel.readInt();
        this.f15871g = parcel.readInt();
        this.f15872h = (byte[]) ad.a(parcel.createByteArray());
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
        PictureFrame pictureFrame = (PictureFrame) obj;
        return this.f15865a == pictureFrame.f15865a && this.f15866b.equals(pictureFrame.f15866b) && this.f15867c.equals(pictureFrame.f15867c) && this.f15868d == pictureFrame.f15868d && this.f15869e == pictureFrame.f15869e && this.f15870f == pictureFrame.f15870f && this.f15871g == pictureFrame.f15871g && Arrays.equals(this.f15872h, pictureFrame.f15872h);
    }

    public int hashCode() {
        return ((((((((((((((527 + this.f15865a) * 31) + this.f15866b.hashCode()) * 31) + this.f15867c.hashCode()) * 31) + this.f15868d) * 31) + this.f15869e) * 31) + this.f15870f) * 31) + this.f15871g) * 31) + Arrays.hashCode(this.f15872h);
    }

    public String toString() {
        String str = this.f15866b;
        String str2 = this.f15867c;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(str2).length());
        sb.append("Picture: mimeType=");
        sb.append(str);
        sb.append(", description=");
        sb.append(str2);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f15865a);
        parcel.writeString(this.f15866b);
        parcel.writeString(this.f15867c);
        parcel.writeInt(this.f15868d);
        parcel.writeInt(this.f15869e);
        parcel.writeInt(this.f15870f);
        parcel.writeInt(this.f15871g);
        parcel.writeByteArray(this.f15872h);
    }
}
