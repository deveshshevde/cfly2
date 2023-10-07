package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q {

    /* renamed from: a  reason: collision with root package name */
    private static Map<Class<?>, Integer> f3632a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static Map<Class<?>, List<Constructor<? extends f>>> f3633b = new HashMap();

    private static f a(Constructor<? extends f> constructor, Object obj) {
        try {
            return (f) constructor.newInstance(new Object[]{obj});
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    static k a(Object obj) {
        boolean z2 = obj instanceof k;
        boolean z3 = obj instanceof e;
        if (z2 && z3) {
            return new FullLifecycleObserverAdapter((e) obj, (k) obj);
        }
        if (z3) {
            return new FullLifecycleObserverAdapter((e) obj, (k) null);
        }
        if (z2) {
            return (k) obj;
        }
        Class<?> cls = obj.getClass();
        if (b(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List list = f3633b.get(cls);
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(a((Constructor) list.get(0), obj));
        }
        f[] fVarArr = new f[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            fVarArr[i2] = a((Constructor) list.get(i2), obj);
        }
        return new CompositeGeneratedAdaptersObserver(fVarArr);
    }

    public static String a(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }

    private static Constructor<? extends f> a(Class<?> cls) {
        try {
            Package packageR = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = packageR != null ? packageR.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String a2 = a(canonicalName);
            if (!name.isEmpty()) {
                a2 = name + "." + a2;
            }
            Constructor<?> declaredConstructor = Class.forName(a2).getDeclaredConstructor(new Class[]{cls});
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static int b(Class<?> cls) {
        Integer num = f3632a.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int c2 = c(cls);
        f3632a.put(cls, Integer.valueOf(c2));
        return c2;
    }

    private static int c(Class<?> cls) {
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends f> a2 = a(cls);
        if (a2 != null) {
            f3633b.put(cls, Collections.singletonList(a2));
            return 2;
        } else if (b.f3605a.a(cls)) {
            return 1;
        } else {
            Class<? super Object> superclass = cls.getSuperclass();
            ArrayList arrayList = null;
            if (d(superclass)) {
                if (b(superclass) == 1) {
                    return 1;
                }
                arrayList = new ArrayList(f3633b.get(superclass));
            }
            for (Class cls2 : cls.getInterfaces()) {
                if (d(cls2)) {
                    if (b(cls2) == 1) {
                        return 1;
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.addAll(f3633b.get(cls2));
                }
            }
            if (arrayList == null) {
                return 1;
            }
            f3633b.put(cls, arrayList);
            return 2;
        }
    }

    private static boolean d(Class<?> cls) {
        return cls != null && m.class.isAssignableFrom(cls);
    }
}
