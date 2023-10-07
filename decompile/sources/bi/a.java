package bi;

import android.os.Build;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    final ThreadPoolExecutor f5646a = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new C0049a());
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final File f5647b;

    /* renamed from: c  reason: collision with root package name */
    private final File f5648c;

    /* renamed from: d  reason: collision with root package name */
    private final File f5649d;

    /* renamed from: e  reason: collision with root package name */
    private final File f5650e;

    /* renamed from: f  reason: collision with root package name */
    private final int f5651f;

    /* renamed from: g  reason: collision with root package name */
    private long f5652g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final int f5653h;

    /* renamed from: i  reason: collision with root package name */
    private long f5654i = 0;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public Writer f5655j;

    /* renamed from: k  reason: collision with root package name */
    private final LinkedHashMap<String, c> f5656k = new LinkedHashMap<>(0, 0.75f, true);
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public int f5657l;

    /* renamed from: m  reason: collision with root package name */
    private long f5658m = 0;

    /* renamed from: n  reason: collision with root package name */
    private final Callable<Void> f5659n = new Callable<Void>() {
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
            return null;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void call() throws java.lang.Exception {
            /*
                r4 = this;
                bi.a r0 = bi.a.this
                monitor-enter(r0)
                bi.a r1 = bi.a.this     // Catch:{ all -> 0x0028 }
                java.io.Writer r1 = r1.f5655j     // Catch:{ all -> 0x0028 }
                r2 = 0
                if (r1 != 0) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x000e:
                bi.a r1 = bi.a.this     // Catch:{ all -> 0x0028 }
                r1.g()     // Catch:{ all -> 0x0028 }
                bi.a r1 = bi.a.this     // Catch:{ all -> 0x0028 }
                boolean r1 = r1.e()     // Catch:{ all -> 0x0028 }
                if (r1 == 0) goto L_0x0026
                bi.a r1 = bi.a.this     // Catch:{ all -> 0x0028 }
                r1.d()     // Catch:{ all -> 0x0028 }
                bi.a r1 = bi.a.this     // Catch:{ all -> 0x0028 }
                r3 = 0
                int unused = r1.f5657l = r3     // Catch:{ all -> 0x0028 }
            L_0x0026:
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x0028:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: bi.a.AnonymousClass1.call():java.lang.Void");
        }
    };

    /* renamed from: bi.a$a  reason: collision with other inner class name */
    private static final class C0049a implements ThreadFactory {
        private C0049a() {
        }

        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    public final class b {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final c f5662b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final boolean[] f5663c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f5664d;

        private b(c cVar) {
            this.f5662b = cVar;
            this.f5663c = cVar.f5670f ? null : new boolean[a.this.f5653h];
        }

        public File a(int i2) throws IOException {
            File b2;
            synchronized (a.this) {
                if (this.f5662b.f5671g == this) {
                    if (!this.f5662b.f5670f) {
                        this.f5663c[i2] = true;
                    }
                    b2 = this.f5662b.b(i2);
                    a.this.f5647b.mkdirs();
                } else {
                    throw new IllegalStateException();
                }
            }
            return b2;
        }

        public void a() throws IOException {
            a.this.a(this, true);
            this.f5664d = true;
        }

        public void b() throws IOException {
            a.this.a(this, false);
        }

        public void c() {
            if (!this.f5664d) {
                try {
                    b();
                } catch (IOException unused) {
                }
            }
        }
    }

    private final class c {

        /* renamed from: a  reason: collision with root package name */
        File[] f5665a;

        /* renamed from: b  reason: collision with root package name */
        File[] f5666b;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final String f5668d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final long[] f5669e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public boolean f5670f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public b f5671g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public long f5672h;

        private c(String str) {
            this.f5668d = str;
            this.f5669e = new long[a.this.f5653h];
            this.f5665a = new File[a.this.f5653h];
            this.f5666b = new File[a.this.f5653h];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i2 = 0; i2 < a.this.f5653h; i2++) {
                sb.append(i2);
                this.f5665a[i2] = new File(a.this.f5647b, sb.toString());
                sb.append(".tmp");
                this.f5666b[i2] = new File(a.this.f5647b, sb.toString());
                sb.setLength(length);
            }
        }

        /* access modifiers changed from: private */
        public void a(String[] strArr) throws IOException {
            if (strArr.length == a.this.f5653h) {
                int i2 = 0;
                while (i2 < strArr.length) {
                    try {
                        this.f5669e[i2] = Long.parseLong(strArr[i2]);
                        i2++;
                    } catch (NumberFormatException unused) {
                        throw b(strArr);
                    }
                }
                return;
            }
            throw b(strArr);
        }

        private IOException b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File a(int i2) {
            return this.f5665a[i2];
        }

        public String a() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long append : this.f5669e) {
                sb.append(' ');
                sb.append(append);
            }
            return sb.toString();
        }

        public File b(int i2) {
            return this.f5666b[i2];
        }
    }

    public final class d {

        /* renamed from: b  reason: collision with root package name */
        private final String f5674b;

        /* renamed from: c  reason: collision with root package name */
        private final long f5675c;

        /* renamed from: d  reason: collision with root package name */
        private final long[] f5676d;

        /* renamed from: e  reason: collision with root package name */
        private final File[] f5677e;

        private d(String str, long j2, File[] fileArr, long[] jArr) {
            this.f5674b = str;
            this.f5675c = j2;
            this.f5677e = fileArr;
            this.f5676d = jArr;
        }

        public File a(int i2) {
            return this.f5677e[i2];
        }
    }

    private a(File file, int i2, int i3, long j2) {
        File file2 = file;
        this.f5647b = file2;
        this.f5651f = i2;
        this.f5648c = new File(file2, "journal");
        this.f5649d = new File(file2, "journal.tmp");
        this.f5650e = new File(file2, "journal.bkp");
        this.f5653h = i3;
        this.f5652g = j2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized bi.a.b a(java.lang.String r6, long r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.f()     // Catch:{ all -> 0x005d }
            java.util.LinkedHashMap<java.lang.String, bi.a$c> r0 = r5.f5656k     // Catch:{ all -> 0x005d }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x005d }
            bi.a$c r0 = (bi.a.c) r0     // Catch:{ all -> 0x005d }
            r1 = -1
            r3 = 0
            int r4 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x001f
            if (r0 == 0) goto L_0x001d
            long r1 = r0.f5672h     // Catch:{ all -> 0x005d }
            int r4 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x001f
        L_0x001d:
            monitor-exit(r5)
            return r3
        L_0x001f:
            if (r0 != 0) goto L_0x002c
            bi.a$c r0 = new bi.a$c     // Catch:{ all -> 0x005d }
            r0.<init>(r6)     // Catch:{ all -> 0x005d }
            java.util.LinkedHashMap<java.lang.String, bi.a$c> r7 = r5.f5656k     // Catch:{ all -> 0x005d }
            r7.put(r6, r0)     // Catch:{ all -> 0x005d }
            goto L_0x0034
        L_0x002c:
            bi.a$b r7 = r0.f5671g     // Catch:{ all -> 0x005d }
            if (r7 == 0) goto L_0x0034
            monitor-exit(r5)
            return r3
        L_0x0034:
            bi.a$b r7 = new bi.a$b     // Catch:{ all -> 0x005d }
            r7.<init>(r0)     // Catch:{ all -> 0x005d }
            bi.a.b unused = r0.f5671g = r7     // Catch:{ all -> 0x005d }
            java.io.Writer r8 = r5.f5655j     // Catch:{ all -> 0x005d }
            java.lang.String r0 = "DIRTY"
            r8.append(r0)     // Catch:{ all -> 0x005d }
            java.io.Writer r8 = r5.f5655j     // Catch:{ all -> 0x005d }
            r0 = 32
            r8.append(r0)     // Catch:{ all -> 0x005d }
            java.io.Writer r8 = r5.f5655j     // Catch:{ all -> 0x005d }
            r8.append(r6)     // Catch:{ all -> 0x005d }
            java.io.Writer r6 = r5.f5655j     // Catch:{ all -> 0x005d }
            r8 = 10
            r6.append(r8)     // Catch:{ all -> 0x005d }
            java.io.Writer r6 = r5.f5655j     // Catch:{ all -> 0x005d }
            b((java.io.Writer) r6)     // Catch:{ all -> 0x005d }
            monitor-exit(r5)
            return r7
        L_0x005d:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: bi.a.a(java.lang.String, long):bi.a$b");
    }

    public static a a(File file, int i2, int i3, long j2) throws IOException {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i3 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            a aVar = new a(file, i2, i3, j2);
            if (aVar.f5648c.exists()) {
                try {
                    aVar.b();
                    aVar.c();
                    return aVar;
                } catch (IOException e2) {
                    PrintStream printStream = System.out;
                    printStream.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                    aVar.a();
                }
            }
            file.mkdirs();
            a aVar2 = new a(file, i2, i3, j2);
            aVar2.d();
            return aVar2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0107, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(bi.a.b r10, boolean r11) throws java.io.IOException {
        /*
            r9 = this;
            monitor-enter(r9)
            bi.a$c r0 = r10.f5662b     // Catch:{ all -> 0x010e }
            bi.a$b r1 = r0.f5671g     // Catch:{ all -> 0x010e }
            if (r1 != r10) goto L_0x0108
            r1 = 0
            if (r11 == 0) goto L_0x004d
            boolean r2 = r0.f5670f     // Catch:{ all -> 0x010e }
            if (r2 != 0) goto L_0x004d
            r2 = 0
        L_0x0015:
            int r3 = r9.f5653h     // Catch:{ all -> 0x010e }
            if (r2 >= r3) goto L_0x004d
            boolean[] r3 = r10.f5663c     // Catch:{ all -> 0x010e }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x010e }
            if (r3 == 0) goto L_0x0033
            java.io.File r3 = r0.b((int) r2)     // Catch:{ all -> 0x010e }
            boolean r3 = r3.exists()     // Catch:{ all -> 0x010e }
            if (r3 != 0) goto L_0x0030
            r10.b()     // Catch:{ all -> 0x010e }
            monitor-exit(r9)
            return
        L_0x0030:
            int r2 = r2 + 1
            goto L_0x0015
        L_0x0033:
            r10.b()     // Catch:{ all -> 0x010e }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x010e }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x010e }
            r11.<init>()     // Catch:{ all -> 0x010e }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r11.append(r0)     // Catch:{ all -> 0x010e }
            r11.append(r2)     // Catch:{ all -> 0x010e }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x010e }
            r10.<init>(r11)     // Catch:{ all -> 0x010e }
            throw r10     // Catch:{ all -> 0x010e }
        L_0x004d:
            int r10 = r9.f5653h     // Catch:{ all -> 0x010e }
            if (r1 >= r10) goto L_0x0081
            java.io.File r10 = r0.b((int) r1)     // Catch:{ all -> 0x010e }
            if (r11 == 0) goto L_0x007b
            boolean r2 = r10.exists()     // Catch:{ all -> 0x010e }
            if (r2 == 0) goto L_0x007e
            java.io.File r2 = r0.a((int) r1)     // Catch:{ all -> 0x010e }
            r10.renameTo(r2)     // Catch:{ all -> 0x010e }
            long[] r10 = r0.f5669e     // Catch:{ all -> 0x010e }
            r3 = r10[r1]     // Catch:{ all -> 0x010e }
            long r5 = r2.length()     // Catch:{ all -> 0x010e }
            long[] r10 = r0.f5669e     // Catch:{ all -> 0x010e }
            r10[r1] = r5     // Catch:{ all -> 0x010e }
            long r7 = r9.f5654i     // Catch:{ all -> 0x010e }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.f5654i = r7     // Catch:{ all -> 0x010e }
            goto L_0x007e
        L_0x007b:
            a((java.io.File) r10)     // Catch:{ all -> 0x010e }
        L_0x007e:
            int r1 = r1 + 1
            goto L_0x004d
        L_0x0081:
            int r10 = r9.f5657l     // Catch:{ all -> 0x010e }
            r1 = 1
            int r10 = r10 + r1
            r9.f5657l = r10     // Catch:{ all -> 0x010e }
            r10 = 0
            bi.a.b unused = r0.f5671g = r10     // Catch:{ all -> 0x010e }
            boolean r10 = r0.f5670f     // Catch:{ all -> 0x010e }
            r10 = r10 | r11
            r2 = 10
            r3 = 32
            if (r10 == 0) goto L_0x00c9
            boolean unused = r0.f5670f = r1     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f5655j     // Catch:{ all -> 0x010e }
            java.lang.String r1 = "CLEAN"
            r10.append(r1)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f5655j     // Catch:{ all -> 0x010e }
            r10.append(r3)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f5655j     // Catch:{ all -> 0x010e }
            java.lang.String r1 = r0.f5668d     // Catch:{ all -> 0x010e }
            r10.append(r1)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f5655j     // Catch:{ all -> 0x010e }
            java.lang.String r1 = r0.a()     // Catch:{ all -> 0x010e }
            r10.append(r1)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f5655j     // Catch:{ all -> 0x010e }
            r10.append(r2)     // Catch:{ all -> 0x010e }
            if (r11 == 0) goto L_0x00ec
            long r10 = r9.f5658m     // Catch:{ all -> 0x010e }
            r1 = 1
            long r1 = r1 + r10
            r9.f5658m = r1     // Catch:{ all -> 0x010e }
            long unused = r0.f5672h = r10     // Catch:{ all -> 0x010e }
            goto L_0x00ec
        L_0x00c9:
            java.util.LinkedHashMap<java.lang.String, bi.a$c> r10 = r9.f5656k     // Catch:{ all -> 0x010e }
            java.lang.String r11 = r0.f5668d     // Catch:{ all -> 0x010e }
            r10.remove(r11)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f5655j     // Catch:{ all -> 0x010e }
            java.lang.String r11 = "REMOVE"
            r10.append(r11)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f5655j     // Catch:{ all -> 0x010e }
            r10.append(r3)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f5655j     // Catch:{ all -> 0x010e }
            java.lang.String r11 = r0.f5668d     // Catch:{ all -> 0x010e }
            r10.append(r11)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f5655j     // Catch:{ all -> 0x010e }
            r10.append(r2)     // Catch:{ all -> 0x010e }
        L_0x00ec:
            java.io.Writer r10 = r9.f5655j     // Catch:{ all -> 0x010e }
            b((java.io.Writer) r10)     // Catch:{ all -> 0x010e }
            long r10 = r9.f5654i     // Catch:{ all -> 0x010e }
            long r0 = r9.f5652g     // Catch:{ all -> 0x010e }
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x00ff
            boolean r10 = r9.e()     // Catch:{ all -> 0x010e }
            if (r10 == 0) goto L_0x0106
        L_0x00ff:
            java.util.concurrent.ThreadPoolExecutor r10 = r9.f5646a     // Catch:{ all -> 0x010e }
            java.util.concurrent.Callable<java.lang.Void> r11 = r9.f5659n     // Catch:{ all -> 0x010e }
            r10.submit(r11)     // Catch:{ all -> 0x010e }
        L_0x0106:
            monitor-exit(r9)
            return
        L_0x0108:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x010e }
            r10.<init>()     // Catch:{ all -> 0x010e }
            throw r10     // Catch:{ all -> 0x010e }
        L_0x010e:
            r10 = move-exception
            monitor-exit(r9)
            goto L_0x0112
        L_0x0111:
            throw r10
        L_0x0112:
            goto L_0x0111
        */
        throw new UnsupportedOperationException("Method not decompiled: bi.a.a(bi.a$b, boolean):void");
    }

    private static void a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z2) throws IOException {
        if (z2) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private static void a(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|(1:19)(1:20)|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r9.f5657l = r0 - r9.f5656k.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
        if (r1.b() != false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006e, code lost:
        d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0072, code lost:
        r9.f5655j = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(r9.f5648c, true), bi.c.f5684a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008b, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005f */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x008c=Splitter:B:23:0x008c, B:16:0x005f=Splitter:B:16:0x005f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b() throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            bi.b r1 = new bi.b
            java.io.FileInputStream r2 = new java.io.FileInputStream
            java.io.File r3 = r9.f5648c
            r2.<init>(r3)
            java.nio.charset.Charset r3 = bi.c.f5684a
            r1.<init>(r2, r3)
            java.lang.String r2 = r1.a()     // Catch:{ all -> 0x00ba }
            java.lang.String r3 = r1.a()     // Catch:{ all -> 0x00ba }
            java.lang.String r4 = r1.a()     // Catch:{ all -> 0x00ba }
            java.lang.String r5 = r1.a()     // Catch:{ all -> 0x00ba }
            java.lang.String r6 = r1.a()     // Catch:{ all -> 0x00ba }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x00ba }
            if (r7 == 0) goto L_0x008c
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x00ba }
            if (r7 == 0) goto L_0x008c
            int r7 = r9.f5651f     // Catch:{ all -> 0x00ba }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x00ba }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x008c
            int r4 = r9.f5653h     // Catch:{ all -> 0x00ba }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x00ba }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x008c
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x008c
            r0 = 0
        L_0x0055:
            java.lang.String r2 = r1.a()     // Catch:{ EOFException -> 0x005f }
            r9.d((java.lang.String) r2)     // Catch:{ EOFException -> 0x005f }
            int r0 = r0 + 1
            goto L_0x0055
        L_0x005f:
            java.util.LinkedHashMap<java.lang.String, bi.a$c> r2 = r9.f5656k     // Catch:{ all -> 0x00ba }
            int r2 = r2.size()     // Catch:{ all -> 0x00ba }
            int r0 = r0 - r2
            r9.f5657l = r0     // Catch:{ all -> 0x00ba }
            boolean r0 = r1.b()     // Catch:{ all -> 0x00ba }
            if (r0 == 0) goto L_0x0072
            r9.d()     // Catch:{ all -> 0x00ba }
            goto L_0x0088
        L_0x0072:
            java.io.BufferedWriter r0 = new java.io.BufferedWriter     // Catch:{ all -> 0x00ba }
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x00ba }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x00ba }
            java.io.File r4 = r9.f5648c     // Catch:{ all -> 0x00ba }
            r5 = 1
            r3.<init>(r4, r5)     // Catch:{ all -> 0x00ba }
            java.nio.charset.Charset r4 = bi.c.f5684a     // Catch:{ all -> 0x00ba }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x00ba }
            r0.<init>(r2)     // Catch:{ all -> 0x00ba }
            r9.f5655j = r0     // Catch:{ all -> 0x00ba }
        L_0x0088:
            bi.c.a((java.io.Closeable) r1)
            return
        L_0x008c:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x00ba }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ba }
            r7.<init>()     // Catch:{ all -> 0x00ba }
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)     // Catch:{ all -> 0x00ba }
            r7.append(r2)     // Catch:{ all -> 0x00ba }
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            r7.append(r3)     // Catch:{ all -> 0x00ba }
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            r7.append(r5)     // Catch:{ all -> 0x00ba }
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            r7.append(r6)     // Catch:{ all -> 0x00ba }
            java.lang.String r0 = "]"
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x00ba }
            r4.<init>(r0)     // Catch:{ all -> 0x00ba }
            throw r4     // Catch:{ all -> 0x00ba }
        L_0x00ba:
            r0 = move-exception
            bi.c.a((java.io.Closeable) r1)
            goto L_0x00c0
        L_0x00bf:
            throw r0
        L_0x00c0:
            goto L_0x00bf
        */
        throw new UnsupportedOperationException("Method not decompiled: bi.a.b():void");
    }

    private static void b(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    private void c() throws IOException {
        a(this.f5649d);
        Iterator<c> it2 = this.f5656k.values().iterator();
        while (it2.hasNext()) {
            c next = it2.next();
            int i2 = 0;
            if (next.f5671g == null) {
                while (i2 < this.f5653h) {
                    this.f5654i += next.f5669e[i2];
                    i2++;
                }
            } else {
                b unused = next.f5671g = null;
                while (i2 < this.f5653h) {
                    a(next.a(i2));
                    a(next.b(i2));
                    i2++;
                }
                it2.remove();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public synchronized void d() throws IOException {
        String str;
        Writer writer = this.f5655j;
        if (writer != null) {
            a(writer);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f5649d), c.f5684a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f5651f));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f5653h));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (c next : this.f5656k.values()) {
                if (next.f5671g != null) {
                    str = "DIRTY " + next.f5668d + 10;
                } else {
                    str = "CLEAN " + next.f5668d + next.a() + 10;
                }
                bufferedWriter.write(str);
            }
            a((Writer) bufferedWriter);
            if (this.f5648c.exists()) {
                a(this.f5648c, this.f5650e, true);
            }
            a(this.f5649d, this.f5648c, false);
            this.f5650e.delete();
            this.f5655j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f5648c, true), c.f5684a));
        } catch (Throwable th) {
            a((Writer) bufferedWriter);
            throw th;
        }
    }

    private void d(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i2 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i2);
            if (indexOf2 == -1) {
                str2 = str.substring(i2);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f5656k.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i2, indexOf2);
            }
            c cVar = this.f5656k.get(str2);
            if (cVar == null) {
                cVar = new c(str2);
                this.f5656k.put(str2, cVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                boolean unused = cVar.f5670f = true;
                b unused2 = cVar.f5671g = null;
                cVar.a(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                b unused3 = cVar.f5671g = new b(cVar);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* access modifiers changed from: private */
    public boolean e() {
        int i2 = this.f5657l;
        return i2 >= 2000 && i2 >= this.f5656k.size();
    }

    private void f() {
        if (this.f5655j == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* access modifiers changed from: private */
    public void g() throws IOException {
        while (this.f5654i > this.f5652g) {
            c((String) this.f5656k.entrySet().iterator().next().getKey());
        }
    }

    public synchronized d a(String str) throws IOException {
        f();
        c cVar = this.f5656k.get(str);
        if (cVar == null) {
            return null;
        }
        if (!cVar.f5670f) {
            return null;
        }
        for (File exists : cVar.f5665a) {
            if (!exists.exists()) {
                return null;
            }
        }
        this.f5657l++;
        this.f5655j.append("READ");
        this.f5655j.append(' ');
        this.f5655j.append(str);
        this.f5655j.append(10);
        if (e()) {
            this.f5646a.submit(this.f5659n);
        }
        return new d(str, cVar.f5672h, cVar.f5665a, cVar.f5669e);
    }

    public void a() throws IOException {
        close();
        c.a(this.f5647b);
    }

    public b b(String str) throws IOException {
        return a(str, -1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008c, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean c(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            monitor-enter(r7)
            r7.f()     // Catch:{ all -> 0x008f }
            java.util.LinkedHashMap<java.lang.String, bi.a$c> r0 = r7.f5656k     // Catch:{ all -> 0x008f }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x008f }
            bi.a$c r0 = (bi.a.c) r0     // Catch:{ all -> 0x008f }
            r1 = 0
            if (r0 == 0) goto L_0x008d
            bi.a$b r2 = r0.f5671g     // Catch:{ all -> 0x008f }
            if (r2 == 0) goto L_0x0017
            goto L_0x008d
        L_0x0017:
            int r2 = r7.f5653h     // Catch:{ all -> 0x008f }
            if (r1 >= r2) goto L_0x0059
            java.io.File r2 = r0.a((int) r1)     // Catch:{ all -> 0x008f }
            boolean r3 = r2.exists()     // Catch:{ all -> 0x008f }
            if (r3 == 0) goto L_0x0043
            boolean r3 = r2.delete()     // Catch:{ all -> 0x008f }
            if (r3 == 0) goto L_0x002c
            goto L_0x0043
        L_0x002c:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x008f }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
            r0.<init>()     // Catch:{ all -> 0x008f }
            java.lang.String r1 = "failed to delete "
            r0.append(r1)     // Catch:{ all -> 0x008f }
            r0.append(r2)     // Catch:{ all -> 0x008f }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x008f }
            r8.<init>(r0)     // Catch:{ all -> 0x008f }
            throw r8     // Catch:{ all -> 0x008f }
        L_0x0043:
            long r2 = r7.f5654i     // Catch:{ all -> 0x008f }
            long[] r4 = r0.f5669e     // Catch:{ all -> 0x008f }
            r5 = r4[r1]     // Catch:{ all -> 0x008f }
            long r2 = r2 - r5
            r7.f5654i = r2     // Catch:{ all -> 0x008f }
            long[] r2 = r0.f5669e     // Catch:{ all -> 0x008f }
            r3 = 0
            r2[r1] = r3     // Catch:{ all -> 0x008f }
            int r1 = r1 + 1
            goto L_0x0017
        L_0x0059:
            int r0 = r7.f5657l     // Catch:{ all -> 0x008f }
            r1 = 1
            int r0 = r0 + r1
            r7.f5657l = r0     // Catch:{ all -> 0x008f }
            java.io.Writer r0 = r7.f5655j     // Catch:{ all -> 0x008f }
            java.lang.String r2 = "REMOVE"
            r0.append(r2)     // Catch:{ all -> 0x008f }
            java.io.Writer r0 = r7.f5655j     // Catch:{ all -> 0x008f }
            r2 = 32
            r0.append(r2)     // Catch:{ all -> 0x008f }
            java.io.Writer r0 = r7.f5655j     // Catch:{ all -> 0x008f }
            r0.append(r8)     // Catch:{ all -> 0x008f }
            java.io.Writer r0 = r7.f5655j     // Catch:{ all -> 0x008f }
            r2 = 10
            r0.append(r2)     // Catch:{ all -> 0x008f }
            java.util.LinkedHashMap<java.lang.String, bi.a$c> r0 = r7.f5656k     // Catch:{ all -> 0x008f }
            r0.remove(r8)     // Catch:{ all -> 0x008f }
            boolean r8 = r7.e()     // Catch:{ all -> 0x008f }
            if (r8 == 0) goto L_0x008b
            java.util.concurrent.ThreadPoolExecutor r8 = r7.f5646a     // Catch:{ all -> 0x008f }
            java.util.concurrent.Callable<java.lang.Void> r0 = r7.f5659n     // Catch:{ all -> 0x008f }
            r8.submit(r0)     // Catch:{ all -> 0x008f }
        L_0x008b:
            monitor-exit(r7)
            return r1
        L_0x008d:
            monitor-exit(r7)
            return r1
        L_0x008f:
            r8 = move-exception
            monitor-exit(r7)
            goto L_0x0093
        L_0x0092:
            throw r8
        L_0x0093:
            goto L_0x0092
        */
        throw new UnsupportedOperationException("Method not decompiled: bi.a.c(java.lang.String):boolean");
    }

    public synchronized void close() throws IOException {
        if (this.f5655j != null) {
            Iterator it2 = new ArrayList(this.f5656k.values()).iterator();
            while (it2.hasNext()) {
                c cVar = (c) it2.next();
                if (cVar.f5671g != null) {
                    cVar.f5671g.b();
                }
            }
            g();
            a(this.f5655j);
            this.f5655j = null;
        }
    }
}
