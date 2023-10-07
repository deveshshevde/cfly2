package org.greenrobot.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f13998a = "EventBus";

    /* renamed from: b  reason: collision with root package name */
    static volatile c f13999b;

    /* renamed from: c  reason: collision with root package name */
    private static final d f14000c = new d();

    /* renamed from: d  reason: collision with root package name */
    private static final Map<Class<?>, List<Class<?>>> f14001d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final Map<Class<?>, CopyOnWriteArrayList<p>> f14002e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<Object, List<Class<?>>> f14003f;

    /* renamed from: g  reason: collision with root package name */
    private final Map<Class<?>, Object> f14004g;

    /* renamed from: h  reason: collision with root package name */
    private final ThreadLocal<a> f14005h;

    /* renamed from: i  reason: collision with root package name */
    private final g f14006i;

    /* renamed from: j  reason: collision with root package name */
    private final k f14007j;

    /* renamed from: k  reason: collision with root package name */
    private final b f14008k;

    /* renamed from: l  reason: collision with root package name */
    private final a f14009l;

    /* renamed from: m  reason: collision with root package name */
    private final o f14010m;

    /* renamed from: n  reason: collision with root package name */
    private final ExecutorService f14011n;

    /* renamed from: o  reason: collision with root package name */
    private final boolean f14012o;

    /* renamed from: p  reason: collision with root package name */
    private final boolean f14013p;

    /* renamed from: q  reason: collision with root package name */
    private final boolean f14014q;

    /* renamed from: r  reason: collision with root package name */
    private final boolean f14015r;

    /* renamed from: s  reason: collision with root package name */
    private final boolean f14016s;

    /* renamed from: t  reason: collision with root package name */
    private final boolean f14017t;

    /* renamed from: u  reason: collision with root package name */
    private final int f14018u;

    /* renamed from: v  reason: collision with root package name */
    private final f f14019v;

    /* renamed from: org.greenrobot.eventbus.c$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14021a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.greenrobot.eventbus.ThreadMode[] r0 = org.greenrobot.eventbus.ThreadMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14021a = r0
                org.greenrobot.eventbus.ThreadMode r1 = org.greenrobot.eventbus.ThreadMode.POSTING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f14021a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.greenrobot.eventbus.ThreadMode r1 = org.greenrobot.eventbus.ThreadMode.MAIN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f14021a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.greenrobot.eventbus.ThreadMode r1 = org.greenrobot.eventbus.ThreadMode.MAIN_ORDERED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f14021a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.greenrobot.eventbus.ThreadMode r1 = org.greenrobot.eventbus.ThreadMode.BACKGROUND     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f14021a     // Catch:{ NoSuchFieldError -> 0x003e }
                org.greenrobot.eventbus.ThreadMode r1 = org.greenrobot.eventbus.ThreadMode.ASYNC     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.eventbus.c.AnonymousClass2.<clinit>():void");
        }
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final List<Object> f14022a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        boolean f14023b;

        /* renamed from: c  reason: collision with root package name */
        boolean f14024c;

        /* renamed from: d  reason: collision with root package name */
        p f14025d;

        /* renamed from: e  reason: collision with root package name */
        Object f14026e;

        /* renamed from: f  reason: collision with root package name */
        boolean f14027f;

        a() {
        }
    }

    public c() {
        this(f14000c);
    }

    c(d dVar) {
        this.f14005h = new ThreadLocal<a>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public a initialValue() {
                return new a();
            }
        };
        this.f14019v = dVar.a();
        this.f14002e = new HashMap();
        this.f14003f = new HashMap();
        this.f14004g = new ConcurrentHashMap();
        g b2 = dVar.b();
        this.f14006i = b2;
        this.f14007j = b2 != null ? b2.a(this) : null;
        this.f14008k = new b(this);
        this.f14009l = new a(this);
        this.f14018u = dVar.f14038j != null ? dVar.f14038j.size() : 0;
        this.f14010m = new o(dVar.f14038j, dVar.f14036h, dVar.f14035g);
        this.f14013p = dVar.f14029a;
        this.f14014q = dVar.f14030b;
        this.f14015r = dVar.f14031c;
        this.f14016s = dVar.f14032d;
        this.f14012o = dVar.f14033e;
        this.f14017t = dVar.f14034f;
        this.f14011n = dVar.f14037i;
    }

    private static List<Class<?>> a(Class<?> cls) {
        List<Class<?>> list;
        Map<Class<?>, List<Class<?>>> map = f14001d;
        synchronized (map) {
            list = map.get(cls);
            if (list == null) {
                list = new ArrayList<>();
                for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    a(list, (Class<?>[]) cls2.getInterfaces());
                }
                f14001d.put(cls, list);
            }
        }
        return list;
    }

    public static c a() {
        c cVar = f13999b;
        if (cVar == null) {
            synchronized (c.class) {
                cVar = f13999b;
                if (cVar == null) {
                    cVar = new c();
                    f13999b = cVar;
                }
            }
        }
        return cVar;
    }

    private void a(Object obj, Class<?> cls) {
        List list = this.f14002e.get(cls);
        if (list != null) {
            int size = list.size();
            int i2 = 0;
            while (i2 < size) {
                p pVar = (p) list.get(i2);
                if (pVar.f14077a == obj) {
                    pVar.f14079c = false;
                    list.remove(i2);
                    i2--;
                    size--;
                }
                i2++;
            }
        }
    }

    private void a(Object obj, a aVar) throws Error {
        boolean z2;
        Class<?> cls = obj.getClass();
        if (this.f14017t) {
            List<Class<?>> a2 = a(cls);
            int size = a2.size();
            z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                z2 |= a(obj, aVar, a2.get(i2));
            }
        } else {
            z2 = a(obj, aVar, cls);
        }
        if (!z2) {
            if (this.f14014q) {
                f fVar = this.f14019v;
                Level level = Level.FINE;
                fVar.a(level, "No subscribers registered for event " + cls);
            }
            if (this.f14016s && cls != h.class && cls != m.class) {
                d(new h(this, obj));
            }
        }
    }

    private void a(Object obj, n nVar) {
        Class<?> cls = nVar.f14060c;
        p pVar = new p(obj, nVar);
        CopyOnWriteArrayList copyOnWriteArrayList = this.f14002e.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.f14002e.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(pVar)) {
            throw new EventBusException("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 > size) {
                break;
            } else if (i2 == size || nVar.f14061d > ((p) copyOnWriteArrayList.get(i2)).f14078b.f14061d) {
                copyOnWriteArrayList.add(i2, pVar);
            } else {
                i2++;
            }
        }
        copyOnWriteArrayList.add(i2, pVar);
        List list = this.f14003f.get(obj);
        if (list == null) {
            list = new ArrayList();
            this.f14003f.put(obj, list);
        }
        list.add(cls);
        if (!nVar.f14062e) {
            return;
        }
        if (this.f14017t) {
            for (Map.Entry next : this.f14004g.entrySet()) {
                if (cls.isAssignableFrom((Class) next.getKey())) {
                    b(pVar, next.getValue());
                }
            }
            return;
        }
        b(pVar, this.f14004g.get(cls));
    }

    static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, (Class<?>[]) cls.getInterfaces());
            }
        }
    }

    private void a(p pVar, Object obj, Throwable th) {
        if (obj instanceof m) {
            if (this.f14013p) {
                f fVar = this.f14019v;
                Level level = Level.SEVERE;
                fVar.a(level, "SubscriberExceptionEvent subscriber " + pVar.f14077a.getClass() + " threw an exception", th);
                m mVar = (m) obj;
                f fVar2 = this.f14019v;
                Level level2 = Level.SEVERE;
                fVar2.a(level2, "Initial event " + mVar.f14056c + " caused exception in " + mVar.f14057d, mVar.f14055b);
            }
        } else if (!this.f14012o) {
            if (this.f14013p) {
                f fVar3 = this.f14019v;
                Level level3 = Level.SEVERE;
                fVar3.a(level3, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + pVar.f14077a.getClass(), th);
            }
            if (this.f14015r) {
                d(new m(this, th, obj, pVar.f14077a));
            }
        } else {
            throw new EventBusException("Invoking subscriber failed", th);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
        if (r5 != null) goto L_0x004e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(org.greenrobot.eventbus.p r3, java.lang.Object r4, boolean r5) {
        /*
            r2 = this;
            int[] r0 = org.greenrobot.eventbus.c.AnonymousClass2.f14021a
            org.greenrobot.eventbus.n r1 = r3.f14078b
            org.greenrobot.eventbus.ThreadMode r1 = r1.f14059b
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 1
            if (r0 == r1) goto L_0x0052
            r1 = 2
            if (r0 == r1) goto L_0x0049
            r1 = 3
            if (r0 == r1) goto L_0x0044
            r1 = 4
            if (r0 == r1) goto L_0x003c
            r5 = 5
            if (r0 != r5) goto L_0x0021
            org.greenrobot.eventbus.a r5 = r2.f14009l
            r5.a(r3, r4)
            goto L_0x0055
        L_0x0021:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "Unknown thread mode: "
            r5.append(r0)
            org.greenrobot.eventbus.n r3 = r3.f14078b
            org.greenrobot.eventbus.ThreadMode r3 = r3.f14059b
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            r4.<init>(r3)
            throw r4
        L_0x003c:
            if (r5 == 0) goto L_0x0052
            org.greenrobot.eventbus.b r5 = r2.f14008k
            r5.a(r3, r4)
            goto L_0x0055
        L_0x0044:
            org.greenrobot.eventbus.k r5 = r2.f14007j
            if (r5 == 0) goto L_0x0052
            goto L_0x004e
        L_0x0049:
            if (r5 == 0) goto L_0x004c
            goto L_0x0052
        L_0x004c:
            org.greenrobot.eventbus.k r5 = r2.f14007j
        L_0x004e:
            r5.a(r3, r4)
            goto L_0x0055
        L_0x0052:
            r2.a((org.greenrobot.eventbus.p) r3, (java.lang.Object) r4)
        L_0x0055:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.eventbus.c.a(org.greenrobot.eventbus.p, java.lang.Object, boolean):void");
    }

    private boolean a(Object obj, a aVar, Class<?> cls) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.f14002e.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it2 = copyOnWriteArrayList.iterator();
        while (it2.hasNext()) {
            p pVar = (p) it2.next();
            aVar.f14026e = obj;
            aVar.f14025d = pVar;
            try {
                a(pVar, obj, aVar.f14024c);
                if (aVar.f14027f) {
                    return true;
                }
            } finally {
                aVar.f14026e = null;
                aVar.f14025d = null;
                aVar.f14027f = false;
            }
        }
        return true;
    }

    public static d b() {
        return new d();
    }

    private void b(p pVar, Object obj) {
        if (obj != null) {
            a(pVar, obj, e());
        }
    }

    private boolean e() {
        g gVar = this.f14006i;
        return gVar == null || gVar.a();
    }

    public void a(Object obj) {
        List<n> a2 = this.f14010m.a(obj.getClass());
        synchronized (this) {
            for (n a3 : a2) {
                a(obj, a3);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(i iVar) {
        Object obj = iVar.f14049a;
        p pVar = iVar.f14050b;
        i.a(iVar);
        if (pVar.f14079c) {
            a(pVar, obj);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(p pVar, Object obj) {
        try {
            pVar.f14078b.f14058a.invoke(pVar.f14077a, new Object[]{obj});
        } catch (InvocationTargetException e2) {
            a(pVar, obj, e2.getCause());
        } catch (IllegalAccessException e3) {
            throw new IllegalStateException("Unexpected exception", e3);
        }
    }

    public synchronized boolean b(Object obj) {
        return this.f14003f.containsKey(obj);
    }

    /* access modifiers changed from: package-private */
    public ExecutorService c() {
        return this.f14011n;
    }

    public synchronized void c(Object obj) {
        List<Class> list = this.f14003f.get(obj);
        if (list != null) {
            for (Class a2 : list) {
                a(obj, (Class<?>) a2);
            }
            this.f14003f.remove(obj);
        } else {
            f fVar = this.f14019v;
            Level level = Level.WARNING;
            fVar.a(level, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    public f d() {
        return this.f14019v;
    }

    public void d(Object obj) {
        a aVar = this.f14005h.get();
        List<Object> list = aVar.f14022a;
        list.add(obj);
        if (!aVar.f14023b) {
            aVar.f14024c = e();
            aVar.f14023b = true;
            if (!aVar.f14027f) {
                while (!list.isEmpty()) {
                    try {
                        a(list.remove(0), aVar);
                    } finally {
                        aVar.f14023b = false;
                        aVar.f14024c = false;
                    }
                }
                return;
            }
            throw new EventBusException("Internal error. Abort state was not reset");
        }
    }

    public void e(Object obj) {
        synchronized (this.f14004g) {
            this.f14004g.put(obj.getClass(), obj);
        }
        d(obj);
    }

    public String toString() {
        return "EventBus[indexCount=" + this.f14018u + ", eventInheritance=" + this.f14017t + "]";
    }
}
