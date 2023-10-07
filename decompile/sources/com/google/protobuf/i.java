package com.google.protobuf;

import java.util.Iterator;
import java.util.Map;

public class i extends j {

    /* renamed from: b  reason: collision with root package name */
    private final k f20142b;

    static class a<K> implements Map.Entry<K, Object> {

        /* renamed from: a  reason: collision with root package name */
        private Map.Entry<K, i> f20143a;

        private a(Map.Entry<K, i> entry) {
            this.f20143a = entry;
        }

        public K getKey() {
            return this.f20143a.getKey();
        }

        public Object getValue() {
            i value = this.f20143a.getValue();
            if (value == null) {
                return null;
            }
            return value.a();
        }

        public Object setValue(Object obj) {
            if (obj instanceof k) {
                return this.f20143a.getValue().b((k) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    static class b<K> implements Iterator<Map.Entry<K, Object>> {

        /* renamed from: a  reason: collision with root package name */
        private Iterator<Map.Entry<K, Object>> f20144a;

        public b(Iterator<Map.Entry<K, Object>> it2) {
            this.f20144a = it2;
        }

        /* renamed from: a */
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.f20144a.next();
            return next.getValue() instanceof i ? new a(next) : next;
        }

        public boolean hasNext() {
            return this.f20144a.hasNext();
        }

        public void remove() {
            this.f20144a.remove();
        }
    }

    public k a() {
        return a(this.f20142b);
    }

    public boolean equals(Object obj) {
        return a().equals(obj);
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString();
    }
}
