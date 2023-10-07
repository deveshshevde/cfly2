package com.lidroid.xutils.cache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class a<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap<K, V> f21002a;

    /* renamed from: b  reason: collision with root package name */
    private int f21003b;

    /* renamed from: c  reason: collision with root package name */
    private int f21004c;

    /* renamed from: d  reason: collision with root package name */
    private int f21005d;

    /* renamed from: e  reason: collision with root package name */
    private int f21006e;

    /* renamed from: f  reason: collision with root package name */
    private int f21007f;

    /* renamed from: g  reason: collision with root package name */
    private int f21008g;

    /* renamed from: h  reason: collision with root package name */
    private int f21009h;

    /* renamed from: i  reason: collision with root package name */
    private KeyExpiryMap<K, Long> f21010i;

    public a(int i2) {
        if (i2 > 0) {
            this.f21004c = i2;
            this.f21002a = new LinkedHashMap<>(0, 0.75f, true);
            this.f21010i = new KeyExpiryMap<>(0, 0.75f);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private void a(int i2) {
        Object key;
        Object value;
        while (true) {
            synchronized (this) {
                if (this.f21003b > i2) {
                    if (this.f21002a.isEmpty()) {
                        break;
                    }
                    Map.Entry next = this.f21002a.entrySet().iterator().next();
                    key = next.getKey();
                    value = next.getValue();
                    this.f21002a.remove(key);
                    this.f21010i.remove(key);
                    this.f21003b -= b(key, value);
                    this.f21007f++;
                }
            }
            a(true, key, value, (Object) null);
        }
    }

    private int b(K k2, V v2) {
        int a2 = a(k2, v2);
        if (a2 <= 0) {
            this.f21003b = 0;
            for (Map.Entry next : this.f21002a.entrySet()) {
                this.f21003b += a(next.getKey(), next.getValue());
            }
        }
        return a2;
    }

    /* access modifiers changed from: protected */
    public int a(K k2, V v2) {
        return 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
        r0 = c(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        if (r0 != null) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0032, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r4.f21006e++;
        r1 = r4.f21002a.put(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003f, code lost:
        if (r1 == null) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0041, code lost:
        r4.f21002a.put(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0047, code lost:
        r4.f21003b += b(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0050, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0051, code lost:
        if (r1 == null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0053, code lost:
        a(false, r5, r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0057, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0058, code lost:
        a(r4.f21004c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005d, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V a(K r5) {
        /*
            r4 = this;
            java.lang.String r0 = "key == null"
            java.util.Objects.requireNonNull(r5, r0)
            monitor-enter(r4)
            com.lidroid.xutils.cache.KeyExpiryMap<K, java.lang.Long> r0 = r4.f21010i     // Catch:{ all -> 0x0061 }
            boolean r0 = r0.containsKey(r5)     // Catch:{ all -> 0x0061 }
            r1 = 0
            if (r0 != 0) goto L_0x0014
            r4.b(r5)     // Catch:{ all -> 0x0061 }
            monitor-exit(r4)     // Catch:{ all -> 0x0061 }
            return r1
        L_0x0014:
            java.util.LinkedHashMap<K, V> r0 = r4.f21002a     // Catch:{ all -> 0x0061 }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x0061 }
            if (r0 == 0) goto L_0x0024
            int r5 = r4.f21008g     // Catch:{ all -> 0x0061 }
            int r5 = r5 + 1
            r4.f21008g = r5     // Catch:{ all -> 0x0061 }
            monitor-exit(r4)     // Catch:{ all -> 0x0061 }
            return r0
        L_0x0024:
            int r0 = r4.f21009h     // Catch:{ all -> 0x0061 }
            int r0 = r0 + 1
            r4.f21009h = r0     // Catch:{ all -> 0x0061 }
            monitor-exit(r4)     // Catch:{ all -> 0x0061 }
            java.lang.Object r0 = r4.c(r5)
            if (r0 != 0) goto L_0x0032
            return r1
        L_0x0032:
            monitor-enter(r4)
            int r1 = r4.f21006e     // Catch:{ all -> 0x005e }
            int r1 = r1 + 1
            r4.f21006e = r1     // Catch:{ all -> 0x005e }
            java.util.LinkedHashMap<K, V> r1 = r4.f21002a     // Catch:{ all -> 0x005e }
            java.lang.Object r1 = r1.put(r5, r0)     // Catch:{ all -> 0x005e }
            if (r1 == 0) goto L_0x0047
            java.util.LinkedHashMap<K, V> r2 = r4.f21002a     // Catch:{ all -> 0x005e }
            r2.put(r5, r1)     // Catch:{ all -> 0x005e }
            goto L_0x0050
        L_0x0047:
            int r2 = r4.f21003b     // Catch:{ all -> 0x005e }
            int r3 = r4.b(r5, r0)     // Catch:{ all -> 0x005e }
            int r2 = r2 + r3
            r4.f21003b = r2     // Catch:{ all -> 0x005e }
        L_0x0050:
            monitor-exit(r4)     // Catch:{ all -> 0x005e }
            if (r1 == 0) goto L_0x0058
            r2 = 0
            r4.a(r2, r5, r0, r1)
            return r1
        L_0x0058:
            int r5 = r4.f21004c
            r4.a((int) r5)
            return r0
        L_0x005e:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x005e }
            throw r5
        L_0x0061:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0061 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lidroid.xutils.cache.a.a(java.lang.Object):java.lang.Object");
    }

    public final V a(K k2, V v2, long j2) {
        V put;
        if (k2 == null || v2 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f21005d++;
            this.f21003b += b(k2, v2);
            put = this.f21002a.put(k2, v2);
            this.f21010i.put(k2, Long.valueOf(j2));
            if (put != null) {
                this.f21003b -= b(k2, put);
            }
        }
        if (put != null) {
            a(false, k2, put, v2);
        }
        a(this.f21004c);
        return put;
    }

    /* access modifiers changed from: protected */
    public void a(boolean z2, K k2, V v2, V v3) {
    }

    public final V b(K k2) {
        V remove;
        Objects.requireNonNull(k2, "key == null");
        synchronized (this) {
            remove = this.f21002a.remove(k2);
            this.f21010i.remove(k2);
            if (remove != null) {
                this.f21003b -= b(k2, remove);
            }
        }
        if (remove != null) {
            a(false, k2, remove, (V) null);
        }
        return remove;
    }

    /* access modifiers changed from: protected */
    public V c(K k2) {
        return null;
    }

    public final synchronized String toString() {
        int i2;
        int i3;
        i2 = this.f21008g;
        i3 = this.f21009h + i2;
        return String.format("LruMemoryCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.f21004c), Integer.valueOf(this.f21008g), Integer.valueOf(this.f21009h), Integer.valueOf(i3 != 0 ? (i2 * 100) / i3 : 0)});
    }
}
