package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.Arrays;

public final class LocationAvailability extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationAvailability> CREATOR = new v();
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    private int f18060a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    private int f18061b;

    /* renamed from: c  reason: collision with root package name */
    private long f18062c;

    /* renamed from: d  reason: collision with root package name */
    private int f18063d;

    /* renamed from: e  reason: collision with root package name */
    private zzbd[] f18064e;

    LocationAvailability(int i2, int i3, int i4, long j2, zzbd[] zzbdArr) {
        this.f18063d = i2;
        this.f18060a = i3;
        this.f18061b = i4;
        this.f18062c = j2;
        this.f18064e = zzbdArr;
    }

    public final boolean a() {
        return this.f18063d < 1000;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            LocationAvailability locationAvailability = (LocationAvailability) obj;
            return this.f18060a == locationAvailability.f18060a && this.f18061b == locationAvailability.f18061b && this.f18062c == locationAvailability.f18062c && this.f18063d == locationAvailability.f18063d && Arrays.equals(this.f18064e, locationAvailability.f18064e);
        }
    }

    public final int hashCode() {
        return l.a(Integer.valueOf(this.f18063d), Integer.valueOf(this.f18060a), Integer.valueOf(this.f18061b), Long.valueOf(this.f18062c), this.f18064e);
    }

    public final String toString() {
        boolean a2 = a();
        StringBuilder sb = new StringBuilder(48);
        sb.append("LocationAvailability[isLocationAvailable: ");
        sb.append(a2);
        sb.append("]");
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f18060a);
        a.a(parcel, 2, this.f18061b);
        a.a(parcel, 3, this.f18062c);
        a.a(parcel, 4, this.f18063d);
        a.a(parcel, 5, (T[]) this.f18064e, i2, false);
        a.a(parcel, a2);
    }
}
