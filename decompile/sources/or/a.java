package or;

public abstract class a {
    public final String a(Object obj) {
        try {
            return b(obj);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return obj.getClass().getName() + ".errorRendering";
        } catch (Throwable th) {
            rx.exceptions.a.a(th);
            return obj.getClass().getName() + ".errorRendering";
        }
    }

    public void a(Throwable th) {
    }

    /* access modifiers changed from: protected */
    public String b(Object obj) throws InterruptedException {
        return null;
    }
}
