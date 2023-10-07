package okhttp3;

import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import nb.c;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    private final TlsVersion f32295a;

    /* renamed from: b  reason: collision with root package name */
    private final h f32296b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Certificate> f32297c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Certificate> f32298d;

    private r(TlsVersion tlsVersion, h hVar, List<Certificate> list, List<Certificate> list2) {
        this.f32295a = tlsVersion;
        this.f32296b = hVar;
        this.f32297c = list;
        this.f32298d = list2;
    }

    private List<String> a(List<Certificate> list) {
        ArrayList arrayList = new ArrayList();
        for (Certificate next : list) {
            arrayList.add(next instanceof X509Certificate ? String.valueOf(((X509Certificate) next).getSubjectDN()) : next.getType());
        }
        return arrayList;
    }

    public static r a(SSLSession sSLSession) throws IOException {
        Certificate[] certificateArr;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        } else if (!"SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            h a2 = h.a(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null");
            } else if (!"NONE".equals(protocol)) {
                TlsVersion a3 = TlsVersion.a(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused) {
                    certificateArr = null;
                }
                List a4 = certificateArr != null ? c.a((T[]) certificateArr) : Collections.emptyList();
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                return new r(a3, a2, a4, localCertificates != null ? c.a((T[]) localCertificates) : Collections.emptyList());
            } else {
                throw new IOException("tlsVersion == NONE");
            }
        } else {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
    }

    public h a() {
        return this.f32296b;
    }

    public List<Certificate> b() {
        return this.f32297c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f32295a.equals(rVar.f32295a) && this.f32296b.equals(rVar.f32296b) && this.f32297c.equals(rVar.f32297c) && this.f32298d.equals(rVar.f32298d);
    }

    public int hashCode() {
        return ((((((527 + this.f32295a.hashCode()) * 31) + this.f32296b.hashCode()) * 31) + this.f32297c.hashCode()) * 31) + this.f32298d.hashCode();
    }

    public String toString() {
        return "Handshake{tlsVersion=" + this.f32295a + " cipherSuite=" + this.f32296b + " peerCertificates=" + a(this.f32297c) + " localCertificates=" + a(this.f32298d) + '}';
    }
}
