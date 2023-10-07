package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzwz {
    private static final Class<?> zza;
    private static final zzxo<?, ?> zzb = zzab(false);
    private static final zzxo<?, ?> zzc = zzab(true);
    private static final zzxo<?, ?> zzd = new zzxq();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
    }

    public static zzxo<?, ?> zzA() {
        return zzc;
    }

    public static zzxo<?, ?> zzB() {
        return zzd;
    }

    static <UT, UB> UB zzC(int i2, List<Integer> list, zzvd zzvd, UB ub, zzxo<UT, UB> zzxo) {
        if (zzvd == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                int intValue = list.get(i4).intValue();
                if (zzvd.zza(intValue)) {
                    if (i4 != i3) {
                        list.set(i3, Integer.valueOf(intValue));
                    }
                    i3++;
                } else {
                    ub = zzD(i2, intValue, ub, zzxo);
                }
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
                return ub;
            }
        } else {
            Iterator<Integer> it2 = list.iterator();
            while (it2.hasNext()) {
                int intValue2 = it2.next().intValue();
                if (!zzvd.zza(intValue2)) {
                    ub = zzD(i2, intValue2, ub, zzxo);
                    it2.remove();
                }
            }
        }
        return ub;
    }

    static <UT, UB> UB zzD(int i2, int i3, UB ub, zzxo<UT, UB> zzxo) {
        if (ub == null) {
            ub = zzxo.zzf();
        }
        zzxo.zzl(ub, i2, (long) i3);
        return ub;
    }

    static <T, FT extends zzun<FT>> void zzE(zzuk<FT> zzuk, T t2, T t3) {
        zzuo<FT> zzb2 = zzuk.zzb(t3);
        if (!zzb2.zza.isEmpty()) {
            zzuk.zzc(t2).zzh(zzb2);
        }
    }

    static <T, UT, UB> void zzF(zzxo<UT, UB> zzxo, T t2, T t3) {
        zzxo.zzo(t2, zzxo.zze(zzxo.zzd(t2), zzxo.zzd(t3)));
    }

    public static void zzG(Class<?> cls) {
        Class<?> cls2;
        if (!zzuz.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    static boolean zzH(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static <T> void zzI(zzwf zzwf, T t2, T t3, long j2) {
        zzxy.zzs(t2, j2, zzwf.zzc(zzxy.zzf(t2, j2), zzxy.zzf(t3, j2)));
    }

    public static void zzJ(int i2, List<Boolean> list, zztp zztp, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zztp.zzc(i2, list, z2);
        }
    }

    public static void zzK(int i2, List<zztd> list, zztp zztp) throws IOException {
        if (list != null && !list.isEmpty()) {
            zztp.zze(i2, list);
        }
    }

    public static void zzL(int i2, List<Double> list, zztp zztp, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zztp.zzg(i2, list, z2);
        }
    }

    public static void zzM(int i2, List<Integer> list, zztp zztp, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zztp.zzj(i2, list, z2);
        }
    }

    public static void zzN(int i2, List<Integer> list, zztp zztp, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zztp.zzl(i2, list, z2);
        }
    }

    public static void zzO(int i2, List<Long> list, zztp zztp, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zztp.zzn(i2, list, z2);
        }
    }

    public static void zzP(int i2, List<Float> list, zztp zztp, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zztp.zzp(i2, list, z2);
        }
    }

    public static void zzQ(int i2, List<?> list, zztp zztp, zzwx zzwx) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                zztp.zzq(i2, list.get(i3), zzwx);
            }
        }
    }

    public static void zzR(int i2, List<Integer> list, zztp zztp, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zztp.zzs(i2, list, z2);
        }
    }

    public static void zzS(int i2, List<Long> list, zztp zztp, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zztp.zzu(i2, list, z2);
        }
    }

    public static void zzT(int i2, List<?> list, zztp zztp, zzwx zzwx) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                zztp.zzv(i2, list.get(i3), zzwx);
            }
        }
    }

    public static void zzU(int i2, List<Integer> list, zztp zztp, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zztp.zzy(i2, list, z2);
        }
    }

    public static void zzV(int i2, List<Long> list, zztp zztp, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zztp.zzA(i2, list, z2);
        }
    }

    public static void zzW(int i2, List<Integer> list, zztp zztp, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zztp.zzC(i2, list, z2);
        }
    }

    public static void zzX(int i2, List<Long> list, zztp zztp, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zztp.zzE(i2, list, z2);
        }
    }

    public static void zzY(int i2, List<String> list, zztp zztp) throws IOException {
        if (list != null && !list.isEmpty()) {
            zztp.zzH(i2, list);
        }
    }

    public static void zzZ(int i2, List<Integer> list, zztp zztp, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zztp.zzJ(i2, list, z2);
        }
    }

    static int zza(int i2, List<?> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzto.zzD(i2 << 3) + 1);
    }

    public static void zzaa(int i2, List<Long> list, zztp zztp, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            zztp.zzL(i2, list, z2);
        }
    }

    private static zzxo<?, ?> zzab(boolean z2) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (zzxo) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z2)});
        } catch (Throwable unused2) {
            return null;
        }
    }

    static int zzb(List<?> list) {
        return list.size();
    }

    static int zzc(int i2, List<zztd> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzC = size * zzto.zzC(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            zzC += zzto.zzu(list.get(i3));
        }
        return zzC;
    }

    static int zzd(int i2, List<Integer> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzto.zzC(i2));
    }

    static int zze(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzva) {
            zzva zzva = (zzva) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzto.zzx(zzva.zze(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + zzto.zzx(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    static int zzf(int i2, List<?> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzto.zzD(i2 << 3) + 4);
    }

    static int zzg(List<?> list) {
        return list.size() * 4;
    }

    static int zzh(int i2, List<?> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzto.zzD(i2 << 3) + 8);
    }

    static int zzi(List<?> list) {
        return list.size() * 8;
    }

    static int zzj(int i2, List<zzwk> list, zzwx zzwx) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += zzto.zzv(i2, list.get(i4), zzwx);
        }
        return i3;
    }

    static int zzk(int i2, List<Integer> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzl(list) + (size * zzto.zzC(i2));
    }

    static int zzl(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzva) {
            zzva zzva = (zzva) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzto.zzx(zzva.zze(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + zzto.zzx(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    static int zzm(int i2, List<Long> list, boolean z2) {
        if (list.size() == 0) {
            return 0;
        }
        return zzn(list) + (list.size() * zzto.zzC(i2));
    }

    static int zzn(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzvz) {
            zzvz zzvz = (zzvz) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzto.zzE(zzvz.zze(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + zzto.zzE(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    static int zzo(int i2, Object obj, zzwx zzwx) {
        if (!(obj instanceof zzvq)) {
            return zzto.zzD(i2 << 3) + zzto.zzA((zzwk) obj, zzwx);
        }
        int zzD = zzto.zzD(i2 << 3);
        int zza2 = ((zzvq) obj).zza();
        return zzD + zzto.zzD(zza2) + zza2;
    }

    static int zzp(int i2, List<?> list, zzwx zzwx) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzC = zzto.zzC(i2) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            zzC += obj instanceof zzvq ? zzto.zzy((zzvq) obj) : zzto.zzA((zzwk) obj, zzwx);
        }
        return zzC;
    }

    static int zzq(int i2, List<Integer> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzr(list) + (size * zzto.zzC(i2));
    }

    static int zzr(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzva) {
            zzva zzva = (zzva) list;
            i2 = 0;
            while (i3 < size) {
                int zze = zzva.zze(i3);
                i2 += zzto.zzD((zze >> 31) ^ (zze + zze));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                int intValue = list.get(i3).intValue();
                i4 = i2 + zzto.zzD((intValue >> 31) ^ (intValue + intValue));
                i3++;
            }
        }
        return i2;
    }

    static int zzs(int i2, List<Long> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzt(list) + (size * zzto.zzC(i2));
    }

    static int zzt(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzvz) {
            zzvz zzvz = (zzvz) list;
            i2 = 0;
            while (i3 < size) {
                long zze = zzvz.zze(i3);
                i2 += zzto.zzE((zze >> 63) ^ (zze + zze));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                long longValue = list.get(i3).longValue();
                i4 = i2 + zzto.zzE((longValue >> 63) ^ (longValue + longValue));
                i3++;
            }
        }
        return i2;
    }

    static int zzu(int i2, List<?> list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        int zzC = zzto.zzC(i2) * size;
        if (list instanceof zzvs) {
            zzvs zzvs = (zzvs) list;
            while (i3 < size) {
                Object zzf = zzvs.zzf(i3);
                zzC += zzf instanceof zztd ? zzto.zzu((zztd) zzf) : zzto.zzB((String) zzf);
                i3++;
            }
        } else {
            while (i3 < size) {
                Object obj = list.get(i3);
                zzC += obj instanceof zztd ? zzto.zzu((zztd) obj) : zzto.zzB((String) obj);
                i3++;
            }
        }
        return zzC;
    }

    static int zzv(int i2, List<Integer> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzw(list) + (size * zzto.zzC(i2));
    }

    static int zzw(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzva) {
            zzva zzva = (zzva) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzto.zzD(zzva.zze(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + zzto.zzD(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    static int zzx(int i2, List<Long> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzy(list) + (size * zzto.zzC(i2));
    }

    static int zzy(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzvz) {
            zzvz zzvz = (zzvz) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzto.zzE(zzvz.zze(i3));
                i3++;
            }
        } else {
            int i4 = 0;
            while (i3 < size) {
                i4 = i2 + zzto.zzE(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    public static zzxo<?, ?> zzz() {
        return zzb;
    }
}
