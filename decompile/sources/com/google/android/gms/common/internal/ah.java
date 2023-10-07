package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class ah implements Parcelable.Creator<MethodInvocation> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        String str2 = null;
        long j2 = 0;
        long j3 = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = -1;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 1:
                    i2 = SafeParcelReader.d(parcel2, a2);
                    break;
                case 2:
                    i3 = SafeParcelReader.d(parcel2, a2);
                    break;
                case 3:
                    i4 = SafeParcelReader.d(parcel2, a2);
                    break;
                case 4:
                    j2 = SafeParcelReader.f(parcel2, a2);
                    break;
                case 5:
                    j3 = SafeParcelReader.f(parcel2, a2);
                    break;
                case 6:
                    str = SafeParcelReader.l(parcel2, a2);
                    break;
                case 7:
                    str2 = SafeParcelReader.l(parcel2, a2);
                    break;
                case 8:
                    i5 = SafeParcelReader.d(parcel2, a2);
                    break;
                case 9:
                    i6 = SafeParcelReader.d(parcel2, a2);
                    break;
                default:
                    SafeParcelReader.r(parcel2, a2);
                    break;
            }
        }
        SafeParcelReader.q(parcel2, b2);
        return new MethodInvocation(i2, i3, i4, j2, j3, str, str2, i5, i6);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new MethodInvocation[i2];
    }
}
