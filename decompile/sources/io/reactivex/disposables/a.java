package io.reactivex.disposables;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.d;
import java.util.ArrayList;
import lw.b;

public final class a implements b, io.reactivex.internal.disposables.a {

    /* renamed from: a  reason: collision with root package name */
    d<b> f28676a;

    /* renamed from: b  reason: collision with root package name */
    volatile boolean f28677b;

    public void a() {
        if (!this.f28677b) {
            synchronized (this) {
                if (!this.f28677b) {
                    d<b> dVar = this.f28676a;
                    this.f28676a = null;
                    a(dVar);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(d<b> dVar) {
        if (dVar != null) {
            ArrayList arrayList = null;
            for (Object obj : dVar.b()) {
                if (obj instanceof b) {
                    try {
                        ((b) obj).dispose();
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(th);
                    }
                }
            }
            if (arrayList == null) {
                return;
            }
            if (arrayList.size() == 1) {
                throw ExceptionHelper.a((Throwable) arrayList.get(0));
            }
            throw new CompositeException((Iterable<? extends Throwable>) arrayList);
        }
    }

    public boolean a(b bVar) {
        b.a(bVar, "d is null");
        if (!this.f28677b) {
            synchronized (this) {
                if (!this.f28677b) {
                    d<b> dVar = this.f28676a;
                    if (dVar == null) {
                        dVar = new d<>();
                        this.f28676a = dVar;
                    }
                    dVar.a(bVar);
                    return true;
                }
            }
        }
        bVar.dispose();
        return false;
    }

    public boolean b(b bVar) {
        if (!c(bVar)) {
            return false;
        }
        bVar.dispose();
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean c(io.reactivex.disposables.b r3) {
        /*
            r2 = this;
            java.lang.String r0 = "Disposable item is null"
            lw.b.a(r3, (java.lang.String) r0)
            boolean r0 = r2.f28677b
            r1 = 0
            if (r0 == 0) goto L_0x000b
            return r1
        L_0x000b:
            monitor-enter(r2)
            boolean r0 = r2.f28677b     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0012
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0012:
            io.reactivex.internal.util.d<io.reactivex.disposables.b> r0 = r2.f28676a     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0020
            boolean r3 = r0.b(r3)     // Catch:{ all -> 0x0022 }
            if (r3 != 0) goto L_0x001d
            goto L_0x0020
        L_0x001d:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            r3 = 1
            return r3
        L_0x0020:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0022:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.disposables.a.c(io.reactivex.disposables.b):boolean");
    }

    public void dispose() {
        if (!this.f28677b) {
            synchronized (this) {
                if (!this.f28677b) {
                    this.f28677b = true;
                    d<b> dVar = this.f28676a;
                    this.f28676a = null;
                    a(dVar);
                }
            }
        }
    }

    public boolean isDisposed() {
        return this.f28677b;
    }
}
