package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class aj implements Parcelable.Creator<ActivityTransitionRequest> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        ArrayList<ActivityTransition> arrayList = null;
        String str = null;
        ArrayList<ClientIdentity> arrayList2 = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                arrayList = SafeParcelReader.b(parcel, a2, ActivityTransition.CREATOR);
            } else if (a3 == 2) {
                str = SafeParcelReader.l(parcel, a2);
            } else if (a3 != 3) {
                SafeParcelReader.r(parcel, a2);
            } else {
                arrayList2 = SafeParcelReader.b(parcel, a2, ClientIdentity.CREATOR);
            }
        }
        SafeParcelReader.q(parcel, b2);
        return new ActivityTransitionRequest(arrayList, str, arrayList2);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new ActivityTransitionRequest[i2];
    }
}
