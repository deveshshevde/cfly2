package androidx.work.impl.workers;

import al.c;
import al.d;
import android.content.Context;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.futures.b;
import androidx.work.j;
import ao.p;
import gz.a;
import java.util.Collections;
import java.util.List;

public class ConstraintTrackingWorker extends ListenableWorker implements c {

    /* renamed from: d  reason: collision with root package name */
    private static final String f5437d = j.a("ConstraintTrkngWrkr");

    /* renamed from: a  reason: collision with root package name */
    final Object f5438a = new Object();

    /* renamed from: b  reason: collision with root package name */
    volatile boolean f5439b = false;

    /* renamed from: c  reason: collision with root package name */
    b<ListenableWorker.a> f5440c = b.d();

    /* renamed from: e  reason: collision with root package name */
    private WorkerParameters f5441e;

    /* renamed from: f  reason: collision with root package name */
    private ListenableWorker f5442f;

    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.f5441e = workerParameters;
    }

    public void a(List<String> list) {
    }

    public void b(List<String> list) {
        j.a().b(f5437d, String.format("Constraints changed for %s", new Object[]{list}), new Throwable[0]);
        synchronized (this.f5438a) {
            this.f5439b = true;
        }
    }

    public a<ListenableWorker.a> d() {
        l().execute(new Runnable() {
            public void run() {
                ConstraintTrackingWorker.this.o();
            }
        });
        return this.f5440c;
    }

    public void h() {
        super.h();
        ListenableWorker listenableWorker = this.f5442f;
        if (listenableWorker != null && !listenableWorker.f()) {
            this.f5442f.g();
        }
    }

    public boolean k() {
        ListenableWorker listenableWorker = this.f5442f;
        return listenableWorker != null && listenableWorker.k();
    }

    public ap.a m() {
        return androidx.work.impl.j.b(a()).g();
    }

    /* access modifiers changed from: package-private */
    public void o() {
        String a2 = c().a("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
        if (TextUtils.isEmpty(a2)) {
            j.a().e(f5437d, "No worker to delegate to.", new Throwable[0]);
        } else {
            ListenableWorker b2 = n().b(a(), a2, this.f5441e);
            this.f5442f = b2;
            if (b2 == null) {
                j.a().b(f5437d, "No worker to delegate to.", new Throwable[0]);
            } else {
                p b3 = r().o().b(b().toString());
                if (b3 == null) {
                    p();
                    return;
                }
                d dVar = new d(a(), m(), this);
                dVar.a((Iterable<p>) Collections.singletonList(b3));
                if (dVar.a(b().toString())) {
                    j.a().b(f5437d, String.format("Constraints met for delegate %s", new Object[]{a2}), new Throwable[0]);
                    try {
                        final a<ListenableWorker.a> d2 = this.f5442f.d();
                        d2.a(new Runnable() {
                            public void run() {
                                synchronized (ConstraintTrackingWorker.this.f5438a) {
                                    if (ConstraintTrackingWorker.this.f5439b) {
                                        ConstraintTrackingWorker.this.q();
                                    } else {
                                        ConstraintTrackingWorker.this.f5440c.a(d2);
                                    }
                                }
                            }
                        }, l());
                        return;
                    } catch (Throwable th) {
                        j a3 = j.a();
                        String str = f5437d;
                        a3.b(str, String.format("Delegated worker %s threw exception in startWork.", new Object[]{a2}), th);
                        synchronized (this.f5438a) {
                            if (this.f5439b) {
                                j.a().b(str, "Constraints were unmet, Retrying.", new Throwable[0]);
                                q();
                            } else {
                                p();
                            }
                            return;
                        }
                    }
                } else {
                    j.a().b(f5437d, String.format("Constraints not met for delegate %s. Requesting retry.", new Object[]{a2}), new Throwable[0]);
                    q();
                    return;
                }
            }
        }
        p();
    }

    /* access modifiers changed from: package-private */
    public void p() {
        this.f5440c.a(ListenableWorker.a.c());
    }

    /* access modifiers changed from: package-private */
    public void q() {
        this.f5440c.a(ListenableWorker.a.b());
    }

    public WorkDatabase r() {
        return androidx.work.impl.j.b(a()).c();
    }
}
