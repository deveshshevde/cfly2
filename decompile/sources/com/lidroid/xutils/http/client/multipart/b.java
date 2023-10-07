package com.lidroid.xutils.http.client.multipart;

import com.lidroid.xutils.http.client.multipart.f;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.util.ByteArrayBuffer;

class b {

    /* renamed from: a  reason: collision with root package name */
    private static final ByteArrayBuffer f21091a = a(c.f21100a, ": ");

    /* renamed from: b  reason: collision with root package name */
    private static final ByteArrayBuffer f21092b = a(c.f21100a, "\r\n");

    /* renamed from: c  reason: collision with root package name */
    private static final ByteArrayBuffer f21093c = a(c.f21100a, "--");

    /* renamed from: i  reason: collision with root package name */
    private static /* synthetic */ int[] f21094i;

    /* renamed from: d  reason: collision with root package name */
    private String f21095d;

    /* renamed from: e  reason: collision with root package name */
    private final Charset f21096e;

    /* renamed from: f  reason: collision with root package name */
    private final String f21097f;

    /* renamed from: g  reason: collision with root package name */
    private final List<a> f21098g;

    /* renamed from: h  reason: collision with root package name */
    private final HttpMultipartMode f21099h;

    public b(String str, Charset charset, String str2, HttpMultipartMode httpMultipartMode) {
        if (str == null) {
            throw new IllegalArgumentException("Multipart subtype may not be null");
        } else if (str2 != null) {
            this.f21095d = str;
            this.f21096e = charset == null ? c.f21100a : charset;
            this.f21097f = str2;
            this.f21098g = new ArrayList();
            this.f21099h = httpMultipartMode;
        } else {
            throw new IllegalArgumentException("Multipart boundary may not be null");
        }
    }

    private static ByteArrayBuffer a(Charset charset, String str) {
        ByteBuffer encode = charset.encode(CharBuffer.wrap(str));
        ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(encode.remaining());
        byteArrayBuffer.append(encode.array(), encode.position(), encode.remaining());
        return byteArrayBuffer;
    }

    private void a(HttpMultipartMode httpMultipartMode, OutputStream outputStream, f.a aVar, boolean z2) throws IOException {
        aVar.f21117d = 0;
        ByteArrayBuffer a2 = a(this.f21096e, b());
        for (a next : this.f21098g) {
            if (aVar.a(true)) {
                ByteArrayBuffer byteArrayBuffer = f21093c;
                a(byteArrayBuffer, outputStream);
                aVar.f21117d += (long) byteArrayBuffer.length();
                a(a2, outputStream);
                aVar.f21117d += (long) a2.length();
                ByteArrayBuffer byteArrayBuffer2 = f21092b;
                a(byteArrayBuffer2, outputStream);
                aVar.f21117d += (long) byteArrayBuffer2.length();
                e c2 = next.c();
                int i2 = d()[httpMultipartMode.ordinal()];
                if (i2 == 1) {
                    Iterator<d> it2 = c2.iterator();
                    while (it2.hasNext()) {
                        d next2 = it2.next();
                        a(next2, outputStream);
                        aVar.f21117d = aVar.f21117d + ((long) (a(c.f21100a, String.valueOf(next2.a()) + next2.b()).length() + f21091a.length() + f21092b.length()));
                    }
                } else if (i2 == 2) {
                    d a3 = c2.a("Content-Disposition");
                    a(a3, this.f21096e, outputStream);
                    long j2 = aVar.f21117d;
                    int length = a(this.f21096e, String.valueOf(a3.a()) + a3.b()).length();
                    ByteArrayBuffer byteArrayBuffer3 = f21091a;
                    aVar.f21117d = j2 + ((long) (length + byteArrayBuffer3.length() + byteArrayBuffer2.length()));
                    if (next.b().b() != null) {
                        d a4 = c2.a("Content-Type");
                        a(a4, this.f21096e, outputStream);
                        aVar.f21117d = aVar.f21117d + ((long) (a(this.f21096e, String.valueOf(a4.a()) + a4.b()).length() + byteArrayBuffer3.length() + byteArrayBuffer2.length()));
                    }
                }
                ByteArrayBuffer byteArrayBuffer4 = f21092b;
                a(byteArrayBuffer4, outputStream);
                aVar.f21117d += (long) byteArrayBuffer4.length();
                if (z2) {
                    ij.b b2 = next.b();
                    b2.a(aVar);
                    b2.a(outputStream);
                }
                a(byteArrayBuffer4, outputStream);
                aVar.f21117d += (long) byteArrayBuffer4.length();
            } else {
                throw new InterruptedIOException("cancel");
            }
        }
        ByteArrayBuffer byteArrayBuffer5 = f21093c;
        a(byteArrayBuffer5, outputStream);
        aVar.f21117d += (long) byteArrayBuffer5.length();
        a(a2, outputStream);
        aVar.f21117d += (long) a2.length();
        a(byteArrayBuffer5, outputStream);
        aVar.f21117d += (long) byteArrayBuffer5.length();
        ByteArrayBuffer byteArrayBuffer6 = f21092b;
        a(byteArrayBuffer6, outputStream);
        aVar.f21117d += (long) byteArrayBuffer6.length();
        aVar.a(true);
    }

    private void a(HttpMultipartMode httpMultipartMode, OutputStream outputStream, boolean z2) throws IOException {
        a(httpMultipartMode, outputStream, f.a.f21114a, z2);
    }

    private static void a(d dVar, OutputStream outputStream) throws IOException {
        a(dVar.a(), outputStream);
        a(f21091a, outputStream);
        a(dVar.b(), outputStream);
        a(f21092b, outputStream);
    }

    private static void a(d dVar, Charset charset, OutputStream outputStream) throws IOException {
        a(dVar.a(), charset, outputStream);
        a(f21091a, outputStream);
        a(dVar.b(), charset, outputStream);
        a(f21092b, outputStream);
    }

    private static void a(String str, OutputStream outputStream) throws IOException {
        a(a(c.f21100a, str), outputStream);
    }

    private static void a(String str, Charset charset, OutputStream outputStream) throws IOException {
        a(a(charset, str), outputStream);
    }

    private static void a(ByteArrayBuffer byteArrayBuffer, OutputStream outputStream) throws IOException {
        outputStream.write(byteArrayBuffer.buffer(), 0, byteArrayBuffer.length());
        outputStream.flush();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:3|4|5|6|7|8|10) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0015 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ int[] d() {
        /*
            int[] r0 = f21094i
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            com.lidroid.xutils.http.client.multipart.HttpMultipartMode[] r0 = com.lidroid.xutils.http.client.multipart.HttpMultipartMode.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            com.lidroid.xutils.http.client.multipart.HttpMultipartMode r1 = com.lidroid.xutils.http.client.multipart.HttpMultipartMode.BROWSER_COMPATIBLE     // Catch:{ NoSuchFieldError -> 0x0015 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0015 }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0015 }
        L_0x0015:
            com.lidroid.xutils.http.client.multipart.HttpMultipartMode r1 = com.lidroid.xutils.http.client.multipart.HttpMultipartMode.STRICT     // Catch:{ NoSuchFieldError -> 0x001e }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001e }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001e }
        L_0x001e:
            f21094i = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lidroid.xutils.http.client.multipart.b.d():int[]");
    }

    public List<a> a() {
        return this.f21098g;
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.f21098g.add(aVar);
        }
    }

    public void a(OutputStream outputStream, f.a aVar) throws IOException {
        a(this.f21099h, outputStream, aVar, true);
    }

    public String b() {
        return this.f21097f;
    }

    public long c() {
        long j2 = 0;
        for (a b2 : this.f21098g) {
            long e2 = b2.b().e();
            if (e2 < 0) {
                return -1;
            }
            j2 += e2;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            a(this.f21099h, (OutputStream) byteArrayOutputStream, false);
            return j2 + ((long) byteArrayOutputStream.toByteArray().length);
        } catch (Throwable unused) {
            return -1;
        }
    }
}
