package com.bumptech.glide.load.engine;

import android.util.Log;
import bo.n;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.engine.e;
import java.io.IOException;
import java.util.List;

class w implements e, e.a {

    /* renamed from: a  reason: collision with root package name */
    private final f<?> f10413a;

    /* renamed from: b  reason: collision with root package name */
    private final e.a f10414b;

    /* renamed from: c  reason: collision with root package name */
    private volatile int f10415c;

    /* renamed from: d  reason: collision with root package name */
    private volatile b f10416d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Object f10417e;

    /* renamed from: f  reason: collision with root package name */
    private volatile n.a<?> f10418f;

    /* renamed from: g  reason: collision with root package name */
    private volatile c f10419g;

    w(f<?> fVar, e.a aVar) {
        this.f10413a = fVar;
        this.f10414b = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00e0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.lang.Object r13) throws java.io.IOException {
        /*
            r12 = this;
            java.lang.String r0 = "SourceGenerator"
            long r1 = cc.g.a()
            r3 = 1
            r4 = 0
            com.bumptech.glide.load.engine.f<?> r5 = r12.f10413a     // Catch:{ all -> 0x00dc }
            com.bumptech.glide.load.data.e r5 = r5.a(r13)     // Catch:{ all -> 0x00dc }
            java.lang.Object r6 = r5.a()     // Catch:{ all -> 0x00dc }
            com.bumptech.glide.load.engine.f<?> r7 = r12.f10413a     // Catch:{ all -> 0x00dc }
            com.bumptech.glide.load.a r7 = r7.b(r6)     // Catch:{ all -> 0x00dc }
            com.bumptech.glide.load.engine.d r8 = new com.bumptech.glide.load.engine.d     // Catch:{ all -> 0x00dc }
            com.bumptech.glide.load.engine.f<?> r9 = r12.f10413a     // Catch:{ all -> 0x00dc }
            com.bumptech.glide.load.f r9 = r9.e()     // Catch:{ all -> 0x00dc }
            r8.<init>(r7, r6, r9)     // Catch:{ all -> 0x00dc }
            com.bumptech.glide.load.engine.c r6 = new com.bumptech.glide.load.engine.c     // Catch:{ all -> 0x00dc }
            bo.n$a<?> r9 = r12.f10418f     // Catch:{ all -> 0x00dc }
            com.bumptech.glide.load.c r9 = r9.f5901a     // Catch:{ all -> 0x00dc }
            com.bumptech.glide.load.engine.f<?> r10 = r12.f10413a     // Catch:{ all -> 0x00dc }
            com.bumptech.glide.load.c r10 = r10.f()     // Catch:{ all -> 0x00dc }
            r6.<init>(r9, r10)     // Catch:{ all -> 0x00dc }
            com.bumptech.glide.load.engine.f<?> r9 = r12.f10413a     // Catch:{ all -> 0x00dc }
            bm.a r9 = r9.b()     // Catch:{ all -> 0x00dc }
            r9.a(r6, r8)     // Catch:{ all -> 0x00dc }
            r8 = 2
            boolean r8 = android.util.Log.isLoggable(r0, r8)     // Catch:{ all -> 0x00dc }
            java.lang.String r10 = ", data: "
            if (r8 == 0) goto L_0x0072
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00dc }
            r8.<init>()     // Catch:{ all -> 0x00dc }
            java.lang.String r11 = "Finished encoding source to cache, key: "
            r8.append(r11)     // Catch:{ all -> 0x00dc }
            r8.append(r6)     // Catch:{ all -> 0x00dc }
            r8.append(r10)     // Catch:{ all -> 0x00dc }
            r8.append(r13)     // Catch:{ all -> 0x00dc }
            java.lang.String r11 = ", encoder: "
            r8.append(r11)     // Catch:{ all -> 0x00dc }
            r8.append(r7)     // Catch:{ all -> 0x00dc }
            java.lang.String r7 = ", duration: "
            r8.append(r7)     // Catch:{ all -> 0x00dc }
            double r1 = cc.g.a(r1)     // Catch:{ all -> 0x00dc }
            r8.append(r1)     // Catch:{ all -> 0x00dc }
            java.lang.String r1 = r8.toString()     // Catch:{ all -> 0x00dc }
            android.util.Log.v(r0, r1)     // Catch:{ all -> 0x00dc }
        L_0x0072:
            java.io.File r1 = r9.a(r6)     // Catch:{ all -> 0x00dc }
            if (r1 == 0) goto L_0x0093
            r12.f10419g = r6     // Catch:{ all -> 0x00dc }
            com.bumptech.glide.load.engine.b r13 = new com.bumptech.glide.load.engine.b     // Catch:{ all -> 0x00dc }
            bo.n$a<?> r0 = r12.f10418f     // Catch:{ all -> 0x00dc }
            com.bumptech.glide.load.c r0 = r0.f5901a     // Catch:{ all -> 0x00dc }
            java.util.List r0 = java.util.Collections.singletonList(r0)     // Catch:{ all -> 0x00dc }
            com.bumptech.glide.load.engine.f<?> r1 = r12.f10413a     // Catch:{ all -> 0x00dc }
            r13.<init>(r0, r1, r12)     // Catch:{ all -> 0x00dc }
            r12.f10416d = r13     // Catch:{ all -> 0x00dc }
            bo.n$a<?> r13 = r12.f10418f
            com.bumptech.glide.load.data.d<Data> r13 = r13.f5903c
            r13.b()
            return r3
        L_0x0093:
            r1 = 3
            boolean r1 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00dc }
            if (r1 == 0) goto L_0x00bb
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00dc }
            r1.<init>()     // Catch:{ all -> 0x00dc }
            java.lang.String r2 = "Attempt to write: "
            r1.append(r2)     // Catch:{ all -> 0x00dc }
            com.bumptech.glide.load.engine.c r2 = r12.f10419g     // Catch:{ all -> 0x00dc }
            r1.append(r2)     // Catch:{ all -> 0x00dc }
            r1.append(r10)     // Catch:{ all -> 0x00dc }
            r1.append(r13)     // Catch:{ all -> 0x00dc }
            java.lang.String r13 = " to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly..."
            r1.append(r13)     // Catch:{ all -> 0x00dc }
            java.lang.String r13 = r1.toString()     // Catch:{ all -> 0x00dc }
            android.util.Log.d(r0, r13)     // Catch:{ all -> 0x00dc }
        L_0x00bb:
            com.bumptech.glide.load.engine.e$a r13 = r12.f10414b     // Catch:{ all -> 0x00da }
            bo.n$a<?> r0 = r12.f10418f     // Catch:{ all -> 0x00da }
            com.bumptech.glide.load.c r6 = r0.f5901a     // Catch:{ all -> 0x00da }
            java.lang.Object r7 = r5.a()     // Catch:{ all -> 0x00da }
            bo.n$a<?> r0 = r12.f10418f     // Catch:{ all -> 0x00da }
            com.bumptech.glide.load.data.d<Data> r8 = r0.f5903c     // Catch:{ all -> 0x00da }
            bo.n$a<?> r0 = r12.f10418f     // Catch:{ all -> 0x00da }
            com.bumptech.glide.load.data.d<Data> r0 = r0.f5903c     // Catch:{ all -> 0x00da }
            com.bumptech.glide.load.DataSource r9 = r0.d()     // Catch:{ all -> 0x00da }
            bo.n$a<?> r0 = r12.f10418f     // Catch:{ all -> 0x00da }
            com.bumptech.glide.load.c r10 = r0.f5901a     // Catch:{ all -> 0x00da }
            r5 = r13
            r5.a(r6, r7, r8, r9, r10)     // Catch:{ all -> 0x00da }
            return r4
        L_0x00da:
            r13 = move-exception
            goto L_0x00de
        L_0x00dc:
            r13 = move-exception
            r3 = 0
        L_0x00de:
            if (r3 != 0) goto L_0x00e7
            bo.n$a<?> r0 = r12.f10418f
            com.bumptech.glide.load.data.d<Data> r0 = r0.f5903c
            r0.b()
        L_0x00e7:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.w.a(java.lang.Object):boolean");
    }

    private void b(final n.a<?> aVar) {
        this.f10418f.f5903c.a(this.f10413a.d(), new d.a<Object>() {
            public void a(Exception exc) {
                if (w.this.a((n.a<?>) aVar)) {
                    w.this.a((n.a<?>) aVar, exc);
                }
            }

            public void a(Object obj) {
                if (w.this.a((n.a<?>) aVar)) {
                    w.this.a((n.a<?>) aVar, obj);
                }
            }
        });
    }

    private boolean d() {
        return this.f10415c < this.f10413a.n().size();
    }

    /* access modifiers changed from: package-private */
    public void a(n.a<?> aVar, Exception exc) {
        this.f10414b.a(this.f10419g, exc, aVar.f5903c, aVar.f5903c.d());
    }

    /* access modifiers changed from: package-private */
    public void a(n.a<?> aVar, Object obj) {
        h c2 = this.f10413a.c();
        if (obj == null || !c2.a(aVar.f5903c.d())) {
            this.f10414b.a(aVar.f5901a, obj, aVar.f5903c, aVar.f5903c.d(), this.f10419g);
            return;
        }
        this.f10417e = obj;
        this.f10414b.c();
    }

    public void a(c cVar, Exception exc, d<?> dVar, DataSource dataSource) {
        this.f10414b.a(cVar, exc, dVar, this.f10418f.f5903c.d());
    }

    public void a(c cVar, Object obj, d<?> dVar, DataSource dataSource, c cVar2) {
        this.f10414b.a(cVar, obj, dVar, this.f10418f.f5903c.d(), cVar);
    }

    public boolean a() {
        if (this.f10417e != null) {
            Object obj = this.f10417e;
            this.f10417e = null;
            try {
                if (!a(obj)) {
                    return true;
                }
            } catch (IOException e2) {
                if (Log.isLoggable("SourceGenerator", 3)) {
                    Log.d("SourceGenerator", "Failed to properly rewind or write data to cache", e2);
                }
            }
        }
        if (this.f10416d != null && this.f10416d.a()) {
            return true;
        }
        this.f10416d = null;
        this.f10418f = null;
        boolean z2 = false;
        while (!z2 && d()) {
            List<n.a<?>> n2 = this.f10413a.n();
            int i2 = this.f10415c;
            this.f10415c = i2 + 1;
            this.f10418f = n2.get(i2);
            if (this.f10418f != null && (this.f10413a.c().a(this.f10418f.f5903c.d()) || this.f10413a.a((Class<?>) this.f10418f.f5903c.a()))) {
                b(this.f10418f);
                z2 = true;
            }
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    public boolean a(n.a<?> aVar) {
        n.a<?> aVar2 = this.f10418f;
        return aVar2 != null && aVar2 == aVar;
    }

    public void b() {
        n.a<?> aVar = this.f10418f;
        if (aVar != null) {
            aVar.f5903c.c();
        }
    }

    public void c() {
        throw new UnsupportedOperationException();
    }
}
