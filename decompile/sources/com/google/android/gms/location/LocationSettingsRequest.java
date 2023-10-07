package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.Collections;
import java.util.List;

public final class LocationSettingsRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new aa();

    /* renamed from: a  reason: collision with root package name */
    private final List<LocationRequest> f18075a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f18076b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f18077c;

    /* renamed from: d  reason: collision with root package name */
    private zzay f18078d;

    LocationSettingsRequest(List<LocationRequest> list, boolean z2, boolean z3, zzay zzay) {
        this.f18075a = list;
        this.f18076b = z2;
        this.f18077c = z3;
        this.f18078d = zzay;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.c(parcel, 1, Collections.unmodifiableList(this.f18075a), false);
        a.a(parcel, 2, this.f18076b);
        a.a(parcel, 3, this.f18077c);
        a.a(parcel, 5, (Parcelable) this.f18078d, i2, false);
        a.a(parcel, a2);
    }
}
