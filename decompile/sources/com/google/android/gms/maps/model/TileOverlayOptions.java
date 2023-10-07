package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.internal.maps.zzaf;
import com.google.android.gms.internal.maps.zzag;

public final class TileOverlayOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<TileOverlayOptions> CREATOR = new ac();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public zzaf f18297a;

    /* renamed from: b  reason: collision with root package name */
    private h f18298b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f18299c = true;

    /* renamed from: d  reason: collision with root package name */
    private float f18300d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f18301e = true;

    /* renamed from: f  reason: collision with root package name */
    private float f18302f = 0.0f;

    public TileOverlayOptions() {
    }

    TileOverlayOptions(IBinder iBinder, boolean z2, float f2, boolean z3, float f3) {
        zzaf zzk = zzag.zzk(iBinder);
        this.f18297a = zzk;
        this.f18298b = zzk == null ? null : new aa(this);
        this.f18299c = z2;
        this.f18300d = f2;
        this.f18301e = z3;
        this.f18302f = f3;
    }

    public final float a() {
        return this.f18300d;
    }

    public final TileOverlayOptions a(h hVar) {
        this.f18298b = hVar;
        this.f18297a = hVar == null ? null : new ab(this, hVar);
        return this;
    }

    public final boolean b() {
        return this.f18299c;
    }

    public final boolean c() {
        return this.f18301e;
    }

    public final float d() {
        return this.f18302f;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 2, this.f18297a.asBinder(), false);
        a.a(parcel, 3, b());
        a.a(parcel, 4, a());
        a.a(parcel, 5, c());
        a.a(parcel, 6, d());
        a.a(parcel, a2);
    }
}
