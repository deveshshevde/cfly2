package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class ab implements Parcelable.Creator<LocationSettingsResult> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        Status status = null;
        LocationSettingsStates locationSettingsStates = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                status = (Status) SafeParcelReader.a(parcel, a2, Status.CREATOR);
            } else if (a3 != 2) {
                SafeParcelReader.r(parcel, a2);
            } else {
                locationSettingsStates = (LocationSettingsStates) SafeParcelReader.a(parcel, a2, LocationSettingsStates.CREATOR);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new LocationSettingsResult(status, locationSettingsStates);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new LocationSettingsResult[i2];
    }
}
