package com.android.volley;

import android.os.Process;
import com.android.volley.a;
import java.util.concurrent.BlockingQueue;

public class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f9893a = l.f9936b;

    /* renamed from: b  reason: collision with root package name */
    private final BlockingQueue<Request> f9894b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final BlockingQueue<Request> f9895c;

    /* renamed from: d  reason: collision with root package name */
    private final a f9896d;

    /* renamed from: e  reason: collision with root package name */
    private final j f9897e;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f9898f = false;

    public b(BlockingQueue<Request> blockingQueue, BlockingQueue<Request> blockingQueue2, a aVar, j jVar) {
        this.f9894b = blockingQueue;
        this.f9895c = blockingQueue2;
        this.f9896d = aVar;
        this.f9897e = jVar;
    }

    public void a() {
        this.f9898f = true;
        interrupt();
    }

    public void run() {
        BlockingQueue<Request> blockingQueue;
        if (f9893a) {
            l.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f9896d.a();
        while (true) {
            try {
                final Request take = this.f9894b.take();
                take.a("cache-queue-take");
                if (take.g()) {
                    take.b("cache-discard-canceled");
                } else {
                    a.C0077a a2 = this.f9896d.a(take.d());
                    if (a2 == null) {
                        take.a("cache-miss");
                        blockingQueue = this.f9895c;
                    } else if (a2.a()) {
                        take.a("cache-hit-expired");
                        take.a(a2);
                        blockingQueue = this.f9895c;
                    } else {
                        take.a("cache-hit");
                        i a3 = take.a(new g(a2.f9887a, a2.f9892f));
                        take.a("cache-hit-parsed");
                        if (!a2.b()) {
                            this.f9897e.a((Request<?>) take, (i<?>) a3);
                        } else {
                            take.a("cache-hit-refresh-needed");
                            take.a(a2);
                            a3.f9934d = true;
                            this.f9897e.a(take, a3, new Runnable() {
                                public void run() {
                                    try {
                                        b.this.f9895c.put(take);
                                    } catch (InterruptedException unused) {
                                    }
                                }
                            });
                        }
                    }
                    blockingQueue.put(take);
                }
            } catch (InterruptedException unused) {
                if (this.f9898f) {
                    return;
                }
            }
        }
    }
}
