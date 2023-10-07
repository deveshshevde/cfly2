package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.util.Locale;

public final class ev {

    /* renamed from: a  reason: collision with root package name */
    static String f8603a = null;

    /* renamed from: b  reason: collision with root package name */
    static boolean f8604b = false;

    /* renamed from: c  reason: collision with root package name */
    private static String f8605c = "";

    /* renamed from: d  reason: collision with root package name */
    private static String f8606d = "";

    /* renamed from: e  reason: collision with root package name */
    private static String f8607e = "";

    /* renamed from: f  reason: collision with root package name */
    private static String f8608f = "";

    public static String a(Context context) {
        try {
            return h(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return f8608f;
        }
    }

    static void a(final Context context, final String str) {
        if (!TextUtils.isEmpty(str)) {
            f8608f = str;
            if (context != null) {
                id.a().a(new ie() {
                    /* JADX WARNING: Removed duplicated region for block: B:21:0x0045 A[SYNTHETIC, Splitter:B:21:0x0045] */
                    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void runTask() {
                        /*
                            r5 = this;
                            r0 = 0
                            android.content.Context r1 = r2     // Catch:{ all -> 0x003b }
                            java.lang.String r2 = "k.store"
                            java.lang.String r1 = com.amap.api.mapcore.util.fx.c(r1, r2)     // Catch:{ all -> 0x003b }
                            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x003b }
                            r2.<init>(r1)     // Catch:{ all -> 0x003b }
                            java.io.File r1 = r2.getParentFile()     // Catch:{ all -> 0x003b }
                            boolean r1 = r1.exists()     // Catch:{ all -> 0x003b }
                            if (r1 != 0) goto L_0x001f
                            java.io.File r1 = r2.getParentFile()     // Catch:{ all -> 0x003b }
                            r1.mkdirs()     // Catch:{ all -> 0x003b }
                        L_0x001f:
                            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x003b }
                            r1.<init>(r2)     // Catch:{ all -> 0x003b }
                            java.lang.String r0 = r3     // Catch:{ all -> 0x0036 }
                            byte[] r0 = com.amap.api.mapcore.util.fg.a((java.lang.String) r0)     // Catch:{ all -> 0x0036 }
                            r1.write(r0)     // Catch:{ all -> 0x0036 }
                            r1.close()     // Catch:{ all -> 0x0031 }
                            return
                        L_0x0031:
                            r0 = move-exception
                            r0.printStackTrace()
                            return
                        L_0x0036:
                            r0 = move-exception
                            r4 = r1
                            r1 = r0
                            r0 = r4
                            goto L_0x003c
                        L_0x003b:
                            r1 = move-exception
                        L_0x003c:
                            java.lang.String r2 = "AI"
                            java.lang.String r3 = "stf"
                            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r1, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x004e }
                            if (r0 == 0) goto L_0x004d
                            r0.close()     // Catch:{ all -> 0x0049 }
                            return
                        L_0x0049:
                            r0 = move-exception
                            r0.printStackTrace()
                        L_0x004d:
                            return
                        L_0x004e:
                            r1 = move-exception
                            if (r0 == 0) goto L_0x0059
                            r0.close()     // Catch:{ all -> 0x0055 }
                            goto L_0x0059
                        L_0x0055:
                            r0 = move-exception
                            r0.printStackTrace()
                        L_0x0059:
                            throw r1
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ev.AnonymousClass1.runTask():void");
                    }
                });
            }
        }
    }

    static boolean a() {
        try {
            if (f8604b) {
                return true;
            }
            if (a(f8603a)) {
                f8604b = true;
                return true;
            } else if (!TextUtils.isEmpty(f8603a)) {
                f8604b = false;
                f8603a = null;
                return false;
            } else if (a(f8606d)) {
                f8604b = true;
                return true;
            } else {
                if (!TextUtils.isEmpty(f8606d)) {
                    f8604b = false;
                    f8606d = null;
                    return false;
                }
                return true;
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.toCharArray();
        for (char c2 : str.toCharArray()) {
            if (('A' > c2 || c2 > 'z') && (('0' > c2 || c2 > ':') && c2 != '.')) {
                try {
                    fz.b(fg.a(), str, "errorPackage");
                } catch (Throwable unused) {
                }
                return false;
            }
        }
        return true;
    }

    public static String b(Context context) {
        try {
            if (!"".equals(f8605c)) {
                return f8605c;
            }
            PackageManager packageManager = context.getPackageManager();
            f8605c = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
            return f8605c;
        } catch (Throwable th) {
            fw.a(th, "AI", "gAN");
        }
    }

    public static String c(Context context) {
        try {
            String str = f8606d;
            if (str != null && !"".equals(str)) {
                return f8606d;
            }
            String packageName = context.getPackageName();
            f8606d = packageName;
            if (!a(packageName)) {
                f8606d = context.getPackageName();
            }
            return f8606d;
        } catch (Throwable th) {
            fw.a(th, "AI", "gpck");
        }
    }

    public static String d(Context context) {
        try {
            if (!"".equals(f8607e)) {
                return f8607e;
            }
            f8607e = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            String str = f8607e;
            return str == null ? "" : str;
        } catch (Throwable th) {
            fw.a(th, "AI", "gAV");
        }
    }

    public static String e(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            byte[] digest = MessageDigest.getInstance(fg.c("IU0hBMQ")).digest(packageInfo.signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : digest) {
                String upperCase = Integer.toHexString(b2 & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                stringBuffer.append(":");
            }
            String str = packageInfo.packageName;
            if (a(str)) {
                str = packageInfo.packageName;
            }
            if (!TextUtils.isEmpty(f8606d)) {
                str = c(context);
            }
            stringBuffer.append(str);
            String stringBuffer2 = stringBuffer.toString();
            f8603a = stringBuffer2;
            return stringBuffer2;
        } catch (Throwable th) {
            fw.a(th, "AI", "gsp");
            return f8603a;
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0003 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String f(android.content.Context r2) {
        /*
            com.amap.api.mapcore.util.ew.a((android.content.Context) r2)     // Catch:{ all -> 0x0003 }
        L_0x0003:
            java.lang.String r2 = h(r2)     // Catch:{ all -> 0x0008 }
            return r2
        L_0x0008:
            r2 = move-exception
            java.lang.String r0 = "AI"
            java.lang.String r1 = "gKy"
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r0, (java.lang.String) r1)
            java.lang.String r2 = f8608f
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ev.f(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c A[Catch:{ all -> 0x0050, all -> 0x005f }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0056 A[SYNTHETIC, Splitter:B:30:0x0056] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String g(android.content.Context r6) {
        /*
            java.lang.String r0 = "k.store"
            java.lang.String r6 = com.amap.api.mapcore.util.fx.c(r6, r0)
            java.io.File r0 = new java.io.File
            r0.<init>(r6)
            boolean r6 = r0.exists()
            java.lang.String r1 = ""
            if (r6 != 0) goto L_0x0014
            return r1
        L_0x0014:
            r6 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x003b }
            r2.<init>(r0)     // Catch:{ all -> 0x003b }
            int r6 = r2.available()     // Catch:{ all -> 0x0039 }
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x0039 }
            r2.read(r6)     // Catch:{ all -> 0x0039 }
            java.lang.String r6 = com.amap.api.mapcore.util.fg.a((byte[]) r6)     // Catch:{ all -> 0x0039 }
            int r0 = r6.length()     // Catch:{ all -> 0x0039 }
            r3 = 32
            if (r0 != r3) goto L_0x0030
            r1 = r6
        L_0x0030:
            r2.close()     // Catch:{ all -> 0x0034 }
            goto L_0x0038
        L_0x0034:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0038:
            return r1
        L_0x0039:
            r6 = move-exception
            goto L_0x003f
        L_0x003b:
            r2 = move-exception
            r5 = r2
            r2 = r6
            r6 = r5
        L_0x003f:
            java.lang.String r3 = "AI"
            java.lang.String r4 = "gKe"
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r6, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x005f }
            boolean r6 = r0.exists()     // Catch:{ all -> 0x0050 }
            if (r6 == 0) goto L_0x0054
            r0.delete()     // Catch:{ all -> 0x0050 }
            goto L_0x0054
        L_0x0050:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x005f }
        L_0x0054:
            if (r2 == 0) goto L_0x005e
            r2.close()     // Catch:{ all -> 0x005a }
            goto L_0x005e
        L_0x005a:
            r6 = move-exception
            r6.printStackTrace()
        L_0x005e:
            return r1
        L_0x005f:
            r6 = move-exception
            if (r2 == 0) goto L_0x006a
            r2.close()     // Catch:{ all -> 0x0066 }
            goto L_0x006a
        L_0x0066:
            r0 = move-exception
            r0.printStackTrace()
        L_0x006a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ev.g(android.content.Context):java.lang.String");
    }

    private static String h(Context context) throws PackageManager.NameNotFoundException {
        String str = f8608f;
        if (str == null || str.equals("")) {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return f8608f;
            }
            String string = applicationInfo.metaData.getString("com.amap.api.v2.apikey");
            f8608f = string;
            if (string == null) {
                f8608f = g(context);
            }
        }
        return f8608f;
    }
}
