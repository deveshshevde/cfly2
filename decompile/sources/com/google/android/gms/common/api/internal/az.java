package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.m;
import gk.f;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class az implements bq, db {

    /* renamed from: a  reason: collision with root package name */
    final Map<a.c<?>, a.f> f11782a;

    /* renamed from: b  reason: collision with root package name */
    final Map<a.c<?>, ConnectionResult> f11783b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    final e f11784c;

    /* renamed from: d  reason: collision with root package name */
    final Map<a<?>, Boolean> f11785d;

    /* renamed from: e  reason: collision with root package name */
    final a.C0118a<? extends f, gk.a> f11786e;

    /* renamed from: f  reason: collision with root package name */
    int f11787f;

    /* renamed from: g  reason: collision with root package name */
    final av f11788g;

    /* renamed from: h  reason: collision with root package name */
    final bo f11789h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final Lock f11790i;

    /* renamed from: j  reason: collision with root package name */
    private final Condition f11791j;

    /* renamed from: k  reason: collision with root package name */
    private final Context f11792k;

    /* renamed from: l  reason: collision with root package name */
    private final d f11793l;

    /* renamed from: m  reason: collision with root package name */
    private final ay f11794m;
    /* access modifiers changed from: private */
    @NotOnlyInitialized

    /* renamed from: n  reason: collision with root package name */
    public volatile aw f11795n;

    /* renamed from: o  reason: collision with root package name */
    private ConnectionResult f11796o = null;

    public az(Context context, av avVar, Lock lock, Looper looper, d dVar, Map<a.c<?>, a.f> map, e eVar, Map<a<?>, Boolean> map2, a.C0118a<? extends f, gk.a> aVar, ArrayList<da> arrayList, bo boVar) {
        this.f11792k = context;
        this.f11790i = lock;
        this.f11793l = dVar;
        this.f11782a = map;
        this.f11784c = eVar;
        this.f11785d = map2;
        this.f11786e = aVar;
        this.f11788g = avVar;
        this.f11789h = boVar;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.get(i2).a((db) this);
        }
        this.f11794m = new ay(this, looper);
        this.f11791j = lock.newCondition();
        this.f11795n = new ar(this);
    }

    public final <A extends a.b, R extends g, T extends d.a<R, A>> T a(T t2) {
        t2.zak();
        this.f11795n.a(t2);
        return t2;
    }

    public final void a() {
        this.f11795n.b();
    }

    public final void a(int i2) {
        this.f11790i.lock();
        try {
            this.f11795n.a(i2);
        } finally {
            this.f11790i.unlock();
        }
    }

    public final void a(Bundle bundle) {
        this.f11790i.lock();
        try {
            this.f11795n.a(bundle);
        } finally {
            this.f11790i.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(ConnectionResult connectionResult) {
        this.f11790i.lock();
        try {
            this.f11796o = connectionResult;
            this.f11795n = new ar(this);
            this.f11795n.a();
            this.f11791j.signalAll();
        } finally {
            this.f11790i.unlock();
        }
    }

    public final void a(ConnectionResult connectionResult, a<?> aVar, boolean z2) {
        this.f11790i.lock();
        try {
            this.f11795n.a(connectionResult, aVar, z2);
        } finally {
            this.f11790i.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(ax axVar) {
        this.f11794m.sendMessage(this.f11794m.obtainMessage(1, axVar));
    }

    /* access modifiers changed from: package-private */
    public final void a(RuntimeException runtimeException) {
        this.f11794m.sendMessage(this.f11794m.obtainMessage(2, runtimeException));
    }

    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append(str).append("mState=").println(this.f11795n);
        for (a next : this.f11785d.keySet()) {
            printWriter.append(str).append(next.d()).println(":");
            ((a.f) m.a(this.f11782a.get(next.b()))).dump(concat, fileDescriptor, printWriter, strArr);
        }
    }

    public final <A extends a.b, T extends d.a<? extends g, A>> T b(T t2) {
        t2.zak();
        return this.f11795n.b(t2);
    }

    public final void b() {
        if (this.f11795n.d()) {
            this.f11783b.clear();
        }
    }

    public final void c() {
        if (this.f11795n instanceof ad) {
            ((ad) this.f11795n).c();
        }
    }

    public final boolean d() {
        return this.f11795n instanceof ad;
    }

    public final boolean e() {
        return this.f11795n instanceof aq;
    }

    /* access modifiers changed from: package-private */
    public final void f() {
        this.f11790i.lock();
        try {
            this.f11788g.h();
            this.f11795n = new ad(this);
            this.f11795n.a();
            this.f11791j.signalAll();
        } finally {
            this.f11790i.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final void g() {
        this.f11790i.lock();
        try {
            this.f11795n = new aq(this, this.f11784c, this.f11785d, this.f11793l, this.f11786e, this.f11790i, this.f11792k);
            this.f11795n.a();
            this.f11791j.signalAll();
        } finally {
            this.f11790i.unlock();
        }
    }
}
