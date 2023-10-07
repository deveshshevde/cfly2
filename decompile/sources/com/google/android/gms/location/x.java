package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class x implements Parcelable.Creator<LocationResult> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        List<Location> list = LocationResult.f18073a;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            if (SafeParcelReader.a(a2) != 1) {
                SafeParcelReader.r(parcel, a2);
            } else {
                list = SafeParcelReader.b(parcel, a2, Location.CREATOR);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new LocationResult(list);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new LocationResult[i2];
    }
}
