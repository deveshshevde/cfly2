package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new bd();

    /* renamed from: a  reason: collision with root package name */
    final int f17745a;

    /* renamed from: b  reason: collision with root package name */
    final int f17746b;

    /* renamed from: c  reason: collision with root package name */
    int f17747c;

    /* renamed from: d  reason: collision with root package name */
    String f17748d;

    /* renamed from: e  reason: collision with root package name */
    IBinder f17749e;

    /* renamed from: f  reason: collision with root package name */
    Scope[] f17750f;

    /* renamed from: g  reason: collision with root package name */
    Bundle f17751g;

    /* renamed from: h  reason: collision with root package name */
    Account f17752h;

    /* renamed from: i  reason: collision with root package name */
    Feature[] f17753i;

    /* renamed from: j  reason: collision with root package name */
    Feature[] f17754j;

    /* renamed from: k  reason: collision with root package name */
    boolean f17755k;

    /* renamed from: l  reason: collision with root package name */
    int f17756l;

    /* renamed from: m  reason: collision with root package name */
    boolean f17757m;

    /* renamed from: n  reason: collision with root package name */
    private String f17758n;

    GetServiceRequest(int i2, int i3, int i4, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, Feature[] featureArr, Feature[] featureArr2, boolean z2, int i5, boolean z3, String str2) {
        this.f17745a = i2;
        this.f17746b = i3;
        this.f17747c = i4;
        if ("com.google.android.gms".equals(str)) {
            this.f17748d = "com.google.android.gms";
        } else {
            this.f17748d = str;
        }
        if (i2 < 2) {
            this.f17752h = iBinder != null ? a.a(h.a.a(iBinder)) : null;
        } else {
            this.f17749e = iBinder;
            this.f17752h = account;
        }
        this.f17750f = scopeArr;
        this.f17751g = bundle;
        this.f17753i = featureArr;
        this.f17754j = featureArr2;
        this.f17755k = z2;
        this.f17756l = i5;
        this.f17757m = z3;
        this.f17758n = str2;
    }

    public GetServiceRequest(int i2, String str) {
        this.f17745a = 6;
        this.f17747c = d.f17673b;
        this.f17746b = i2;
        this.f17755k = true;
        this.f17758n = str;
    }

    public final String a() {
        return this.f17758n;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        bd.a(this, parcel, i2);
    }
}
