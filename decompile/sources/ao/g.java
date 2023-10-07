package ao;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public final String f5472a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5473b;

    public g(String str, int i2) {
        this.f5472a = str;
        this.f5473b = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f5473b != gVar.f5473b) {
            return false;
        }
        return this.f5472a.equals(gVar.f5472a);
    }

    public int hashCode() {
        return (this.f5472a.hashCode() * 31) + this.f5473b;
    }
}
