package kotlinx.coroutines;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import mr.d;

public final class ai extends au implements Runnable {
    private static volatile Thread _thread;

    /* renamed from: b  reason: collision with root package name */
    public static final ai f30301b;

    /* renamed from: d  reason: collision with root package name */
    private static final long f30302d;
    private static volatile int debugStatus;

    static {
        Long l2;
        ai aiVar = new ai();
        f30301b = aiVar;
        at.a(aiVar, false, 1, (Object) null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l2 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);
        } catch (SecurityException unused) {
            l2 = 1000L;
        }
        f30302d = timeUnit.toNanos(l2.longValue());
    }

    private ai() {
    }

    private final boolean k() {
        int i2 = debugStatus;
        return i2 == 2 || i2 == 3;
    }

    private final synchronized Thread l() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private final synchronized boolean m() {
        if (k()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    private final synchronized void n() {
        if (k()) {
            debugStatus = 3;
            i();
            notifyAll();
        }
    }

    /* access modifiers changed from: protected */
    public Thread a() {
        Thread thread = _thread;
        return thread != null ? thread : l();
    }

    public void run() {
        by.f30365a.a(this);
        bz a2 = ca.a();
        if (a2 != null) {
            a2.d();
        }
        try {
            if (m()) {
                long j2 = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long b2 = b();
                    if (b2 == Long.MAX_VALUE) {
                        bz a3 = ca.a();
                        long a4 = a3 != null ? a3.a() : System.nanoTime();
                        if (j2 == Long.MAX_VALUE) {
                            j2 = f30302d + a4;
                        }
                        long j3 = j2 - a4;
                        if (j3 <= 0) {
                            _thread = null;
                            n();
                            bz a5 = ca.a();
                            if (a5 != null) {
                                a5.e();
                            }
                            if (!c()) {
                                a();
                                return;
                            }
                            return;
                        }
                        b2 = d.b(b2, j3);
                    } else {
                        j2 = Long.MAX_VALUE;
                    }
                    if (b2 > 0) {
                        if (k()) {
                            _thread = null;
                            n();
                            bz a6 = ca.a();
                            if (a6 != null) {
                                a6.e();
                            }
                            if (!c()) {
                                a();
                                return;
                            }
                            return;
                        }
                        bz a7 = ca.a();
                        if (a7 != null) {
                            a7.a(this, b2);
                        } else {
                            LockSupport.parkNanos(this, b2);
                        }
                    }
                }
            }
        } finally {
            _thread = null;
            n();
            bz a8 = ca.a();
            if (a8 != null) {
                a8.e();
            }
            if (!c()) {
                a();
            }
        }
    }
}
