package kb;

public class b {
    public static void a(int i2, int i3) {
        a((Object) Integer.valueOf(i2), (Object) Integer.valueOf(i3));
    }

    public static void a(Object obj, Object obj2) {
        if (obj == obj2) {
            return;
        }
        if (obj == null || obj2 == null || !obj.equals(obj2)) {
            throw new AssertionError("expected " + obj + ", got " + obj2);
        }
    }

    public static void b(int i2, int i3) {
        if (i2 <= i3) {
            throw new AssertionError("unexpected " + i2 + " <= " + i3);
        }
    }
}
