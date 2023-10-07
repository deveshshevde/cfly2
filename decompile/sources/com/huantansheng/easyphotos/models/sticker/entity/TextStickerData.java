package com.huantansheng.easyphotos.models.sticker.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class TextStickerData implements Parcelable {
    public static final Parcelable.Creator<TextStickerData> CREATOR = new Parcelable.Creator<TextStickerData>() {
        /* renamed from: a */
        public TextStickerData createFromParcel(Parcel parcel) {
            return new TextStickerData(parcel);
        }

        /* renamed from: a */
        public TextStickerData[] newArray(int i2) {
            return new TextStickerData[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public String f20466a;

    /* renamed from: b  reason: collision with root package name */
    public String f20467b;

    protected TextStickerData(Parcel parcel) {
        this.f20466a = parcel.readString();
        this.f20467b = parcel.readString();
    }

    public TextStickerData(String str, String str2) {
        this.f20466a = str;
        this.f20467b = str2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f20466a);
        parcel.writeString(this.f20467b);
    }
}
