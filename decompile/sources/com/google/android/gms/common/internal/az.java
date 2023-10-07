package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

final class az implements Parcelable.Creator<BinderWrapper> {
    az() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new BinderWrapper(parcel, (ba) null);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new BinderWrapper[i2];
    }
}
