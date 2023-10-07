package bl;

import bl.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class h<K extends m, V> {

    /* renamed from: a  reason: collision with root package name */
    private final a<K, V> f5755a = new a<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<K, a<K, V>> f5756b = new HashMap();

    private static class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f5757a;

        /* renamed from: b  reason: collision with root package name */
        a<K, V> f5758b;

        /* renamed from: c  reason: collision with root package name */
        a<K, V> f5759c;

        /* renamed from: d  reason: collision with root package name */
        private List<V> f5760d;

        a() {
            this((Object) null);
        }

        a(K k2) {
            this.f5759c = this;
            this.f5758b = this;
            this.f5757a = k2;
        }

        public V a() {
            int b2 = b();
            if (b2 > 0) {
                return this.f5760d.remove(b2 - 1);
            }
            return null;
        }

        public void a(V v2) {
            if (this.f5760d == null) {
                this.f5760d = new ArrayList();
            }
            this.f5760d.add(v2);
        }

        public int b() {
            List<V> list = this.f5760d;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
    }

    h() {
    }

    private void a(a<K, V> aVar) {
        d(aVar);
        aVar.f5759c = this.f5755a;
        aVar.f5758b = this.f5755a.f5758b;
        c(aVar);
    }

    private void b(a<K, V> aVar) {
        d(aVar);
        aVar.f5759c = this.f5755a.f5759c;
        aVar.f5758b = this.f5755a;
        c(aVar);
    }

    private static <K, V> void c(a<K, V> aVar) {
        aVar.f5758b.f5759c = aVar;
        aVar.f5759c.f5758b = aVar;
    }

    private static <K, V> void d(a<K, V> aVar) {
        aVar.f5759c.f5758b = aVar.f5758b;
        aVar.f5758b.f5759c = aVar.f5759c;
    }

    public V a() {
        a<K, V> aVar = this.f5755a;
        while (true) {
            aVar = aVar.f5759c;
            if (aVar.equals(this.f5755a)) {
                return null;
            }
            V a2 = aVar.a();
            if (a2 != null) {
                return a2;
            }
            d(aVar);
            this.f5756b.remove(aVar.f5757a);
            ((m) aVar.f5757a).a();
        }
    }

    public V a(K k2) {
        a aVar = this.f5756b.get(k2);
        if (aVar == null) {
            aVar = new a(k2);
            this.f5756b.put(k2, aVar);
        } else {
            k2.a();
        }
        a(aVar);
        return aVar.a();
    }

    public void a(K k2, V v2) {
        a aVar = this.f5756b.get(k2);
        if (aVar == null) {
            aVar = new a(k2);
            b(aVar);
            this.f5756b.put(k2, aVar);
        } else {
            k2.a();
        }
        aVar.a(v2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z2 = false;
        for (a<K, V> aVar = this.f5755a.f5758b; !aVar.equals(this.f5755a); aVar = aVar.f5758b) {
            z2 = true;
            sb.append('{');
            sb.append(aVar.f5757a);
            sb.append(':');
            sb.append(aVar.b());
            sb.append("}, ");
        }
        if (z2) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
