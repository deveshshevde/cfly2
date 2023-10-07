package com.huawei.android.multiscreen.dlna.sdk.common;

import android.os.Parcel;
import android.os.Parcelable;

public enum EMediaInfoType implements Parcelable {
    IMAGE,
    AUDIO,
    VIDEO,
    TUNER,
    EPG,
    FOLDER,
    IMAGE_VIDEO;
    
    public static final Parcelable.Creator<EMediaInfoType> CREATOR = null;

    static {
        CREATOR = new Parcelable.Creator<EMediaInfoType>() {
            /* renamed from: a */
            public EMediaInfoType createFromParcel(Parcel parcel) {
                return EMediaInfoType.valueOf(parcel.readString());
            }

            /* renamed from: a */
            public EMediaInfoType[] newArray(int i2) {
                return new EMediaInfoType[i2];
            }
        };
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(name());
    }
}
