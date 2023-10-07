package nc;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

public final class d implements Closeable, Flushable {

    /* renamed from: a  reason: collision with root package name */
    static final Pattern f31345a = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: j  reason: collision with root package name */
    static final /* synthetic */ boolean f31346j = true;

    /* renamed from: b  reason: collision with root package name */
    final nf.a f31347b;

    /* renamed from: c  reason: collision with root package name */
    final int f31348c;

    /* renamed from: d  reason: collision with root package name */
    okio.d f31349d;

    /* renamed from: e  reason: collision with root package name */
    final LinkedHashMap<String, b> f31350e;

    /* renamed from: f  reason: collision with root package name */
    int f31351f;

    /* renamed from: g  reason: collision with root package name */
    boolean f31352g;

    /* renamed from: h  reason: collision with root package name */
    boolean f31353h;

    /* renamed from: i  reason: collision with root package name */
    boolean f31354i;

    /* renamed from: k  reason: collision with root package name */
    private long f31355k;

    /* renamed from: l  reason: collision with root package name */
    private long f31356l;

    /* renamed from: m  reason: collision with root package name */
    private long f31357m;

    /* renamed from: n  reason: collision with root package name */
    private final Executor f31358n;

    /* renamed from: o  reason: collision with root package name */
    private final Runnable f31359o;

    public final class a {

        /* renamed from: a  reason: collision with root package name */
        final b f31360a;

        /* renamed from: b  reason: collision with root package name */
        final boolean[] f31361b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d f31362c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f31363d;

        /* access modifiers changed from: package-private */
        public void a() {
            if (this.f31360a.f31369f == this) {
                for (int i2 = 0; i2 < this.f31362c.f31348c; i2++) {
                    try {
                        this.f31362c.f31347b.a(this.f31360a.f31367d[i2]);
                    } catch (IOException unused) {
                    }
                }
                this.f31360a.f31369f = null;
            }
        }

        public void b() throws IOException {
            synchronized (this.f31362c) {
                if (!this.f31363d) {
                    if (this.f31360a.f31369f == this) {
                        this.f31362c.a(this, false);
                    }
                    this.f31363d = true;
                } else {
                    throw new IllegalStateException();
                }
            }
        }
    }

    private final class b {

        /* renamed from: a  reason: collision with root package name */
        final String f31364a;

        /* renamed from: b  reason: collision with root package name */
        final long[] f31365b;

        /* renamed from: c  reason: collision with root package name */
        final File[] f31366c;

        /* renamed from: d  reason: collision with root package name */
        final File[] f31367d;

        /* renamed from: e  reason: collision with root package name */
        boolean f31368e;

        /* renamed from: f  reason: collision with root package name */
        a f31369f;

        /* renamed from: g  reason: collision with root package name */
        long f31370g;

        /* access modifiers changed from: package-private */
        public void a(okio.d dVar) throws IOException {
            for (long l2 : this.f31365b) {
                dVar.i(32).l(l2);
            }
        }
    }

    private synchronized void d() {
        if (b()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f4, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(nc.d.a r10, boolean r11) throws java.io.IOException {
        /*
            r9 = this;
            monitor-enter(r9)
            nc.d$b r0 = r10.f31360a     // Catch:{ all -> 0x00fb }
            nc.d$a r1 = r0.f31369f     // Catch:{ all -> 0x00fb }
            if (r1 != r10) goto L_0x00f5
            r1 = 0
            if (r11 == 0) goto L_0x0047
            boolean r2 = r0.f31368e     // Catch:{ all -> 0x00fb }
            if (r2 != 0) goto L_0x0047
            r2 = 0
        L_0x000f:
            int r3 = r9.f31348c     // Catch:{ all -> 0x00fb }
            if (r2 >= r3) goto L_0x0047
            boolean[] r3 = r10.f31361b     // Catch:{ all -> 0x00fb }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x00fb }
            if (r3 == 0) goto L_0x002d
            nf.a r3 = r9.f31347b     // Catch:{ all -> 0x00fb }
            java.io.File[] r4 = r0.f31367d     // Catch:{ all -> 0x00fb }
            r4 = r4[r2]     // Catch:{ all -> 0x00fb }
            boolean r3 = r3.b(r4)     // Catch:{ all -> 0x00fb }
            if (r3 != 0) goto L_0x002a
            r10.b()     // Catch:{ all -> 0x00fb }
            monitor-exit(r9)
            return
        L_0x002a:
            int r2 = r2 + 1
            goto L_0x000f
        L_0x002d:
            r10.b()     // Catch:{ all -> 0x00fb }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00fb }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fb }
            r11.<init>()     // Catch:{ all -> 0x00fb }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r11.append(r0)     // Catch:{ all -> 0x00fb }
            r11.append(r2)     // Catch:{ all -> 0x00fb }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00fb }
            r10.<init>(r11)     // Catch:{ all -> 0x00fb }
            throw r10     // Catch:{ all -> 0x00fb }
        L_0x0047:
            int r10 = r9.f31348c     // Catch:{ all -> 0x00fb }
            if (r1 >= r10) goto L_0x007f
            java.io.File[] r10 = r0.f31367d     // Catch:{ all -> 0x00fb }
            r10 = r10[r1]     // Catch:{ all -> 0x00fb }
            if (r11 == 0) goto L_0x0077
            nf.a r2 = r9.f31347b     // Catch:{ all -> 0x00fb }
            boolean r2 = r2.b(r10)     // Catch:{ all -> 0x00fb }
            if (r2 == 0) goto L_0x007c
            java.io.File[] r2 = r0.f31366c     // Catch:{ all -> 0x00fb }
            r2 = r2[r1]     // Catch:{ all -> 0x00fb }
            nf.a r3 = r9.f31347b     // Catch:{ all -> 0x00fb }
            r3.a(r10, r2)     // Catch:{ all -> 0x00fb }
            long[] r10 = r0.f31365b     // Catch:{ all -> 0x00fb }
            r3 = r10[r1]     // Catch:{ all -> 0x00fb }
            nf.a r10 = r9.f31347b     // Catch:{ all -> 0x00fb }
            long r5 = r10.c(r2)     // Catch:{ all -> 0x00fb }
            long[] r10 = r0.f31365b     // Catch:{ all -> 0x00fb }
            r10[r1] = r5     // Catch:{ all -> 0x00fb }
            long r7 = r9.f31356l     // Catch:{ all -> 0x00fb }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.f31356l = r7     // Catch:{ all -> 0x00fb }
            goto L_0x007c
        L_0x0077:
            nf.a r2 = r9.f31347b     // Catch:{ all -> 0x00fb }
            r2.a(r10)     // Catch:{ all -> 0x00fb }
        L_0x007c:
            int r1 = r1 + 1
            goto L_0x0047
        L_0x007f:
            int r10 = r9.f31351f     // Catch:{ all -> 0x00fb }
            r1 = 1
            int r10 = r10 + r1
            r9.f31351f = r10     // Catch:{ all -> 0x00fb }
            r10 = 0
            r0.f31369f = r10     // Catch:{ all -> 0x00fb }
            boolean r10 = r0.f31368e     // Catch:{ all -> 0x00fb }
            r10 = r10 | r11
            r2 = 10
            r3 = 32
            if (r10 == 0) goto L_0x00bb
            r0.f31368e = r1     // Catch:{ all -> 0x00fb }
            okio.d r10 = r9.f31349d     // Catch:{ all -> 0x00fb }
            java.lang.String r1 = "CLEAN"
            okio.d r10 = r10.b((java.lang.String) r1)     // Catch:{ all -> 0x00fb }
            r10.i(r3)     // Catch:{ all -> 0x00fb }
            okio.d r10 = r9.f31349d     // Catch:{ all -> 0x00fb }
            java.lang.String r1 = r0.f31364a     // Catch:{ all -> 0x00fb }
            r10.b((java.lang.String) r1)     // Catch:{ all -> 0x00fb }
            okio.d r10 = r9.f31349d     // Catch:{ all -> 0x00fb }
            r0.a(r10)     // Catch:{ all -> 0x00fb }
            okio.d r10 = r9.f31349d     // Catch:{ all -> 0x00fb }
            r10.i(r2)     // Catch:{ all -> 0x00fb }
            if (r11 == 0) goto L_0x00d9
            long r10 = r9.f31357m     // Catch:{ all -> 0x00fb }
            r1 = 1
            long r1 = r1 + r10
            r9.f31357m = r1     // Catch:{ all -> 0x00fb }
            r0.f31370g = r10     // Catch:{ all -> 0x00fb }
            goto L_0x00d9
        L_0x00bb:
            java.util.LinkedHashMap<java.lang.String, nc.d$b> r10 = r9.f31350e     // Catch:{ all -> 0x00fb }
            java.lang.String r11 = r0.f31364a     // Catch:{ all -> 0x00fb }
            r10.remove(r11)     // Catch:{ all -> 0x00fb }
            okio.d r10 = r9.f31349d     // Catch:{ all -> 0x00fb }
            java.lang.String r11 = "REMOVE"
            okio.d r10 = r10.b((java.lang.String) r11)     // Catch:{ all -> 0x00fb }
            r10.i(r3)     // Catch:{ all -> 0x00fb }
            okio.d r10 = r9.f31349d     // Catch:{ all -> 0x00fb }
            java.lang.String r11 = r0.f31364a     // Catch:{ all -> 0x00fb }
            r10.b((java.lang.String) r11)     // Catch:{ all -> 0x00fb }
            okio.d r10 = r9.f31349d     // Catch:{ all -> 0x00fb }
            r10.i(r2)     // Catch:{ all -> 0x00fb }
        L_0x00d9:
            okio.d r10 = r9.f31349d     // Catch:{ all -> 0x00fb }
            r10.flush()     // Catch:{ all -> 0x00fb }
            long r10 = r9.f31356l     // Catch:{ all -> 0x00fb }
            long r0 = r9.f31355k     // Catch:{ all -> 0x00fb }
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x00ec
            boolean r10 = r9.a()     // Catch:{ all -> 0x00fb }
            if (r10 == 0) goto L_0x00f3
        L_0x00ec:
            java.util.concurrent.Executor r10 = r9.f31358n     // Catch:{ all -> 0x00fb }
            java.lang.Runnable r11 = r9.f31359o     // Catch:{ all -> 0x00fb }
            r10.execute(r11)     // Catch:{ all -> 0x00fb }
        L_0x00f3:
            monitor-exit(r9)
            return
        L_0x00f5:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00fb }
            r10.<init>()     // Catch:{ all -> 0x00fb }
            throw r10     // Catch:{ all -> 0x00fb }
        L_0x00fb:
            r10 = move-exception
            monitor-exit(r9)
            goto L_0x00ff
        L_0x00fe:
            throw r10
        L_0x00ff:
            goto L_0x00fe
        */
        throw new UnsupportedOperationException("Method not decompiled: nc.d.a(nc.d$a, boolean):void");
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        int i2 = this.f31351f;
        return i2 >= 2000 && i2 >= this.f31350e.size();
    }

    /* access modifiers changed from: package-private */
    public boolean a(b bVar) throws IOException {
        if (bVar.f31369f != null) {
            bVar.f31369f.a();
        }
        for (int i2 = 0; i2 < this.f31348c; i2++) {
            this.f31347b.a(bVar.f31366c[i2]);
            this.f31356l -= bVar.f31365b[i2];
            bVar.f31365b[i2] = 0;
        }
        this.f31351f++;
        this.f31349d.b("REMOVE").i(32).b(bVar.f31364a).i(10);
        this.f31350e.remove(bVar.f31364a);
        if (a()) {
            this.f31358n.execute(this.f31359o);
        }
        return true;
    }

    public synchronized boolean b() {
        return this.f31353h;
    }

    /* access modifiers changed from: package-private */
    public void c() throws IOException {
        while (this.f31356l > this.f31355k) {
            a(this.f31350e.values().iterator().next());
        }
        this.f31354i = false;
    }

    public synchronized void close() throws IOException {
        if (this.f31352g) {
            if (!this.f31353h) {
                for (b bVar : (b[]) this.f31350e.values().toArray(new b[this.f31350e.size()])) {
                    if (bVar.f31369f != null) {
                        bVar.f31369f.b();
                    }
                }
                c();
                this.f31349d.close();
                this.f31349d = null;
                this.f31353h = true;
                return;
            }
        }
        this.f31353h = true;
    }

    public synchronized void flush() throws IOException {
        if (this.f31352g) {
            d();
            c();
            this.f31349d.flush();
        }
    }
}
