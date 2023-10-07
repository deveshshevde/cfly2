package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class ah implements Parcelable.Creator<ActivityTransitionEvent> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        int i2 = 0;
        long j2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                i2 = SafeParcelReader.d(parcel, a2);
            } else if (a3 == 2) {
                i3 = SafeParcelReader.d(parcel, a2);
            } else if (a3 != 3) {
                SafeParcelReader.r(parcel, a2);
            } else {
                j2 = SafeParcelReader.f(parcel, a2);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new ActivityTransitionEvent(i2, i3, j2);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new ActivityTransitionEvent[i2];
    }
}
