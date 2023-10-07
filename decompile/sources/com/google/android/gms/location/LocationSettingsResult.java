package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class LocationSettingsResult extends AbstractSafeParcelable implements g {
    public static final Parcelable.Creator<LocationSettingsResult> CREATOR = new ab();

    /* renamed from: a  reason: collision with root package name */
    private final Status f18079a;

    /* renamed from: b  reason: collision with root package name */
    private final LocationSettingsStates f18080b;

    public LocationSettingsResult(Status status) {
        this(status, (LocationSettingsStates) null);
    }

    public LocationSettingsResult(Status status, LocationSettingsStates locationSettingsStates) {
        this.f18079a = status;
        this.f18080b = locationSettingsStates;
    }

    public final LocationSettingsStates a() {
        return this.f18080b;
    }

    public final Status getStatus() {
        return this.f18079a;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, (Parcelable) getStatus(), i2, false);
        a.a(parcel, 2, (Parcelable) a(), i2, false);
        a.a(parcel, a2);
    }
}
