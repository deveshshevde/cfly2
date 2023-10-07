package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
import java.util.List;

public final class s implements Parcelable.Creator<PolygonOptions> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        ArrayList arrayList = new ArrayList();
        ArrayList<LatLng> arrayList2 = null;
        ArrayList<PatternItem> arrayList3 = null;
        float f2 = 0.0f;
        int i2 = 0;
        int i3 = 0;
        float f3 = 0.0f;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        int i4 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 2:
                    arrayList2 = SafeParcelReader.b(parcel, a2, LatLng.CREATOR);
                    break;
                case 3:
                    SafeParcelReader.a(parcel, a2, (List) arrayList, getClass().getClassLoader());
                    break;
                case 4:
                    f2 = SafeParcelReader.c(parcel, a2);
                    break;
                case 5:
                    i2 = SafeParcelReader.d(parcel, a2);
                    break;
                case 6:
                    i3 = SafeParcelReader.d(parcel, a2);
                    break;
                case 7:
                    f3 = SafeParcelReader.c(parcel, a2);
                    break;
                case 8:
                    z2 = SafeParcelReader.s(parcel, a2);
                    break;
                case 9:
                    z3 = SafeParcelReader.s(parcel, a2);
                    break;
                case 10:
                    z4 = SafeParcelReader.s(parcel, a2);
                    break;
                case 11:
                    i4 = SafeParcelReader.d(parcel, a2);
                    break;
                case 12:
                    arrayList3 = SafeParcelReader.b(parcel, a2, PatternItem.CREATOR);
                    break;
                default:
                    SafeParcelReader.r(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new PolygonOptions(arrayList2, arrayList, f2, i2, i3, f3, z2, z3, z4, i4, arrayList3);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new PolygonOptions[i2];
    }
}
