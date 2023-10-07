package com.liulishuo.filedownloader;

import android.content.Context;
import com.liulishuo.filedownloader.a;
import iq.c;
import iq.d;

public class q {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f21436a = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static final Object f21437c = new Object();

    /* renamed from: b  reason: collision with root package name */
    private w f21438b;

    /* renamed from: d  reason: collision with root package name */
    private v f21439d;

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final q f21440a = new q();
    }

    public static q a() {
        return a.f21440a;
    }

    public static void a(Context context) {
        c.a(context.getApplicationContext());
    }

    public a a(String str) {
        return new c(str);
    }

    public void a(e eVar) {
        f.a().a("event.service.connect.changed", (com.liulishuo.filedownloader.event.c) eVar);
    }

    public void a(boolean z2) {
        m.a().a(z2);
    }

    public boolean a(int i2) {
        if (h.a().b()) {
            return m.a().c(i2);
        }
        d.d(this, "Can't change the max network thread count, because there are actively executing tasks in FileDownloader, please try again after all actively executing tasks are completed or invoking FileDownloader#pauseAll directly.", new Object[0]);
        return false;
    }

    public void b() {
        p.a().b();
        for (a.b A : h.a().d()) {
            A.A().d();
        }
        if (m.a().d()) {
            m.a().c();
        } else {
            ab.a();
        }
    }

    public void c() {
        b();
        m.a().e();
    }

    public void d() {
        if (!f()) {
            m.a().a(c.a());
        }
    }

    public void e() {
        if (f()) {
            m.a().b(c.a());
        }
    }

    public boolean f() {
        return m.a().d();
    }

    /* access modifiers changed from: package-private */
    public w g() {
        if (this.f21438b == null) {
            synchronized (f21436a) {
                if (this.f21438b == null) {
                    this.f21438b = new ac();
                }
            }
        }
        return this.f21438b;
    }

    /* access modifiers changed from: package-private */
    public v h() {
        if (this.f21439d == null) {
            synchronized (f21437c) {
                if (this.f21439d == null) {
                    z zVar = new z();
                    this.f21439d = zVar;
                    a((e) zVar);
                }
            }
        }
        return this.f21439d;
    }
}
