package io.realm.internal;

import io.realm.d;
import io.realm.e;
import io.realm.internal.g;

interface ObservableCollection {

    public static class a implements g.a<b> {

        /* renamed from: a  reason: collision with root package name */
        private final d f28961a;

        a(d dVar) {
            this.f28961a = dVar;
        }

        public void a(b bVar, Object obj) {
            bVar.a(obj, this.f28961a);
        }
    }

    public static class b<T> extends g.b<T, Object> {
        public void a(T t2, d dVar) {
            if (this.f29041b instanceof e) {
                ((e) this.f29041b).a(t2, dVar);
            } else if (this.f29041b instanceof io.realm.g) {
                ((io.realm.g) this.f29041b).a(t2);
            } else {
                throw new RuntimeException("Unsupported listener type: " + this.f29041b);
            }
        }
    }

    public static class c<T> implements e<T> {

        /* renamed from: a  reason: collision with root package name */
        private final io.realm.g<T> f28962a;

        c(io.realm.g<T> gVar) {
            this.f28962a = gVar;
        }

        public void a(T t2, d dVar) {
            this.f28962a.a(t2);
        }

        public boolean equals(Object obj) {
            return (obj instanceof c) && this.f28962a == ((c) obj).f28962a;
        }

        public int hashCode() {
            return this.f28962a.hashCode();
        }
    }

    void notifyChangeListeners(long j2);
}
