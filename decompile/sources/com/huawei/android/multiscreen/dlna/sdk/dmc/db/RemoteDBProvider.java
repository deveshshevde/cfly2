package com.huawei.android.multiscreen.dlna.sdk.dmc.db;

import android.os.Parcel;
import android.os.Parcelable;

public class RemoteDBProvider implements Parcelable {
    public static final Parcelable.Creator<RemoteDBProvider> CREATOR = new Parcelable.Creator<RemoteDBProvider>() {
        /* renamed from: a */
        public RemoteDBProvider createFromParcel(Parcel parcel) {
            return new RemoteDBProvider();
        }

        /* renamed from: a */
        public RemoteDBProvider[] newArray(int i2) {
            return new RemoteDBProvider[i2];
        }
    };

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
    }
}
