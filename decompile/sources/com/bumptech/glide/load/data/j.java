package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import bo.g;
import cc.c;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.d;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

public class j implements d<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    static final b f10176a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final g f10177b;

    /* renamed from: c  reason: collision with root package name */
    private final int f10178c;

    /* renamed from: d  reason: collision with root package name */
    private final b f10179d;

    /* renamed from: e  reason: collision with root package name */
    private HttpURLConnection f10180e;

    /* renamed from: f  reason: collision with root package name */
    private InputStream f10181f;

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f10182g;

    private static class a implements b {
        a() {
        }

        public HttpURLConnection a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    interface b {
        HttpURLConnection a(URL url) throws IOException;
    }

    public j(g gVar, int i2) {
        this(gVar, i2, f10176a);
    }

    j(g gVar, int i2, b bVar) {
        this.f10177b = gVar;
        this.f10178c = i2;
        this.f10179d = bVar;
    }

    private static int a(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e2) {
            if (!Log.isLoggable("HttpUrlFetcher", 3)) {
                return -1;
            }
            Log.d("HttpUrlFetcher", "Failed to get a response code", e2);
            return -1;
        }
    }

    private InputStream a(URL url, int i2, URL url2, Map<String, String> map) throws HttpException {
        if (i2 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new HttpException("In re-direct loop", -1);
                    }
                } catch (URISyntaxException unused) {
                }
            }
            HttpURLConnection a2 = a(url, map);
            this.f10180e = a2;
            try {
                a2.connect();
                this.f10181f = this.f10180e.getInputStream();
                if (this.f10182g) {
                    return null;
                }
                int a3 = a(this.f10180e);
                if (a(a3)) {
                    return b(this.f10180e);
                }
                if (b(a3)) {
                    String headerField = this.f10180e.getHeaderField("Location");
                    if (!TextUtils.isEmpty(headerField)) {
                        try {
                            URL url3 = new URL(url, headerField);
                            b();
                            return a(url3, i2 + 1, url, map);
                        } catch (MalformedURLException e2) {
                            throw new HttpException("Bad redirect url: " + headerField, a3, e2);
                        }
                    } else {
                        throw new HttpException("Received empty or null redirect url", a3);
                    }
                } else if (a3 == -1) {
                    throw new HttpException(a3);
                } else {
                    try {
                        throw new HttpException(this.f10180e.getResponseMessage(), a3);
                    } catch (IOException e3) {
                        throw new HttpException("Failed to get a response message", a3, e3);
                    }
                }
            } catch (IOException e4) {
                throw new HttpException("Failed to connect or obtain data", a(this.f10180e), e4);
            }
        } else {
            throw new HttpException("Too many (> 5) redirects!", -1);
        }
    }

    private HttpURLConnection a(URL url, Map<String, String> map) throws HttpException {
        try {
            HttpURLConnection a2 = this.f10179d.a(url);
            for (Map.Entry next : map.entrySet()) {
                a2.addRequestProperty((String) next.getKey(), (String) next.getValue());
            }
            a2.setConnectTimeout(this.f10178c);
            a2.setReadTimeout(this.f10178c);
            a2.setUseCaches(false);
            a2.setDoInput(true);
            a2.setInstanceFollowRedirects(false);
            return a2;
        } catch (IOException e2) {
            throw new HttpException("URL.openConnection threw", 0, e2);
        }
    }

    private static boolean a(int i2) {
        return i2 / 100 == 2;
    }

    private InputStream b(HttpURLConnection httpURLConnection) throws HttpException {
        InputStream inputStream;
        try {
            if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                inputStream = c.a(httpURLConnection.getInputStream(), (long) httpURLConnection.getContentLength());
            } else {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
                }
                inputStream = httpURLConnection.getInputStream();
            }
            this.f10181f = inputStream;
            return this.f10181f;
        } catch (IOException e2) {
            throw new HttpException("Failed to obtain InputStream", a(httpURLConnection), e2);
        }
    }

    private static boolean b(int i2) {
        return i2 / 100 == 3;
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }

    public void a(Priority priority, d.a<? super InputStream> aVar) {
        StringBuilder sb;
        long a2 = cc.g.a();
        try {
            aVar.a(a(this.f10177b.a(), 0, (URL) null, this.f10177b.b()));
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(cc.g.a(a2));
                Log.v("HttpUrlFetcher", sb.toString());
            }
        } catch (IOException e2) {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Failed to load data for url", e2);
            }
            aVar.a((Exception) e2);
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + cc.g.a(a2));
            }
            throw th;
        }
    }

    public void b() {
        InputStream inputStream = this.f10181f;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f10180e;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f10180e = null;
    }

    public void c() {
        this.f10182g = true;
    }

    public DataSource d() {
        return DataSource.REMOTE;
    }
}
