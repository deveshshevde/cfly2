package mr;

import kotlin.collections.t;
import mj.c;

public class a implements Iterable<Integer>, mn.a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0227a f31276a = new C0227a((f) null);

    /* renamed from: b  reason: collision with root package name */
    private final int f31277b;

    /* renamed from: c  reason: collision with root package name */
    private final int f31278c;

    /* renamed from: d  reason: collision with root package name */
    private final int f31279d;

    /* renamed from: mr.a$a  reason: collision with other inner class name */
    public static final class C0227a {
        private C0227a() {
        }

        public /* synthetic */ C0227a(f fVar) {
            this();
        }

        public final a a(int i2, int i3, int i4) {
            return new a(i2, i3, i4);
        }
    }

    public a(int i2, int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i4 != Integer.MIN_VALUE) {
            this.f31277b = i2;
            this.f31278c = c.a(i2, i3, i4);
            this.f31279d = i4;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public final int a() {
        return this.f31277b;
    }

    public final int b() {
        return this.f31278c;
    }

    public final int c() {
        return this.f31279d;
    }

    /* renamed from: d */
    public t iterator() {
        return new b(this.f31277b, this.f31278c, this.f31279d);
    }

    public boolean e() {
        if (this.f31279d > 0) {
            if (this.f31277b > this.f31278c) {
                return true;
            }
        } else if (this.f31277b < this.f31278c) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            if (!e() || !((a) obj).e()) {
                a aVar = (a) obj;
                if (!(this.f31277b == aVar.f31277b && this.f31278c == aVar.f31278c && this.f31279d == aVar.f31279d)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (e()) {
            return -1;
        }
        return (((this.f31277b * 31) + this.f31278c) * 31) + this.f31279d;
    }

    public String toString() {
        int i2;
        StringBuilder sb;
        if (this.f31279d > 0) {
            sb = new StringBuilder();
            sb.append(this.f31277b);
            sb.append("..");
            sb.append(this.f31278c);
            sb.append(" step ");
            i2 = this.f31279d;
        } else {
            sb = new StringBuilder();
            sb.append(this.f31277b);
            sb.append(" downTo ");
            sb.append(this.f31278c);
            sb.append(" step ");
            i2 = -this.f31279d;
        }
        sb.append(i2);
        return sb.toString();
    }
}
