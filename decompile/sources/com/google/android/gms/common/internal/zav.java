package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class zav extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zav> CREATOR = new aj();

    /* renamed from: a  reason: collision with root package name */
    final int f17870a;

    /* renamed from: b  reason: collision with root package name */
    final IBinder f17871b;

    /* renamed from: c  reason: collision with root package name */
    private final ConnectionResult f17872c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f17873d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f17874e;

    zav(int i2, IBinder iBinder, ConnectionResult connectionResult, boolean z2, boolean z3) {
        this.f17870a = i2;
        this.f17871b = iBinder;
        this.f17872c = connectionResult;
        this.f17873d = z2;
        this.f17874e = z3;
    }

    public final ConnectionResult a() {
        return this.f17872c;
    }

    public final h b() {
        IBinder iBinder = this.f17871b;
        if (iBinder == null) {
            return null;
        }
        return h.a.a(iBinder);
    }

    public final boolean c() {
        return this.f17873d;
    }

    public final boolean d() {
        return this.f17874e;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zav)) {
            return false;
        }
        zav zav = (zav) obj;
        return this.f17872c.equals(zav.f17872c) && l.a(b(), zav.b());
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f17870a);
        a.a(parcel, 2, this.f17871b, false);
        a.a(parcel, 3, (Parcelable) this.f17872c, i2, false);
        a.a(parcel, 4, this.f17873d);
        a.a(parcel, 5, this.f17874e);
        a.a(parcel, a2);
    }
}
