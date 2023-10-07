package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class zaa extends AbstractSafeParcelable implements g {
    public static final Parcelable.Creator<zaa> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    final int f18331a;

    /* renamed from: b  reason: collision with root package name */
    private int f18332b;

    /* renamed from: c  reason: collision with root package name */
    private Intent f18333c;

    public zaa() {
        this(2, 0, (Intent) null);
    }

    zaa(int i2, int i3, Intent intent) {
        this.f18331a = i2;
        this.f18332b = i3;
        this.f18333c = intent;
    }

    public final Status getStatus() {
        return this.f18332b == 0 ? Status.f17374a : Status.f17378e;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f18331a);
        a.a(parcel, 2, this.f18332b);
        a.a(parcel, 3, (Parcelable) this.f18333c, i2, false);
        a.a(parcel, a2);
    }
}
