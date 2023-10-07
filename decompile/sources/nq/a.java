package nq;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static int f31610a;

    /* renamed from: b  reason: collision with root package name */
    private static int f31611b;

    public static int a() {
        if (f31610a == 0) {
            String substring = System.getProperty("os.name").substring(0, 3);
            f31610a = substring.compareToIgnoreCase("win") == 0 ? 1 : substring.compareToIgnoreCase("lin") == 0 ? 2 : -1;
        }
        return f31610a;
    }
}
