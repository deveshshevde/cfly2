package ap;

import android.os.Handler;
import android.os.Looper;
import androidx.work.impl.utils.g;
import java.util.concurrent.Executor;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final g f5549a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f5550b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    private final Executor f5551c = new Executor() {
        public void execute(Runnable runnable) {
            b.this.b(runnable);
        }
    };

    public b(Executor executor) {
        this.f5549a = new g(executor);
    }

    public Executor a() {
        return this.f5551c;
    }

    public void a(Runnable runnable) {
        this.f5549a.execute(runnable);
    }

    public g b() {
        return this.f5549a;
    }

    public void b(Runnable runnable) {
        this.f5550b.post(runnable);
    }
}
