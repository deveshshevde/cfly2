package com.github.barteksc.pdfviewer;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.github.barteksc.pdfviewer.util.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

class b {

    /* renamed from: a  reason: collision with root package name */
    private final PriorityQueue<ev.b> f14585a;

    /* renamed from: b  reason: collision with root package name */
    private final PriorityQueue<ev.b> f14586b;

    /* renamed from: c  reason: collision with root package name */
    private final List<ev.b> f14587c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f14588d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private final a f14589e;

    class a implements Comparator<ev.b> {
        a() {
        }

        /* renamed from: a */
        public int compare(ev.b bVar, ev.b bVar2) {
            if (bVar.a() == bVar2.a()) {
                return 0;
            }
            return bVar.a() > bVar2.a() ? 1 : -1;
        }
    }

    public b() {
        a aVar = new a();
        this.f14589e = aVar;
        this.f14586b = new PriorityQueue<>(a.C0106a.f14688a, aVar);
        this.f14585a = new PriorityQueue<>(a.C0106a.f14688a, aVar);
        this.f14587c = new ArrayList();
    }

    private static ev.b a(PriorityQueue<ev.b> priorityQueue, ev.b bVar) {
        Iterator<ev.b> it2 = priorityQueue.iterator();
        while (it2.hasNext()) {
            ev.b next = it2.next();
            if (next.equals(bVar)) {
                return next;
            }
        }
        return null;
    }

    private void a(Collection<ev.b> collection, ev.b bVar) {
        for (ev.b equals : collection) {
            if (equals.equals(bVar)) {
                bVar.c().recycle();
                return;
            }
        }
        collection.add(bVar);
    }

    private void e() {
        synchronized (this.f14588d) {
            while (this.f14586b.size() + this.f14585a.size() >= a.C0106a.f14688a && !this.f14585a.isEmpty()) {
                this.f14585a.poll().c().recycle();
            }
            while (this.f14586b.size() + this.f14585a.size() >= a.C0106a.f14688a && !this.f14586b.isEmpty()) {
                this.f14586b.poll().c().recycle();
            }
        }
    }

    public void a() {
        synchronized (this.f14588d) {
            this.f14585a.addAll(this.f14586b);
            this.f14586b.clear();
        }
    }

    public void a(ev.b bVar) {
        synchronized (this.f14588d) {
            e();
            this.f14586b.offer(bVar);
        }
    }

    public boolean a(int i2, RectF rectF) {
        ev.b bVar = new ev.b(i2, (Bitmap) null, rectF, true, 0);
        synchronized (this.f14587c) {
            for (ev.b equals : this.f14587c) {
                if (equals.equals(bVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(int r8, android.graphics.RectF r9, int r10) {
        /*
            r7 = this;
            ev.b r6 = new ev.b
            r2 = 0
            r4 = 0
            r5 = 0
            r0 = r6
            r1 = r8
            r3 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            java.lang.Object r8 = r7.f14588d
            monitor-enter(r8)
            java.util.PriorityQueue<ev.b> r9 = r7.f14585a     // Catch:{ all -> 0x0032 }
            ev.b r9 = a((java.util.PriorityQueue<ev.b>) r9, (ev.b) r6)     // Catch:{ all -> 0x0032 }
            r0 = 1
            if (r9 == 0) goto L_0x0026
            java.util.PriorityQueue<ev.b> r1 = r7.f14585a     // Catch:{ all -> 0x0032 }
            r1.remove(r9)     // Catch:{ all -> 0x0032 }
            r9.a(r10)     // Catch:{ all -> 0x0032 }
            java.util.PriorityQueue<ev.b> r10 = r7.f14586b     // Catch:{ all -> 0x0032 }
            r10.offer(r9)     // Catch:{ all -> 0x0032 }
            monitor-exit(r8)     // Catch:{ all -> 0x0032 }
            return r0
        L_0x0026:
            java.util.PriorityQueue<ev.b> r9 = r7.f14586b     // Catch:{ all -> 0x0032 }
            ev.b r9 = a((java.util.PriorityQueue<ev.b>) r9, (ev.b) r6)     // Catch:{ all -> 0x0032 }
            if (r9 == 0) goto L_0x002f
            goto L_0x0030
        L_0x002f:
            r0 = 0
        L_0x0030:
            monitor-exit(r8)     // Catch:{ all -> 0x0032 }
            return r0
        L_0x0032:
            r9 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0032 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.barteksc.pdfviewer.b.a(int, android.graphics.RectF, int):boolean");
    }

    public List<ev.b> b() {
        ArrayList arrayList;
        synchronized (this.f14588d) {
            arrayList = new ArrayList(this.f14585a);
            arrayList.addAll(this.f14586b);
        }
        return arrayList;
    }

    public void b(ev.b bVar) {
        synchronized (this.f14587c) {
            while (this.f14587c.size() >= a.C0106a.f14689b) {
                this.f14587c.remove(0).c().recycle();
            }
            a((Collection<ev.b>) this.f14587c, bVar);
        }
    }

    public List<ev.b> c() {
        List<ev.b> list;
        synchronized (this.f14587c) {
            list = this.f14587c;
        }
        return list;
    }

    public void d() {
        synchronized (this.f14588d) {
            Iterator<ev.b> it2 = this.f14585a.iterator();
            while (it2.hasNext()) {
                it2.next().c().recycle();
            }
            this.f14585a.clear();
            Iterator<ev.b> it3 = this.f14586b.iterator();
            while (it3.hasNext()) {
                it3.next().c().recycle();
            }
            this.f14586b.clear();
        }
        synchronized (this.f14587c) {
            for (ev.b c2 : this.f14587c) {
                c2.c().recycle();
            }
            this.f14587c.clear();
        }
    }
}
