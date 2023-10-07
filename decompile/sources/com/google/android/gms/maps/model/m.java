package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class m implements Parcelable.Creator<LatLngBounds> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        LatLng latLng = null;
        LatLng latLng2 = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 2) {
                latLng = (LatLng) SafeParcelReader.a(parcel, a2, LatLng.CREATOR);
            } else if (a3 != 3) {
                SafeParcelReader.r(parcel, a2);
            } else {
                latLng2 = (LatLng) SafeParcelReader.a(parcel, a2, LatLng.CREATOR);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new LatLngBounds(latLng, latLng2);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new LatLngBounds[i2];
    }
}
