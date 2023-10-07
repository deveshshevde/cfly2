package com.xeagle.android.vjoystick.utils.transformation;

import android.util.Log;
import bo.g;
import cc.c;
import cc.k;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.d;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.e;
import okhttp3.f;
import okhttp3.z;

class a implements d<InputStream>, f {

    /* renamed from: a  reason: collision with root package name */
    private final e.a f25384a;

    /* renamed from: b  reason: collision with root package name */
    private final g f25385b;

    /* renamed from: c  reason: collision with root package name */
    private InputStream f25386c;

    /* renamed from: d  reason: collision with root package name */
    private ac f25387d;

    /* renamed from: e  reason: collision with root package name */
    private d.a<? super InputStream> f25388e;

    /* renamed from: f  reason: collision with root package name */
    private volatile e f25389f;

    public a(e.a aVar, g gVar) {
        this.f25384a = aVar;
        this.f25385b = gVar;
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }

    public void a(Priority priority, d.a<? super InputStream> aVar) {
        z.a a2 = new z.a().a(this.f25385b.c());
        for (Map.Entry next : this.f25385b.b().entrySet()) {
            a2.b((String) next.getKey(), (String) next.getValue());
        }
        z b2 = a2.b();
        this.f25388e = aVar;
        this.f25389f = this.f25384a.a(b2);
        this.f25389f.a(this);
    }

    public void b() {
        try {
            InputStream inputStream = this.f25386c;
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException unused) {
        }
        ac acVar = this.f25387d;
        if (acVar != null) {
            acVar.close();
        }
        this.f25388e = null;
    }

    public void c() {
        e eVar = this.f25389f;
        if (eVar != null) {
            eVar.c();
        }
    }

    public DataSource d() {
        return DataSource.REMOTE;
    }

    public void onFailure(e eVar, IOException iOException) {
        if (Log.isLoggable("OkHttpFetcher", 3)) {
            Log.d("OkHttpFetcher", "OkHttp failed to obtain result", iOException);
        }
        this.f25388e.a((Exception) iOException);
    }

    public void onResponse(e eVar, ab abVar) {
        this.f25387d = abVar.g();
        if (abVar.c()) {
            InputStream a2 = c.a(this.f25387d.byteStream(), ((ac) k.a(this.f25387d)).contentLength());
            this.f25386c = a2;
            this.f25388e.a(a2);
            return;
        }
        this.f25388e.a((Exception) new HttpException(abVar.d(), abVar.b()));
    }
}
