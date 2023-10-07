package com.flypro.core.drone.variables;

import com.flypro.core.drone.d;
import com.flypro.core.parameters.Parameter;
import en.a;

public class m extends d {

    /* renamed from: a  reason: collision with root package name */
    private int f14357a;

    /* renamed from: c  reason: collision with root package name */
    private int f14358c;

    /* renamed from: d  reason: collision with root package name */
    private int f14359d;

    /* renamed from: e  reason: collision with root package name */
    private int f14360e;

    /* renamed from: f  reason: collision with root package name */
    private int f14361f;

    /* renamed from: g  reason: collision with root package name */
    private int f14362g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f14363h = false;

    public m(a aVar) {
        super(aVar);
    }

    public int a() {
        return this.f14357a;
    }

    public int b() {
        return this.f14360e;
    }

    public int c() {
        return this.f14358c;
    }

    public int d() {
        return this.f14361f;
    }

    public int e() {
        return this.f14359d;
    }

    public int f() {
        return this.f14362g;
    }

    public boolean g() {
        return this.f14363h;
    }

    public int[] h() {
        Parameter b2 = this.f11557b.e().b("COMPASS_OFS_X");
        Parameter b3 = this.f11557b.e().b("COMPASS_OFS_Y");
        Parameter b4 = this.f11557b.e().b("COMPASS_OFS_Z");
        if (b2 == null || b3 == null || b4 == null) {
            return null;
        }
        return new int[]{(int) b2.f14456b, (int) b3.f14456b, (int) b4.f14456b};
    }

    public int[] i() {
        Parameter b2 = this.f11557b.e().b("COMPASS_OFS2_X");
        Parameter b3 = this.f11557b.e().b("COMPASS_OFS2_Y");
        Parameter b4 = this.f11557b.e().b("COMPASS_OFS2_Z");
        if (b2 == null || b3 == null || b4 == null) {
            return null;
        }
        return new int[]{(int) b2.f14456b, (int) b3.f14456b, (int) b4.f14456b};
    }
}
