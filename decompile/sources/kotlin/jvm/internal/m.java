package kotlin.jvm.internal;

import java.util.Collection;
import kotlin.c;
import mm.d;
import mm.e;
import mm.f;
import mm.g;
import mm.h;
import mm.i;
import mm.j;
import mm.k;
import mm.l;
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
import mn.a;
import mn.b;

public class m {
    public static ClassCastException a(ClassCastException classCastException) {
        throw ((ClassCastException) a(classCastException));
    }

    private static <T extends Throwable> T a(T t2) {
        return h.a(t2, m.class.getName());
    }

    public static Collection a(Object obj) {
        if ((obj instanceof a) && !(obj instanceof b)) {
            a(obj, "kotlin.collections.MutableCollection");
        }
        return b(obj);
    }

    public static void a(Object obj, String str) {
        String name = obj == null ? "null" : obj.getClass().getName();
        a(name + " cannot be cast to " + str);
    }

    public static void a(String str) {
        throw a(new ClassCastException(str));
    }

    public static boolean a(Object obj, int i2) {
        return (obj instanceof c) && c(obj) == i2;
    }

    public static Object b(Object obj, int i2) {
        if (obj != null && !a(obj, i2)) {
            a(obj, "kotlin.jvm.functions.Function" + i2);
        }
        return obj;
    }

    public static Collection b(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e2) {
            throw a(e2);
        }
    }

    public static int c(Object obj) {
        if (obj instanceof g) {
            return ((g) obj).getArity();
        }
        if (obj instanceof mm.a) {
            return 0;
        }
        if (obj instanceof mm.b) {
            return 1;
        }
        if (obj instanceof mm.m) {
            return 2;
        }
        if (obj instanceof q) {
            return 3;
        }
        if (obj instanceof r) {
            return 4;
        }
        if (obj instanceof s) {
            return 5;
        }
        if (obj instanceof t) {
            return 6;
        }
        if (obj instanceof u) {
            return 7;
        }
        if (obj instanceof v) {
            return 8;
        }
        if (obj instanceof w) {
            return 9;
        }
        if (obj instanceof mm.c) {
            return 10;
        }
        if (obj instanceof d) {
            return 11;
        }
        if (obj instanceof e) {
            return 12;
        }
        if (obj instanceof f) {
            return 13;
        }
        if (obj instanceof g) {
            return 14;
        }
        if (obj instanceof h) {
            return 15;
        }
        if (obj instanceof i) {
            return 16;
        }
        if (obj instanceof j) {
            return 17;
        }
        if (obj instanceof k) {
            return 18;
        }
        if (obj instanceof l) {
            return 19;
        }
        if (obj instanceof n) {
            return 20;
        }
        if (obj instanceof o) {
            return 21;
        }
        return obj instanceof p ? 22 : -1;
    }
}
