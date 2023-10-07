package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.List;

final class zztp {
    private final zzto zza;

    private zztp(zzto zzto) {
        zzvi.zzf(zzto, "output");
        this.zza = zzto;
        zzto.zza = this;
    }

    public static zztp zza(zzto zzto) {
        zztp zztp = zzto.zza;
        return zztp != null ? zztp : new zztp(zzto);
    }

    public final void zzA(int i2, List<Long> list, boolean z2) throws IOException {
        int i3 = 0;
        if (z2) {
            this.zza.zzo(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).longValue();
                i4 += 8;
            }
            this.zza.zzq(i4);
            while (i3 < list.size()) {
                this.zza.zzi(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzh(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void zzB(int i2, int i3) throws IOException {
        this.zza.zzp(i2, (i3 >> 31) ^ (i3 + i3));
    }

    public final void zzC(int i2, List<Integer> list, boolean z2) throws IOException {
        int i3 = 0;
        if (z2) {
            this.zza.zzo(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                int intValue = list.get(i5).intValue();
                i4 += zzto.zzD((intValue >> 31) ^ (intValue + intValue));
            }
            this.zza.zzq(i4);
            while (i3 < list.size()) {
                zzto zzto = this.zza;
                int intValue2 = list.get(i3).intValue();
                zzto.zzq((intValue2 >> 31) ^ (intValue2 + intValue2));
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            zzto zzto2 = this.zza;
            int intValue3 = list.get(i3).intValue();
            zzto2.zzp(i2, (intValue3 >> 31) ^ (intValue3 + intValue3));
            i3++;
        }
    }

    public final void zzD(int i2, long j2) throws IOException {
        this.zza.zzr(i2, (j2 >> 63) ^ (j2 + j2));
    }

    public final void zzE(int i2, List<Long> list, boolean z2) throws IOException {
        int i3 = 0;
        if (z2) {
            this.zza.zzo(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                long longValue = list.get(i5).longValue();
                i4 += zzto.zzE((longValue >> 63) ^ (longValue + longValue));
            }
            this.zza.zzq(i4);
            while (i3 < list.size()) {
                zzto zzto = this.zza;
                long longValue2 = list.get(i3).longValue();
                zzto.zzs((longValue2 >> 63) ^ (longValue2 + longValue2));
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            zzto zzto2 = this.zza;
            long longValue3 = list.get(i3).longValue();
            zzto2.zzr(i2, (longValue3 >> 63) ^ (longValue3 + longValue3));
            i3++;
        }
    }

    public final void zzF(int i2) throws IOException {
        this.zza.zzo(i2, 3);
    }

    public final void zzG(int i2, String str) throws IOException {
        this.zza.zzm(i2, str);
    }

    public final void zzH(int i2, List<String> list) throws IOException {
        int i3 = 0;
        if (list instanceof zzvs) {
            zzvs zzvs = (zzvs) list;
            while (i3 < list.size()) {
                Object zzf = zzvs.zzf(i3);
                if (zzf instanceof String) {
                    this.zza.zzm(i2, (String) zzf);
                } else {
                    this.zza.zze(i2, (zztd) zzf);
                }
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzm(i2, list.get(i3));
            i3++;
        }
    }

    public final void zzI(int i2, int i3) throws IOException {
        this.zza.zzp(i2, i3);
    }

    public final void zzJ(int i2, List<Integer> list, boolean z2) throws IOException {
        int i3 = 0;
        if (z2) {
            this.zza.zzo(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzto.zzD(list.get(i5).intValue());
            }
            this.zza.zzq(i4);
            while (i3 < list.size()) {
                this.zza.zzq(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzp(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void zzK(int i2, long j2) throws IOException {
        this.zza.zzr(i2, j2);
    }

    public final void zzL(int i2, List<Long> list, boolean z2) throws IOException {
        int i3 = 0;
        if (z2) {
            this.zza.zzo(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzto.zzE(list.get(i5).longValue());
            }
            this.zza.zzq(i4);
            while (i3 < list.size()) {
                this.zza.zzs(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzr(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void zzb(int i2, boolean z2) throws IOException {
        this.zza.zzd(i2, z2);
    }

    public final void zzc(int i2, List<Boolean> list, boolean z2) throws IOException {
        int i3 = 0;
        if (z2) {
            this.zza.zzo(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).booleanValue();
                i4++;
            }
            this.zza.zzq(i4);
            while (i3 < list.size()) {
                this.zza.zzb(list.get(i3).booleanValue() ? (byte) 1 : 0);
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzd(i2, list.get(i3).booleanValue());
            i3++;
        }
    }

    public final void zzd(int i2, zztd zztd) throws IOException {
        this.zza.zze(i2, zztd);
    }

    public final void zze(int i2, List<zztd> list) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.zza.zze(i2, list.get(i3));
        }
    }

    public final void zzf(int i2, double d2) throws IOException {
        this.zza.zzh(i2, Double.doubleToRawLongBits(d2));
    }

    public final void zzg(int i2, List<Double> list, boolean z2) throws IOException {
        int i3 = 0;
        if (z2) {
            this.zza.zzo(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).doubleValue();
                i4 += 8;
            }
            this.zza.zzq(i4);
            while (i3 < list.size()) {
                this.zza.zzi(Double.doubleToRawLongBits(list.get(i3).doubleValue()));
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzh(i2, Double.doubleToRawLongBits(list.get(i3).doubleValue()));
            i3++;
        }
    }

    public final void zzh(int i2) throws IOException {
        this.zza.zzo(i2, 4);
    }

    public final void zzi(int i2, int i3) throws IOException {
        this.zza.zzj(i2, i3);
    }

    public final void zzj(int i2, List<Integer> list, boolean z2) throws IOException {
        int i3 = 0;
        if (z2) {
            this.zza.zzo(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzto.zzx(list.get(i5).intValue());
            }
            this.zza.zzq(i4);
            while (i3 < list.size()) {
                this.zza.zzk(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzj(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void zzk(int i2, int i3) throws IOException {
        this.zza.zzf(i2, i3);
    }

    public final void zzl(int i2, List<Integer> list, boolean z2) throws IOException {
        int i3 = 0;
        if (z2) {
            this.zza.zzo(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).intValue();
                i4 += 4;
            }
            this.zza.zzq(i4);
            while (i3 < list.size()) {
                this.zza.zzg(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzf(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void zzm(int i2, long j2) throws IOException {
        this.zza.zzh(i2, j2);
    }

    public final void zzn(int i2, List<Long> list, boolean z2) throws IOException {
        int i3 = 0;
        if (z2) {
            this.zza.zzo(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).longValue();
                i4 += 8;
            }
            this.zza.zzq(i4);
            while (i3 < list.size()) {
                this.zza.zzi(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzh(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void zzo(int i2, float f2) throws IOException {
        this.zza.zzf(i2, Float.floatToRawIntBits(f2));
    }

    public final void zzp(int i2, List<Float> list, boolean z2) throws IOException {
        int i3 = 0;
        if (z2) {
            this.zza.zzo(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).floatValue();
                i4 += 4;
            }
            this.zza.zzq(i4);
            while (i3 < list.size()) {
                this.zza.zzg(Float.floatToRawIntBits(list.get(i3).floatValue()));
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzf(i2, Float.floatToRawIntBits(list.get(i3).floatValue()));
            i3++;
        }
    }

    public final void zzq(int i2, Object obj, zzwx zzwx) throws IOException {
        zzto zzto = this.zza;
        zzto.zzo(i2, 3);
        zzwx.zzn((zzwk) obj, zzto.zza);
        zzto.zzo(i2, 4);
    }

    public final void zzr(int i2, int i3) throws IOException {
        this.zza.zzj(i2, i3);
    }

    public final void zzs(int i2, List<Integer> list, boolean z2) throws IOException {
        int i3 = 0;
        if (z2) {
            this.zza.zzo(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzto.zzx(list.get(i5).intValue());
            }
            this.zza.zzq(i4);
            while (i3 < list.size()) {
                this.zza.zzk(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzj(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void zzt(int i2, long j2) throws IOException {
        this.zza.zzr(i2, j2);
    }

    public final void zzu(int i2, List<Long> list, boolean z2) throws IOException {
        int i3 = 0;
        if (z2) {
            this.zza.zzo(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzto.zzE(list.get(i5).longValue());
            }
            this.zza.zzq(i4);
            while (i3 < list.size()) {
                this.zza.zzs(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzr(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void zzv(int i2, Object obj, zzwx zzwx) throws IOException {
        zzwk zzwk = (zzwk) obj;
        zztl zztl = (zztl) this.zza;
        zztl.zzq((i2 << 3) | 2);
        zzsh zzsh = (zzsh) zzwk;
        int zzQ = zzsh.zzQ();
        if (zzQ == -1) {
            zzQ = zzwx.zza(zzsh);
            zzsh.zzT(zzQ);
        }
        zztl.zzq(zzQ);
        zzwx.zzn(zzwk, zztl.zza);
    }

    public final void zzw(int i2, Object obj) throws IOException {
        if (obj instanceof zztd) {
            zztl zztl = (zztl) this.zza;
            zztl.zzq(11);
            zztl.zzp(2, i2);
            zztl.zze(3, (zztd) obj);
            zztl.zzq(12);
            return;
        }
        zzto zzto = this.zza;
        zzwk zzwk = (zzwk) obj;
        zztl zztl2 = (zztl) zzto;
        zztl2.zzq(11);
        zztl2.zzp(2, i2);
        zztl2.zzq(26);
        zztl2.zzq(zzwk.zzX());
        zzwk.zzaq(zzto);
        zztl2.zzq(12);
    }

    public final void zzx(int i2, int i3) throws IOException {
        this.zza.zzf(i2, i3);
    }

    public final void zzy(int i2, List<Integer> list, boolean z2) throws IOException {
        int i3 = 0;
        if (z2) {
            this.zza.zzo(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).intValue();
                i4 += 4;
            }
            this.zza.zzq(i4);
            while (i3 < list.size()) {
                this.zza.zzg(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzf(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void zzz(int i2, long j2) throws IOException {
        this.zza.zzh(i2, j2);
    }
}
