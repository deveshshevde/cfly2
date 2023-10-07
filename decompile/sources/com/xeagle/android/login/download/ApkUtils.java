package com.xeagle.android.login.download;

import android.content.Context;

public class ApkUtils {
    public static synchronized String getAppName(Context context) {
        String string;
        synchronized (ApkUtils.class) {
            try {
                string = context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return string;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0019 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized android.graphics.Bitmap getBitmap(android.content.Context r4) {
        /*
            java.lang.Class<com.xeagle.android.login.download.ApkUtils> r0 = com.xeagle.android.login.download.ApkUtils.class
            monitor-enter(r0)
            r1 = 0
            android.content.Context r2 = r4.getApplicationContext()     // Catch:{ NameNotFoundException -> 0x0018 }
            android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0018 }
            java.lang.String r4 = r4.getPackageName()     // Catch:{ NameNotFoundException -> 0x0019 }
            r3 = 0
            android.content.pm.ApplicationInfo r1 = r2.getApplicationInfo(r4, r3)     // Catch:{ NameNotFoundException -> 0x0019 }
            goto L_0x0019
        L_0x0016:
            r4 = move-exception
            goto L_0x0025
        L_0x0018:
            r2 = r1
        L_0x0019:
            android.graphics.drawable.Drawable r4 = r2.getApplicationIcon(r1)     // Catch:{ all -> 0x0016 }
            android.graphics.drawable.BitmapDrawable r4 = (android.graphics.drawable.BitmapDrawable) r4     // Catch:{ all -> 0x0016 }
            android.graphics.Bitmap r4 = r4.getBitmap()     // Catch:{ all -> 0x0016 }
            monitor-exit(r0)
            return r4
        L_0x0025:
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.download.ApkUtils.getBitmap(android.content.Context):android.graphics.Bitmap");
    }

    public static synchronized String getPackageName(Context context) {
        String str;
        synchronized (ApkUtils.class) {
            try {
                str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return str;
    }

    public static synchronized int getVersionCode(Context context) {
        int i2;
        synchronized (ApkUtils.class) {
            try {
                i2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return i2;
    }

    public static synchronized String getVersionName(Context context) {
        String str;
        synchronized (ApkUtils.class) {
            try {
                str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return str;
    }
}
