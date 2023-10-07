package com.autonavi.extra;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private List<a> f10021a = new ArrayList();

    public final void a() {
        synchronized (b.class) {
            List<a> list = this.f10021a;
            if (list != null) {
                list.add((Object) null);
            }
        }
    }

    public final void b() {
        synchronized (b.class) {
            Iterator<a> it2 = this.f10021a.iterator();
            while (it2.hasNext()) {
                it2.next();
            }
        }
    }

    public final void c() {
        synchronized (b.class) {
            Iterator<a> it2 = this.f10021a.iterator();
            while (it2.hasNext()) {
                it2.next();
            }
        }
    }

    public final void d() {
        synchronized (b.class) {
            Iterator<a> it2 = this.f10021a.iterator();
            while (it2.hasNext()) {
                it2.next();
            }
        }
    }

    public final void e() {
        synchronized (b.class) {
            Iterator<a> it2 = this.f10021a.iterator();
            while (it2.hasNext()) {
                it2.next();
            }
        }
    }

    public final void f() {
        synchronized (b.class) {
            Iterator<a> it2 = this.f10021a.iterator();
            while (it2.hasNext()) {
                it2.next();
            }
            this.f10021a.clear();
        }
    }

    public final String g() {
        String stringBuffer;
        synchronized (b.class) {
            StringBuffer stringBuffer2 = new StringBuffer();
            for (a next : this.f10021a) {
                if (next != null) {
                    String a2 = next.a();
                    if (!TextUtils.isEmpty(a2)) {
                        stringBuffer2.append(a2);
                        if (!a2.endsWith(";")) {
                            stringBuffer2.append(";");
                        }
                    }
                }
            }
            stringBuffer = stringBuffer2.toString();
        }
        return stringBuffer;
    }

    public final void h() {
        synchronized (b.class) {
            Iterator<a> it2 = this.f10021a.iterator();
            while (it2.hasNext()) {
                it2.next();
            }
        }
    }

    public final void i() {
        synchronized (b.class) {
            Iterator<a> it2 = this.f10021a.iterator();
            while (it2.hasNext()) {
                it2.next();
            }
        }
    }

    public final Object j() {
        Object b2;
        synchronized (b.class) {
            for (a next : this.f10021a) {
                if (next != null && (b2 = next.b()) != null) {
                    return b2;
                }
            }
            return null;
        }
    }
}
