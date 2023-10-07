package com.amap.api.mapcore.util;

import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.mapcore.util.gw;
import com.amap.api.mapcore.util.hd;
import com.amap.api.maps.AMapException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.SoftReference;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSession;
import org.apache.http.conn.ConnectTimeoutException;

public final class ha {

    /* renamed from: k  reason: collision with root package name */
    private static SoftReference<SSLContext> f9020k;

    /* renamed from: t  reason: collision with root package name */
    private static SoftReference<hb> f9021t;

    /* renamed from: a  reason: collision with root package name */
    private boolean f9022a;

    /* renamed from: b  reason: collision with root package name */
    private SSLContext f9023b;

    /* renamed from: c  reason: collision with root package name */
    private Proxy f9024c;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f9025d = false;

    /* renamed from: e  reason: collision with root package name */
    private long f9026e = -1;

    /* renamed from: f  reason: collision with root package name */
    private long f9027f = 0;

    /* renamed from: g  reason: collision with root package name */
    private String f9028g;

    /* renamed from: h  reason: collision with root package name */
    private gw.a f9029h;

    /* renamed from: i  reason: collision with root package name */
    private d f9030i;

    /* renamed from: j  reason: collision with root package name */
    private String f9031j = "";

    /* renamed from: l  reason: collision with root package name */
    private boolean f9032l;

    /* renamed from: m  reason: collision with root package name */
    private String f9033m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public String f9034n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f9035o = false;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public boolean f9036p = false;

    /* renamed from: q  reason: collision with root package name */
    private String f9037q = "";

    /* renamed from: r  reason: collision with root package name */
    private String f9038r = "";

    /* renamed from: s  reason: collision with root package name */
    private String f9039s = "";

    /* renamed from: u  reason: collision with root package name */
    private f f9040u = new f();

    public static class a implements Cloneable, Comparable {

        /* renamed from: a  reason: collision with root package name */
        public int f9041a;

        /* renamed from: b  reason: collision with root package name */
        public String f9042b;

        /* renamed from: c  reason: collision with root package name */
        public String f9043c;

        /* renamed from: d  reason: collision with root package name */
        public String f9044d;

        /* renamed from: e  reason: collision with root package name */
        public String f9045e;

        /* renamed from: f  reason: collision with root package name */
        public int f9046f;

        /* renamed from: g  reason: collision with root package name */
        public int f9047g;

        /* renamed from: h  reason: collision with root package name */
        public int f9048h;

        /* renamed from: i  reason: collision with root package name */
        public long f9049i;

        /* renamed from: j  reason: collision with root package name */
        public volatile AtomicInteger f9050j = new AtomicInteger(1);

        public a(c cVar) {
            this.f9042b = cVar.f9055c;
            this.f9043c = cVar.f9057e;
            this.f9045e = cVar.f9056d;
            this.f9046f = cVar.f9065m;
            this.f9047g = cVar.f9066n;
            this.f9048h = cVar.f9054b.a();
            this.f9044d = cVar.f9053a;
            this.f9049i = cVar.f9058f;
            if (this.f9046f == 10) {
                this.f9041a = 0;
            }
        }

        /* renamed from: a */
        public final a clone() {
            try {
                return (a) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }

        public final String b() {
            StringBuilder sb;
            StringBuilder sb2;
            StringBuilder sb3;
            StringBuilder sb4;
            try {
                String str = this.f9046f + "#";
                if (!TextUtils.isEmpty(this.f9045e)) {
                    sb = new StringBuilder();
                    sb.append(str);
                    sb.append(this.f9045e);
                    sb.append("#");
                } else {
                    sb = new StringBuilder();
                    sb.append(str);
                    sb.append("-#");
                }
                String str2 = (sb.toString() + this.f9048h + "#") + this.f9050j + "#";
                if (!TextUtils.isEmpty(this.f9042b)) {
                    sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append(this.f9042b);
                    sb2.append("#");
                } else {
                    sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append("-#");
                }
                String sb5 = sb2.toString();
                if (this.f9046f == 1) {
                    sb3 = new StringBuilder();
                    sb3.append(sb5);
                    sb3.append(this.f9044d);
                    sb3.append("#");
                } else {
                    sb3 = new StringBuilder();
                    sb3.append(sb5);
                    sb3.append("-#");
                }
                String sb6 = sb3.toString();
                if (this.f9046f == 1) {
                    sb4 = new StringBuilder();
                    sb4.append(sb6);
                    sb4.append(this.f9049i);
                    sb4.append("#");
                } else {
                    sb4 = new StringBuilder();
                    sb4.append(sb6);
                    sb4.append("-#");
                }
                String str3 = (sb4.toString() + this.f9043c + "#") + this.f9047g;
                String b2 = fa.b(gm.a(str3.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                StringBuilder sb7 = new StringBuilder("上报异常数据");
                sb7.append(str3);
                sb7.append("加密后：");
                sb7.append(b2);
                ha.b();
                return b2;
            } catch (Exception unused) {
                return null;
            }
        }

        public final int compareTo(Object obj) {
            return this.f9041a - ((a) obj).f9041a;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public HttpURLConnection f9051a;

        /* renamed from: b  reason: collision with root package name */
        public int f9052b = this.f9052b;

        public b(HttpURLConnection httpURLConnection) {
            this.f9051a = httpURLConnection;
        }
    }

    public static class c implements Cloneable {

        /* renamed from: a  reason: collision with root package name */
        public String f9053a = "";

        /* renamed from: b  reason: collision with root package name */
        public hd.b f9054b = hd.b.FIRST_NONDEGRADE;

        /* renamed from: c  reason: collision with root package name */
        public String f9055c = "";

        /* renamed from: d  reason: collision with root package name */
        public String f9056d = "";

        /* renamed from: e  reason: collision with root package name */
        public String f9057e = "";

        /* renamed from: f  reason: collision with root package name */
        public long f9058f = 0;

        /* renamed from: g  reason: collision with root package name */
        public long f9059g = 0;

        /* renamed from: h  reason: collision with root package name */
        public long f9060h = 0;

        /* renamed from: i  reason: collision with root package name */
        public long f9061i = 0;

        /* renamed from: j  reason: collision with root package name */
        public long f9062j = 0;

        /* renamed from: k  reason: collision with root package name */
        public String f9063k = "-";

        /* renamed from: l  reason: collision with root package name */
        public String f9064l = "-";

        /* renamed from: m  reason: collision with root package name */
        public int f9065m = 0;

        /* renamed from: n  reason: collision with root package name */
        public int f9066n = 0;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final c clone() {
            try {
                return (c) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public final String b() {
            String str;
            String str2;
            if (!TextUtils.isEmpty(this.f9055c)) {
                str = this.f9055c + "#";
            } else {
                str = "-#";
            }
            if (!TextUtils.isEmpty(this.f9056d)) {
                str2 = str + this.f9056d + "#";
            } else {
                str2 = str + "-#";
            }
            String str3 = (((str2 + this.f9054b.a() + "#") + this.f9060h + "#") + this.f9062j + "#") + this.f9058f;
            String b2 = fa.b(gm.a(str3.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
            StringBuilder sb = new StringBuilder("上报耗时数据");
            sb.append(str3);
            sb.append("加密后：");
            sb.append(b2);
            ha.b();
            return b2;
        }

        public final String toString() {
            return "RequestInfo{csid='" + this.f9053a + '\'' + ", degradeType=" + this.f9054b + ", serverIp='" + this.f9055c + '\'' + ", path='" + this.f9056d + '\'' + ", hostname='" + this.f9057e + '\'' + ", totalTime=" + this.f9058f + ", DNSTime=" + this.f9059g + ", connectionTime=" + this.f9060h + ", writeTime=" + this.f9061i + ", readTime=" + this.f9062j + ", serverTime='" + this.f9063k + '\'' + ", datasize='" + this.f9064l + '\'' + ", errorcode=" + this.f9065m + ", errorcodeSub=" + this.f9066n + '}';
        }
    }

    private static class d {

        /* renamed from: a  reason: collision with root package name */
        private Vector<e> f9067a;

        /* renamed from: b  reason: collision with root package name */
        private volatile e f9068b;

        private d() {
            this.f9067a = new Vector<>();
            this.f9068b = new e((byte) 0);
        }

        /* synthetic */ d(byte b2) {
            this();
        }

        public final e a(String str) {
            if (TextUtils.isEmpty(str)) {
                return this.f9068b;
            }
            for (int i2 = 0; i2 < this.f9067a.size(); i2++) {
                e eVar = this.f9067a.get(i2);
                if (eVar != null && eVar.a().equals(str)) {
                    return eVar;
                }
            }
            e eVar2 = new e((byte) 0);
            eVar2.b(str);
            this.f9067a.add(eVar2);
            return eVar2;
        }
    }

    private static class e implements HostnameVerifier {

        /* renamed from: a  reason: collision with root package name */
        private String f9069a;

        /* renamed from: b  reason: collision with root package name */
        private String f9070b;

        private e() {
        }

        /* synthetic */ e(byte b2) {
            this();
        }

        public final String a() {
            return this.f9070b;
        }

        public final void a(String str) {
            this.f9069a = str;
        }

        public final void b(String str) {
            this.f9070b = str;
        }

        public final boolean verify(String str, SSLSession sSLSession) {
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            return !TextUtils.isEmpty(this.f9069a) ? this.f9069a.equals(str) : !TextUtils.isEmpty(this.f9070b) ? defaultHostnameVerifier.verify(this.f9070b, sSLSession) : defaultHostnameVerifier.verify(str, sSLSession);
        }
    }

    class f {

        /* renamed from: a  reason: collision with root package name */
        long f9071a = 0;

        /* renamed from: b  reason: collision with root package name */
        long f9072b = 0;

        /* renamed from: c  reason: collision with root package name */
        c f9073c = new c();

        /* renamed from: d  reason: collision with root package name */
        a f9074d;

        /* renamed from: e  reason: collision with root package name */
        c f9075e;

        /* renamed from: f  reason: collision with root package name */
        String f9076f;

        /* renamed from: g  reason: collision with root package name */
        URL f9077g;

        f() {
        }

        public final void a() {
            this.f9073c.f9060h = SystemClock.elapsedRealtime() - this.f9072b;
        }

        public final void a(int i2) {
            "----errorcode-----".concat(String.valueOf(i2));
            ha.b();
            try {
                this.f9073c.f9058f = SystemClock.elapsedRealtime() - this.f9071a;
                this.f9073c.f9065m = i2;
                if (this.f9073c.f9054b.e()) {
                    ew.a(false, this.f9073c.f9057e);
                }
                boolean a2 = ha.this.a(this.f9073c.f9057e);
                if (a2) {
                    if (ha.this.f9036p && !TextUtils.isEmpty(ha.this.f9034n) && this.f9073c.f9054b.b()) {
                        ew.c();
                    }
                    if (this.f9073c.f9054b.c()) {
                        ew.a(this.f9073c.f9054b.c(), this.f9073c.f9057e);
                    }
                    ew.c(this.f9075e);
                    ew.a(false, this.f9074d);
                    ew.b(this.f9073c);
                }
                ew.a(this.f9077g.toString(), this.f9073c.f9054b.c(), true, a2);
                new StringBuilder("!!!error-").append(this.f9073c.toString());
                ha.b();
            } catch (Throwable unused) {
            }
        }

        public final void a(long j2) {
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            this.f9073c.f9064l = decimalFormat.format((double) (((float) j2) / 1024.0f));
        }

        public final void a(hd hdVar, URL url) {
            this.f9077g = url;
            this.f9073c.f9056d = url.getPath();
            this.f9073c.f9057e = url.getHost();
            if (!TextUtils.isEmpty(ha.this.f9034n) && hdVar.getDegradeType().b()) {
                c cVar = this.f9073c;
                cVar.f9055c = cVar.f9057e.replace("[", "").replace("]", "");
                this.f9073c.f9057e = ha.this.f9034n;
            }
            if (hdVar.getDegradeType().b()) {
                hdVar.setNon_degrade_final_Host(this.f9073c.f9057e);
            }
            if (hdVar.getDegradeType().d()) {
                this.f9076f = hdVar.getNon_degrade_final_Host();
            }
        }

        public final void a(he heVar) {
            c a2;
            try {
                this.f9073c.f9058f = SystemClock.elapsedRealtime() - this.f9071a;
                if (heVar != null) {
                    heVar.f9122f = this.f9073c.f9054b.c();
                }
                if (this.f9073c.f9054b.b() && this.f9073c.f9058f > 10000) {
                    ew.a(false, this.f9073c.f9057e);
                }
                if (this.f9073c.f9054b.d()) {
                    ew.a(false, this.f9076f);
                }
                boolean a3 = ha.this.a(this.f9073c.f9057e);
                if (a3) {
                    ew.c(this.f9073c);
                    ew.a(true, this.f9074d);
                    if (this.f9073c.f9058f > ((long) ew.f8615e) && (a2 = this.f9073c.clone()) != null) {
                        a2.f9065m = 1;
                        ew.b(a2);
                        new StringBuilder("!!!finish&error-").append(a2.toString());
                        ha.b();
                    }
                }
                ew.a(this.f9077g.toString(), this.f9073c.f9054b.c(), false, a3);
                new StringBuilder("!!!finish-").append(this.f9073c.toString());
                ha.b();
            } catch (Throwable unused) {
            }
        }

        public final void b() {
            this.f9073c.f9061i = SystemClock.elapsedRealtime() - this.f9072b;
        }

        public final void b(int i2) {
            this.f9073c.f9066n = i2;
        }

        public final void c() {
            this.f9073c.f9062j = SystemClock.elapsedRealtime() - this.f9072b;
        }

        public final void d() {
            c a2 = this.f9073c.clone();
            if (this.f9073c.f9058f > ((long) ew.f8615e)) {
                a2.f9065m = 1;
            }
            ew.a(a2);
        }
    }

    ha() {
        ew.d();
        try {
            this.f9028g = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        } catch (Throwable th) {
            fw.a(th, "ht", "ic");
        }
    }

    private static int a(Exception exc) {
        if (exc instanceof SSLHandshakeException) {
            return 4101;
        }
        if (exc instanceof SSLKeyException) {
            return 4102;
        }
        if (exc instanceof SSLProtocolException) {
            return 4103;
        }
        if (exc instanceof SSLPeerUnverifiedException) {
            return 4104;
        }
        if (exc instanceof ConnectException) {
            return 6101;
        }
        if (exc instanceof SocketException) {
            return 6102;
        }
        if (exc instanceof ConnectTimeoutException) {
            return 2101;
        }
        return exc instanceof SocketTimeoutException ? 2102 : 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0202 A[SYNTHETIC, Splitter:B:101:0x0202] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0225 A[SYNTHETIC, Splitter:B:113:0x0225] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0243  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x024d  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0290  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x029f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d3 A[SYNTHETIC, Splitter:B:42:0x00d3] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x014a A[Catch:{ all -> 0x01b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x018d A[Catch:{ all -> 0x01b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01f1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.amap.api.mapcore.util.ha.b a(com.amap.api.mapcore.util.hd r17, boolean r18, boolean r19) throws java.io.IOException, com.amap.api.mapcore.util.eu {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            java.lang.String r0 = "TLS"
            com.amap.api.mapcore.util.ha$f r3 = r1.f9040u
            com.amap.api.mapcore.util.hd$b r4 = r17.getDegradeType()
            com.amap.api.mapcore.util.ha$c r5 = r3.f9073c
            com.amap.api.mapcore.util.ha r6 = com.amap.api.mapcore.util.ha.this
            java.lang.String r6 = r6.f9028g
            r5.f9053a = r6
            com.amap.api.mapcore.util.ha$c r5 = r3.f9073c
            r5.f9054b = r4
            long r4 = android.os.SystemClock.elapsedRealtime()
            r3.f9071a = r4
            java.util.Map r3 = r17.getRequestHead()
            if (r3 != 0) goto L_0x0029
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
        L_0x0029:
            com.amap.api.mapcore.util.ha$d r4 = r1.f9030i
            java.lang.String r5 = r1.f9034n
            com.amap.api.mapcore.util.ha$e r4 = r4.a(r5)
            int r5 = com.amap.api.mapcore.util.gw.f8981a
            java.lang.String r6 = r1.f9033m
            android.net.Uri r7 = android.net.Uri.parse(r6)
            java.lang.String r8 = r7.getHost()
            java.lang.String r9 = ""
            r10 = 0
            r11 = 1
            if (r5 == r11) goto L_0x0059
            r12 = 2
            if (r5 == r12) goto L_0x0049
            r5 = r9
        L_0x0047:
            r12 = 1
            goto L_0x005c
        L_0x0049:
            java.util.HashMap<java.lang.String, java.lang.String> r5 = com.amap.api.mapcore.util.gw.f8983c
            if (r5 == 0) goto L_0x0056
            java.util.HashMap<java.lang.String, java.lang.String> r5 = com.amap.api.mapcore.util.gw.f8983c
            java.lang.Object r5 = r5.get(r8)
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x0057
        L_0x0056:
            r5 = r9
        L_0x0057:
            r12 = 0
            goto L_0x005c
        L_0x0059:
            java.lang.String r5 = com.amap.api.mapcore.util.gw.f8982b
            goto L_0x0047
        L_0x005c:
            boolean r13 = android.text.TextUtils.isEmpty(r5)
            if (r13 != 0) goto L_0x0089
            r2.setHostToIP(r10)
            android.net.Uri$Builder r6 = r7.buildUpon()
            android.net.Uri$Builder r6 = r6.encodedAuthority(r5)
            android.net.Uri r6 = r6.build()
            java.lang.String r6 = r6.toString()
            if (r12 == 0) goto L_0x0080
            if (r3 == 0) goto L_0x0080
            java.lang.String r7 = "targetHost"
            r3.put(r7, r8)
            r1.f9039s = r8
        L_0x0080:
            if (r12 == 0) goto L_0x0089
            boolean r7 = r1.f9022a
            if (r7 == 0) goto L_0x0089
            r4.a(r5)
        L_0x0089:
            r1.f9033m = r6
            java.net.URL r5 = new java.net.URL
            java.lang.String r6 = r1.f9033m
            r5.<init>(r6)
            com.amap.api.mapcore.util.ha$f r6 = r1.f9040u
            r6.a(r2, r5)
            java.lang.String r5 = r5.getHost()
            boolean r5 = b((java.lang.String) r5)
            if (r5 == 0) goto L_0x01b9
            boolean r5 = r17.isHostToIP()
            if (r5 == 0) goto L_0x01b9
            com.amap.api.mapcore.util.hd$b r5 = r17.getDegradeType()
            com.amap.api.mapcore.util.ha$f r6 = r1.f9040u
            com.amap.api.mapcore.util.ha$c r6 = r6.f9073c
            java.lang.String r6 = r6.f9057e
            boolean r7 = r1.a((java.lang.String) r6)
            if (r7 == 0) goto L_0x00d0
            boolean r7 = r5.b()
            if (r7 == 0) goto L_0x00c3
            boolean r7 = com.amap.api.mapcore.util.ew.f8617g
            if (r7 == 0) goto L_0x00c3
        L_0x00c1:
            r5 = 1
            goto L_0x00d1
        L_0x00c3:
            boolean r5 = r5.c()
            if (r5 == 0) goto L_0x00d0
            boolean r5 = com.amap.api.mapcore.util.ew.e(r6)
            if (r5 == 0) goto L_0x00d0
            goto L_0x00c1
        L_0x00d0:
            r5 = 0
        L_0x00d1:
            if (r5 == 0) goto L_0x01b9
            com.amap.api.mapcore.util.ha$f r5 = r1.f9040u     // Catch:{ all -> 0x01b8 }
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x01b8 }
            r5.f9072b = r6     // Catch:{ all -> 0x01b8 }
            com.amap.api.mapcore.util.ha$f r5 = r1.f9040u     // Catch:{ all -> 0x01b8 }
            com.amap.api.mapcore.util.ha$c r5 = r5.f9073c     // Catch:{ all -> 0x01b8 }
            java.lang.String r5 = r5.f9057e     // Catch:{ all -> 0x01b8 }
            java.net.InetAddress[] r5 = java.net.InetAddress.getAllByName(r5)     // Catch:{ all -> 0x01b8 }
            java.lang.String r6 = "]"
            java.lang.String r7 = "["
            if (r5 == 0) goto L_0x0164
            int r8 = r5.length     // Catch:{ all -> 0x01b8 }
            if (r8 <= 0) goto L_0x0164
            r8 = r5[r10]     // Catch:{ all -> 0x01b8 }
            if (r8 == 0) goto L_0x0164
            boolean r8 = com.amap.api.mapcore.util.ew.a()     // Catch:{ all -> 0x01b8 }
            if (r8 == 0) goto L_0x0100
            boolean r8 = com.amap.api.mapcore.util.ew.b()     // Catch:{ all -> 0x01b8 }
            if (r8 == 0) goto L_0x0100
            r8 = 1
            goto L_0x0101
        L_0x0100:
            r8 = 0
        L_0x0101:
            java.lang.String r12 = "---canUseIpv6---"
            java.lang.String r13 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x01b8 }
            r12.concat(r13)     // Catch:{ all -> 0x01b8 }
            if (r8 == 0) goto L_0x012f
            r8 = 0
        L_0x010d:
            int r12 = r5.length     // Catch:{ all -> 0x01b8 }
            if (r8 >= r12) goto L_0x0143
            r12 = r5[r8]     // Catch:{ all -> 0x01b8 }
            boolean r12 = r12 instanceof java.net.Inet6Address     // Catch:{ all -> 0x01b8 }
            if (r12 == 0) goto L_0x012c
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b8 }
            r12.<init>(r7)     // Catch:{ all -> 0x01b8 }
            r8 = r5[r8]     // Catch:{ all -> 0x01b8 }
            java.lang.String r8 = r8.getHostAddress()     // Catch:{ all -> 0x01b8 }
            r12.append(r8)     // Catch:{ all -> 0x01b8 }
            r12.append(r6)     // Catch:{ all -> 0x01b8 }
            java.lang.String r8 = r12.toString()     // Catch:{ all -> 0x01b8 }
            goto L_0x0144
        L_0x012c:
            int r8 = r8 + 1
            goto L_0x010d
        L_0x012f:
            r8 = 0
        L_0x0130:
            int r12 = r5.length     // Catch:{ all -> 0x01b8 }
            if (r8 >= r12) goto L_0x0143
            r12 = r5[r8]     // Catch:{ all -> 0x01b8 }
            boolean r12 = r12 instanceof java.net.Inet4Address     // Catch:{ all -> 0x01b8 }
            if (r12 == 0) goto L_0x0140
            r8 = r5[r8]     // Catch:{ all -> 0x01b8 }
            java.lang.String r8 = r8.getHostAddress()     // Catch:{ all -> 0x01b8 }
            goto L_0x0144
        L_0x0140:
            int r8 = r8 + 1
            goto L_0x0130
        L_0x0143:
            r8 = r9
        L_0x0144:
            boolean r12 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x01b8 }
            if (r12 == 0) goto L_0x0165
            r5 = r5[r10]     // Catch:{ all -> 0x01b8 }
            java.lang.String r8 = r5.getHostAddress()     // Catch:{ all -> 0x01b8 }
            boolean r5 = r5 instanceof java.net.Inet6Address     // Catch:{ all -> 0x01b8 }
            if (r5 == 0) goto L_0x0165
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b8 }
            r5.<init>(r7)     // Catch:{ all -> 0x01b8 }
            r5.append(r8)     // Catch:{ all -> 0x01b8 }
            r5.append(r6)     // Catch:{ all -> 0x01b8 }
            java.lang.String r8 = r5.toString()     // Catch:{ all -> 0x01b8 }
            goto L_0x0165
        L_0x0164:
            r8 = r9
        L_0x0165:
            com.amap.api.mapcore.util.ha$f r5 = r1.f9040u     // Catch:{ all -> 0x01b8 }
            java.lang.String r12 = "---onDNSEnd---ip="
            java.lang.String r13 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x01b8 }
            r12.concat(r13)     // Catch:{ all -> 0x01b8 }
            com.amap.api.mapcore.util.ha$c r12 = r5.f9073c     // Catch:{ all -> 0x01b8 }
            java.lang.String r7 = r8.replace(r7, r9)     // Catch:{ all -> 0x01b8 }
            java.lang.String r6 = r7.replace(r6, r9)     // Catch:{ all -> 0x01b8 }
            r12.f9055c = r6     // Catch:{ all -> 0x01b8 }
            com.amap.api.mapcore.util.ha$c r6 = r5.f9073c     // Catch:{ all -> 0x01b8 }
            long r12 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x01b8 }
            long r14 = r5.f9072b     // Catch:{ all -> 0x01b8 }
            long r12 = r12 - r14
            r6.f9059g = r12     // Catch:{ all -> 0x01b8 }
            boolean r5 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x01b8 }
            if (r5 != 0) goto L_0x01b9
            java.lang.String r5 = r1.f9033m     // Catch:{ all -> 0x01b8 }
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ all -> 0x01b8 }
            java.lang.String r6 = r5.getHost()     // Catch:{ all -> 0x01b8 }
            android.net.Uri$Builder r5 = r5.buildUpon()     // Catch:{ all -> 0x01b8 }
            android.net.Uri$Builder r5 = r5.encodedAuthority(r8)     // Catch:{ all -> 0x01b8 }
            android.net.Uri r5 = r5.build()     // Catch:{ all -> 0x01b8 }
            r1.f9034n = r6     // Catch:{ all -> 0x01b8 }
            java.lang.String r7 = "host"
            r3.put(r7, r6)     // Catch:{ all -> 0x01b8 }
            boolean r7 = r1.f9022a     // Catch:{ all -> 0x01b8 }
            if (r7 == 0) goto L_0x01b1
            r4.b(r6)     // Catch:{ all -> 0x01b8 }
        L_0x01b1:
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x01b8 }
            r1.f9033m = r5     // Catch:{ all -> 0x01b8 }
            goto L_0x01b9
        L_0x01b8:
        L_0x01b9:
            boolean r5 = r1.f9022a
            if (r5 == 0) goto L_0x01c5
            java.lang.String r5 = r1.f9033m
            java.lang.String r5 = com.amap.api.mapcore.util.fb.a((java.lang.String) r5)
            r1.f9033m = r5
        L_0x01c5:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "是否降级="
            r5.<init>(r6)
            com.amap.api.mapcore.util.hd$b r6 = r17.getDegradeType()
            r5.append(r6)
            java.lang.String r6 = "-最终url="
            r5.append(r6)
            java.lang.String r6 = r1.f9033m
            r5.append(r6)
            java.net.URL r5 = new java.net.URL
            java.lang.String r6 = r1.f9033m
            r5.<init>(r6)
            com.amap.api.mapcore.util.gw$a r6 = r1.f9029h
            r7 = 0
            if (r6 == 0) goto L_0x01ee
            java.net.URLConnection r6 = r6.a()
            goto L_0x01ef
        L_0x01ee:
            r6 = r7
        L_0x01ef:
            if (r6 != 0) goto L_0x01fe
            java.net.Proxy r6 = r1.f9024c
            if (r6 == 0) goto L_0x01fa
            java.net.URLConnection r6 = r5.openConnection(r6)
            goto L_0x01fe
        L_0x01fa:
            java.net.URLConnection r6 = r5.openConnection()
        L_0x01fe:
            boolean r5 = r1.f9022a
            if (r5 == 0) goto L_0x0260
            java.lang.ref.SoftReference<javax.net.ssl.SSLContext> r5 = f9020k     // Catch:{ all -> 0x0222 }
            if (r5 == 0) goto L_0x020c
            java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x0222 }
            if (r5 != 0) goto L_0x0217
        L_0x020c:
            java.lang.ref.SoftReference r5 = new java.lang.ref.SoftReference     // Catch:{ all -> 0x0222 }
            javax.net.ssl.SSLContext r8 = javax.net.ssl.SSLContext.getInstance(r0)     // Catch:{ all -> 0x0222 }
            r5.<init>(r8)     // Catch:{ all -> 0x0222 }
            f9020k = r5     // Catch:{ all -> 0x0222 }
        L_0x0217:
            java.lang.ref.SoftReference<javax.net.ssl.SSLContext> r5 = f9020k     // Catch:{ all -> 0x0222 }
            if (r5 == 0) goto L_0x0222
            java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x0222 }
            javax.net.ssl.SSLContext r5 = (javax.net.ssl.SSLContext) r5     // Catch:{ all -> 0x0222 }
            goto L_0x0223
        L_0x0222:
            r5 = r7
        L_0x0223:
            if (r5 != 0) goto L_0x0229
            javax.net.ssl.SSLContext r5 = javax.net.ssl.SSLContext.getInstance(r0)     // Catch:{ all -> 0x022f }
        L_0x0229:
            r5.init(r7, r7, r7)     // Catch:{ all -> 0x022f }
            r1.f9023b = r5     // Catch:{ all -> 0x022f }
            goto L_0x0237
        L_0x022f:
            r0 = move-exception
            java.lang.String r5 = "ht"
            java.lang.String r7 = "ne"
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r0, (java.lang.String) r5, (java.lang.String) r7)
        L_0x0237:
            javax.net.ssl.HttpsURLConnection r6 = (javax.net.ssl.HttpsURLConnection) r6
            boolean r0 = com.amap.api.mapcore.util.ew.e.f8664a
            if (r0 == 0) goto L_0x024d
            com.amap.api.mapcore.util.hb r0 = r16.c()
            if (r0 == 0) goto L_0x024d
            r5 = r6
            javax.net.ssl.HttpsURLConnection r5 = (javax.net.ssl.HttpsURLConnection) r5
            r5.setSSLSocketFactory(r0)
            r0.a()
            goto L_0x0259
        L_0x024d:
            r0 = r6
            javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0
            javax.net.ssl.SSLContext r5 = r1.f9023b
            javax.net.ssl.SSLSocketFactory r5 = r5.getSocketFactory()
            r0.setSSLSocketFactory(r5)
        L_0x0259:
            r0 = r6
            javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0
            r0.setHostnameVerifier(r4)
            goto L_0x0262
        L_0x0260:
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6
        L_0x0262:
            java.lang.String r0 = android.os.Build.VERSION.SDK
            if (r0 == 0) goto L_0x0273
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 13
            if (r0 <= r4) goto L_0x0273
            java.lang.String r0 = "Connection"
            java.lang.String r4 = "close"
            r6.setRequestProperty(r0, r4)
        L_0x0273:
            int r0 = r17.getReal_max_timeout()
            long r4 = (long) r0
            com.amap.api.mapcore.util.ha$f r0 = r1.f9040u
            com.amap.api.mapcore.util.ha$c r0 = r0.f9073c
            long r7 = r0.f9059g
            r12 = 1000(0x3e8, double:4.94E-321)
            long r7 = r7 / r12
            long r4 = r4 - r7
            int r0 = (int) r4
            r2 = r19
            r1.a((java.util.Map<java.lang.String, java.lang.String>) r3, (java.net.HttpURLConnection) r6, (boolean) r2)
            r6.setConnectTimeout(r0)
            r6.setReadTimeout(r0)
            if (r18 == 0) goto L_0x029f
            java.lang.String r0 = "POST"
            r6.setRequestMethod(r0)
            r6.setUseCaches(r10)
            r6.setDoInput(r11)
            r6.setDoOutput(r11)
            goto L_0x02a7
        L_0x029f:
            java.lang.String r0 = "GET"
            r6.setRequestMethod(r0)
            r6.setDoInput(r11)
        L_0x02a7:
            com.amap.api.mapcore.util.ha$b r0 = new com.amap.api.mapcore.util.ha$b
            r0.<init>(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ha.a(com.amap.api.mapcore.util.hd, boolean, boolean):com.amap.api.mapcore.util.ha$b");
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r6v5 */
    /* JADX WARNING: type inference failed for: r6v19 */
    /* JADX WARNING: type inference failed for: r6v22 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x017a A[SYNTHETIC, Splitter:B:111:0x017a] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01d5 A[Catch:{ all -> 0x01f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01f8 A[Catch:{ all -> 0x01f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x020a A[SYNTHETIC, Splitter:B:140:0x020a] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0215 A[SYNTHETIC, Splitter:B:145:0x0215] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0220 A[SYNTHETIC, Splitter:B:150:0x0220] */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x022b A[SYNTHETIC, Splitter:B:155:0x022b] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a8 A[SYNTHETIC, Splitter:B:46:0x00a8] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.amap.api.mapcore.util.he a(com.amap.api.mapcore.util.ha.b r17, boolean r18) throws com.amap.api.mapcore.util.eu, java.io.IOException {
        /*
            r16 = this;
            r1 = r16
            java.lang.String r2 = "par"
            java.lang.String r3 = "ht"
            java.lang.String r4 = ""
            r5 = 0
            com.amap.api.mapcore.util.gz.a()     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            r0 = r17
            java.net.HttpURLConnection r0 = r0.f9051a     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            java.util.Map r6 = r0.getHeaderFields()     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            int r7 = r0.getResponseCode()     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            r8 = 2
            r9 = 1
            r10 = 0
            if (r6 == 0) goto L_0x00a3
            java.lang.String r11 = "gsid"
            java.lang.Object r11 = r6.get(r11)     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            java.util.List r11 = (java.util.List) r11     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            if (r11 == 0) goto L_0x0034
            int r12 = r11.size()     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            if (r12 <= 0) goto L_0x0034
            java.lang.Object r11 = r11.get(r10)     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            r4 = r11
        L_0x0034:
            com.amap.api.mapcore.util.ha$f r11 = r1.f9040u     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            java.lang.String r12 = b((java.util.Map<java.lang.String, java.util.List<java.lang.String>>) r6)     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            com.amap.api.mapcore.util.ha$c r11 = r11.f9073c     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            r11.f9063k = r12     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            java.lang.String r11 = r1.f9031j     // Catch:{ all -> 0x00a3 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x00a3 }
            if (r11 != 0) goto L_0x00a3
            boolean r11 = r1.f9035o     // Catch:{ all -> 0x00a3 }
            if (r11 == 0) goto L_0x0060
            java.lang.String r11 = "sc"
            boolean r11 = r6.containsKey(r11)     // Catch:{ all -> 0x00a3 }
            if (r11 == 0) goto L_0x0058
            boolean r11 = r1.a((java.util.Map<java.lang.String, java.util.List<java.lang.String>>) r6, (boolean) r10)     // Catch:{ all -> 0x00a3 }
            r12 = 1
            goto L_0x0065
        L_0x0058:
            java.lang.String r11 = r1.f9031j     // Catch:{ all -> 0x00a3 }
            com.amap.api.mapcore.util.ew.b((java.lang.String) r11)     // Catch:{ all -> 0x00a3 }
            r11 = 0
            r12 = 0
            goto L_0x0065
        L_0x0060:
            boolean r11 = r1.a((java.util.Map<java.lang.String, java.util.List<java.lang.String>>) r6, (boolean) r9)     // Catch:{ all -> 0x00a3 }
            r12 = 2
        L_0x0065:
            if (r11 == 0) goto L_0x009b
            java.lang.String r13 = r1.f9031j     // Catch:{ all -> 0x0099 }
            java.lang.String r14 = "loc"
            boolean r13 = r13.equals(r14)     // Catch:{ all -> 0x0099 }
            if (r13 == 0) goto L_0x008e
            java.lang.String r13 = r1.f9039s     // Catch:{ all -> 0x0099 }
            boolean r14 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x0099 }
            if (r14 == 0) goto L_0x0081
            java.net.URL r13 = r0.getURL()     // Catch:{ all -> 0x0099 }
            java.lang.String r13 = r13.getHost()     // Catch:{ all -> 0x0099 }
        L_0x0081:
            java.lang.String r14 = r1.f9031j     // Catch:{ all -> 0x0099 }
            if (r12 != r8) goto L_0x0087
            r12 = 1
            goto L_0x0088
        L_0x0087:
            r12 = 0
        L_0x0088:
            java.lang.String r15 = r1.f9034n     // Catch:{ all -> 0x0099 }
            com.amap.api.mapcore.util.ew.a((java.lang.String) r14, (boolean) r12, (java.lang.String) r13, (java.lang.String) r13, (java.lang.String) r15)     // Catch:{ all -> 0x0099 }
            goto L_0x00a4
        L_0x008e:
            java.lang.String r13 = r1.f9031j     // Catch:{ all -> 0x0099 }
            if (r12 != r8) goto L_0x0094
            r12 = 1
            goto L_0x0095
        L_0x0094:
            r12 = 0
        L_0x0095:
            com.amap.api.mapcore.util.ew.b((java.lang.String) r13, (boolean) r12)     // Catch:{ all -> 0x0099 }
            goto L_0x00a4
        L_0x0099:
            goto L_0x00a4
        L_0x009b:
            if (r12 != r9) goto L_0x00a4
            java.lang.String r12 = r1.f9031j     // Catch:{ all -> 0x0099 }
            com.amap.api.mapcore.util.gz.a((boolean) r10, (java.lang.String) r12)     // Catch:{ all -> 0x0099 }
            goto L_0x00a4
        L_0x00a3:
            r11 = 0
        L_0x00a4:
            r12 = 200(0xc8, float:2.8E-43)
            if (r7 != r12) goto L_0x017a
            java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            r7.<init>()     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            com.amap.api.mapcore.util.ha$f r12 = r1.f9040u     // Catch:{ ConnectTimeoutException -> 0x0173, SocketTimeoutException -> 0x016c, IOException -> 0x0165, all -> 0x015d }
            long r13 = android.os.SystemClock.elapsedRealtime()     // Catch:{ ConnectTimeoutException -> 0x0173, SocketTimeoutException -> 0x016c, IOException -> 0x0165, all -> 0x015d }
            r12.f9072b = r13     // Catch:{ ConnectTimeoutException -> 0x0173, SocketTimeoutException -> 0x016c, IOException -> 0x0165, all -> 0x015d }
            java.io.InputStream r12 = r0.getInputStream()     // Catch:{ ConnectTimeoutException -> 0x0173, SocketTimeoutException -> 0x016c, IOException -> 0x0165, all -> 0x015d }
            java.io.PushbackInputStream r13 = new java.io.PushbackInputStream     // Catch:{ ConnectTimeoutException -> 0x0159, SocketTimeoutException -> 0x0155, IOException -> 0x0151, all -> 0x014c }
            r13.<init>(r12, r8)     // Catch:{ ConnectTimeoutException -> 0x0159, SocketTimeoutException -> 0x0155, IOException -> 0x0151, all -> 0x014c }
            byte[] r8 = new byte[r8]     // Catch:{ ConnectTimeoutException -> 0x0149, SocketTimeoutException -> 0x0146, IOException -> 0x0143, all -> 0x013f }
            r13.read(r8)     // Catch:{ ConnectTimeoutException -> 0x0149, SocketTimeoutException -> 0x0146, IOException -> 0x0143, all -> 0x013f }
            r13.unread(r8)     // Catch:{ ConnectTimeoutException -> 0x0149, SocketTimeoutException -> 0x0146, IOException -> 0x0143, all -> 0x013f }
            byte r14 = r8[r10]     // Catch:{ ConnectTimeoutException -> 0x0149, SocketTimeoutException -> 0x0146, IOException -> 0x0143, all -> 0x013f }
            r15 = 31
            if (r14 != r15) goto L_0x00db
            byte r8 = r8[r9]     // Catch:{ ConnectTimeoutException -> 0x0149, SocketTimeoutException -> 0x0146, IOException -> 0x0143, all -> 0x013f }
            r9 = -117(0xffffffffffffff8b, float:NaN)
            if (r8 != r9) goto L_0x00db
            if (r18 != 0) goto L_0x00db
            java.util.zip.GZIPInputStream r8 = new java.util.zip.GZIPInputStream     // Catch:{ ConnectTimeoutException -> 0x0149, SocketTimeoutException -> 0x0146, IOException -> 0x0143, all -> 0x013f }
            r8.<init>(r13)     // Catch:{ ConnectTimeoutException -> 0x0149, SocketTimeoutException -> 0x0146, IOException -> 0x0143, all -> 0x013f }
            r5 = r8
            goto L_0x00dc
        L_0x00db:
            r5 = r13
        L_0x00dc:
            r8 = 1024(0x400, float:1.435E-42)
            byte[] r8 = new byte[r8]     // Catch:{ ConnectTimeoutException -> 0x0149, SocketTimeoutException -> 0x0146, IOException -> 0x0143, all -> 0x013f }
        L_0x00e0:
            int r9 = r5.read(r8)     // Catch:{ ConnectTimeoutException -> 0x0149, SocketTimeoutException -> 0x0146, IOException -> 0x0143, all -> 0x013f }
            r14 = -1
            if (r9 == r14) goto L_0x00eb
            r7.write(r8, r10, r9)     // Catch:{ ConnectTimeoutException -> 0x0149, SocketTimeoutException -> 0x0146, IOException -> 0x0143, all -> 0x013f }
            goto L_0x00e0
        L_0x00eb:
            com.amap.api.mapcore.util.ha$f r8 = r1.f9040u     // Catch:{ ConnectTimeoutException -> 0x0149, SocketTimeoutException -> 0x0146, IOException -> 0x0143, all -> 0x013f }
            r8.c()     // Catch:{ ConnectTimeoutException -> 0x0149, SocketTimeoutException -> 0x0146, IOException -> 0x0143, all -> 0x013f }
            com.amap.api.mapcore.util.fz.c()     // Catch:{ ConnectTimeoutException -> 0x0149, SocketTimeoutException -> 0x0146, IOException -> 0x0143, all -> 0x013f }
            com.amap.api.mapcore.util.he r8 = new com.amap.api.mapcore.util.he     // Catch:{ ConnectTimeoutException -> 0x0149, SocketTimeoutException -> 0x0146, IOException -> 0x0143, all -> 0x013f }
            r8.<init>()     // Catch:{ ConnectTimeoutException -> 0x0149, SocketTimeoutException -> 0x0146, IOException -> 0x0143, all -> 0x013f }
            byte[] r9 = r7.toByteArray()     // Catch:{ ConnectTimeoutException -> 0x0149, SocketTimeoutException -> 0x0146, IOException -> 0x0143, all -> 0x013f }
            r8.f9117a = r9     // Catch:{ ConnectTimeoutException -> 0x0149, SocketTimeoutException -> 0x0146, IOException -> 0x0143, all -> 0x013f }
            r8.f9118b = r6     // Catch:{ ConnectTimeoutException -> 0x0149, SocketTimeoutException -> 0x0146, IOException -> 0x0143, all -> 0x013f }
            java.lang.String r6 = r1.f9028g     // Catch:{ ConnectTimeoutException -> 0x0149, SocketTimeoutException -> 0x0146, IOException -> 0x0143, all -> 0x013f }
            r8.f9119c = r6     // Catch:{ ConnectTimeoutException -> 0x0149, SocketTimeoutException -> 0x0146, IOException -> 0x0143, all -> 0x013f }
            r8.f9120d = r4     // Catch:{ ConnectTimeoutException -> 0x0149, SocketTimeoutException -> 0x0146, IOException -> 0x0143, all -> 0x013f }
            r8.f9121e = r11     // Catch:{ ConnectTimeoutException -> 0x0149, SocketTimeoutException -> 0x0146, IOException -> 0x0143, all -> 0x013f }
            java.net.URL r0 = r0.getURL()     // Catch:{ ConnectTimeoutException -> 0x0149, SocketTimeoutException -> 0x0146, IOException -> 0x0143, all -> 0x013f }
            com.amap.api.mapcore.util.gz.a((java.net.URL) r0, (com.amap.api.mapcore.util.he) r8)     // Catch:{ ConnectTimeoutException -> 0x0149, SocketTimeoutException -> 0x0146, IOException -> 0x0143, all -> 0x013f }
            com.amap.api.mapcore.util.ha$f r0 = r1.f9040u     // Catch:{ ConnectTimeoutException -> 0x0149, SocketTimeoutException -> 0x0146, IOException -> 0x0143, all -> 0x013f }
            byte[] r6 = r8.f9117a     // Catch:{ ConnectTimeoutException -> 0x0149, SocketTimeoutException -> 0x0146, IOException -> 0x0143, all -> 0x013f }
            int r6 = r6.length     // Catch:{ ConnectTimeoutException -> 0x0149, SocketTimeoutException -> 0x0146, IOException -> 0x0143, all -> 0x013f }
            long r9 = (long) r6     // Catch:{ ConnectTimeoutException -> 0x0149, SocketTimeoutException -> 0x0146, IOException -> 0x0143, all -> 0x013f }
            r0.a((long) r9)     // Catch:{ ConnectTimeoutException -> 0x0149, SocketTimeoutException -> 0x0146, IOException -> 0x0143, all -> 0x013f }
            r7.close()     // Catch:{ all -> 0x011c }
            goto L_0x0121
        L_0x011c:
            r0 = move-exception
            r4 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r4, (java.lang.String) r3, (java.lang.String) r2)
        L_0x0121:
            if (r12 == 0) goto L_0x012c
            r12.close()     // Catch:{ all -> 0x0127 }
            goto L_0x012c
        L_0x0127:
            r0 = move-exception
            r4 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r4, (java.lang.String) r3, (java.lang.String) r2)
        L_0x012c:
            r13.close()     // Catch:{ all -> 0x0130 }
            goto L_0x0135
        L_0x0130:
            r0 = move-exception
            r4 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r4, (java.lang.String) r3, (java.lang.String) r2)
        L_0x0135:
            r5.close()     // Catch:{ all -> 0x0139 }
            goto L_0x013e
        L_0x0139:
            r0 = move-exception
            r4 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r4, (java.lang.String) r3, (java.lang.String) r2)
        L_0x013e:
            return r8
        L_0x013f:
            r0 = move-exception
            r4 = r0
            r6 = r5
            goto L_0x0162
        L_0x0143:
            r0 = move-exception
            r6 = r5
            goto L_0x0169
        L_0x0146:
            r0 = move-exception
            r4 = r5
            goto L_0x0170
        L_0x0149:
            r0 = move-exception
            r4 = r5
            goto L_0x0177
        L_0x014c:
            r0 = move-exception
            r4 = r0
            r6 = r5
            r13 = r6
            goto L_0x0162
        L_0x0151:
            r0 = move-exception
            r6 = r5
            r13 = r6
            goto L_0x0169
        L_0x0155:
            r0 = move-exception
            r4 = r5
            r13 = r4
            goto L_0x0170
        L_0x0159:
            r0 = move-exception
            r4 = r5
            r13 = r4
            goto L_0x0177
        L_0x015d:
            r0 = move-exception
            r4 = r0
            r6 = r5
            r12 = r6
            r13 = r12
        L_0x0162:
            r5 = r7
            goto L_0x0208
        L_0x0165:
            r0 = move-exception
            r6 = r5
            r12 = r6
            r13 = r12
        L_0x0169:
            r5 = r7
            goto L_0x01d1
        L_0x016c:
            r0 = move-exception
            r4 = r5
            r12 = r4
            r13 = r12
        L_0x0170:
            r5 = r7
            goto L_0x01ff
        L_0x0173:
            r0 = move-exception
            r4 = r5
            r12 = r4
            r13 = r12
        L_0x0177:
            r5 = r7
            goto L_0x0204
        L_0x017a:
            com.amap.api.mapcore.util.eu r8 = new com.amap.api.mapcore.util.eu     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            java.lang.String r10 = "网络异常原因："
            r9.<init>(r10)     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            java.lang.String r10 = r0.getResponseMessage()     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            r9.append(r10)     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            java.lang.String r10 = " 网络异常状态码："
            r9.append(r10)     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            r9.append(r7)     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            java.lang.String r10 = "  "
            r9.append(r10)     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            r9.append(r4)     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            java.lang.String r10 = " "
            r9.append(r10)     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            java.lang.String r10 = r1.f9028g     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            r9.append(r10)     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            java.lang.String r9 = r9.toString()     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            java.lang.String r10 = r1.f9028g     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            r8.<init>(r9, r4, r10)     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            java.lang.String r0 = r0.getResponseMessage()     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            r8.a((java.lang.String) r0)     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            r8.a((java.util.Map<java.lang.String, java.util.List<java.lang.String>>) r6)     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            com.amap.api.mapcore.util.ha$f r0 = r1.f9040u     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            r0.b(r7)     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            com.amap.api.mapcore.util.ha$f r0 = r1.f9040u     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            r6 = 10
            r0.a((int) r6)     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            r8.h()     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
            throw r8     // Catch:{ ConnectTimeoutException -> 0x0200, SocketTimeoutException -> 0x01fb, IOException -> 0x01cd, all -> 0x01c7 }
        L_0x01c7:
            r0 = move-exception
            r4 = r0
            r6 = r5
            r12 = r6
            r13 = r12
            goto L_0x0208
        L_0x01cd:
            r0 = move-exception
            r6 = r5
            r12 = r6
            r13 = r12
        L_0x01d1:
            boolean r7 = r0 instanceof java.io.InterruptedIOException     // Catch:{ all -> 0x01f9 }
            if (r7 == 0) goto L_0x01f8
            com.amap.api.mapcore.util.eu r7 = new com.amap.api.mapcore.util.eu     // Catch:{ all -> 0x01f9 }
            java.lang.String r8 = "IO 操作异常 - IOException"
            java.lang.String r9 = r1.f9028g     // Catch:{ all -> 0x01f9 }
            r7.<init>(r8, r4, r9)     // Catch:{ all -> 0x01f9 }
            java.lang.String r4 = r0.getMessage()     // Catch:{ all -> 0x01f9 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x01f9 }
            if (r4 != 0) goto L_0x01f7
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x01f9 }
            java.lang.String r4 = "thread interrupted"
            boolean r0 = r0.equals(r4)     // Catch:{ all -> 0x01f9 }
            if (r0 == 0) goto L_0x01f7
            r7.j()     // Catch:{ all -> 0x01f9 }
        L_0x01f7:
            throw r7     // Catch:{ all -> 0x01f9 }
        L_0x01f8:
            throw r0     // Catch:{ all -> 0x01f9 }
        L_0x01f9:
            r0 = move-exception
            goto L_0x0207
        L_0x01fb:
            r0 = move-exception
            r4 = r5
            r12 = r4
            r13 = r12
        L_0x01ff:
            throw r0     // Catch:{ all -> 0x0205 }
        L_0x0200:
            r0 = move-exception
            r4 = r5
            r12 = r4
            r13 = r12
        L_0x0204:
            throw r0     // Catch:{ all -> 0x0205 }
        L_0x0205:
            r0 = move-exception
            r6 = r4
        L_0x0207:
            r4 = r0
        L_0x0208:
            if (r5 == 0) goto L_0x0213
            r5.close()     // Catch:{ all -> 0x020e }
            goto L_0x0213
        L_0x020e:
            r0 = move-exception
            r5 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r5, (java.lang.String) r3, (java.lang.String) r2)
        L_0x0213:
            if (r12 == 0) goto L_0x021e
            r12.close()     // Catch:{ all -> 0x0219 }
            goto L_0x021e
        L_0x0219:
            r0 = move-exception
            r5 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r5, (java.lang.String) r3, (java.lang.String) r2)
        L_0x021e:
            if (r13 == 0) goto L_0x0229
            r13.close()     // Catch:{ all -> 0x0224 }
            goto L_0x0229
        L_0x0224:
            r0 = move-exception
            r5 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r5, (java.lang.String) r3, (java.lang.String) r2)
        L_0x0229:
            if (r6 == 0) goto L_0x0234
            r6.close()     // Catch:{ all -> 0x022f }
            goto L_0x0234
        L_0x022f:
            r0 = move-exception
            r5 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r5, (java.lang.String) r3, (java.lang.String) r2)
        L_0x0234:
            goto L_0x0236
        L_0x0235:
            throw r4
        L_0x0236:
            goto L_0x0235
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ha.a(com.amap.api.mapcore.util.ha$b, boolean):com.amap.api.mapcore.util.he");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0097, code lost:
        if (r9.endsWith(r0) == false) goto L_0x0099;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.lang.String r9, java.util.HashMap r10) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 == 0) goto L_0x0007
            return r9
        L_0x0007:
            java.util.HashMap<java.lang.String, java.lang.String> r0 = com.amap.api.mapcore.util.gw.f8985e
            if (r0 == 0) goto L_0x0015
            if (r10 == 0) goto L_0x0013
            java.util.HashMap<java.lang.String, java.lang.String> r0 = com.amap.api.mapcore.util.gw.f8985e
            r10.putAll(r0)
            goto L_0x0015
        L_0x0013:
            java.util.HashMap<java.lang.String, java.lang.String> r10 = com.amap.api.mapcore.util.gw.f8985e
        L_0x0015:
            if (r10 == 0) goto L_0x00a5
            int r0 = r10.size()
            if (r0 > 0) goto L_0x001f
            goto L_0x00a5
        L_0x001f:
            java.lang.String r0 = "?"
            int r1 = r9.indexOf(r0)
            if (r1 < 0) goto L_0x0076
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.lang.String r3 = r9.substring(r1)
            java.util.Set r10 = r10.entrySet()
            java.util.Iterator r10 = r10.iterator()
        L_0x0038:
            boolean r4 = r10.hasNext()
            if (r4 == 0) goto L_0x0075
            java.lang.Object r4 = r10.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r4 = r4.getValue()
            java.lang.String r4 = (java.lang.String) r4
            if (r4 != 0) goto L_0x0054
            java.lang.String r4 = ""
        L_0x0054:
            java.lang.String r6 = java.net.URLEncoder.encode(r5)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = ".*[\\?\\&]"
            r7.<init>(r8)
            r7.append(r6)
            java.lang.String r6 = "=.*"
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            boolean r6 = r3.matches(r6)
            if (r6 != 0) goto L_0x0038
            r2.put(r5, r4)
            goto L_0x0038
        L_0x0075:
            r10 = r2
        L_0x0076:
            int r2 = r10.size()
            if (r2 != 0) goto L_0x007d
            return r9
        L_0x007d:
            java.lang.String r10 = a((java.util.Map<java.lang.String, java.lang.String>) r10)
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            r2.<init>()
            r2.append(r9)
            if (r1 < 0) goto L_0x0099
            boolean r0 = r9.endsWith(r0)
            if (r0 != 0) goto L_0x009c
            java.lang.String r0 = "&"
            boolean r9 = r9.endsWith(r0)
            if (r9 != 0) goto L_0x009c
        L_0x0099:
            r2.append(r0)
        L_0x009c:
            if (r10 == 0) goto L_0x00a1
            r2.append(r10)
        L_0x00a1:
            java.lang.String r9 = r2.toString()
        L_0x00a5:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ha.a(java.lang.String, java.util.Map):java.lang.String");
    }

    private static String a(HttpURLConnection httpURLConnection) {
        List list;
        if (httpURLConnection == null) {
            return "";
        }
        try {
            Map headerFields = httpURLConnection.getHeaderFields();
            if (!(headerFields == null || (list = (List) headerFields.get("gsid")) == null || list.size() <= 0)) {
                return (String) list.get(0);
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    static String a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            String str2 = (String) next.getValue();
            if (str2 == null) {
                str2 = "";
            }
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(URLEncoder.encode(str));
            sb.append("=");
            sb.append(URLEncoder.encode(str2));
        }
        return sb.toString();
    }

    private void a(Map<String, String> map, HttpURLConnection httpURLConnection, boolean z2) {
        String str;
        c f2;
        if (map != null) {
            try {
                for (String next : map.keySet()) {
                    httpURLConnection.addRequestProperty(next, map.get(next));
                }
            } catch (Throwable th) {
                fw.a(th, "ht", "adh");
                return;
            }
        }
        if (gw.f8984d != null) {
            for (String next2 : gw.f8984d.keySet()) {
                httpURLConnection.addRequestProperty(next2, gw.f8984d.get(next2));
            }
        }
        if (z2 && !this.f9033m.contains("/v3/iasdkauth") && !TextUtils.isEmpty(this.f9031j) && ew.a(this.f9031j)) {
            this.f9035o = true;
            httpURLConnection.addRequestProperty("lct", String.valueOf(ew.c(this.f9031j)));
        }
        httpURLConnection.addRequestProperty("csid", this.f9028g);
        if (a(this.f9040u.f9073c.f9057e)) {
            f fVar = this.f9040u;
            if (TextUtils.isEmpty(fVar.f9073c.f9055c)) {
                str = "";
            } else {
                String b2 = fa.b(gm.a(fVar.f9073c.f9055c.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                StringBuilder sb = new StringBuilder("上报本次请求serverIp:");
                sb.append(fVar.f9073c.f9055c);
                sb.append("加密后：");
                sb.append(b2);
                str = b2;
            }
            if (!TextUtils.isEmpty(str)) {
                httpURLConnection.addRequestProperty("sip", str);
            }
            if (ew.f8620j && (f2 = ew.f()) != null) {
                httpURLConnection.addRequestProperty("nls", f2.b());
                this.f9040u.f9075e = f2;
            }
            a e2 = ew.e();
            if (e2 != null) {
                httpURLConnection.addRequestProperty("nlf", e2.b());
                this.f9040u.f9074d = e2;
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean a(String str) {
        if (!this.f9032l) {
            return (!TextUtils.isEmpty(this.f9034n) && (this.f9034n.contains("rest") || this.f9034n.contains("apilocate"))) || b(str);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003f A[Catch:{ all -> 0x0072 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0040 A[Catch:{ all -> 0x0072 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r7, boolean r8) {
        /*
            r6 = this;
            java.lang.String r0 = "#"
            java.lang.String r1 = "lct"
            r2 = 1
            r3 = 0
            java.lang.String r4 = "sc"
            java.lang.Object r4 = r7.get(r4)     // Catch:{ all -> 0x0072 }
            java.util.List r4 = (java.util.List) r4     // Catch:{ all -> 0x0072 }
            if (r4 == 0) goto L_0x003c
            int r5 = r4.size()     // Catch:{ all -> 0x0072 }
            if (r5 <= 0) goto L_0x003c
            java.lang.Object r4 = r4.get(r3)     // Catch:{ all -> 0x0072 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0072 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0072 }
            if (r5 != 0) goto L_0x003c
            boolean r5 = r4.contains(r0)     // Catch:{ all -> 0x0072 }
            if (r5 != 0) goto L_0x002a
        L_0x0028:
            r0 = 1
            goto L_0x003d
        L_0x002a:
            java.lang.String[] r0 = r4.split(r0)     // Catch:{ all -> 0x0072 }
            int r4 = r0.length     // Catch:{ all -> 0x0072 }
            if (r4 <= r2) goto L_0x003c
            java.lang.String r4 = "1"
            r0 = r0[r2]     // Catch:{ all -> 0x0072 }
            boolean r0 = r4.equals(r0)     // Catch:{ all -> 0x0072 }
            if (r0 == 0) goto L_0x003c
            goto L_0x0028
        L_0x003c:
            r0 = 0
        L_0x003d:
            if (r0 != 0) goto L_0x0040
            return r3
        L_0x0040:
            if (r8 == 0) goto L_0x0073
            boolean r8 = r7.containsKey(r1)     // Catch:{ all -> 0x0072 }
            if (r8 == 0) goto L_0x0072
            java.lang.Object r7 = r7.get(r1)     // Catch:{ all -> 0x0072 }
            java.util.List r7 = (java.util.List) r7     // Catch:{ all -> 0x0072 }
            if (r7 == 0) goto L_0x0072
            int r8 = r7.size()     // Catch:{ all -> 0x0072 }
            if (r8 <= 0) goto L_0x0072
            java.lang.Object r7 = r7.get(r3)     // Catch:{ all -> 0x0072 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0072 }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0072 }
            if (r8 != 0) goto L_0x0072
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0072 }
            long r7 = r7.longValue()     // Catch:{ all -> 0x0072 }
            java.lang.String r0 = r6.f9031j     // Catch:{ all -> 0x0072 }
            boolean r7 = com.amap.api.mapcore.util.ew.a((java.lang.String) r0, (long) r7)     // Catch:{ all -> 0x0072 }
            r2 = r7
            goto L_0x0073
        L_0x0072:
            r2 = 0
        L_0x0073:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ha.a(java.util.Map, boolean):boolean");
    }

    private static String b(Map<String, List<String>> map) {
        try {
            List list = map.get("sc");
            if (list == null || list.size() <= 0) {
                return "";
            }
            String str = (String) list.get(0);
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (str.contains("#")) {
                String[] split = str.split("#");
                if (split.length <= 1) {
                    return "";
                }
                str = split[0];
            }
            return str;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void b() {
    }

    private static boolean b(String str) {
        return str.contains("rest") || str.contains("apilocate");
    }

    private hb c() {
        try {
            SoftReference<hb> softReference = f9021t;
            if (softReference == null || softReference.get() == null) {
                f9021t = new SoftReference<>(new hb(ew.f8613c, this.f9023b));
            }
            hb hbVar = f9020k != null ? f9021t.get() : null;
            return hbVar == null ? new hb(ew.f8613c, this.f9023b) : hbVar;
        } catch (Throwable th) {
            fz.c(th, "ht", "gsf");
            return null;
        }
    }

    private void d(hd hdVar) throws eu {
        this.f9030i = new d((byte) 0);
        this.f9036p = hdVar.isIPV6Request();
        this.f9024c = hdVar.getProxy();
        this.f9029h = hdVar.getUrlConnectionImpl();
        this.f9032l = hdVar.isBinary();
        this.f9031j = hdVar.parseSdkNameFromRequest();
        this.f9022a = fb.a().a(hdVar.isHttps());
        String b2 = hdVar.getDegradeType().b() ? hdVar.b() : hdVar.a();
        this.f9033m = b2;
        this.f9033m = gz.a(b2, this.f9031j);
        this.f9034n = hdVar.getIPDNSName();
        if ("loc".equals(this.f9031j)) {
            String a2 = hdVar.a();
            String b3 = hdVar.b();
            if (!TextUtils.isEmpty(a2)) {
                try {
                    this.f9038r = new URL(a2).getHost();
                } catch (Exception unused) {
                }
            }
            if (!TextUtils.isEmpty(b3)) {
                try {
                    if (!TextUtils.isEmpty(this.f9034n)) {
                        this.f9037q = this.f9034n;
                    } else {
                        this.f9037q = new URL(b3).getHost();
                    }
                } catch (Exception unused2) {
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Map<String, String> a(hd hdVar) throws eu {
        String headerFieldKey;
        HttpURLConnection httpURLConnection = null;
        try {
            d(hdVar);
            this.f9033m = a(this.f9033m, hdVar.getParams());
            int i2 = 0;
            HttpURLConnection httpURLConnection2 = a(hdVar, false, false).f9051a;
            try {
                this.f9040u.f9072b = SystemClock.elapsedRealtime();
                httpURLConnection2.connect();
                this.f9040u.a();
                int responseCode = httpURLConnection2.getResponseCode();
                if (responseCode < 400) {
                    HashMap hashMap = new HashMap();
                    while (i2 < 50 && (headerFieldKey = httpURLConnection2.getHeaderFieldKey(i2)) != null) {
                        hashMap.put(headerFieldKey.toLowerCase(), httpURLConnection2.getHeaderField(headerFieldKey));
                        i2++;
                    }
                    this.f9040u.a((he) null);
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.disconnect();
                        } catch (Throwable th) {
                            fw.a(th, "hth", "mgr");
                        }
                    }
                    this.f9040u.d();
                    return hashMap;
                }
                this.f9040u.b(responseCode);
                this.f9040u.a(10);
                eu euVar = new eu("http读取header失败");
                euVar.a(responseCode);
                throw euVar;
            } catch (ConnectException e2) {
                e = e2;
                HttpURLConnection httpURLConnection3 = httpURLConnection2;
                this.f9040u.b(a((Exception) e));
                this.f9040u.a(6);
                throw new eu(AMapException.ERROR_CONNECTION);
            } catch (SSLException e3) {
                e = e3;
                HttpURLConnection httpURLConnection4 = httpURLConnection2;
                e.printStackTrace();
                this.f9040u.b(a((Exception) e));
                this.f9040u.a(4);
                throw new eu(AMapException.ERROR_IO);
            } catch (ConnectTimeoutException e4) {
                e = e4;
                HttpURLConnection httpURLConnection5 = httpURLConnection2;
                e.printStackTrace();
                this.f9040u.b(a((Exception) e));
                this.f9040u.a(2);
                throw new eu(AMapException.ERROR_IO);
            } catch (MalformedURLException unused) {
                HttpURLConnection httpURLConnection6 = httpURLConnection2;
                this.f9040u.a(8);
                throw new eu(AMapException.ERROR_URL);
            } catch (UnknownHostException unused2) {
                HttpURLConnection httpURLConnection7 = httpURLConnection2;
                this.f9040u.a(9);
                throw new eu(AMapException.ERROR_UNKNOW_HOST);
            } catch (SocketException e5) {
                e = e5;
                HttpURLConnection httpURLConnection8 = httpURLConnection2;
                this.f9040u.b(a((Exception) e));
                this.f9040u.a(6);
                throw new eu(AMapException.ERROR_SOCKET);
            } catch (SocketTimeoutException e6) {
                e = e6;
                HttpURLConnection httpURLConnection9 = httpURLConnection2;
                this.f9040u.b(a((Exception) e));
                this.f9040u.a(2);
                throw new eu(AMapException.ERROR_SOCKE_TIME_OUT);
            } catch (InterruptedIOException unused3) {
                HttpURLConnection httpURLConnection10 = httpURLConnection2;
                this.f9040u.b(7101);
                this.f9040u.a(7);
                throw new eu(AMapException.ERROR_UNKNOWN);
            } catch (IOException unused4) {
                HttpURLConnection httpURLConnection11 = httpURLConnection2;
                this.f9040u.a(7);
                throw new eu(AMapException.ERROR_IO);
            } catch (eu e7) {
                e = e7;
                HttpURLConnection httpURLConnection12 = httpURLConnection2;
                this.f9040u.a(e.g());
                throw e;
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = httpURLConnection2;
                this.f9040u.a(9);
                th.printStackTrace();
                throw new eu(AMapException.ERROR_UNKNOWN);
            }
        } catch (ConnectException e8) {
            e = e8;
            this.f9040u.b(a((Exception) e));
            this.f9040u.a(6);
            throw new eu(AMapException.ERROR_CONNECTION);
        } catch (SSLException e9) {
            e = e9;
            e.printStackTrace();
            this.f9040u.b(a((Exception) e));
            this.f9040u.a(4);
            throw new eu(AMapException.ERROR_IO);
        } catch (ConnectTimeoutException e10) {
            e = e10;
            e.printStackTrace();
            this.f9040u.b(a((Exception) e));
            this.f9040u.a(2);
            throw new eu(AMapException.ERROR_IO);
        } catch (MalformedURLException unused5) {
            this.f9040u.a(8);
            throw new eu(AMapException.ERROR_URL);
        } catch (UnknownHostException unused6) {
            this.f9040u.a(9);
            throw new eu(AMapException.ERROR_UNKNOW_HOST);
        } catch (SocketException e11) {
            e = e11;
            this.f9040u.b(a((Exception) e));
            this.f9040u.a(6);
            throw new eu(AMapException.ERROR_SOCKET);
        } catch (SocketTimeoutException e12) {
            e = e12;
            this.f9040u.b(a((Exception) e));
            this.f9040u.a(2);
            throw new eu(AMapException.ERROR_SOCKE_TIME_OUT);
        } catch (InterruptedIOException unused7) {
            this.f9040u.b(7101);
            this.f9040u.a(7);
            throw new eu(AMapException.ERROR_UNKNOWN);
        } catch (IOException unused8) {
            this.f9040u.a(7);
            throw new eu(AMapException.ERROR_IO);
        } catch (eu e13) {
            e = e13;
            this.f9040u.a(e.g());
            throw e;
        } catch (Throwable th3) {
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable th4) {
                    fw.a(th4, "hth", "mgr");
                }
            }
            this.f9040u.d();
            throw th3;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f9025d = true;
    }

    /* access modifiers changed from: package-private */
    public final void a(long j2) {
        this.f9027f = j2;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0148 A[SYNTHETIC, Splitter:B:110:0x0148] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0194 A[SYNTHETIC, Splitter:B:124:0x0194] */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x0374 A[SYNTHETIC, Splitter:B:275:0x0374] */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x0381 A[SYNTHETIC, Splitter:B:280:0x0381] */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x038c A[SYNTHETIC, Splitter:B:285:0x038c] */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x03ae A[SYNTHETIC, Splitter:B:296:0x03ae] */
    /* JADX WARNING: Removed duplicated region for block: B:301:0x03bb A[SYNTHETIC, Splitter:B:301:0x03bb] */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x03c6 A[SYNTHETIC, Splitter:B:306:0x03c6] */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x03e5 A[SYNTHETIC, Splitter:B:317:0x03e5] */
    /* JADX WARNING: Removed duplicated region for block: B:322:0x03f2 A[SYNTHETIC, Splitter:B:322:0x03f2] */
    /* JADX WARNING: Removed duplicated region for block: B:327:0x03fd A[SYNTHETIC, Splitter:B:327:0x03fd] */
    /* JADX WARNING: Removed duplicated region for block: B:338:0x0423 A[SYNTHETIC, Splitter:B:338:0x0423] */
    /* JADX WARNING: Removed duplicated region for block: B:343:0x0430 A[SYNTHETIC, Splitter:B:343:0x0430] */
    /* JADX WARNING: Removed duplicated region for block: B:348:0x043b A[SYNTHETIC, Splitter:B:348:0x043b] */
    /* JADX WARNING: Removed duplicated region for block: B:359:0x0463 A[SYNTHETIC, Splitter:B:359:0x0463] */
    /* JADX WARNING: Removed duplicated region for block: B:364:0x0470 A[SYNTHETIC, Splitter:B:364:0x0470] */
    /* JADX WARNING: Removed duplicated region for block: B:369:0x047b A[SYNTHETIC, Splitter:B:369:0x047b] */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x04a3 A[SYNTHETIC, Splitter:B:380:0x04a3] */
    /* JADX WARNING: Removed duplicated region for block: B:385:0x04b0 A[SYNTHETIC, Splitter:B:385:0x04b0] */
    /* JADX WARNING: Removed duplicated region for block: B:390:0x04bb A[SYNTHETIC, Splitter:B:390:0x04bb] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ab A[SYNTHETIC, Splitter:B:39:0x00ab] */
    /* JADX WARNING: Removed duplicated region for block: B:401:0x04da A[SYNTHETIC, Splitter:B:401:0x04da] */
    /* JADX WARNING: Removed duplicated region for block: B:406:0x04e7 A[SYNTHETIC, Splitter:B:406:0x04e7] */
    /* JADX WARNING: Removed duplicated region for block: B:411:0x04f2 A[SYNTHETIC, Splitter:B:411:0x04f2] */
    /* JADX WARNING: Removed duplicated region for block: B:422:0x0512 A[SYNTHETIC, Splitter:B:422:0x0512] */
    /* JADX WARNING: Removed duplicated region for block: B:427:0x051f A[SYNTHETIC, Splitter:B:427:0x051f] */
    /* JADX WARNING: Removed duplicated region for block: B:432:0x052a A[SYNTHETIC, Splitter:B:432:0x052a] */
    /* JADX WARNING: Removed duplicated region for block: B:443:0x0555 A[SYNTHETIC, Splitter:B:443:0x0555] */
    /* JADX WARNING: Removed duplicated region for block: B:448:0x0562 A[SYNTHETIC, Splitter:B:448:0x0562] */
    /* JADX WARNING: Removed duplicated region for block: B:453:0x056d A[SYNTHETIC, Splitter:B:453:0x056d] */
    /* JADX WARNING: Removed duplicated region for block: B:464:0x0598 A[SYNTHETIC, Splitter:B:464:0x0598] */
    /* JADX WARNING: Removed duplicated region for block: B:469:0x05a5 A[SYNTHETIC, Splitter:B:469:0x05a5] */
    /* JADX WARNING: Removed duplicated region for block: B:474:0x05b0 A[SYNTHETIC, Splitter:B:474:0x05b0] */
    /* JADX WARNING: Removed duplicated region for block: B:485:0x05d8 A[SYNTHETIC, Splitter:B:485:0x05d8] */
    /* JADX WARNING: Removed duplicated region for block: B:490:0x05e5 A[SYNTHETIC, Splitter:B:490:0x05e5] */
    /* JADX WARNING: Removed duplicated region for block: B:495:0x05f0 A[SYNTHETIC, Splitter:B:495:0x05f0] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x012f  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:293:0x03a0=Splitter:B:293:0x03a0, B:335:0x0411=Splitter:B:335:0x0411, B:461:0x0581=Splitter:B:461:0x0581, B:482:0x05c4=Splitter:B:482:0x05c4, B:419:0x0506=Splitter:B:419:0x0506, B:272:0x0368=Splitter:B:272:0x0368, B:314:0x03da=Splitter:B:314:0x03da, B:440:0x053e=Splitter:B:440:0x053e, B:356:0x044f=Splitter:B:356:0x044f, B:377:0x048f=Splitter:B:377:0x048f, B:398:0x04cf=Splitter:B:398:0x04cf} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.amap.api.mapcore.util.hd r20, com.amap.api.mapcore.util.gy.a r21) {
        /*
            r19 = this;
            r1 = r19
            r2 = r21
            java.lang.String r3 = "mdr"
            java.lang.String r4 = "ht"
            if (r2 != 0) goto L_0x000b
            return
        L_0x000b:
            r19.d(r20)     // Catch:{ ConnectException -> 0x05bf, SSLException -> 0x057c, ConnectTimeoutException -> 0x0539, MalformedURLException -> 0x0501, UnknownHostException -> 0x04ca, SocketException -> 0x048a, SocketTimeoutException -> 0x044a, InterruptedIOException -> 0x040c, IOException -> 0x03d5, eu -> 0x039b, all -> 0x0363 }
            java.lang.String r9 = r1.f9033m     // Catch:{ ConnectException -> 0x05bf, SSLException -> 0x057c, ConnectTimeoutException -> 0x0539, MalformedURLException -> 0x0501, UnknownHostException -> 0x04ca, SocketException -> 0x048a, SocketTimeoutException -> 0x044a, InterruptedIOException -> 0x040c, IOException -> 0x03d5, eu -> 0x039b, all -> 0x0363 }
            java.util.Map r10 = r20.getParams()     // Catch:{ ConnectException -> 0x05bf, SSLException -> 0x057c, ConnectTimeoutException -> 0x0539, MalformedURLException -> 0x0501, UnknownHostException -> 0x04ca, SocketException -> 0x048a, SocketTimeoutException -> 0x044a, InterruptedIOException -> 0x040c, IOException -> 0x03d5, eu -> 0x039b, all -> 0x0363 }
            java.lang.String r9 = a((java.lang.String) r9, (java.util.Map<java.lang.String, java.lang.String>) r10)     // Catch:{ ConnectException -> 0x05bf, SSLException -> 0x057c, ConnectTimeoutException -> 0x0539, MalformedURLException -> 0x0501, UnknownHostException -> 0x04ca, SocketException -> 0x048a, SocketTimeoutException -> 0x044a, InterruptedIOException -> 0x040c, IOException -> 0x03d5, eu -> 0x039b, all -> 0x0363 }
            r1.f9033m = r9     // Catch:{ ConnectException -> 0x05bf, SSLException -> 0x057c, ConnectTimeoutException -> 0x0539, MalformedURLException -> 0x0501, UnknownHostException -> 0x04ca, SocketException -> 0x048a, SocketTimeoutException -> 0x044a, InterruptedIOException -> 0x040c, IOException -> 0x03d5, eu -> 0x039b, all -> 0x0363 }
            byte[] r9 = r20.getEntityBytes()     // Catch:{ ConnectException -> 0x05bf, SSLException -> 0x057c, ConnectTimeoutException -> 0x0539, MalformedURLException -> 0x0501, UnknownHostException -> 0x04ca, SocketException -> 0x048a, SocketTimeoutException -> 0x044a, InterruptedIOException -> 0x040c, IOException -> 0x03d5, eu -> 0x039b, all -> 0x0363 }
            r10 = 1
            r11 = 0
            if (r9 == 0) goto L_0x0076
            int r12 = r9.length     // Catch:{ ConnectException -> 0x006f, SSLException -> 0x0068, ConnectTimeoutException -> 0x0061, MalformedURLException -> 0x005a, UnknownHostException -> 0x0053, SocketException -> 0x004c, SocketTimeoutException -> 0x0045, InterruptedIOException -> 0x003e, IOException -> 0x0037, eu -> 0x0030, all -> 0x0029 }
            if (r12 <= 0) goto L_0x0076
            r12 = r20
            r13 = 1
            goto L_0x0079
        L_0x0029:
            r0 = move-exception
            r5 = r0
            r7 = 0
            r8 = 0
            r12 = 0
            goto L_0x0368
        L_0x0030:
            r0 = move-exception
            r5 = r0
            r7 = 0
            r8 = 0
            r12 = 0
            goto L_0x03a0
        L_0x0037:
            r0 = move-exception
            r5 = r0
            r7 = 0
            r8 = 0
            r12 = 0
            goto L_0x03da
        L_0x003e:
            r0 = move-exception
            r5 = r0
            r7 = 0
            r8 = 0
            r12 = 0
            goto L_0x0411
        L_0x0045:
            r0 = move-exception
            r5 = r0
            r7 = 0
            r8 = 0
            r12 = 0
            goto L_0x044f
        L_0x004c:
            r0 = move-exception
            r5 = r0
            r7 = 0
            r8 = 0
            r12 = 0
            goto L_0x048f
        L_0x0053:
            r0 = move-exception
            r5 = r0
            r7 = 0
            r8 = 0
            r12 = 0
            goto L_0x04cf
        L_0x005a:
            r0 = move-exception
            r5 = r0
            r7 = 0
            r8 = 0
            r12 = 0
            goto L_0x0506
        L_0x0061:
            r0 = move-exception
            r5 = r0
            r7 = 0
            r8 = 0
            r12 = 0
            goto L_0x053e
        L_0x0068:
            r0 = move-exception
            r5 = r0
            r7 = 0
            r8 = 0
            r12 = 0
            goto L_0x0581
        L_0x006f:
            r0 = move-exception
            r5 = r0
            r7 = 0
            r8 = 0
            r12 = 0
            goto L_0x05c4
        L_0x0076:
            r12 = r20
            r13 = 0
        L_0x0079:
            com.amap.api.mapcore.util.ha$b r12 = r1.a((com.amap.api.mapcore.util.hd) r12, (boolean) r13, (boolean) r11)     // Catch:{ ConnectException -> 0x05bf, SSLException -> 0x057c, ConnectTimeoutException -> 0x0539, MalformedURLException -> 0x0501, UnknownHostException -> 0x04ca, SocketException -> 0x048a, SocketTimeoutException -> 0x044a, InterruptedIOException -> 0x040c, IOException -> 0x03d5, eu -> 0x039b, all -> 0x0363 }
            java.net.HttpURLConnection r12 = r12.f9051a     // Catch:{ ConnectException -> 0x05bf, SSLException -> 0x057c, ConnectTimeoutException -> 0x0539, MalformedURLException -> 0x0501, UnknownHostException -> 0x04ca, SocketException -> 0x048a, SocketTimeoutException -> 0x044a, InterruptedIOException -> 0x040c, IOException -> 0x03d5, eu -> 0x039b, all -> 0x0363 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ ConnectException -> 0x035d, SSLException -> 0x0357, ConnectTimeoutException -> 0x0351, MalformedURLException -> 0x034b, UnknownHostException -> 0x0345, SocketException -> 0x033f, SocketTimeoutException -> 0x0339, InterruptedIOException -> 0x0333, IOException -> 0x032d, eu -> 0x0327, all -> 0x0322 }
            java.lang.String r15 = "bytes="
            r14.<init>(r15)     // Catch:{ ConnectException -> 0x035d, SSLException -> 0x0357, ConnectTimeoutException -> 0x0351, MalformedURLException -> 0x034b, UnknownHostException -> 0x0345, SocketException -> 0x033f, SocketTimeoutException -> 0x0339, InterruptedIOException -> 0x0333, IOException -> 0x032d, eu -> 0x0327, all -> 0x0322 }
            long r5 = r1.f9027f     // Catch:{ ConnectException -> 0x035d, SSLException -> 0x0357, ConnectTimeoutException -> 0x0351, MalformedURLException -> 0x034b, UnknownHostException -> 0x0345, SocketException -> 0x033f, SocketTimeoutException -> 0x0339, InterruptedIOException -> 0x0333, IOException -> 0x032d, eu -> 0x0327, all -> 0x0322 }
            r14.append(r5)     // Catch:{ ConnectException -> 0x035d, SSLException -> 0x0357, ConnectTimeoutException -> 0x0351, MalformedURLException -> 0x034b, UnknownHostException -> 0x0345, SocketException -> 0x033f, SocketTimeoutException -> 0x0339, InterruptedIOException -> 0x0333, IOException -> 0x032d, eu -> 0x0327, all -> 0x0322 }
            java.lang.String r5 = "-"
            r14.append(r5)     // Catch:{ ConnectException -> 0x035d, SSLException -> 0x0357, ConnectTimeoutException -> 0x0351, MalformedURLException -> 0x034b, UnknownHostException -> 0x0345, SocketException -> 0x033f, SocketTimeoutException -> 0x0339, InterruptedIOException -> 0x0333, IOException -> 0x032d, eu -> 0x0327, all -> 0x0322 }
            java.lang.String r5 = r14.toString()     // Catch:{ ConnectException -> 0x035d, SSLException -> 0x0357, ConnectTimeoutException -> 0x0351, MalformedURLException -> 0x034b, UnknownHostException -> 0x0345, SocketException -> 0x033f, SocketTimeoutException -> 0x0339, InterruptedIOException -> 0x0333, IOException -> 0x032d, eu -> 0x0327, all -> 0x0322 }
            java.lang.String r6 = "RANGE"
            r12.setRequestProperty(r6, r5)     // Catch:{ ConnectException -> 0x035d, SSLException -> 0x0357, ConnectTimeoutException -> 0x0351, MalformedURLException -> 0x034b, UnknownHostException -> 0x0345, SocketException -> 0x033f, SocketTimeoutException -> 0x0339, InterruptedIOException -> 0x0333, IOException -> 0x032d, eu -> 0x0327, all -> 0x0322 }
            com.amap.api.mapcore.util.ha$f r5 = r1.f9040u     // Catch:{ ConnectException -> 0x035d, SSLException -> 0x0357, ConnectTimeoutException -> 0x0351, MalformedURLException -> 0x034b, UnknownHostException -> 0x0345, SocketException -> 0x033f, SocketTimeoutException -> 0x0339, InterruptedIOException -> 0x0333, IOException -> 0x032d, eu -> 0x0327, all -> 0x0322 }
            long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ ConnectException -> 0x035d, SSLException -> 0x0357, ConnectTimeoutException -> 0x0351, MalformedURLException -> 0x034b, UnknownHostException -> 0x0345, SocketException -> 0x033f, SocketTimeoutException -> 0x0339, InterruptedIOException -> 0x0333, IOException -> 0x032d, eu -> 0x0327, all -> 0x0322 }
            r5.f9072b = r7     // Catch:{ ConnectException -> 0x035d, SSLException -> 0x0357, ConnectTimeoutException -> 0x0351, MalformedURLException -> 0x034b, UnknownHostException -> 0x0345, SocketException -> 0x033f, SocketTimeoutException -> 0x0339, InterruptedIOException -> 0x0333, IOException -> 0x032d, eu -> 0x0327, all -> 0x0322 }
            r12.connect()     // Catch:{ ConnectException -> 0x035d, SSLException -> 0x0357, ConnectTimeoutException -> 0x0351, MalformedURLException -> 0x034b, UnknownHostException -> 0x0345, SocketException -> 0x033f, SocketTimeoutException -> 0x0339, InterruptedIOException -> 0x0333, IOException -> 0x032d, eu -> 0x0327, all -> 0x0322 }
            com.amap.api.mapcore.util.ha$f r5 = r1.f9040u     // Catch:{ ConnectException -> 0x035d, SSLException -> 0x0357, ConnectTimeoutException -> 0x0351, MalformedURLException -> 0x034b, UnknownHostException -> 0x0345, SocketException -> 0x033f, SocketTimeoutException -> 0x0339, InterruptedIOException -> 0x0333, IOException -> 0x032d, eu -> 0x0327, all -> 0x0322 }
            r5.a()     // Catch:{ ConnectException -> 0x035d, SSLException -> 0x0357, ConnectTimeoutException -> 0x0351, MalformedURLException -> 0x034b, UnknownHostException -> 0x0345, SocketException -> 0x033f, SocketTimeoutException -> 0x0339, InterruptedIOException -> 0x0333, IOException -> 0x032d, eu -> 0x0327, all -> 0x0322 }
            if (r13 == 0) goto L_0x012f
            com.amap.api.mapcore.util.ha$f r5 = r1.f9040u     // Catch:{ ConnectException -> 0x0129, SSLException -> 0x0123, ConnectTimeoutException -> 0x011d, MalformedURLException -> 0x0117, UnknownHostException -> 0x0111, SocketException -> 0x010b, SocketTimeoutException -> 0x0105, InterruptedIOException -> 0x00ff, IOException -> 0x00f9, eu -> 0x00f3, all -> 0x00ed }
            long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ ConnectException -> 0x0129, SSLException -> 0x0123, ConnectTimeoutException -> 0x011d, MalformedURLException -> 0x0117, UnknownHostException -> 0x0111, SocketException -> 0x010b, SocketTimeoutException -> 0x0105, InterruptedIOException -> 0x00ff, IOException -> 0x00f9, eu -> 0x00f3, all -> 0x00ed }
            r5.f9072b = r7     // Catch:{ ConnectException -> 0x0129, SSLException -> 0x0123, ConnectTimeoutException -> 0x011d, MalformedURLException -> 0x0117, UnknownHostException -> 0x0111, SocketException -> 0x010b, SocketTimeoutException -> 0x0105, InterruptedIOException -> 0x00ff, IOException -> 0x00f9, eu -> 0x00f3, all -> 0x00ed }
            java.io.OutputStream r5 = r12.getOutputStream()     // Catch:{ ConnectException -> 0x0129, SSLException -> 0x0123, ConnectTimeoutException -> 0x011d, MalformedURLException -> 0x0117, UnknownHostException -> 0x0111, SocketException -> 0x010b, SocketTimeoutException -> 0x0105, InterruptedIOException -> 0x00ff, IOException -> 0x00f9, eu -> 0x00f3, all -> 0x00ed }
            java.io.DataOutputStream r7 = new java.io.DataOutputStream     // Catch:{ ConnectException -> 0x0129, SSLException -> 0x0123, ConnectTimeoutException -> 0x011d, MalformedURLException -> 0x0117, UnknownHostException -> 0x0111, SocketException -> 0x010b, SocketTimeoutException -> 0x0105, InterruptedIOException -> 0x00ff, IOException -> 0x00f9, eu -> 0x00f3, all -> 0x00ed }
            r7.<init>(r5)     // Catch:{ ConnectException -> 0x0129, SSLException -> 0x0123, ConnectTimeoutException -> 0x011d, MalformedURLException -> 0x0117, UnknownHostException -> 0x0111, SocketException -> 0x010b, SocketTimeoutException -> 0x0105, InterruptedIOException -> 0x00ff, IOException -> 0x00f9, eu -> 0x00f3, all -> 0x00ed }
            r7.write(r9)     // Catch:{ ConnectException -> 0x00ea, SSLException -> 0x00e7, ConnectTimeoutException -> 0x00e4, MalformedURLException -> 0x00e1, UnknownHostException -> 0x00de, SocketException -> 0x00db, SocketTimeoutException -> 0x00d8, InterruptedIOException -> 0x00d5, IOException -> 0x00d2, eu -> 0x00cf, all -> 0x00cc }
            r7.close()     // Catch:{ ConnectException -> 0x00ea, SSLException -> 0x00e7, ConnectTimeoutException -> 0x00e4, MalformedURLException -> 0x00e1, UnknownHostException -> 0x00de, SocketException -> 0x00db, SocketTimeoutException -> 0x00d8, InterruptedIOException -> 0x00d5, IOException -> 0x00d2, eu -> 0x00cf, all -> 0x00cc }
            r5.close()     // Catch:{ ConnectException -> 0x00ea, SSLException -> 0x00e7, ConnectTimeoutException -> 0x00e4, MalformedURLException -> 0x00e1, UnknownHostException -> 0x00de, SocketException -> 0x00db, SocketTimeoutException -> 0x00d8, InterruptedIOException -> 0x00d5, IOException -> 0x00d2, eu -> 0x00cf, all -> 0x00cc }
            com.amap.api.mapcore.util.ha$f r5 = r1.f9040u     // Catch:{ ConnectException -> 0x00ea, SSLException -> 0x00e7, ConnectTimeoutException -> 0x00e4, MalformedURLException -> 0x00e1, UnknownHostException -> 0x00de, SocketException -> 0x00db, SocketTimeoutException -> 0x00d8, InterruptedIOException -> 0x00d5, IOException -> 0x00d2, eu -> 0x00cf, all -> 0x00cc }
            r5.b()     // Catch:{ ConnectException -> 0x00ea, SSLException -> 0x00e7, ConnectTimeoutException -> 0x00e4, MalformedURLException -> 0x00e1, UnknownHostException -> 0x00de, SocketException -> 0x00db, SocketTimeoutException -> 0x00d8, InterruptedIOException -> 0x00d5, IOException -> 0x00d2, eu -> 0x00cf, all -> 0x00cc }
            goto L_0x0130
        L_0x00cc:
            r0 = move-exception
            r5 = r0
            goto L_0x00f0
        L_0x00cf:
            r0 = move-exception
            r5 = r0
            goto L_0x00f6
        L_0x00d2:
            r0 = move-exception
            r5 = r0
            goto L_0x00fc
        L_0x00d5:
            r0 = move-exception
            r5 = r0
            goto L_0x0102
        L_0x00d8:
            r0 = move-exception
            r5 = r0
            goto L_0x0108
        L_0x00db:
            r0 = move-exception
            r5 = r0
            goto L_0x010e
        L_0x00de:
            r0 = move-exception
            r5 = r0
            goto L_0x0114
        L_0x00e1:
            r0 = move-exception
            r5 = r0
            goto L_0x011a
        L_0x00e4:
            r0 = move-exception
            r5 = r0
            goto L_0x0120
        L_0x00e7:
            r0 = move-exception
            r5 = r0
            goto L_0x0126
        L_0x00ea:
            r0 = move-exception
            r5 = r0
            goto L_0x012c
        L_0x00ed:
            r0 = move-exception
            r5 = r0
            r7 = 0
        L_0x00f0:
            r8 = 0
            goto L_0x0368
        L_0x00f3:
            r0 = move-exception
            r5 = r0
            r7 = 0
        L_0x00f6:
            r8 = 0
            goto L_0x03a0
        L_0x00f9:
            r0 = move-exception
            r5 = r0
            r7 = 0
        L_0x00fc:
            r8 = 0
            goto L_0x03da
        L_0x00ff:
            r0 = move-exception
            r5 = r0
            r7 = 0
        L_0x0102:
            r8 = 0
            goto L_0x0411
        L_0x0105:
            r0 = move-exception
            r5 = r0
            r7 = 0
        L_0x0108:
            r8 = 0
            goto L_0x044f
        L_0x010b:
            r0 = move-exception
            r5 = r0
            r7 = 0
        L_0x010e:
            r8 = 0
            goto L_0x048f
        L_0x0111:
            r0 = move-exception
            r5 = r0
            r7 = 0
        L_0x0114:
            r8 = 0
            goto L_0x04cf
        L_0x0117:
            r0 = move-exception
            r5 = r0
            r7 = 0
        L_0x011a:
            r8 = 0
            goto L_0x0506
        L_0x011d:
            r0 = move-exception
            r5 = r0
            r7 = 0
        L_0x0120:
            r8 = 0
            goto L_0x053e
        L_0x0123:
            r0 = move-exception
            r5 = r0
            r7 = 0
        L_0x0126:
            r8 = 0
            goto L_0x0581
        L_0x0129:
            r0 = move-exception
            r5 = r0
            r7 = 0
        L_0x012c:
            r8 = 0
            goto L_0x05c4
        L_0x012f:
            r7 = 0
        L_0x0130:
            java.lang.String r5 = a((java.net.HttpURLConnection) r12)     // Catch:{ ConnectException -> 0x0318, SSLException -> 0x030e, ConnectTimeoutException -> 0x0304, MalformedURLException -> 0x02fa, UnknownHostException -> 0x02f0, SocketException -> 0x02e6, SocketTimeoutException -> 0x02dc, InterruptedIOException -> 0x02d2, IOException -> 0x02c8, eu -> 0x02be, all -> 0x02b4 }
            int r8 = r12.getResponseCode()     // Catch:{ ConnectException -> 0x0318, SSLException -> 0x030e, ConnectTimeoutException -> 0x0304, MalformedURLException -> 0x02fa, UnknownHostException -> 0x02f0, SocketException -> 0x02e6, SocketTimeoutException -> 0x02dc, InterruptedIOException -> 0x02d2, IOException -> 0x02c8, eu -> 0x02be, all -> 0x02b4 }
            r9 = 200(0xc8, float:2.8E-43)
            if (r8 == r9) goto L_0x013e
            r9 = 1
            goto L_0x013f
        L_0x013e:
            r9 = 0
        L_0x013f:
            r13 = 206(0xce, float:2.89E-43)
            if (r8 == r13) goto L_0x0144
            goto L_0x0145
        L_0x0144:
            r10 = 0
        L_0x0145:
            r9 = r9 & r10
            if (r9 == 0) goto L_0x0194
            com.amap.api.mapcore.util.ha$f r9 = r1.f9040u     // Catch:{ ConnectException -> 0x00ea, SSLException -> 0x00e7, ConnectTimeoutException -> 0x00e4, MalformedURLException -> 0x00e1, UnknownHostException -> 0x00de, SocketException -> 0x00db, SocketTimeoutException -> 0x00d8, InterruptedIOException -> 0x00d5, IOException -> 0x00d2, eu -> 0x00cf, all -> 0x00cc }
            r9.b(r8)     // Catch:{ ConnectException -> 0x00ea, SSLException -> 0x00e7, ConnectTimeoutException -> 0x00e4, MalformedURLException -> 0x00e1, UnknownHostException -> 0x00de, SocketException -> 0x00db, SocketTimeoutException -> 0x00d8, InterruptedIOException -> 0x00d5, IOException -> 0x00d2, eu -> 0x00cf, all -> 0x00cc }
            com.amap.api.mapcore.util.ha$f r9 = r1.f9040u     // Catch:{ ConnectException -> 0x00ea, SSLException -> 0x00e7, ConnectTimeoutException -> 0x00e4, MalformedURLException -> 0x00e1, UnknownHostException -> 0x00de, SocketException -> 0x00db, SocketTimeoutException -> 0x00d8, InterruptedIOException -> 0x00d5, IOException -> 0x00d2, eu -> 0x00cf, all -> 0x00cc }
            r10 = 10
            r9.a((int) r10)     // Catch:{ ConnectException -> 0x00ea, SSLException -> 0x00e7, ConnectTimeoutException -> 0x00e4, MalformedURLException -> 0x00e1, UnknownHostException -> 0x00de, SocketException -> 0x00db, SocketTimeoutException -> 0x00d8, InterruptedIOException -> 0x00d5, IOException -> 0x00d2, eu -> 0x00cf, all -> 0x00cc }
            com.amap.api.mapcore.util.eu r9 = new com.amap.api.mapcore.util.eu     // Catch:{ ConnectException -> 0x00ea, SSLException -> 0x00e7, ConnectTimeoutException -> 0x00e4, MalformedURLException -> 0x00e1, UnknownHostException -> 0x00de, SocketException -> 0x00db, SocketTimeoutException -> 0x00d8, InterruptedIOException -> 0x00d5, IOException -> 0x00d2, eu -> 0x00cf, all -> 0x00cc }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ ConnectException -> 0x00ea, SSLException -> 0x00e7, ConnectTimeoutException -> 0x00e4, MalformedURLException -> 0x00e1, UnknownHostException -> 0x00de, SocketException -> 0x00db, SocketTimeoutException -> 0x00d8, InterruptedIOException -> 0x00d5, IOException -> 0x00d2, eu -> 0x00cf, all -> 0x00cc }
            java.lang.String r11 = "网络异常原因："
            r10.<init>(r11)     // Catch:{ ConnectException -> 0x00ea, SSLException -> 0x00e7, ConnectTimeoutException -> 0x00e4, MalformedURLException -> 0x00e1, UnknownHostException -> 0x00de, SocketException -> 0x00db, SocketTimeoutException -> 0x00d8, InterruptedIOException -> 0x00d5, IOException -> 0x00d2, eu -> 0x00cf, all -> 0x00cc }
            java.lang.String r11 = r12.getResponseMessage()     // Catch:{ ConnectException -> 0x00ea, SSLException -> 0x00e7, ConnectTimeoutException -> 0x00e4, MalformedURLException -> 0x00e1, UnknownHostException -> 0x00de, SocketException -> 0x00db, SocketTimeoutException -> 0x00d8, InterruptedIOException -> 0x00d5, IOException -> 0x00d2, eu -> 0x00cf, all -> 0x00cc }
            r10.append(r11)     // Catch:{ ConnectException -> 0x00ea, SSLException -> 0x00e7, ConnectTimeoutException -> 0x00e4, MalformedURLException -> 0x00e1, UnknownHostException -> 0x00de, SocketException -> 0x00db, SocketTimeoutException -> 0x00d8, InterruptedIOException -> 0x00d5, IOException -> 0x00d2, eu -> 0x00cf, all -> 0x00cc }
            java.lang.String r11 = " 网络异常状态码："
            r10.append(r11)     // Catch:{ ConnectException -> 0x00ea, SSLException -> 0x00e7, ConnectTimeoutException -> 0x00e4, MalformedURLException -> 0x00e1, UnknownHostException -> 0x00de, SocketException -> 0x00db, SocketTimeoutException -> 0x00d8, InterruptedIOException -> 0x00d5, IOException -> 0x00d2, eu -> 0x00cf, all -> 0x00cc }
            r10.append(r8)     // Catch:{ ConnectException -> 0x00ea, SSLException -> 0x00e7, ConnectTimeoutException -> 0x00e4, MalformedURLException -> 0x00e1, UnknownHostException -> 0x00de, SocketException -> 0x00db, SocketTimeoutException -> 0x00d8, InterruptedIOException -> 0x00d5, IOException -> 0x00d2, eu -> 0x00cf, all -> 0x00cc }
            java.lang.String r8 = r10.toString()     // Catch:{ ConnectException -> 0x00ea, SSLException -> 0x00e7, ConnectTimeoutException -> 0x00e4, MalformedURLException -> 0x00e1, UnknownHostException -> 0x00de, SocketException -> 0x00db, SocketTimeoutException -> 0x00d8, InterruptedIOException -> 0x00d5, IOException -> 0x00d2, eu -> 0x00cf, all -> 0x00cc }
            java.lang.String r10 = r1.f9028g     // Catch:{ ConnectException -> 0x00ea, SSLException -> 0x00e7, ConnectTimeoutException -> 0x00e4, MalformedURLException -> 0x00e1, UnknownHostException -> 0x00de, SocketException -> 0x00db, SocketTimeoutException -> 0x00d8, InterruptedIOException -> 0x00d5, IOException -> 0x00d2, eu -> 0x00cf, all -> 0x00cc }
            r9.<init>(r8, r5, r10)     // Catch:{ ConnectException -> 0x00ea, SSLException -> 0x00e7, ConnectTimeoutException -> 0x00e4, MalformedURLException -> 0x00e1, UnknownHostException -> 0x00de, SocketException -> 0x00db, SocketTimeoutException -> 0x00d8, InterruptedIOException -> 0x00d5, IOException -> 0x00d2, eu -> 0x00cf, all -> 0x00cc }
            r2.onException(r9)     // Catch:{ ConnectException -> 0x00ea, SSLException -> 0x00e7, ConnectTimeoutException -> 0x00e4, MalformedURLException -> 0x00e1, UnknownHostException -> 0x00de, SocketException -> 0x00db, SocketTimeoutException -> 0x00d8, InterruptedIOException -> 0x00d5, IOException -> 0x00d2, eu -> 0x00cf, all -> 0x00cc }
            if (r12 == 0) goto L_0x0183
            r12.disconnect()     // Catch:{ all -> 0x017e }
            goto L_0x0183
        L_0x017e:
            r0 = move-exception
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x0183:
            if (r7 == 0) goto L_0x018e
            r7.close()     // Catch:{ all -> 0x0189 }
            goto L_0x018e
        L_0x0189:
            r0 = move-exception
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x018e:
            com.amap.api.mapcore.util.ha$f r2 = r1.f9040u
            r2.d()
            return
        L_0x0194:
            com.amap.api.mapcore.util.ha$f r5 = r1.f9040u     // Catch:{ ConnectException -> 0x0318, SSLException -> 0x030e, ConnectTimeoutException -> 0x0304, MalformedURLException -> 0x02fa, UnknownHostException -> 0x02f0, SocketException -> 0x02e6, SocketTimeoutException -> 0x02dc, InterruptedIOException -> 0x02d2, IOException -> 0x02c8, eu -> 0x02be, all -> 0x02b4 }
            long r8 = android.os.SystemClock.elapsedRealtime()     // Catch:{ ConnectException -> 0x0318, SSLException -> 0x030e, ConnectTimeoutException -> 0x0304, MalformedURLException -> 0x02fa, UnknownHostException -> 0x02f0, SocketException -> 0x02e6, SocketTimeoutException -> 0x02dc, InterruptedIOException -> 0x02d2, IOException -> 0x02c8, eu -> 0x02be, all -> 0x02b4 }
            r5.f9072b = r8     // Catch:{ ConnectException -> 0x0318, SSLException -> 0x030e, ConnectTimeoutException -> 0x0304, MalformedURLException -> 0x02fa, UnknownHostException -> 0x02f0, SocketException -> 0x02e6, SocketTimeoutException -> 0x02dc, InterruptedIOException -> 0x02d2, IOException -> 0x02c8, eu -> 0x02be, all -> 0x02b4 }
            java.io.InputStream r5 = r12.getInputStream()     // Catch:{ ConnectException -> 0x0318, SSLException -> 0x030e, ConnectTimeoutException -> 0x0304, MalformedURLException -> 0x02fa, UnknownHostException -> 0x02f0, SocketException -> 0x02e6, SocketTimeoutException -> 0x02dc, InterruptedIOException -> 0x02d2, IOException -> 0x02c8, eu -> 0x02be, all -> 0x02b4 }
            r8 = 1024(0x400, float:1.435E-42)
            byte[] r9 = new byte[r8]     // Catch:{ ConnectException -> 0x02ad, SSLException -> 0x02a6, ConnectTimeoutException -> 0x029f, MalformedURLException -> 0x0298, UnknownHostException -> 0x0291, SocketException -> 0x028a, SocketTimeoutException -> 0x0283, InterruptedIOException -> 0x027c, IOException -> 0x0275, eu -> 0x026e, all -> 0x0267 }
            r10 = 0
        L_0x01a5:
            boolean r13 = java.lang.Thread.interrupted()     // Catch:{ ConnectException -> 0x02ad, SSLException -> 0x02a6, ConnectTimeoutException -> 0x029f, MalformedURLException -> 0x0298, UnknownHostException -> 0x0291, SocketException -> 0x028a, SocketTimeoutException -> 0x0283, InterruptedIOException -> 0x027c, IOException -> 0x0275, eu -> 0x026e, all -> 0x0267 }
            if (r13 != 0) goto L_0x01e4
            boolean r13 = r1.f9025d     // Catch:{ ConnectException -> 0x02ad, SSLException -> 0x02a6, ConnectTimeoutException -> 0x029f, MalformedURLException -> 0x0298, UnknownHostException -> 0x0291, SocketException -> 0x028a, SocketTimeoutException -> 0x0283, InterruptedIOException -> 0x027c, IOException -> 0x0275, eu -> 0x026e, all -> 0x0267 }
            if (r13 != 0) goto L_0x01e4
            int r13 = r5.read(r9, r11, r8)     // Catch:{ ConnectException -> 0x02ad, SSLException -> 0x02a6, ConnectTimeoutException -> 0x029f, MalformedURLException -> 0x0298, UnknownHostException -> 0x0291, SocketException -> 0x028a, SocketTimeoutException -> 0x0283, InterruptedIOException -> 0x027c, IOException -> 0x0275, eu -> 0x026e, all -> 0x0267 }
            if (r13 <= 0) goto L_0x01e4
            long r14 = r1.f9026e     // Catch:{ ConnectException -> 0x02ad, SSLException -> 0x02a6, ConnectTimeoutException -> 0x029f, MalformedURLException -> 0x0298, UnknownHostException -> 0x0291, SocketException -> 0x028a, SocketTimeoutException -> 0x0283, InterruptedIOException -> 0x027c, IOException -> 0x0275, eu -> 0x026e, all -> 0x0267 }
            r16 = -1
            int r18 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r18 == 0) goto L_0x01c6
            r17 = r7
            long r6 = r1.f9027f     // Catch:{ ConnectException -> 0x0261, SSLException -> 0x025b, ConnectTimeoutException -> 0x0255, MalformedURLException -> 0x024f, UnknownHostException -> 0x0249, SocketException -> 0x0244, SocketTimeoutException -> 0x023f, InterruptedIOException -> 0x023a, IOException -> 0x0235, eu -> 0x0230, all -> 0x022b }
            int r18 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r18 >= 0) goto L_0x01e6
            goto L_0x01c8
        L_0x01c6:
            r17 = r7
        L_0x01c8:
            if (r13 != r8) goto L_0x01d0
            long r6 = r1.f9027f     // Catch:{ ConnectException -> 0x0261, SSLException -> 0x025b, ConnectTimeoutException -> 0x0255, MalformedURLException -> 0x024f, UnknownHostException -> 0x0249, SocketException -> 0x0244, SocketTimeoutException -> 0x023f, InterruptedIOException -> 0x023a, IOException -> 0x0235, eu -> 0x0230, all -> 0x022b }
            r2.onDownload(r9, r6)     // Catch:{ ConnectException -> 0x0261, SSLException -> 0x025b, ConnectTimeoutException -> 0x0255, MalformedURLException -> 0x024f, UnknownHostException -> 0x0249, SocketException -> 0x0244, SocketTimeoutException -> 0x023f, InterruptedIOException -> 0x023a, IOException -> 0x0235, eu -> 0x0230, all -> 0x022b }
            goto L_0x01da
        L_0x01d0:
            byte[] r6 = new byte[r13]     // Catch:{ ConnectException -> 0x0261, SSLException -> 0x025b, ConnectTimeoutException -> 0x0255, MalformedURLException -> 0x024f, UnknownHostException -> 0x0249, SocketException -> 0x0244, SocketTimeoutException -> 0x023f, InterruptedIOException -> 0x023a, IOException -> 0x0235, eu -> 0x0230, all -> 0x022b }
            java.lang.System.arraycopy(r9, r11, r6, r11, r13)     // Catch:{ ConnectException -> 0x0261, SSLException -> 0x025b, ConnectTimeoutException -> 0x0255, MalformedURLException -> 0x024f, UnknownHostException -> 0x0249, SocketException -> 0x0244, SocketTimeoutException -> 0x023f, InterruptedIOException -> 0x023a, IOException -> 0x0235, eu -> 0x0230, all -> 0x022b }
            long r14 = r1.f9027f     // Catch:{ ConnectException -> 0x0261, SSLException -> 0x025b, ConnectTimeoutException -> 0x0255, MalformedURLException -> 0x024f, UnknownHostException -> 0x0249, SocketException -> 0x0244, SocketTimeoutException -> 0x023f, InterruptedIOException -> 0x023a, IOException -> 0x0235, eu -> 0x0230, all -> 0x022b }
            r2.onDownload(r6, r14)     // Catch:{ ConnectException -> 0x0261, SSLException -> 0x025b, ConnectTimeoutException -> 0x0255, MalformedURLException -> 0x024f, UnknownHostException -> 0x0249, SocketException -> 0x0244, SocketTimeoutException -> 0x023f, InterruptedIOException -> 0x023a, IOException -> 0x0235, eu -> 0x0230, all -> 0x022b }
        L_0x01da:
            long r6 = r1.f9027f     // Catch:{ ConnectException -> 0x0261, SSLException -> 0x025b, ConnectTimeoutException -> 0x0255, MalformedURLException -> 0x024f, UnknownHostException -> 0x0249, SocketException -> 0x0244, SocketTimeoutException -> 0x023f, InterruptedIOException -> 0x023a, IOException -> 0x0235, eu -> 0x0230, all -> 0x022b }
            long r14 = (long) r13     // Catch:{ ConnectException -> 0x0261, SSLException -> 0x025b, ConnectTimeoutException -> 0x0255, MalformedURLException -> 0x024f, UnknownHostException -> 0x0249, SocketException -> 0x0244, SocketTimeoutException -> 0x023f, InterruptedIOException -> 0x023a, IOException -> 0x0235, eu -> 0x0230, all -> 0x022b }
            long r6 = r6 + r14
            r1.f9027f = r6     // Catch:{ ConnectException -> 0x0261, SSLException -> 0x025b, ConnectTimeoutException -> 0x0255, MalformedURLException -> 0x024f, UnknownHostException -> 0x0249, SocketException -> 0x0244, SocketTimeoutException -> 0x023f, InterruptedIOException -> 0x023a, IOException -> 0x0235, eu -> 0x0230, all -> 0x022b }
            int r10 = r10 + r13
            r7 = r17
            goto L_0x01a5
        L_0x01e4:
            r17 = r7
        L_0x01e6:
            com.amap.api.mapcore.util.ha$f r6 = r1.f9040u     // Catch:{ ConnectException -> 0x0261, SSLException -> 0x025b, ConnectTimeoutException -> 0x0255, MalformedURLException -> 0x024f, UnknownHostException -> 0x0249, SocketException -> 0x0244, SocketTimeoutException -> 0x023f, InterruptedIOException -> 0x023a, IOException -> 0x0235, eu -> 0x0230, all -> 0x022b }
            long r7 = (long) r10     // Catch:{ ConnectException -> 0x0261, SSLException -> 0x025b, ConnectTimeoutException -> 0x0255, MalformedURLException -> 0x024f, UnknownHostException -> 0x0249, SocketException -> 0x0244, SocketTimeoutException -> 0x023f, InterruptedIOException -> 0x023a, IOException -> 0x0235, eu -> 0x0230, all -> 0x022b }
            r6.a((long) r7)     // Catch:{ ConnectException -> 0x0261, SSLException -> 0x025b, ConnectTimeoutException -> 0x0255, MalformedURLException -> 0x024f, UnknownHostException -> 0x0249, SocketException -> 0x0244, SocketTimeoutException -> 0x023f, InterruptedIOException -> 0x023a, IOException -> 0x0235, eu -> 0x0230, all -> 0x022b }
            com.amap.api.mapcore.util.ha$f r6 = r1.f9040u     // Catch:{ ConnectException -> 0x0261, SSLException -> 0x025b, ConnectTimeoutException -> 0x0255, MalformedURLException -> 0x024f, UnknownHostException -> 0x0249, SocketException -> 0x0244, SocketTimeoutException -> 0x023f, InterruptedIOException -> 0x023a, IOException -> 0x0235, eu -> 0x0230, all -> 0x022b }
            r6.c()     // Catch:{ ConnectException -> 0x0261, SSLException -> 0x025b, ConnectTimeoutException -> 0x0255, MalformedURLException -> 0x024f, UnknownHostException -> 0x0249, SocketException -> 0x0244, SocketTimeoutException -> 0x023f, InterruptedIOException -> 0x023a, IOException -> 0x0235, eu -> 0x0230, all -> 0x022b }
            boolean r6 = r1.f9025d     // Catch:{ ConnectException -> 0x0261, SSLException -> 0x025b, ConnectTimeoutException -> 0x0255, MalformedURLException -> 0x024f, UnknownHostException -> 0x0249, SocketException -> 0x0244, SocketTimeoutException -> 0x023f, InterruptedIOException -> 0x023a, IOException -> 0x0235, eu -> 0x0230, all -> 0x022b }
            if (r6 == 0) goto L_0x01f9
            r21.onStop()     // Catch:{ ConnectException -> 0x0261, SSLException -> 0x025b, ConnectTimeoutException -> 0x0255, MalformedURLException -> 0x024f, UnknownHostException -> 0x0249, SocketException -> 0x0244, SocketTimeoutException -> 0x023f, InterruptedIOException -> 0x023a, IOException -> 0x0235, eu -> 0x0230, all -> 0x022b }
            goto L_0x01fc
        L_0x01f9:
            r21.onFinish()     // Catch:{ ConnectException -> 0x0261, SSLException -> 0x025b, ConnectTimeoutException -> 0x0255, MalformedURLException -> 0x024f, UnknownHostException -> 0x0249, SocketException -> 0x0244, SocketTimeoutException -> 0x023f, InterruptedIOException -> 0x023a, IOException -> 0x0235, eu -> 0x0230, all -> 0x022b }
        L_0x01fc:
            com.amap.api.mapcore.util.ha$f r6 = r1.f9040u     // Catch:{ ConnectException -> 0x0261, SSLException -> 0x025b, ConnectTimeoutException -> 0x0255, MalformedURLException -> 0x024f, UnknownHostException -> 0x0249, SocketException -> 0x0244, SocketTimeoutException -> 0x023f, InterruptedIOException -> 0x023a, IOException -> 0x0235, eu -> 0x0230, all -> 0x022b }
            r7 = 0
            r6.a((com.amap.api.mapcore.util.he) r7)     // Catch:{ ConnectException -> 0x0261, SSLException -> 0x025b, ConnectTimeoutException -> 0x0255, MalformedURLException -> 0x024f, UnknownHostException -> 0x0249, SocketException -> 0x0244, SocketTimeoutException -> 0x023f, InterruptedIOException -> 0x023a, IOException -> 0x0235, eu -> 0x0230, all -> 0x022b }
            if (r5 == 0) goto L_0x020f
            r5.close()     // Catch:{ IOException -> 0x020a, all -> 0x0208 }
            goto L_0x020f
        L_0x0208:
            r0 = move-exception
            goto L_0x020b
        L_0x020a:
            r0 = move-exception
        L_0x020b:
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x020f:
            if (r12 == 0) goto L_0x021a
            r12.disconnect()     // Catch:{ all -> 0x0215 }
            goto L_0x021a
        L_0x0215:
            r0 = move-exception
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x021a:
            if (r17 == 0) goto L_0x0225
            r17.close()     // Catch:{ all -> 0x0220 }
            goto L_0x0225
        L_0x0220:
            r0 = move-exception
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x0225:
            com.amap.api.mapcore.util.ha$f r2 = r1.f9040u
            r2.d()
            return
        L_0x022b:
            r0 = move-exception
            r8 = r5
            r7 = r17
            goto L_0x026b
        L_0x0230:
            r0 = move-exception
            r8 = r5
            r7 = r17
            goto L_0x0272
        L_0x0235:
            r0 = move-exception
            r8 = r5
            r7 = r17
            goto L_0x0279
        L_0x023a:
            r0 = move-exception
            r8 = r5
            r7 = r17
            goto L_0x0280
        L_0x023f:
            r0 = move-exception
            r8 = r5
            r7 = r17
            goto L_0x0287
        L_0x0244:
            r0 = move-exception
            r8 = r5
            r7 = r17
            goto L_0x028e
        L_0x0249:
            r0 = move-exception
            r8 = r5
            r7 = r17
            goto L_0x0295
        L_0x024f:
            r0 = move-exception
            r8 = r5
            r7 = r17
            goto L_0x029c
        L_0x0255:
            r0 = move-exception
            r8 = r5
            r7 = r17
            goto L_0x02a3
        L_0x025b:
            r0 = move-exception
            r8 = r5
            r7 = r17
            goto L_0x02aa
        L_0x0261:
            r0 = move-exception
            r8 = r5
            r7 = r17
            goto L_0x02b1
        L_0x0267:
            r0 = move-exception
            r17 = r7
            r8 = r5
        L_0x026b:
            r5 = r0
            goto L_0x0368
        L_0x026e:
            r0 = move-exception
            r17 = r7
            r8 = r5
        L_0x0272:
            r5 = r0
            goto L_0x03a0
        L_0x0275:
            r0 = move-exception
            r17 = r7
            r8 = r5
        L_0x0279:
            r5 = r0
            goto L_0x03da
        L_0x027c:
            r0 = move-exception
            r17 = r7
            r8 = r5
        L_0x0280:
            r5 = r0
            goto L_0x0411
        L_0x0283:
            r0 = move-exception
            r17 = r7
            r8 = r5
        L_0x0287:
            r5 = r0
            goto L_0x044f
        L_0x028a:
            r0 = move-exception
            r17 = r7
            r8 = r5
        L_0x028e:
            r5 = r0
            goto L_0x048f
        L_0x0291:
            r0 = move-exception
            r17 = r7
            r8 = r5
        L_0x0295:
            r5 = r0
            goto L_0x04cf
        L_0x0298:
            r0 = move-exception
            r17 = r7
            r8 = r5
        L_0x029c:
            r5 = r0
            goto L_0x0506
        L_0x029f:
            r0 = move-exception
            r17 = r7
            r8 = r5
        L_0x02a3:
            r5 = r0
            goto L_0x053e
        L_0x02a6:
            r0 = move-exception
            r17 = r7
            r8 = r5
        L_0x02aa:
            r5 = r0
            goto L_0x0581
        L_0x02ad:
            r0 = move-exception
            r17 = r7
            r8 = r5
        L_0x02b1:
            r5 = r0
            goto L_0x05c4
        L_0x02b4:
            r0 = move-exception
            r17 = r7
            r7 = 0
            r5 = r0
            r8 = r7
            r7 = r17
            goto L_0x0368
        L_0x02be:
            r0 = move-exception
            r17 = r7
            r7 = 0
            r5 = r0
            r8 = r7
            r7 = r17
            goto L_0x03a0
        L_0x02c8:
            r0 = move-exception
            r17 = r7
            r7 = 0
            r5 = r0
            r8 = r7
            r7 = r17
            goto L_0x03da
        L_0x02d2:
            r0 = move-exception
            r17 = r7
            r7 = 0
            r5 = r0
            r8 = r7
            r7 = r17
            goto L_0x0411
        L_0x02dc:
            r0 = move-exception
            r17 = r7
            r7 = 0
            r5 = r0
            r8 = r7
            r7 = r17
            goto L_0x044f
        L_0x02e6:
            r0 = move-exception
            r17 = r7
            r7 = 0
            r5 = r0
            r8 = r7
            r7 = r17
            goto L_0x048f
        L_0x02f0:
            r0 = move-exception
            r17 = r7
            r7 = 0
            r5 = r0
            r8 = r7
            r7 = r17
            goto L_0x04cf
        L_0x02fa:
            r0 = move-exception
            r17 = r7
            r7 = 0
            r5 = r0
            r8 = r7
            r7 = r17
            goto L_0x0506
        L_0x0304:
            r0 = move-exception
            r17 = r7
            r7 = 0
            r5 = r0
            r8 = r7
            r7 = r17
            goto L_0x053e
        L_0x030e:
            r0 = move-exception
            r17 = r7
            r7 = 0
            r5 = r0
            r8 = r7
            r7 = r17
            goto L_0x0581
        L_0x0318:
            r0 = move-exception
            r17 = r7
            r7 = 0
            r5 = r0
            r8 = r7
            r7 = r17
            goto L_0x05c4
        L_0x0322:
            r0 = move-exception
            r7 = 0
            r5 = r0
            r8 = r7
            goto L_0x0368
        L_0x0327:
            r0 = move-exception
            r7 = 0
            r5 = r0
            r8 = r7
            goto L_0x03a0
        L_0x032d:
            r0 = move-exception
            r7 = 0
            r5 = r0
            r8 = r7
            goto L_0x03da
        L_0x0333:
            r0 = move-exception
            r7 = 0
            r5 = r0
            r8 = r7
            goto L_0x0411
        L_0x0339:
            r0 = move-exception
            r7 = 0
            r5 = r0
            r8 = r7
            goto L_0x044f
        L_0x033f:
            r0 = move-exception
            r7 = 0
            r5 = r0
            r8 = r7
            goto L_0x048f
        L_0x0345:
            r0 = move-exception
            r7 = 0
            r5 = r0
            r8 = r7
            goto L_0x04cf
        L_0x034b:
            r0 = move-exception
            r7 = 0
            r5 = r0
            r8 = r7
            goto L_0x0506
        L_0x0351:
            r0 = move-exception
            r7 = 0
            r5 = r0
            r8 = r7
            goto L_0x053e
        L_0x0357:
            r0 = move-exception
            r7 = 0
            r5 = r0
            r8 = r7
            goto L_0x0581
        L_0x035d:
            r0 = move-exception
            r7 = 0
            r5 = r0
            r8 = r7
            goto L_0x05c4
        L_0x0363:
            r0 = move-exception
            r7 = 0
            r5 = r0
            r8 = r7
            r12 = r8
        L_0x0368:
            com.amap.api.mapcore.util.ha$f r6 = r1.f9040u     // Catch:{ all -> 0x05ff }
            r9 = 9
            r6.a((int) r9)     // Catch:{ all -> 0x05ff }
            r2.onException(r5)     // Catch:{ all -> 0x05ff }
            if (r8 == 0) goto L_0x037f
            r8.close()     // Catch:{ IOException -> 0x037a, all -> 0x0378 }
            goto L_0x037f
        L_0x0378:
            r0 = move-exception
            goto L_0x037b
        L_0x037a:
            r0 = move-exception
        L_0x037b:
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x037f:
            if (r12 == 0) goto L_0x038a
            r12.disconnect()     // Catch:{ all -> 0x0385 }
            goto L_0x038a
        L_0x0385:
            r0 = move-exception
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x038a:
            if (r7 == 0) goto L_0x0395
            r7.close()     // Catch:{ all -> 0x0390 }
            goto L_0x0395
        L_0x0390:
            r0 = move-exception
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x0395:
            com.amap.api.mapcore.util.ha$f r2 = r1.f9040u
            r2.d()
            return
        L_0x039b:
            r0 = move-exception
            r7 = 0
            r5 = r0
            r8 = r7
            r12 = r8
        L_0x03a0:
            com.amap.api.mapcore.util.ha$f r6 = r1.f9040u     // Catch:{ all -> 0x05ff }
            int r9 = r5.g()     // Catch:{ all -> 0x05ff }
            r6.a((int) r9)     // Catch:{ all -> 0x05ff }
            r2.onException(r5)     // Catch:{ all -> 0x05ff }
            if (r8 == 0) goto L_0x03b9
            r8.close()     // Catch:{ IOException -> 0x03b4, all -> 0x03b2 }
            goto L_0x03b9
        L_0x03b2:
            r0 = move-exception
            goto L_0x03b5
        L_0x03b4:
            r0 = move-exception
        L_0x03b5:
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x03b9:
            if (r12 == 0) goto L_0x03c4
            r12.disconnect()     // Catch:{ all -> 0x03bf }
            goto L_0x03c4
        L_0x03bf:
            r0 = move-exception
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x03c4:
            if (r7 == 0) goto L_0x03cf
            r7.close()     // Catch:{ all -> 0x03ca }
            goto L_0x03cf
        L_0x03ca:
            r0 = move-exception
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x03cf:
            com.amap.api.mapcore.util.ha$f r2 = r1.f9040u
            r2.d()
            return
        L_0x03d5:
            r0 = move-exception
            r7 = 0
            r5 = r0
            r8 = r7
            r12 = r8
        L_0x03da:
            com.amap.api.mapcore.util.ha$f r6 = r1.f9040u     // Catch:{ all -> 0x05ff }
            r9 = 7
            r6.a((int) r9)     // Catch:{ all -> 0x05ff }
            r2.onException(r5)     // Catch:{ all -> 0x05ff }
            if (r8 == 0) goto L_0x03f0
            r8.close()     // Catch:{ IOException -> 0x03eb, all -> 0x03e9 }
            goto L_0x03f0
        L_0x03e9:
            r0 = move-exception
            goto L_0x03ec
        L_0x03eb:
            r0 = move-exception
        L_0x03ec:
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x03f0:
            if (r12 == 0) goto L_0x03fb
            r12.disconnect()     // Catch:{ all -> 0x03f6 }
            goto L_0x03fb
        L_0x03f6:
            r0 = move-exception
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x03fb:
            if (r7 == 0) goto L_0x0406
            r7.close()     // Catch:{ all -> 0x0401 }
            goto L_0x0406
        L_0x0401:
            r0 = move-exception
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x0406:
            com.amap.api.mapcore.util.ha$f r2 = r1.f9040u
            r2.d()
            return
        L_0x040c:
            r0 = move-exception
            r7 = 0
            r5 = r0
            r8 = r7
            r12 = r8
        L_0x0411:
            com.amap.api.mapcore.util.ha$f r9 = r1.f9040u     // Catch:{ all -> 0x05ff }
            r10 = 7101(0x1bbd, float:9.95E-42)
            r9.b(r10)     // Catch:{ all -> 0x05ff }
            com.amap.api.mapcore.util.ha$f r9 = r1.f9040u     // Catch:{ all -> 0x05ff }
            r6 = 7
            r9.a((int) r6)     // Catch:{ all -> 0x05ff }
            r2.onException(r5)     // Catch:{ all -> 0x05ff }
            if (r8 == 0) goto L_0x042e
            r8.close()     // Catch:{ IOException -> 0x0429, all -> 0x0427 }
            goto L_0x042e
        L_0x0427:
            r0 = move-exception
            goto L_0x042a
        L_0x0429:
            r0 = move-exception
        L_0x042a:
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x042e:
            if (r12 == 0) goto L_0x0439
            r12.disconnect()     // Catch:{ all -> 0x0434 }
            goto L_0x0439
        L_0x0434:
            r0 = move-exception
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x0439:
            if (r7 == 0) goto L_0x0444
            r7.close()     // Catch:{ all -> 0x043f }
            goto L_0x0444
        L_0x043f:
            r0 = move-exception
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x0444:
            com.amap.api.mapcore.util.ha$f r2 = r1.f9040u
            r2.d()
            return
        L_0x044a:
            r0 = move-exception
            r7 = 0
            r5 = r0
            r8 = r7
            r12 = r8
        L_0x044f:
            com.amap.api.mapcore.util.ha$f r6 = r1.f9040u     // Catch:{ all -> 0x05ff }
            int r9 = a((java.lang.Exception) r5)     // Catch:{ all -> 0x05ff }
            r6.b(r9)     // Catch:{ all -> 0x05ff }
            com.amap.api.mapcore.util.ha$f r6 = r1.f9040u     // Catch:{ all -> 0x05ff }
            r9 = 2
            r6.a((int) r9)     // Catch:{ all -> 0x05ff }
            r2.onException(r5)     // Catch:{ all -> 0x05ff }
            if (r8 == 0) goto L_0x046e
            r8.close()     // Catch:{ IOException -> 0x0469, all -> 0x0467 }
            goto L_0x046e
        L_0x0467:
            r0 = move-exception
            goto L_0x046a
        L_0x0469:
            r0 = move-exception
        L_0x046a:
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x046e:
            if (r12 == 0) goto L_0x0479
            r12.disconnect()     // Catch:{ all -> 0x0474 }
            goto L_0x0479
        L_0x0474:
            r0 = move-exception
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x0479:
            if (r7 == 0) goto L_0x0484
            r7.close()     // Catch:{ all -> 0x047f }
            goto L_0x0484
        L_0x047f:
            r0 = move-exception
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x0484:
            com.amap.api.mapcore.util.ha$f r2 = r1.f9040u
            r2.d()
            return
        L_0x048a:
            r0 = move-exception
            r7 = 0
            r5 = r0
            r8 = r7
            r12 = r8
        L_0x048f:
            com.amap.api.mapcore.util.ha$f r6 = r1.f9040u     // Catch:{ all -> 0x05ff }
            int r9 = a((java.lang.Exception) r5)     // Catch:{ all -> 0x05ff }
            r6.b(r9)     // Catch:{ all -> 0x05ff }
            com.amap.api.mapcore.util.ha$f r6 = r1.f9040u     // Catch:{ all -> 0x05ff }
            r9 = 6
            r6.a((int) r9)     // Catch:{ all -> 0x05ff }
            r2.onException(r5)     // Catch:{ all -> 0x05ff }
            if (r8 == 0) goto L_0x04ae
            r8.close()     // Catch:{ IOException -> 0x04a9, all -> 0x04a7 }
            goto L_0x04ae
        L_0x04a7:
            r0 = move-exception
            goto L_0x04aa
        L_0x04a9:
            r0 = move-exception
        L_0x04aa:
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x04ae:
            if (r12 == 0) goto L_0x04b9
            r12.disconnect()     // Catch:{ all -> 0x04b4 }
            goto L_0x04b9
        L_0x04b4:
            r0 = move-exception
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x04b9:
            if (r7 == 0) goto L_0x04c4
            r7.close()     // Catch:{ all -> 0x04bf }
            goto L_0x04c4
        L_0x04bf:
            r0 = move-exception
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x04c4:
            com.amap.api.mapcore.util.ha$f r2 = r1.f9040u
            r2.d()
            return
        L_0x04ca:
            r0 = move-exception
            r7 = 0
            r5 = r0
            r8 = r7
            r12 = r8
        L_0x04cf:
            com.amap.api.mapcore.util.ha$f r6 = r1.f9040u     // Catch:{ all -> 0x05ff }
            r9 = 5
            r6.a((int) r9)     // Catch:{ all -> 0x05ff }
            r2.onException(r5)     // Catch:{ all -> 0x05ff }
            if (r8 == 0) goto L_0x04e5
            r8.close()     // Catch:{ IOException -> 0x04e0, all -> 0x04de }
            goto L_0x04e5
        L_0x04de:
            r0 = move-exception
            goto L_0x04e1
        L_0x04e0:
            r0 = move-exception
        L_0x04e1:
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x04e5:
            if (r12 == 0) goto L_0x04f0
            r12.disconnect()     // Catch:{ all -> 0x04eb }
            goto L_0x04f0
        L_0x04eb:
            r0 = move-exception
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x04f0:
            if (r7 == 0) goto L_0x04fb
            r7.close()     // Catch:{ all -> 0x04f6 }
            goto L_0x04fb
        L_0x04f6:
            r0 = move-exception
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x04fb:
            com.amap.api.mapcore.util.ha$f r2 = r1.f9040u
            r2.d()
            return
        L_0x0501:
            r0 = move-exception
            r7 = 0
            r5 = r0
            r8 = r7
            r12 = r8
        L_0x0506:
            com.amap.api.mapcore.util.ha$f r6 = r1.f9040u     // Catch:{ all -> 0x05ff }
            r9 = 8
            r6.a((int) r9)     // Catch:{ all -> 0x05ff }
            r2.onException(r5)     // Catch:{ all -> 0x05ff }
            if (r8 == 0) goto L_0x051d
            r8.close()     // Catch:{ IOException -> 0x0518, all -> 0x0516 }
            goto L_0x051d
        L_0x0516:
            r0 = move-exception
            goto L_0x0519
        L_0x0518:
            r0 = move-exception
        L_0x0519:
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x051d:
            if (r12 == 0) goto L_0x0528
            r12.disconnect()     // Catch:{ all -> 0x0523 }
            goto L_0x0528
        L_0x0523:
            r0 = move-exception
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x0528:
            if (r7 == 0) goto L_0x0533
            r7.close()     // Catch:{ all -> 0x052e }
            goto L_0x0533
        L_0x052e:
            r0 = move-exception
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x0533:
            com.amap.api.mapcore.util.ha$f r2 = r1.f9040u
            r2.d()
            return
        L_0x0539:
            r0 = move-exception
            r7 = 0
            r5 = r0
            r8 = r7
            r12 = r8
        L_0x053e:
            r5.printStackTrace()     // Catch:{ all -> 0x05ff }
            com.amap.api.mapcore.util.ha$f r6 = r1.f9040u     // Catch:{ all -> 0x05ff }
            int r9 = a((java.lang.Exception) r5)     // Catch:{ all -> 0x05ff }
            r6.b(r9)     // Catch:{ all -> 0x05ff }
            com.amap.api.mapcore.util.ha$f r6 = r1.f9040u     // Catch:{ all -> 0x05ff }
            r9 = 2
            r6.a((int) r9)     // Catch:{ all -> 0x05ff }
            r2.onException(r5)     // Catch:{ all -> 0x05ff }
            if (r8 == 0) goto L_0x0560
            r8.close()     // Catch:{ IOException -> 0x055b, all -> 0x0559 }
            goto L_0x0560
        L_0x0559:
            r0 = move-exception
            goto L_0x055c
        L_0x055b:
            r0 = move-exception
        L_0x055c:
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x0560:
            if (r12 == 0) goto L_0x056b
            r12.disconnect()     // Catch:{ all -> 0x0566 }
            goto L_0x056b
        L_0x0566:
            r0 = move-exception
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x056b:
            if (r7 == 0) goto L_0x0576
            r7.close()     // Catch:{ all -> 0x0571 }
            goto L_0x0576
        L_0x0571:
            r0 = move-exception
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x0576:
            com.amap.api.mapcore.util.ha$f r2 = r1.f9040u
            r2.d()
            return
        L_0x057c:
            r0 = move-exception
            r7 = 0
            r5 = r0
            r8 = r7
            r12 = r8
        L_0x0581:
            r5.printStackTrace()     // Catch:{ all -> 0x05ff }
            com.amap.api.mapcore.util.ha$f r6 = r1.f9040u     // Catch:{ all -> 0x05ff }
            int r9 = a((java.lang.Exception) r5)     // Catch:{ all -> 0x05ff }
            r6.b(r9)     // Catch:{ all -> 0x05ff }
            com.amap.api.mapcore.util.ha$f r6 = r1.f9040u     // Catch:{ all -> 0x05ff }
            r9 = 4
            r6.a((int) r9)     // Catch:{ all -> 0x05ff }
            r2.onException(r5)     // Catch:{ all -> 0x05ff }
            if (r8 == 0) goto L_0x05a3
            r8.close()     // Catch:{ IOException -> 0x059e, all -> 0x059c }
            goto L_0x05a3
        L_0x059c:
            r0 = move-exception
            goto L_0x059f
        L_0x059e:
            r0 = move-exception
        L_0x059f:
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x05a3:
            if (r12 == 0) goto L_0x05ae
            r12.disconnect()     // Catch:{ all -> 0x05a9 }
            goto L_0x05ae
        L_0x05a9:
            r0 = move-exception
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x05ae:
            if (r7 == 0) goto L_0x05b9
            r7.close()     // Catch:{ all -> 0x05b4 }
            goto L_0x05b9
        L_0x05b4:
            r0 = move-exception
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x05b9:
            com.amap.api.mapcore.util.ha$f r2 = r1.f9040u
            r2.d()
            return
        L_0x05bf:
            r0 = move-exception
            r7 = 0
            r5 = r0
            r8 = r7
            r12 = r8
        L_0x05c4:
            com.amap.api.mapcore.util.ha$f r6 = r1.f9040u     // Catch:{ all -> 0x05ff }
            int r9 = a((java.lang.Exception) r5)     // Catch:{ all -> 0x05ff }
            r6.b(r9)     // Catch:{ all -> 0x05ff }
            com.amap.api.mapcore.util.ha$f r6 = r1.f9040u     // Catch:{ all -> 0x05ff }
            r9 = 6
            r6.a((int) r9)     // Catch:{ all -> 0x05ff }
            r2.onException(r5)     // Catch:{ all -> 0x05ff }
            if (r8 == 0) goto L_0x05e3
            r8.close()     // Catch:{ IOException -> 0x05de, all -> 0x05dc }
            goto L_0x05e3
        L_0x05dc:
            r0 = move-exception
            goto L_0x05df
        L_0x05de:
            r0 = move-exception
        L_0x05df:
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x05e3:
            if (r12 == 0) goto L_0x05ee
            r12.disconnect()     // Catch:{ all -> 0x05e9 }
            goto L_0x05ee
        L_0x05e9:
            r0 = move-exception
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x05ee:
            if (r7 == 0) goto L_0x05f9
            r7.close()     // Catch:{ all -> 0x05f4 }
            goto L_0x05f9
        L_0x05f4:
            r0 = move-exception
            r2 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r4, (java.lang.String) r3)
        L_0x05f9:
            com.amap.api.mapcore.util.ha$f r2 = r1.f9040u
            r2.d()
            return
        L_0x05ff:
            r0 = move-exception
            r2 = r0
            if (r8 == 0) goto L_0x060e
            r8.close()     // Catch:{ IOException -> 0x0609, all -> 0x0607 }
            goto L_0x060e
        L_0x0607:
            r0 = move-exception
            goto L_0x060a
        L_0x0609:
            r0 = move-exception
        L_0x060a:
            r5 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r5, (java.lang.String) r4, (java.lang.String) r3)
        L_0x060e:
            if (r12 == 0) goto L_0x0619
            r12.disconnect()     // Catch:{ all -> 0x0614 }
            goto L_0x0619
        L_0x0614:
            r0 = move-exception
            r5 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r5, (java.lang.String) r4, (java.lang.String) r3)
        L_0x0619:
            if (r7 == 0) goto L_0x0624
            r7.close()     // Catch:{ all -> 0x061f }
            goto L_0x0624
        L_0x061f:
            r0 = move-exception
            r5 = r0
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r5, (java.lang.String) r4, (java.lang.String) r3)
        L_0x0624:
            com.amap.api.mapcore.util.ha$f r3 = r1.f9040u
            r3.d()
            goto L_0x062b
        L_0x062a:
            throw r2
        L_0x062b:
            goto L_0x062a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ha.a(com.amap.api.mapcore.util.hd, com.amap.api.mapcore.util.gy$a):void");
    }

    /* access modifiers changed from: package-private */
    public final he b(hd hdVar) throws eu {
        HttpURLConnection httpURLConnection = null;
        try {
            d(hdVar);
            String a2 = a(this.f9033m, hdVar.getParams());
            this.f9033m = a2;
            he b2 = gz.b(a2, this.f9031j);
            if (b2 != null) {
                this.f9040u.d();
                return b2;
            }
            b a3 = a(hdVar, false, true);
            httpURLConnection = a3.f9051a;
            this.f9040u.f9072b = SystemClock.elapsedRealtime();
            httpURLConnection.connect();
            this.f9040u.a();
            he a4 = a(a3, hdVar.isIgnoreGZip());
            this.f9040u.a(a4);
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable th) {
                    fw.a(th, "ht", "mgr");
                }
            }
            this.f9040u.d();
            return a4;
        } catch (ConnectException e2) {
            this.f9040u.b(a((Exception) e2));
            this.f9040u.a(6);
            throw new eu(AMapException.ERROR_CONNECTION);
        } catch (SSLException e3) {
            e3.printStackTrace();
            this.f9040u.b(a((Exception) e3));
            this.f9040u.a(4);
            throw new eu(AMapException.ERROR_IO);
        } catch (ConnectTimeoutException e4) {
            e4.printStackTrace();
            this.f9040u.b(a((Exception) e4));
            this.f9040u.a(2);
            throw new eu(AMapException.ERROR_IO);
        } catch (MalformedURLException unused) {
            this.f9040u.a(8);
            throw new eu(AMapException.ERROR_URL);
        } catch (UnknownHostException unused2) {
            this.f9040u.a(9);
            throw new eu(AMapException.ERROR_UNKNOW_HOST);
        } catch (SocketException e5) {
            this.f9040u.b(a((Exception) e5));
            this.f9040u.a(6);
            throw new eu(AMapException.ERROR_SOCKET);
        } catch (SocketTimeoutException e6) {
            this.f9040u.b(a((Exception) e6));
            this.f9040u.a(2);
            throw new eu(AMapException.ERROR_SOCKE_TIME_OUT);
        } catch (InterruptedIOException unused3) {
            this.f9040u.b(7101);
            this.f9040u.a(7);
            throw new eu(AMapException.ERROR_UNKNOWN);
        } catch (IOException unused4) {
            this.f9040u.a(7);
            throw new eu(AMapException.ERROR_IO);
        } catch (eu e7) {
            if (!e7.i() && e7.g() != 10) {
                this.f9040u.a(e7.f());
            }
            throw e7;
        } catch (Throwable th2) {
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable th3) {
                    fw.a(th3, "ht", "mgr");
                }
            }
            this.f9040u.d();
            throw th2;
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(long j2) {
        this.f9026e = j2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v15, resolved type: java.io.DataOutputStream} */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v1, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r7v2 */
    /* JADX WARNING: type inference failed for: r7v13 */
    /* JADX WARNING: type inference failed for: r7v17 */
    /* JADX WARNING: type inference failed for: r7v19 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008f A[Catch:{ SSLException -> 0x00dc, ConnectException -> 0x00d8, ConnectTimeoutException -> 0x00d4, MalformedURLException -> 0x00d0, UnknownHostException -> 0x00cc, SocketException -> 0x00c8, SocketTimeoutException -> 0x00c5, InterruptedIOException -> 0x00c3, IOException -> 0x00c0, eu -> 0x00bd, all -> 0x00ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0094 A[Catch:{ SSLException -> 0x00dc, ConnectException -> 0x00d8, ConnectTimeoutException -> 0x00d4, MalformedURLException -> 0x00d0, UnknownHostException -> 0x00cc, SocketException -> 0x00c8, SocketTimeoutException -> 0x00c5, InterruptedIOException -> 0x00c3, IOException -> 0x00c0, eu -> 0x00bd, all -> 0x00ba }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.amap.api.mapcore.util.he c(com.amap.api.mapcore.util.hd r15) throws com.amap.api.mapcore.util.eu {
        /*
            r14 = this;
            java.lang.String r0 = "未知的错误"
            java.lang.String r1 = "IO 操作异常 - IOException"
            java.lang.String r2 = "mPt"
            java.lang.String r3 = "ht"
            r4 = 2
            r5 = 6
            r6 = 7
            r7 = 0
            r14.d(r15)     // Catch:{ SSLException -> 0x01b9, ConnectException -> 0x019f, ConnectTimeoutException -> 0x0187, MalformedURLException -> 0x0174, UnknownHostException -> 0x0162, SocketException -> 0x0148, SocketTimeoutException -> 0x012e, InterruptedIOException -> 0x011c, IOException -> 0x010d, eu -> 0x00f1, all -> 0x00e0 }
            java.lang.String r8 = r14.f9033m     // Catch:{ SSLException -> 0x01b9, ConnectException -> 0x019f, ConnectTimeoutException -> 0x0187, MalformedURLException -> 0x0174, UnknownHostException -> 0x0162, SocketException -> 0x0148, SocketTimeoutException -> 0x012e, InterruptedIOException -> 0x011c, IOException -> 0x010d, eu -> 0x00f1, all -> 0x00e0 }
            java.lang.String r9 = r14.f9031j     // Catch:{ SSLException -> 0x01b9, ConnectException -> 0x019f, ConnectTimeoutException -> 0x0187, MalformedURLException -> 0x0174, UnknownHostException -> 0x0162, SocketException -> 0x0148, SocketTimeoutException -> 0x012e, InterruptedIOException -> 0x011c, IOException -> 0x010d, eu -> 0x00f1, all -> 0x00e0 }
            com.amap.api.mapcore.util.he r8 = com.amap.api.mapcore.util.gz.b((java.lang.String) r8, (java.lang.String) r9)     // Catch:{ SSLException -> 0x01b9, ConnectException -> 0x019f, ConnectTimeoutException -> 0x0187, MalformedURLException -> 0x0174, UnknownHostException -> 0x0162, SocketException -> 0x0148, SocketTimeoutException -> 0x012e, InterruptedIOException -> 0x011c, IOException -> 0x010d, eu -> 0x00f1, all -> 0x00e0 }
            if (r8 == 0) goto L_0x001f
            com.amap.api.mapcore.util.ha$f r15 = r14.f9040u
            r15.d()
            return r8
        L_0x001f:
            r8 = 1
            com.amap.api.mapcore.util.ha$b r8 = r14.a((com.amap.api.mapcore.util.hd) r15, (boolean) r8, (boolean) r8)     // Catch:{ SSLException -> 0x01b9, ConnectException -> 0x019f, ConnectTimeoutException -> 0x0187, MalformedURLException -> 0x0174, UnknownHostException -> 0x0162, SocketException -> 0x0148, SocketTimeoutException -> 0x012e, InterruptedIOException -> 0x011c, IOException -> 0x010d, eu -> 0x00f1, all -> 0x00e0 }
            java.net.HttpURLConnection r9 = r8.f9051a     // Catch:{ SSLException -> 0x01b9, ConnectException -> 0x019f, ConnectTimeoutException -> 0x0187, MalformedURLException -> 0x0174, UnknownHostException -> 0x0162, SocketException -> 0x0148, SocketTimeoutException -> 0x012e, InterruptedIOException -> 0x011c, IOException -> 0x010d, eu -> 0x00f1, all -> 0x00e0 }
            com.amap.api.mapcore.util.ha$f r10 = r14.f9040u     // Catch:{ SSLException -> 0x00dc, ConnectException -> 0x00d8, ConnectTimeoutException -> 0x00d4, MalformedURLException -> 0x00d0, UnknownHostException -> 0x00cc, SocketException -> 0x00c8, SocketTimeoutException -> 0x00c5, InterruptedIOException -> 0x00c3, IOException -> 0x00c0, eu -> 0x00bd, all -> 0x00ba }
            long r11 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SSLException -> 0x00dc, ConnectException -> 0x00d8, ConnectTimeoutException -> 0x00d4, MalformedURLException -> 0x00d0, UnknownHostException -> 0x00cc, SocketException -> 0x00c8, SocketTimeoutException -> 0x00c5, InterruptedIOException -> 0x00c3, IOException -> 0x00c0, eu -> 0x00bd, all -> 0x00ba }
            r10.f9072b = r11     // Catch:{ SSLException -> 0x00dc, ConnectException -> 0x00d8, ConnectTimeoutException -> 0x00d4, MalformedURLException -> 0x00d0, UnknownHostException -> 0x00cc, SocketException -> 0x00c8, SocketTimeoutException -> 0x00c5, InterruptedIOException -> 0x00c3, IOException -> 0x00c0, eu -> 0x00bd, all -> 0x00ba }
            r9.connect()     // Catch:{ SSLException -> 0x00dc, ConnectException -> 0x00d8, ConnectTimeoutException -> 0x00d4, MalformedURLException -> 0x00d0, UnknownHostException -> 0x00cc, SocketException -> 0x00c8, SocketTimeoutException -> 0x00c5, InterruptedIOException -> 0x00c3, IOException -> 0x00c0, eu -> 0x00bd, all -> 0x00ba }
            com.amap.api.mapcore.util.ha$f r10 = r14.f9040u     // Catch:{ SSLException -> 0x00dc, ConnectException -> 0x00d8, ConnectTimeoutException -> 0x00d4, MalformedURLException -> 0x00d0, UnknownHostException -> 0x00cc, SocketException -> 0x00c8, SocketTimeoutException -> 0x00c5, InterruptedIOException -> 0x00c3, IOException -> 0x00c0, eu -> 0x00bd, all -> 0x00ba }
            r10.a()     // Catch:{ SSLException -> 0x00dc, ConnectException -> 0x00d8, ConnectTimeoutException -> 0x00d4, MalformedURLException -> 0x00d0, UnknownHostException -> 0x00cc, SocketException -> 0x00c8, SocketTimeoutException -> 0x00c5, InterruptedIOException -> 0x00c3, IOException -> 0x00c0, eu -> 0x00bd, all -> 0x00ba }
            byte[] r10 = r15.getEntityBytes()     // Catch:{ SSLException -> 0x00dc, ConnectException -> 0x00d8, ConnectTimeoutException -> 0x00d4, MalformedURLException -> 0x00d0, UnknownHostException -> 0x00cc, SocketException -> 0x00c8, SocketTimeoutException -> 0x00c5, InterruptedIOException -> 0x00c3, IOException -> 0x00c0, eu -> 0x00bd, all -> 0x00ba }
            if (r10 == 0) goto L_0x003f
            int r11 = r10.length     // Catch:{ SSLException -> 0x00dc, ConnectException -> 0x00d8, ConnectTimeoutException -> 0x00d4, MalformedURLException -> 0x00d0, UnknownHostException -> 0x00cc, SocketException -> 0x00c8, SocketTimeoutException -> 0x00c5, InterruptedIOException -> 0x00c3, IOException -> 0x00c0, eu -> 0x00bd, all -> 0x00ba }
            if (r11 != 0) goto L_0x005f
        L_0x003f:
            java.util.Map r11 = r15.getParams()     // Catch:{ SSLException -> 0x00dc, ConnectException -> 0x00d8, ConnectTimeoutException -> 0x00d4, MalformedURLException -> 0x00d0, UnknownHostException -> 0x00cc, SocketException -> 0x00c8, SocketTimeoutException -> 0x00c5, InterruptedIOException -> 0x00c3, IOException -> 0x00c0, eu -> 0x00bd, all -> 0x00ba }
            java.util.HashMap<java.lang.String, java.lang.String> r12 = com.amap.api.mapcore.util.gw.f8985e     // Catch:{ SSLException -> 0x00dc, ConnectException -> 0x00d8, ConnectTimeoutException -> 0x00d4, MalformedURLException -> 0x00d0, UnknownHostException -> 0x00cc, SocketException -> 0x00c8, SocketTimeoutException -> 0x00c5, InterruptedIOException -> 0x00c3, IOException -> 0x00c0, eu -> 0x00bd, all -> 0x00ba }
            if (r12 == 0) goto L_0x0051
            if (r11 == 0) goto L_0x004f
            java.util.HashMap<java.lang.String, java.lang.String> r12 = com.amap.api.mapcore.util.gw.f8985e     // Catch:{ SSLException -> 0x00dc, ConnectException -> 0x00d8, ConnectTimeoutException -> 0x00d4, MalformedURLException -> 0x00d0, UnknownHostException -> 0x00cc, SocketException -> 0x00c8, SocketTimeoutException -> 0x00c5, InterruptedIOException -> 0x00c3, IOException -> 0x00c0, eu -> 0x00bd, all -> 0x00ba }
            r11.putAll(r12)     // Catch:{ SSLException -> 0x00dc, ConnectException -> 0x00d8, ConnectTimeoutException -> 0x00d4, MalformedURLException -> 0x00d0, UnknownHostException -> 0x00cc, SocketException -> 0x00c8, SocketTimeoutException -> 0x00c5, InterruptedIOException -> 0x00c3, IOException -> 0x00c0, eu -> 0x00bd, all -> 0x00ba }
            goto L_0x0051
        L_0x004f:
            java.util.HashMap<java.lang.String, java.lang.String> r11 = com.amap.api.mapcore.util.gw.f8985e     // Catch:{ SSLException -> 0x00dc, ConnectException -> 0x00d8, ConnectTimeoutException -> 0x00d4, MalformedURLException -> 0x00d0, UnknownHostException -> 0x00cc, SocketException -> 0x00c8, SocketTimeoutException -> 0x00c5, InterruptedIOException -> 0x00c3, IOException -> 0x00c0, eu -> 0x00bd, all -> 0x00ba }
        L_0x0051:
            java.lang.String r11 = a((java.util.Map<java.lang.String, java.lang.String>) r11)     // Catch:{ SSLException -> 0x00dc, ConnectException -> 0x00d8, ConnectTimeoutException -> 0x00d4, MalformedURLException -> 0x00d0, UnknownHostException -> 0x00cc, SocketException -> 0x00c8, SocketTimeoutException -> 0x00c5, InterruptedIOException -> 0x00c3, IOException -> 0x00c0, eu -> 0x00bd, all -> 0x00ba }
            boolean r12 = android.text.TextUtils.isEmpty(r11)     // Catch:{ SSLException -> 0x00dc, ConnectException -> 0x00d8, ConnectTimeoutException -> 0x00d4, MalformedURLException -> 0x00d0, UnknownHostException -> 0x00cc, SocketException -> 0x00c8, SocketTimeoutException -> 0x00c5, InterruptedIOException -> 0x00c3, IOException -> 0x00c0, eu -> 0x00bd, all -> 0x00ba }
            if (r12 != 0) goto L_0x005f
            byte[] r10 = com.amap.api.mapcore.util.fg.a((java.lang.String) r11)     // Catch:{ SSLException -> 0x00dc, ConnectException -> 0x00d8, ConnectTimeoutException -> 0x00d4, MalformedURLException -> 0x00d0, UnknownHostException -> 0x00cc, SocketException -> 0x00c8, SocketTimeoutException -> 0x00c5, InterruptedIOException -> 0x00c3, IOException -> 0x00c0, eu -> 0x00bd, all -> 0x00ba }
        L_0x005f:
            if (r10 == 0) goto L_0x009d
            int r11 = r10.length     // Catch:{ SSLException -> 0x00dc, ConnectException -> 0x00d8, ConnectTimeoutException -> 0x00d4, MalformedURLException -> 0x00d0, UnknownHostException -> 0x00cc, SocketException -> 0x00c8, SocketTimeoutException -> 0x00c5, InterruptedIOException -> 0x00c3, IOException -> 0x00c0, eu -> 0x00bd, all -> 0x00ba }
            if (r11 <= 0) goto L_0x009d
            com.amap.api.mapcore.util.ha$f r11 = r14.f9040u     // Catch:{ all -> 0x008b }
            long r12 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x008b }
            r11.f9072b = r12     // Catch:{ all -> 0x008b }
            java.io.OutputStream r11 = r9.getOutputStream()     // Catch:{ all -> 0x008b }
            java.io.DataOutputStream r12 = new java.io.DataOutputStream     // Catch:{ all -> 0x0089 }
            r12.<init>(r11)     // Catch:{ all -> 0x0089 }
            r12.write(r10)     // Catch:{ all -> 0x0086 }
            r12.close()     // Catch:{ SSLException -> 0x00dc, ConnectException -> 0x00d8, ConnectTimeoutException -> 0x00d4, MalformedURLException -> 0x00d0, UnknownHostException -> 0x00cc, SocketException -> 0x00c8, SocketTimeoutException -> 0x00c5, InterruptedIOException -> 0x00c3, IOException -> 0x00c0, eu -> 0x00bd, all -> 0x00ba }
            if (r11 == 0) goto L_0x0080
            r11.close()     // Catch:{ SSLException -> 0x00dc, ConnectException -> 0x00d8, ConnectTimeoutException -> 0x00d4, MalformedURLException -> 0x00d0, UnknownHostException -> 0x00cc, SocketException -> 0x00c8, SocketTimeoutException -> 0x00c5, InterruptedIOException -> 0x00c3, IOException -> 0x00c0, eu -> 0x00bd, all -> 0x00ba }
        L_0x0080:
            com.amap.api.mapcore.util.ha$f r7 = r14.f9040u     // Catch:{ SSLException -> 0x00dc, ConnectException -> 0x00d8, ConnectTimeoutException -> 0x00d4, MalformedURLException -> 0x00d0, UnknownHostException -> 0x00cc, SocketException -> 0x00c8, SocketTimeoutException -> 0x00c5, InterruptedIOException -> 0x00c3, IOException -> 0x00c0, eu -> 0x00bd, all -> 0x00ba }
            r7.b()     // Catch:{ SSLException -> 0x00dc, ConnectException -> 0x00d8, ConnectTimeoutException -> 0x00d4, MalformedURLException -> 0x00d0, UnknownHostException -> 0x00cc, SocketException -> 0x00c8, SocketTimeoutException -> 0x00c5, InterruptedIOException -> 0x00c3, IOException -> 0x00c0, eu -> 0x00bd, all -> 0x00ba }
            goto L_0x009d
        L_0x0086:
            r15 = move-exception
            r7 = r12
            goto L_0x008d
        L_0x0089:
            r15 = move-exception
            goto L_0x008d
        L_0x008b:
            r15 = move-exception
            r11 = r7
        L_0x008d:
            if (r7 == 0) goto L_0x0092
            r7.close()     // Catch:{ SSLException -> 0x00dc, ConnectException -> 0x00d8, ConnectTimeoutException -> 0x00d4, MalformedURLException -> 0x00d0, UnknownHostException -> 0x00cc, SocketException -> 0x00c8, SocketTimeoutException -> 0x00c5, InterruptedIOException -> 0x00c3, IOException -> 0x00c0, eu -> 0x00bd, all -> 0x00ba }
        L_0x0092:
            if (r11 == 0) goto L_0x0097
            r11.close()     // Catch:{ SSLException -> 0x00dc, ConnectException -> 0x00d8, ConnectTimeoutException -> 0x00d4, MalformedURLException -> 0x00d0, UnknownHostException -> 0x00cc, SocketException -> 0x00c8, SocketTimeoutException -> 0x00c5, InterruptedIOException -> 0x00c3, IOException -> 0x00c0, eu -> 0x00bd, all -> 0x00ba }
        L_0x0097:
            com.amap.api.mapcore.util.ha$f r7 = r14.f9040u     // Catch:{ SSLException -> 0x00dc, ConnectException -> 0x00d8, ConnectTimeoutException -> 0x00d4, MalformedURLException -> 0x00d0, UnknownHostException -> 0x00cc, SocketException -> 0x00c8, SocketTimeoutException -> 0x00c5, InterruptedIOException -> 0x00c3, IOException -> 0x00c0, eu -> 0x00bd, all -> 0x00ba }
            r7.b()     // Catch:{ SSLException -> 0x00dc, ConnectException -> 0x00d8, ConnectTimeoutException -> 0x00d4, MalformedURLException -> 0x00d0, UnknownHostException -> 0x00cc, SocketException -> 0x00c8, SocketTimeoutException -> 0x00c5, InterruptedIOException -> 0x00c3, IOException -> 0x00c0, eu -> 0x00bd, all -> 0x00ba }
            throw r15     // Catch:{ SSLException -> 0x00dc, ConnectException -> 0x00d8, ConnectTimeoutException -> 0x00d4, MalformedURLException -> 0x00d0, UnknownHostException -> 0x00cc, SocketException -> 0x00c8, SocketTimeoutException -> 0x00c5, InterruptedIOException -> 0x00c3, IOException -> 0x00c0, eu -> 0x00bd, all -> 0x00ba }
        L_0x009d:
            boolean r15 = r15.isIgnoreGZip()     // Catch:{ SSLException -> 0x00dc, ConnectException -> 0x00d8, ConnectTimeoutException -> 0x00d4, MalformedURLException -> 0x00d0, UnknownHostException -> 0x00cc, SocketException -> 0x00c8, SocketTimeoutException -> 0x00c5, InterruptedIOException -> 0x00c3, IOException -> 0x00c0, eu -> 0x00bd, all -> 0x00ba }
            com.amap.api.mapcore.util.he r15 = r14.a((com.amap.api.mapcore.util.ha.b) r8, (boolean) r15)     // Catch:{ SSLException -> 0x00dc, ConnectException -> 0x00d8, ConnectTimeoutException -> 0x00d4, MalformedURLException -> 0x00d0, UnknownHostException -> 0x00cc, SocketException -> 0x00c8, SocketTimeoutException -> 0x00c5, InterruptedIOException -> 0x00c3, IOException -> 0x00c0, eu -> 0x00bd, all -> 0x00ba }
            com.amap.api.mapcore.util.ha$f r7 = r14.f9040u     // Catch:{ SSLException -> 0x00dc, ConnectException -> 0x00d8, ConnectTimeoutException -> 0x00d4, MalformedURLException -> 0x00d0, UnknownHostException -> 0x00cc, SocketException -> 0x00c8, SocketTimeoutException -> 0x00c5, InterruptedIOException -> 0x00c3, IOException -> 0x00c0, eu -> 0x00bd, all -> 0x00ba }
            r7.a((com.amap.api.mapcore.util.he) r15)     // Catch:{ SSLException -> 0x00dc, ConnectException -> 0x00d8, ConnectTimeoutException -> 0x00d4, MalformedURLException -> 0x00d0, UnknownHostException -> 0x00cc, SocketException -> 0x00c8, SocketTimeoutException -> 0x00c5, InterruptedIOException -> 0x00c3, IOException -> 0x00c0, eu -> 0x00bd, all -> 0x00ba }
            if (r9 == 0) goto L_0x00b4
            r9.disconnect()     // Catch:{ all -> 0x00b0 }
            goto L_0x00b4
        L_0x00b0:
            r0 = move-exception
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r0, (java.lang.String) r3, (java.lang.String) r2)
        L_0x00b4:
            com.amap.api.mapcore.util.ha$f r0 = r14.f9040u
            r0.d()
            return r15
        L_0x00ba:
            r15 = move-exception
            r7 = r9
            goto L_0x00e1
        L_0x00bd:
            r15 = move-exception
            r7 = r9
            goto L_0x00f2
        L_0x00c0:
            r15 = move-exception
            r7 = r9
            goto L_0x010e
        L_0x00c3:
            r7 = r9
            goto L_0x011c
        L_0x00c5:
            r15 = move-exception
            r7 = r9
            goto L_0x012f
        L_0x00c8:
            r15 = move-exception
            r7 = r9
            goto L_0x0149
        L_0x00cc:
            r15 = move-exception
            r7 = r9
            goto L_0x0163
        L_0x00d0:
            r15 = move-exception
            r7 = r9
            goto L_0x0175
        L_0x00d4:
            r15 = move-exception
            r7 = r9
            goto L_0x0188
        L_0x00d8:
            r15 = move-exception
            r7 = r9
            goto L_0x01a0
        L_0x00dc:
            r15 = move-exception
            r7 = r9
            goto L_0x01ba
        L_0x00e0:
            r15 = move-exception
        L_0x00e1:
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r15, (java.lang.String) r3, (java.lang.String) r2)     // Catch:{ all -> 0x01d2 }
            com.amap.api.mapcore.util.ha$f r15 = r14.f9040u     // Catch:{ all -> 0x01d2 }
            r1 = 9
            r15.a((int) r1)     // Catch:{ all -> 0x01d2 }
            com.amap.api.mapcore.util.eu r15 = new com.amap.api.mapcore.util.eu     // Catch:{ all -> 0x01d2 }
            r15.<init>(r0)     // Catch:{ all -> 0x01d2 }
            throw r15     // Catch:{ all -> 0x01d2 }
        L_0x00f1:
            r15 = move-exception
        L_0x00f2:
            boolean r0 = r15.i()     // Catch:{ all -> 0x01d2 }
            if (r0 != 0) goto L_0x0109
            int r0 = r15.g()     // Catch:{ all -> 0x01d2 }
            r1 = 10
            if (r0 == r1) goto L_0x0109
            com.amap.api.mapcore.util.ha$f r0 = r14.f9040u     // Catch:{ all -> 0x01d2 }
            int r1 = r15.g()     // Catch:{ all -> 0x01d2 }
            r0.a((int) r1)     // Catch:{ all -> 0x01d2 }
        L_0x0109:
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r15, (java.lang.String) r3, (java.lang.String) r2)     // Catch:{ all -> 0x01d2 }
            throw r15     // Catch:{ all -> 0x01d2 }
        L_0x010d:
            r15 = move-exception
        L_0x010e:
            r15.printStackTrace()     // Catch:{ all -> 0x01d2 }
            com.amap.api.mapcore.util.ha$f r15 = r14.f9040u     // Catch:{ all -> 0x01d2 }
            r15.a((int) r6)     // Catch:{ all -> 0x01d2 }
            com.amap.api.mapcore.util.eu r15 = new com.amap.api.mapcore.util.eu     // Catch:{ all -> 0x01d2 }
            r15.<init>(r1)     // Catch:{ all -> 0x01d2 }
            throw r15     // Catch:{ all -> 0x01d2 }
        L_0x011c:
            com.amap.api.mapcore.util.ha$f r15 = r14.f9040u     // Catch:{ all -> 0x01d2 }
            r1 = 7101(0x1bbd, float:9.95E-42)
            r15.b(r1)     // Catch:{ all -> 0x01d2 }
            com.amap.api.mapcore.util.ha$f r15 = r14.f9040u     // Catch:{ all -> 0x01d2 }
            r15.a((int) r6)     // Catch:{ all -> 0x01d2 }
            com.amap.api.mapcore.util.eu r15 = new com.amap.api.mapcore.util.eu     // Catch:{ all -> 0x01d2 }
            r15.<init>(r0)     // Catch:{ all -> 0x01d2 }
            throw r15     // Catch:{ all -> 0x01d2 }
        L_0x012e:
            r15 = move-exception
        L_0x012f:
            r15.printStackTrace()     // Catch:{ all -> 0x01d2 }
            com.amap.api.mapcore.util.ha$f r0 = r14.f9040u     // Catch:{ all -> 0x01d2 }
            int r15 = a((java.lang.Exception) r15)     // Catch:{ all -> 0x01d2 }
            r0.b(r15)     // Catch:{ all -> 0x01d2 }
            com.amap.api.mapcore.util.ha$f r15 = r14.f9040u     // Catch:{ all -> 0x01d2 }
            r15.a((int) r4)     // Catch:{ all -> 0x01d2 }
            com.amap.api.mapcore.util.eu r15 = new com.amap.api.mapcore.util.eu     // Catch:{ all -> 0x01d2 }
            java.lang.String r0 = "socket 连接超时 - SocketTimeoutException"
            r15.<init>(r0)     // Catch:{ all -> 0x01d2 }
            throw r15     // Catch:{ all -> 0x01d2 }
        L_0x0148:
            r15 = move-exception
        L_0x0149:
            r15.printStackTrace()     // Catch:{ all -> 0x01d2 }
            com.amap.api.mapcore.util.ha$f r0 = r14.f9040u     // Catch:{ all -> 0x01d2 }
            int r15 = a((java.lang.Exception) r15)     // Catch:{ all -> 0x01d2 }
            r0.b(r15)     // Catch:{ all -> 0x01d2 }
            com.amap.api.mapcore.util.ha$f r15 = r14.f9040u     // Catch:{ all -> 0x01d2 }
            r15.a((int) r5)     // Catch:{ all -> 0x01d2 }
            com.amap.api.mapcore.util.eu r15 = new com.amap.api.mapcore.util.eu     // Catch:{ all -> 0x01d2 }
            java.lang.String r0 = "socket 连接异常 - SocketException"
            r15.<init>(r0)     // Catch:{ all -> 0x01d2 }
            throw r15     // Catch:{ all -> 0x01d2 }
        L_0x0162:
            r15 = move-exception
        L_0x0163:
            r15.printStackTrace()     // Catch:{ all -> 0x01d2 }
            com.amap.api.mapcore.util.ha$f r15 = r14.f9040u     // Catch:{ all -> 0x01d2 }
            r0 = 5
            r15.a((int) r0)     // Catch:{ all -> 0x01d2 }
            com.amap.api.mapcore.util.eu r15 = new com.amap.api.mapcore.util.eu     // Catch:{ all -> 0x01d2 }
            java.lang.String r0 = "未知主机 - UnKnowHostException"
            r15.<init>(r0)     // Catch:{ all -> 0x01d2 }
            throw r15     // Catch:{ all -> 0x01d2 }
        L_0x0174:
            r15 = move-exception
        L_0x0175:
            r15.printStackTrace()     // Catch:{ all -> 0x01d2 }
            com.amap.api.mapcore.util.ha$f r15 = r14.f9040u     // Catch:{ all -> 0x01d2 }
            r0 = 8
            r15.a((int) r0)     // Catch:{ all -> 0x01d2 }
            com.amap.api.mapcore.util.eu r15 = new com.amap.api.mapcore.util.eu     // Catch:{ all -> 0x01d2 }
            java.lang.String r0 = "url异常 - MalformedURLException"
            r15.<init>(r0)     // Catch:{ all -> 0x01d2 }
            throw r15     // Catch:{ all -> 0x01d2 }
        L_0x0187:
            r15 = move-exception
        L_0x0188:
            r15.printStackTrace()     // Catch:{ all -> 0x01d2 }
            com.amap.api.mapcore.util.ha$f r0 = r14.f9040u     // Catch:{ all -> 0x01d2 }
            int r15 = a((java.lang.Exception) r15)     // Catch:{ all -> 0x01d2 }
            r0.b(r15)     // Catch:{ all -> 0x01d2 }
            com.amap.api.mapcore.util.ha$f r15 = r14.f9040u     // Catch:{ all -> 0x01d2 }
            r15.a((int) r4)     // Catch:{ all -> 0x01d2 }
            com.amap.api.mapcore.util.eu r15 = new com.amap.api.mapcore.util.eu     // Catch:{ all -> 0x01d2 }
            r15.<init>(r1)     // Catch:{ all -> 0x01d2 }
            throw r15     // Catch:{ all -> 0x01d2 }
        L_0x019f:
            r15 = move-exception
        L_0x01a0:
            r15.printStackTrace()     // Catch:{ all -> 0x01d2 }
            com.amap.api.mapcore.util.ha$f r0 = r14.f9040u     // Catch:{ all -> 0x01d2 }
            int r15 = a((java.lang.Exception) r15)     // Catch:{ all -> 0x01d2 }
            r0.b(r15)     // Catch:{ all -> 0x01d2 }
            com.amap.api.mapcore.util.ha$f r15 = r14.f9040u     // Catch:{ all -> 0x01d2 }
            r15.a((int) r5)     // Catch:{ all -> 0x01d2 }
            com.amap.api.mapcore.util.eu r15 = new com.amap.api.mapcore.util.eu     // Catch:{ all -> 0x01d2 }
            java.lang.String r0 = "http连接失败 - ConnectionException"
            r15.<init>(r0)     // Catch:{ all -> 0x01d2 }
            throw r15     // Catch:{ all -> 0x01d2 }
        L_0x01b9:
            r15 = move-exception
        L_0x01ba:
            r15.printStackTrace()     // Catch:{ all -> 0x01d2 }
            com.amap.api.mapcore.util.ha$f r0 = r14.f9040u     // Catch:{ all -> 0x01d2 }
            int r15 = a((java.lang.Exception) r15)     // Catch:{ all -> 0x01d2 }
            r0.b(r15)     // Catch:{ all -> 0x01d2 }
            com.amap.api.mapcore.util.ha$f r15 = r14.f9040u     // Catch:{ all -> 0x01d2 }
            r0 = 4
            r15.a((int) r0)     // Catch:{ all -> 0x01d2 }
            com.amap.api.mapcore.util.eu r15 = new com.amap.api.mapcore.util.eu     // Catch:{ all -> 0x01d2 }
            r15.<init>(r1)     // Catch:{ all -> 0x01d2 }
            throw r15     // Catch:{ all -> 0x01d2 }
        L_0x01d2:
            r15 = move-exception
            if (r7 == 0) goto L_0x01dd
            r7.disconnect()     // Catch:{ all -> 0x01d9 }
            goto L_0x01dd
        L_0x01d9:
            r0 = move-exception
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r0, (java.lang.String) r3, (java.lang.String) r2)
        L_0x01dd:
            com.amap.api.mapcore.util.ha$f r0 = r14.f9040u
            r0.d()
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ha.c(com.amap.api.mapcore.util.hd):com.amap.api.mapcore.util.he");
    }
}
