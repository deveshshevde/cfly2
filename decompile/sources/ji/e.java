package ji;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static Class<? extends c> f13820a;

    public static c a() {
        if (f13820a == null) {
            f13820a = d.class;
        }
        try {
            return (c) f13820a.newInstance();
        } catch (InstantiationException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static void a(Class<? extends c> cls) {
        f13820a = cls;
    }
}
