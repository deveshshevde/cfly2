package com.google.android.gms.internal.gtm;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.IOException;
import java.util.List;

final class zztk implements zzww {
    private final zztj zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zztk(zztj zztj) {
        zzvi.zzf(zztj, "input");
        this.zza = zztj;
        zztj.zzc = this;
    }

    private final <T> T zzO(zzwx<T> zzwx, zzuj zzuj) throws IOException {
        int i2 = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            T zze = zzwx.zze();
            zzwx.zzh(zze, this, zzuj);
            zzwx.zzf(zze);
            if (this.zzb == this.zzc) {
                return zze;
            }
            throw zzvk.zzg();
        } finally {
            this.zzc = i2;
        }
    }

    private final <T> T zzU(zzwx<T> zzwx, zzuj zzuj) throws IOException {
        int zzn = ((zzth) this.zza).zzn();
        zztj zztj = this.zza;
        if (zztj.zza < zztj.zzb) {
            int zzb2 = zztj.zzb(zzn);
            T zze = zzwx.zze();
            this.zza.zza++;
            zzwx.zzh(zze, this, zzuj);
            zzwx.zzf(zze);
            this.zza.zzg(0);
            zztj zztj2 = this.zza;
            zztj2.zza--;
            zztj2.zzh(zzb2);
            return zze;
        }
        throw new zzvk("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private final void zzV(int i2) throws IOException {
        if (this.zza.zza() != i2) {
            throw zzvk.zzj();
        }
    }

    private final void zzW(int i2) throws IOException {
        if ((this.zzb & 7) != i2) {
            throw zzvk.zza();
        }
    }

    private static final void zzX(int i2) throws IOException {
        if ((i2 & 3) != 0) {
            throw zzvk.zzg();
        }
    }

    private static final void zzY(int i2) throws IOException {
        if ((i2 & 7) != 0) {
            throw zzvk.zzg();
        }
    }

    public static zztk zzp(zztj zztj) {
        zztk zztk = zztj.zzc;
        return zztk != null ? zztk : new zztk(zztj);
    }

    public final void zzA(List<Double> list) throws IOException {
        int zzc2;
        int zzc3;
        if (list instanceof zzug) {
            zzug zzug = (zzug) list;
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    zzug.zze(Double.longBitsToDouble(((zzth) this.zza).zzo()));
                    if (!this.zza.zzi()) {
                        zzc3 = this.zza.zzc();
                    } else {
                        return;
                    }
                } while (zzc3 == this.zzb);
                this.zzd = zzc3;
            } else if (i2 == 2) {
                int zzn = ((zzth) this.zza).zzn();
                zzY(zzn);
                int zza2 = this.zza.zza() + zzn;
                do {
                    zzug.zze(Double.longBitsToDouble(((zzth) this.zza).zzo()));
                } while (this.zza.zza() < zza2);
            } else {
                throw zzvk.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 1) {
                do {
                    list.add(Double.valueOf(Double.longBitsToDouble(((zzth) this.zza).zzo())));
                    if (!this.zza.zzi()) {
                        zzc2 = this.zza.zzc();
                    } else {
                        return;
                    }
                } while (zzc2 == this.zzb);
                this.zzd = zzc2;
            } else if (i3 == 2) {
                int zzn2 = ((zzth) this.zza).zzn();
                zzY(zzn2);
                int zza3 = this.zza.zza() + zzn2;
                do {
                    list.add(Double.valueOf(Double.longBitsToDouble(((zzth) this.zza).zzo())));
                } while (this.zza.zza() < zza3);
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final void zzB(List<Integer> list) throws IOException {
        int zzc2;
        int zzc3;
        if (list instanceof zzva) {
            zzva zzva = (zzva) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzva.zzh(((zzth) this.zza).zzn());
                    if (!this.zza.zzi()) {
                        zzc3 = this.zza.zzc();
                    } else {
                        return;
                    }
                } while (zzc3 == this.zzb);
                this.zzd = zzc3;
            } else if (i2 == 2) {
                int zza2 = this.zza.zza() + ((zzth) this.zza).zzn();
                do {
                    zzva.zzh(((zzth) this.zza).zzn());
                } while (this.zza.zza() < zza2);
                zzV(zza2);
            } else {
                throw zzvk.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(((zzth) this.zza).zzn()));
                    if (!this.zza.zzi()) {
                        zzc2 = this.zza.zzc();
                    } else {
                        return;
                    }
                } while (zzc2 == this.zzb);
                this.zzd = zzc2;
            } else if (i3 == 2) {
                int zza3 = this.zza.zza() + ((zzth) this.zza).zzn();
                do {
                    list.add(Integer.valueOf(((zzth) this.zza).zzn()));
                } while (this.zza.zza() < zza3);
                zzV(zza3);
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final void zzC(List<Integer> list) throws IOException {
        int zzc2;
        int zzc3;
        if (list instanceof zzva) {
            zzva zzva = (zzva) list;
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzn = ((zzth) this.zza).zzn();
                zzX(zzn);
                int zza2 = this.zza.zza() + zzn;
                do {
                    zzva.zzh(((zzth) this.zza).zzm());
                } while (this.zza.zza() < zza2);
            } else if (i2 == 5) {
                do {
                    zzva.zzh(((zzth) this.zza).zzm());
                    if (!this.zza.zzi()) {
                        zzc3 = this.zza.zzc();
                    } else {
                        return;
                    }
                } while (zzc3 == this.zzb);
                this.zzd = zzc3;
            } else {
                throw zzvk.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                int zzn2 = ((zzth) this.zza).zzn();
                zzX(zzn2);
                int zza3 = this.zza.zza() + zzn2;
                do {
                    list.add(Integer.valueOf(((zzth) this.zza).zzm()));
                } while (this.zza.zza() < zza3);
            } else if (i3 == 5) {
                do {
                    list.add(Integer.valueOf(((zzth) this.zza).zzm()));
                    if (!this.zza.zzi()) {
                        zzc2 = this.zza.zzc();
                    } else {
                        return;
                    }
                } while (zzc2 == this.zzb);
                this.zzd = zzc2;
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final void zzD(List<Long> list) throws IOException {
        int zzc2;
        int zzc3;
        if (list instanceof zzvz) {
            zzvz zzvz = (zzvz) list;
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    zzvz.zzf(((zzth) this.zza).zzo());
                    if (!this.zza.zzi()) {
                        zzc3 = this.zza.zzc();
                    } else {
                        return;
                    }
                } while (zzc3 == this.zzb);
                this.zzd = zzc3;
            } else if (i2 == 2) {
                int zzn = ((zzth) this.zza).zzn();
                zzY(zzn);
                int zza2 = this.zza.zza() + zzn;
                do {
                    zzvz.zzf(((zzth) this.zza).zzo());
                } while (this.zza.zza() < zza2);
            } else {
                throw zzvk.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 1) {
                do {
                    list.add(Long.valueOf(((zzth) this.zza).zzo()));
                    if (!this.zza.zzi()) {
                        zzc2 = this.zza.zzc();
                    } else {
                        return;
                    }
                } while (zzc2 == this.zzb);
                this.zzd = zzc2;
            } else if (i3 == 2) {
                int zzn2 = ((zzth) this.zza).zzn();
                zzY(zzn2);
                int zza3 = this.zza.zza() + zzn2;
                do {
                    list.add(Long.valueOf(((zzth) this.zza).zzo()));
                } while (this.zza.zza() < zza3);
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final void zzE(List<Float> list) throws IOException {
        int zzc2;
        int zzc3;
        if (list instanceof zzuq) {
            zzuq zzuq = (zzuq) list;
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzn = ((zzth) this.zza).zzn();
                zzX(zzn);
                int zza2 = this.zza.zza() + zzn;
                do {
                    zzuq.zze(Float.intBitsToFloat(((zzth) this.zza).zzm()));
                } while (this.zza.zza() < zza2);
            } else if (i2 == 5) {
                do {
                    zzuq.zze(Float.intBitsToFloat(((zzth) this.zza).zzm()));
                    if (!this.zza.zzi()) {
                        zzc3 = this.zza.zzc();
                    } else {
                        return;
                    }
                } while (zzc3 == this.zzb);
                this.zzd = zzc3;
            } else {
                throw zzvk.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                int zzn2 = ((zzth) this.zza).zzn();
                zzX(zzn2);
                int zza3 = this.zza.zza() + zzn2;
                do {
                    list.add(Float.valueOf(Float.intBitsToFloat(((zzth) this.zza).zzm())));
                } while (this.zza.zza() < zza3);
            } else if (i3 == 5) {
                do {
                    list.add(Float.valueOf(Float.intBitsToFloat(((zzth) this.zza).zzm())));
                    if (!this.zza.zzi()) {
                        zzc2 = this.zza.zzc();
                    } else {
                        return;
                    }
                } while (zzc2 == this.zzb);
                this.zzd = zzc2;
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final <T> void zzF(List<T> list, zzwx<T> zzwx, zzuj zzuj) throws IOException {
        int zzc2;
        int i2 = this.zzb;
        if ((i2 & 7) == 3) {
            do {
                list.add(zzO(zzwx, zzuj));
                if (!this.zza.zzi() && this.zzd == 0) {
                    zzc2 = this.zza.zzc();
                } else {
                    return;
                }
            } while (zzc2 == i2);
            this.zzd = zzc2;
            return;
        }
        throw zzvk.zza();
    }

    public final void zzG(List<Integer> list) throws IOException {
        int zzc2;
        int zzc3;
        if (list instanceof zzva) {
            zzva zzva = (zzva) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzva.zzh(((zzth) this.zza).zzn());
                    if (!this.zza.zzi()) {
                        zzc3 = this.zza.zzc();
                    } else {
                        return;
                    }
                } while (zzc3 == this.zzb);
                this.zzd = zzc3;
            } else if (i2 == 2) {
                int zza2 = this.zza.zza() + ((zzth) this.zza).zzn();
                do {
                    zzva.zzh(((zzth) this.zza).zzn());
                } while (this.zza.zza() < zza2);
                zzV(zza2);
            } else {
                throw zzvk.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(((zzth) this.zza).zzn()));
                    if (!this.zza.zzi()) {
                        zzc2 = this.zza.zzc();
                    } else {
                        return;
                    }
                } while (zzc2 == this.zzb);
                this.zzd = zzc2;
            } else if (i3 == 2) {
                int zza3 = this.zza.zza() + ((zzth) this.zza).zzn();
                do {
                    list.add(Integer.valueOf(((zzth) this.zza).zzn()));
                } while (this.zza.zza() < zza3);
                zzV(zza3);
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final void zzH(List<Long> list) throws IOException {
        int zzc2;
        int zzc3;
        if (list instanceof zzvz) {
            zzvz zzvz = (zzvz) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzvz.zzf(((zzth) this.zza).zzp());
                    if (!this.zza.zzi()) {
                        zzc3 = this.zza.zzc();
                    } else {
                        return;
                    }
                } while (zzc3 == this.zzb);
                this.zzd = zzc3;
            } else if (i2 == 2) {
                int zza2 = this.zza.zza() + ((zzth) this.zza).zzn();
                do {
                    zzvz.zzf(((zzth) this.zza).zzp());
                } while (this.zza.zza() < zza2);
                zzV(zza2);
            } else {
                throw zzvk.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(((zzth) this.zza).zzp()));
                    if (!this.zza.zzi()) {
                        zzc2 = this.zza.zzc();
                    } else {
                        return;
                    }
                } while (zzc2 == this.zzb);
                this.zzd = zzc2;
            } else if (i3 == 2) {
                int zza3 = this.zza.zza() + ((zzth) this.zza).zzn();
                do {
                    list.add(Long.valueOf(((zzth) this.zza).zzp()));
                } while (this.zza.zza() < zza3);
                zzV(zza3);
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final <T> void zzI(List<T> list, zzwx<T> zzwx, zzuj zzuj) throws IOException {
        int zzc2;
        int i2 = this.zzb;
        if ((i2 & 7) == 2) {
            do {
                list.add(zzU(zzwx, zzuj));
                if (!this.zza.zzi() && this.zzd == 0) {
                    zzc2 = this.zza.zzc();
                } else {
                    return;
                }
            } while (zzc2 == i2);
            this.zzd = zzc2;
            return;
        }
        throw zzvk.zza();
    }

    public final void zzJ(List<Integer> list) throws IOException {
        int zzc2;
        int zzc3;
        if (list instanceof zzva) {
            zzva zzva = (zzva) list;
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzn = ((zzth) this.zza).zzn();
                zzX(zzn);
                int zza2 = this.zza.zza() + zzn;
                do {
                    zzva.zzh(((zzth) this.zza).zzm());
                } while (this.zza.zza() < zza2);
            } else if (i2 == 5) {
                do {
                    zzva.zzh(((zzth) this.zza).zzm());
                    if (!this.zza.zzi()) {
                        zzc3 = this.zza.zzc();
                    } else {
                        return;
                    }
                } while (zzc3 == this.zzb);
                this.zzd = zzc3;
            } else {
                throw zzvk.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                int zzn2 = ((zzth) this.zza).zzn();
                zzX(zzn2);
                int zza3 = this.zza.zza() + zzn2;
                do {
                    list.add(Integer.valueOf(((zzth) this.zza).zzm()));
                } while (this.zza.zza() < zza3);
            } else if (i3 == 5) {
                do {
                    list.add(Integer.valueOf(((zzth) this.zza).zzm()));
                    if (!this.zza.zzi()) {
                        zzc2 = this.zza.zzc();
                    } else {
                        return;
                    }
                } while (zzc2 == this.zzb);
                this.zzd = zzc2;
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final void zzK(List<Long> list) throws IOException {
        int zzc2;
        int zzc3;
        if (list instanceof zzvz) {
            zzvz zzvz = (zzvz) list;
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    zzvz.zzf(((zzth) this.zza).zzo());
                    if (!this.zza.zzi()) {
                        zzc3 = this.zza.zzc();
                    } else {
                        return;
                    }
                } while (zzc3 == this.zzb);
                this.zzd = zzc3;
            } else if (i2 == 2) {
                int zzn = ((zzth) this.zza).zzn();
                zzY(zzn);
                int zza2 = this.zza.zza() + zzn;
                do {
                    zzvz.zzf(((zzth) this.zza).zzo());
                } while (this.zza.zza() < zza2);
            } else {
                throw zzvk.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 1) {
                do {
                    list.add(Long.valueOf(((zzth) this.zza).zzo()));
                    if (!this.zza.zzi()) {
                        zzc2 = this.zza.zzc();
                    } else {
                        return;
                    }
                } while (zzc2 == this.zzb);
                this.zzd = zzc2;
            } else if (i3 == 2) {
                int zzn2 = ((zzth) this.zza).zzn();
                zzY(zzn2);
                int zza3 = this.zza.zza() + zzn2;
                do {
                    list.add(Long.valueOf(((zzth) this.zza).zzo()));
                } while (this.zza.zza() < zza3);
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final void zzL(List<Integer> list) throws IOException {
        int zzc2;
        int zzc3;
        if (list instanceof zzva) {
            zzva zzva = (zzva) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzva.zzh(zzth.zzs(((zzth) this.zza).zzn()));
                    if (!this.zza.zzi()) {
                        zzc3 = this.zza.zzc();
                    } else {
                        return;
                    }
                } while (zzc3 == this.zzb);
                this.zzd = zzc3;
            } else if (i2 == 2) {
                int zza2 = this.zza.zza() + ((zzth) this.zza).zzn();
                do {
                    zzva.zzh(zzth.zzs(((zzth) this.zza).zzn()));
                } while (this.zza.zza() < zza2);
                zzV(zza2);
            } else {
                throw zzvk.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(zzth.zzs(((zzth) this.zza).zzn())));
                    if (!this.zza.zzi()) {
                        zzc2 = this.zza.zzc();
                    } else {
                        return;
                    }
                } while (zzc2 == this.zzb);
                this.zzd = zzc2;
            } else if (i3 == 2) {
                int zza3 = this.zza.zza() + ((zzth) this.zza).zzn();
                do {
                    list.add(Integer.valueOf(zzth.zzs(((zzth) this.zza).zzn())));
                } while (this.zza.zza() < zza3);
                zzV(zza3);
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final void zzM(List<Long> list) throws IOException {
        int zzc2;
        int zzc3;
        if (list instanceof zzvz) {
            zzvz zzvz = (zzvz) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzvz.zzf(zzth.zzt(((zzth) this.zza).zzp()));
                    if (!this.zza.zzi()) {
                        zzc3 = this.zza.zzc();
                    } else {
                        return;
                    }
                } while (zzc3 == this.zzb);
                this.zzd = zzc3;
            } else if (i2 == 2) {
                int zza2 = this.zza.zza() + ((zzth) this.zza).zzn();
                do {
                    zzvz.zzf(zzth.zzt(((zzth) this.zza).zzp()));
                } while (this.zza.zza() < zza2);
                zzV(zza2);
            } else {
                throw zzvk.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(zzth.zzt(((zzth) this.zza).zzp())));
                    if (!this.zza.zzi()) {
                        zzc2 = this.zza.zzc();
                    } else {
                        return;
                    }
                } while (zzc2 == this.zzb);
                this.zzd = zzc2;
            } else if (i3 == 2) {
                int zza3 = this.zza.zza() + ((zzth) this.zza).zzn();
                do {
                    list.add(Long.valueOf(zzth.zzt(((zzth) this.zza).zzp())));
                } while (this.zza.zza() < zza3);
                zzV(zza3);
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final void zzN(List<String> list) throws IOException {
        zzw(list, false);
    }

    public final void zzP(List<String> list) throws IOException {
        zzw(list, true);
    }

    public final void zzQ(List<Integer> list) throws IOException {
        int zzc2;
        int zzc3;
        if (list instanceof zzva) {
            zzva zzva = (zzva) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzva.zzh(((zzth) this.zza).zzn());
                    if (!this.zza.zzi()) {
                        zzc3 = this.zza.zzc();
                    } else {
                        return;
                    }
                } while (zzc3 == this.zzb);
                this.zzd = zzc3;
            } else if (i2 == 2) {
                int zza2 = this.zza.zza() + ((zzth) this.zza).zzn();
                do {
                    zzva.zzh(((zzth) this.zza).zzn());
                } while (this.zza.zza() < zza2);
                zzV(zza2);
            } else {
                throw zzvk.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(((zzth) this.zza).zzn()));
                    if (!this.zza.zzi()) {
                        zzc2 = this.zza.zzc();
                    } else {
                        return;
                    }
                } while (zzc2 == this.zzb);
                this.zzd = zzc2;
            } else if (i3 == 2) {
                int zza3 = this.zza.zza() + ((zzth) this.zza).zzn();
                do {
                    list.add(Integer.valueOf(((zzth) this.zza).zzn()));
                } while (this.zza.zza() < zza3);
                zzV(zza3);
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final void zzR(List<Long> list) throws IOException {
        int zzc2;
        int zzc3;
        if (list instanceof zzvz) {
            zzvz zzvz = (zzvz) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzvz.zzf(((zzth) this.zza).zzp());
                    if (!this.zza.zzi()) {
                        zzc3 = this.zza.zzc();
                    } else {
                        return;
                    }
                } while (zzc3 == this.zzb);
                this.zzd = zzc3;
            } else if (i2 == 2) {
                int zza2 = this.zza.zza() + ((zzth) this.zza).zzn();
                do {
                    zzvz.zzf(((zzth) this.zza).zzp());
                } while (this.zza.zza() < zza2);
                zzV(zza2);
            } else {
                throw zzvk.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(((zzth) this.zza).zzp()));
                    if (!this.zza.zzi()) {
                        zzc2 = this.zza.zzc();
                    } else {
                        return;
                    }
                } while (zzc2 == this.zzb);
                this.zzd = zzc2;
            } else if (i3 == 2) {
                int zza3 = this.zza.zza() + ((zzth) this.zza).zzn();
                do {
                    list.add(Long.valueOf(((zzth) this.zza).zzp()));
                } while (this.zza.zza() < zza3);
                zzV(zza3);
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final boolean zzS() throws IOException {
        zzW(0);
        return this.zza.zzj();
    }

    public final boolean zzT() throws IOException {
        int i2;
        if (this.zza.zzi() || (i2 = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zzk(i2);
    }

    public final double zza() throws IOException {
        zzW(1);
        return Double.longBitsToDouble(((zzth) this.zza).zzo());
    }

    public final float zzb() throws IOException {
        zzW(5);
        return Float.intBitsToFloat(((zzth) this.zza).zzm());
    }

    public final int zzc() throws IOException {
        int i2 = this.zzd;
        if (i2 != 0) {
            this.zzb = i2;
            this.zzd = 0;
        } else {
            i2 = this.zza.zzc();
            this.zzb = i2;
        }
        return (i2 == 0 || i2 == this.zzc) ? SubsamplingScaleImageView.TILE_SIZE_AUTO : i2 >>> 3;
    }

    public final int zzd() {
        return this.zzb;
    }

    public final int zze() throws IOException {
        zzW(0);
        return ((zzth) this.zza).zzn();
    }

    public final int zzf() throws IOException {
        zzW(5);
        return ((zzth) this.zza).zzm();
    }

    public final int zzg() throws IOException {
        zzW(0);
        return ((zzth) this.zza).zzn();
    }

    public final int zzh() throws IOException {
        zzW(5);
        return ((zzth) this.zza).zzm();
    }

    public final int zzi() throws IOException {
        zzW(0);
        return zzth.zzs(((zzth) this.zza).zzn());
    }

    public final int zzj() throws IOException {
        zzW(0);
        return ((zzth) this.zza).zzn();
    }

    public final long zzk() throws IOException {
        zzW(1);
        return ((zzth) this.zza).zzo();
    }

    public final long zzl() throws IOException {
        zzW(0);
        return ((zzth) this.zza).zzp();
    }

    public final long zzm() throws IOException {
        zzW(1);
        return ((zzth) this.zza).zzo();
    }

    public final long zzn() throws IOException {
        zzW(0);
        return zzth.zzt(((zzth) this.zza).zzp());
    }

    public final long zzo() throws IOException {
        zzW(0);
        return ((zzth) this.zza).zzp();
    }

    public final zztd zzq() throws IOException {
        zzW(2);
        return this.zza.zzd();
    }

    public final <T> T zzr(Class<T> cls, zzuj zzuj) throws IOException {
        zzW(3);
        return zzO(zzwt.zza().zzb(cls), zzuj);
    }

    public final <T> T zzs(zzwx<T> zzwx, zzuj zzuj) throws IOException {
        zzW(3);
        return zzO(zzwx, zzuj);
    }

    public final <T> T zzt(Class<T> cls, zzuj zzuj) throws IOException {
        zzW(2);
        return zzU(zzwt.zza().zzb(cls), zzuj);
    }

    public final <T> T zzu(zzwx<T> zzwx, zzuj zzuj) throws IOException {
        zzW(2);
        return zzU(zzwx, zzuj);
    }

    public final String zzv() throws IOException {
        zzW(2);
        return this.zza.zze();
    }

    public final void zzw(List<String> list, boolean z2) throws IOException {
        int zzc2;
        int zzc3;
        if ((this.zzb & 7) != 2) {
            throw zzvk.zza();
        } else if ((list instanceof zzvs) && !z2) {
            zzvs zzvs = (zzvs) list;
            do {
                zzvs.zzi(zzq());
                if (!this.zza.zzi()) {
                    zzc3 = this.zza.zzc();
                } else {
                    return;
                }
            } while (zzc3 == this.zzb);
            this.zzd = zzc3;
        } else {
            do {
                list.add(z2 ? zzx() : zzv());
                if (!this.zza.zzi()) {
                    zzc2 = this.zza.zzc();
                } else {
                    return;
                }
            } while (zzc2 == this.zzb);
            this.zzd = zzc2;
        }
    }

    public final String zzx() throws IOException {
        zzW(2);
        return this.zza.zzf();
    }

    public final void zzy(List<Boolean> list) throws IOException {
        int zzc2;
        int zzc3;
        if (list instanceof zzsr) {
            zzsr zzsr = (zzsr) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzsr.zze(this.zza.zzj());
                    if (!this.zza.zzi()) {
                        zzc3 = this.zza.zzc();
                    } else {
                        return;
                    }
                } while (zzc3 == this.zzb);
                this.zzd = zzc3;
            } else if (i2 == 2) {
                int zza2 = this.zza.zza() + ((zzth) this.zza).zzn();
                do {
                    zzsr.zze(this.zza.zzj());
                } while (this.zza.zza() < zza2);
                zzV(zza2);
            } else {
                throw zzvk.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zza.zzj()));
                    if (!this.zza.zzi()) {
                        zzc2 = this.zza.zzc();
                    } else {
                        return;
                    }
                } while (zzc2 == this.zzb);
                this.zzd = zzc2;
            } else if (i3 == 2) {
                int zza3 = this.zza.zza() + ((zzth) this.zza).zzn();
                do {
                    list.add(Boolean.valueOf(this.zza.zzj()));
                } while (this.zza.zza() < zza3);
                zzV(zza3);
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final void zzz(List<zztd> list) throws IOException {
        int zzc2;
        if ((this.zzb & 7) == 2) {
            do {
                list.add(zzq());
                if (!this.zza.zzi()) {
                    zzc2 = this.zza.zzc();
                } else {
                    return;
                }
            } while (zzc2 == this.zzb);
            this.zzd = zzc2;
            return;
        }
        throw zzvk.zza();
    }
}
