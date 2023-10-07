package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import java.io.IOException;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class d implements f {

    /* renamed from: a  reason: collision with root package name */
    protected final HttpClient f9974a;

    public d(HttpClient httpClient) {
        this.f9974a = httpClient;
    }

    private static void a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, Request<?> request) throws AuthFailureError {
        byte[] p2 = request.p();
        if (p2 != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(p2));
        }
    }

    private static void a(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String next : map.keySet()) {
            httpUriRequest.setHeader(next, map.get(next));
        }
    }

    static HttpUriRequest b(Request<?> request, Map<String, String> map) throws AuthFailureError {
        int a2 = request.a();
        if (a2 == -1) {
            byte[] l2 = request.l();
            if (l2 == null) {
                return new HttpGet(request.c());
            }
            HttpPost httpPost = new HttpPost(request.c());
            httpPost.addHeader("Content-Type", request.k());
            httpPost.setEntity(new ByteArrayEntity(l2));
            return httpPost;
        } else if (a2 == 0) {
            return new HttpGet(request.c());
        } else {
            if (a2 == 1) {
                HttpPost httpPost2 = new HttpPost(request.c());
                httpPost2.addHeader("Content-Type", request.o());
                a((HttpEntityEnclosingRequestBase) httpPost2, request);
                return httpPost2;
            } else if (a2 == 2) {
                HttpPut httpPut = new HttpPut(request.c());
                httpPut.addHeader("Content-Type", request.o());
                a((HttpEntityEnclosingRequestBase) httpPut, request);
                return httpPut;
            } else if (a2 == 3) {
                return new HttpDelete(request.c());
            } else {
                throw new IllegalStateException("Unknown request method.");
            }
        }
    }

    public HttpResponse a(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError {
        HttpUriRequest b2 = b(request, map);
        a(b2, map);
        a(b2, request.h());
        a(b2);
        HttpParams params = b2.getParams();
        int s2 = request.s();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, s2);
        return this.f9974a.execute(b2);
    }

    /* access modifiers changed from: protected */
    public void a(HttpUriRequest httpUriRequest) throws IOException {
    }
}
