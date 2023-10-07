package cd;

public abstract class c {

    private static class a extends c {

        /* renamed from: a  reason: collision with root package name */
        private volatile boolean f6203a;

        a() {
            super();
        }

        public void a(boolean z2) {
            this.f6203a = z2;
        }

        public void b() {
            if (this.f6203a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    private c() {
    }

    public static c a() {
        return new a();
    }

    /* access modifiers changed from: package-private */
    public abstract void a(boolean z2);

    public abstract void b();
}
