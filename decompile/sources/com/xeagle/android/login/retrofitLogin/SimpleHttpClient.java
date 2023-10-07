package com.xeagle.android.login.retrofitLogin;

import android.util.Log;
import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.ab;
import okhttp3.e;
import okhttp3.f;
import okhttp3.x;
import okhttp3.z;

public class SimpleHttpClient {
    private x mOkHttpClient;

    private static final class InnerClass {
        public static final SimpleHttpClient sHttpUtil = new SimpleHttpClient();

        private InnerClass() {
        }
    }

    public interface RequestCallBack {
        void onFail(IOException iOException);

        void onSuccess(ab abVar);
    }

    private SimpleHttpClient() {
        try {
            this.mOkHttpClient = new x.a().a(getSSLSocketFactory()).a((HostnameVerifier) new HostnameVerifier() {
                public boolean verify(String str, SSLSession sSLSession) {
                    return true;
                }
            }).c(10, TimeUnit.SECONDS).a(10, TimeUnit.SECONDS).b(10, TimeUnit.SECONDS).a();
        } catch (Exception e2) {
            Log.i("ssl", "onSuccess: ===SimpleHttpClient:===errpr=== " + e2.getMessage());
            e2.printStackTrace();
        }
    }

    public static SimpleHttpClient getInstance() {
        return InnerClass.sHttpUtil;
    }

    public static x getOkHttpClientInstance() {
        try {
            return new x.a().a(getSSLSocketFactory()).b(10, TimeUnit.SECONDS).a(10, TimeUnit.SECONDS).a();
        } catch (Exception e2) {
            Log.e("OkHttpClientError", e2.getMessage());
            return null;
        }
    }

    public static SSLSocketFactory getSSLSocketFactory() throws Exception {
        TrustManager[] trustManagerArr = {new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }};
        SSLContext instance = SSLContext.getInstance("TLS");
        instance.init((KeyManager[]) null, trustManagerArr, new SecureRandom());
        return instance.getSocketFactory();
    }

    public x getOkHttpClient() {
        return this.mOkHttpClient;
    }

    public void getRequest(String str, final RequestCallBack requestCallBack) {
        z.a aVar = new z.a();
        aVar.a(str);
        aVar.a();
        this.mOkHttpClient.a(aVar.b()).a(new f() {
            public void onFailure(e eVar, IOException iOException) {
                requestCallBack.onFail(iOException);
            }

            public void onResponse(e eVar, ab abVar) {
                requestCallBack.onSuccess(abVar);
            }
        });
    }
}
