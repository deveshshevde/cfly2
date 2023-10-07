package cc;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private Class<?> f6191a;

    /* renamed from: b  reason: collision with root package name */
    private Class<?> f6192b;

    /* renamed from: c  reason: collision with root package name */
    private Class<?> f6193c;

    public j() {
    }

    public j(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        a(cls, cls2, cls3);
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.f6191a = cls;
        this.f6192b = cls2;
        this.f6193c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        return this.f6191a.equals(jVar.f6191a) && this.f6192b.equals(jVar.f6192b) && l.a((Object) this.f6193c, (Object) jVar.f6193c);
    }

    public int hashCode() {
        int hashCode = ((this.f6191a.hashCode() * 31) + this.f6192b.hashCode()) * 31;
        Class<?> cls = this.f6193c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f6191a + ", second=" + this.f6192b + '}';
    }
}
