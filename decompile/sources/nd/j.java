package nd;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import nb.c;
import okhttp3.aa;
import okhttp3.ab;
import okhttp3.ad;
import okhttp3.internal.connection.i;
import okhttp3.t;
import okhttp3.u;
import okhttp3.x;
import okhttp3.z;

public final class j implements u {

    /* renamed from: a  reason: collision with root package name */
    private final x f31391a;

    public j(x xVar) {
        this.f31391a = xVar;
    }

    private int a(ab abVar, int i2) {
        String a2 = abVar.a("Retry-After");
        return a2 == null ? i2 : a2.matches("\\d+") ? Integer.valueOf(a2).intValue() : SubsamplingScaleImageView.TILE_SIZE_AUTO;
    }

    private z a(ab abVar, ad adVar) throws IOException {
        String a2;
        t c2;
        if (abVar != null) {
            int b2 = abVar.b();
            String b3 = abVar.a().b();
            aa aaVar = null;
            if (b2 == 307 || b2 == 308) {
                if (!b3.equals("GET") && !b3.equals("HEAD")) {
                    return null;
                }
            } else if (b2 == 401) {
                return this.f31391a.o().authenticate(adVar, abVar);
            } else {
                if (b2 != 503) {
                    if (b2 == 407) {
                        if ((adVar != null ? adVar.b() : this.f31391a.f()).type() == Proxy.Type.HTTP) {
                            return this.f31391a.p().authenticate(adVar, abVar);
                        }
                        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    } else if (b2 != 408) {
                        switch (b2) {
                            case 300:
                            case 301:
                            case 302:
                            case 303:
                                break;
                            default:
                                return null;
                        }
                    } else if (!this.f31391a.t()) {
                        return null;
                    } else {
                        aa d2 = abVar.a().d();
                        if (d2 != null && d2.isOneShot()) {
                            return null;
                        }
                        if ((abVar.i() == null || abVar.i().b() != 408) && a(abVar, 0) <= 0) {
                            return abVar.a();
                        }
                        return null;
                    }
                } else if ((abVar.i() == null || abVar.i().b() != 503) && a(abVar, (int) SubsamplingScaleImageView.TILE_SIZE_AUTO) == 0) {
                    return abVar.a();
                } else {
                    return null;
                }
            }
            if (!this.f31391a.s() || (a2 = abVar.a("Location")) == null || (c2 = abVar.a().a().c(a2)) == null) {
                return null;
            }
            if (!c2.b().equals(abVar.a().a().b()) && !this.f31391a.r()) {
                return null;
            }
            z.a e2 = abVar.a().e();
            if (f.c(b3)) {
                boolean d3 = f.d(b3);
                if (f.e(b3)) {
                    e2.a("GET", (aa) null);
                } else {
                    if (d3) {
                        aaVar = abVar.a().d();
                    }
                    e2.a(b3, aaVar);
                }
                if (!d3) {
                    e2.b("Transfer-Encoding");
                    e2.b("Content-Length");
                    e2.b("Content-Type");
                }
            }
            if (!c.a(abVar.a().a(), c2)) {
                e2.b("Authorization");
            }
            return e2.a(c2).b();
        }
        throw new IllegalStateException();
    }

    private boolean a(IOException iOException, i iVar, boolean z2, z zVar) {
        if (!this.f31391a.t()) {
            return false;
        }
        return (!z2 || !a(iOException, zVar)) && a(iOException, z2) && iVar.g();
    }

    private boolean a(IOException iOException, z zVar) {
        aa d2 = zVar.d();
        return (d2 != null && d2.isOneShot()) || (iOException instanceof FileNotFoundException);
    }

    private boolean a(IOException iOException, boolean z2) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z2 : (!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b3, code lost:
        r1.f();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.ab intercept(okhttp3.u.a r9) throws java.io.IOException {
        /*
            r8 = this;
            okhttp3.z r0 = r9.a()
            nd.g r9 = (nd.g) r9
            okhttp3.internal.connection.i r1 = r9.e()
            r2 = 0
            r3 = 0
            r4 = r3
            r5 = 0
        L_0x000e:
            r1.a((okhttp3.z) r0)
            boolean r6 = r1.j()
            if (r6 != 0) goto L_0x00c1
            okhttp3.ab r0 = r9.a(r0, r1, r3)     // Catch:{ RouteException -> 0x00a8, IOException -> 0x0098 }
            if (r4 == 0) goto L_0x0035
            okhttp3.ab$a r0 = r0.h()
            okhttp3.ab$a r4 = r4.h()
            okhttp3.ab$a r4 = r4.a((okhttp3.ac) r3)
            okhttp3.ab r4 = r4.a()
            okhttp3.ab$a r0 = r0.c(r4)
            okhttp3.ab r0 = r0.a()
        L_0x0035:
            r4 = r0
            nb.a r0 = nb.a.f31311a
            okhttp3.internal.connection.c r0 = r0.a((okhttp3.ab) r4)
            if (r0 == 0) goto L_0x0047
            okhttp3.internal.connection.e r6 = r0.a()
            okhttp3.ad r6 = r6.b()
            goto L_0x0048
        L_0x0047:
            r6 = r3
        L_0x0048:
            okhttp3.z r6 = r8.a((okhttp3.ab) r4, (okhttp3.ad) r6)
            if (r6 != 0) goto L_0x005a
            if (r0 == 0) goto L_0x0059
            boolean r9 = r0.b()
            if (r9 == 0) goto L_0x0059
            r1.c()
        L_0x0059:
            return r4
        L_0x005a:
            okhttp3.aa r7 = r6.d()
            if (r7 == 0) goto L_0x0067
            boolean r7 = r7.isOneShot()
            if (r7 == 0) goto L_0x0067
            return r4
        L_0x0067:
            okhttp3.ac r7 = r4.g()
            nb.c.a((java.io.Closeable) r7)
            boolean r7 = r1.h()
            if (r7 == 0) goto L_0x0077
            r0.h()
        L_0x0077:
            int r5 = r5 + 1
            r0 = 20
            if (r5 > r0) goto L_0x007f
            r0 = r6
            goto L_0x000e
        L_0x007f:
            java.net.ProtocolException r9 = new java.net.ProtocolException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Too many follow-up requests: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            r9.<init>(r0)
            throw r9
        L_0x0096:
            r9 = move-exception
            goto L_0x00bd
        L_0x0098:
            r6 = move-exception
            boolean r7 = r6 instanceof okhttp3.internal.http2.ConnectionShutdownException     // Catch:{ all -> 0x0096 }
            if (r7 != 0) goto L_0x009f
            r7 = 1
            goto L_0x00a0
        L_0x009f:
            r7 = 0
        L_0x00a0:
            boolean r7 = r8.a(r6, r1, r7, r0)     // Catch:{ all -> 0x0096 }
            if (r7 == 0) goto L_0x00a7
            goto L_0x00b3
        L_0x00a7:
            throw r6     // Catch:{ all -> 0x0096 }
        L_0x00a8:
            r6 = move-exception
            java.io.IOException r7 = r6.b()     // Catch:{ all -> 0x0096 }
            boolean r7 = r8.a(r7, r1, r2, r0)     // Catch:{ all -> 0x0096 }
            if (r7 == 0) goto L_0x00b8
        L_0x00b3:
            r1.f()
            goto L_0x000e
        L_0x00b8:
            java.io.IOException r9 = r6.a()     // Catch:{ all -> 0x0096 }
            throw r9     // Catch:{ all -> 0x0096 }
        L_0x00bd:
            r1.f()
            throw r9
        L_0x00c1:
            java.io.IOException r9 = new java.io.IOException
            java.lang.String r0 = "Canceled"
            r9.<init>(r0)
            goto L_0x00ca
        L_0x00c9:
            throw r9
        L_0x00ca:
            goto L_0x00c9
        */
        throw new UnsupportedOperationException("Method not decompiled: nd.j.intercept(okhttp3.u$a):okhttp3.ab");
    }
}
