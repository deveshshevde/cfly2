package hf;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static long f13321a;

    public static boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = currentTimeMillis - f13321a < 3000;
        if (!z2) {
            f13321a = currentTimeMillis;
        }
        return z2;
    }
}
