package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.work.impl.d;
import androidx.work.impl.utils.g;
import androidx.work.impl.utils.n;
import androidx.work.j;
import java.util.ArrayList;
import java.util.List;

public class e implements androidx.work.impl.b {

    /* renamed from: a  reason: collision with root package name */
    static final String f5195a = j.a("SystemAlarmDispatcher");

    /* renamed from: b  reason: collision with root package name */
    final Context f5196b;

    /* renamed from: c  reason: collision with root package name */
    final b f5197c;

    /* renamed from: d  reason: collision with root package name */
    final List<Intent> f5198d;

    /* renamed from: e  reason: collision with root package name */
    Intent f5199e;

    /* renamed from: f  reason: collision with root package name */
    private final ap.a f5200f;

    /* renamed from: g  reason: collision with root package name */
    private final n f5201g;

    /* renamed from: h  reason: collision with root package name */
    private final d f5202h;

    /* renamed from: i  reason: collision with root package name */
    private final androidx.work.impl.j f5203i;

    /* renamed from: j  reason: collision with root package name */
    private final Handler f5204j;

    /* renamed from: k  reason: collision with root package name */
    private b f5205k;

    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final e f5207a;

        /* renamed from: b  reason: collision with root package name */
        private final Intent f5208b;

        /* renamed from: c  reason: collision with root package name */
        private final int f5209c;

        a(e eVar, Intent intent, int i2) {
            this.f5207a = eVar;
            this.f5208b = intent;
            this.f5209c = i2;
        }

        public void run() {
            this.f5207a.a(this.f5208b, this.f5209c);
        }
    }

    interface b {
        void a();
    }

    static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final e f5210a;

        c(e eVar) {
            this.f5210a = eVar;
        }

        public void run() {
            this.f5210a.f();
        }
    }

    e(Context context) {
        this(context, (d) null, (androidx.work.impl.j) null);
    }

    e(Context context, d dVar, androidx.work.impl.j jVar) {
        Context applicationContext = context.getApplicationContext();
        this.f5196b = applicationContext;
        this.f5197c = new b(applicationContext);
        this.f5201g = new n();
        jVar = jVar == null ? androidx.work.impl.j.b(context) : jVar;
        this.f5203i = jVar;
        dVar = dVar == null ? jVar.f() : dVar;
        this.f5202h = dVar;
        this.f5200f = jVar.g();
        dVar.a((androidx.work.impl.b) this);
        this.f5198d = new ArrayList();
        this.f5199e = null;
        this.f5204j = new Handler(Looper.getMainLooper());
    }

    private boolean a(String str) {
        h();
        synchronized (this.f5198d) {
            for (Intent action : this.f5198d) {
                if (str.equals(action.getAction())) {
                    return true;
                }
            }
            return false;
        }
    }

    private void g() {
        h();
        PowerManager.WakeLock a2 = androidx.work.impl.utils.j.a(this.f5196b, "ProcessCommand");
        try {
            a2.acquire();
            this.f5203i.g().a(new Runnable() {
                public void run() {
                    c cVar;
                    e eVar;
                    synchronized (e.this.f5198d) {
                        e eVar2 = e.this;
                        eVar2.f5199e = eVar2.f5198d.get(0);
                    }
                    if (e.this.f5199e != null) {
                        String action = e.this.f5199e.getAction();
                        int intExtra = e.this.f5199e.getIntExtra("KEY_START_ID", 0);
                        j.a().b(e.f5195a, String.format("Processing command %s, %s", new Object[]{e.this.f5199e, Integer.valueOf(intExtra)}), new Throwable[0]);
                        PowerManager.WakeLock a2 = androidx.work.impl.utils.j.a(e.this.f5196b, String.format("%s (%s)", new Object[]{action, Integer.valueOf(intExtra)}));
                        try {
                            j.a().b(e.f5195a, String.format("Acquiring operation wake lock (%s) %s", new Object[]{action, a2}), new Throwable[0]);
                            a2.acquire();
                            e.this.f5197c.a(e.this.f5199e, intExtra, e.this);
                            j.a().b(e.f5195a, String.format("Releasing operation wake lock (%s) %s", new Object[]{action, a2}), new Throwable[0]);
                            a2.release();
                            eVar = e.this;
                            cVar = new c(eVar);
                        } catch (Throwable th) {
                            j.a().b(e.f5195a, String.format("Releasing operation wake lock (%s) %s", new Object[]{action, a2}), new Throwable[0]);
                            a2.release();
                            e eVar3 = e.this;
                            eVar3.a((Runnable) new c(eVar3));
                            throw th;
                        }
                        eVar.a((Runnable) cVar);
                    }
                }
            });
        } finally {
            a2.release();
        }
    }

    private void h() {
        if (this.f5204j.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        j.a().b(f5195a, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        this.f5202h.b((androidx.work.impl.b) this);
        this.f5201g.a();
        this.f5205k = null;
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar) {
        if (this.f5205k != null) {
            j.a().e(f5195a, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        } else {
            this.f5205k = bVar;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Runnable runnable) {
        this.f5204j.post(runnable);
    }

    public void a(String str, boolean z2) {
        a((Runnable) new a(this, b.a(this.f5196b, str, z2), 0));
    }

    public boolean a(Intent intent, int i2) {
        j a2 = j.a();
        String str = f5195a;
        boolean z2 = false;
        a2.b(str, String.format("Adding command %s (%s)", new Object[]{intent, Integer.valueOf(i2)}), new Throwable[0]);
        h();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            j.a().d(str, "Unknown command. Ignoring", new Throwable[0]);
            return false;
        } else if ("ACTION_CONSTRAINTS_CHANGED".equals(action) && a("ACTION_CONSTRAINTS_CHANGED")) {
            return false;
        } else {
            intent.putExtra("KEY_START_ID", i2);
            synchronized (this.f5198d) {
                if (!this.f5198d.isEmpty()) {
                    z2 = true;
                }
                this.f5198d.add(intent);
                if (!z2) {
                    g();
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public d b() {
        return this.f5202h;
    }

    /* access modifiers changed from: package-private */
    public n c() {
        return this.f5201g;
    }

    /* access modifiers changed from: package-private */
    public androidx.work.impl.j d() {
        return this.f5203i;
    }

    /* access modifiers changed from: package-private */
    public ap.a e() {
        return this.f5200f;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        j a2 = j.a();
        String str = f5195a;
        a2.b(str, "Checking if commands are complete.", new Throwable[0]);
        h();
        synchronized (this.f5198d) {
            if (this.f5199e != null) {
                j.a().b(str, String.format("Removing command %s", new Object[]{this.f5199e}), new Throwable[0]);
                if (this.f5198d.remove(0).equals(this.f5199e)) {
                    this.f5199e = null;
                } else {
                    throw new IllegalStateException("Dequeue-d command is not the first.");
                }
            }
            g b2 = this.f5200f.b();
            if (!this.f5197c.a() && this.f5198d.isEmpty() && !b2.b()) {
                j.a().b(str, "No more commands & intents.", new Throwable[0]);
                b bVar = this.f5205k;
                if (bVar != null) {
                    bVar.a();
                }
            } else if (!this.f5198d.isEmpty()) {
                g();
            }
        }
    }
}
