package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class di {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f8250a = false;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f8251b = false;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f8252c = false;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f8253d = false;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f8254e = false;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f8255f = false;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f8256g = false;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f8257h = false;

    /* renamed from: i  reason: collision with root package name */
    private static boolean f8258i = false;

    /* renamed from: j  reason: collision with root package name */
    private static HashMap<String, Boolean> f8259j = new HashMap<>();

    /* renamed from: k  reason: collision with root package name */
    private static ConcurrentHashMap<Integer, Integer> f8260k = new ConcurrentHashMap<>();

    /* renamed from: l  reason: collision with root package name */
    private static ConcurrentHashMap<Integer, Integer> f8261l = new ConcurrentHashMap<>();

    private static <T> String a(Map<String, T> map) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            for (Map.Entry next : map.entrySet()) {
                sb.append("\"" + ((String) next.getKey()) + "\":");
                sb.append(next.getValue());
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("}");
            return sb.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static String a(boolean z2) {
        try {
            return "{\"Quest\":" + z2 + "}";
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void a(Context context) {
        if (!f8252c) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("amap_3dmap_heatmap", 1);
                a(context, "O009", a(hashMap));
                f8252c = true;
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context, int i2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_draw_fail", Integer.valueOf(i2));
            a(context, "O023", a(hashMap));
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x007e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r3, int r4, int r5, java.lang.String r6) {
        /*
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Integer> r0 = f8260k     // Catch:{ all -> 0x0082 }
            monitor-enter(r0)     // Catch:{ all -> 0x0082 }
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Integer> r1 = f8260k     // Catch:{ all -> 0x007f }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x007f }
            boolean r1 = r1.containsKey(r2)     // Catch:{ all -> 0x007f }
            if (r1 == 0) goto L_0x0027
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Integer> r1 = f8260k     // Catch:{ all -> 0x007f }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x007f }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x007f }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x007f }
            int r1 = r1.intValue()     // Catch:{ all -> 0x007f }
            r2 = 2
            if (r1 < r2) goto L_0x0027
            monitor-exit(r0)     // Catch:{ all -> 0x007f }
            return
        L_0x0027:
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x007f }
            r1.<init>()     // Catch:{ all -> 0x007f }
            java.lang.String r2 = "amap_3dmap_map_request_type"
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x007f }
            r1.put(r2, r5)     // Catch:{ all -> 0x007f }
            java.lang.String r5 = "amap_3dmap_map_request_info"
            r1.put(r5, r6)     // Catch:{ all -> 0x007f }
            java.lang.String r5 = a(r1)     // Catch:{ all -> 0x007f }
            java.lang.String r6 = "O019"
            a(r3, r6, r5)     // Catch:{ all -> 0x007f }
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Integer> r3 = f8260k     // Catch:{ all -> 0x007f }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x007f }
            boolean r3 = r3.containsKey(r5)     // Catch:{ all -> 0x007f }
            if (r3 != 0) goto L_0x005e
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Integer> r3 = f8260k     // Catch:{ all -> 0x007f }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x007f }
            r5 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x007f }
            r3.put(r4, r5)     // Catch:{ all -> 0x007f }
            goto L_0x007d
        L_0x005e:
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Integer> r3 = f8260k     // Catch:{ all -> 0x007f }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x007f }
            java.lang.Object r3 = r3.get(r5)     // Catch:{ all -> 0x007f }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x007f }
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Integer> r5 = f8260k     // Catch:{ all -> 0x007f }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x007f }
            int r3 = r3.intValue()     // Catch:{ all -> 0x007f }
            int r3 = r3 + 1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x007f }
            r5.put(r4, r3)     // Catch:{ all -> 0x007f }
        L_0x007d:
            monitor-exit(r0)     // Catch:{ all -> 0x007f }
            return
        L_0x007f:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x007f }
            throw r3     // Catch:{ all -> 0x0082 }
        L_0x0082:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.di.a(android.content.Context, int, int, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x007f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r3, int r4, long r5, long r7) {
        /*
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Integer> r0 = f8261l     // Catch:{ all -> 0x0083 }
            monitor-enter(r0)     // Catch:{ all -> 0x0083 }
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Integer> r1 = f8261l     // Catch:{ all -> 0x0080 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0080 }
            boolean r1 = r1.containsKey(r2)     // Catch:{ all -> 0x0080 }
            if (r1 == 0) goto L_0x0024
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Integer> r1 = f8261l     // Catch:{ all -> 0x0080 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0080 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0080 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x0080 }
            int r1 = r1.intValue()     // Catch:{ all -> 0x0080 }
            r2 = 2
            if (r1 < r2) goto L_0x0024
            monitor-exit(r0)     // Catch:{ all -> 0x0080 }
            return
        L_0x0024:
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x0080 }
            r1.<init>()     // Catch:{ all -> 0x0080 }
            java.lang.String r2 = "amap_3dmap_map_request_rendertime"
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0080 }
            r1.put(r2, r5)     // Catch:{ all -> 0x0080 }
            java.lang.String r5 = "amap_3dmap_map_request_size"
            java.lang.Long r6 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0080 }
            r1.put(r5, r6)     // Catch:{ all -> 0x0080 }
            java.lang.String r5 = a(r1)     // Catch:{ all -> 0x0080 }
            java.lang.String r6 = "O020"
            a(r3, r6, r5)     // Catch:{ all -> 0x0080 }
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Integer> r3 = f8261l     // Catch:{ all -> 0x0080 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0080 }
            boolean r3 = r3.containsKey(r5)     // Catch:{ all -> 0x0080 }
            if (r3 != 0) goto L_0x005f
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Integer> r3 = f8261l     // Catch:{ all -> 0x0080 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0080 }
            r5 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0080 }
            r3.put(r4, r5)     // Catch:{ all -> 0x0080 }
            goto L_0x007e
        L_0x005f:
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Integer> r3 = f8261l     // Catch:{ all -> 0x0080 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0080 }
            java.lang.Object r3 = r3.get(r5)     // Catch:{ all -> 0x0080 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x0080 }
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Integer> r5 = f8261l     // Catch:{ all -> 0x0080 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0080 }
            int r3 = r3.intValue()     // Catch:{ all -> 0x0080 }
            int r3 = r3 + 1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0080 }
            r5.put(r4, r3)     // Catch:{ all -> 0x0080 }
        L_0x007e:
            monitor-exit(r0)     // Catch:{ all -> 0x0080 }
            return
        L_0x0080:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0080 }
            throw r3     // Catch:{ all -> 0x0083 }
        L_0x0083:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.di.a(android.content.Context, int, long, long):void");
    }

    public static void a(Context context, long j2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_rendertime", Long.valueOf(j2));
            hashMap.put("amap_3dmap_render_background", 0L);
            a(context, "O005", a(hashMap));
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0049, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(android.content.Context r3, java.lang.String r4) {
        /*
            java.lang.Class<com.amap.api.mapcore.util.di> r0 = com.amap.api.mapcore.util.di.class
            monitor-enter(r0)
            java.util.HashMap<java.lang.String, java.lang.Boolean> r1 = f8259j     // Catch:{ all -> 0x004c }
            if (r1 == 0) goto L_0x004a
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x004c }
            if (r1 == 0) goto L_0x000e
            goto L_0x004a
        L_0x000e:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r1 = f8259j     // Catch:{ all -> 0x004c }
            boolean r1 = r1.containsKey(r4)     // Catch:{ all -> 0x004c }
            if (r1 == 0) goto L_0x0026
            java.util.HashMap<java.lang.String, java.lang.Boolean> r1 = f8259j     // Catch:{ all -> 0x004c }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x004c }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x004c }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x004c }
            if (r1 == 0) goto L_0x0026
            monitor-exit(r0)
            return
        L_0x0026:
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x004c }
            r1.<init>()     // Catch:{ all -> 0x004c }
            java.lang.String r2 = "amap_3dmap_coordinate"
            r1.put(r2, r4)     // Catch:{ all -> 0x004c }
            java.lang.String r1 = a(r1)     // Catch:{ all -> 0x004c }
            java.lang.String r2 = "O008"
            a(r3, r2, r1)     // Catch:{ all -> 0x004c }
            java.util.HashMap<java.lang.String, java.lang.Boolean> r3 = f8259j     // Catch:{ all -> 0x004c }
            boolean r3 = r3.containsKey(r4)     // Catch:{ all -> 0x004c }
            if (r3 != 0) goto L_0x0048
            java.util.HashMap<java.lang.String, java.lang.Boolean> r3 = f8259j     // Catch:{ all -> 0x004c }
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x004c }
            r3.put(r4, r1)     // Catch:{ all -> 0x004c }
        L_0x0048:
            monitor-exit(r0)
            return
        L_0x004a:
            monitor-exit(r0)
            return
        L_0x004c:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.di.a(android.content.Context, java.lang.String):void");
    }

    private static void a(Context context, String str, String str2) {
        if (context != null) {
            try {
                hl hlVar = new hl(context, "3dmap", "8.0.0", str);
                hlVar.a(str2);
                hm.a(hlVar, context);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context, boolean z2) {
        try {
            String a2 = a(z2);
            hl hlVar = new hl(context, "3dmap", "8.0.0", "O001");
            hlVar.a(a2);
            hm.a(hlVar, context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(Context context) {
        if (!f8253d) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("amap_3dmap_offlinemap", 1);
                a(context, "O010", a(hashMap));
                f8253d = true;
            } catch (Throwable unused) {
            }
        }
    }

    public static void b(Context context, String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_engine_init_fail", str);
            a(context, "O021", a(hashMap));
        } catch (Throwable unused) {
        }
    }

    public static void b(Context context, boolean z2) {
        if (!f8250a) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("amap_3dmap_stylemap", Integer.valueOf(z2 ? 1 : 0));
                a(context, "O006", a(hashMap));
                f8250a = true;
            } catch (Throwable unused) {
            }
        }
    }

    public static void c(Context context) {
        if (!f8254e) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("amap_3dmap_particleoverlay", 1);
                a(context, "O011", a(hashMap));
                f8254e = true;
            } catch (Throwable unused) {
            }
        }
    }

    public static void c(Context context, String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_res_load_fail", str);
            a(context, "O022", a(hashMap));
        } catch (Throwable unused) {
        }
    }

    public static void c(Context context, boolean z2) {
        if (!f8251b) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("amap_3dmap_indoormap", Integer.valueOf(z2 ? 1 : 0));
                a(context, "O007", a(hashMap));
                f8251b = true;
            } catch (Throwable unused) {
            }
        }
    }

    public static void d(Context context) {
        if (!f8256g) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("amap_3dmap_bzmapreview", 1);
                a(context, "O012", a(hashMap));
                f8256g = true;
            } catch (Throwable unused) {
            }
        }
    }

    public static void e(Context context) {
        if (!f8257h) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("amap_3dmap_wxmapreview", 1);
                a(context, "O013", a(hashMap));
                f8257h = true;
            } catch (Throwable unused) {
            }
        }
    }

    public static void f(Context context) {
        if (!f8255f) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("amap_3dmap_renderfps", 1);
                a(context, "O014", a(hashMap));
                f8255f = true;
            } catch (Throwable unused) {
            }
        }
    }

    public static void g(Context context) {
        if (!f8258i) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("amap_3dmap_buildingoverlay", 1);
                a(context, "O015", a(hashMap));
                f8258i = true;
            } catch (Throwable unused) {
            }
        }
    }
}
