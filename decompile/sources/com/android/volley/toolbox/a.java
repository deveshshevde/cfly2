package com.android.volley.toolbox;

import com.android.volley.Request;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.a;
import com.android.volley.e;
import com.android.volley.k;
import com.android.volley.l;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.impl.cookie.DateUtils;

public class a implements e {

    /* renamed from: a  reason: collision with root package name */
    protected static final boolean f9952a = l.f9936b;

    /* renamed from: d  reason: collision with root package name */
    private static int f9953d = 3000;

    /* renamed from: e  reason: collision with root package name */
    private static int f9954e = 4096;

    /* renamed from: b  reason: collision with root package name */
    protected final f f9955b;

    /* renamed from: c  reason: collision with root package name */
    protected final b f9956c;

    public a(f fVar) {
        this(fVar, new b(f9954e));
    }

    public a(f fVar, b bVar) {
        this.f9955b = fVar;
        this.f9956c = bVar;
    }

    private static Map<String, String> a(Header[] headerArr) {
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < headerArr.length; i2++) {
            hashMap.put(headerArr[i2].getName(), headerArr[i2].getValue());
        }
        return hashMap;
    }

    private void a(long j2, Request<?> request, byte[] bArr, StatusLine statusLine) {
        if (f9952a || j2 > ((long) f9953d)) {
            Object[] objArr = new Object[5];
            objArr[0] = request;
            objArr[1] = Long.valueOf(j2);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(statusLine.getStatusCode());
            objArr[4] = Integer.valueOf(request.t().b());
            l.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    private static void a(String str, Request<?> request, VolleyError volleyError) throws VolleyError {
        k t2 = request.t();
        int s2 = request.s();
        try {
            t2.a(volleyError);
            request.a(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(s2)}));
        } catch (VolleyError e2) {
            request.a(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(s2)}));
            throw e2;
        }
    }

    private void a(Map<String, String> map, a.C0077a aVar) {
        if (aVar != null) {
            if (aVar.f9888b != null) {
                map.put("If-None-Match", aVar.f9888b);
            }
            if (aVar.f9889c > 0) {
                map.put("If-Modified-Since", DateUtils.formatDate(new Date(aVar.f9889c)));
            }
        }
    }

    private byte[] a(HttpEntity httpEntity) throws IOException, ServerError {
        j jVar = new j(this.f9956c, (int) httpEntity.getContentLength());
        byte[] bArr = null;
        try {
            InputStream content = httpEntity.getContent();
            if (content != null) {
                bArr = this.f9956c.a(1024);
                while (true) {
                    int read = content.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    jVar.write(bArr, 0, read);
                }
                return jVar.toByteArray();
            }
            throw new ServerError();
        } finally {
            try {
                httpEntity.consumeContent();
            } catch (IOException unused) {
                l.a("Error occured when calling consumingContent", new Object[0]);
            }
            this.f9956c.a(bArr);
            jVar.close();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0069, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006a, code lost:
        r1 = r15;
        r5 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0078, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0079, code lost:
        r2 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x007d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x007e, code lost:
        r2 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0080, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0081, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0084, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0085, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0087, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0088, code lost:
        r5 = null;
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x008c, code lost:
        r0 = r14.getStatusLine().getStatusCode();
        com.android.volley.l.c("Unexpected response code %d for %s", java.lang.Integer.valueOf(r0), r18.c());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a8, code lost:
        if (r5 != null) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00aa, code lost:
        r2 = new com.android.volley.g(r0, r5, r1, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b1, code lost:
        if (r0 == 401) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00bd, code lost:
        throw new com.android.volley.ServerError(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00be, code lost:
        r0 = new com.android.volley.AuthFailureError(r2);
        r1 = "auth";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00cb, code lost:
        throw new com.android.volley.NetworkError((com.android.volley.g) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00d1, code lost:
        throw new com.android.volley.NoConnectionError(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00d2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00ea, code lost:
        throw new java.lang.RuntimeException("Bad URL " + r18.c(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00eb, code lost:
        r0 = new com.android.volley.TimeoutError();
        r1 = "connection";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00f3, code lost:
        r0 = new com.android.volley.TimeoutError();
        r1 = "socket";
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00d2 A[ExcHandler: MalformedURLException (r0v3 'e' java.net.MalformedURLException A[CUSTOM_DECLARE]), Splitter:B:2:0x0010] */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[ExcHandler: ConnectTimeoutException (unused org.apache.http.conn.ConnectTimeoutException), SYNTHETIC, Splitter:B:2:0x0010] */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[ExcHandler: SocketTimeoutException (unused java.net.SocketTimeoutException), SYNTHETIC, Splitter:B:2:0x0010] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00cc A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.android.volley.g a(com.android.volley.Request<?> r18) throws com.android.volley.VolleyError {
        /*
            r17 = this;
            r7 = r17
            r8 = r18
            long r9 = android.os.SystemClock.elapsedRealtime()
        L_0x0008:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r11 = 1
            r12 = 0
            r13 = 0
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ SocketTimeoutException -> 0x00f3, ConnectTimeoutException -> 0x00eb, MalformedURLException -> 0x00d2, IOException -> 0x0087 }
            r0.<init>()     // Catch:{ SocketTimeoutException -> 0x00f3, ConnectTimeoutException -> 0x00eb, MalformedURLException -> 0x00d2, IOException -> 0x0087 }
            com.android.volley.a$a r2 = r18.e()     // Catch:{ SocketTimeoutException -> 0x00f3, ConnectTimeoutException -> 0x00eb, MalformedURLException -> 0x00d2, IOException -> 0x0087 }
            r7.a(r0, r2)     // Catch:{ SocketTimeoutException -> 0x00f3, ConnectTimeoutException -> 0x00eb, MalformedURLException -> 0x00d2, IOException -> 0x0087 }
            com.android.volley.toolbox.f r2 = r7.f9955b     // Catch:{ SocketTimeoutException -> 0x00f3, ConnectTimeoutException -> 0x00eb, MalformedURLException -> 0x00d2, IOException -> 0x0087 }
            org.apache.http.HttpResponse r14 = r2.a(r8, r0)     // Catch:{ SocketTimeoutException -> 0x00f3, ConnectTimeoutException -> 0x00eb, MalformedURLException -> 0x00d2, IOException -> 0x0087 }
            org.apache.http.StatusLine r6 = r14.getStatusLine()     // Catch:{ SocketTimeoutException -> 0x00f3, ConnectTimeoutException -> 0x00eb, MalformedURLException -> 0x00d2, IOException -> 0x0084 }
            int r0 = r6.getStatusCode()     // Catch:{ SocketTimeoutException -> 0x00f3, ConnectTimeoutException -> 0x00eb, MalformedURLException -> 0x00d2, IOException -> 0x0084 }
            org.apache.http.Header[] r2 = r14.getAllHeaders()     // Catch:{ SocketTimeoutException -> 0x00f3, ConnectTimeoutException -> 0x00eb, MalformedURLException -> 0x00d2, IOException -> 0x0084 }
            java.util.Map r15 = a((org.apache.http.Header[]) r2)     // Catch:{ SocketTimeoutException -> 0x00f3, ConnectTimeoutException -> 0x00eb, MalformedURLException -> 0x00d2, IOException -> 0x0084 }
            r1 = 304(0x130, float:4.26E-43)
            if (r0 != r1) goto L_0x0042
            com.android.volley.g r0 = new com.android.volley.g     // Catch:{ SocketTimeoutException -> 0x00f3, ConnectTimeoutException -> 0x00eb, MalformedURLException -> 0x00d2, IOException -> 0x0080 }
            com.android.volley.a$a r2 = r18.e()     // Catch:{ SocketTimeoutException -> 0x00f3, ConnectTimeoutException -> 0x00eb, MalformedURLException -> 0x00d2, IOException -> 0x0080 }
            byte[] r2 = r2.f9887a     // Catch:{ SocketTimeoutException -> 0x00f3, ConnectTimeoutException -> 0x00eb, MalformedURLException -> 0x00d2, IOException -> 0x0080 }
            r0.<init>(r1, r2, r15, r11)     // Catch:{ SocketTimeoutException -> 0x00f3, ConnectTimeoutException -> 0x00eb, MalformedURLException -> 0x00d2, IOException -> 0x0080 }
            return r0
        L_0x0042:
            org.apache.http.HttpEntity r1 = r14.getEntity()     // Catch:{ SocketTimeoutException -> 0x00f3, ConnectTimeoutException -> 0x00eb, MalformedURLException -> 0x00d2, IOException -> 0x0080 }
            byte[] r5 = r7.a((org.apache.http.HttpEntity) r1)     // Catch:{ SocketTimeoutException -> 0x00f3, ConnectTimeoutException -> 0x00eb, MalformedURLException -> 0x00d2, IOException -> 0x0080 }
            long r1 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x00f3, ConnectTimeoutException -> 0x00eb, MalformedURLException -> 0x00d2, IOException -> 0x007d }
            long r3 = r1 - r9
            r1 = r17
            r2 = r3
            r4 = r18
            r16 = r5
            r1.a(r2, r4, r5, r6)     // Catch:{ SocketTimeoutException -> 0x00f3, ConnectTimeoutException -> 0x00eb, MalformedURLException -> 0x00d2, IOException -> 0x0078 }
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 == r1) goto L_0x006e
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 != r1) goto L_0x0063
            goto L_0x006e
        L_0x0063:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ SocketTimeoutException -> 0x00f3, ConnectTimeoutException -> 0x00eb, MalformedURLException -> 0x00d2, IOException -> 0x0069 }
            r0.<init>()     // Catch:{ SocketTimeoutException -> 0x00f3, ConnectTimeoutException -> 0x00eb, MalformedURLException -> 0x00d2, IOException -> 0x0069 }
            throw r0     // Catch:{ SocketTimeoutException -> 0x00f3, ConnectTimeoutException -> 0x00eb, MalformedURLException -> 0x00d2, IOException -> 0x0069 }
        L_0x0069:
            r0 = move-exception
            r1 = r15
            r5 = r16
            goto L_0x008a
        L_0x006e:
            com.android.volley.g r1 = new com.android.volley.g     // Catch:{ SocketTimeoutException -> 0x00f3, ConnectTimeoutException -> 0x00eb, MalformedURLException -> 0x00d2, IOException -> 0x0078 }
            r2 = r16
            r1.<init>(r0, r2, r15, r12)     // Catch:{ SocketTimeoutException -> 0x00f3, ConnectTimeoutException -> 0x00eb, MalformedURLException -> 0x00d2, IOException -> 0x0076 }
            return r1
        L_0x0076:
            r0 = move-exception
            goto L_0x007b
        L_0x0078:
            r0 = move-exception
            r2 = r16
        L_0x007b:
            r5 = r2
            goto L_0x0082
        L_0x007d:
            r0 = move-exception
            r2 = r5
            goto L_0x0082
        L_0x0080:
            r0 = move-exception
            r5 = r13
        L_0x0082:
            r1 = r15
            goto L_0x008a
        L_0x0084:
            r0 = move-exception
            r5 = r13
            goto L_0x008a
        L_0x0087:
            r0 = move-exception
            r5 = r13
            r14 = r5
        L_0x008a:
            if (r14 == 0) goto L_0x00cc
            org.apache.http.StatusLine r0 = r14.getStatusLine()
            int r0 = r0.getStatusCode()
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            r2[r12] = r3
            java.lang.String r3 = r18.c()
            r2[r11] = r3
            java.lang.String r3 = "Unexpected response code %d for %s"
            com.android.volley.l.c(r3, r2)
            if (r5 == 0) goto L_0x00c6
            com.android.volley.g r2 = new com.android.volley.g
            r2.<init>(r0, r5, r1, r12)
            r1 = 401(0x191, float:5.62E-43)
            if (r0 == r1) goto L_0x00be
            r1 = 403(0x193, float:5.65E-43)
            if (r0 != r1) goto L_0x00b8
            goto L_0x00be
        L_0x00b8:
            com.android.volley.ServerError r0 = new com.android.volley.ServerError
            r0.<init>(r2)
            throw r0
        L_0x00be:
            com.android.volley.AuthFailureError r0 = new com.android.volley.AuthFailureError
            r0.<init>(r2)
            java.lang.String r1 = "auth"
            goto L_0x00fa
        L_0x00c6:
            com.android.volley.NetworkError r0 = new com.android.volley.NetworkError
            r0.<init>((com.android.volley.g) r13)
            throw r0
        L_0x00cc:
            com.android.volley.NoConnectionError r1 = new com.android.volley.NoConnectionError
            r1.<init>(r0)
            throw r1
        L_0x00d2:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Bad URL "
            r2.<init>(r3)
            java.lang.String r3 = r18.c()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2, r0)
            throw r1
        L_0x00eb:
            com.android.volley.TimeoutError r0 = new com.android.volley.TimeoutError
            r0.<init>()
            java.lang.String r1 = "connection"
            goto L_0x00fa
        L_0x00f3:
            com.android.volley.TimeoutError r0 = new com.android.volley.TimeoutError
            r0.<init>()
            java.lang.String r1 = "socket"
        L_0x00fa:
            a(r1, r8, r0)
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.a.a(com.android.volley.Request):com.android.volley.g");
    }
}
