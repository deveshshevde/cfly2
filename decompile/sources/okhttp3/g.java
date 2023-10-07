package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import ni.c;
import okio.ByteString;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f31895a = new a().a();

    /* renamed from: b  reason: collision with root package name */
    private final Set<b> f31896b;

    /* renamed from: c  reason: collision with root package name */
    private final c f31897c;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<b> f31898a = new ArrayList();

        public g a() {
            return new g(new LinkedHashSet(this.f31898a), (c) null);
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        final String f31899a;

        /* renamed from: b  reason: collision with root package name */
        final String f31900b;

        /* renamed from: c  reason: collision with root package name */
        final String f31901c;

        /* renamed from: d  reason: collision with root package name */
        final ByteString f31902d;

        /* access modifiers changed from: package-private */
        public boolean a(String str) {
            if (!this.f31899a.startsWith("*.")) {
                return str.equals(this.f31900b);
            }
            int indexOf = str.indexOf(46);
            if ((str.length() - indexOf) - 1 == this.f31900b.length()) {
                String str2 = this.f31900b;
                if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                return this.f31899a.equals(bVar.f31899a) && this.f31901c.equals(bVar.f31901c) && this.f31902d.equals(bVar.f31902d);
            }
        }

        public int hashCode() {
            return ((((527 + this.f31899a.hashCode()) * 31) + this.f31901c.hashCode()) * 31) + this.f31902d.hashCode();
        }

        public String toString() {
            return this.f31901c + this.f31902d.b();
        }
    }

    g(Set<b> set, c cVar) {
        this.f31896b = set;
        this.f31897c = cVar;
    }

    public static String a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + b((X509Certificate) certificate).b();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static ByteString a(X509Certificate x509Certificate) {
        return ByteString.a(x509Certificate.getPublicKey().getEncoded()).c();
    }

    static ByteString b(X509Certificate x509Certificate) {
        return ByteString.a(x509Certificate.getPublicKey().getEncoded()).d();
    }

    /* access modifiers changed from: package-private */
    public List<b> a(String str) {
        List<b> emptyList = Collections.emptyList();
        for (b next : this.f31896b) {
            if (next.a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(next);
            }
        }
        return emptyList;
    }

    /* access modifiers changed from: package-private */
    public g a(c cVar) {
        return Objects.equals(this.f31897c, cVar) ? this : new g(this.f31896b, cVar);
    }

    public void a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<b> a2 = a(str);
        if (!a2.isEmpty()) {
            c cVar = this.f31897c;
            if (cVar != null) {
                list = cVar.a(list, str);
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i2);
                int size2 = a2.size();
                ByteString byteString = null;
                ByteString byteString2 = null;
                for (int i3 = 0; i3 < size2; i3++) {
                    b bVar = a2.get(i3);
                    if (bVar.f31901c.equals("sha256/")) {
                        if (byteString == null) {
                            byteString = b(x509Certificate);
                        }
                        if (bVar.f31902d.equals(byteString)) {
                            return;
                        }
                    } else if (bVar.f31901c.equals("sha1/")) {
                        if (byteString2 == null) {
                            byteString2 = a(x509Certificate);
                        }
                        if (bVar.f31902d.equals(byteString2)) {
                            return;
                        }
                    } else {
                        throw new AssertionError("unsupported hashAlgorithm: " + bVar.f31901c);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Certificate pinning failure!");
            sb.append("\n  Peer certificate chain:");
            int size3 = list.size();
            for (int i4 = 0; i4 < size3; i4++) {
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i4);
                sb.append("\n    ");
                sb.append(a((Certificate) x509Certificate2));
                sb.append(": ");
                sb.append(x509Certificate2.getSubjectDN().getName());
            }
            sb.append("\n  Pinned certificates for ");
            sb.append(str);
            sb.append(":");
            int size4 = a2.size();
            for (int i5 = 0; i5 < size4; i5++) {
                sb.append("\n    ");
                sb.append(a2.get(i5));
            }
            throw new SSLPeerUnverifiedException(sb.toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return Objects.equals(this.f31897c, gVar.f31897c) && this.f31896b.equals(gVar.f31896b);
        }
    }

    public int hashCode() {
        return (Objects.hashCode(this.f31897c) * 31) + this.f31896b.hashCode();
    }
}
