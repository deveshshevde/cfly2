package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class v implements Parcelable.Creator<StreetViewPanoramaLink> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        float f2 = 0.0f;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 2) {
                str = SafeParcelReader.l(parcel, a2);
            } else if (a3 != 3) {
                SafeParcelReader.r(parcel, a2);
            } else {
                f2 = SafeParcelReader.c(parcel, a2);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new StreetViewPanoramaLink(str, f2);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new StreetViewPanoramaLink[i2];
    }
}
