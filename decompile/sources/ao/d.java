package ao;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f5467a;

    /* renamed from: b  reason: collision with root package name */
    public Long f5468b;

    public d(String str, long j2) {
        this.f5467a = str;
        this.f5468b = Long.valueOf(j2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public d(String str, boolean z2) {
        this(str, z2 ? 1 : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!this.f5467a.equals(dVar.f5467a)) {
            return false;
        }
        Long l2 = this.f5468b;
        Long l3 = dVar.f5468b;
        return l2 != null ? l2.equals(l3) : l3 == null;
    }

    public int hashCode() {
        int hashCode = this.f5467a.hashCode() * 31;
        Long l2 = this.f5468b;
        return hashCode + (l2 != null ? l2.hashCode() : 0);
    }
}
