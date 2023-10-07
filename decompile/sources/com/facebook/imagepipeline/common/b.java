package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import dr.a;
import java.util.Locale;

public class b {

    /* renamed from: j  reason: collision with root package name */
    private static final b f11325j = a().j();

    /* renamed from: a  reason: collision with root package name */
    public final int f11326a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f11327b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f11328c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f11329d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f11330e;

    /* renamed from: f  reason: collision with root package name */
    public final Bitmap.Config f11331f;

    /* renamed from: g  reason: collision with root package name */
    public final a f11332g;

    /* renamed from: h  reason: collision with root package name */
    public final du.a f11333h;

    /* renamed from: i  reason: collision with root package name */
    public final ColorSpace f11334i;

    public b(c cVar) {
        this.f11326a = cVar.a();
        this.f11327b = cVar.b();
        this.f11328c = cVar.c();
        this.f11329d = cVar.d();
        this.f11330e = cVar.f();
        this.f11331f = cVar.g();
        this.f11332g = cVar.e();
        this.f11333h = cVar.h();
        this.f11334i = cVar.i();
    }

    public static c a() {
        return new c();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f11327b == bVar.f11327b && this.f11328c == bVar.f11328c && this.f11329d == bVar.f11329d && this.f11330e == bVar.f11330e && this.f11331f == bVar.f11331f && this.f11332g == bVar.f11332g && this.f11333h == bVar.f11333h && this.f11334i == bVar.f11334i;
    }

    public int hashCode() {
        int ordinal = ((((((((((this.f11326a * 31) + (this.f11327b ? 1 : 0)) * 31) + (this.f11328c ? 1 : 0)) * 31) + (this.f11329d ? 1 : 0)) * 31) + (this.f11330e ? 1 : 0)) * 31) + this.f11331f.ordinal()) * 31;
        a aVar = this.f11332g;
        int i2 = 0;
        int hashCode = (ordinal + (aVar != null ? aVar.hashCode() : 0)) * 31;
        du.a aVar2 = this.f11333h;
        int hashCode2 = (hashCode + (aVar2 != null ? aVar2.hashCode() : 0)) * 31;
        ColorSpace colorSpace = this.f11334i;
        if (colorSpace != null) {
            i2 = colorSpace.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return String.format((Locale) null, "%d-%b-%b-%b-%b-%b-%s-%s-%s", new Object[]{Integer.valueOf(this.f11326a), Boolean.valueOf(this.f11327b), Boolean.valueOf(this.f11328c), Boolean.valueOf(this.f11329d), Boolean.valueOf(this.f11330e), this.f11331f.name(), this.f11332g, this.f11333h, this.f11334i});
    }
}
