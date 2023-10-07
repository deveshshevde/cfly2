package okhttp3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import nb.c;
import okhttp3.s;
import okio.ByteString;
import okio.d;

public final class w extends aa {

    /* renamed from: a  reason: collision with root package name */
    public static final v f32325a = v.a("multipart/mixed");

    /* renamed from: b  reason: collision with root package name */
    public static final v f32326b = v.a("multipart/alternative");

    /* renamed from: c  reason: collision with root package name */
    public static final v f32327c = v.a("multipart/digest");

    /* renamed from: d  reason: collision with root package name */
    public static final v f32328d = v.a("multipart/parallel");

    /* renamed from: e  reason: collision with root package name */
    public static final v f32329e = v.a("multipart/form-data");

    /* renamed from: f  reason: collision with root package name */
    private static final byte[] f32330f = {58, 32};

    /* renamed from: g  reason: collision with root package name */
    private static final byte[] f32331g = {13, 10};

    /* renamed from: h  reason: collision with root package name */
    private static final byte[] f32332h = {45, 45};

    /* renamed from: i  reason: collision with root package name */
    private final ByteString f32333i;

    /* renamed from: j  reason: collision with root package name */
    private final v f32334j;

    /* renamed from: k  reason: collision with root package name */
    private final v f32335k;

    /* renamed from: l  reason: collision with root package name */
    private final List<b> f32336l;

    /* renamed from: m  reason: collision with root package name */
    private long f32337m = -1;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final ByteString f32338a;

        /* renamed from: b  reason: collision with root package name */
        private v f32339b;

        /* renamed from: c  reason: collision with root package name */
        private final List<b> f32340c;

        public a() {
            this(UUID.randomUUID().toString());
        }

        public a(String str) {
            this.f32339b = w.f32325a;
            this.f32340c = new ArrayList();
            this.f32338a = ByteString.a(str);
        }

        public a a(s sVar, aa aaVar) {
            return a(b.a(sVar, aaVar));
        }

        public a a(v vVar) {
            Objects.requireNonNull(vVar, "type == null");
            if (vVar.a().equals("multipart")) {
                this.f32339b = vVar;
                return this;
            }
            throw new IllegalArgumentException("multipart != " + vVar);
        }

        public a a(b bVar) {
            Objects.requireNonNull(bVar, "part == null");
            this.f32340c.add(bVar);
            return this;
        }

        public w a() {
            if (!this.f32340c.isEmpty()) {
                return new w(this.f32338a, this.f32339b, this.f32340c);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        final s f32341a;

        /* renamed from: b  reason: collision with root package name */
        final aa f32342b;

        private b(s sVar, aa aaVar) {
            this.f32341a = sVar;
            this.f32342b = aaVar;
        }

        public static b a(String str, String str2) {
            return a(str, (String) null, aa.create((v) null, str2));
        }

        public static b a(String str, String str2, aa aaVar) {
            Objects.requireNonNull(str, "name == null");
            StringBuilder sb = new StringBuilder("form-data; name=");
            w.a(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                w.a(sb, str2);
            }
            return a(new s.a().b("Content-Disposition", sb.toString()).a(), aaVar);
        }

        public static b a(s sVar, aa aaVar) {
            Objects.requireNonNull(aaVar, "body == null");
            if (sVar != null && sVar.a("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            } else if (sVar == null || sVar.a("Content-Length") == null) {
                return new b(sVar, aaVar);
            } else {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
        }
    }

    w(ByteString byteString, v vVar, List<b> list) {
        this.f32333i = byteString;
        this.f32334j = vVar;
        this.f32335k = v.a(vVar + "; boundary=" + byteString.a());
        this.f32336l = c.a(list);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: okio.d} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: okio.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: okio.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: okio.d} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: okio.c} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long a(okio.d r13, boolean r14) throws java.io.IOException {
        /*
            r12 = this;
            if (r14 == 0) goto L_0x0009
            okio.c r13 = new okio.c
            r13.<init>()
            r0 = r13
            goto L_0x000a
        L_0x0009:
            r0 = 0
        L_0x000a:
            java.util.List<okhttp3.w$b> r1 = r12.f32336l
            int r1 = r1.size()
            r2 = 0
            r3 = 0
            r5 = 0
        L_0x0014:
            if (r5 >= r1) goto L_0x00a4
            java.util.List<okhttp3.w$b> r6 = r12.f32336l
            java.lang.Object r6 = r6.get(r5)
            okhttp3.w$b r6 = (okhttp3.w.b) r6
            okhttp3.s r7 = r6.f32341a
            okhttp3.aa r6 = r6.f32342b
            byte[] r8 = f32332h
            r13.c(r8)
            okio.ByteString r8 = r12.f32333i
            r13.b((okio.ByteString) r8)
            byte[] r8 = f32331g
            r13.c(r8)
            if (r7 == 0) goto L_0x0058
            int r8 = r7.a()
            r9 = 0
        L_0x0038:
            if (r9 >= r8) goto L_0x0058
            java.lang.String r10 = r7.a((int) r9)
            okio.d r10 = r13.b((java.lang.String) r10)
            byte[] r11 = f32330f
            okio.d r10 = r10.c(r11)
            java.lang.String r11 = r7.b((int) r9)
            okio.d r10 = r10.b((java.lang.String) r11)
            byte[] r11 = f32331g
            r10.c(r11)
            int r9 = r9 + 1
            goto L_0x0038
        L_0x0058:
            okhttp3.v r7 = r6.contentType()
            if (r7 == 0) goto L_0x0071
            java.lang.String r8 = "Content-Type: "
            okio.d r8 = r13.b((java.lang.String) r8)
            java.lang.String r7 = r7.toString()
            okio.d r7 = r8.b((java.lang.String) r7)
            byte[] r8 = f32331g
            r7.c(r8)
        L_0x0071:
            long r7 = r6.contentLength()
            r9 = -1
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x008b
            java.lang.String r9 = "Content-Length: "
            okio.d r9 = r13.b((java.lang.String) r9)
            okio.d r9 = r9.l(r7)
            byte[] r10 = f32331g
            r9.c(r10)
            goto L_0x0091
        L_0x008b:
            if (r14 == 0) goto L_0x0091
            r0.s()
            return r9
        L_0x0091:
            byte[] r9 = f32331g
            r13.c(r9)
            if (r14 == 0) goto L_0x009a
            long r3 = r3 + r7
            goto L_0x009d
        L_0x009a:
            r6.writeTo(r13)
        L_0x009d:
            r13.c(r9)
            int r5 = r5 + 1
            goto L_0x0014
        L_0x00a4:
            byte[] r1 = f32332h
            r13.c(r1)
            okio.ByteString r2 = r12.f32333i
            r13.b((okio.ByteString) r2)
            r13.c(r1)
            byte[] r1 = f32331g
            r13.c(r1)
            if (r14 == 0) goto L_0x00c0
            long r13 = r0.a()
            long r3 = r3 + r13
            r0.s()
        L_0x00c0:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.w.a(okio.d, boolean):long");
    }

    static void a(StringBuilder sb, String str) {
        String str2;
        sb.append('\"');
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt == 10) {
                str2 = "%0A";
            } else if (charAt == 13) {
                str2 = "%0D";
            } else if (charAt != '\"') {
                sb.append(charAt);
            } else {
                str2 = "%22";
            }
            sb.append(str2);
        }
        sb.append('\"');
    }

    public long contentLength() throws IOException {
        long j2 = this.f32337m;
        if (j2 != -1) {
            return j2;
        }
        long a2 = a((d) null, true);
        this.f32337m = a2;
        return a2;
    }

    public v contentType() {
        return this.f32335k;
    }

    public void writeTo(d dVar) throws IOException {
        a(dVar, false);
    }
}
