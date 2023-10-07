package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;
import java.util.List;

public final class PolylineOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PolylineOptions> CREATOR = new t();

    /* renamed from: a  reason: collision with root package name */
    private final List<LatLng> f18266a;

    /* renamed from: b  reason: collision with root package name */
    private float f18267b;

    /* renamed from: c  reason: collision with root package name */
    private int f18268c;

    /* renamed from: d  reason: collision with root package name */
    private float f18269d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f18270e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f18271f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f18272g;

    /* renamed from: h  reason: collision with root package name */
    private Cap f18273h;

    /* renamed from: i  reason: collision with root package name */
    private Cap f18274i;

    /* renamed from: j  reason: collision with root package name */
    private int f18275j;

    /* renamed from: k  reason: collision with root package name */
    private List<PatternItem> f18276k;

    public PolylineOptions() {
        this.f18267b = 10.0f;
        this.f18268c = -16777216;
        this.f18269d = 0.0f;
        this.f18270e = true;
        this.f18271f = false;
        this.f18272g = false;
        this.f18273h = new ButtCap();
        this.f18274i = new ButtCap();
        this.f18275j = 0;
        this.f18276k = null;
        this.f18266a = new ArrayList();
    }

    PolylineOptions(List list, float f2, int i2, float f3, boolean z2, boolean z3, boolean z4, Cap cap, Cap cap2, int i3, List<PatternItem> list2) {
        this.f18267b = 10.0f;
        this.f18268c = -16777216;
        this.f18269d = 0.0f;
        this.f18270e = true;
        this.f18271f = false;
        this.f18272g = false;
        this.f18273h = new ButtCap();
        this.f18274i = new ButtCap();
        this.f18275j = 0;
        this.f18276k = null;
        this.f18266a = list;
        this.f18267b = f2;
        this.f18268c = i2;
        this.f18269d = f3;
        this.f18270e = z2;
        this.f18271f = z3;
        this.f18272g = z4;
        if (cap != null) {
            this.f18273h = cap;
        }
        if (cap2 != null) {
            this.f18274i = cap2;
        }
        this.f18275j = i3;
        this.f18276k = list2;
    }

    public final PolylineOptions a(float f2) {
        this.f18267b = f2;
        return this;
    }

    public final PolylineOptions a(int i2) {
        this.f18268c = i2;
        return this;
    }

    public final List<LatLng> a() {
        return this.f18266a;
    }

    public final float b() {
        return this.f18267b;
    }

    public final PolylineOptions b(float f2) {
        this.f18269d = f2;
        return this;
    }

    public final int c() {
        return this.f18268c;
    }

    public final Cap d() {
        return this.f18273h;
    }

    public final Cap e() {
        return this.f18274i;
    }

    public final int f() {
        return this.f18275j;
    }

    public final List<PatternItem> g() {
        return this.f18276k;
    }

    public final float h() {
        return this.f18269d;
    }

    public final boolean i() {
        return this.f18270e;
    }

    public final boolean j() {
        return this.f18271f;
    }

    public final boolean k() {
        return this.f18272g;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.c(parcel, 2, a(), false);
        a.a(parcel, 3, b());
        a.a(parcel, 4, c());
        a.a(parcel, 5, h());
        a.a(parcel, 6, i());
        a.a(parcel, 7, j());
        a.a(parcel, 8, k());
        a.a(parcel, 9, (Parcelable) d(), i2, false);
        a.a(parcel, 10, (Parcelable) e(), i2, false);
        a.a(parcel, 11, f());
        a.c(parcel, 12, g(), false);
        a.a(parcel, a2);
    }
}
