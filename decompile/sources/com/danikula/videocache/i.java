package com.danikula.videocache;

import android.text.TextUtils;
import db.a;
import db.b;
import dc.c;
import dc.d;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class i implements o {

    /* renamed from: a  reason: collision with root package name */
    private final c f11066a;

    /* renamed from: b  reason: collision with root package name */
    private final b f11067b;

    /* renamed from: c  reason: collision with root package name */
    private p f11068c;

    /* renamed from: d  reason: collision with root package name */
    private HttpURLConnection f11069d;

    /* renamed from: e  reason: collision with root package name */
    private InputStream f11070e;

    public i(i iVar) {
        this.f11068c = iVar.f11068c;
        this.f11066a = iVar.f11066a;
        this.f11067b = iVar.f11067b;
    }

    public i(String str) {
        this(str, d.a());
    }

    public i(String str, c cVar) {
        this(str, cVar, new a());
    }

    public i(String str, c cVar, b bVar) {
        this.f11066a = (c) l.a(cVar);
        this.f11067b = (b) l.a(bVar);
        p a2 = cVar.a(str);
        this.f11068c = a2 == null ? new p(str, -2147483648L, n.a(str)) : a2;
    }

    private long a(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1;
        }
        return Long.parseLong(headerField);
    }

    private long a(HttpURLConnection httpURLConnection, long j2, int i2) throws IOException {
        long a2 = a(httpURLConnection);
        return i2 == 200 ? a2 : i2 == 206 ? a2 + j2 : this.f11068c.f11092b;
    }

    private HttpURLConnection a(long j2, int i2) throws IOException, ProxyCacheException {
        boolean z2;
        HttpURLConnection httpURLConnection;
        String str = this.f11068c.f11091a;
        int i3 = 0;
        do {
            z2 = true;
            if (str.startsWith("https")) {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new HostnameVerifier() {
                    public boolean verify(String str, SSLSession sSLSession) {
                        return true;
                    }
                });
                TrustManager[] trustManagerArr = {new X509TrustManager() {
                    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                    }

                    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                    }

                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                }};
                try {
                    SSLContext instance = SSLContext.getInstance("SSL");
                    instance.init((KeyManager[]) null, trustManagerArr, new SecureRandom());
                    ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(instance.getSocketFactory());
                    ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new HostnameVerifier() {
                        public boolean verify(String str, SSLSession sSLSession) {
                            return true;
                        }
                    });
                } catch (NoSuchAlgorithmException e2) {
                    e2.printStackTrace();
                } catch (KeyManagementException e3) {
                    e3.printStackTrace();
                }
            } else {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            }
            a(httpURLConnection, str);
            if (j2 > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j2 + "-");
            }
            if (i2 > 0) {
                httpURLConnection.setConnectTimeout(i2);
                httpURLConnection.setReadTimeout(i2);
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (!(responseCode == 301 || responseCode == 302 || responseCode == 303)) {
                z2 = false;
            }
            if (z2) {
                str = httpURLConnection.getHeaderField("Location");
                i3++;
                httpURLConnection.disconnect();
            }
            if (i3 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i3);
            }
        } while (z2);
        return httpURLConnection;
    }

    private void a(HttpURLConnection httpURLConnection, String str) {
        Map<String, String> a2 = this.f11067b.a(str);
        if (a2 != null) {
            f.c("****** injectCustomHeaders ****** :" + a2.size());
            for (Map.Entry next : a2.entrySet()) {
                httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e() throws com.danikula.videocache.ProxyCacheException {
        /*
            r7 = this;
            r0 = 0
            r2 = 10000(0x2710, float:1.4013E-41)
            r3 = 0
            java.net.HttpURLConnection r0 = r7.a((long) r0, (int) r2)     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
            long r1 = r7.a((java.net.HttpURLConnection) r0)     // Catch:{ IOException -> 0x0031 }
            java.lang.String r4 = r0.getContentType()     // Catch:{ IOException -> 0x0031 }
            java.io.InputStream r3 = r0.getInputStream()     // Catch:{ IOException -> 0x0031 }
            com.danikula.videocache.p r5 = new com.danikula.videocache.p     // Catch:{ IOException -> 0x0031 }
            com.danikula.videocache.p r6 = r7.f11068c     // Catch:{ IOException -> 0x0031 }
            java.lang.String r6 = r6.f11091a     // Catch:{ IOException -> 0x0031 }
            r5.<init>(r6, r1, r4)     // Catch:{ IOException -> 0x0031 }
            r7.f11068c = r5     // Catch:{ IOException -> 0x0031 }
            dc.c r1 = r7.f11066a     // Catch:{ IOException -> 0x0031 }
            java.lang.String r2 = r5.f11091a     // Catch:{ IOException -> 0x0031 }
            com.danikula.videocache.p r4 = r7.f11068c     // Catch:{ IOException -> 0x0031 }
            r1.a(r2, r4)     // Catch:{ IOException -> 0x0031 }
            com.danikula.videocache.n.a((java.io.Closeable) r3)
            if (r0 == 0) goto L_0x0058
            goto L_0x0055
        L_0x002f:
            r1 = move-exception
            goto L_0x0059
        L_0x0031:
            r1 = move-exception
            goto L_0x0038
        L_0x0033:
            r1 = move-exception
            r0 = r3
            goto L_0x0059
        L_0x0036:
            r1 = move-exception
            r0 = r3
        L_0x0038:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x002f }
            r2.<init>()     // Catch:{ all -> 0x002f }
            java.lang.String r4 = "Error fetching info from "
            r2.append(r4)     // Catch:{ all -> 0x002f }
            com.danikula.videocache.p r4 = r7.f11068c     // Catch:{ all -> 0x002f }
            java.lang.String r4 = r4.f11091a     // Catch:{ all -> 0x002f }
            r2.append(r4)     // Catch:{ all -> 0x002f }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x002f }
            com.danikula.videocache.f.a((java.lang.String) r2, (java.lang.Exception) r1)     // Catch:{ all -> 0x002f }
            com.danikula.videocache.n.a((java.io.Closeable) r3)
            if (r0 == 0) goto L_0x0058
        L_0x0055:
            r0.disconnect()
        L_0x0058:
            return
        L_0x0059:
            com.danikula.videocache.n.a((java.io.Closeable) r3)
            if (r0 == 0) goto L_0x0061
            r0.disconnect()
        L_0x0061:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danikula.videocache.i.e():void");
    }

    public int a(byte[] bArr) throws ProxyCacheException {
        InputStream inputStream = this.f11070e;
        if (inputStream != null) {
            try {
                return inputStream.read(bArr, 0, bArr.length);
            } catch (InterruptedIOException e2) {
                throw new InterruptedProxyCacheException("Reading source " + this.f11068c.f11091a + " is interrupted", e2);
            } catch (IOException e3) {
                throw new ProxyCacheException("Error reading data from " + this.f11068c.f11091a, e3);
            }
        } else {
            throw new ProxyCacheException("Error reading data from " + this.f11068c.f11091a + ": connection is absent!");
        }
    }

    public synchronized long a() throws ProxyCacheException {
        if (this.f11068c.f11092b == -2147483648L) {
            e();
        }
        return this.f11068c.f11092b;
    }

    public void a(long j2) throws ProxyCacheException {
        try {
            HttpURLConnection a2 = a(j2, -1);
            this.f11069d = a2;
            String contentType = a2.getContentType();
            this.f11070e = new BufferedInputStream(this.f11069d.getInputStream(), 8192);
            HttpURLConnection httpURLConnection = this.f11069d;
            p pVar = new p(this.f11068c.f11091a, a(httpURLConnection, j2, httpURLConnection.getResponseCode()), contentType);
            this.f11068c = pVar;
            this.f11066a.a(pVar.f11091a, this.f11068c);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error opening connection for " + this.f11068c.f11091a + " with offset " + j2, e2);
        }
    }

    public void b() throws ProxyCacheException {
        HttpURLConnection httpURLConnection = this.f11069d;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (IllegalArgumentException | NullPointerException e2) {
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e2);
            } catch (ArrayIndexOutOfBoundsException e3) {
                f.a("Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue :(", (Exception) e3);
            }
        }
    }

    public synchronized String c() throws ProxyCacheException {
        if (TextUtils.isEmpty(this.f11068c.f11093c)) {
            e();
        }
        return this.f11068c.f11093c;
    }

    public String d() {
        return this.f11068c.f11091a;
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.f11068c + "}";
    }
}
