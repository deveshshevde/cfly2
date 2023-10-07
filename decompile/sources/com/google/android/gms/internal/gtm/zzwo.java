package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class zzwo<T> implements zzwx<T> {
    private final zzwk zza;
    private final zzxo<?, ?> zzb;
    private final boolean zzc;
    private final zzuk<?> zzd;

    private zzwo(zzxo<?, ?> zzxo, zzuk<?> zzuk, zzwk zzwk) {
        this.zzb = zzxo;
        this.zzc = zzuk.zzi(zzwk);
        this.zzd = zzuk;
        this.zza = zzwk;
    }

    static <T> zzwo<T> zzc(zzxo<?, ?> zzxo, zzuk<?> zzuk, zzwk zzwk) {
        return new zzwo<>(zzxo, zzuk, zzwk);
    }

    public final int zza(T t2) {
        zzxo<?, ?> zzxo = this.zzb;
        int zzb2 = zzxo.zzb(zzxo.zzd(t2));
        return this.zzc ? zzb2 + this.zzd.zzb(t2).zzb() : zzb2;
    }

    public final int zzb(T t2) {
        int hashCode = this.zzb.zzd(t2).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zzb(t2).zza.hashCode() : hashCode;
    }

    public final T zze() {
        return this.zza.zzao().zzD();
    }

    public final void zzf(T t2) {
        this.zzb.zzm(t2);
        this.zzd.zzf(t2);
    }

    public final void zzg(T t2, T t3) {
        zzwz.zzF(this.zzb, t2, t3);
        if (this.zzc) {
            zzwz.zzE(this.zzd, t2, t3);
        }
    }

    public final void zzh(T t2, zzww zzww, zzuj zzuj) throws IOException {
        boolean z2;
        zzxo<?, ?> zzxo = this.zzb;
        zzuk<?> zzuk = this.zzd;
        Object zzc2 = zzxo.zzc(t2);
        zzuo<?> zzc3 = zzuk.zzc(t2);
        while (zzww.zzc() != Integer.MAX_VALUE) {
            int zzd2 = zzww.zzd();
            if (zzd2 != 11) {
                if ((zzd2 & 7) == 2) {
                    Object zzd3 = zzuk.zzd(zzuj, this.zza, zzd2 >>> 3);
                    if (zzd3 != null) {
                        zzuk.zzg(zzww, zzd3, zzuj, zzc3);
                    } else {
                        z2 = zzxo.zzp(zzc2, zzww);
                    }
                } else {
                    z2 = zzww.zzT();
                }
                if (!z2) {
                    zzxo.zzn(t2, zzc2);
                    return;
                }
            } else {
                int i2 = 0;
                Object obj = null;
                zztd zztd = null;
                while (true) {
                    try {
                        if (zzww.zzc() == Integer.MAX_VALUE) {
                            break;
                        }
                        int zzd4 = zzww.zzd();
                        if (zzd4 == 16) {
                            i2 = zzww.zzj();
                            obj = zzuk.zzd(zzuj, this.zza, i2);
                        } else if (zzd4 == 26) {
                            if (obj != null) {
                                zzuk.zzg(zzww, obj, zzuj, zzc3);
                            } else {
                                zztd = zzww.zzq();
                            }
                        } else if (!zzww.zzT()) {
                            break;
                        }
                    } catch (Throwable th) {
                        zzxo.zzn(t2, zzc2);
                        throw th;
                    }
                }
                if (zzww.zzd() != 12) {
                    throw zzvk.zzb();
                } else if (zztd != null) {
                    if (obj != null) {
                        zzuk.zzh(zztd, obj, zzuj, zzc3);
                    } else {
                        zzxo.zzk(zzc2, i2, zztd);
                    }
                }
            }
        }
        zzxo.zzn(t2, zzc2);
    }

    public final void zzi(T t2, byte[] bArr, int i2, int i3, zzsl zzsl) throws IOException {
        zzuz zzuz = (zzuz) t2;
        zzxp zzxp = zzuz.zzc;
        if (zzxp == zzxp.zzc()) {
            zzxp = zzxp.zze();
            zzuz.zzc = zzxp;
        }
        zzuo<zzuw> zzU = ((zzuv) t2).zzU();
        Object obj = null;
        while (i2 < i3) {
            int zzj = zzsm.zzj(bArr, i2, zzsl);
            int i4 = zzsl.zza;
            if (i4 == 11) {
                int i5 = 0;
                zztd zztd = null;
                while (zzj < i3) {
                    zzj = zzsm.zzj(bArr, zzj, zzsl);
                    int i6 = zzsl.zza;
                    int i7 = i6 & 7;
                    int i8 = i6 >>> 3;
                    if (i8 != 2) {
                        if (i8 == 3) {
                            if (obj != null) {
                                zzux zzux = (zzux) obj;
                                zzj = zzsm.zzd(zzwt.zza().zzb(zzux.zzc.getClass()), bArr, zzj, i3, zzsl);
                                zzU.zzi(zzux.zzd, zzsl.zzc);
                            } else if (i7 == 2) {
                                zzj = zzsm.zza(bArr, zzj, zzsl);
                                zztd = (zztd) zzsl.zzc;
                            }
                        }
                    } else if (i7 == 0) {
                        zzj = zzsm.zzj(bArr, zzj, zzsl);
                        i5 = zzsl.zza;
                        obj = this.zzd.zzd(zzsl.zzd, this.zza, i5);
                    }
                    if (i6 == 12) {
                        break;
                    }
                    zzj = zzsm.zzn(i6, bArr, zzj, i3, zzsl);
                }
                if (zztd != null) {
                    zzxp.zzh((i5 << 3) | 2, zztd);
                }
                i2 = zzj;
            } else if ((i4 & 7) == 2) {
                Object zzd2 = this.zzd.zzd(zzsl.zzd, this.zza, i4 >>> 3);
                if (zzd2 != null) {
                    zzux zzux2 = (zzux) zzd2;
                    i2 = zzsm.zzd(zzwt.zza().zzb(zzux2.zzc.getClass()), bArr, zzj, i3, zzsl);
                    zzU.zzi(zzux2.zzd, zzsl.zzc);
                } else {
                    i2 = zzsm.zzi(i4, bArr, zzj, i3, zzxp, zzsl);
                }
                obj = zzd2;
            } else {
                i2 = zzsm.zzn(i4, bArr, zzj, i3, zzsl);
            }
        }
        if (i2 != i3) {
            throw zzvk.zzg();
        }
    }

    public final boolean zzj(T t2, T t3) {
        if (!this.zzb.zzd(t2).equals(this.zzb.zzd(t3))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zzb(t2).equals(this.zzd.zzb(t3));
        }
        return true;
    }

    public final boolean zzk(T t2) {
        return this.zzd.zzb(t2).zzk();
    }

    public final void zzn(T t2, zztp zztp) throws IOException {
        Iterator<Map.Entry<?, Object>> zzf = this.zzd.zzb(t2).zzf();
        while (zzf.hasNext()) {
            Map.Entry next = zzf.next();
            zzun zzun = (zzun) next.getKey();
            if (zzun.zze() == zzyf.MESSAGE) {
                zzun.zzg();
                zzun.zzf();
                zztp.zzw(zzun.zza(), next instanceof zzvn ? ((zzvn) next).zza().zzb() : next.getValue());
            } else {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
        }
        zzxo<?, ?> zzxo = this.zzb;
        zzxo.zzr(zzxo.zzd(t2), zztp);
    }
}
