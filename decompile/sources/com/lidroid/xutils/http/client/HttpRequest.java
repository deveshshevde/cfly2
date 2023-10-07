package com.lidroid.xutils.http.client;

import com.lidroid.xutils.http.b;
import ih.e;
import ii.d;
import ik.a;
import il.c;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.CloneUtils;

public class HttpRequest extends HttpRequestBase implements HttpEntityEnclosingRequest {

    /* renamed from: a  reason: collision with root package name */
    private HttpEntity f21062a;

    /* renamed from: b  reason: collision with root package name */
    private HttpMethod f21063b;

    /* renamed from: c  reason: collision with root package name */
    private a f21064c;

    /* renamed from: d  reason: collision with root package name */
    private Charset f21065d;

    public enum HttpMethod {
        GET("GET"),
        POST("POST"),
        PUT("PUT"),
        HEAD("HEAD"),
        MOVE("MOVE"),
        COPY("COPY"),
        DELETE("DELETE"),
        OPTIONS("OPTIONS"),
        TRACE("TRACE"),
        CONNECT("CONNECT");
        

        /* renamed from: k  reason: collision with root package name */
        private final String f21077k;

        private HttpMethod(String str) {
            this.f21077k = str;
        }

        public String toString() {
            return this.f21077k;
        }
    }

    public HttpRequest(HttpMethod httpMethod, String str) {
        this.f21063b = httpMethod;
        a(str);
    }

    public HttpRequest a(List<NameValuePair> list) {
        if (list != null) {
            for (NameValuePair next : list) {
                this.f21064c.a(next.getName(), next.getValue());
            }
        }
        return this;
    }

    public void a(b bVar, e eVar) {
        if (bVar != null) {
            if (this.f21065d == null) {
                this.f21065d = Charset.forName(bVar.b());
            }
            List<b.a> e2 = bVar.e();
            if (e2 != null) {
                for (b.a next : e2) {
                    boolean z2 = next.f21050a;
                    Header header = next.f21051b;
                    if (z2) {
                        setHeader(header);
                    } else {
                        addHeader(header);
                    }
                }
            }
            a(bVar.d());
            d c2 = bVar.c();
            if (c2 != null) {
                if (c2 instanceof d) {
                    c2.a(eVar);
                }
                setEntity(c2);
            }
        }
    }

    public void a(String str) {
        this.f21064c = new a(str);
    }

    public Object clone() throws CloneNotSupportedException {
        HttpRequest httpRequest = (HttpRequest) HttpRequest.super.clone();
        HttpEntity httpEntity = this.f21062a;
        if (httpEntity != null) {
            httpRequest.f21062a = (HttpEntity) CloneUtils.clone(httpEntity);
        }
        return httpRequest;
    }

    public boolean expectContinue() {
        Header firstHeader = getFirstHeader("Expect");
        return firstHeader != null && "100-Continue".equalsIgnoreCase(firstHeader.getValue());
    }

    public HttpEntity getEntity() {
        return this.f21062a;
    }

    public String getMethod() {
        return this.f21063b.toString();
    }

    public URI getURI() {
        try {
            if (this.f21065d == null) {
                this.f21065d = il.d.a((HttpRequestBase) this);
            }
            if (this.f21065d == null) {
                this.f21065d = Charset.forName("UTF-8");
            }
            return this.f21064c.a(this.f21065d);
        } catch (URISyntaxException e2) {
            c.a(e2.getMessage(), e2);
            return null;
        }
    }

    public void setEntity(HttpEntity httpEntity) {
        this.f21062a = httpEntity;
    }

    public void setURI(URI uri) {
        this.f21064c = new a(uri);
    }
}
