package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class zat extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zat> CREATOR = new ai();

    /* renamed from: a  reason: collision with root package name */
    final int f17866a;

    /* renamed from: b  reason: collision with root package name */
    private final Account f17867b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17868c;

    /* renamed from: d  reason: collision with root package name */
    private final GoogleSignInAccount f17869d;

    zat(int i2, Account account, int i3, GoogleSignInAccount googleSignInAccount) {
        this.f17866a = i2;
        this.f17867b = account;
        this.f17868c = i3;
        this.f17869d = googleSignInAccount;
    }

    public zat(Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i2, googleSignInAccount);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f17866a);
        a.a(parcel, 2, (Parcelable) this.f17867b, i2, false);
        a.a(parcel, 3, this.f17868c);
        a.a(parcel, 4, (Parcelable) this.f17869d, i2, false);
        a.a(parcel, a2);
    }
}
