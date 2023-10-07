package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new an();

    /* renamed from: a  reason: collision with root package name */
    private boolean f18116a;

    /* renamed from: b  reason: collision with root package name */
    private long f18117b;

    /* renamed from: c  reason: collision with root package name */
    private float f18118c;

    /* renamed from: d  reason: collision with root package name */
    private long f18119d;

    /* renamed from: e  reason: collision with root package name */
    private int f18120e;

    public zzo() {
        this(true, 50, 0.0f, Long.MAX_VALUE, SubsamplingScaleImageView.TILE_SIZE_AUTO);
    }

    zzo(boolean z2, long j2, float f2, long j3, int i2) {
        this.f18116a = z2;
        this.f18117b = j2;
        this.f18118c = f2;
        this.f18119d = j3;
        this.f18120e = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzo)) {
            return false;
        }
        zzo zzo = (zzo) obj;
        return this.f18116a == zzo.f18116a && this.f18117b == zzo.f18117b && Float.compare(this.f18118c, zzo.f18118c) == 0 && this.f18119d == zzo.f18119d && this.f18120e == zzo.f18120e;
    }

    public final int hashCode() {
        return l.a(Boolean.valueOf(this.f18116a), Long.valueOf(this.f18117b), Float.valueOf(this.f18118c), Long.valueOf(this.f18119d), Integer.valueOf(this.f18120e));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeviceOrientationRequest[mShouldUseMag=");
        sb.append(this.f18116a);
        sb.append(" mMinimumSamplingPeriodMs=");
        sb.append(this.f18117b);
        sb.append(" mSmallestAngleChangeRadians=");
        sb.append(this.f18118c);
        long j2 = this.f18119d;
        if (j2 != Long.MAX_VALUE) {
            sb.append(" expireIn=");
            sb.append(j2 - SystemClock.elapsedRealtime());
            sb.append("ms");
        }
        if (this.f18120e != Integer.MAX_VALUE) {
            sb.append(" num=");
            sb.append(this.f18120e);
        }
        sb.append(']');
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f18116a);
        a.a(parcel, 2, this.f18117b);
        a.a(parcel, 3, this.f18118c);
        a.a(parcel, 4, this.f18119d);
        a.a(parcel, 5, this.f18120e);
        a.a(parcel, a2);
    }
}
