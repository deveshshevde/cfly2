package androidx.room;

import ag.d;
import ag.e;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class k implements d, e {

    /* renamed from: g  reason: collision with root package name */
    static final TreeMap<Integer, k> f4453g = new TreeMap<>();

    /* renamed from: a  reason: collision with root package name */
    final long[] f4454a;

    /* renamed from: b  reason: collision with root package name */
    final double[] f4455b;

    /* renamed from: c  reason: collision with root package name */
    final String[] f4456c;

    /* renamed from: d  reason: collision with root package name */
    final byte[][] f4457d;

    /* renamed from: e  reason: collision with root package name */
    final int f4458e;

    /* renamed from: f  reason: collision with root package name */
    int f4459f;

    /* renamed from: h  reason: collision with root package name */
    private volatile String f4460h;

    /* renamed from: i  reason: collision with root package name */
    private final int[] f4461i;

    private k(int i2) {
        this.f4458e = i2;
        int i3 = i2 + 1;
        this.f4461i = new int[i3];
        this.f4454a = new long[i3];
        this.f4455b = new double[i3];
        this.f4456c = new String[i3];
        this.f4457d = new byte[i3][];
    }

    public static k a(String str, int i2) {
        TreeMap<Integer, k> treeMap = f4453g;
        synchronized (treeMap) {
            Map.Entry<Integer, k> ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i2));
            if (ceilingEntry != null) {
                treeMap.remove(ceilingEntry.getKey());
                k value = ceilingEntry.getValue();
                value.b(str, i2);
                return value;
            }
            k kVar = new k(i2);
            kVar.b(str, i2);
            return kVar;
        }
    }

    private static void c() {
        TreeMap<Integer, k> treeMap = f4453g;
        if (treeMap.size() > 15) {
            int size = treeMap.size() - 10;
            Iterator<Integer> it2 = treeMap.descendingKeySet().iterator();
            while (true) {
                int i2 = size - 1;
                if (size > 0) {
                    it2.next();
                    it2.remove();
                    size = i2;
                } else {
                    return;
                }
            }
        }
    }

    public void a() {
        TreeMap<Integer, k> treeMap = f4453g;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f4458e), this);
            c();
        }
    }

    public void a(int i2) {
        this.f4461i[i2] = 1;
    }

    public void a(int i2, double d2) {
        this.f4461i[i2] = 3;
        this.f4455b[i2] = d2;
    }

    public void a(int i2, long j2) {
        this.f4461i[i2] = 2;
        this.f4454a[i2] = j2;
    }

    public void a(int i2, String str) {
        this.f4461i[i2] = 4;
        this.f4456c[i2] = str;
    }

    public void a(int i2, byte[] bArr) {
        this.f4461i[i2] = 5;
        this.f4457d[i2] = bArr;
    }

    public void a(d dVar) {
        for (int i2 = 1; i2 <= this.f4459f; i2++) {
            int i3 = this.f4461i[i2];
            if (i3 == 1) {
                dVar.a(i2);
            } else if (i3 == 2) {
                dVar.a(i2, this.f4454a[i2]);
            } else if (i3 == 3) {
                dVar.a(i2, this.f4455b[i2]);
            } else if (i3 == 4) {
                dVar.a(i2, this.f4456c[i2]);
            } else if (i3 == 5) {
                dVar.a(i2, this.f4457d[i2]);
            }
        }
    }

    public String b() {
        return this.f4460h;
    }

    /* access modifiers changed from: package-private */
    public void b(String str, int i2) {
        this.f4460h = str;
        this.f4459f = i2;
    }

    public void close() {
    }
}
