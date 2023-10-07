package com.amap.api.mapcore.util;

public abstract class ie implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    a f9222f;

    interface a {
        void a(ie ieVar);

        void b(ie ieVar);
    }

    public final void cancelTask() {
        try {
            a aVar = this.f9222f;
            if (aVar != null) {
                aVar.b(this);
            }
        } catch (Throwable th) {
            fz.c(th, "ThreadTask", "cancelTask");
            th.printStackTrace();
        }
    }

    public final void run() {
        a aVar;
        try {
            if (!Thread.interrupted()) {
                runTask();
                if (!Thread.interrupted() && (aVar = this.f9222f) != null) {
                    aVar.a(this);
                }
            }
        } catch (Throwable th) {
            fz.c(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }

    public abstract void runTask();
}
