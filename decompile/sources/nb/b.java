package nb;

public abstract class b implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    protected final String f31312c;

    public b(String str, Object... objArr) {
        this.f31312c = c.a(str, objArr);
    }

    /* access modifiers changed from: protected */
    public abstract void d();

    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f31312c);
        try {
            d();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
