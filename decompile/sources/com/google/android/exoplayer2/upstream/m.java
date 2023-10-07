package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.s;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public class m extends d implements HttpDataSource {

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f17055b = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReference<byte[]> f17056c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    private final boolean f17057d;

    /* renamed from: e  reason: collision with root package name */
    private final int f17058e;

    /* renamed from: f  reason: collision with root package name */
    private final int f17059f;

    /* renamed from: g  reason: collision with root package name */
    private final String f17060g;

    /* renamed from: h  reason: collision with root package name */
    private final HttpDataSource.c f17061h;

    /* renamed from: i  reason: collision with root package name */
    private final HttpDataSource.c f17062i = new HttpDataSource.c();

    /* renamed from: j  reason: collision with root package name */
    private s<String> f17063j;

    /* renamed from: k  reason: collision with root package name */
    private h f17064k;

    /* renamed from: l  reason: collision with root package name */
    private HttpURLConnection f17065l;

    /* renamed from: m  reason: collision with root package name */
    private InputStream f17066m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f17067n;

    /* renamed from: o  reason: collision with root package name */
    private int f17068o;

    /* renamed from: p  reason: collision with root package name */
    private long f17069p;

    /* renamed from: q  reason: collision with root package name */
    private long f17070q;

    /* renamed from: r  reason: collision with root package name */
    private long f17071r;

    /* renamed from: s  reason: collision with root package name */
    private long f17072s;

    public m(String str, int i2, int i3, boolean z2, HttpDataSource.c cVar) {
        super(true);
        this.f17060g = a.a(str);
        this.f17058e = i2;
        this.f17059f = i3;
        this.f17057d = z2;
        this.f17061h = cVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long a(java.net.HttpURLConnection r10) {
        /*
            java.lang.String r0 = "Content-Length"
            java.lang.String r0 = r10.getHeaderField(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r2 = "]"
            java.lang.String r3 = "DefaultHttpDataSource"
            if (r1 != 0) goto L_0x0036
            long r4 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x0015 }
            goto L_0x0038
        L_0x0015:
            java.lang.String r1 = java.lang.String.valueOf(r0)
            int r1 = r1.length()
            int r1 = r1 + 28
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r1)
            java.lang.String r1 = "Unexpected Content-Length ["
            r4.append(r1)
            r4.append(r0)
            r4.append(r2)
            java.lang.String r1 = r4.toString()
            com.google.android.exoplayer2.util.k.d(r3, r1)
        L_0x0036:
            r4 = -1
        L_0x0038:
            java.lang.String r1 = "Content-Range"
            java.lang.String r10 = r10.getHeaderField(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r10)
            if (r1 != 0) goto L_0x00cb
            java.util.regex.Pattern r1 = f17055b
            java.util.regex.Matcher r1 = r1.matcher(r10)
            boolean r6 = r1.find()
            if (r6 == 0) goto L_0x00cb
            r6 = 2
            java.lang.String r6 = r1.group(r6)     // Catch:{ NumberFormatException -> 0x00aa }
            long r6 = java.lang.Long.parseLong(r6)     // Catch:{ NumberFormatException -> 0x00aa }
            r8 = 1
            java.lang.String r1 = r1.group(r8)     // Catch:{ NumberFormatException -> 0x00aa }
            long r8 = java.lang.Long.parseLong(r1)     // Catch:{ NumberFormatException -> 0x00aa }
            long r6 = r6 - r8
            r8 = 1
            long r6 = r6 + r8
            r8 = 0
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 >= 0) goto L_0x006e
            r4 = r6
            goto L_0x00cb
        L_0x006e:
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 == 0) goto L_0x00cb
            java.lang.String r1 = java.lang.String.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00aa }
            int r1 = r1.length()     // Catch:{ NumberFormatException -> 0x00aa }
            int r1 = r1 + 26
            java.lang.String r8 = java.lang.String.valueOf(r10)     // Catch:{ NumberFormatException -> 0x00aa }
            int r8 = r8.length()     // Catch:{ NumberFormatException -> 0x00aa }
            int r1 = r1 + r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x00aa }
            r8.<init>(r1)     // Catch:{ NumberFormatException -> 0x00aa }
            java.lang.String r1 = "Inconsistent headers ["
            r8.append(r1)     // Catch:{ NumberFormatException -> 0x00aa }
            r8.append(r0)     // Catch:{ NumberFormatException -> 0x00aa }
            java.lang.String r0 = "] ["
            r8.append(r0)     // Catch:{ NumberFormatException -> 0x00aa }
            r8.append(r10)     // Catch:{ NumberFormatException -> 0x00aa }
            r8.append(r2)     // Catch:{ NumberFormatException -> 0x00aa }
            java.lang.String r0 = r8.toString()     // Catch:{ NumberFormatException -> 0x00aa }
            com.google.android.exoplayer2.util.k.c(r3, r0)     // Catch:{ NumberFormatException -> 0x00aa }
            long r0 = java.lang.Math.max(r4, r6)     // Catch:{ NumberFormatException -> 0x00aa }
            r4 = r0
            goto L_0x00cb
        L_0x00aa:
            java.lang.String r0 = java.lang.String.valueOf(r10)
            int r0 = r0.length()
            int r0 = r0 + 27
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "Unexpected Content-Range ["
            r1.append(r0)
            r1.append(r10)
            r1.append(r2)
            java.lang.String r10 = r1.toString()
            com.google.android.exoplayer2.util.k.d(r3, r10)
        L_0x00cb:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.m.a(java.net.HttpURLConnection):long");
    }

    private HttpURLConnection a(URL url, int i2, byte[] bArr, long j2, long j3, boolean z2, boolean z3, Map<String, String> map) throws IOException {
        HttpURLConnection a2 = a(url);
        a2.setConnectTimeout(this.f17058e);
        a2.setReadTimeout(this.f17059f);
        HashMap hashMap = new HashMap();
        HttpDataSource.c cVar = this.f17061h;
        if (cVar != null) {
            hashMap.putAll(cVar.a());
        }
        hashMap.putAll(this.f17062i.a());
        hashMap.putAll(map);
        for (Map.Entry entry : hashMap.entrySet()) {
            a2.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        if (!(j2 == 0 && j3 == -1)) {
            StringBuilder sb = new StringBuilder(27);
            sb.append("bytes=");
            sb.append(j2);
            sb.append("-");
            String sb2 = sb.toString();
            if (j3 != -1) {
                String valueOf = String.valueOf(sb2);
                StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 20);
                sb3.append(valueOf);
                sb3.append((j2 + j3) - 1);
                sb2 = sb3.toString();
            }
            a2.setRequestProperty("Range", sb2);
        }
        a2.setRequestProperty("User-Agent", this.f17060g);
        a2.setRequestProperty("Accept-Encoding", z2 ? "gzip" : "identity");
        a2.setInstanceFollowRedirects(z3);
        a2.setDoOutput(bArr != null);
        a2.setRequestMethod(h.b(i2));
        if (bArr != null) {
            a2.setFixedLengthStreamingMode(bArr.length);
            a2.connect();
            OutputStream outputStream = a2.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            a2.connect();
        }
        return a2;
    }

    private static URL a(URL url, String str) throws IOException {
        if (str != null) {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if ("https".equals(protocol) || "http".equals(protocol)) {
                return url2;
            }
            String valueOf = String.valueOf(protocol);
            throw new ProtocolException(valueOf.length() != 0 ? "Unsupported protocol redirect: ".concat(valueOf) : new String("Unsupported protocol redirect: "));
        }
        throw new ProtocolException("Null location redirect");
    }

    private static void a(HttpURLConnection httpURLConnection, long j2) {
        if (ad.f11755a == 19 || ad.f11755a == 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j2 == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j2 <= IjkMediaMeta.AV_CH_TOP_CENTER) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                    Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, new Object[0]);
                }
            } catch (Exception unused) {
            }
        }
    }

    private int b(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f17070q;
        if (j2 != -1) {
            long j3 = j2 - this.f17072s;
            if (j3 == 0) {
                return -1;
            }
            i3 = (int) Math.min((long) i3, j3);
        }
        int read = this.f17066m.read(bArr, i2, i3);
        if (read != -1) {
            this.f17072s += (long) read;
            a(read);
            return read;
        } else if (this.f17070q == -1) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    private static boolean b(HttpURLConnection httpURLConnection) {
        return "gzip".equalsIgnoreCase(httpURLConnection.getHeaderField("Content-Encoding"));
    }

    private HttpURLConnection d(h hVar) throws IOException {
        HttpURLConnection a2;
        h hVar2 = hVar;
        URL url = new URL(hVar2.f16995a.toString());
        int i2 = hVar2.f16996b;
        byte[] bArr = hVar2.f16997c;
        long j2 = hVar2.f17000f;
        long j3 = hVar2.f17001g;
        boolean a3 = hVar2.a(1);
        if (!this.f17057d) {
            return a(url, i2, bArr, j2, j3, a3, true, hVar2.f16998d);
        }
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            if (i3 <= 20) {
                Map<String, String> map = hVar2.f16998d;
                int i5 = i4;
                byte[] bArr2 = bArr;
                long j4 = j3;
                long j5 = j2;
                a2 = a(url, i2, bArr, j2, j3, a3, false, map);
                int responseCode = a2.getResponseCode();
                String headerField = a2.getHeaderField("Location");
                if ((i2 == 1 || i2 == 3) && (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308)) {
                    a2.disconnect();
                    url = a(url, headerField);
                } else if (i2 != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                    return a2;
                } else {
                    a2.disconnect();
                    url = a(url, headerField);
                    bArr2 = null;
                    i2 = 1;
                }
                i3 = i5;
                bArr = bArr2;
                j3 = j4;
                j2 = j5;
                hVar2 = hVar;
            } else {
                StringBuilder sb = new StringBuilder(31);
                sb.append("Too many redirects: ");
                sb.append(i4);
                throw new NoRouteToHostException(sb.toString());
            }
        }
        return a2;
    }

    private void f() throws IOException {
        if (this.f17071r != this.f17069p) {
            byte[] andSet = f17056c.getAndSet((Object) null);
            if (andSet == null) {
                andSet = new byte[4096];
            }
            while (true) {
                long j2 = this.f17071r;
                long j3 = this.f17069p;
                if (j2 != j3) {
                    int read = this.f17066m.read(andSet, 0, (int) Math.min(j3 - j2, (long) andSet.length));
                    if (Thread.currentThread().isInterrupted()) {
                        throw new InterruptedIOException();
                    } else if (read != -1) {
                        this.f17071r += (long) read;
                        a(read);
                    } else {
                        throw new EOFException();
                    }
                } else {
                    f17056c.set(andSet);
                    return;
                }
            }
        }
    }

    private void g() {
        HttpURLConnection httpURLConnection = this.f17065l;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e2) {
                k.b("DefaultHttpDataSource", "Unexpected error while disconnecting", e2);
            }
            this.f17065l = null;
        }
    }

    public int a(byte[] bArr, int i2, int i3) throws HttpDataSource.HttpDataSourceException {
        try {
            f();
            return b(bArr, i2, i3);
        } catch (IOException e2) {
            throw new HttpDataSource.HttpDataSourceException(e2, this.f17064k, 2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0084 A[Catch:{ IOException -> 0x0095 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long a(com.google.android.exoplayer2.upstream.h r8) throws com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException {
        /*
            r7 = this;
            java.lang.String r0 = "Unable to connect"
            r7.f17064k = r8
            r1 = 0
            r7.f17072s = r1
            r7.f17071r = r1
            r7.b(r8)
            r3 = 1
            java.net.HttpURLConnection r4 = r7.d(r8)     // Catch:{ IOException -> 0x00c9 }
            r7.f17065l = r4     // Catch:{ IOException -> 0x00c9 }
            int r4 = r4.getResponseCode()     // Catch:{ IOException -> 0x00bf }
            r7.f17068o = r4     // Catch:{ IOException -> 0x00bf }
            java.net.HttpURLConnection r4 = r7.f17065l     // Catch:{ IOException -> 0x00bf }
            java.lang.String r0 = r4.getResponseMessage()     // Catch:{ IOException -> 0x00bf }
            int r4 = r7.f17068o
            r5 = 200(0xc8, float:2.8E-43)
            if (r4 < r5) goto L_0x009f
            r6 = 299(0x12b, float:4.19E-43)
            if (r4 <= r6) goto L_0x002c
            goto L_0x009f
        L_0x002c:
            java.net.HttpURLConnection r0 = r7.f17065l
            java.lang.String r0 = r0.getContentType()
            com.google.android.exoplayer2.util.s<java.lang.String> r4 = r7.f17063j
            if (r4 == 0) goto L_0x0046
            boolean r4 = r4.evaluate(r0)
            if (r4 == 0) goto L_0x003d
            goto L_0x0046
        L_0x003d:
            r7.g()
            com.google.android.exoplayer2.upstream.HttpDataSource$InvalidContentTypeException r1 = new com.google.android.exoplayer2.upstream.HttpDataSource$InvalidContentTypeException
            r1.<init>(r0, r8)
            throw r1
        L_0x0046:
            int r0 = r7.f17068o
            if (r0 != r5) goto L_0x0052
            long r4 = r8.f17000f
            int r0 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0052
            long r1 = r8.f17000f
        L_0x0052:
            r7.f17069p = r1
            java.net.HttpURLConnection r0 = r7.f17065l
            boolean r0 = b(r0)
            if (r0 != 0) goto L_0x0076
            long r1 = r8.f17001g
            r4 = -1
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0065
            goto L_0x0076
        L_0x0065:
            java.net.HttpURLConnection r1 = r7.f17065l
            long r1 = a((java.net.HttpURLConnection) r1)
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0073
            long r4 = r7.f17069p
            long r4 = r1 - r4
        L_0x0073:
            r7.f17070q = r4
            goto L_0x007a
        L_0x0076:
            long r1 = r8.f17001g
            r7.f17070q = r1
        L_0x007a:
            java.net.HttpURLConnection r1 = r7.f17065l     // Catch:{ IOException -> 0x0095 }
            java.io.InputStream r1 = r1.getInputStream()     // Catch:{ IOException -> 0x0095 }
            r7.f17066m = r1     // Catch:{ IOException -> 0x0095 }
            if (r0 == 0) goto L_0x008d
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x0095 }
            java.io.InputStream r1 = r7.f17066m     // Catch:{ IOException -> 0x0095 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0095 }
            r7.f17066m = r0     // Catch:{ IOException -> 0x0095 }
        L_0x008d:
            r7.f17067n = r3
            r7.c(r8)
            long r0 = r7.f17070q
            return r0
        L_0x0095:
            r0 = move-exception
            r7.g()
            com.google.android.exoplayer2.upstream.HttpDataSource$HttpDataSourceException r1 = new com.google.android.exoplayer2.upstream.HttpDataSource$HttpDataSourceException
            r1.<init>((java.io.IOException) r0, (com.google.android.exoplayer2.upstream.h) r8, (int) r3)
            throw r1
        L_0x009f:
            java.net.HttpURLConnection r1 = r7.f17065l
            java.util.Map r1 = r1.getHeaderFields()
            r7.g()
            com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException r2 = new com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException
            int r3 = r7.f17068o
            r2.<init>(r3, r0, r1, r8)
            int r8 = r7.f17068o
            r0 = 416(0x1a0, float:5.83E-43)
            if (r8 != r0) goto L_0x00be
            com.google.android.exoplayer2.upstream.DataSourceException r8 = new com.google.android.exoplayer2.upstream.DataSourceException
            r0 = 0
            r8.<init>(r0)
            r2.initCause(r8)
        L_0x00be:
            throw r2
        L_0x00bf:
            r1 = move-exception
            r7.g()
            com.google.android.exoplayer2.upstream.HttpDataSource$HttpDataSourceException r2 = new com.google.android.exoplayer2.upstream.HttpDataSource$HttpDataSourceException
            r2.<init>(r0, r1, r8, r3)
            throw r2
        L_0x00c9:
            r1 = move-exception
            com.google.android.exoplayer2.upstream.HttpDataSource$HttpDataSourceException r2 = new com.google.android.exoplayer2.upstream.HttpDataSource$HttpDataSourceException
            r2.<init>(r0, r1, r8, r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.m.a(com.google.android.exoplayer2.upstream.h):long");
    }

    public Uri a() {
        HttpURLConnection httpURLConnection = this.f17065l;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    /* access modifiers changed from: package-private */
    public HttpURLConnection a(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    public Map<String, List<String>> b() {
        HttpURLConnection httpURLConnection = this.f17065l;
        return httpURLConnection == null ? Collections.emptyMap() : httpURLConnection.getHeaderFields();
    }

    public void c() throws HttpDataSource.HttpDataSourceException {
        try {
            if (this.f17066m != null) {
                a(this.f17065l, e());
                this.f17066m.close();
            }
            this.f17066m = null;
            g();
            if (this.f17067n) {
                this.f17067n = false;
                d();
            }
        } catch (IOException e2) {
            throw new HttpDataSource.HttpDataSourceException(e2, this.f17064k, 3);
        } catch (Throwable th) {
            this.f17066m = null;
            g();
            if (this.f17067n) {
                this.f17067n = false;
                d();
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public final long e() {
        long j2 = this.f17070q;
        return j2 == -1 ? j2 : j2 - this.f17072s;
    }
}
