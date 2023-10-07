package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

final class c {

    /* renamed from: a  reason: collision with root package name */
    protected static final Class<?> f2822a;

    /* renamed from: b  reason: collision with root package name */
    protected static final Field f2823b = b();

    /* renamed from: c  reason: collision with root package name */
    protected static final Field f2824c = c();

    /* renamed from: d  reason: collision with root package name */
    protected static final Method f2825d;

    /* renamed from: e  reason: collision with root package name */
    protected static final Method f2826e;

    /* renamed from: f  reason: collision with root package name */
    protected static final Method f2827f;

    /* renamed from: g  reason: collision with root package name */
    private static final Handler f2828g = new Handler(Looper.getMainLooper());

    private static final class a implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a  reason: collision with root package name */
        Object f2835a;

        /* renamed from: b  reason: collision with root package name */
        private Activity f2836b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2837c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f2838d = false;

        /* renamed from: e  reason: collision with root package name */
        private boolean f2839e = false;

        /* renamed from: f  reason: collision with root package name */
        private boolean f2840f = false;

        a(Activity activity) {
            this.f2836b = activity;
            this.f2837c = activity.hashCode();
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.f2836b == activity) {
                this.f2836b = null;
                this.f2839e = true;
            }
        }

        public void onActivityPaused(Activity activity) {
            if (this.f2839e && !this.f2840f && !this.f2838d && c.a(this.f2835a, this.f2837c, activity)) {
                this.f2840f = true;
                this.f2835a = null;
            }
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            if (this.f2836b == activity) {
                this.f2838d = true;
            }
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class<?> d2 = d();
        f2822a = d2;
        f2825d = a(d2);
        f2826e = b(d2);
        f2827f = c(d2);
    }

    private static Method a(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE, String.class});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean a() {
        return Build.VERSION.SDK_INT == 26 || Build.VERSION.SDK_INT == 27;
    }

    static boolean a(Activity activity) {
        Object obj;
        final Application application;
        final a aVar;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (a() && f2827f == null) {
            return false;
        } else {
            if (f2826e == null && f2825d == null) {
                return false;
            }
            try {
                final Object obj2 = f2824c.get(activity);
                if (obj2 == null || (obj = f2823b.get(activity)) == null) {
                    return false;
                }
                application = activity.getApplication();
                aVar = new a(activity);
                application.registerActivityLifecycleCallbacks(aVar);
                Handler handler = f2828g;
                handler.post(new Runnable() {
                    public void run() {
                        a.this.f2835a = obj2;
                    }
                });
                if (a()) {
                    f2827f.invoke(obj, new Object[]{obj2, null, null, 0, false, null, null, false, false});
                } else {
                    activity.recreate();
                }
                handler.post(new Runnable() {
                    public void run() {
                        application.unregisterActivityLifecycleCallbacks(aVar);
                    }
                });
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }

    protected static boolean a(Object obj, int i2, Activity activity) {
        try {
            final Object obj2 = f2824c.get(activity);
            if (obj2 == obj) {
                if (activity.hashCode() == i2) {
                    final Object obj3 = f2823b.get(activity);
                    f2828g.postAtFrontOfQueue(new Runnable() {
                        public void run() {
                            try {
                                if (c.f2825d != null) {
                                    c.f2825d.invoke(obj3, new Object[]{obj2, false, "AppCompat recreation"});
                                    return;
                                }
                                c.f2826e.invoke(obj3, new Object[]{obj2, false});
                            } catch (RuntimeException e2) {
                                if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                                    throw e2;
                                }
                            } catch (Throwable th) {
                                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
                            }
                        }
                    });
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method b(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field c() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(Class<?> cls) {
        if (a() && cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", new Class[]{IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE});
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Class<?> d() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }
}
