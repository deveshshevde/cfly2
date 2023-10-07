package com.cloudbufferfly.uicorelib.utils;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import androidx.core.content.FileProvider;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.TypeCastException;
import kotlin.jvm.internal.h;

public final class YDUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final YDUtils f10743a = new YDUtils();

    /* renamed from: b  reason: collision with root package name */
    private static final a f10744b = new a();

    /* renamed from: c  reason: collision with root package name */
    private static final ExecutorService f10745c = Executors.newFixedThreadPool(3);

    /* renamed from: d  reason: collision with root package name */
    private static Handler f10746d = new Handler(Looper.getMainLooper());

    /* renamed from: e  reason: collision with root package name */
    private static Application f10747e;

    public static final class FileProvider4UtilCode extends FileProvider {
        public boolean onCreate() {
            YDUtils.f10743a.a(getContext());
            return true;
        }
    }

    public static final class a implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a  reason: collision with root package name */
        private final LinkedList<Activity> f10748a = new LinkedList<>();

        /* renamed from: b  reason: collision with root package name */
        private final Map<Object, c> f10749b = new HashMap();

        /* renamed from: c  reason: collision with root package name */
        private final Map<Activity, Set<b>> f10750c = new HashMap();

        /* renamed from: d  reason: collision with root package name */
        private int f10751d;

        /* renamed from: e  reason: collision with root package name */
        private int f10752e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f10753f;

        /* renamed from: com.cloudbufferfly.uicorelib.utils.YDUtils$a$a  reason: collision with other inner class name */
        static final class C0084a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Activity f10754a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f10755b;

            C0084a(Activity activity, int i2) {
                this.f10754a = activity;
                this.f10755b = i2;
            }

            public final void run() {
                this.f10754a.getWindow().setSoftInputMode(this.f10755b);
            }
        }

        private final void a(Activity activity) {
            if (this.f10748a.contains(activity)) {
                if (!h.a((Object) this.f10748a.getLast(), (Object) activity)) {
                    this.f10748a.remove(activity);
                } else {
                    return;
                }
            }
            this.f10748a.addLast(activity);
        }

        private final void a(Activity activity, boolean z2) {
            if (z2) {
                Window window = activity.getWindow();
                h.a((Object) window, "activity.window");
                int i2 = window.getAttributes().softInputMode;
                Window window2 = activity.getWindow();
                h.a((Object) window2, "activity.window");
                window2.getDecorView().setTag(-123, Integer.valueOf(i2));
                activity.getWindow().setSoftInputMode(3);
                return;
            }
            Window window3 = activity.getWindow();
            h.a((Object) window3, "activity.window");
            Object tag = window3.getDecorView().getTag(-123);
            if (!(tag instanceof Integer)) {
                tag = null;
            }
            Integer num = (Integer) tag;
            if (num != null) {
                YDUtils.f10743a.a(new C0084a(activity, num.intValue()), 100);
            }
        }

        private final void a(boolean z2) {
            c next;
            if (!this.f10749b.isEmpty()) {
                Iterator<c> it2 = this.f10749b.values().iterator();
                while (it2.hasNext() && (next = it2.next()) != null) {
                    if (z2) {
                        next.a();
                    } else {
                        next.b();
                    }
                }
            }
        }

        private final void b(Activity activity) {
            Iterator<Map.Entry<Activity, Set<b>>> it2 = this.f10750c.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry next = it2.next();
                if (((Activity) next.getKey()) == activity) {
                    for (b a2 : (Set) next.getValue()) {
                        a2.a(activity);
                    }
                    it2.remove();
                }
            }
        }

        public final LinkedList<Activity> a() {
            return this.f10748a;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            h.c(activity, "activity");
            h.c(bundle, "savedInstanceState");
            YDUtils.f10743a.c();
            a(activity);
        }

        public void onActivityDestroyed(Activity activity) {
            h.c(activity, "activity");
            this.f10748a.remove(activity);
            b(activity);
            YDUtils yDUtils = YDUtils.f10743a;
            Window window = activity.getWindow();
            h.a((Object) window, "activity.window");
            yDUtils.a(window);
        }

        public void onActivityPaused(Activity activity) {
            h.c(activity, "activity");
        }

        public void onActivityResumed(Activity activity) {
            h.c(activity, "activity");
            a(activity);
            if (this.f10753f) {
                this.f10753f = false;
                a(true);
            }
            a(activity, false);
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            h.c(activity, "activity");
            h.c(bundle, "outState");
        }

        public void onActivityStarted(Activity activity) {
            h.c(activity, "activity");
            if (!this.f10753f) {
                a(activity);
            }
            int i2 = this.f10752e;
            if (i2 < 0) {
                this.f10752e = i2 + 1;
            } else {
                this.f10751d++;
            }
        }

        public void onActivityStopped(Activity activity) {
            h.c(activity, "activity");
            if (activity.isChangingConfigurations()) {
                this.f10752e--;
            } else {
                int i2 = this.f10751d - 1;
                this.f10751d = i2;
                if (i2 <= 0) {
                    this.f10753f = true;
                    a(false);
                }
            }
            a(activity, true);
        }
    }

    public interface b {
        void a(Activity activity);
    }

    public interface c {
        void a();

        void b();
    }

    private YDUtils() {
    }

    private final Application b() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            h.a((Object) cls, "Class.forName(\"android.app.ActivityThread\")");
            Object invoke = cls.getMethod("getApplication", new Class[0]).invoke(cls.getMethod("currentActivityThread", new Class[0]).invoke((Object) null, new Object[0]), new Object[0]);
            if (invoke == null) {
                throw new NullPointerException("u should init first");
            } else if (invoke != null) {
                return (Application) invoke;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.app.Application");
            }
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            throw new NullPointerException("u should init first");
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            throw new NullPointerException("u should init first");
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            throw new NullPointerException("u should init first");
        } catch (ClassNotFoundException e5) {
            e5.printStackTrace();
            throw new NullPointerException("u should init first");
        }
    }

    /* access modifiers changed from: private */
    public final void c() {
        if (Build.VERSION.SDK_INT < 26 || !ValueAnimator.areAnimatorsEnabled()) {
            try {
                Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
                h.a((Object) declaredField, "ValueAnimator::class.jav…edField(\"sDurationScale\")");
                declaredField.setAccessible(true);
                Object obj = declaredField.get((Object) null);
                if (obj == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
                } else if (((Float) obj).floatValue() == 0.0f) {
                    declaredField.set((Object) null, Float.valueOf(1.0f));
                    Log.i("Utils", "setAnimatorsEnabled: Animators are enabled now!");
                }
            } catch (NoSuchFieldException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            }
        }
    }

    public final Application a() {
        Application b2 = b();
        a(b2);
        return b2;
    }

    public final void a(Application application) {
        Application application2 = f10747e;
        if (application2 != null && application != null) {
            Class<?> cls = application.getClass();
            Application application3 = f10747e;
            if (!h.a((Object) cls, (Object) application3 != null ? application3.getClass() : null)) {
                a aVar = f10744b;
                application2.unregisterActivityLifecycleCallbacks(aVar);
                aVar.a().clear();
                application2.registerActivityLifecycleCallbacks(aVar);
            }
        }
    }

    public final void a(Context context) {
        Application application;
        if (context == null) {
            application = b();
        } else {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                application = (Application) applicationContext;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.app.Application");
            }
        }
        a(application);
    }

    public final void a(Window window) {
        h.c(window, "window");
        Application a2 = a();
        Object systemService = a2 != null ? a2.getSystemService("input_method") : null;
        if (systemService != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            String[] strArr = {"mLastSrvView", "mCurRootView", "mServedView", "mNextServedView"};
            for (int i2 = 0; i2 < 4; i2++) {
                try {
                    Field declaredField = InputMethodManager.class.getDeclaredField(strArr[i2]);
                    h.a((Object) declaredField, "InputMethodManager::clas…iew\n                    )");
                    if (!declaredField.isAccessible()) {
                        declaredField.setAccessible(true);
                    }
                    Object obj = declaredField.get(inputMethodManager);
                    if (!(obj instanceof View)) {
                        obj = null;
                    }
                    View view = (View) obj;
                    if (view != null) {
                        View rootView = view.getRootView();
                        View decorView = window.getDecorView();
                        h.a((Object) decorView, "window.decorView");
                        if (rootView == decorView.getRootView()) {
                            declaredField.set(inputMethodManager, (Object) null);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    public final void a(Runnable runnable, long j2) {
        f10746d.postDelayed(runnable, j2);
    }
}
