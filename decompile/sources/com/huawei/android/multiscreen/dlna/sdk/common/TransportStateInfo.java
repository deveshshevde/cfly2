package com.huawei.android.multiscreen.dlna.sdk.common;

import android.os.Parcel;
import android.os.Parcelable;

public class TransportStateInfo implements Parcelable {
    public static final Parcelable.Creator<TransportStateInfo> CREATOR = new Parcelable.Creator<TransportStateInfo>() {
        /* renamed from: a */
        public TransportStateInfo createFromParcel(Parcel parcel) {
            TransportStateInfo transportStateInfo = new TransportStateInfo();
            transportStateInfo.a(ETransportState.valueOf(parcel.readString()));
            return transportStateInfo;
        }

        /* renamed from: a */
        public TransportStateInfo[] newArray(int i2) {
            return new TransportStateInfo[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private ETransportState f20728a = ETransportState.INVALID;

    public void a(ETransportState eTransportState) {
        this.f20728a = eTransportState;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "TransportStateInfo [transportState=" + this.f20728a + "]";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f20728a.toString());
    }
}
