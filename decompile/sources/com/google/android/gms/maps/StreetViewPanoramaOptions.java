package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewSource;
import gj.l;

public final class StreetViewPanoramaOptions extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaOptions> CREATOR = new n();

    /* renamed from: a  reason: collision with root package name */
    private StreetViewPanoramaCamera f18147a;

    /* renamed from: b  reason: collision with root package name */
    private String f18148b;

    /* renamed from: c  reason: collision with root package name */
    private LatLng f18149c;

    /* renamed from: d  reason: collision with root package name */
    private Integer f18150d;

    /* renamed from: e  reason: collision with root package name */
    private Boolean f18151e = true;

    /* renamed from: f  reason: collision with root package name */
    private Boolean f18152f = true;

    /* renamed from: g  reason: collision with root package name */
    private Boolean f18153g = true;

    /* renamed from: h  reason: collision with root package name */
    private Boolean f18154h = true;

    /* renamed from: i  reason: collision with root package name */
    private Boolean f18155i;

    /* renamed from: j  reason: collision with root package name */
    private StreetViewSource f18156j = StreetViewSource.f18290a;

    public StreetViewPanoramaOptions() {
    }

    StreetViewPanoramaOptions(StreetViewPanoramaCamera streetViewPanoramaCamera, String str, LatLng latLng, Integer num, byte b2, byte b3, byte b4, byte b5, byte b6, StreetViewSource streetViewSource) {
        this.f18147a = streetViewPanoramaCamera;
        this.f18149c = latLng;
        this.f18150d = num;
        this.f18148b = str;
        this.f18151e = l.a(b2);
        this.f18152f = l.a(b3);
        this.f18153g = l.a(b4);
        this.f18154h = l.a(b5);
        this.f18155i = l.a(b6);
        this.f18156j = streetViewSource;
    }

    public final StreetViewPanoramaCamera a() {
        return this.f18147a;
    }

    public final LatLng b() {
        return this.f18149c;
    }

    public final Integer c() {
        return this.f18150d;
    }

    public final StreetViewSource d() {
        return this.f18156j;
    }

    public final String e() {
        return this.f18148b;
    }

    public final String toString() {
        return com.google.android.gms.common.internal.l.a((Object) this).a("PanoramaId", this.f18148b).a("Position", this.f18149c).a("Radius", this.f18150d).a("Source", this.f18156j).a("StreetViewPanoramaCamera", this.f18147a).a("UserNavigationEnabled", this.f18151e).a("ZoomGesturesEnabled", this.f18152f).a("PanningGesturesEnabled", this.f18153g).a("StreetNamesEnabled", this.f18154h).a("UseViewLifecycleInFragment", this.f18155i).toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 2, (Parcelable) a(), i2, false);
        a.a(parcel, 3, e(), false);
        a.a(parcel, 4, (Parcelable) b(), i2, false);
        a.a(parcel, 5, c(), false);
        a.a(parcel, 6, l.a(this.f18151e));
        a.a(parcel, 7, l.a(this.f18152f));
        a.a(parcel, 8, l.a(this.f18153g));
        a.a(parcel, 9, l.a(this.f18154h));
        a.a(parcel, 10, l.a(this.f18155i));
        a.a(parcel, 11, (Parcelable) d(), i2, false);
        a.a(parcel, a2);
    }
}
