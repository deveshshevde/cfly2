package com.huawei.android.multiscreen.dlna.sdk.dms;

import android.os.Parcel;
import android.os.Parcelable;

public enum ShareStateEnum implements Parcelable {
    NO_SHARE_FLAG(-1),
    PART_SHARE_FLAG(0),
    ALL_SHARE_FLAG(1);
    
    public static final Parcelable.Creator<ShareStateEnum> CREATOR = null;

    /* renamed from: d  reason: collision with root package name */
    private int f20828d;

    static {
        CREATOR = new Parcelable.Creator<ShareStateEnum>() {
            /* renamed from: a */
            public ShareStateEnum createFromParcel(Parcel parcel) {
                return ShareStateEnum.valueOf(parcel.readString());
            }

            /* renamed from: a */
            public ShareStateEnum[] newArray(int i2) {
                return new ShareStateEnum[i2];
            }
        };
    }

    private ShareStateEnum(int i2) {
        this.f20828d = i2;
    }

    public int a() {
        return this.f20828d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(name());
    }
}
