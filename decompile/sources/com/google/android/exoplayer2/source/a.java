package com.google.android.exoplayer2.source;

import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.af;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.upstream.t;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public abstract class a implements i {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<i.b> f16013a = new ArrayList<>(1);

    /* renamed from: b  reason: collision with root package name */
    private final HashSet<i.b> f16014b = new HashSet<>(1);

    /* renamed from: c  reason: collision with root package name */
    private final j.a f16015c = new j.a();

    /* renamed from: d  reason: collision with root package name */
    private Looper f16016d;

    /* renamed from: e  reason: collision with root package name */
    private af f16017e;

    /* access modifiers changed from: protected */
    public final j.a a(i.a aVar) {
        return this.f16015c.a(0, aVar, 0);
    }

    /* access modifiers changed from: protected */
    public final j.a a(i.a aVar, long j2) {
        com.google.android.exoplayer2.util.a.a(aVar != null);
        return this.f16015c.a(0, aVar, j2);
    }

    /* access modifiers changed from: protected */
    public void a() {
    }

    public final void a(Handler handler, j jVar) {
        this.f16015c.a(handler, jVar);
    }

    /* access modifiers changed from: protected */
    public final void a(af afVar) {
        this.f16017e = afVar;
        Iterator<i.b> it2 = this.f16013a.iterator();
        while (it2.hasNext()) {
            it2.next().a(this, afVar);
        }
    }

    public final void a(i.b bVar) {
        com.google.android.exoplayer2.util.a.b(this.f16016d);
        boolean isEmpty = this.f16014b.isEmpty();
        this.f16014b.add(bVar);
        if (isEmpty) {
            a();
        }
    }

    public final void a(i.b bVar, t tVar) {
        Looper myLooper = Looper.myLooper();
        Looper looper = this.f16016d;
        com.google.android.exoplayer2.util.a.a(looper == null || looper == myLooper);
        af afVar = this.f16017e;
        this.f16013a.add(bVar);
        if (this.f16016d == null) {
            this.f16016d = myLooper;
            this.f16014b.add(bVar);
            a(tVar);
        } else if (afVar != null) {
            a(bVar);
            bVar.a(this, afVar);
        }
    }

    public final void a(j jVar) {
        this.f16015c.a(jVar);
    }

    /* access modifiers changed from: protected */
    public abstract void a(t tVar);

    /* access modifiers changed from: protected */
    public void b() {
    }

    public final void b(i.b bVar) {
        boolean z2 = !this.f16014b.isEmpty();
        this.f16014b.remove(bVar);
        if (z2 && this.f16014b.isEmpty()) {
            b();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void c();

    public final void c(i.b bVar) {
        this.f16013a.remove(bVar);
        if (this.f16013a.isEmpty()) {
            this.f16016d = null;
            this.f16017e = null;
            this.f16014b.clear();
            c();
            return;
        }
        b(bVar);
    }
}
