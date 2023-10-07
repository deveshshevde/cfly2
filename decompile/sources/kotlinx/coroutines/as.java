package kotlinx.coroutines;

final class as implements bb {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f30320a;

    public as(boolean z2) {
        this.f30320a = z2;
    }

    public boolean b() {
        return this.f30320a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(b() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }

    public bq z_() {
        return null;
    }
}
