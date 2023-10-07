package ig;

import android.content.Context;
import android.text.TextUtils;
import com.lidroid.xutils.http.HttpHandler;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.http.client.b;
import com.lidroid.xutils.task.c;
import il.d;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executor;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final com.lidroid.xutils.http.a f13546a = new com.lidroid.xutils.http.a();

    /* renamed from: g  reason: collision with root package name */
    private static final c f13547g = new c(3);

    /* renamed from: b  reason: collision with root package name */
    private final DefaultHttpClient f13548b;

    /* renamed from: c  reason: collision with root package name */
    private final HttpContext f13549c;

    /* renamed from: d  reason: collision with root package name */
    private ih.c f13550d;

    /* renamed from: e  reason: collision with root package name */
    private String f13551e;

    /* renamed from: f  reason: collision with root package name */
    private long f13552f;

    public a() {
        this(15000, (String) null);
    }

    public a(int i2, String str) {
        this.f13549c = new BasicHttpContext();
        this.f13551e = "UTF-8";
        this.f13552f = com.lidroid.xutils.http.a.a();
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basicHttpParams, (long) i2);
        HttpConnectionParams.setSoTimeout(basicHttpParams, i2);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, i2);
        HttpProtocolParams.setUserAgent(basicHttpParams, TextUtils.isEmpty(str) ? d.a((Context) null) : str);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(10));
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 10);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", com.lidroid.xutils.http.client.a.a(), 443));
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        this.f13548b = defaultHttpClient;
        defaultHttpClient.setHttpRequestRetryHandler(new b(3));
        defaultHttpClient.addRequestInterceptor(new HttpRequestInterceptor() {
            public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
                if (!httpRequest.containsHeader("Accept-Encoding")) {
                    httpRequest.addHeader("Accept-Encoding", "gzip");
                }
            }
        });
        defaultHttpClient.addResponseInterceptor(new HttpResponseInterceptor() {
            public void process(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
                Header contentEncoding;
                HttpEntity entity = httpResponse.getEntity();
                if (entity != null && (contentEncoding = entity.getContentEncoding()) != null) {
                    for (HeaderElement name : contentEncoding.getElements()) {
                        if (name.getName().equalsIgnoreCase("gzip")) {
                            httpResponse.setEntity(new ii.c(httpResponse.getEntity()));
                            return;
                        }
                    }
                }
            }
        });
    }

    public HttpHandler<File> a(HttpRequest.HttpMethod httpMethod, String str, String str2, com.lidroid.xutils.http.b bVar, boolean z2, boolean z3, ih.d<File> dVar) {
        if (str == null) {
            throw new IllegalArgumentException("url may not be null");
        } else if (str2 != null) {
            com.lidroid.xutils.http.client.HttpRequest httpRequest = new com.lidroid.xutils.http.client.HttpRequest(httpMethod, str);
            HttpHandler<File> httpHandler = new HttpHandler<>(this.f13548b, this.f13549c, this.f13551e, dVar);
            httpHandler.a(this.f13552f);
            httpHandler.a(this.f13550d);
            if (bVar != null) {
                httpRequest.a(bVar, httpHandler);
                httpHandler.a(bVar.a());
            }
            httpHandler.a((Executor) f13547g, (Params[]) new Object[]{httpRequest, str2, Boolean.valueOf(z2), Boolean.valueOf(z3)});
            return httpHandler;
        } else {
            throw new IllegalArgumentException("target may not be null");
        }
    }

    public HttpHandler<File> a(String str, String str2, boolean z2, ih.d<File> dVar) {
        return a(HttpRequest.HttpMethod.GET, str, str2, (com.lidroid.xutils.http.b) null, z2, false, dVar);
    }
}
