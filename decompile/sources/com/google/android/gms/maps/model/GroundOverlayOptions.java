package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.dynamic.b;

public final class GroundOverlayOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GroundOverlayOptions> CREATOR = new l();

    /* renamed from: a  reason: collision with root package name */
    private a f18213a;

    /* renamed from: b  reason: collision with root package name */
    private LatLng f18214b;

    /* renamed from: c  reason: collision with root package name */
    private float f18215c;

    /* renamed from: d  reason: collision with root package name */
    private float f18216d;

    /* renamed from: e  reason: collision with root package name */
    private LatLngBounds f18217e;

    /* renamed from: f  reason: collision with root package name */
    private float f18218f;

    /* renamed from: g  reason: collision with root package name */
    private float f18219g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f18220h = true;

    /* renamed from: i  reason: collision with root package name */
    private float f18221i = 0.0f;

    /* renamed from: j  reason: collision with root package name */
    private float f18222j = 0.5f;

    /* renamed from: k  reason: collision with root package name */
    private float f18223k = 0.5f;

    /* renamed from: l  reason: collision with root package name */
    private boolean f18224l = false;

    public GroundOverlayOptions() {
    }

    GroundOverlayOptions(IBinder iBinder, LatLng latLng, float f2, float f3, LatLngBounds latLngBounds, float f4, float f5, boolean z2, float f6, float f7, float f8, boolean z3) {
        this.f18213a = new a(b.a.a(iBinder));
        this.f18214b = latLng;
        this.f18215c = f2;
        this.f18216d = f3;
        this.f18217e = latLngBounds;
        this.f18218f = f4;
        this.f18219g = f5;
        this.f18220h = z2;
        this.f18221i = f6;
        this.f18222j = f7;
        this.f18223k = f8;
        this.f18224l = z3;
    }

    public final LatLng a() {
        return this.f18214b;
    }

    public final float b() {
        return this.f18215c;
    }

    public final float c() {
        return this.f18216d;
    }

    public final LatLngBounds d() {
        return this.f18217e;
    }

    public final float e() {
        return this.f18218f;
    }

    public final float f() {
        return this.f18219g;
    }

    public final float g() {
        return this.f18221i;
    }

    public final float h() {
        return this.f18222j;
    }

    public final float i() {
        return this.f18223k;
    }

    public final boolean j() {
        return this.f18220h;
    }

    public final boolean k() {
        return this.f18224l;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 2, this.f18213a.a().asBinder(), false);
        a.a(parcel, 3, (Parcelable) a(), i2, false);
        a.a(parcel, 4, b());
        a.a(parcel, 5, c());
        a.a(parcel, 6, (Parcelable) d(), i2, false);
        a.a(parcel, 7, e());
        a.a(parcel, 8, f());
        a.a(parcel, 9, j());
        a.a(parcel, 10, g());
        a.a(parcel, 11, h());
        a.a(parcel, 12, i());
        a.a(parcel, 13, k());
        a.a(parcel, a2);
    }
}
