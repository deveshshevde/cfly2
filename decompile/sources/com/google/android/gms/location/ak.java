package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class ak implements Parcelable.Creator<ActivityTransitionResult> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        ArrayList<ActivityTransitionEvent> arrayList = null;
        Bundle bundle = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                arrayList = SafeParcelReader.b(parcel, a2, ActivityTransitionEvent.CREATOR);
            } else if (a3 != 2) {
                SafeParcelReader.r(parcel, a2);
            } else {
                bundle = SafeParcelReader.g(parcel, a2);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new ActivityTransitionResult(arrayList, bundle);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new ActivityTransitionResult[i2];
    }
}
