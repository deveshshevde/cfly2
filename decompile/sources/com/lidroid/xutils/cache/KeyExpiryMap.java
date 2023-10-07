package com.lidroid.xutils.cache;

import java.util.concurrent.ConcurrentHashMap;

public class KeyExpiryMap<K, V> extends ConcurrentHashMap<K, Long> {
    private static final long serialVersionUID = 1;

    public KeyExpiryMap() {
    }

    public KeyExpiryMap(int i2, float f2) {
        super(i2, f2, 16);
    }

    /* renamed from: a */
    public synchronized Long get(Object obj) {
        if (!containsKey(obj)) {
            return null;
        }
        return (Long) super.get(obj);
    }

    /* renamed from: a */
    public synchronized Long put(K k2, Long l2) {
        if (containsKey(k2)) {
            remove(k2);
        }
        return (Long) super.put(k2, l2);
    }

    /* renamed from: b */
    public synchronized Long remove(Object obj) {
        return (Long) super.remove(obj);
    }

    public synchronized void clear() {
        super.clear();
    }

    public synchronized boolean containsKey(Object obj) {
        boolean z2;
        z2 = false;
        Long l2 = (Long) super.get(obj);
        if (l2 == null || System.currentTimeMillis() >= l2.longValue()) {
            remove(obj);
        } else {
            z2 = true;
        }
        return z2;
    }
}
