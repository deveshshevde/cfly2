package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;

public final class zzn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzn> CREATOR = new v();

    /* renamed from: a  reason: collision with root package name */
    private final String f17974a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f17975b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f17976c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f17977d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f17978e;

    zzn(String str, boolean z2, boolean z3, IBinder iBinder, boolean z4) {
        this.f17974a = str;
        this.f17975b = z2;
        this.f17976c = z3;
        this.f17977d = (Context) d.a(b.a.a(iBinder));
        this.f17978e = z4;
    }

    /* JADX WARNING: type inference failed for: r0v4, types: [com.google.android.gms.dynamic.b, android.os.IBinder] */
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f17974a, false);
        a.a(parcel, 2, this.f17975b);
        a.a(parcel, 3, this.f17976c);
        a.a(parcel, 4, (IBinder) d.a(this.f17977d), false);
        a.a(parcel, 5, this.f17978e);
        a.a(parcel, a2);
    }
}
