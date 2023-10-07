package okhttp3;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.concurrent.TimeUnit;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f31872a = new a().a().c();

    /* renamed from: b  reason: collision with root package name */
    public static final d f31873b = new a().b().a(SubsamplingScaleImageView.TILE_SIZE_AUTO, TimeUnit.SECONDS).c();

    /* renamed from: c  reason: collision with root package name */
    String f31874c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f31875d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f31876e;

    /* renamed from: f  reason: collision with root package name */
    private final int f31877f;

    /* renamed from: g  reason: collision with root package name */
    private final int f31878g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f31879h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f31880i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f31881j;

    /* renamed from: k  reason: collision with root package name */
    private final int f31882k;

    /* renamed from: l  reason: collision with root package name */
    private final int f31883l;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f31884m;

    /* renamed from: n  reason: collision with root package name */
    private final boolean f31885n;

    /* renamed from: o  reason: collision with root package name */
    private final boolean f31886o;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f31887a;

        /* renamed from: b  reason: collision with root package name */
        boolean f31888b;

        /* renamed from: c  reason: collision with root package name */
        int f31889c = -1;

        /* renamed from: d  reason: collision with root package name */
        int f31890d = -1;

        /* renamed from: e  reason: collision with root package name */
        int f31891e = -1;

        /* renamed from: f  reason: collision with root package name */
        boolean f31892f;

        /* renamed from: g  reason: collision with root package name */
        boolean f31893g;

        /* renamed from: h  reason: collision with root package name */
        boolean f31894h;

        public a a() {
            this.f31887a = true;
            return this;
        }

        public a a(int i2, TimeUnit timeUnit) {
            if (i2 >= 0) {
                long seconds = timeUnit.toSeconds((long) i2);
                this.f31890d = seconds > 2147483647L ? SubsamplingScaleImageView.TILE_SIZE_AUTO : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i2);
        }

        public a b() {
            this.f31892f = true;
            return this;
        }

        public d c() {
            return new d(this);
        }
    }

    d(a aVar) {
        this.f31875d = aVar.f31887a;
        this.f31876e = aVar.f31888b;
        this.f31877f = aVar.f31889c;
        this.f31878g = -1;
        this.f31879h = false;
        this.f31880i = false;
        this.f31881j = false;
        this.f31882k = aVar.f31890d;
        this.f31883l = aVar.f31891e;
        this.f31884m = aVar.f31892f;
        this.f31885n = aVar.f31893g;
        this.f31886o = aVar.f31894h;
    }

    private d(boolean z2, boolean z3, int i2, int i3, boolean z4, boolean z5, boolean z6, int i4, int i5, boolean z7, boolean z8, boolean z9, String str) {
        this.f31875d = z2;
        this.f31876e = z3;
        this.f31877f = i2;
        this.f31878g = i3;
        this.f31879h = z4;
        this.f31880i = z5;
        this.f31881j = z6;
        this.f31882k = i4;
        this.f31883l = i5;
        this.f31884m = z7;
        this.f31885n = z8;
        this.f31886o = z9;
        this.f31874c = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static okhttp3.d a(okhttp3.s r22) {
        /*
            r0 = r22
            int r1 = r22.a()
            r6 = 0
            r7 = 1
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = -1
            r12 = -1
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = -1
            r17 = -1
            r18 = 0
            r19 = 0
            r20 = 0
        L_0x001a:
            if (r6 >= r1) goto L_0x013f
            java.lang.String r2 = r0.a((int) r6)
            java.lang.String r4 = r0.b((int) r6)
            java.lang.String r3 = "Cache-Control"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0031
            if (r8 == 0) goto L_0x002f
            goto L_0x0039
        L_0x002f:
            r8 = r4
            goto L_0x003a
        L_0x0031:
            java.lang.String r3 = "Pragma"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x0138
        L_0x0039:
            r7 = 0
        L_0x003a:
            r2 = 0
        L_0x003b:
            int r3 = r4.length()
            if (r2 >= r3) goto L_0x0138
            java.lang.String r3 = "=,;"
            int r3 = nd.e.a((java.lang.String) r4, (int) r2, (java.lang.String) r3)
            java.lang.String r2 = r4.substring(r2, r3)
            java.lang.String r2 = r2.trim()
            int r5 = r4.length()
            if (r3 == r5) goto L_0x0099
            char r5 = r4.charAt(r3)
            r0 = 44
            if (r5 == r0) goto L_0x0099
            char r0 = r4.charAt(r3)
            r5 = 59
            if (r0 != r5) goto L_0x0066
            goto L_0x0099
        L_0x0066:
            int r3 = r3 + 1
            int r0 = nd.e.a(r4, r3)
            int r3 = r4.length()
            if (r0 >= r3) goto L_0x0089
            char r3 = r4.charAt(r0)
            r5 = 34
            if (r3 != r5) goto L_0x0089
            int r0 = r0 + 1
            java.lang.String r3 = "\""
            int r3 = nd.e.a((java.lang.String) r4, (int) r0, (java.lang.String) r3)
            java.lang.String r0 = r4.substring(r0, r3)
            r5 = 1
            int r3 = r3 + r5
            goto L_0x009d
        L_0x0089:
            r5 = 1
            java.lang.String r3 = ",;"
            int r3 = nd.e.a((java.lang.String) r4, (int) r0, (java.lang.String) r3)
            java.lang.String r0 = r4.substring(r0, r3)
            java.lang.String r0 = r0.trim()
            goto L_0x009d
        L_0x0099:
            r5 = 1
            int r3 = r3 + 1
            r0 = 0
        L_0x009d:
            java.lang.String r5 = "no-cache"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00a9
            r5 = -1
            r9 = 1
            goto L_0x0133
        L_0x00a9:
            java.lang.String r5 = "no-store"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00b5
            r5 = -1
            r10 = 1
            goto L_0x0133
        L_0x00b5:
            java.lang.String r5 = "max-age"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00c4
            r5 = -1
            int r11 = nd.e.b(r0, r5)
            goto L_0x0133
        L_0x00c4:
            java.lang.String r5 = "s-maxage"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00d2
            r5 = -1
            int r12 = nd.e.b(r0, r5)
            goto L_0x0133
        L_0x00d2:
            java.lang.String r5 = "private"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00dd
            r5 = -1
            r13 = 1
            goto L_0x0133
        L_0x00dd:
            java.lang.String r5 = "public"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00e8
            r5 = -1
            r14 = 1
            goto L_0x0133
        L_0x00e8:
            java.lang.String r5 = "must-revalidate"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00f3
            r5 = -1
            r15 = 1
            goto L_0x0133
        L_0x00f3:
            java.lang.String r5 = "max-stale"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x0104
            r2 = 2147483647(0x7fffffff, float:NaN)
            int r16 = nd.e.b(r0, r2)
            r5 = -1
            goto L_0x0133
        L_0x0104:
            java.lang.String r5 = "min-fresh"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x0112
            r5 = -1
            int r17 = nd.e.b(r0, r5)
            goto L_0x0133
        L_0x0112:
            r5 = -1
            java.lang.String r0 = "only-if-cached"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x011e
            r18 = 1
            goto L_0x0133
        L_0x011e:
            java.lang.String r0 = "no-transform"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0129
            r19 = 1
            goto L_0x0133
        L_0x0129:
            java.lang.String r0 = "immutable"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0133
            r20 = 1
        L_0x0133:
            r0 = r22
            r2 = r3
            goto L_0x003b
        L_0x0138:
            r5 = -1
            int r6 = r6 + 1
            r0 = r22
            goto L_0x001a
        L_0x013f:
            if (r7 != 0) goto L_0x0144
            r21 = 0
            goto L_0x0146
        L_0x0144:
            r21 = r8
        L_0x0146:
            okhttp3.d r0 = new okhttp3.d
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.d.a(okhttp3.s):okhttp3.d");
    }

    private String j() {
        StringBuilder sb = new StringBuilder();
        if (this.f31875d) {
            sb.append("no-cache, ");
        }
        if (this.f31876e) {
            sb.append("no-store, ");
        }
        if (this.f31877f != -1) {
            sb.append("max-age=");
            sb.append(this.f31877f);
            sb.append(", ");
        }
        if (this.f31878g != -1) {
            sb.append("s-maxage=");
            sb.append(this.f31878g);
            sb.append(", ");
        }
        if (this.f31879h) {
            sb.append("private, ");
        }
        if (this.f31880i) {
            sb.append("public, ");
        }
        if (this.f31881j) {
            sb.append("must-revalidate, ");
        }
        if (this.f31882k != -1) {
            sb.append("max-stale=");
            sb.append(this.f31882k);
            sb.append(", ");
        }
        if (this.f31883l != -1) {
            sb.append("min-fresh=");
            sb.append(this.f31883l);
            sb.append(", ");
        }
        if (this.f31884m) {
            sb.append("only-if-cached, ");
        }
        if (this.f31885n) {
            sb.append("no-transform, ");
        }
        if (this.f31886o) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public boolean a() {
        return this.f31875d;
    }

    public boolean b() {
        return this.f31876e;
    }

    public int c() {
        return this.f31877f;
    }

    public boolean d() {
        return this.f31879h;
    }

    public boolean e() {
        return this.f31880i;
    }

    public boolean f() {
        return this.f31881j;
    }

    public int g() {
        return this.f31882k;
    }

    public int h() {
        return this.f31883l;
    }

    public boolean i() {
        return this.f31884m;
    }

    public String toString() {
        String str = this.f31874c;
        if (str != null) {
            return str;
        }
        String j2 = j();
        this.f31874c = j2;
        return j2;
    }
}
