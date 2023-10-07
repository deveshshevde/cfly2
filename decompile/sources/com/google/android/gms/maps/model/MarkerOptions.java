package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.dynamic.b;

public final class MarkerOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MarkerOptions> CREATOR = new p();

    /* renamed from: a  reason: collision with root package name */
    private LatLng f18235a;

    /* renamed from: b  reason: collision with root package name */
    private String f18236b;

    /* renamed from: c  reason: collision with root package name */
    private String f18237c;

    /* renamed from: d  reason: collision with root package name */
    private a f18238d;

    /* renamed from: e  reason: collision with root package name */
    private float f18239e = 0.5f;

    /* renamed from: f  reason: collision with root package name */
    private float f18240f = 1.0f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f18241g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f18242h = true;

    /* renamed from: i  reason: collision with root package name */
    private boolean f18243i = false;

    /* renamed from: j  reason: collision with root package name */
    private float f18244j = 0.0f;

    /* renamed from: k  reason: collision with root package name */
    private float f18245k = 0.5f;

    /* renamed from: l  reason: collision with root package name */
    private float f18246l = 0.0f;

    /* renamed from: m  reason: collision with root package name */
    private float f18247m = 1.0f;

    /* renamed from: n  reason: collision with root package name */
    private float f18248n;

    public MarkerOptions() {
    }

    MarkerOptions(LatLng latLng, String str, String str2, IBinder iBinder, float f2, float f3, boolean z2, boolean z3, boolean z4, float f4, float f5, float f6, float f7, float f8) {
        this.f18235a = latLng;
        this.f18236b = str;
        this.f18237c = str2;
        this.f18238d = iBinder == null ? null : new a(b.a.a(iBinder));
        this.f18239e = f2;
        this.f18240f = f3;
        this.f18241g = z2;
        this.f18242h = z3;
        this.f18243i = z4;
        this.f18244j = f4;
        this.f18245k = f5;
        this.f18246l = f6;
        this.f18247m = f7;
        this.f18248n = f8;
    }

    public final LatLng a() {
        return this.f18235a;
    }

    public final MarkerOptions a(float f2) {
        this.f18244j = f2;
        return this;
    }

    public final MarkerOptions a(float f2, float f3) {
        this.f18239e = f2;
        this.f18240f = f3;
        return this;
    }

    public final MarkerOptions a(LatLng latLng) {
        if (latLng != null) {
            this.f18235a = latLng;
            return this;
        }
        throw new IllegalArgumentException("latlng cannot be null - a position is required.");
    }

    public final MarkerOptions a(a aVar) {
        this.f18238d = aVar;
        return this;
    }

    public final MarkerOptions a(String str) {
        this.f18236b = str;
        return this;
    }

    public final MarkerOptions a(boolean z2) {
        this.f18241g = z2;
        return this;
    }

    public final MarkerOptions b(float f2) {
        this.f18247m = f2;
        return this;
    }

    public final MarkerOptions b(float f2, float f3) {
        this.f18245k = f2;
        this.f18246l = f3;
        return this;
    }

    public final MarkerOptions b(String str) {
        this.f18237c = str;
        return this;
    }

    public final MarkerOptions b(boolean z2) {
        this.f18242h = z2;
        return this;
    }

    public final String b() {
        return this.f18236b;
    }

    public final MarkerOptions c(boolean z2) {
        this.f18243i = z2;
        return this;
    }

    public final String c() {
        return this.f18237c;
    }

    public final float d() {
        return this.f18239e;
    }

    public final float e() {
        return this.f18240f;
    }

    public final boolean f() {
        return this.f18241g;
    }

    public final boolean g() {
        return this.f18242h;
    }

    public final boolean h() {
        return this.f18243i;
    }

    public final float i() {
        return this.f18244j;
    }

    public final float j() {
        return this.f18245k;
    }

    public final float k() {
        return this.f18246l;
    }

    public final float l() {
        return this.f18247m;
    }

    public final float m() {
        return this.f18248n;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 2, (Parcelable) a(), i2, false);
        a.a(parcel, 3, b(), false);
        a.a(parcel, 4, c(), false);
        a aVar = this.f18238d;
        a.a(parcel, 5, aVar == null ? null : aVar.a().asBinder(), false);
        a.a(parcel, 6, d());
        a.a(parcel, 7, e());
        a.a(parcel, 8, f());
        a.a(parcel, 9, g());
        a.a(parcel, 10, h());
        a.a(parcel, 11, i());
        a.a(parcel, 12, j());
        a.a(parcel, 13, k());
        a.a(parcel, 14, l());
        a.a(parcel, 15, m());
        a.a(parcel, a2);
    }
}
