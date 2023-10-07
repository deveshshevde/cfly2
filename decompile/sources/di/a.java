package di;

public class a {
    public static int a(int i2, int i3) {
        return ((i2 + 31) * 31) + i3;
    }

    public static int a(Object obj, Object obj2) {
        int i2 = 0;
        int hashCode = obj == null ? 0 : obj.hashCode();
        if (obj2 != null) {
            i2 = obj2.hashCode();
        }
        return a(hashCode, i2);
    }
}
