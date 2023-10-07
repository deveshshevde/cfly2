package op;

import java.util.Iterator;

public abstract class a<E> extends b<E> {

    /* renamed from: a  reason: collision with root package name */
    protected static final int f32495a;

    /* renamed from: d  reason: collision with root package name */
    private static final long f32496d;

    /* renamed from: e  reason: collision with root package name */
    private static final int f32497e;

    /* renamed from: b  reason: collision with root package name */
    protected final long f32498b;

    /* renamed from: c  reason: collision with root package name */
    protected final E[] f32499c;

    static {
        int i2;
        int intValue = Integer.getInteger("sparse.shift", 0).intValue();
        f32495a = intValue;
        int arrayIndexScale = y.f32512a.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            i2 = intValue + 2;
        } else if (8 == arrayIndexScale) {
            i2 = intValue + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        f32497e = i2;
        f32496d = (long) (y.f32512a.arrayBaseOffset(Object[].class) + (32 << (f32497e - intValue)));
    }

    public a(int i2) {
        int a2 = i.a(i2);
        this.f32498b = (long) (a2 - 1);
        this.f32499c = (Object[]) new Object[((a2 << f32495a) + 64)];
    }

    /* access modifiers changed from: protected */
    public final long a(long j2) {
        return a(j2, this.f32498b);
    }

    /* access modifiers changed from: protected */
    public final long a(long j2, long j3) {
        return f32496d + ((j2 & j3) << f32497e);
    }

    /* access modifiers changed from: protected */
    public final E a(E[] eArr, long j2) {
        return y.f32512a.getObject(eArr, j2);
    }

    /* access modifiers changed from: protected */
    public final void a(long j2, E e2) {
        a(this.f32499c, j2, e2);
    }

    /* access modifiers changed from: protected */
    public final void a(E[] eArr, long j2, E e2) {
        y.f32512a.putObject(eArr, j2, e2);
    }

    /* access modifiers changed from: protected */
    public final E b(long j2) {
        return a(this.f32499c, j2);
    }

    /* access modifiers changed from: protected */
    public final E b(E[] eArr, long j2) {
        return y.f32512a.getObjectVolatile(eArr, j2);
    }

    /* access modifiers changed from: protected */
    public final void b(E[] eArr, long j2, E e2) {
        y.f32512a.putOrderedObject(eArr, j2, e2);
    }

    /* access modifiers changed from: protected */
    public final E c(long j2) {
        return b(this.f32499c, j2);
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }
}
