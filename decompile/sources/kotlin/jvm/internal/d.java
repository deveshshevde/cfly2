package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.c;
import kotlin.collections.h;
import mm.e;
import mm.f;
import mm.g;
import mm.i;
import mm.j;
import mm.k;
import mm.l;
import mm.m;
import mm.n;
import mm.o;
import mm.p;
import mm.q;
import mm.r;
import mm.s;
import mm.t;
import mm.u;
import mm.v;
import mm.w;
import ms.b;

public final class d implements c, b<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f30240a = new a((f) null);

    /* renamed from: c  reason: collision with root package name */
    private static final Map<Class<? extends c<?>>, Integer> f30241c;

    /* renamed from: d  reason: collision with root package name */
    private static final HashMap<String, String> f30242d;

    /* renamed from: e  reason: collision with root package name */
    private static final HashMap<String, String> f30243e;

    /* renamed from: f  reason: collision with root package name */
    private static final HashMap<String, String> f30244f;

    /* renamed from: g  reason: collision with root package name */
    private static final Map<String, String> f30245g;

    /* renamed from: b  reason: collision with root package name */
    private final Class<?> f30246b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        int i2 = 0;
        Iterable b2 = h.b((T[]) new Class[]{mm.a.class, mm.b.class, m.class, q.class, r.class, s.class, t.class, u.class, v.class, w.class, mm.c.class, mm.d.class, e.class, f.class, g.class, mm.h.class, i.class, j.class, k.class, l.class, n.class, o.class, p.class});
        Collection arrayList = new ArrayList(h.a(b2, 10));
        for (Object next : b2) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                h.b();
            }
            arrayList.add(kotlin.j.a((Class) next, Integer.valueOf(i2)));
            i2 = i3;
        }
        f30241c = kotlin.collections.u.a((List) arrayList);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        f30242d = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f30243e = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        h.b(values, "primitiveFqNames.values");
        for (String str : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            h.b(str, "kotlinName");
            sb.append(kotlin.text.f.b(str, '.', (String) null, 2, (Object) null));
            sb.append("CompanionObject");
            String sb2 = sb.toString();
            Pair a2 = kotlin.j.a(sb2, str + ".Companion");
            hashMap3.put(a2.a(), a2.b());
        }
        Map map = hashMap3;
        for (Map.Entry next2 : f30241c.entrySet()) {
            int intValue = ((Number) next2.getValue()).intValue();
            String name = ((Class) next2.getKey()).getName();
            hashMap3.put(name, "kotlin.Function" + intValue);
        }
        f30244f = hashMap3;
        Map map2 = hashMap3;
        Map<String, String> linkedHashMap = new LinkedHashMap<>(kotlin.collections.u.a(map2.size()));
        for (Map.Entry entry : map2.entrySet()) {
            linkedHashMap.put(entry.getKey(), kotlin.text.f.b((String) entry.getValue(), '.', (String) null, 2, (Object) null));
        }
        f30245g = linkedHashMap;
    }

    public d(Class<?> cls) {
        h.d(cls, "jClass");
        this.f30246b = cls;
    }

    public Class<?> a() {
        return this.f30246b;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && h.a((Object) kotlin.jvm.a.a(this), (Object) kotlin.jvm.a.a((b) obj));
    }

    public int hashCode() {
        return kotlin.jvm.a.a(this).hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
