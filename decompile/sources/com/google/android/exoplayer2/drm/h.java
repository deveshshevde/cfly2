package com.google.android.exoplayer2.drm;

import android.util.Pair;
import java.util.Map;

public final class h {
    private static long a(Map<String, String> map, String str) {
        if (map == null) {
            return -9223372036854775807L;
        }
        try {
            String str2 = map.get(str);
            if (str2 != null) {
                return Long.parseLong(str2);
            }
            return -9223372036854775807L;
        } catch (NumberFormatException unused) {
            return -9223372036854775807L;
        }
    }

    public static Pair<Long, Long> a(DrmSession<?> drmSession) {
        Map<String, String> g2 = drmSession.g();
        if (g2 == null) {
            return null;
        }
        return new Pair<>(Long.valueOf(a(g2, "LicenseDurationRemaining")), Long.valueOf(a(g2, "PlaybackDurationRemaining")));
    }
}
