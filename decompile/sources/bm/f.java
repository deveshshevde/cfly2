package bm;

import android.content.Context;
import bm.d;
import java.io.File;

public final class f extends d {
    public f(Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public f(final Context context, final String str, long j2) {
        super((d.a) new d.a() {
            public File a() {
                File cacheDir = context.getCacheDir();
                if (cacheDir == null) {
                    return null;
                }
                return str != null ? new File(cacheDir, str) : cacheDir;
            }
        }, j2);
    }
}
