package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.location.zzbg;
import java.util.ArrayList;

public final class m implements Parcelable.Creator<GeofencingRequest> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        ArrayList<zzbg> arrayList = null;
        int i2 = 0;
        String str = "";
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                arrayList = SafeParcelReader.b(parcel, a2, zzbg.CREATOR);
            } else if (a3 == 2) {
                i2 = SafeParcelReader.d(parcel, a2);
            } else if (a3 != 3) {
                SafeParcelReader.r(parcel, a2);
            } else {
                str = SafeParcelReader.l(parcel, a2);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new GeofencingRequest(arrayList, i2, str);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new GeofencingRequest[i2];
    }
}
