package androidx.work.impl;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkInfo;
import androidx.work.WorkerParameters;
import androidx.work.h;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.utils.d;
import androidx.work.impl.utils.futures.b;
import androidx.work.impl.utils.l;
import androidx.work.impl.utils.m;
import androidx.work.j;
import ao.p;
import ao.q;
import ao.t;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    static final String f5306a = j.a("WorkerWrapper");

    /* renamed from: b  reason: collision with root package name */
    Context f5307b;

    /* renamed from: c  reason: collision with root package name */
    p f5308c;

    /* renamed from: d  reason: collision with root package name */
    ListenableWorker f5309d;

    /* renamed from: e  reason: collision with root package name */
    ap.a f5310e;

    /* renamed from: f  reason: collision with root package name */
    ListenableWorker.a f5311f = ListenableWorker.a.c();

    /* renamed from: g  reason: collision with root package name */
    b<Boolean> f5312g = b.d();

    /* renamed from: h  reason: collision with root package name */
    gz.a<ListenableWorker.a> f5313h = null;

    /* renamed from: i  reason: collision with root package name */
    private String f5314i;

    /* renamed from: j  reason: collision with root package name */
    private List<e> f5315j;

    /* renamed from: k  reason: collision with root package name */
    private WorkerParameters.a f5316k;

    /* renamed from: l  reason: collision with root package name */
    private androidx.work.a f5317l;

    /* renamed from: m  reason: collision with root package name */
    private androidx.work.impl.foreground.a f5318m;

    /* renamed from: n  reason: collision with root package name */
    private WorkDatabase f5319n;

    /* renamed from: o  reason: collision with root package name */
    private q f5320o;

    /* renamed from: p  reason: collision with root package name */
    private ao.b f5321p;

    /* renamed from: q  reason: collision with root package name */
    private t f5322q;

    /* renamed from: r  reason: collision with root package name */
    private List<String> f5323r;

    /* renamed from: s  reason: collision with root package name */
    private String f5324s;

    /* renamed from: t  reason: collision with root package name */
    private volatile boolean f5325t;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        Context f5332a;

        /* renamed from: b  reason: collision with root package name */
        ListenableWorker f5333b;

        /* renamed from: c  reason: collision with root package name */
        androidx.work.impl.foreground.a f5334c;

        /* renamed from: d  reason: collision with root package name */
        ap.a f5335d;

        /* renamed from: e  reason: collision with root package name */
        androidx.work.a f5336e;

        /* renamed from: f  reason: collision with root package name */
        WorkDatabase f5337f;

        /* renamed from: g  reason: collision with root package name */
        String f5338g;

        /* renamed from: h  reason: collision with root package name */
        List<e> f5339h;

        /* renamed from: i  reason: collision with root package name */
        WorkerParameters.a f5340i = new WorkerParameters.a();

        public a(Context context, androidx.work.a aVar, ap.a aVar2, androidx.work.impl.foreground.a aVar3, WorkDatabase workDatabase, String str) {
            this.f5332a = context.getApplicationContext();
            this.f5335d = aVar2;
            this.f5334c = aVar3;
            this.f5336e = aVar;
            this.f5337f = workDatabase;
            this.f5338g = str;
        }

        public a a(WorkerParameters.a aVar) {
            if (aVar != null) {
                this.f5340i = aVar;
            }
            return this;
        }

        public a a(List<e> list) {
            this.f5339h = list;
            return this;
        }

        public k a() {
            return new k(this);
        }
    }

    k(a aVar) {
        this.f5307b = aVar.f5332a;
        this.f5310e = aVar.f5335d;
        this.f5318m = aVar.f5334c;
        this.f5314i = aVar.f5338g;
        this.f5315j = aVar.f5339h;
        this.f5316k = aVar.f5340i;
        this.f5309d = aVar.f5333b;
        this.f5317l = aVar.f5336e;
        WorkDatabase workDatabase = aVar.f5337f;
        this.f5319n = workDatabase;
        this.f5320o = workDatabase.o();
        this.f5321p = this.f5319n.p();
        this.f5322q = this.f5319n.q();
    }

    private String a(List<String> list) {
        StringBuilder sb = new StringBuilder("Work [ id=");
        sb.append(this.f5314i);
        sb.append(", tags={ ");
        boolean z2 = true;
        for (String next : list) {
            if (z2) {
                z2 = false;
            } else {
                sb.append(", ");
            }
            sb.append(next);
        }
        sb.append(" } ]");
        return sb.toString();
    }

    private void a(ListenableWorker.a aVar) {
        if (aVar instanceof ListenableWorker.a.c) {
            j.a().c(f5306a, String.format("Worker result SUCCESS for %s", new Object[]{this.f5324s}), new Throwable[0]);
            if (!this.f5308c.a()) {
                k();
                return;
            }
        } else if (aVar instanceof ListenableWorker.a.b) {
            j.a().c(f5306a, String.format("Worker result RETRY for %s", new Object[]{this.f5324s}), new Throwable[0]);
            i();
            return;
        } else {
            j.a().c(f5306a, String.format("Worker result FAILURE for %s", new Object[]{this.f5324s}), new Throwable[0]);
            if (!this.f5308c.a()) {
                d();
                return;
            }
        }
        j();
    }

    private void a(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            if (this.f5320o.f(str2) != WorkInfo.State.CANCELLED) {
                this.f5320o.a(WorkInfo.State.FAILED, str2);
            }
            linkedList.addAll(this.f5321p.b(str2));
        }
    }

    /* JADX INFO: finally extract failed */
    private void a(boolean z2) {
        ListenableWorker listenableWorker;
        this.f5319n.g();
        try {
            if (!this.f5319n.o().a()) {
                d.a(this.f5307b, RescheduleReceiver.class, false);
            }
            if (z2) {
                this.f5320o.a(WorkInfo.State.ENQUEUED, this.f5314i);
                this.f5320o.b(this.f5314i, -1);
            }
            if (!(this.f5308c == null || (listenableWorker = this.f5309d) == null || !listenableWorker.k())) {
                this.f5318m.e(this.f5314i);
            }
            this.f5319n.j();
            this.f5319n.h();
            this.f5312g.a(Boolean.valueOf(z2));
        } catch (Throwable th) {
            this.f5319n.h();
            throw th;
        }
    }

    private void e() {
        androidx.work.d a2;
        if (!g()) {
            this.f5319n.g();
            try {
                p b2 = this.f5320o.b(this.f5314i);
                this.f5308c = b2;
                if (b2 == null) {
                    j.a().e(f5306a, String.format("Didn't find WorkSpec for id %s", new Object[]{this.f5314i}), new Throwable[0]);
                    a(false);
                    this.f5319n.j();
                } else if (b2.f5496b != WorkInfo.State.ENQUEUED) {
                    f();
                    this.f5319n.j();
                    j.a().b(f5306a, String.format("%s is not in ENQUEUED state. Nothing more to do.", new Object[]{this.f5308c.f5497c}), new Throwable[0]);
                    this.f5319n.h();
                } else {
                    if (this.f5308c.a() || this.f5308c.b()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (!(this.f5308c.f5508n == 0) && currentTimeMillis < this.f5308c.c()) {
                            j.a().b(f5306a, String.format("Delaying execution for %s because it is being executed before schedule.", new Object[]{this.f5308c.f5497c}), new Throwable[0]);
                            a(true);
                            this.f5319n.j();
                            this.f5319n.h();
                            return;
                        }
                    }
                    this.f5319n.j();
                    this.f5319n.h();
                    if (this.f5308c.a()) {
                        a2 = this.f5308c.f5499e;
                    } else {
                        h b3 = this.f5317l.d().b(this.f5308c.f5498d);
                        if (b3 == null) {
                            j.a().e(f5306a, String.format("Could not create Input Merger %s", new Object[]{this.f5308c.f5498d}), new Throwable[0]);
                            d();
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(this.f5308c.f5499e);
                        arrayList.addAll(this.f5320o.g(this.f5314i));
                        a2 = b3.a((List<androidx.work.d>) arrayList);
                    }
                    WorkerParameters workerParameters = new WorkerParameters(UUID.fromString(this.f5314i), a2, this.f5323r, this.f5316k, this.f5308c.f5505k, this.f5317l.a(), this.f5310e, this.f5317l.c(), new m(this.f5319n, this.f5310e), new l(this.f5319n, this.f5318m, this.f5310e));
                    if (this.f5309d == null) {
                        this.f5309d = this.f5317l.c().b(this.f5307b, this.f5308c.f5497c, workerParameters);
                    }
                    ListenableWorker listenableWorker = this.f5309d;
                    if (listenableWorker == null) {
                        j.a().e(f5306a, String.format("Could not create Worker %s", new Object[]{this.f5308c.f5497c}), new Throwable[0]);
                        d();
                    } else if (listenableWorker.i()) {
                        j.a().e(f5306a, String.format("Received an already-used Worker %s; WorkerFactory should return new instances", new Object[]{this.f5308c.f5497c}), new Throwable[0]);
                        d();
                    } else {
                        this.f5309d.j();
                        if (!h()) {
                            f();
                        } else if (!g()) {
                            final b d2 = b.d();
                            androidx.work.impl.utils.k kVar = new androidx.work.impl.utils.k(this.f5307b, this.f5308c, this.f5309d, workerParameters.f(), this.f5310e);
                            this.f5310e.a().execute(kVar);
                            final gz.a<Void> a3 = kVar.a();
                            a3.a(new Runnable() {
                                public void run() {
                                    try {
                                        a3.get();
                                        j.a().b(k.f5306a, String.format("Starting work for %s", new Object[]{k.this.f5308c.f5497c}), new Throwable[0]);
                                        k kVar = k.this;
                                        kVar.f5313h = kVar.f5309d.d();
                                        d2.a(k.this.f5313h);
                                    } catch (Throwable th) {
                                        d2.a(th);
                                    }
                                }
                            }, this.f5310e.a());
                            final String str = this.f5324s;
                            d2.a((Runnable) new Runnable() {
                                public void run() {
                                    try {
                                        ListenableWorker.a aVar = (ListenableWorker.a) d2.get();
                                        if (aVar == null) {
                                            j.a().e(k.f5306a, String.format("%s returned a null result. Treating it as a failure.", new Object[]{k.this.f5308c.f5497c}), new Throwable[0]);
                                        } else {
                                            j.a().b(k.f5306a, String.format("%s returned a %s result.", new Object[]{k.this.f5308c.f5497c, aVar}), new Throwable[0]);
                                            k.this.f5311f = aVar;
                                        }
                                    } catch (CancellationException e2) {
                                        j.a().c(k.f5306a, String.format("%s was cancelled", new Object[]{str}), e2);
                                    } catch (InterruptedException | ExecutionException e3) {
                                        j.a().e(k.f5306a, String.format("%s failed because it threw an exception/error", new Object[]{str}), e3);
                                    } catch (Throwable th) {
                                        k.this.b();
                                        throw th;
                                    }
                                    k.this.b();
                                }
                            }, (Executor) this.f5310e.b());
                        }
                    }
                }
            } finally {
                this.f5319n.h();
            }
        }
    }

    private void f() {
        WorkInfo.State f2 = this.f5320o.f(this.f5314i);
        if (f2 == WorkInfo.State.RUNNING) {
            j.a().b(f5306a, String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", new Object[]{this.f5314i}), new Throwable[0]);
            a(true);
            return;
        }
        j.a().b(f5306a, String.format("Status for %s is %s; not doing any work", new Object[]{this.f5314i, f2}), new Throwable[0]);
        a(false);
    }

    private boolean g() {
        if (!this.f5325t) {
            return false;
        }
        j.a().b(f5306a, String.format("Work interrupted for %s", new Object[]{this.f5324s}), new Throwable[0]);
        WorkInfo.State f2 = this.f5320o.f(this.f5314i);
        if (f2 == null) {
            a(false);
        } else {
            a(!f2.a());
        }
        return true;
    }

    private boolean h() {
        this.f5319n.g();
        try {
            boolean z2 = true;
            if (this.f5320o.f(this.f5314i) == WorkInfo.State.ENQUEUED) {
                this.f5320o.a(WorkInfo.State.RUNNING, this.f5314i);
                this.f5320o.d(this.f5314i);
            } else {
                z2 = false;
            }
            this.f5319n.j();
            return z2;
        } finally {
            this.f5319n.h();
        }
    }

    private void i() {
        this.f5319n.g();
        try {
            this.f5320o.a(WorkInfo.State.ENQUEUED, this.f5314i);
            this.f5320o.a(this.f5314i, System.currentTimeMillis());
            this.f5320o.b(this.f5314i, -1);
            this.f5319n.j();
        } finally {
            this.f5319n.h();
            a(true);
        }
    }

    private void j() {
        this.f5319n.g();
        try {
            this.f5320o.a(this.f5314i, System.currentTimeMillis());
            this.f5320o.a(WorkInfo.State.ENQUEUED, this.f5314i);
            this.f5320o.e(this.f5314i);
            this.f5320o.b(this.f5314i, -1);
            this.f5319n.j();
        } finally {
            this.f5319n.h();
            a(false);
        }
    }

    private void k() {
        this.f5319n.g();
        try {
            this.f5320o.a(WorkInfo.State.SUCCEEDED, this.f5314i);
            this.f5320o.a(this.f5314i, ((ListenableWorker.a.c) this.f5311f).d());
            long currentTimeMillis = System.currentTimeMillis();
            for (String next : this.f5321p.b(this.f5314i)) {
                if (this.f5320o.f(next) == WorkInfo.State.BLOCKED && this.f5321p.a(next)) {
                    j.a().c(f5306a, String.format("Setting status to enqueued for %s", new Object[]{next}), new Throwable[0]);
                    this.f5320o.a(WorkInfo.State.ENQUEUED, next);
                    this.f5320o.a(next, currentTimeMillis);
                }
            }
            this.f5319n.j();
        } finally {
            this.f5319n.h();
            a(false);
        }
    }

    public gz.a<Boolean> a() {
        return this.f5312g;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (!g()) {
            this.f5319n.g();
            try {
                WorkInfo.State f2 = this.f5320o.f(this.f5314i);
                this.f5319n.t().a(this.f5314i);
                if (f2 == null) {
                    a(false);
                } else if (f2 == WorkInfo.State.RUNNING) {
                    a(this.f5311f);
                } else if (!f2.a()) {
                    i();
                }
                this.f5319n.j();
            } finally {
                this.f5319n.h();
            }
        }
        List<e> list = this.f5315j;
        if (list != null) {
            for (e a2 : list) {
                a2.a(this.f5314i);
            }
            f.a(this.f5317l, this.f5319n, this.f5315j);
        }
    }

    public void c() {
        boolean z2;
        this.f5325t = true;
        g();
        gz.a<ListenableWorker.a> aVar = this.f5313h;
        if (aVar != null) {
            z2 = aVar.isDone();
            this.f5313h.cancel(true);
        } else {
            z2 = false;
        }
        ListenableWorker listenableWorker = this.f5309d;
        if (listenableWorker == null || z2) {
            j.a().b(f5306a, String.format("WorkSpec %s is already done. Not interrupting.", new Object[]{this.f5308c}), new Throwable[0]);
            return;
        }
        listenableWorker.g();
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f5319n.g();
        try {
            a(this.f5314i);
            this.f5320o.a(this.f5314i, ((ListenableWorker.a.C0043a) this.f5311f).d());
            this.f5319n.j();
        } finally {
            this.f5319n.h();
            a(false);
        }
    }

    public void run() {
        List<String> a2 = this.f5322q.a(this.f5314i);
        this.f5323r = a2;
        this.f5324s = a(a2);
        e();
    }
}
