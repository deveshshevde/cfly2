package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class af implements Parcelable.Creator<ActivityRecognitionResult> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        long j2 = 0;
        long j3 = 0;
        ArrayList<DetectedActivity> arrayList = null;
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                arrayList = SafeParcelReader.b(parcel, a2, DetectedActivity.CREATOR);
            } else if (a3 == 2) {
                j2 = SafeParcelReader.f(parcel, a2);
            } else if (a3 == 3) {
                j3 = SafeParcelReader.f(parcel, a2);
            } else if (a3 == 4) {
                i2 = SafeParcelReader.d(parcel, a2);
            } else if (a3 != 5) {
                SafeParcelReader.r(parcel, a2);
            } else {
                bundle = SafeParcelReader.g(parcel, a2);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new ActivityRecognitionResult(arrayList, j2, j3, i2, bundle);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new ActivityRecognitionResult[i2];
    }
}
