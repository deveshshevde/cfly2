package com.amap.api.mapcore.util;

import android.util.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class dq implements Cdo {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, a> f8276a = new ConcurrentHashMap();

    class a {

        /* renamed from: a  reason: collision with root package name */
        String f8277a = "";

        /* renamed from: b  reason: collision with root package name */
        String f8278b = "";

        /* renamed from: c  reason: collision with root package name */
        int f8279c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicInteger f8280d;

        public a(int i2, String str, String str2) {
            this.f8277a = str;
            this.f8278b = str2;
            this.f8279c = i2;
            this.f8280d = new AtomicInteger(0);
        }

        public final int a() {
            return this.f8280d.incrementAndGet();
        }
    }

    private static void a(int i2, String str, String str2, int i3) {
        StringBuilder sb;
        fr a2 = fr.a(dl.a());
        if (i2 != 0) {
            sb = new StringBuilder();
        }
        sb.append(str2);
        sb.append(" counter ");
        sb.append(i3);
        a2.a(fq.a(str, sb.toString()));
        if (dm.f8268b) {
            c(i2, str, str2 + " counter " + i3);
        }
    }

    private static String b(int i2, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        if (str == null) {
            str = "";
        }
        sb.append(str);
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        return sb.toString();
    }

    private static void c(int i2, String str, String str2) {
        if (i2 == 0) {
            Log.i("linklog", str + " " + str2);
            return;
        }
        Log.e("linklog", str + " " + str2);
    }

    public final void a() {
        try {
            for (Map.Entry<String, a> value : f8276a.entrySet()) {
                a aVar = (a) value.getValue();
                if (aVar != null) {
                    a(aVar.f8279c, aVar.f8277a, aVar.f8278b, aVar.f8280d.get());
                }
            }
            f8276a.clear();
            fr.a(dl.a()).a();
        } catch (Throwable unused) {
        }
    }

    public final void a(int i2, String str, String str2) {
        try {
            String b2 = b(i2, str, str2);
            a aVar = f8276a.get(b2);
            if (aVar == null) {
                aVar = new a(i2, str, str2);
                f8276a.put(b2, aVar);
            }
            if (aVar.a() > 100) {
                a(aVar.f8279c, aVar.f8277a, aVar.f8278b, aVar.f8280d.get());
                f8276a.remove(b2);
            }
        } catch (Throwable unused) {
        }
    }
}
