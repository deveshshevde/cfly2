package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.ad;

public final class CommentFrame extends Id3Frame {
    public static final Parcelable.Creator<CommentFrame> CREATOR = new Parcelable.Creator<CommentFrame>() {
        /* renamed from: a */
        public CommentFrame createFromParcel(Parcel parcel) {
            return new CommentFrame(parcel);
        }

        /* renamed from: a */
        public CommentFrame[] newArray(int i2) {
            return new CommentFrame[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f15903a;

    /* renamed from: b  reason: collision with root package name */
    public final String f15904b;

    /* renamed from: c  reason: collision with root package name */
    public final String f15905c;

    CommentFrame(Parcel parcel) {
        super("COMM");
        this.f15903a = (String) ad.a(parcel.readString());
        this.f15904b = (String) ad.a(parcel.readString());
        this.f15905c = (String) ad.a(parcel.readString());
    }

    public CommentFrame(String str, String str2, String str3) {
        super("COMM");
        this.f15903a = str;
        this.f15904b = str2;
        this.f15905c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CommentFrame commentFrame = (CommentFrame) obj;
        return ad.a((Object) this.f15904b, (Object) commentFrame.f15904b) && ad.a((Object) this.f15903a, (Object) commentFrame.f15903a) && ad.a((Object) this.f15905c, (Object) commentFrame.f15905c);
    }

    public int hashCode() {
        String str = this.f15903a;
        int i2 = 0;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f15904b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f15905c;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        String str = this.f15910f;
        String str2 = this.f15903a;
        String str3 = this.f15904b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 25 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append(": language=");
        sb.append(str2);
        sb.append(", description=");
        sb.append(str3);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f15910f);
        parcel.writeString(this.f15903a);
        parcel.writeString(this.f15905c);
    }
}
