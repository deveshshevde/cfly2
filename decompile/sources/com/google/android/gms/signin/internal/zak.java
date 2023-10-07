package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.zav;

public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new i();

    /* renamed from: a  reason: collision with root package name */
    final int f18338a;

    /* renamed from: b  reason: collision with root package name */
    private final ConnectionResult f18339b;

    /* renamed from: c  reason: collision with root package name */
    private final zav f18340c;

    zak(int i2, ConnectionResult connectionResult, zav zav) {
        this.f18338a = i2;
        this.f18339b = connectionResult;
        this.f18340c = zav;
    }

    public final ConnectionResult a() {
        return this.f18339b;
    }

    public final zav b() {
        return this.f18340c;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f18338a);
        a.a(parcel, 2, (Parcelable) this.f18339b, i2, false);
        a.a(parcel, 3, (Parcelable) this.f18340c, i2, false);
        a.a(parcel, a2);
    }
}
