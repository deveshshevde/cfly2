package ar;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final int f5561a;

    /* renamed from: b  reason: collision with root package name */
    private final int f5562b;

    public c(int i2, int i3) {
        this.f5561a = i2;
        this.f5562b = i3;
    }

    public final int a() {
        return this.f5561a;
    }

    public final int b() {
        return this.f5562b;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (this.f5561a == cVar.f5561a) {
                    if (this.f5562b == cVar.f5562b) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f5561a * 31) + this.f5562b;
    }

    public String toString() {
        return "MonthSnapshot(month=" + this.f5561a + ", year=" + this.f5562b + ")";
    }
}
