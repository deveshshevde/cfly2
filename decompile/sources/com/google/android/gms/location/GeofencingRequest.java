package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.location.zzbg;
import java.util.ArrayList;
import java.util.List;

public class GeofencingRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GeofencingRequest> CREATOR = new m();

    /* renamed from: a  reason: collision with root package name */
    private final List<zzbg> f18054a;

    /* renamed from: b  reason: collision with root package name */
    private final int f18055b;

    /* renamed from: c  reason: collision with root package name */
    private final String f18056c;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<zzbg> f18057a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private int f18058b = 5;

        /* renamed from: c  reason: collision with root package name */
        private String f18059c = "";

        public final a a(int i2) {
            this.f18058b = i2 & 7;
            return this;
        }

        public final a a(d dVar) {
            m.a(dVar, (Object) "geofence can't be null.");
            m.a(dVar instanceof zzbg, (Object) "Geofence must be created using Geofence.Builder.");
            this.f18057a.add((zzbg) dVar);
            return this;
        }

        public final a a(List<d> list) {
            if (list != null && !list.isEmpty()) {
                for (d next : list) {
                    if (next != null) {
                        a(next);
                    }
                }
            }
            return this;
        }

        public final GeofencingRequest a() {
            m.a(!this.f18057a.isEmpty(), (Object) "No geofence has been added to this request.");
            return new GeofencingRequest(this.f18057a, this.f18058b, this.f18059c);
        }
    }

    GeofencingRequest(List<zzbg> list, int i2, String str) {
        this.f18054a = list;
        this.f18055b = i2;
        this.f18056c = str;
    }

    public int a() {
        return this.f18055b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GeofencingRequest[");
        sb.append("geofences=");
        sb.append(this.f18054a);
        int i2 = this.f18055b;
        StringBuilder sb2 = new StringBuilder(30);
        sb2.append(", initialTrigger=");
        sb2.append(i2);
        sb2.append(", ");
        sb.append(sb2.toString());
        String valueOf = String.valueOf(this.f18056c);
        sb.append(valueOf.length() != 0 ? "tag=".concat(valueOf) : new String("tag="));
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 1, this.f18054a, false);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 2, a());
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 3, this.f18056c, false);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, a2);
    }
}
