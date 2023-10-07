package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.dynamic.b;

public class Cap extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Cap> CREATOR = new j();

    /* renamed from: a  reason: collision with root package name */
    private static final String f18196a = "Cap";

    /* renamed from: b  reason: collision with root package name */
    private final int f18197b;

    /* renamed from: c  reason: collision with root package name */
    private final a f18198c;

    /* renamed from: d  reason: collision with root package name */
    private final Float f18199d;

    protected Cap(int i2) {
        this(i2, (a) null, (Float) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    Cap(int i2, IBinder iBinder, Float f2) {
        this(i2, iBinder == null ? null : new a(b.a.a(iBinder)), f2);
    }

    private Cap(int i2, a aVar, Float f2) {
        m.a(i2 != 3 || (aVar != null && (f2 != null && (f2.floatValue() > 0.0f ? 1 : (f2.floatValue() == 0.0f ? 0 : -1)) > 0)), (Object) String.format("Invalid Cap: type=%s bitmapDescriptor=%s bitmapRefWidth=%s", new Object[]{Integer.valueOf(i2), aVar, f2}));
        this.f18197b = i2;
        this.f18198c = aVar;
        this.f18199d = f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cap)) {
            return false;
        }
        Cap cap = (Cap) obj;
        return this.f18197b == cap.f18197b && l.a(this.f18198c, cap.f18198c) && l.a(this.f18199d, cap.f18199d);
    }

    public int hashCode() {
        return l.a(Integer.valueOf(this.f18197b), this.f18198c, this.f18199d);
    }

    public String toString() {
        int i2 = this.f18197b;
        StringBuilder sb = new StringBuilder(23);
        sb.append("[Cap: type=");
        sb.append(i2);
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 2, this.f18197b);
        a aVar = this.f18198c;
        a.a(parcel, 3, aVar == null ? null : aVar.a().asBinder(), false);
        a.a(parcel, 4, this.f18199d, false);
        a.a(parcel, a2);
    }
}
