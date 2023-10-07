package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import fg.i;

public class StreetViewPanoramaCamera extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaCamera> CREATOR = new u();

    /* renamed from: a  reason: collision with root package name */
    public final float f18277a;

    /* renamed from: b  reason: collision with root package name */
    public final float f18278b;

    /* renamed from: c  reason: collision with root package name */
    public final float f18279c;

    /* renamed from: d  reason: collision with root package name */
    private final StreetViewPanoramaOrientation f18280d;

    public StreetViewPanoramaCamera(float f2, float f3, float f4) {
        boolean z2 = -90.0f <= f3 && f3 <= 90.0f;
        StringBuilder sb = new StringBuilder(62);
        sb.append("Tilt needs to be between -90 and 90 inclusive: ");
        sb.append(f3);
        m.a(z2, (Object) sb.toString());
        this.f18277a = ((double) f2) <= i.f27244a ? 0.0f : f2;
        this.f18278b = 0.0f + f3;
        this.f18279c = (((double) f4) <= i.f27244a ? (f4 % 360.0f) + 360.0f : f4) % 360.0f;
        this.f18280d = new StreetViewPanoramaOrientation.a().a(f3).b(f4).a();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaCamera)) {
            return false;
        }
        StreetViewPanoramaCamera streetViewPanoramaCamera = (StreetViewPanoramaCamera) obj;
        return Float.floatToIntBits(this.f18277a) == Float.floatToIntBits(streetViewPanoramaCamera.f18277a) && Float.floatToIntBits(this.f18278b) == Float.floatToIntBits(streetViewPanoramaCamera.f18278b) && Float.floatToIntBits(this.f18279c) == Float.floatToIntBits(streetViewPanoramaCamera.f18279c);
    }

    public int hashCode() {
        return l.a(Float.valueOf(this.f18277a), Float.valueOf(this.f18278b), Float.valueOf(this.f18279c));
    }

    public String toString() {
        return l.a((Object) this).a("zoom", Float.valueOf(this.f18277a)).a("tilt", Float.valueOf(this.f18278b)).a("bearing", Float.valueOf(this.f18279c)).toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 2, this.f18277a);
        a.a(parcel, 3, this.f18278b);
        a.a(parcel, 4, this.f18279c);
        a.a(parcel, a2);
    }
}
