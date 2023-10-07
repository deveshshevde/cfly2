package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.Collections;
import java.util.List;

public final class zzbe extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbe> CREATOR = new ae();

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f18113a;

    /* renamed from: b  reason: collision with root package name */
    private final PendingIntent f18114b;

    /* renamed from: c  reason: collision with root package name */
    private final String f18115c;

    zzbe(List<String> list, PendingIntent pendingIntent, String str) {
        this.f18113a = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.f18114b = pendingIntent;
        this.f18115c = str;
    }

    public static zzbe a(PendingIntent pendingIntent) {
        m.a(pendingIntent, (Object) "PendingIntent can not be null.");
        return new zzbe((List<String>) null, pendingIntent, "");
    }

    public static zzbe a(List<String> list) {
        m.a(list, (Object) "geofence can't be null.");
        m.a(!list.isEmpty(), (Object) "Geofences must contains at least one id.");
        return new zzbe(list, (PendingIntent) null, "");
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.b(parcel, 1, this.f18113a, false);
        a.a(parcel, 2, (Parcelable) this.f18114b, i2, false);
        a.a(parcel, 3, this.f18115c, false);
        a.a(parcel, a2);
    }
}
