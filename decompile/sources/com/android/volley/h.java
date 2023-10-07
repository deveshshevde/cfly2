package com.android.volley;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private AtomicInteger f9921a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Queue<Request>> f9922b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Request> f9923c;

    /* renamed from: d  reason: collision with root package name */
    private final PriorityBlockingQueue<Request> f9924d;

    /* renamed from: e  reason: collision with root package name */
    private final PriorityBlockingQueue<Request> f9925e;

    /* renamed from: f  reason: collision with root package name */
    private final a f9926f;

    /* renamed from: g  reason: collision with root package name */
    private final e f9927g;

    /* renamed from: h  reason: collision with root package name */
    private final j f9928h;

    /* renamed from: i  reason: collision with root package name */
    private f[] f9929i;

    /* renamed from: j  reason: collision with root package name */
    private b f9930j;

    public h(a aVar, e eVar) {
        this(aVar, eVar, 4);
    }

    public h(a aVar, e eVar, int i2) {
        this(aVar, eVar, i2, new d(new Handler(Looper.getMainLooper())));
    }

    public h(a aVar, e eVar, int i2, j jVar) {
        this.f9921a = new AtomicInteger();
        this.f9922b = new HashMap();
        this.f9923c = new HashSet();
        this.f9924d = new PriorityBlockingQueue<>();
        this.f9925e = new PriorityBlockingQueue<>();
        this.f9926f = aVar;
        this.f9927g = eVar;
        this.f9929i = new f[i2];
        this.f9928h = jVar;
    }

    public Request a(Request request) {
        request.a(this);
        synchronized (this.f9923c) {
            this.f9923c.add(request);
        }
        request.a(c());
        request.a("add-to-queue");
        if (!request.q()) {
            this.f9925e.add(request);
            return request;
        }
        synchronized (this.f9922b) {
            String d2 = request.d();
            if (this.f9922b.containsKey(d2)) {
                Queue queue = this.f9922b.get(d2);
                if (queue == null) {
                    queue = new LinkedList();
                }
                queue.add(request);
                this.f9922b.put(d2, queue);
                if (l.f9936b) {
                    l.a("Request for cacheKey=%s is in flight, putting on hold.", d2);
                }
            } else {
                this.f9922b.put(d2, (Object) null);
                this.f9924d.add(request);
            }
        }
        return request;
    }

    public void a() {
        b();
        b bVar = new b(this.f9924d, this.f9925e, this.f9926f, this.f9928h);
        this.f9930j = bVar;
        bVar.start();
        for (int i2 = 0; i2 < this.f9929i.length; i2++) {
            f fVar = new f(this.f9925e, this.f9927g, this.f9926f, this.f9928h);
            this.f9929i[i2] = fVar;
            fVar.start();
        }
    }

    public void b() {
        b bVar = this.f9930j;
        if (bVar != null) {
            bVar.a();
        }
        int i2 = 0;
        while (true) {
            f[] fVarArr = this.f9929i;
            if (i2 < fVarArr.length) {
                if (fVarArr[i2] != null) {
                    fVarArr[i2].a();
                }
                i2++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Request request) {
        synchronized (this.f9923c) {
            this.f9923c.remove(request);
        }
        if (request.q()) {
            synchronized (this.f9922b) {
                String d2 = request.d();
                Queue remove = this.f9922b.remove(d2);
                if (remove != null) {
                    if (l.f9936b) {
                        l.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), d2);
                    }
                    this.f9924d.addAll(remove);
                }
            }
        }
    }

    public int c() {
        return this.f9921a.incrementAndGet();
    }
}
