package com.huawei.android.multiscreen.dlna.sdk.dmc;

import android.os.Parcel;
import android.os.Parcelable;

public enum ERemoteDeviceType implements Parcelable {
    DMS_DEVICE,
    DMR_DEVICE,
    RCU_DEVICE;
    
    public static final Parcelable.Creator<ERemoteDeviceType> CREATOR = null;

    static {
        CREATOR = new Parcelable.Creator<ERemoteDeviceType>() {
            /* renamed from: a */
            public ERemoteDeviceType createFromParcel(Parcel parcel) {
                return ERemoteDeviceType.valueOf(parcel.readString());
            }

            /* renamed from: a */
            public ERemoteDeviceType[] newArray(int i2) {
                return new ERemoteDeviceType[i2];
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
