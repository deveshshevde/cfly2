package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.ab;
import androidx.savedstate.a;
import androidx.savedstate.c;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public final class y extends ab.c {

    /* renamed from: f  reason: collision with root package name */
    private static final Class<?>[] f3653f = {Application.class, x.class};

    /* renamed from: g  reason: collision with root package name */
    private static final Class<?>[] f3654g = {x.class};

    /* renamed from: a  reason: collision with root package name */
    private final Application f3655a;

    /* renamed from: b  reason: collision with root package name */
    private final ab.b f3656b;

    /* renamed from: c  reason: collision with root package name */
    private final Bundle f3657c;

    /* renamed from: d  reason: collision with root package name */
    private final Lifecycle f3658d;

    /* renamed from: e  reason: collision with root package name */
    private final a f3659e;

    public y(Application application, c cVar, Bundle bundle) {
        this.f3659e = cVar.getSavedStateRegistry();
        this.f3658d = cVar.getLifecycle();
        this.f3657c = bundle;
        this.f3655a = application;
        this.f3656b = application != null ? ab.a.a(application) : ab.d.a();
    }

    private static <T> Constructor<T> a(Class<T> cls, Class<?>[] clsArr) {
        for (Constructor<T> constructor : cls.getConstructors()) {
            if (Arrays.equals(clsArr, constructor.getParameterTypes())) {
                return constructor;
            }
        }
        return null;
    }

    public <T extends aa> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return a(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public <T extends aa> T a(String str, Class<T> cls) {
        T newInstance;
        boolean isAssignableFrom = a.class.isAssignableFrom(cls);
        Constructor<T> a2 = (!isAssignableFrom || this.f3655a == null) ? a(cls, f3654g) : a(cls, f3653f);
        if (a2 == null) {
            return this.f3656b.a(cls);
        }
        SavedStateHandleController a3 = SavedStateHandleController.a(this.f3659e, this.f3658d, str, this.f3657c);
        if (isAssignableFrom) {
            try {
                Application application = this.f3655a;
                if (application != null) {
                    newInstance = a2.newInstance(new Object[]{application, a3.b()});
                    T t2 = (aa) newInstance;
                    t2.a("androidx.lifecycle.savedstate.vm.tag", a3);
                    return t2;
                }
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Failed to access " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("A " + cls + " cannot be instantiated.", e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("An exception happened in constructor of " + cls, e4.getCause());
            }
        }
        newInstance = a2.newInstance(new Object[]{a3.b()});
        T t22 = (aa) newInstance;
        t22.a("androidx.lifecycle.savedstate.vm.tag", a3);
        return t22;
    }

    /* access modifiers changed from: package-private */
    public void a(aa aaVar) {
        SavedStateHandleController.a(aaVar, this.f3659e, this.f3658d);
    }
}
