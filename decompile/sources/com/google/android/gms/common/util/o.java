package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import gi.c;
import java.lang.reflect.Method;

public class o {

    /* renamed from: a  reason: collision with root package name */
    private static final int f17965a = Process.myUid();

    /* renamed from: b  reason: collision with root package name */
    private static final Method f17966b;

    /* renamed from: c  reason: collision with root package name */
    private static final Method f17967c;

    /* renamed from: d  reason: collision with root package name */
    private static final Method f17968d;

    /* renamed from: e  reason: collision with root package name */
    private static final Method f17969e;

    /* renamed from: f  reason: collision with root package name */
    private static final Method f17970f;

    /* renamed from: g  reason: collision with root package name */
    private static final Method f17971g;

    /* renamed from: h  reason: collision with root package name */
    private static final Method f17972h;

    /* renamed from: i  reason: collision with root package name */
    private static final Method f17973i;

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005c A[SYNTHETIC, Splitter:B:23:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b6  */
    static {
        /*
            java.lang.String r0 = "add"
            int r1 = android.os.Process.myUid()
            f17965a = r1
            r1 = 1
            r2 = 0
            r3 = 0
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0018 }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0018 }
            r4[r2] = r5     // Catch:{ Exception -> 0x0018 }
            java.lang.Class<android.os.WorkSource> r5 = android.os.WorkSource.class
            java.lang.reflect.Method r4 = r5.getMethod(r0, r4)     // Catch:{ Exception -> 0x0018 }
            goto L_0x0019
        L_0x0018:
            r4 = r3
        L_0x0019:
            f17966b = r4
            boolean r4 = com.google.android.gms.common.util.l.b()
            r5 = 2
            if (r4 == 0) goto L_0x0033
            java.lang.Class[] r4 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x0033 }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0033 }
            r4[r2] = r6     // Catch:{ Exception -> 0x0033 }
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r4[r1] = r6     // Catch:{ Exception -> 0x0033 }
            java.lang.Class<android.os.WorkSource> r6 = android.os.WorkSource.class
            java.lang.reflect.Method r0 = r6.getMethod(r0, r4)     // Catch:{ Exception -> 0x0033 }
            goto L_0x0034
        L_0x0033:
            r0 = r3
        L_0x0034:
            f17967c = r0
            java.lang.Class<android.os.WorkSource> r0 = android.os.WorkSource.class
            java.lang.String r4 = "size"
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0041 }
            java.lang.reflect.Method r0 = r0.getMethod(r4, r6)     // Catch:{ Exception -> 0x0041 }
            goto L_0x0042
        L_0x0041:
            r0 = r3
        L_0x0042:
            f17968d = r0
            java.lang.Class[] r0 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0053 }
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0053 }
            r0[r2] = r4     // Catch:{ Exception -> 0x0053 }
            java.lang.Class<android.os.WorkSource> r4 = android.os.WorkSource.class
            java.lang.String r6 = "get"
            java.lang.reflect.Method r0 = r4.getMethod(r6, r0)     // Catch:{ Exception -> 0x0053 }
            goto L_0x0054
        L_0x0053:
            r0 = r3
        L_0x0054:
            f17969e = r0
            boolean r0 = com.google.android.gms.common.util.l.b()
            if (r0 == 0) goto L_0x006b
            java.lang.Class[] r0 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x006b }
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x006b }
            r0[r2] = r4     // Catch:{ Exception -> 0x006b }
            java.lang.Class<android.os.WorkSource> r4 = android.os.WorkSource.class
            java.lang.String r6 = "getName"
            java.lang.reflect.Method r0 = r4.getMethod(r6, r0)     // Catch:{ Exception -> 0x006b }
            goto L_0x006c
        L_0x006b:
            r0 = r3
        L_0x006c:
            f17970f = r0
            boolean r0 = com.google.android.gms.common.util.l.g()
            java.lang.String r4 = "WorkSourceUtil"
            if (r0 == 0) goto L_0x0087
            java.lang.Class<android.os.WorkSource> r0 = android.os.WorkSource.class
            java.lang.String r6 = "createWorkChain"
            java.lang.Class[] r7 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0081 }
            java.lang.reflect.Method r0 = r0.getMethod(r6, r7)     // Catch:{ Exception -> 0x0081 }
            goto L_0x0088
        L_0x0081:
            r0 = move-exception
            java.lang.String r6 = "Missing WorkChain API createWorkChain"
            android.util.Log.w(r4, r6, r0)
        L_0x0087:
            r0 = r3
        L_0x0088:
            f17971g = r0
            boolean r0 = com.google.android.gms.common.util.l.g()
            if (r0 == 0) goto L_0x00ad
            java.lang.String r0 = "android.os.WorkSource$WorkChain"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x00a7 }
            java.lang.Class[] r5 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x00a7 }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x00a7 }
            r5[r2] = r6     // Catch:{ Exception -> 0x00a7 }
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r5[r1] = r6     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r6 = "addNode"
            java.lang.reflect.Method r0 = r0.getMethod(r6, r5)     // Catch:{ Exception -> 0x00a7 }
            goto L_0x00ae
        L_0x00a7:
            r0 = move-exception
            java.lang.String r5 = "Missing WorkChain class"
            android.util.Log.w(r4, r5, r0)
        L_0x00ad:
            r0 = r3
        L_0x00ae:
            f17972h = r0
            boolean r0 = com.google.android.gms.common.util.l.g()
            if (r0 == 0) goto L_0x00c3
            java.lang.Class<android.os.WorkSource> r0 = android.os.WorkSource.class
            java.lang.String r4 = "isEmpty"
            java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x00c3 }
            java.lang.reflect.Method r3 = r0.getMethod(r4, r2)     // Catch:{ Exception -> 0x00c3 }
            r3.setAccessible(r1)     // Catch:{ Exception -> 0x00c3 }
        L_0x00c3:
            f17973i = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.o.<clinit>():void");
    }

    public static WorkSource a(Context context, String str) {
        if (!(context == null || context.getPackageManager() == null || str == null)) {
            try {
                ApplicationInfo a2 = c.a(context).a(str, 0);
                if (a2 == null) {
                    Log.e("WorkSourceUtil", str.length() != 0 ? "Could not get applicationInfo from package: ".concat(str) : new String("Could not get applicationInfo from package: "));
                    return null;
                }
                int i2 = a2.uid;
                WorkSource workSource = new WorkSource();
                a(workSource, i2, str);
                return workSource;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("WorkSourceUtil", str.length() != 0 ? "Could not find package: ".concat(str) : new String("Could not find package: "));
            }
        }
        return null;
    }

    public static void a(WorkSource workSource, int i2, String str) {
        Method method = f17967c;
        if (method != null) {
            if (str == null) {
                str = "";
            }
            try {
                method.invoke(workSource, new Object[]{Integer.valueOf(i2), str});
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            }
        } else {
            Method method2 = f17966b;
            if (method2 != null) {
                try {
                    method2.invoke(workSource, new Object[]{Integer.valueOf(i2)});
                } catch (Exception e3) {
                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e3);
                }
            }
        }
    }

    public static boolean a(Context context) {
        return (context == null || context.getPackageManager() == null || c.a(context).a("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != 0) ? false : true;
    }
}
