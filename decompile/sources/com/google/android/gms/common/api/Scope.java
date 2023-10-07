package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new n();

    /* renamed from: a  reason: collision with root package name */
    final int f17372a;

    /* renamed from: b  reason: collision with root package name */
    private final String f17373b;

    Scope(int i2, String str) {
        m.a(str, (Object) "scopeUri must not be null or empty");
        this.f17372a = i2;
        this.f17373b = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public String a() {
        return this.f17373b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f17373b.equals(((Scope) obj).f17373b);
    }

    public int hashCode() {
        return this.f17373b.hashCode();
    }

    public String toString() {
        return this.f17373b;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f17372a);
        a.a(parcel, 2, a(), false);
        a.a(parcel, a2);
    }
}
