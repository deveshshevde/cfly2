package com.huawei.android.multiscreen.dlna.sdk.dms;

import android.os.Parcel;
import android.os.Parcelable;

public enum ShareOperationFlagEnum implements Parcelable {
    REMOVE_SHARE_FLAG(0),
    ADD_SHARE_FLAG(1);
    
    public static final Parcelable.Creator<ShareOperationFlagEnum> CREATOR = null;

    /* renamed from: c  reason: collision with root package name */
    private int f20823c;

    static {
        CREATOR = new Parcelable.Creator<ShareOperationFlagEnum>() {
            /* renamed from: a */
            public ShareOperationFlagEnum createFromParcel(Parcel parcel) {
                return ShareOperationFlagEnum.valueOf(parcel.readString());
            }

            /* renamed from: a */
            public ShareOperationFlagEnum[] newArray(int i2) {
                return new ShareOperationFlagEnum[i2];
            }
        };
    }

    private ShareOperationFlagEnum(int i2) {
        this.f20823c = i2;
    }

    public int a() {
        return this.f20823c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(name());
    }
}
