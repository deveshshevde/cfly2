package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.ad;

public final class TextInformationFrame extends Id3Frame {
    public static final Parcelable.Creator<TextInformationFrame> CREATOR = new Parcelable.Creator<TextInformationFrame>() {
        /* renamed from: a */
        public TextInformationFrame createFromParcel(Parcel parcel) {
            return new TextInformationFrame(parcel);
        }

        /* renamed from: a */
        public TextInformationFrame[] newArray(int i2) {
            return new TextInformationFrame[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f15921a;

    /* renamed from: b  reason: collision with root package name */
    public final String f15922b;

    TextInformationFrame(Parcel parcel) {
        super((String) ad.a(parcel.readString()));
        this.f15921a = parcel.readString();
        this.f15922b = (String) ad.a(parcel.readString());
    }

    public TextInformationFrame(String str, String str2, String str3) {
        super(str);
        this.f15921a = str2;
        this.f15922b = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TextInformationFrame textInformationFrame = (TextInformationFrame) obj;
        return this.f15910f.equals(textInformationFrame.f15910f) && ad.a((Object) this.f15921a, (Object) textInformationFrame.f15921a) && ad.a((Object) this.f15922b, (Object) textInformationFrame.f15922b);
    }

    public int hashCode() {
        int hashCode = (527 + this.f15910f.hashCode()) * 31;
        String str = this.f15921a;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f15922b;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        String str = this.f15910f;
        String str2 = this.f15921a;
        String str3 = this.f15922b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append(": description=");
        sb.append(str2);
        sb.append(": value=");
        sb.append(str3);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f15910f);
        parcel.writeString(this.f15921a);
        parcel.writeString(this.f15922b);
    }
}
