package androidx.work.impl.utils;

import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.d;
import androidx.work.j;
import ao.q;

public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5398a = j.a("StopWorkRunnable");

    /* renamed from: b  reason: collision with root package name */
    private final androidx.work.impl.j f5399b;

    /* renamed from: c  reason: collision with root package name */
    private final String f5400c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f5401d;

    public i(androidx.work.impl.j jVar, String str, boolean z2) {
        this.f5399b = jVar;
        this.f5400c = str;
        this.f5401d = z2;
    }

    public void run() {
        boolean z2;
        WorkDatabase c2 = this.f5399b.c();
        d f2 = this.f5399b.f();
        q o2 = c2.o();
        c2.g();
        try {
            boolean h2 = f2.h(this.f5400c);
            if (this.f5401d) {
                z2 = this.f5399b.f().b(this.f5400c);
            } else {
                if (!h2 && o2.f(this.f5400c) == WorkInfo.State.RUNNING) {
                    o2.a(WorkInfo.State.ENQUEUED, this.f5400c);
                }
                z2 = this.f5399b.f().c(this.f5400c);
            }
            j.a().b(f5398a, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", new Object[]{this.f5400c, Boolean.valueOf(z2)}), new Throwable[0]);
            c2.j();
        } finally {
            c2.h();
        }
    }
}
