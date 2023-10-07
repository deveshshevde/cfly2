package kotlinx.coroutines.internal;

final /* synthetic */ class y {

    /* renamed from: a  reason: collision with root package name */
    private static final int f30439a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return f30439a;
    }

    public static final String a(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
