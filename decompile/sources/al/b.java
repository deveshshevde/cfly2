package al;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private boolean f238a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f239b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f240c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f241d;

    public b(boolean z2, boolean z3, boolean z4, boolean z5) {
        this.f238a = z2;
        this.f239b = z3;
        this.f240c = z4;
        this.f241d = z5;
    }

    public boolean a() {
        return this.f238a;
    }

    public boolean b() {
        return this.f239b;
    }

    public boolean c() {
        return this.f240c;
    }

    public boolean d() {
        return this.f241d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f238a == bVar.f238a && this.f239b == bVar.f239b && this.f240c == bVar.f240c && this.f241d == bVar.f241d;
    }

    public int hashCode() {
        int i2 = this.f238a ? 1 : 0;
        if (this.f239b) {
            i2 += 16;
        }
        if (this.f240c) {
            i2 += 256;
        }
        return this.f241d ? i2 + 4096 : i2;
    }

    public String toString() {
        return String.format("[ Connected=%b Validated=%b Metered=%b NotRoaming=%b ]", new Object[]{Boolean.valueOf(this.f238a), Boolean.valueOf(this.f239b), Boolean.valueOf(this.f240c), Boolean.valueOf(this.f241d)});
    }
}
