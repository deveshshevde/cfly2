package com.lidroid.xutils.http;

import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;

public final class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public T f21052a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f21053b;

    /* renamed from: c  reason: collision with root package name */
    public final Locale f21054c;

    /* renamed from: d  reason: collision with root package name */
    public final int f21055d;

    /* renamed from: e  reason: collision with root package name */
    public final ProtocolVersion f21056e;

    /* renamed from: f  reason: collision with root package name */
    public final String f21057f;

    /* renamed from: g  reason: collision with root package name */
    public final long f21058g;

    /* renamed from: h  reason: collision with root package name */
    public final Header f21059h;

    /* renamed from: i  reason: collision with root package name */
    public final Header f21060i;

    /* renamed from: j  reason: collision with root package name */
    private final HttpResponse f21061j;

    public c(HttpResponse httpResponse, T t2, boolean z2) {
        this.f21061j = httpResponse;
        this.f21052a = t2;
        this.f21053b = z2;
        if (httpResponse != null) {
            this.f21054c = httpResponse.getLocale();
            StatusLine statusLine = httpResponse.getStatusLine();
            if (statusLine != null) {
                this.f21055d = statusLine.getStatusCode();
                this.f21056e = statusLine.getProtocolVersion();
                this.f21057f = statusLine.getReasonPhrase();
            } else {
                this.f21055d = 0;
                this.f21056e = null;
                this.f21057f = null;
            }
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                this.f21058g = entity.getContentLength();
                this.f21059h = entity.getContentType();
                this.f21060i = entity.getContentEncoding();
                return;
            }
        } else {
            this.f21054c = null;
            this.f21055d = 0;
            this.f21056e = null;
            this.f21057f = null;
        }
        this.f21058g = 0;
        this.f21059h = null;
        this.f21060i = null;
    }
}
