package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class w implements Parcelable.Creator<LocationRequest> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b2 = SafeParcelReader.b(parcel);
        long j2 = 3600000;
        long j3 = 600000;
        long j4 = Long.MAX_VALUE;
        long j5 = 0;
        int i2 = 102;
        boolean z2 = false;
        int i3 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        float f2 = 0.0f;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 1:
                    i2 = SafeParcelReader.d(parcel2, a2);
                    break;
                case 2:
                    j2 = SafeParcelReader.f(parcel2, a2);
                    break;
                case 3:
                    j3 = SafeParcelReader.f(parcel2, a2);
                    break;
                case 4:
                    z2 = SafeParcelReader.s(parcel2, a2);
                    break;
                case 5:
                    j4 = SafeParcelReader.f(parcel2, a2);
                    break;
                case 6:
                    i3 = SafeParcelReader.d(parcel2, a2);
                    break;
                case 7:
                    f2 = SafeParcelReader.c(parcel2, a2);
                    break;
                case 8:
                    j5 = SafeParcelReader.f(parcel2, a2);
                    break;
                default:
                    SafeParcelReader.r(parcel2, a2);
                    break;
            }
        }
        SafeParcelReader.q(parcel2, b2);
        return new LocationRequest(i2, j2, j3, z2, j4, i3, f2, j5);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new LocationRequest[i2];
    }
}
