package com.cloudbufferfly.uicorelib.baseview;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import kotlin.jvm.internal.h;

public final class f implements h, i {

    /* renamed from: a  reason: collision with root package name */
    private View f10720a;

    /* renamed from: b  reason: collision with root package name */
    private i f10721b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10722c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10723d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10724e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10725f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10726g;

    /* renamed from: h  reason: collision with root package name */
    private j f10727h;

    /* renamed from: i  reason: collision with root package name */
    private Handler f10728i = new Handler();

    public f(View view) {
        this.f10720a = view;
        this.f10721b = (i) view;
    }

    private final void m() {
        SupportActivity l2;
        if ((l() instanceof j) && (l2 = l()) != null) {
            l2.a(this);
        }
    }

    private final void n() {
        SupportActivity l2;
        if ((l() instanceof j) && (l2 = l()) != null) {
            l2.b(this);
        }
    }

    public final void a() {
        m();
    }

    public void a(int i2, int i3, Intent intent) {
        i iVar = this.f10721b;
        if (iVar != null) {
            iVar.a(i2, i3, intent);
        }
    }

    public void a(Intent intent) {
        i iVar = this.f10721b;
        if (iVar != null) {
            iVar.a(intent);
        }
    }

    public void a(j jVar) {
        j jVar2;
        if ((!h.a((Object) jVar, (Object) this.f10727h)) && (jVar2 = this.f10727h) != null) {
            jVar2.b(this);
        }
        this.f10727h = jVar;
    }

    public void b() {
        this.f10724e = true;
        i iVar = this.f10721b;
        if (iVar != null) {
            iVar.d();
        }
        i iVar2 = this.f10721b;
        if (iVar2 != null) {
            iVar2.e();
        }
        f();
        g();
    }

    public void c() {
        k();
        n();
        this.f10724e = false;
    }

    public void d() {
    }

    public void e() {
    }

    public void f() {
        if (this.f10724e && !this.f10725f) {
            this.f10725f = true;
            i iVar = this.f10721b;
            if (iVar != null) {
                iVar.f();
            }
        }
    }

    public void g() {
        if (this.f10724e && !this.f10726g) {
            this.f10726g = true;
            i iVar = this.f10721b;
            if (iVar != null) {
                iVar.g();
            }
        }
    }

    public i getLifecycleDelegate() {
        return this;
    }

    public void h() {
        if (!this.f10723d) {
            this.f10726g = false;
            i iVar = this.f10721b;
            if (iVar != null) {
                iVar.h();
            }
        }
    }

    public void i() {
        if (this.f10725f && !this.f10723d) {
            this.f10725f = false;
            i iVar = this.f10721b;
            if (iVar != null) {
                iVar.i();
            }
        }
    }

    public void j() {
    }

    public void k() {
        i iVar;
        if (this.f10724e && !this.f10723d) {
            this.f10723d = true;
            if (this.f10725f) {
                this.f10725f = false;
                i iVar2 = this.f10721b;
                if (iVar2 != null) {
                    iVar2.i();
                }
            }
            if (this.f10726g && (iVar = this.f10721b) != null) {
                iVar.h();
            }
            i iVar3 = this.f10721b;
            if (iVar3 != null) {
                iVar3.j();
            }
            i iVar4 = this.f10721b;
            if (iVar4 != null) {
                iVar4.k();
            }
            this.f10727h = null;
        }
    }

    /* access modifiers changed from: protected */
    public final SupportActivity l() {
        a aVar = a.f10694a;
        View view = this.f10720a;
        if (view == null) {
            h.a();
        }
        return aVar.a(view);
    }

    public void onWindowFocusChanged(boolean z2) {
        if (z2 && !this.f10722c) {
            this.f10722c = true;
        }
    }
}
