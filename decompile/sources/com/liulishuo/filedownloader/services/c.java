package com.liulishuo.filedownloader.services;

import com.liulishuo.filedownloader.services.i;
import im.c;
import ip.b;
import iq.c;
import iq.d;
import iq.e;
import iq.f;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final a f21450a = null;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        c.C0196c f21451a;

        /* renamed from: b  reason: collision with root package name */
        Integer f21452b;

        /* renamed from: c  reason: collision with root package name */
        c.e f21453c;

        /* renamed from: d  reason: collision with root package name */
        c.b f21454d;

        /* renamed from: e  reason: collision with root package name */
        c.a f21455e;

        /* renamed from: f  reason: collision with root package name */
        c.d f21456f;

        /* renamed from: g  reason: collision with root package name */
        i f21457g;

        public String toString() {
            return f.a("component: database[%s], maxNetworkCount[%s], outputStream[%s], connection[%s], connectionCountAdapter[%s]", this.f21451a, this.f21452b, this.f21453c, this.f21454d, this.f21455e);
        }
    }

    private i h() {
        return new i.a().a(true).a();
    }

    private c.d i() {
        return new b();
    }

    private int j() {
        return e.a().f29062e;
    }

    private in.a k() {
        return new in.c();
    }

    private c.e l() {
        return new b.a();
    }

    private c.b m() {
        return new c.b();
    }

    private c.a n() {
        return new im.a();
    }

    public int a() {
        a aVar = this.f21450a;
        if (aVar == null) {
            return j();
        }
        Integer num = aVar.f21452b;
        if (num == null) {
            return j();
        }
        if (d.f29057a) {
            d.c(this, "initial FileDownloader manager with the customize maxNetworkThreadCount: %d", num);
        }
        return e.a(num.intValue());
    }

    public in.a b() {
        a aVar = this.f21450a;
        if (aVar == null || aVar.f21451a == null) {
            return k();
        }
        in.a a2 = this.f21450a.f21451a.a();
        if (a2 == null) {
            return k();
        }
        if (d.f29057a) {
            d.c(this, "initial FileDownloader manager with the customize database: %s", a2);
        }
        return a2;
    }

    public c.e c() {
        a aVar = this.f21450a;
        if (aVar == null) {
            return l();
        }
        c.e eVar = aVar.f21453c;
        if (eVar == null) {
            return l();
        }
        if (d.f29057a) {
            d.c(this, "initial FileDownloader manager with the customize output stream: %s", eVar);
        }
        return eVar;
    }

    public c.b d() {
        a aVar = this.f21450a;
        if (aVar == null) {
            return m();
        }
        c.b bVar = aVar.f21454d;
        if (bVar == null) {
            return m();
        }
        if (d.f29057a) {
            d.c(this, "initial FileDownloader manager with the customize connection creator: %s", bVar);
        }
        return bVar;
    }

    public c.a e() {
        a aVar = this.f21450a;
        if (aVar == null) {
            return n();
        }
        c.a aVar2 = aVar.f21455e;
        if (aVar2 == null) {
            return n();
        }
        if (d.f29057a) {
            d.c(this, "initial FileDownloader manager with the customize connection count adapter: %s", aVar2);
        }
        return aVar2;
    }

    public c.d f() {
        a aVar = this.f21450a;
        if (aVar == null) {
            return i();
        }
        c.d dVar = aVar.f21456f;
        if (dVar == null) {
            return i();
        }
        if (d.f29057a) {
            d.c(this, "initial FileDownloader manager with the customize id generator: %s", dVar);
        }
        return dVar;
    }

    public i g() {
        a aVar = this.f21450a;
        if (aVar == null) {
            return h();
        }
        i iVar = aVar.f21457g;
        if (iVar == null) {
            return h();
        }
        if (d.f29057a) {
            d.c(this, "initial FileDownloader manager with the customize foreground service config: %s", iVar);
        }
        return iVar;
    }
}
