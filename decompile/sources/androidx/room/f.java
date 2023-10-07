package androidx.room;

import ag.e;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

public class f {

    /* renamed from: h  reason: collision with root package name */
    private static final String[] f4401h = {"UPDATE", "DELETE", "INSERT"};

    /* renamed from: a  reason: collision with root package name */
    final HashMap<String, Integer> f4402a;

    /* renamed from: b  reason: collision with root package name */
    final String[] f4403b;

    /* renamed from: c  reason: collision with root package name */
    final RoomDatabase f4404c;

    /* renamed from: d  reason: collision with root package name */
    AtomicBoolean f4405d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    volatile ag.f f4406e;

    /* renamed from: f  reason: collision with root package name */
    final h.b<b, c> f4407f = new h.b<>();

    /* renamed from: g  reason: collision with root package name */
    Runnable f4408g = new Runnable() {
        /* JADX INFO: finally extract failed */
        private Set<Integer> a() {
            HashSet hashSet = new HashSet();
            Cursor a2 = f.this.f4404c.a((e) new ag.a("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
            while (a2.moveToNext()) {
                try {
                    hashSet.add(Integer.valueOf(a2.getInt(0)));
                } catch (Throwable th) {
                    a2.close();
                    throw th;
                }
            }
            a2.close();
            if (!hashSet.isEmpty()) {
                f.this.f4406e.a();
            }
            return hashSet;
        }

        public void run() {
            ag.b b2;
            Lock a2 = f.this.f4404c.a();
            Set<Integer> set = null;
            try {
                a2.lock();
                if (!f.this.a()) {
                    a2.unlock();
                } else if (!f.this.f4405d.compareAndSet(true, false)) {
                    a2.unlock();
                } else if (f.this.f4404c.k()) {
                    a2.unlock();
                } else {
                    if (f.this.f4404c.f4350b) {
                        b2 = f.this.f4404c.b().b();
                        b2.a();
                        set = a();
                        b2.c();
                        b2.b();
                    } else {
                        set = a();
                    }
                    a2.unlock();
                    if (set != null && !set.isEmpty()) {
                        synchronized (f.this.f4407f) {
                            Iterator<Map.Entry<b, c>> it2 = f.this.f4407f.iterator();
                            while (it2.hasNext()) {
                                ((c) it2.next().getValue()).a(set);
                            }
                        }
                    }
                }
            } catch (SQLiteException | IllegalStateException e2) {
                try {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e2);
                } catch (Throwable th) {
                    a2.unlock();
                    throw th;
                }
            } catch (Throwable th2) {
                b2.b();
                throw th2;
            }
        }
    };

    /* renamed from: i  reason: collision with root package name */
    private Map<String, Set<String>> f4409i;

    /* renamed from: j  reason: collision with root package name */
    private volatile boolean f4410j = false;

    /* renamed from: k  reason: collision with root package name */
    private a f4411k;

    /* renamed from: l  reason: collision with root package name */
    private final e f4412l;

    /* renamed from: m  reason: collision with root package name */
    private g f4413m;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final long[] f4415a;

        /* renamed from: b  reason: collision with root package name */
        final boolean[] f4416b;

        /* renamed from: c  reason: collision with root package name */
        final int[] f4417c;

        /* renamed from: d  reason: collision with root package name */
        boolean f4418d;

        /* renamed from: e  reason: collision with root package name */
        boolean f4419e;

        a(int i2) {
            long[] jArr = new long[i2];
            this.f4415a = jArr;
            boolean[] zArr = new boolean[i2];
            this.f4416b = zArr;
            this.f4417c = new int[i2];
            Arrays.fill(jArr, 0);
            Arrays.fill(zArr, false);
        }

        /* access modifiers changed from: package-private */
        public boolean a(int... iArr) {
            boolean z2;
            synchronized (this) {
                z2 = false;
                for (int i2 : iArr) {
                    long[] jArr = this.f4415a;
                    long j2 = jArr[i2];
                    jArr[i2] = 1 + j2;
                    if (j2 == 0) {
                        this.f4418d = true;
                        z2 = true;
                    }
                }
            }
            return z2;
        }

        /* access modifiers changed from: package-private */
        public int[] a() {
            synchronized (this) {
                if (this.f4418d) {
                    if (!this.f4419e) {
                        int length = this.f4415a.length;
                        int i2 = 0;
                        while (true) {
                            int i3 = 1;
                            if (i2 < length) {
                                boolean z2 = this.f4415a[i2] > 0;
                                boolean[] zArr = this.f4416b;
                                if (z2 != zArr[i2]) {
                                    int[] iArr = this.f4417c;
                                    if (!z2) {
                                        i3 = 2;
                                    }
                                    iArr[i2] = i3;
                                } else {
                                    this.f4417c[i2] = 0;
                                }
                                zArr[i2] = z2;
                                i2++;
                            } else {
                                this.f4419e = true;
                                this.f4418d = false;
                                int[] iArr2 = this.f4417c;
                                return iArr2;
                            }
                        }
                    }
                }
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            synchronized (this) {
                this.f4419e = false;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(int... iArr) {
            boolean z2;
            synchronized (this) {
                z2 = false;
                for (int i2 : iArr) {
                    long[] jArr = this.f4415a;
                    long j2 = jArr[i2];
                    jArr[i2] = j2 - 1;
                    if (j2 == 1) {
                        this.f4418d = true;
                        z2 = true;
                    }
                }
            }
            return z2;
        }
    }

    public static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        final String[] f4420a;

        public b(String[] strArr) {
            this.f4420a = (String[]) Arrays.copyOf(strArr, strArr.length);
        }

        public abstract void a(Set<String> set);

        /* access modifiers changed from: package-private */
        public boolean a() {
            return false;
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        final int[] f4421a;

        /* renamed from: b  reason: collision with root package name */
        final b f4422b;

        /* renamed from: c  reason: collision with root package name */
        private final String[] f4423c;

        /* renamed from: d  reason: collision with root package name */
        private final Set<String> f4424d;

        c(b bVar, int[] iArr, String[] strArr) {
            Set<String> set;
            this.f4422b = bVar;
            this.f4421a = iArr;
            this.f4423c = strArr;
            if (iArr.length == 1) {
                HashSet hashSet = new HashSet();
                hashSet.add(strArr[0]);
                set = Collections.unmodifiableSet(hashSet);
            } else {
                set = null;
            }
            this.f4424d = set;
        }

        /* access modifiers changed from: package-private */
        public void a(Set<Integer> set) {
            int length = this.f4421a.length;
            Set set2 = null;
            for (int i2 = 0; i2 < length; i2++) {
                if (set.contains(Integer.valueOf(this.f4421a[i2]))) {
                    if (length == 1) {
                        set2 = this.f4424d;
                    } else {
                        if (set2 == null) {
                            set2 = new HashSet(length);
                        }
                        set2.add(this.f4423c[i2]);
                    }
                }
            }
            if (set2 != null) {
                this.f4422b.a(set2);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(String[] strArr) {
            Set<String> set = null;
            if (this.f4423c.length == 1) {
                int length = strArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (strArr[i2].equalsIgnoreCase(this.f4423c[0])) {
                        set = this.f4424d;
                        break;
                    } else {
                        i2++;
                    }
                }
            } else {
                HashSet hashSet = new HashSet();
                for (String str : strArr) {
                    String[] strArr2 = this.f4423c;
                    int length2 = strArr2.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length2) {
                            break;
                        }
                        String str2 = strArr2[i3];
                        if (str2.equalsIgnoreCase(str)) {
                            hashSet.add(str2);
                            break;
                        }
                        i3++;
                    }
                }
                if (hashSet.size() > 0) {
                    set = hashSet;
                }
            }
            if (set != null) {
                this.f4422b.a(set);
            }
        }
    }

    public f(RoomDatabase roomDatabase, Map<String, String> map, Map<String, Set<String>> map2, String... strArr) {
        this.f4404c = roomDatabase;
        this.f4411k = new a(strArr.length);
        this.f4402a = new HashMap<>();
        this.f4409i = map2;
        this.f4412l = new e(roomDatabase);
        int length = strArr.length;
        this.f4403b = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            String lowerCase = strArr[i2].toLowerCase(Locale.US);
            this.f4402a.put(lowerCase, Integer.valueOf(i2));
            String str = map.get(strArr[i2]);
            if (str != null) {
                this.f4403b[i2] = str.toLowerCase(Locale.US);
            } else {
                this.f4403b[i2] = lowerCase;
            }
        }
        for (Map.Entry next : map.entrySet()) {
            String lowerCase2 = ((String) next.getValue()).toLowerCase(Locale.US);
            if (this.f4402a.containsKey(lowerCase2)) {
                String lowerCase3 = ((String) next.getKey()).toLowerCase(Locale.US);
                HashMap<String, Integer> hashMap = this.f4402a;
                hashMap.put(lowerCase3, hashMap.get(lowerCase2));
            }
        }
    }

    private void a(ag.b bVar, int i2) {
        String str = this.f4403b[i2];
        StringBuilder sb = new StringBuilder();
        for (String a2 : f4401h) {
            sb.setLength(0);
            sb.append("DROP TRIGGER IF EXISTS ");
            a(sb, str, a2);
            bVar.c(sb.toString());
        }
    }

    private static void a(StringBuilder sb, String str, String str2) {
        sb.append("`");
        sb.append("room_table_modification_trigger_");
        sb.append(str);
        sb.append("_");
        sb.append(str2);
        sb.append("`");
    }

    private void b(ag.b bVar, int i2) {
        bVar.c("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i2 + ", 0)");
        String str = this.f4403b[i2];
        StringBuilder sb = new StringBuilder();
        for (String str2 : f4401h) {
            sb.setLength(0);
            sb.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            a(sb, str, str2);
            sb.append(" AFTER ");
            sb.append(str2);
            sb.append(" ON `");
            sb.append(str);
            sb.append("` BEGIN UPDATE ");
            sb.append("room_table_modification_log");
            sb.append(" SET ");
            sb.append("invalidated");
            sb.append(" = 1");
            sb.append(" WHERE ");
            sb.append("table_id");
            sb.append(" = ");
            sb.append(i2);
            sb.append(" AND ");
            sb.append("invalidated");
            sb.append(" = 0");
            sb.append("; END");
            bVar.c(sb.toString());
        }
    }

    private String[] b(String[] strArr) {
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (this.f4409i.containsKey(lowerCase)) {
                hashSet.addAll(this.f4409i.get(lowerCase));
            } else {
                hashSet.add(str);
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    /* access modifiers changed from: package-private */
    public void a(ag.b bVar) {
        synchronized (this) {
            if (this.f4410j) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            bVar.c("PRAGMA temp_store = MEMORY;");
            bVar.c("PRAGMA recursive_triggers='ON';");
            bVar.c("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            b(bVar);
            this.f4406e = bVar.a("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ");
            this.f4410j = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, String str) {
        this.f4413m = new g(context, str, this, this.f4404c.i());
    }

    public void a(b bVar) {
        c a2;
        String[] b2 = b(bVar.f4420a);
        int[] iArr = new int[b2.length];
        int length = b2.length;
        int i2 = 0;
        while (i2 < length) {
            Integer num = this.f4402a.get(b2[i2].toLowerCase(Locale.US));
            if (num != null) {
                iArr[i2] = num.intValue();
                i2++;
            } else {
                throw new IllegalArgumentException("There is no table with name " + b2[i2]);
            }
        }
        c cVar = new c(bVar, iArr, b2);
        synchronized (this.f4407f) {
            a2 = this.f4407f.a(bVar, cVar);
        }
        if (a2 == null && this.f4411k.a(iArr)) {
            c();
        }
    }

    public void a(String... strArr) {
        synchronized (this.f4407f) {
            Iterator<Map.Entry<b, c>> it2 = this.f4407f.iterator();
            while (it2.hasNext()) {
                Map.Entry next = it2.next();
                if (!((b) next.getKey()).a()) {
                    ((c) next.getValue()).a(strArr);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        if (!this.f4404c.d()) {
            return false;
        }
        if (!this.f4410j) {
            this.f4404c.b().b();
        }
        if (this.f4410j) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    public void b() {
        if (this.f4405d.compareAndSet(false, true)) {
            this.f4404c.i().execute(this.f4408g);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(ag.b bVar) {
        if (!bVar.d()) {
            while (true) {
                try {
                    Lock a2 = this.f4404c.a();
                    a2.lock();
                    try {
                        int[] a3 = this.f4411k.a();
                        if (a3 == null) {
                            a2.unlock();
                            return;
                        }
                        int length = a3.length;
                        bVar.a();
                        for (int i2 = 0; i2 < length; i2++) {
                            int i3 = a3[i2];
                            if (i3 == 1) {
                                b(bVar, i2);
                            } else if (i3 == 2) {
                                a(bVar, i2);
                            }
                        }
                        bVar.c();
                        bVar.b();
                        this.f4411k.b();
                        a2.unlock();
                    } catch (Throwable th) {
                        a2.unlock();
                        throw th;
                    }
                } catch (SQLiteException | IllegalStateException e2) {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e2);
                    return;
                }
            }
        }
    }

    public void b(b bVar) {
        c b2;
        synchronized (this.f4407f) {
            b2 = this.f4407f.b(bVar);
        }
        if (b2 != null && this.f4411k.b(b2.f4421a)) {
            c();
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.f4404c.d()) {
            b(this.f4404c.b().b());
        }
    }
}
