package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public class ActivityTransition extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityTransition> CREATOR = new ag();

    /* renamed from: a  reason: collision with root package name */
    private final int f18038a;

    /* renamed from: b  reason: collision with root package name */
    private final int f18039b;

    ActivityTransition(int i2, int i3) {
        this.f18038a = i2;
        this.f18039b = i3;
    }

    public static void a(int i2) {
        boolean z2 = true;
        if (i2 < 0 || i2 > 1) {
            z2 = false;
        }
        StringBuilder sb = new StringBuilder(41);
        sb.append("Transition type ");
        sb.append(i2);
        sb.append(" is not valid.");
        m.a(z2, (Object) sb.toString());
    }

    public int a() {
        return this.f18038a;
    }

    public int b() {
        return this.f18039b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityTransition)) {
            return false;
        }
        ActivityTransition activityTransition = (ActivityTransition) obj;
        return this.f18038a == activityTransition.f18038a && this.f18039b == activityTransition.f18039b;
    }

    public int hashCode() {
        return l.a(Integer.valueOf(this.f18038a), Integer.valueOf(this.f18039b));
    }

    public String toString() {
        int i2 = this.f18038a;
        int i3 = this.f18039b;
        StringBuilder sb = new StringBuilder(75);
        sb.append("ActivityTransition [mActivityType=");
        sb.append(i2);
        sb.append(", mTransitionType=");
        sb.append(i3);
        sb.append(']');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, a());
        a.a(parcel, 2, b());
        a.a(parcel, a2);
    }
}
