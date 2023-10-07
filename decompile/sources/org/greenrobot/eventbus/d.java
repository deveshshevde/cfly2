package org.greenrobot.eventbus;

import android.os.Looper;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import nr.a;
import ns.b;
import org.greenrobot.eventbus.f;
import org.greenrobot.eventbus.g;

public class d {

    /* renamed from: m  reason: collision with root package name */
    private static final ExecutorService f14028m = Executors.newCachedThreadPool();

    /* renamed from: a  reason: collision with root package name */
    boolean f14029a = true;

    /* renamed from: b  reason: collision with root package name */
    boolean f14030b = true;

    /* renamed from: c  reason: collision with root package name */
    boolean f14031c = true;

    /* renamed from: d  reason: collision with root package name */
    boolean f14032d = true;

    /* renamed from: e  reason: collision with root package name */
    boolean f14033e;

    /* renamed from: f  reason: collision with root package name */
    boolean f14034f = true;

    /* renamed from: g  reason: collision with root package name */
    boolean f14035g;

    /* renamed from: h  reason: collision with root package name */
    boolean f14036h;

    /* renamed from: i  reason: collision with root package name */
    ExecutorService f14037i = f14028m;

    /* renamed from: j  reason: collision with root package name */
    List<b> f14038j;

    /* renamed from: k  reason: collision with root package name */
    f f14039k;

    /* renamed from: l  reason: collision with root package name */
    g f14040l;

    d() {
    }

    static Object c() {
        try {
            return Looper.getMainLooper();
        } catch (RuntimeException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public f a() {
        f fVar = this.f14039k;
        return fVar != null ? fVar : f.a.a();
    }

    /* access modifiers changed from: package-private */
    public g b() {
        Object c2;
        g gVar = this.f14040l;
        if (gVar != null) {
            return gVar;
        }
        if (!a.a() || (c2 = c()) == null) {
            return null;
        }
        return new g.a((Looper) c2);
    }

    public c d() {
        return new c(this);
    }
}
