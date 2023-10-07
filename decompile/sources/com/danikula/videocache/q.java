package com.danikula.videocache;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.autonavi.base.amap.mapcore.AeUtil;
import java.io.File;

final class q {
    public static File a(Context context) {
        return new File(a(context, true), "video-cache");
    }

    private static File a(Context context, boolean z2) {
        String str;
        try {
            str = Environment.getExternalStorageState();
        } catch (NullPointerException unused) {
            str = "";
        }
        File b2 = (!z2 || !"mounted".equals(str) || Build.VERSION.SDK_INT > 28) ? null : b(context);
        if (b2 == null) {
            b2 = context.getCacheDir();
        }
        if (b2 != null) {
            return b2;
        }
        String str2 = "/data/data/" + context.getPackageName() + "/cache/";
        f.b("Can't define system cache directory! '" + str2 + "%s' will be used.");
        return new File(str2);
    }

    private static File b(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), AeUtil.ROOT_DATA_PATH_OLD_NAME), context.getPackageName()), "cache");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        f.b("Unable to create external cache directory");
        return null;
    }
}
