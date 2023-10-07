package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new az();

    /* renamed from: a  reason: collision with root package name */
    private IBinder f17734a;

    /* synthetic */ BinderWrapper(Parcel parcel, ba baVar) {
        this.f17734a = parcel.readStrongBinder();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeStrongBinder(this.f17734a);
    }
}
