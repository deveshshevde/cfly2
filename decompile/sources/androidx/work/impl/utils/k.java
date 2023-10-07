package androidx.work.impl.utils;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.e;
import androidx.work.f;
import androidx.work.impl.utils.futures.b;
import androidx.work.j;
import ao.p;
import ap.a;

public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    static final String f5404a = j.a("WorkForegroundRunnable");

    /* renamed from: b  reason: collision with root package name */
    final b<Void> f5405b = b.d();

    /* renamed from: c  reason: collision with root package name */
    final Context f5406c;

    /* renamed from: d  reason: collision with root package name */
    final p f5407d;

    /* renamed from: e  reason: collision with root package name */
    final ListenableWorker f5408e;

    /* renamed from: f  reason: collision with root package name */
    final f f5409f;

    /* renamed from: g  reason: collision with root package name */
    final a f5410g;

    public k(Context context, p pVar, ListenableWorker listenableWorker, f fVar, a aVar) {
        this.f5406c = context;
        this.f5407d = pVar;
        this.f5408e = listenableWorker;
        this.f5409f = fVar;
        this.f5410g = aVar;
    }

    public gz.a<Void> a() {
        return this.f5405b;
    }

    public void run() {
        if (!this.f5407d.f5511q || androidx.core.os.a.b()) {
            this.f5405b.a(null);
            return;
        }
        final b d2 = b.d();
        this.f5410g.a().execute(new Runnable() {
            public void run() {
                d2.a(k.this.f5408e.e());
            }
        });
        d2.a((Runnable) new Runnable() {
            public void run() {
                try {
                    e eVar = (e) d2.get();
                    if (eVar != null) {
                        j.a().b(k.f5404a, String.format("Updating notification for %s", new Object[]{k.this.f5407d.f5497c}), new Throwable[0]);
                        k.this.f5408e.a(true);
                        k.this.f5405b.a(k.this.f5409f.a(k.this.f5406c, k.this.f5408e.b(), eVar));
                        return;
                    }
                    throw new IllegalStateException(String.format("Worker was marked important (%s) but did not provide ForegroundInfo", new Object[]{k.this.f5407d.f5497c}));
                } catch (Throwable th) {
                    k.this.f5405b.a(th);
                }
            }
        }, this.f5410g.a());
    }
}
