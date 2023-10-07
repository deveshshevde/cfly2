package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class g implements Parcelable.Creator<zag> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        ArrayList<String> arrayList = null;
        String str = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                arrayList = SafeParcelReader.o(parcel, a2);
            } else if (a3 != 2) {
                SafeParcelReader.r(parcel, a2);
            } else {
                str = SafeParcelReader.l(parcel, a2);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new zag(arrayList, str);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zag[i2];
    }
}
