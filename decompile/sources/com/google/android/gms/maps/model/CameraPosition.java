package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fg.i;

public final class CameraPosition extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<CameraPosition> CREATOR = new i();

    /* renamed from: a  reason: collision with root package name */
    public final LatLng f18188a;

    /* renamed from: b  reason: collision with root package name */
    public final float f18189b;

    /* renamed from: c  reason: collision with root package name */
    public final float f18190c;

    /* renamed from: d  reason: collision with root package name */
    public final float f18191d;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private LatLng f18192a;

        /* renamed from: b  reason: collision with root package name */
        private float f18193b;

        /* renamed from: c  reason: collision with root package name */
        private float f18194c;

        /* renamed from: d  reason: collision with root package name */
        private float f18195d;

        public final a a(float f2) {
            this.f18193b = f2;
            return this;
        }

        public final a a(LatLng latLng) {
            this.f18192a = latLng;
            return this;
        }

        public final CameraPosition a() {
            return new CameraPosition(this.f18192a, this.f18193b, this.f18194c, this.f18195d);
        }

        public final a b(float f2) {
            this.f18194c = f2;
            return this;
        }

        public final a c(float f2) {
            this.f18195d = f2;
            return this;
        }
    }

    public CameraPosition(LatLng latLng, float f2, float f3, float f4) {
        m.a(latLng, (Object) "null camera target");
        m.a(0.0f <= f3 && f3 <= 90.0f, "Tilt needs to be between 0 and 90 inclusive: %s", Float.valueOf(f3));
        this.f18188a = latLng;
        this.f18189b = f2;
        this.f18190c = f3 + 0.0f;
        this.f18191d = (((double) f4) <= i.f27244a ? (f4 % 360.0f) + 360.0f : f4) % 360.0f;
    }

    public static a a() {
        return new a();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        return this.f18188a.equals(cameraPosition.f18188a) && Float.floatToIntBits(this.f18189b) == Float.floatToIntBits(cameraPosition.f18189b) && Float.floatToIntBits(this.f18190c) == Float.floatToIntBits(cameraPosition.f18190c) && Float.floatToIntBits(this.f18191d) == Float.floatToIntBits(cameraPosition.f18191d);
    }

    public final int hashCode() {
        return l.a(this.f18188a, Float.valueOf(this.f18189b), Float.valueOf(this.f18190c), Float.valueOf(this.f18191d));
    }

    public final String toString() {
        return l.a((Object) this).a("target", this.f18188a).a("zoom", Float.valueOf(this.f18189b)).a("tilt", Float.valueOf(this.f18190c)).a("bearing", Float.valueOf(this.f18191d)).toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 2, (Parcelable) this.f18188a, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 3, this.f18189b);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 4, this.f18190c);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 5, this.f18191d);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, a2);
    }
}
