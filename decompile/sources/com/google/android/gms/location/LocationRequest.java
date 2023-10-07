package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationRequest> CREATOR = new w();

    /* renamed from: a  reason: collision with root package name */
    private int f18065a;

    /* renamed from: b  reason: collision with root package name */
    private long f18066b;

    /* renamed from: c  reason: collision with root package name */
    private long f18067c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f18068d;

    /* renamed from: e  reason: collision with root package name */
    private long f18069e;

    /* renamed from: f  reason: collision with root package name */
    private int f18070f;

    /* renamed from: g  reason: collision with root package name */
    private float f18071g;

    /* renamed from: h  reason: collision with root package name */
    private long f18072h;

    public LocationRequest() {
        this.f18065a = 102;
        this.f18066b = 3600000;
        this.f18067c = 600000;
        this.f18068d = false;
        this.f18069e = Long.MAX_VALUE;
        this.f18070f = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.f18071g = 0.0f;
        this.f18072h = 0;
    }

    LocationRequest(int i2, long j2, long j3, boolean z2, long j4, int i3, float f2, long j5) {
        this.f18065a = i2;
        this.f18066b = j2;
        this.f18067c = j3;
        this.f18068d = z2;
        this.f18069e = j4;
        this.f18070f = i3;
        this.f18071g = f2;
        this.f18072h = j5;
    }

    public static LocationRequest a() {
        return new LocationRequest();
    }

    private static void c(long j2) {
        if (j2 < 0) {
            StringBuilder sb = new StringBuilder(38);
            sb.append("invalid interval: ");
            sb.append(j2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public final LocationRequest a(float f2) {
        if (f2 >= 0.0f) {
            this.f18071g = f2;
            return this;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("invalid displacement: ");
        sb.append(f2);
        throw new IllegalArgumentException(sb.toString());
    }

    public final LocationRequest a(int i2) {
        if (i2 == 100 || i2 == 102 || i2 == 104 || i2 == 105) {
            this.f18065a = i2;
            return this;
        }
        StringBuilder sb = new StringBuilder(28);
        sb.append("invalid quality: ");
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }

    public final LocationRequest a(long j2) {
        c(j2);
        this.f18066b = j2;
        if (!this.f18068d) {
            double d2 = (double) j2;
            Double.isNaN(d2);
            this.f18067c = (long) (d2 / 6.0d);
        }
        return this;
    }

    public final long b() {
        return this.f18066b;
    }

    public final LocationRequest b(long j2) {
        c(j2);
        this.f18068d = true;
        this.f18067c = j2;
        return this;
    }

    public final long c() {
        long j2 = this.f18072h;
        long j3 = this.f18066b;
        return j2 < j3 ? j3 : j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) obj;
        return this.f18065a == locationRequest.f18065a && this.f18066b == locationRequest.f18066b && this.f18067c == locationRequest.f18067c && this.f18068d == locationRequest.f18068d && this.f18069e == locationRequest.f18069e && this.f18070f == locationRequest.f18070f && this.f18071g == locationRequest.f18071g && c() == locationRequest.c();
    }

    public final int hashCode() {
        return l.a(Integer.valueOf(this.f18065a), Long.valueOf(this.f18066b), Float.valueOf(this.f18071g), Long.valueOf(this.f18072h));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[");
        int i2 = this.f18065a;
        sb.append(i2 != 100 ? i2 != 102 ? i2 != 104 ? i2 != 105 ? "???" : "PRIORITY_NO_POWER" : "PRIORITY_LOW_POWER" : "PRIORITY_BALANCED_POWER_ACCURACY" : "PRIORITY_HIGH_ACCURACY");
        if (this.f18065a != 105) {
            sb.append(" requested=");
            sb.append(this.f18066b);
            sb.append("ms");
        }
        sb.append(" fastest=");
        sb.append(this.f18067c);
        sb.append("ms");
        if (this.f18072h > this.f18066b) {
            sb.append(" maxWait=");
            sb.append(this.f18072h);
            sb.append("ms");
        }
        if (this.f18071g > 0.0f) {
            sb.append(" smallestDisplacement=");
            sb.append(this.f18071g);
            sb.append("m");
        }
        long j2 = this.f18069e;
        if (j2 != Long.MAX_VALUE) {
            sb.append(" expireIn=");
            sb.append(j2 - SystemClock.elapsedRealtime());
            sb.append("ms");
        }
        if (this.f18070f != Integer.MAX_VALUE) {
            sb.append(" num=");
            sb.append(this.f18070f);
        }
        sb.append(']');
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f18065a);
        a.a(parcel, 2, this.f18066b);
        a.a(parcel, 3, this.f18067c);
        a.a(parcel, 4, this.f18068d);
        a.a(parcel, 5, this.f18069e);
        a.a(parcel, 6, this.f18070f);
        a.a(parcel, 7, this.f18071g);
        a.a(parcel, 8, this.f18072h);
        a.a(parcel, a2);
    }
}
