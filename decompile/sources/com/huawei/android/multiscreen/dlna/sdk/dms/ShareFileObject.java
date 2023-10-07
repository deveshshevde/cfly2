package com.huawei.android.multiscreen.dlna.sdk.dms;

import android.os.Parcel;
import android.os.Parcelable;

public class ShareFileObject implements Parcelable {
    public static final Parcelable.Creator<ShareFileObject> CREATOR = new Parcelable.Creator<ShareFileObject>() {
        /* renamed from: a */
        public ShareFileObject createFromParcel(Parcel parcel) {
            return null;
        }

        /* renamed from: a */
        public ShareFileObject[] newArray(int i2) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f20818a;

    /* renamed from: b  reason: collision with root package name */
    private ShareOperationFlagEnum f20819b;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f20818a);
        parcel.writeParcelable(this.f20819b, i2);
    }
}
