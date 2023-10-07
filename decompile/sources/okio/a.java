package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public class a extends s {

    /* renamed from: a  reason: collision with root package name */
    private static final long f32422a;

    /* renamed from: b  reason: collision with root package name */
    static a f32423b;

    /* renamed from: d  reason: collision with root package name */
    private static final long f32424d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f32425e;

    /* renamed from: f  reason: collision with root package name */
    private a f32426f;

    /* renamed from: g  reason: collision with root package name */
    private long f32427g;

    /* renamed from: okio.a$a  reason: collision with other inner class name */
    private static final class C0238a extends Thread {
        C0238a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r1.a();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
            L_0x0000:
                java.lang.Class<okio.a> r0 = okio.a.class
                monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0000 }
                okio.a r1 = okio.a.e()     // Catch:{ all -> 0x0019 }
                if (r1 != 0) goto L_0x000b
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                goto L_0x0000
            L_0x000b:
                okio.a r2 = okio.a.f32423b     // Catch:{ all -> 0x0019 }
                if (r1 != r2) goto L_0x0014
                r1 = 0
                okio.a.f32423b = r1     // Catch:{ all -> 0x0019 }
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                return
            L_0x0014:
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                r1.a()     // Catch:{ InterruptedException -> 0x0000 }
                goto L_0x0000
            L_0x0019:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                goto L_0x001d
            L_0x001c:
                throw r1
            L_0x001d:
                goto L_0x001c
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.a.C0238a.run():void");
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60);
        f32422a = millis;
        f32424d = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0052 A[EDGE_INSN: B:34:0x0052->B:23:0x0052 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void a(okio.a r6, long r7, boolean r9) {
        /*
            java.lang.Class<okio.a> r0 = okio.a.class
            monitor-enter(r0)
            okio.a r1 = f32423b     // Catch:{ all -> 0x0067 }
            if (r1 != 0) goto L_0x0016
            okio.a r1 = new okio.a     // Catch:{ all -> 0x0067 }
            r1.<init>()     // Catch:{ all -> 0x0067 }
            f32423b = r1     // Catch:{ all -> 0x0067 }
            okio.a$a r1 = new okio.a$a     // Catch:{ all -> 0x0067 }
            r1.<init>()     // Catch:{ all -> 0x0067 }
            r1.start()     // Catch:{ all -> 0x0067 }
        L_0x0016:
            long r1 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0067 }
            r3 = 0
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x002f
            if (r9 == 0) goto L_0x002f
            long r3 = r6.d()     // Catch:{ all -> 0x0067 }
            long r3 = r3 - r1
            long r7 = java.lang.Math.min(r7, r3)     // Catch:{ all -> 0x0067 }
        L_0x002b:
            long r7 = r7 + r1
            r6.f32427g = r7     // Catch:{ all -> 0x0067 }
            goto L_0x003c
        L_0x002f:
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0034
            goto L_0x002b
        L_0x0034:
            if (r9 == 0) goto L_0x0061
            long r7 = r6.d()     // Catch:{ all -> 0x0067 }
            r6.f32427g = r7     // Catch:{ all -> 0x0067 }
        L_0x003c:
            long r7 = r6.b((long) r1)     // Catch:{ all -> 0x0067 }
            okio.a r9 = f32423b     // Catch:{ all -> 0x0067 }
        L_0x0042:
            okio.a r3 = r9.f32426f     // Catch:{ all -> 0x0067 }
            if (r3 == 0) goto L_0x0052
            long r3 = r3.b((long) r1)     // Catch:{ all -> 0x0067 }
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x004f
            goto L_0x0052
        L_0x004f:
            okio.a r9 = r9.f32426f     // Catch:{ all -> 0x0067 }
            goto L_0x0042
        L_0x0052:
            okio.a r7 = r9.f32426f     // Catch:{ all -> 0x0067 }
            r6.f32426f = r7     // Catch:{ all -> 0x0067 }
            r9.f32426f = r6     // Catch:{ all -> 0x0067 }
            okio.a r6 = f32423b     // Catch:{ all -> 0x0067 }
            if (r9 != r6) goto L_0x005f
            r0.notify()     // Catch:{ all -> 0x0067 }
        L_0x005f:
            monitor-exit(r0)
            return
        L_0x0061:
            java.lang.AssertionError r6 = new java.lang.AssertionError     // Catch:{ all -> 0x0067 }
            r6.<init>()     // Catch:{ all -> 0x0067 }
            throw r6     // Catch:{ all -> 0x0067 }
        L_0x0067:
            r6 = move-exception
            monitor-exit(r0)
            goto L_0x006b
        L_0x006a:
            throw r6
        L_0x006b:
            goto L_0x006a
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.a.a(okio.a, long, boolean):void");
    }

    private static synchronized boolean a(a aVar) {
        boolean z2;
        synchronized (a.class) {
            a aVar2 = f32423b;
            while (true) {
                if (aVar2 == null) {
                    z2 = true;
                    break;
                }
                a aVar3 = aVar2.f32426f;
                if (aVar3 == aVar) {
                    aVar2.f32426f = aVar.f32426f;
                    aVar.f32426f = null;
                    z2 = false;
                    break;
                }
                aVar2 = aVar3;
            }
        }
        return z2;
    }

    private long b(long j2) {
        return this.f32427g - j2;
    }

    static a e() throws InterruptedException {
        Class<a> cls = a.class;
        a aVar = f32423b.f32426f;
        long nanoTime = System.nanoTime();
        if (aVar == null) {
            cls.wait(f32422a);
            if (f32423b.f32426f != null || System.nanoTime() - nanoTime < f32424d) {
                return null;
            }
            return f32423b;
        }
        long b2 = aVar.b(nanoTime);
        if (b2 > 0) {
            long j2 = b2 / 1000000;
            cls.wait(j2, (int) (b2 - (1000000 * j2)));
            return null;
        }
        f32423b.f32426f = aVar.f32426f;
        aVar.f32426f = null;
        return aVar;
    }

    public final boolean A_() {
        if (!this.f32425e) {
            return false;
        }
        this.f32425e = false;
        return a(this);
    }

    /* access modifiers changed from: protected */
    public IOException a(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final q a(final q qVar) {
        return new q() {
            public void close() throws IOException {
                a.this.c();
                try {
                    qVar.close();
                    a.this.a(true);
                } catch (IOException e2) {
                    throw a.this.b(e2);
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            public void flush() throws IOException {
                a.this.c();
                try {
                    qVar.flush();
                    a.this.a(true);
                } catch (IOException e2) {
                    throw a.this.b(e2);
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            public s timeout() {
                return a.this;
            }

            public String toString() {
                return "AsyncTimeout.sink(" + qVar + ")";
            }

            public void write(c cVar, long j2) throws IOException {
                t.a(cVar.f32436b, 0, j2);
                while (true) {
                    long j3 = 0;
                    if (j2 > 0) {
                        o oVar = cVar.f32435a;
                        while (true) {
                            if (j3 >= IjkMediaMeta.AV_CH_TOP_BACK_CENTER) {
                                break;
                            }
                            j3 += (long) (oVar.f32467c - oVar.f32466b);
                            if (j3 >= j2) {
                                j3 = j2;
                                break;
                            }
                            oVar = oVar.f32470f;
                        }
                        a.this.c();
                        try {
                            qVar.write(cVar, j3);
                            j2 -= j3;
                            a.this.a(true);
                        } catch (IOException e2) {
                            throw a.this.b(e2);
                        } catch (Throwable th) {
                            a.this.a(false);
                            throw th;
                        }
                    } else {
                        return;
                    }
                }
            }
        };
    }

    public final r a(final r rVar) {
        return new r() {
            public void close() throws IOException {
                a.this.c();
                try {
                    rVar.close();
                    a.this.a(true);
                } catch (IOException e2) {
                    throw a.this.b(e2);
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            public long read(c cVar, long j2) throws IOException {
                a.this.c();
                try {
                    long read = rVar.read(cVar, j2);
                    a.this.a(true);
                    return read;
                } catch (IOException e2) {
                    throw a.this.b(e2);
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            public s timeout() {
                return a.this;
            }

            public String toString() {
                return "AsyncTimeout.source(" + rVar + ")";
            }
        };
    }

    /* access modifiers changed from: protected */
    public void a() {
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z2) throws IOException {
        if (A_() && z2) {
            throw a((IOException) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final IOException b(IOException iOException) throws IOException {
        return !A_() ? iOException : a(iOException);
    }

    public final void c() {
        if (!this.f32425e) {
            long D_ = D_();
            boolean B_ = B_();
            if (D_ != 0 || B_) {
                this.f32425e = true;
                a(this, D_, B_);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }
}
