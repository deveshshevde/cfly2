package com.danikula.videocache;

import java.util.Objects;

public final class l {
    public static <T> T a(T t2) {
        Objects.requireNonNull(t2);
        return t2;
    }

    public static <T> T a(T t2, String str) {
        Objects.requireNonNull(t2, str);
        return t2;
    }

    static void a(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    static void a(boolean z2, String str) {
        if (!z2) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void a(Object... objArr) {
        for (Object requireNonNull : objArr) {
            Objects.requireNonNull(requireNonNull);
        }
    }
}
