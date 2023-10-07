package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import gj.l;

public final class GoogleMapOptions extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleMapOptions> CREATOR = new l();

    /* renamed from: a  reason: collision with root package name */
    private Boolean f18121a;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f18122b;

    /* renamed from: c  reason: collision with root package name */
    private int f18123c = -1;

    /* renamed from: d  reason: collision with root package name */
    private CameraPosition f18124d;

    /* renamed from: e  reason: collision with root package name */
    private Boolean f18125e;

    /* renamed from: f  reason: collision with root package name */
    private Boolean f18126f;

    /* renamed from: g  reason: collision with root package name */
    private Boolean f18127g;

    /* renamed from: h  reason: collision with root package name */
    private Boolean f18128h;

    /* renamed from: i  reason: collision with root package name */
    private Boolean f18129i;

    /* renamed from: j  reason: collision with root package name */
    private Boolean f18130j;

    /* renamed from: k  reason: collision with root package name */
    private Boolean f18131k;

    /* renamed from: l  reason: collision with root package name */
    private Boolean f18132l;

    /* renamed from: m  reason: collision with root package name */
    private Boolean f18133m;

    /* renamed from: n  reason: collision with root package name */
    private Float f18134n = null;

    /* renamed from: o  reason: collision with root package name */
    private Float f18135o = null;

    /* renamed from: p  reason: collision with root package name */
    private LatLngBounds f18136p = null;

    /* renamed from: q  reason: collision with root package name */
    private Boolean f18137q;

    public GoogleMapOptions() {
    }

    GoogleMapOptions(byte b2, byte b3, int i2, CameraPosition cameraPosition, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9, byte b10, byte b11, byte b12, Float f2, Float f3, LatLngBounds latLngBounds, byte b13) {
        this.f18121a = l.a(b2);
        this.f18122b = l.a(b3);
        this.f18123c = i2;
        this.f18124d = cameraPosition;
        this.f18125e = l.a(b4);
        this.f18126f = l.a(b5);
        this.f18127g = l.a(b6);
        this.f18128h = l.a(b7);
        this.f18129i = l.a(b8);
        this.f18130j = l.a(b9);
        this.f18131k = l.a(b10);
        this.f18132l = l.a(b11);
        this.f18133m = l.a(b12);
        this.f18134n = f2;
        this.f18135o = f3;
        this.f18136p = latLngBounds;
        this.f18137q = l.a(b13);
    }

    public static GoogleMapOptions a(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_mapType)) {
            googleMapOptions.a(obtainAttributes.getInt(R.styleable.MapAttrs_mapType, -1));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_zOrderOnTop)) {
            googleMapOptions.a(obtainAttributes.getBoolean(R.styleable.MapAttrs_zOrderOnTop, false));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_useViewLifecycle)) {
            googleMapOptions.b(obtainAttributes.getBoolean(R.styleable.MapAttrs_useViewLifecycle, false));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_uiCompass)) {
            googleMapOptions.d(obtainAttributes.getBoolean(R.styleable.MapAttrs_uiCompass, true));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_uiRotateGestures)) {
            googleMapOptions.h(obtainAttributes.getBoolean(R.styleable.MapAttrs_uiRotateGestures, true));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_uiScrollGesturesDuringRotateOrZoom)) {
            googleMapOptions.i(obtainAttributes.getBoolean(R.styleable.MapAttrs_uiScrollGesturesDuringRotateOrZoom, true));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_uiScrollGestures)) {
            googleMapOptions.e(obtainAttributes.getBoolean(R.styleable.MapAttrs_uiScrollGestures, true));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_uiTiltGestures)) {
            googleMapOptions.g(obtainAttributes.getBoolean(R.styleable.MapAttrs_uiTiltGestures, true));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_uiZoomGestures)) {
            googleMapOptions.f(obtainAttributes.getBoolean(R.styleable.MapAttrs_uiZoomGestures, true));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_uiZoomControls)) {
            googleMapOptions.c(obtainAttributes.getBoolean(R.styleable.MapAttrs_uiZoomControls, true));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_liteMode)) {
            googleMapOptions.j(obtainAttributes.getBoolean(R.styleable.MapAttrs_liteMode, false));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_uiMapToolbar)) {
            googleMapOptions.k(obtainAttributes.getBoolean(R.styleable.MapAttrs_uiMapToolbar, true));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_ambientEnabled)) {
            googleMapOptions.l(obtainAttributes.getBoolean(R.styleable.MapAttrs_ambientEnabled, false));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_cameraMinZoomPreference)) {
            googleMapOptions.a(obtainAttributes.getFloat(R.styleable.MapAttrs_cameraMinZoomPreference, Float.NEGATIVE_INFINITY));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_cameraMinZoomPreference)) {
            googleMapOptions.b(obtainAttributes.getFloat(R.styleable.MapAttrs_cameraMaxZoomPreference, Float.POSITIVE_INFINITY));
        }
        googleMapOptions.a(b(context, attributeSet));
        googleMapOptions.a(c(context, attributeSet));
        obtainAttributes.recycle();
        return googleMapOptions;
    }

    public static LatLngBounds b(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        Float valueOf = obtainAttributes.hasValue(R.styleable.MapAttrs_latLngBoundsSouthWestLatitude) ? Float.valueOf(obtainAttributes.getFloat(R.styleable.MapAttrs_latLngBoundsSouthWestLatitude, 0.0f)) : null;
        Float valueOf2 = obtainAttributes.hasValue(R.styleable.MapAttrs_latLngBoundsSouthWestLongitude) ? Float.valueOf(obtainAttributes.getFloat(R.styleable.MapAttrs_latLngBoundsSouthWestLongitude, 0.0f)) : null;
        Float valueOf3 = obtainAttributes.hasValue(R.styleable.MapAttrs_latLngBoundsNorthEastLatitude) ? Float.valueOf(obtainAttributes.getFloat(R.styleable.MapAttrs_latLngBoundsNorthEastLatitude, 0.0f)) : null;
        Float valueOf4 = obtainAttributes.hasValue(R.styleable.MapAttrs_latLngBoundsNorthEastLongitude) ? Float.valueOf(obtainAttributes.getFloat(R.styleable.MapAttrs_latLngBoundsNorthEastLongitude, 0.0f)) : null;
        obtainAttributes.recycle();
        if (valueOf == null || valueOf2 == null || valueOf3 == null || valueOf4 == null) {
            return null;
        }
        return new LatLngBounds(new LatLng((double) valueOf.floatValue(), (double) valueOf2.floatValue()), new LatLng((double) valueOf3.floatValue(), (double) valueOf4.floatValue()));
    }

    public static CameraPosition c(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        LatLng latLng = new LatLng((double) (obtainAttributes.hasValue(R.styleable.MapAttrs_cameraTargetLat) ? obtainAttributes.getFloat(R.styleable.MapAttrs_cameraTargetLat, 0.0f) : 0.0f), (double) (obtainAttributes.hasValue(R.styleable.MapAttrs_cameraTargetLng) ? obtainAttributes.getFloat(R.styleable.MapAttrs_cameraTargetLng, 0.0f) : 0.0f));
        CameraPosition.a a2 = CameraPosition.a();
        a2.a(latLng);
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_cameraZoom)) {
            a2.a(obtainAttributes.getFloat(R.styleable.MapAttrs_cameraZoom, 0.0f));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_cameraBearing)) {
            a2.c(obtainAttributes.getFloat(R.styleable.MapAttrs_cameraBearing, 0.0f));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_cameraTilt)) {
            a2.b(obtainAttributes.getFloat(R.styleable.MapAttrs_cameraTilt, 0.0f));
        }
        obtainAttributes.recycle();
        return a2.a();
    }

    public final int a() {
        return this.f18123c;
    }

    public final GoogleMapOptions a(float f2) {
        this.f18134n = Float.valueOf(f2);
        return this;
    }

    public final GoogleMapOptions a(int i2) {
        this.f18123c = i2;
        return this;
    }

    public final GoogleMapOptions a(CameraPosition cameraPosition) {
        this.f18124d = cameraPosition;
        return this;
    }

    public final GoogleMapOptions a(LatLngBounds latLngBounds) {
        this.f18136p = latLngBounds;
        return this;
    }

    public final GoogleMapOptions a(boolean z2) {
        this.f18121a = Boolean.valueOf(z2);
        return this;
    }

    public final GoogleMapOptions b(float f2) {
        this.f18135o = Float.valueOf(f2);
        return this;
    }

    public final GoogleMapOptions b(boolean z2) {
        this.f18122b = Boolean.valueOf(z2);
        return this;
    }

    public final CameraPosition b() {
        return this.f18124d;
    }

    public final GoogleMapOptions c(boolean z2) {
        this.f18125e = Boolean.valueOf(z2);
        return this;
    }

    public final Float c() {
        return this.f18134n;
    }

    public final GoogleMapOptions d(boolean z2) {
        this.f18126f = Boolean.valueOf(z2);
        return this;
    }

    public final Float d() {
        return this.f18135o;
    }

    public final GoogleMapOptions e(boolean z2) {
        this.f18127g = Boolean.valueOf(z2);
        return this;
    }

    public final LatLngBounds e() {
        return this.f18136p;
    }

    public final GoogleMapOptions f(boolean z2) {
        this.f18128h = Boolean.valueOf(z2);
        return this;
    }

    public final GoogleMapOptions g(boolean z2) {
        this.f18129i = Boolean.valueOf(z2);
        return this;
    }

    public final GoogleMapOptions h(boolean z2) {
        this.f18130j = Boolean.valueOf(z2);
        return this;
    }

    public final GoogleMapOptions i(boolean z2) {
        this.f18137q = Boolean.valueOf(z2);
        return this;
    }

    public final GoogleMapOptions j(boolean z2) {
        this.f18131k = Boolean.valueOf(z2);
        return this;
    }

    public final GoogleMapOptions k(boolean z2) {
        this.f18132l = Boolean.valueOf(z2);
        return this;
    }

    public final GoogleMapOptions l(boolean z2) {
        this.f18133m = Boolean.valueOf(z2);
        return this;
    }

    public final String toString() {
        return com.google.android.gms.common.internal.l.a((Object) this).a("MapType", Integer.valueOf(this.f18123c)).a("LiteMode", this.f18131k).a("Camera", this.f18124d).a("CompassEnabled", this.f18126f).a("ZoomControlsEnabled", this.f18125e).a("ScrollGesturesEnabled", this.f18127g).a("ZoomGesturesEnabled", this.f18128h).a("TiltGesturesEnabled", this.f18129i).a("RotateGesturesEnabled", this.f18130j).a("ScrollGesturesEnabledDuringRotateOrZoom", this.f18137q).a("MapToolbarEnabled", this.f18132l).a("AmbientEnabled", this.f18133m).a("MinZoomPreference", this.f18134n).a("MaxZoomPreference", this.f18135o).a("LatLngBoundsForCameraTarget", this.f18136p).a("ZOrderOnTop", this.f18121a).a("UseViewLifecycleInFragment", this.f18122b).toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 2, l.a(this.f18121a));
        a.a(parcel, 3, l.a(this.f18122b));
        a.a(parcel, 4, a());
        a.a(parcel, 5, (Parcelable) b(), i2, false);
        a.a(parcel, 6, l.a(this.f18125e));
        a.a(parcel, 7, l.a(this.f18126f));
        a.a(parcel, 8, l.a(this.f18127g));
        a.a(parcel, 9, l.a(this.f18128h));
        a.a(parcel, 10, l.a(this.f18129i));
        a.a(parcel, 11, l.a(this.f18130j));
        a.a(parcel, 12, l.a(this.f18131k));
        a.a(parcel, 14, l.a(this.f18132l));
        a.a(parcel, 15, l.a(this.f18133m));
        a.a(parcel, 16, c(), false);
        a.a(parcel, 17, d(), false);
        a.a(parcel, 18, (Parcelable) e(), i2, false);
        a.a(parcel, 19, l.a(this.f18137q));
        a.a(parcel, a2);
    }
}
