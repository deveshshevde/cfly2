package im;

import iq.c;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    protected URLConnection f13601a;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public Proxy f13602a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public Integer f13603b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public Integer f13604c;
    }

    public static class b implements c.b {

        /* renamed from: a  reason: collision with root package name */
        private final a f13605a;

        public b() {
            this((a) null);
        }

        public b(a aVar) {
            this.f13605a = aVar;
        }

        public b a(String str) throws IOException {
            return new c(str, this.f13605a);
        }
    }

    public c(String str, a aVar) throws IOException {
        this(new URL(str), aVar);
    }

    public c(URL url, a aVar) throws IOException {
        this.f13601a = (aVar == null || aVar.f13602a == null) ? url.openConnection() : url.openConnection(aVar.f13602a);
        if (aVar != null) {
            if (aVar.f13603b != null) {
                this.f13601a.setReadTimeout(aVar.f13603b.intValue());
            }
            if (aVar.f13604c != null) {
                this.f13601a.setConnectTimeout(aVar.f13604c.intValue());
            }
        }
    }

    public InputStream a() throws IOException {
        return this.f13601a.getInputStream();
    }

    public String a(String str) {
        return this.f13601a.getHeaderField(str);
    }

    public void a(String str, String str2) {
        this.f13601a.addRequestProperty(str, str2);
    }

    public boolean a(String str, long j2) {
        return false;
    }

    public Map<String, List<String>> b() {
        return this.f13601a.getRequestProperties();
    }

    public boolean b(String str) throws ProtocolException {
        URLConnection uRLConnection = this.f13601a;
        if (!(uRLConnection instanceof HttpURLConnection)) {
            return false;
        }
        ((HttpURLConnection) uRLConnection).setRequestMethod(str);
        return true;
    }

    public Map<String, List<String>> c() {
        return this.f13601a.getHeaderFields();
    }

    public void d() throws IOException {
        this.f13601a.connect();
    }

    public int e() throws IOException {
        URLConnection uRLConnection = this.f13601a;
        if (uRLConnection instanceof HttpURLConnection) {
            return ((HttpURLConnection) uRLConnection).getResponseCode();
        }
        return 0;
    }

    public void f() {
        try {
            this.f13601a.getInputStream().close();
        } catch (IOException unused) {
        }
    }
}
