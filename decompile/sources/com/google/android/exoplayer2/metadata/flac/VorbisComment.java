package com.google.android.exoplayer2.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.ad;

public final class VorbisComment implements Metadata.Entry {
    public static final Parcelable.Creator<VorbisComment> CREATOR = new Parcelable.Creator<VorbisComment>() {
        /* renamed from: a */
        public VorbisComment createFromParcel(Parcel parcel) {
            return new VorbisComment(parcel);
        }

        /* renamed from: a */
        public VorbisComment[] newArray(int i2) {
            return new VorbisComment[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f15873a;

    /* renamed from: b  reason: collision with root package name */
    public final String f15874b;

    VorbisComment(Parcel parcel) {
        this.f15873a = (String) ad.a(parcel.readString());
        this.f15874b = (String) ad.a(parcel.readString());
    }

    public VorbisComment(String str, String str2) {
        this.f15873a = str;
        this.f15874b = str2;
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
        VorbisComment vorbisComment = (VorbisComment) obj;
        return this.f15873a.equals(vorbisComment.f15873a) && this.f15874b.equals(vorbisComment.f15874b);
    }

    public int hashCode() {
        return ((527 + this.f15873a.hashCode()) * 31) + this.f15874b.hashCode();
    }

    public String toString() {
        String str = this.f15873a;
        String str2 = this.f15874b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 5 + String.valueOf(str2).length());
        sb.append("VC: ");
        sb.append(str);
        sb.append("=");
        sb.append(str2);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f15873a);
        parcel.writeString(this.f15874b);
    }
}
