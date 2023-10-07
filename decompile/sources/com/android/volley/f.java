package com.android.volley;

import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import java.util.concurrent.BlockingQueue;

public class f extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final BlockingQueue<Request> f9912a;

    /* renamed from: b  reason: collision with root package name */
    private final e f9913b;

    /* renamed from: c  reason: collision with root package name */
    private final a f9914c;

    /* renamed from: d  reason: collision with root package name */
    private final j f9915d;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f9916e = false;

    public f(BlockingQueue<Request> blockingQueue, e eVar, a aVar, j jVar) {
        this.f9912a = blockingQueue;
        this.f9913b = eVar;
        this.f9914c = aVar;
        this.f9915d = jVar;
    }

    private void a(Request<?> request, VolleyError volleyError) {
        this.f9915d.a(request, request.a(volleyError));
    }

    public void a() {
        this.f9916e = true;
        interrupt();
    }

    public void run() {
        String str;
        Process.setThreadPriority(10);
        while (true) {
            try {
                Request take = this.f9912a.take();
                try {
                    take.a("network-queue-take");
                    if (take.g()) {
                        str = "network-discard-cancelled";
                    } else {
                        if (Build.VERSION.SDK_INT >= 14) {
                            TrafficStats.setThreadStatsTag(take.b());
                        }
                        g a2 = this.f9913b.a(take);
                        take.a("network-http-complete");
                        if (!a2.f9920d || !take.v()) {
                            i a3 = take.a(a2);
                            take.a("network-parse-complete");
                            if (take.q() && a3.f9932b != null) {
                                this.f9914c.a(take.d(), a3.f9932b);
                                take.a("network-cache-written");
                            }
                            take.u();
                            this.f9915d.a((Request<?>) take, (i<?>) a3);
                        } else {
                            str = "not-modified";
                        }
                    }
                    take.b(str);
                } catch (VolleyError e2) {
                    a(take, e2);
                } catch (Exception e3) {
                    l.a(e3, "Unhandled exception %s", e3.toString());
                    this.f9915d.a((Request<?>) take, new VolleyError((Throwable) e3));
                }
            } catch (InterruptedException unused) {
                if (this.f9916e) {
                    return;
                }
            }
        }
    }
}
