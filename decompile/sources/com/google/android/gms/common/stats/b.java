package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class b implements Parcelable.Creator<WakeLockEvent> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b2 = SafeParcelReader.b(parcel);
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        String str = null;
        ArrayList<String> arrayList = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        float f2 = 0.0f;
        boolean z2 = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 1:
                    i2 = SafeParcelReader.d(parcel2, a2);
                    break;
                case 2:
                    j2 = SafeParcelReader.f(parcel2, a2);
                    break;
                case 4:
                    str = SafeParcelReader.l(parcel2, a2);
                    break;
                case 5:
                    i4 = SafeParcelReader.d(parcel2, a2);
                    break;
                case 6:
                    arrayList = SafeParcelReader.o(parcel2, a2);
                    break;
                case 8:
                    j3 = SafeParcelReader.f(parcel2, a2);
                    break;
                case 10:
                    str3 = SafeParcelReader.l(parcel2, a2);
                    break;
                case 11:
                    i3 = SafeParcelReader.d(parcel2, a2);
                    break;
                case 12:
                    str2 = SafeParcelReader.l(parcel2, a2);
                    break;
                case 13:
                    str4 = SafeParcelReader.l(parcel2, a2);
                    break;
                case 14:
                    i5 = SafeParcelReader.d(parcel2, a2);
                    break;
                case 15:
                    f2 = SafeParcelReader.c(parcel2, a2);
                    break;
                case 16:
                    j4 = SafeParcelReader.f(parcel2, a2);
                    break;
                case 17:
                    str5 = SafeParcelReader.l(parcel2, a2);
                    break;
                case 18:
                    z2 = SafeParcelReader.s(parcel2, a2);
                    break;
                default:
                    SafeParcelReader.r(parcel2, a2);
                    break;
            }
        }
        SafeParcelReader.q(parcel2, b2);
        return new WakeLockEvent(i2, j2, i3, str, i4, arrayList, str2, j3, i5, str3, str4, f2, j4, str5, z2);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new WakeLockEvent[i2];
    }
}
