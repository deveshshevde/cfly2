package com.blankj.utilcode.util;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class DebouncingUtils {
    private static final int CACHE_SIZE = 64;
    private static final long DEBOUNCING_DEFAULT_VALUE = 1000;
    private static final Map<String, Long> KEY_MILLIS_MAP = new ConcurrentHashMap(64);

    private DebouncingUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static void clearIfNecessary(long j2) {
        Map<String, Long> map = KEY_MILLIS_MAP;
        if (map.size() >= 64) {
            Iterator<Map.Entry<String, Long>> it2 = map.entrySet().iterator();
            while (it2.hasNext()) {
                if (j2 >= ((Long) it2.next().getValue()).longValue()) {
                    it2.remove();
                }
            }
        }
    }

    public static boolean isValid(View view) {
        Objects.requireNonNull(view, "Argument 'view' of type View (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return isValid(view, (long) DEBOUNCING_DEFAULT_VALUE);
    }

    public static boolean isValid(View view, long j2) {
        Objects.requireNonNull(view, "Argument 'view' of type View (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return isValid(String.valueOf(view.hashCode()), j2);
    }

    public static boolean isValid(String str, long j2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("The key is null.");
        } else if (j2 >= 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            clearIfNecessary(elapsedRealtime);
            Map<String, Long> map = KEY_MILLIS_MAP;
            Long l2 = map.get(str);
            if (l2 != null && elapsedRealtime < l2.longValue()) {
                return false;
            }
            map.put(str, Long.valueOf(elapsedRealtime + j2));
            return true;
        } else {
            throw new IllegalArgumentException("The duration is less than 0.");
        }
    }
}
