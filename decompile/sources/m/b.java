package m;

import android.graphics.Insets;
import android.graphics.Rect;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f31044a = new b(0, 0, 0, 0);

    /* renamed from: b  reason: collision with root package name */
    public final int f31045b;

    /* renamed from: c  reason: collision with root package name */
    public final int f31046c;

    /* renamed from: d  reason: collision with root package name */
    public final int f31047d;

    /* renamed from: e  reason: collision with root package name */
    public final int f31048e;

    private b(int i2, int i3, int i4, int i5) {
        this.f31045b = i2;
        this.f31046c = i3;
        this.f31047d = i4;
        this.f31048e = i5;
    }

    public static b a(int i2, int i3, int i4, int i5) {
        return (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) ? f31044a : new b(i2, i3, i4, i5);
    }

    public static b a(Insets insets) {
        return a(insets.left, insets.top, insets.right, insets.bottom);
    }

    public static b a(Rect rect) {
        return a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static b a(b bVar, b bVar2) {
        return a(Math.max(bVar.f31045b, bVar2.f31045b), Math.max(bVar.f31046c, bVar2.f31046c), Math.max(bVar.f31047d, bVar2.f31047d), Math.max(bVar.f31048e, bVar2.f31048e));
    }

    public Insets a() {
        return Insets.of(this.f31045b, this.f31046c, this.f31047d, this.f31048e);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f31048e == bVar.f31048e && this.f31045b == bVar.f31045b && this.f31047d == bVar.f31047d && this.f31046c == bVar.f31046c;
    }

    public int hashCode() {
        return (((((this.f31045b * 31) + this.f31046c) * 31) + this.f31047d) * 31) + this.f31048e;
    }

    public String toString() {
        return "Insets{left=" + this.f31045b + ", top=" + this.f31046c + ", right=" + this.f31047d + ", bottom=" + this.f31048e + '}';
    }
}
