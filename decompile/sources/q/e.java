package q;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import j.g;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import m.d;
import q.f;

class e {

    /* renamed from: a  reason: collision with root package name */
    static final j.e<String, Typeface> f34127a = new j.e<>(16);

    /* renamed from: b  reason: collision with root package name */
    static final Object f34128b = new Object();

    /* renamed from: c  reason: collision with root package name */
    static final g<String, ArrayList<s.a<a>>> f34129c = new g<>();

    /* renamed from: d  reason: collision with root package name */
    private static final ExecutorService f34130d = g.a("fonts-androidx", 10, 10000);

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final Typeface f34141a;

        /* renamed from: b  reason: collision with root package name */
        final int f34142b;

        a(int i2) {
            this.f34141a = null;
            this.f34142b = i2;
        }

        a(Typeface typeface) {
            this.f34141a = typeface;
            this.f34142b = 0;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f34142b == 0;
        }
    }

    private static int a(f.a aVar) {
        int i2 = 1;
        if (aVar.a() != 0) {
            return aVar.a() != 1 ? -3 : -2;
        }
        f.b[] b2 = aVar.b();
        if (!(b2 == null || b2.length == 0)) {
            int length = b2.length;
            i2 = 0;
            int i3 = 0;
            while (i3 < length) {
                int e2 = b2[i3].e();
                if (e2 == 0) {
                    i3++;
                } else if (e2 < 0) {
                    return -3;
                } else {
                    return e2;
                }
            }
        }
        return i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        r9 = new q.e.AnonymousClass3();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        if (r8 != null) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        r8 = f34130d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0044, code lost:
        q.g.a(r8, r9, new q.e.AnonymousClass4());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004c, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.graphics.Typeface a(final android.content.Context r5, final q.d r6, final int r7, java.util.concurrent.Executor r8, final q.a r9) {
        /*
            java.lang.String r0 = a(r6, r7)
            j.e<java.lang.String, android.graphics.Typeface> r1 = f34127a
            java.lang.Object r1 = r1.get(r0)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            if (r1 == 0) goto L_0x0017
            q.e$a r5 = new q.e$a
            r5.<init>((android.graphics.Typeface) r1)
            r9.a((q.e.a) r5)
            return r1
        L_0x0017:
            q.e$2 r1 = new q.e$2
            r1.<init>()
            java.lang.Object r9 = f34128b
            monitor-enter(r9)
            j.g<java.lang.String, java.util.ArrayList<s.a<q.e$a>>> r2 = f34129c     // Catch:{ all -> 0x004d }
            java.lang.Object r3 = r2.get(r0)     // Catch:{ all -> 0x004d }
            java.util.ArrayList r3 = (java.util.ArrayList) r3     // Catch:{ all -> 0x004d }
            r4 = 0
            if (r3 == 0) goto L_0x002f
            r3.add(r1)     // Catch:{ all -> 0x004d }
            monitor-exit(r9)     // Catch:{ all -> 0x004d }
            return r4
        L_0x002f:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x004d }
            r3.<init>()     // Catch:{ all -> 0x004d }
            r3.add(r1)     // Catch:{ all -> 0x004d }
            r2.put(r0, r3)     // Catch:{ all -> 0x004d }
            monitor-exit(r9)     // Catch:{ all -> 0x004d }
            q.e$3 r9 = new q.e$3
            r9.<init>(r0, r5, r6, r7)
            if (r8 != 0) goto L_0x0044
            java.util.concurrent.ExecutorService r8 = f34130d
        L_0x0044:
            q.e$4 r5 = new q.e$4
            r5.<init>(r0)
            q.g.a((java.util.concurrent.Executor) r8, r9, r5)
            return r4
        L_0x004d:
            r5 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x004d }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: q.e.a(android.content.Context, q.d, int, java.util.concurrent.Executor, q.a):android.graphics.Typeface");
    }

    static Typeface a(final Context context, final d dVar, a aVar, final int i2, int i3) {
        final String a2 = a(dVar, i2);
        Typeface typeface = f34127a.get(a2);
        if (typeface != null) {
            aVar.a(new a(typeface));
            return typeface;
        } else if (i3 == -1) {
            a a3 = a(a2, context, dVar, i2);
            aVar.a(a3);
            return a3.f34141a;
        } else {
            try {
                a aVar2 = (a) g.a(f34130d, new Callable<a>() {
                    /* renamed from: a */
                    public a call() {
                        return e.a(a2, context, dVar, i2);
                    }
                }, i3);
                aVar.a(aVar2);
                return aVar2.f34141a;
            } catch (InterruptedException unused) {
                aVar.a(new a(-3));
                return null;
            }
        }
    }

    private static String a(d dVar, int i2) {
        return dVar.f() + "-" + i2;
    }

    static a a(String str, Context context, d dVar, int i2) {
        j.e<String, Typeface> eVar = f34127a;
        Typeface typeface = eVar.get(str);
        if (typeface != null) {
            return new a(typeface);
        }
        try {
            f.a a2 = c.a(context, dVar, (CancellationSignal) null);
            int a3 = a(a2);
            if (a3 != 0) {
                return new a(a3);
            }
            Typeface a4 = d.a(context, (CancellationSignal) null, a2.b(), i2);
            if (a4 == null) {
                return new a(-3);
            }
            eVar.put(str, a4);
            return new a(a4);
        } catch (PackageManager.NameNotFoundException unused) {
            return new a(-1);
        }
    }
}
