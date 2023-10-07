package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import df.c;
import java.util.Set;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f11127a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<C0087a> f11128b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f11129c;

    /* renamed from: d  reason: collision with root package name */
    private final Runnable f11130d;

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    public interface C0087a {
    }

    private static void a() {
        c.b(Looper.getMainLooper().getThread() == Thread.currentThread());
    }

    public void a(C0087a aVar) {
        a();
        if (this.f11128b.add(aVar) && this.f11128b.size() == 1) {
            this.f11129c.post(this.f11130d);
        }
    }

    public void b(C0087a aVar) {
        a();
        this.f11128b.remove(aVar);
    }
}
