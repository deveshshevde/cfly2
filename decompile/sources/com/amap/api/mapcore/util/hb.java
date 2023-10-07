package com.amap.api.mapcore.util;

import android.content.Context;
import android.net.SSLSessionCache;
import android.os.Build;
import com.amap.api.mapcore.util.ew;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public final class hb extends SSLSocketFactory {

    /* renamed from: a  reason: collision with root package name */
    private SSLSocketFactory f9079a;

    /* renamed from: b  reason: collision with root package name */
    private Context f9080b;

    /* renamed from: c  reason: collision with root package name */
    private SSLContext f9081c;

    public hb(Context context, SSLContext sSLContext) {
        if (context != null) {
            try {
                this.f9080b = context.getApplicationContext();
            } catch (Throwable th) {
                fz.c(th, "myssl", "<init3>");
                return;
            }
        }
        this.f9081c = sSLContext;
        if (sSLContext != null) {
            this.f9079a = sSLContext.getSocketFactory();
        }
        try {
            if (this.f9081c == null && Build.VERSION.SDK_INT >= 9) {
                this.f9081c = SSLContext.getDefault();
            }
        } catch (Throwable th2) {
            fz.c(th2, "myssl", "<init2>");
        }
        try {
            if (this.f9079a == null) {
                this.f9079a = (SSLSocketFactory) SSLSocketFactory.getDefault();
                return;
            }
            return;
        } catch (Throwable th3) {
            fz.c(th3, "myssl", "<init3>");
            return;
        }
        if (this.f9079a == null) {
            this.f9079a = (SSLSocketFactory) SSLSocketFactory.getDefault();
        }
    }

    private static Socket a(Socket socket) {
        try {
            if (Build.VERSION.SDK_INT >= 21 && ew.e.f8665b && (socket instanceof SSLSocket)) {
                ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.2"});
            }
        } catch (Throwable th) {
            fz.c(th, "myssl", "stlv2");
        }
        return socket;
    }

    private void a(SSLSessionCache sSLSessionCache) {
        SSLContext sSLContext = this.f9081c;
        if (sSLContext != null) {
            try {
                SSLSessionContext clientSessionContext = sSLContext.getClientSessionContext();
                Field declaredField = sSLSessionCache.getClass().getDeclaredField(fg.c("UbVNlc3Npb25DYWNoZQ"));
                declaredField.setAccessible(true);
                Object obj = declaredField.get(sSLSessionCache);
                Method[] methods = clientSessionContext.getClass().getMethods();
                String c2 = fg.c("Yc2V0UGVyc2lzdGVudENhY2hl");
                for (Method method : methods) {
                    if (method.getName().equals(c2)) {
                        method.invoke(clientSessionContext, new Object[]{obj});
                        return;
                    }
                }
            } catch (Throwable th) {
                fz.c(th, "myssl", "isc2");
            }
        }
    }

    private static void b(Socket socket) {
        if (Build.VERSION.SDK_INT >= 17 && ew.e.f8666c && ew.e.f8668e && (socket instanceof SSLSocket)) {
            int i2 = ew.e.f8669f > ew.e.f8667d ? ew.e.f8667d : ew.e.f8669f;
            if (i2 <= 17 || Build.VERSION.SDK_INT <= i2) {
                try {
                    socket.getClass().getMethod(fg.c("Cc2V0VXNlU2Vzc2lvblRpY2tldHM"), new Class[]{Boolean.TYPE}).invoke(socket, new Object[]{Boolean.TRUE});
                } catch (Throwable th) {
                    fz.c(th, "myssl", "sust");
                }
            }
        }
    }

    public final void a() {
        if (Build.VERSION.SDK_INT >= 17 && ew.e.f8666c && this.f9080b != null && this.f9081c != null) {
            int i2 = ew.e.f8667d;
            if (i2 <= 17 || Build.VERSION.SDK_INT <= i2) {
                SSLSessionCache sSLSessionCache = new SSLSessionCache(this.f9080b);
                if (Build.VERSION.SDK_INT <= 20 || Build.VERSION.SDK_INT >= 28) {
                    a(sSLSessionCache);
                    return;
                }
                try {
                    sSLSessionCache.getClass().getMethod(fg.c("MaW5zdGFsbA"), new Class[]{SSLSessionCache.class, SSLContext.class}).invoke(sSLSessionCache, new Object[]{sSLSessionCache, this.f9081c});
                } catch (Throwable th) {
                    fz.c(th, "myssl", "isc1");
                    a(sSLSessionCache);
                }
            }
        }
    }

    public final Socket createSocket() throws IOException {
        try {
            SSLSocketFactory sSLSocketFactory = this.f9079a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket a2 = a(sSLSocketFactory.createSocket());
            b(a2);
            return a2;
        } catch (Throwable th) {
            fz.c(th, "myssl", "cs1");
            if (!(th instanceof IOException)) {
                return null;
            }
            throw th;
        }
    }

    public final Socket createSocket(String str, int i2) throws IOException, UnknownHostException {
        try {
            SSLSocketFactory sSLSocketFactory = this.f9079a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket a2 = a(sSLSocketFactory.createSocket(str, i2));
            b(a2);
            return a2;
        } catch (Throwable th) {
            fz.c(th, "myssl", "cs3");
            if (th instanceof UnknownHostException) {
                throw th;
            } else if (!(th instanceof IOException)) {
                return null;
            } else {
                throw th;
            }
        }
    }

    public final Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException, UnknownHostException {
        try {
            SSLSocketFactory sSLSocketFactory = this.f9079a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket a2 = a(sSLSocketFactory.createSocket(str, i2, inetAddress, i3));
            b(a2);
            return a2;
        } catch (Throwable th) {
            fz.c(th, "myssl", "cs4");
            if (th instanceof UnknownHostException) {
                throw th;
            } else if (!(th instanceof IOException)) {
                return null;
            } else {
                throw th;
            }
        }
    }

    public final Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        try {
            SSLSocketFactory sSLSocketFactory = this.f9079a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket a2 = a(sSLSocketFactory.createSocket(inetAddress, i2));
            b(a2);
            return a2;
        } catch (Throwable th) {
            fz.c(th, "myssl", "cs5");
            if (!(th instanceof IOException)) {
                return null;
            }
            throw th;
        }
    }

    public final Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        try {
            SSLSocketFactory sSLSocketFactory = this.f9079a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket a2 = a(sSLSocketFactory.createSocket(inetAddress, i2, inetAddress2, i3));
            b(a2);
            return a2;
        } catch (Throwable th) {
            fz.c(th, "myssl", "cs6");
            if (!(th instanceof IOException)) {
                return null;
            }
            throw th;
        }
    }

    public final Socket createSocket(Socket socket, String str, int i2, boolean z2) throws IOException {
        try {
            SSLSocketFactory sSLSocketFactory = this.f9079a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket a2 = a(sSLSocketFactory.createSocket(socket, str, i2, z2));
            b(a2);
            return a2;
        } catch (Throwable th) {
            fz.c(th, "myssl", "cs2");
            if (!(th instanceof IOException)) {
                return null;
            }
            throw th;
        }
    }

    public final String[] getDefaultCipherSuites() {
        try {
            SSLSocketFactory sSLSocketFactory = this.f9079a;
            if (sSLSocketFactory != null) {
                return sSLSocketFactory.getDefaultCipherSuites();
            }
        } catch (Throwable th) {
            fz.c(th, "myssl", "gdcs");
        }
        return new String[0];
    }

    public final String[] getSupportedCipherSuites() {
        try {
            SSLSocketFactory sSLSocketFactory = this.f9079a;
            if (sSLSocketFactory != null) {
                return sSLSocketFactory.getSupportedCipherSuites();
            }
        } catch (Throwable th) {
            fz.c(th, "myssl", "gscs");
        }
        return new String[0];
    }
}
