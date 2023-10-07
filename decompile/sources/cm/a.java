package cm;

import android.util.SparseIntArray;
import java.util.List;

public abstract class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private SparseIntArray f6240a;

    public final int a(int i2) {
        return this.f6240a.get(i2, -404);
    }

    /* access modifiers changed from: protected */
    public abstract int a(T t2);

    public final int a(List<T> list, int i2) {
        T t2 = list.get(i2);
        if (t2 != null) {
            return a(t2);
        }
        return -255;
    }
}
