package com.flypro.core.drone.variables;

import com.flypro.core.drone.d;
import dy.n;
import dy.p;
import ef.a;
import fg.i;
import org.greenrobot.eventbus.c;

public class j extends d {

    /* renamed from: a  reason: collision with root package name */
    private double f14347a = -1.0d;

    /* renamed from: c  reason: collision with root package name */
    private int f14348c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f14349d = -1;

    /* renamed from: e  reason: collision with root package name */
    private a f14350e;

    /* renamed from: f  reason: collision with root package name */
    private en.a f14351f;

    /* renamed from: g  reason: collision with root package name */
    private double f14352g = -1.0d;

    public j(en.a aVar) {
        super(aVar);
        this.f14351f = aVar;
    }

    public void a(double d2) {
        this.f14352g = d2;
    }

    public void a(int i2) {
        if (this.f14348c != i2) {
            this.f14348c = i2;
            if (i2 != -1) {
                this.f11557b.Q().a(this.f14348c);
            }
            c.a().d(new n(25));
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            if (!a()) {
                this.f14350e = aVar;
            } else if (this.f14350e.d() != aVar.d() || b().c() != aVar.c()) {
                this.f14350e = aVar;
                com.flypro.core.util.a.a().j();
                c.a().d(new p(23));
            }
        }
    }

    public boolean a() {
        return this.f14350e != null;
    }

    public a b() {
        return this.f14350e;
    }

    public double c() {
        return this.f14347a;
    }

    public int d() {
        return this.f14348c;
    }

    public String e() {
        int i2 = this.f14349d;
        return i2 != 2 ? i2 != 3 ? "NoFix" : "3D" : "2D";
    }

    public double f() {
        return a() ? this.f14352g : i.f27244a;
    }

    public int g() {
        return this.f14349d;
    }
}
