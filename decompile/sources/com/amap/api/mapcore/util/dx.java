package com.amap.api.mapcore.util;

import java.util.ArrayList;

public final class dx {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<a> f8361a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private boolean f8362b = false;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f8363a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public Object f8364b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public Class<?>[] f8365c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public Object[] f8366d;

        public a(Object obj, String str, Object... objArr) {
            this.f8364b = obj;
            this.f8363a = str;
            if (objArr != null && objArr.length > 0) {
                this.f8365c = new Class[objArr.length];
                for (int i2 = 0; i2 < objArr.length; i2++) {
                    this.f8365c[i2] = objArr[i2].getClass();
                }
                this.f8366d = new Object[objArr.length];
                for (int i3 = 0; i3 < objArr.length; i3++) {
                    this.f8366d[i3] = objArr[i3];
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0043, code lost:
        if (com.amap.api.mapcore.util.dx.a.c(r3).length > 0) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0045, code lost:
        r5 = new java.lang.Class[com.amap.api.mapcore.util.dx.a.c(r3).length];
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0052, code lost:
        if (r6 < com.amap.api.mapcore.util.dx.a.c(r3).length) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005f, code lost:
        if (com.amap.api.mapcore.util.dx.a.c(r3)[r6].getInterfaces().length > 0) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0061, code lost:
        r5[r6] = com.amap.api.mapcore.util.dx.a.c(r3)[r6].getInterfaces()[0];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006f, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0072, code lost:
        r5 = r4.getDeclaredMethod(com.amap.api.mapcore.util.dx.a.b(r3), r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008b, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r3.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0090, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0091, code lost:
        r3.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0095, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0096, code lost:
        r3.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x009a, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x009b, code lost:
        r3.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x003e */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008b A[ExcHandler: InvocationTargetException (r3v9 'e' java.lang.reflect.InvocationTargetException A[CUSTOM_DECLARE]), Splitter:B:12:0x001c] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0090 A[Catch:{ NoSuchMethodException -> 0x003e, SecurityException -> 0x009a, IllegalAccessException -> 0x0095, IllegalArgumentException -> 0x0090, InvocationTargetException -> 0x008b }, ExcHandler: IllegalArgumentException (r3v8 'e' java.lang.IllegalArgumentException A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:12:0x001c] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0095 A[Catch:{ NoSuchMethodException -> 0x003e, SecurityException -> 0x009a, IllegalAccessException -> 0x0095, IllegalArgumentException -> 0x0090, InvocationTargetException -> 0x008b }, ExcHandler: IllegalAccessException (r3v7 'e' java.lang.IllegalAccessException A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:12:0x001c] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009a A[Catch:{ NoSuchMethodException -> 0x003e, SecurityException -> 0x009a, IllegalAccessException -> 0x0095, IllegalArgumentException -> 0x0090, InvocationTargetException -> 0x008b }, ExcHandler: SecurityException (r3v6 'e' java.lang.SecurityException A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:12:0x001c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a() {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.f8362b     // Catch:{ all -> 0x00ae }
            r1 = 1
            if (r0 != r1) goto L_0x0008
            monitor-exit(r8)
            return
        L_0x0008:
            r8.f8362b = r1     // Catch:{ all -> 0x00ae }
            r0 = 0
            r2 = 0
        L_0x000c:
            java.util.ArrayList<com.amap.api.mapcore.util.dx$a> r3 = r8.f8361a     // Catch:{ all -> 0x00ae }
            int r3 = r3.size()     // Catch:{ all -> 0x00ae }
            if (r2 >= r3) goto L_0x00a7
            java.util.ArrayList<com.amap.api.mapcore.util.dx$a> r3 = r8.f8361a     // Catch:{ all -> 0x00ae }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ all -> 0x00ae }
            com.amap.api.mapcore.util.dx$a r3 = (com.amap.api.mapcore.util.dx.a) r3     // Catch:{ all -> 0x00ae }
            java.lang.Object r4 = r3.f8364b     // Catch:{ NoSuchMethodException -> 0x009f, SecurityException -> 0x009a, IllegalAccessException -> 0x0095, IllegalArgumentException -> 0x0090, InvocationTargetException -> 0x008b }
            if (r4 != 0) goto L_0x0024
            goto L_0x00a3
        L_0x0024:
            java.lang.Object r4 = r3.f8364b     // Catch:{ NoSuchMethodException -> 0x009f, SecurityException -> 0x009a, IllegalAccessException -> 0x0095, IllegalArgumentException -> 0x0090, InvocationTargetException -> 0x008b }
            java.lang.Class r4 = r4.getClass()     // Catch:{ NoSuchMethodException -> 0x009f, SecurityException -> 0x009a, IllegalAccessException -> 0x0095, IllegalArgumentException -> 0x0090, InvocationTargetException -> 0x008b }
            if (r4 != 0) goto L_0x0030
            goto L_0x00a3
        L_0x0030:
            r5 = 0
            java.lang.String r6 = r3.f8363a     // Catch:{ NoSuchMethodException -> 0x003e, SecurityException -> 0x009a, IllegalAccessException -> 0x0095, IllegalArgumentException -> 0x0090, InvocationTargetException -> 0x008b }
            java.lang.Class[] r7 = r3.f8365c     // Catch:{ NoSuchMethodException -> 0x003e, SecurityException -> 0x009a, IllegalAccessException -> 0x0095, IllegalArgumentException -> 0x0090, InvocationTargetException -> 0x008b }
            java.lang.reflect.Method r5 = r4.getDeclaredMethod(r6, r7)     // Catch:{ NoSuchMethodException -> 0x003e, SecurityException -> 0x009a, IllegalAccessException -> 0x0095, IllegalArgumentException -> 0x0090, InvocationTargetException -> 0x008b }
            goto L_0x007a
        L_0x003e:
            java.lang.Class[] r6 = r3.f8365c     // Catch:{ NoSuchMethodException -> 0x009f, SecurityException -> 0x009a, IllegalAccessException -> 0x0095, IllegalArgumentException -> 0x0090, InvocationTargetException -> 0x008b }
            int r6 = r6.length     // Catch:{ NoSuchMethodException -> 0x009f, SecurityException -> 0x009a, IllegalAccessException -> 0x0095, IllegalArgumentException -> 0x0090, InvocationTargetException -> 0x008b }
            if (r6 <= 0) goto L_0x007a
            java.lang.Class[] r5 = r3.f8365c     // Catch:{ NoSuchMethodException -> 0x009f, SecurityException -> 0x009a, IllegalAccessException -> 0x0095, IllegalArgumentException -> 0x0090, InvocationTargetException -> 0x008b }
            int r5 = r5.length     // Catch:{ NoSuchMethodException -> 0x009f, SecurityException -> 0x009a, IllegalAccessException -> 0x0095, IllegalArgumentException -> 0x0090, InvocationTargetException -> 0x008b }
            java.lang.Class[] r5 = new java.lang.Class[r5]     // Catch:{ NoSuchMethodException -> 0x009f, SecurityException -> 0x009a, IllegalAccessException -> 0x0095, IllegalArgumentException -> 0x0090, InvocationTargetException -> 0x008b }
            r6 = 0
        L_0x004d:
            java.lang.Class[] r7 = r3.f8365c     // Catch:{ NoSuchMethodException -> 0x009f, SecurityException -> 0x009a, IllegalAccessException -> 0x0095, IllegalArgumentException -> 0x0090, InvocationTargetException -> 0x008b }
            int r7 = r7.length     // Catch:{ NoSuchMethodException -> 0x009f, SecurityException -> 0x009a, IllegalAccessException -> 0x0095, IllegalArgumentException -> 0x0090, InvocationTargetException -> 0x008b }
            if (r6 >= r7) goto L_0x0072
            java.lang.Class[] r7 = r3.f8365c     // Catch:{ NoSuchMethodException -> 0x009f, SecurityException -> 0x009a, IllegalAccessException -> 0x0095, IllegalArgumentException -> 0x0090, InvocationTargetException -> 0x008b }
            r7 = r7[r6]     // Catch:{ NoSuchMethodException -> 0x009f, SecurityException -> 0x009a, IllegalAccessException -> 0x0095, IllegalArgumentException -> 0x0090, InvocationTargetException -> 0x008b }
            java.lang.Class[] r7 = r7.getInterfaces()     // Catch:{ NoSuchMethodException -> 0x009f, SecurityException -> 0x009a, IllegalAccessException -> 0x0095, IllegalArgumentException -> 0x0090, InvocationTargetException -> 0x008b }
            int r7 = r7.length     // Catch:{ NoSuchMethodException -> 0x009f, SecurityException -> 0x009a, IllegalAccessException -> 0x0095, IllegalArgumentException -> 0x0090, InvocationTargetException -> 0x008b }
            if (r7 <= 0) goto L_0x006f
            java.lang.Class[] r7 = r3.f8365c     // Catch:{ NoSuchMethodException -> 0x009f, SecurityException -> 0x009a, IllegalAccessException -> 0x0095, IllegalArgumentException -> 0x0090, InvocationTargetException -> 0x008b }
            r7 = r7[r6]     // Catch:{ NoSuchMethodException -> 0x009f, SecurityException -> 0x009a, IllegalAccessException -> 0x0095, IllegalArgumentException -> 0x0090, InvocationTargetException -> 0x008b }
            java.lang.Class[] r7 = r7.getInterfaces()     // Catch:{ NoSuchMethodException -> 0x009f, SecurityException -> 0x009a, IllegalAccessException -> 0x0095, IllegalArgumentException -> 0x0090, InvocationTargetException -> 0x008b }
            r7 = r7[r0]     // Catch:{ NoSuchMethodException -> 0x009f, SecurityException -> 0x009a, IllegalAccessException -> 0x0095, IllegalArgumentException -> 0x0090, InvocationTargetException -> 0x008b }
            r5[r6] = r7     // Catch:{ NoSuchMethodException -> 0x009f, SecurityException -> 0x009a, IllegalAccessException -> 0x0095, IllegalArgumentException -> 0x0090, InvocationTargetException -> 0x008b }
        L_0x006f:
            int r6 = r6 + 1
            goto L_0x004d
        L_0x0072:
            java.lang.String r6 = r3.f8363a     // Catch:{ NoSuchMethodException -> 0x009f, SecurityException -> 0x009a, IllegalAccessException -> 0x0095, IllegalArgumentException -> 0x0090, InvocationTargetException -> 0x008b }
            java.lang.reflect.Method r5 = r4.getDeclaredMethod(r6, r5)     // Catch:{ NoSuchMethodException -> 0x009f, SecurityException -> 0x009a, IllegalAccessException -> 0x0095, IllegalArgumentException -> 0x0090, InvocationTargetException -> 0x008b }
        L_0x007a:
            if (r5 == 0) goto L_0x00a3
            r5.setAccessible(r1)     // Catch:{ NoSuchMethodException -> 0x009f, SecurityException -> 0x009a, IllegalAccessException -> 0x0095, IllegalArgumentException -> 0x0090, InvocationTargetException -> 0x008b }
            java.lang.Object r4 = r3.f8364b     // Catch:{ NoSuchMethodException -> 0x009f, SecurityException -> 0x009a, IllegalAccessException -> 0x0095, IllegalArgumentException -> 0x0090, InvocationTargetException -> 0x008b }
            java.lang.Object[] r3 = r3.f8366d     // Catch:{ NoSuchMethodException -> 0x009f, SecurityException -> 0x009a, IllegalAccessException -> 0x0095, IllegalArgumentException -> 0x0090, InvocationTargetException -> 0x008b }
            r5.invoke(r4, r3)     // Catch:{ NoSuchMethodException -> 0x009f, SecurityException -> 0x009a, IllegalAccessException -> 0x0095, IllegalArgumentException -> 0x0090, InvocationTargetException -> 0x008b }
            goto L_0x00a3
        L_0x008b:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x00ae }
            goto L_0x00a3
        L_0x0090:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x00ae }
            goto L_0x00a3
        L_0x0095:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x00ae }
            goto L_0x00a3
        L_0x009a:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x00ae }
            goto L_0x00a3
        L_0x009f:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x00ae }
        L_0x00a3:
            int r2 = r2 + 1
            goto L_0x000c
        L_0x00a7:
            java.util.ArrayList<com.amap.api.mapcore.util.dx$a> r0 = r8.f8361a     // Catch:{ all -> 0x00ae }
            r0.clear()     // Catch:{ all -> 0x00ae }
            monitor-exit(r8)
            return
        L_0x00ae:
            r0 = move-exception
            monitor-exit(r8)
            goto L_0x00b2
        L_0x00b1:
            throw r0
        L_0x00b2:
            goto L_0x00b1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.dx.a():void");
    }

    public final synchronized void a(Object obj, Object... objArr) {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace != null && stackTrace.length >= 3) {
                this.f8361a.add(new a(obj, stackTrace[3].getMethodName(), objArr));
            }
        } catch (Throwable unused) {
        }
        this.f8362b = false;
    }
}
