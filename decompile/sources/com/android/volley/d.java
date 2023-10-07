package com.android.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

public class d implements j {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f9905a;

    private class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final Request f9909b;

        /* renamed from: c  reason: collision with root package name */
        private final i f9910c;

        /* renamed from: d  reason: collision with root package name */
        private final Runnable f9911d;

        public a(Request request, i iVar, Runnable runnable) {
            this.f9909b = request;
            this.f9910c = iVar;
            this.f9911d = runnable;
        }

        public void run() {
            if (this.f9909b.g()) {
                this.f9909b.b("canceled-at-delivery");
                return;
            }
            if (this.f9910c.a()) {
                this.f9909b.a(this.f9910c.f9931a);
            } else {
                this.f9909b.b(this.f9910c.f9933c);
            }
            if (this.f9910c.f9934d) {
                this.f9909b.a("intermediate-response");
            } else {
                this.f9909b.b("done");
            }
            Runnable runnable = this.f9911d;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public d(final Handler handler) {
        this.f9905a = new Executor() {
            public void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    public void a(Request<?> request, VolleyError volleyError) {
        request.a("post-error");
        this.f9905a.execute(new a(request, i.a(volleyError), (Runnable) null));
    }

    public void a(Request<?> request, i<?> iVar) {
        a(request, iVar, (Runnable) null);
    }

    public void a(Request<?> request, i<?> iVar, Runnable runnable) {
        request.u();
        request.a("post-response");
        this.f9905a.execute(new a(request, iVar, runnable));
    }
}
