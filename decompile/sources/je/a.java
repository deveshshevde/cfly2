package je;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Class<? extends b> f29483a;

    public static b a() {
        if (f29483a == null) {
            f29483a = c.class;
        }
        try {
            return (b) f29483a.newInstance();
        } catch (InstantiationException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return null;
        }
    }
}
