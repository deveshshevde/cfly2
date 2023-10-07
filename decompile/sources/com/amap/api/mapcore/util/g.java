package com.amap.api.mapcore.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<Integer, a> f8886a = new ConcurrentHashMap<>();

    private class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public List<T> f8887a = Collections.synchronizedList(new ArrayList());

        /* renamed from: b  reason: collision with root package name */
        public T f8888b = null;

        public a() {
        }
    }

    public final <T> List<T> a(int i2) {
        try {
            a aVar = this.f8886a.get(Integer.valueOf(i2));
            if (aVar != null) {
                return aVar.f8887a;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final <T> void a() {
        ConcurrentHashMap<Integer, a> concurrentHashMap = this.f8886a;
        if (concurrentHashMap != null) {
            try {
                for (Map.Entry<Integer, a> value : concurrentHashMap.entrySet()) {
                    a aVar = (a) value.getValue();
                    aVar.f8887a.clear();
                    aVar.f8888b = null;
                }
                this.f8886a.clear();
            } catch (Throwable unused) {
            }
        }
    }

    public final <T> void a(int i2, T t2) {
        ConcurrentHashMap<Integer, a> concurrentHashMap = this.f8886a;
        if (concurrentHashMap != null) {
            try {
                a aVar = concurrentHashMap.get(Integer.valueOf(i2));
                if (aVar == null) {
                    aVar = new a();
                    this.f8886a.putIfAbsent(Integer.valueOf(i2), aVar);
                }
                if (aVar.f8888b != t2) {
                    b(Integer.valueOf(i2), aVar.f8888b);
                    aVar.f8888b = t2;
                    a(Integer.valueOf(i2), t2);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final <T> void a(Integer num) {
        a aVar;
        try {
            if (this.f8886a.containsKey(num) && (aVar = this.f8886a.get(num)) != null && aVar.f8887a != null) {
                aVar.f8887a.clear();
            }
        } catch (Throwable unused) {
        }
    }

    public final <T> void a(Integer num, T t2) {
        ConcurrentHashMap<Integer, a> concurrentHashMap;
        if (t2 != null && (concurrentHashMap = this.f8886a) != null) {
            try {
                a aVar = concurrentHashMap.get(num);
                if (aVar == null) {
                    aVar = new a();
                    this.f8886a.putIfAbsent(num, aVar);
                }
                if (aVar.f8887a != null && !aVar.f8887a.contains(t2)) {
                    aVar.f8887a.add(t2);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final <T> void b(Integer num, T t2) {
        ConcurrentHashMap<Integer, a> concurrentHashMap;
        a aVar;
        if (t2 != null && (concurrentHashMap = this.f8886a) != null) {
            try {
                if (concurrentHashMap.containsKey(num) && (aVar = this.f8886a.get(num)) != null && aVar.f8887a != null && aVar.f8887a.contains(t2)) {
                    aVar.f8887a.remove(t2);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
