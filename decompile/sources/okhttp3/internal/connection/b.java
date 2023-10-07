package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import nb.a;
import okhttp3.k;

final class b {

    /* renamed from: a  reason: collision with root package name */
    private final List<k> f31976a;

    /* renamed from: b  reason: collision with root package name */
    private int f31977b = 0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f31978c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f31979d;

    b(List<k> list) {
        this.f31976a = list;
    }

    private boolean b(SSLSocket sSLSocket) {
        for (int i2 = this.f31977b; i2 < this.f31976a.size(); i2++) {
            if (this.f31976a.get(i2).a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public k a(SSLSocket sSLSocket) throws IOException {
        k kVar;
        int i2 = this.f31977b;
        int size = this.f31976a.size();
        while (true) {
            if (i2 >= size) {
                kVar = null;
                break;
            }
            kVar = this.f31976a.get(i2);
            i2++;
            if (kVar.a(sSLSocket)) {
                this.f31977b = i2;
                break;
            }
        }
        if (kVar != null) {
            this.f31978c = b(sSLSocket);
            a.f31311a.a(kVar, sSLSocket, this.f31979d);
            return kVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f31979d + ", modes=" + this.f31976a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    /* access modifiers changed from: package-private */
    public boolean a(IOException iOException) {
        this.f31979d = true;
        if (!this.f31978c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        if ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) {
            return iOException instanceof SSLException;
        }
        return false;
    }
}
