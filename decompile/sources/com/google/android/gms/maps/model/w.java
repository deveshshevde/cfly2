package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class w implements Parcelable.Creator<StreetViewPanoramaLocation> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        StreetViewPanoramaLink[] streetViewPanoramaLinkArr = null;
        LatLng latLng = null;
        String str = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 2) {
                streetViewPanoramaLinkArr = (StreetViewPanoramaLink[]) SafeParcelReader.c(parcel, a2, StreetViewPanoramaLink.CREATOR);
            } else if (a3 == 3) {
                latLng = (LatLng) SafeParcelReader.a(parcel, a2, LatLng.CREATOR);
            } else if (a3 != 4) {
                SafeParcelReader.r(parcel, a2);
            } else {
                str = SafeParcelReader.l(parcel, a2);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new StreetViewPanoramaLocation(streetViewPanoramaLinkArr, latLng, str);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new StreetViewPanoramaLocation[i2];
    }
}
