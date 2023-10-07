package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class d implements Parcelable.Creator<DataHolder> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String[] strArr = null;
        CursorWindow[] cursorWindowArr = null;
        Bundle bundle = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                strArr = SafeParcelReader.z(parcel, a2);
            } else if (a3 == 2) {
                cursorWindowArr = (CursorWindow[]) SafeParcelReader.c(parcel, a2, CursorWindow.CREATOR);
            } else if (a3 == 3) {
                i3 = SafeParcelReader.d(parcel, a2);
            } else if (a3 == 4) {
                bundle = SafeParcelReader.g(parcel, a2);
            } else if (a3 != 1000) {
                SafeParcelReader.r(parcel, a2);
            } else {
                i2 = SafeParcelReader.d(parcel, a2);
            }
        }
        SafeParcelReader.q(parcel, b2);
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i3, bundle);
        dataHolder.d();
        return dataHolder;
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new DataHolder[i2];
    }
}
