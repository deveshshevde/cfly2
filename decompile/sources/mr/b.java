package mr;

import java.util.NoSuchElementException;
import kotlin.collections.t;

public final class b extends t {

    /* renamed from: a  reason: collision with root package name */
    private final int f31280a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f31281b;

    /* renamed from: c  reason: collision with root package name */
    private int f31282c;

    /* renamed from: d  reason: collision with root package name */
    private final int f31283d;

    public b(int i2, int i3, int i4) {
        this.f31283d = i4;
        this.f31280a = i3;
        boolean z2 = true;
        if (i4 <= 0 ? i2 < i3 : i2 > i3) {
            z2 = false;
        }
        this.f31281b = z2;
        this.f31282c = !z2 ? i3 : i2;
    }

    public int b() {
        int i2 = this.f31282c;
        if (i2 != this.f31280a) {
            this.f31282c = this.f31283d + i2;
        } else if (this.f31281b) {
            this.f31281b = false;
        } else {
            throw new NoSuchElementException();
        }
        return i2;
    }

    public boolean hasNext() {
        return this.f31281b;
    }
}
