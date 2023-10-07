package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

public class ab {

    /* renamed from: a  reason: collision with root package name */
    private final b f3599a;

    /* renamed from: b  reason: collision with root package name */
    private final ac f3600b;

    public static class a extends d {

        /* renamed from: a  reason: collision with root package name */
        private static a f3601a;

        /* renamed from: b  reason: collision with root package name */
        private Application f3602b;

        public a(Application application) {
            this.f3602b = application;
        }

        public static a a(Application application) {
            if (f3601a == null) {
                f3601a = new a(application);
            }
            return f3601a;
        }

        public <T extends aa> T a(Class<T> cls) {
            if (!a.class.isAssignableFrom(cls)) {
                return super.a(cls);
            }
            try {
                return (aa) cls.getConstructor(new Class[]{Application.class}).newInstance(new Object[]{this.f3602b});
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            } catch (InstantiationException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            } catch (InvocationTargetException e5) {
                throw new RuntimeException("Cannot create an instance of " + cls, e5);
            }
        }
    }

    public interface b {
        <T extends aa> T a(Class<T> cls);
    }

    static abstract class c extends e implements b {
        c() {
        }

        public <T extends aa> T a(Class<T> cls) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }

        public abstract <T extends aa> T a(String str, Class<T> cls);
    }

    public static class d implements b {

        /* renamed from: a  reason: collision with root package name */
        private static d f3603a;

        static d a() {
            if (f3603a == null) {
                f3603a = new d();
            }
            return f3603a;
        }

        public <T extends aa> T a(Class<T> cls) {
            try {
                return (aa) cls.newInstance();
            } catch (InstantiationException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            }
        }
    }

    static class e {
        e() {
        }

        /* access modifiers changed from: package-private */
        public void a(aa aaVar) {
        }
    }

    public ab(ac acVar, b bVar) {
        this.f3599a = bVar;
        this.f3600b = acVar;
    }

    public <T extends aa> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return a("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public <T extends aa> T a(String str, Class<T> cls) {
        T a2 = this.f3600b.a(str);
        if (cls.isInstance(a2)) {
            b bVar = this.f3599a;
            if (bVar instanceof e) {
                ((e) bVar).a(a2);
            }
            return a2;
        }
        b bVar2 = this.f3599a;
        T a3 = bVar2 instanceof c ? ((c) bVar2).a(str, cls) : bVar2.a(cls);
        this.f3600b.a(str, a3);
        return a3;
    }
}
