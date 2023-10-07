package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.w;

public class v implements n {

    /* renamed from: i  reason: collision with root package name */
    private static final v f3635i = new v();

    /* renamed from: a  reason: collision with root package name */
    w.a f3636a = new w.a() {
        public void a() {
        }

        public void b() {
            v.this.a();
        }

        public void c() {
            v.this.b();
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private int f3637b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f3638c = 0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3639d = true;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3640e = true;

    /* renamed from: f  reason: collision with root package name */
    private Handler f3641f;

    /* renamed from: g  reason: collision with root package name */
    private final o f3642g = new o(this);

    /* renamed from: h  reason: collision with root package name */
    private Runnable f3643h = new Runnable() {
        public void run() {
            v.this.e();
            v.this.f();
        }
    };

    private v() {
    }

    static void a(Context context) {
        f3635i.b(context);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        int i2 = this.f3637b + 1;
        this.f3637b = i2;
        if (i2 == 1 && this.f3640e) {
            this.f3642g.a(Lifecycle.Event.ON_START);
            this.f3640e = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        int i2 = this.f3638c + 1;
        this.f3638c = i2;
        if (i2 != 1) {
            return;
        }
        if (this.f3639d) {
            this.f3642g.a(Lifecycle.Event.ON_RESUME);
            this.f3639d = false;
            return;
        }
        this.f3641f.removeCallbacks(this.f3643h);
    }

    /* access modifiers changed from: package-private */
    public void b(Context context) {
        this.f3641f = new Handler();
        this.f3642g.a(Lifecycle.Event.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new d() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (Build.VERSION.SDK_INT < 29) {
                    w.b(activity).a(v.this.f3636a);
                }
            }

            public void onActivityPaused(Activity activity) {
                v.this.c();
            }

            public void onActivityPreCreated(Activity activity, Bundle bundle) {
                activity.registerActivityLifecycleCallbacks(new d() {
                    public void onActivityPostResumed(Activity activity) {
                        v.this.b();
                    }

                    public void onActivityPostStarted(Activity activity) {
                        v.this.a();
                    }
                });
            }

            public void onActivityStopped(Activity activity) {
                v.this.d();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void c() {
        int i2 = this.f3638c - 1;
        this.f3638c = i2;
        if (i2 == 0) {
            this.f3641f.postDelayed(this.f3643h, 700);
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f3637b--;
        f();
    }

    /* access modifiers changed from: package-private */
    public void e() {
        if (this.f3638c == 0) {
            this.f3639d = true;
            this.f3642g.a(Lifecycle.Event.ON_PAUSE);
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (this.f3637b == 0 && this.f3639d) {
            this.f3642g.a(Lifecycle.Event.ON_STOP);
            this.f3640e = true;
        }
    }

    public Lifecycle getLifecycle() {
        return this.f3642g;
    }
}
