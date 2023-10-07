package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public class FavaDiagnosticsEntity extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final int f17888a;

    /* renamed from: b  reason: collision with root package name */
    public final String f17889b;

    /* renamed from: c  reason: collision with root package name */
    public final int f17890c;

    public FavaDiagnosticsEntity(int i2, String str, int i3) {
        this.f17888a = i2;
        this.f17889b = str;
        this.f17890c = i3;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f17888a);
        a.a(parcel, 2, this.f17889b, false);
        a.a(parcel, 3, this.f17890c);
        a.a(parcel, a2);
    }
}
