package com.lidroid.xutils.http.client.multipart;

import ih.e;
import ii.d;
import ij.b;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

public class f implements d, HttpEntity {

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f21105b = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /* renamed from: a  reason: collision with root package name */
    private a f21106a;

    /* renamed from: c  reason: collision with root package name */
    private final b f21107c;

    /* renamed from: d  reason: collision with root package name */
    private Header f21108d;

    /* renamed from: e  reason: collision with root package name */
    private long f21109e;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f21110f;

    /* renamed from: g  reason: collision with root package name */
    private final String f21111g;

    /* renamed from: h  reason: collision with root package name */
    private final Charset f21112h;

    /* renamed from: i  reason: collision with root package name */
    private String f21113i;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f21114a = new a();

        /* renamed from: b  reason: collision with root package name */
        public e f21115b = null;

        /* renamed from: c  reason: collision with root package name */
        public long f21116c = 0;

        /* renamed from: d  reason: collision with root package name */
        public long f21117d = 0;

        public boolean a(boolean z2) {
            e eVar = this.f21115b;
            if (eVar != null) {
                return eVar.a(this.f21116c, this.f21117d, z2);
            }
            return true;
        }
    }

    public f() {
        this(HttpMultipartMode.STRICT, (String) null, (Charset) null);
    }

    public f(HttpMultipartMode httpMultipartMode, String str, Charset charset) {
        this.f21106a = new a();
        this.f21113i = "form-data";
        str = str == null ? a() : str;
        this.f21111g = str;
        httpMultipartMode = httpMultipartMode == null ? HttpMultipartMode.STRICT : httpMultipartMode;
        charset = charset == null ? c.f21100a : charset;
        this.f21112h = charset;
        this.f21107c = new b(this.f21113i, charset, str, httpMultipartMode);
        this.f21108d = new BasicHeader("Content-Type", a(str, charset));
        this.f21110f = true;
    }

    /* access modifiers changed from: protected */
    public String a() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int nextInt = random.nextInt(11) + 30;
        for (int i2 = 0; i2 < nextInt; i2++) {
            char[] cArr = f21105b;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public String a(String str, Charset charset) {
        StringBuilder sb = new StringBuilder();
        sb.append("multipart/" + this.f21113i + "; boundary=");
        sb.append(str);
        return sb.toString();
    }

    public void a(a aVar) {
        this.f21107c.a(aVar);
        this.f21110f = true;
    }

    public void a(e eVar) {
        this.f21106a.f21115b = eVar;
    }

    public void a(String str, b bVar) {
        a(new a(str, bVar));
    }

    public void consumeContent() throws IOException, UnsupportedOperationException {
        if (isStreaming()) {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        }
    }

    public InputStream getContent() throws IOException, UnsupportedOperationException {
        throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
    }

    public Header getContentEncoding() {
        return null;
    }

    public long getContentLength() {
        if (this.f21110f) {
            this.f21109e = this.f21107c.c();
            this.f21110f = false;
        }
        return this.f21109e;
    }

    public Header getContentType() {
        return this.f21108d;
    }

    public boolean isChunked() {
        return !isRepeatable();
    }

    public boolean isRepeatable() {
        for (a b2 : this.f21107c.a()) {
            if (b2.b().e() < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isStreaming() {
        return !isRepeatable();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        this.f21106a.f21116c = getContentLength();
        this.f21107c.a(outputStream, this.f21106a);
    }
}
