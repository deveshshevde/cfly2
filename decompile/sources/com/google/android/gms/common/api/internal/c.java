package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.util.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: a  reason: collision with root package name */
    private static final c f17529a = new c();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicBoolean f17530b = new AtomicBoolean();

    /* renamed from: c  reason: collision with root package name */
    private final AtomicBoolean f17531c = new AtomicBoolean();

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<a> f17532d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private boolean f17533e = false;

    public interface a {
        void a(boolean z2);
    }

    private c() {
    }

    public static c a() {
        return f17529a;
    }

    public static void a(Application application) {
        c cVar = f17529a;
        synchronized (cVar) {
            if (!cVar.f17533e) {
                application.registerActivityLifecycleCallbacks(cVar);
                application.registerComponentCallbacks(cVar);
                cVar.f17533e = true;
            }
        }
    }

    private final void b(boolean z2) {
        synchronized (f17529a) {
            Iterator<a> it2 = this.f17532d.iterator();
            while (it2.hasNext()) {
                it2.next().a(z2);
            }
        }
    }

    public void a(a aVar) {
        synchronized (f17529a) {
            this.f17532d.add(aVar);
        }
    }

    public boolean a(boolean z2) {
        if (!this.f17531c.get()) {
            if (!l.a()) {
                return z2;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.f17531c.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f17530b.set(true);
            }
        }
        return b();
    }

    public boolean b() {
        return this.f17530b.get();
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.f17530b.compareAndSet(true, false);
        this.f17531c.set(true);
        if (compareAndSet) {
            b(false);
        }
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.f17530b.compareAndSet(true, false);
        this.f17531c.set(true);
        if (compareAndSet) {
            b(false);
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    public final void onTrimMemory(int i2) {
        if (i2 == 20 && this.f17530b.compareAndSet(false, true)) {
            this.f17531c.set(true);
            b(true);
        }
    }
}
