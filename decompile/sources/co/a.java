package co;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class a {

    /* renamed from: co.a$a  reason: collision with other inner class name */
    private static class C0070a implements X509TrustManager {

        /* renamed from: a  reason: collision with root package name */
        private X509TrustManager f6241a;

        /* renamed from: b  reason: collision with root package name */
        private X509TrustManager f6242b;

        public C0070a(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyStoreException {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            this.f6241a = a.b(instance.getTrustManagers());
            this.f6242b = x509TrustManager;
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            try {
                this.f6241a.checkServerTrusted(x509CertificateArr, str);
            } catch (CertificateException unused) {
                this.f6242b.checkServerTrusted(x509CertificateArr, str);
            }
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public SSLSocketFactory f6243a;

        /* renamed from: b  reason: collision with root package name */
        public X509TrustManager f6244b;
    }

    private static class c implements X509TrustManager {
        private c() {
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    public static b a(InputStream inputStream, String str, InputStream[] inputStreamArr) {
        b bVar = new b();
        try {
            KeyManager[] a2 = a(inputStream, str);
            TrustManager[] a3 = a(inputStreamArr);
            SSLContext instance = SSLContext.getInstance("TLS");
            X509TrustManager aVar = a3 != null ? new C0070a(b(a3)) : new c();
            instance.init(a2, new TrustManager[]{aVar}, (SecureRandom) null);
            bVar.f6243a = instance.getSocketFactory();
            bVar.f6244b = aVar;
            return bVar;
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        } catch (KeyManagementException e3) {
            throw new AssertionError(e3);
        } catch (KeyStoreException e4) {
            throw new AssertionError(e4);
        }
    }

    private static KeyManager[] a(InputStream inputStream, String str) {
        if (!(inputStream == null || str == null)) {
            try {
                KeyStore instance = KeyStore.getInstance("BKS");
                instance.load(inputStream, str.toCharArray());
                KeyManagerFactory instance2 = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                instance2.init(instance, str.toCharArray());
                return instance2.getKeyManagers();
            } catch (IOException | Exception | KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException | CertificateException e2) {
                cp.a.a(e2);
            }
        }
        return null;
    }

    private static TrustManager[] a(InputStream... inputStreamArr) {
        if (inputStreamArr != null && inputStreamArr.length > 0) {
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                KeyStore instance2 = KeyStore.getInstance(KeyStore.getDefaultType());
                instance2.load((KeyStore.LoadStoreParameter) null);
                int length = inputStreamArr.length;
                int i2 = 0;
                int i3 = 0;
                while (i2 < length) {
                    InputStream inputStream = inputStreamArr[i2];
                    int i4 = i3 + 1;
                    instance2.setCertificateEntry(Integer.toString(i3), instance.generateCertificate(inputStream));
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                            cp.a.a((Throwable) e2);
                        }
                    }
                    i2++;
                    i3 = i4;
                }
                TrustManagerFactory instance3 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                instance3.init(instance2);
                return instance3.getTrustManagers();
            } catch (Exception | KeyStoreException | NoSuchAlgorithmException | CertificateException e3) {
                cp.a.a(e3);
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static X509TrustManager b(TrustManager[] trustManagerArr) {
        for (X509TrustManager x509TrustManager : trustManagerArr) {
            if (x509TrustManager instanceof X509TrustManager) {
                return x509TrustManager;
            }
        }
        return null;
    }
}
