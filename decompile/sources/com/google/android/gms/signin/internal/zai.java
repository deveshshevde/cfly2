package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.zat;

public final class zai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zai> CREATOR = new h();

    /* renamed from: a  reason: collision with root package name */
    final int f18336a;

    /* renamed from: b  reason: collision with root package name */
    final zat f18337b;

    zai(int i2, zat zat) {
        this.f18336a = i2;
        this.f18337b = zat;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f18336a);
        a.a(parcel, 2, (Parcelable) this.f18337b, i2, false);
        a.a(parcel, a2);
    }
}
