package com.xeagle.android.utils;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.e;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class j implements d.b, d.c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f24406a = "j";

    /* renamed from: b  reason: collision with root package name */
    private final Runnable f24407b = new Runnable() {
        public void run() {
            while (j.this.f24409d.get()) {
                try {
                    if (!j.this.f24415j.d()) {
                        j.this.i();
                    } else {
                        a aVar = (a) j.this.f24417l.take();
                        if (aVar != null) {
                            (aVar.f24420a ? j.this.f24412g : j.this.f24411f).post(aVar);
                        }
                    }
                } catch (InterruptedException e2) {
                    Log.v(j.f24406a, e2.getMessage(), e2);
                    return;
                }
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final a f24408c = new a() {
        /* access modifiers changed from: protected */
        public void a() {
            j.this.i();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final AtomicBoolean f24409d;

    /* renamed from: e  reason: collision with root package name */
    private Thread f24410e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final Handler f24411f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Handler f24412g;

    /* renamed from: h  reason: collision with root package name */
    private HandlerThread f24413h;

    /* renamed from: i  reason: collision with root package name */
    private final Context f24414i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final d f24415j;

    /* renamed from: k  reason: collision with root package name */
    private b f24416k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final LinkedBlockingQueue<a> f24417l;

    public interface b {
        void a(int i2);

        void a(ConnectionResult connectionResult);

        void j();

        void k();
    }

    public static abstract class a implements Runnable {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public boolean f24420a = false;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public d f24421b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public LinkedBlockingQueue<a> f24422c;

        /* access modifiers changed from: protected */
        public abstract void a();

        /* access modifiers changed from: protected */
        public d b() {
            return this.f24421b;
        }

        public void run() {
            if (!this.f24421b.d()) {
                this.f24422c.offer(this);
            } else {
                a();
            }
        }
    }

    public j(Context context, Handler handler, com.google.android.gms.common.api.a<? extends a.d.e>[] aVarArr) {
        this.f24409d = new AtomicBoolean(false);
        this.f24417l = new LinkedBlockingQueue<>();
        this.f24414i = context;
        this.f24411f = handler;
        d.a aVar = new d.a(context);
        for (com.google.android.gms.common.api.a<? extends a.d.e> a2 : aVarArr) {
            aVar.a(a2);
        }
        this.f24415j = aVar.a((d.b) this).a((d.c) this).a();
    }

    private void d() {
        HandlerThread handlerThread = this.f24413h;
        if (handlerThread != null && handlerThread.isAlive()) {
            this.f24413h.quit();
            this.f24413h.interrupt();
            this.f24413h = null;
        }
        this.f24412g = null;
    }

    private void e() {
        Thread thread = this.f24410e;
        if (thread != null && thread.isAlive()) {
            this.f24410e.interrupt();
            this.f24410e = null;
        }
    }

    private void f() {
        HandlerThread handlerThread = this.f24413h;
        if (handlerThread == null || handlerThread.isInterrupted()) {
            HandlerThread handlerThread2 = new HandlerThread("GAC Manager Background Thread");
            this.f24413h = handlerThread2;
            handlerThread2.start();
            this.f24412g = null;
        }
        if (this.f24412g == null) {
            this.f24412g = new Handler(this.f24413h.getLooper());
        }
    }

    private void g() {
        Thread thread = this.f24410e;
        if (thread == null || thread.isInterrupted()) {
            Thread thread2 = new Thread(this.f24407b, "GAC Manager Driver Thread");
            this.f24410e = thread2;
            thread2.start();
        }
    }

    private boolean h() {
        return this.f24409d.get();
    }

    /* access modifiers changed from: private */
    public void i() {
        this.f24409d.set(false);
        e();
        d();
        this.f24417l.clear();
        if (this.f24415j.d() || this.f24415j.e()) {
            this.f24415j.c();
        }
        b bVar = this.f24416k;
        if (bVar != null) {
            bVar.k();
        }
    }

    public void a() {
        int a2 = e.a(this.f24414i);
        if (a2 == 0) {
            this.f24417l.clear();
            this.f24409d.set(true);
            if (this.f24415j.d()) {
                a((Bundle) null);
            } else if (!this.f24415j.e()) {
                this.f24415j.b();
            }
        } else {
            Log.e(f24406a, "Google Play Services is unavailable.");
            b bVar = this.f24416k;
            if (bVar != null) {
                bVar.a(a2);
            }
        }
    }

    public void a(int i2) {
    }

    public void a(Bundle bundle) {
        f();
        g();
        b bVar = this.f24416k;
        if (bVar != null) {
            bVar.j();
        }
    }

    public void a(ConnectionResult connectionResult) {
        b bVar = this.f24416k;
        if (bVar != null) {
            bVar.a(connectionResult);
        }
        i();
    }

    public void a(b bVar) {
        this.f24416k = bVar;
    }

    public boolean a(a aVar) {
        if (!h()) {
            Log.d(f24406a, "GoogleApiClientManager is not started.");
            return false;
        }
        d unused = aVar.f24421b = this.f24415j;
        LinkedBlockingQueue unused2 = aVar.f24422c = this.f24417l;
        boolean unused3 = aVar.f24420a = false;
        return this.f24417l.offer(aVar);
    }

    public void b() {
        a(this.f24408c);
    }
}
