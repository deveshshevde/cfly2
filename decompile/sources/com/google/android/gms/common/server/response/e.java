package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class e implements Parcelable.Creator<SafeParcelResponse> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        Parcel parcel2 = null;
        zan zan = null;
        int i2 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                i2 = SafeParcelReader.d(parcel, a2);
            } else if (a3 == 2) {
                parcel2 = SafeParcelReader.i(parcel, a2);
            } else if (a3 != 3) {
                SafeParcelReader.r(parcel, a2);
            } else {
                zan = (zan) SafeParcelReader.a(parcel, a2, zan.CREATOR);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new SafeParcelResponse(i2, parcel2, zan);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new SafeParcelResponse[i2];
    }
}
