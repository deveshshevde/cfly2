package com.google.android.gms.common;

import android.content.Context;
import android.util.Log;

final class u {

    /* renamed from: a  reason: collision with root package name */
    static final s f17946a = new l(p.a("0\u0005È0\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010e\bsù/Qí"));

    /* renamed from: b  reason: collision with root package name */
    static final s f17947b = new m(p.a("0\u0006\u00040\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²­×árÊkì"));

    /* renamed from: c  reason: collision with root package name */
    static final s f17948c = new n(p.a("0\u0004C0\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000ÂàFdJ00"));

    /* renamed from: d  reason: collision with root package name */
    static final s f17949d = new o(p.a("0\u0004¨0\u0003 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ¸l}ÓNõ0"));

    /* renamed from: e  reason: collision with root package name */
    private static final Object f17950e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private static Context f17951f;

    static synchronized void a(Context context) {
        synchronized (u.class) {
            if (f17951f != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                f17951f = context.getApplicationContext();
            }
        }
    }
}
