package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public class PatternItem extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PatternItem> CREATOR = new q();

    /* renamed from: a  reason: collision with root package name */
    private static final String f18249a = "PatternItem";

    /* renamed from: b  reason: collision with root package name */
    private final int f18250b;

    /* renamed from: c  reason: collision with root package name */
    private final Float f18251c;

    public PatternItem(int i2, Float f2) {
        boolean z2 = true;
        if (i2 != 1 && (f2 == null || f2.floatValue() < 0.0f)) {
            z2 = false;
        }
        String valueOf = String.valueOf(f2);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 45);
        sb.append("Invalid PatternItem: type=");
        sb.append(i2);
        sb.append(" length=");
        sb.append(valueOf);
        m.a(z2, (Object) sb.toString());
        this.f18250b = i2;
        this.f18251c = f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PatternItem)) {
            return false;
        }
        PatternItem patternItem = (PatternItem) obj;
        return this.f18250b == patternItem.f18250b && l.a(this.f18251c, patternItem.f18251c);
    }

    public int hashCode() {
        return l.a(Integer.valueOf(this.f18250b), this.f18251c);
    }

    public String toString() {
        int i2 = this.f18250b;
        String valueOf = String.valueOf(this.f18251c);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 39);
        sb.append("[PatternItem: type=");
        sb.append(i2);
        sb.append(" length=");
        sb.append(valueOf);
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 2, this.f18250b);
        a.a(parcel, 3, this.f18251c, false);
        a.a(parcel, a2);
    }
}
