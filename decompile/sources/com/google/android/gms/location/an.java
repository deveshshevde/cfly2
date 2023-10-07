package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class an implements Parcelable.Creator<zzo> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b2 = SafeParcelReader.b(parcel);
        long j2 = 50;
        long j3 = Long.MAX_VALUE;
        boolean z2 = true;
        float f2 = 0.0f;
        int i2 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                z2 = SafeParcelReader.s(parcel2, a2);
            } else if (a3 == 2) {
                j2 = SafeParcelReader.f(parcel2, a2);
            } else if (a3 == 3) {
                f2 = SafeParcelReader.c(parcel2, a2);
            } else if (a3 == 4) {
                j3 = SafeParcelReader.f(parcel2, a2);
            } else if (a3 != 5) {
                SafeParcelReader.r(parcel2, a2);
            } else {
                i2 = SafeParcelReader.d(parcel2, a2);
            }
        }
        SafeParcelReader.q(parcel2, b2);
        return new zzo(z2, j2, f2, j3, i2);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzo[i2];
    }
}
