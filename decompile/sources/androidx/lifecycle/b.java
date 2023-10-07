package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class b {

    /* renamed from: a  reason: collision with root package name */
    static b f3605a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, a> f3606b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class<?>, Boolean> f3607c = new HashMap();

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final Map<Lifecycle.Event, List<C0029b>> f3608a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        final Map<C0029b, Lifecycle.Event> f3609b;

        a(Map<C0029b, Lifecycle.Event> map) {
            this.f3609b = map;
            for (Map.Entry next : map.entrySet()) {
                Lifecycle.Event event = (Lifecycle.Event) next.getValue();
                List list = this.f3608a.get(event);
                if (list == null) {
                    list = new ArrayList();
                    this.f3608a.put(event, list);
                }
                list.add(next.getKey());
            }
        }

        private static void a(List<C0029b> list, n nVar, Lifecycle.Event event, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(nVar, event, obj);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(n nVar, Lifecycle.Event event, Object obj) {
            a(this.f3608a.get(event), nVar, event, obj);
            a(this.f3608a.get(Lifecycle.Event.ON_ANY), nVar, event, obj);
        }
    }

    /* renamed from: androidx.lifecycle.b$b  reason: collision with other inner class name */
    static final class C0029b {

        /* renamed from: a  reason: collision with root package name */
        final int f3610a;

        /* renamed from: b  reason: collision with root package name */
        final Method f3611b;

        C0029b(int i2, Method method) {
            this.f3610a = i2;
            this.f3611b = method;
            method.setAccessible(true);
        }

        /* access modifiers changed from: package-private */
        public void a(n nVar, Lifecycle.Event event, Object obj) {
            try {
                int i2 = this.f3610a;
                if (i2 == 0) {
                    this.f3611b.invoke(obj, new Object[0]);
                } else if (i2 == 1) {
                    this.f3611b.invoke(obj, new Object[]{nVar});
                } else if (i2 == 2) {
                    this.f3611b.invoke(obj, new Object[]{nVar, event});
                }
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("Failed to call observer method", e2.getCause());
            } catch (IllegalAccessException e3) {
                throw new RuntimeException(e3);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0029b)) {
                return false;
            }
            C0029b bVar = (C0029b) obj;
            return this.f3610a == bVar.f3610a && this.f3611b.getName().equals(bVar.f3611b.getName());
        }

        public int hashCode() {
            return (this.f3610a * 31) + this.f3611b.getName().hashCode();
        }
    }

    b() {
    }

    private a a(Class<?> cls, Method[] methodArr) {
        int i2;
        a b2;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (!(superclass == null || (b2 = b(superclass)) == null)) {
            hashMap.putAll(b2.f3609b);
        }
        for (Class b3 : cls.getInterfaces()) {
            for (Map.Entry next : b(b3).f3609b.entrySet()) {
                a(hashMap, (C0029b) next.getKey(), (Lifecycle.Event) next.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = c(cls);
        }
        boolean z2 = false;
        for (Method method : methodArr) {
            u uVar = (u) method.getAnnotation(u.class);
            if (uVar != null) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i2 = 0;
                } else if (parameterTypes[0].isAssignableFrom(n.class)) {
                    i2 = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                Lifecycle.Event a2 = uVar.a();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(Lifecycle.Event.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (a2 == Lifecycle.Event.ON_ANY) {
                        i2 = 2;
                    } else {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (parameterTypes.length <= 2) {
                    a(hashMap, new C0029b(i2, method), a2, cls);
                    z2 = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        a aVar = new a(hashMap);
        this.f3606b.put(cls, aVar);
        this.f3607c.put(cls, Boolean.valueOf(z2));
        return aVar;
    }

    private void a(Map<C0029b, Lifecycle.Event> map, C0029b bVar, Lifecycle.Event event, Class<?> cls) {
        Lifecycle.Event event2 = map.get(bVar);
        if (event2 != null && event != event2) {
            Method method = bVar.f3611b;
            throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
        } else if (event2 == null) {
            map.put(bVar, event);
        }
    }

    private Method[] c(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e2) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(Class<?> cls) {
        Boolean bool = this.f3607c.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] c2 = c(cls);
        for (Method annotation : c2) {
            if (((u) annotation.getAnnotation(u.class)) != null) {
                a(cls, c2);
                return true;
            }
        }
        this.f3607c.put(cls, false);
        return false;
    }

    /* access modifiers changed from: package-private */
    public a b(Class<?> cls) {
        a aVar = this.f3606b.get(cls);
        return aVar != null ? aVar : a(cls, (Method[]) null);
    }
}
