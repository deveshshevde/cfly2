package ha;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.n;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, a<Object>> f13300a;

    public static class a<T> extends s<T> {

        /* renamed from: e  reason: collision with root package name */
        private Map<t, t> f13301e = new HashMap();

        /* renamed from: f  reason: collision with root package name */
        private Handler f13302f = new Handler(Looper.getMainLooper());

        /* renamed from: ha.b$a$a  reason: collision with other inner class name */
        private class C0093a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            private T f13304b;

            public C0093a(T t2) {
                this.f13304b = t2;
            }

            public void run() {
                a.this.b(this.f13304b);
            }
        }

        private void c(t<? super T> tVar) throws Exception {
            Class<LiveData> cls = LiveData.class;
            Field declaredField = cls.getDeclaredField("mObservers");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            Method declaredMethod = obj.getClass().getDeclaredMethod("get", new Class[]{Object.class});
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(obj, new Object[]{tVar});
            Object value = invoke instanceof Map.Entry ? ((Map.Entry) invoke).getValue() : null;
            Objects.requireNonNull(value, "Wrapper can not be bull!");
            Field declaredField2 = value.getClass().getSuperclass().getDeclaredField("mLastVersion");
            declaredField2.setAccessible(true);
            Field declaredField3 = cls.getDeclaredField("mVersion");
            declaredField3.setAccessible(true);
            declaredField2.set(value, declaredField3.get(this));
        }

        public void a(n nVar, t<? super T> tVar) {
            super.a(nVar, tVar);
            try {
                c(tVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public void a(t<? super T> tVar) {
            if (!this.f13301e.containsKey(tVar)) {
                this.f13301e.put(tVar, new C0094b(tVar));
            }
            super.a(this.f13301e.get(tVar));
        }

        public void a(T t2) {
            this.f13302f.post(new C0093a(t2));
        }

        public void b(n nVar, t<? super Object> tVar) {
            super.a(nVar, tVar);
        }

        public void b(t<? super T> tVar) {
            if (this.f13301e.containsKey(tVar)) {
                tVar = this.f13301e.remove(tVar);
            }
            super.b(tVar);
        }
    }

    /* renamed from: ha.b$b  reason: collision with other inner class name */
    private static class C0094b<T> implements t<T> {

        /* renamed from: a  reason: collision with root package name */
        private t<T> f13305a;

        public C0094b(t<T> tVar) {
            this.f13305a = tVar;
        }

        private boolean a() {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if ("android.arch.lifecycle.LiveData".equals(stackTraceElement.getClassName()) && "observeForever".equals(stackTraceElement.getMethodName())) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void onChanged(T t2) {
            if (this.f13305a != null && !a()) {
                this.f13305a.onChanged(t2);
            }
        }
    }

    private static class c {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final b f13306a = new b();
    }

    private b() {
        this.f13300a = new HashMap();
    }

    public static b a() {
        return c.f13306a;
    }

    public a<Object> a(String str) {
        return a(str, Object.class);
    }

    public synchronized <T> a<T> a(String str, Class<T> cls) {
        if (!this.f13300a.containsKey(str)) {
            this.f13300a.put(str, new a());
        }
        return this.f13300a.get(str);
    }
}
