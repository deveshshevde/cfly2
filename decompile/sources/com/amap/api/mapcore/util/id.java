package com.amap.api.mapcore.util;

import com.amap.api.mapcore.util.ic;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class id extends Cif {

    /* renamed from: c  reason: collision with root package name */
    private static id f9221c = new id(new ic.a().a("amap-global-threadPool").b());

    private id(ic icVar) {
        try {
            this.f9223a = new ThreadPoolExecutor(icVar.a(), icVar.b(), (long) icVar.d(), TimeUnit.SECONDS, icVar.c(), icVar);
            this.f9223a.allowCoreThreadTimeOut(true);
        } catch (Throwable th) {
            fz.c(th, "TPool", "ThreadPool");
            th.printStackTrace();
        }
    }

    public static id a() {
        return f9221c;
    }

    public static id a(ic icVar) {
        return new id(icVar);
    }

    @Deprecated
    public static synchronized id b() {
        id idVar;
        synchronized (id.class) {
            if (f9221c == null) {
                f9221c = new id(new ic.a().b());
            }
            idVar = f9221c;
        }
        return idVar;
    }
}
