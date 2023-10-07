package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public class PlaceReport extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<PlaceReport> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final int f18102a;

    /* renamed from: b  reason: collision with root package name */
    private final String f18103b;

    /* renamed from: c  reason: collision with root package name */
    private final String f18104c;

    /* renamed from: d  reason: collision with root package name */
    private final String f18105d;

    PlaceReport(int i2, String str, String str2, String str3) {
        this.f18102a = i2;
        this.f18103b = str;
        this.f18104c = str2;
        this.f18105d = str3;
    }

    public String a() {
        return this.f18103b;
    }

    public String b() {
        return this.f18104c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) obj;
        return l.a(this.f18103b, placeReport.f18103b) && l.a(this.f18104c, placeReport.f18104c) && l.a(this.f18105d, placeReport.f18105d);
    }

    public int hashCode() {
        return l.a(this.f18103b, this.f18104c, this.f18105d);
    }

    public String toString() {
        l.a a2 = l.a((Object) this);
        a2.a("placeId", this.f18103b);
        a2.a("tag", this.f18104c);
        if (!IjkMediaMeta.IJKM_VAL_TYPE__UNKNOWN.equals(this.f18105d)) {
            a2.a("source", this.f18105d);
        }
        return a2.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f18102a);
        a.a(parcel, 2, a(), false);
        a.a(parcel, 3, b(), false);
        a.a(parcel, 4, this.f18105d, false);
        a.a(parcel, a2);
    }
}
