package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.util.e;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public final class DynamiteModule {

    /* renamed from: a  reason: collision with root package name */
    public static final a f18009a = new f();

    /* renamed from: b  reason: collision with root package name */
    public static final a f18010b = new g();

    /* renamed from: c  reason: collision with root package name */
    public static final a f18011c = new h();

    /* renamed from: d  reason: collision with root package name */
    public static final a f18012d = new i();

    /* renamed from: e  reason: collision with root package name */
    public static final a f18013e = new j();

    /* renamed from: f  reason: collision with root package name */
    public static final a f18014f = new k();

    /* renamed from: g  reason: collision with root package name */
    public static final a f18015g = new l();

    /* renamed from: h  reason: collision with root package name */
    private static Boolean f18016h = null;

    /* renamed from: i  reason: collision with root package name */
    private static String f18017i = null;

    /* renamed from: j  reason: collision with root package name */
    private static boolean f18018j = false;

    /* renamed from: k  reason: collision with root package name */
    private static int f18019k = -1;

    /* renamed from: l  reason: collision with root package name */
    private static final ThreadLocal<n> f18020l = new ThreadLocal<>();

    /* renamed from: m  reason: collision with root package name */
    private static final ThreadLocal<Long> f18021m = new d();

    /* renamed from: n  reason: collision with root package name */
    private static final a.C0123a f18022n = new e();

    /* renamed from: p  reason: collision with root package name */
    private static q f18023p;

    /* renamed from: q  reason: collision with root package name */
    private static r f18024q;

    /* renamed from: o  reason: collision with root package name */
    private final Context f18025o;

    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    public static class LoadingException extends Exception {
        /* synthetic */ LoadingException(String str, p pVar) {
            super(str);
        }

        /* synthetic */ LoadingException(String str, Throwable th, p pVar) {
            super(str, th);
        }
    }

    public interface a {

        /* renamed from: com.google.android.gms.dynamite.DynamiteModule$a$a  reason: collision with other inner class name */
        public interface C0123a {
            int a(Context context, String str);

            int a(Context context, String str, boolean z2) throws LoadingException;
        }

        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public int f18026a = 0;

            /* renamed from: b  reason: collision with root package name */
            public int f18027b = 0;

            /* renamed from: c  reason: collision with root package name */
            public int f18028c = 0;
        }

        b a(Context context, String str, C0123a aVar) throws LoadingException;
    }

    private DynamiteModule(Context context) {
        m.a(context);
        this.f18025o = context;
    }

    public static int a(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".");
            sb.append("ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (l.a(declaredField.get((Object) null), str)) {
                return declaredField2.getInt((Object) null);
            }
            String valueOf = String.valueOf(declaredField.get((Object) null));
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 51 + String.valueOf(str).length());
            sb2.append("Module descriptor id '");
            sb2.append(valueOf);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            Log.e("DynamiteModule", sb2.toString());
            return 0;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(e2.getMessage());
            Log.e("DynamiteModule", valueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(valueOf2) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:43:0x0090=Splitter:B:43:0x0090, B:18:0x003a=Splitter:B:18:0x003a, B:24:0x004a=Splitter:B:24:0x004a} */
    public static int a(android.content.Context r9, java.lang.String r10, boolean r11) {
        /*
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r0 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r0)     // Catch:{ all -> 0x01c6 }
            java.lang.Boolean r1 = f18016h     // Catch:{ all -> 0x01c3 }
            r2 = 0
            if (r1 != 0) goto L_0x00d1
            android.content.Context r1 = r9.getApplicationContext()     // Catch:{ ClassNotFoundException -> 0x00ac, IllegalAccessException -> 0x00aa, NoSuchFieldException -> 0x00a8 }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x00ac, IllegalAccessException -> 0x00aa, NoSuchFieldException -> 0x00a8 }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader> r3 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class
            java.lang.String r3 = r3.getName()     // Catch:{ ClassNotFoundException -> 0x00ac, IllegalAccessException -> 0x00aa, NoSuchFieldException -> 0x00a8 }
            java.lang.Class r1 = r1.loadClass(r3)     // Catch:{ ClassNotFoundException -> 0x00ac, IllegalAccessException -> 0x00aa, NoSuchFieldException -> 0x00a8 }
            java.lang.String r3 = "sClassLoader"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r3)     // Catch:{ ClassNotFoundException -> 0x00ac, IllegalAccessException -> 0x00aa, NoSuchFieldException -> 0x00a8 }
            java.lang.Class r3 = r1.getDeclaringClass()     // Catch:{ ClassNotFoundException -> 0x00ac, IllegalAccessException -> 0x00aa, NoSuchFieldException -> 0x00a8 }
            monitor-enter(r3)     // Catch:{ ClassNotFoundException -> 0x00ac, IllegalAccessException -> 0x00aa, NoSuchFieldException -> 0x00a8 }
            java.lang.Object r4 = r1.get(r2)     // Catch:{ all -> 0x00a5 }
            java.lang.ClassLoader r4 = (java.lang.ClassLoader) r4     // Catch:{ all -> 0x00a5 }
            if (r4 == 0) goto L_0x003d
            java.lang.ClassLoader r1 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00a5 }
            if (r4 != r1) goto L_0x0037
        L_0x0033:
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00a5 }
            goto L_0x00a3
        L_0x0037:
            a((java.lang.ClassLoader) r4)     // Catch:{ LoadingException -> 0x003a }
        L_0x003a:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00a5 }
            goto L_0x00a3
        L_0x003d:
            boolean r4 = f18018j     // Catch:{ all -> 0x00a5 }
            if (r4 != 0) goto L_0x009b
            java.lang.Boolean r4 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00a5 }
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x00a5 }
            if (r4 == 0) goto L_0x004a
            goto L_0x009b
        L_0x004a:
            int r4 = b(r9, r10, r11)     // Catch:{ LoadingException -> 0x0093 }
            java.lang.String r5 = f18017i     // Catch:{ LoadingException -> 0x0093 }
            if (r5 == 0) goto L_0x0090
            boolean r5 = r5.isEmpty()     // Catch:{ LoadingException -> 0x0093 }
            if (r5 == 0) goto L_0x0059
            goto L_0x0090
        L_0x0059:
            java.lang.ClassLoader r5 = com.google.android.gms.dynamite.b.a()     // Catch:{ LoadingException -> 0x0093 }
            if (r5 == 0) goto L_0x0060
            goto L_0x0083
        L_0x0060:
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ LoadingException -> 0x0093 }
            r6 = 29
            if (r5 < r6) goto L_0x0075
            dalvik.system.DelegateLastClassLoader r5 = new dalvik.system.DelegateLastClassLoader     // Catch:{ LoadingException -> 0x0093 }
            java.lang.String r6 = f18017i     // Catch:{ LoadingException -> 0x0093 }
            com.google.android.gms.common.internal.m.a(r6)     // Catch:{ LoadingException -> 0x0093 }
            java.lang.ClassLoader r7 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x0093 }
            r5.<init>(r6, r7)     // Catch:{ LoadingException -> 0x0093 }
            goto L_0x0083
        L_0x0075:
            com.google.android.gms.dynamite.c r5 = new com.google.android.gms.dynamite.c     // Catch:{ LoadingException -> 0x0093 }
            java.lang.String r6 = f18017i     // Catch:{ LoadingException -> 0x0093 }
            com.google.android.gms.common.internal.m.a(r6)     // Catch:{ LoadingException -> 0x0093 }
            java.lang.ClassLoader r7 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x0093 }
            r5.<init>(r6, r7)     // Catch:{ LoadingException -> 0x0093 }
        L_0x0083:
            a((java.lang.ClassLoader) r5)     // Catch:{ LoadingException -> 0x0093 }
            r1.set(r2, r5)     // Catch:{ LoadingException -> 0x0093 }
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ LoadingException -> 0x0093 }
            f18016h = r5     // Catch:{ LoadingException -> 0x0093 }
            monitor-exit(r3)     // Catch:{ all -> 0x00a5 }
            monitor-exit(r0)     // Catch:{ all -> 0x01c3 }
            return r4
        L_0x0090:
            monitor-exit(r3)     // Catch:{ all -> 0x00a5 }
            monitor-exit(r0)     // Catch:{ all -> 0x01c3 }
            return r4
        L_0x0093:
            java.lang.ClassLoader r4 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00a5 }
            r1.set(r2, r4)     // Catch:{ all -> 0x00a5 }
            goto L_0x0033
        L_0x009b:
            java.lang.ClassLoader r4 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00a5 }
            r1.set(r2, r4)     // Catch:{ all -> 0x00a5 }
            goto L_0x0033
        L_0x00a3:
            monitor-exit(r3)     // Catch:{ all -> 0x00a5 }
            goto L_0x00cf
        L_0x00a5:
            r1 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00a5 }
            throw r1     // Catch:{ ClassNotFoundException -> 0x00ac, IllegalAccessException -> 0x00aa, NoSuchFieldException -> 0x00a8 }
        L_0x00a8:
            r1 = move-exception
            goto L_0x00ad
        L_0x00aa:
            r1 = move-exception
            goto L_0x00ad
        L_0x00ac:
            r1 = move-exception
        L_0x00ad:
            java.lang.String r3 = "DynamiteModule"
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01c3 }
            int r4 = r1.length()     // Catch:{ all -> 0x01c3 }
            int r4 = r4 + 30
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c3 }
            r5.<init>(r4)     // Catch:{ all -> 0x01c3 }
            java.lang.String r4 = "Failed to load module via V2: "
            r5.append(r4)     // Catch:{ all -> 0x01c3 }
            r5.append(r1)     // Catch:{ all -> 0x01c3 }
            java.lang.String r1 = r5.toString()     // Catch:{ all -> 0x01c3 }
            android.util.Log.w(r3, r1)     // Catch:{ all -> 0x01c3 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x01c3 }
        L_0x00cf:
            f18016h = r1     // Catch:{ all -> 0x01c3 }
        L_0x00d1:
            monitor-exit(r0)     // Catch:{ all -> 0x01c3 }
            boolean r0 = r1.booleanValue()     // Catch:{ all -> 0x01c6 }
            r1 = 0
            if (r0 == 0) goto L_0x00ff
            int r9 = b(r9, r10, r11)     // Catch:{ LoadingException -> 0x00de }
            return r9
        L_0x00de:
            r10 = move-exception
            java.lang.String r11 = "DynamiteModule"
            java.lang.String r0 = "Failed to retrieve remote module version: "
            java.lang.String r10 = r10.getMessage()     // Catch:{ all -> 0x01c6 }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x01c6 }
            int r2 = r10.length()     // Catch:{ all -> 0x01c6 }
            if (r2 == 0) goto L_0x00f6
            java.lang.String r10 = r0.concat(r10)     // Catch:{ all -> 0x01c6 }
            goto L_0x00fb
        L_0x00f6:
            java.lang.String r10 = new java.lang.String     // Catch:{ all -> 0x01c6 }
            r10.<init>(r0)     // Catch:{ all -> 0x01c6 }
        L_0x00fb:
            android.util.Log.w(r11, r10)     // Catch:{ all -> 0x01c6 }
            return r1
        L_0x00ff:
            com.google.android.gms.dynamite.q r3 = a((android.content.Context) r9)     // Catch:{ all -> 0x01c6 }
            if (r3 != 0) goto L_0x0107
            goto L_0x01ba
        L_0x0107:
            int r0 = r3.a()     // Catch:{ RemoteException -> 0x0194 }
            r4 = 3
            if (r0 < r4) goto L_0x016f
            java.lang.ThreadLocal<com.google.android.gms.dynamite.n> r0 = f18020l     // Catch:{ RemoteException -> 0x0194 }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x0194 }
            com.google.android.gms.dynamite.n r0 = (com.google.android.gms.dynamite.n) r0     // Catch:{ RemoteException -> 0x0194 }
            if (r0 == 0) goto L_0x0122
            android.database.Cursor r0 = r0.f18031a     // Catch:{ RemoteException -> 0x0194 }
            if (r0 == 0) goto L_0x0122
            int r1 = r0.getInt(r1)     // Catch:{ RemoteException -> 0x0194 }
            goto L_0x01ba
        L_0x0122:
            com.google.android.gms.dynamic.b r4 = com.google.android.gms.dynamic.d.a(r9)     // Catch:{ RemoteException -> 0x0194 }
            java.lang.ThreadLocal<java.lang.Long> r0 = f18021m     // Catch:{ RemoteException -> 0x0194 }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x0194 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ RemoteException -> 0x0194 }
            long r7 = r0.longValue()     // Catch:{ RemoteException -> 0x0194 }
            r5 = r10
            r6 = r11
            com.google.android.gms.dynamic.b r10 = r3.a((com.google.android.gms.dynamic.b) r4, (java.lang.String) r5, (boolean) r6, (long) r7)     // Catch:{ RemoteException -> 0x0194 }
            java.lang.Object r10 = com.google.android.gms.dynamic.d.a((com.google.android.gms.dynamic.b) r10)     // Catch:{ RemoteException -> 0x0194 }
            android.database.Cursor r10 = (android.database.Cursor) r10     // Catch:{ RemoteException -> 0x0194 }
            if (r10 == 0) goto L_0x015c
            boolean r11 = r10.moveToFirst()     // Catch:{ RemoteException -> 0x016c, all -> 0x0169 }
            if (r11 != 0) goto L_0x0147
            goto L_0x015c
        L_0x0147:
            int r11 = r10.getInt(r1)     // Catch:{ RemoteException -> 0x016c, all -> 0x0169 }
            if (r11 <= 0) goto L_0x0154
            boolean r0 = a((android.database.Cursor) r10)     // Catch:{ RemoteException -> 0x016c, all -> 0x0169 }
            if (r0 == 0) goto L_0x0154
            goto L_0x0155
        L_0x0154:
            r2 = r10
        L_0x0155:
            if (r2 == 0) goto L_0x015a
            r2.close()     // Catch:{ all -> 0x01c6 }
        L_0x015a:
            r1 = r11
            goto L_0x01ba
        L_0x015c:
            java.lang.String r11 = "DynamiteModule"
            java.lang.String r0 = "Failed to retrieve remote module version."
            android.util.Log.w(r11, r0)     // Catch:{ RemoteException -> 0x016c, all -> 0x0169 }
            if (r10 == 0) goto L_0x01ba
            r10.close()     // Catch:{ all -> 0x01c6 }
            goto L_0x01ba
        L_0x0169:
            r11 = move-exception
            r2 = r10
            goto L_0x01bd
        L_0x016c:
            r11 = move-exception
            r2 = r10
            goto L_0x0196
        L_0x016f:
            r4 = 2
            if (r0 != r4) goto L_0x0182
            java.lang.String r0 = "DynamiteModule"
            java.lang.String r4 = "IDynamite loader version = 2, no high precision latency measurement."
            android.util.Log.w(r0, r4)     // Catch:{ RemoteException -> 0x0194 }
            com.google.android.gms.dynamic.b r0 = com.google.android.gms.dynamic.d.a(r9)     // Catch:{ RemoteException -> 0x0194 }
            int r1 = r3.b((com.google.android.gms.dynamic.b) r0, (java.lang.String) r10, (boolean) r11)     // Catch:{ RemoteException -> 0x0194 }
            goto L_0x01ba
        L_0x0182:
            java.lang.String r0 = "DynamiteModule"
            java.lang.String r4 = "IDynamite loader version < 2, falling back to getModuleVersion2"
            android.util.Log.w(r0, r4)     // Catch:{ RemoteException -> 0x0194 }
            com.google.android.gms.dynamic.b r0 = com.google.android.gms.dynamic.d.a(r9)     // Catch:{ RemoteException -> 0x0194 }
            int r1 = r3.a((com.google.android.gms.dynamic.b) r0, (java.lang.String) r10, (boolean) r11)     // Catch:{ RemoteException -> 0x0194 }
            goto L_0x01ba
        L_0x0192:
            r11 = r10
            goto L_0x01bd
        L_0x0194:
            r10 = move-exception
            r11 = r10
        L_0x0196:
            java.lang.String r10 = "DynamiteModule"
            java.lang.String r0 = "Failed to retrieve remote module version: "
            java.lang.String r11 = r11.getMessage()     // Catch:{ all -> 0x01bb }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x01bb }
            int r3 = r11.length()     // Catch:{ all -> 0x01bb }
            if (r3 == 0) goto L_0x01ad
            java.lang.String r11 = r0.concat(r11)     // Catch:{ all -> 0x01bb }
            goto L_0x01b2
        L_0x01ad:
            java.lang.String r11 = new java.lang.String     // Catch:{ all -> 0x01bb }
            r11.<init>(r0)     // Catch:{ all -> 0x01bb }
        L_0x01b2:
            android.util.Log.w(r10, r11)     // Catch:{ all -> 0x01bb }
            if (r2 == 0) goto L_0x01ba
            r2.close()     // Catch:{ all -> 0x01c6 }
        L_0x01ba:
            return r1
        L_0x01bb:
            r10 = move-exception
            goto L_0x0192
        L_0x01bd:
            if (r2 == 0) goto L_0x01c2
            r2.close()     // Catch:{ all -> 0x01c6 }
        L_0x01c2:
            throw r11     // Catch:{ all -> 0x01c6 }
        L_0x01c3:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x01c3 }
            throw r10     // Catch:{ all -> 0x01c6 }
        L_0x01c6:
            r10 = move-exception
            com.google.android.gms.common.util.e.a(r9, r10)
            goto L_0x01cc
        L_0x01cb:
            throw r10
        L_0x01cc:
            goto L_0x01cb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.a(android.content.Context, java.lang.String, boolean):int");
    }

    public static DynamiteModule a(Context context, a aVar, String str) throws LoadingException {
        int i2;
        ThreadLocal<Long> threadLocal;
        Boolean bool;
        DynamiteModule dynamiteModule;
        b bVar;
        r rVar;
        Boolean valueOf;
        b bVar2;
        Context context2 = context;
        a aVar2 = aVar;
        String str2 = str;
        Class<DynamiteModule> cls = DynamiteModule.class;
        ThreadLocal<n> threadLocal2 = f18020l;
        n nVar = threadLocal2.get();
        n nVar2 = new n((m) null);
        threadLocal2.set(nVar2);
        ThreadLocal<Long> threadLocal3 = f18021m;
        long longValue = threadLocal3.get().longValue();
        try {
            threadLocal3.set(Long.valueOf(SystemClock.elapsedRealtime()));
            a.b a2 = aVar2.a(context2, str2, f18022n);
            int i3 = a2.f18026a;
            int i4 = a2.f18027b;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length());
            sb.append("Considering local module ");
            sb.append(str2);
            sb.append(":");
            sb.append(i3);
            sb.append(" and remote module ");
            sb.append(str2);
            sb.append(":");
            sb.append(i4);
            Log.i("DynamiteModule", sb.toString());
            int i5 = a2.f18028c;
            if (i5 != 0) {
                if (i5 == -1) {
                    if (a2.f18026a != 0) {
                        i5 = -1;
                    }
                }
                if (!(i5 == 1 && a2.f18027b == 0)) {
                    if (i5 == -1) {
                        DynamiteModule b2 = b(context2, str2);
                        if (longValue == 0) {
                            threadLocal3.remove();
                        } else {
                            threadLocal3.set(Long.valueOf(longValue));
                        }
                        Cursor cursor = nVar2.f18031a;
                        if (cursor != null) {
                            cursor.close();
                        }
                        threadLocal2.set(nVar);
                        return b2;
                    } else if (i5 == 1) {
                        try {
                            int i6 = a2.f18027b;
                            try {
                                synchronized (cls) {
                                    bool = f18016h;
                                }
                                if (bool != null) {
                                    if (bool.booleanValue()) {
                                        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 51);
                                        sb2.append("Selected remote version of ");
                                        sb2.append(str2);
                                        sb2.append(", version >= ");
                                        sb2.append(i6);
                                        Log.i("DynamiteModule", sb2.toString());
                                        synchronized (cls) {
                                            rVar = f18024q;
                                        }
                                        if (rVar != null) {
                                            n nVar3 = threadLocal2.get();
                                            if (nVar3 == null || nVar3.f18031a == null) {
                                                throw new LoadingException("No result cursor", (p) null);
                                            }
                                            Context applicationContext = context.getApplicationContext();
                                            Cursor cursor2 = nVar3.f18031a;
                                            d.a(null);
                                            synchronized (cls) {
                                                valueOf = Boolean.valueOf(f18019k >= 2);
                                            }
                                            if (valueOf.booleanValue()) {
                                                Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                                                bVar2 = rVar.b(d.a(applicationContext), str2, i6, d.a(cursor2));
                                            } else {
                                                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                                                bVar2 = rVar.a(d.a(applicationContext), str2, i6, d.a(cursor2));
                                            }
                                            Context context3 = (Context) d.a(bVar2);
                                            if (context3 != null) {
                                                dynamiteModule = new DynamiteModule(context3);
                                            } else {
                                                throw new LoadingException("Failed to get module context", (p) null);
                                            }
                                        } else {
                                            throw new LoadingException("DynamiteLoaderV2 was not cached.", (p) null);
                                        }
                                    } else {
                                        StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 51);
                                        sb3.append("Selected remote version of ");
                                        sb3.append(str2);
                                        sb3.append(", version >= ");
                                        sb3.append(i6);
                                        Log.i("DynamiteModule", sb3.toString());
                                        q a3 = a(context);
                                        if (a3 != null) {
                                            int a4 = a3.a();
                                            if (a4 >= 3) {
                                                n nVar4 = threadLocal2.get();
                                                if (nVar4 != null) {
                                                    bVar = a3.a(d.a(context), str2, i6, d.a(nVar4.f18031a));
                                                } else {
                                                    throw new LoadingException("No cached result cursor holder", (p) null);
                                                }
                                            } else if (a4 == 2) {
                                                Log.w("DynamiteModule", "IDynamite loader version = 2");
                                                bVar = a3.b(d.a(context), str2, i6);
                                            } else {
                                                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                                bVar = a3.a(d.a(context), str2, i6);
                                            }
                                            if (d.a(bVar) != null) {
                                                dynamiteModule = new DynamiteModule((Context) d.a(bVar));
                                            } else {
                                                throw new LoadingException("Failed to load remote module.", (p) null);
                                            }
                                        } else {
                                            throw new LoadingException("Failed to create IDynamiteLoader.", (p) null);
                                        }
                                    }
                                    if (longValue == 0) {
                                        threadLocal3.remove();
                                    } else {
                                        threadLocal3.set(Long.valueOf(longValue));
                                    }
                                    Cursor cursor3 = nVar2.f18031a;
                                    if (cursor3 != null) {
                                        cursor3.close();
                                    }
                                    threadLocal2.set(nVar);
                                    return dynamiteModule;
                                }
                                throw new LoadingException("Failed to determine which loading route to use.", (p) null);
                            } catch (RemoteException e2) {
                                throw new LoadingException("Failed to load remote module.", e2, (p) null);
                            } catch (LoadingException e3) {
                                throw e3;
                            } catch (Throwable th) {
                                e.a(context2, th);
                                throw new LoadingException("Failed to load remote module.", th, (p) null);
                            }
                        } catch (LoadingException e4) {
                            String valueOf2 = String.valueOf(e4.getMessage());
                            Log.w("DynamiteModule", valueOf2.length() != 0 ? "Failed to load remote module: ".concat(valueOf2) : new String("Failed to load remote module: "));
                            int i7 = a2.f18026a;
                            if (i7 != 0) {
                                if (aVar.a(context2, str2, new o(i7, 0)).f18028c == -1) {
                                    DynamiteModule b3 = b(context2, str2);
                                    if (i2 != 0) {
                                        threadLocal.set(Long.valueOf(longValue));
                                    }
                                    return b3;
                                }
                            }
                            throw new LoadingException("Remote load failed. No local fallback found.", e4, (p) null);
                        }
                    } else {
                        StringBuilder sb4 = new StringBuilder(47);
                        sb4.append("VersionPolicy returned invalid code:");
                        sb4.append(i5);
                        throw new LoadingException(sb4.toString(), (p) null);
                    }
                }
            }
            int i8 = a2.f18026a;
            int i9 = a2.f18027b;
            StringBuilder sb5 = new StringBuilder(String.valueOf(str).length() + 92);
            sb5.append("No acceptable module ");
            sb5.append(str2);
            sb5.append(" found. Local version is ");
            sb5.append(i8);
            sb5.append(" and remote version is ");
            sb5.append(i9);
            sb5.append(".");
            throw new LoadingException(sb5.toString(), (p) null);
        } finally {
            i2 = (longValue > 0 ? 1 : (longValue == 0 ? 0 : -1));
            threadLocal = f18021m;
            if (i2 == 0) {
                threadLocal.remove();
            } else {
                threadLocal.set(Long.valueOf(longValue));
            }
            Cursor cursor4 = nVar2.f18031a;
            if (cursor4 != null) {
                cursor4.close();
            }
            f18020l.set(nVar);
        }
    }

    private static q a(Context context) {
        q qVar;
        synchronized (DynamiteModule.class) {
            q qVar2 = f18023p;
            if (qVar2 != null) {
                return qVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    qVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    qVar = queryLocalInterface instanceof q ? (q) queryLocalInterface : new q(iBinder);
                }
                if (qVar != null) {
                    f18023p = qVar;
                    return qVar;
                }
            } catch (Exception e2) {
                String valueOf = String.valueOf(e2.getMessage());
                Log.e("DynamiteModule", valueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
            }
        }
        return null;
    }

    private static void a(ClassLoader classLoader) throws LoadingException {
        r rVar;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                rVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                rVar = queryLocalInterface instanceof r ? (r) queryLocalInterface : new r(iBinder);
            }
            f18024q = rVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new LoadingException("Failed to instantiate dynamite loader", e2, (p) null);
        }
    }

    private static boolean a(Cursor cursor) {
        n nVar = f18020l.get();
        if (nVar == null || nVar.f18031a != null) {
            return false;
        }
        nVar.f18031a = cursor;
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x00c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int b(android.content.Context r10, java.lang.String r11, boolean r12) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r0 = 0
            java.lang.ThreadLocal<java.lang.Long> r1 = f18021m     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            long r1 = r1.longValue()     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            java.lang.String r10 = "api_force_staging"
            java.lang.String r4 = "api"
            r9 = 1
            if (r9 == r12) goto L_0x0019
            r10 = r4
        L_0x0019:
            android.net.Uri$Builder r12 = new android.net.Uri$Builder     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            r12.<init>()     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            java.lang.String r4 = "content"
            android.net.Uri$Builder r12 = r12.scheme(r4)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            java.lang.String r4 = "com.google.android.gms.chimera"
            android.net.Uri$Builder r12 = r12.authority(r4)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            android.net.Uri$Builder r10 = r12.path(r10)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            android.net.Uri$Builder r10 = r10.appendPath(r11)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            java.lang.String r11 = "requestStartTime"
            java.lang.String r12 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            android.net.Uri$Builder r10 = r10.appendQueryParameter(r11, r12)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            android.net.Uri r4 = r10.build()     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            if (r10 == 0) goto L_0x00a0
            boolean r11 = r10.moveToFirst()     // Catch:{ Exception -> 0x009e }
            if (r11 == 0) goto L_0x00a0
            r11 = 0
            int r12 = r10.getInt(r11)     // Catch:{ Exception -> 0x009e }
            if (r12 <= 0) goto L_0x008e
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r1 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r1)     // Catch:{ Exception -> 0x009e }
            r2 = 2
            java.lang.String r2 = r10.getString(r2)     // Catch:{ all -> 0x008b }
            f18017i = r2     // Catch:{ all -> 0x008b }
            java.lang.String r2 = "loaderVersion"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x008b }
            if (r2 < 0) goto L_0x006f
            int r2 = r10.getInt(r2)     // Catch:{ all -> 0x008b }
            f18019k = r2     // Catch:{ all -> 0x008b }
        L_0x006f:
            java.lang.String r2 = "disableStandaloneDynamiteLoader"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x008b }
            if (r2 < 0) goto L_0x0082
            int r2 = r10.getInt(r2)     // Catch:{ all -> 0x008b }
            if (r2 == 0) goto L_0x007e
            goto L_0x007f
        L_0x007e:
            r9 = 0
        L_0x007f:
            f18018j = r9     // Catch:{ all -> 0x008b }
            r11 = r9
        L_0x0082:
            monitor-exit(r1)     // Catch:{ all -> 0x008b }
            boolean r1 = a((android.database.Cursor) r10)     // Catch:{ Exception -> 0x009e }
            if (r1 == 0) goto L_0x008e
            r10 = r0
            goto L_0x008e
        L_0x008b:
            r11 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x008b }
            throw r11     // Catch:{ Exception -> 0x009e }
        L_0x008e:
            if (r11 != 0) goto L_0x0096
            if (r10 == 0) goto L_0x0095
            r10.close()
        L_0x0095:
            return r12
        L_0x0096:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r11 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x009e }
            java.lang.String r12 = "forcing fallback to container DynamiteLoader impl"
            r11.<init>(r12, r0)     // Catch:{ Exception -> 0x009e }
            throw r11     // Catch:{ Exception -> 0x009e }
        L_0x009e:
            r11 = move-exception
            goto L_0x00b5
        L_0x00a0:
            java.lang.String r11 = "DynamiteModule"
            java.lang.String r12 = "Failed to retrieve remote module version."
            android.util.Log.w(r11, r12)     // Catch:{ Exception -> 0x009e }
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r11 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x009e }
            java.lang.String r12 = "Failed to connect to dynamite module ContentResolver."
            r11.<init>(r12, r0)     // Catch:{ Exception -> 0x009e }
            throw r11     // Catch:{ Exception -> 0x009e }
        L_0x00af:
            r10 = move-exception
            r11 = r10
            goto L_0x00c4
        L_0x00b2:
            r10 = move-exception
            r11 = r10
            r10 = r0
        L_0x00b5:
            boolean r12 = r11 instanceof com.google.android.gms.dynamite.DynamiteModule.LoadingException     // Catch:{ all -> 0x00c2 }
            if (r12 == 0) goto L_0x00ba
            throw r11     // Catch:{ all -> 0x00c2 }
        L_0x00ba:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r12 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x00c2 }
            java.lang.String r1 = "V2 version check failed"
            r12.<init>(r1, r11, r0)     // Catch:{ all -> 0x00c2 }
            throw r12     // Catch:{ all -> 0x00c2 }
        L_0x00c2:
            r11 = move-exception
            r0 = r10
        L_0x00c4:
            if (r0 == 0) goto L_0x00c9
            r0.close()
        L_0x00c9:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.b(android.content.Context, java.lang.String, boolean):int");
    }

    private static DynamiteModule b(Context context, String str) {
        String valueOf = String.valueOf(str);
        Log.i("DynamiteModule", valueOf.length() != 0 ? "Selected local version of ".concat(valueOf) : new String("Selected local version of "));
        return new DynamiteModule(context.getApplicationContext());
    }

    public Context a() {
        return this.f18025o;
    }
}
