package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class zac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zac> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    final int f17896a;

    /* renamed from: b  reason: collision with root package name */
    final String f17897b;

    /* renamed from: c  reason: collision with root package name */
    final int f17898c;

    zac(int i2, String str, int i3) {
        this.f17896a = i2;
        this.f17897b = str;
        this.f17898c = i3;
    }

    zac(String str, int i2) {
        this.f17896a = 1;
        this.f17897b = str;
        this.f17898c = i2;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f17896a);
        a.a(parcel, 2, this.f17897b, false);
        a.a(parcel, 3, this.f17898c);
        a.a(parcel, a2);
    }
}
