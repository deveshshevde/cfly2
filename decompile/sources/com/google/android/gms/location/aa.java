package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class aa implements Parcelable.Creator<LocationSettingsRequest> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        boolean z2 = false;
        ArrayList<LocationRequest> arrayList = null;
        zzay zzay = null;
        boolean z3 = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                arrayList = SafeParcelReader.b(parcel, a2, LocationRequest.CREATOR);
            } else if (a3 == 2) {
                z2 = SafeParcelReader.s(parcel, a2);
            } else if (a3 == 3) {
                z3 = SafeParcelReader.s(parcel, a2);
            } else if (a3 != 5) {
                SafeParcelReader.r(parcel, a2);
            } else {
                zzay = (zzay) SafeParcelReader.a(parcel, a2, zzay.CREATOR);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new LocationSettingsRequest(arrayList, z2, z3, zzay);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new LocationSettingsRequest[i2];
    }
}
