package com.xeagle.android.vjoystick.utils.transformation;

import android.content.Context;
import android.os.Environment;
import bm.a;
import bo.g;
import bx.a;
import co.a;
import com.bumptech.glide.Registry;
import com.bumptech.glide.c;
import com.bumptech.glide.d;
import com.xeagle.android.vjoystick.utils.transformation.b;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import okhttp3.x;

public class OkHttpAppGlideModule extends a {

    /* renamed from: a  reason: collision with root package name */
    private String f25382a = Environment.getExternalStorageDirectory().getPath();

    /* renamed from: b  reason: collision with root package name */
    private String f25383b = null;

    private String a() {
        return Environment.getExternalStorageState().equals("mounted") ? this.f25382a : this.f25383b;
    }

    public void a(Context context, c cVar, Registry registry) {
        x a2 = g.a();
        a.b a3 = co.a.a((InputStream) null, (String) null, (InputStream[]) null);
        a2.A().b(10000, TimeUnit.SECONDS).a(10000, TimeUnit.SECONDS).c(10000, TimeUnit.SECONDS).a(a3.f6243a, a3.f6244b);
        registry.b(g.class, InputStream.class, new b.a(a2));
    }

    public void a(Context context, d dVar) {
        this.f25383b = context.getCacheDir().getPath();
        dVar.a((a.C0051a) new bm.d(a() + "/GlideDisk", (long) 1048576000));
    }
}
