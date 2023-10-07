package no;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected final b f31602a;

    /* renamed from: b  reason: collision with root package name */
    private c f31603b = null;

    /* renamed from: c  reason: collision with root package name */
    private c f31604c = null;

    protected a() {
        b bVar = new b(this);
        this.f31602a = bVar;
        bVar.start();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static no.a a() {
        /*
            java.lang.Object r0 = nn.a.b()
            monitor-enter(r0)
            boolean r1 = nn.a.c()     // Catch:{ all -> 0x001d }
            if (r1 == 0) goto L_0x000e
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            r0 = 0
            return r0
        L_0x000e:
            no.a r1 = nn.a.a()     // Catch:{ all -> 0x001d }
            if (r1 != 0) goto L_0x001b
            no.a r1 = e()     // Catch:{ all -> 0x001d }
            nn.a.a(r1)     // Catch:{ all -> 0x001d }
        L_0x001b:
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            return r1
        L_0x001d:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: no.a.a():no.a");
    }

    private static a e() {
        String str;
        int a2 = nq.a.a();
        if (a2 == 1) {
            str = "org.apache.harmony.awt.datatransfer.windows.WinDTK";
        } else if (a2 == 2) {
            str = "org.apache.harmony.awt.datatransfer.linux.LinuxDTK";
        } else {
            throw new RuntimeException(np.a.a("awt.4E"));
        }
        try {
            return (a) Class.forName(str).newInstance();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public abstract void b();

    public abstract void c();

    public String d() {
        return "unicode";
    }
}
