package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public class ActivityTransitionEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityTransitionEvent> CREATOR = new ah();

    /* renamed from: a  reason: collision with root package name */
    private final int f18040a;

    /* renamed from: b  reason: collision with root package name */
    private final int f18041b;

    /* renamed from: c  reason: collision with root package name */
    private final long f18042c;

    public ActivityTransitionEvent(int i2, int i3, long j2) {
        ActivityTransition.a(i3);
        this.f18040a = i2;
        this.f18041b = i3;
        this.f18042c = j2;
    }

    public int a() {
        return this.f18040a;
    }

    public int b() {
        return this.f18041b;
    }

    public long c() {
        return this.f18042c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityTransitionEvent)) {
            return false;
        }
        ActivityTransitionEvent activityTransitionEvent = (ActivityTransitionEvent) obj;
        return this.f18040a == activityTransitionEvent.f18040a && this.f18041b == activityTransitionEvent.f18041b && this.f18042c == activityTransitionEvent.f18042c;
    }

    public int hashCode() {
        return l.a(Integer.valueOf(this.f18040a), Integer.valueOf(this.f18041b), Long.valueOf(this.f18042c));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i2 = this.f18040a;
        StringBuilder sb2 = new StringBuilder(24);
        sb2.append("ActivityType ");
        sb2.append(i2);
        sb.append(sb2.toString());
        sb.append(" ");
        int i3 = this.f18041b;
        StringBuilder sb3 = new StringBuilder(26);
        sb3.append("TransitionType ");
        sb3.append(i3);
        sb.append(sb3.toString());
        sb.append(" ");
        long j2 = this.f18042c;
        StringBuilder sb4 = new StringBuilder(41);
        sb4.append("ElapsedRealTimeNanos ");
        sb4.append(j2);
        sb.append(sb4.toString());
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, a());
        a.a(parcel, 2, b());
        a.a(parcel, 3, c());
        a.a(parcel, a2);
    }
}
