package com.cloudbufferfly.uicorelib.baseview;

import cq.a;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.h;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;

public abstract class e<UIIterface> {

    /* renamed from: a  reason: collision with root package name */
    private Reference<UIIterface> f10719a;

    public final void a() {
        Reference<UIIterface> reference = this.f10719a;
        if (reference != null) {
            reference.clear();
        }
        this.f10719a = null;
    }

    public final void a(UIIterface uiiterface) {
        this.f10719a = new WeakReference(uiiterface);
    }

    public final void b() {
        a.f26246a.a(this);
    }

    public final void c() {
    }

    public final void d() {
    }

    @l(a = ThreadMode.MAIN)
    public final void defaultEvent(String str) {
        h.c(str, "event");
    }

    public final void e() {
    }

    public final void f() {
        a.f26246a.b(this);
    }

    public final void g() {
        a.f26246a.b(this);
    }

    public final void h() {
    }
}
