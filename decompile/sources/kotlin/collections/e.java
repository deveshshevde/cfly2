package kotlin.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.h;

class e extends d {
    public static final <T> List<T> a(T[] tArr) {
        h.d(tArr, "$this$asList");
        List<T> a2 = g.a(tArr);
        h.b(a2, "ArraysUtilJVM.asList(this)");
        return a2;
    }

    public static final <T> void a(T[] tArr, Comparator<? super T> comparator) {
        h.d(tArr, "$this$sortWith");
        h.d(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }

    public static final <T> T[] a(T[] tArr, T[] tArr2, int i2, int i3, int i4) {
        h.d(tArr, "$this$copyInto");
        h.d(tArr2, "destination");
        System.arraycopy(tArr, i3, tArr2, i2, i4 - i3);
        return tArr2;
    }

    public static /* synthetic */ Object[] a(Object[] objArr, Object[] objArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = objArr.length;
        }
        return b.a(objArr, objArr2, i2, i3, i4);
    }
}
