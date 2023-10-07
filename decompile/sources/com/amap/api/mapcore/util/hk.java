package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

public class hk {

    /* renamed from: a  reason: collision with root package name */
    static int f9138a = 1000;

    /* renamed from: b  reason: collision with root package name */
    static boolean f9139b = false;

    /* renamed from: c  reason: collision with root package name */
    static int f9140c = 20;

    /* renamed from: d  reason: collision with root package name */
    static int f9141d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static WeakReference<hg> f9142e = null;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static int f9143f = 10;

    static class a extends ie {

        /* renamed from: a  reason: collision with root package name */
        private int f9144a;

        /* renamed from: b  reason: collision with root package name */
        private Context f9145b;

        /* renamed from: c  reason: collision with root package name */
        private hj f9146c;

        a(Context context, int i2) {
            this.f9145b = context;
            this.f9144a = i2;
        }

        a(Context context, hj hjVar) {
            this(context, 1);
            this.f9146c = hjVar;
        }

        public final void runTask() {
            int i2 = this.f9144a;
            if (i2 == 1) {
                try {
                    synchronized (hk.class) {
                        String l2 = Long.toString(System.currentTimeMillis());
                        hg a2 = hn.a(hk.f9142e);
                        hn.a(this.f9145b, a2, fx.f8868i, hk.f9138a, 2097152, "6");
                        if (a2.f9127e == null) {
                            a2.f9127e = new gp(new gr(new gs(new gr())));
                        }
                        hh.a(l2, this.f9146c.a(), a2);
                    }
                } catch (Throwable th) {
                    fz.c(th, "ofm", "aple");
                }
            } else if (i2 == 2) {
                try {
                    hg a3 = hn.a(hk.f9142e);
                    hn.a(this.f9145b, a3, fx.f8868i, hk.f9138a, 2097152, "6");
                    a3.f9130h = 14400000;
                    if (a3.f9129g == null) {
                        gp gpVar = new gp(new gr(new gs()));
                        a3.f9129g = new hr(new hq(this.f9145b, new hv(), gpVar, new String(fv.a(10)), ev.f(this.f9145b), ez.u(this.f9145b), ez.m(this.f9145b), ez.h(this.f9145b), ez.a(), Build.MANUFACTURER, Build.DEVICE, ez.x(this.f9145b), ev.c(this.f9145b), Build.MODEL, ev.d(this.f9145b), ev.b(this.f9145b)));
                    }
                    if (TextUtils.isEmpty(a3.f9131i)) {
                        a3.f9131i = "fKey";
                    }
                    a3.f9128f = new hz(this.f9145b, a3.f9130h, a3.f9131i, new hx(this.f9145b, hk.f9139b, hk.f9143f * 1024, hk.f9140c * 1024, "offLocKey", hk.f9141d * 1024));
                    hh.a(a3);
                } catch (Throwable th2) {
                    fz.c(th2, "ofm", "uold");
                }
            }
        }
    }

    @Deprecated
    public static synchronized void a(int i2, boolean z2) {
        synchronized (hk.class) {
            f9138a = i2;
            f9139b = z2;
        }
    }

    public static void a(Context context) {
        id.a().a(new a(context, 2));
    }

    public static synchronized void a(hj hjVar, Context context) {
        synchronized (hk.class) {
            id.a().a(new a(context, hjVar));
        }
    }
}
