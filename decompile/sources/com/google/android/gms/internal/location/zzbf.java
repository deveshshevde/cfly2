package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzbf implements Parcelable.Creator<zzbg> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b2 = SafeParcelReader.b(parcel);
        double d2 = 0.0d;
        double d3 = 0.0d;
        String str = null;
        long j2 = 0;
        int i2 = 0;
        short s2 = 0;
        float f2 = 0.0f;
        int i3 = 0;
        int i4 = -1;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 1:
                    str = SafeParcelReader.l(parcel2, a2);
                    break;
                case 2:
                    j2 = SafeParcelReader.f(parcel2, a2);
                    break;
                case 3:
                    s2 = SafeParcelReader.p(parcel2, a2);
                    break;
                case 4:
                    d2 = SafeParcelReader.b(parcel2, a2);
                    break;
                case 5:
                    d3 = SafeParcelReader.b(parcel2, a2);
                    break;
                case 6:
                    f2 = SafeParcelReader.c(parcel2, a2);
                    break;
                case 7:
                    i2 = SafeParcelReader.d(parcel2, a2);
                    break;
                case 8:
                    i3 = SafeParcelReader.d(parcel2, a2);
                    break;
                case 9:
                    i4 = SafeParcelReader.d(parcel2, a2);
                    break;
                default:
                    SafeParcelReader.r(parcel2, a2);
                    break;
            }
        }
        SafeParcelReader.q(parcel2, b2);
        return new zzbg(str, i2, s2, d2, d3, f2, j2, i3, i4);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzbg[i2];
    }
}
