package org.jsoup;

import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;
import org.jsoup.nodes.Document;
import org.jsoup.parser.e;

public interface Connection {

    public enum Method {
        GET(false),
        POST(true),
        PUT(true),
        DELETE(false),
        PATCH(true),
        HEAD(false),
        OPTIONS(false),
        TRACE(false);
        

        /* renamed from: i  reason: collision with root package name */
        private final boolean f33566i;

        private Method(boolean z2) {
            this.f33566i = z2;
        }

        public final boolean a() {
            return this.f33566i;
        }
    }

    public interface a<T extends a> {
        String a(String str);

        URL a();

        T a(String str, String str2);

        T a(URL url);

        T a(Method method);

        Method b();

        T b(String str, String str2);

        boolean b(String str);

        Map<String, List<String>> c();

        T c(String str);

        Map<String, String> d();
    }

    public interface b {
        String a();

        String b();

        InputStream c();

        boolean d();

        String e();
    }

    public interface c extends a<c> {
        c a(int i2);

        c a(e eVar);

        c d(String str);

        Proxy e();

        int f();

        int g();

        boolean h();

        boolean i();

        boolean j();

        SSLSocketFactory k();

        Collection<b> l();

        String m();

        e n();

        String o();
    }

    public interface d extends a<d> {
        Document e() throws IOException;
    }

    Connection a(int i2);

    Connection a(String str);

    Document a() throws IOException;
}
