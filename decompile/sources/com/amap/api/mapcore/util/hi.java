package com.amap.api.mapcore.util;

import android.content.Context;
import java.lang.ref.WeakReference;

public class hi {

    /* renamed from: a  reason: collision with root package name */
    static WeakReference<hg> f9132a;

    public static void a(final String str, final Context context) {
        fz.d().submit(new Runnable() {
            public final void run() {
                synchronized (hi.class) {
                    try {
                        String a2 = fd.a(fg.a(str));
                        hg a3 = hn.a(hi.f9132a);
                        hn.a(context, a3, fx.f8869j, 50, 102400, "10");
                        if (a3.f9127e == null) {
                            a3.f9127e = new gp(new gs(new gr()));
                        }
                        String a4 = fg.a(System.currentTimeMillis(), "yyyyMMdd HH:mm:ss");
                        hh.a(a2, fg.a(" \"timestamp\":\"" + a4 + "\",\"details\":" + str), a3);
                    } catch (Throwable th) {
                        fz.c(th, "mam", "ap");
                    }
                }
            }
        });
    }
}
