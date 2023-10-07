package com.google.android.exoplayer2.upstream;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.k;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class Loader implements q {

    /* renamed from: a  reason: collision with root package name */
    public static final b f16943a = a(false, -9223372036854775807L);

    /* renamed from: b  reason: collision with root package name */
    public static final b f16944b = a(true, -9223372036854775807L);

    /* renamed from: c  reason: collision with root package name */
    public static final b f16945c = new b(2, -9223372036854775807L);

    /* renamed from: d  reason: collision with root package name */
    public static final b f16946d = new b(3, -9223372036854775807L);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final ExecutorService f16947e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public c<? extends d> f16948f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public IOException f16949g;

    public interface a<T extends d> {
        b a(T t2, long j2, long j3, IOException iOException, int i2);

        void a(T t2, long j2, long j3);

        void a(T t2, long j2, long j3, boolean z2);
    }

    public interface d {
        void a();

        void b() throws IOException, InterruptedException;
    }

    public interface e {
        void h();
    }

    public static final class UnexpectedLoaderException extends IOException {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public UnexpectedLoaderException(java.lang.Throwable r5) {
            /*
                r4 = this;
                java.lang.Class r0 = r5.getClass()
                java.lang.String r0 = r0.getSimpleName()
                java.lang.String r1 = r5.getMessage()
                java.lang.String r2 = java.lang.String.valueOf(r0)
                int r2 = r2.length()
                int r2 = r2 + 13
                java.lang.String r3 = java.lang.String.valueOf(r1)
                int r3 = r3.length()
                int r2 = r2 + r3
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>(r2)
                java.lang.String r2 = "Unexpected "
                r3.append(r2)
                r3.append(r0)
                java.lang.String r0 = ": "
                r3.append(r0)
                r3.append(r1)
                java.lang.String r0 = r3.toString()
                r4.<init>(r0, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.Loader.UnexpectedLoaderException.<init>(java.lang.Throwable):void");
        }
    }

    public static final class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f16950a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final long f16951b;

        private b(int i2, long j2) {
            this.f16950a = i2;
            this.f16951b = j2;
        }

        public boolean a() {
            int i2 = this.f16950a;
            return i2 == 0 || i2 == 1;
        }
    }

    private final class c<T extends d> extends Handler implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final int f16952a;

        /* renamed from: c  reason: collision with root package name */
        private final T f16954c;

        /* renamed from: d  reason: collision with root package name */
        private final long f16955d;

        /* renamed from: e  reason: collision with root package name */
        private a<T> f16956e;

        /* renamed from: f  reason: collision with root package name */
        private IOException f16957f;

        /* renamed from: g  reason: collision with root package name */
        private int f16958g;

        /* renamed from: h  reason: collision with root package name */
        private Thread f16959h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f16960i;

        /* renamed from: j  reason: collision with root package name */
        private volatile boolean f16961j;

        public c(Looper looper, T t2, a<T> aVar, int i2, long j2) {
            super(looper);
            this.f16954c = t2;
            this.f16956e = aVar;
            this.f16952a = i2;
            this.f16955d = j2;
        }

        private void a() {
            this.f16957f = null;
            Loader.this.f16947e.execute((Runnable) com.google.android.exoplayer2.util.a.b(Loader.this.f16948f));
        }

        private void b() {
            c unused = Loader.this.f16948f = null;
        }

        private long c() {
            return (long) Math.min((this.f16958g - 1) * 1000, 5000);
        }

        public void a(int i2) throws IOException {
            IOException iOException = this.f16957f;
            if (iOException != null && this.f16958g > i2) {
                throw iOException;
            }
        }

        public void a(long j2) {
            com.google.android.exoplayer2.util.a.b(Loader.this.f16948f == null);
            c unused = Loader.this.f16948f = this;
            if (j2 > 0) {
                sendEmptyMessageDelayed(0, j2);
            } else {
                a();
            }
        }

        public void a(boolean z2) {
            this.f16961j = z2;
            this.f16957f = null;
            if (hasMessages(0)) {
                this.f16960i = true;
                removeMessages(0);
                if (!z2) {
                    sendEmptyMessage(1);
                }
            } else {
                synchronized (this) {
                    this.f16960i = true;
                    this.f16954c.a();
                    Thread thread = this.f16959h;
                    if (thread != null) {
                        thread.interrupt();
                    }
                }
            }
            if (z2) {
                b();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                ((a) com.google.android.exoplayer2.util.a.b(this.f16956e)).a(this.f16954c, elapsedRealtime, elapsedRealtime - this.f16955d, true);
                this.f16956e = null;
            }
        }

        public void handleMessage(Message message) {
            if (!this.f16961j) {
                if (message.what == 0) {
                    a();
                } else if (message.what != 3) {
                    b();
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    long j2 = elapsedRealtime - this.f16955d;
                    a aVar = (a) com.google.android.exoplayer2.util.a.b(this.f16956e);
                    if (this.f16960i) {
                        aVar.a(this.f16954c, elapsedRealtime, j2, false);
                        return;
                    }
                    int i2 = message.what;
                    if (i2 == 1) {
                        try {
                            aVar.a(this.f16954c, elapsedRealtime, j2);
                        } catch (RuntimeException e2) {
                            k.b("LoadTask", "Unexpected exception handling load completed", e2);
                            IOException unused = Loader.this.f16949g = new UnexpectedLoaderException(e2);
                        }
                    } else if (i2 == 2) {
                        IOException iOException = (IOException) message.obj;
                        this.f16957f = iOException;
                        int i3 = this.f16958g + 1;
                        this.f16958g = i3;
                        b a2 = aVar.a(this.f16954c, elapsedRealtime, j2, iOException, i3);
                        if (a2.f16950a == 3) {
                            IOException unused2 = Loader.this.f16949g = this.f16957f;
                        } else if (a2.f16950a != 2) {
                            if (a2.f16950a == 1) {
                                this.f16958g = 1;
                            }
                            a(a2.f16951b != -9223372036854775807L ? a2.f16951b : c());
                        }
                    }
                } else {
                    throw ((Error) message.obj);
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:54:0x0085, code lost:
            r0.sendToTarget();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r5 = this;
                r0 = 1
                r1 = 2
                monitor-enter(r5)     // Catch:{ IOException -> 0x00a9, InterruptedException -> 0x009b, Exception -> 0x0089, OutOfMemoryError -> 0x0070, Error -> 0x005b }
                boolean r2 = r5.f16960i     // Catch:{ all -> 0x0058 }
                if (r2 != 0) goto L_0x0009
                r2 = 1
                goto L_0x000a
            L_0x0009:
                r2 = 0
            L_0x000a:
                java.lang.Thread r3 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0058 }
                r5.f16959h = r3     // Catch:{ all -> 0x0058 }
                monitor-exit(r5)     // Catch:{ all -> 0x0058 }
                if (r2 == 0) goto L_0x0045
                java.lang.String r2 = "load:"
                T r3 = r5.f16954c     // Catch:{ IOException -> 0x00a9, InterruptedException -> 0x009b, Exception -> 0x0089, OutOfMemoryError -> 0x0070, Error -> 0x005b }
                java.lang.Class r3 = r3.getClass()     // Catch:{ IOException -> 0x00a9, InterruptedException -> 0x009b, Exception -> 0x0089, OutOfMemoryError -> 0x0070, Error -> 0x005b }
                java.lang.String r3 = r3.getSimpleName()     // Catch:{ IOException -> 0x00a9, InterruptedException -> 0x009b, Exception -> 0x0089, OutOfMemoryError -> 0x0070, Error -> 0x005b }
                java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ IOException -> 0x00a9, InterruptedException -> 0x009b, Exception -> 0x0089, OutOfMemoryError -> 0x0070, Error -> 0x005b }
                int r4 = r3.length()     // Catch:{ IOException -> 0x00a9, InterruptedException -> 0x009b, Exception -> 0x0089, OutOfMemoryError -> 0x0070, Error -> 0x005b }
                if (r4 == 0) goto L_0x002e
                java.lang.String r2 = r2.concat(r3)     // Catch:{ IOException -> 0x00a9, InterruptedException -> 0x009b, Exception -> 0x0089, OutOfMemoryError -> 0x0070, Error -> 0x005b }
                goto L_0x0034
            L_0x002e:
                java.lang.String r3 = new java.lang.String     // Catch:{ IOException -> 0x00a9, InterruptedException -> 0x009b, Exception -> 0x0089, OutOfMemoryError -> 0x0070, Error -> 0x005b }
                r3.<init>(r2)     // Catch:{ IOException -> 0x00a9, InterruptedException -> 0x009b, Exception -> 0x0089, OutOfMemoryError -> 0x0070, Error -> 0x005b }
                r2 = r3
            L_0x0034:
                com.google.android.exoplayer2.util.ab.a(r2)     // Catch:{ IOException -> 0x00a9, InterruptedException -> 0x009b, Exception -> 0x0089, OutOfMemoryError -> 0x0070, Error -> 0x005b }
                T r2 = r5.f16954c     // Catch:{ all -> 0x0040 }
                r2.b()     // Catch:{ all -> 0x0040 }
                com.google.android.exoplayer2.util.ab.a()     // Catch:{ IOException -> 0x00a9, InterruptedException -> 0x009b, Exception -> 0x0089, OutOfMemoryError -> 0x0070, Error -> 0x005b }
                goto L_0x0045
            L_0x0040:
                r2 = move-exception
                com.google.android.exoplayer2.util.ab.a()     // Catch:{ IOException -> 0x00a9, InterruptedException -> 0x009b, Exception -> 0x0089, OutOfMemoryError -> 0x0070, Error -> 0x005b }
                throw r2     // Catch:{ IOException -> 0x00a9, InterruptedException -> 0x009b, Exception -> 0x0089, OutOfMemoryError -> 0x0070, Error -> 0x005b }
            L_0x0045:
                monitor-enter(r5)     // Catch:{ IOException -> 0x00a9, InterruptedException -> 0x009b, Exception -> 0x0089, OutOfMemoryError -> 0x0070, Error -> 0x005b }
                r2 = 0
                r5.f16959h = r2     // Catch:{ all -> 0x0055 }
                java.lang.Thread.interrupted()     // Catch:{ all -> 0x0055 }
                monitor-exit(r5)     // Catch:{ all -> 0x0055 }
                boolean r2 = r5.f16961j     // Catch:{ IOException -> 0x00a9, InterruptedException -> 0x009b, Exception -> 0x0089, OutOfMemoryError -> 0x0070, Error -> 0x005b }
                if (r2 != 0) goto L_0x00b3
                r5.sendEmptyMessage(r0)     // Catch:{ IOException -> 0x00a9, InterruptedException -> 0x009b, Exception -> 0x0089, OutOfMemoryError -> 0x0070, Error -> 0x005b }
                goto L_0x00b3
            L_0x0055:
                r2 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x0055 }
                throw r2     // Catch:{ IOException -> 0x00a9, InterruptedException -> 0x009b, Exception -> 0x0089, OutOfMemoryError -> 0x0070, Error -> 0x005b }
            L_0x0058:
                r2 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x0058 }
                throw r2     // Catch:{ IOException -> 0x00a9, InterruptedException -> 0x009b, Exception -> 0x0089, OutOfMemoryError -> 0x0070, Error -> 0x005b }
            L_0x005b:
                r0 = move-exception
                java.lang.String r1 = "LoadTask"
                java.lang.String r2 = "Unexpected error loading stream"
                com.google.android.exoplayer2.util.k.b(r1, r2, r0)
                boolean r1 = r5.f16961j
                if (r1 != 0) goto L_0x006f
                r1 = 3
                android.os.Message r1 = r5.obtainMessage(r1, r0)
                r1.sendToTarget()
            L_0x006f:
                throw r0
            L_0x0070:
                r0 = move-exception
                java.lang.String r2 = "LoadTask"
                java.lang.String r3 = "OutOfMemory error loading stream"
                com.google.android.exoplayer2.util.k.b(r2, r3, r0)
                boolean r2 = r5.f16961j
                if (r2 != 0) goto L_0x00b3
                com.google.android.exoplayer2.upstream.Loader$UnexpectedLoaderException r2 = new com.google.android.exoplayer2.upstream.Loader$UnexpectedLoaderException
                r2.<init>(r0)
            L_0x0081:
                android.os.Message r0 = r5.obtainMessage(r1, r2)
            L_0x0085:
                r0.sendToTarget()
                goto L_0x00b3
            L_0x0089:
                r0 = move-exception
                java.lang.String r2 = "LoadTask"
                java.lang.String r3 = "Unexpected exception loading stream"
                com.google.android.exoplayer2.util.k.b(r2, r3, r0)
                boolean r2 = r5.f16961j
                if (r2 != 0) goto L_0x00b3
                com.google.android.exoplayer2.upstream.Loader$UnexpectedLoaderException r2 = new com.google.android.exoplayer2.upstream.Loader$UnexpectedLoaderException
                r2.<init>(r0)
                goto L_0x0081
            L_0x009b:
                boolean r1 = r5.f16960i
                com.google.android.exoplayer2.util.a.b((boolean) r1)
                boolean r1 = r5.f16961j
                if (r1 != 0) goto L_0x00b3
                r5.sendEmptyMessage(r0)
                goto L_0x00b3
            L_0x00a9:
                r0 = move-exception
                boolean r2 = r5.f16961j
                if (r2 != 0) goto L_0x00b3
                android.os.Message r0 = r5.obtainMessage(r1, r0)
                goto L_0x0085
            L_0x00b3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.Loader.c.run():void");
        }
    }

    private static final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final e f16962a;

        public f(e eVar) {
            this.f16962a = eVar;
        }

        public void run() {
            this.f16962a.h();
        }
    }

    public Loader(String str) {
        this.f16947e = ad.a(str);
    }

    public static b a(boolean z2, long j2) {
        return new b(z2 ? 1 : 0, j2);
    }

    public <T extends d> long a(T t2, a<T> aVar, int i2) {
        this.f16949g = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new c((Looper) com.google.android.exoplayer2.util.a.a(Looper.myLooper()), t2, aVar, i2, elapsedRealtime).a(0);
        return elapsedRealtime;
    }

    public void a(int i2) throws IOException {
        IOException iOException = this.f16949g;
        if (iOException == null) {
            c<? extends d> cVar = this.f16948f;
            if (cVar != null) {
                if (i2 == Integer.MIN_VALUE) {
                    i2 = cVar.f16952a;
                }
                cVar.a(i2);
                return;
            }
            return;
        }
        throw iOException;
    }

    public void a(e eVar) {
        c<? extends d> cVar = this.f16948f;
        if (cVar != null) {
            cVar.a(true);
        }
        if (eVar != null) {
            this.f16947e.execute(new f(eVar));
        }
        this.f16947e.shutdown();
    }

    public boolean a() {
        return this.f16949g != null;
    }

    public void b() {
        this.f16949g = null;
    }

    public boolean c() {
        return this.f16948f != null;
    }

    public void d() {
        ((c) com.google.android.exoplayer2.util.a.a(this.f16948f)).a(false);
    }

    public void e() {
        a((e) null);
    }

    public void f() throws IOException {
        a(Integer.MIN_VALUE);
    }
}
