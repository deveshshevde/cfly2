package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicLong;

public final class ag {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f30297a = false;

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f30298b;

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f30299c;

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicLong f30300d = new AtomicLong(0);

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003c, code lost:
        if (r1.equals("on") != false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0045, code lost:
        if (r1.equals("") != false) goto L_0x0047;
     */
    static {
        /*
            java.lang.Class<kotlinx.coroutines.ad> r0 = kotlinx.coroutines.ad.class
            r0 = 0
            f30297a = r0
            java.lang.String r1 = "kotlinx.coroutines.debug"
            java.lang.String r1 = kotlinx.coroutines.internal.x.a(r1)
            r2 = 1
            if (r1 != 0) goto L_0x000f
            goto L_0x002b
        L_0x000f:
            int r3 = r1.hashCode()
            if (r3 == 0) goto L_0x003f
            r4 = 3551(0xddf, float:4.976E-42)
            if (r3 == r4) goto L_0x0036
            r4 = 109935(0x1ad6f, float:1.54052E-40)
            if (r3 == r4) goto L_0x002d
            r4 = 3005871(0x2dddaf, float:4.212122E-39)
            if (r3 != r4) goto L_0x0061
            java.lang.String r3 = "auto"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0061
        L_0x002b:
            r1 = 0
            goto L_0x0048
        L_0x002d:
            java.lang.String r3 = "off"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0061
            goto L_0x002b
        L_0x0036:
            java.lang.String r3 = "on"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0061
            goto L_0x0047
        L_0x003f:
            java.lang.String r3 = ""
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0061
        L_0x0047:
            r1 = 1
        L_0x0048:
            f30298b = r1
            if (r1 == 0) goto L_0x0055
            java.lang.String r1 = "kotlinx.coroutines.stacktrace.recovery"
            boolean r1 = kotlinx.coroutines.internal.x.a(r1, r2)
            if (r1 == 0) goto L_0x0055
            r0 = 1
        L_0x0055:
            f30299c = r0
            java.util.concurrent.atomic.AtomicLong r0 = new java.util.concurrent.atomic.AtomicLong
            r1 = 0
            r0.<init>(r1)
            f30300d = r0
            return
        L_0x0061:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "System property 'kotlinx.coroutines.debug' has unrecognized value '"
            r0.append(r2)
            r0.append(r1)
            r1 = 39
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            goto L_0x0084
        L_0x0083:
            throw r1
        L_0x0084:
            goto L_0x0083
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.ag.<clinit>():void");
    }

    public static final boolean a() {
        return f30297a;
    }

    public static final boolean b() {
        return f30298b;
    }

    public static final boolean c() {
        return f30299c;
    }

    public static final AtomicLong d() {
        return f30300d;
    }
}
