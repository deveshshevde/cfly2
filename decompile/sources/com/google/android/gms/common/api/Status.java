package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class Status extends AbstractSafeParcelable implements g, ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR = new o();

    /* renamed from: a  reason: collision with root package name */
    public static final Status f17374a = new Status(0);

    /* renamed from: b  reason: collision with root package name */
    public static final Status f17375b = new Status(14);

    /* renamed from: c  reason: collision with root package name */
    public static final Status f17376c = new Status(8);

    /* renamed from: d  reason: collision with root package name */
    public static final Status f17377d = new Status(15);

    /* renamed from: e  reason: collision with root package name */
    public static final Status f17378e = new Status(16);

    /* renamed from: f  reason: collision with root package name */
    public static final Status f17379f = new Status(18);

    /* renamed from: g  reason: collision with root package name */
    public static final Status f17380g = new Status(17);

    /* renamed from: h  reason: collision with root package name */
    final int f17381h;

    /* renamed from: i  reason: collision with root package name */
    private final int f17382i;

    /* renamed from: j  reason: collision with root package name */
    private final String f17383j;

    /* renamed from: k  reason: collision with root package name */
    private final PendingIntent f17384k;

    /* renamed from: l  reason: collision with root package name */
    private final ConnectionResult f17385l;

    public Status(int i2) {
        this(i2, (String) null);
    }

    Status(int i2, int i3, String str, PendingIntent pendingIntent) {
        this(i2, i3, str, pendingIntent, (ConnectionResult) null);
    }

    Status(int i2, int i3, String str, PendingIntent pendingIntent, ConnectionResult connectionResult) {
        this.f17381h = i2;
        this.f17382i = i3;
        this.f17383j = str;
        this.f17384k = pendingIntent;
        this.f17385l = connectionResult;
    }

    public Status(int i2, String str) {
        this(1, i2, str, (PendingIntent) null);
    }

    public Status(int i2, String str, PendingIntent pendingIntent) {
        this(1, i2, str, pendingIntent);
    }

    public Status(ConnectionResult connectionResult, String str) {
        this(connectionResult, str, 17);
    }

    @Deprecated
    public Status(ConnectionResult connectionResult, String str, int i2) {
        this(1, i2, str, connectionResult.b(), connectionResult);
    }

    public int a() {
        return this.f17382i;
    }

    public ConnectionResult b() {
        return this.f17385l;
    }

    public String c() {
        return this.f17383j;
    }

    public boolean d() {
        return this.f17384k != null;
    }

    public boolean e() {
        return this.f17382i <= 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f17381h == status.f17381h && this.f17382i == status.f17382i && l.a(this.f17383j, status.f17383j) && l.a(this.f17384k, status.f17384k) && l.a(this.f17385l, status.f17385l);
    }

    public final String f() {
        String str = this.f17383j;
        return str != null ? str : b.a(this.f17382i);
    }

    public Status getStatus() {
        return this;
    }

    public int hashCode() {
        return l.a(Integer.valueOf(this.f17381h), Integer.valueOf(this.f17382i), this.f17383j, this.f17384k, this.f17385l);
    }

    public String toString() {
        l.a a2 = l.a((Object) this);
        a2.a("statusCode", f());
        a2.a("resolution", this.f17384k);
        return a2.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, a());
        a.a(parcel, 2, c(), false);
        a.a(parcel, 3, (Parcelable) this.f17384k, i2, false);
        a.a(parcel, 4, (Parcelable) b(), i2, false);
        a.a(parcel, 1000, this.f17381h);
        a.a(parcel, a2);
    }
}
