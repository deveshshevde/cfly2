package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class zzbd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbd> CREATOR = new ad();

    /* renamed from: a  reason: collision with root package name */
    private final int f18109a;

    /* renamed from: b  reason: collision with root package name */
    private final int f18110b;

    /* renamed from: c  reason: collision with root package name */
    private final long f18111c;

    /* renamed from: d  reason: collision with root package name */
    private final long f18112d;

    zzbd(int i2, int i3, long j2, long j3) {
        this.f18109a = i2;
        this.f18110b = i3;
        this.f18111c = j2;
        this.f18112d = j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzbd zzbd = (zzbd) obj;
            return this.f18109a == zzbd.f18109a && this.f18110b == zzbd.f18110b && this.f18111c == zzbd.f18111c && this.f18112d == zzbd.f18112d;
        }
    }

    public final int hashCode() {
        return l.a(Integer.valueOf(this.f18110b), Integer.valueOf(this.f18109a), Long.valueOf(this.f18112d), Long.valueOf(this.f18111c));
    }

    public final String toString() {
        return "NetworkLocationStatus:" + " Wifi status: " + this.f18109a + " Cell status: " + this.f18110b + " elapsed time NS: " + this.f18112d + " system time ms: " + this.f18111c;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f18109a);
        a.a(parcel, 2, this.f18110b);
        a.a(parcel, 3, this.f18111c);
        a.a(parcel, 4, this.f18112d);
        a.a(parcel, a2);
    }
}
