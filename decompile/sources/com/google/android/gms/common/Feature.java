package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new k();

    /* renamed from: a  reason: collision with root package name */
    private final String f17358a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    private final int f17359b;

    /* renamed from: c  reason: collision with root package name */
    private final long f17360c;

    public Feature(String str, int i2, long j2) {
        this.f17358a = str;
        this.f17359b = i2;
        this.f17360c = j2;
    }

    public Feature(String str, long j2) {
        this.f17358a = str;
        this.f17360c = j2;
        this.f17359b = -1;
    }

    public long a() {
        long j2 = this.f17360c;
        return j2 == -1 ? (long) this.f17359b : j2;
    }

    public String b() {
        return this.f17358a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            return ((b() != null && b().equals(feature.b())) || (b() == null && feature.b() == null)) && a() == feature.a();
        }
    }

    public final int hashCode() {
        return l.a(b(), Long.valueOf(a()));
    }

    public final String toString() {
        l.a a2 = l.a((Object) this);
        a2.a("name", b());
        a2.a("version", Long.valueOf(a()));
        return a2.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, b(), false);
        a.a(parcel, 2, this.f17359b);
        a.a(parcel, 3, a());
        a.a(parcel, a2);
    }
}
