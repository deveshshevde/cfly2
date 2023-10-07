package com.google.android.gms.internal.gtm;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class zzxy {
    static final long zza = ((long) zzz(byte[].class));
    static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class<?> zzd = zzsk.zza();
    private static final boolean zze;
    private static final boolean zzf;
    private static final zzxx zzg;
    private static final boolean zzh;
    private static final boolean zzi;

    /* JADX WARNING: Removed duplicated region for block: B:34:0x015a  */
    static {
        /*
            java.lang.Class<double[]> r0 = double[].class
            java.lang.Class<float[]> r1 = float[].class
            java.lang.Class<long[]> r2 = long[].class
            java.lang.Class<int[]> r3 = int[].class
            java.lang.Class<boolean[]> r4 = boolean[].class
            sun.misc.Unsafe r5 = zzg()
            zzc = r5
            java.lang.Class r6 = com.google.android.gms.internal.gtm.zzsk.zza()
            zzd = r6
            java.lang.Class r6 = java.lang.Long.TYPE
            boolean r6 = zzv(r6)
            zze = r6
            java.lang.Class r7 = java.lang.Integer.TYPE
            boolean r7 = zzv(r7)
            zzf = r7
            r8 = 0
            if (r5 != 0) goto L_0x002a
            goto L_0x0039
        L_0x002a:
            if (r6 == 0) goto L_0x0032
            com.google.android.gms.internal.gtm.zzxw r8 = new com.google.android.gms.internal.gtm.zzxw
            r8.<init>(r5)
            goto L_0x0039
        L_0x0032:
            if (r7 == 0) goto L_0x0039
            com.google.android.gms.internal.gtm.zzxv r8 = new com.google.android.gms.internal.gtm.zzxv
            r8.<init>(r5)
        L_0x0039:
            zzg = r8
            java.lang.String r5 = "getLong"
            java.lang.String r6 = "objectFieldOffset"
            r7 = 2
            r9 = 1
            r10 = 0
            if (r8 != 0) goto L_0x0046
        L_0x0044:
            r8 = 0
            goto L_0x0073
        L_0x0046:
            sun.misc.Unsafe r8 = r8.zza
            if (r8 != 0) goto L_0x004b
            goto L_0x0044
        L_0x004b:
            java.lang.Class r8 = r8.getClass()     // Catch:{ all -> 0x006e }
            java.lang.Class[] r11 = new java.lang.Class[r9]     // Catch:{ all -> 0x006e }
            java.lang.Class<java.lang.reflect.Field> r12 = java.lang.reflect.Field.class
            r11[r10] = r12     // Catch:{ all -> 0x006e }
            r8.getMethod(r6, r11)     // Catch:{ all -> 0x006e }
            java.lang.Class[] r11 = new java.lang.Class[r7]     // Catch:{ all -> 0x006e }
            java.lang.Class<java.lang.Object> r12 = java.lang.Object.class
            r11[r10] = r12     // Catch:{ all -> 0x006e }
            java.lang.Class r12 = java.lang.Long.TYPE     // Catch:{ all -> 0x006e }
            r11[r9] = r12     // Catch:{ all -> 0x006e }
            r8.getMethod(r5, r11)     // Catch:{ all -> 0x006e }
            java.lang.reflect.Field r8 = zzB()     // Catch:{ all -> 0x006e }
            if (r8 != 0) goto L_0x006c
            goto L_0x0044
        L_0x006c:
            r8 = 1
            goto L_0x0073
        L_0x006e:
            r8 = move-exception
            zzh(r8)
            goto L_0x0044
        L_0x0073:
            zzh = r8
            com.google.android.gms.internal.gtm.zzxx r8 = zzg
            if (r8 != 0) goto L_0x007c
        L_0x0079:
            r5 = 0
            goto L_0x0111
        L_0x007c:
            sun.misc.Unsafe r8 = r8.zza
            if (r8 != 0) goto L_0x0081
            goto L_0x0079
        L_0x0081:
            java.lang.Class r8 = r8.getClass()     // Catch:{ all -> 0x010b }
            java.lang.Class[] r11 = new java.lang.Class[r9]     // Catch:{ all -> 0x010b }
            java.lang.Class<java.lang.reflect.Field> r12 = java.lang.reflect.Field.class
            r11[r10] = r12     // Catch:{ all -> 0x010b }
            r8.getMethod(r6, r11)     // Catch:{ all -> 0x010b }
            java.lang.Class[] r6 = new java.lang.Class[r9]     // Catch:{ all -> 0x010b }
            java.lang.Class<java.lang.Class> r11 = java.lang.Class.class
            r6[r10] = r11     // Catch:{ all -> 0x010b }
            java.lang.String r11 = "arrayBaseOffset"
            r8.getMethod(r11, r6)     // Catch:{ all -> 0x010b }
            java.lang.Class[] r6 = new java.lang.Class[r9]     // Catch:{ all -> 0x010b }
            java.lang.Class<java.lang.Class> r11 = java.lang.Class.class
            r6[r10] = r11     // Catch:{ all -> 0x010b }
            java.lang.String r11 = "arrayIndexScale"
            r8.getMethod(r11, r6)     // Catch:{ all -> 0x010b }
            java.lang.Class[] r6 = new java.lang.Class[r7]     // Catch:{ all -> 0x010b }
            java.lang.Class<java.lang.Object> r11 = java.lang.Object.class
            r6[r10] = r11     // Catch:{ all -> 0x010b }
            java.lang.Class r11 = java.lang.Long.TYPE     // Catch:{ all -> 0x010b }
            r6[r9] = r11     // Catch:{ all -> 0x010b }
            java.lang.String r11 = "getInt"
            r8.getMethod(r11, r6)     // Catch:{ all -> 0x010b }
            r6 = 3
            java.lang.Class[] r11 = new java.lang.Class[r6]     // Catch:{ all -> 0x010b }
            java.lang.Class<java.lang.Object> r12 = java.lang.Object.class
            r11[r10] = r12     // Catch:{ all -> 0x010b }
            java.lang.Class r12 = java.lang.Long.TYPE     // Catch:{ all -> 0x010b }
            r11[r9] = r12     // Catch:{ all -> 0x010b }
            java.lang.Class r12 = java.lang.Integer.TYPE     // Catch:{ all -> 0x010b }
            r11[r7] = r12     // Catch:{ all -> 0x010b }
            java.lang.String r12 = "putInt"
            r8.getMethod(r12, r11)     // Catch:{ all -> 0x010b }
            java.lang.Class[] r11 = new java.lang.Class[r7]     // Catch:{ all -> 0x010b }
            java.lang.Class<java.lang.Object> r12 = java.lang.Object.class
            r11[r10] = r12     // Catch:{ all -> 0x010b }
            java.lang.Class r12 = java.lang.Long.TYPE     // Catch:{ all -> 0x010b }
            r11[r9] = r12     // Catch:{ all -> 0x010b }
            r8.getMethod(r5, r11)     // Catch:{ all -> 0x010b }
            java.lang.Class[] r5 = new java.lang.Class[r6]     // Catch:{ all -> 0x010b }
            java.lang.Class<java.lang.Object> r11 = java.lang.Object.class
            r5[r10] = r11     // Catch:{ all -> 0x010b }
            java.lang.Class r11 = java.lang.Long.TYPE     // Catch:{ all -> 0x010b }
            r5[r9] = r11     // Catch:{ all -> 0x010b }
            java.lang.Class r11 = java.lang.Long.TYPE     // Catch:{ all -> 0x010b }
            r5[r7] = r11     // Catch:{ all -> 0x010b }
            java.lang.String r11 = "putLong"
            r8.getMethod(r11, r5)     // Catch:{ all -> 0x010b }
            java.lang.Class[] r5 = new java.lang.Class[r7]     // Catch:{ all -> 0x010b }
            java.lang.Class<java.lang.Object> r11 = java.lang.Object.class
            r5[r10] = r11     // Catch:{ all -> 0x010b }
            java.lang.Class r11 = java.lang.Long.TYPE     // Catch:{ all -> 0x010b }
            r5[r9] = r11     // Catch:{ all -> 0x010b }
            java.lang.String r11 = "getObject"
            r8.getMethod(r11, r5)     // Catch:{ all -> 0x010b }
            java.lang.Class[] r5 = new java.lang.Class[r6]     // Catch:{ all -> 0x010b }
            java.lang.Class<java.lang.Object> r6 = java.lang.Object.class
            r5[r10] = r6     // Catch:{ all -> 0x010b }
            java.lang.Class r6 = java.lang.Long.TYPE     // Catch:{ all -> 0x010b }
            r5[r9] = r6     // Catch:{ all -> 0x010b }
            java.lang.Class<java.lang.Object> r6 = java.lang.Object.class
            r5[r7] = r6     // Catch:{ all -> 0x010b }
            java.lang.String r6 = "putObject"
            r8.getMethod(r6, r5)     // Catch:{ all -> 0x010b }
            r5 = 1
            goto L_0x0111
        L_0x010b:
            r5 = move-exception
            zzh(r5)
            goto L_0x0079
        L_0x0111:
            zzi = r5
            java.lang.Class<byte[]> r5 = byte[].class
            int r5 = zzz(r5)
            long r5 = (long) r5
            zza = r5
            zzz(r4)
            zzA(r4)
            zzz(r3)
            zzA(r3)
            zzz(r2)
            zzA(r2)
            zzz(r1)
            zzA(r1)
            zzz(r0)
            zzA(r0)
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            zzz(r0)
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            zzA(r0)
            java.lang.reflect.Field r0 = zzB()
            if (r0 == 0) goto L_0x0151
            com.google.android.gms.internal.gtm.zzxx r1 = zzg
            if (r1 == 0) goto L_0x0151
            r1.zzl(r0)
        L_0x0151:
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x015a
            goto L_0x015b
        L_0x015a:
            r9 = 0
        L_0x015b:
            zzb = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzxy.<clinit>():void");
    }

    private zzxy() {
    }

    private static int zzA(Class<?> cls) {
        if (zzi) {
            return zzg.zzi(cls);
        }
        return -1;
    }

    private static Field zzB() {
        int i2 = zzsk.zza;
        Field zzC = zzC(Buffer.class, "effectiveDirectAddress");
        if (zzC != null) {
            return zzC;
        }
        Field zzC2 = zzC(Buffer.class, "address");
        if (zzC2 == null || zzC2.getType() != Long.TYPE) {
            return null;
        }
        return zzC2;
    }

    private static Field zzC(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void zzD(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        zzxx zzxx = zzg;
        int i2 = ((((int) j2) ^ -1) & 3) << 3;
        zzxx.zzn(obj, j3, ((255 & b2) << i2) | (zzxx.zzj(obj, j3) & ((255 << i2) ^ -1)));
    }

    /* access modifiers changed from: private */
    public static void zzE(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        zzxx zzxx = zzg;
        int i2 = (((int) j2) & 3) << 3;
        zzxx.zzn(obj, j3, ((255 & b2) << i2) | (zzxx.zzj(obj, j3) & ((255 << i2) ^ -1)));
    }

    static double zza(Object obj, long j2) {
        return zzg.zza(obj, j2);
    }

    static float zzb(Object obj, long j2) {
        return zzg.zzb(obj, j2);
    }

    static int zzc(Object obj, long j2) {
        return zzg.zzj(obj, j2);
    }

    static long zzd(Object obj, long j2) {
        return zzg.zzk(obj, j2);
    }

    static <T> T zze(Class<T> cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    static Object zzf(Object obj, long j2) {
        return zzg.zzm(obj, j2);
    }

    static Unsafe zzg() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzxu());
        } catch (Throwable unused) {
            return null;
        }
    }

    static /* synthetic */ void zzh(Throwable th) {
        Logger logger = Logger.getLogger(zzxy.class.getName());
        Level level = Level.WARNING;
        String valueOf = String.valueOf(th);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
        sb.append("platform method missing - proto runtime falling back to safer methods: ");
        sb.append(valueOf);
        logger.logp(level, "com.google.protobuf.UnsafeUtil", "logMissingMethod", sb.toString());
    }

    static void zzm(Object obj, long j2, boolean z2) {
        zzg.zzc(obj, j2, z2);
    }

    static void zzn(byte[] bArr, long j2, byte b2) {
        zzg.zzd(bArr, zza + j2, b2);
    }

    static void zzo(Object obj, long j2, double d2) {
        zzg.zze(obj, j2, d2);
    }

    static void zzp(Object obj, long j2, float f2) {
        zzg.zzf(obj, j2, f2);
    }

    static void zzq(Object obj, long j2, int i2) {
        zzg.zzn(obj, j2, i2);
    }

    static void zzr(Object obj, long j2, long j3) {
        zzg.zzo(obj, j2, j3);
    }

    static void zzs(Object obj, long j2, Object obj2) {
        zzg.zzp(obj, j2, obj2);
    }

    static /* synthetic */ boolean zzt(Object obj, long j2) {
        return ((byte) ((zzg.zzj(obj, -4 & j2) >>> ((int) (((j2 ^ -1) & 3) << 3))) & 255)) != 0;
    }

    static /* synthetic */ boolean zzu(Object obj, long j2) {
        return ((byte) ((zzg.zzj(obj, -4 & j2) >>> ((int) ((j2 & 3) << 3))) & 255)) != 0;
    }

    static boolean zzv(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        int i2 = zzsk.zza;
        try {
            Class<?> cls3 = zzd;
            cls3.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls3.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
            cls3.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    static boolean zzw(Object obj, long j2) {
        return zzg.zzg(obj, j2);
    }

    static boolean zzx() {
        return zzi;
    }

    static boolean zzy() {
        return zzh;
    }

    private static int zzz(Class<?> cls) {
        if (zzi) {
            return zzg.zzh(cls);
        }
        return -1;
    }
}
