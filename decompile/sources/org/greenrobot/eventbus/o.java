package org.greenrobot.eventbus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import ns.b;

class o {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Class<?>, List<n>> f14064a = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    private static final a[] f14065e = new a[4];

    /* renamed from: b  reason: collision with root package name */
    private List<b> f14066b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f14067c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f14068d;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final List<n> f14069a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        final Map<Class, Object> f14070b = new HashMap();

        /* renamed from: c  reason: collision with root package name */
        final Map<String, Class> f14071c = new HashMap();

        /* renamed from: d  reason: collision with root package name */
        final StringBuilder f14072d = new StringBuilder(128);

        /* renamed from: e  reason: collision with root package name */
        Class<?> f14073e;

        /* renamed from: f  reason: collision with root package name */
        Class<?> f14074f;

        /* renamed from: g  reason: collision with root package name */
        boolean f14075g;

        /* renamed from: h  reason: collision with root package name */
        ns.a f14076h;

        a() {
        }

        private boolean b(Method method, Class<?> cls) {
            this.f14072d.setLength(0);
            this.f14072d.append(method.getName());
            StringBuilder sb = this.f14072d;
            sb.append('>');
            sb.append(cls.getName());
            String sb2 = this.f14072d.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class put = this.f14071c.put(sb2, declaringClass);
            if (put == null || put.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.f14071c.put(sb2, put);
            return false;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f14069a.clear();
            this.f14070b.clear();
            this.f14071c.clear();
            this.f14072d.setLength(0);
            this.f14073e = null;
            this.f14074f = null;
            this.f14075g = false;
            this.f14076h = null;
        }

        /* access modifiers changed from: package-private */
        public void a(Class<?> cls) {
            this.f14074f = cls;
            this.f14073e = cls;
            this.f14075g = false;
            this.f14076h = null;
        }

        /* access modifiers changed from: package-private */
        public boolean a(Method method, Class<?> cls) {
            Object put = this.f14070b.put(cls, method);
            if (put == null) {
                return true;
            }
            if (put instanceof Method) {
                if (b((Method) put, cls)) {
                    this.f14070b.put(cls, this);
                } else {
                    throw new IllegalStateException();
                }
            }
            return b(method, cls);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (!this.f14075g) {
                Class<? super Object> superclass = this.f14074f.getSuperclass();
                this.f14074f = superclass;
                String name = superclass.getName();
                if (!name.startsWith("java.") && !name.startsWith("javax.") && !name.startsWith("android.") && !name.startsWith("androidx.")) {
                    return;
                }
            }
            this.f14074f = null;
        }
    }

    o(List<b> list, boolean z2, boolean z3) {
        this.f14066b = list;
        this.f14067c = z2;
        this.f14068d = z3;
    }

    private List<n> a(a aVar) {
        ArrayList arrayList = new ArrayList(aVar.f14069a);
        aVar.a();
        synchronized (f14065e) {
            int i2 = 0;
            while (true) {
                if (i2 >= 4) {
                    break;
                }
                a[] aVarArr = f14065e;
                if (aVarArr[i2] == null) {
                    aVarArr[i2] = aVar;
                    break;
                }
                i2++;
            }
        }
        return arrayList;
    }

    private a a() {
        synchronized (f14065e) {
            for (int i2 = 0; i2 < 4; i2++) {
                a[] aVarArr = f14065e;
                a aVar = aVarArr[i2];
                if (aVar != null) {
                    aVarArr[i2] = null;
                    return aVar;
                }
            }
            return new a();
        }
    }

    private List<n> b(Class<?> cls) {
        a a2 = a();
        a2.a(cls);
        while (a2.f14074f != null) {
            a2.f14076h = b(a2);
            if (a2.f14076h != null) {
                for (n nVar : a2.f14076h.b()) {
                    if (a2.a(nVar.f14058a, nVar.f14060c)) {
                        a2.f14069a.add(nVar);
                    }
                }
            } else {
                c(a2);
            }
            a2.b();
        }
        return a(a2);
    }

    private ns.a b(a aVar) {
        if (!(aVar.f14076h == null || aVar.f14076h.c() == null)) {
            ns.a c2 = aVar.f14076h.c();
            if (aVar.f14074f == c2.a()) {
                return c2;
            }
        }
        List<b> list = this.f14066b;
        if (list == null) {
            return null;
        }
        for (b a2 : list) {
            ns.a a3 = a2.a(aVar.f14074f);
            if (a3 != null) {
                return a3;
            }
        }
        return null;
    }

    private List<n> c(Class<?> cls) {
        a a2 = a();
        a2.a(cls);
        while (a2.f14074f != null) {
            c(a2);
            a2.b();
        }
        return a(a2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ee, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ef, code lost:
        r15 = "Could not inspect methods of " + r15.f14074f.getName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0108, code lost:
        if (r14.f14068d != false) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x010a, code lost:
        r1 = new java.lang.StringBuilder();
        r1.append(r15);
        r15 = ". Please consider using EventBus annotation processor to avoid reflection.";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0115, code lost:
        r1 = new java.lang.StringBuilder();
        r1.append(r15);
        r15 = ". Please make this class visible to EventBus annotation processor to avoid reflection.";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x011f, code lost:
        r1.append(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x012c, code lost:
        throw new org.greenrobot.eventbus.EventBusException(r1.toString(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
        r1 = r15.f14074f.getMethods();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000e, code lost:
        r15.f14075g = true;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0008 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(org.greenrobot.eventbus.o.a r15) {
        /*
            r14 = this;
            r0 = 1
            java.lang.Class<?> r1 = r15.f14074f     // Catch:{ all -> 0x0008 }
            java.lang.reflect.Method[] r1 = r1.getDeclaredMethods()     // Catch:{ all -> 0x0008 }
            goto L_0x0010
        L_0x0008:
            java.lang.Class<?> r1 = r15.f14074f     // Catch:{ LinkageError -> 0x00ee }
            java.lang.reflect.Method[] r1 = r1.getMethods()     // Catch:{ LinkageError -> 0x00ee }
            r15.f14075g = r0
        L_0x0010:
            int r2 = r1.length
            r3 = 0
            r4 = 0
        L_0x0013:
            if (r4 >= r2) goto L_0x00ed
            r6 = r1[r4]
            int r5 = r6.getModifiers()
            r7 = r5 & 1
            java.lang.String r8 = "."
            if (r7 == 0) goto L_0x00a7
            r5 = r5 & 5192(0x1448, float:7.276E-42)
            if (r5 != 0) goto L_0x00a7
            java.lang.Class[] r5 = r6.getParameterTypes()
            int r7 = r5.length
            if (r7 != r0) goto L_0x005b
            java.lang.Class<org.greenrobot.eventbus.l> r7 = org.greenrobot.eventbus.l.class
            java.lang.annotation.Annotation r7 = r6.getAnnotation(r7)
            org.greenrobot.eventbus.l r7 = (org.greenrobot.eventbus.l) r7
            if (r7 == 0) goto L_0x00e9
            r8 = r5[r3]
            boolean r5 = r15.a(r6, r8)
            if (r5 == 0) goto L_0x00e9
            org.greenrobot.eventbus.ThreadMode r9 = r7.a()
            java.util.List<org.greenrobot.eventbus.n> r11 = r15.f14069a
            org.greenrobot.eventbus.n r12 = new org.greenrobot.eventbus.n
            int r10 = r7.c()
            boolean r13 = r7.b()
            r5 = r12
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r13
            r5.<init>(r6, r7, r8, r9, r10)
            r11.add(r12)
            goto L_0x00e9
        L_0x005b:
            boolean r7 = r14.f14067c
            if (r7 == 0) goto L_0x00e9
            java.lang.Class<org.greenrobot.eventbus.l> r7 = org.greenrobot.eventbus.l.class
            boolean r7 = r6.isAnnotationPresent(r7)
            if (r7 != 0) goto L_0x0069
            goto L_0x00e9
        L_0x0069:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.Class r0 = r6.getDeclaringClass()
            java.lang.String r0 = r0.getName()
            r15.append(r0)
            r15.append(r8)
            java.lang.String r0 = r6.getName()
            r15.append(r0)
            java.lang.String r15 = r15.toString()
            org.greenrobot.eventbus.EventBusException r0 = new org.greenrobot.eventbus.EventBusException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "@Subscribe method "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r15 = "must have exactly 1 parameter but has "
            r1.append(r15)
            int r15 = r5.length
            r1.append(r15)
            java.lang.String r15 = r1.toString()
            r0.<init>(r15)
            throw r0
        L_0x00a7:
            boolean r5 = r14.f14067c
            if (r5 == 0) goto L_0x00e9
            java.lang.Class<org.greenrobot.eventbus.l> r5 = org.greenrobot.eventbus.l.class
            boolean r5 = r6.isAnnotationPresent(r5)
            if (r5 != 0) goto L_0x00b4
            goto L_0x00e9
        L_0x00b4:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.Class r0 = r6.getDeclaringClass()
            java.lang.String r0 = r0.getName()
            r15.append(r0)
            r15.append(r8)
            java.lang.String r0 = r6.getName()
            r15.append(r0)
            java.lang.String r15 = r15.toString()
            org.greenrobot.eventbus.EventBusException r0 = new org.greenrobot.eventbus.EventBusException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r15)
            java.lang.String r15 = " is a illegal @Subscribe method: must be public, non-static, and non-abstract"
            r1.append(r15)
            java.lang.String r15 = r1.toString()
            r0.<init>(r15)
            throw r0
        L_0x00e9:
            int r4 = r4 + 1
            goto L_0x0013
        L_0x00ed:
            return
        L_0x00ee:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Could not inspect methods of "
            r1.append(r2)
            java.lang.Class<?> r15 = r15.f14074f
            java.lang.String r15 = r15.getName()
            r1.append(r15)
            java.lang.String r15 = r1.toString()
            boolean r1 = r14.f14068d
            if (r1 == 0) goto L_0x0115
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r15)
            java.lang.String r15 = ". Please consider using EventBus annotation processor to avoid reflection."
            goto L_0x011f
        L_0x0115:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r15)
            java.lang.String r15 = ". Please make this class visible to EventBus annotation processor to avoid reflection."
        L_0x011f:
            r1.append(r15)
            java.lang.String r15 = r1.toString()
            org.greenrobot.eventbus.EventBusException r1 = new org.greenrobot.eventbus.EventBusException
            r1.<init>(r15, r0)
            goto L_0x012d
        L_0x012c:
            throw r1
        L_0x012d:
            goto L_0x012c
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.eventbus.o.c(org.greenrobot.eventbus.o$a):void");
    }

    /* access modifiers changed from: package-private */
    public List<n> a(Class<?> cls) {
        Map<Class<?>, List<n>> map = f14064a;
        List<n> list = map.get(cls);
        if (list != null) {
            return list;
        }
        List<n> c2 = this.f14068d ? c(cls) : b(cls);
        if (!c2.isEmpty()) {
            map.put(cls, c2);
            return c2;
        }
        throw new EventBusException("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
    }
}
