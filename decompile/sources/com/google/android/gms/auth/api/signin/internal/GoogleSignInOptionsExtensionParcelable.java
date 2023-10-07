package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    final int f17344a;

    /* renamed from: b  reason: collision with root package name */
    private int f17345b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f17346c;

    GoogleSignInOptionsExtensionParcelable(int i2, int i3, Bundle bundle) {
        this.f17344a = i2;
        this.f17345b = i3;
        this.f17346c = bundle;
    }

    public int a() {
        return this.f17345b;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f17344a);
        a.a(parcel, 2, a());
        a.a(parcel, 3, this.f17346c, false);
        a.a(parcel, a2);
    }
}
