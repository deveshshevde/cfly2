package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;
import java.util.List;

public final class PolygonOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PolygonOptions> CREATOR = new s();

    /* renamed from: a  reason: collision with root package name */
    private final List<LatLng> f18255a;

    /* renamed from: b  reason: collision with root package name */
    private final List<List<LatLng>> f18256b;

    /* renamed from: c  reason: collision with root package name */
    private float f18257c;

    /* renamed from: d  reason: collision with root package name */
    private int f18258d;

    /* renamed from: e  reason: collision with root package name */
    private int f18259e;

    /* renamed from: f  reason: collision with root package name */
    private float f18260f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f18261g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f18262h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f18263i;

    /* renamed from: j  reason: collision with root package name */
    private int f18264j;

    /* renamed from: k  reason: collision with root package name */
    private List<PatternItem> f18265k;

    public PolygonOptions() {
        this.f18257c = 10.0f;
        this.f18258d = -16777216;
        this.f18259e = 0;
        this.f18260f = 0.0f;
        this.f18261g = true;
        this.f18262h = false;
        this.f18263i = false;
        this.f18264j = 0;
        this.f18265k = null;
        this.f18255a = new ArrayList();
        this.f18256b = new ArrayList();
    }

    PolygonOptions(List<LatLng> list, List list2, float f2, int i2, int i3, float f3, boolean z2, boolean z3, boolean z4, int i4, List<PatternItem> list3) {
        this.f18257c = 10.0f;
        this.f18258d = -16777216;
        this.f18259e = 0;
        this.f18260f = 0.0f;
        this.f18261g = true;
        this.f18262h = false;
        this.f18263i = false;
        this.f18264j = 0;
        this.f18265k = null;
        this.f18255a = list;
        this.f18256b = list2;
        this.f18257c = f2;
        this.f18258d = i2;
        this.f18259e = i3;
        this.f18260f = f3;
        this.f18261g = z2;
        this.f18262h = z3;
        this.f18263i = z4;
        this.f18264j = i4;
        this.f18265k = list3;
    }

    public final PolygonOptions a(float f2) {
        this.f18257c = f2;
        return this;
    }

    public final PolygonOptions a(int i2) {
        this.f18258d = i2;
        return this;
    }

    public final PolygonOptions a(LatLng latLng) {
        this.f18255a.add(latLng);
        return this;
    }

    public final PolygonOptions a(Iterable<LatLng> iterable) {
        for (LatLng add : iterable) {
            this.f18255a.add(add);
        }
        return this;
    }

    public final List<LatLng> a() {
        return this.f18255a;
    }

    public final float b() {
        return this.f18257c;
    }

    public final PolygonOptions b(int i2) {
        this.f18259e = i2;
        return this;
    }

    public final int c() {
        return this.f18258d;
    }

    public final int d() {
        return this.f18264j;
    }

    public final List<PatternItem> e() {
        return this.f18265k;
    }

    public final int f() {
        return this.f18259e;
    }

    public final float g() {
        return this.f18260f;
    }

    public final boolean h() {
        return this.f18261g;
    }

    public final boolean i() {
        return this.f18262h;
    }

    public final boolean j() {
        return this.f18263i;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.c(parcel, 2, a(), false);
        a.a(parcel, 3, (List) this.f18256b, false);
        a.a(parcel, 4, b());
        a.a(parcel, 5, c());
        a.a(parcel, 6, f());
        a.a(parcel, 7, g());
        a.a(parcel, 8, h());
        a.a(parcel, 9, i());
        a.a(parcel, 10, j());
        a.a(parcel, 11, d());
        a.c(parcel, 12, e(), false);
        a.a(parcel, a2);
    }
}
