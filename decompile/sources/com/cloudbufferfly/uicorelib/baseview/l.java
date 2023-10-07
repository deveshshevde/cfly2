package com.cloudbufferfly.uicorelib.baseview;

import android.content.Intent;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.TypeCastException;
import kotlin.jvm.internal.h;

public final class l implements i, j {

    /* renamed from: a  reason: collision with root package name */
    private final CopyOnWriteArrayList<i> f10733a = new CopyOnWriteArrayList<>();

    public void a() {
    }

    public void a(int i2, int i3, Intent intent) {
        Iterator<i> it2 = this.f10733a.iterator();
        h.a((Object) it2, "mLifecycleList.iterator()");
        while (it2.hasNext()) {
            i next = it2.next();
            if (next != null) {
                next.a(i2, i3, intent);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.cloudbufferfly.uicorelib.baseview.IViewLifecycle");
            }
        }
    }

    public void a(Intent intent) {
        Iterator<i> it2 = this.f10733a.iterator();
        h.a((Object) it2, "mLifecycleList.iterator()");
        while (it2.hasNext()) {
            i next = it2.next();
            if (next != null) {
                next.a(intent);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.cloudbufferfly.uicorelib.baseview.IViewLifecycle");
            }
        }
    }

    public void a(i iVar) {
        if (!this.f10733a.contains(iVar)) {
            if (iVar instanceof h) {
                ((h) iVar).a(this);
            }
            this.f10733a.add(iVar);
        }
    }

    public void b() {
    }

    public void b(i iVar) {
        this.f10733a.remove(iVar);
    }

    public void d() {
    }

    public void e() {
    }

    public void f() {
        Iterator<i> it2 = this.f10733a.iterator();
        h.a((Object) it2, "mLifecycleList.iterator()");
        while (it2.hasNext()) {
            i next = it2.next();
            if (next != null) {
                next.f();
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.cloudbufferfly.uicorelib.baseview.IViewLifecycle");
            }
        }
    }

    public void g() {
        Iterator<i> it2 = this.f10733a.iterator();
        h.a((Object) it2, "mLifecycleList.iterator()");
        while (it2.hasNext()) {
            i next = it2.next();
            if (next != null) {
                next.g();
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.cloudbufferfly.uicorelib.baseview.IViewLifecycle");
            }
        }
    }

    public i getLifecycleDelegate() {
        return this;
    }

    public void h() {
        Iterator<i> it2 = this.f10733a.iterator();
        h.a((Object) it2, "mLifecycleList.iterator()");
        while (it2.hasNext()) {
            i next = it2.next();
            if (next != null) {
                next.h();
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.cloudbufferfly.uicorelib.baseview.IViewLifecycle");
            }
        }
    }

    public void i() {
        Iterator<i> it2 = this.f10733a.iterator();
        h.a((Object) it2, "mLifecycleList.iterator()");
        while (it2.hasNext()) {
            i next = it2.next();
            if (next != null) {
                next.i();
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.cloudbufferfly.uicorelib.baseview.IViewLifecycle");
            }
        }
    }

    public void j() {
    }

    public void k() {
        Iterator<i> it2 = this.f10733a.iterator();
        h.a((Object) it2, "mLifecycleList.iterator()");
        while (it2.hasNext()) {
            i next = it2.next();
            if (next != null) {
                next.k();
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.cloudbufferfly.uicorelib.baseview.IViewLifecycle");
            }
        }
    }

    public void onWindowFocusChanged(boolean z2) {
        Iterator<i> it2 = this.f10733a.iterator();
        h.a((Object) it2, "mLifecycleList.iterator()");
        while (it2.hasNext()) {
            i next = it2.next();
            if (next != null) {
                next.onWindowFocusChanged(z2);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.cloudbufferfly.uicorelib.baseview.IViewLifecycle");
            }
        }
    }
}
