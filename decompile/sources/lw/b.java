package lw;

import java.util.Objects;
import lv.c;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    static final c<Object, Object> f31021a = new a();

    static final class a implements c<Object, Object> {
        a() {
        }
    }

    public static int a(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 > i3 ? 1 : 0;
    }

    public static int a(int i2, String str) {
        if (i2 > 0) {
            return i2;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i2);
    }

    public static int a(long j2, long j3) {
        if (j2 < j3) {
            return -1;
        }
        return j2 > j3 ? 1 : 0;
    }

    public static <T> T a(T t2, String str) {
        Objects.requireNonNull(t2, str);
        return t2;
    }
}
