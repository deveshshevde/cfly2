package kotlinx.coroutines.internal;

import java.util.Objects;
import kotlin.collections.b;

public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private Object[] f30383a = new Object[16];

    /* renamed from: b  reason: collision with root package name */
    private int f30384b;

    /* renamed from: c  reason: collision with root package name */
    private int f30385c;

    private final void c() {
        Object[] objArr = this.f30383a;
        int length = objArr.length;
        Object[] objArr2 = new Object[(length << 1)];
        Object[] objArr3 = objArr2;
        b.a(objArr, objArr3, 0, this.f30384b, 0, 10, (Object) null);
        Object[] objArr4 = this.f30383a;
        int length2 = objArr4.length;
        int i2 = this.f30384b;
        b.a(objArr4, objArr2, length2 - i2, 0, i2, 4, (Object) null);
        this.f30383a = objArr3;
        this.f30384b = 0;
        this.f30385c = length;
    }

    public final void a(T t2) {
        Object[] objArr = this.f30383a;
        int i2 = this.f30385c;
        objArr[i2] = t2;
        int length = (objArr.length - 1) & (i2 + 1);
        this.f30385c = length;
        if (length == this.f30384b) {
            c();
        }
    }

    public final boolean a() {
        return this.f30384b == this.f30385c;
    }

    public final T b() {
        int i2 = this.f30384b;
        if (i2 == this.f30385c) {
            return null;
        }
        T[] tArr = this.f30383a;
        T t2 = tArr[i2];
        tArr[i2] = null;
        this.f30384b = (i2 + 1) & (tArr.length - 1);
        Objects.requireNonNull(t2, "null cannot be cast to non-null type T");
        return t2;
    }
}
