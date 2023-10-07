package androidx.work;

public interface l {

    /* renamed from: a  reason: collision with root package name */
    public static final a.c f5450a = new a.c();

    /* renamed from: b  reason: collision with root package name */
    public static final a.b f5451b = new a.b();

    public static abstract class a {

        /* renamed from: androidx.work.l$a$a  reason: collision with other inner class name */
        public static final class C0046a extends a {

            /* renamed from: a  reason: collision with root package name */
            private final Throwable f5452a;

            public C0046a(Throwable th) {
                this.f5452a = th;
            }

            public Throwable a() {
                return this.f5452a;
            }

            public String toString() {
                return String.format("FAILURE (%s)", new Object[]{this.f5452a.getMessage()});
            }
        }

        public static final class b extends a {
            private b() {
            }

            public String toString() {
                return "IN_PROGRESS";
            }
        }

        public static final class c extends a {
            private c() {
            }

            public String toString() {
                return "SUCCESS";
            }
        }

        a() {
        }
    }
}
