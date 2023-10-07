package ng;

import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;
import nb.c;
import okhttp3.Protocol;

class d extends f {

    /* renamed from: a  reason: collision with root package name */
    private final Method f31566a;

    /* renamed from: b  reason: collision with root package name */
    private final Method f31567b;

    /* renamed from: c  reason: collision with root package name */
    private final Method f31568c;

    /* renamed from: d  reason: collision with root package name */
    private final Class<?> f31569d;

    /* renamed from: e  reason: collision with root package name */
    private final Class<?> f31570e;

    private static class a implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        boolean f31571a;

        /* renamed from: b  reason: collision with root package name */
        String f31572b;

        /* renamed from: c  reason: collision with root package name */
        private final List<String> f31573c;

        a(List<String> list) {
            this.f31573c = list;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = c.f31314b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return true;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f31571a = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f31573c;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        String str = (String) list.get(i2);
                        if (this.f31573c.contains(str)) {
                            this.f31572b = str;
                            return str;
                        }
                    }
                    String str2 = this.f31573c.get(0);
                    this.f31572b = str2;
                    return str2;
                } else if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                } else {
                    this.f31572b = (String) objArr[0];
                    return null;
                }
            }
        }
    }

    d(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f31566a = method;
        this.f31567b = method2;
        this.f31568c = method3;
        this.f31569d = cls;
        this.f31570e = cls2;
    }

    public static f a() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, (ClassLoader) null);
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$Provider", true, (ClassLoader) null);
            Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ClientProvider", true, (ClassLoader) null);
            Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ServerProvider", true, (ClassLoader) null);
            Method method = cls.getMethod("put", new Class[]{SSLSocket.class, cls2});
            return new d(method, cls.getMethod("get", new Class[]{SSLSocket.class}), cls.getMethod(ProductAction.ACTION_REMOVE, new Class[]{SSLSocket.class}), cls3, cls4);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    public String a(SSLSocket sSLSocket) {
        try {
            a aVar = (a) Proxy.getInvocationHandler(this.f31567b.invoke((Object) null, new Object[]{sSLSocket}));
            if (!aVar.f31571a && aVar.f31572b == null) {
                f.e().a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            } else if (aVar.f31571a) {
                return null;
            } else {
                return aVar.f31572b;
            }
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new AssertionError("failed to get ALPN selected protocol", e2);
        }
    }

    public void a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        List<String> a2 = a(list);
        try {
            Object newProxyInstance = Proxy.newProxyInstance(f.class.getClassLoader(), new Class[]{this.f31569d, this.f31570e}, new a(a2));
            this.f31566a.invoke((Object) null, new Object[]{sSLSocket, newProxyInstance});
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new AssertionError("failed to set ALPN", e2);
        }
    }

    public void b(SSLSocket sSLSocket) {
        try {
            this.f31568c.invoke((Object) null, new Object[]{sSLSocket});
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new AssertionError("failed to remove ALPN", e2);
        }
    }
}
