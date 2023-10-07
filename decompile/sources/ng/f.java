package ng;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import ni.a;
import ni.b;
import ni.e;
import okhttp3.Protocol;
import okhttp3.x;
import okio.c;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final f f31576a = a();

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f31577b = Logger.getLogger(x.class.getName());

    static <T> T a(Object obj, Class<T> cls, String str) {
        Object a2;
        Class cls2 = obj.getClass();
        while (cls2 != Object.class) {
            try {
                Field declaredField = cls2.getDeclaredField(str);
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (!cls.isInstance(obj2)) {
                    return null;
                }
                return cls.cast(obj2);
            } catch (NoSuchFieldException unused) {
                cls2 = cls2.getSuperclass();
            } catch (IllegalAccessException unused2) {
                throw new AssertionError();
            }
        }
        if (str.equals("delegate") || (a2 = a(obj, Object.class, "delegate")) == null) {
            return null;
        }
        return a(a2, cls, str);
    }

    public static List<String> a(List<Protocol> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Protocol protocol = list.get(i2);
            if (protocol != Protocol.HTTP_1_0) {
                arrayList.add(protocol.toString());
            }
        }
        return arrayList;
    }

    private static f a() {
        return g() ? d() : b();
    }

    private static f b() {
        c a2;
        if (f() && (a2 = c.a()) != null) {
            return a2;
        }
        e a3 = e.a();
        if (a3 != null) {
            return a3;
        }
        f a4 = d.a();
        return a4 != null ? a4 : new f();
    }

    static byte[] b(List<Protocol> list) {
        c cVar = new c();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Protocol protocol = list.get(i2);
            if (protocol != Protocol.HTTP_1_0) {
                cVar.i(protocol.toString().length());
                cVar.b(protocol.toString());
            }
        }
        return cVar.r();
    }

    private static f d() {
        f a2 = a.a();
        if (a2 != null) {
            return a2;
        }
        f b2 = b.b();
        Objects.requireNonNull(b2, "No platform found on Android");
        return b2;
    }

    public static f e() {
        return f31576a;
    }

    public static boolean f() {
        if ("conscrypt".equals(nb.c.a("okhttp.platform", (String) null))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    public static boolean g() {
        return "Dalvik".equals(System.getProperty("java.vm.name"));
    }

    public Object a(String str) {
        if (f31577b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public String a(SSLSocket sSLSocket) {
        return null;
    }

    /* access modifiers changed from: protected */
    public X509TrustManager a(SSLSocketFactory sSLSocketFactory) {
        try {
            Object a2 = a((Object) sSLSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
            if (a2 == null) {
                return null;
            }
            return (X509TrustManager) a((Object) a2, X509TrustManager.class, "trustManager");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public ni.c a(X509TrustManager x509TrustManager) {
        return new a(b(x509TrustManager));
    }

    public void a(int i2, String str, Throwable th) {
        f31577b.log(i2 == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void a(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        a(5, str, (Throwable) obj);
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i2) throws IOException {
        socket.connect(inetSocketAddress, i2);
    }

    public void a(SSLSocket sSLSocket, String str, List<Protocol> list) throws IOException {
    }

    public e b(X509TrustManager x509TrustManager) {
        return new b(x509TrustManager.getAcceptedIssuers());
    }

    public void b(SSLSocket sSLSocket) {
    }

    public void b(SSLSocketFactory sSLSocketFactory) {
    }

    public boolean b(String str) {
        return true;
    }

    public SSLContext c() {
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException("No TLS provider", e2);
        }
    }

    public ni.c c(SSLSocketFactory sSLSocketFactory) {
        X509TrustManager a2 = a(sSLSocketFactory);
        if (a2 != null) {
            return a(a2);
        }
        throw new IllegalStateException("Unable to extract the trust manager on " + e() + ", sslSocketFactory is " + sSLSocketFactory.getClass());
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
