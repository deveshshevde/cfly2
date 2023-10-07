package com.xeagle.android.utils;

import com.xeagle.android.login.retrofitLogin.UserGlobal;
import com.xeagle.android.utils.prefs.a;

public class h {
    public static boolean a(a aVar) {
        return aVar.j().equalsIgnoreCase(UserGlobal.DRONE_NAME_DF812_E);
    }

    public static boolean a(a aVar, en.a aVar2) {
        return (aVar2.y() != null && aVar2.y().contains(UserGlobal.DRONE_TYPE_DF808_D)) || !aVar.j().contains(UserGlobal.DRONE_NAME_DF808) || aVar2.z() >= 4.3d;
    }

    public static boolean a(en.a aVar) {
        return aVar.y() != null && aVar.y().contains(UserGlobal.DRONE_TYPE_DF808) && !aVar.y().contains(UserGlobal.DRONE_TYPE_DF808_D) && aVar.z() < 3.7d;
    }

    public static boolean a(String str) {
        return str.equalsIgnoreCase(UserGlobal.DRONE_NAME_DF808_D) || str.equals(UserGlobal.DRONE_NAME_DF809_D) || str.equals(UserGlobal.DRONE_NAME_DF812_D) || str.equals(UserGlobal.DRONE_NAME_DF809_E) || str.equals(UserGlobal.DRONE_NAME_DF812_E);
    }

    public static boolean b(a aVar) {
        return aVar.j().equalsIgnoreCase(UserGlobal.DRONE_NAME_DF809_E) || aVar.j().equalsIgnoreCase(UserGlobal.DRONE_NAME_DF808_D) || aVar.j().equalsIgnoreCase(UserGlobal.DRONE_NAME_DF809_D);
    }

    public static boolean b(a aVar, en.a aVar2) {
        return (aVar2.y() != null && aVar2.y().contains(UserGlobal.DRONE_TYPE_DF808_D)) || !aVar.j().contains(UserGlobal.DRONE_NAME_DF808) || aVar2.z() > 4.2d;
    }

    public static boolean b(en.a aVar) {
        return aVar.y() != null && (aVar.y().contains(UserGlobal.DRONE_TYPE_DF808_D) || !aVar.y().contains(UserGlobal.DRONE_TYPE_DF808) || aVar.z() >= 3.7d);
    }

    public static boolean b(String str) {
        return str.contains(UserGlobal.DRONE_NAME_DF816);
    }

    public static boolean c(a aVar, en.a aVar2) {
        return aVar2.y() != null && (aVar2.y().contains(UserGlobal.DRONE_TYPE_DF808_D) || !aVar.j().contains(UserGlobal.DRONE_NAME_DF808));
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0060 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean c(en.a r8) {
        /*
            java.lang.String r0 = r8.y()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.lang.String r8 = r8.y()
            java.lang.String r0 = "v"
            int r2 = r8.indexOf(r0)
            r3 = 1
            int r2 = r2 + r3
            int r0 = r8.indexOf(r0)
            int r0 = r0 + 4
            java.lang.String r0 = r8.substring(r2, r0)
            double r4 = java.lang.Double.parseDouble(r0)
            java.lang.String r0 = "808-D"
            boolean r0 = r8.contains(r0)
            if (r0 == 0) goto L_0x0034
            r6 = 4618891777831180698(0x401999999999999a, double:6.4)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 < 0) goto L_0x0061
            goto L_0x0060
        L_0x0034:
            java.lang.String r0 = "809-E"
            boolean r0 = r8.contains(r0)
            if (r0 == 0) goto L_0x0046
            r6 = 4617090337980232499(0x4013333333333333, double:4.8)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 < 0) goto L_0x0061
            goto L_0x0060
        L_0x0046:
            java.lang.String r0 = "809-D"
            boolean r0 = r8.contains(r0)
            if (r0 == 0) goto L_0x0058
            r6 = 4616977747989548237(0x4012cccccccccccd, double:4.7)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 < 0) goto L_0x0061
            goto L_0x0060
        L_0x0058:
            java.lang.String r0 = "812-E"
            boolean r8 = r8.contains(r0)
            if (r8 == 0) goto L_0x0061
        L_0x0060:
            r1 = 1
        L_0x0061:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.utils.h.c(en.a):boolean");
    }

    public static boolean c(String str) {
        return str.contains("vK") || str.contains("vF");
    }

    public static boolean d(a aVar, en.a aVar2) {
        return (aVar2.y() != null && aVar2.y().contains(UserGlobal.DRONE_TYPE_DF808_D)) || !aVar.j().contains(UserGlobal.DRONE_NAME_DF808) || aVar2.z() >= 3.6d;
    }

    public static boolean d(en.a aVar) {
        return aVar.y() != null && aVar.y().contains(UserGlobal.DRONE_NAME_DF812_E);
    }

    public static boolean e(a aVar, en.a aVar2) {
        return aVar2.y() != null && (!aVar.j().contains(UserGlobal.DRONE_NAME_DF808) || aVar2.z() > 2.9d);
    }

    public static boolean f(a aVar, en.a aVar2) {
        return aVar2.y() != null && (aVar2.y().contains(UserGlobal.DRONE_TYPE_DF808_D) || !aVar.j().contains(UserGlobal.DRONE_NAME_DF808));
    }
}
