package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xeagle.android.login.common.ListenerStickView;
import java.lang.ref.WeakReference;

class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f19641a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f19642b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final Handler f19643c = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b.this.a((C0131b) message.obj);
            return true;
        }
    });

    /* renamed from: d  reason: collision with root package name */
    private C0131b f19644d;

    /* renamed from: e  reason: collision with root package name */
    private C0131b f19645e;

    interface a {
        void a();

        void a(int i2);
    }

    /* renamed from: com.google.android.material.snackbar.b$b  reason: collision with other inner class name */
    private static class C0131b {

        /* renamed from: a  reason: collision with root package name */
        final WeakReference<a> f19647a;

        /* renamed from: b  reason: collision with root package name */
        int f19648b;

        /* renamed from: c  reason: collision with root package name */
        boolean f19649c;

        C0131b(int i2, a aVar) {
            this.f19647a = new WeakReference<>(aVar);
            this.f19648b = i2;
        }

        /* access modifiers changed from: package-private */
        public boolean a(a aVar) {
            return aVar != null && this.f19647a.get() == aVar;
        }
    }

    private b() {
    }

    static b a() {
        if (f19641a == null) {
            f19641a = new b();
        }
        return f19641a;
    }

    private boolean a(C0131b bVar, int i2) {
        a aVar = (a) bVar.f19647a.get();
        if (aVar == null) {
            return false;
        }
        this.f19643c.removeCallbacksAndMessages(bVar);
        aVar.a(i2);
        return true;
    }

    private void b() {
        C0131b bVar = this.f19645e;
        if (bVar != null) {
            this.f19644d = bVar;
            this.f19645e = null;
            a aVar = (a) bVar.f19647a.get();
            if (aVar != null) {
                aVar.a();
            } else {
                this.f19644d = null;
            }
        }
    }

    private void b(C0131b bVar) {
        if (bVar.f19648b != -2) {
            int i2 = 2750;
            if (bVar.f19648b > 0) {
                i2 = bVar.f19648b;
            } else if (bVar.f19648b == -1) {
                i2 = ListenerStickView.RC_TRIM;
            }
            this.f19643c.removeCallbacksAndMessages(bVar);
            Handler handler = this.f19643c;
            handler.sendMessageDelayed(Message.obtain(handler, 0, bVar), (long) i2);
        }
    }

    private boolean f(a aVar) {
        C0131b bVar = this.f19644d;
        return bVar != null && bVar.a(aVar);
    }

    private boolean g(a aVar) {
        C0131b bVar = this.f19645e;
        return bVar != null && bVar.a(aVar);
    }

    public void a(int i2, a aVar) {
        synchronized (this.f19642b) {
            if (f(aVar)) {
                this.f19644d.f19648b = i2;
                this.f19643c.removeCallbacksAndMessages(this.f19644d);
                b(this.f19644d);
                return;
            }
            if (g(aVar)) {
                this.f19645e.f19648b = i2;
            } else {
                this.f19645e = new C0131b(i2, aVar);
            }
            C0131b bVar = this.f19644d;
            if (bVar == null || !a(bVar, 4)) {
                this.f19644d = null;
                b();
            }
        }
    }

    public void a(a aVar) {
        synchronized (this.f19642b) {
            if (f(aVar)) {
                this.f19644d = null;
                if (this.f19645e != null) {
                    b();
                }
            }
        }
    }

    public void a(a aVar, int i2) {
        C0131b bVar;
        synchronized (this.f19642b) {
            if (f(aVar)) {
                bVar = this.f19644d;
            } else if (g(aVar)) {
                bVar = this.f19645e;
            }
            a(bVar, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(C0131b bVar) {
        synchronized (this.f19642b) {
            if (this.f19644d == bVar || this.f19645e == bVar) {
                a(bVar, 2);
            }
        }
    }

    public void b(a aVar) {
        synchronized (this.f19642b) {
            if (f(aVar)) {
                b(this.f19644d);
            }
        }
    }

    public void c(a aVar) {
        synchronized (this.f19642b) {
            if (f(aVar) && !this.f19644d.f19649c) {
                this.f19644d.f19649c = true;
                this.f19643c.removeCallbacksAndMessages(this.f19644d);
            }
        }
    }

    public void d(a aVar) {
        synchronized (this.f19642b) {
            if (f(aVar) && this.f19644d.f19649c) {
                this.f19644d.f19649c = false;
                b(this.f19644d);
            }
        }
    }

    public boolean e(a aVar) {
        boolean z2;
        synchronized (this.f19642b) {
            if (!f(aVar)) {
                if (!g(aVar)) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }
}
