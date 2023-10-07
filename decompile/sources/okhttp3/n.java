package okhttp3;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import nb.c;
import okhttp3.y;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f32279a = true;

    /* renamed from: b  reason: collision with root package name */
    private int f32280b = 64;

    /* renamed from: c  reason: collision with root package name */
    private int f32281c = 5;

    /* renamed from: d  reason: collision with root package name */
    private Runnable f32282d;

    /* renamed from: e  reason: collision with root package name */
    private ExecutorService f32283e;

    /* renamed from: f  reason: collision with root package name */
    private final Deque<y.a> f32284f = new ArrayDeque();

    /* renamed from: g  reason: collision with root package name */
    private final Deque<y.a> f32285g = new ArrayDeque();

    /* renamed from: h  reason: collision with root package name */
    private final Deque<y> f32286h = new ArrayDeque();

    private y.a a(String str) {
        for (y.a next : this.f32285g) {
            if (next.b().equals(str)) {
                return next;
            }
        }
        for (y.a next2 : this.f32284f) {
            if (next2.b().equals(str)) {
                return next2;
            }
        }
        return null;
    }

    private <T> void a(Deque<T> deque, T t2) {
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t2)) {
                runnable = this.f32282d;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (!c() && runnable != null) {
            runnable.run();
        }
    }

    private boolean c() {
        int i2;
        boolean z2;
        if (f32279a || !Thread.holdsLock(this)) {
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                Iterator<y.a> it2 = this.f32284f.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    y.a next = it2.next();
                    if (this.f32285g.size() >= this.f32280b) {
                        break;
                    } else if (next.a().get() < this.f32281c) {
                        it2.remove();
                        next.a().incrementAndGet();
                        arrayList.add(next);
                        this.f32285g.add(next);
                    }
                }
                z2 = b() > 0;
            }
            int size = arrayList.size();
            for (i2 = 0; i2 < size; i2++) {
                ((y.a) arrayList.get(i2)).a(a());
            }
            return z2;
        }
        throw new AssertionError();
    }

    public synchronized ExecutorService a() {
        if (this.f32283e == null) {
            this.f32283e = new ThreadPoolExecutor(0, SubsamplingScaleImageView.TILE_SIZE_AUTO, 60, TimeUnit.SECONDS, new SynchronousQueue(), c.a("OkHttp Dispatcher", false));
        }
        return this.f32283e;
    }

    /* access modifiers changed from: package-private */
    public void a(y.a aVar) {
        y.a a2;
        synchronized (this) {
            this.f32284f.add(aVar);
            if (!aVar.c().f32397c && (a2 = a(aVar.b())) != null) {
                aVar.a(a2);
            }
        }
        c();
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(y yVar) {
        this.f32286h.add(yVar);
    }

    public synchronized int b() {
        return this.f32285g.size() + this.f32286h.size();
    }

    /* access modifiers changed from: package-private */
    public void b(y.a aVar) {
        aVar.a().decrementAndGet();
        a(this.f32285g, aVar);
    }

    /* access modifiers changed from: package-private */
    public void b(y yVar) {
        a(this.f32286h, yVar);
    }
}
