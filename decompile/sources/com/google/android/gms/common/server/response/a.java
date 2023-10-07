package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.server.response.FastJsonResponse;

public final class a implements Parcelable.Creator<FastJsonResponse.Field> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        String str2 = null;
        zaa zaa = null;
        int i2 = 0;
        int i3 = 0;
        boolean z2 = false;
        int i4 = 0;
        boolean z3 = false;
        int i5 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 1:
                    i2 = SafeParcelReader.d(parcel, a2);
                    break;
                case 2:
                    i3 = SafeParcelReader.d(parcel, a2);
                    break;
                case 3:
                    z2 = SafeParcelReader.s(parcel, a2);
                    break;
                case 4:
                    i4 = SafeParcelReader.d(parcel, a2);
                    break;
                case 5:
                    z3 = SafeParcelReader.s(parcel, a2);
                    break;
                case 6:
                    str = SafeParcelReader.l(parcel, a2);
                    break;
                case 7:
                    i5 = SafeParcelReader.d(parcel, a2);
                    break;
                case 8:
                    str2 = SafeParcelReader.l(parcel, a2);
                    break;
                case 9:
                    zaa = (zaa) SafeParcelReader.a(parcel, a2, zaa.CREATOR);
                    break;
                default:
                    SafeParcelReader.r(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new FastJsonResponse.Field(i2, i3, z2, i4, z3, str, i5, str2, zaa);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new FastJsonResponse.Field[i2];
    }
}
