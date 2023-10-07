package fj;

public interface s {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final t f27402a;

        /* renamed from: b  reason: collision with root package name */
        public final t f27403b;

        public a(t tVar) {
            this(tVar, tVar);
        }

        public a(t tVar, t tVar2) {
            this.f27402a = (t) com.google.android.exoplayer2.util.a.b(tVar);
            this.f27403b = (t) com.google.android.exoplayer2.util.a.b(tVar2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f27402a.equals(aVar.f27402a) && this.f27403b.equals(aVar.f27403b);
        }

        public int hashCode() {
            return (this.f27402a.hashCode() * 31) + this.f27403b.hashCode();
        }

        public String toString() {
            String str;
            String valueOf = String.valueOf(this.f27402a);
            if (this.f27402a.equals(this.f27403b)) {
                str = "";
            } else {
                String valueOf2 = String.valueOf(this.f27403b);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 2);
                sb.append(", ");
                sb.append(valueOf2);
                str = sb.toString();
            }
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 2 + String.valueOf(str).length());
            sb2.append("[");
            sb2.append(valueOf);
            sb2.append(str);
            sb2.append("]");
            return sb2.toString();
        }
    }

    public static class b implements s {

        /* renamed from: a  reason: collision with root package name */
        private final long f27404a;

        /* renamed from: b  reason: collision with root package name */
        private final a f27405b;

        public b(long j2) {
            this(j2, 0);
        }

        public b(long j2, long j3) {
            this.f27404a = j2;
            this.f27405b = new a(j3 == 0 ? t.f27406a : new t(0, j3));
        }

        public a a(long j2) {
            return this.f27405b;
        }

        public boolean a() {
            return false;
        }

        public long b() {
            return this.f27404a;
        }
    }

    a a(long j2);

    boolean a();

    long b();
}
