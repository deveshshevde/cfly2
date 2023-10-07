package fj;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    public static final t f27406a = new t(0, 0);

    /* renamed from: b  reason: collision with root package name */
    public final long f27407b;

    /* renamed from: c  reason: collision with root package name */
    public final long f27408c;

    public t(long j2, long j3) {
        this.f27407b = j2;
        this.f27408c = j3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        t tVar = (t) obj;
        return this.f27407b == tVar.f27407b && this.f27408c == tVar.f27408c;
    }

    public int hashCode() {
        return (((int) this.f27407b) * 31) + ((int) this.f27408c);
    }

    public String toString() {
        long j2 = this.f27407b;
        long j3 = this.f27408c;
        StringBuilder sb = new StringBuilder(60);
        sb.append("[timeUs=");
        sb.append(j2);
        sb.append(", position=");
        sb.append(j3);
        sb.append("]");
        return sb.toString();
    }
}
