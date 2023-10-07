package com.amap.api.mapcore.util;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

public final class gt implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    static final Pattern f8933a = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f8934b = Charset.forName("US-ASCII");

    /* renamed from: c  reason: collision with root package name */
    static final Charset f8935c = Charset.forName("UTF-8");

    /* renamed from: d  reason: collision with root package name */
    static ThreadPoolExecutor f8936d;

    /* renamed from: r  reason: collision with root package name */
    private static final ThreadFactory f8937r;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public static final OutputStream f8938t = new OutputStream() {
        public final void write(int i2) throws IOException {
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final File f8939e;

    /* renamed from: f  reason: collision with root package name */
    private final File f8940f;

    /* renamed from: g  reason: collision with root package name */
    private final File f8941g;

    /* renamed from: h  reason: collision with root package name */
    private final File f8942h;

    /* renamed from: i  reason: collision with root package name */
    private final int f8943i;

    /* renamed from: j  reason: collision with root package name */
    private long f8944j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final int f8945k;

    /* renamed from: l  reason: collision with root package name */
    private long f8946l = 0;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public Writer f8947m;

    /* renamed from: n  reason: collision with root package name */
    private int f8948n = 1000;

    /* renamed from: o  reason: collision with root package name */
    private final LinkedHashMap<String, c> f8949o = new LinkedHashMap<>(0, 0.75f, true);
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public int f8950p;

    /* renamed from: q  reason: collision with root package name */
    private long f8951q = 0;

    /* renamed from: s  reason: collision with root package name */
    private final Callable<Void> f8952s = new Callable<Void>() {
        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
            return null;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void call() throws java.lang.Exception {
            /*
                r3 = this;
                com.amap.api.mapcore.util.gt r0 = com.amap.api.mapcore.util.gt.this
                monitor-enter(r0)
                com.amap.api.mapcore.util.gt r1 = com.amap.api.mapcore.util.gt.this     // Catch:{ all -> 0x0027 }
                java.io.Writer r1 = r1.f8947m     // Catch:{ all -> 0x0027 }
                r2 = 0
                if (r1 != 0) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x0027 }
                return r2
            L_0x000e:
                com.amap.api.mapcore.util.gt r1 = com.amap.api.mapcore.util.gt.this     // Catch:{ all -> 0x0027 }
                r1.l()     // Catch:{ all -> 0x0027 }
                com.amap.api.mapcore.util.gt r1 = com.amap.api.mapcore.util.gt.this     // Catch:{ all -> 0x0027 }
                boolean r1 = r1.j()     // Catch:{ all -> 0x0027 }
                if (r1 == 0) goto L_0x0025
                com.amap.api.mapcore.util.gt r1 = com.amap.api.mapcore.util.gt.this     // Catch:{ all -> 0x0027 }
                r1.i()     // Catch:{ all -> 0x0027 }
                com.amap.api.mapcore.util.gt r1 = com.amap.api.mapcore.util.gt.this     // Catch:{ all -> 0x0027 }
                int unused = r1.f8950p = 0     // Catch:{ all -> 0x0027 }
            L_0x0025:
                monitor-exit(r0)     // Catch:{ all -> 0x0027 }
                return r2
            L_0x0027:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0027 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.gt.AnonymousClass2.call():java.lang.Void");
        }
    };

    public final class a {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final c f8956b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final boolean[] f8957c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public boolean f8958d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f8959e;

        /* renamed from: com.amap.api.mapcore.util.gt$a$a  reason: collision with other inner class name */
        private class C0075a extends FilterOutputStream {
            private C0075a(OutputStream outputStream) {
                super(outputStream);
            }

            /* synthetic */ C0075a(a aVar, OutputStream outputStream, byte b2) {
                this(outputStream);
            }

            public final void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    boolean unused2 = a.this.f8958d = true;
                }
            }

            public final void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    boolean unused2 = a.this.f8958d = true;
                }
            }

            public final void write(int i2) {
                try {
                    this.out.write(i2);
                } catch (IOException unused) {
                    boolean unused2 = a.this.f8958d = true;
                }
            }

            public final void write(byte[] bArr, int i2, int i3) {
                try {
                    this.out.write(bArr, i2, i3);
                } catch (IOException unused) {
                    boolean unused2 = a.this.f8958d = true;
                }
            }
        }

        private a(c cVar) {
            this.f8956b = cVar;
            this.f8957c = cVar.f8969d ? null : new boolean[gt.this.f8945k];
        }

        /* synthetic */ a(gt gtVar, c cVar, byte b2) {
            this(cVar);
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002d */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.io.OutputStream a() throws java.io.IOException {
            /*
                r4 = this;
                com.amap.api.mapcore.util.gt r0 = com.amap.api.mapcore.util.gt.this
                int r0 = r0.f8945k
                if (r0 <= 0) goto L_0x0051
                com.amap.api.mapcore.util.gt r0 = com.amap.api.mapcore.util.gt.this
                monitor-enter(r0)
                com.amap.api.mapcore.util.gt$c r1 = r4.f8956b     // Catch:{ all -> 0x004e }
                com.amap.api.mapcore.util.gt$a r1 = r1.f8970e     // Catch:{ all -> 0x004e }
                if (r1 != r4) goto L_0x0048
                com.amap.api.mapcore.util.gt$c r1 = r4.f8956b     // Catch:{ all -> 0x004e }
                boolean r1 = r1.f8969d     // Catch:{ all -> 0x004e }
                r2 = 0
                if (r1 != 0) goto L_0x0021
                boolean[] r1 = r4.f8957c     // Catch:{ all -> 0x004e }
                r3 = 1
                r1[r2] = r3     // Catch:{ all -> 0x004e }
            L_0x0021:
                com.amap.api.mapcore.util.gt$c r1 = r4.f8956b     // Catch:{ all -> 0x004e }
                java.io.File r1 = r1.b((int) r2)     // Catch:{ all -> 0x004e }
                java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x002d }
                r3.<init>(r1)     // Catch:{ FileNotFoundException -> 0x002d }
                goto L_0x003b
            L_0x002d:
                com.amap.api.mapcore.util.gt r3 = com.amap.api.mapcore.util.gt.this     // Catch:{ all -> 0x004e }
                java.io.File r3 = r3.f8939e     // Catch:{ all -> 0x004e }
                r3.mkdirs()     // Catch:{ all -> 0x004e }
                java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0042 }
                r3.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0042 }
            L_0x003b:
                com.amap.api.mapcore.util.gt$a$a r1 = new com.amap.api.mapcore.util.gt$a$a     // Catch:{ all -> 0x004e }
                r1.<init>(r4, r3, r2)     // Catch:{ all -> 0x004e }
                monitor-exit(r0)     // Catch:{ all -> 0x004e }
                return r1
            L_0x0042:
                java.io.OutputStream r1 = com.amap.api.mapcore.util.gt.f8938t     // Catch:{ all -> 0x004e }
                monitor-exit(r0)     // Catch:{ all -> 0x004e }
                return r1
            L_0x0048:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x004e }
                r1.<init>()     // Catch:{ all -> 0x004e }
                throw r1     // Catch:{ all -> 0x004e }
            L_0x004e:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x004e }
                throw r1
            L_0x0051:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "Expected index 0 to be greater than 0 and less than the maximum value count of "
                r1.<init>(r2)
                com.amap.api.mapcore.util.gt r2 = com.amap.api.mapcore.util.gt.this
                int r2 = r2.f8945k
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.gt.a.a():java.io.OutputStream");
        }

        public final void b() throws IOException {
            if (this.f8958d) {
                gt.this.a(this, false);
                gt.this.c(this.f8956b.f8967b);
            } else {
                gt.this.a(this, true);
            }
            this.f8959e = true;
        }

        public final void c() throws IOException {
            gt.this.a(this, false);
        }
    }

    public final class b implements Closeable {

        /* renamed from: b  reason: collision with root package name */
        private final String f8962b;

        /* renamed from: c  reason: collision with root package name */
        private final long f8963c;

        /* renamed from: d  reason: collision with root package name */
        private final InputStream[] f8964d;

        /* renamed from: e  reason: collision with root package name */
        private final long[] f8965e;

        private b(String str, long j2, InputStream[] inputStreamArr, long[] jArr) {
            this.f8962b = str;
            this.f8963c = j2;
            this.f8964d = inputStreamArr;
            this.f8965e = jArr;
        }

        /* synthetic */ b(gt gtVar, String str, long j2, InputStream[] inputStreamArr, long[] jArr, byte b2) {
            this(str, j2, inputStreamArr, jArr);
        }

        public final InputStream a() {
            return this.f8964d[0];
        }

        public final void close() {
            for (InputStream a2 : this.f8964d) {
                gt.a((Closeable) a2);
            }
        }
    }

    private final class c {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final String f8967b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final long[] f8968c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public boolean f8969d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public a f8970e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public long f8971f;

        private c(String str) {
            this.f8967b = str;
            this.f8968c = new long[gt.this.f8945k];
        }

        /* synthetic */ c(gt gtVar, String str, byte b2) {
            this(str);
        }

        private static IOException a(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        static /* synthetic */ void a(c cVar, String[] strArr) throws IOException {
            if (strArr.length == gt.this.f8945k) {
                int i2 = 0;
                while (i2 < strArr.length) {
                    try {
                        cVar.f8968c[i2] = Long.parseLong(strArr[i2]);
                        i2++;
                    } catch (NumberFormatException unused) {
                        throw a(strArr);
                    }
                }
                return;
            }
            throw a(strArr);
        }

        public final File a(int i2) {
            File g2 = gt.this.f8939e;
            return new File(g2, this.f8967b + "." + i2);
        }

        public final String a() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long append : this.f8968c) {
                sb.append(' ');
                sb.append(append);
            }
            return sb.toString();
        }

        public final File b(int i2) {
            File g2 = gt.this.f8939e;
            return new File(g2, this.f8967b + "." + i2 + ".tmp");
        }
    }

    static {
        AnonymousClass1 r8 = new ThreadFactory() {

            /* renamed from: a  reason: collision with root package name */
            private final AtomicInteger f8953a = new AtomicInteger(1);

            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "disklrucache#" + this.f8953a.getAndIncrement());
            }
        };
        f8937r = r8;
        f8936d = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), r8);
    }

    private gt(File file, long j2) {
        this.f8939e = file;
        this.f8943i = 1;
        this.f8940f = new File(file, "journal");
        this.f8941g = new File(file, "journal.tmp");
        this.f8942h = new File(file, "journal.bkp");
        this.f8945k = 1;
        this.f8944j = j2;
    }

    public static gt a(File file, long j2) throws IOException {
        if (j2 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            gt gtVar = new gt(file, j2);
            if (gtVar.f8940f.exists()) {
                try {
                    gtVar.g();
                    gtVar.h();
                    gtVar.f8947m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(gtVar.f8940f, true), f8934b));
                    return gtVar;
                } catch (Throwable unused) {
                    gtVar.d();
                }
            }
            file.mkdirs();
            gt gtVar2 = new gt(file, j2);
            gtVar2.i();
            return gtVar2;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public static void a() {
        ThreadPoolExecutor threadPoolExecutor = f8936d;
        if (threadPoolExecutor != null && !threadPoolExecutor.isShutdown()) {
            f8936d.shutdown();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00fe, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(com.amap.api.mapcore.util.gt.a r10, boolean r11) throws java.io.IOException {
        /*
            r9 = this;
            monitor-enter(r9)
            com.amap.api.mapcore.util.gt$c r0 = r10.f8956b     // Catch:{ all -> 0x0105 }
            com.amap.api.mapcore.util.gt$a r1 = r0.f8970e     // Catch:{ all -> 0x0105 }
            if (r1 != r10) goto L_0x00ff
            r1 = 0
            if (r11 == 0) goto L_0x0046
            boolean r2 = r0.f8969d     // Catch:{ all -> 0x0105 }
            if (r2 != 0) goto L_0x0046
            r2 = 0
        L_0x0015:
            int r3 = r9.f8945k     // Catch:{ all -> 0x0105 }
            if (r2 >= r3) goto L_0x0046
            boolean[] r3 = r10.f8957c     // Catch:{ all -> 0x0105 }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x0105 }
            if (r3 == 0) goto L_0x0033
            java.io.File r3 = r0.b((int) r2)     // Catch:{ all -> 0x0105 }
            boolean r3 = r3.exists()     // Catch:{ all -> 0x0105 }
            if (r3 != 0) goto L_0x0030
            r10.c()     // Catch:{ all -> 0x0105 }
            monitor-exit(r9)
            return
        L_0x0030:
            int r2 = r2 + 1
            goto L_0x0015
        L_0x0033:
            r10.c()     // Catch:{ all -> 0x0105 }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0105 }
            java.lang.String r11 = "Newly created entry didn't create value for index "
            java.lang.String r0 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0105 }
            java.lang.String r11 = r11.concat(r0)     // Catch:{ all -> 0x0105 }
            r10.<init>(r11)     // Catch:{ all -> 0x0105 }
            throw r10     // Catch:{ all -> 0x0105 }
        L_0x0046:
            int r10 = r9.f8945k     // Catch:{ all -> 0x0105 }
            if (r1 >= r10) goto L_0x007a
            java.io.File r10 = r0.b((int) r1)     // Catch:{ all -> 0x0105 }
            if (r11 == 0) goto L_0x0074
            boolean r2 = r10.exists()     // Catch:{ all -> 0x0105 }
            if (r2 == 0) goto L_0x0077
            java.io.File r2 = r0.a((int) r1)     // Catch:{ all -> 0x0105 }
            r10.renameTo(r2)     // Catch:{ all -> 0x0105 }
            long[] r10 = r0.f8968c     // Catch:{ all -> 0x0105 }
            r3 = r10[r1]     // Catch:{ all -> 0x0105 }
            long r5 = r2.length()     // Catch:{ all -> 0x0105 }
            long[] r10 = r0.f8968c     // Catch:{ all -> 0x0105 }
            r10[r1] = r5     // Catch:{ all -> 0x0105 }
            long r7 = r9.f8946l     // Catch:{ all -> 0x0105 }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.f8946l = r7     // Catch:{ all -> 0x0105 }
            goto L_0x0077
        L_0x0074:
            a((java.io.File) r10)     // Catch:{ all -> 0x0105 }
        L_0x0077:
            int r1 = r1 + 1
            goto L_0x0046
        L_0x007a:
            int r10 = r9.f8950p     // Catch:{ all -> 0x0105 }
            int r10 = r10 + 1
            r9.f8950p = r10     // Catch:{ all -> 0x0105 }
            r10 = 0
            com.amap.api.mapcore.util.gt.a unused = r0.f8970e = r10     // Catch:{ all -> 0x0105 }
            boolean r10 = r0.f8969d     // Catch:{ all -> 0x0105 }
            r10 = r10 | r11
            r1 = 10
            if (r10 == 0) goto L_0x00be
            boolean unused = r0.f8969d = true     // Catch:{ all -> 0x0105 }
            java.io.Writer r10 = r9.f8947m     // Catch:{ all -> 0x0105 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0105 }
            java.lang.String r3 = "CLEAN "
            r2.<init>(r3)     // Catch:{ all -> 0x0105 }
            java.lang.String r3 = r0.f8967b     // Catch:{ all -> 0x0105 }
            r2.append(r3)     // Catch:{ all -> 0x0105 }
            java.lang.String r3 = r0.a()     // Catch:{ all -> 0x0105 }
            r2.append(r3)     // Catch:{ all -> 0x0105 }
            r2.append(r1)     // Catch:{ all -> 0x0105 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0105 }
            r10.write(r1)     // Catch:{ all -> 0x0105 }
            if (r11 == 0) goto L_0x00e1
            long r10 = r9.f8951q     // Catch:{ all -> 0x0105 }
            r1 = 1
            long r1 = r1 + r10
            r9.f8951q = r1     // Catch:{ all -> 0x0105 }
            long unused = r0.f8971f = r10     // Catch:{ all -> 0x0105 }
            goto L_0x00e1
        L_0x00be:
            java.util.LinkedHashMap<java.lang.String, com.amap.api.mapcore.util.gt$c> r10 = r9.f8949o     // Catch:{ all -> 0x0105 }
            java.lang.String r11 = r0.f8967b     // Catch:{ all -> 0x0105 }
            r10.remove(r11)     // Catch:{ all -> 0x0105 }
            java.io.Writer r10 = r9.f8947m     // Catch:{ all -> 0x0105 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0105 }
            java.lang.String r2 = "REMOVE "
            r11.<init>(r2)     // Catch:{ all -> 0x0105 }
            java.lang.String r0 = r0.f8967b     // Catch:{ all -> 0x0105 }
            r11.append(r0)     // Catch:{ all -> 0x0105 }
            r11.append(r1)     // Catch:{ all -> 0x0105 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0105 }
            r10.write(r11)     // Catch:{ all -> 0x0105 }
        L_0x00e1:
            java.io.Writer r10 = r9.f8947m     // Catch:{ all -> 0x0105 }
            r10.flush()     // Catch:{ all -> 0x0105 }
            long r10 = r9.f8946l     // Catch:{ all -> 0x0105 }
            long r0 = r9.f8944j     // Catch:{ all -> 0x0105 }
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x00f4
            boolean r10 = r9.j()     // Catch:{ all -> 0x0105 }
            if (r10 == 0) goto L_0x00fd
        L_0x00f4:
            java.util.concurrent.ThreadPoolExecutor r10 = f()     // Catch:{ all -> 0x0105 }
            java.util.concurrent.Callable<java.lang.Void> r11 = r9.f8952s     // Catch:{ all -> 0x0105 }
            r10.submit(r11)     // Catch:{ all -> 0x0105 }
        L_0x00fd:
            monitor-exit(r9)
            return
        L_0x00ff:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0105 }
            r10.<init>()     // Catch:{ all -> 0x0105 }
            throw r10     // Catch:{ all -> 0x0105 }
        L_0x0105:
            r10 = move-exception
            monitor-exit(r9)
            goto L_0x0109
        L_0x0108:
            throw r10
        L_0x0109:
            goto L_0x0108
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.gt.a(com.amap.api.mapcore.util.gt$a, boolean):void");
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
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

    private static void b(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            int i2 = 0;
            while (i2 < length) {
                File file2 = listFiles[i2];
                if (file2.isDirectory()) {
                    b(file2);
                }
                if (file2.delete()) {
                    i2++;
                } else {
                    throw new IOException("failed to delete file: ".concat(String.valueOf(file2)));
                }
            }
            return;
        }
        throw new IOException("not a readable directory: ".concat(String.valueOf(file)));
    }

    private synchronized a d(String str) throws IOException {
        k();
        e(str);
        c cVar = this.f8949o.get(str);
        if (cVar == null) {
            cVar = new c(this, str, (byte) 0);
            this.f8949o.put(str, cVar);
        } else if (cVar.f8970e != null) {
            return null;
        }
        a aVar = new a(this, cVar, (byte) 0);
        a unused = cVar.f8970e = aVar;
        Writer writer = this.f8947m;
        writer.write("DIRTY " + str + 10);
        this.f8947m.flush();
        return aVar;
    }

    private static void e(String str) {
        if (!f8933a.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    private static ThreadPoolExecutor f() {
        try {
            ThreadPoolExecutor threadPoolExecutor = f8936d;
            if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
                f8936d = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(256), f8937r);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return f8936d;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:51|52|53|54) */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r11.f8950p = r2 - r11.f8949o.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x010c, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x0100 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:51:0x0100=Splitter:B:51:0x0100, B:55:0x010d=Splitter:B:55:0x010d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g() throws java.io.IOException {
        /*
            r11 = this;
            java.lang.String r0 = ", "
            com.amap.api.mapcore.util.gu r1 = new com.amap.api.mapcore.util.gu
            java.io.FileInputStream r2 = new java.io.FileInputStream
            java.io.File r3 = r11.f8940f
            r2.<init>(r3)
            java.nio.charset.Charset r3 = f8934b
            r1.<init>(r2, r3)
            java.lang.String r2 = r1.a()     // Catch:{ all -> 0x0138 }
            java.lang.String r3 = r1.a()     // Catch:{ all -> 0x0138 }
            java.lang.String r4 = r1.a()     // Catch:{ all -> 0x0138 }
            java.lang.String r5 = r1.a()     // Catch:{ all -> 0x0138 }
            java.lang.String r6 = r1.a()     // Catch:{ all -> 0x0138 }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x0138 }
            if (r7 == 0) goto L_0x010d
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x0138 }
            if (r7 == 0) goto L_0x010d
            int r7 = r11.f8943i     // Catch:{ all -> 0x0138 }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x0138 }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x0138 }
            if (r4 == 0) goto L_0x010d
            int r4 = r11.f8945k     // Catch:{ all -> 0x0138 }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x0138 }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x0138 }
            if (r4 == 0) goto L_0x010d
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x0138 }
            if (r4 == 0) goto L_0x010d
            r0 = 0
            r2 = 0
        L_0x0056:
            java.lang.String r3 = r1.a()     // Catch:{ EOFException -> 0x0100 }
            r4 = 32
            int r5 = r3.indexOf(r4)     // Catch:{ EOFException -> 0x0100 }
            java.lang.String r6 = "unexpected journal line: "
            r7 = -1
            if (r5 == r7) goto L_0x00f2
            int r8 = r5 + 1
            int r4 = r3.indexOf(r4, r8)     // Catch:{ EOFException -> 0x0100 }
            if (r4 != r7) goto L_0x0082
            java.lang.String r8 = r3.substring(r8)     // Catch:{ EOFException -> 0x0100 }
            r9 = 6
            if (r5 != r9) goto L_0x0086
            java.lang.String r9 = "REMOVE"
            boolean r9 = r3.startsWith(r9)     // Catch:{ EOFException -> 0x0100 }
            if (r9 == 0) goto L_0x0086
            java.util.LinkedHashMap<java.lang.String, com.amap.api.mapcore.util.gt$c> r3 = r11.f8949o     // Catch:{ EOFException -> 0x0100 }
            r3.remove(r8)     // Catch:{ EOFException -> 0x0100 }
            goto L_0x00e0
        L_0x0082:
            java.lang.String r8 = r3.substring(r8, r4)     // Catch:{ EOFException -> 0x0100 }
        L_0x0086:
            java.util.LinkedHashMap<java.lang.String, com.amap.api.mapcore.util.gt$c> r9 = r11.f8949o     // Catch:{ EOFException -> 0x0100 }
            java.lang.Object r9 = r9.get(r8)     // Catch:{ EOFException -> 0x0100 }
            com.amap.api.mapcore.util.gt$c r9 = (com.amap.api.mapcore.util.gt.c) r9     // Catch:{ EOFException -> 0x0100 }
            if (r9 != 0) goto L_0x009a
            com.amap.api.mapcore.util.gt$c r9 = new com.amap.api.mapcore.util.gt$c     // Catch:{ EOFException -> 0x0100 }
            r9.<init>(r11, r8, r0)     // Catch:{ EOFException -> 0x0100 }
            java.util.LinkedHashMap<java.lang.String, com.amap.api.mapcore.util.gt$c> r10 = r11.f8949o     // Catch:{ EOFException -> 0x0100 }
            r10.put(r8, r9)     // Catch:{ EOFException -> 0x0100 }
        L_0x009a:
            r8 = 5
            if (r4 == r7) goto L_0x00be
            if (r5 != r8) goto L_0x00be
            java.lang.String r10 = "CLEAN"
            boolean r10 = r3.startsWith(r10)     // Catch:{ EOFException -> 0x0100 }
            if (r10 == 0) goto L_0x00be
            int r4 = r4 + 1
            java.lang.String r3 = r3.substring(r4)     // Catch:{ EOFException -> 0x0100 }
            java.lang.String r4 = " "
            java.lang.String[] r3 = r3.split(r4)     // Catch:{ EOFException -> 0x0100 }
            boolean unused = r9.f8969d = true     // Catch:{ EOFException -> 0x0100 }
            r4 = 0
            com.amap.api.mapcore.util.gt.a unused = r9.f8970e = r4     // Catch:{ EOFException -> 0x0100 }
            com.amap.api.mapcore.util.gt.c.a((com.amap.api.mapcore.util.gt.c) r9, (java.lang.String[]) r3)     // Catch:{ EOFException -> 0x0100 }
            goto L_0x00e0
        L_0x00be:
            if (r4 != r7) goto L_0x00d3
            if (r5 != r8) goto L_0x00d3
            java.lang.String r8 = "DIRTY"
            boolean r8 = r3.startsWith(r8)     // Catch:{ EOFException -> 0x0100 }
            if (r8 == 0) goto L_0x00d3
            com.amap.api.mapcore.util.gt$a r3 = new com.amap.api.mapcore.util.gt$a     // Catch:{ EOFException -> 0x0100 }
            r3.<init>(r11, r9, r0)     // Catch:{ EOFException -> 0x0100 }
            com.amap.api.mapcore.util.gt.a unused = r9.f8970e = r3     // Catch:{ EOFException -> 0x0100 }
            goto L_0x00e0
        L_0x00d3:
            if (r4 != r7) goto L_0x00e4
            r4 = 4
            if (r5 != r4) goto L_0x00e4
            java.lang.String r4 = "READ"
            boolean r4 = r3.startsWith(r4)     // Catch:{ EOFException -> 0x0100 }
            if (r4 == 0) goto L_0x00e4
        L_0x00e0:
            int r2 = r2 + 1
            goto L_0x0056
        L_0x00e4:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ EOFException -> 0x0100 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ EOFException -> 0x0100 }
            java.lang.String r3 = r6.concat(r3)     // Catch:{ EOFException -> 0x0100 }
            r0.<init>(r3)     // Catch:{ EOFException -> 0x0100 }
            throw r0     // Catch:{ EOFException -> 0x0100 }
        L_0x00f2:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ EOFException -> 0x0100 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ EOFException -> 0x0100 }
            java.lang.String r3 = r6.concat(r3)     // Catch:{ EOFException -> 0x0100 }
            r0.<init>(r3)     // Catch:{ EOFException -> 0x0100 }
            throw r0     // Catch:{ EOFException -> 0x0100 }
        L_0x0100:
            java.util.LinkedHashMap<java.lang.String, com.amap.api.mapcore.util.gt$c> r0 = r11.f8949o     // Catch:{ all -> 0x0138 }
            int r0 = r0.size()     // Catch:{ all -> 0x0138 }
            int r2 = r2 - r0
            r11.f8950p = r2     // Catch:{ all -> 0x0138 }
            a((java.io.Closeable) r1)
            return
        L_0x010d:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x0138 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0138 }
            java.lang.String r8 = "unexpected journal header: ["
            r7.<init>(r8)     // Catch:{ all -> 0x0138 }
            r7.append(r2)     // Catch:{ all -> 0x0138 }
            r7.append(r0)     // Catch:{ all -> 0x0138 }
            r7.append(r3)     // Catch:{ all -> 0x0138 }
            r7.append(r0)     // Catch:{ all -> 0x0138 }
            r7.append(r5)     // Catch:{ all -> 0x0138 }
            r7.append(r0)     // Catch:{ all -> 0x0138 }
            r7.append(r6)     // Catch:{ all -> 0x0138 }
            java.lang.String r0 = "]"
            r7.append(r0)     // Catch:{ all -> 0x0138 }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x0138 }
            r4.<init>(r0)     // Catch:{ all -> 0x0138 }
            throw r4     // Catch:{ all -> 0x0138 }
        L_0x0138:
            r0 = move-exception
            a((java.io.Closeable) r1)
            goto L_0x013e
        L_0x013d:
            throw r0
        L_0x013e:
            goto L_0x013d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.gt.g():void");
    }

    private void h() throws IOException {
        a(this.f8941g);
        Iterator<c> it2 = this.f8949o.values().iterator();
        while (it2.hasNext()) {
            c next = it2.next();
            int i2 = 0;
            if (next.f8970e == null) {
                while (i2 < this.f8945k) {
                    this.f8946l += next.f8968c[i2];
                    i2++;
                }
            } else {
                a unused = next.f8970e = null;
                while (i2 < this.f8945k) {
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
    public synchronized void i() throws IOException {
        String str;
        Writer writer = this.f8947m;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f8941g), f8934b));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f8943i));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f8945k));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (c next : this.f8949o.values()) {
                if (next.f8970e != null) {
                    str = "DIRTY " + next.f8967b + 10;
                } else {
                    str = "CLEAN " + next.f8967b + next.a() + 10;
                }
                bufferedWriter.write(str);
            }
            bufferedWriter.close();
            if (this.f8940f.exists()) {
                a(this.f8940f, this.f8942h, true);
            }
            a(this.f8941g, this.f8940f, false);
            this.f8942h.delete();
            this.f8947m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f8940f, true), f8934b));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public boolean j() {
        int i2 = this.f8950p;
        return i2 >= 2000 && i2 >= this.f8949o.size();
    }

    private void k() {
        if (this.f8947m == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* access modifiers changed from: private */
    public void l() throws IOException {
        while (true) {
            if (this.f8946l > this.f8944j || this.f8949o.size() > this.f8948n) {
                c((String) this.f8949o.entrySet().iterator().next().getKey());
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:32|33|28|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r11.f8950p++;
        r11.f8947m.append("READ " + r12 + 10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        if (j() == false) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0058, code lost:
        f().submit(r11.f8952s);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0073, code lost:
        return new com.amap.api.mapcore.util.gt.b(r11, r12, com.amap.api.mapcore.util.gt.c.f(r0), r8, com.amap.api.mapcore.util.gt.c.c(r0), (byte) 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0085, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0074 */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.amap.api.mapcore.util.gt.b a(java.lang.String r12) throws java.io.IOException {
        /*
            r11 = this;
            monitor-enter(r11)
            r11.k()     // Catch:{ all -> 0x0086 }
            e((java.lang.String) r12)     // Catch:{ all -> 0x0086 }
            java.util.LinkedHashMap<java.lang.String, com.amap.api.mapcore.util.gt$c> r0 = r11.f8949o     // Catch:{ all -> 0x0086 }
            java.lang.Object r0 = r0.get(r12)     // Catch:{ all -> 0x0086 }
            com.amap.api.mapcore.util.gt$c r0 = (com.amap.api.mapcore.util.gt.c) r0     // Catch:{ all -> 0x0086 }
            r1 = 0
            if (r0 != 0) goto L_0x0014
            monitor-exit(r11)
            return r1
        L_0x0014:
            boolean r2 = r0.f8969d     // Catch:{ all -> 0x0086 }
            if (r2 != 0) goto L_0x001c
            monitor-exit(r11)
            return r1
        L_0x001c:
            int r2 = r11.f8945k     // Catch:{ all -> 0x0086 }
            java.io.InputStream[] r8 = new java.io.InputStream[r2]     // Catch:{ all -> 0x0086 }
            r2 = 0
            r3 = 0
        L_0x0022:
            int r4 = r11.f8945k     // Catch:{ FileNotFoundException -> 0x0074 }
            if (r3 >= r4) goto L_0x0034
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0074 }
            java.io.File r5 = r0.a((int) r3)     // Catch:{ FileNotFoundException -> 0x0074 }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0074 }
            r8[r3] = r4     // Catch:{ FileNotFoundException -> 0x0074 }
            int r3 = r3 + 1
            goto L_0x0022
        L_0x0034:
            int r1 = r11.f8950p     // Catch:{ all -> 0x0086 }
            int r1 = r1 + 1
            r11.f8950p = r1     // Catch:{ all -> 0x0086 }
            java.io.Writer r1 = r11.f8947m     // Catch:{ all -> 0x0086 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0086 }
            java.lang.String r3 = "READ "
            r2.<init>(r3)     // Catch:{ all -> 0x0086 }
            r2.append(r12)     // Catch:{ all -> 0x0086 }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x0086 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0086 }
            r1.append(r2)     // Catch:{ all -> 0x0086 }
            boolean r1 = r11.j()     // Catch:{ all -> 0x0086 }
            if (r1 == 0) goto L_0x0061
            java.util.concurrent.ThreadPoolExecutor r1 = f()     // Catch:{ all -> 0x0086 }
            java.util.concurrent.Callable<java.lang.Void> r2 = r11.f8952s     // Catch:{ all -> 0x0086 }
            r1.submit(r2)     // Catch:{ all -> 0x0086 }
        L_0x0061:
            com.amap.api.mapcore.util.gt$b r1 = new com.amap.api.mapcore.util.gt$b     // Catch:{ all -> 0x0086 }
            long r6 = r0.f8971f     // Catch:{ all -> 0x0086 }
            long[] r9 = r0.f8968c     // Catch:{ all -> 0x0086 }
            r10 = 0
            r3 = r1
            r4 = r11
            r5 = r12
            r3.<init>(r4, r5, r6, r8, r9, r10)     // Catch:{ all -> 0x0086 }
            monitor-exit(r11)
            return r1
        L_0x0074:
            int r12 = r11.f8945k     // Catch:{ all -> 0x0086 }
            if (r2 >= r12) goto L_0x0084
            r12 = r8[r2]     // Catch:{ all -> 0x0086 }
            if (r12 == 0) goto L_0x0084
            r12 = r8[r2]     // Catch:{ all -> 0x0086 }
            a((java.io.Closeable) r12)     // Catch:{ all -> 0x0086 }
            int r2 = r2 + 1
            goto L_0x0074
        L_0x0084:
            monitor-exit(r11)
            return r1
        L_0x0086:
            r12 = move-exception
            monitor-exit(r11)
            goto L_0x008a
        L_0x0089:
            throw r12
        L_0x008a:
            goto L_0x0089
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.gt.a(java.lang.String):com.amap.api.mapcore.util.gt$b");
    }

    public final void a(int i2) {
        if (i2 < 10) {
            i2 = 10;
        } else if (i2 > 10000) {
            i2 = 10000;
        }
        this.f8948n = i2;
    }

    public final a b(String str) throws IOException {
        return d(str);
    }

    public final File b() {
        return this.f8939e;
    }

    public final synchronized void c() throws IOException {
        k();
        l();
        this.f8947m.flush();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0087, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0089, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean c(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            monitor-enter(r7)
            r7.k()     // Catch:{ all -> 0x008a }
            e((java.lang.String) r8)     // Catch:{ all -> 0x008a }
            java.util.LinkedHashMap<java.lang.String, com.amap.api.mapcore.util.gt$c> r0 = r7.f8949o     // Catch:{ all -> 0x008a }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x008a }
            com.amap.api.mapcore.util.gt$c r0 = (com.amap.api.mapcore.util.gt.c) r0     // Catch:{ all -> 0x008a }
            r1 = 0
            if (r0 == 0) goto L_0x0088
            com.amap.api.mapcore.util.gt$a r2 = r0.f8970e     // Catch:{ all -> 0x008a }
            if (r2 == 0) goto L_0x0019
            goto L_0x0088
        L_0x0019:
            int r2 = r7.f8945k     // Catch:{ all -> 0x008a }
            if (r1 >= r2) goto L_0x0054
            java.io.File r2 = r0.a((int) r1)     // Catch:{ all -> 0x008a }
            boolean r3 = r2.exists()     // Catch:{ all -> 0x008a }
            if (r3 == 0) goto L_0x003e
            boolean r3 = r2.delete()     // Catch:{ all -> 0x008a }
            if (r3 == 0) goto L_0x002e
            goto L_0x003e
        L_0x002e:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x008a }
            java.lang.String r0 = "failed to delete "
            java.lang.String r1 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x008a }
            java.lang.String r0 = r0.concat(r1)     // Catch:{ all -> 0x008a }
            r8.<init>(r0)     // Catch:{ all -> 0x008a }
            throw r8     // Catch:{ all -> 0x008a }
        L_0x003e:
            long r2 = r7.f8946l     // Catch:{ all -> 0x008a }
            long[] r4 = r0.f8968c     // Catch:{ all -> 0x008a }
            r5 = r4[r1]     // Catch:{ all -> 0x008a }
            long r2 = r2 - r5
            r7.f8946l = r2     // Catch:{ all -> 0x008a }
            long[] r2 = r0.f8968c     // Catch:{ all -> 0x008a }
            r3 = 0
            r2[r1] = r3     // Catch:{ all -> 0x008a }
            int r1 = r1 + 1
            goto L_0x0019
        L_0x0054:
            int r0 = r7.f8950p     // Catch:{ all -> 0x008a }
            r1 = 1
            int r0 = r0 + r1
            r7.f8950p = r0     // Catch:{ all -> 0x008a }
            java.io.Writer r0 = r7.f8947m     // Catch:{ all -> 0x008a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x008a }
            java.lang.String r3 = "REMOVE "
            r2.<init>(r3)     // Catch:{ all -> 0x008a }
            r2.append(r8)     // Catch:{ all -> 0x008a }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x008a }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x008a }
            r0.append(r2)     // Catch:{ all -> 0x008a }
            java.util.LinkedHashMap<java.lang.String, com.amap.api.mapcore.util.gt$c> r0 = r7.f8949o     // Catch:{ all -> 0x008a }
            r0.remove(r8)     // Catch:{ all -> 0x008a }
            boolean r8 = r7.j()     // Catch:{ all -> 0x008a }
            if (r8 == 0) goto L_0x0086
            java.util.concurrent.ThreadPoolExecutor r8 = f()     // Catch:{ all -> 0x008a }
            java.util.concurrent.Callable<java.lang.Void> r0 = r7.f8952s     // Catch:{ all -> 0x008a }
            r8.submit(r0)     // Catch:{ all -> 0x008a }
        L_0x0086:
            monitor-exit(r7)
            return r1
        L_0x0088:
            monitor-exit(r7)
            return r1
        L_0x008a:
            r8 = move-exception
            monitor-exit(r7)
            goto L_0x008e
        L_0x008d:
            throw r8
        L_0x008e:
            goto L_0x008d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.gt.c(java.lang.String):boolean");
    }

    public final synchronized void close() throws IOException {
        if (this.f8947m != null) {
            Iterator it2 = new ArrayList(this.f8949o.values()).iterator();
            while (it2.hasNext()) {
                c cVar = (c) it2.next();
                if (cVar.f8970e != null) {
                    cVar.f8970e.c();
                }
            }
            l();
            this.f8947m.close();
            this.f8947m = null;
        }
    }

    public final void d() throws IOException {
        close();
        b(this.f8939e);
    }
}
