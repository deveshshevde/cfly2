package nd;

import java.net.Proxy;
import okhttp3.t;
import okhttp3.z;

public final class i {
    public static String a(t tVar) {
        String h2 = tVar.h();
        String k2 = tVar.k();
        if (k2 == null) {
            return h2;
        }
        return h2 + '?' + k2;
    }

    public static String a(z zVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(zVar.b());
        sb.append(' ');
        boolean b2 = b(zVar, type);
        t a2 = zVar.a();
        if (b2) {
            sb.append(a2);
        } else {
            sb.append(a(a2));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean b(z zVar, Proxy.Type type) {
        return !zVar.g() && type == Proxy.Type.HTTP;
    }
}
