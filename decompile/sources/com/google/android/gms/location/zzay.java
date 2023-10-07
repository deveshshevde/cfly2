package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;

@Deprecated
public final class zzay extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzay> CREATOR = new z();

    /* renamed from: a  reason: collision with root package name */
    private final String f18106a;

    /* renamed from: b  reason: collision with root package name */
    private final String f18107b;

    /* renamed from: c  reason: collision with root package name */
    private final String f18108c;

    zzay(String str, String str2, String str3) {
        this.f18108c = str;
        this.f18106a = str2;
        this.f18107b = str3;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f18106a, false);
        a.a(parcel, 2, this.f18107b, false);
        a.a(parcel, 5, this.f18108c, false);
        a.a(parcel, a2);
    }
}
