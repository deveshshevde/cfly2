package com.lidroid.xutils.http.client;

import il.c;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class a extends SSLSocketFactory {

    /* renamed from: b  reason: collision with root package name */
    private static KeyStore f21078b;

    /* renamed from: c  reason: collision with root package name */
    private static a f21079c;

    /* renamed from: a  reason: collision with root package name */
    private SSLContext f21080a = SSLContext.getInstance("TLS");

    static {
        try {
            KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
            f21078b = instance;
            instance.load((InputStream) null, (char[]) null);
        } catch (Throwable th) {
            c.a(th.getMessage(), th);
        }
    }

    private a() throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        super(f21078b);
        AnonymousClass1 r0 = new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };
        this.f21080a.init((KeyManager[]) null, new TrustManager[]{r0}, (SecureRandom) null);
        setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
    }

    public static a a() {
        if (f21079c == null) {
            try {
                f21079c = new a();
            } catch (Throwable th) {
                c.a(th.getMessage(), th);
            }
        }
        return f21079c;
    }

    public Socket createSocket() throws IOException {
        return this.f21080a.getSocketFactory().createSocket();
    }

    public Socket createSocket(Socket socket, String str, int i2, boolean z2) throws IOException {
        return this.f21080a.getSocketFactory().createSocket(socket, str, i2, z2);
    }
}
