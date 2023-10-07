package com.google.android.gms.internal.gtm;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

final class zzsn extends zzsp {
    private final byte[] zza;
    private int zzb;
    private int zzc;
    private int zzd;
    private int zze;

    public zzsn(ByteBuffer byteBuffer, boolean z2) {
        super((zzso) null);
        this.zza = byteBuffer.array();
        this.zzb = byteBuffer.arrayOffset() + byteBuffer.position();
        this.zzc = byteBuffer.arrayOffset() + byteBuffer.limit();
    }

    private final byte zzU() throws IOException {
        int i2 = this.zzb;
        if (i2 != this.zzc) {
            byte[] bArr = this.zza;
            this.zzb = i2 + 1;
            return bArr[i2];
        }
        throw zzvk.zzj();
    }

    private final int zzV() throws IOException {
        zzad(4);
        return zzW();
    }

    private final int zzW() {
        int i2 = this.zzb;
        byte[] bArr = this.zza;
        this.zzb = i2 + 4;
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    private final int zzX() throws IOException {
        byte b2;
        int i2 = this.zzb;
        int i3 = this.zzc;
        if (i3 != i2) {
            byte[] bArr = this.zza;
            int i4 = i2 + 1;
            byte b3 = bArr[i2];
            if (b3 >= 0) {
                this.zzb = i4;
                return b3;
            } else if (i3 - i4 < 9) {
                return (int) zzaa();
            } else {
                int i5 = i4 + 1;
                byte b4 = b3 ^ (bArr[i4] << 7);
                if (b4 < 0) {
                    b2 = b4 ^ Byte.MIN_VALUE;
                } else {
                    int i6 = i5 + 1;
                    byte b5 = b4 ^ (bArr[i5] << 14);
                    if (b5 >= 0) {
                        b2 = b5 ^ 16256;
                    } else {
                        i5 = i6 + 1;
                        byte b6 = b5 ^ (bArr[i6] << 21);
                        if (b6 < 0) {
                            b2 = b6 ^ -2080896;
                        } else {
                            i6 = i5 + 1;
                            byte b7 = bArr[i5];
                            b2 = (b6 ^ (b7 << 28)) ^ 266354560;
                            if (b7 < 0) {
                                i5 = i6 + 1;
                                if (bArr[i6] < 0) {
                                    i6 = i5 + 1;
                                    if (bArr[i5] < 0) {
                                        i5 = i6 + 1;
                                        if (bArr[i6] < 0) {
                                            i6 = i5 + 1;
                                            if (bArr[i5] < 0) {
                                                i5 = i6 + 1;
                                                if (bArr[i6] < 0) {
                                                    throw zzvk.zze();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i5 = i6;
                }
                this.zzb = i5;
                return b2;
            }
        } else {
            throw zzvk.zzj();
        }
    }

    private final long zzY() throws IOException {
        zzad(8);
        return zzZ();
    }

    private final long zzZ() {
        int i2 = this.zzb;
        byte[] bArr = this.zza;
        this.zzb = i2 + 8;
        return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
    }

    private final long zzaa() throws IOException {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte zzU = zzU();
            j2 |= ((long) (zzU & Byte.MAX_VALUE)) << i2;
            if ((zzU & 128) == 0) {
                return j2;
            }
        }
        throw zzvk.zze();
    }

    private final <T> T zzab(zzwx<T> zzwx, zzuj zzuj) throws IOException {
        int i2 = this.zze;
        this.zze = ((this.zzd >>> 3) << 3) | 4;
        try {
            T zze2 = zzwx.zze();
            zzwx.zzh(zze2, this, zzuj);
            zzwx.zzf(zze2);
            if (this.zzd == this.zze) {
                return zze2;
            }
            throw zzvk.zzg();
        } finally {
            this.zze = i2;
        }
    }

    private final <T> T zzac(zzwx<T> zzwx, zzuj zzuj) throws IOException {
        int zzX = zzX();
        zzad(zzX);
        int i2 = this.zzc;
        int i3 = this.zzb + zzX;
        this.zzc = i3;
        try {
            T zze2 = zzwx.zze();
            zzwx.zzh(zze2, this, zzuj);
            zzwx.zzf(zze2);
            if (this.zzb == i3) {
                return zze2;
            }
            throw zzvk.zzg();
        } finally {
            this.zzc = i2;
        }
    }

    private final void zzad(int i2) throws IOException {
        if (i2 < 0 || i2 > this.zzc - this.zzb) {
            throw zzvk.zzj();
        }
    }

    private final void zzae(int i2) throws IOException {
        if (this.zzb != i2) {
            throw zzvk.zzj();
        }
    }

    private final void zzaf(int i2) throws IOException {
        if ((this.zzd & 7) != i2) {
            throw zzvk.zza();
        }
    }

    private final void zzag(int i2) throws IOException {
        zzad(i2);
        this.zzb += i2;
    }

    private final void zzah(int i2) throws IOException {
        zzad(i2);
        if ((i2 & 3) != 0) {
            throw zzvk.zzg();
        }
    }

    private final void zzai(int i2) throws IOException {
        zzad(i2);
        if ((i2 & 7) != 0) {
            throw zzvk.zzg();
        }
    }

    private final boolean zzaj() {
        return this.zzb == this.zzc;
    }

    public final void zzA(List<Double> list) throws IOException {
        int i2;
        int i3;
        if (list instanceof zzug) {
            zzug zzug = (zzug) list;
            int i4 = this.zzd & 7;
            if (i4 == 1) {
                do {
                    zzug.zze(zza());
                    if (!zzaj()) {
                        i3 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i3;
            } else if (i4 == 2) {
                int zzX = zzX();
                zzai(zzX);
                int i5 = this.zzb + zzX;
                while (this.zzb < i5) {
                    zzug.zze(Double.longBitsToDouble(zzZ()));
                }
            } else {
                throw zzvk.zza();
            }
        } else {
            int i6 = this.zzd & 7;
            if (i6 == 1) {
                do {
                    list.add(Double.valueOf(zza()));
                    if (!zzaj()) {
                        i2 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i2;
            } else if (i6 == 2) {
                int zzX2 = zzX();
                zzai(zzX2);
                int i7 = this.zzb + zzX2;
                while (this.zzb < i7) {
                    list.add(Double.valueOf(Double.longBitsToDouble(zzZ())));
                }
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final void zzB(List<Integer> list) throws IOException {
        int i2;
        int i3;
        if (list instanceof zzva) {
            zzva zzva = (zzva) list;
            int i4 = this.zzd & 7;
            if (i4 == 0) {
                do {
                    zzva.zzh(zze());
                    if (!zzaj()) {
                        i3 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i3;
            } else if (i4 == 2) {
                int zzX = this.zzb + zzX();
                while (this.zzb < zzX) {
                    zzva.zzh(zzX());
                }
            } else {
                throw zzvk.zza();
            }
        } else {
            int i5 = this.zzd & 7;
            if (i5 == 0) {
                do {
                    list.add(Integer.valueOf(zze()));
                    if (!zzaj()) {
                        i2 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i2;
            } else if (i5 == 2) {
                int zzX2 = this.zzb + zzX();
                while (this.zzb < zzX2) {
                    list.add(Integer.valueOf(zzX()));
                }
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final void zzC(List<Integer> list) throws IOException {
        int i2;
        int i3;
        if (list instanceof zzva) {
            zzva zzva = (zzva) list;
            int i4 = this.zzd & 7;
            if (i4 == 2) {
                int zzX = zzX();
                zzah(zzX);
                int i5 = this.zzb + zzX;
                while (this.zzb < i5) {
                    zzva.zzh(zzW());
                }
            } else if (i4 == 5) {
                do {
                    zzva.zzh(zzf());
                    if (!zzaj()) {
                        i3 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i3;
            } else {
                throw zzvk.zza();
            }
        } else {
            int i6 = this.zzd & 7;
            if (i6 == 2) {
                int zzX2 = zzX();
                zzah(zzX2);
                int i7 = this.zzb + zzX2;
                while (this.zzb < i7) {
                    list.add(Integer.valueOf(zzW()));
                }
            } else if (i6 == 5) {
                do {
                    list.add(Integer.valueOf(zzf()));
                    if (!zzaj()) {
                        i2 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i2;
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final void zzD(List<Long> list) throws IOException {
        int i2;
        int i3;
        if (list instanceof zzvz) {
            zzvz zzvz = (zzvz) list;
            int i4 = this.zzd & 7;
            if (i4 == 1) {
                do {
                    zzvz.zzf(zzk());
                    if (!zzaj()) {
                        i3 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i3;
            } else if (i4 == 2) {
                int zzX = zzX();
                zzai(zzX);
                int i5 = this.zzb + zzX;
                while (this.zzb < i5) {
                    zzvz.zzf(zzZ());
                }
            } else {
                throw zzvk.zza();
            }
        } else {
            int i6 = this.zzd & 7;
            if (i6 == 1) {
                do {
                    list.add(Long.valueOf(zzk()));
                    if (!zzaj()) {
                        i2 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i2;
            } else if (i6 == 2) {
                int zzX2 = zzX();
                zzai(zzX2);
                int i7 = this.zzb + zzX2;
                while (this.zzb < i7) {
                    list.add(Long.valueOf(zzZ()));
                }
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final void zzE(List<Float> list) throws IOException {
        int i2;
        int i3;
        if (list instanceof zzuq) {
            zzuq zzuq = (zzuq) list;
            int i4 = this.zzd & 7;
            if (i4 == 2) {
                int zzX = zzX();
                zzah(zzX);
                int i5 = this.zzb + zzX;
                while (this.zzb < i5) {
                    zzuq.zze(Float.intBitsToFloat(zzW()));
                }
            } else if (i4 == 5) {
                do {
                    zzuq.zze(zzb());
                    if (!zzaj()) {
                        i3 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i3;
            } else {
                throw zzvk.zza();
            }
        } else {
            int i6 = this.zzd & 7;
            if (i6 == 2) {
                int zzX2 = zzX();
                zzah(zzX2);
                int i7 = this.zzb + zzX2;
                while (this.zzb < i7) {
                    list.add(Float.valueOf(Float.intBitsToFloat(zzW())));
                }
            } else if (i6 == 5) {
                do {
                    list.add(Float.valueOf(zzb()));
                    if (!zzaj()) {
                        i2 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i2;
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final <T> void zzF(List<T> list, zzwx<T> zzwx, zzuj zzuj) throws IOException {
        int i2;
        int i3 = this.zzd;
        if ((i3 & 7) == 3) {
            do {
                list.add(zzab(zzwx, zzuj));
                if (!zzaj()) {
                    i2 = this.zzb;
                } else {
                    return;
                }
            } while (zzX() == i3);
            this.zzb = i2;
            return;
        }
        throw zzvk.zza();
    }

    public final void zzG(List<Integer> list) throws IOException {
        int i2;
        int i3;
        if (list instanceof zzva) {
            zzva zzva = (zzva) list;
            int i4 = this.zzd & 7;
            if (i4 == 0) {
                do {
                    zzva.zzh(zzg());
                    if (!zzaj()) {
                        i3 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i3;
            } else if (i4 == 2) {
                int zzX = this.zzb + zzX();
                while (this.zzb < zzX) {
                    zzva.zzh(zzX());
                }
                zzae(zzX);
            } else {
                throw zzvk.zza();
            }
        } else {
            int i5 = this.zzd & 7;
            if (i5 == 0) {
                do {
                    list.add(Integer.valueOf(zzg()));
                    if (!zzaj()) {
                        i2 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i2;
            } else if (i5 == 2) {
                int zzX2 = this.zzb + zzX();
                while (this.zzb < zzX2) {
                    list.add(Integer.valueOf(zzX()));
                }
                zzae(zzX2);
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final void zzH(List<Long> list) throws IOException {
        int i2;
        int i3;
        if (list instanceof zzvz) {
            zzvz zzvz = (zzvz) list;
            int i4 = this.zzd & 7;
            if (i4 == 0) {
                do {
                    zzvz.zzf(zzl());
                    if (!zzaj()) {
                        i3 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i3;
            } else if (i4 == 2) {
                int zzX = this.zzb + zzX();
                while (this.zzb < zzX) {
                    zzvz.zzf(zzp());
                }
                zzae(zzX);
            } else {
                throw zzvk.zza();
            }
        } else {
            int i5 = this.zzd & 7;
            if (i5 == 0) {
                do {
                    list.add(Long.valueOf(zzl()));
                    if (!zzaj()) {
                        i2 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i2;
            } else if (i5 == 2) {
                int zzX2 = this.zzb + zzX();
                while (this.zzb < zzX2) {
                    list.add(Long.valueOf(zzp()));
                }
                zzae(zzX2);
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final <T> void zzI(List<T> list, zzwx<T> zzwx, zzuj zzuj) throws IOException {
        int i2;
        int i3 = this.zzd;
        if ((i3 & 7) == 2) {
            do {
                list.add(zzac(zzwx, zzuj));
                if (!zzaj()) {
                    i2 = this.zzb;
                } else {
                    return;
                }
            } while (zzX() == i3);
            this.zzb = i2;
            return;
        }
        throw zzvk.zza();
    }

    public final void zzJ(List<Integer> list) throws IOException {
        int i2;
        int i3;
        if (list instanceof zzva) {
            zzva zzva = (zzva) list;
            int i4 = this.zzd & 7;
            if (i4 == 2) {
                int zzX = zzX();
                zzah(zzX);
                int i5 = this.zzb + zzX;
                while (this.zzb < i5) {
                    zzva.zzh(zzW());
                }
            } else if (i4 == 5) {
                do {
                    zzva.zzh(zzh());
                    if (!zzaj()) {
                        i3 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i3;
            } else {
                throw zzvk.zza();
            }
        } else {
            int i6 = this.zzd & 7;
            if (i6 == 2) {
                int zzX2 = zzX();
                zzah(zzX2);
                int i7 = this.zzb + zzX2;
                while (this.zzb < i7) {
                    list.add(Integer.valueOf(zzW()));
                }
            } else if (i6 == 5) {
                do {
                    list.add(Integer.valueOf(zzh()));
                    if (!zzaj()) {
                        i2 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i2;
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final void zzK(List<Long> list) throws IOException {
        int i2;
        int i3;
        if (list instanceof zzvz) {
            zzvz zzvz = (zzvz) list;
            int i4 = this.zzd & 7;
            if (i4 == 1) {
                do {
                    zzvz.zzf(zzm());
                    if (!zzaj()) {
                        i3 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i3;
            } else if (i4 == 2) {
                int zzX = zzX();
                zzai(zzX);
                int i5 = this.zzb + zzX;
                while (this.zzb < i5) {
                    zzvz.zzf(zzZ());
                }
            } else {
                throw zzvk.zza();
            }
        } else {
            int i6 = this.zzd & 7;
            if (i6 == 1) {
                do {
                    list.add(Long.valueOf(zzm()));
                    if (!zzaj()) {
                        i2 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i2;
            } else if (i6 == 2) {
                int zzX2 = zzX();
                zzai(zzX2);
                int i7 = this.zzb + zzX2;
                while (this.zzb < i7) {
                    list.add(Long.valueOf(zzZ()));
                }
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final void zzL(List<Integer> list) throws IOException {
        int i2;
        int i3;
        if (list instanceof zzva) {
            zzva zzva = (zzva) list;
            int i4 = this.zzd & 7;
            if (i4 == 0) {
                do {
                    zzva.zzh(zzi());
                    if (!zzaj()) {
                        i3 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i3;
            } else if (i4 == 2) {
                int zzX = this.zzb + zzX();
                while (this.zzb < zzX) {
                    zzva.zzh(zztj.zzs(zzX()));
                }
            } else {
                throw zzvk.zza();
            }
        } else {
            int i5 = this.zzd & 7;
            if (i5 == 0) {
                do {
                    list.add(Integer.valueOf(zzi()));
                    if (!zzaj()) {
                        i2 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i2;
            } else if (i5 == 2) {
                int zzX2 = this.zzb + zzX();
                while (this.zzb < zzX2) {
                    list.add(Integer.valueOf(zztj.zzs(zzX())));
                }
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final void zzM(List<Long> list) throws IOException {
        int i2;
        int i3;
        if (list instanceof zzvz) {
            zzvz zzvz = (zzvz) list;
            int i4 = this.zzd & 7;
            if (i4 == 0) {
                do {
                    zzvz.zzf(zzn());
                    if (!zzaj()) {
                        i3 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i3;
            } else if (i4 == 2) {
                int zzX = this.zzb + zzX();
                while (this.zzb < zzX) {
                    zzvz.zzf(zztj.zzt(zzp()));
                }
            } else {
                throw zzvk.zza();
            }
        } else {
            int i5 = this.zzd & 7;
            if (i5 == 0) {
                do {
                    list.add(Long.valueOf(zzn()));
                    if (!zzaj()) {
                        i2 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i2;
            } else if (i5 == 2) {
                int zzX2 = this.zzb + zzX();
                while (this.zzb < zzX2) {
                    list.add(Long.valueOf(zztj.zzt(zzp())));
                }
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final void zzN(List<String> list) throws IOException {
        zzO(list, false);
    }

    public final void zzO(List<String> list, boolean z2) throws IOException {
        int i2;
        int i3;
        if ((this.zzd & 7) != 2) {
            throw zzvk.zza();
        } else if ((list instanceof zzvs) && !z2) {
            zzvs zzvs = (zzvs) list;
            do {
                zzvs.zzi(zzq());
                if (!zzaj()) {
                    i3 = this.zzb;
                } else {
                    return;
                }
            } while (zzX() == this.zzd);
            this.zzb = i3;
        } else {
            do {
                list.add(zzw(z2));
                if (!zzaj()) {
                    i2 = this.zzb;
                } else {
                    return;
                }
            } while (zzX() == this.zzd);
            this.zzb = i2;
        }
    }

    public final void zzP(List<String> list) throws IOException {
        zzO(list, true);
    }

    public final void zzQ(List<Integer> list) throws IOException {
        int i2;
        int i3;
        if (list instanceof zzva) {
            zzva zzva = (zzva) list;
            int i4 = this.zzd & 7;
            if (i4 == 0) {
                do {
                    zzva.zzh(zzj());
                    if (!zzaj()) {
                        i3 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i3;
            } else if (i4 == 2) {
                int zzX = this.zzb + zzX();
                while (this.zzb < zzX) {
                    zzva.zzh(zzX());
                }
            } else {
                throw zzvk.zza();
            }
        } else {
            int i5 = this.zzd & 7;
            if (i5 == 0) {
                do {
                    list.add(Integer.valueOf(zzj()));
                    if (!zzaj()) {
                        i2 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i2;
            } else if (i5 == 2) {
                int zzX2 = this.zzb + zzX();
                while (this.zzb < zzX2) {
                    list.add(Integer.valueOf(zzX()));
                }
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final void zzR(List<Long> list) throws IOException {
        int i2;
        int i3;
        if (list instanceof zzvz) {
            zzvz zzvz = (zzvz) list;
            int i4 = this.zzd & 7;
            if (i4 == 0) {
                do {
                    zzvz.zzf(zzo());
                    if (!zzaj()) {
                        i3 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i3;
            } else if (i4 == 2) {
                int zzX = this.zzb + zzX();
                while (this.zzb < zzX) {
                    zzvz.zzf(zzp());
                }
                zzae(zzX);
            } else {
                throw zzvk.zza();
            }
        } else {
            int i5 = this.zzd & 7;
            if (i5 == 0) {
                do {
                    list.add(Long.valueOf(zzo()));
                    if (!zzaj()) {
                        i2 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i2;
            } else if (i5 == 2) {
                int zzX2 = this.zzb + zzX();
                while (this.zzb < zzX2) {
                    list.add(Long.valueOf(zzp()));
                }
                zzae(zzX2);
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final boolean zzS() throws IOException {
        zzaf(0);
        return zzX() != 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002e A[LOOP:0: B:18:0x002e->B:21:0x003b, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzT() throws java.io.IOException {
        /*
            r7 = this;
            boolean r0 = r7.zzaj()
            r1 = 0
            if (r0 != 0) goto L_0x0082
            int r0 = r7.zzd
            int r2 = r7.zze
            if (r0 != r2) goto L_0x000f
            goto L_0x0082
        L_0x000f:
            r3 = r0 & 7
            r4 = 1
            if (r3 == 0) goto L_0x0056
            if (r3 == r4) goto L_0x0053
            r1 = 2
            if (r3 == r1) goto L_0x004b
            r1 = 4
            r5 = 3
            if (r3 == r5) goto L_0x0029
            r0 = 5
            if (r3 != r0) goto L_0x0024
            r7.zzag(r1)
            return r4
        L_0x0024:
            com.google.android.gms.internal.gtm.zzvj r0 = com.google.android.gms.internal.gtm.zzvk.zza()
            throw r0
        L_0x0029:
            int r0 = r0 >>> r5
            int r0 = r0 << r5
            r0 = r0 | r1
            r7.zze = r0
        L_0x002e:
            int r0 = r7.zzc()
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r1) goto L_0x003d
            boolean r0 = r7.zzT()
            if (r0 != 0) goto L_0x002e
        L_0x003d:
            int r0 = r7.zzd
            int r1 = r7.zze
            if (r0 != r1) goto L_0x0046
            r7.zze = r2
            return r4
        L_0x0046:
            com.google.android.gms.internal.gtm.zzvk r0 = com.google.android.gms.internal.gtm.zzvk.zzg()
            throw r0
        L_0x004b:
            int r0 = r7.zzX()
        L_0x004f:
            r7.zzag(r0)
            return r4
        L_0x0053:
            r0 = 8
            goto L_0x004f
        L_0x0056:
            int r0 = r7.zzc
            int r2 = r7.zzb
            int r0 = r0 - r2
            r3 = 10
            if (r0 < r3) goto L_0x0071
            byte[] r0 = r7.zza
            r5 = 0
        L_0x0062:
            if (r5 >= r3) goto L_0x0071
            int r6 = r2 + 1
            byte r2 = r0[r2]
            if (r2 < 0) goto L_0x006d
            r7.zzb = r6
            goto L_0x007c
        L_0x006d:
            int r5 = r5 + 1
            r2 = r6
            goto L_0x0062
        L_0x0071:
            if (r1 >= r3) goto L_0x007d
            byte r0 = r7.zzU()
            if (r0 >= 0) goto L_0x007c
            int r1 = r1 + 1
            goto L_0x0071
        L_0x007c:
            return r4
        L_0x007d:
            com.google.android.gms.internal.gtm.zzvk r0 = com.google.android.gms.internal.gtm.zzvk.zze()
            throw r0
        L_0x0082:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzsn.zzT():boolean");
    }

    public final double zza() throws IOException {
        zzaf(1);
        return Double.longBitsToDouble(zzY());
    }

    public final float zzb() throws IOException {
        zzaf(5);
        return Float.intBitsToFloat(zzV());
    }

    public final int zzc() throws IOException {
        if (zzaj()) {
            return SubsamplingScaleImageView.TILE_SIZE_AUTO;
        }
        int zzX = zzX();
        this.zzd = zzX;
        return zzX == this.zze ? SubsamplingScaleImageView.TILE_SIZE_AUTO : zzX >>> 3;
    }

    public final int zzd() {
        return this.zzd;
    }

    public final int zze() throws IOException {
        zzaf(0);
        return zzX();
    }

    public final int zzf() throws IOException {
        zzaf(5);
        return zzV();
    }

    public final int zzg() throws IOException {
        zzaf(0);
        return zzX();
    }

    public final int zzh() throws IOException {
        zzaf(5);
        return zzV();
    }

    public final int zzi() throws IOException {
        zzaf(0);
        return zztj.zzs(zzX());
    }

    public final int zzj() throws IOException {
        zzaf(0);
        return zzX();
    }

    public final long zzk() throws IOException {
        zzaf(1);
        return zzY();
    }

    public final long zzl() throws IOException {
        zzaf(0);
        return zzp();
    }

    public final long zzm() throws IOException {
        zzaf(1);
        return zzY();
    }

    public final long zzn() throws IOException {
        zzaf(0);
        return zztj.zzt(zzp());
    }

    public final long zzo() throws IOException {
        zzaf(0);
        return zzp();
    }

    public final long zzp() throws IOException {
        long j2;
        long j3;
        long j4;
        long j5;
        byte b2;
        int i2 = this.zzb;
        int i3 = this.zzc;
        if (i3 != i2) {
            byte[] bArr = this.zza;
            int i4 = i2 + 1;
            byte b3 = bArr[i2];
            if (b3 >= 0) {
                this.zzb = i4;
                return (long) b3;
            } else if (i3 - i4 < 9) {
                return zzaa();
            } else {
                int i5 = i4 + 1;
                byte b4 = b3 ^ (bArr[i4] << 7);
                if (b4 < 0) {
                    b2 = b4 ^ Byte.MIN_VALUE;
                } else {
                    int i6 = i5 + 1;
                    byte b5 = b4 ^ (bArr[i5] << 14);
                    if (b5 >= 0) {
                        j3 = (long) (b5 ^ 16256);
                    } else {
                        i5 = i6 + 1;
                        byte b6 = b5 ^ (bArr[i6] << 21);
                        if (b6 < 0) {
                            b2 = b6 ^ -2080896;
                        } else {
                            i6 = i5 + 1;
                            long j6 = (((long) bArr[i5]) << 28) ^ ((long) b6);
                            if (j6 >= 0) {
                                j5 = 266354560;
                            } else {
                                int i7 = i6 + 1;
                                long j7 = j6 ^ (((long) bArr[i6]) << 35);
                                if (j7 < 0) {
                                    j4 = -34093383808L;
                                } else {
                                    i6 = i7 + 1;
                                    j6 = j7 ^ (((long) bArr[i7]) << 42);
                                    if (j6 >= 0) {
                                        j5 = 4363953127296L;
                                    } else {
                                        i7 = i6 + 1;
                                        j7 = j6 ^ (((long) bArr[i6]) << 49);
                                        if (j7 < 0) {
                                            j4 = -558586000294016L;
                                        } else {
                                            i6 = i7 + 1;
                                            j3 = (j7 ^ (((long) bArr[i7]) << 56)) ^ 71499008037633920L;
                                            if (j3 < 0) {
                                                i7 = i6 + 1;
                                                if (((long) bArr[i6]) >= 0) {
                                                    j2 = j3;
                                                    i5 = i7;
                                                    this.zzb = i5;
                                                    return j2;
                                                }
                                                throw zzvk.zze();
                                            }
                                        }
                                    }
                                }
                                j2 = j4 ^ j7;
                                i5 = i7;
                                this.zzb = i5;
                                return j2;
                            }
                            j3 = j6 ^ j5;
                        }
                    }
                    i5 = i6;
                    j2 = j3;
                    this.zzb = i5;
                    return j2;
                }
                j2 = (long) b2;
                this.zzb = i5;
                return j2;
            }
        } else {
            throw zzvk.zzj();
        }
    }

    public final zztd zzq() throws IOException {
        zzaf(2);
        int zzX = zzX();
        if (zzX == 0) {
            return zztd.zzb;
        }
        zzad(zzX);
        zztd zzq = zztd.zzq(this.zza, this.zzb, zzX);
        this.zzb += zzX;
        return zzq;
    }

    public final <T> T zzr(Class<T> cls, zzuj zzuj) throws IOException {
        zzaf(3);
        return zzab(zzwt.zza().zzb(cls), zzuj);
    }

    public final <T> T zzs(zzwx<T> zzwx, zzuj zzuj) throws IOException {
        zzaf(3);
        return zzab(zzwx, zzuj);
    }

    public final <T> T zzt(Class<T> cls, zzuj zzuj) throws IOException {
        zzaf(2);
        return zzac(zzwt.zza().zzb(cls), zzuj);
    }

    public final <T> T zzu(zzwx<T> zzwx, zzuj zzuj) throws IOException {
        zzaf(2);
        return zzac(zzwx, zzuj);
    }

    public final String zzv() throws IOException {
        return zzw(false);
    }

    public final String zzw(boolean z2) throws IOException {
        zzaf(2);
        int zzX = zzX();
        if (zzX == 0) {
            return "";
        }
        zzad(zzX);
        if (z2) {
            byte[] bArr = this.zza;
            int i2 = this.zzb;
            if (!zzyd.zzf(bArr, i2, i2 + zzX)) {
                throw zzvk.zzd();
            }
        }
        String str = new String(this.zza, this.zzb, zzX, zzvi.zza);
        this.zzb += zzX;
        return str;
    }

    public final String zzx() throws IOException {
        return zzw(true);
    }

    public final void zzy(List<Boolean> list) throws IOException {
        int i2;
        int i3;
        if (list instanceof zzsr) {
            zzsr zzsr = (zzsr) list;
            int i4 = this.zzd & 7;
            if (i4 == 0) {
                do {
                    zzsr.zze(zzS());
                    if (!zzaj()) {
                        i3 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i3;
            } else if (i4 == 2) {
                int zzX = this.zzb + zzX();
                while (this.zzb < zzX) {
                    zzsr.zze(zzX() != 0);
                }
                zzae(zzX);
            } else {
                throw zzvk.zza();
            }
        } else {
            int i5 = this.zzd & 7;
            if (i5 == 0) {
                do {
                    list.add(Boolean.valueOf(zzS()));
                    if (!zzaj()) {
                        i2 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i2;
            } else if (i5 == 2) {
                int zzX2 = this.zzb + zzX();
                while (this.zzb < zzX2) {
                    list.add(Boolean.valueOf(zzX() != 0));
                }
                zzae(zzX2);
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final void zzz(List<zztd> list) throws IOException {
        int i2;
        if ((this.zzd & 7) == 2) {
            do {
                list.add(zzq());
                if (!zzaj()) {
                    i2 = this.zzb;
                } else {
                    return;
                }
            } while (zzX() == this.zzd);
            this.zzb = i2;
            return;
        }
        throw zzvk.zza();
    }
}
