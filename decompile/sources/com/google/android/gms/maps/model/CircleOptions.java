package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import fg.i;
import java.util.List;

public final class CircleOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CircleOptions> CREATOR = new k();

    /* renamed from: a  reason: collision with root package name */
    private LatLng f18200a = null;

    /* renamed from: b  reason: collision with root package name */
    private double f18201b = i.f27244a;

    /* renamed from: c  reason: collision with root package name */
    private float f18202c = 10.0f;

    /* renamed from: d  reason: collision with root package name */
    private int f18203d = -16777216;

    /* renamed from: e  reason: collision with root package name */
    private int f18204e = 0;

    /* renamed from: f  reason: collision with root package name */
    private float f18205f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f18206g = true;

    /* renamed from: h  reason: collision with root package name */
    private boolean f18207h = false;

    /* renamed from: i  reason: collision with root package name */
    private List<PatternItem> f18208i = null;

    public CircleOptions() {
    }

    CircleOptions(LatLng latLng, double d2, float f2, int i2, int i3, float f3, boolean z2, boolean z3, List<PatternItem> list) {
        this.f18200a = latLng;
        this.f18201b = d2;
        this.f18202c = f2;
        this.f18203d = i2;
        this.f18204e = i3;
        this.f18205f = f3;
        this.f18206g = z2;
        this.f18207h = z3;
        this.f18208i = list;
    }

    public final CircleOptions a(double d2) {
        this.f18201b = d2;
        return this;
    }

    public final CircleOptions a(float f2) {
        this.f18202c = f2;
        return this;
    }

    public final CircleOptions a(int i2) {
        this.f18203d = i2;
        return this;
    }

    public final CircleOptions a(LatLng latLng) {
        this.f18200a = latLng;
        return this;
    }

    public final CircleOptions a(boolean z2) {
        this.f18207h = z2;
        return this;
    }

    public final LatLng a() {
        return this.f18200a;
    }

    public final double b() {
        return this.f18201b;
    }

    public final CircleOptions b(int i2) {
        this.f18204e = i2;
        return this;
    }

    public final float c() {
        return this.f18202c;
    }

    public final int d() {
        return this.f18203d;
    }

    public final List<PatternItem> e() {
        return this.f18208i;
    }

    public final int f() {
        return this.f18204e;
    }

    public final float g() {
        return this.f18205f;
    }

    public final boolean h() {
        return this.f18206g;
    }

    public final boolean i() {
        return this.f18207h;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 2, (Parcelable) a(), i2, false);
        a.a(parcel, 3, b());
        a.a(parcel, 4, c());
        a.a(parcel, 5, d());
        a.a(parcel, 6, f());
        a.a(parcel, 7, g());
        a.a(parcel, 8, h());
        a.a(parcel, 9, i());
        a.c(parcel, 10, e(), false);
        a.a(parcel, a2);
    }
}
