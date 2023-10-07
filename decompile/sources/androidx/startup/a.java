package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class a {

    /* renamed from: d  reason: collision with root package name */
    private static volatile a f4525d;

    /* renamed from: e  reason: collision with root package name */
    private static final Object f4526e = new Object();

    /* renamed from: a  reason: collision with root package name */
    final Map<Class<?>, Object> f4527a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    final Set<Class<? extends b<?>>> f4528b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    final Context f4529c;

    a(Context context) {
        this.f4529c = context.getApplicationContext();
    }

    public static a a(Context context) {
        if (f4525d == null) {
            synchronized (f4526e) {
                if (f4525d == null) {
                    f4525d = new a(context);
                }
            }
        }
        return f4525d;
    }

    /* access modifiers changed from: package-private */
    public <T> T a(Class<? extends b<?>> cls, Set<Class<?>> set) {
        T t2;
        synchronized (f4526e) {
            if (ai.a.a()) {
                try {
                    ai.a.a(cls.getSimpleName());
                } catch (Throwable th) {
                    ai.a.b();
                    throw th;
                }
            }
            if (!set.contains(cls)) {
                if (!this.f4527a.containsKey(cls)) {
                    set.add(cls);
                    b bVar = (b) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    List<Class<? extends b<?>>> a2 = bVar.a();
                    if (!a2.isEmpty()) {
                        for (Class next : a2) {
                            if (!this.f4527a.containsKey(next)) {
                                a(next, set);
                            }
                        }
                    }
                    t2 = bVar.a(this.f4529c);
                    set.remove(cls);
                    this.f4527a.put(cls, t2);
                } else {
                    t2 = this.f4527a.get(cls);
                }
                ai.a.b();
            } else {
                throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", new Object[]{cls.getName()}));
            }
        }
        return t2;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        try {
            ai.a.a("Startup");
            Bundle bundle = this.f4529c.getPackageManager().getProviderInfo(new ComponentName(this.f4529c.getPackageName(), InitializationProvider.class.getName()), 128).metaData;
            String string = this.f4529c.getString(R.string.androidx_startup);
            if (bundle != null) {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, (String) null))) {
                        Class<?> cls = Class.forName(str);
                        if (b.class.isAssignableFrom(cls)) {
                            this.f4528b.add(cls);
                            a(cls, hashSet);
                        }
                    }
                }
            }
            ai.a.b();
        } catch (PackageManager.NameNotFoundException | ClassNotFoundException e2) {
            throw new StartupException(e2);
        } catch (Throwable th) {
            ai.a.b();
            throw th;
        }
    }
}
