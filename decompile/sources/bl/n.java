package bl;

import android.graphics.Bitmap;
import android.os.Build;
import cc.l;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class n implements l {

    /* renamed from: a  reason: collision with root package name */
    private static final Bitmap.Config[] f5781a;

    /* renamed from: b  reason: collision with root package name */
    private static final Bitmap.Config[] f5782b;

    /* renamed from: c  reason: collision with root package name */
    private static final Bitmap.Config[] f5783c = {Bitmap.Config.RGB_565};

    /* renamed from: d  reason: collision with root package name */
    private static final Bitmap.Config[] f5784d = {Bitmap.Config.ARGB_4444};

    /* renamed from: e  reason: collision with root package name */
    private static final Bitmap.Config[] f5785e = {Bitmap.Config.ALPHA_8};

    /* renamed from: f  reason: collision with root package name */
    private final b f5786f = new b();

    /* renamed from: g  reason: collision with root package name */
    private final h<a, Bitmap> f5787g = new h<>();

    /* renamed from: h  reason: collision with root package name */
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f5788h = new HashMap();

    /* renamed from: bl.n$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5789a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                android.graphics.Bitmap$Config[] r0 = android.graphics.Bitmap.Config.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5789a = r0
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f5789a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f5789a     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_4444     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f5789a     // Catch:{ NoSuchFieldError -> 0x0033 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ALPHA_8     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: bl.n.AnonymousClass1.<clinit>():void");
        }
    }

    static final class a implements m {

        /* renamed from: a  reason: collision with root package name */
        int f5790a;

        /* renamed from: b  reason: collision with root package name */
        private final b f5791b;

        /* renamed from: c  reason: collision with root package name */
        private Bitmap.Config f5792c;

        public a(b bVar) {
            this.f5791b = bVar;
        }

        public void a() {
            this.f5791b.a(this);
        }

        public void a(int i2, Bitmap.Config config) {
            this.f5790a = i2;
            this.f5792c = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f5790a == aVar.f5790a && l.a((Object) this.f5792c, (Object) aVar.f5792c);
        }

        public int hashCode() {
            int i2 = this.f5790a * 31;
            Bitmap.Config config = this.f5792c;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return n.a(this.f5790a, this.f5792c);
        }
    }

    static class b extends d<a> {
        b() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public a b() {
            return new a(this);
        }

        public a a(int i2, Bitmap.Config config) {
            a aVar = (a) c();
            aVar.a(i2, config);
            return aVar;
        }
    }

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f5781a = configArr;
        f5782b = configArr;
    }

    static String a(int i2, Bitmap.Config config) {
        return "[" + i2 + "](" + config + ")";
    }

    private NavigableMap<Integer, Integer> a(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f5788h.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f5788h.put(config, treeMap);
        return treeMap;
    }

    private void a(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> a2 = a(bitmap.getConfig());
        Integer num2 = (Integer) a2.get(num);
        if (num2 == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + b(bitmap) + ", this: " + this);
        } else if (num2.intValue() == 1) {
            a2.remove(num);
        } else {
            a2.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    private a b(int i2, Bitmap.Config config) {
        a a2 = this.f5786f.a(i2, config);
        Bitmap.Config[] b2 = b(config);
        int length = b2.length;
        int i3 = 0;
        while (i3 < length) {
            Bitmap.Config config2 = b2[i3];
            Integer ceilingKey = a(config2).ceilingKey(Integer.valueOf(i2));
            if (ceilingKey == null || ceilingKey.intValue() > i2 * 8) {
                i3++;
            } else {
                if (ceilingKey.intValue() == i2) {
                    if (config2 == null) {
                        if (config == null) {
                            return a2;
                        }
                    } else if (config2.equals(config)) {
                        return a2;
                    }
                }
                this.f5786f.a(a2);
                return this.f5786f.a(ceilingKey.intValue(), config2);
            }
        }
        return a2;
    }

    private static Bitmap.Config[] b(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(config)) {
            return f5782b;
        }
        int i2 = AnonymousClass1.f5789a[config.ordinal()];
        if (i2 == 1) {
            return f5781a;
        }
        if (i2 == 2) {
            return f5783c;
        }
        if (i2 == 3) {
            return f5784d;
        }
        if (i2 == 4) {
            return f5785e;
        }
        return new Bitmap.Config[]{config};
    }

    public Bitmap a() {
        Bitmap a2 = this.f5787g.a();
        if (a2 != null) {
            a(Integer.valueOf(l.a(a2)), a2);
        }
        return a2;
    }

    public Bitmap a(int i2, int i3, Bitmap.Config config) {
        a b2 = b(l.a(i2, i3, config), config);
        Bitmap a2 = this.f5787g.a(b2);
        if (a2 != null) {
            a(Integer.valueOf(b2.f5790a), a2);
            a2.reconfigure(i2, i3, config);
        }
        return a2;
    }

    public void a(Bitmap bitmap) {
        a a2 = this.f5786f.a(l.a(bitmap), bitmap.getConfig());
        this.f5787g.a(a2, bitmap);
        NavigableMap<Integer, Integer> a3 = a(bitmap.getConfig());
        Integer num = (Integer) a3.get(Integer.valueOf(a2.f5790a));
        Integer valueOf = Integer.valueOf(a2.f5790a);
        int i2 = 1;
        if (num != null) {
            i2 = 1 + num.intValue();
        }
        a3.put(valueOf, Integer.valueOf(i2));
    }

    public String b(int i2, int i3, Bitmap.Config config) {
        return a(l.a(i2, i3, config), config);
    }

    public String b(Bitmap bitmap) {
        return a(l.a(bitmap), bitmap.getConfig());
    }

    public int c(Bitmap bitmap) {
        return l.a(bitmap);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f5787g);
        sb.append(", sortedSizes=(");
        for (Map.Entry next : this.f5788h.entrySet()) {
            sb.append(next.getKey());
            sb.append('[');
            sb.append(next.getValue());
            sb.append("], ");
        }
        if (!this.f5788h.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }
}
