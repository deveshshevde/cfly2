package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public class g implements f {

    /* renamed from: a  reason: collision with root package name */
    private final a f9975a;

    /* renamed from: b  reason: collision with root package name */
    private final SSLSocketFactory f9976b;

    public interface a {
        String a(String str);
    }

    public g() {
        this((a) null);
    }

    public g(a aVar) {
        this(aVar, (SSLSocketFactory) null);
    }

    public g(a aVar, SSLSocketFactory sSLSocketFactory) {
        this.f9975a = aVar;
        this.f9976b = sSLSocketFactory;
    }

    private HttpURLConnection a(URL url, Request<?> request) throws IOException {
        SSLSocketFactory sSLSocketFactory;
        HttpURLConnection a2 = a(url);
        int s2 = request.s();
        a2.setConnectTimeout(s2);
        a2.setReadTimeout(s2);
        a2.setUseCaches(false);
        a2.setDoInput(true);
        if ("https".equals(url.getProtocol()) && (sSLSocketFactory = this.f9976b) != null) {
            ((HttpsURLConnection) a2).setSSLSocketFactory(sSLSocketFactory);
        }
        return a2;
    }

    private static HttpEntity a(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (IOException unused) {
            inputStream = httpURLConnection.getErrorStream();
        }
        basicHttpEntity.setContent(inputStream);
        basicHttpEntity.setContentLength((long) httpURLConnection.getContentLength());
        basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
        basicHttpEntity.setContentType(httpURLConnection.getContentType());
        return basicHttpEntity;
    }

    static void a(HttpURLConnection httpURLConnection, Request<?> request) throws IOException, AuthFailureError {
        String str;
        int a2 = request.a();
        if (a2 != -1) {
            if (a2 != 0) {
                if (a2 == 1) {
                    httpURLConnection.setRequestMethod("POST");
                } else if (a2 == 2) {
                    httpURLConnection.setRequestMethod("PUT");
                } else if (a2 == 3) {
                    str = "DELETE";
                } else {
                    throw new IllegalStateException("Unknown method type.");
                }
                b(httpURLConnection, request);
                return;
            }
            str = "GET";
            httpURLConnection.setRequestMethod(str);
            return;
        }
        byte[] l2 = request.l();
        if (l2 != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.addRequestProperty("Content-Type", request.k());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(l2);
            dataOutputStream.close();
        }
    }

    private static void b(HttpURLConnection httpURLConnection, Request<?> request) throws IOException, AuthFailureError {
        byte[] p2 = request.p();
        if (p2 != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", request.o());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(p2);
            dataOutputStream.close();
        }
    }

    /* access modifiers changed from: protected */
    public HttpURLConnection a(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    public HttpResponse a(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError {
        String c2 = request.c();
        HashMap hashMap = new HashMap();
        hashMap.putAll(request.h());
        hashMap.putAll(map);
        a aVar = this.f9975a;
        if (aVar != null) {
            String a2 = aVar.a(c2);
            if (a2 != null) {
                c2 = a2;
            } else {
                throw new IOException("URL blocked by rewriter: " + c2);
            }
        }
        HttpURLConnection a3 = a(new URL(c2), request);
        for (String str : hashMap.keySet()) {
            a3.addRequestProperty(str, (String) hashMap.get(str));
        }
        a(a3, request);
        ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
        if (a3.getResponseCode() != -1) {
            BasicHttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(protocolVersion, a3.getResponseCode(), a3.getResponseMessage()));
            basicHttpResponse.setEntity(a(a3));
            for (Map.Entry entry : a3.getHeaderFields().entrySet()) {
                if (entry.getKey() != null) {
                    basicHttpResponse.addHeader(new BasicHeader((String) entry.getKey(), (String) ((List) entry.getValue()).get(0)));
                }
            }
            return basicHttpResponse;
        }
        throw new IOException("Could not retrieve response code from HttpUrlConnection.");
    }
}
