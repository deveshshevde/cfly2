package com.xeagle.android.editor.widget.bubbleSeekBar;

import android.content.res.Resources;
import android.util.TypedValue;
import java.util.Properties;

class a {

    /* renamed from: a  reason: collision with root package name */
    private static Properties f23030a = new Properties();

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f23031b;

    static int a(int i2) {
        return (int) TypedValue.applyDimension(1, (float) i2, Resources.getSystem().getDisplayMetrics());
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0039 A[SYNTHETIC, Splitter:B:21:0x0039] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004a A[SYNTHETIC, Splitter:B:27:0x004a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean a() {
        /*
            java.lang.Boolean r0 = f23031b
            if (r0 == 0) goto L_0x0009
            boolean r0 = r0.booleanValue()
            return r0
        L_0x0009:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            java.lang.String r2 = "ro.miui.ui.version.name"
            r3 = 0
            if (r0 >= r1) goto L_0x0053
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0033 }
            java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x0033 }
            java.io.File r4 = android.os.Environment.getRootDirectory()     // Catch:{ IOException -> 0x0033 }
            java.lang.String r5 = "build.prop"
            r1.<init>(r4, r5)     // Catch:{ IOException -> 0x0033 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0033 }
            java.util.Properties r1 = f23030a     // Catch:{ IOException -> 0x002e, all -> 0x002b }
            r1.load(r0)     // Catch:{ IOException -> 0x002e, all -> 0x002b }
            r0.close()     // Catch:{ IOException -> 0x003d }
            goto L_0x0041
        L_0x002b:
            r1 = move-exception
            r3 = r0
            goto L_0x0048
        L_0x002e:
            r1 = move-exception
            r3 = r0
            goto L_0x0034
        L_0x0031:
            r1 = move-exception
            goto L_0x0048
        L_0x0033:
            r1 = move-exception
        L_0x0034:
            r1.printStackTrace()     // Catch:{ all -> 0x0031 }
            if (r3 == 0) goto L_0x0041
            r3.close()     // Catch:{ IOException -> 0x003d }
            goto L_0x0041
        L_0x003d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0041:
            java.util.Properties r0 = f23030a
            boolean r0 = r0.containsKey(r2)
            goto L_0x0080
        L_0x0048:
            if (r3 == 0) goto L_0x0052
            r3.close()     // Catch:{ IOException -> 0x004e }
            goto L_0x0052
        L_0x004e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0052:
            throw r1
        L_0x0053:
            r0 = 0
            java.lang.String r1 = "android.os.SystemProperties"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ Exception -> 0x0080 }
            java.lang.String r4 = "get"
            r5 = 1
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x0080 }
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r6[r0] = r7     // Catch:{ Exception -> 0x0080 }
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r4, r6)     // Catch:{ Exception -> 0x0080 }
            java.lang.Object[] r4 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0080 }
            r4[r0] = r2     // Catch:{ Exception -> 0x0080 }
            java.lang.Object r1 = r1.invoke(r3, r4)     // Catch:{ Exception -> 0x0080 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0080 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0080 }
            if (r1 != 0) goto L_0x0078
            goto L_0x0079
        L_0x0078:
            r5 = 0
        L_0x0079:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x0080 }
            f23031b = r1     // Catch:{ Exception -> 0x0080 }
            goto L_0x0086
        L_0x0080:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            f23031b = r0
        L_0x0086:
            java.lang.Boolean r0 = f23031b
            boolean r0 = r0.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.editor.widget.bubbleSeekBar.a.a():boolean");
    }

    static int b(int i2) {
        return (int) TypedValue.applyDimension(2, (float) i2, Resources.getSystem().getDisplayMetrics());
    }
}
