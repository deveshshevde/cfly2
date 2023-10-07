package bh;

import java.util.Map;

public class b {
    public static boolean a(Map<?, ?> map) {
        return !b(map);
    }

    public static boolean b(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }
}
