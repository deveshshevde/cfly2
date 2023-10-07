package com.lidroid.xutils.http.client;

import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;

public class b implements HttpRequestRetryHandler {

    /* renamed from: a  reason: collision with root package name */
    private static HashSet<Class<?>> f21082a = new HashSet<>();

    /* renamed from: b  reason: collision with root package name */
    private static HashSet<Class<?>> f21083b = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    private final int f21084c;

    static {
        f21082a.add(NoHttpResponseException.class);
        f21082a.add(UnknownHostException.class);
        f21082a.add(SocketException.class);
        f21083b.add(InterruptedIOException.class);
        f21083b.add(SSLHandshakeException.class);
    }

    public b(int i2) {
        this.f21084c = i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x006b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean retryRequest(java.io.IOException r5, int r6, org.apache.http.protocol.HttpContext r7) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L_0x0070
            if (r7 != 0) goto L_0x0007
            goto L_0x0070
        L_0x0007:
            java.lang.String r1 = "http.request_sent"
            java.lang.Object r1 = r7.getAttribute(r1)
            if (r1 != 0) goto L_0x0011
            r1 = 0
            goto L_0x0017
        L_0x0011:
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
        L_0x0017:
            int r2 = r4.f21084c
            r3 = 1
            if (r6 <= r2) goto L_0x001e
        L_0x001c:
            r3 = 0
            goto L_0x0035
        L_0x001e:
            java.util.HashSet<java.lang.Class<?>> r6 = f21083b
            java.lang.Class r2 = r5.getClass()
            boolean r6 = r6.contains(r2)
            if (r6 == 0) goto L_0x002b
            goto L_0x001c
        L_0x002b:
            java.util.HashSet<java.lang.Class<?>> r6 = f21082a
            java.lang.Class r5 = r5.getClass()
            boolean r5 = r6.contains(r5)
        L_0x0035:
            if (r3 == 0) goto L_0x0068
            java.lang.String r5 = "http.request"
            java.lang.Object r5 = r7.getAttribute(r5)     // Catch:{ all -> 0x0061 }
            if (r5 == 0) goto L_0x005b
            boolean r6 = r5 instanceof org.apache.http.client.methods.HttpRequestBase     // Catch:{ all -> 0x0061 }
            java.lang.String r7 = "GET"
            if (r6 == 0) goto L_0x0050
            org.apache.http.client.methods.HttpRequestBase r5 = (org.apache.http.client.methods.HttpRequestBase) r5     // Catch:{ all -> 0x0061 }
            java.lang.String r5 = r5.getMethod()     // Catch:{ all -> 0x0061 }
        L_0x004b:
            boolean r0 = r7.equals(r5)     // Catch:{ all -> 0x0061 }
            goto L_0x0069
        L_0x0050:
            boolean r6 = r5 instanceof org.apache.http.impl.client.RequestWrapper     // Catch:{ all -> 0x0061 }
            if (r6 == 0) goto L_0x0068
            org.apache.http.impl.client.RequestWrapper r5 = (org.apache.http.impl.client.RequestWrapper) r5     // Catch:{ all -> 0x0061 }
            java.lang.String r5 = r5.getMethod()     // Catch:{ all -> 0x0061 }
            goto L_0x004b
        L_0x005b:
            java.lang.String r5 = "retry error, curr request is null"
            il.c.b(r5)     // Catch:{ all -> 0x0061 }
            goto L_0x0069
        L_0x0061:
            r5 = move-exception
            java.lang.String r6 = "retry error"
            il.c.a(r6, r5)
            goto L_0x0069
        L_0x0068:
            r0 = r3
        L_0x0069:
            if (r0 == 0) goto L_0x0070
            r5 = 500(0x1f4, double:2.47E-321)
            android.os.SystemClock.sleep(r5)
        L_0x0070:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lidroid.xutils.http.client.b.retryRequest(java.io.IOException, int, org.apache.http.protocol.HttpContext):boolean");
    }
}
