package ir;

import android.util.Log;
import is.c;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class k implements Cloneable {

    /* renamed from: i  reason: collision with root package name */
    private static final l f29137i = new f();

    /* renamed from: j  reason: collision with root package name */
    private static final l f29138j = new d();

    /* renamed from: k  reason: collision with root package name */
    private static Class[] f29139k = {Float.TYPE, Float.class, Double.TYPE, Integer.TYPE, Double.class, Integer.class};

    /* renamed from: l  reason: collision with root package name */
    private static Class[] f29140l = {Integer.TYPE, Integer.class, Float.TYPE, Double.TYPE, Float.class, Double.class};

    /* renamed from: m  reason: collision with root package name */
    private static Class[] f29141m = {Double.TYPE, Double.class, Float.TYPE, Integer.TYPE, Float.class, Integer.class};

    /* renamed from: n  reason: collision with root package name */
    private static final HashMap<Class, HashMap<String, Method>> f29142n = new HashMap<>();

    /* renamed from: o  reason: collision with root package name */
    private static final HashMap<Class, HashMap<String, Method>> f29143o = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    String f29144a;

    /* renamed from: b  reason: collision with root package name */
    protected c f29145b;

    /* renamed from: c  reason: collision with root package name */
    Method f29146c;

    /* renamed from: d  reason: collision with root package name */
    Class f29147d;

    /* renamed from: e  reason: collision with root package name */
    h f29148e;

    /* renamed from: f  reason: collision with root package name */
    final ReentrantReadWriteLock f29149f;

    /* renamed from: g  reason: collision with root package name */
    final Object[] f29150g;

    /* renamed from: h  reason: collision with root package name */
    private Method f29151h;

    /* renamed from: p  reason: collision with root package name */
    private l f29152p;

    /* renamed from: q  reason: collision with root package name */
    private Object f29153q;

    static class a extends k {

        /* renamed from: h  reason: collision with root package name */
        e f29154h;

        /* renamed from: i  reason: collision with root package name */
        float f29155i;

        /* renamed from: j  reason: collision with root package name */
        private is.a f29156j;

        public a(c cVar, float... fArr) {
            super(cVar);
            a(fArr);
            if (cVar instanceof is.a) {
                this.f29156j = (is.a) this.f29145b;
            }
        }

        public a(String str, float... fArr) {
            super(str);
            a(fArr);
        }

        /* access modifiers changed from: package-private */
        public void a(float f2) {
            this.f29155i = this.f29154h.b(f2);
        }

        /* access modifiers changed from: package-private */
        public void a(Class cls) {
            if (this.f29145b == null) {
                k.super.a(cls);
            }
        }

        public void a(float... fArr) {
            k.super.a(fArr);
            this.f29154h = (e) this.f29148e;
        }

        /* access modifiers changed from: package-private */
        public void b(Object obj) {
            String str;
            is.a aVar = this.f29156j;
            if (aVar != null) {
                aVar.a(obj, this.f29155i);
                return;
            } else if (this.f29145b != null) {
                this.f29145b.a(obj, Float.valueOf(this.f29155i));
                return;
            } else if (this.f29146c != null) {
                try {
                    this.f29150g[0] = Float.valueOf(this.f29155i);
                    this.f29146c.invoke(obj, this.f29150g);
                    return;
                } catch (InvocationTargetException e2) {
                    str = e2.toString();
                } catch (IllegalAccessException e3) {
                    str = e3.toString();
                }
            } else {
                return;
            }
            Log.e("PropertyValuesHolder", str);
        }

        /* access modifiers changed from: package-private */
        public Object d() {
            return Float.valueOf(this.f29155i);
        }

        /* renamed from: e */
        public a clone() {
            a aVar = (a) k.super.clone();
            aVar.f29154h = (e) aVar.f29148e;
            return aVar;
        }
    }

    private k(c cVar) {
        this.f29146c = null;
        this.f29151h = null;
        this.f29148e = null;
        this.f29149f = new ReentrantReadWriteLock();
        this.f29150g = new Object[1];
        this.f29145b = cVar;
        if (cVar != null) {
            this.f29144a = cVar.a();
        }
    }

    private k(String str) {
        this.f29146c = null;
        this.f29151h = null;
        this.f29148e = null;
        this.f29149f = new ReentrantReadWriteLock();
        this.f29150g = new Object[1];
        this.f29144a = str;
    }

    public static k a(c<?, Float> cVar, float... fArr) {
        return new a((c) cVar, fArr);
    }

    public static k a(String str, float... fArr) {
        return new a(str, fArr);
    }

    static String a(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return str;
        }
        char upperCase = Character.toUpperCase(str2.charAt(0));
        String substring = str2.substring(1);
        return str + upperCase + substring;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:21|22|23|25|26|34|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0072, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007d, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0073 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.reflect.Method a(java.lang.Class r9, java.lang.String r10, java.lang.Class r11) {
        /*
            r8 = this;
            java.lang.String r0 = r8.f29144a
            java.lang.String r10 = a((java.lang.String) r10, (java.lang.String) r0)
            java.lang.String r0 = "PropertyValuesHolder"
            r1 = 0
            r2 = 1
            if (r11 != 0) goto L_0x0034
            java.lang.reflect.Method r9 = r9.getMethod(r10, r1)     // Catch:{ NoSuchMethodException -> 0x0012 }
            goto L_0x00a1
        L_0x0012:
            r11 = move-exception
            java.lang.reflect.Method r1 = r9.getDeclaredMethod(r10, r1)     // Catch:{ NoSuchMethodException -> 0x001c }
            r1.setAccessible(r2)     // Catch:{ NoSuchMethodException -> 0x001c }
            goto L_0x00a0
        L_0x001c:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Couldn't find no-arg method for property "
            r9.append(r10)
            java.lang.String r10 = r8.f29144a
            r9.append(r10)
            java.lang.String r10 = ": "
            r9.append(r10)
            r9.append(r11)
            goto L_0x0099
        L_0x0034:
            java.lang.Class[] r11 = new java.lang.Class[r2]
            java.lang.Class r3 = r8.f29147d
            java.lang.Class<java.lang.Float> r4 = java.lang.Float.class
            boolean r3 = r3.equals(r4)
            r4 = 0
            if (r3 == 0) goto L_0x0044
            java.lang.Class[] r3 = f29139k
            goto L_0x0064
        L_0x0044:
            java.lang.Class r3 = r8.f29147d
            java.lang.Class<java.lang.Integer> r5 = java.lang.Integer.class
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0051
            java.lang.Class[] r3 = f29140l
            goto L_0x0064
        L_0x0051:
            java.lang.Class r3 = r8.f29147d
            java.lang.Class<java.lang.Double> r5 = java.lang.Double.class
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x005e
            java.lang.Class[] r3 = f29141m
            goto L_0x0064
        L_0x005e:
            java.lang.Class[] r3 = new java.lang.Class[r2]
            java.lang.Class r5 = r8.f29147d
            r3[r4] = r5
        L_0x0064:
            int r5 = r3.length
            r6 = 0
        L_0x0066:
            if (r6 >= r5) goto L_0x0080
            r7 = r3[r6]
            r11[r4] = r7
            java.lang.reflect.Method r1 = r9.getMethod(r10, r11)     // Catch:{ NoSuchMethodException -> 0x0073 }
            r8.f29147d = r7     // Catch:{ NoSuchMethodException -> 0x0073 }
            return r1
        L_0x0073:
            java.lang.reflect.Method r1 = r9.getDeclaredMethod(r10, r11)     // Catch:{ NoSuchMethodException -> 0x007d }
            r1.setAccessible(r2)     // Catch:{ NoSuchMethodException -> 0x007d }
            r8.f29147d = r7     // Catch:{ NoSuchMethodException -> 0x007d }
            return r1
        L_0x007d:
            int r6 = r6 + 1
            goto L_0x0066
        L_0x0080:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Couldn't find setter/getter for property "
            r9.append(r10)
            java.lang.String r10 = r8.f29144a
            r9.append(r10)
            java.lang.String r10 = " with value type "
            r9.append(r10)
            java.lang.Class r10 = r8.f29147d
            r9.append(r10)
        L_0x0099:
            java.lang.String r9 = r9.toString()
            android.util.Log.e(r0, r9)
        L_0x00a0:
            r9 = r1
        L_0x00a1:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.k.a(java.lang.Class, java.lang.String, java.lang.Class):java.lang.reflect.Method");
    }

    private Method a(Class cls, HashMap<Class, HashMap<String, Method>> hashMap, String str, Class cls2) {
        try {
            this.f29149f.writeLock().lock();
            HashMap hashMap2 = hashMap.get(cls);
            Method method = hashMap2 != null ? (Method) hashMap2.get(this.f29144a) : null;
            if (method == null) {
                method = a(cls, str, cls2);
                if (hashMap2 == null) {
                    hashMap2 = new HashMap();
                    hashMap.put(cls, hashMap2);
                }
                hashMap2.put(this.f29144a, method);
            }
            return method;
        } finally {
            this.f29149f.writeLock().unlock();
        }
    }

    private void b(Class cls) {
        this.f29151h = a(cls, f29143o, "get", (Class) null);
    }

    /* renamed from: a */
    public k clone() {
        try {
            k kVar = (k) super.clone();
            kVar.f29144a = this.f29144a;
            kVar.f29145b = this.f29145b;
            kVar.f29148e = this.f29148e.clone();
            kVar.f29152p = this.f29152p;
            return kVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(float f2) {
        this.f29153q = this.f29148e.a(f2);
    }

    public void a(c cVar) {
        this.f29145b = cVar;
    }

    /* access modifiers changed from: package-private */
    public void a(Class cls) {
        this.f29146c = a(cls, f29142n, "set", this.f29147d);
    }

    /* access modifiers changed from: package-private */
    public void a(Object obj) {
        String str;
        c cVar = this.f29145b;
        if (cVar != null) {
            try {
                cVar.a(obj);
                Iterator<g> it2 = this.f29148e.f29117e.iterator();
                while (it2.hasNext()) {
                    g next = it2.next();
                    if (!next.a()) {
                        next.a(this.f29145b.a(obj));
                    }
                }
                return;
            } catch (ClassCastException unused) {
                Log.e("PropertyValuesHolder", "No such property (" + this.f29145b.a() + ") on target object " + obj + ". Trying reflection instead");
                this.f29145b = null;
            }
        }
        Class<?> cls = obj.getClass();
        if (this.f29146c == null) {
            a((Class) cls);
        }
        Iterator<g> it3 = this.f29148e.f29117e.iterator();
        while (it3.hasNext()) {
            g next2 = it3.next();
            if (!next2.a()) {
                if (this.f29151h == null) {
                    b((Class) cls);
                }
                try {
                    next2.a(this.f29151h.invoke(obj, new Object[0]));
                } catch (InvocationTargetException e2) {
                    str = e2.toString();
                } catch (IllegalAccessException e3) {
                    str = e3.toString();
                }
            }
        }
        return;
        Log.e("PropertyValuesHolder", str);
    }

    public void a(String str) {
        this.f29144a = str;
    }

    public void a(float... fArr) {
        this.f29147d = Float.TYPE;
        this.f29148e = h.a(fArr);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (this.f29152p == null) {
            Class<Float> cls = this.f29147d;
            this.f29152p = cls == Integer.class ? f29137i : cls == Float.class ? f29138j : null;
        }
        l lVar = this.f29152p;
        if (lVar != null) {
            this.f29148e.a(lVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Object obj) {
        String str;
        c cVar = this.f29145b;
        if (cVar != null) {
            cVar.a(obj, d());
        }
        if (this.f29146c != null) {
            try {
                this.f29150g[0] = d();
                this.f29146c.invoke(obj, this.f29150g);
                return;
            } catch (InvocationTargetException e2) {
                str = e2.toString();
            } catch (IllegalAccessException e3) {
                str = e3.toString();
            }
        } else {
            return;
        }
        Log.e("PropertyValuesHolder", str);
    }

    public String c() {
        return this.f29144a;
    }

    /* access modifiers changed from: package-private */
    public Object d() {
        return this.f29153q;
    }

    public String toString() {
        return this.f29144a + ": " + this.f29148e.toString();
    }
}
