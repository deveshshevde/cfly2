package okhttp3.internal.connection;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Proxy;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import nb.c;
import okhttp3.a;
import okhttp3.ad;
import okhttp3.internal.connection.i;

public final class f {

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ boolean f32024c = true;

    /* renamed from: d  reason: collision with root package name */
    private static final Executor f32025d = new ThreadPoolExecutor(0, SubsamplingScaleImageView.TILE_SIZE_AUTO, 60, TimeUnit.SECONDS, new SynchronousQueue(), c.a("OkHttp ConnectionPool", true));

    /* renamed from: a  reason: collision with root package name */
    final g f32026a = new g();

    /* renamed from: b  reason: collision with root package name */
    boolean f32027b;

    /* renamed from: e  reason: collision with root package name */
    private final int f32028e;

    /* renamed from: f  reason: collision with root package name */
    private final long f32029f;

    /* renamed from: g  reason: collision with root package name */
    private final Runnable f32030g = new Runnable() {
        public final void run() {
            f.this.a();
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private final Deque<e> f32031h = new ArrayDeque();

    public f(int i2, long j2, TimeUnit timeUnit) {
        this.f32028e = i2;
        this.f32029f = timeUnit.toNanos(j2);
        if (j2 <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: " + j2);
        }
    }

    private int a(e eVar, long j2) {
        List<Reference<i>> list = eVar.f32012e;
        int i2 = 0;
        while (i2 < list.size()) {
            Reference reference = list.get(i2);
            if (reference.get() != null) {
                i2++;
            } else {
                ng.f.e().a("A connection to " + eVar.b().a().a() + " was leaked. Did you forget to close a response body?", ((i.a) reference).f32060a);
                list.remove(i2);
                eVar.f32009b = true;
                if (list.isEmpty()) {
                    eVar.f32013f = j2 - this.f32029f;
                    return 0;
                }
            }
        }
        return list.size();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0025 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void a() {
        /*
            r6 = this;
        L_0x0000:
            long r0 = java.lang.System.nanoTime()
            long r0 = r6.a((long) r0)
            r2 = -1
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x000f
            return
        L_0x000f:
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0000
            r2 = 1000000(0xf4240, double:4.940656E-318)
            long r4 = r0 / r2
            long r2 = r2 * r4
            long r0 = r0 - r2
            monitor-enter(r6)
            int r1 = (int) r0
            r6.wait(r4, r1)     // Catch:{ InterruptedException -> 0x0025 }
            goto L_0x0025
        L_0x0023:
            r0 = move-exception
            goto L_0x0027
        L_0x0025:
            monitor-exit(r6)     // Catch:{ all -> 0x0023 }
            goto L_0x0000
        L_0x0027:
            monitor-exit(r6)     // Catch:{ all -> 0x0023 }
            goto L_0x002a
        L_0x0029:
            throw r0
        L_0x002a:
            goto L_0x0029
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.f.a():void");
    }

    /* access modifiers changed from: package-private */
    public long a(long j2) {
        synchronized (this) {
            e eVar = null;
            long j3 = Long.MIN_VALUE;
            int i2 = 0;
            int i3 = 0;
            for (e next : this.f32031h) {
                if (a(next, j2) > 0) {
                    i3++;
                } else {
                    i2++;
                    long j4 = j2 - next.f32013f;
                    if (j4 > j3) {
                        eVar = next;
                        j3 = j4;
                    }
                }
            }
            long j5 = this.f32029f;
            if (j3 < j5) {
                if (i2 <= this.f32028e) {
                    if (i2 > 0) {
                        long j6 = j5 - j3;
                        return j6;
                    } else if (i3 > 0) {
                        return j5;
                    } else {
                        this.f32027b = false;
                        return -1;
                    }
                }
            }
            this.f32031h.remove(eVar);
            c.a(eVar.d());
            return 0;
        }
    }

    public void a(ad adVar, IOException iOException) {
        if (adVar.b().type() != Proxy.Type.DIRECT) {
            a a2 = adVar.a();
            a2.g().connectFailed(a2.a().a(), adVar.b().address(), iOException);
        }
        this.f32026a.a(adVar);
    }

    /* access modifiers changed from: package-private */
    public void a(e eVar) {
        if (f32024c || Thread.holdsLock(this)) {
            if (!this.f32027b) {
                this.f32027b = true;
                f32025d.execute(this.f32030g);
            }
            this.f32031h.add(eVar);
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public boolean a(a aVar, i iVar, List<ad> list, boolean z2) {
        if (f32024c || Thread.holdsLock(this)) {
            for (e next : this.f32031h) {
                if ((!z2 || next.f()) && next.a(aVar, list)) {
                    iVar.a(next);
                    return true;
                }
            }
            return false;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public boolean b(e eVar) {
        if (!f32024c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (eVar.f32009b || this.f32028e == 0) {
            this.f32031h.remove(eVar);
            return true;
        } else {
            notifyAll();
            return false;
        }
    }
}
