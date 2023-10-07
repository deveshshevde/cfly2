package org.apache.commons.net.ftp;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.net.MalformedServerReplyException;
import org.apache.commons.net.ftp.parser.d;

public class c extends b implements a {

    /* renamed from: s  reason: collision with root package name */
    private static final Pattern f32847s = Pattern.compile("(\\d{1,3},\\d{1,3},\\d{1,3},\\d{1,3}),(\\d{1,3}),(\\d{1,3})");
    private InetAddress A;
    private InetAddress B;
    private InetAddress C;
    private int D;
    private int E;
    private int F;
    private int G;
    private boolean H;
    private long I;
    private d J;
    private int K;
    private int L;
    private int M;
    private boolean N;
    private boolean O;
    private String P;
    private e Q;
    private String R;
    private d S;
    private int T = 1000;
    private a U = new b(this);
    private boolean V = false;
    private HashMap<String, Set<String>> W;

    /* renamed from: t  reason: collision with root package name */
    private int f32848t;

    /* renamed from: u  reason: collision with root package name */
    private int f32849u;

    /* renamed from: v  reason: collision with root package name */
    private int f32850v;

    /* renamed from: w  reason: collision with root package name */
    private String f32851w;

    /* renamed from: x  reason: collision with root package name */
    private final Random f32852x;

    /* renamed from: y  reason: collision with root package name */
    private int f32853y;

    /* renamed from: z  reason: collision with root package name */
    private int f32854z;

    public interface a {
        String a(String str) throws UnknownHostException;
    }

    public static class b implements a {

        /* renamed from: a  reason: collision with root package name */
        private final c f32855a;

        public b(c cVar) {
            this.f32855a = cVar;
        }

        public String a(String str) throws UnknownHostException {
            if (!InetAddress.getByName(str).isSiteLocalAddress()) {
                return str;
            }
            InetAddress f2 = this.f32855a.f();
            return !f2.isSiteLocalAddress() ? f2.getHostAddress() : str;
        }
    }

    /* renamed from: org.apache.commons.net.ftp.c$c  reason: collision with other inner class name */
    private static class C0240c {

        /* renamed from: a  reason: collision with root package name */
        static final Properties f32856a;

        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0012 */
        static {
            /*
                java.lang.Class<org.apache.commons.net.ftp.c> r0 = org.apache.commons.net.ftp.c.class
                java.lang.String r1 = "/systemType.properties"
                java.io.InputStream r0 = r0.getResourceAsStream(r1)
                if (r0 == 0) goto L_0x001b
                java.util.Properties r1 = new java.util.Properties
                r1.<init>()
                r1.load(r0)     // Catch:{ IOException -> 0x0012, all -> 0x0016 }
            L_0x0012:
                r0.close()     // Catch:{ IOException -> 0x001c }
                goto L_0x001c
            L_0x0016:
                r1 = move-exception
                r0.close()     // Catch:{ IOException -> 0x001a }
            L_0x001a:
                throw r1
            L_0x001b:
                r1 = 0
            L_0x001c:
                f32856a = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.net.ftp.c.C0240c.<clinit>():void");
        }
    }

    public c() {
        A();
        this.f32849u = -1;
        this.H = true;
        this.J = new org.apache.commons.net.ftp.parser.c();
        this.S = null;
        this.N = false;
        this.O = false;
        this.f32852x = new Random();
        this.C = null;
    }

    private void A() {
        this.f32848t = 0;
        this.f32851w = null;
        this.f32850v = -1;
        this.A = null;
        this.B = null;
        this.f32853y = 0;
        this.f32854z = 0;
        this.D = 0;
        this.F = 7;
        this.E = 4;
        this.G = 10;
        this.I = 0;
        this.P = null;
        this.Q = null;
        this.R = "";
        this.W = null;
    }

    private boolean B() throws IOException {
        String str;
        String str2;
        if (this.W == null) {
            int n2 = n();
            if (n2 == 530) {
                return false;
            }
            boolean b2 = j.b(n2);
            this.W = new HashMap<>();
            if (!b2) {
                return false;
            }
            Iterator it2 = this.f32838k.iterator();
            while (it2.hasNext()) {
                String str3 = (String) it2.next();
                if (str3.startsWith(" ")) {
                    int indexOf = str3.indexOf(32, 1);
                    if (indexOf > 0) {
                        str = str3.substring(1, indexOf);
                        str2 = str3.substring(indexOf + 1);
                    } else {
                        str = str3.substring(1);
                        str2 = "";
                    }
                    String upperCase = str.toUpperCase(Locale.ENGLISH);
                    Set set = this.W.get(upperCase);
                    if (set == null) {
                        set = new HashSet();
                        this.W.put(upperCase, set);
                    }
                    set.add(str2);
                }
            }
        }
        return true;
    }

    private OutputStream a(OutputStream outputStream) {
        return this.K > 0 ? new BufferedOutputStream(outputStream, this.K) : new BufferedOutputStream(outputStream);
    }

    /* JADX INFO: finally extract failed */
    private i a(e eVar, String str) throws IOException {
        Socket b2 = b(FTPCmd.LIST, n(str));
        i iVar = new i(eVar, this.S);
        if (b2 == null) {
            return iVar;
        }
        try {
            iVar.a(b2.getInputStream(), h());
            nm.d.a(b2);
            r();
            return iVar;
        } catch (Throwable th) {
            nm.d.a(b2);
            throw th;
        }
    }

    private OutputStream c(FTPCmd fTPCmd, String str) throws IOException {
        return d(fTPCmd.a(), str);
    }

    private static Properties w() {
        return C0240c.f32856a;
    }

    private int x() {
        int i2;
        int i3 = this.f32853y;
        if (i3 <= 0 || (i2 = this.f32854z) < i3) {
            return 0;
        }
        return i2 == i3 ? i2 : this.f32852x.nextInt((i2 - i3) + 1) + this.f32853y;
    }

    private InetAddress y() {
        InetAddress inetAddress = this.A;
        return inetAddress != null ? inetAddress : e();
    }

    private InetAddress z() {
        InetAddress inetAddress = this.B;
        return inetAddress != null ? inetAddress : y();
    }

    /* access modifiers changed from: protected */
    public void a() throws IOException {
        a((Reader) null);
    }

    /* access modifiers changed from: protected */
    public void a(Reader reader) throws IOException {
        super.a(reader);
        A();
        if (this.V) {
            ArrayList arrayList = new ArrayList(this.f32838k);
            int i2 = this.f32837j;
            if (o("UTF8") || o("UTF-8")) {
                a("UTF-8");
                this.f32844q = new nm.a(new InputStreamReader(this.f32768e, h()));
                this.f32845r = new BufferedWriter(new OutputStreamWriter(this.f32769f, h()));
            }
            this.f32838k.clear();
            this.f32838k.addAll(arrayList);
            this.f32837j = i2;
            this.f32839l = true;
        }
    }

    public void a(d dVar) {
        this.S = dVar;
    }

    /* access modifiers changed from: protected */
    public boolean a(long j2) throws IOException {
        this.I = 0;
        return j.c(e(Long.toString(j2)));
    }

    /* access modifiers changed from: protected */
    public Socket b(FTPCmd fTPCmd, String str) throws IOException {
        return c(fTPCmd.a(), str);
    }

    public void b(long j2) {
        if (j2 >= 0) {
            this.I = j2;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00a1, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00a2, code lost:
        if (r2 != null) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00a8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00a9, code lost:
        r9.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ac, code lost:
        throw r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.net.Socket c(java.lang.String r9, java.lang.String r10) throws java.io.IOException {
        /*
            r8 = this;
            int r0 = r8.f32848t
            r1 = 0
            if (r0 == 0) goto L_0x0009
            r2 = 2
            if (r0 == r2) goto L_0x0009
            return r1
        L_0x0009:
            java.net.InetAddress r0 = r8.f()
            boolean r0 = r0 instanceof java.net.Inet6Address
            int r2 = r8.f32848t
            r3 = 0
            r5 = 1
            if (r2 != 0) goto L_0x00ad
            javax.net.ServerSocketFactory r2 = r8.f32771h
            int r6 = r8.x()
            java.net.InetAddress r7 = r8.y()
            java.net.ServerSocket r2 = r2.createServerSocket(r6, r5, r7)
            if (r0 == 0) goto L_0x003e
            java.net.InetAddress r0 = r8.z()     // Catch:{ all -> 0x009f }
            int r5 = r2.getLocalPort()     // Catch:{ all -> 0x009f }
            int r0 = r8.b((java.net.InetAddress) r0, (int) r5)     // Catch:{ all -> 0x009f }
            boolean r0 = org.apache.commons.net.ftp.j.b(r0)     // Catch:{ all -> 0x009f }
            if (r0 != 0) goto L_0x0056
            if (r2 == 0) goto L_0x003d
            r2.close()
        L_0x003d:
            return r1
        L_0x003e:
            java.net.InetAddress r0 = r8.z()     // Catch:{ all -> 0x009f }
            int r5 = r2.getLocalPort()     // Catch:{ all -> 0x009f }
            int r0 = r8.a((java.net.InetAddress) r0, (int) r5)     // Catch:{ all -> 0x009f }
            boolean r0 = org.apache.commons.net.ftp.j.b(r0)     // Catch:{ all -> 0x009f }
            if (r0 != 0) goto L_0x0056
            if (r2 == 0) goto L_0x0055
            r2.close()
        L_0x0055:
            return r1
        L_0x0056:
            long r5 = r8.I     // Catch:{ all -> 0x009f }
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x0068
            boolean r0 = r8.a((long) r5)     // Catch:{ all -> 0x009f }
            if (r0 != 0) goto L_0x0068
            if (r2 == 0) goto L_0x0067
            r2.close()
        L_0x0067:
            return r1
        L_0x0068:
            int r9 = r8.b((java.lang.String) r9, (java.lang.String) r10)     // Catch:{ all -> 0x009f }
            boolean r9 = org.apache.commons.net.ftp.j.a(r9)     // Catch:{ all -> 0x009f }
            if (r9 != 0) goto L_0x0078
            if (r2 == 0) goto L_0x0077
            r2.close()
        L_0x0077:
            return r1
        L_0x0078:
            int r9 = r8.f32849u     // Catch:{ all -> 0x009f }
            if (r9 < 0) goto L_0x007f
            r2.setSoTimeout(r9)     // Catch:{ all -> 0x009f }
        L_0x007f:
            java.net.Socket r9 = r2.accept()     // Catch:{ all -> 0x009f }
            int r10 = r8.f32849u     // Catch:{ all -> 0x009f }
            if (r10 < 0) goto L_0x008a
            r9.setSoTimeout(r10)     // Catch:{ all -> 0x009f }
        L_0x008a:
            int r10 = r8.M     // Catch:{ all -> 0x009f }
            if (r10 <= 0) goto L_0x0091
            r9.setReceiveBufferSize(r10)     // Catch:{ all -> 0x009f }
        L_0x0091:
            int r10 = r8.L     // Catch:{ all -> 0x009f }
            if (r10 <= 0) goto L_0x0098
            r9.setSendBufferSize(r10)     // Catch:{ all -> 0x009f }
        L_0x0098:
            if (r2 == 0) goto L_0x013b
            r2.close()
            goto L_0x013b
        L_0x009f:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x00a1 }
        L_0x00a1:
            r10 = move-exception
            if (r2 == 0) goto L_0x00ac
            r2.close()     // Catch:{ all -> 0x00a8 }
            goto L_0x00ac
        L_0x00a8:
            r0 = move-exception
            r9.addSuppressed(r0)
        L_0x00ac:
            throw r10
        L_0x00ad:
            boolean r2 = r8.v()
            r6 = 0
            if (r2 != 0) goto L_0x00b8
            if (r0 == 0) goto L_0x00b7
            goto L_0x00b8
        L_0x00b7:
            r5 = 0
        L_0x00b8:
            if (r5 == 0) goto L_0x00ce
            int r2 = r8.m()
            r5 = 229(0xe5, float:3.21E-43)
            if (r2 != r5) goto L_0x00ce
            java.util.ArrayList r0 = r8.f32838k
            java.lang.Object r0 = r0.get(r6)
            java.lang.String r0 = (java.lang.String) r0
            r8.h(r0)
            goto L_0x00e5
        L_0x00ce:
            if (r0 == 0) goto L_0x00d1
            return r1
        L_0x00d1:
            int r0 = r8.l()
            r2 = 227(0xe3, float:3.18E-43)
            if (r0 == r2) goto L_0x00da
            return r1
        L_0x00da:
            java.util.ArrayList r0 = r8.f32838k
            java.lang.Object r0 = r0.get(r6)
            java.lang.String r0 = (java.lang.String) r0
            r8.i(r0)
        L_0x00e5:
            javax.net.SocketFactory r0 = r8.f32770g
            java.net.Socket r0 = r0.createSocket()
            int r2 = r8.M
            if (r2 <= 0) goto L_0x00f2
            r0.setReceiveBufferSize(r2)
        L_0x00f2:
            int r2 = r8.L
            if (r2 <= 0) goto L_0x00f9
            r0.setSendBufferSize(r2)
        L_0x00f9:
            java.net.InetAddress r2 = r8.C
            if (r2 == 0) goto L_0x0107
            java.net.InetSocketAddress r2 = new java.net.InetSocketAddress
            java.net.InetAddress r5 = r8.C
            r2.<init>(r5, r6)
            r0.bind(r2)
        L_0x0107:
            int r2 = r8.f32849u
            if (r2 < 0) goto L_0x010e
            r0.setSoTimeout(r2)
        L_0x010e:
            java.net.InetSocketAddress r2 = new java.net.InetSocketAddress
            java.lang.String r5 = r8.f32851w
            int r6 = r8.f32850v
            r2.<init>(r5, r6)
            int r5 = r8.f32772i
            r0.connect(r2, r5)
            long r5 = r8.I
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 <= 0) goto L_0x012c
            boolean r2 = r8.a((long) r5)
            if (r2 != 0) goto L_0x012c
            r0.close()
            return r1
        L_0x012c:
            int r9 = r8.b((java.lang.String) r9, (java.lang.String) r10)
            boolean r9 = org.apache.commons.net.ftp.j.a(r9)
            if (r9 != 0) goto L_0x013a
            r0.close()
            return r1
        L_0x013a:
            r9 = r0
        L_0x013b:
            boolean r10 = r8.H
            if (r10 == 0) goto L_0x0178
            boolean r10 = r8.a((java.net.Socket) r9)
            if (r10 == 0) goto L_0x0146
            goto L_0x0178
        L_0x0146:
            java.net.InetAddress r10 = r9.getInetAddress()
            r9.close()
            java.io.IOException r9 = new java.io.IOException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Host attempting data connection "
            r0.append(r1)
            java.lang.String r10 = r10.getHostAddress()
            r0.append(r10)
            java.lang.String r10 = " is not same as server "
            r0.append(r10)
            java.net.InetAddress r10 = r8.f()
            java.lang.String r10 = r10.getHostAddress()
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            r9.<init>(r10)
            throw r9
        L_0x0178:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.net.ftp.c.c(java.lang.String, java.lang.String):java.net.Socket");
    }

    public void c() throws IOException {
        super.c();
        A();
    }

    public boolean c(int i2) throws IOException {
        if (!j.b(b(i2))) {
            return false;
        }
        this.D = i2;
        this.E = 4;
        return true;
    }

    /* access modifiers changed from: protected */
    public OutputStream d(String str, String str2) throws IOException {
        Socket c2 = c(str, str2);
        if (c2 == null) {
            return null;
        }
        return new nm.b(c2, this.D == 0 ? new nm.c(a(c2.getOutputStream())) : c2.getOutputStream());
    }

    public i e(String str, String str2) throws IOException {
        l(str);
        return a(this.Q, str2);
    }

    public boolean f(String str, String str2) throws IOException {
        b(str);
        if (j.b(this.f32837j)) {
            return true;
        }
        if (!j.c(this.f32837j)) {
            return false;
        }
        return j.b(c(str2));
    }

    /* access modifiers changed from: protected */
    public void h(String str) throws MalformedServerReplyException {
        String trim = str.substring(str.indexOf(40) + 1, str.indexOf(41)).trim();
        char charAt = trim.charAt(0);
        char charAt2 = trim.charAt(1);
        char charAt3 = trim.charAt(2);
        char charAt4 = trim.charAt(trim.length() - 1);
        if (charAt == charAt2 && charAt2 == charAt3 && charAt3 == charAt4) {
            try {
                int parseInt = Integer.parseInt(trim.substring(3, trim.length() - 1));
                this.f32851w = f().getHostAddress();
                this.f32850v = parseInt;
            } catch (NumberFormatException unused) {
                throw new MalformedServerReplyException("Could not parse extended passive host information.\nServer Reply: " + trim);
            }
        } else {
            throw new MalformedServerReplyException("Could not parse extended passive host information.\nServer Reply: " + trim);
        }
    }

    /* access modifiers changed from: protected */
    public void i(String str) throws MalformedServerReplyException {
        Matcher matcher = f32847s.matcher(str);
        if (matcher.find()) {
            this.f32851w = "0,0,0,0".equals(matcher.group(1)) ? this.f32765b.getInetAddress().getHostAddress() : matcher.group(1).replace(',', '.');
            try {
                this.f32850v = Integer.parseInt(matcher.group(3)) | (Integer.parseInt(matcher.group(2)) << 8);
                a aVar = this.U;
                if (aVar != null) {
                    try {
                        String a2 = aVar.a(this.f32851w);
                        if (!this.f32851w.equals(a2)) {
                            a(0, "[Replacing PASV mode reply address " + this.f32851w + " with " + a2 + "]\n");
                            this.f32851w = a2;
                        }
                    } catch (UnknownHostException unused) {
                        throw new MalformedServerReplyException("Could not parse passive host information.\nServer Reply: " + str);
                    }
                }
            } catch (NumberFormatException unused2) {
                throw new MalformedServerReplyException("Could not parse passive port information.\nServer Reply: " + str);
            }
        } else {
            throw new MalformedServerReplyException("Could not parse passive host information.\nServer Reply: " + str);
        }
    }

    public OutputStream j(String str) throws IOException {
        return c(FTPCmd.APPE, str);
    }

    public boolean k(String str) throws IOException {
        return j.b(d(str));
    }

    /* access modifiers changed from: package-private */
    public void l(String str) throws IOException {
        e a2;
        String property;
        if (this.Q == null || (str != null && !this.R.equals(str))) {
            if (str != null) {
                a2 = this.J.a(str);
            } else {
                d dVar = this.S;
                if (dVar == null || dVar.a().length() <= 0) {
                    str = System.getProperty("org.apache.commons.net.ftp.systemType");
                    if (str == null) {
                        str = u();
                        Properties w2 = w();
                        if (!(w2 == null || (property = w2.getProperty(str)) == null)) {
                            str = property;
                        }
                    }
                    a2 = this.S != null ? this.J.a(new d(str, this.S)) : this.J.a(str);
                } else {
                    this.Q = this.J.a(this.S);
                    str = this.S.a();
                    this.R = str;
                }
            }
            this.Q = a2;
            this.R = str;
        }
    }

    public boolean m(String str) throws IOException {
        return j.b(f(str));
    }

    /* access modifiers changed from: protected */
    public String n(String str) {
        if (!t()) {
            return str;
        }
        if (str == null) {
            return "-a";
        }
        StringBuilder sb = new StringBuilder(str.length() + 3);
        sb.append("-a ");
        sb.append(str);
        return sb.toString();
    }

    public boolean o(String str) throws IOException {
        if (!B()) {
            return false;
        }
        return this.W.containsKey(str.toUpperCase(Locale.ENGLISH));
    }

    public FTPFile[] p(String str) throws IOException {
        return e((String) null, str).a();
    }

    public boolean q(String str) throws IOException {
        return j.b(g(str));
    }

    public boolean r() throws IOException {
        return j.b(j());
    }

    public void s() {
        this.f32848t = 2;
        this.f32851w = null;
        this.f32850v = -1;
    }

    public boolean t() {
        return this.N;
    }

    public String u() throws IOException {
        String property;
        if (this.P == null) {
            if (j.b(o())) {
                property = ((String) this.f32838k.get(this.f32838k.size() - 1)).substring(4);
            } else {
                property = System.getProperty("org.apache.commons.net.ftp.systemType.default");
                if (property == null) {
                    throw new IOException("Unable to determine system type - response: " + k());
                }
            }
            this.P = property;
        }
        return this.P;
    }

    public boolean v() {
        return this.O;
    }
}
