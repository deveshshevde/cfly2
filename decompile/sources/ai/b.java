package ai;

import android.os.Trace;

final class b {
    public static void a() {
        Trace.endSection();
    }

    public static void a(String str) {
        Trace.beginSection(str);
    }
}
