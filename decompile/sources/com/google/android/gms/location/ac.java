package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class ac implements Parcelable.Creator<LocationSettingsStates> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 1:
                    z2 = SafeParcelReader.s(parcel, a2);
                    break;
                case 2:
                    z3 = SafeParcelReader.s(parcel, a2);
                    break;
                case 3:
                    z4 = SafeParcelReader.s(parcel, a2);
                    break;
                case 4:
                    z5 = SafeParcelReader.s(parcel, a2);
                    break;
                case 5:
                    z6 = SafeParcelReader.s(parcel, a2);
                    break;
                case 6:
                    z7 = SafeParcelReader.s(parcel, a2);
                    break;
                default:
                    SafeParcelReader.r(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new LocationSettingsStates(z2, z3, z4, z5, z6, z7);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new LocationSettingsStates[i2];
    }
}
