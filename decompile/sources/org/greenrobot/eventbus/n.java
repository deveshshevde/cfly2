package org.greenrobot.eventbus;

import java.lang.reflect.Method;

public class n {

    /* renamed from: a  reason: collision with root package name */
    final Method f14058a;

    /* renamed from: b  reason: collision with root package name */
    final ThreadMode f14059b;

    /* renamed from: c  reason: collision with root package name */
    final Class<?> f14060c;

    /* renamed from: d  reason: collision with root package name */
    final int f14061d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f14062e;

    /* renamed from: f  reason: collision with root package name */
    String f14063f;

    public n(Method method, Class<?> cls, ThreadMode threadMode, int i2, boolean z2) {
        this.f14058a = method;
        this.f14059b = threadMode;
        this.f14060c = cls;
        this.f14061d = i2;
        this.f14062e = z2;
    }

    private synchronized void a() {
        if (this.f14063f == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f14058a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.f14058a.getName());
            sb.append('(');
            sb.append(this.f14060c.getName());
            this.f14063f = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        a();
        n nVar = (n) obj;
        nVar.a();
        return this.f14063f.equals(nVar.f14063f);
    }

    public int hashCode() {
        return this.f14058a.hashCode();
    }
}
