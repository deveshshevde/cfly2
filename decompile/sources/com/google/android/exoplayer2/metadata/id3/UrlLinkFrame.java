package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.ad;

public final class UrlLinkFrame extends Id3Frame {
    public static final Parcelable.Creator<UrlLinkFrame> CREATOR = new Parcelable.Creator<UrlLinkFrame>() {
        /* renamed from: a */
        public UrlLinkFrame createFromParcel(Parcel parcel) {
            return new UrlLinkFrame(parcel);
        }

        /* renamed from: a */
        public UrlLinkFrame[] newArray(int i2) {
            return new UrlLinkFrame[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f15923a;

    /* renamed from: b  reason: collision with root package name */
    public final String f15924b;

    UrlLinkFrame(Parcel parcel) {
        super((String) ad.a(parcel.readString()));
        this.f15923a = parcel.readString();
        this.f15924b = (String) ad.a(parcel.readString());
    }

    public UrlLinkFrame(String str, String str2, String str3) {
        super(str);
        this.f15923a = str2;
        this.f15924b = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UrlLinkFrame urlLinkFrame = (UrlLinkFrame) obj;
        return this.f15910f.equals(urlLinkFrame.f15910f) && ad.a((Object) this.f15923a, (Object) urlLinkFrame.f15923a) && ad.a((Object) this.f15924b, (Object) urlLinkFrame.f15924b);
    }

    public int hashCode() {
        int hashCode = (527 + this.f15910f.hashCode()) * 31;
        String str = this.f15923a;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f15924b;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        String str = this.f15910f;
        String str2 = this.f15924b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 6 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(": url=");
        sb.append(str2);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f15910f);
        parcel.writeString(this.f15923a);
        parcel.writeString(this.f15924b);
    }
}
