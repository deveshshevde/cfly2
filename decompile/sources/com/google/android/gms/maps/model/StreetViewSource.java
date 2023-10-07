package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class StreetViewSource extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StreetViewSource> CREATOR = new y();

    /* renamed from: a  reason: collision with root package name */
    public static final StreetViewSource f18290a = new StreetViewSource(0);

    /* renamed from: b  reason: collision with root package name */
    public static final StreetViewSource f18291b = new StreetViewSource(1);

    /* renamed from: c  reason: collision with root package name */
    private static final String f18292c = "StreetViewSource";

    /* renamed from: d  reason: collision with root package name */
    private final int f18293d;

    public StreetViewSource(int i2) {
        this.f18293d = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StreetViewSource) && this.f18293d == ((StreetViewSource) obj).f18293d;
    }

    public final int hashCode() {
        return l.a(Integer.valueOf(this.f18293d));
    }

    public final String toString() {
        String str;
        int i2 = this.f18293d;
        if (i2 == 0) {
            str = "DEFAULT";
        } else if (i2 != 1) {
            str = String.format("UNKNOWN(%s)", new Object[]{Integer.valueOf(i2)});
        } else {
            str = "OUTDOOR";
        }
        return String.format("StreetViewSource:%s", new Object[]{str});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 2, this.f18293d);
        a.a(parcel, a2);
    }
}
