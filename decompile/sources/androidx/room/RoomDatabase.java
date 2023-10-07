package androidx.room;

import ag.c;
import ag.e;
import ag.f;
import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public abstract class RoomDatabase {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    protected volatile ag.b f4349a;

    /* renamed from: b  reason: collision with root package name */
    boolean f4350b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    protected List<b> f4351c;

    /* renamed from: d  reason: collision with root package name */
    private Executor f4352d;

    /* renamed from: e  reason: collision with root package name */
    private Executor f4353e;

    /* renamed from: f  reason: collision with root package name */
    private ag.c f4354f;

    /* renamed from: g  reason: collision with root package name */
    private final f f4355g = c();

    /* renamed from: h  reason: collision with root package name */
    private boolean f4356h;

    /* renamed from: i  reason: collision with root package name */
    private final ReentrantReadWriteLock f4357i = new ReentrantReadWriteLock();

    /* renamed from: j  reason: collision with root package name */
    private final ThreadLocal<Integer> f4358j = new ThreadLocal<>();

    /* renamed from: k  reason: collision with root package name */
    private final Map<String, Object> f4359k = new ConcurrentHashMap();

    public enum JournalMode {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        private static boolean a(ActivityManager activityManager) {
            if (Build.VERSION.SDK_INT >= 19) {
                return activityManager.isLowRamDevice();
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x000b, code lost:
            r3 = (android.app.ActivityManager) r3.getSystemService("activity");
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.room.RoomDatabase.JournalMode a(android.content.Context r3) {
            /*
                r2 = this;
                androidx.room.RoomDatabase$JournalMode r0 = AUTOMATIC
                if (r2 == r0) goto L_0x0005
                return r2
            L_0x0005:
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 16
                if (r0 < r1) goto L_0x001e
                java.lang.String r0 = "activity"
                java.lang.Object r3 = r3.getSystemService(r0)
                android.app.ActivityManager r3 = (android.app.ActivityManager) r3
                if (r3 == 0) goto L_0x001e
                boolean r3 = a((android.app.ActivityManager) r3)
                if (r3 != 0) goto L_0x001e
                androidx.room.RoomDatabase$JournalMode r3 = WRITE_AHEAD_LOGGING
                return r3
            L_0x001e:
                androidx.room.RoomDatabase$JournalMode r3 = TRUNCATE
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabase.JournalMode.a(android.content.Context):androidx.room.RoomDatabase$JournalMode");
        }
    }

    public static class a<T extends RoomDatabase> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f4364a;

        /* renamed from: b  reason: collision with root package name */
        private final String f4365b;

        /* renamed from: c  reason: collision with root package name */
        private final Context f4366c;

        /* renamed from: d  reason: collision with root package name */
        private ArrayList<b> f4367d;

        /* renamed from: e  reason: collision with root package name */
        private Executor f4368e;

        /* renamed from: f  reason: collision with root package name */
        private Executor f4369f;

        /* renamed from: g  reason: collision with root package name */
        private c.C0004c f4370g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f4371h;

        /* renamed from: i  reason: collision with root package name */
        private JournalMode f4372i = JournalMode.AUTOMATIC;

        /* renamed from: j  reason: collision with root package name */
        private boolean f4373j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f4374k = true;

        /* renamed from: l  reason: collision with root package name */
        private boolean f4375l;

        /* renamed from: m  reason: collision with root package name */
        private final c f4376m = new c();

        /* renamed from: n  reason: collision with root package name */
        private Set<Integer> f4377n;

        /* renamed from: o  reason: collision with root package name */
        private Set<Integer> f4378o;

        /* renamed from: p  reason: collision with root package name */
        private String f4379p;

        /* renamed from: q  reason: collision with root package name */
        private File f4380q;

        a(Context context, Class<T> cls, String str) {
            this.f4366c = context;
            this.f4364a = cls;
            this.f4365b = str;
        }

        public a<T> a() {
            this.f4371h = true;
            return this;
        }

        public a<T> a(c.C0004c cVar) {
            this.f4370g = cVar;
            return this;
        }

        public a<T> a(b bVar) {
            if (this.f4367d == null) {
                this.f4367d = new ArrayList<>();
            }
            this.f4367d.add(bVar);
            return this;
        }

        public a<T> a(Executor executor) {
            this.f4368e = executor;
            return this;
        }

        public a<T> a(ae.a... aVarArr) {
            if (this.f4378o == null) {
                this.f4378o = new HashSet();
            }
            for (ae.a aVar : aVarArr) {
                this.f4378o.add(Integer.valueOf(aVar.f59a));
                this.f4378o.add(Integer.valueOf(aVar.f60b));
            }
            this.f4376m.a(aVarArr);
            return this;
        }

        public a<T> b() {
            this.f4374k = false;
            this.f4375l = true;
            return this;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
            if (r1 != null) goto L_0x0018;
         */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x003d  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0067  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x007a  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00d4  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public T c() {
            /*
                r21 = this;
                r0 = r21
                android.content.Context r1 = r0.f4366c
                if (r1 == 0) goto L_0x00e4
                java.lang.Class<T> r1 = r0.f4364a
                if (r1 == 0) goto L_0x00dc
                java.util.concurrent.Executor r1 = r0.f4368e
                if (r1 != 0) goto L_0x001b
                java.util.concurrent.Executor r2 = r0.f4369f
                if (r2 != 0) goto L_0x001b
                java.util.concurrent.Executor r1 = g.a.b()
                r0.f4369f = r1
            L_0x0018:
                r0.f4368e = r1
                goto L_0x002b
            L_0x001b:
                if (r1 == 0) goto L_0x0024
                java.util.concurrent.Executor r2 = r0.f4369f
                if (r2 != 0) goto L_0x0024
                r0.f4369f = r1
                goto L_0x002b
            L_0x0024:
                if (r1 != 0) goto L_0x002b
                java.util.concurrent.Executor r1 = r0.f4369f
                if (r1 == 0) goto L_0x002b
                goto L_0x0018
            L_0x002b:
                java.util.Set<java.lang.Integer> r1 = r0.f4378o
                if (r1 == 0) goto L_0x0063
                java.util.Set<java.lang.Integer> r2 = r0.f4377n
                if (r2 == 0) goto L_0x0063
                java.util.Iterator r1 = r1.iterator()
            L_0x0037:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x0063
                java.lang.Object r2 = r1.next()
                java.lang.Integer r2 = (java.lang.Integer) r2
                java.util.Set<java.lang.Integer> r3 = r0.f4377n
                boolean r3 = r3.contains(r2)
                if (r3 != 0) goto L_0x004c
                goto L_0x0037
            L_0x004c:
                java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: "
                r3.append(r4)
                r3.append(r2)
                java.lang.String r2 = r3.toString()
                r1.<init>(r2)
                throw r1
            L_0x0063:
                ag.c$c r1 = r0.f4370g
                if (r1 != 0) goto L_0x006e
                ah.c r1 = new ah.c
                r1.<init>()
                r0.f4370g = r1
            L_0x006e:
                java.lang.String r1 = r0.f4379p
                if (r1 != 0) goto L_0x0076
                java.io.File r2 = r0.f4380q
                if (r2 == 0) goto L_0x0094
            L_0x0076:
                java.lang.String r2 = r0.f4365b
                if (r2 == 0) goto L_0x00d4
                if (r1 == 0) goto L_0x0089
                java.io.File r2 = r0.f4380q
                if (r2 != 0) goto L_0x0081
                goto L_0x0089
            L_0x0081:
                java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
                java.lang.String r2 = "Both createFromAsset() and createFromFile() was called on this Builder but the database can only be created using one of the two configurations."
                r1.<init>(r2)
                throw r1
            L_0x0089:
                androidx.room.m r2 = new androidx.room.m
                java.io.File r3 = r0.f4380q
                ag.c$c r4 = r0.f4370g
                r2.<init>(r1, r3, r4)
                r0.f4370g = r2
            L_0x0094:
                androidx.room.a r1 = new androidx.room.a
                android.content.Context r6 = r0.f4366c
                java.lang.String r7 = r0.f4365b
                ag.c$c r8 = r0.f4370g
                androidx.room.RoomDatabase$c r9 = r0.f4376m
                java.util.ArrayList<androidx.room.RoomDatabase$b> r10 = r0.f4367d
                boolean r11 = r0.f4371h
                androidx.room.RoomDatabase$JournalMode r2 = r0.f4372i
                androidx.room.RoomDatabase$JournalMode r12 = r2.a((android.content.Context) r6)
                java.util.concurrent.Executor r13 = r0.f4368e
                java.util.concurrent.Executor r14 = r0.f4369f
                boolean r15 = r0.f4373j
                boolean r2 = r0.f4374k
                boolean r3 = r0.f4375l
                java.util.Set<java.lang.Integer> r4 = r0.f4377n
                java.lang.String r5 = r0.f4379p
                r18 = r4
                java.io.File r4 = r0.f4380q
                r19 = r5
                r5 = r1
                r16 = r2
                r17 = r3
                r20 = r4
                r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
                java.lang.Class<T> r2 = r0.f4364a
                java.lang.String r3 = "_Impl"
                java.lang.Object r2 = androidx.room.h.a(r2, (java.lang.String) r3)
                androidx.room.RoomDatabase r2 = (androidx.room.RoomDatabase) r2
                r2.a((androidx.room.a) r1)
                return r2
            L_0x00d4:
                java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
                java.lang.String r2 = "Cannot create from asset or file for an in-memory database."
                r1.<init>(r2)
                throw r1
            L_0x00dc:
                java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
                java.lang.String r2 = "Must provide an abstract class that extends RoomDatabase"
                r1.<init>(r2)
                throw r1
            L_0x00e4:
                java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
                java.lang.String r2 = "Cannot provide null context for the database."
                r1.<init>(r2)
                goto L_0x00ed
            L_0x00ec:
                throw r1
            L_0x00ed:
                goto L_0x00ec
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabase.a.c():androidx.room.RoomDatabase");
        }
    }

    public static abstract class b {
        public void a(ag.b bVar) {
        }

        public void b(ag.b bVar) {
        }

        public void c(ag.b bVar) {
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private HashMap<Integer, TreeMap<Integer, ae.a>> f4381a = new HashMap<>();

        private List<ae.a> a(List<ae.a> list, boolean z2, int i2, int i3) {
            boolean z3;
            do {
                if (z2) {
                    if (i2 >= i3) {
                        return list;
                    }
                } else if (i2 <= i3) {
                    return list;
                }
                TreeMap treeMap = this.f4381a.get(Integer.valueOf(i2));
                if (treeMap != null) {
                    Iterator it2 = (z2 ? treeMap.descendingKeySet() : treeMap.keySet()).iterator();
                    while (true) {
                        z3 = true;
                        boolean z4 = false;
                        if (!it2.hasNext()) {
                            z3 = false;
                            continue;
                            break;
                        }
                        int intValue = ((Integer) it2.next()).intValue();
                        if (!z2 ? !(intValue < i3 || intValue >= i2) : !(intValue > i3 || intValue <= i2)) {
                            z4 = true;
                            continue;
                        }
                        if (z4) {
                            list.add(treeMap.get(Integer.valueOf(intValue)));
                            i2 = intValue;
                            continue;
                            break;
                        }
                    }
                } else {
                    return null;
                }
            } while (z3);
            return null;
        }

        private void a(ae.a aVar) {
            int i2 = aVar.f59a;
            int i3 = aVar.f60b;
            TreeMap treeMap = this.f4381a.get(Integer.valueOf(i2));
            if (treeMap == null) {
                treeMap = new TreeMap();
                this.f4381a.put(Integer.valueOf(i2), treeMap);
            }
            ae.a aVar2 = (ae.a) treeMap.get(Integer.valueOf(i3));
            if (aVar2 != null) {
                Log.w("ROOM", "Overriding migration " + aVar2 + " with " + aVar);
            }
            treeMap.put(Integer.valueOf(i3), aVar);
        }

        public List<ae.a> a(int i2, int i3) {
            if (i2 == i3) {
                return Collections.emptyList();
            }
            return a(new ArrayList(), i3 > i2, i2, i3);
        }

        public void a(ae.a... aVarArr) {
            for (ae.a a2 : aVarArr) {
                a(a2);
            }
        }
    }

    private static boolean l() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public f a(String str) {
        e();
        f();
        return this.f4354f.b().a(str);
    }

    public Cursor a(e eVar) {
        return a(eVar, (CancellationSignal) null);
    }

    public Cursor a(e eVar, CancellationSignal cancellationSignal) {
        e();
        f();
        return (cancellationSignal == null || Build.VERSION.SDK_INT < 16) ? this.f4354f.b().a(eVar) : this.f4354f.b().a(eVar, cancellationSignal);
    }

    /* access modifiers changed from: package-private */
    public Lock a() {
        return this.f4357i.readLock();
    }

    /* access modifiers changed from: protected */
    public void a(ag.b bVar) {
        this.f4355g.a(bVar);
    }

    public void a(a aVar) {
        ag.c b2 = b(aVar);
        this.f4354f = b2;
        if (b2 instanceof l) {
            ((l) b2).a(aVar);
        }
        boolean z2 = false;
        if (Build.VERSION.SDK_INT >= 16) {
            if (aVar.f4388g == JournalMode.WRITE_AHEAD_LOGGING) {
                z2 = true;
            }
            this.f4354f.a(z2);
        }
        this.f4351c = aVar.f4386e;
        this.f4352d = aVar.f4389h;
        this.f4353e = new o(aVar.f4390i);
        this.f4356h = aVar.f4387f;
        this.f4350b = z2;
        if (aVar.f4391j) {
            this.f4355g.a(aVar.f4383b, aVar.f4384c);
        }
    }

    public ag.c b() {
        return this.f4354f;
    }

    /* access modifiers changed from: protected */
    public abstract ag.c b(a aVar);

    /* access modifiers changed from: protected */
    public abstract f c();

    public boolean d() {
        ag.b bVar = this.f4349a;
        return bVar != null && bVar.e();
    }

    public void e() {
        if (!this.f4356h && l()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public void f() {
        if (!k() && this.f4358j.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    @Deprecated
    public void g() {
        e();
        ag.b b2 = this.f4354f.b();
        this.f4355g.b(b2);
        b2.a();
    }

    @Deprecated
    public void h() {
        this.f4354f.b().b();
        if (!k()) {
            this.f4355g.b();
        }
    }

    public Executor i() {
        return this.f4352d;
    }

    @Deprecated
    public void j() {
        this.f4354f.b().c();
    }

    public boolean k() {
        return this.f4354f.b().d();
    }
}
