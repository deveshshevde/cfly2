package ds;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f26769a = new C0167b();

    /* renamed from: b  reason: collision with root package name */
    private static volatile c f26770b = null;

    public interface a {
    }

    /* renamed from: ds.b$b  reason: collision with other inner class name */
    private static final class C0167b implements a {
        private C0167b() {
        }
    }

    public interface c {
        void a();

        void a(String str);

        boolean b();
    }

    private b() {
    }

    public static void a() {
        c().a();
    }

    public static void a(String str) {
        c().a(str);
    }

    public static boolean b() {
        return c().b();
    }

    private static c c() {
        if (f26770b == null) {
            synchronized (b.class) {
                if (f26770b == null) {
                    f26770b = new a();
                }
            }
        }
        return f26770b;
    }
}
