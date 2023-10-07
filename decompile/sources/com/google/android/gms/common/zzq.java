package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new x();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f17979a;

    /* renamed from: b  reason: collision with root package name */
    private final String f17980b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17981c;

    zzq(boolean z2, String str, int i2) {
        this.f17979a = z2;
        this.f17980b = str;
        this.f17981c = w.a(i2) - 1;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f17979a);
        a.a(parcel, 2, this.f17980b, false);
        a.a(parcel, 3, this.f17981c);
        a.a(parcel, a2);
    }
}
