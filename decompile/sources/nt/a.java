package nt;

import android.content.res.Resources;
import android.util.Log;
import org.greenrobot.eventbus.c;

public class a {

    /* renamed from: a  reason: collision with root package name */
    final Resources f31612a;

    /* renamed from: b  reason: collision with root package name */
    final int f31613b;

    /* renamed from: c  reason: collision with root package name */
    final int f31614c;

    /* renamed from: d  reason: collision with root package name */
    final e f31615d;

    /* renamed from: e  reason: collision with root package name */
    c f31616e;

    /* renamed from: f  reason: collision with root package name */
    boolean f31617f;

    /* renamed from: g  reason: collision with root package name */
    String f31618g;

    /* renamed from: h  reason: collision with root package name */
    int f31619h;

    /* renamed from: i  reason: collision with root package name */
    Class<?> f31620i;

    public int a(Throwable th) {
        Integer a2 = this.f31615d.a(th);
        if (a2 != null) {
            return a2.intValue();
        }
        String str = c.f13998a;
        Log.d(str, "No specific message ressource ID found for " + th);
        return this.f31614c;
    }

    /* access modifiers changed from: package-private */
    public c a() {
        c cVar = this.f31616e;
        return cVar != null ? cVar : c.a();
    }
}
