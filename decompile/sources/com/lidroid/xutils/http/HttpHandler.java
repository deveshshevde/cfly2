package com.lidroid.xutils.http;

import android.os.SystemClock;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.task.b;
import ih.c;
import ih.d;
import ih.e;
import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

public class HttpHandler<T> extends b<Object, Object, Void> implements e {

    /* renamed from: s  reason: collision with root package name */
    private static final a f21012s = new a((a) null);

    /* renamed from: b  reason: collision with root package name */
    private final AbstractHttpClient f21013b;

    /* renamed from: c  reason: collision with root package name */
    private final HttpContext f21014c;

    /* renamed from: d  reason: collision with root package name */
    private c f21015d;

    /* renamed from: e  reason: collision with root package name */
    private String f21016e;

    /* renamed from: f  reason: collision with root package name */
    private String f21017f;

    /* renamed from: g  reason: collision with root package name */
    private HttpRequestBase f21018g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f21019h = true;

    /* renamed from: i  reason: collision with root package name */
    private d<T> f21020i;

    /* renamed from: j  reason: collision with root package name */
    private int f21021j = 0;

    /* renamed from: k  reason: collision with root package name */
    private String f21022k = null;

    /* renamed from: l  reason: collision with root package name */
    private boolean f21023l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f21024m = false;

    /* renamed from: n  reason: collision with root package name */
    private boolean f21025n = false;

    /* renamed from: o  reason: collision with root package name */
    private String f21026o;

    /* renamed from: p  reason: collision with root package name */
    private State f21027p = State.WAITING;

    /* renamed from: q  reason: collision with root package name */
    private long f21028q = a.a();

    /* renamed from: r  reason: collision with root package name */
    private long f21029r;

    public enum State {
        WAITING(0),
        STARTED(1),
        LOADING(2),
        FAILURE(3),
        CANCELLED(4),
        SUCCESS(5);
        

        /* renamed from: g  reason: collision with root package name */
        private int f21037g;

        private State(int i2) {
            this.f21037g = 0;
            this.f21037g = i2;
        }
    }

    private static final class a implements RedirectHandler {
        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        public URI getLocationURI(HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
            return null;
        }

        public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
            return false;
        }
    }

    public HttpHandler(AbstractHttpClient abstractHttpClient, HttpContext httpContext, String str, d<T> dVar) {
        this.f21013b = abstractHttpClient;
        this.f21014c = httpContext;
        this.f21020i = dVar;
        this.f21026o = str;
        abstractHttpClient.setRedirectHandler(f21012s);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.Object} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.lidroid.xutils.http.c<T> a(org.apache.http.HttpResponse r11) throws com.lidroid.xutils.exception.HttpException, java.io.IOException {
        /*
            r10 = this;
            if (r11 == 0) goto L_0x00a9
            boolean r0 = r10.c()
            r1 = 0
            if (r0 == 0) goto L_0x000a
            return r1
        L_0x000a:
            org.apache.http.StatusLine r0 = r11.getStatusLine()
            int r2 = r0.getStatusCode()
            r3 = 300(0x12c, float:4.2E-43)
            if (r2 >= r3) goto L_0x0071
            org.apache.http.HttpEntity r5 = r11.getEntity()
            r0 = 0
            if (r5 == 0) goto L_0x006b
            r10.f21019h = r0
            boolean r2 = r10.f21023l
            if (r2 == 0) goto L_0x004a
            boolean r2 = r10.f21024m
            if (r2 == 0) goto L_0x002f
            boolean r2 = il.d.a((org.apache.http.HttpResponse) r11)
            if (r2 == 0) goto L_0x002f
            r2 = 1
            goto L_0x0030
        L_0x002f:
            r2 = 0
        L_0x0030:
            r10.f21024m = r2
            boolean r2 = r10.f21025n
            if (r2 == 0) goto L_0x003a
            java.lang.String r1 = il.d.b(r11)
        L_0x003a:
            r9 = r1
            ih.b r4 = new ih.b
            r4.<init>()
            java.lang.String r7 = r10.f21022k
            boolean r8 = r10.f21024m
            r6 = r10
            java.io.File r1 = r4.a(r5, r6, r7, r8, r9)
            goto L_0x006b
        L_0x004a:
            ih.f r1 = new ih.f
            r1.<init>()
            java.lang.String r2 = r10.f21026o
            java.lang.String r1 = r1.a(r5, r10, r2)
            com.lidroid.xutils.http.a r2 = ig.a.f13546a
            java.lang.String r3 = r10.f21017f
            boolean r2 = r2.b(r3)
            if (r2 == 0) goto L_0x006b
            com.lidroid.xutils.http.a r2 = ig.a.f13546a
            java.lang.String r3 = r10.f21016e
            r4 = r1
            java.lang.String r4 = (java.lang.String) r4
            long r5 = r10.f21028q
            r2.a(r3, r4, r5)
        L_0x006b:
            com.lidroid.xutils.http.c r2 = new com.lidroid.xutils.http.c
            r2.<init>(r11, r1, r0)
            return r2
        L_0x0071:
            r3 = 301(0x12d, float:4.22E-43)
            if (r2 == r3) goto L_0x0090
            r3 = 302(0x12e, float:4.23E-43)
            if (r2 != r3) goto L_0x007a
            goto L_0x0090
        L_0x007a:
            r11 = 416(0x1a0, float:5.83E-43)
            if (r2 != r11) goto L_0x0086
            com.lidroid.xutils.exception.HttpException r11 = new com.lidroid.xutils.exception.HttpException
            java.lang.String r0 = "maybe the file has downloaded completely"
            r11.<init>(r2, r0)
            throw r11
        L_0x0086:
            com.lidroid.xutils.exception.HttpException r11 = new com.lidroid.xutils.exception.HttpException
            java.lang.String r0 = r0.getReasonPhrase()
            r11.<init>(r2, r0)
            throw r11
        L_0x0090:
            ih.c r0 = r10.f21015d
            if (r0 != 0) goto L_0x009b
            ih.a r0 = new ih.a
            r0.<init>()
            r10.f21015d = r0
        L_0x009b:
            ih.c r0 = r10.f21015d
            org.apache.http.client.methods.HttpRequestBase r11 = r0.a(r11)
            if (r11 == 0) goto L_0x00a8
            com.lidroid.xutils.http.c r11 = r10.a((org.apache.http.client.methods.HttpRequestBase) r11)
            return r11
        L_0x00a8:
            return r1
        L_0x00a9:
            com.lidroid.xutils.exception.HttpException r11 = new com.lidroid.xutils.exception.HttpException
            java.lang.String r0 = "response is null"
            r11.<init>((java.lang.String) r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lidroid.xutils.http.HttpHandler.a(org.apache.http.HttpResponse):com.lidroid.xutils.http.c");
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b3 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.lidroid.xutils.http.c<T> a(org.apache.http.client.methods.HttpRequestBase r7) throws com.lidroid.xutils.exception.HttpException {
        /*
            r6 = this;
            org.apache.http.impl.client.AbstractHttpClient r0 = r6.f21013b
            org.apache.http.client.HttpRequestRetryHandler r0 = r0.getHttpRequestRetryHandler()
        L_0x0006:
            boolean r1 = r6.f21024m
            if (r1 == 0) goto L_0x0045
            boolean r1 = r6.f21023l
            if (r1 == 0) goto L_0x0045
            java.io.File r1 = new java.io.File
            java.lang.String r2 = r6.f21022k
            r1.<init>(r2)
            boolean r2 = r1.isFile()
            r3 = 0
            if (r2 == 0) goto L_0x0028
            boolean r2 = r1.exists()
            if (r2 == 0) goto L_0x0028
            long r1 = r1.length()
            goto L_0x0029
        L_0x0028:
            r1 = r3
        L_0x0029:
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0045
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "bytes="
            r3.<init>(r4)
            r3.append(r1)
            java.lang.String r1 = "-"
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.lang.String r2 = "RANGE"
            r7.setHeader(r2, r1)
        L_0x0045:
            r1 = 1
            java.lang.String r2 = r7.getMethod()     // Catch:{ UnknownHostException -> 0x00a2, IOException -> 0x00a0, NullPointerException -> 0x0087, HttpException -> 0x0085, all -> 0x007a }
            r6.f21017f = r2     // Catch:{ UnknownHostException -> 0x00a2, IOException -> 0x00a0, NullPointerException -> 0x0087, HttpException -> 0x0085, all -> 0x007a }
            com.lidroid.xutils.http.a r2 = ig.a.f13546a     // Catch:{ UnknownHostException -> 0x00a2, IOException -> 0x00a0, NullPointerException -> 0x0087, HttpException -> 0x0085, all -> 0x007a }
            java.lang.String r3 = r6.f21017f     // Catch:{ UnknownHostException -> 0x00a2, IOException -> 0x00a0, NullPointerException -> 0x0087, HttpException -> 0x0085, all -> 0x007a }
            boolean r2 = r2.b(r3)     // Catch:{ UnknownHostException -> 0x00a2, IOException -> 0x00a0, NullPointerException -> 0x0087, HttpException -> 0x0085, all -> 0x007a }
            r3 = 0
            if (r2 == 0) goto L_0x0067
            com.lidroid.xutils.http.a r2 = ig.a.f13546a     // Catch:{ UnknownHostException -> 0x00a2, IOException -> 0x00a0, NullPointerException -> 0x0087, HttpException -> 0x0085, all -> 0x007a }
            java.lang.String r4 = r6.f21016e     // Catch:{ UnknownHostException -> 0x00a2, IOException -> 0x00a0, NullPointerException -> 0x0087, HttpException -> 0x0085, all -> 0x007a }
            java.lang.String r2 = r2.a(r4)     // Catch:{ UnknownHostException -> 0x00a2, IOException -> 0x00a0, NullPointerException -> 0x0087, HttpException -> 0x0085, all -> 0x007a }
            if (r2 == 0) goto L_0x0067
            com.lidroid.xutils.http.c r4 = new com.lidroid.xutils.http.c     // Catch:{ UnknownHostException -> 0x00a2, IOException -> 0x00a0, NullPointerException -> 0x0087, HttpException -> 0x0085, all -> 0x007a }
            r4.<init>(r3, r2, r1)     // Catch:{ UnknownHostException -> 0x00a2, IOException -> 0x00a0, NullPointerException -> 0x0087, HttpException -> 0x0085, all -> 0x007a }
            return r4
        L_0x0067:
            boolean r2 = r6.c()     // Catch:{ UnknownHostException -> 0x00a2, IOException -> 0x00a0, NullPointerException -> 0x0087, HttpException -> 0x0085, all -> 0x007a }
            if (r2 != 0) goto L_0x0079
            org.apache.http.impl.client.AbstractHttpClient r2 = r6.f21013b     // Catch:{ UnknownHostException -> 0x00a2, IOException -> 0x00a0, NullPointerException -> 0x0087, HttpException -> 0x0085, all -> 0x007a }
            org.apache.http.protocol.HttpContext r3 = r6.f21014c     // Catch:{ UnknownHostException -> 0x00a2, IOException -> 0x00a0, NullPointerException -> 0x0087, HttpException -> 0x0085, all -> 0x007a }
            org.apache.http.HttpResponse r2 = r2.execute(r7, r3)     // Catch:{ UnknownHostException -> 0x00a2, IOException -> 0x00a0, NullPointerException -> 0x0087, HttpException -> 0x0085, all -> 0x007a }
            com.lidroid.xutils.http.c r3 = r6.a((org.apache.http.HttpResponse) r2)     // Catch:{ UnknownHostException -> 0x00a2, IOException -> 0x00a0, NullPointerException -> 0x0087, HttpException -> 0x0085, all -> 0x007a }
        L_0x0079:
            return r3
        L_0x007a:
            r2 = move-exception
            java.io.IOException r3 = new java.io.IOException
            java.lang.String r4 = r2.getMessage()
            r3.<init>(r4)
            goto L_0x0091
        L_0x0085:
            r7 = move-exception
            throw r7
        L_0x0087:
            r2 = move-exception
            java.io.IOException r3 = new java.io.IOException
            java.lang.String r4 = r2.getMessage()
            r3.<init>(r4)
        L_0x0091:
            r3.initCause(r2)
            int r2 = r6.f21021j
            int r2 = r2 + r1
            r6.f21021j = r2
            org.apache.http.protocol.HttpContext r1 = r6.f21014c
            boolean r1 = r0.retryRequest(r3, r2, r1)
            goto L_0x00af
        L_0x00a0:
            r2 = move-exception
            goto L_0x00a3
        L_0x00a2:
            r2 = move-exception
        L_0x00a3:
            int r3 = r6.f21021j
            int r3 = r3 + r1
            r6.f21021j = r3
            org.apache.http.protocol.HttpContext r1 = r6.f21014c
            boolean r1 = r0.retryRequest(r2, r3, r1)
            r3 = r2
        L_0x00af:
            if (r1 == 0) goto L_0x00b3
            goto L_0x0006
        L_0x00b3:
            com.lidroid.xutils.exception.HttpException r7 = new com.lidroid.xutils.exception.HttpException
            r7.<init>((java.lang.Throwable) r3)
            goto L_0x00ba
        L_0x00b9:
            throw r7
        L_0x00ba:
            goto L_0x00b9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lidroid.xutils.http.HttpHandler.a(org.apache.http.client.methods.HttpRequestBase):com.lidroid.xutils.http.c");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Void c(Object... objArr) {
        if (!(this.f21027p == State.CANCELLED || objArr == null || objArr.length == 0)) {
            if (objArr.length > 3) {
                String valueOf = String.valueOf(objArr[1]);
                this.f21022k = valueOf;
                this.f21023l = valueOf != null;
                this.f21024m = objArr[2].booleanValue();
                this.f21025n = objArr[3].booleanValue();
            }
            try {
                if (this.f21027p == State.CANCELLED) {
                    return null;
                }
                HttpRequestBase httpRequestBase = objArr[0];
                this.f21018g = httpRequestBase;
                String uri = httpRequestBase.getURI().toString();
                this.f21016e = uri;
                d<T> dVar = this.f21020i;
                if (dVar != null) {
                    dVar.a(uri);
                }
                d((Progress[]) new Object[]{1});
                this.f21029r = SystemClock.uptimeMillis();
                c a2 = a(this.f21018g);
                if (a2 != null) {
                    d((Progress[]) new Object[]{4, a2});
                    return null;
                }
            } catch (HttpException e2) {
                d((Progress[]) new Object[]{3, e2, e2.getMessage()});
            }
        }
        return null;
    }

    public void a(long j2) {
        this.f21028q = j2;
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.f21015d = cVar;
        }
    }

    public boolean a(long j2, long j3, boolean z2) {
        if (!(this.f21020i == null || this.f21027p == State.CANCELLED)) {
            if (z2) {
                d((Progress[]) new Object[]{2, Long.valueOf(j2), Long.valueOf(j3)});
            } else {
                long uptimeMillis = SystemClock.uptimeMillis();
                if (uptimeMillis - this.f21029r >= ((long) this.f21020i.a())) {
                    this.f21029r = uptimeMillis;
                    d((Progress[]) new Object[]{2, Long.valueOf(j2), Long.valueOf(j3)});
                }
            }
        }
        return this.f21027p != State.CANCELLED;
    }

    /* access modifiers changed from: protected */
    public void b(Object... objArr) {
        if (this.f21027p != State.CANCELLED && objArr != null && objArr.length != 0 && this.f21020i != null) {
            int intValue = objArr[0].intValue();
            if (intValue == 1) {
                this.f21027p = State.STARTED;
                this.f21020i.b();
            } else if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue == 4 && objArr.length == 2) {
                        this.f21027p = State.SUCCESS;
                        this.f21020i.a(objArr[1]);
                    }
                } else if (objArr.length == 3) {
                    this.f21027p = State.FAILURE;
                    this.f21020i.a(objArr[1], objArr[2]);
                }
            } else if (objArr.length == 3) {
                this.f21027p = State.LOADING;
                this.f21020i.a(Long.valueOf(String.valueOf(objArr[1])).longValue(), Long.valueOf(String.valueOf(objArr[2])).longValue(), this.f21019h);
            }
        }
    }
}
