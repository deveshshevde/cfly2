package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import com.blankj.utilcode.constant.TimeConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ga {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static WeakReference<hg> f8890a = null;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f8891b = true;

    /* renamed from: c  reason: collision with root package name */
    private static WeakReference<ia> f8892c = null;

    /* renamed from: d  reason: collision with root package name */
    private static WeakReference<ia> f8893d = null;

    /* renamed from: e  reason: collision with root package name */
    private static String[] f8894e = new String[10];

    /* renamed from: f  reason: collision with root package name */
    private static int f8895f = 0;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f8896g = false;

    /* renamed from: h  reason: collision with root package name */
    private static int f8897h;

    /* renamed from: i  reason: collision with root package name */
    private static ff f8898i;

    public interface a {
        void a(int i2);
    }

    private static ff a(String str) {
        List<ff> a2 = fx.a();
        if (a2 == null) {
            a2 = new ArrayList<>();
        }
        if (str != null && !"".equals(str)) {
            for (ff ffVar : a2) {
                if (fx.a(ffVar.g(), str)) {
                    return ffVar;
                }
            }
            if (str.contains("com.amap.api.col")) {
                try {
                    return fg.a();
                } catch (eu e2) {
                    e2.printStackTrace();
                }
            }
            if (str.contains("com.amap.co") || str.contains("com.amap.opensdk.co") || str.contains("com.amap.location")) {
                try {
                    ff b2 = fg.b();
                    b2.a(true);
                    return b2;
                } catch (eu e3) {
                    e3.printStackTrace();
                }
            }
        }
        return null;
    }

    static /* synthetic */ String a(Context context, ff ffVar, String str, String str2) {
        String a2 = hn.a();
        String a3 = hn.a(context, ffVar);
        ev.a(context);
        return hn.a(a3, a2, str, str2);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00a3 */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c1 A[SYNTHETIC, Splitter:B:62:0x00c1] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00cb A[SYNTHETIC, Splitter:B:67:0x00cb] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00e9 A[SYNTHETIC, Splitter:B:85:0x00e9] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00f3 A[SYNTHETIC, Splitter:B:90:0x00f3] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x00ff A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.util.List<com.amap.api.mapcore.util.ff> r11) {
        /*
            java.lang.String r0 = "getA"
            java.lang.String r1 = "alg"
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch:{ FileNotFoundException -> 0x00e5, all -> 0x00b9 }
            java.lang.String r4 = "/data/anr/traces.txt"
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x00e5, all -> 0x00b9 }
            boolean r4 = r3.exists()     // Catch:{ FileNotFoundException -> 0x00e5, all -> 0x00b9 }
            if (r4 != 0) goto L_0x0013
            return r2
        L_0x0013:
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00e5, all -> 0x00b9 }
            r4.<init>(r3)     // Catch:{ FileNotFoundException -> 0x00e5, all -> 0x00b9 }
            int r3 = r4.available()     // Catch:{ FileNotFoundException -> 0x00b7, all -> 0x00b4 }
            r5 = 1024000(0xfa000, float:1.43493E-39)
            if (r3 <= r5) goto L_0x0026
            int r3 = r3 - r5
            long r5 = (long) r3     // Catch:{ FileNotFoundException -> 0x00b7, all -> 0x00b4 }
            r4.skip(r5)     // Catch:{ FileNotFoundException -> 0x00b7, all -> 0x00b4 }
        L_0x0026:
            com.amap.api.mapcore.util.gu r3 = new com.amap.api.mapcore.util.gu     // Catch:{ FileNotFoundException -> 0x00b7, all -> 0x00b4 }
            java.nio.charset.Charset r5 = com.amap.api.mapcore.util.gt.f8934b     // Catch:{ FileNotFoundException -> 0x00b7, all -> 0x00b4 }
            r3.<init>(r4, r5)     // Catch:{ FileNotFoundException -> 0x00b7, all -> 0x00b4 }
            r5 = 0
            r6 = 0
        L_0x002f:
            java.lang.String r7 = r3.a()     // Catch:{ EOFException -> 0x00a3, FileNotFoundException -> 0x00e7, all -> 0x00a1 }
            java.lang.String r7 = r7.trim()     // Catch:{ EOFException -> 0x00a3, FileNotFoundException -> 0x00e7, all -> 0x00a1 }
            java.lang.String r8 = "pid"
            boolean r8 = r7.contains(r8)     // Catch:{ EOFException -> 0x00a3, FileNotFoundException -> 0x00e7, all -> 0x00a1 }
            if (r8 == 0) goto L_0x004d
        L_0x003f:
            java.lang.String r6 = "\"main\""
            boolean r6 = r7.startsWith(r6)     // Catch:{ EOFException -> 0x00a3, FileNotFoundException -> 0x00e7, all -> 0x00a1 }
            if (r6 != 0) goto L_0x004c
            java.lang.String r7 = r3.a()     // Catch:{ EOFException -> 0x00a3, FileNotFoundException -> 0x00e7, all -> 0x00a1 }
            goto L_0x003f
        L_0x004c:
            r6 = 1
        L_0x004d:
            java.lang.String r8 = ""
            boolean r8 = r7.equals(r8)     // Catch:{ EOFException -> 0x00a3, FileNotFoundException -> 0x00e7, all -> 0x00a1 }
            if (r8 == 0) goto L_0x0058
            if (r6 == 0) goto L_0x0058
            goto L_0x00a3
        L_0x0058:
            if (r6 == 0) goto L_0x002f
            int r8 = f8895f     // Catch:{ all -> 0x006d }
            r9 = 9
            if (r8 <= r9) goto L_0x0062
            f8895f = r5     // Catch:{ all -> 0x006d }
        L_0x0062:
            java.lang.String[] r8 = f8894e     // Catch:{ all -> 0x006d }
            int r9 = f8895f     // Catch:{ all -> 0x006d }
            r8[r9] = r7     // Catch:{ all -> 0x006d }
            int r9 = r9 + 1
            f8895f = r9     // Catch:{ all -> 0x006d }
            goto L_0x0073
        L_0x006d:
            r8 = move-exception
            java.lang.String r9 = "aDa"
            com.amap.api.mapcore.util.fz.c(r8, r1, r9)     // Catch:{ EOFException -> 0x00a3, FileNotFoundException -> 0x00e7, all -> 0x00a1 }
        L_0x0073:
            int r8 = f8897h     // Catch:{ EOFException -> 0x00a3, FileNotFoundException -> 0x00e7, all -> 0x00a1 }
            r9 = 5
            if (r8 != r9) goto L_0x0079
            goto L_0x00a3
        L_0x0079:
            boolean r9 = f8896g     // Catch:{ EOFException -> 0x00a3, FileNotFoundException -> 0x00e7, all -> 0x00a1 }
            if (r9 != 0) goto L_0x009c
            java.util.Iterator r8 = r11.iterator()     // Catch:{ EOFException -> 0x00a3, FileNotFoundException -> 0x00e7, all -> 0x00a1 }
        L_0x0081:
            boolean r9 = r8.hasNext()     // Catch:{ EOFException -> 0x00a3, FileNotFoundException -> 0x00e7, all -> 0x00a1 }
            if (r9 == 0) goto L_0x002f
            java.lang.Object r9 = r8.next()     // Catch:{ EOFException -> 0x00a3, FileNotFoundException -> 0x00e7, all -> 0x00a1 }
            com.amap.api.mapcore.util.ff r9 = (com.amap.api.mapcore.util.ff) r9     // Catch:{ EOFException -> 0x00a3, FileNotFoundException -> 0x00e7, all -> 0x00a1 }
            java.lang.String[] r10 = r9.g()     // Catch:{ EOFException -> 0x00a3, FileNotFoundException -> 0x00e7, all -> 0x00a1 }
            boolean r10 = com.amap.api.mapcore.util.fx.b((java.lang.String[]) r10, (java.lang.String) r7)     // Catch:{ EOFException -> 0x00a3, FileNotFoundException -> 0x00e7, all -> 0x00a1 }
            f8896g = r10     // Catch:{ EOFException -> 0x00a3, FileNotFoundException -> 0x00e7, all -> 0x00a1 }
            if (r10 == 0) goto L_0x0081
            f8898i = r9     // Catch:{ EOFException -> 0x00a3, FileNotFoundException -> 0x00e7, all -> 0x00a1 }
            goto L_0x002f
        L_0x009c:
            int r8 = r8 + 1
            f8897h = r8     // Catch:{ EOFException -> 0x00a3, FileNotFoundException -> 0x00e7, all -> 0x00a1 }
            goto L_0x002f
        L_0x00a1:
            r11 = move-exception
            goto L_0x00bc
        L_0x00a3:
            r3.close()     // Catch:{ all -> 0x00a7 }
            goto L_0x00ab
        L_0x00a7:
            r11 = move-exception
            com.amap.api.mapcore.util.fz.c(r11, r1, r0)
        L_0x00ab:
            r4.close()     // Catch:{ all -> 0x00af }
            goto L_0x00f6
        L_0x00af:
            r11 = move-exception
            com.amap.api.mapcore.util.fz.c(r11, r1, r0)
            goto L_0x00f6
        L_0x00b4:
            r11 = move-exception
            r3 = r2
            goto L_0x00bc
        L_0x00b7:
            r3 = r2
            goto L_0x00e7
        L_0x00b9:
            r11 = move-exception
            r3 = r2
            r4 = r3
        L_0x00bc:
            com.amap.api.mapcore.util.fz.c(r11, r1, r0)     // Catch:{ all -> 0x00cf }
            if (r3 == 0) goto L_0x00c9
            r3.close()     // Catch:{ all -> 0x00c5 }
            goto L_0x00c9
        L_0x00c5:
            r11 = move-exception
            com.amap.api.mapcore.util.fz.c(r11, r1, r0)
        L_0x00c9:
            if (r4 == 0) goto L_0x00f6
            r4.close()     // Catch:{ all -> 0x00af }
            goto L_0x00f6
        L_0x00cf:
            r11 = move-exception
            if (r3 == 0) goto L_0x00da
            r3.close()     // Catch:{ all -> 0x00d6 }
            goto L_0x00da
        L_0x00d6:
            r2 = move-exception
            com.amap.api.mapcore.util.fz.c(r2, r1, r0)
        L_0x00da:
            if (r4 == 0) goto L_0x00e4
            r4.close()     // Catch:{ all -> 0x00e0 }
            goto L_0x00e4
        L_0x00e0:
            r2 = move-exception
            com.amap.api.mapcore.util.fz.c(r2, r1, r0)
        L_0x00e4:
            throw r11
        L_0x00e5:
            r3 = r2
            r4 = r3
        L_0x00e7:
            if (r3 == 0) goto L_0x00f1
            r3.close()     // Catch:{ all -> 0x00ed }
            goto L_0x00f1
        L_0x00ed:
            r11 = move-exception
            com.amap.api.mapcore.util.fz.c(r11, r1, r0)
        L_0x00f1:
            if (r4 == 0) goto L_0x00f6
            r4.close()     // Catch:{ all -> 0x00af }
        L_0x00f6:
            boolean r11 = f8896g
            if (r11 == 0) goto L_0x00ff
            java.lang.String r11 = b()
            return r11
        L_0x00ff:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ga.a(java.util.List):java.lang.String");
    }

    static void a(Context context) {
        String a2;
        ff ffVar;
        List<ff> a3 = fx.a();
        if (a3 != null && a3.size() != 0 && (a2 = a(a3)) != null && !"".equals(a2) && (ffVar = f8898i) != null) {
            a(context, ffVar, 2, "ANR", a2);
        }
    }

    private static void a(Context context, ff ffVar, int i2, String str, String str2) {
        String str3;
        String a2 = hn.a();
        String a3 = hn.a(context, ffVar);
        ev.a(context);
        String a4 = hn.a(a3, a2, i2, str, str2);
        if (a4 != null && !"".equals(a4)) {
            String c2 = fd.c(str2);
            if (i2 == 1) {
                str3 = fx.f8861b;
            } else if (i2 == 2) {
                str3 = fx.f8863d;
            } else if (i2 == 0) {
                str3 = fx.f8862c;
            } else {
                return;
            }
            String str4 = str3;
            hg a5 = hn.a(f8890a);
            hn.a(context, a5, str4, 1000, 4096000, "1");
            if (a5.f9127e == null) {
                a5.f9127e = new go(new gp(new gr(new gs())));
            }
            try {
                hh.a(c2, fg.a(a4.replaceAll("\n", "<br/>")), a5);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context, ff ffVar, String str, int i2, String str2, String str3) {
        if (str2 != null && !"".equals(str2)) {
            StringBuilder sb = new StringBuilder();
            if (str2 != null) {
                sb.append("class:");
                sb.append(str2);
            }
            if (str3 != null) {
                sb.append(" method:");
                sb.append(str3);
                sb.append("$<br/>");
            }
            sb.append(str);
            a(context, ffVar, i2, str2, sb.toString());
        }
    }

    public static void a(Context context, ff ffVar, String str, hg hgVar, String str2) {
        try {
            final Context context2 = context;
            final ff ffVar2 = ffVar;
            final String str3 = str;
            final String str4 = str2;
            final hg hgVar2 = hgVar;
            id.a().a(new ie() {
                public final void runTask() {
                    String a2 = ga.a(context2, ffVar2, str3, str4);
                    if (hgVar2.f9127e == null) {
                        hgVar2.f9127e = new go(new gp(new gr(new gs())));
                    }
                    try {
                        hh.a(fd.c(a2), fg.a(a2), hgVar2);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static void a(final Context context, final hg hgVar, final a aVar) {
        try {
            id.a().a(new ie() {
                public final void runTask() {
                    try {
                        synchronized (ga.class) {
                            if (hgVar.f9129g == null) {
                                hgVar.f9129g = new hr(new hq(context, new hv(), new gp(new gr(new gs())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", ev.f(context), ez.u(context), ez.t(context), ev.c(context), Build.MODEL, ev.b(context), ev.d(context), Build.VERSION.RELEASE));
                            }
                            int a2 = hh.a(hgVar);
                            a aVar = aVar;
                            if (aVar != null) {
                                aVar.a(a2);
                            }
                        }
                    } catch (Throwable th) {
                        fz.c(th, "lg", "pul");
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    private static void a(final Context context, final ia iaVar, final String str) {
        id.a().a(new ie() {
            public final void runTask() {
                try {
                    synchronized (ga.class) {
                        hg a2 = hn.a(ga.f8890a);
                        hn.a(context, a2, str, 1000, 4096000, "1");
                        a2.f9128f = iaVar;
                        if (a2.f9129g == null) {
                            a2.f9129g = new hr(new hq(context, new hv(), new gp(new gr(new gs())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", ev.f(context), ez.u(context), ez.t(context), ev.c(context), Build.MODEL, ev.b(context), ev.d(context), Build.VERSION.RELEASE));
                        }
                        a2.f9130h = TimeConstants.HOUR;
                        hh.a(a2);
                    }
                } catch (Throwable th) {
                    fz.c(th, "lg", "pul");
                }
            }
        });
    }

    public static void a(Context context, Throwable th, int i2, String str, String str2) {
        String a2 = fg.a(th);
        ff a3 = a(a2);
        if (a(a3)) {
            String replaceAll = a2.replaceAll("\n", "<br/>");
            String th2 = th.toString();
            if (th2 != null && !"".equals(th2)) {
                StringBuilder sb = new StringBuilder();
                if (str != null) {
                    sb.append("class:");
                    sb.append(str);
                }
                if (str2 != null) {
                    sb.append(" method:");
                    sb.append(str2);
                    sb.append("$<br/>");
                }
                sb.append(replaceAll);
                a(context, a3, i2, th2, sb.toString());
            }
        }
    }

    static void a(ff ffVar, Context context, String str, String str2) {
        if (a(ffVar) && str != null && !"".equals(str)) {
            a(context, ffVar, 1, str, str2);
        }
    }

    private static boolean a(ff ffVar) {
        return ffVar != null && ffVar.f();
    }

    private static String b() {
        StringBuilder sb = new StringBuilder();
        try {
            int i2 = f8895f;
            while (i2 < 10 && i2 <= 9) {
                sb.append(f8894e[i2]);
                i2++;
            }
            for (int i3 = 0; i3 < f8895f; i3++) {
                sb.append(f8894e[i3]);
            }
        } catch (Throwable th) {
            fz.c(th, "alg", "gLI");
        }
        return sb.toString();
    }

    static void b(Context context) {
        hy hyVar = new hy(f8891b);
        f8891b = false;
        a(context, (ia) hyVar, fx.f8862c);
    }

    static void c(Context context) {
        WeakReference<ia> weakReference = f8892c;
        if (weakReference == null || weakReference.get() == null) {
            f8892c = new WeakReference<>(new hz(context, TimeConstants.HOUR, "hKey", new ib(context, false)));
        }
        a(context, (ia) f8892c.get(), fx.f8863d);
    }

    static void d(Context context) {
        WeakReference<ia> weakReference = f8893d;
        if (weakReference == null || weakReference.get() == null) {
            f8893d = new WeakReference<>(new hz(context, TimeConstants.HOUR, "gKey", new ib(context, false)));
        }
        a(context, (ia) f8893d.get(), fx.f8861b);
    }
}
