package com.alibaba.android.arouter.base;

import java.util.TreeMap;

public class UniqueKeyTreeMap<K, V> extends TreeMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private String f7651a;

    public UniqueKeyTreeMap(String str) {
        this.f7651a = str;
    }

    public V put(K k2, V v2) {
        if (!containsKey(k2)) {
            return super.put(k2, v2);
        }
        throw new RuntimeException(String.format(this.f7651a, new Object[]{k2}));
    }
}
