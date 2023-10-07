package com.xeagle.android.xrichtext;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    protected final Context f26231a;

    /* renamed from: b  reason: collision with root package name */
    protected final int f26232b;

    /* renamed from: c  reason: collision with root package name */
    protected final int f26233c;

    public a(Context context) {
        this(context, 5000, 20000);
    }

    public a(Context context, int i2, int i3) {
        this.f26231a = context.getApplicationContext();
        this.f26232b = i2;
        this.f26233c = i3;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void a(InputStream inputStream) {
        do {
            try {
            } catch (IOException unused) {
            } catch (Throwable th) {
                a((Closeable) inputStream);
                throw th;
            }
        } while (inputStream.read(new byte[32768], 0, 32768) != -1);
        a((Closeable) inputStream);
    }

    public Bitmap a(String str) throws IOException {
        HttpURLConnection b2 = b(str);
        try {
            InputStream inputStream = b2.getInputStream();
            if (a(b2)) {
                return BitmapFactory.decodeStream(new BufferedInputStream(inputStream, 32768));
            }
            a((Closeable) inputStream);
            throw new IOException("Image request failed with response code " + b2.getResponseCode());
        } catch (IOException e2) {
            a(b2.getErrorStream());
            throw e2;
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(HttpURLConnection httpURLConnection) throws IOException {
        return httpURLConnection.getResponseCode() == 200;
    }

    /* access modifiers changed from: protected */
    public HttpURLConnection b(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Uri.encode(str, "@#&=*+-_.,:!?()/~'%")).openConnection();
        httpURLConnection.setConnectTimeout(this.f26232b);
        httpURLConnection.setReadTimeout(this.f26233c);
        return httpURLConnection;
    }
}
