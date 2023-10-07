package com.lidroid.xutils.http;

import com.lidroid.xutils.http.client.multipart.HttpMultipartMode;
import com.lidroid.xutils.http.client.multipart.f;
import com.lidroid.xutils.task.Priority;
import ij.d;
import il.c;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f21043a;

    /* renamed from: b  reason: collision with root package name */
    private List<a> f21044b;

    /* renamed from: c  reason: collision with root package name */
    private List<NameValuePair> f21045c;

    /* renamed from: d  reason: collision with root package name */
    private HttpEntity f21046d;

    /* renamed from: e  reason: collision with root package name */
    private List<NameValuePair> f21047e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap<String, ij.b> f21048f;

    /* renamed from: g  reason: collision with root package name */
    private Priority f21049g;

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f21050a;

        /* renamed from: b  reason: collision with root package name */
        public final Header f21051b;
    }

    public Priority a() {
        return this.f21049g;
    }

    public String b() {
        return this.f21043a;
    }

    public HttpEntity c() {
        HttpEntity httpEntity = this.f21046d;
        if (httpEntity != null) {
            return httpEntity;
        }
        HashMap<String, ij.b> hashMap = this.f21048f;
        if (hashMap == null || hashMap.isEmpty()) {
            List<NameValuePair> list = this.f21047e;
            if (list == null || list.isEmpty()) {
                return null;
            }
            return new ii.a(this.f21047e, this.f21043a);
        }
        HttpEntity fVar = new f(HttpMultipartMode.STRICT, (String) null, Charset.forName(this.f21043a));
        List<NameValuePair> list2 = this.f21047e;
        if (list2 != null && !list2.isEmpty()) {
            for (NameValuePair next : this.f21047e) {
                try {
                    fVar.a(next.getName(), (ij.b) new d(next.getValue()));
                } catch (UnsupportedEncodingException e2) {
                    c.a(e2.getMessage(), e2);
                }
            }
        }
        for (Map.Entry next2 : this.f21048f.entrySet()) {
            fVar.a((String) next2.getKey(), (ij.b) next2.getValue());
        }
        return fVar;
    }

    public List<NameValuePair> d() {
        return this.f21045c;
    }

    public List<a> e() {
        return this.f21044b;
    }
}
