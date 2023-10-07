package kf;

import android.util.Log;
import com.xeagle.android.hicamera.net.b;
import com.xeagle.android.hicamera.unity.a;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.TreeMap;

public class c {
    public static int a(String str, int i2) {
        return b.b(String.format("http://%s%s/settimelapseinfo.cgi?&-time=%d", new Object[]{str, "/cgi-bin/hi3510", Integer.valueOf(i2)}));
    }

    public static int a(String str, int i2, int i3) {
        if (i2 < 0 || i2 > 3 || i3 < 0 || i3 > 18) {
            Log.e("setBurstInfo", "Invalid args");
            return -1;
        }
        return b.b(String.format("http://%s%s/setburstinfo.cgi?&-time=%d&-count=%d", new Object[]{str, "/cgi-bin/hi3510", Integer.valueOf(i2), Integer.valueOf(i3)}));
    }

    public static int a(String str, String str2) {
        return b.b(String.format("http://%s%s/setbootaction.cgi?&-action=%s", new Object[]{str, "/cgi-bin/hi3510", str2}));
    }

    public static int a(String str, String str2, int i2) {
        return b.b(String.format("http://%s%s/setvideoinfo.cgi?&-resolution=%s&-fps=%d", new Object[]{str, "/cgi-bin/hi3510", str2, Integer.valueOf(i2)}));
    }

    public static int a(String str, GregorianCalendar gregorianCalendar) {
        if (gregorianCalendar == null) {
            return -1;
        }
        return b.b(String.format("http://%s%s/setsystime.cgi?&-time=%04d%02d%02d%02d%02d%02d", new Object[]{str, "/cgi-bin/hi3510", Integer.valueOf(gregorianCalendar.get(1)), Integer.valueOf(gregorianCalendar.get(2) + 1), Integer.valueOf(gregorianCalendar.get(5)), Integer.valueOf(gregorianCalendar.get(11)), Integer.valueOf(gregorianCalendar.get(12)), Integer.valueOf(gregorianCalendar.get(13))}));
    }

    public static int a(String str, Map<String, String> map) {
        return b.a(String.format("http://%s%s/getvideoinfo.cgi?", new Object[]{str, "/cgi-bin/hi3510"}), map);
    }

    public static int a(String str, boolean z2) {
        return b.b(String.format("http://%s%s/setflip.cgi?&-enable=%d", new Object[]{str, "/cgi-bin/hi3510", Integer.valueOf(z2 ? 1 : 0)}));
    }

    public static a.c a(String str) {
        TreeMap treeMap = new TreeMap();
        int i2 = 2;
        if (-1 == b.a(String.format("http://%s%s/getsdstate.cgi?", new Object[]{str, "/cgi-bin/hi3510"}), (Map<String, String>) treeMap)) {
            return null;
        }
        a.c cVar = new a.c();
        String str2 = (String) treeMap.get("sdstate");
        String str3 = (String) treeMap.get("total");
        String str4 = (String) treeMap.get("used");
        if (str2.equals("SDOK")) {
            cVar.f23745a = 0;
        } else if (str2.equals("SDFULL")) {
            cVar.f23745a = 1;
        } else {
            if (!str2.equals("SDNONE")) {
                if (!str2.equals("SDERROR")) {
                    return null;
                }
                i2 = 3;
            }
            cVar.f23745a = i2;
        }
        if (str3 != null) {
            cVar.f23746b = Integer.parseInt(str3.replace(" MB", ""));
        } else {
            cVar.f23746b = -1;
        }
        if (str4 != null) {
            cVar.f23747c = Integer.parseInt(str4.replace(" MB", ""));
        } else {
            cVar.f23747c = -1;
        }
        return cVar;
    }

    public static int b(String str, int i2) {
        return b.b(String.format("http://%s%s/settimerinfo.cgi?&-time=%d", new Object[]{str, "/cgi-bin/hi3510", Integer.valueOf(i2)}));
    }

    public static int b(String str, String str2) {
        return b.b(String.format("http://%s%s/setvideonorm.cgi?&-videonorm=%s", new Object[]{str, "/cgi-bin/hi3510", str2}));
    }

    public static int b(String str, Map<String, Integer> map) {
        com.xeagle.android.hicamera.net.a a2 = b.a(String.format("http://%s%s/getburstinfo.cgi?", new Object[]{str, "/cgi-bin/hi3510"}));
        if (a2.f23632a == 200) {
            TreeMap treeMap = new TreeMap();
            com.xeagle.android.hicamera.net.c.a(a2.f23633b, treeMap);
            String str2 = (String) treeMap.get("time");
            String str3 = (String) treeMap.get("count");
            if (!(str2 == null || str3 == null)) {
                try {
                    int parseInt = Integer.parseInt(str2);
                    int parseInt2 = Integer.parseInt(str3);
                    map.put("time", Integer.valueOf(parseInt));
                    map.put("count", Integer.valueOf(parseInt2));
                    return 0;
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                    return -1;
                }
            }
        }
        Log.e("getBurstInfo", a2.f23633b);
        return -1;
    }

    public static int b(String str, boolean z2) {
        return b.b(String.format("http://%s%s/setaudioencode.cgi?&-enable=%d", new Object[]{str, "/cgi-bin/hi3510", Integer.valueOf(z2 ? 1 : 0)}));
    }

    public static Boolean b(String str) {
        return b.c(String.format("http://%s%s/getflip.cgi?", new Object[]{str, "/cgi-bin/hi3510"}));
    }

    public static int c(String str) {
        return b.b(String.format("http://%s%s/gettimelapseinfo.cgi?", new Object[]{str, "/cgi-bin/hi3510"}), "time");
    }

    public static int c(String str, int i2) {
        return b.b(String.format("http://%s%s/setrecordtimelapse.cgi?&-time=%d", new Object[]{str, "/cgi-bin/hi3510", Integer.valueOf(i2)}));
    }

    public static int c(String str, boolean z2) {
        return b.b(String.format("http://%s%s/settimeosd.cgi?&-enable=%d", new Object[]{str, "/cgi-bin/hi3510", Integer.valueOf(z2 ? 1 : 0)}));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.net.Socket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.net.Socket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.net.Socket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.net.Socket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.net.Socket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.net.Socket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.net.Socket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.net.Socket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.net.Socket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.net.Socket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: java.net.Socket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: java.net.Socket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v20, resolved type: java.net.Socket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v21, resolved type: java.net.Socket} */
    /* JADX WARNING: type inference failed for: r6v1, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r6v3 */
    /* JADX WARNING: type inference failed for: r6v4, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r6v5 */
    /* JADX WARNING: type inference failed for: r6v6, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r6v7 */
    /* JADX WARNING: type inference failed for: r6v8 */
    /* JADX WARNING: type inference failed for: r6v9 */
    /* JADX WARNING: type inference failed for: r6v10 */
    /* JADX WARNING: type inference failed for: r6v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008d A[SYNTHETIC, Splitter:B:24:0x008d] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0092 A[Catch:{ IOException -> 0x00a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a2 A[SYNTHETIC, Splitter:B:34:0x00a2] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00aa A[Catch:{ IOException -> 0x00a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b5 A[SYNTHETIC, Splitter:B:43:0x00b5] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00bd A[Catch:{ IOException -> 0x00b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void c(java.lang.String r5, java.lang.String r6) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "strUrl:"
            r0.append(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "Setting"
            android.util.Log.d(r1, r0)
            r0 = 0
            java.net.Socket r2 = new java.net.Socket     // Catch:{ UnknownHostException -> 0x0096, IOException -> 0x0081, all -> 0x007e }
            r3 = 80
            r2.<init>(r6, r3)     // Catch:{ UnknownHostException -> 0x0096, IOException -> 0x0081, all -> 0x007e }
            r3 = 6000(0x1770, float:8.408E-42)
            r2.setSoTimeout(r3)     // Catch:{ UnknownHostException -> 0x007a, IOException -> 0x0076, all -> 0x0072 }
            java.io.OutputStream r0 = r2.getOutputStream()     // Catch:{ UnknownHostException -> 0x007a, IOException -> 0x0076, all -> 0x0072 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x007a, IOException -> 0x0076, all -> 0x0072 }
            java.lang.String r4 = "GET "
            r3.<init>(r4)     // Catch:{ UnknownHostException -> 0x007a, IOException -> 0x0076, all -> 0x0072 }
            java.lang.String r4 = "/cgi-bin/hi3510"
            r3.append(r4)     // Catch:{ UnknownHostException -> 0x007a, IOException -> 0x0076, all -> 0x0072 }
            r3.append(r5)     // Catch:{ UnknownHostException -> 0x007a, IOException -> 0x0076, all -> 0x0072 }
            java.lang.String r5 = " HTTP/1.1\r\n"
            r3.append(r5)     // Catch:{ UnknownHostException -> 0x007a, IOException -> 0x0076, all -> 0x0072 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x007a, IOException -> 0x0076, all -> 0x0072 }
            r5.<init>()     // Catch:{ UnknownHostException -> 0x007a, IOException -> 0x0076, all -> 0x0072 }
            java.lang.String r4 = "Host: "
            r5.append(r4)     // Catch:{ UnknownHostException -> 0x007a, IOException -> 0x0076, all -> 0x0072 }
            r5.append(r6)     // Catch:{ UnknownHostException -> 0x007a, IOException -> 0x0076, all -> 0x0072 }
            java.lang.String r6 = "\r\n"
            r5.append(r6)     // Catch:{ UnknownHostException -> 0x007a, IOException -> 0x0076, all -> 0x0072 }
            java.lang.String r5 = r5.toString()     // Catch:{ UnknownHostException -> 0x007a, IOException -> 0x0076, all -> 0x0072 }
            r3.append(r5)     // Catch:{ UnknownHostException -> 0x007a, IOException -> 0x0076, all -> 0x0072 }
            java.lang.String r5 = "Connection: Keep-Alive\r\n"
            r3.append(r5)     // Catch:{ UnknownHostException -> 0x007a, IOException -> 0x0076, all -> 0x0072 }
            java.lang.String r5 = "User-Agent: HiCamera\r\n\r\n"
            r3.append(r5)     // Catch:{ UnknownHostException -> 0x007a, IOException -> 0x0076, all -> 0x0072 }
            java.lang.String r5 = r3.toString()     // Catch:{ UnknownHostException -> 0x007a, IOException -> 0x0076, all -> 0x0072 }
            byte[] r5 = r5.getBytes()     // Catch:{ UnknownHostException -> 0x007a, IOException -> 0x0076, all -> 0x0072 }
            r0.write(r5)     // Catch:{ UnknownHostException -> 0x007a, IOException -> 0x0076, all -> 0x0072 }
            r2.close()     // Catch:{ IOException -> 0x00a6 }
            if (r0 == 0) goto L_0x00b1
            r0.close()     // Catch:{ IOException -> 0x00a6 }
            goto L_0x00b1
        L_0x0072:
            r5 = move-exception
            r6 = r0
            r0 = r2
            goto L_0x00b3
        L_0x0076:
            r5 = move-exception
            r6 = r0
            r0 = r2
            goto L_0x0083
        L_0x007a:
            r5 = move-exception
            r6 = r0
            r0 = r2
            goto L_0x0098
        L_0x007e:
            r5 = move-exception
            r6 = r0
            goto L_0x00b3
        L_0x0081:
            r5 = move-exception
            r6 = r0
        L_0x0083:
            java.lang.String r2 = "strUrl:IOException"
            android.util.Log.d(r1, r2)     // Catch:{ all -> 0x00b2 }
            r5.printStackTrace()     // Catch:{ all -> 0x00b2 }
            if (r0 == 0) goto L_0x0090
            r0.close()     // Catch:{ IOException -> 0x00a6 }
        L_0x0090:
            if (r6 == 0) goto L_0x00b1
            r6.close()     // Catch:{ IOException -> 0x00a6 }
            goto L_0x00b1
        L_0x0096:
            r5 = move-exception
            r6 = r0
        L_0x0098:
            java.lang.String r2 = "strUrl:UnknownHostException"
            android.util.Log.d(r1, r2)     // Catch:{ all -> 0x00b2 }
            r5.printStackTrace()     // Catch:{ all -> 0x00b2 }
            if (r0 == 0) goto L_0x00a8
            r0.close()     // Catch:{ IOException -> 0x00a6 }
            goto L_0x00a8
        L_0x00a6:
            r5 = move-exception
            goto L_0x00ae
        L_0x00a8:
            if (r6 == 0) goto L_0x00b1
            r6.close()     // Catch:{ IOException -> 0x00a6 }
            goto L_0x00b1
        L_0x00ae:
            r5.printStackTrace()
        L_0x00b1:
            return
        L_0x00b2:
            r5 = move-exception
        L_0x00b3:
            if (r0 == 0) goto L_0x00bb
            r0.close()     // Catch:{ IOException -> 0x00b9 }
            goto L_0x00bb
        L_0x00b9:
            r6 = move-exception
            goto L_0x00c1
        L_0x00bb:
            if (r6 == 0) goto L_0x00c4
            r6.close()     // Catch:{ IOException -> 0x00b9 }
            goto L_0x00c4
        L_0x00c1:
            r6.printStackTrace()
        L_0x00c4:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kf.c.c(java.lang.String, java.lang.String):void");
    }

    public static int d(String str) {
        return b.b(String.format("http://%s%s/gettimerinfo.cgi?", new Object[]{str, "/cgi-bin/hi3510"}), "time");
    }

    public static int d(String str, boolean z2) {
        return b.b(String.format("http://%s%s/setledstate.cgi?&-enable=%d", new Object[]{str, "/cgi-bin/hi3510", Integer.valueOf(z2 ? 1 : 0)}));
    }

    public static int e(String str) {
        return b.b(String.format("http://%s%s/getrecordtimelapse.cgi?", new Object[]{str, "/cgi-bin/hi3510"}), "time");
    }

    public static String f(String str) {
        return b.a(String.format("http://%s%s/getbootaction.cgi?", new Object[]{str, "/cgi-bin/hi3510"}), "action");
    }

    public static Boolean g(String str) {
        return b.c(String.format("http://%s%s/getaudioencode.cgi?", new Object[]{str, "/cgi-bin/hi3510"}));
    }

    public static String h(String str) {
        String a2 = b.a(String.format("http://%s%s/getvideonorm.cgi?", new Object[]{str, "/cgi-bin/hi3510"}), "videonorm");
        if (a2 == null) {
            return null;
        }
        if (a2.equals("NTSC") || a2.equals("PAL")) {
            return a2;
        }
        return null;
    }

    public static Boolean i(String str) {
        return b.c(String.format("http://%s%s/gettimeosd.cgi?", new Object[]{str, "/cgi-bin/hi3510"}));
    }

    public static Boolean j(String str) {
        return b.c(String.format("http://%s%s/getledstate.cgi?", new Object[]{str, "/cgi-bin/hi3510"}));
    }

    public static void k(String str) {
        c("/reset.cgi?", str);
    }
}
