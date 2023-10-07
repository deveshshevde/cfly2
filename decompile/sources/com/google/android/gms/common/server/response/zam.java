package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.server.response.FastJsonResponse;

public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    final int f17920a;

    /* renamed from: b  reason: collision with root package name */
    final String f17921b;

    /* renamed from: c  reason: collision with root package name */
    final FastJsonResponse.Field<?, ?> f17922c;

    zam(int i2, String str, FastJsonResponse.Field<?, ?> field) {
        this.f17920a = i2;
        this.f17921b = str;
        this.f17922c = field;
    }

    zam(String str, FastJsonResponse.Field<?, ?> field) {
        this.f17920a = 1;
        this.f17921b = str;
        this.f17922c = field;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f17920a);
        a.a(parcel, 2, this.f17921b, false);
        a.a(parcel, 3, (Parcelable) this.f17922c, i2, false);
        a.a(parcel, a2);
    }
}
