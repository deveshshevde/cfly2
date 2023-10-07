package com.google.android.gms.internal.gtm;

import fg.i;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

final class zzwn<T> implements zzwx<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzxy.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzwk zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final int[] zzk;
    private final int zzl;
    private final int zzm;
    private final zzvy zzn;
    private final zzxo<?, ?> zzo;
    private final zzuk<?> zzp;
    private final zzwq zzq;
    private final zzwf zzr;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.google.android.gms.internal.gtm.zzwk} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: com.google.android.gms.internal.gtm.zzwq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.google.android.gms.internal.gtm.zzwf} */
    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.gms.internal.gtm.zzuk<?>, com.google.android.gms.internal.gtm.zzuk] */
    /* JADX WARNING: type inference failed for: r3v2, types: [int] */
    /* JADX WARNING: type inference failed for: r3v9, types: [int] */
    /* JADX WARNING: type inference failed for: r3v12, types: [com.google.android.gms.internal.gtm.zzvy] */
    /* JADX WARNING: type inference failed for: r3v13, types: [com.google.android.gms.internal.gtm.zzxo<?, ?>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzwn(int[] r6, int[] r7, java.lang.Object[] r8, int r9, int r10, com.google.android.gms.internal.gtm.zzwk r11, boolean r12, boolean r13, int[] r14, int r15, int r16, com.google.android.gms.internal.gtm.zzwq r17, com.google.android.gms.internal.gtm.zzvy r18, com.google.android.gms.internal.gtm.zzxo<?, ?> r19, com.google.android.gms.internal.gtm.zzuk<?> r20, com.google.android.gms.internal.gtm.zzwf r21) {
        /*
            r5 = this;
            r0 = r5
            r1 = r10
            r2 = r19
            r5.<init>()
            r3 = r6
            r0.zzc = r3
            r3 = r7
            r0.zzd = r3
            r3 = r8
            r0.zze = r3
            r3 = r9
            r0.zzf = r3
            boolean r3 = r1 instanceof com.google.android.gms.internal.gtm.zzuz
            r0.zzi = r3
            r3 = r11
            r0.zzj = r3
            r3 = 0
            if (r2 == 0) goto L_0x0024
            boolean r4 = r2.zzi(r10)
            if (r4 == 0) goto L_0x0024
            r3 = 1
        L_0x0024:
            r0.zzh = r3
            r3 = r13
            r0.zzk = r3
            r3 = r14
            r0.zzl = r3
            r3 = r15
            r0.zzm = r3
            r3 = r16
            r0.zzq = r3
            r3 = r17
            r0.zzn = r3
            r3 = r18
            r0.zzo = r3
            r0.zzp = r2
            r0.zzg = r1
            r1 = r20
            r0.zzr = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzwn.<init>(int[], java.lang.Object[], int, int, com.google.android.gms.internal.gtm.zzwk, boolean, boolean, int[], int, int, com.google.android.gms.internal.gtm.zzwq, com.google.android.gms.internal.gtm.zzvy, com.google.android.gms.internal.gtm.zzxo, com.google.android.gms.internal.gtm.zzuk, com.google.android.gms.internal.gtm.zzwf, byte[]):void");
    }

    private final int zzA(int i2, int i3) {
        int length = (this.zzc.length / 3) - 1;
        while (i3 <= length) {
            int i4 = (length + i3) >>> 1;
            int i5 = i4 * 3;
            int i6 = this.zzc[i5];
            if (i2 == i6) {
                return i5;
            }
            if (i2 < i6) {
                length = i4 - 1;
            } else {
                i3 = i4 + 1;
            }
        }
        return -1;
    }

    private static int zzB(int i2) {
        return (i2 >>> 20) & 255;
    }

    private final int zzC(int i2) {
        return this.zzc[i2 + 1];
    }

    private static <T> long zzD(T t2, long j2) {
        return ((Long) zzxy.zzf(t2, j2)).longValue();
    }

    private final zzvd zzE(int i2) {
        int i3 = i2 / 3;
        return (zzvd) this.zzd[i3 + i3 + 1];
    }

    private final zzwx zzF(int i2) {
        int i3 = i2 / 3;
        int i4 = i3 + i3;
        zzwx zzwx = (zzwx) this.zzd[i4];
        if (zzwx != null) {
            return zzwx;
        }
        zzwx zzb2 = zzwt.zza().zzb((Class) this.zzd[i4 + 1]);
        this.zzd[i4] = zzb2;
        return zzb2;
    }

    private final <UT, UB> UB zzG(Object obj, int i2, UB ub, zzxo<UT, UB> zzxo) {
        int i3 = this.zzc[i2];
        Object zzf2 = zzxy.zzf(obj, (long) (zzC(i2) & 1048575));
        if (zzf2 == null || zzE(i2) == null) {
            return ub;
        }
        zzwe zzwe = (zzwe) zzf2;
        zzwd zzwd = (zzwd) zzH(i2);
        throw null;
    }

    private final Object zzH(int i2) {
        int i3 = i2 / 3;
        return this.zzd[i3 + i3];
    }

    private static Field zzI(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    private final void zzJ(T t2, T t3, int i2) {
        long zzC = (long) (zzC(i2) & 1048575);
        if (zzQ(t3, i2)) {
            Object zzf2 = zzxy.zzf(t2, zzC);
            Object zzf3 = zzxy.zzf(t3, zzC);
            if (zzf2 != null && zzf3 != null) {
                zzf3 = zzvi.zzg(zzf2, zzf3);
            } else if (zzf3 == null) {
                return;
            }
            zzxy.zzs(t2, zzC, zzf3);
            zzM(t2, i2);
        }
    }

    private final void zzK(T t2, T t3, int i2) {
        int zzC = zzC(i2);
        int i3 = this.zzc[i2];
        long j2 = (long) (zzC & 1048575);
        if (zzT(t3, i3, i2)) {
            Object zzf2 = zzT(t2, i3, i2) ? zzxy.zzf(t2, j2) : null;
            Object zzf3 = zzxy.zzf(t3, j2);
            if (zzf2 != null && zzf3 != null) {
                zzf3 = zzvi.zzg(zzf2, zzf3);
            } else if (zzf3 == null) {
                return;
            }
            zzxy.zzs(t2, j2, zzf3);
            zzN(t2, i3, i2);
        }
    }

    private final void zzL(Object obj, int i2, zzww zzww) throws IOException {
        long j2;
        Object zzq2;
        if (zzP(i2)) {
            j2 = (long) (i2 & 1048575);
            zzq2 = zzww.zzx();
        } else {
            int i3 = i2 & 1048575;
            if (this.zzi) {
                j2 = (long) i3;
                zzq2 = zzww.zzv();
            } else {
                j2 = (long) i3;
                zzq2 = zzww.zzq();
            }
        }
        zzxy.zzs(obj, j2, zzq2);
    }

    private final void zzM(T t2, int i2) {
        int zzz = zzz(i2);
        long j2 = (long) (1048575 & zzz);
        if (j2 != 1048575) {
            zzxy.zzq(t2, j2, (1 << (zzz >>> 20)) | zzxy.zzc(t2, j2));
        }
    }

    private final void zzN(T t2, int i2, int i3) {
        zzxy.zzq(t2, (long) (zzz(i3) & 1048575), i2);
    }

    private final boolean zzO(T t2, T t3, int i2) {
        return zzQ(t2, i2) == zzQ(t3, i2);
    }

    private static boolean zzP(int i2) {
        return (i2 & 536870912) != 0;
    }

    private final boolean zzQ(T t2, int i2) {
        int zzz = zzz(i2);
        long j2 = (long) (zzz & 1048575);
        if (j2 != 1048575) {
            return (zzxy.zzc(t2, j2) & (1 << (zzz >>> 20))) != 0;
        }
        int zzC = zzC(i2);
        long j3 = (long) (zzC & 1048575);
        switch (zzB(zzC)) {
            case 0:
                return zzxy.zza(t2, j3) != i.f27244a;
            case 1:
                return zzxy.zzb(t2, j3) != 0.0f;
            case 2:
                return zzxy.zzd(t2, j3) != 0;
            case 3:
                return zzxy.zzd(t2, j3) != 0;
            case 4:
                return zzxy.zzc(t2, j3) != 0;
            case 5:
                return zzxy.zzd(t2, j3) != 0;
            case 6:
                return zzxy.zzc(t2, j3) != 0;
            case 7:
                return zzxy.zzw(t2, j3);
            case 8:
                Object zzf2 = zzxy.zzf(t2, j3);
                if (zzf2 instanceof String) {
                    return !((String) zzf2).isEmpty();
                }
                if (zzf2 instanceof zztd) {
                    return !zztd.zzb.equals(zzf2);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzxy.zzf(t2, j3) != null;
            case 10:
                return !zztd.zzb.equals(zzxy.zzf(t2, j3));
            case 11:
                return zzxy.zzc(t2, j3) != 0;
            case 12:
                return zzxy.zzc(t2, j3) != 0;
            case 13:
                return zzxy.zzc(t2, j3) != 0;
            case 14:
                return zzxy.zzd(t2, j3) != 0;
            case 15:
                return zzxy.zzc(t2, j3) != 0;
            case 16:
                return zzxy.zzd(t2, j3) != 0;
            case 17:
                return zzxy.zzf(t2, j3) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzR(T t2, int i2, int i3, int i4, int i5) {
        return i3 == 1048575 ? zzQ(t2, i2) : (i4 & i5) != 0;
    }

    private static boolean zzS(Object obj, int i2, zzwx zzwx) {
        return zzwx.zzk(zzxy.zzf(obj, (long) (i2 & 1048575)));
    }

    private final boolean zzT(T t2, int i2, int i3) {
        return zzxy.zzc(t2, (long) (zzz(i3) & 1048575)) == i2;
    }

    private static <T> boolean zzU(T t2, long j2) {
        return ((Boolean) zzxy.zzf(t2, j2)).booleanValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0283, code lost:
        com.google.android.gms.internal.gtm.zzwz.zzV(r4, (java.util.List) r7.getObject(r1, r8), r2, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0293, code lost:
        com.google.android.gms.internal.gtm.zzwz.zzU(r4, (java.util.List) r7.getObject(r1, r8), r2, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x02a3, code lost:
        com.google.android.gms.internal.gtm.zzwz.zzM(r4, (java.util.List) r7.getObject(r1, r8), r2, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x02b3, code lost:
        com.google.android.gms.internal.gtm.zzwz.zzZ(r4, (java.util.List) r7.getObject(r1, r8), r2, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0459, code lost:
        r10 = r10 + 3;
        r8 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0269, code lost:
        com.google.android.gms.internal.gtm.zzwz.zzX(r4, r8, r2, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0273, code lost:
        com.google.android.gms.internal.gtm.zzwz.zzW(r4, (java.util.List) r7.getObject(r1, r8), r2, r14);
     */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0462  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzV(T r18, com.google.android.gms.internal.gtm.zztp r19) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r0.zzh
            if (r3 == 0) goto L_0x0023
            com.google.android.gms.internal.gtm.zzuk<?> r3 = r0.zzp
            com.google.android.gms.internal.gtm.zzuo r3 = r3.zzb(r1)
            com.google.android.gms.internal.gtm.zzxk<T, java.lang.Object> r5 = r3.zza
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0023
            java.util.Iterator r3 = r3.zzf()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0025
        L_0x0023:
            r3 = 0
            r5 = 0
        L_0x0025:
            int[] r6 = r0.zzc
            int r6 = r6.length
            sun.misc.Unsafe r7 = zzb
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = 0
            r11 = 1048575(0xfffff, float:1.469367E-39)
            r12 = 0
        L_0x0032:
            if (r10 >= r6) goto L_0x0460
            int r13 = r0.zzC(r10)
            int[] r14 = r0.zzc
            r14 = r14[r10]
            int r15 = zzB(r13)
            r4 = 17
            if (r15 > r4) goto L_0x005a
            int[] r4 = r0.zzc
            int r16 = r10 + 2
            r4 = r4[r16]
            r9 = r4 & r8
            if (r9 == r11) goto L_0x0054
            long r11 = (long) r9
            int r12 = r7.getInt(r1, r11)
            r11 = r9
        L_0x0054:
            int r4 = r4 >>> 20
            r9 = 1
            int r4 = r9 << r4
            goto L_0x005b
        L_0x005a:
            r4 = 0
        L_0x005b:
            if (r5 == 0) goto L_0x0079
            com.google.android.gms.internal.gtm.zzuk<?> r9 = r0.zzp
            int r9 = r9.zza(r5)
            if (r9 > r14) goto L_0x0079
            com.google.android.gms.internal.gtm.zzuk<?> r9 = r0.zzp
            r9.zzj(r2, r5)
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0077
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x005b
        L_0x0077:
            r5 = 0
            goto L_0x005b
        L_0x0079:
            r9 = r13 & r8
            long r8 = (long) r9
            switch(r15) {
                case 0: goto L_0x044e;
                case 1: goto L_0x0442;
                case 2: goto L_0x0436;
                case 3: goto L_0x042a;
                case 4: goto L_0x041e;
                case 5: goto L_0x0412;
                case 6: goto L_0x0406;
                case 7: goto L_0x03fa;
                case 8: goto L_0x03ee;
                case 9: goto L_0x03dd;
                case 10: goto L_0x03ce;
                case 11: goto L_0x03c1;
                case 12: goto L_0x03b4;
                case 13: goto L_0x03a7;
                case 14: goto L_0x039a;
                case 15: goto L_0x038d;
                case 16: goto L_0x0380;
                case 17: goto L_0x036f;
                case 18: goto L_0x035f;
                case 19: goto L_0x034f;
                case 20: goto L_0x033f;
                case 21: goto L_0x032f;
                case 22: goto L_0x031f;
                case 23: goto L_0x030f;
                case 24: goto L_0x02ff;
                case 25: goto L_0x02ef;
                case 26: goto L_0x02e0;
                case 27: goto L_0x02cd;
                case 28: goto L_0x02be;
                case 29: goto L_0x02ae;
                case 30: goto L_0x029e;
                case 31: goto L_0x028e;
                case 32: goto L_0x027e;
                case 33: goto L_0x026e;
                case 34: goto L_0x025e;
                case 35: goto L_0x024e;
                case 36: goto L_0x023e;
                case 37: goto L_0x022e;
                case 38: goto L_0x021e;
                case 39: goto L_0x020e;
                case 40: goto L_0x01fe;
                case 41: goto L_0x01ee;
                case 42: goto L_0x01de;
                case 43: goto L_0x01d7;
                case 44: goto L_0x01d0;
                case 45: goto L_0x01c9;
                case 46: goto L_0x01c2;
                case 47: goto L_0x01bb;
                case 48: goto L_0x01ae;
                case 49: goto L_0x019b;
                case 50: goto L_0x0192;
                case 51: goto L_0x0183;
                case 52: goto L_0x0174;
                case 53: goto L_0x0165;
                case 54: goto L_0x0156;
                case 55: goto L_0x0147;
                case 56: goto L_0x0138;
                case 57: goto L_0x0129;
                case 58: goto L_0x011a;
                case 59: goto L_0x010b;
                case 60: goto L_0x00f8;
                case 61: goto L_0x00e8;
                case 62: goto L_0x00da;
                case 63: goto L_0x00cc;
                case 64: goto L_0x00be;
                case 65: goto L_0x00b0;
                case 66: goto L_0x00a2;
                case 67: goto L_0x0094;
                case 68: goto L_0x0082;
                default: goto L_0x007f;
            }
        L_0x007f:
            r15 = 0
            goto L_0x0459
        L_0x0082:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007f
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.android.gms.internal.gtm.zzwx r8 = r0.zzF(r10)
            r2.zzq(r14, r4, r8)
            goto L_0x007f
        L_0x0094:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007f
            long r8 = zzD(r1, r8)
            r2.zzD(r14, r8)
            goto L_0x007f
        L_0x00a2:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007f
            int r4 = zzs(r1, r8)
            r2.zzB(r14, r4)
            goto L_0x007f
        L_0x00b0:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007f
            long r8 = zzD(r1, r8)
            r2.zzz(r14, r8)
            goto L_0x007f
        L_0x00be:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007f
            int r4 = zzs(r1, r8)
            r2.zzx(r14, r4)
            goto L_0x007f
        L_0x00cc:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007f
            int r4 = zzs(r1, r8)
            r2.zzi(r14, r4)
            goto L_0x007f
        L_0x00da:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007f
            int r4 = zzs(r1, r8)
            r2.zzI(r14, r4)
            goto L_0x007f
        L_0x00e8:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007f
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.android.gms.internal.gtm.zztd r4 = (com.google.android.gms.internal.gtm.zztd) r4
            r2.zzd(r14, r4)
            goto L_0x007f
        L_0x00f8:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007f
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.android.gms.internal.gtm.zzwx r8 = r0.zzF(r10)
            r2.zzv(r14, r4, r8)
            goto L_0x007f
        L_0x010b:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007f
            java.lang.Object r4 = r7.getObject(r1, r8)
            zzX(r14, r4, r2)
            goto L_0x007f
        L_0x011a:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007f
            boolean r4 = zzU(r1, r8)
            r2.zzb(r14, r4)
            goto L_0x007f
        L_0x0129:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007f
            int r4 = zzs(r1, r8)
            r2.zzk(r14, r4)
            goto L_0x007f
        L_0x0138:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007f
            long r8 = zzD(r1, r8)
            r2.zzm(r14, r8)
            goto L_0x007f
        L_0x0147:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007f
            int r4 = zzs(r1, r8)
            r2.zzr(r14, r4)
            goto L_0x007f
        L_0x0156:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007f
            long r8 = zzD(r1, r8)
            r2.zzK(r14, r8)
            goto L_0x007f
        L_0x0165:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007f
            long r8 = zzD(r1, r8)
            r2.zzt(r14, r8)
            goto L_0x007f
        L_0x0174:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007f
            float r4 = zzp(r1, r8)
            r2.zzo(r14, r4)
            goto L_0x007f
        L_0x0183:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007f
            double r8 = zzo(r1, r8)
            r2.zzf(r14, r8)
            goto L_0x007f
        L_0x0192:
            java.lang.Object r4 = r7.getObject(r1, r8)
            r0.zzW(r2, r14, r4, r10)
            goto L_0x007f
        L_0x019b:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwx r9 = r0.zzF(r10)
            com.google.android.gms.internal.gtm.zzwz.zzQ(r4, r8, r2, r9)
            goto L_0x007f
        L_0x01ae:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            r14 = 1
            goto L_0x0269
        L_0x01bb:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            goto L_0x0273
        L_0x01c2:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            goto L_0x0283
        L_0x01c9:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            goto L_0x0293
        L_0x01d0:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            goto L_0x02a3
        L_0x01d7:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            goto L_0x02b3
        L_0x01de:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzJ(r4, r8, r2, r14)
            goto L_0x007f
        L_0x01ee:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzN(r4, r8, r2, r14)
            goto L_0x007f
        L_0x01fe:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzO(r4, r8, r2, r14)
            goto L_0x007f
        L_0x020e:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzR(r4, r8, r2, r14)
            goto L_0x007f
        L_0x021e:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzaa(r4, r8, r2, r14)
            goto L_0x007f
        L_0x022e:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzS(r4, r8, r2, r14)
            goto L_0x007f
        L_0x023e:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzP(r4, r8, r2, r14)
            goto L_0x007f
        L_0x024e:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzL(r4, r8, r2, r14)
            goto L_0x007f
        L_0x025e:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            r14 = 0
        L_0x0269:
            com.google.android.gms.internal.gtm.zzwz.zzX(r4, r8, r2, r14)
            goto L_0x007f
        L_0x026e:
            r14 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
        L_0x0273:
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzW(r4, r8, r2, r14)
            goto L_0x007f
        L_0x027e:
            r14 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
        L_0x0283:
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzV(r4, r8, r2, r14)
            goto L_0x007f
        L_0x028e:
            r14 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
        L_0x0293:
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzU(r4, r8, r2, r14)
            goto L_0x007f
        L_0x029e:
            r14 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
        L_0x02a3:
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzM(r4, r8, r2, r14)
            goto L_0x007f
        L_0x02ae:
            r14 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
        L_0x02b3:
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzZ(r4, r8, r2, r14)
            goto L_0x007f
        L_0x02be:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzK(r4, r8, r2)
            goto L_0x007f
        L_0x02cd:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwx r9 = r0.zzF(r10)
            com.google.android.gms.internal.gtm.zzwz.zzT(r4, r8, r2, r9)
            goto L_0x007f
        L_0x02e0:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzY(r4, r8, r2)
            goto L_0x007f
        L_0x02ef:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            r15 = 0
            com.google.android.gms.internal.gtm.zzwz.zzJ(r4, r8, r2, r15)
            goto L_0x0459
        L_0x02ff:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzN(r4, r8, r2, r15)
            goto L_0x0459
        L_0x030f:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzO(r4, r8, r2, r15)
            goto L_0x0459
        L_0x031f:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzR(r4, r8, r2, r15)
            goto L_0x0459
        L_0x032f:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzaa(r4, r8, r2, r15)
            goto L_0x0459
        L_0x033f:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzS(r4, r8, r2, r15)
            goto L_0x0459
        L_0x034f:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzP(r4, r8, r2, r15)
            goto L_0x0459
        L_0x035f:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzL(r4, r8, r2, r15)
            goto L_0x0459
        L_0x036f:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0459
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.android.gms.internal.gtm.zzwx r8 = r0.zzF(r10)
            r2.zzq(r14, r4, r8)
            goto L_0x0459
        L_0x0380:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0459
            long r8 = r7.getLong(r1, r8)
            r2.zzD(r14, r8)
            goto L_0x0459
        L_0x038d:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0459
            int r4 = r7.getInt(r1, r8)
            r2.zzB(r14, r4)
            goto L_0x0459
        L_0x039a:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0459
            long r8 = r7.getLong(r1, r8)
            r2.zzz(r14, r8)
            goto L_0x0459
        L_0x03a7:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0459
            int r4 = r7.getInt(r1, r8)
            r2.zzx(r14, r4)
            goto L_0x0459
        L_0x03b4:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0459
            int r4 = r7.getInt(r1, r8)
            r2.zzi(r14, r4)
            goto L_0x0459
        L_0x03c1:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0459
            int r4 = r7.getInt(r1, r8)
            r2.zzI(r14, r4)
            goto L_0x0459
        L_0x03ce:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0459
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.android.gms.internal.gtm.zztd r4 = (com.google.android.gms.internal.gtm.zztd) r4
            r2.zzd(r14, r4)
            goto L_0x0459
        L_0x03dd:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0459
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.android.gms.internal.gtm.zzwx r8 = r0.zzF(r10)
            r2.zzv(r14, r4, r8)
            goto L_0x0459
        L_0x03ee:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0459
            java.lang.Object r4 = r7.getObject(r1, r8)
            zzX(r14, r4, r2)
            goto L_0x0459
        L_0x03fa:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0459
            boolean r4 = com.google.android.gms.internal.gtm.zzxy.zzw(r1, r8)
            r2.zzb(r14, r4)
            goto L_0x0459
        L_0x0406:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0459
            int r4 = r7.getInt(r1, r8)
            r2.zzk(r14, r4)
            goto L_0x0459
        L_0x0412:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0459
            long r8 = r7.getLong(r1, r8)
            r2.zzm(r14, r8)
            goto L_0x0459
        L_0x041e:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0459
            int r4 = r7.getInt(r1, r8)
            r2.zzr(r14, r4)
            goto L_0x0459
        L_0x042a:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0459
            long r8 = r7.getLong(r1, r8)
            r2.zzK(r14, r8)
            goto L_0x0459
        L_0x0436:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0459
            long r8 = r7.getLong(r1, r8)
            r2.zzt(r14, r8)
            goto L_0x0459
        L_0x0442:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0459
            float r4 = com.google.android.gms.internal.gtm.zzxy.zzb(r1, r8)
            r2.zzo(r14, r4)
            goto L_0x0459
        L_0x044e:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0459
            double r8 = com.google.android.gms.internal.gtm.zzxy.zza(r1, r8)
            r2.zzf(r14, r8)
        L_0x0459:
            int r10 = r10 + 3
            r8 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0032
        L_0x0460:
            if (r5 == 0) goto L_0x0477
            com.google.android.gms.internal.gtm.zzuk<?> r4 = r0.zzp
            r4.zzj(r2, r5)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0475
            java.lang.Object r4 = r3.next()
            r5 = r4
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0460
        L_0x0475:
            r5 = 0
            goto L_0x0460
        L_0x0477:
            com.google.android.gms.internal.gtm.zzxo<?, ?> r3 = r0.zzo
            java.lang.Object r1 = r3.zzd(r1)
            r3.zzs(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzwn.zzV(java.lang.Object, com.google.android.gms.internal.gtm.zztp):void");
    }

    private final <K, V> void zzW(zztp zztp, int i2, Object obj, int i3) throws IOException {
        if (obj != null) {
            zzwd zzwd = (zzwd) zzH(i3);
            throw null;
        }
    }

    private static final void zzX(int i2, Object obj, zztp zztp) throws IOException {
        if (obj instanceof String) {
            zztp.zzG(i2, (String) obj);
        } else {
            zztp.zzd(i2, (zztd) obj);
        }
    }

    static zzxp zzd(Object obj) {
        zzuz zzuz = (zzuz) obj;
        zzxp zzxp = zzuz.zzc;
        if (zzxp != zzxp.zzc()) {
            return zzxp;
        }
        zzxp zze2 = zzxp.zze();
        zzuz.zzc = zze2;
        return zze2;
    }

    static <T> zzwn<T> zzl(Class<T> cls, zzwh zzwh, zzwq zzwq, zzvy zzvy, zzxo<?, ?> zzxo, zzuk<?> zzuk, zzwf zzwf) {
        if (zzwh instanceof zzwv) {
            return zzm((zzwv) zzwh, zzwq, zzvy, zzxo, zzuk, zzwf);
        }
        zzxl zzxl = (zzxl) zzwh;
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x032f  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0378  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.android.gms.internal.gtm.zzwn<T> zzm(com.google.android.gms.internal.gtm.zzwv r34, com.google.android.gms.internal.gtm.zzwq r35, com.google.android.gms.internal.gtm.zzvy r36, com.google.android.gms.internal.gtm.zzxo<?, ?> r37, com.google.android.gms.internal.gtm.zzuk<?> r38, com.google.android.gms.internal.gtm.zzwf r39) {
        /*
            int r0 = r34.zzc()
            r1 = 0
            r3 = 2
            if (r0 != r3) goto L_0x000a
            r10 = 1
            goto L_0x000b
        L_0x000a:
            r10 = 0
        L_0x000b:
            java.lang.String r0 = r34.zzd()
            int r3 = r0.length()
            char r4 = r0.charAt(r1)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0027
            r4 = 1
        L_0x001d:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0028
            r4 = r6
            goto L_0x001d
        L_0x0027:
            r6 = 1
        L_0x0028:
            int r4 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0047
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0034:
            int r9 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0044
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r8
            r6 = r6 | r4
            int r8 = r8 + 13
            r4 = r9
            goto L_0x0034
        L_0x0044:
            int r4 = r4 << r8
            r6 = r6 | r4
            r4 = r9
        L_0x0047:
            if (r6 != 0) goto L_0x0056
            int[] r6 = zza
            r13 = r6
            r6 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r16 = 0
            goto L_0x0165
        L_0x0056:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0075
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0062:
            int r9 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0072
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r8
            r4 = r4 | r6
            int r8 = r8 + 13
            r6 = r9
            goto L_0x0062
        L_0x0072:
            int r6 = r6 << r8
            r4 = r4 | r6
            r6 = r9
        L_0x0075:
            int r8 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0094
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0081:
            int r11 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x0091
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r6 = r6 | r8
            int r9 = r9 + 13
            r8 = r11
            goto L_0x0081
        L_0x0091:
            int r8 = r8 << r9
            r6 = r6 | r8
            r8 = r11
        L_0x0094:
            int r9 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x00b3
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a0:
            int r12 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00b0
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r11
            r8 = r8 | r9
            int r11 = r11 + 13
            r9 = r12
            goto L_0x00a0
        L_0x00b0:
            int r9 = r9 << r11
            r8 = r8 | r9
            r9 = r12
        L_0x00b3:
            int r11 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00d2
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00bf:
            int r13 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00cf
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r9 = r9 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00bf
        L_0x00cf:
            int r11 = r11 << r12
            r9 = r9 | r11
            r11 = r13
        L_0x00d2:
            int r12 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00f1
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00de:
            int r14 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x00ee
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00de
        L_0x00ee:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00f1:
            int r13 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x0110
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00fd:
            int r15 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x010d
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00fd
        L_0x010d:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x0110:
            int r14 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x0131
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011c:
            int r16 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x012d
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x011c
        L_0x012d:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0131:
            int r15 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x0154
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013d:
            int r17 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r5) goto L_0x014f
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x013d
        L_0x014f:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0154:
            int r16 = r14 + r12
            int r13 = r16 + r13
            int[] r13 = new int[r13]
            int r16 = r4 + r4
            int r16 = r16 + r6
            r6 = r4
            r4 = r15
            r33 = r12
            r12 = r9
            r9 = r33
        L_0x0165:
            sun.misc.Unsafe r15 = zzb
            java.lang.Object[] r17 = r34.zze()
            com.google.android.gms.internal.gtm.zzwk r18 = r34.zza()
            java.lang.Class r1 = r18.getClass()
            int r7 = r11 * 3
            int[] r7 = new int[r7]
            int r11 = r11 + r11
            java.lang.Object[] r11 = new java.lang.Object[r11]
            int r21 = r14 + r9
            r22 = r14
            r23 = r21
            r9 = 0
            r20 = 0
        L_0x0183:
            if (r4 >= r3) goto L_0x03ca
            int r24 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x01ab
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r2 = r24
            r24 = 13
        L_0x0193:
            int r26 = r2 + 1
            char r2 = r0.charAt(r2)
            if (r2 < r5) goto L_0x01a5
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r24
            r4 = r4 | r2
            int r24 = r24 + 13
            r2 = r26
            goto L_0x0193
        L_0x01a5:
            int r2 = r2 << r24
            r4 = r4 | r2
            r2 = r26
            goto L_0x01ad
        L_0x01ab:
            r2 = r24
        L_0x01ad:
            int r24 = r2 + 1
            char r2 = r0.charAt(r2)
            if (r2 < r5) goto L_0x01da
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r5 = r24
            r24 = 13
        L_0x01bb:
            int r27 = r5 + 1
            char r5 = r0.charAt(r5)
            r28 = r3
            r3 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r3) goto L_0x01d4
            r3 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r24
            r2 = r2 | r3
            int r24 = r24 + 13
            r5 = r27
            r3 = r28
            goto L_0x01bb
        L_0x01d4:
            int r3 = r5 << r24
            r2 = r2 | r3
            r3 = r27
            goto L_0x01de
        L_0x01da:
            r28 = r3
            r3 = r24
        L_0x01de:
            r5 = r2 & 255(0xff, float:3.57E-43)
            r24 = r14
            r14 = r2 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x01ec
            int r14 = r20 + 1
            r13[r20] = r9
            r20 = r14
        L_0x01ec:
            r14 = 51
            if (r5 < r14) goto L_0x0295
            int r14 = r3 + 1
            char r3 = r0.charAt(r3)
            r27 = r14
            r14 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r14) goto L_0x0222
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r14 = r27
            r27 = 13
        L_0x0203:
            int r31 = r14 + 1
            char r14 = r0.charAt(r14)
            r32 = r12
            r12 = 55296(0xd800, float:7.7486E-41)
            if (r14 < r12) goto L_0x021c
            r12 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r27
            r3 = r3 | r12
            int r27 = r27 + 13
            r14 = r31
            r12 = r32
            goto L_0x0203
        L_0x021c:
            int r12 = r14 << r27
            r3 = r3 | r12
            r14 = r31
            goto L_0x0226
        L_0x0222:
            r32 = r12
            r14 = r27
        L_0x0226:
            int r12 = r5 + -51
            r27 = r14
            r14 = 9
            if (r12 == r14) goto L_0x0247
            r14 = 17
            if (r12 != r14) goto L_0x0233
            goto L_0x0247
        L_0x0233:
            r14 = 12
            if (r12 != r14) goto L_0x0256
            if (r10 != 0) goto L_0x0256
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
            goto L_0x0254
        L_0x0247:
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
        L_0x0254:
            r16 = r14
        L_0x0256:
            int r3 = r3 + r3
            r12 = r17[r3]
            boolean r14 = r12 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x0260
            java.lang.reflect.Field r12 = (java.lang.reflect.Field) r12
            goto L_0x0268
        L_0x0260:
            java.lang.String r12 = (java.lang.String) r12
            java.lang.reflect.Field r12 = zzI(r1, r12)
            r17[r3] = r12
        L_0x0268:
            r31 = r7
            r14 = r8
            long r7 = r15.objectFieldOffset(r12)
            int r8 = (int) r7
            int r3 = r3 + 1
            r7 = r17[r3]
            boolean r12 = r7 instanceof java.lang.reflect.Field
            if (r12 == 0) goto L_0x027b
            java.lang.reflect.Field r7 = (java.lang.reflect.Field) r7
            goto L_0x0283
        L_0x027b:
            java.lang.String r7 = (java.lang.String) r7
            java.lang.reflect.Field r7 = zzI(r1, r7)
            r17[r3] = r7
        L_0x0283:
            r3 = r8
            long r7 = r15.objectFieldOffset(r7)
            int r8 = (int) r7
            r30 = r0
            r7 = r1
            r1 = r8
            r29 = r11
            r25 = 1
            r8 = r3
            r3 = 0
            goto L_0x0391
        L_0x0295:
            r31 = r7
            r14 = r8
            r32 = r12
            int r7 = r16 + 1
            r8 = r17[r16]
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = zzI(r1, r8)
            r12 = 9
            if (r5 == r12) goto L_0x030d
            r12 = 17
            if (r5 != r12) goto L_0x02ad
            goto L_0x030d
        L_0x02ad:
            r12 = 27
            if (r5 == r12) goto L_0x02fd
            r12 = 49
            if (r5 != r12) goto L_0x02b6
            goto L_0x02fd
        L_0x02b6:
            r12 = 12
            if (r5 == r12) goto L_0x02ed
            r12 = 30
            if (r5 == r12) goto L_0x02ed
            r12 = 44
            if (r5 != r12) goto L_0x02c3
            goto L_0x02ed
        L_0x02c3:
            r12 = 50
            if (r5 != r12) goto L_0x02e3
            int r12 = r22 + 1
            r13[r22] = r9
            int r22 = r9 / 3
            int r22 = r22 + r22
            int r27 = r7 + 1
            r7 = r17[r7]
            r11[r22] = r7
            r7 = r2 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x02e6
            int r7 = r27 + 1
            int r22 = r22 + 1
            r27 = r17[r27]
            r11[r22] = r27
            r22 = r12
        L_0x02e3:
            r25 = 1
            goto L_0x031a
        L_0x02e6:
            r22 = r12
            r12 = r27
            r25 = 1
            goto L_0x031b
        L_0x02ed:
            if (r10 != 0) goto L_0x02e3
            int r12 = r9 / 3
            int r27 = r7 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
            goto L_0x030a
        L_0x02fd:
            r25 = 1
            int r12 = r9 / 3
            int r27 = r7 + 1
            int r12 = r12 + r12
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
        L_0x030a:
            r12 = r27
            goto L_0x031b
        L_0x030d:
            r25 = 1
            int r12 = r9 / 3
            int r12 = r12 + r12
            int r12 = r12 + 1
            java.lang.Class r27 = r8.getType()
            r11[r12] = r27
        L_0x031a:
            r12 = r7
        L_0x031b:
            long r7 = r15.objectFieldOffset(r8)
            int r8 = (int) r7
            r7 = r2 & 4096(0x1000, float:5.74E-42)
            r27 = 1048575(0xfffff, float:1.469367E-39)
            r29 = r11
            r11 = 4096(0x1000, float:5.74E-42)
            if (r7 != r11) goto L_0x0378
            r7 = 17
            if (r5 > r7) goto L_0x0378
            int r7 = r3 + 1
            char r3 = r0.charAt(r3)
            r11 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r11) goto L_0x0354
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r26 = 13
        L_0x033e:
            int r27 = r7 + 1
            char r7 = r0.charAt(r7)
            if (r7 < r11) goto L_0x0350
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r26
            r3 = r3 | r7
            int r26 = r26 + 13
            r7 = r27
            goto L_0x033e
        L_0x0350:
            int r7 = r7 << r26
            r3 = r3 | r7
            goto L_0x0356
        L_0x0354:
            r27 = r7
        L_0x0356:
            int r7 = r6 + r6
            int r26 = r3 / 32
            int r7 = r7 + r26
            r11 = r17[r7]
            r30 = r0
            boolean r0 = r11 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x0367
            java.lang.reflect.Field r11 = (java.lang.reflect.Field) r11
            goto L_0x036f
        L_0x0367:
            java.lang.String r11 = (java.lang.String) r11
            java.lang.reflect.Field r11 = zzI(r1, r11)
            r17[r7] = r11
        L_0x036f:
            r7 = r1
            long r0 = r15.objectFieldOffset(r11)
            int r1 = (int) r0
            int r3 = r3 % 32
            goto L_0x0381
        L_0x0378:
            r30 = r0
            r7 = r1
            r27 = r3
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r3 = 0
        L_0x0381:
            r0 = 18
            if (r5 < r0) goto L_0x038f
            r0 = 49
            if (r5 > r0) goto L_0x038f
            int r0 = r23 + 1
            r13[r23] = r8
            r23 = r0
        L_0x038f:
            r16 = r12
        L_0x0391:
            int r0 = r9 + 1
            r31[r9] = r4
            int r4 = r0 + 1
            r9 = r2 & 512(0x200, float:7.175E-43)
            if (r9 == 0) goto L_0x039e
            r9 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x039f
        L_0x039e:
            r9 = 0
        L_0x039f:
            r2 = r2 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x03a6
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03a7
        L_0x03a6:
            r2 = 0
        L_0x03a7:
            r2 = r2 | r9
            int r5 = r5 << 20
            r2 = r2 | r5
            r2 = r2 | r8
            r31[r0] = r2
            int r9 = r4 + 1
            int r0 = r3 << 20
            r0 = r0 | r1
            r31[r4] = r0
            r1 = r7
            r8 = r14
            r14 = r24
            r4 = r27
            r3 = r28
            r11 = r29
            r0 = r30
            r7 = r31
            r12 = r32
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0183
        L_0x03ca:
            r31 = r7
            r29 = r11
            r32 = r12
            r24 = r14
            r14 = r8
            com.google.android.gms.internal.gtm.zzwn r0 = new com.google.android.gms.internal.gtm.zzwn
            r4 = r0
            com.google.android.gms.internal.gtm.zzwk r9 = r34.zza()
            r11 = 0
            r1 = r29
            r20 = 0
            r5 = r31
            r6 = r1
            r7 = r14
            r8 = r32
            r12 = r13
            r13 = r24
            r14 = r21
            r15 = r35
            r16 = r36
            r17 = r37
            r18 = r38
            r19 = r39
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzwn.zzm(com.google.android.gms.internal.gtm.zzwv, com.google.android.gms.internal.gtm.zzwq, com.google.android.gms.internal.gtm.zzvy, com.google.android.gms.internal.gtm.zzxo, com.google.android.gms.internal.gtm.zzuk, com.google.android.gms.internal.gtm.zzwf):com.google.android.gms.internal.gtm.zzwn");
    }

    private static <T> double zzo(T t2, long j2) {
        return ((Double) zzxy.zzf(t2, j2)).doubleValue();
    }

    private static <T> float zzp(T t2, long j2) {
        return ((Float) zzxy.zzf(t2, j2)).floatValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x026a, code lost:
        r7 = com.google.android.gms.internal.gtm.zzto.zzv(r8, (com.google.android.gms.internal.gtm.zzwk) r0.getObject(r15, r12), zzF(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0281, code lost:
        r8 = com.google.android.gms.internal.gtm.zzto.zzD(r8 << 3);
        r7 = com.google.android.gms.internal.gtm.zzto.zzE((r9 >> 63) ^ (r9 + r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0299, code lost:
        r8 = com.google.android.gms.internal.gtm.zzto.zzD(r8 << 3);
        r7 = (r7 >> 31) ^ (r7 + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x02bf, code lost:
        r8 = com.google.android.gms.internal.gtm.zzto.zzD(r8 << 3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x02c5, code lost:
        r7 = com.google.android.gms.internal.gtm.zzto.zzD(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02cf, code lost:
        r7 = r0.getObject(r15, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02d3, code lost:
        r8 = com.google.android.gms.internal.gtm.zzto.zzD(r8 << 3);
        r7 = ((com.google.android.gms.internal.gtm.zztd) r7).zzd();
        r8 = r8 + (com.google.android.gms.internal.gtm.zzto.zzD(r7) + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02ea, code lost:
        r7 = com.google.android.gms.internal.gtm.zzwz.zzo(r8, r0.getObject(r15, r12), zzF(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0302, code lost:
        if ((r7 instanceof com.google.android.gms.internal.gtm.zztd) != false) goto L_0x02d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0305, code lost:
        r8 = com.google.android.gms.internal.gtm.zzto.zzD(r8 << 3);
        r7 = com.google.android.gms.internal.gtm.zzto.zzB((java.lang.String) r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0316, code lost:
        r7 = com.google.android.gms.internal.gtm.zzto.zzD(r8 << 3) + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x032d, code lost:
        r7 = r0.getInt(r15, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0331, code lost:
        r8 = com.google.android.gms.internal.gtm.zzto.zzD(r8 << 3);
        r7 = com.google.android.gms.internal.gtm.zzto.zzx(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x033b, code lost:
        r8 = r8 + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x033c, code lost:
        r4 = r4 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0347, code lost:
        r9 = r0.getLong(r15, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x034b, code lost:
        r7 = com.google.android.gms.internal.gtm.zzto.zzD(r8 << 3) + com.google.android.gms.internal.gtm.zzto.zzE(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x035c, code lost:
        r7 = com.google.android.gms.internal.gtm.zzto.zzD(r8 << 3) + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x036a, code lost:
        r7 = com.google.android.gms.internal.gtm.zzto.zzD(r8 << 3) + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0374, code lost:
        r3 = r3 + 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a0, code lost:
        if ((r7 instanceof com.google.android.gms.internal.gtm.zztd) != false) goto L_0x02d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c2, code lost:
        r7 = zzs(r15, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d5, code lost:
        r9 = zzD(r15, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01c3, code lost:
        r8 = com.google.android.gms.internal.gtm.zzto.zzC(r8) + com.google.android.gms.internal.gtm.zzto.zzD(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0263, code lost:
        r4 = r4 + r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzq(T r15) {
        /*
            r14 = this;
            sun.misc.Unsafe r0 = zzb
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x000c:
            int[] r7 = r14.zzc
            int r7 = r7.length
            if (r3 >= r7) goto L_0x0378
            int r7 = r14.zzC(r3)
            int[] r8 = r14.zzc
            r8 = r8[r3]
            int r9 = zzB(r7)
            r10 = 17
            r11 = 1
            if (r9 > r10) goto L_0x0037
            int[] r10 = r14.zzc
            int r12 = r3 + 2
            r10 = r10[r12]
            r12 = r10 & r1
            int r10 = r10 >>> 20
            int r10 = r11 << r10
            if (r12 == r6) goto L_0x0038
            long r5 = (long) r12
            int r5 = r0.getInt(r15, r5)
            r6 = r12
            goto L_0x0038
        L_0x0037:
            r10 = 0
        L_0x0038:
            r7 = r7 & r1
            long r12 = (long) r7
            r7 = 63
            switch(r9) {
                case 0: goto L_0x0366;
                case 1: goto L_0x0358;
                case 2: goto L_0x0343;
                case 3: goto L_0x033e;
                case 4: goto L_0x0329;
                case 5: goto L_0x0324;
                case 6: goto L_0x031f;
                case 7: goto L_0x0312;
                case 8: goto L_0x02f8;
                case 9: goto L_0x02e6;
                case 10: goto L_0x02cb;
                case 11: goto L_0x02b7;
                case 12: goto L_0x02b1;
                case 13: goto L_0x02ab;
                case 14: goto L_0x02a5;
                case 15: goto L_0x0291;
                case 16: goto L_0x0279;
                case 17: goto L_0x0266;
                case 18: goto L_0x0259;
                case 19: goto L_0x024e;
                case 20: goto L_0x0243;
                case 21: goto L_0x0238;
                case 22: goto L_0x022d;
                case 23: goto L_0x0259;
                case 24: goto L_0x024e;
                case 25: goto L_0x0222;
                case 26: goto L_0x0217;
                case 27: goto L_0x0208;
                case 28: goto L_0x01fd;
                case 29: goto L_0x01f2;
                case 30: goto L_0x01e6;
                case 31: goto L_0x024e;
                case 32: goto L_0x0259;
                case 33: goto L_0x01da;
                case 34: goto L_0x01ce;
                case 35: goto L_0x01b7;
                case 36: goto L_0x01aa;
                case 37: goto L_0x019d;
                case 38: goto L_0x0190;
                case 39: goto L_0x0183;
                case 40: goto L_0x0176;
                case 41: goto L_0x0169;
                case 42: goto L_0x015c;
                case 43: goto L_0x014e;
                case 44: goto L_0x0140;
                case 45: goto L_0x0132;
                case 46: goto L_0x0124;
                case 47: goto L_0x0116;
                case 48: goto L_0x0108;
                case 49: goto L_0x00f8;
                case 50: goto L_0x00eb;
                case 51: goto L_0x00e3;
                case 52: goto L_0x00db;
                case 53: goto L_0x00cf;
                case 54: goto L_0x00c8;
                case 55: goto L_0x00bc;
                case 56: goto L_0x00b4;
                case 57: goto L_0x00ac;
                case 58: goto L_0x00a4;
                case 59: goto L_0x0094;
                case 60: goto L_0x008c;
                case 61: goto L_0x0084;
                case 62: goto L_0x0078;
                case 63: goto L_0x0071;
                case 64: goto L_0x0069;
                case 65: goto L_0x0061;
                case 66: goto L_0x0055;
                case 67: goto L_0x0049;
                case 68: goto L_0x0041;
                default: goto L_0x003f;
            }
        L_0x003f:
            goto L_0x0374
        L_0x0041:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0374
            goto L_0x026a
        L_0x0049:
            boolean r9 = r14.zzT(r15, r8, r3)
            if (r9 == 0) goto L_0x0374
            long r9 = zzD(r15, r12)
            goto L_0x0281
        L_0x0055:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0374
            int r7 = zzs(r15, r12)
            goto L_0x0299
        L_0x0061:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0374
            goto L_0x036a
        L_0x0069:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0374
            goto L_0x035c
        L_0x0071:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0374
            goto L_0x00c2
        L_0x0078:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0374
            int r7 = zzs(r15, r12)
            goto L_0x02bf
        L_0x0084:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0374
            goto L_0x02cf
        L_0x008c:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0374
            goto L_0x02ea
        L_0x0094:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0374
            java.lang.Object r7 = r0.getObject(r15, r12)
            boolean r9 = r7 instanceof com.google.android.gms.internal.gtm.zztd
            if (r9 == 0) goto L_0x0305
            goto L_0x0304
        L_0x00a4:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0374
            goto L_0x0316
        L_0x00ac:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0374
            goto L_0x035c
        L_0x00b4:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0374
            goto L_0x036a
        L_0x00bc:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0374
        L_0x00c2:
            int r7 = zzs(r15, r12)
            goto L_0x0331
        L_0x00c8:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0374
            goto L_0x00d5
        L_0x00cf:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0374
        L_0x00d5:
            long r9 = zzD(r15, r12)
            goto L_0x034b
        L_0x00db:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0374
            goto L_0x035c
        L_0x00e3:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0374
            goto L_0x036a
        L_0x00eb:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.lang.Object r9 = r14.zzH(r3)
            com.google.android.gms.internal.gtm.zzwf.zza(r8, r7, r9)
            goto L_0x0374
        L_0x00f8:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.gtm.zzwx r9 = r14.zzF(r3)
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzj(r8, r7, r9)
            goto L_0x0263
        L_0x0108:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzt(r7)
            if (r7 <= 0) goto L_0x0374
            goto L_0x01c3
        L_0x0116:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzr(r7)
            if (r7 <= 0) goto L_0x0374
            goto L_0x01c3
        L_0x0124:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzi(r7)
            if (r7 <= 0) goto L_0x0374
            goto L_0x01c3
        L_0x0132:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzg(r7)
            if (r7 <= 0) goto L_0x0374
            goto L_0x01c3
        L_0x0140:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zze(r7)
            if (r7 <= 0) goto L_0x0374
            goto L_0x01c3
        L_0x014e:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzw(r7)
            if (r7 <= 0) goto L_0x0374
            goto L_0x01c3
        L_0x015c:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzb(r7)
            if (r7 <= 0) goto L_0x0374
            goto L_0x01c3
        L_0x0169:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzg(r7)
            if (r7 <= 0) goto L_0x0374
            goto L_0x01c3
        L_0x0176:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzi(r7)
            if (r7 <= 0) goto L_0x0374
            goto L_0x01c3
        L_0x0183:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzl(r7)
            if (r7 <= 0) goto L_0x0374
            goto L_0x01c3
        L_0x0190:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzy(r7)
            if (r7 <= 0) goto L_0x0374
            goto L_0x01c3
        L_0x019d:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzn(r7)
            if (r7 <= 0) goto L_0x0374
            goto L_0x01c3
        L_0x01aa:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzg(r7)
            if (r7 <= 0) goto L_0x0374
            goto L_0x01c3
        L_0x01b7:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzi(r7)
            if (r7 <= 0) goto L_0x0374
        L_0x01c3:
            int r8 = com.google.android.gms.internal.gtm.zzto.zzC(r8)
            int r9 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            int r8 = r8 + r9
            goto L_0x033b
        L_0x01ce:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzs(r8, r7, r2)
            goto L_0x0263
        L_0x01da:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzq(r8, r7, r2)
            goto L_0x0263
        L_0x01e6:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzd(r8, r7, r2)
            goto L_0x0263
        L_0x01f2:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzv(r8, r7, r2)
            goto L_0x0263
        L_0x01fd:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzc(r8, r7)
            goto L_0x0263
        L_0x0208:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.gtm.zzwx r9 = r14.zzF(r3)
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzp(r8, r7, r9)
            goto L_0x0263
        L_0x0217:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzu(r8, r7)
            goto L_0x0263
        L_0x0222:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zza(r8, r7, r2)
            goto L_0x0263
        L_0x022d:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzk(r8, r7, r2)
            goto L_0x0263
        L_0x0238:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzx(r8, r7, r2)
            goto L_0x0263
        L_0x0243:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzm(r8, r7, r2)
            goto L_0x0263
        L_0x024e:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzf(r8, r7, r2)
            goto L_0x0263
        L_0x0259:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzh(r8, r7, r2)
        L_0x0263:
            int r4 = r4 + r7
            goto L_0x0374
        L_0x0266:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0374
        L_0x026a:
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.gtm.zzwk r7 = (com.google.android.gms.internal.gtm.zzwk) r7
            com.google.android.gms.internal.gtm.zzwx r9 = r14.zzF(r3)
            int r7 = com.google.android.gms.internal.gtm.zzto.zzv(r8, r7, r9)
            goto L_0x0263
        L_0x0279:
            r9 = r5 & r10
            if (r9 == 0) goto L_0x0374
            long r9 = r0.getLong(r15, r12)
        L_0x0281:
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.gtm.zzto.zzD(r8)
            long r11 = r9 + r9
            long r9 = r9 >> r7
            long r9 = r9 ^ r11
            int r7 = com.google.android.gms.internal.gtm.zzto.zzE(r9)
            goto L_0x033b
        L_0x0291:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0374
            int r7 = r0.getInt(r15, r12)
        L_0x0299:
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.gtm.zzto.zzD(r8)
            int r9 = r7 + r7
            int r7 = r7 >> 31
            r7 = r7 ^ r9
            goto L_0x02c5
        L_0x02a5:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0374
            goto L_0x036a
        L_0x02ab:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0374
            goto L_0x035c
        L_0x02b1:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0374
            goto L_0x032d
        L_0x02b7:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0374
            int r7 = r0.getInt(r15, r12)
        L_0x02bf:
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.gtm.zzto.zzD(r8)
        L_0x02c5:
            int r7 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            goto L_0x033b
        L_0x02cb:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0374
        L_0x02cf:
            java.lang.Object r7 = r0.getObject(r15, r12)
        L_0x02d3:
            com.google.android.gms.internal.gtm.zztd r7 = (com.google.android.gms.internal.gtm.zztd) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.gtm.zzto.zzD(r8)
            int r7 = r7.zzd()
            int r9 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            int r9 = r9 + r7
            int r8 = r8 + r9
            goto L_0x033c
        L_0x02e6:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0374
        L_0x02ea:
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.gtm.zzwx r9 = r14.zzF(r3)
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzo(r8, r7, r9)
            goto L_0x0263
        L_0x02f8:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0374
            java.lang.Object r7 = r0.getObject(r15, r12)
            boolean r9 = r7 instanceof com.google.android.gms.internal.gtm.zztd
            if (r9 == 0) goto L_0x0305
        L_0x0304:
            goto L_0x02d3
        L_0x0305:
            java.lang.String r7 = (java.lang.String) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.gtm.zzto.zzD(r8)
            int r7 = com.google.android.gms.internal.gtm.zzto.zzB(r7)
            goto L_0x033b
        L_0x0312:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0374
        L_0x0316:
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            int r7 = r7 + r11
            goto L_0x0263
        L_0x031f:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0374
            goto L_0x035c
        L_0x0324:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0374
            goto L_0x036a
        L_0x0329:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0374
        L_0x032d:
            int r7 = r0.getInt(r15, r12)
        L_0x0331:
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.gtm.zzto.zzD(r8)
            int r7 = com.google.android.gms.internal.gtm.zzto.zzx(r7)
        L_0x033b:
            int r8 = r8 + r7
        L_0x033c:
            int r4 = r4 + r8
            goto L_0x0374
        L_0x033e:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0374
            goto L_0x0347
        L_0x0343:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0374
        L_0x0347:
            long r9 = r0.getLong(r15, r12)
        L_0x034b:
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            int r8 = com.google.android.gms.internal.gtm.zzto.zzE(r9)
            int r7 = r7 + r8
            goto L_0x0263
        L_0x0358:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0374
        L_0x035c:
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            int r7 = r7 + 4
            goto L_0x0263
        L_0x0366:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0374
        L_0x036a:
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            int r7 = r7 + 8
            goto L_0x0263
        L_0x0374:
            int r3 = r3 + 3
            goto L_0x000c
        L_0x0378:
            com.google.android.gms.internal.gtm.zzxo<?, ?> r0 = r14.zzo
            java.lang.Object r1 = r0.zzd(r15)
            int r0 = r0.zza(r1)
            int r4 = r4 + r0
            boolean r0 = r14.zzh
            if (r0 == 0) goto L_0x03d5
            com.google.android.gms.internal.gtm.zzuk<?> r0 = r14.zzp
            com.google.android.gms.internal.gtm.zzuo r15 = r0.zzb(r15)
            r0 = 0
        L_0x038e:
            com.google.android.gms.internal.gtm.zzxk<T, java.lang.Object> r1 = r15.zza
            int r1 = r1.zzb()
            if (r2 >= r1) goto L_0x03ae
            com.google.android.gms.internal.gtm.zzxk<T, java.lang.Object> r1 = r15.zza
            java.util.Map$Entry r1 = r1.zzg(r2)
            java.lang.Object r3 = r1.getKey()
            com.google.android.gms.internal.gtm.zzun r3 = (com.google.android.gms.internal.gtm.zzun) r3
            java.lang.Object r1 = r1.getValue()
            int r1 = com.google.android.gms.internal.gtm.zzuo.zza(r3, r1)
            int r0 = r0 + r1
            int r2 = r2 + 1
            goto L_0x038e
        L_0x03ae:
            com.google.android.gms.internal.gtm.zzxk<T, java.lang.Object> r15 = r15.zza
            java.lang.Iterable r15 = r15.zzc()
            java.util.Iterator r15 = r15.iterator()
        L_0x03b8:
            boolean r1 = r15.hasNext()
            if (r1 == 0) goto L_0x03d4
            java.lang.Object r1 = r15.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            com.google.android.gms.internal.gtm.zzun r2 = (com.google.android.gms.internal.gtm.zzun) r2
            java.lang.Object r1 = r1.getValue()
            int r1 = com.google.android.gms.internal.gtm.zzuo.zza(r2, r1)
            int r0 = r0 + r1
            goto L_0x03b8
        L_0x03d4:
            int r4 = r4 + r0
        L_0x03d5:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzwn.zzq(java.lang.Object):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0263, code lost:
        r4 = com.google.android.gms.internal.gtm.zzto.zzv(r6, (com.google.android.gms.internal.gtm.zzwk) com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7), zzF(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x027c, code lost:
        r5 = com.google.android.gms.internal.gtm.zzto.zzD(r6 << 3);
        r4 = com.google.android.gms.internal.gtm.zzto.zzE((r7 >> 63) ^ (r7 + r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0297, code lost:
        r5 = com.google.android.gms.internal.gtm.zzto.zzD(r6 << 3);
        r4 = (r4 >> 31) ^ (r4 + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x02c5, code lost:
        r5 = com.google.android.gms.internal.gtm.zzto.zzD(r6 << 3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x02cb, code lost:
        r4 = com.google.android.gms.internal.gtm.zzto.zzD(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02d7, code lost:
        r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02db, code lost:
        r5 = com.google.android.gms.internal.gtm.zzto.zzD(r6 << 3);
        r4 = ((com.google.android.gms.internal.gtm.zztd) r4).zzd();
        r5 = r5 + (com.google.android.gms.internal.gtm.zzto.zzD(r4) + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02f4, code lost:
        r4 = com.google.android.gms.internal.gtm.zzwz.zzo(r6, com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7), zzF(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x030e, code lost:
        if ((r4 instanceof com.google.android.gms.internal.gtm.zztd) != false) goto L_0x02db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0311, code lost:
        r5 = com.google.android.gms.internal.gtm.zzto.zzD(r6 << 3);
        r4 = com.google.android.gms.internal.gtm.zzto.zzB((java.lang.String) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0324, code lost:
        r4 = com.google.android.gms.internal.gtm.zzto.zzD(r6 << 3) + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0342, code lost:
        r4 = com.google.android.gms.internal.gtm.zzxy.zzc(r12, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0346, code lost:
        r5 = com.google.android.gms.internal.gtm.zzto.zzD(r6 << 3);
        r4 = com.google.android.gms.internal.gtm.zzto.zzx(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0350, code lost:
        r5 = r5 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0351, code lost:
        r3 = r3 + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0360, code lost:
        r4 = com.google.android.gms.internal.gtm.zzxy.zzd(r12, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0364, code lost:
        r3 = r3 + (com.google.android.gms.internal.gtm.zzto.zzD(r6 << 3) + com.google.android.gms.internal.gtm.zzto.zzE(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0377, code lost:
        r4 = com.google.android.gms.internal.gtm.zzto.zzD(r6 << 3) + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0387, code lost:
        r4 = com.google.android.gms.internal.gtm.zzto.zzD(r6 << 3) + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0391, code lost:
        r2 = r2 + 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0097, code lost:
        if ((r4 instanceof com.google.android.gms.internal.gtm.zztd) != false) goto L_0x02db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b9, code lost:
        r4 = zzs(r12, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00cc, code lost:
        r4 = zzD(r12, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01ba, code lost:
        r5 = com.google.android.gms.internal.gtm.zzto.zzC(r6) + com.google.android.gms.internal.gtm.zzto.zzD(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x025a, code lost:
        r3 = r3 + r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzr(T r12) {
        /*
            r11 = this;
            sun.misc.Unsafe r0 = zzb
            r1 = 0
            r2 = 0
            r3 = 0
        L_0x0005:
            int[] r4 = r11.zzc
            int r4 = r4.length
            if (r2 >= r4) goto L_0x0395
            int r4 = r11.zzC(r2)
            int r5 = zzB(r4)
            int[] r6 = r11.zzc
            r6 = r6[r2]
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r7
            long r7 = (long) r4
            com.google.android.gms.internal.gtm.zzup r4 = com.google.android.gms.internal.gtm.zzup.DOUBLE_LIST_PACKED
            int r4 = r4.zza()
            if (r5 < r4) goto L_0x0031
            com.google.android.gms.internal.gtm.zzup r4 = com.google.android.gms.internal.gtm.zzup.SINT64_LIST_PACKED
            int r4 = r4.zza()
            if (r5 > r4) goto L_0x0031
            int[] r4 = r11.zzc
            int r9 = r2 + 2
            r4 = r4[r9]
        L_0x0031:
            r4 = 63
            switch(r5) {
                case 0: goto L_0x0381;
                case 1: goto L_0x0371;
                case 2: goto L_0x035a;
                case 3: goto L_0x0353;
                case 4: goto L_0x033c;
                case 5: goto L_0x0335;
                case 6: goto L_0x032e;
                case 7: goto L_0x031e;
                case 8: goto L_0x0302;
                case 9: goto L_0x02ee;
                case 10: goto L_0x02d1;
                case 11: goto L_0x02bb;
                case 12: goto L_0x02b3;
                case 13: goto L_0x02ab;
                case 14: goto L_0x02a3;
                case 15: goto L_0x028d;
                case 16: goto L_0x0272;
                case 17: goto L_0x025d;
                case 18: goto L_0x0250;
                case 19: goto L_0x0245;
                case 20: goto L_0x023a;
                case 21: goto L_0x022f;
                case 22: goto L_0x0224;
                case 23: goto L_0x0250;
                case 24: goto L_0x0245;
                case 25: goto L_0x0219;
                case 26: goto L_0x020e;
                case 27: goto L_0x01ff;
                case 28: goto L_0x01f4;
                case 29: goto L_0x01e9;
                case 30: goto L_0x01dd;
                case 31: goto L_0x0245;
                case 32: goto L_0x0250;
                case 33: goto L_0x01d1;
                case 34: goto L_0x01c5;
                case 35: goto L_0x01ae;
                case 36: goto L_0x01a1;
                case 37: goto L_0x0194;
                case 38: goto L_0x0187;
                case 39: goto L_0x017a;
                case 40: goto L_0x016d;
                case 41: goto L_0x0160;
                case 42: goto L_0x0153;
                case 43: goto L_0x0145;
                case 44: goto L_0x0137;
                case 45: goto L_0x0129;
                case 46: goto L_0x011b;
                case 47: goto L_0x010d;
                case 48: goto L_0x00ff;
                case 49: goto L_0x00ef;
                case 50: goto L_0x00e2;
                case 51: goto L_0x00da;
                case 52: goto L_0x00d2;
                case 53: goto L_0x00c6;
                case 54: goto L_0x00bf;
                case 55: goto L_0x00b3;
                case 56: goto L_0x00ab;
                case 57: goto L_0x00a3;
                case 58: goto L_0x009b;
                case 59: goto L_0x008b;
                case 60: goto L_0x0083;
                case 61: goto L_0x007b;
                case 62: goto L_0x006f;
                case 63: goto L_0x0068;
                case 64: goto L_0x0060;
                case 65: goto L_0x0058;
                case 66: goto L_0x004c;
                case 67: goto L_0x0040;
                case 68: goto L_0x0038;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x0391
        L_0x0038:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x0263
        L_0x0040:
            boolean r5 = r11.zzT(r12, r6, r2)
            if (r5 == 0) goto L_0x0391
            long r7 = zzD(r12, r7)
            goto L_0x027c
        L_0x004c:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0391
            int r4 = zzs(r12, r7)
            goto L_0x0297
        L_0x0058:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x0387
        L_0x0060:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x0377
        L_0x0068:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x00b9
        L_0x006f:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0391
            int r4 = zzs(r12, r7)
            goto L_0x02c5
        L_0x007b:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x02d7
        L_0x0083:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x02f4
        L_0x008b:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0391
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.gtm.zztd
            if (r5 == 0) goto L_0x0311
            goto L_0x0310
        L_0x009b:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x0324
        L_0x00a3:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x0377
        L_0x00ab:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x0387
        L_0x00b3:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0391
        L_0x00b9:
            int r4 = zzs(r12, r7)
            goto L_0x0346
        L_0x00bf:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x00cc
        L_0x00c6:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0391
        L_0x00cc:
            long r4 = zzD(r12, r7)
            goto L_0x0364
        L_0x00d2:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x0377
        L_0x00da:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x0387
        L_0x00e2:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            java.lang.Object r5 = r11.zzH(r2)
            com.google.android.gms.internal.gtm.zzwf.zza(r6, r4, r5)
            goto L_0x0391
        L_0x00ef:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.gtm.zzwx r5 = r11.zzF(r2)
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzj(r6, r4, r5)
            goto L_0x025a
        L_0x00ff:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzt(r4)
            if (r4 <= 0) goto L_0x0391
            goto L_0x01ba
        L_0x010d:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzr(r4)
            if (r4 <= 0) goto L_0x0391
            goto L_0x01ba
        L_0x011b:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzi(r4)
            if (r4 <= 0) goto L_0x0391
            goto L_0x01ba
        L_0x0129:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzg(r4)
            if (r4 <= 0) goto L_0x0391
            goto L_0x01ba
        L_0x0137:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zze(r4)
            if (r4 <= 0) goto L_0x0391
            goto L_0x01ba
        L_0x0145:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzw(r4)
            if (r4 <= 0) goto L_0x0391
            goto L_0x01ba
        L_0x0153:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzb(r4)
            if (r4 <= 0) goto L_0x0391
            goto L_0x01ba
        L_0x0160:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzg(r4)
            if (r4 <= 0) goto L_0x0391
            goto L_0x01ba
        L_0x016d:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzi(r4)
            if (r4 <= 0) goto L_0x0391
            goto L_0x01ba
        L_0x017a:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzl(r4)
            if (r4 <= 0) goto L_0x0391
            goto L_0x01ba
        L_0x0187:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzy(r4)
            if (r4 <= 0) goto L_0x0391
            goto L_0x01ba
        L_0x0194:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzn(r4)
            if (r4 <= 0) goto L_0x0391
            goto L_0x01ba
        L_0x01a1:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzg(r4)
            if (r4 <= 0) goto L_0x0391
            goto L_0x01ba
        L_0x01ae:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzi(r4)
            if (r4 <= 0) goto L_0x0391
        L_0x01ba:
            int r5 = com.google.android.gms.internal.gtm.zzto.zzC(r6)
            int r6 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            int r5 = r5 + r6
            goto L_0x0350
        L_0x01c5:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzs(r6, r4, r1)
            goto L_0x025a
        L_0x01d1:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzq(r6, r4, r1)
            goto L_0x025a
        L_0x01dd:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzd(r6, r4, r1)
            goto L_0x025a
        L_0x01e9:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzv(r6, r4, r1)
            goto L_0x025a
        L_0x01f4:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzc(r6, r4)
            goto L_0x025a
        L_0x01ff:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.gtm.zzwx r5 = r11.zzF(r2)
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzp(r6, r4, r5)
            goto L_0x025a
        L_0x020e:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzu(r6, r4)
            goto L_0x025a
        L_0x0219:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zza(r6, r4, r1)
            goto L_0x025a
        L_0x0224:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzk(r6, r4, r1)
            goto L_0x025a
        L_0x022f:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzx(r6, r4, r1)
            goto L_0x025a
        L_0x023a:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzm(r6, r4, r1)
            goto L_0x025a
        L_0x0245:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzf(r6, r4, r1)
            goto L_0x025a
        L_0x0250:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzh(r6, r4, r1)
        L_0x025a:
            int r3 = r3 + r4
            goto L_0x0391
        L_0x025d:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0391
        L_0x0263:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            com.google.android.gms.internal.gtm.zzwk r4 = (com.google.android.gms.internal.gtm.zzwk) r4
            com.google.android.gms.internal.gtm.zzwx r5 = r11.zzF(r2)
            int r4 = com.google.android.gms.internal.gtm.zzto.zzv(r6, r4, r5)
            goto L_0x025a
        L_0x0272:
            boolean r5 = r11.zzQ(r12, r2)
            if (r5 == 0) goto L_0x0391
            long r7 = com.google.android.gms.internal.gtm.zzxy.zzd(r12, r7)
        L_0x027c:
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.gtm.zzto.zzD(r5)
            long r9 = r7 + r7
            long r6 = r7 >> r4
            long r6 = r6 ^ r9
            int r4 = com.google.android.gms.internal.gtm.zzto.zzE(r6)
            goto L_0x0350
        L_0x028d:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0391
            int r4 = com.google.android.gms.internal.gtm.zzxy.zzc(r12, r7)
        L_0x0297:
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.gtm.zzto.zzD(r5)
            int r6 = r4 + r4
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            goto L_0x02cb
        L_0x02a3:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x0387
        L_0x02ab:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x0377
        L_0x02b3:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x0342
        L_0x02bb:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0391
            int r4 = com.google.android.gms.internal.gtm.zzxy.zzc(r12, r7)
        L_0x02c5:
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.gtm.zzto.zzD(r5)
        L_0x02cb:
            int r4 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            goto L_0x0350
        L_0x02d1:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0391
        L_0x02d7:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
        L_0x02db:
            com.google.android.gms.internal.gtm.zztd r4 = (com.google.android.gms.internal.gtm.zztd) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.gtm.zzto.zzD(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            int r6 = r6 + r4
            int r5 = r5 + r6
            goto L_0x0351
        L_0x02ee:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0391
        L_0x02f4:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            com.google.android.gms.internal.gtm.zzwx r5 = r11.zzF(r2)
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzo(r6, r4, r5)
            goto L_0x025a
        L_0x0302:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0391
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.gtm.zztd
            if (r5 == 0) goto L_0x0311
        L_0x0310:
            goto L_0x02db
        L_0x0311:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.gtm.zzto.zzD(r5)
            int r4 = com.google.android.gms.internal.gtm.zzto.zzB(r4)
            goto L_0x0350
        L_0x031e:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0391
        L_0x0324:
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            int r4 = r4 + 1
            goto L_0x025a
        L_0x032e:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x0377
        L_0x0335:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x0387
        L_0x033c:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0391
        L_0x0342:
            int r4 = com.google.android.gms.internal.gtm.zzxy.zzc(r12, r7)
        L_0x0346:
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.gtm.zzto.zzD(r5)
            int r4 = com.google.android.gms.internal.gtm.zzto.zzx(r4)
        L_0x0350:
            int r5 = r5 + r4
        L_0x0351:
            int r3 = r3 + r5
            goto L_0x0391
        L_0x0353:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x0360
        L_0x035a:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0391
        L_0x0360:
            long r4 = com.google.android.gms.internal.gtm.zzxy.zzd(r12, r7)
        L_0x0364:
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.gtm.zzto.zzD(r6)
            int r4 = com.google.android.gms.internal.gtm.zzto.zzE(r4)
            int r6 = r6 + r4
            int r3 = r3 + r6
            goto L_0x0391
        L_0x0371:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0391
        L_0x0377:
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            int r4 = r4 + 4
            goto L_0x025a
        L_0x0381:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0391
        L_0x0387:
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            int r4 = r4 + 8
            goto L_0x025a
        L_0x0391:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x0395:
            com.google.android.gms.internal.gtm.zzxo<?, ?> r0 = r11.zzo
            java.lang.Object r12 = r0.zzd(r12)
            int r12 = r0.zza(r12)
            int r3 = r3 + r12
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzwn.zzr(java.lang.Object):int");
    }

    private static <T> int zzs(T t2, long j2) {
        return ((Integer) zzxy.zzf(t2, j2)).intValue();
    }

    private final <K, V> int zzt(T t2, byte[] bArr, int i2, int i3, int i4, long j2, zzsl zzsl) throws IOException {
        Unsafe unsafe = zzb;
        Object zzH = zzH(i4);
        Object object = unsafe.getObject(t2, j2);
        if (zzwf.zzb(object)) {
            zzwe zzb2 = zzwe.zza().zzb();
            zzwf.zzc(zzb2, object);
            unsafe.putObject(t2, j2, zzb2);
        }
        zzwd zzwd = (zzwd) zzH;
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0066, code lost:
        r3 = java.lang.Long.valueOf(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        r12.putObject(r1, r9, r3);
        r12.putInt(r1, r13, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0070, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007f, code lost:
        r3 = java.lang.Integer.valueOf(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ec, code lost:
        r12.putObject(r1, r9, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x010f, code lost:
        r12.putInt(r1, r13, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzu(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, long r26, int r28, com.google.android.gms.internal.gtm.zzsl r29) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r2 = r21
            r8 = r22
            r5 = r23
            r9 = r26
            r6 = r28
            r11 = r29
            sun.misc.Unsafe r12 = zzb
            int[] r7 = r0.zzc
            int r13 = r6 + 2
            r7 = r7[r13]
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r7 & r13
            long r13 = (long) r7
            r7 = 5
            r15 = 2
            switch(r25) {
                case 51: goto L_0x0183;
                case 52: goto L_0x016b;
                case 53: goto L_0x0160;
                case 54: goto L_0x0160;
                case 55: goto L_0x0155;
                case 56: goto L_0x0140;
                case 57: goto L_0x012b;
                case 58: goto L_0x0114;
                case 59: goto L_0x00e0;
                case 60: goto L_0x00be;
                case 61: goto L_0x00b3;
                case 62: goto L_0x0155;
                case 63: goto L_0x0084;
                case 64: goto L_0x012b;
                case 65: goto L_0x0140;
                case 66: goto L_0x0071;
                case 67: goto L_0x0058;
                case 68: goto L_0x0028;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x019c
        L_0x0028:
            r7 = 3
            if (r5 != r7) goto L_0x019c
            com.google.android.gms.internal.gtm.zzwx r5 = r0.zzF(r6)
            r2 = r2 & -8
            r6 = r2 | 4
            r2 = r5
            r3 = r18
            r4 = r19
            r5 = r20
            r7 = r29
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzc(r2, r3, r4, r5, r6, r7)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x004b
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x004c
        L_0x004b:
            r15 = 0
        L_0x004c:
            java.lang.Object r3 = r11.zzc
            if (r15 != 0) goto L_0x0052
            goto L_0x00ec
        L_0x0052:
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zzvi.zzg(r15, r3)
            goto L_0x00ec
        L_0x0058:
            if (r5 == 0) goto L_0x005c
            goto L_0x019c
        L_0x005c:
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzm(r3, r4, r11)
            long r3 = r11.zzb
            long r3 = com.google.android.gms.internal.gtm.zztj.zzt(r3)
        L_0x0066:
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
        L_0x006a:
            r12.putObject(r1, r9, r3)
            r12.putInt(r1, r13, r8)
            return r2
        L_0x0071:
            if (r5 == 0) goto L_0x0075
            goto L_0x019c
        L_0x0075:
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r11)
            int r3 = r11.zza
            int r3 = com.google.android.gms.internal.gtm.zztj.zzs(r3)
        L_0x007f:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x006a
        L_0x0084:
            if (r5 != 0) goto L_0x019c
            int r3 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r11)
            int r4 = r11.zza
            com.google.android.gms.internal.gtm.zzvd r5 = r0.zzE(r6)
            if (r5 == 0) goto L_0x00a6
            boolean r5 = r5.zza(r4)
            if (r5 == 0) goto L_0x0099
            goto L_0x00a6
        L_0x0099:
            com.google.android.gms.internal.gtm.zzxp r1 = zzd(r17)
            long r4 = (long) r4
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r1.zzh(r2, r4)
            goto L_0x00b0
        L_0x00a6:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r12.putObject(r1, r9, r2)
            r12.putInt(r1, r13, r8)
        L_0x00b0:
            r2 = r3
            goto L_0x019d
        L_0x00b3:
            if (r5 == r15) goto L_0x00b7
            goto L_0x019c
        L_0x00b7:
            int r2 = com.google.android.gms.internal.gtm.zzsm.zza(r3, r4, r11)
            java.lang.Object r3 = r11.zzc
            goto L_0x006a
        L_0x00be:
            if (r5 != r15) goto L_0x019c
            com.google.android.gms.internal.gtm.zzwx r2 = r0.zzF(r6)
            r5 = r20
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzd(r2, r3, r4, r5, r11)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x00d5
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x00d6
        L_0x00d5:
            r15 = 0
        L_0x00d6:
            java.lang.Object r3 = r11.zzc
            if (r15 != 0) goto L_0x00db
            goto L_0x00ec
        L_0x00db:
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zzvi.zzg(r15, r3)
            goto L_0x00ec
        L_0x00e0:
            if (r5 != r15) goto L_0x019c
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r11)
            int r4 = r11.zza
            if (r4 != 0) goto L_0x00f0
            java.lang.String r3 = ""
        L_0x00ec:
            r12.putObject(r1, r9, r3)
            goto L_0x010f
        L_0x00f0:
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            r5 = r24 & r5
            if (r5 == 0) goto L_0x0104
            int r5 = r2 + r4
            boolean r5 = com.google.android.gms.internal.gtm.zzyd.zzf(r3, r2, r5)
            if (r5 == 0) goto L_0x00ff
            goto L_0x0104
        L_0x00ff:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzd()
            throw r1
        L_0x0104:
            java.lang.String r5 = new java.lang.String
            java.nio.charset.Charset r6 = com.google.android.gms.internal.gtm.zzvi.zza
            r5.<init>(r3, r2, r4, r6)
            r12.putObject(r1, r9, r5)
            int r2 = r2 + r4
        L_0x010f:
            r12.putInt(r1, r13, r8)
            goto L_0x019d
        L_0x0114:
            if (r5 != 0) goto L_0x019c
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzm(r3, r4, r11)
            long r3 = r11.zzb
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0124
            r15 = 1
            goto L_0x0125
        L_0x0124:
            r15 = 0
        L_0x0125:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r15)
            goto L_0x006a
        L_0x012b:
            if (r5 == r7) goto L_0x012f
            goto L_0x019c
        L_0x012f:
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzb(r18, r19)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r12.putObject(r1, r9, r2)
            r12.putInt(r1, r13, r8)
            int r1 = r4 + 4
            return r1
        L_0x0140:
            r2 = 1
            if (r5 == r2) goto L_0x0144
            goto L_0x019c
        L_0x0144:
            long r2 = com.google.android.gms.internal.gtm.zzsm.zzo(r18, r19)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r12.putObject(r1, r9, r2)
            r12.putInt(r1, r13, r8)
            int r1 = r4 + 8
            return r1
        L_0x0155:
            if (r5 == 0) goto L_0x0158
            goto L_0x019c
        L_0x0158:
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r11)
            int r3 = r11.zza
            goto L_0x007f
        L_0x0160:
            if (r5 == 0) goto L_0x0163
            goto L_0x019c
        L_0x0163:
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzm(r3, r4, r11)
            long r3 = r11.zzb
            goto L_0x0066
        L_0x016b:
            if (r5 == r7) goto L_0x016e
            goto L_0x019c
        L_0x016e:
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzb(r18, r19)
            float r2 = java.lang.Float.intBitsToFloat(r2)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r12.putObject(r1, r9, r2)
            r12.putInt(r1, r13, r8)
            int r1 = r4 + 4
            return r1
        L_0x0183:
            r2 = 1
            if (r5 == r2) goto L_0x0187
            goto L_0x019c
        L_0x0187:
            long r2 = com.google.android.gms.internal.gtm.zzsm.zzo(r18, r19)
            double r2 = java.lang.Double.longBitsToDouble(r2)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            r12.putObject(r1, r9, r2)
            r12.putInt(r1, r13, r8)
            int r1 = r4 + 8
            return r1
        L_0x019c:
            r2 = r4
        L_0x019d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzwn.zzu(java.lang.Object, byte[], int, int, int, int, int, int, int, long, int, com.google.android.gms.internal.gtm.zzsl):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v5, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x028e, code lost:
        if (r0 != r15) goto L_0x0290;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x02a4, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x02d7, code lost:
        if (r0 != r15) goto L_0x0290;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x02f8, code lost:
        if (r0 != r15) goto L_0x0290;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d0, code lost:
        if (r3 == 0) goto L_0x0198;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x012e, code lost:
        r10.putObject(r14, r8, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0163, code lost:
        r6 = r6 | r21;
        r9 = r10;
        r1 = r20;
        r8 = 1048575;
        r10 = -1;
        r29 = r13;
        r13 = r2;
        r2 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0196, code lost:
        if (r3 == 0) goto L_0x0198;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0198, code lost:
        r0 = com.google.android.gms.internal.gtm.zzsm.zzj(r12, r4, r11);
        r1 = r11.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x019e, code lost:
        r10.putInt(r14, r8, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01b5, code lost:
        r0.putLong(r1, r2, r4);
        r6 = r6 | r21;
        r9 = r10;
        r2 = r13;
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01ed, code lost:
        r6 = r6 | r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01f0, code lost:
        r2 = r4;
        r28 = r10;
        r19 = r13;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzv(T r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.gtm.zzsl r35) throws java.io.IOException {
        /*
            r30 = this;
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            sun.misc.Unsafe r9 = zzb
            r10 = -1
            r16 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r33
            r1 = -1
            r2 = 0
            r6 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001a:
            if (r0 >= r13) goto L_0x0321
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002c
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzk(r0, r12, r3, r11)
            int r3 = r11.zza
            r4 = r0
            r17 = r3
            goto L_0x002f
        L_0x002c:
            r17 = r0
            r4 = r3
        L_0x002f:
            int r5 = r17 >>> 3
            r3 = r17 & 7
            if (r5 <= r1) goto L_0x003c
            int r2 = r2 / 3
            int r0 = r15.zzy(r5, r2)
            goto L_0x0040
        L_0x003c:
            int r0 = r15.zzx(r5)
        L_0x0040:
            r2 = r0
            if (r2 != r10) goto L_0x004e
            r2 = r4
            r20 = r5
            r28 = r9
            r18 = -1
            r19 = 0
            goto L_0x02fb
        L_0x004e:
            int[] r0 = r15.zzc
            int r1 = r2 + 1
            r1 = r0[r1]
            int r0 = zzB(r1)
            r10 = r1 & r8
            r19 = r9
            long r8 = (long) r10
            r10 = 17
            r33 = r5
            if (r0 > r10) goto L_0x01f9
            int[] r10 = r15.zzc
            int r21 = r2 + 2
            r10 = r10[r21]
            int r21 = r10 >>> 20
            r5 = 1
            int r21 = r5 << r21
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r10 = r10 & r13
            r23 = r1
            r20 = r2
            if (r10 == r7) goto L_0x0090
            if (r7 == r13) goto L_0x0081
            long r1 = (long) r7
            r7 = r19
            r7.putInt(r14, r1, r6)
            goto L_0x0083
        L_0x0081:
            r7 = r19
        L_0x0083:
            if (r10 == r13) goto L_0x008a
            long r1 = (long) r10
            int r6 = r7.getInt(r14, r1)
        L_0x008a:
            r29 = r10
            r10 = r7
            r7 = r29
            goto L_0x0092
        L_0x0090:
            r10 = r19
        L_0x0092:
            r1 = 5
            switch(r0) {
                case 0: goto L_0x01d7;
                case 1: goto L_0x01c0;
                case 2: goto L_0x01a2;
                case 3: goto L_0x01a2;
                case 4: goto L_0x018f;
                case 5: goto L_0x0173;
                case 6: goto L_0x014f;
                case 7: goto L_0x0132;
                case 8: goto L_0x0111;
                case 9: goto L_0x00e6;
                case 10: goto L_0x00d4;
                case 11: goto L_0x018f;
                case 12: goto L_0x00cc;
                case 13: goto L_0x014f;
                case 14: goto L_0x0173;
                case 15: goto L_0x00ba;
                case 16: goto L_0x009f;
                default: goto L_0x0096;
            }
        L_0x0096:
            r13 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            goto L_0x01f0
        L_0x009f:
            if (r3 != 0) goto L_0x00b5
            int r17 = com.google.android.gms.internal.gtm.zzsm.zzm(r12, r4, r11)
            long r0 = r11.zzb
            long r4 = com.google.android.gms.internal.gtm.zztj.zzt(r0)
            r0 = r10
            r1 = r31
            r13 = r20
            r2 = r8
            r20 = r33
            goto L_0x01b5
        L_0x00b5:
            r13 = r20
            r20 = r33
            goto L_0x010c
        L_0x00ba:
            r13 = r20
            r20 = r33
            if (r3 != 0) goto L_0x010c
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzj(r12, r4, r11)
            int r1 = r11.zza
            int r1 = com.google.android.gms.internal.gtm.zztj.zzs(r1)
            goto L_0x019e
        L_0x00cc:
            r13 = r20
            r20 = r33
            if (r3 != 0) goto L_0x010c
            goto L_0x0198
        L_0x00d4:
            r13 = r20
            r0 = 2
            r20 = r33
            if (r3 != r0) goto L_0x010c
            int r0 = com.google.android.gms.internal.gtm.zzsm.zza(r12, r4, r11)
            java.lang.Object r1 = r11.zzc
            r10.putObject(r14, r8, r1)
            goto L_0x01ed
        L_0x00e6:
            r13 = r20
            r0 = 2
            r20 = r33
            if (r3 != r0) goto L_0x010a
            com.google.android.gms.internal.gtm.zzwx r0 = r15.zzF(r13)
            r2 = r34
            r19 = 1048575(0xfffff, float:1.469367E-39)
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzd(r0, r12, r4, r2, r11)
            java.lang.Object r1 = r10.getObject(r14, r8)
            if (r1 != 0) goto L_0x0103
            java.lang.Object r1 = r11.zzc
            goto L_0x012e
        L_0x0103:
            java.lang.Object r3 = r11.zzc
            java.lang.Object r1 = com.google.android.gms.internal.gtm.zzvi.zzg(r1, r3)
            goto L_0x012e
        L_0x010a:
            r2 = r34
        L_0x010c:
            r19 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x01f0
        L_0x0111:
            r2 = r34
            r13 = r20
            r0 = 2
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            if (r3 != r0) goto L_0x01f0
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r23 & r0
            if (r0 != 0) goto L_0x0128
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzg(r12, r4, r11)
            goto L_0x012c
        L_0x0128:
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzh(r12, r4, r11)
        L_0x012c:
            java.lang.Object r1 = r11.zzc
        L_0x012e:
            r10.putObject(r14, r8, r1)
            goto L_0x0163
        L_0x0132:
            r2 = r34
            r13 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            if (r3 != 0) goto L_0x01f0
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzm(r12, r4, r11)
            long r3 = r11.zzb
            r22 = 0
            int r1 = (r3 > r22 ? 1 : (r3 == r22 ? 0 : -1))
            if (r1 == 0) goto L_0x014a
            goto L_0x014b
        L_0x014a:
            r5 = 0
        L_0x014b:
            com.google.android.gms.internal.gtm.zzxy.zzm(r14, r8, r5)
            goto L_0x0163
        L_0x014f:
            r2 = r34
            r13 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            if (r3 != r1) goto L_0x01f0
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzb(r12, r4)
            r10.putInt(r14, r8, r0)
            int r0 = r4 + 4
        L_0x0163:
            r6 = r6 | r21
            r9 = r10
            r1 = r20
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = -1
            r29 = r13
            r13 = r2
            r2 = r29
            goto L_0x001a
        L_0x0173:
            r2 = r34
            r13 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            if (r3 != r5) goto L_0x01f0
            long r22 = com.google.android.gms.internal.gtm.zzsm.zzo(r12, r4)
            r0 = r10
            r1 = r31
            r2 = r8
            r8 = r4
            r4 = r22
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            goto L_0x01ed
        L_0x018f:
            r13 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            if (r3 != 0) goto L_0x01f0
        L_0x0198:
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzj(r12, r4, r11)
            int r1 = r11.zza
        L_0x019e:
            r10.putInt(r14, r8, r1)
            goto L_0x01ed
        L_0x01a2:
            r13 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            if (r3 != 0) goto L_0x01f0
            int r17 = com.google.android.gms.internal.gtm.zzsm.zzm(r12, r4, r11)
            long r4 = r11.zzb
            r0 = r10
            r1 = r31
            r2 = r8
        L_0x01b5:
            r0.putLong(r1, r2, r4)
            r6 = r6 | r21
            r9 = r10
            r2 = r13
            r0 = r17
            goto L_0x023d
        L_0x01c0:
            r13 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            if (r3 != r1) goto L_0x01f0
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzb(r12, r4)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.gtm.zzxy.zzp(r14, r8, r0)
            int r0 = r4 + 4
            goto L_0x01ed
        L_0x01d7:
            r13 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            if (r3 != r5) goto L_0x01f0
            long r0 = com.google.android.gms.internal.gtm.zzsm.zzo(r12, r4)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.gtm.zzxy.zzo(r14, r8, r0)
            int r0 = r4 + 8
        L_0x01ed:
            r6 = r6 | r21
            goto L_0x023b
        L_0x01f0:
            r2 = r4
            r28 = r10
            r19 = r13
            r18 = -1
            goto L_0x02fb
        L_0x01f9:
            r20 = r33
            r23 = r1
            r13 = r2
            r10 = r19
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r1 = 27
            if (r0 != r1) goto L_0x0254
            r1 = 2
            if (r3 != r1) goto L_0x0247
            java.lang.Object r0 = r10.getObject(r14, r8)
            com.google.android.gms.internal.gtm.zzvh r0 = (com.google.android.gms.internal.gtm.zzvh) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x0227
            int r1 = r0.size()
            if (r1 != 0) goto L_0x021f
            r1 = 10
            goto L_0x0220
        L_0x021f:
            int r1 = r1 + r1
        L_0x0220:
            com.google.android.gms.internal.gtm.zzvh r0 = r0.zzd(r1)
            r10.putObject(r14, r8, r0)
        L_0x0227:
            r5 = r0
            com.google.android.gms.internal.gtm.zzwx r0 = r15.zzF(r13)
            r1 = r17
            r2 = r32
            r3 = r4
            r4 = r34
            r8 = r6
            r6 = r35
            int r0 = com.google.android.gms.internal.gtm.zzsm.zze(r0, r1, r2, r3, r4, r5, r6)
            r6 = r8
        L_0x023b:
            r9 = r10
            r2 = r13
        L_0x023d:
            r1 = r20
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = -1
            r13 = r34
            goto L_0x001a
        L_0x0247:
            r15 = r4
            r24 = r6
            r25 = r7
            r28 = r10
            r19 = r13
            r18 = -1
            goto L_0x02da
        L_0x0254:
            r1 = 49
            if (r0 > r1) goto L_0x02a6
            r1 = r23
            long r1 = (long) r1
            r5 = r0
            r0 = r30
            r21 = r1
            r1 = r31
            r2 = r32
            r33 = r3
            r3 = r4
            r15 = r4
            r4 = r34
            r23 = r5
            r5 = r17
            r24 = r6
            r6 = r20
            r25 = r7
            r7 = r33
            r26 = r8
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r13
            r28 = r10
            r18 = -1
            r9 = r21
            r11 = r23
            r19 = r13
            r12 = r26
            r14 = r35
            int r0 = r0.zzw(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x02a4
        L_0x0290:
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r2 = r19
            r1 = r20
            r6 = r24
            r7 = r25
            goto L_0x0319
        L_0x02a4:
            r2 = r0
            goto L_0x02db
        L_0x02a6:
            r33 = r3
            r15 = r4
            r24 = r6
            r25 = r7
            r26 = r8
            r28 = r10
            r19 = r13
            r1 = r23
            r18 = -1
            r23 = r0
            r0 = 50
            r9 = r23
            r7 = r33
            if (r9 != r0) goto L_0x02e0
            r0 = 2
            if (r7 != r0) goto L_0x02da
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r19
            r6 = r26
            r8 = r35
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x02a4
            goto L_0x0290
        L_0x02da:
            r2 = r15
        L_0x02db:
            r6 = r24
            r7 = r25
            goto L_0x02fb
        L_0x02e0:
            r0 = r30
            r8 = r1
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r17
            r6 = r20
            r10 = r26
            r12 = r19
            r13 = r35
            int r0 = r0.zzu(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x02a4
            goto L_0x0290
        L_0x02fb:
            com.google.android.gms.internal.gtm.zzxp r4 = zzd(r31)
            r0 = r17
            r1 = r32
            r3 = r34
            r5 = r35
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzi(r0, r1, r2, r3, r4, r5)
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r2 = r19
            r1 = r20
        L_0x0319:
            r9 = r28
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = -1
            goto L_0x001a
        L_0x0321:
            r24 = r6
            r28 = r9
            r1 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 == r1) goto L_0x0334
            long r1 = (long) r7
            r3 = r31
            r6 = r24
            r4 = r28
            r4.putInt(r3, r1, r6)
        L_0x0334:
            r1 = r34
            if (r0 != r1) goto L_0x0339
            return r0
        L_0x0339:
            com.google.android.gms.internal.gtm.zzvk r0 = com.google.android.gms.internal.gtm.zzvk.zzg()
            goto L_0x033f
        L_0x033e:
            throw r0
        L_0x033f:
            goto L_0x033e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzwn.zzv(java.lang.Object, byte[], int, int, com.google.android.gms.internal.gtm.zzsl):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0254, code lost:
        if (r7.zzb != 0) goto L_0x0256;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0256, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0258, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0259, code lost:
        r12.zze(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x025c, code lost:
        if (r4 >= r5) goto L_0x0272;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x025e, code lost:
        r6 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0264, code lost:
        if (r2 == r7.zza) goto L_0x0267;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0267, code lost:
        r4 = com.google.android.gms.internal.gtm.zzsm.zzm(r3, r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x026f, code lost:
        if (r7.zzb == 0) goto L_0x0258;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0272, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:?, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0122, code lost:
        if (r4 == 0) goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0124, code lost:
        r12.add(com.google.android.gms.internal.gtm.zztd.zzb);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x012a, code lost:
        r12.add(com.google.android.gms.internal.gtm.zztd.zzn(r3, r1, r4));
        r1 = r1 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0132, code lost:
        if (r1 >= r5) goto L_0x0156;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0134, code lost:
        r4 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r1, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x013a, code lost:
        if (r2 == r7.zza) goto L_0x013d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x013d, code lost:
        r1 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7);
        r4 = r7.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0143, code lost:
        if (r4 < 0) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0147, code lost:
        if (r4 > (r3.length - r1)) goto L_0x014c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0149, code lost:
        if (r4 != 0) goto L_0x012a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0150, code lost:
        throw com.google.android.gms.internal.gtm.zzvk.zzj();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0155, code lost:
        throw com.google.android.gms.internal.gtm.zzvk.zzf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0156, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01a4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzw(T r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.gtm.zzsl r29) throws java.io.IOException {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r2 = r20
            r6 = r22
            r8 = r23
            r9 = r27
            r7 = r29
            sun.misc.Unsafe r11 = zzb
            java.lang.Object r12 = r11.getObject(r1, r9)
            com.google.android.gms.internal.gtm.zzvh r12 = (com.google.android.gms.internal.gtm.zzvh) r12
            boolean r13 = r12.zzc()
            if (r13 != 0) goto L_0x0032
            int r13 = r12.size()
            if (r13 != 0) goto L_0x002a
            r13 = 10
            goto L_0x002b
        L_0x002a:
            int r13 = r13 + r13
        L_0x002b:
            com.google.android.gms.internal.gtm.zzvh r12 = r12.zzd(r13)
            r11.putObject(r1, r9, r12)
        L_0x0032:
            r9 = 5
            r10 = 0
            r13 = 1
            r14 = 2
            switch(r26) {
                case 18: goto L_0x0388;
                case 19: goto L_0x0342;
                case 20: goto L_0x030a;
                case 21: goto L_0x030a;
                case 22: goto L_0x02ef;
                case 23: goto L_0x02b1;
                case 24: goto L_0x0273;
                case 25: goto L_0x021f;
                case 26: goto L_0x017c;
                case 27: goto L_0x0161;
                case 28: goto L_0x0114;
                case 29: goto L_0x02ef;
                case 30: goto L_0x00dc;
                case 31: goto L_0x0273;
                case 32: goto L_0x02b1;
                case 33: goto L_0x009c;
                case 34: goto L_0x005c;
                case 35: goto L_0x0388;
                case 36: goto L_0x0342;
                case 37: goto L_0x030a;
                case 38: goto L_0x030a;
                case 39: goto L_0x02ef;
                case 40: goto L_0x02b1;
                case 41: goto L_0x0273;
                case 42: goto L_0x021f;
                case 43: goto L_0x02ef;
                case 44: goto L_0x00dc;
                case 45: goto L_0x0273;
                case 46: goto L_0x02b1;
                case 47: goto L_0x009c;
                case 48: goto L_0x005c;
                default: goto L_0x003a;
            }
        L_0x003a:
            r1 = 3
            if (r6 != r1) goto L_0x03eb
            com.google.android.gms.internal.gtm.zzwx r1 = r15.zzF(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r21 = r1
            r22 = r17
            r23 = r18
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.gtm.zzsm.zzc(r21, r22, r23, r24, r25, r26)
        L_0x0055:
            java.lang.Object r8 = r7.zzc
            r12.add(r8)
            goto L_0x03cd
        L_0x005c:
            if (r6 != r14) goto L_0x0080
            com.google.android.gms.internal.gtm.zzvz r12 = (com.google.android.gms.internal.gtm.zzvz) r12
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0067:
            if (r1 >= r2) goto L_0x0077
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzm(r3, r1, r7)
            long r4 = r7.zzb
            long r4 = com.google.android.gms.internal.gtm.zztj.zzt(r4)
            r12.zzf(r4)
            goto L_0x0067
        L_0x0077:
            if (r1 != r2) goto L_0x007b
            goto L_0x03ec
        L_0x007b:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzj()
            throw r1
        L_0x0080:
            if (r6 != 0) goto L_0x03eb
            com.google.android.gms.internal.gtm.zzvz r12 = (com.google.android.gms.internal.gtm.zzvz) r12
        L_0x0084:
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.gtm.zztj.zzt(r8)
            r12.zzf(r8)
            if (r1 >= r5) goto L_0x009b
            int r4 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0084
        L_0x009b:
            return r1
        L_0x009c:
            if (r6 != r14) goto L_0x00c0
            com.google.android.gms.internal.gtm.zzva r12 = (com.google.android.gms.internal.gtm.zzva) r12
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x00a7:
            if (r1 >= r2) goto L_0x00b7
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r1, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.gtm.zztj.zzs(r4)
            r12.zzh(r4)
            goto L_0x00a7
        L_0x00b7:
            if (r1 != r2) goto L_0x00bb
            goto L_0x03ec
        L_0x00bb:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzj()
            throw r1
        L_0x00c0:
            if (r6 != 0) goto L_0x03eb
            com.google.android.gms.internal.gtm.zzva r12 = (com.google.android.gms.internal.gtm.zzva) r12
        L_0x00c4:
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.gtm.zztj.zzs(r4)
            r12.zzh(r4)
            if (r1 >= r5) goto L_0x00db
            int r4 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x00c4
        L_0x00db:
            return r1
        L_0x00dc:
            if (r6 != r14) goto L_0x00e3
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzf(r3, r4, r12, r7)
            goto L_0x00f4
        L_0x00e3:
            if (r6 != 0) goto L_0x03eb
            r2 = r20
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r12
            r7 = r29
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzl(r2, r3, r4, r5, r6, r7)
        L_0x00f4:
            com.google.android.gms.internal.gtm.zzuz r1 = (com.google.android.gms.internal.gtm.zzuz) r1
            com.google.android.gms.internal.gtm.zzxp r3 = r1.zzc
            com.google.android.gms.internal.gtm.zzxp r4 = com.google.android.gms.internal.gtm.zzxp.zzc()
            if (r3 != r4) goto L_0x00ff
            r3 = 0
        L_0x00ff:
            com.google.android.gms.internal.gtm.zzvd r4 = r15.zzE(r8)
            com.google.android.gms.internal.gtm.zzxo<?, ?> r5 = r0.zzo
            r6 = r21
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zzwz.zzC(r6, r12, r4, r3, r5)
            if (r3 != 0) goto L_0x010f
            goto L_0x0240
        L_0x010f:
            com.google.android.gms.internal.gtm.zzxp r3 = (com.google.android.gms.internal.gtm.zzxp) r3
            r1.zzc = r3
            return r2
        L_0x0114:
            if (r6 != r14) goto L_0x03eb
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x015c
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0157
            if (r4 != 0) goto L_0x012a
        L_0x0124:
            com.google.android.gms.internal.gtm.zztd r4 = com.google.android.gms.internal.gtm.zztd.zzb
            r12.add(r4)
            goto L_0x0132
        L_0x012a:
            com.google.android.gms.internal.gtm.zztd r6 = com.google.android.gms.internal.gtm.zztd.zzn(r3, r1, r4)
            r12.add(r6)
            int r1 = r1 + r4
        L_0x0132:
            if (r1 >= r5) goto L_0x0156
            int r4 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x013d
            goto L_0x0156
        L_0x013d:
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0151
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x014c
            if (r4 != 0) goto L_0x012a
            goto L_0x0124
        L_0x014c:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzj()
            throw r1
        L_0x0151:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzf()
            throw r1
        L_0x0156:
            return r1
        L_0x0157:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzj()
            throw r1
        L_0x015c:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzf()
            throw r1
        L_0x0161:
            if (r6 == r14) goto L_0x0165
            goto L_0x03eb
        L_0x0165:
            com.google.android.gms.internal.gtm.zzwx r1 = r15.zzF(r8)
            r21 = r1
            r22 = r20
            r23 = r17
            r24 = r18
            r25 = r19
            r26 = r12
            r27 = r29
            int r1 = com.google.android.gms.internal.gtm.zzsm.zze(r21, r22, r23, r24, r25, r26, r27)
            return r1
        L_0x017c:
            if (r6 != r14) goto L_0x03eb
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r24 & r8
            java.lang.String r1 = ""
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            int r4 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7)
            if (r6 != 0) goto L_0x01c9
            int r6 = r7.zza
            if (r6 < 0) goto L_0x01c4
            if (r6 != 0) goto L_0x0197
        L_0x0193:
            r12.add(r1)
            goto L_0x01a2
        L_0x0197:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.gtm.zzvi.zza
            r8.<init>(r3, r4, r6, r9)
        L_0x019e:
            r12.add(r8)
            int r4 = r4 + r6
        L_0x01a2:
            if (r4 >= r5) goto L_0x03eb
            int r6 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x03eb
            int r4 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r6, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x01bf
            if (r6 != 0) goto L_0x01b7
            goto L_0x0193
        L_0x01b7:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.gtm.zzvi.zza
            r8.<init>(r3, r4, r6, r9)
            goto L_0x019e
        L_0x01bf:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzf()
            throw r1
        L_0x01c4:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzf()
            throw r1
        L_0x01c9:
            int r6 = r7.zza
            if (r6 < 0) goto L_0x021a
            if (r6 != 0) goto L_0x01d3
        L_0x01cf:
            r12.add(r1)
            goto L_0x01e6
        L_0x01d3:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.gtm.zzyd.zzf(r3, r4, r8)
            if (r9 == 0) goto L_0x0215
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.gtm.zzvi.zza
            r9.<init>(r3, r4, r6, r10)
        L_0x01e2:
            r12.add(r9)
            r4 = r8
        L_0x01e6:
            if (r4 >= r5) goto L_0x03eb
            int r6 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x03eb
            int r4 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r6, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x0210
            if (r6 != 0) goto L_0x01fb
            goto L_0x01cf
        L_0x01fb:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.gtm.zzyd.zzf(r3, r4, r8)
            if (r9 == 0) goto L_0x020b
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.gtm.zzvi.zza
            r9.<init>(r3, r4, r6, r10)
            goto L_0x01e2
        L_0x020b:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzd()
            throw r1
        L_0x0210:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzf()
            throw r1
        L_0x0215:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzd()
            throw r1
        L_0x021a:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzf()
            throw r1
        L_0x021f:
            r1 = 0
            if (r6 != r14) goto L_0x0248
            com.google.android.gms.internal.gtm.zzsr r12 = (com.google.android.gms.internal.gtm.zzsr) r12
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = r4 + r2
        L_0x022b:
            if (r2 >= r4) goto L_0x023e
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzm(r3, r2, r7)
            long r5 = r7.zzb
            int r8 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x0239
            r5 = 1
            goto L_0x023a
        L_0x0239:
            r5 = 0
        L_0x023a:
            r12.zze(r5)
            goto L_0x022b
        L_0x023e:
            if (r2 != r4) goto L_0x0243
        L_0x0240:
            r1 = r2
            goto L_0x03ec
        L_0x0243:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzj()
            throw r1
        L_0x0248:
            if (r6 != 0) goto L_0x03eb
            com.google.android.gms.internal.gtm.zzsr r12 = (com.google.android.gms.internal.gtm.zzsr) r12
            int r4 = com.google.android.gms.internal.gtm.zzsm.zzm(r3, r4, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x0258
        L_0x0256:
            r6 = 1
            goto L_0x0259
        L_0x0258:
            r6 = 0
        L_0x0259:
            r12.zze(r6)
            if (r4 >= r5) goto L_0x0272
            int r6 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7)
            int r8 = r7.zza
            if (r2 == r8) goto L_0x0267
            goto L_0x0272
        L_0x0267:
            int r4 = com.google.android.gms.internal.gtm.zzsm.zzm(r3, r6, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x0258
            goto L_0x0256
        L_0x0272:
            return r4
        L_0x0273:
            if (r6 != r14) goto L_0x0293
            com.google.android.gms.internal.gtm.zzva r12 = (com.google.android.gms.internal.gtm.zzva) r12
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x027e:
            if (r1 >= r2) goto L_0x028a
            int r4 = com.google.android.gms.internal.gtm.zzsm.zzb(r3, r1)
            r12.zzh(r4)
            int r1 = r1 + 4
            goto L_0x027e
        L_0x028a:
            if (r1 != r2) goto L_0x028e
            goto L_0x03ec
        L_0x028e:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzj()
            throw r1
        L_0x0293:
            if (r6 != r9) goto L_0x03eb
            com.google.android.gms.internal.gtm.zzva r12 = (com.google.android.gms.internal.gtm.zzva) r12
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzb(r17, r18)
        L_0x029b:
            r12.zzh(r1)
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x02b0
            int r4 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x02ab
            goto L_0x02b0
        L_0x02ab:
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzb(r3, r4)
            goto L_0x029b
        L_0x02b0:
            return r1
        L_0x02b1:
            if (r6 != r14) goto L_0x02d1
            com.google.android.gms.internal.gtm.zzvz r12 = (com.google.android.gms.internal.gtm.zzvz) r12
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x02bc:
            if (r1 >= r2) goto L_0x02c8
            long r4 = com.google.android.gms.internal.gtm.zzsm.zzo(r3, r1)
            r12.zzf(r4)
            int r1 = r1 + 8
            goto L_0x02bc
        L_0x02c8:
            if (r1 != r2) goto L_0x02cc
            goto L_0x03ec
        L_0x02cc:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzj()
            throw r1
        L_0x02d1:
            if (r6 != r13) goto L_0x03eb
            com.google.android.gms.internal.gtm.zzvz r12 = (com.google.android.gms.internal.gtm.zzvz) r12
            long r8 = com.google.android.gms.internal.gtm.zzsm.zzo(r17, r18)
        L_0x02d9:
            r12.zzf(r8)
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x02ee
            int r4 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x02e9
            goto L_0x02ee
        L_0x02e9:
            long r8 = com.google.android.gms.internal.gtm.zzsm.zzo(r3, r4)
            goto L_0x02d9
        L_0x02ee:
            return r1
        L_0x02ef:
            if (r6 != r14) goto L_0x02f7
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzf(r3, r4, r12, r7)
            goto L_0x03ec
        L_0x02f7:
            if (r6 == 0) goto L_0x02fb
            goto L_0x03eb
        L_0x02fb:
            r21 = r17
            r22 = r18
            r23 = r19
            r24 = r12
            r25 = r29
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzl(r20, r21, r22, r23, r24, r25)
            return r1
        L_0x030a:
            if (r6 != r14) goto L_0x032a
            com.google.android.gms.internal.gtm.zzvz r12 = (com.google.android.gms.internal.gtm.zzvz) r12
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0315:
            if (r1 >= r2) goto L_0x0321
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzm(r3, r1, r7)
            long r4 = r7.zzb
            r12.zzf(r4)
            goto L_0x0315
        L_0x0321:
            if (r1 != r2) goto L_0x0325
            goto L_0x03ec
        L_0x0325:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzj()
            throw r1
        L_0x032a:
            if (r6 != 0) goto L_0x03eb
            com.google.android.gms.internal.gtm.zzvz r12 = (com.google.android.gms.internal.gtm.zzvz) r12
        L_0x032e:
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r12.zzf(r8)
            if (r1 >= r5) goto L_0x0341
            int r4 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x032e
        L_0x0341:
            return r1
        L_0x0342:
            if (r6 != r14) goto L_0x0366
            com.google.android.gms.internal.gtm.zzuq r12 = (com.google.android.gms.internal.gtm.zzuq) r12
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x034d:
            if (r1 >= r2) goto L_0x035d
            int r4 = com.google.android.gms.internal.gtm.zzsm.zzb(r3, r1)
            float r4 = java.lang.Float.intBitsToFloat(r4)
            r12.zze(r4)
            int r1 = r1 + 4
            goto L_0x034d
        L_0x035d:
            if (r1 != r2) goto L_0x0361
            goto L_0x03ec
        L_0x0361:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzj()
            throw r1
        L_0x0366:
            if (r6 != r9) goto L_0x03eb
            com.google.android.gms.internal.gtm.zzuq r12 = (com.google.android.gms.internal.gtm.zzuq) r12
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzb(r17, r18)
        L_0x036e:
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r12.zze(r1)
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0387
            int r4 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0382
            goto L_0x0387
        L_0x0382:
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzb(r3, r4)
            goto L_0x036e
        L_0x0387:
            return r1
        L_0x0388:
            if (r6 != r14) goto L_0x03ab
            com.google.android.gms.internal.gtm.zzug r12 = (com.google.android.gms.internal.gtm.zzug) r12
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0393:
            if (r1 >= r2) goto L_0x03a3
            long r4 = com.google.android.gms.internal.gtm.zzsm.zzo(r3, r1)
            double r4 = java.lang.Double.longBitsToDouble(r4)
            r12.zze(r4)
            int r1 = r1 + 8
            goto L_0x0393
        L_0x03a3:
            if (r1 != r2) goto L_0x03a6
            goto L_0x03ec
        L_0x03a6:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzj()
            throw r1
        L_0x03ab:
            if (r6 != r13) goto L_0x03eb
            com.google.android.gms.internal.gtm.zzug r12 = (com.google.android.gms.internal.gtm.zzug) r12
            long r8 = com.google.android.gms.internal.gtm.zzsm.zzo(r17, r18)
        L_0x03b3:
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r12.zze(r8)
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x03cc
            int r4 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x03c7
            goto L_0x03cc
        L_0x03c7:
            long r8 = com.google.android.gms.internal.gtm.zzsm.zzo(r3, r4)
            goto L_0x03b3
        L_0x03cc:
            return r1
        L_0x03cd:
            if (r4 >= r5) goto L_0x03ea
            int r8 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7)
            int r9 = r7.zza
            if (r2 == r9) goto L_0x03d8
            goto L_0x03ea
        L_0x03d8:
            r21 = r1
            r22 = r17
            r23 = r8
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.gtm.zzsm.zzc(r21, r22, r23, r24, r25, r26)
            goto L_0x0055
        L_0x03ea:
            return r4
        L_0x03eb:
            r1 = r4
        L_0x03ec:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzwn.zzw(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.gtm.zzsl):int");
    }

    private final int zzx(int i2) {
        if (i2 < this.zze || i2 > this.zzf) {
            return -1;
        }
        return zzA(i2, 0);
    }

    private final int zzy(int i2, int i3) {
        if (i2 < this.zze || i2 > this.zzf) {
            return -1;
        }
        return zzA(i2, i3);
    }

    private final int zzz(int i2) {
        return this.zzc[i2 + 2];
    }

    public final int zza(T t2) {
        return this.zzj ? zzr(t2) : zzq(t2);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008d, code lost:
        r2 = r2 * 53;
        r3 = zzs(r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a2, code lost:
        r2 = r2 * 53;
        r3 = zzD(r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c8, code lost:
        if (r3 != null) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00cb, code lost:
        r2 = r2 * 53;
        r3 = com.google.android.gms.internal.gtm.zzxy.zzf(r9, r5).hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00da, code lost:
        if (r3 != null) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00dc, code lost:
        r7 = r3.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e0, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e4, code lost:
        r2 = r2 * 53;
        r3 = ((java.lang.String) com.google.android.gms.internal.gtm.zzxy.zzf(r9, r5)).hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f7, code lost:
        r3 = com.google.android.gms.internal.gtm.zzvi.zza(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0110, code lost:
        r3 = java.lang.Float.floatToIntBits(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x011b, code lost:
        r3 = java.lang.Double.doubleToLongBits(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x011f, code lost:
        r3 = com.google.android.gms.internal.gtm.zzvi.zzc(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0123, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0124, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.zzc
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x0128
            int r3 = r8.zzC(r1)
            int[] r4 = r8.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            int r3 = zzB(r3)
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0115;
                case 1: goto L_0x010a;
                case 2: goto L_0x0103;
                case 3: goto L_0x0103;
                case 4: goto L_0x00fc;
                case 5: goto L_0x0103;
                case 6: goto L_0x00fc;
                case 7: goto L_0x00f1;
                case 8: goto L_0x00e4;
                case 9: goto L_0x00d6;
                case 10: goto L_0x00cb;
                case 11: goto L_0x00fc;
                case 12: goto L_0x00fc;
                case 13: goto L_0x00fc;
                case 14: goto L_0x0103;
                case 15: goto L_0x00fc;
                case 16: goto L_0x0103;
                case 17: goto L_0x00c4;
                case 18: goto L_0x00cb;
                case 19: goto L_0x00cb;
                case 20: goto L_0x00cb;
                case 21: goto L_0x00cb;
                case 22: goto L_0x00cb;
                case 23: goto L_0x00cb;
                case 24: goto L_0x00cb;
                case 25: goto L_0x00cb;
                case 26: goto L_0x00cb;
                case 27: goto L_0x00cb;
                case 28: goto L_0x00cb;
                case 29: goto L_0x00cb;
                case 30: goto L_0x00cb;
                case 31: goto L_0x00cb;
                case 32: goto L_0x00cb;
                case 33: goto L_0x00cb;
                case 34: goto L_0x00cb;
                case 35: goto L_0x00cb;
                case 36: goto L_0x00cb;
                case 37: goto L_0x00cb;
                case 38: goto L_0x00cb;
                case 39: goto L_0x00cb;
                case 40: goto L_0x00cb;
                case 41: goto L_0x00cb;
                case 42: goto L_0x00cb;
                case 43: goto L_0x00cb;
                case 44: goto L_0x00cb;
                case 45: goto L_0x00cb;
                case 46: goto L_0x00cb;
                case 47: goto L_0x00cb;
                case 48: goto L_0x00cb;
                case 49: goto L_0x00cb;
                case 50: goto L_0x00cb;
                case 51: goto L_0x00b7;
                case 52: goto L_0x00aa;
                case 53: goto L_0x009c;
                case 54: goto L_0x0095;
                case 55: goto L_0x0087;
                case 56: goto L_0x0080;
                case 57: goto L_0x0079;
                case 58: goto L_0x006b;
                case 59: goto L_0x0063;
                case 60: goto L_0x005b;
                case 61: goto L_0x0053;
                case 62: goto L_0x004c;
                case 63: goto L_0x0045;
                case 64: goto L_0x003e;
                case 65: goto L_0x0036;
                case 66: goto L_0x002f;
                case 67: goto L_0x0027;
                case 68: goto L_0x001f;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x0124
        L_0x001f:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
            goto L_0x00cb
        L_0x0027:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
            goto L_0x00a2
        L_0x002f:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
            goto L_0x004b
        L_0x0036:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
            goto L_0x00a2
        L_0x003e:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
            goto L_0x004b
        L_0x0045:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
        L_0x004b:
            goto L_0x008d
        L_0x004c:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
            goto L_0x008d
        L_0x0053:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
            goto L_0x00cb
        L_0x005b:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
            goto L_0x00cb
        L_0x0063:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
            goto L_0x00e4
        L_0x006b:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
            int r2 = r2 * 53
            boolean r3 = zzU(r9, r5)
            goto L_0x00f7
        L_0x0079:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
            goto L_0x008d
        L_0x0080:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
            goto L_0x00a2
        L_0x0087:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
        L_0x008d:
            int r2 = r2 * 53
            int r3 = zzs(r9, r5)
            goto L_0x0123
        L_0x0095:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
            goto L_0x00a2
        L_0x009c:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
        L_0x00a2:
            int r2 = r2 * 53
            long r3 = zzD(r9, r5)
            goto L_0x011f
        L_0x00aa:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
            int r2 = r2 * 53
            float r3 = zzp(r9, r5)
            goto L_0x0110
        L_0x00b7:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
            int r2 = r2 * 53
            double r3 = zzo(r9, r5)
            goto L_0x011b
        L_0x00c4:
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zzxy.zzf(r9, r5)
            if (r3 == 0) goto L_0x00e0
            goto L_0x00dc
        L_0x00cb:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zzxy.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0123
        L_0x00d6:
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zzxy.zzf(r9, r5)
            if (r3 == 0) goto L_0x00e0
        L_0x00dc:
            int r7 = r3.hashCode()
        L_0x00e0:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0124
        L_0x00e4:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zzxy.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0123
        L_0x00f1:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.gtm.zzxy.zzw(r9, r5)
        L_0x00f7:
            int r3 = com.google.android.gms.internal.gtm.zzvi.zza(r3)
            goto L_0x0123
        L_0x00fc:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.gtm.zzxy.zzc(r9, r5)
            goto L_0x0123
        L_0x0103:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.gtm.zzxy.zzd(r9, r5)
            goto L_0x011f
        L_0x010a:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.gtm.zzxy.zzb(r9, r5)
        L_0x0110:
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0123
        L_0x0115:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.gtm.zzxy.zza(r9, r5)
        L_0x011b:
            long r3 = java.lang.Double.doubleToLongBits(r3)
        L_0x011f:
            int r3 = com.google.android.gms.internal.gtm.zzvi.zzc(r3)
        L_0x0123:
            int r2 = r2 + r3
        L_0x0124:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x0128:
            int r2 = r2 * 53
            com.google.android.gms.internal.gtm.zzxo<?, ?> r0 = r8.zzo
            java.lang.Object r0 = r0.zzd(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.zzh
            if (r0 == 0) goto L_0x0148
            int r2 = r2 * 53
            com.google.android.gms.internal.gtm.zzuk<?> r0 = r8.zzp
            com.google.android.gms.internal.gtm.zzuo r9 = r0.zzb(r9)
            com.google.android.gms.internal.gtm.zzxk<T, java.lang.Object> r9 = r9.zza
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x0148:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzwn.zzb(java.lang.Object):int");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0316, code lost:
        if (r0 != r15) goto L_0x0318;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0332, code lost:
        r2 = r0;
        r6 = r23;
        r7 = r25;
        r0 = r36;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0368, code lost:
        if (r0 != r15) goto L_0x0318;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x038b, code lost:
        if (r0 != r15) goto L_0x0318;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x04a0, code lost:
        r4 = r10.zzc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0502, code lost:
        r2 = r2 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0515, code lost:
        r2 = r2 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00f9, code lost:
        r10.putInt(r14, r3, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0135, code lost:
        r1 = r9.zzc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0137, code lost:
        r10.putObject(r14, r3, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01a6, code lost:
        r5 = r6 | r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01aa, code lost:
        r17 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0220, code lost:
        r17 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x023a, code lost:
        r0 = r13 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x023c, code lost:
        r5 = r6 | r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x023e, code lost:
        r13 = r35;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0240, code lost:
        r6 = r7;
        r3 = r8;
        r1 = r11;
        r2 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0245, code lost:
        r11 = r36;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0249, code lost:
        r17 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x025e, code lost:
        r0 = r36;
        r22 = r6;
        r6 = r7;
        r21 = r8;
        r29 = r10;
        r7 = r11;
        r2 = r17;
        r34 = r26;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzc(T r32, byte[] r33, int r34, int r35, int r36, com.google.android.gms.internal.gtm.zzsl r37) throws java.io.IOException {
        /*
            r31 = this;
            r15 = r31
            r14 = r32
            r12 = r33
            r13 = r35
            r11 = r36
            r9 = r37
            sun.misc.Unsafe r10 = zzb
            r16 = 0
            r0 = r34
            r1 = 0
            r2 = -1
            r3 = 0
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0019:
            if (r0 >= r13) goto L_0x0572
            int r1 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0028
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzk(r0, r12, r1, r9)
            int r1 = r9.zza
            goto L_0x002d
        L_0x0028:
            r30 = r1
            r1 = r0
            r0 = r30
        L_0x002d:
            int r7 = r1 >>> 3
            r8 = r1 & 7
            r4 = 3
            if (r7 <= r2) goto L_0x003a
            int r3 = r3 / r4
            int r2 = r15.zzy(r7, r3)
            goto L_0x003e
        L_0x003a:
            int r2 = r15.zzx(r7)
        L_0x003e:
            r19 = 0
            r4 = -1
            if (r2 != r4) goto L_0x0054
            r2 = r0
            r22 = r5
            r34 = r7
            r29 = r10
            r0 = r11
            r18 = 1
            r21 = 0
            r26 = -1
            r7 = r1
            goto L_0x038e
        L_0x0054:
            int[] r3 = r15.zzc
            int r23 = r2 + 1
            r3 = r3[r23]
            int r11 = zzB(r3)
            r17 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r3 & r17
            r24 = r3
            long r3 = (long) r4
            r25 = r1
            r1 = 17
            r26 = r7
            if (r11 > r1) goto L_0x0272
            int[] r1 = r15.zzc
            int r27 = r2 + 2
            r1 = r1[r27]
            int r27 = r1 >>> 20
            r22 = 1
            int r27 = r22 << r27
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r1 & r7
            r17 = r8
            if (r1 == r6) goto L_0x008f
            if (r6 == r7) goto L_0x0088
            long r7 = (long) r6
            r10.putInt(r14, r7, r5)
        L_0x0088:
            long r5 = (long) r1
            int r5 = r10.getInt(r14, r5)
            r7 = r1
            goto L_0x0090
        L_0x008f:
            r7 = r6
        L_0x0090:
            r6 = r5
            r1 = 5
            switch(r11) {
                case 0: goto L_0x0224;
                case 1: goto L_0x0208;
                case 2: goto L_0x01e2;
                case 3: goto L_0x01e2;
                case 4: goto L_0x01cd;
                case 5: goto L_0x01ae;
                case 6: goto L_0x0194;
                case 7: goto L_0x017a;
                case 8: goto L_0x0160;
                case 9: goto L_0x013c;
                case 10: goto L_0x0127;
                case 11: goto L_0x01cd;
                case 12: goto L_0x00fe;
                case 13: goto L_0x0194;
                case 14: goto L_0x01ae;
                case 15: goto L_0x00e8;
                case 16: goto L_0x00be;
                default: goto L_0x0095;
            }
        L_0x0095:
            r13 = r0
            r8 = r2
            r2 = r17
            r11 = r25
            r0 = 3
            r1 = 1
            r21 = -1
            if (r2 != r0) goto L_0x0249
            com.google.android.gms.internal.gtm.zzwx r0 = r15.zzF(r8)
            int r1 = r26 << 3
            r5 = r1 | 4
            r1 = r33
            r2 = r13
            r12 = r3
            r3 = r35
            r4 = r5
            r5 = r37
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzc(r0, r1, r2, r3, r4, r5)
            r1 = r6 & r27
            if (r1 != 0) goto L_0x024c
            java.lang.Object r1 = r9.zzc
            goto L_0x0256
        L_0x00be:
            if (r17 != 0) goto L_0x00e1
            int r8 = com.google.android.gms.internal.gtm.zzsm.zzm(r12, r0, r9)
            long r0 = r9.zzb
            long r17 = com.google.android.gms.internal.gtm.zztj.zzt(r0)
            r0 = r10
            r11 = r25
            r1 = r32
            r5 = r2
            r2 = r3
            r34 = r8
            r21 = -1
            r8 = r5
            r4 = r17
            r0.putLong(r1, r2, r4)
            r5 = r6 | r27
            r0 = r34
            goto L_0x0240
        L_0x00e1:
            r8 = r2
            r11 = r25
            r21 = -1
            goto L_0x01aa
        L_0x00e8:
            r8 = r2
            r11 = r25
            r21 = -1
            if (r17 != 0) goto L_0x01aa
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzj(r12, r0, r9)
            int r1 = r9.zza
            int r1 = com.google.android.gms.internal.gtm.zztj.zzs(r1)
        L_0x00f9:
            r10.putInt(r14, r3, r1)
            goto L_0x01a6
        L_0x00fe:
            r8 = r2
            r11 = r25
            r21 = -1
            if (r17 != 0) goto L_0x01aa
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzj(r12, r0, r9)
            int r1 = r9.zza
            com.google.android.gms.internal.gtm.zzvd r2 = r15.zzE(r8)
            if (r2 == 0) goto L_0x00f9
            boolean r2 = r2.zza(r1)
            if (r2 == 0) goto L_0x0118
            goto L_0x00f9
        L_0x0118:
            com.google.android.gms.internal.gtm.zzxp r2 = zzd(r32)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zzh(r11, r1)
            r5 = r6
            goto L_0x0240
        L_0x0127:
            r8 = r2
            r2 = r17
            r11 = r25
            r1 = 2
            r21 = -1
            if (r2 != r1) goto L_0x01aa
            int r0 = com.google.android.gms.internal.gtm.zzsm.zza(r12, r0, r9)
        L_0x0135:
            java.lang.Object r1 = r9.zzc
        L_0x0137:
            r10.putObject(r14, r3, r1)
            goto L_0x01a6
        L_0x013c:
            r8 = r2
            r2 = r17
            r11 = r25
            r1 = 2
            r21 = -1
            if (r2 != r1) goto L_0x01aa
            com.google.android.gms.internal.gtm.zzwx r1 = r15.zzF(r8)
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzd(r1, r12, r0, r13, r9)
            r1 = r6 & r27
            if (r1 != 0) goto L_0x0155
            java.lang.Object r1 = r9.zzc
            goto L_0x0137
        L_0x0155:
            java.lang.Object r1 = r10.getObject(r14, r3)
            java.lang.Object r2 = r9.zzc
            java.lang.Object r1 = com.google.android.gms.internal.gtm.zzvi.zzg(r1, r2)
            goto L_0x0137
        L_0x0160:
            r8 = r2
            r2 = r17
            r11 = r25
            r1 = 2
            r21 = -1
            if (r2 != r1) goto L_0x01aa
            r1 = 536870912(0x20000000, float:1.0842022E-19)
            r1 = r24 & r1
            if (r1 != 0) goto L_0x0175
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzg(r12, r0, r9)
            goto L_0x0135
        L_0x0175:
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzh(r12, r0, r9)
            goto L_0x0135
        L_0x017a:
            r8 = r2
            r2 = r17
            r11 = r25
            r21 = -1
            if (r2 != 0) goto L_0x01aa
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzm(r12, r0, r9)
            long r1 = r9.zzb
            int r5 = (r1 > r19 ? 1 : (r1 == r19 ? 0 : -1))
            if (r5 == 0) goto L_0x018f
            r1 = 1
            goto L_0x0190
        L_0x018f:
            r1 = 0
        L_0x0190:
            com.google.android.gms.internal.gtm.zzxy.zzm(r14, r3, r1)
            goto L_0x01a6
        L_0x0194:
            r8 = r2
            r2 = r17
            r11 = r25
            r21 = -1
            if (r2 != r1) goto L_0x01aa
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzb(r12, r0)
            r10.putInt(r14, r3, r1)
            int r0 = r0 + 4
        L_0x01a6:
            r5 = r6 | r27
            goto L_0x0240
        L_0x01aa:
            r17 = r0
            goto L_0x0222
        L_0x01ae:
            r8 = r2
            r2 = r17
            r11 = r25
            r1 = 1
            r21 = -1
            if (r2 != r1) goto L_0x01c9
            long r17 = com.google.android.gms.internal.gtm.zzsm.zzo(r12, r0)
            r5 = r0
            r0 = r10
            r1 = r32
            r2 = r3
            r13 = r5
            r4 = r17
            r0.putLong(r1, r2, r4)
            goto L_0x023a
        L_0x01c9:
            r17 = r0
            goto L_0x025e
        L_0x01cd:
            r13 = r0
            r8 = r2
            r2 = r17
            r11 = r25
            r21 = -1
            if (r2 != 0) goto L_0x0220
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzj(r12, r13, r9)
            int r1 = r9.zza
            r10.putInt(r14, r3, r1)
            goto L_0x023c
        L_0x01e2:
            r13 = r0
            r8 = r2
            r2 = r17
            r11 = r25
            r21 = -1
            if (r2 != 0) goto L_0x0220
            int r13 = com.google.android.gms.internal.gtm.zzsm.zzm(r12, r13, r9)
            long r1 = r9.zzb
            r0 = r10
            r17 = r1
            r1 = r32
            r2 = r3
            r4 = r17
            r0.putLong(r1, r2, r4)
            r5 = r6 | r27
            r6 = r7
            r3 = r8
            r1 = r11
            r0 = r13
            r2 = r26
            r13 = r35
            goto L_0x0245
        L_0x0208:
            r13 = r0
            r8 = r2
            r2 = r17
            r11 = r25
            r21 = -1
            if (r2 != r1) goto L_0x0220
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzb(r12, r13)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.gtm.zzxy.zzp(r14, r3, r0)
            int r0 = r13 + 4
            goto L_0x023c
        L_0x0220:
            r17 = r13
        L_0x0222:
            r1 = 1
            goto L_0x025e
        L_0x0224:
            r13 = r0
            r8 = r2
            r2 = r17
            r11 = r25
            r1 = 1
            r21 = -1
            if (r2 != r1) goto L_0x0249
            long r0 = com.google.android.gms.internal.gtm.zzsm.zzo(r12, r13)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.gtm.zzxy.zzo(r14, r3, r0)
        L_0x023a:
            int r0 = r13 + 8
        L_0x023c:
            r5 = r6 | r27
        L_0x023e:
            r13 = r35
        L_0x0240:
            r6 = r7
            r3 = r8
            r1 = r11
            r2 = r26
        L_0x0245:
            r11 = r36
            goto L_0x0019
        L_0x0249:
            r17 = r13
            goto L_0x025e
        L_0x024c:
            java.lang.Object r1 = r10.getObject(r14, r12)
            java.lang.Object r2 = r9.zzc
            java.lang.Object r1 = com.google.android.gms.internal.gtm.zzvi.zzg(r1, r2)
        L_0x0256:
            r10.putObject(r14, r12, r1)
            r5 = r6 | r27
            r12 = r33
            goto L_0x023e
        L_0x025e:
            r0 = r36
            r22 = r6
            r6 = r7
            r21 = r8
            r29 = r10
            r7 = r11
            r2 = r17
            r34 = r26
            r18 = 1
            r26 = -1
            goto L_0x038e
        L_0x0272:
            r17 = r0
            r12 = r3
            r7 = r25
            r1 = 1
            r21 = -1
            r30 = r8
            r8 = r2
            r2 = r30
            r0 = 27
            if (r11 != r0) goto L_0x02de
            r0 = 2
            if (r2 != r0) goto L_0x02ca
            java.lang.Object r0 = r10.getObject(r14, r12)
            com.google.android.gms.internal.gtm.zzvh r0 = (com.google.android.gms.internal.gtm.zzvh) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x02a4
            int r1 = r0.size()
            if (r1 != 0) goto L_0x029b
            r3 = 10
            goto L_0x029d
        L_0x029b:
            int r3 = r1 + r1
        L_0x029d:
            com.google.android.gms.internal.gtm.zzvh r0 = r0.zzd(r3)
            r10.putObject(r14, r12, r0)
        L_0x02a4:
            r11 = r0
            com.google.android.gms.internal.gtm.zzwx r0 = r15.zzF(r8)
            r1 = r7
            r2 = r33
            r3 = r17
            r4 = r35
            r22 = r5
            r5 = r11
            r23 = r6
            r6 = r37
            int r0 = com.google.android.gms.internal.gtm.zzsm.zze(r0, r1, r2, r3, r4, r5, r6)
            r12 = r33
            r13 = r35
            r11 = r36
            r3 = r8
            r5 = r22
            r6 = r23
            r2 = r26
            goto L_0x0019
        L_0x02ca:
            r22 = r5
            r23 = r6
            r25 = r7
            r21 = r8
            r29 = r10
            r15 = r17
            r34 = r26
            r18 = 1
            r26 = -1
            goto L_0x036b
        L_0x02de:
            r22 = r5
            r23 = r6
            r0 = 49
            if (r11 > r0) goto L_0x033b
            r3 = r24
            long r5 = (long) r3
            r0 = r31
            r4 = 1
            r1 = r32
            r3 = r2
            r2 = r33
            r24 = r3
            r3 = r17
            r18 = 1
            r4 = r35
            r27 = r5
            r5 = r7
            r6 = r26
            r25 = r7
            r34 = r26
            r7 = r24
            r21 = r8
            r26 = -1
            r29 = r10
            r9 = r27
            r15 = r36
            r15 = r17
            r14 = r37
            int r0 = r0.zzw(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x0332
        L_0x0318:
            r15 = r31
            r14 = r32
            r12 = r33
            r2 = r34
            r13 = r35
            r11 = r36
            r9 = r37
            r3 = r21
            r5 = r22
            r6 = r23
            r1 = r25
            r10 = r29
            goto L_0x0019
        L_0x0332:
            r2 = r0
            r6 = r23
            r7 = r25
            r0 = r36
            goto L_0x038e
        L_0x033b:
            r25 = r7
            r21 = r8
            r29 = r10
            r15 = r17
            r3 = r24
            r34 = r26
            r18 = 1
            r26 = -1
            r24 = r2
            r0 = 50
            r7 = r24
            if (r11 != r0) goto L_0x0373
            r0 = 2
            if (r7 != r0) goto L_0x036b
            r0 = r31
            r1 = r32
            r2 = r33
            r3 = r15
            r4 = r35
            r5 = r21
            r6 = r12
            r8 = r37
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x0332
            goto L_0x0318
        L_0x036b:
            r0 = r36
            r2 = r15
            r6 = r23
            r7 = r25
            goto L_0x038e
        L_0x0373:
            r0 = r31
            r1 = r32
            r2 = r33
            r8 = r3
            r3 = r15
            r4 = r35
            r5 = r25
            r6 = r34
            r9 = r11
            r10 = r12
            r12 = r21
            r13 = r37
            int r0 = r0.zzu(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x0332
            goto L_0x0318
        L_0x038e:
            if (r7 != r0) goto L_0x03a3
            if (r0 == 0) goto L_0x03a3
            r8 = r31
            r13 = r32
            r9 = r0
            r0 = r2
            r2 = r6
            r1 = r7
            r5 = r22
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r35
            goto L_0x0581
        L_0x03a3:
            r8 = r31
            r9 = r0
            boolean r0 = r8.zzh
            if (r0 == 0) goto L_0x0545
            r10 = r37
            com.google.android.gms.internal.gtm.zzuj r0 = r10.zzd
            com.google.android.gms.internal.gtm.zzuj r1 = com.google.android.gms.internal.gtm.zzuj.zza()
            if (r0 == r1) goto L_0x053e
            com.google.android.gms.internal.gtm.zzwk r0 = r8.zzg
            com.google.android.gms.internal.gtm.zzxo<?, ?> r1 = r8.zzo
            com.google.android.gms.internal.gtm.zzuj r3 = r10.zzd
            r11 = r34
            com.google.android.gms.internal.gtm.zzux r12 = r3.zzc(r0, r11)
            if (r12 != 0) goto L_0x03db
            com.google.android.gms.internal.gtm.zzxp r4 = zzd(r32)
            r0 = r7
            r1 = r33
            r3 = r35
            r5 = r37
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzi(r0, r1, r2, r3, r4, r5)
            r13 = r32
            r15 = r33
        L_0x03d5:
            r34 = r6
            r6 = r35
            goto L_0x0560
        L_0x03db:
            r13 = r32
            r0 = r13
            com.google.android.gms.internal.gtm.zzuv r0 = (com.google.android.gms.internal.gtm.zzuv) r0
            r0.zzU()
            com.google.android.gms.internal.gtm.zzuo<com.google.android.gms.internal.gtm.zzuw> r14 = r0.zza
            com.google.android.gms.internal.gtm.zzuw r3 = r12.zzd
            com.google.android.gms.internal.gtm.zzye r3 = r3.zzc
            com.google.android.gms.internal.gtm.zzye r4 = com.google.android.gms.internal.gtm.zzye.ENUM
            r15 = r33
            if (r3 != r4) goto L_0x0417
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzj(r15, r2, r10)
            com.google.android.gms.internal.gtm.zzuw r3 = r12.zzd
            com.google.android.gms.internal.gtm.zzvc<?> r3 = r3.zza
            int r3 = r10.zza
            com.google.android.gms.internal.gtm.zzyl r3 = com.google.android.gms.internal.gtm.zzyl.zzc(r3)
            if (r3 != 0) goto L_0x0414
            com.google.android.gms.internal.gtm.zzxp r3 = r0.zzc
            com.google.android.gms.internal.gtm.zzxp r4 = com.google.android.gms.internal.gtm.zzxp.zzc()
            if (r3 != r4) goto L_0x040d
            com.google.android.gms.internal.gtm.zzxp r3 = com.google.android.gms.internal.gtm.zzxp.zze()
            r0.zzc = r3
        L_0x040d:
            int r0 = r10.zza
            com.google.android.gms.internal.gtm.zzwz.zzD(r11, r0, r3, r1)
            r0 = r2
            goto L_0x03d5
        L_0x0414:
            int r0 = r10.zza
            goto L_0x0442
        L_0x0417:
            com.google.android.gms.internal.gtm.zzuw r0 = r12.zzd
            com.google.android.gms.internal.gtm.zzye r0 = r0.zzc
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L_0x0505;
                case 1: goto L_0x04f2;
                case 2: goto L_0x04e3;
                case 3: goto L_0x04e3;
                case 4: goto L_0x04d4;
                case 5: goto L_0x04c7;
                case 6: goto L_0x04ba;
                case 7: goto L_0x04a4;
                case 8: goto L_0x0498;
                case 9: goto L_0x0476;
                case 10: goto L_0x045b;
                case 11: goto L_0x044f;
                case 12: goto L_0x04d4;
                case 13: goto L_0x0447;
                case 14: goto L_0x04ba;
                case 15: goto L_0x04c7;
                case 16: goto L_0x0438;
                case 17: goto L_0x0429;
                default: goto L_0x0422;
            }
        L_0x0422:
            r34 = r6
            r6 = r35
            r4 = 0
            goto L_0x0517
        L_0x0429:
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzm(r15, r2, r10)
            long r0 = r10.zzb
            long r0 = com.google.android.gms.internal.gtm.zztj.zzt(r0)
            java.lang.Long r4 = java.lang.Long.valueOf(r0)
            goto L_0x0455
        L_0x0438:
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzj(r15, r2, r10)
            int r0 = r10.zza
            int r0 = com.google.android.gms.internal.gtm.zztj.zzs(r0)
        L_0x0442:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            goto L_0x0455
        L_0x0447:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Shouldn't reach here."
            r0.<init>(r1)
            throw r0
        L_0x044f:
            int r2 = com.google.android.gms.internal.gtm.zzsm.zza(r15, r2, r10)
            java.lang.Object r4 = r10.zzc
        L_0x0455:
            r34 = r6
            r6 = r35
            goto L_0x0517
        L_0x045b:
            com.google.android.gms.internal.gtm.zzwt r0 = com.google.android.gms.internal.gtm.zzwt.zza()
            com.google.android.gms.internal.gtm.zzwk r1 = r12.zzc
            java.lang.Class r1 = r1.getClass()
            com.google.android.gms.internal.gtm.zzwx r0 = r0.zzb(r1)
            r5 = r35
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzd(r0, r15, r2, r5, r10)
            java.lang.Object r4 = r10.zzc
            r34 = r6
            r6 = r5
            goto L_0x0517
        L_0x0476:
            r5 = r35
            com.google.android.gms.internal.gtm.zzwt r0 = com.google.android.gms.internal.gtm.zzwt.zza()
            com.google.android.gms.internal.gtm.zzwk r1 = r12.zzc
            java.lang.Class r1 = r1.getClass()
            com.google.android.gms.internal.gtm.zzwx r0 = r0.zzb(r1)
            int r1 = r11 << 3
            r4 = r1 | 4
            r1 = r33
            r3 = r35
            r34 = r6
            r6 = r5
            r5 = r37
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzc(r0, r1, r2, r3, r4, r5)
            goto L_0x04a0
        L_0x0498:
            r34 = r6
            r6 = r35
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzg(r15, r2, r10)
        L_0x04a0:
            java.lang.Object r4 = r10.zzc
            goto L_0x0517
        L_0x04a4:
            r34 = r6
            r6 = r35
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzm(r15, r2, r10)
            long r0 = r10.zzb
            int r3 = (r0 > r19 ? 1 : (r0 == r19 ? 0 : -1))
            if (r3 == 0) goto L_0x04b4
            r4 = 1
            goto L_0x04b5
        L_0x04b4:
            r4 = 0
        L_0x04b5:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            goto L_0x0517
        L_0x04ba:
            r34 = r6
            r6 = r35
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzb(r15, r2)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            goto L_0x0502
        L_0x04c7:
            r34 = r6
            r6 = r35
            long r0 = com.google.android.gms.internal.gtm.zzsm.zzo(r15, r2)
            java.lang.Long r4 = java.lang.Long.valueOf(r0)
            goto L_0x0515
        L_0x04d4:
            r34 = r6
            r6 = r35
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzj(r15, r2, r10)
            int r0 = r10.zza
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            goto L_0x0517
        L_0x04e3:
            r34 = r6
            r6 = r35
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzm(r15, r2, r10)
            long r0 = r10.zzb
            java.lang.Long r4 = java.lang.Long.valueOf(r0)
            goto L_0x0517
        L_0x04f2:
            r34 = r6
            r6 = r35
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzb(r15, r2)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            java.lang.Float r4 = java.lang.Float.valueOf(r0)
        L_0x0502:
            int r2 = r2 + 4
            goto L_0x0517
        L_0x0505:
            r34 = r6
            r6 = r35
            long r0 = com.google.android.gms.internal.gtm.zzsm.zzo(r15, r2)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            java.lang.Double r4 = java.lang.Double.valueOf(r0)
        L_0x0515:
            int r2 = r2 + 8
        L_0x0517:
            r12.zza()
            com.google.android.gms.internal.gtm.zzuw r0 = r12.zzd
            com.google.android.gms.internal.gtm.zzye r0 = r0.zzc
            int r0 = r0.ordinal()
            r1 = 9
            if (r0 == r1) goto L_0x052b
            r1 = 10
            if (r0 == r1) goto L_0x052b
            goto L_0x0537
        L_0x052b:
            com.google.android.gms.internal.gtm.zzuw r0 = r12.zzd
            java.lang.Object r0 = r14.zze(r0)
            if (r0 == 0) goto L_0x0537
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzvi.zzg(r0, r4)
        L_0x0537:
            com.google.android.gms.internal.gtm.zzuw r0 = r12.zzd
            r14.zzi(r0, r4)
            r0 = r2
            goto L_0x0560
        L_0x053e:
            r13 = r32
            r15 = r33
            r11 = r34
            goto L_0x054d
        L_0x0545:
            r13 = r32
            r15 = r33
            r11 = r34
            r10 = r37
        L_0x054d:
            r34 = r6
            r6 = r35
            com.google.android.gms.internal.gtm.zzxp r4 = zzd(r32)
            r0 = r7
            r1 = r33
            r3 = r35
            r5 = r37
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzi(r0, r1, r2, r3, r4, r5)
        L_0x0560:
            r1 = r7
            r2 = r11
            r14 = r13
            r12 = r15
            r3 = r21
            r5 = r22
            r13 = r6
            r15 = r8
            r11 = r9
            r9 = r10
            r10 = r29
            r6 = r34
            goto L_0x0019
        L_0x0572:
            r22 = r5
            r23 = r6
            r29 = r10
            r9 = r11
            r6 = r13
            r13 = r14
            r8 = r15
            r2 = r23
            r3 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0581:
            if (r2 == r3) goto L_0x0589
            long r2 = (long) r2
            r4 = r29
            r4.putInt(r13, r2, r5)
        L_0x0589:
            int r2 = r8.zzl
        L_0x058b:
            int r3 = r8.zzm
            if (r2 >= r3) goto L_0x059c
            int[] r3 = r8.zzk
            r3 = r3[r2]
            com.google.android.gms.internal.gtm.zzxo<?, ?> r4 = r8.zzo
            r5 = 0
            r8.zzG(r13, r3, r5, r4)
            int r2 = r2 + 1
            goto L_0x058b
        L_0x059c:
            if (r9 != 0) goto L_0x05a6
            if (r0 != r6) goto L_0x05a1
            goto L_0x05aa
        L_0x05a1:
            com.google.android.gms.internal.gtm.zzvk r0 = com.google.android.gms.internal.gtm.zzvk.zzg()
            throw r0
        L_0x05a6:
            if (r0 > r6) goto L_0x05ab
            if (r1 != r9) goto L_0x05ab
        L_0x05aa:
            return r0
        L_0x05ab:
            com.google.android.gms.internal.gtm.zzvk r0 = com.google.android.gms.internal.gtm.zzvk.zzg()
            goto L_0x05b1
        L_0x05b0:
            throw r0
        L_0x05b1:
            goto L_0x05b0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzwn.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.gtm.zzsl):int");
    }

    public final T zze() {
        return ((zzuz) this.zzg).zzb(4, (Object) null, (Object) null);
    }

    public final void zzf(T t2) {
        int i2;
        int i3 = this.zzl;
        while (true) {
            i2 = this.zzm;
            if (i3 >= i2) {
                break;
            }
            long zzC = (long) (zzC(this.zzk[i3]) & 1048575);
            Object zzf2 = zzxy.zzf(t2, zzC);
            if (zzf2 != null) {
                ((zzwe) zzf2).zzc();
                zzxy.zzs(t2, zzC, zzf2);
            }
            i3++;
        }
        int length = this.zzk.length;
        while (i2 < length) {
            this.zzn.zzb(t2, (long) this.zzk[i2]);
            i2++;
        }
        this.zzo.zzm(t2);
        if (this.zzh) {
            this.zzp.zzf(t2);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0031, code lost:
        com.google.android.gms.internal.gtm.zzxy.zzs(r7, r2, com.google.android.gms.internal.gtm.zzxy.zzf(r8, r2));
        zzN(r7, r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0089, code lost:
        com.google.android.gms.internal.gtm.zzxy.zzs(r7, r2, com.google.android.gms.internal.gtm.zzxy.zzf(r8, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b3, code lost:
        com.google.android.gms.internal.gtm.zzxy.zzq(r7, r2, com.google.android.gms.internal.gtm.zzxy.zzc(r8, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c8, code lost:
        com.google.android.gms.internal.gtm.zzxy.zzr(r7, r2, com.google.android.gms.internal.gtm.zzxy.zzd(r8, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00eb, code lost:
        zzM(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ee, code lost:
        r0 = r0 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzg(T r7, T r8) {
        /*
            r6 = this;
            java.util.Objects.requireNonNull(r8)
            r0 = 0
        L_0x0004:
            int[] r1 = r6.zzc
            int r1 = r1.length
            if (r0 >= r1) goto L_0x00f2
            int r1 = r6.zzC(r0)
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r1
            long r2 = (long) r2
            int[] r4 = r6.zzc
            r4 = r4[r0]
            int r1 = zzB(r1)
            switch(r1) {
                case 0: goto L_0x00de;
                case 1: goto L_0x00d0;
                case 2: goto L_0x00c2;
                case 3: goto L_0x00bb;
                case 4: goto L_0x00ad;
                case 5: goto L_0x00a6;
                case 6: goto L_0x009f;
                case 7: goto L_0x0091;
                case 8: goto L_0x0083;
                case 9: goto L_0x007e;
                case 10: goto L_0x0077;
                case 11: goto L_0x0070;
                case 12: goto L_0x0069;
                case 13: goto L_0x0062;
                case 14: goto L_0x005a;
                case 15: goto L_0x0053;
                case 16: goto L_0x004b;
                case 17: goto L_0x007e;
                case 18: goto L_0x0044;
                case 19: goto L_0x0044;
                case 20: goto L_0x0044;
                case 21: goto L_0x0044;
                case 22: goto L_0x0044;
                case 23: goto L_0x0044;
                case 24: goto L_0x0044;
                case 25: goto L_0x0044;
                case 26: goto L_0x0044;
                case 27: goto L_0x0044;
                case 28: goto L_0x0044;
                case 29: goto L_0x0044;
                case 30: goto L_0x0044;
                case 31: goto L_0x0044;
                case 32: goto L_0x0044;
                case 33: goto L_0x0044;
                case 34: goto L_0x0044;
                case 35: goto L_0x0044;
                case 36: goto L_0x0044;
                case 37: goto L_0x0044;
                case 38: goto L_0x0044;
                case 39: goto L_0x0044;
                case 40: goto L_0x0044;
                case 41: goto L_0x0044;
                case 42: goto L_0x0044;
                case 43: goto L_0x0044;
                case 44: goto L_0x0044;
                case 45: goto L_0x0044;
                case 46: goto L_0x0044;
                case 47: goto L_0x0044;
                case 48: goto L_0x0044;
                case 49: goto L_0x0044;
                case 50: goto L_0x003d;
                case 51: goto L_0x002b;
                case 52: goto L_0x002b;
                case 53: goto L_0x002b;
                case 54: goto L_0x002b;
                case 55: goto L_0x002b;
                case 56: goto L_0x002b;
                case 57: goto L_0x002b;
                case 58: goto L_0x002b;
                case 59: goto L_0x002b;
                case 60: goto L_0x0026;
                case 61: goto L_0x001f;
                case 62: goto L_0x001f;
                case 63: goto L_0x001f;
                case 64: goto L_0x001f;
                case 65: goto L_0x001f;
                case 66: goto L_0x001f;
                case 67: goto L_0x001f;
                case 68: goto L_0x0026;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x00ee
        L_0x001f:
            boolean r1 = r6.zzT(r8, r4, r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x0031
        L_0x0026:
            r6.zzK(r7, r8, r0)
            goto L_0x00ee
        L_0x002b:
            boolean r1 = r6.zzT(r8, r4, r0)
            if (r1 == 0) goto L_0x00ee
        L_0x0031:
            java.lang.Object r1 = com.google.android.gms.internal.gtm.zzxy.zzf(r8, r2)
            com.google.android.gms.internal.gtm.zzxy.zzs(r7, r2, r1)
            r6.zzN(r7, r4, r0)
            goto L_0x00ee
        L_0x003d:
            com.google.android.gms.internal.gtm.zzwf r1 = r6.zzr
            com.google.android.gms.internal.gtm.zzwz.zzI(r1, r7, r8, r2)
            goto L_0x00ee
        L_0x0044:
            com.google.android.gms.internal.gtm.zzvy r1 = r6.zzn
            r1.zzc(r7, r8, r2)
            goto L_0x00ee
        L_0x004b:
            boolean r1 = r6.zzQ(r8, r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00c8
        L_0x0053:
            boolean r1 = r6.zzQ(r8, r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x006f
        L_0x005a:
            boolean r1 = r6.zzQ(r8, r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00c8
        L_0x0062:
            boolean r1 = r6.zzQ(r8, r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x006f
        L_0x0069:
            boolean r1 = r6.zzQ(r8, r0)
            if (r1 == 0) goto L_0x00ee
        L_0x006f:
            goto L_0x00b3
        L_0x0070:
            boolean r1 = r6.zzQ(r8, r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00b3
        L_0x0077:
            boolean r1 = r6.zzQ(r8, r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x0089
        L_0x007e:
            r6.zzJ(r7, r8, r0)
            goto L_0x00ee
        L_0x0083:
            boolean r1 = r6.zzQ(r8, r0)
            if (r1 == 0) goto L_0x00ee
        L_0x0089:
            java.lang.Object r1 = com.google.android.gms.internal.gtm.zzxy.zzf(r8, r2)
            com.google.android.gms.internal.gtm.zzxy.zzs(r7, r2, r1)
            goto L_0x00eb
        L_0x0091:
            boolean r1 = r6.zzQ(r8, r0)
            if (r1 == 0) goto L_0x00ee
            boolean r1 = com.google.android.gms.internal.gtm.zzxy.zzw(r8, r2)
            com.google.android.gms.internal.gtm.zzxy.zzm(r7, r2, r1)
            goto L_0x00eb
        L_0x009f:
            boolean r1 = r6.zzQ(r8, r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00b3
        L_0x00a6:
            boolean r1 = r6.zzQ(r8, r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00c8
        L_0x00ad:
            boolean r1 = r6.zzQ(r8, r0)
            if (r1 == 0) goto L_0x00ee
        L_0x00b3:
            int r1 = com.google.android.gms.internal.gtm.zzxy.zzc(r8, r2)
            com.google.android.gms.internal.gtm.zzxy.zzq(r7, r2, r1)
            goto L_0x00eb
        L_0x00bb:
            boolean r1 = r6.zzQ(r8, r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00c8
        L_0x00c2:
            boolean r1 = r6.zzQ(r8, r0)
            if (r1 == 0) goto L_0x00ee
        L_0x00c8:
            long r4 = com.google.android.gms.internal.gtm.zzxy.zzd(r8, r2)
            com.google.android.gms.internal.gtm.zzxy.zzr(r7, r2, r4)
            goto L_0x00eb
        L_0x00d0:
            boolean r1 = r6.zzQ(r8, r0)
            if (r1 == 0) goto L_0x00ee
            float r1 = com.google.android.gms.internal.gtm.zzxy.zzb(r8, r2)
            com.google.android.gms.internal.gtm.zzxy.zzp(r7, r2, r1)
            goto L_0x00eb
        L_0x00de:
            boolean r1 = r6.zzQ(r8, r0)
            if (r1 == 0) goto L_0x00ee
            double r4 = com.google.android.gms.internal.gtm.zzxy.zza(r8, r2)
            com.google.android.gms.internal.gtm.zzxy.zzo(r7, r2, r4)
        L_0x00eb:
            r6.zzM(r7, r0)
        L_0x00ee:
            int r0 = r0 + 3
            goto L_0x0004
        L_0x00f2:
            com.google.android.gms.internal.gtm.zzxo<?, ?> r0 = r6.zzo
            com.google.android.gms.internal.gtm.zzwz.zzF(r0, r7, r8)
            boolean r0 = r6.zzh
            if (r0 == 0) goto L_0x0100
            com.google.android.gms.internal.gtm.zzuk<?> r0 = r6.zzp
            com.google.android.gms.internal.gtm.zzwz.zzE(r0, r7, r8)
        L_0x0100:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzwn.zzg(java.lang.Object, java.lang.Object):void");
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final void zzh(T r13, com.google.android.gms.internal.gtm.zzww r14, com.google.android.gms.internal.gtm.zzuj r15) throws java.io.IOException {
        /*
            r12 = this;
            java.util.Objects.requireNonNull(r15)
            com.google.android.gms.internal.gtm.zzxo<?, ?> r7 = r12.zzo
            com.google.android.gms.internal.gtm.zzuk<?> r8 = r12.zzp
            r9 = 0
            r0 = r9
            r10 = r0
        L_0x000a:
            int r1 = r14.zzc()     // Catch:{ all -> 0x0076 }
            int r2 = r12.zzx(r1)     // Catch:{ all -> 0x0076 }
            if (r2 >= 0) goto L_0x0079
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r1 != r2) goto L_0x002f
            int r14 = r12.zzl
        L_0x001b:
            int r15 = r12.zzm
            if (r14 >= r15) goto L_0x0029
            int[] r15 = r12.zzk
            r15 = r15[r14]
            r12.zzG(r13, r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x001b
        L_0x0029:
            if (r10 == 0) goto L_0x050b
            r7.zzn(r13, r10)
            return
        L_0x002f:
            boolean r2 = r12.zzh     // Catch:{ all -> 0x0076 }
            if (r2 != 0) goto L_0x0035
            r2 = r9
            goto L_0x003c
        L_0x0035:
            com.google.android.gms.internal.gtm.zzwk r2 = r12.zzg     // Catch:{ all -> 0x0076 }
            java.lang.Object r1 = r8.zzd(r15, r2, r1)     // Catch:{ all -> 0x0076 }
            r2 = r1
        L_0x003c:
            if (r2 == 0) goto L_0x0051
            if (r0 != 0) goto L_0x0044
            com.google.android.gms.internal.gtm.zzuo r0 = r8.zzc(r13)     // Catch:{ all -> 0x0076 }
        L_0x0044:
            r11 = r0
            r0 = r8
            r1 = r14
            r3 = r15
            r4 = r11
            r5 = r10
            r6 = r7
            java.lang.Object r10 = r0.zze(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0076 }
            r0 = r11
            goto L_0x000a
        L_0x0051:
            r7.zzq(r14)     // Catch:{ all -> 0x0076 }
            if (r10 != 0) goto L_0x005a
            java.lang.Object r10 = r7.zzc(r13)     // Catch:{ all -> 0x0076 }
        L_0x005a:
            boolean r1 = r7.zzp(r10, r14)     // Catch:{ all -> 0x0076 }
            if (r1 != 0) goto L_0x000a
            int r14 = r12.zzl
        L_0x0062:
            int r15 = r12.zzm
            if (r14 >= r15) goto L_0x0070
            int[] r15 = r12.zzk
            r15 = r15[r14]
            r12.zzG(r13, r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x0062
        L_0x0070:
            if (r10 == 0) goto L_0x050b
            r7.zzn(r13, r10)
            return
        L_0x0076:
            r14 = move-exception
            goto L_0x050c
        L_0x0079:
            int r3 = r12.zzC(r2)     // Catch:{ all -> 0x0076 }
            int r4 = zzB(r3)     // Catch:{ zzvj -> 0x04e6 }
            r5 = 1048575(0xfffff, float:1.469367E-39)
            switch(r4) {
                case 0: goto L_0x04c0;
                case 1: goto L_0x04b4;
                case 2: goto L_0x04a8;
                case 3: goto L_0x049c;
                case 4: goto L_0x0490;
                case 5: goto L_0x0484;
                case 6: goto L_0x0478;
                case 7: goto L_0x046c;
                case 8: goto L_0x0467;
                case 9: goto L_0x043c;
                case 10: goto L_0x0431;
                case 11: goto L_0x0426;
                case 12: goto L_0x040f;
                case 13: goto L_0x0404;
                case 14: goto L_0x03f9;
                case 15: goto L_0x03ee;
                case 16: goto L_0x03e3;
                case 17: goto L_0x03b2;
                case 18: goto L_0x03a7;
                case 19: goto L_0x039c;
                case 20: goto L_0x0391;
                case 21: goto L_0x0386;
                case 22: goto L_0x037b;
                case 23: goto L_0x0370;
                case 24: goto L_0x0365;
                case 25: goto L_0x035a;
                case 26: goto L_0x0338;
                case 27: goto L_0x0326;
                case 28: goto L_0x0318;
                case 29: goto L_0x030d;
                case 30: goto L_0x02fc;
                case 31: goto L_0x02f1;
                case 32: goto L_0x02e6;
                case 33: goto L_0x02db;
                case 34: goto L_0x02d0;
                case 35: goto L_0x02c2;
                case 36: goto L_0x02b4;
                case 37: goto L_0x02a6;
                case 38: goto L_0x0298;
                case 39: goto L_0x028a;
                case 40: goto L_0x027c;
                case 41: goto L_0x026e;
                case 42: goto L_0x0260;
                case 43: goto L_0x0252;
                case 44: goto L_0x023d;
                case 45: goto L_0x022f;
                case 46: goto L_0x0221;
                case 47: goto L_0x0213;
                case 48: goto L_0x0205;
                case 49: goto L_0x01f3;
                case 50: goto L_0x01bd;
                case 51: goto L_0x01ae;
                case 52: goto L_0x019f;
                case 53: goto L_0x0190;
                case 54: goto L_0x0181;
                case 55: goto L_0x0172;
                case 56: goto L_0x0163;
                case 57: goto L_0x0154;
                case 58: goto L_0x0145;
                case 59: goto L_0x0140;
                case 60: goto L_0x0112;
                case 61: goto L_0x0108;
                case 62: goto L_0x00fa;
                case 63: goto L_0x00d9;
                case 64: goto L_0x00cb;
                case 65: goto L_0x00bd;
                case 66: goto L_0x00af;
                case 67: goto L_0x00a1;
                case 68: goto L_0x008f;
                default: goto L_0x0087;
            }     // Catch:{ zzvj -> 0x04e6 }
        L_0x0087:
            if (r10 != 0) goto L_0x04cc
            java.lang.Object r10 = r7.zzf()     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x04cc
        L_0x008f:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzwx r5 = r12.zzF(r2)     // Catch:{ zzvj -> 0x04e6 }
            java.lang.Object r5 = r14.zzs(r5, r15)     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r5)     // Catch:{ zzvj -> 0x04e6 }
        L_0x009c:
            r12.zzN(r13, r1, r2)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x000a
        L_0x00a1:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzvj -> 0x04e6 }
            long r5 = r14.zzn()     // Catch:{ zzvj -> 0x04e6 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r5)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x009c
        L_0x00af:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzvj -> 0x04e6 }
            int r5 = r14.zzi()     // Catch:{ zzvj -> 0x04e6 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r5)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x009c
        L_0x00bd:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzvj -> 0x04e6 }
            long r5 = r14.zzm()     // Catch:{ zzvj -> 0x04e6 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r5)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x009c
        L_0x00cb:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzvj -> 0x04e6 }
            int r5 = r14.zzh()     // Catch:{ zzvj -> 0x04e6 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r5)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x009c
        L_0x00d9:
            int r4 = r14.zze()     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzvd r6 = r12.zzE(r2)     // Catch:{ zzvj -> 0x04e6 }
            if (r6 == 0) goto L_0x00f0
            boolean r6 = r6.zza(r4)     // Catch:{ zzvj -> 0x04e6 }
            if (r6 == 0) goto L_0x00ea
            goto L_0x00f0
        L_0x00ea:
            java.lang.Object r10 = com.google.android.gms.internal.gtm.zzwz.zzD(r1, r4, r10, r7)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x000a
        L_0x00f0:
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzvj -> 0x04e6 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r5, r3)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x009c
        L_0x00fa:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzvj -> 0x04e6 }
            int r5 = r14.zzj()     // Catch:{ zzvj -> 0x04e6 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r5)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x009c
        L_0x0108:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zztd r5 = r14.zzq()     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r5)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x009c
        L_0x0112:
            boolean r4 = r12.zzT(r13, r1, r2)     // Catch:{ zzvj -> 0x04e6 }
            r3 = r3 & r5
            if (r4 == 0) goto L_0x012f
            long r3 = (long) r3     // Catch:{ zzvj -> 0x04e6 }
            java.lang.Object r5 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r3)     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzwx r6 = r12.zzF(r2)     // Catch:{ zzvj -> 0x04e6 }
            java.lang.Object r6 = r14.zzu(r6, r15)     // Catch:{ zzvj -> 0x04e6 }
            java.lang.Object r5 = com.google.android.gms.internal.gtm.zzvi.zzg(r5, r6)     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r5)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x009c
        L_0x012f:
            long r3 = (long) r3     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzwx r5 = r12.zzF(r2)     // Catch:{ zzvj -> 0x04e6 }
            java.lang.Object r5 = r14.zzu(r5, r15)     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r5)     // Catch:{ zzvj -> 0x04e6 }
            r12.zzM(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x009c
        L_0x0140:
            r12.zzL(r13, r3, r14)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x009c
        L_0x0145:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzvj -> 0x04e6 }
            boolean r5 = r14.zzS()     // Catch:{ zzvj -> 0x04e6 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r5)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x009c
        L_0x0154:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzvj -> 0x04e6 }
            int r5 = r14.zzf()     // Catch:{ zzvj -> 0x04e6 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r5)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x009c
        L_0x0163:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzvj -> 0x04e6 }
            long r5 = r14.zzk()     // Catch:{ zzvj -> 0x04e6 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r5)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x009c
        L_0x0172:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzvj -> 0x04e6 }
            int r5 = r14.zzg()     // Catch:{ zzvj -> 0x04e6 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r5)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x009c
        L_0x0181:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzvj -> 0x04e6 }
            long r5 = r14.zzo()     // Catch:{ zzvj -> 0x04e6 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r5)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x009c
        L_0x0190:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzvj -> 0x04e6 }
            long r5 = r14.zzl()     // Catch:{ zzvj -> 0x04e6 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r5)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x009c
        L_0x019f:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzvj -> 0x04e6 }
            float r5 = r14.zzb()     // Catch:{ zzvj -> 0x04e6 }
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r5)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x009c
        L_0x01ae:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzvj -> 0x04e6 }
            double r5 = r14.zza()     // Catch:{ zzvj -> 0x04e6 }
            java.lang.Double r5 = java.lang.Double.valueOf(r5)     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r5)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x009c
        L_0x01bd:
            java.lang.Object r1 = r12.zzH(r2)     // Catch:{ zzvj -> 0x04e6 }
            int r2 = r12.zzC(r2)     // Catch:{ zzvj -> 0x04e6 }
            r2 = r2 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x04e6 }
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
            if (r4 == 0) goto L_0x01e3
            boolean r5 = com.google.android.gms.internal.gtm.zzwf.zzb(r4)     // Catch:{ zzvj -> 0x04e6 }
            if (r5 == 0) goto L_0x01ee
            com.google.android.gms.internal.gtm.zzwe r5 = com.google.android.gms.internal.gtm.zzwe.zza()     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzwe r5 = r5.zzb()     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzwf.zzc(r5, r4)     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r2, r5)     // Catch:{ zzvj -> 0x04e6 }
            r4 = r5
            goto L_0x01ee
        L_0x01e3:
            com.google.android.gms.internal.gtm.zzwe r4 = com.google.android.gms.internal.gtm.zzwe.zza()     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzwe r4 = r4.zzb()     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r2, r4)     // Catch:{ zzvj -> 0x04e6 }
        L_0x01ee:
            com.google.android.gms.internal.gtm.zzwe r4 = (com.google.android.gms.internal.gtm.zzwe) r4     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzwd r1 = (com.google.android.gms.internal.gtm.zzwd) r1     // Catch:{ zzvj -> 0x04e6 }
            throw r9     // Catch:{ zzvj -> 0x04e6 }
        L_0x01f3:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzwx r1 = r12.zzF(r2)     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzvy r2 = r12.zzn     // Catch:{ zzvj -> 0x04e6 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzvj -> 0x04e6 }
            r14.zzF(r2, r1, r15)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x000a
        L_0x0205:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x04e6 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x04e6 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
        L_0x020e:
            r14.zzM(r1)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x000a
        L_0x0213:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x04e6 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x04e6 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
        L_0x021c:
            r14.zzL(r1)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x000a
        L_0x0221:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x04e6 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x04e6 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
        L_0x022a:
            r14.zzK(r1)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x000a
        L_0x022f:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x04e6 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x04e6 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
        L_0x0238:
            r14.zzJ(r1)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x000a
        L_0x023d:
            com.google.android.gms.internal.gtm.zzvy r4 = r12.zzn     // Catch:{ zzvj -> 0x04e6 }
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzvj -> 0x04e6 }
            java.util.List r3 = r4.zza(r13, r5)     // Catch:{ zzvj -> 0x04e6 }
            r14.zzB(r3)     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzvd r2 = r12.zzE(r2)     // Catch:{ zzvj -> 0x04e6 }
        L_0x024c:
            java.lang.Object r10 = com.google.android.gms.internal.gtm.zzwz.zzC(r1, r3, r2, r10, r7)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x000a
        L_0x0252:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x04e6 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x04e6 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
        L_0x025b:
            r14.zzQ(r1)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x000a
        L_0x0260:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x04e6 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x04e6 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
        L_0x0269:
            r14.zzy(r1)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x000a
        L_0x026e:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x04e6 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x04e6 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
        L_0x0277:
            r14.zzC(r1)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x000a
        L_0x027c:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x04e6 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x04e6 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
        L_0x0285:
            r14.zzD(r1)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x000a
        L_0x028a:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x04e6 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x04e6 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
        L_0x0293:
            r14.zzG(r1)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x000a
        L_0x0298:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x04e6 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x04e6 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
        L_0x02a1:
            r14.zzR(r1)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x000a
        L_0x02a6:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x04e6 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x04e6 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
        L_0x02af:
            r14.zzH(r1)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x000a
        L_0x02b4:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x04e6 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x04e6 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
        L_0x02bd:
            r14.zzE(r1)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x000a
        L_0x02c2:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x04e6 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x04e6 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
        L_0x02cb:
            r14.zzA(r1)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x000a
        L_0x02d0:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x04e6 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x04e6 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x020e
        L_0x02db:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x04e6 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x04e6 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x021c
        L_0x02e6:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x04e6 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x04e6 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x022a
        L_0x02f1:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x04e6 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x04e6 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x0238
        L_0x02fc:
            com.google.android.gms.internal.gtm.zzvy r4 = r12.zzn     // Catch:{ zzvj -> 0x04e6 }
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzvj -> 0x04e6 }
            java.util.List r3 = r4.zza(r13, r5)     // Catch:{ zzvj -> 0x04e6 }
            r14.zzB(r3)     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzvd r2 = r12.zzE(r2)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x024c
        L_0x030d:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x04e6 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x04e6 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x025b
        L_0x0318:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x04e6 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x04e6 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
            r14.zzz(r1)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x000a
        L_0x0326:
            com.google.android.gms.internal.gtm.zzwx r1 = r12.zzF(r2)     // Catch:{ zzvj -> 0x04e6 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzvy r4 = r12.zzn     // Catch:{ zzvj -> 0x04e6 }
            java.util.List r2 = r4.zza(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
            r14.zzI(r2, r1, r15)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x000a
        L_0x0338:
            boolean r1 = zzP(r3)     // Catch:{ zzvj -> 0x04e6 }
            if (r1 == 0) goto L_0x034c
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x04e6 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x04e6 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
            r14.zzP(r1)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x000a
        L_0x034c:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x04e6 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x04e6 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
            r14.zzN(r1)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x000a
        L_0x035a:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x04e6 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x04e6 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x0269
        L_0x0365:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x04e6 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x04e6 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x0277
        L_0x0370:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x04e6 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x04e6 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x0285
        L_0x037b:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x04e6 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x04e6 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x0293
        L_0x0386:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x04e6 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x04e6 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x02a1
        L_0x0391:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x04e6 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x04e6 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x02af
        L_0x039c:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x04e6 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x04e6 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x02bd
        L_0x03a7:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x04e6 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x04e6 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x02cb
        L_0x03b2:
            boolean r1 = r12.zzQ(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
            if (r1 == 0) goto L_0x03d0
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x04e6 }
            java.lang.Object r1 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r3)     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzwx r2 = r12.zzF(r2)     // Catch:{ zzvj -> 0x04e6 }
            java.lang.Object r2 = r14.zzs(r2, r15)     // Catch:{ zzvj -> 0x04e6 }
            java.lang.Object r1 = com.google.android.gms.internal.gtm.zzvi.zzg(r1, r2)     // Catch:{ zzvj -> 0x04e6 }
        L_0x03cb:
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r1)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x000a
        L_0x03d0:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzwx r1 = r12.zzF(r2)     // Catch:{ zzvj -> 0x04e6 }
            java.lang.Object r1 = r14.zzs(r1, r15)     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r1)     // Catch:{ zzvj -> 0x04e6 }
        L_0x03de:
            r12.zzM(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x000a
        L_0x03e3:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x04e6 }
            long r5 = r14.zzn()     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzr(r13, r3, r5)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x03de
        L_0x03ee:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x04e6 }
            int r1 = r14.zzi()     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzq(r13, r3, r1)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x03de
        L_0x03f9:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x04e6 }
            long r5 = r14.zzm()     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzr(r13, r3, r5)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x03de
        L_0x0404:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x04e6 }
            int r1 = r14.zzh()     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzq(r13, r3, r1)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x03de
        L_0x040f:
            int r4 = r14.zze()     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzvd r6 = r12.zzE(r2)     // Catch:{ zzvj -> 0x04e6 }
            if (r6 == 0) goto L_0x041f
            boolean r6 = r6.zza(r4)     // Catch:{ zzvj -> 0x04e6 }
            if (r6 == 0) goto L_0x00ea
        L_0x041f:
            r1 = r3 & r5
            long r5 = (long) r1     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzq(r13, r5, r4)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x03de
        L_0x0426:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x04e6 }
            int r1 = r14.zzj()     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzq(r13, r3, r1)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x03de
        L_0x0431:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zztd r1 = r14.zzq()     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r1)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x03de
        L_0x043c:
            boolean r1 = r12.zzQ(r13, r2)     // Catch:{ zzvj -> 0x04e6 }
            if (r1 == 0) goto L_0x0457
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x04e6 }
            java.lang.Object r1 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r3)     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzwx r2 = r12.zzF(r2)     // Catch:{ zzvj -> 0x04e6 }
            java.lang.Object r2 = r14.zzu(r2, r15)     // Catch:{ zzvj -> 0x04e6 }
            java.lang.Object r1 = com.google.android.gms.internal.gtm.zzvi.zzg(r1, r2)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x03cb
        L_0x0457:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzwx r1 = r12.zzF(r2)     // Catch:{ zzvj -> 0x04e6 }
            java.lang.Object r1 = r14.zzu(r1, r15)     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r1)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x03de
        L_0x0467:
            r12.zzL(r13, r3, r14)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x03de
        L_0x046c:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x04e6 }
            boolean r1 = r14.zzS()     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzm(r13, r3, r1)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x03de
        L_0x0478:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x04e6 }
            int r1 = r14.zzf()     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzq(r13, r3, r1)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x03de
        L_0x0484:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x04e6 }
            long r5 = r14.zzk()     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzr(r13, r3, r5)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x03de
        L_0x0490:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x04e6 }
            int r1 = r14.zzg()     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzq(r13, r3, r1)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x03de
        L_0x049c:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x04e6 }
            long r5 = r14.zzo()     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzr(r13, r3, r5)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x03de
        L_0x04a8:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x04e6 }
            long r5 = r14.zzl()     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzr(r13, r3, r5)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x03de
        L_0x04b4:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x04e6 }
            float r1 = r14.zzb()     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzp(r13, r3, r1)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x03de
        L_0x04c0:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x04e6 }
            double r5 = r14.zza()     // Catch:{ zzvj -> 0x04e6 }
            com.google.android.gms.internal.gtm.zzxy.zzo(r13, r3, r5)     // Catch:{ zzvj -> 0x04e6 }
            goto L_0x03de
        L_0x04cc:
            boolean r1 = r7.zzp(r10, r14)     // Catch:{ zzvj -> 0x04e6 }
            if (r1 != 0) goto L_0x000a
            int r14 = r12.zzl
        L_0x04d4:
            int r15 = r12.zzm
            if (r14 >= r15) goto L_0x04e2
            int[] r15 = r12.zzk
            r15 = r15[r14]
            r12.zzG(r13, r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x04d4
        L_0x04e2:
            r7.zzn(r13, r10)
            return
        L_0x04e6:
            r7.zzq(r14)     // Catch:{ all -> 0x0076 }
            if (r10 != 0) goto L_0x04f0
            java.lang.Object r1 = r7.zzc(r13)     // Catch:{ all -> 0x0076 }
            r10 = r1
        L_0x04f0:
            boolean r1 = r7.zzp(r10, r14)     // Catch:{ all -> 0x0076 }
            if (r1 != 0) goto L_0x000a
            int r14 = r12.zzl
        L_0x04f8:
            int r15 = r12.zzm
            if (r14 >= r15) goto L_0x0506
            int[] r15 = r12.zzk
            r15 = r15[r14]
            r12.zzG(r13, r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x04f8
        L_0x0506:
            if (r10 == 0) goto L_0x050b
            r7.zzn(r13, r10)
        L_0x050b:
            return
        L_0x050c:
            int r15 = r12.zzl
        L_0x050e:
            int r0 = r12.zzm
            if (r15 >= r0) goto L_0x051c
            int[] r0 = r12.zzk
            r0 = r0[r15]
            r12.zzG(r13, r0, r10, r7)
            int r15 = r15 + 1
            goto L_0x050e
        L_0x051c:
            if (r10 == 0) goto L_0x0521
            r7.zzn(r13, r10)
        L_0x0521:
            goto L_0x0523
        L_0x0522:
            throw r14
        L_0x0523:
            goto L_0x0522
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzwn.zzh(java.lang.Object, com.google.android.gms.internal.gtm.zzww, com.google.android.gms.internal.gtm.zzuj):void");
    }

    public final void zzi(T t2, byte[] bArr, int i2, int i3, zzsl zzsl) throws IOException {
        if (this.zzj) {
            zzv(t2, bArr, i2, i3, zzsl);
        } else {
            zzc(t2, bArr, i2, i3, 0, zzsl);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01b6, code lost:
        r2 = r2 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzj(T r9, T r10) {
        /*
            r8 = this;
            int[] r0 = r8.zzc
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r2 >= r0) goto L_0x01ba
            int r3 = r8.zzC(r2)
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r3 & r4
            long r5 = (long) r5
            int r3 = zzB(r3)
            switch(r3) {
                case 0: goto L_0x019a;
                case 1: goto L_0x0181;
                case 2: goto L_0x016e;
                case 3: goto L_0x015b;
                case 4: goto L_0x014a;
                case 5: goto L_0x0136;
                case 6: goto L_0x0124;
                case 7: goto L_0x0112;
                case 8: goto L_0x00fc;
                case 9: goto L_0x00e6;
                case 10: goto L_0x00d0;
                case 11: goto L_0x00be;
                case 12: goto L_0x00ac;
                case 13: goto L_0x009a;
                case 14: goto L_0x0086;
                case 15: goto L_0x0074;
                case 16: goto L_0x0060;
                case 17: goto L_0x004a;
                case 18: goto L_0x003a;
                case 19: goto L_0x003a;
                case 20: goto L_0x003a;
                case 21: goto L_0x003a;
                case 22: goto L_0x003a;
                case 23: goto L_0x003a;
                case 24: goto L_0x003a;
                case 25: goto L_0x003a;
                case 26: goto L_0x003a;
                case 27: goto L_0x003a;
                case 28: goto L_0x003a;
                case 29: goto L_0x003a;
                case 30: goto L_0x003a;
                case 31: goto L_0x003a;
                case 32: goto L_0x003a;
                case 33: goto L_0x003a;
                case 34: goto L_0x003a;
                case 35: goto L_0x003a;
                case 36: goto L_0x003a;
                case 37: goto L_0x003a;
                case 38: goto L_0x003a;
                case 39: goto L_0x003a;
                case 40: goto L_0x003a;
                case 41: goto L_0x003a;
                case 42: goto L_0x003a;
                case 43: goto L_0x003a;
                case 44: goto L_0x003a;
                case 45: goto L_0x003a;
                case 46: goto L_0x003a;
                case 47: goto L_0x003a;
                case 48: goto L_0x003a;
                case 49: goto L_0x003a;
                case 50: goto L_0x003a;
                case 51: goto L_0x001a;
                case 52: goto L_0x001a;
                case 53: goto L_0x001a;
                case 54: goto L_0x001a;
                case 55: goto L_0x001a;
                case 56: goto L_0x001a;
                case 57: goto L_0x001a;
                case 58: goto L_0x001a;
                case 59: goto L_0x001a;
                case 60: goto L_0x001a;
                case 61: goto L_0x001a;
                case 62: goto L_0x001a;
                case 63: goto L_0x001a;
                case 64: goto L_0x001a;
                case 65: goto L_0x001a;
                case 66: goto L_0x001a;
                case 67: goto L_0x001a;
                case 68: goto L_0x001a;
                default: goto L_0x0018;
            }
        L_0x0018:
            goto L_0x01b6
        L_0x001a:
            int r3 = r8.zzz(r2)
            r3 = r3 & r4
            long r3 = (long) r3
            int r7 = com.google.android.gms.internal.gtm.zzxy.zzc(r9, r3)
            int r3 = com.google.android.gms.internal.gtm.zzxy.zzc(r10, r3)
            if (r7 != r3) goto L_0x01b5
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zzxy.zzf(r9, r5)
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r10, r5)
            boolean r3 = com.google.android.gms.internal.gtm.zzwz.zzH(r3, r4)
            if (r3 != 0) goto L_0x01b6
            goto L_0x01b5
        L_0x003a:
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zzxy.zzf(r9, r5)
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r10, r5)
            boolean r3 = com.google.android.gms.internal.gtm.zzwz.zzH(r3, r4)
            if (r3 != 0) goto L_0x01b6
            goto L_0x01b5
        L_0x004a:
            boolean r3 = r8.zzO(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zzxy.zzf(r9, r5)
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r10, r5)
            boolean r3 = com.google.android.gms.internal.gtm.zzwz.zzH(r3, r4)
            if (r3 == 0) goto L_0x01b5
            goto L_0x01b6
        L_0x0060:
            boolean r3 = r8.zzO(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            long r3 = com.google.android.gms.internal.gtm.zzxy.zzd(r9, r5)
            long r5 = com.google.android.gms.internal.gtm.zzxy.zzd(r10, r5)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x01b5
            goto L_0x01b6
        L_0x0074:
            boolean r3 = r8.zzO(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            int r3 = com.google.android.gms.internal.gtm.zzxy.zzc(r9, r5)
            int r4 = com.google.android.gms.internal.gtm.zzxy.zzc(r10, r5)
            if (r3 != r4) goto L_0x01b5
            goto L_0x01b6
        L_0x0086:
            boolean r3 = r8.zzO(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            long r3 = com.google.android.gms.internal.gtm.zzxy.zzd(r9, r5)
            long r5 = com.google.android.gms.internal.gtm.zzxy.zzd(r10, r5)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x01b5
            goto L_0x01b6
        L_0x009a:
            boolean r3 = r8.zzO(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            int r3 = com.google.android.gms.internal.gtm.zzxy.zzc(r9, r5)
            int r4 = com.google.android.gms.internal.gtm.zzxy.zzc(r10, r5)
            if (r3 != r4) goto L_0x01b5
            goto L_0x01b6
        L_0x00ac:
            boolean r3 = r8.zzO(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            int r3 = com.google.android.gms.internal.gtm.zzxy.zzc(r9, r5)
            int r4 = com.google.android.gms.internal.gtm.zzxy.zzc(r10, r5)
            if (r3 != r4) goto L_0x01b5
            goto L_0x01b6
        L_0x00be:
            boolean r3 = r8.zzO(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            int r3 = com.google.android.gms.internal.gtm.zzxy.zzc(r9, r5)
            int r4 = com.google.android.gms.internal.gtm.zzxy.zzc(r10, r5)
            if (r3 != r4) goto L_0x01b5
            goto L_0x01b6
        L_0x00d0:
            boolean r3 = r8.zzO(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zzxy.zzf(r9, r5)
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r10, r5)
            boolean r3 = com.google.android.gms.internal.gtm.zzwz.zzH(r3, r4)
            if (r3 == 0) goto L_0x01b5
            goto L_0x01b6
        L_0x00e6:
            boolean r3 = r8.zzO(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zzxy.zzf(r9, r5)
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r10, r5)
            boolean r3 = com.google.android.gms.internal.gtm.zzwz.zzH(r3, r4)
            if (r3 == 0) goto L_0x01b5
            goto L_0x01b6
        L_0x00fc:
            boolean r3 = r8.zzO(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zzxy.zzf(r9, r5)
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r10, r5)
            boolean r3 = com.google.android.gms.internal.gtm.zzwz.zzH(r3, r4)
            if (r3 == 0) goto L_0x01b5
            goto L_0x01b6
        L_0x0112:
            boolean r3 = r8.zzO(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            boolean r3 = com.google.android.gms.internal.gtm.zzxy.zzw(r9, r5)
            boolean r4 = com.google.android.gms.internal.gtm.zzxy.zzw(r10, r5)
            if (r3 != r4) goto L_0x01b5
            goto L_0x01b6
        L_0x0124:
            boolean r3 = r8.zzO(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            int r3 = com.google.android.gms.internal.gtm.zzxy.zzc(r9, r5)
            int r4 = com.google.android.gms.internal.gtm.zzxy.zzc(r10, r5)
            if (r3 != r4) goto L_0x01b5
            goto L_0x01b6
        L_0x0136:
            boolean r3 = r8.zzO(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            long r3 = com.google.android.gms.internal.gtm.zzxy.zzd(r9, r5)
            long r5 = com.google.android.gms.internal.gtm.zzxy.zzd(r10, r5)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x01b5
            goto L_0x01b6
        L_0x014a:
            boolean r3 = r8.zzO(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            int r3 = com.google.android.gms.internal.gtm.zzxy.zzc(r9, r5)
            int r4 = com.google.android.gms.internal.gtm.zzxy.zzc(r10, r5)
            if (r3 != r4) goto L_0x01b5
            goto L_0x01b6
        L_0x015b:
            boolean r3 = r8.zzO(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            long r3 = com.google.android.gms.internal.gtm.zzxy.zzd(r9, r5)
            long r5 = com.google.android.gms.internal.gtm.zzxy.zzd(r10, r5)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x01b5
            goto L_0x01b6
        L_0x016e:
            boolean r3 = r8.zzO(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            long r3 = com.google.android.gms.internal.gtm.zzxy.zzd(r9, r5)
            long r5 = com.google.android.gms.internal.gtm.zzxy.zzd(r10, r5)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x01b5
            goto L_0x01b6
        L_0x0181:
            boolean r3 = r8.zzO(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            float r3 = com.google.android.gms.internal.gtm.zzxy.zzb(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            float r4 = com.google.android.gms.internal.gtm.zzxy.zzb(r10, r5)
            int r4 = java.lang.Float.floatToIntBits(r4)
            if (r3 != r4) goto L_0x01b5
            goto L_0x01b6
        L_0x019a:
            boolean r3 = r8.zzO(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            double r3 = com.google.android.gms.internal.gtm.zzxy.zza(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            double r5 = com.google.android.gms.internal.gtm.zzxy.zza(r10, r5)
            long r5 = java.lang.Double.doubleToLongBits(r5)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x01b5
            goto L_0x01b6
        L_0x01b5:
            return r1
        L_0x01b6:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x01ba:
            com.google.android.gms.internal.gtm.zzxo<?, ?> r0 = r8.zzo
            java.lang.Object r0 = r0.zzd(r9)
            com.google.android.gms.internal.gtm.zzxo<?, ?> r2 = r8.zzo
            java.lang.Object r2 = r2.zzd(r10)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01cd
            return r1
        L_0x01cd:
            boolean r0 = r8.zzh
            if (r0 == 0) goto L_0x01e2
            com.google.android.gms.internal.gtm.zzuk<?> r0 = r8.zzp
            com.google.android.gms.internal.gtm.zzuo r9 = r0.zzb(r9)
            com.google.android.gms.internal.gtm.zzuk<?> r0 = r8.zzp
            com.google.android.gms.internal.gtm.zzuo r10 = r0.zzb(r10)
            boolean r9 = r9.equals(r10)
            return r9
        L_0x01e2:
            r9 = 1
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzwn.zzj(java.lang.Object, java.lang.Object):boolean");
    }

    public final boolean zzk(T t2) {
        int i2;
        int i3;
        T t3 = t2;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (i6 < this.zzl) {
            int i7 = this.zzk[i6];
            int i8 = this.zzc[i7];
            int zzC = zzC(i7);
            int i9 = this.zzc[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i4) {
                if (i10 != 1048575) {
                    i5 = zzb.getInt(t3, (long) i10);
                }
                i2 = i5;
                i3 = i10;
            } else {
                i3 = i4;
                i2 = i5;
            }
            if ((268435456 & zzC) != 0 && !zzR(t2, i7, i3, i2, i11)) {
                return false;
            }
            int zzB = zzB(zzC);
            if (zzB != 9 && zzB != 17) {
                if (zzB != 27) {
                    if (zzB == 60 || zzB == 68) {
                        if (zzT(t3, i8, i7) && !zzS(t3, zzC, zzF(i7))) {
                            return false;
                        }
                    } else if (zzB != 49) {
                        if (zzB == 50 && !((zzwe) zzxy.zzf(t3, (long) (zzC & 1048575))).isEmpty()) {
                            zzwd zzwd = (zzwd) zzH(i7);
                            throw null;
                        }
                    }
                }
                List list = (List) zzxy.zzf(t3, (long) (zzC & 1048575));
                if (!list.isEmpty()) {
                    zzwx zzF = zzF(i7);
                    for (int i12 = 0; i12 < list.size(); i12++) {
                        if (!zzF.zzk(list.get(i12))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zzR(t2, i7, i3, i2, i11) && !zzS(t3, zzC, zzF(i7))) {
                return false;
            }
            i6++;
            i4 = i3;
            i5 = i2;
        }
        return !this.zzh || this.zzp.zzb(t3).zzk();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x037b, code lost:
        r14.zzq(r7, com.google.android.gms.internal.gtm.zzxy.zzf(r13, (long) (r6 & 1048575)), zzF(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0396, code lost:
        r14.zzD(r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x03a7, code lost:
        r14.zzB(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x03b8, code lost:
        r14.zzz(r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x03c9, code lost:
        r14.zzx(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x03da, code lost:
        r14.zzi(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x03eb, code lost:
        r14.zzI(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x03f6, code lost:
        r14.zzd(r7, (com.google.android.gms.internal.gtm.zztd) com.google.android.gms.internal.gtm.zzxy.zzf(r13, (long) (r6 & 1048575)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0409, code lost:
        r14.zzv(r7, com.google.android.gms.internal.gtm.zzxy.zzf(r13, (long) (r6 & 1048575)), zzF(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x041e, code lost:
        zzX(r7, com.google.android.gms.internal.gtm.zzxy.zzf(r13, (long) (r6 & 1048575)), r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0435, code lost:
        r14.zzb(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0446, code lost:
        r14.zzk(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0456, code lost:
        r14.zzm(r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0466, code lost:
        r14.zzr(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0476, code lost:
        r14.zzK(r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0486, code lost:
        r14.zzt(r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x0496, code lost:
        r14.zzo(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x04a6, code lost:
        r14.zzf(r7, r8);
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x04af  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzn(T r13, com.google.android.gms.internal.gtm.zztp r14) throws java.io.IOException {
        /*
            r12 = this;
            boolean r0 = r12.zzj
            if (r0 == 0) goto L_0x04cd
            boolean r0 = r12.zzh
            r1 = 0
            if (r0 == 0) goto L_0x0022
            com.google.android.gms.internal.gtm.zzuk<?> r0 = r12.zzp
            com.google.android.gms.internal.gtm.zzuo r0 = r0.zzb(r13)
            com.google.android.gms.internal.gtm.zzxk<T, java.lang.Object> r2 = r0.zza
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0022
            java.util.Iterator r0 = r0.zzf()
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0024
        L_0x0022:
            r0 = r1
            r2 = r0
        L_0x0024:
            int[] r3 = r12.zzc
            int r3 = r3.length
            r4 = 0
            r5 = 0
        L_0x0029:
            if (r5 >= r3) goto L_0x04ad
            int r6 = r12.zzC(r5)
            int[] r7 = r12.zzc
            r7 = r7[r5]
        L_0x0033:
            if (r2 == 0) goto L_0x0051
            com.google.android.gms.internal.gtm.zzuk<?> r8 = r12.zzp
            int r8 = r8.zza(r2)
            if (r8 > r7) goto L_0x0051
            com.google.android.gms.internal.gtm.zzuk<?> r8 = r12.zzp
            r8.zzj(r14, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x004f
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0033
        L_0x004f:
            r2 = r1
            goto L_0x0033
        L_0x0051:
            int r8 = zzB(r6)
            r9 = 1
            r10 = 1048575(0xfffff, float:1.469367E-39)
            switch(r8) {
                case 0: goto L_0x049a;
                case 1: goto L_0x048a;
                case 2: goto L_0x047a;
                case 3: goto L_0x046a;
                case 4: goto L_0x045a;
                case 5: goto L_0x044a;
                case 6: goto L_0x043a;
                case 7: goto L_0x0429;
                case 8: goto L_0x0418;
                case 9: goto L_0x0403;
                case 10: goto L_0x03f0;
                case 11: goto L_0x03df;
                case 12: goto L_0x03ce;
                case 13: goto L_0x03bd;
                case 14: goto L_0x03ac;
                case 15: goto L_0x039b;
                case 16: goto L_0x038a;
                case 17: goto L_0x0375;
                case 18: goto L_0x0364;
                case 19: goto L_0x0353;
                case 20: goto L_0x0342;
                case 21: goto L_0x0331;
                case 22: goto L_0x0320;
                case 23: goto L_0x030f;
                case 24: goto L_0x02fe;
                case 25: goto L_0x02ed;
                case 26: goto L_0x02dc;
                case 27: goto L_0x02c7;
                case 28: goto L_0x02b6;
                case 29: goto L_0x02a5;
                case 30: goto L_0x0294;
                case 31: goto L_0x0283;
                case 32: goto L_0x0272;
                case 33: goto L_0x0261;
                case 34: goto L_0x0250;
                case 35: goto L_0x023f;
                case 36: goto L_0x022e;
                case 37: goto L_0x021d;
                case 38: goto L_0x020c;
                case 39: goto L_0x01fb;
                case 40: goto L_0x01ea;
                case 41: goto L_0x01d9;
                case 42: goto L_0x01c8;
                case 43: goto L_0x01b7;
                case 44: goto L_0x01a6;
                case 45: goto L_0x0195;
                case 46: goto L_0x0184;
                case 47: goto L_0x0173;
                case 48: goto L_0x0162;
                case 49: goto L_0x014d;
                case 50: goto L_0x0142;
                case 51: goto L_0x0134;
                case 52: goto L_0x0126;
                case 53: goto L_0x0118;
                case 54: goto L_0x010a;
                case 55: goto L_0x00fc;
                case 56: goto L_0x00ee;
                case 57: goto L_0x00e0;
                case 58: goto L_0x00d2;
                case 59: goto L_0x00ca;
                case 60: goto L_0x00c2;
                case 61: goto L_0x00ba;
                case 62: goto L_0x00ac;
                case 63: goto L_0x009e;
                case 64: goto L_0x0090;
                case 65: goto L_0x0082;
                case 66: goto L_0x0074;
                case 67: goto L_0x0066;
                case 68: goto L_0x005e;
                default: goto L_0x005c;
            }
        L_0x005c:
            goto L_0x04a9
        L_0x005e:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x04a9
            goto L_0x037b
        L_0x0066:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x04a9
            r6 = r6 & r10
            long r8 = (long) r6
            long r8 = zzD(r13, r8)
            goto L_0x0396
        L_0x0074:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x04a9
            r6 = r6 & r10
            long r8 = (long) r6
            int r6 = zzs(r13, r8)
            goto L_0x03a7
        L_0x0082:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x04a9
            r6 = r6 & r10
            long r8 = (long) r6
            long r8 = zzD(r13, r8)
            goto L_0x03b8
        L_0x0090:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x04a9
            r6 = r6 & r10
            long r8 = (long) r6
            int r6 = zzs(r13, r8)
            goto L_0x03c9
        L_0x009e:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x04a9
            r6 = r6 & r10
            long r8 = (long) r6
            int r6 = zzs(r13, r8)
            goto L_0x03da
        L_0x00ac:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x04a9
            r6 = r6 & r10
            long r8 = (long) r6
            int r6 = zzs(r13, r8)
            goto L_0x03eb
        L_0x00ba:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x04a9
            goto L_0x03f6
        L_0x00c2:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x04a9
            goto L_0x0409
        L_0x00ca:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x04a9
            goto L_0x041e
        L_0x00d2:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x04a9
            r6 = r6 & r10
            long r8 = (long) r6
            boolean r6 = zzU(r13, r8)
            goto L_0x0435
        L_0x00e0:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x04a9
            r6 = r6 & r10
            long r8 = (long) r6
            int r6 = zzs(r13, r8)
            goto L_0x0446
        L_0x00ee:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x04a9
            r6 = r6 & r10
            long r8 = (long) r6
            long r8 = zzD(r13, r8)
            goto L_0x0456
        L_0x00fc:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x04a9
            r6 = r6 & r10
            long r8 = (long) r6
            int r6 = zzs(r13, r8)
            goto L_0x0466
        L_0x010a:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x04a9
            r6 = r6 & r10
            long r8 = (long) r6
            long r8 = zzD(r13, r8)
            goto L_0x0476
        L_0x0118:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x04a9
            r6 = r6 & r10
            long r8 = (long) r6
            long r8 = zzD(r13, r8)
            goto L_0x0486
        L_0x0126:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x04a9
            r6 = r6 & r10
            long r8 = (long) r6
            float r6 = zzp(r13, r8)
            goto L_0x0496
        L_0x0134:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x04a9
            r6 = r6 & r10
            long r8 = (long) r6
            double r8 = zzo(r13, r8)
            goto L_0x04a6
        L_0x0142:
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            r12.zzW(r14, r7, r6, r5)
            goto L_0x04a9
        L_0x014d:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwx r8 = r12.zzF(r5)
            com.google.android.gms.internal.gtm.zzwz.zzQ(r7, r6, r14, r8)
            goto L_0x04a9
        L_0x0162:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r10 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzX(r7, r6, r14, r9)
            goto L_0x04a9
        L_0x0173:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r10 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzW(r7, r6, r14, r9)
            goto L_0x04a9
        L_0x0184:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r10 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzV(r7, r6, r14, r9)
            goto L_0x04a9
        L_0x0195:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r10 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzU(r7, r6, r14, r9)
            goto L_0x04a9
        L_0x01a6:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r10 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzM(r7, r6, r14, r9)
            goto L_0x04a9
        L_0x01b7:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r10 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzZ(r7, r6, r14, r9)
            goto L_0x04a9
        L_0x01c8:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r10 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzJ(r7, r6, r14, r9)
            goto L_0x04a9
        L_0x01d9:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r10 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzN(r7, r6, r14, r9)
            goto L_0x04a9
        L_0x01ea:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r10 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzO(r7, r6, r14, r9)
            goto L_0x04a9
        L_0x01fb:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r10 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzR(r7, r6, r14, r9)
            goto L_0x04a9
        L_0x020c:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r10 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzaa(r7, r6, r14, r9)
            goto L_0x04a9
        L_0x021d:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r10 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzS(r7, r6, r14, r9)
            goto L_0x04a9
        L_0x022e:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r10 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzP(r7, r6, r14, r9)
            goto L_0x04a9
        L_0x023f:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r10 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzL(r7, r6, r14, r9)
            goto L_0x04a9
        L_0x0250:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzX(r7, r6, r14, r4)
            goto L_0x04a9
        L_0x0261:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzW(r7, r6, r14, r4)
            goto L_0x04a9
        L_0x0272:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzV(r7, r6, r14, r4)
            goto L_0x04a9
        L_0x0283:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzU(r7, r6, r14, r4)
            goto L_0x04a9
        L_0x0294:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzM(r7, r6, r14, r4)
            goto L_0x04a9
        L_0x02a5:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzZ(r7, r6, r14, r4)
            goto L_0x04a9
        L_0x02b6:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzK(r7, r6, r14)
            goto L_0x04a9
        L_0x02c7:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwx r8 = r12.zzF(r5)
            com.google.android.gms.internal.gtm.zzwz.zzT(r7, r6, r14, r8)
            goto L_0x04a9
        L_0x02dc:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzY(r7, r6, r14)
            goto L_0x04a9
        L_0x02ed:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzJ(r7, r6, r14, r4)
            goto L_0x04a9
        L_0x02fe:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzN(r7, r6, r14, r4)
            goto L_0x04a9
        L_0x030f:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzO(r7, r6, r14, r4)
            goto L_0x04a9
        L_0x0320:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzR(r7, r6, r14, r4)
            goto L_0x04a9
        L_0x0331:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzaa(r7, r6, r14, r4)
            goto L_0x04a9
        L_0x0342:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzS(r7, r6, r14, r4)
            goto L_0x04a9
        L_0x0353:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzP(r7, r6, r14, r4)
            goto L_0x04a9
        L_0x0364:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzL(r7, r6, r14, r4)
            goto L_0x04a9
        L_0x0375:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x04a9
        L_0x037b:
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            com.google.android.gms.internal.gtm.zzwx r8 = r12.zzF(r5)
            r14.zzq(r7, r6, r8)
            goto L_0x04a9
        L_0x038a:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x04a9
            r6 = r6 & r10
            long r8 = (long) r6
            long r8 = com.google.android.gms.internal.gtm.zzxy.zzd(r13, r8)
        L_0x0396:
            r14.zzD(r7, r8)
            goto L_0x04a9
        L_0x039b:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x04a9
            r6 = r6 & r10
            long r8 = (long) r6
            int r6 = com.google.android.gms.internal.gtm.zzxy.zzc(r13, r8)
        L_0x03a7:
            r14.zzB(r7, r6)
            goto L_0x04a9
        L_0x03ac:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x04a9
            r6 = r6 & r10
            long r8 = (long) r6
            long r8 = com.google.android.gms.internal.gtm.zzxy.zzd(r13, r8)
        L_0x03b8:
            r14.zzz(r7, r8)
            goto L_0x04a9
        L_0x03bd:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x04a9
            r6 = r6 & r10
            long r8 = (long) r6
            int r6 = com.google.android.gms.internal.gtm.zzxy.zzc(r13, r8)
        L_0x03c9:
            r14.zzx(r7, r6)
            goto L_0x04a9
        L_0x03ce:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x04a9
            r6 = r6 & r10
            long r8 = (long) r6
            int r6 = com.google.android.gms.internal.gtm.zzxy.zzc(r13, r8)
        L_0x03da:
            r14.zzi(r7, r6)
            goto L_0x04a9
        L_0x03df:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x04a9
            r6 = r6 & r10
            long r8 = (long) r6
            int r6 = com.google.android.gms.internal.gtm.zzxy.zzc(r13, r8)
        L_0x03eb:
            r14.zzI(r7, r6)
            goto L_0x04a9
        L_0x03f0:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x04a9
        L_0x03f6:
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            com.google.android.gms.internal.gtm.zztd r6 = (com.google.android.gms.internal.gtm.zztd) r6
            r14.zzd(r7, r6)
            goto L_0x04a9
        L_0x0403:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x04a9
        L_0x0409:
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            com.google.android.gms.internal.gtm.zzwx r8 = r12.zzF(r5)
            r14.zzv(r7, r6, r8)
            goto L_0x04a9
        L_0x0418:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x04a9
        L_0x041e:
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            zzX(r7, r6, r14)
            goto L_0x04a9
        L_0x0429:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x04a9
            r6 = r6 & r10
            long r8 = (long) r6
            boolean r6 = com.google.android.gms.internal.gtm.zzxy.zzw(r13, r8)
        L_0x0435:
            r14.zzb(r7, r6)
            goto L_0x04a9
        L_0x043a:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x04a9
            r6 = r6 & r10
            long r8 = (long) r6
            int r6 = com.google.android.gms.internal.gtm.zzxy.zzc(r13, r8)
        L_0x0446:
            r14.zzk(r7, r6)
            goto L_0x04a9
        L_0x044a:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x04a9
            r6 = r6 & r10
            long r8 = (long) r6
            long r8 = com.google.android.gms.internal.gtm.zzxy.zzd(r13, r8)
        L_0x0456:
            r14.zzm(r7, r8)
            goto L_0x04a9
        L_0x045a:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x04a9
            r6 = r6 & r10
            long r8 = (long) r6
            int r6 = com.google.android.gms.internal.gtm.zzxy.zzc(r13, r8)
        L_0x0466:
            r14.zzr(r7, r6)
            goto L_0x04a9
        L_0x046a:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x04a9
            r6 = r6 & r10
            long r8 = (long) r6
            long r8 = com.google.android.gms.internal.gtm.zzxy.zzd(r13, r8)
        L_0x0476:
            r14.zzK(r7, r8)
            goto L_0x04a9
        L_0x047a:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x04a9
            r6 = r6 & r10
            long r8 = (long) r6
            long r8 = com.google.android.gms.internal.gtm.zzxy.zzd(r13, r8)
        L_0x0486:
            r14.zzt(r7, r8)
            goto L_0x04a9
        L_0x048a:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x04a9
            r6 = r6 & r10
            long r8 = (long) r6
            float r6 = com.google.android.gms.internal.gtm.zzxy.zzb(r13, r8)
        L_0x0496:
            r14.zzo(r7, r6)
            goto L_0x04a9
        L_0x049a:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x04a9
            r6 = r6 & r10
            long r8 = (long) r6
            double r8 = com.google.android.gms.internal.gtm.zzxy.zza(r13, r8)
        L_0x04a6:
            r14.zzf(r7, r8)
        L_0x04a9:
            int r5 = r5 + 3
            goto L_0x0029
        L_0x04ad:
            if (r2 == 0) goto L_0x04c3
            com.google.android.gms.internal.gtm.zzuk<?> r3 = r12.zzp
            r3.zzj(r14, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x04c1
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x04ad
        L_0x04c1:
            r2 = r1
            goto L_0x04ad
        L_0x04c3:
            com.google.android.gms.internal.gtm.zzxo<?, ?> r0 = r12.zzo
            java.lang.Object r13 = r0.zzd(r13)
            r0.zzs(r13, r14)
            return
        L_0x04cd:
            r12.zzV(r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzwn.zzn(java.lang.Object, com.google.android.gms.internal.gtm.zztp):void");
    }
}
