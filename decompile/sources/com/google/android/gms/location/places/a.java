package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class a implements Parcelable.Creator<PlaceReport> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                i2 = SafeParcelReader.d(parcel, a2);
            } else if (a3 == 2) {
                str = SafeParcelReader.l(parcel, a2);
            } else if (a3 == 3) {
                str2 = SafeParcelReader.l(parcel, a2);
            } else if (a3 != 4) {
                SafeParcelReader.r(parcel, a2);
            } else {
                str3 = SafeParcelReader.l(parcel, a2);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new PlaceReport(i2, str, str2, str3);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new PlaceReport[i2];
    }
}
