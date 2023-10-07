package com.liulishuo.filedownloader.download;

import android.database.sqlite.SQLiteFullException;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.liulishuo.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.liulishuo.filedownloader.message.c;
import com.liulishuo.filedownloader.message.d;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import iq.f;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public class e implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    private final FileDownloadModel f21284a;

    /* renamed from: b  reason: collision with root package name */
    private final in.a f21285b;

    /* renamed from: c  reason: collision with root package name */
    private final a f21286c;

    /* renamed from: d  reason: collision with root package name */
    private final int f21287d;

    /* renamed from: e  reason: collision with root package name */
    private final int f21288e;

    /* renamed from: f  reason: collision with root package name */
    private final int f21289f;

    /* renamed from: g  reason: collision with root package name */
    private long f21290g;

    /* renamed from: h  reason: collision with root package name */
    private Handler f21291h;

    /* renamed from: i  reason: collision with root package name */
    private HandlerThread f21292i;

    /* renamed from: j  reason: collision with root package name */
    private volatile boolean f21293j = false;

    /* renamed from: k  reason: collision with root package name */
    private volatile Thread f21294k;

    /* renamed from: l  reason: collision with root package name */
    private volatile long f21295l = 0;

    /* renamed from: m  reason: collision with root package name */
    private final AtomicLong f21296m = new AtomicLong();

    /* renamed from: n  reason: collision with root package name */
    private final AtomicBoolean f21297n = new AtomicBoolean(false);

    /* renamed from: o  reason: collision with root package name */
    private final AtomicBoolean f21298o = new AtomicBoolean(false);

    /* renamed from: p  reason: collision with root package name */
    private final AtomicBoolean f21299p = new AtomicBoolean(true);

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f21300a;

        /* renamed from: b  reason: collision with root package name */
        private Exception f21301b;

        /* renamed from: c  reason: collision with root package name */
        private int f21302c;

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            this.f21302c = i2;
        }

        /* access modifiers changed from: package-private */
        public void a(Exception exc) {
            this.f21301b = exc;
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z2) {
            this.f21300a = z2;
        }

        public boolean a() {
            return this.f21300a;
        }

        public Exception b() {
            return this.f21301b;
        }

        public int c() {
            return this.f21302c;
        }
    }

    e(FileDownloadModel fileDownloadModel, int i2, int i3, int i4) {
        this.f21284a = fileDownloadModel;
        this.f21285b = c.a().c();
        this.f21288e = i3 < 5 ? 5 : i3;
        this.f21289f = i4;
        this.f21286c = new a();
        this.f21287d = i2;
    }

    private static long a(long j2, long j3) {
        if (j3 <= 0) {
            return -1;
        }
        if (j2 == -1) {
            return 1;
        }
        long j4 = j2 / j3;
        if (j4 <= 0) {
            return 1;
        }
        return j4;
    }

    private void a(byte b2) {
        if (b2 != -2) {
            c.a().a(d.a(b2, this.f21284a, this.f21286c));
        } else if (iq.d.f29057a) {
            iq.d.c(this, "High concurrent cause, Already paused and we don't need to call-back to Task in here, %d", Integer.valueOf(this.f21284a.a()));
        }
    }

    private void a(SQLiteFullException sQLiteFullException) {
        int a2 = this.f21284a.a();
        if (iq.d.f29057a) {
            iq.d.c(this, "the data of the task[%d] is dirty, because the SQLite full exception[%s], so remove it from the database directly.", Integer.valueOf(a2), sQLiteFullException.toString());
        }
        this.f21284a.c(sQLiteFullException.toString());
        this.f21284a.a((byte) -1);
        this.f21285b.e(a2);
        this.f21285b.d(a2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0043, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(android.os.Message r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            android.os.HandlerThread r0 = r4.f21292i     // Catch:{ all -> 0x0045 }
            boolean r0 = r0.isAlive()     // Catch:{ all -> 0x0045 }
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0020
            boolean r0 = iq.d.f29057a     // Catch:{ all -> 0x0045 }
            if (r0 == 0) goto L_0x001e
            java.lang.String r0 = "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread."
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0045 }
            int r5 = r5.what     // Catch:{ all -> 0x0045 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0045 }
            r2[r1] = r5     // Catch:{ all -> 0x0045 }
            iq.d.c(r4, r0, r2)     // Catch:{ all -> 0x0045 }
        L_0x001e:
            monitor-exit(r4)
            return
        L_0x0020:
            android.os.Handler r0 = r4.f21291h     // Catch:{ IllegalStateException -> 0x0026 }
            r0.sendMessage(r5)     // Catch:{ IllegalStateException -> 0x0026 }
            goto L_0x0042
        L_0x0026:
            r0 = move-exception
            android.os.HandlerThread r3 = r4.f21292i     // Catch:{ all -> 0x0045 }
            boolean r3 = r3.isAlive()     // Catch:{ all -> 0x0045 }
            if (r3 != 0) goto L_0x0044
            boolean r0 = iq.d.f29057a     // Catch:{ all -> 0x0045 }
            if (r0 == 0) goto L_0x0042
            java.lang.String r0 = "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread."
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0045 }
            int r5 = r5.what     // Catch:{ all -> 0x0045 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0045 }
            r2[r1] = r5     // Catch:{ all -> 0x0045 }
            iq.d.c(r4, r0, r2)     // Catch:{ all -> 0x0045 }
        L_0x0042:
            monitor-exit(r4)
            return
        L_0x0044:
            throw r0     // Catch:{ all -> 0x0045 }
        L_0x0045:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.download.e.a(android.os.Message):void");
    }

    private Exception b(Exception exc) {
        long j2;
        String e2 = this.f21284a.e();
        if ((!this.f21284a.i() && !iq.e.a().f29063f) || !(exc instanceof IOException) || !new File(e2).exists()) {
            return exc;
        }
        long f2 = f.f(e2);
        if (f2 > IjkMediaMeta.AV_CH_TOP_FRONT_LEFT) {
            return exc;
        }
        File file = new File(e2);
        if (!file.exists()) {
            iq.d.a((Object) this, (Throwable) exc, "Exception with: free space isn't enough, and the target file not exist.", new Object[0]);
            j2 = 0;
        } else {
            j2 = file.length();
        }
        return Build.VERSION.SDK_INT >= 9 ? new FileDownloadOutOfSpaceException(f2, IjkMediaMeta.AV_CH_TOP_FRONT_LEFT, j2, exc) : new FileDownloadOutOfSpaceException(f2, IjkMediaMeta.AV_CH_TOP_FRONT_LEFT, j2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(long r10) {
        /*
            r9 = this;
            java.util.concurrent.atomic.AtomicBoolean r0 = r9.f21299p
            r1 = 1
            r2 = 0
            boolean r0 = r0.compareAndSet(r1, r2)
            if (r0 == 0) goto L_0x000c
        L_0x000a:
            r0 = 1
            goto L_0x002d
        L_0x000c:
            long r3 = r9.f21295l
            long r3 = r10 - r3
            long r5 = r9.f21290g
            r7 = -1
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x002c
            java.util.concurrent.atomic.AtomicLong r0 = r9.f21296m
            long r5 = r0.get()
            long r7 = r9.f21290g
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 < 0) goto L_0x002c
            int r0 = r9.f21288e
            long r5 = (long) r0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x002c
            goto L_0x000a
        L_0x002c:
            r0 = 0
        L_0x002d:
            if (r0 == 0) goto L_0x004b
            java.util.concurrent.atomic.AtomicBoolean r0 = r9.f21297n
            boolean r0 = r0.compareAndSet(r2, r1)
            if (r0 == 0) goto L_0x004b
            boolean r0 = iq.d.f29057a
            if (r0 == 0) goto L_0x0042
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r1 = "inspectNeedCallbackToUser need callback to user"
            iq.d.b(r9, r1, r0)
        L_0x0042:
            r9.f21295l = r10
            java.util.concurrent.atomic.AtomicLong r10 = r9.f21296m
            r0 = 0
            r10.set(r0)
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.download.e.b(long):void");
    }

    private void b(Exception exc, int i2) {
        Exception b2 = b(exc);
        this.f21286c.a(b2);
        this.f21286c.a(this.f21287d - i2);
        this.f21284a.a((byte) 5);
        this.f21284a.c(b2.toString());
        this.f21285b.a(this.f21284a.a(), (Throwable) b2);
        a((byte) 5);
    }

    private void c(Exception exc) {
        Exception b2 = b(exc);
        if (!(b2 instanceof SQLiteFullException)) {
            try {
                this.f21284a.a((byte) -1);
                this.f21284a.c(exc.toString());
                this.f21285b.a(this.f21284a.a(), (Throwable) b2, this.f21284a.g());
            } catch (SQLiteFullException e2) {
                b2 = e2;
            }
            this.f21286c.a(b2);
            a((byte) -1);
        }
        a((SQLiteFullException) b2);
        this.f21286c.a(b2);
        a((byte) -1);
    }

    private void h() throws IOException {
        boolean z2;
        String e2 = this.f21284a.e();
        String d2 = this.f21284a.d();
        File file = new File(e2);
        try {
            File file2 = new File(d2);
            if (file2.exists()) {
                long length = file2.length();
                if (file2.delete()) {
                    iq.d.d(this, "The target file([%s], [%d]) will be replaced with the new downloaded file[%d]", d2, Long.valueOf(length), Long.valueOf(file.length()));
                } else {
                    throw new IOException(f.a("Can't delete the old file([%s], [%d]), so can't replace it with the new downloaded one.", d2, Long.valueOf(length)));
                }
            }
            z2 = !file.renameTo(file2);
            if (z2) {
                try {
                    throw new IOException(f.a("Can't rename the  temp downloaded file(%s) to the target file(%s)", e2, d2));
                } catch (Throwable th) {
                    th = th;
                    if (z2 && file.exists() && !file.delete()) {
                        iq.d.d(this, "delete the temp file(%s) failed, on completed downloading.", e2);
                    }
                    throw th;
                }
            } else if (z2 && file.exists() && !file.delete()) {
                iq.d.d(this, "delete the temp file(%s) failed, on completed downloading.", e2);
            }
        } catch (Throwable th2) {
            th = th2;
            z2 = true;
            iq.d.d(this, "delete the temp file(%s) failed, on completed downloading.", e2);
            throw th;
        }
    }

    private void i() {
        if (this.f21284a.g() == this.f21284a.h()) {
            this.f21285b.a(this.f21284a.a(), this.f21284a.g());
            return;
        }
        if (this.f21298o.compareAndSet(true, false)) {
            if (iq.d.f29057a) {
                iq.d.b(this, "handleProgress update model's status with progress", new Object[0]);
            }
            this.f21284a.a((byte) 3);
        }
        if (this.f21297n.compareAndSet(true, false)) {
            if (iq.d.f29057a) {
                iq.d.b(this, "handleProgress notify user progress status", new Object[0]);
            }
            a((byte) 3);
        }
    }

    private void j() throws IOException {
        h();
        this.f21284a.a((byte) -3);
        this.f21285b.b(this.f21284a.a(), this.f21284a.h());
        this.f21285b.d(this.f21284a.a());
        a((byte) -3);
        if (iq.e.a().f29064g) {
            com.liulishuo.filedownloader.services.f.a(this.f21284a);
        }
    }

    private boolean k() {
        if (this.f21284a.i()) {
            FileDownloadModel fileDownloadModel = this.f21284a;
            fileDownloadModel.c(fileDownloadModel.g());
        } else if (this.f21284a.g() != this.f21284a.h()) {
            a((Exception) new FileDownloadGiveUpRetryException(f.a("sofar[%d] not equal total[%d]", Long.valueOf(this.f21284a.g()), Long.valueOf(this.f21284a.h()))));
            return true;
        }
        return false;
    }

    private void l() {
        this.f21284a.a((byte) -2);
        this.f21285b.c(this.f21284a.a(), this.f21284a.g());
        a((byte) -2);
    }

    /* access modifiers changed from: package-private */
    public void a(long j2) {
        this.f21296m.addAndGet(j2);
        this.f21284a.b(j2);
        b(SystemClock.elapsedRealtime());
        if (this.f21291h == null) {
            i();
        } else if (this.f21297n.get()) {
            a(this.f21291h.obtainMessage(3));
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Exception exc) {
        c(exc);
    }

    /* access modifiers changed from: package-private */
    public void a(Exception exc, int i2) {
        this.f21296m.set(0);
        Handler handler = this.f21291h;
        if (handler == null) {
            b(exc, i2);
        } else {
            a(handler.obtainMessage(5, i2, 0, exc));
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2, long j2, String str, String str2) throws IllegalArgumentException {
        String j3 = this.f21284a.j();
        if (j3 == null || j3.equals(str)) {
            this.f21286c.a(z2);
            this.f21284a.a((byte) 2);
            this.f21284a.c(j2);
            this.f21284a.b(str);
            this.f21284a.d(str2);
            this.f21285b.a(this.f21284a.a(), j2, str, str2);
            a((byte) 2);
            this.f21290g = a(j2, (long) this.f21289f);
            this.f21298o.compareAndSet(false, true);
            return;
        }
        throw new IllegalArgumentException(f.a("callback onConnected must with precondition succeed, but the etag is changes(%s != %s)", str, j3));
    }

    public boolean a() {
        HandlerThread handlerThread = this.f21292i;
        return handlerThread != null && handlerThread.isAlive();
    }

    /* access modifiers changed from: package-private */
    public void b() {
        Handler handler = this.f21291h;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f21292i.quit();
            this.f21294k = Thread.currentThread();
            while (this.f21293j) {
                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(100));
            }
            this.f21294k = null;
        }
    }

    public void c() {
        this.f21284a.a((byte) 1);
        this.f21285b.f(this.f21284a.a());
        a((byte) 1);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f21284a.a((byte) 6);
        a((byte) 6);
        this.f21285b.a(this.f21284a.a());
    }

    /* access modifiers changed from: package-private */
    public void e() {
        HandlerThread handlerThread = new HandlerThread("source-status-callback");
        this.f21292i = handlerThread;
        handlerThread.start();
        this.f21291h = new Handler(this.f21292i.getLooper(), this);
    }

    /* access modifiers changed from: package-private */
    public void f() {
        l();
    }

    /* access modifiers changed from: package-private */
    public void g() throws IOException {
        if (!k()) {
            j();
        }
    }

    public boolean handleMessage(Message message) {
        this.f21293j = true;
        int i2 = message.what;
        if (i2 == 3) {
            i();
        } else if (i2 == 5) {
            try {
                b((Exception) message.obj, message.arg1);
            } catch (Throwable th) {
                this.f21293j = false;
                if (this.f21294k != null) {
                    LockSupport.unpark(this.f21294k);
                }
                throw th;
            }
        }
        this.f21293j = false;
        if (this.f21294k != null) {
            LockSupport.unpark(this.f21294k);
        }
        return true;
    }
}
