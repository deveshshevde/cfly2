package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.List;

public final class zag extends AbstractSafeParcelable implements g {
    public static final Parcelable.Creator<zag> CREATOR = new g();

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f18334a;

    /* renamed from: b  reason: collision with root package name */
    private final String f18335b;

    public zag(List<String> list, String str) {
        this.f18334a = list;
        this.f18335b = str;
    }

    public final Status getStatus() {
        return this.f18335b != null ? Status.f17374a : Status.f17378e;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.b(parcel, 1, this.f18334a, false);
        a.a(parcel, 2, this.f18335b, false);
        a.a(parcel, a2);
    }
}
