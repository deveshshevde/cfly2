package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class Tile extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Tile> CREATOR = new z();

    /* renamed from: a  reason: collision with root package name */
    public final int f18294a;

    /* renamed from: b  reason: collision with root package name */
    public final int f18295b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f18296c;

    public Tile(int i2, int i3, byte[] bArr) {
        this.f18294a = i2;
        this.f18295b = i3;
        this.f18296c = bArr;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 2, this.f18294a);
        a.a(parcel, 3, this.f18295b);
        a.a(parcel, 4, this.f18296c, false);
        a.a(parcel, a2);
    }
}
