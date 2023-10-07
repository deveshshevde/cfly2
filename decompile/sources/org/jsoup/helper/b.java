package org.jsoup.helper;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.parser.e;
import org.jsoup.parser.g;

public class b implements Connection {

    /* renamed from: a  reason: collision with root package name */
    private Connection.c f33575a = new C0244b();

    /* renamed from: b  reason: collision with root package name */
    private Connection.d f33576b = new c();

    private static abstract class a<T extends Connection.a> implements Connection.a<T> {

        /* renamed from: a  reason: collision with root package name */
        URL f33577a;

        /* renamed from: b  reason: collision with root package name */
        Connection.Method f33578b;

        /* renamed from: c  reason: collision with root package name */
        Map<String, List<String>> f33579c;

        /* renamed from: d  reason: collision with root package name */
        Map<String, String> f33580d;

        private a() {
            this.f33579c = new LinkedHashMap();
            this.f33580d = new LinkedHashMap();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
            if ((((r8[1] & 255) == 187) & ((r8[2] & 255) == 191)) != false) goto L_0x002a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static boolean a(byte[] r8) {
            /*
                int r0 = r8.length
                r1 = 3
                r2 = 1
                r3 = 0
                if (r0 < r1) goto L_0x0029
                byte r0 = r8[r3]
                r0 = r0 & 255(0xff, float:3.57E-43)
                r4 = 239(0xef, float:3.35E-43)
                if (r0 != r4) goto L_0x0029
                byte r0 = r8[r2]
                r0 = r0 & 255(0xff, float:3.57E-43)
                r4 = 187(0xbb, float:2.62E-43)
                if (r0 != r4) goto L_0x0018
                r0 = 1
                goto L_0x0019
            L_0x0018:
                r0 = 0
            L_0x0019:
                r4 = 2
                byte r4 = r8[r4]
                r4 = r4 & 255(0xff, float:3.57E-43)
                r5 = 191(0xbf, float:2.68E-43)
                if (r4 != r5) goto L_0x0024
                r4 = 1
                goto L_0x0025
            L_0x0024:
                r4 = 0
            L_0x0025:
                r0 = r0 & r4
                if (r0 == 0) goto L_0x0029
                goto L_0x002a
            L_0x0029:
                r1 = 0
            L_0x002a:
                int r0 = r8.length
            L_0x002b:
                if (r1 >= r0) goto L_0x0061
                byte r4 = r8[r1]
                r5 = r4 & 128(0x80, float:1.794E-43)
                if (r5 != 0) goto L_0x0034
                goto L_0x005e
            L_0x0034:
                r5 = r4 & 224(0xe0, float:3.14E-43)
                r6 = 192(0xc0, float:2.69E-43)
                if (r5 != r6) goto L_0x003d
                int r4 = r1 + 1
                goto L_0x004e
            L_0x003d:
                r5 = r4 & 240(0xf0, float:3.36E-43)
                r7 = 224(0xe0, float:3.14E-43)
                if (r5 != r7) goto L_0x0046
                int r4 = r1 + 2
                goto L_0x004e
            L_0x0046:
                r4 = r4 & 248(0xf8, float:3.48E-43)
                r5 = 240(0xf0, float:3.36E-43)
                if (r4 != r5) goto L_0x0060
                int r4 = r1 + 3
            L_0x004e:
                int r5 = r8.length
                if (r4 < r5) goto L_0x0052
                return r3
            L_0x0052:
                if (r1 >= r4) goto L_0x005e
                int r1 = r1 + 1
                byte r5 = r8[r1]
                r5 = r5 & r6
                r7 = 128(0x80, float:1.794E-43)
                if (r5 == r7) goto L_0x0052
                return r3
            L_0x005e:
                int r1 = r1 + r2
                goto L_0x002b
            L_0x0060:
                return r3
            L_0x0061:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.b.a.a(byte[]):boolean");
        }

        private static String d(String str) {
            try {
                byte[] bytes = str.getBytes("ISO-8859-1");
                return !a(bytes) ? str : new String(bytes, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                return str;
            }
        }

        private List<String> g(String str) {
            c.a((Object) str);
            for (Map.Entry next : this.f33579c.entrySet()) {
                if (str.equalsIgnoreCase((String) next.getKey())) {
                    return (List) next.getValue();
                }
            }
            return Collections.emptyList();
        }

        private Map.Entry<String, List<String>> h(String str) {
            String a2 = oh.b.a(str);
            for (Map.Entry<String, List<String>> next : this.f33579c.entrySet()) {
                if (oh.b.a(next.getKey()).equals(a2)) {
                    return next;
                }
            }
            return null;
        }

        public String a(String str) {
            c.a((Object) str, "Header name must not be null");
            List<String> g2 = g(str);
            if (g2.size() > 0) {
                return oh.c.a((Collection) g2, ", ");
            }
            return null;
        }

        public URL a() {
            return this.f33577a;
        }

        public T a(String str, String str2) {
            c.a(str, "Header name must not be empty");
            c(str);
            c(str, str2);
            return this;
        }

        public T a(URL url) {
            c.a((Object) url, "URL must not be null");
            this.f33577a = url;
            return this;
        }

        public T a(Connection.Method method) {
            c.a((Object) method, "Method must not be null");
            this.f33578b = method;
            return this;
        }

        public Connection.Method b() {
            return this.f33578b;
        }

        public T b(String str, String str2) {
            c.a(str, "Cookie name must not be empty");
            c.a((Object) str2, "Cookie value must not be null");
            this.f33580d.put(str, str2);
            return this;
        }

        public boolean b(String str) {
            c.a(str, "Header name must not be empty");
            return !g(str).isEmpty();
        }

        public Map<String, List<String>> c() {
            return this.f33579c;
        }

        public T c(String str) {
            c.a(str, "Header name must not be empty");
            Map.Entry<String, List<String>> h2 = h(str);
            if (h2 != null) {
                this.f33579c.remove(h2.getKey());
            }
            return this;
        }

        public T c(String str, String str2) {
            c.a(str);
            if (str2 == null) {
                str2 = "";
            }
            List e2 = e(str);
            if (e2.isEmpty()) {
                e2 = new ArrayList();
                this.f33579c.put(str, e2);
            }
            e2.add(d(str2));
            return this;
        }

        public Map<String, String> d() {
            return this.f33580d;
        }

        public boolean d(String str, String str2) {
            c.a(str);
            c.a(str2);
            for (String equalsIgnoreCase : e(str)) {
                if (str2.equalsIgnoreCase(equalsIgnoreCase)) {
                    return true;
                }
            }
            return false;
        }

        public List<String> e(String str) {
            c.a(str);
            return g(str);
        }

        public boolean f(String str) {
            c.a(str, "Cookie name must not be empty");
            return this.f33580d.containsKey(str);
        }
    }

    /* renamed from: org.jsoup.helper.b$b  reason: collision with other inner class name */
    public static class C0244b extends a<Connection.c> implements Connection.c {

        /* renamed from: e  reason: collision with root package name */
        private Proxy f33581e;

        /* renamed from: f  reason: collision with root package name */
        private int f33582f = 30000;

        /* renamed from: g  reason: collision with root package name */
        private int f33583g = 2097152;

        /* renamed from: h  reason: collision with root package name */
        private boolean f33584h = true;

        /* renamed from: i  reason: collision with root package name */
        private Collection<Connection.b> f33585i = new ArrayList();

        /* renamed from: j  reason: collision with root package name */
        private String f33586j = null;

        /* renamed from: k  reason: collision with root package name */
        private boolean f33587k = false;

        /* renamed from: l  reason: collision with root package name */
        private boolean f33588l = false;

        /* renamed from: m  reason: collision with root package name */
        private e f33589m;
        /* access modifiers changed from: private */

        /* renamed from: n  reason: collision with root package name */
        public boolean f33590n = false;

        /* renamed from: o  reason: collision with root package name */
        private String f33591o = "UTF-8";

        /* renamed from: p  reason: collision with root package name */
        private SSLSocketFactory f33592p;

        C0244b() {
            super();
            this.f33578b = Connection.Method.GET;
            c("Accept-Encoding", "gzip");
            c("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36");
            this.f33589m = e.c();
        }

        public /* bridge */ /* synthetic */ String a(String str) {
            return super.a(str);
        }

        public /* bridge */ /* synthetic */ URL a() {
            return super.a();
        }

        public /* bridge */ /* synthetic */ Connection.a a(String str, String str2) {
            return super.a(str, str2);
        }

        public /* bridge */ /* synthetic */ Connection.a a(URL url) {
            return super.a(url);
        }

        public /* bridge */ /* synthetic */ Connection.a a(Connection.Method method) {
            return super.a(method);
        }

        public /* bridge */ /* synthetic */ Connection.Method b() {
            return super.b();
        }

        public /* bridge */ /* synthetic */ Connection.a b(String str, String str2) {
            return super.b(str, str2);
        }

        /* renamed from: b */
        public C0244b a(int i2) {
            c.a(i2 >= 0, "Timeout milliseconds must be 0 (infinite) or greater");
            this.f33582f = i2;
            return this;
        }

        /* renamed from: b */
        public C0244b a(e eVar) {
            this.f33589m = eVar;
            this.f33590n = true;
            return this;
        }

        public /* bridge */ /* synthetic */ boolean b(String str) {
            return super.b(str);
        }

        public /* bridge */ /* synthetic */ Map c() {
            return super.c();
        }

        public /* bridge */ /* synthetic */ Connection.a c(String str) {
            return super.c(str);
        }

        public /* bridge */ /* synthetic */ Connection.a c(String str, String str2) {
            return super.c(str, str2);
        }

        public /* bridge */ /* synthetic */ Map d() {
            return super.d();
        }

        public Connection.c d(String str) {
            this.f33586j = str;
            return this;
        }

        public /* bridge */ /* synthetic */ boolean d(String str, String str2) {
            return super.d(str, str2);
        }

        public Proxy e() {
            return this.f33581e;
        }

        public /* bridge */ /* synthetic */ List e(String str) {
            return super.e(str);
        }

        public int f() {
            return this.f33582f;
        }

        public /* bridge */ /* synthetic */ boolean f(String str) {
            return super.f(str);
        }

        public int g() {
            return this.f33583g;
        }

        public boolean h() {
            return this.f33584h;
        }

        public boolean i() {
            return this.f33587k;
        }

        public boolean j() {
            return this.f33588l;
        }

        public SSLSocketFactory k() {
            return this.f33592p;
        }

        public Collection<Connection.b> l() {
            return this.f33585i;
        }

        public String m() {
            return this.f33586j;
        }

        public e n() {
            return this.f33589m;
        }

        public String o() {
            return this.f33591o;
        }
    }

    public static class c extends a<Connection.d> implements Connection.d {

        /* renamed from: p  reason: collision with root package name */
        private static final Pattern f33593p = Pattern.compile("(application|text)/\\w*\\+?xml.*");

        /* renamed from: e  reason: collision with root package name */
        private int f33594e;

        /* renamed from: f  reason: collision with root package name */
        private String f33595f;

        /* renamed from: g  reason: collision with root package name */
        private ByteBuffer f33596g;

        /* renamed from: h  reason: collision with root package name */
        private InputStream f33597h;

        /* renamed from: i  reason: collision with root package name */
        private HttpURLConnection f33598i;

        /* renamed from: j  reason: collision with root package name */
        private String f33599j;

        /* renamed from: k  reason: collision with root package name */
        private String f33600k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f33601l = false;

        /* renamed from: m  reason: collision with root package name */
        private boolean f33602m = false;

        /* renamed from: n  reason: collision with root package name */
        private int f33603n = 0;

        /* renamed from: o  reason: collision with root package name */
        private Connection.c f33604o;

        c() {
            super();
        }

        private c(c cVar) throws IOException {
            super();
            if (cVar != null) {
                int i2 = cVar.f33603n + 1;
                this.f33603n = i2;
                if (i2 >= 20) {
                    throw new IOException(String.format("Too many redirects occurred trying to load URL %s", new Object[]{cVar.a()}));
                }
            }
        }

        private static LinkedHashMap<String, List<String>> a(HttpURLConnection httpURLConnection) {
            LinkedHashMap<String, List<String>> linkedHashMap = new LinkedHashMap<>();
            int i2 = 0;
            while (true) {
                String headerFieldKey = httpURLConnection.getHeaderFieldKey(i2);
                String headerField = httpURLConnection.getHeaderField(i2);
                if (headerFieldKey == null && headerField == null) {
                    return linkedHashMap;
                }
                i2++;
                if (!(headerFieldKey == null || headerField == null)) {
                    if (linkedHashMap.containsKey(headerFieldKey)) {
                        linkedHashMap.get(headerFieldKey).add(headerField);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(headerField);
                        linkedHashMap.put(headerFieldKey, arrayList);
                    }
                }
            }
        }

        static c a(Connection.c cVar) throws IOException {
            return a(cVar, (c) null);
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x008b A[Catch:{ IOException -> 0x01fd }] */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00ac A[Catch:{ IOException -> 0x01fa }] */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x0117 A[Catch:{ IOException -> 0x01fa }] */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x0200  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static org.jsoup.helper.b.c a(org.jsoup.Connection.c r9, org.jsoup.helper.b.c r10) throws java.io.IOException {
            /*
                java.lang.String r0 = "Content-Encoding"
                java.lang.String r1 = "Location"
                java.lang.String r2 = "Request must not be null"
                org.jsoup.helper.c.a((java.lang.Object) r9, (java.lang.String) r2)
                java.net.URL r2 = r9.a()
                java.lang.String r3 = "URL must be specified to connect"
                org.jsoup.helper.c.a((java.lang.Object) r2, (java.lang.String) r3)
                java.net.URL r2 = r9.a()
                java.lang.String r2 = r2.getProtocol()
                java.lang.String r3 = "http"
                boolean r3 = r2.equals(r3)
                if (r3 != 0) goto L_0x0033
                java.lang.String r3 = "https"
                boolean r2 = r2.equals(r3)
                if (r2 == 0) goto L_0x002b
                goto L_0x0033
            L_0x002b:
                java.net.MalformedURLException r9 = new java.net.MalformedURLException
                java.lang.String r10 = "Only http & https protocols supported"
                r9.<init>(r10)
                throw r9
            L_0x0033:
                org.jsoup.Connection$Method r2 = r9.b()
                boolean r2 = r2.a()
                java.lang.String r3 = r9.m()
                r4 = 1
                if (r3 == 0) goto L_0x0044
                r3 = 1
                goto L_0x0045
            L_0x0044:
                r3 = 0
            L_0x0045:
                if (r2 != 0) goto L_0x005f
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "Cannot set a request body for HTTP method "
                r5.append(r6)
                org.jsoup.Connection$Method r6 = r9.b()
                r5.append(r6)
                java.lang.String r5 = r5.toString()
                org.jsoup.helper.c.b(r3, r5)
            L_0x005f:
                java.util.Collection r5 = r9.l()
                int r5 = r5.size()
                r6 = 0
                if (r5 <= 0) goto L_0x0072
                if (r2 == 0) goto L_0x006e
                if (r3 == 0) goto L_0x0072
            L_0x006e:
                e((org.jsoup.Connection.c) r9)
                goto L_0x0079
            L_0x0072:
                if (r2 == 0) goto L_0x0079
                java.lang.String r2 = c((org.jsoup.Connection.c) r9)
                goto L_0x007a
            L_0x0079:
                r2 = r6
            L_0x007a:
                long r7 = java.lang.System.nanoTime()
                java.net.HttpURLConnection r3 = b((org.jsoup.Connection.c) r9)
                r3.connect()     // Catch:{ IOException -> 0x01fd }
                boolean r5 = r3.getDoOutput()     // Catch:{ IOException -> 0x01fd }
                if (r5 == 0) goto L_0x0092
                java.io.OutputStream r5 = r3.getOutputStream()     // Catch:{ IOException -> 0x01fd }
                a(r9, r5, r2)     // Catch:{ IOException -> 0x01fd }
            L_0x0092:
                int r2 = r3.getResponseCode()     // Catch:{ IOException -> 0x01fd }
                org.jsoup.helper.b$c r5 = new org.jsoup.helper.b$c     // Catch:{ IOException -> 0x01fd }
                r5.<init>(r10)     // Catch:{ IOException -> 0x01fd }
                r5.a((java.net.HttpURLConnection) r3, (org.jsoup.helper.b.c) r10)     // Catch:{ IOException -> 0x01fa }
                r5.f33604o = r9     // Catch:{ IOException -> 0x01fa }
                boolean r10 = r5.b((java.lang.String) r1)     // Catch:{ IOException -> 0x01fa }
                if (r10 == 0) goto L_0x0117
                boolean r10 = r9.h()     // Catch:{ IOException -> 0x01fa }
                if (r10 == 0) goto L_0x0117
                r10 = 307(0x133, float:4.3E-43)
                if (r2 == r10) goto L_0x00c4
                org.jsoup.Connection$Method r10 = org.jsoup.Connection.Method.GET     // Catch:{ IOException -> 0x01fa }
                r9.a((org.jsoup.Connection.Method) r10)     // Catch:{ IOException -> 0x01fa }
                java.util.Collection r10 = r9.l()     // Catch:{ IOException -> 0x01fa }
                r10.clear()     // Catch:{ IOException -> 0x01fa }
                r9.d(r6)     // Catch:{ IOException -> 0x01fa }
                java.lang.String r10 = "Content-Type"
                r9.c(r10)     // Catch:{ IOException -> 0x01fa }
            L_0x00c4:
                java.lang.String r10 = r5.a((java.lang.String) r1)     // Catch:{ IOException -> 0x01fa }
                java.lang.String r0 = "http:/"
                boolean r0 = r10.startsWith(r0)     // Catch:{ IOException -> 0x01fa }
                if (r0 == 0) goto L_0x00dd
                r0 = 6
                char r1 = r10.charAt(r0)     // Catch:{ IOException -> 0x01fa }
                r2 = 47
                if (r1 == r2) goto L_0x00dd
                java.lang.String r10 = r10.substring(r0)     // Catch:{ IOException -> 0x01fa }
            L_0x00dd:
                java.net.URL r0 = r9.a()     // Catch:{ IOException -> 0x01fa }
                java.net.URL r10 = oh.c.a((java.net.URL) r0, (java.lang.String) r10)     // Catch:{ IOException -> 0x01fa }
                java.net.URL r10 = org.jsoup.helper.b.a((java.net.URL) r10)     // Catch:{ IOException -> 0x01fa }
                r9.a((java.net.URL) r10)     // Catch:{ IOException -> 0x01fa }
                java.util.Map r10 = r5.f33580d     // Catch:{ IOException -> 0x01fa }
                java.util.Set r10 = r10.entrySet()     // Catch:{ IOException -> 0x01fa }
                java.util.Iterator r10 = r10.iterator()     // Catch:{ IOException -> 0x01fa }
            L_0x00f6:
                boolean r0 = r10.hasNext()     // Catch:{ IOException -> 0x01fa }
                if (r0 == 0) goto L_0x0112
                java.lang.Object r0 = r10.next()     // Catch:{ IOException -> 0x01fa }
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ IOException -> 0x01fa }
                java.lang.Object r1 = r0.getKey()     // Catch:{ IOException -> 0x01fa }
                java.lang.String r1 = (java.lang.String) r1     // Catch:{ IOException -> 0x01fa }
                java.lang.Object r0 = r0.getValue()     // Catch:{ IOException -> 0x01fa }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ IOException -> 0x01fa }
                r9.b(r1, r0)     // Catch:{ IOException -> 0x01fa }
                goto L_0x00f6
            L_0x0112:
                org.jsoup.helper.b$c r9 = a((org.jsoup.Connection.c) r9, (org.jsoup.helper.b.c) r5)     // Catch:{ IOException -> 0x01fa }
                return r9
            L_0x0117:
                r10 = 200(0xc8, float:2.8E-43)
                if (r2 < r10) goto L_0x011f
                r10 = 400(0x190, float:5.6E-43)
                if (r2 < r10) goto L_0x0125
            L_0x011f:
                boolean r10 = r9.i()     // Catch:{ IOException -> 0x01fa }
                if (r10 == 0) goto L_0x01ea
            L_0x0125:
                java.lang.String r10 = r5.f()     // Catch:{ IOException -> 0x01fa }
                if (r10 == 0) goto L_0x0156
                boolean r1 = r9.j()     // Catch:{ IOException -> 0x01fa }
                if (r1 != 0) goto L_0x0156
                java.lang.String r1 = "text/"
                boolean r1 = r10.startsWith(r1)     // Catch:{ IOException -> 0x01fa }
                if (r1 != 0) goto L_0x0156
                java.util.regex.Pattern r1 = f33593p     // Catch:{ IOException -> 0x01fa }
                java.util.regex.Matcher r1 = r1.matcher(r10)     // Catch:{ IOException -> 0x01fa }
                boolean r1 = r1.matches()     // Catch:{ IOException -> 0x01fa }
                if (r1 == 0) goto L_0x0146
                goto L_0x0156
            L_0x0146:
                org.jsoup.UnsupportedMimeTypeException r0 = new org.jsoup.UnsupportedMimeTypeException     // Catch:{ IOException -> 0x01fa }
                java.lang.String r1 = "Unhandled content type. Must be text/*, application/xml, or application/*+xml"
                java.net.URL r9 = r9.a()     // Catch:{ IOException -> 0x01fa }
                java.lang.String r9 = r9.toString()     // Catch:{ IOException -> 0x01fa }
                r0.<init>(r1, r10, r9)     // Catch:{ IOException -> 0x01fa }
                throw r0     // Catch:{ IOException -> 0x01fa }
            L_0x0156:
                if (r10 == 0) goto L_0x0178
                java.util.regex.Pattern r1 = f33593p     // Catch:{ IOException -> 0x01fa }
                java.util.regex.Matcher r10 = r1.matcher(r10)     // Catch:{ IOException -> 0x01fa }
                boolean r10 = r10.matches()     // Catch:{ IOException -> 0x01fa }
                if (r10 == 0) goto L_0x0178
                boolean r10 = r9 instanceof org.jsoup.helper.b.C0244b     // Catch:{ IOException -> 0x01fa }
                if (r10 == 0) goto L_0x0178
                r10 = r9
                org.jsoup.helper.b$b r10 = (org.jsoup.helper.b.C0244b) r10     // Catch:{ IOException -> 0x01fa }
                boolean r10 = r10.f33590n     // Catch:{ IOException -> 0x01fa }
                if (r10 != 0) goto L_0x0178
                org.jsoup.parser.e r10 = org.jsoup.parser.e.d()     // Catch:{ IOException -> 0x01fa }
                r9.a((org.jsoup.parser.e) r10)     // Catch:{ IOException -> 0x01fa }
            L_0x0178:
                java.lang.String r10 = r5.f33600k     // Catch:{ IOException -> 0x01fa }
                java.lang.String r10 = org.jsoup.helper.a.a((java.lang.String) r10)     // Catch:{ IOException -> 0x01fa }
                r5.f33599j = r10     // Catch:{ IOException -> 0x01fa }
                int r10 = r3.getContentLength()     // Catch:{ IOException -> 0x01fa }
                if (r10 == 0) goto L_0x01e1
                org.jsoup.Connection$Method r10 = r9.b()     // Catch:{ IOException -> 0x01fa }
                org.jsoup.Connection$Method r1 = org.jsoup.Connection.Method.HEAD     // Catch:{ IOException -> 0x01fa }
                if (r10 == r1) goto L_0x01e1
                r5.f33597h = r6     // Catch:{ IOException -> 0x01fa }
                java.io.InputStream r10 = r3.getErrorStream()     // Catch:{ IOException -> 0x01fa }
                if (r10 == 0) goto L_0x019b
                java.io.InputStream r10 = r3.getErrorStream()     // Catch:{ IOException -> 0x01fa }
                goto L_0x019f
            L_0x019b:
                java.io.InputStream r10 = r3.getInputStream()     // Catch:{ IOException -> 0x01fa }
            L_0x019f:
                r5.f33597h = r10     // Catch:{ IOException -> 0x01fa }
                java.lang.String r10 = "gzip"
                boolean r10 = r5.d(r0, r10)     // Catch:{ IOException -> 0x01fa }
                if (r10 == 0) goto L_0x01b3
                java.util.zip.GZIPInputStream r10 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x01fa }
                java.io.InputStream r0 = r5.f33597h     // Catch:{ IOException -> 0x01fa }
                r10.<init>(r0)     // Catch:{ IOException -> 0x01fa }
            L_0x01b0:
                r5.f33597h = r10     // Catch:{ IOException -> 0x01fa }
                goto L_0x01c8
            L_0x01b3:
                java.lang.String r10 = "deflate"
                boolean r10 = r5.d(r0, r10)     // Catch:{ IOException -> 0x01fa }
                if (r10 == 0) goto L_0x01c8
                java.util.zip.InflaterInputStream r10 = new java.util.zip.InflaterInputStream     // Catch:{ IOException -> 0x01fa }
                java.io.InputStream r0 = r5.f33597h     // Catch:{ IOException -> 0x01fa }
                java.util.zip.Inflater r1 = new java.util.zip.Inflater     // Catch:{ IOException -> 0x01fa }
                r1.<init>(r4)     // Catch:{ IOException -> 0x01fa }
                r10.<init>(r0, r1)     // Catch:{ IOException -> 0x01fa }
                goto L_0x01b0
            L_0x01c8:
                java.io.InputStream r10 = r5.f33597h     // Catch:{ IOException -> 0x01fa }
                r0 = 32768(0x8000, float:4.5918E-41)
                int r1 = r9.g()     // Catch:{ IOException -> 0x01fa }
                oh.a r10 = oh.a.a(r10, r0, r1)     // Catch:{ IOException -> 0x01fa }
                int r9 = r9.f()     // Catch:{ IOException -> 0x01fa }
                long r0 = (long) r9     // Catch:{ IOException -> 0x01fa }
                oh.a r9 = r10.a(r7, r0)     // Catch:{ IOException -> 0x01fa }
                r5.f33597h = r9     // Catch:{ IOException -> 0x01fa }
                goto L_0x01e7
            L_0x01e1:
                java.nio.ByteBuffer r9 = org.jsoup.helper.a.a()     // Catch:{ IOException -> 0x01fa }
                r5.f33596g = r9     // Catch:{ IOException -> 0x01fa }
            L_0x01e7:
                r5.f33601l = r4
                return r5
            L_0x01ea:
                org.jsoup.HttpStatusException r10 = new org.jsoup.HttpStatusException     // Catch:{ IOException -> 0x01fa }
                java.lang.String r0 = "HTTP error fetching URL"
                java.net.URL r9 = r9.a()     // Catch:{ IOException -> 0x01fa }
                java.lang.String r9 = r9.toString()     // Catch:{ IOException -> 0x01fa }
                r10.<init>(r0, r2, r9)     // Catch:{ IOException -> 0x01fa }
                throw r10     // Catch:{ IOException -> 0x01fa }
            L_0x01fa:
                r9 = move-exception
                r6 = r5
                goto L_0x01fe
            L_0x01fd:
                r9 = move-exception
            L_0x01fe:
                if (r6 == 0) goto L_0x0203
                r6.g()
            L_0x0203:
                goto L_0x0205
            L_0x0204:
                throw r9
            L_0x0205:
                goto L_0x0204
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.b.c.a(org.jsoup.Connection$c, org.jsoup.helper.b$c):org.jsoup.helper.b$c");
        }

        private void a(HttpURLConnection httpURLConnection, c cVar) throws IOException {
            this.f33598i = httpURLConnection;
            this.f33578b = Connection.Method.valueOf(httpURLConnection.getRequestMethod());
            this.f33577a = httpURLConnection.getURL();
            this.f33594e = httpURLConnection.getResponseCode();
            this.f33595f = httpURLConnection.getResponseMessage();
            this.f33600k = httpURLConnection.getContentType();
            a((Map<String, List<String>>) a(httpURLConnection));
            if (cVar != null) {
                for (Map.Entry entry : cVar.d().entrySet()) {
                    if (!f((String) entry.getKey())) {
                        b((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                cVar.g();
            }
        }

        private static void a(Connection.c cVar, OutputStream outputStream, String str) throws IOException {
            Collection<Connection.b> l2 = cVar.l();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, cVar.o()));
            if (str != null) {
                for (Connection.b next : l2) {
                    bufferedWriter.write("--");
                    bufferedWriter.write(str);
                    bufferedWriter.write("\r\n");
                    bufferedWriter.write("Content-Disposition: form-data; name=\"");
                    bufferedWriter.write(b.e(next.a()));
                    bufferedWriter.write("\"");
                    if (next.d()) {
                        bufferedWriter.write("; filename=\"");
                        bufferedWriter.write(b.e(next.b()));
                        bufferedWriter.write("\"\r\nContent-Type: ");
                        bufferedWriter.write(next.e() != null ? next.e() : "application/octet-stream");
                        bufferedWriter.write("\r\n\r\n");
                        bufferedWriter.flush();
                        a.a(next.c(), outputStream);
                        outputStream.flush();
                    } else {
                        bufferedWriter.write("\r\n\r\n");
                        bufferedWriter.write(next.b());
                    }
                    bufferedWriter.write("\r\n");
                }
                bufferedWriter.write("--");
                bufferedWriter.write(str);
                bufferedWriter.write("--");
            } else if (cVar.m() != null) {
                bufferedWriter.write(cVar.m());
            } else {
                boolean z2 = true;
                for (Connection.b next2 : l2) {
                    if (!z2) {
                        bufferedWriter.append('&');
                    } else {
                        z2 = false;
                    }
                    bufferedWriter.write(URLEncoder.encode(next2.a(), cVar.o()));
                    bufferedWriter.write(61);
                    bufferedWriter.write(URLEncoder.encode(next2.b(), cVar.o()));
                }
            }
            bufferedWriter.close();
        }

        private static HttpURLConnection b(Connection.c cVar) throws IOException {
            HttpURLConnection httpURLConnection = (HttpURLConnection) (cVar.e() == null ? cVar.a().openConnection() : cVar.a().openConnection(cVar.e()));
            httpURLConnection.setRequestMethod(cVar.b().name());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setConnectTimeout(cVar.f());
            httpURLConnection.setReadTimeout(cVar.f() / 2);
            if (cVar.k() != null && (httpURLConnection instanceof HttpsURLConnection)) {
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(cVar.k());
            }
            if (cVar.b().a()) {
                httpURLConnection.setDoOutput(true);
            }
            if (cVar.d().size() > 0) {
                httpURLConnection.addRequestProperty("Cookie", d(cVar));
            }
            for (Map.Entry next : cVar.c().entrySet()) {
                for (String addRequestProperty : (List) next.getValue()) {
                    httpURLConnection.addRequestProperty((String) next.getKey(), addRequestProperty);
                }
            }
            return httpURLConnection;
        }

        private static String c(Connection.c cVar) {
            StringBuilder sb;
            String str;
            if (cVar.b("Content-Type")) {
                if (cVar.a("Content-Type").contains("multipart/form-data") && !cVar.a("Content-Type").contains("boundary")) {
                    str = a.b();
                    sb = new StringBuilder();
                }
                return null;
            } else if (b.b(cVar)) {
                str = a.b();
                sb = new StringBuilder();
            } else {
                cVar.a("Content-Type", "application/x-www-form-urlencoded; charset=" + cVar.o());
                return null;
            }
            sb.append("multipart/form-data; boundary=");
            sb.append(str);
            cVar.a("Content-Type", sb.toString());
            return str;
        }

        private static String d(Connection.c cVar) {
            StringBuilder a2 = oh.c.a();
            boolean z2 = true;
            for (Map.Entry next : cVar.d().entrySet()) {
                if (!z2) {
                    a2.append("; ");
                } else {
                    z2 = false;
                }
                a2.append((String) next.getKey());
                a2.append('=');
                a2.append((String) next.getValue());
            }
            return oh.c.a(a2);
        }

        private static void e(Connection.c cVar) throws IOException {
            boolean z2;
            URL a2 = cVar.a();
            StringBuilder a3 = oh.c.a();
            a3.append(a2.getProtocol());
            a3.append("://");
            a3.append(a2.getAuthority());
            a3.append(a2.getPath());
            a3.append("?");
            if (a2.getQuery() != null) {
                a3.append(a2.getQuery());
                z2 = false;
            } else {
                z2 = true;
            }
            for (Connection.b next : cVar.l()) {
                c.b(next.d(), "InputStream data not supported in URL query string.");
                if (!z2) {
                    a3.append('&');
                } else {
                    z2 = false;
                }
                a3.append(URLEncoder.encode(next.a(), "UTF-8"));
                a3.append('=');
                a3.append(URLEncoder.encode(next.b(), "UTF-8"));
            }
            cVar.a(new URL(oh.c.a(a3)));
            cVar.l().clear();
        }

        private void g() {
            InputStream inputStream = this.f33597h;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                } catch (Throwable th) {
                    this.f33597h = null;
                    throw th;
                }
                this.f33597h = null;
            }
            HttpURLConnection httpURLConnection = this.f33598i;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
                this.f33598i = null;
            }
        }

        public /* bridge */ /* synthetic */ String a(String str) {
            return super.a(str);
        }

        public /* bridge */ /* synthetic */ URL a() {
            return super.a();
        }

        public /* bridge */ /* synthetic */ Connection.a a(String str, String str2) {
            return super.a(str, str2);
        }

        public /* bridge */ /* synthetic */ Connection.a a(URL url) {
            return super.a(url);
        }

        public /* bridge */ /* synthetic */ Connection.a a(Connection.Method method) {
            return super.a(method);
        }

        /* access modifiers changed from: package-private */
        public void a(Map<String, List<String>> map) {
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                if (str != null) {
                    List<String> list = (List) next.getValue();
                    if (str.equalsIgnoreCase("Set-Cookie")) {
                        for (String str2 : list) {
                            if (str2 != null) {
                                g gVar = new g(str2);
                                String trim = gVar.e("=").trim();
                                String trim2 = gVar.d(";").trim();
                                if (trim.length() > 0) {
                                    b(trim, trim2);
                                }
                            }
                        }
                    }
                    for (String c2 : list) {
                        c(str, c2);
                    }
                }
            }
        }

        public /* bridge */ /* synthetic */ Connection.Method b() {
            return super.b();
        }

        public /* bridge */ /* synthetic */ Connection.a b(String str, String str2) {
            return super.b(str, str2);
        }

        public /* bridge */ /* synthetic */ boolean b(String str) {
            return super.b(str);
        }

        public /* bridge */ /* synthetic */ Map c() {
            return super.c();
        }

        public /* bridge */ /* synthetic */ Connection.a c(String str) {
            return super.c(str);
        }

        public /* bridge */ /* synthetic */ Connection.a c(String str, String str2) {
            return super.c(str, str2);
        }

        public /* bridge */ /* synthetic */ Map d() {
            return super.d();
        }

        public /* bridge */ /* synthetic */ boolean d(String str, String str2) {
            return super.d(str, str2);
        }

        public /* bridge */ /* synthetic */ List e(String str) {
            return super.e(str);
        }

        public Document e() throws IOException {
            c.a(this.f33601l, "Request must be executed (with .execute(), .get(), or .post() before parsing response");
            if (this.f33596g != null) {
                this.f33597h = new ByteArrayInputStream(this.f33596g.array());
                this.f33602m = false;
            }
            c.b(this.f33602m, "Input stream already read and parsed, cannot re-read.");
            Document a2 = a.a(this.f33597h, this.f33599j, this.f33577a.toExternalForm(), this.f33604o.n());
            this.f33599j = a2.j().b().name();
            this.f33602m = true;
            g();
            return a2;
        }

        public String f() {
            return this.f33600k;
        }

        public /* bridge */ /* synthetic */ boolean f(String str) {
            return super.f(str);
        }
    }

    static URL a(URL url) {
        try {
            return new URL(new URI(url.toExternalForm().replace(" ", "%20")).toASCIIString());
        } catch (MalformedURLException | URISyntaxException unused) {
            return url;
        }
    }

    public static Connection b(String str) {
        b bVar = new b();
        bVar.a(str);
        return bVar;
    }

    /* access modifiers changed from: private */
    public static boolean b(Connection.c cVar) {
        for (Connection.b d2 : cVar.l()) {
            if (d2.d()) {
                return true;
            }
        }
        return false;
    }

    private static String d(String str) {
        try {
            return a(new URL(str)).toExternalForm();
        } catch (Exception unused) {
            return str;
        }
    }

    /* access modifiers changed from: private */
    public static String e(String str) {
        if (str == null) {
            return null;
        }
        return str.replace("\"", "%22");
    }

    public Connection a(int i2) {
        this.f33575a.a(i2);
        return this;
    }

    public Connection a(String str) {
        c.a(str, "Must supply a valid URL");
        try {
            this.f33575a.a(new URL(d(str)));
            return this;
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException("Malformed URL: " + str, e2);
        }
    }

    public Document a() throws IOException {
        this.f33575a.a(Connection.Method.GET);
        b();
        return this.f33576b.e();
    }

    public Connection.d b() throws IOException {
        c a2 = c.a(this.f33575a);
        this.f33576b = a2;
        return a2;
    }
}
