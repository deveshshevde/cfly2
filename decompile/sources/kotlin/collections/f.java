package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.h;

class f extends e {
    public static final char a(char[] cArr) {
        h.d(cArr, "$this$single");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return cArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static final <T> boolean a(T[] tArr, T t2) {
        h.d(tArr, "$this$contains");
        return b.b(tArr, t2) >= 0;
    }

    public static final <T> int b(T[] tArr, T t2) {
        h.d(tArr, "$this$indexOf");
        int i2 = 0;
        if (t2 == null) {
            int length = tArr.length;
            while (i2 < length) {
                if (tArr[i2] == null) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i2 < length2) {
            if (h.a((Object) t2, (Object) tArr[i2])) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static final <T> T b(T[] tArr) {
        h.d(tArr, "$this$singleOrNull");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static final <T> T[] b(T[] tArr, Comparator<? super T> comparator) {
        h.d(tArr, "$this$sortedArrayWith");
        h.d(comparator, "comparator");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] copyOf = Arrays.copyOf(tArr, tArr.length);
        h.b(copyOf, "java.util.Arrays.copyOf(this, size)");
        b.a(copyOf, comparator);
        return copyOf;
    }

    public static final <T> List<T> c(T[] tArr) {
        h.d(tArr, "$this$reversed");
        if (tArr.length == 0) {
            return h.a();
        }
        List<T> d2 = b.d(tArr);
        h.c(d2);
        return d2;
    }

    public static final <T> List<T> c(T[] tArr, Comparator<? super T> comparator) {
        h.d(tArr, "$this$sortedWith");
        h.d(comparator, "comparator");
        return b.a(b.b(tArr, comparator));
    }

    public static final <T> List<T> d(T[] tArr) {
        h.d(tArr, "$this$toMutableList");
        return new ArrayList<>(h.a(tArr));
    }
}
