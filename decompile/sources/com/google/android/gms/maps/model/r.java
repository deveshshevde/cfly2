package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class r implements Parcelable.Creator<PointOfInterest> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        LatLng latLng = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 2) {
                latLng = (LatLng) SafeParcelReader.a(parcel, a2, LatLng.CREATOR);
            } else if (a3 == 3) {
                str = SafeParcelReader.l(parcel, a2);
            } else if (a3 != 4) {
                SafeParcelReader.r(parcel, a2);
            } else {
                str2 = SafeParcelReader.l(parcel, a2);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new PointOfInterest(latLng, str, str2);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new PointOfInterest[i2];
    }
}
