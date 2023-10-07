package io.reactivex.internal.disposables;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class b implements io.reactivex.disposables.b, a {

    /* renamed from: a  reason: collision with root package name */
    List<io.reactivex.disposables.b> f28702a;

    /* renamed from: b  reason: collision with root package name */
    volatile boolean f28703b;

    /* access modifiers changed from: package-private */
    public void a(List<io.reactivex.disposables.b> list) {
        if (list != null) {
            ArrayList arrayList = null;
            for (io.reactivex.disposables.b dispose : list) {
                try {
                    dispose.dispose();
                } catch (Throwable th) {
                    a.b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
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

    public boolean a(io.reactivex.disposables.b bVar) {
        lw.b.a(bVar, "d is null");
        if (!this.f28703b) {
            synchronized (this) {
                if (!this.f28703b) {
                    List list = this.f28702a;
                    if (list == null) {
                        list = new LinkedList();
                        this.f28702a = list;
                    }
                    list.add(bVar);
                    return true;
                }
            }
        }
        bVar.dispose();
        return false;
    }

    public boolean b(io.reactivex.disposables.b bVar) {
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
            boolean r0 = r2.f28703b
            r1 = 0
            if (r0 == 0) goto L_0x000b
            return r1
        L_0x000b:
            monitor-enter(r2)
            boolean r0 = r2.f28703b     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0012
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0012:
            java.util.List<io.reactivex.disposables.b> r0 = r2.f28702a     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0020
            boolean r3 = r0.remove(r3)     // Catch:{ all -> 0x0022 }
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
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.disposables.b.c(io.reactivex.disposables.b):boolean");
    }

    public void dispose() {
        if (!this.f28703b) {
            synchronized (this) {
                if (!this.f28703b) {
                    this.f28703b = true;
                    List<io.reactivex.disposables.b> list = this.f28702a;
                    this.f28702a = null;
                    a(list);
                }
            }
        }
    }

    public boolean isDisposed() {
        return this.f28703b;
    }
}
