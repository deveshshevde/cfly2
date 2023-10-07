package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class zzac extends AbstractSafeParcelable implements g {
    public static final Parcelable.Creator<zzac> CREATOR = new zzab();
    private static final zzac zza = new zzac(Status.f17374a);
    private final Status zzb;

    public zzac(Status status) {
        this.zzb = status;
    }

    public final Status getStatus() {
        return this.zzb;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, (Parcelable) getStatus(), i2, false);
        a.a(parcel, a2);
    }
}
