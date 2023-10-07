package androidx.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.futures.b;
import gz.a;

public abstract class Worker extends ListenableWorker {

    /* renamed from: a  reason: collision with root package name */
    b<ListenableWorker.a> f5085a;

    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public final a<ListenableWorker.a> d() {
        this.f5085a = b.d();
        l().execute(new Runnable() {
            public void run() {
                try {
                    Worker.this.f5085a.a(Worker.this.o());
                } catch (Throwable th) {
                    Worker.this.f5085a.a(th);
                }
            }
        });
        return this.f5085a;
    }

    public abstract ListenableWorker.a o();
}
