package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class b implements Parcelable.Creator<StringToIntConverter> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        int i2 = 0;
        ArrayList<zac> arrayList = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                i2 = SafeParcelReader.d(parcel, a2);
            } else if (a3 != 2) {
                SafeParcelReader.r(parcel, a2);
            } else {
                arrayList = SafeParcelReader.b(parcel, a2, zac.CREATOR);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new StringToIntConverter(i2, arrayList);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new StringToIntConverter[i2];
    }
}
