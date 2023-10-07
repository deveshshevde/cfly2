package com.huawei.android.multiscreen.dlna.sdk.common;

import android.os.Parcel;
import android.os.Parcelable;
import ie.a;

public class MediaInfoConvert implements Parcelable {
    public static final Parcelable.Creator<MediaInfoConvert> CREATOR = new Parcelable.Creator<MediaInfoConvert>() {
        /* renamed from: a */
        public MediaInfoConvert createFromParcel(Parcel parcel) {
            MediaInfoConvert mediaInfoConvert = new MediaInfoConvert();
            try {
                mediaInfoConvert.a((MediaInfo) parcel.readParcelable(Class.forName(parcel.readString()).getClassLoader()));
            } catch (ClassNotFoundException unused) {
                a.d("MediaInfoConvert", "MediaInfoConvert.createFromParcel happened ClassNotFoundException");
            }
            return mediaInfoConvert;
        }

        /* renamed from: a */
        public MediaInfoConvert[] newArray(int i2) {
            return new MediaInfoConvert[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private MediaInfo f20721a;

    public void a(MediaInfo mediaInfo) {
        this.f20721a = mediaInfo;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f20721a.getClass().getName());
        parcel.writeParcelable(this.f20721a, i2);
    }
}
