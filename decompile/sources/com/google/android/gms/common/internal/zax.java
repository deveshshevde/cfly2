package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class zax extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zax> CREATOR = new ak();

    /* renamed from: a  reason: collision with root package name */
    final int f17875a;

    /* renamed from: b  reason: collision with root package name */
    private final int f17876b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17877c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    private final Scope[] f17878d;

    zax(int i2, int i3, int i4, Scope[] scopeArr) {
        this.f17875a = i2;
        this.f17876b = i3;
        this.f17877c = i4;
        this.f17878d = scopeArr;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f17875a);
        a.a(parcel, 2, this.f17876b);
        a.a(parcel, 3, this.f17877c);
        a.a(parcel, 4, (T[]) this.f17878d, i2, false);
        a.a(parcel, a2);
    }
}
