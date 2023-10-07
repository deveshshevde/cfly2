package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.LinkedHashMap;
import java.util.Map;

public final class av {

    /* renamed from: a  reason: collision with root package name */
    private static av f7871a;

    /* renamed from: b  reason: collision with root package name */
    private id f7872b;

    /* renamed from: c  reason: collision with root package name */
    private LinkedHashMap<String, ie> f7873c = new LinkedHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private boolean f7874d = true;

    private av() {
        try {
            this.f7872b = id.b();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static av a() {
        return c();
    }

    private static synchronized av c() {
        av avVar;
        synchronized (av.class) {
            try {
                av avVar2 = f7871a;
                if (avVar2 == null) {
                    f7871a = new av();
                } else if (avVar2.f7872b == null) {
                    avVar2.f7872b = id.b();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            avVar = f7871a;
        }
        return avVar;
    }

    private void d() {
        synchronized (this.f7873c) {
            if (this.f7873c.size() > 0) {
                for (Map.Entry next : this.f7873c.entrySet()) {
                    next.getKey();
                    ((ar) next.getValue()).a();
                }
                this.f7873c.clear();
            }
        }
    }

    private static void e() {
        f7871a = null;
    }

    public final void a(au auVar) {
        synchronized (this.f7873c) {
            ar arVar = (ar) this.f7873c.get(auVar.b());
            if (arVar != null) {
                arVar.a();
                this.f7873c.remove(auVar.b());
            }
        }
    }

    public final void a(au auVar, Context context) throws eu {
        if (!this.f7873c.containsKey(auVar.b())) {
            ar arVar = new ar((bl) auVar, context.getApplicationContext(), (byte) 0);
            synchronized (this.f7873c) {
                this.f7873c.put(auVar.b(), arVar);
            }
        }
        this.f7872b.a(this.f7873c.get(auVar.b()));
    }

    public final void b() {
        d();
        this.f7872b.c();
        this.f7872b = null;
        e();
    }

    public final void b(au auVar) {
        ar arVar = (ar) this.f7873c.get(auVar.b());
        if (arVar != null) {
            synchronized (this.f7873c) {
                arVar.b();
                this.f7873c.remove(auVar.b());
            }
        }
    }
}
