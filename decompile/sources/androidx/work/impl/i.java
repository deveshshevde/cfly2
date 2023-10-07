package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.work.j;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5291a = j.a("WrkDbPathHelper");

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f5292b = {"-journal", "-shm", "-wal"};

    private static File a(Context context, String str) {
        return new File(context.getNoBackupFilesDir(), str);
    }

    public static String a() {
        return "androidx.work.workdb";
    }

    public static void a(Context context) {
        String str;
        File c2 = c(context);
        if (Build.VERSION.SDK_INT >= 23 && c2.exists()) {
            j.a().b(f5291a, "Migrating WorkDatabase to the no-backup directory", new Throwable[0]);
            Map<File, File> b2 = b(context);
            for (File next : b2.keySet()) {
                File file = b2.get(next);
                if (next.exists() && file != null) {
                    if (file.exists()) {
                        j.a().d(f5291a, String.format("Over-writing contents of %s", new Object[]{file}), new Throwable[0]);
                    }
                    if (next.renameTo(file)) {
                        str = String.format("Migrated %s to %s", new Object[]{next, file});
                    } else {
                        str = String.format("Renaming %s to %s failed", new Object[]{next, file});
                    }
                    j.a().b(f5291a, str, new Throwable[0]);
                }
            }
        }
    }

    public static Map<File, File> b(Context context) {
        HashMap hashMap = new HashMap();
        if (Build.VERSION.SDK_INT >= 23) {
            File c2 = c(context);
            File d2 = d(context);
            hashMap.put(c2, d2);
            for (String str : f5292b) {
                hashMap.put(new File(c2.getPath() + str), new File(d2.getPath() + str));
            }
        }
        return hashMap;
    }

    public static File c(Context context) {
        return context.getDatabasePath("androidx.work.workdb");
    }

    public static File d(Context context) {
        return Build.VERSION.SDK_INT < 23 ? c(context) : a(context, "androidx.work.workdb");
    }
}
