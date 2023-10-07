package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.h;
import mn.a;

final class EmptyMap implements Serializable, Map, a {

    /* renamed from: a  reason: collision with root package name */
    public static final EmptyMap f30185a = new EmptyMap();
    private static final long serialVersionUID = 8246714829545688274L;

    private EmptyMap() {
    }

    public int a() {
        return 0;
    }

    public Void a(Object obj) {
        return null;
    }

    public boolean a(Void voidR) {
        h.d(voidR, "value");
        return false;
    }

    public Set<Map.Entry> b() {
        return EmptySet.f30186a;
    }

    public Set<Object> c() {
        return EmptySet.f30186a;
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean containsKey(Object obj) {
        return false;
    }

    public final boolean containsValue(Object obj) {
        if (obj instanceof Void) {
            return a((Void) obj);
        }
        return false;
    }

    public Collection d() {
        return EmptyList.f30184a;
    }

    public final Set<Map.Entry> entrySet() {
        return b();
    }

    public boolean equals(Object obj) {
        return (obj instanceof Map) && ((Map) obj).isEmpty();
    }

    public final Object get(Object obj) {
        return a(obj);
    }

    public int hashCode() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    public final Set<Object> keySet() {
        return c();
    }

    public /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final int size() {
        return a();
    }

    public String toString() {
        return "{}";
    }

    public final Collection values() {
        return d();
    }
}
