package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import nb.c;
import okio.ByteString;
import okio.e;

public abstract class ac implements Closeable {
    private Reader reader;

    static final class a extends Reader {

        /* renamed from: a  reason: collision with root package name */
        private final e f31862a;

        /* renamed from: b  reason: collision with root package name */
        private final Charset f31863b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f31864c;

        /* renamed from: d  reason: collision with root package name */
        private Reader f31865d;

        a(e eVar, Charset charset) {
            this.f31862a = eVar;
            this.f31863b = charset;
        }

        public void close() throws IOException {
            this.f31864c = true;
            Reader reader = this.f31865d;
            if (reader != null) {
                reader.close();
            } else {
                this.f31862a.close();
            }
        }

        public int read(char[] cArr, int i2, int i3) throws IOException {
            if (!this.f31864c) {
                Reader reader = this.f31865d;
                if (reader == null) {
                    InputStreamReader inputStreamReader = new InputStreamReader(this.f31862a.g(), c.a(this.f31862a, this.f31863b));
                    this.f31865d = inputStreamReader;
                    reader = inputStreamReader;
                }
                return reader.read(cArr, i2, i3);
            }
            throw new IOException("Stream closed");
        }
    }

    private static /* synthetic */ void $closeResource(Throwable th, AutoCloseable autoCloseable) {
        if (th != null) {
            try {
                autoCloseable.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            autoCloseable.close();
        }
    }

    private Charset charset() {
        v contentType = contentType();
        return contentType != null ? contentType.a(StandardCharsets.UTF_8) : StandardCharsets.UTF_8;
    }

    public static ac create(final v vVar, final long j2, final e eVar) {
        Objects.requireNonNull(eVar, "source == null");
        return new ac() {
            public long contentLength() {
                return j2;
            }

            public v contentType() {
                return v.this;
            }

            public e source() {
                return eVar;
            }
        };
    }

    public static ac create(v vVar, String str) {
        Charset charset = StandardCharsets.UTF_8;
        if (vVar != null && (charset = vVar.b()) == null) {
            charset = StandardCharsets.UTF_8;
            vVar = v.b(vVar + "; charset=utf-8");
        }
        okio.c a2 = new okio.c().a(str, charset);
        return create(vVar, a2.a(), a2);
    }

    public static ac create(v vVar, ByteString byteString) {
        return create(vVar, (long) byteString.g(), new okio.c().b(byteString));
    }

    public static ac create(v vVar, byte[] bArr) {
        return create(vVar, (long) bArr.length, new okio.c().c(bArr));
    }

    public final InputStream byteStream() {
        return source().g();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        if (r2 != null) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0051, code lost:
        $closeResource(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0054, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] bytes() throws java.io.IOException {
        /*
            r6 = this;
            long r0 = r6.contentLength()
            r2 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x0055
            okio.e r2 = r6.source()
            r3 = 0
            byte[] r4 = r2.r()     // Catch:{ all -> 0x004c }
            if (r2 == 0) goto L_0x0019
            $closeResource(r3, r2)
        L_0x0019:
            r2 = -1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x004b
            int r2 = r4.length
            long r2 = (long) r2
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 != 0) goto L_0x0026
            goto L_0x004b
        L_0x0026:
            java.io.IOException r2 = new java.io.IOException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Content-Length ("
            r3.append(r5)
            r3.append(r0)
            java.lang.String r0 = ") and stream length ("
            r3.append(r0)
            int r0 = r4.length
            r3.append(r0)
            java.lang.String r0 = ") disagree"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x004b:
            return r4
        L_0x004c:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x004e }
        L_0x004e:
            r1 = move-exception
            if (r2 == 0) goto L_0x0054
            $closeResource(r0, r2)
        L_0x0054:
            throw r1
        L_0x0055:
            java.io.IOException r2 = new java.io.IOException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Cannot buffer entire body for content length: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.ac.bytes():byte[]");
    }

    public final Reader charStream() {
        Reader reader2 = this.reader;
        if (reader2 != null) {
            return reader2;
        }
        a aVar = new a(source(), charset());
        this.reader = aVar;
        return aVar;
    }

    public void close() {
        c.a((Closeable) source());
    }

    public abstract long contentLength();

    public abstract v contentType();

    public abstract e source();

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        if (r0 != null) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        $closeResource(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
        r2 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String string() throws java.io.IOException {
        /*
            r3 = this;
            okio.e r0 = r3.source()
            java.nio.charset.Charset r1 = r3.charset()     // Catch:{ all -> 0x0017 }
            java.nio.charset.Charset r1 = nb.c.a((okio.e) r0, (java.nio.charset.Charset) r1)     // Catch:{ all -> 0x0017 }
            java.lang.String r1 = r0.a((java.nio.charset.Charset) r1)     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x0016
            r2 = 0
            $closeResource(r2, r0)
        L_0x0016:
            return r1
        L_0x0017:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0019 }
        L_0x0019:
            r2 = move-exception
            if (r0 == 0) goto L_0x001f
            $closeResource(r1, r0)
        L_0x001f:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.ac.string():java.lang.String");
    }
}
