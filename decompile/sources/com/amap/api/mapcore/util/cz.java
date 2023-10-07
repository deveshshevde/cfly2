package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.maps.model.LatLng;
import java.lang.ref.WeakReference;
import java.util.Hashtable;

public class cz {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f8228a = false;

    /* renamed from: d  reason: collision with root package name */
    private static volatile cz f8229d;

    /* renamed from: b  reason: collision with root package name */
    private Hashtable<String, String> f8230b = new Hashtable<>();

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<Context> f8231c = null;

    private cz() {
    }

    public static cz a() {
        if (f8229d == null) {
            synchronized (cz.class) {
                if (f8229d == null) {
                    f8229d = new cz();
                }
            }
        }
        return f8229d;
    }

    private void a(String str) {
        Hashtable<String, String> hashtable;
        if (str != null && (hashtable = this.f8230b) != null) {
            synchronized (hashtable) {
                String b2 = fd.b(str);
                Hashtable<String, String> hashtable2 = this.f8230b;
                if (hashtable2 != null && !hashtable2.contains(b2)) {
                    this.f8230b.put(b2, str);
                }
                if (e()) {
                    d();
                }
            }
        }
    }

    public static void a(boolean z2) {
        f8228a = z2;
    }

    public static void b() {
        if (f8229d != null) {
            if (f8229d.f8230b != null && f8229d.f8230b.size() > 0) {
                synchronized (f8229d.f8230b) {
                    f8229d.d();
                    if (f8229d.f8231c != null) {
                        f8229d.f8231c.clear();
                    }
                }
            }
            f8229d = null;
        }
        a(false);
    }

    public static boolean c() {
        return f8228a;
    }

    private void d() {
        WeakReference<Context> weakReference;
        if (!f8228a) {
            this.f8230b.clear();
        } else if (this.f8230b != null) {
            StringBuffer stringBuffer = new StringBuffer();
            int i2 = 0;
            int size = this.f8230b.size();
            if (size > 0) {
                stringBuffer.append("[");
                for (String append : this.f8230b.values()) {
                    i2++;
                    stringBuffer.append(append);
                    if (i2 < size) {
                        stringBuffer.append(",");
                    }
                }
                stringBuffer.append("]");
                String stringBuffer2 = stringBuffer.toString();
                if (!(TextUtils.isEmpty(stringBuffer2) || (weakReference = this.f8231c) == null || weakReference.get() == null)) {
                    hi.a(stringBuffer2, (Context) this.f8231c.get());
                }
            }
            this.f8230b.clear();
        }
    }

    private boolean e() {
        Hashtable<String, String> hashtable = this.f8230b;
        return hashtable != null && hashtable.size() > 20;
    }

    public final void a(Context context) {
        if (context != null) {
            this.f8231c = new WeakReference<>(context);
        }
    }

    public final void a(LatLng latLng, String str, String str2) {
        if (!f8228a) {
            this.f8230b.clear();
        } else if (latLng != null && !TextUtils.isEmpty(str)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("{");
            stringBuffer.append("\"lon\":");
            stringBuffer.append(latLng.longitude);
            stringBuffer.append(",");
            stringBuffer.append("\"lat\":");
            stringBuffer.append(latLng.latitude);
            stringBuffer.append(",");
            stringBuffer.append("\"title\":\"");
            stringBuffer.append(str);
            stringBuffer.append("\",");
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            stringBuffer.append("\"snippet\":\"");
            stringBuffer.append(str2);
            stringBuffer.append("\"");
            stringBuffer.append("}");
            a(stringBuffer.toString());
        }
    }
}
