package com.huawei.android.multiscreen.dlna.sdk.common;

import android.os.Parcel;
import android.os.Parcelable;

public class PositionInfo implements Parcelable {
    public static final Parcelable.Creator<PositionInfo> CREATOR = new Parcelable.Creator<PositionInfo>() {
        /* renamed from: a */
        public PositionInfo createFromParcel(Parcel parcel) {
            PositionInfo positionInfo = new PositionInfo();
            positionInfo.a(parcel.readString());
            positionInfo.b(parcel.readString());
            positionInfo.c(parcel.readString());
            positionInfo.d(parcel.readString());
            return positionInfo;
        }

        /* renamed from: a */
        public PositionInfo[] newArray(int i2) {
            return new PositionInfo[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f20722a;

    /* renamed from: b  reason: collision with root package name */
    private String f20723b;

    /* renamed from: c  reason: collision with root package name */
    private String f20724c;

    /* renamed from: d  reason: collision with root package name */
    private String f20725d;

    public void a(String str) {
        this.f20722a = str;
    }

    public void b(String str) {
        this.f20723b = str;
    }

    public void c(String str) {
        this.f20724c = str;
    }

    public void d(String str) {
        this.f20725d = str;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PositionInfo [trackDur=" + this.f20722a + ", trackMetaData=" + this.f20723b + ", trackURI=" + this.f20724c + ", relTime=" + this.f20725d + "]";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f20722a);
        parcel.writeString(this.f20723b);
        parcel.writeString(this.f20724c);
        parcel.writeString(this.f20725d);
    }
}
