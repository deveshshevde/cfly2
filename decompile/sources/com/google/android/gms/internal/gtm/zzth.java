package com.google.android.gms.internal.gtm;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

final class zzth extends zztj {
    private final InputStream zze;
    private final byte[] zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl = SubsamplingScaleImageView.TILE_SIZE_AUTO;

    /* synthetic */ zzth(InputStream inputStream, int i2, zztg zztg) {
        super((zzti) null);
        zzvi.zzf(inputStream, "input");
        this.zze = inputStream;
        this.zzf = new byte[4096];
        this.zzg = 0;
        this.zzi = 0;
        this.zzk = 0;
    }

    private final List<byte[]> zzu(int i2) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i2 > 0) {
            int min = Math.min(i2, 4096);
            byte[] bArr = new byte[min];
            int i3 = 0;
            while (i3 < min) {
                int read = this.zze.read(bArr, i3, min - i3);
                if (read != -1) {
                    this.zzk += read;
                    i3 += read;
                } else {
                    throw zzvk.zzj();
                }
            }
            i2 -= min;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzv() {
        int i2 = this.zzg + this.zzh;
        this.zzg = i2;
        int i3 = this.zzk + i2;
        int i4 = this.zzl;
        if (i3 > i4) {
            int i5 = i3 - i4;
            this.zzh = i5;
            this.zzg = i2 - i5;
            return;
        }
        this.zzh = 0;
    }

    private final void zzw(int i2) throws IOException {
        if (zzx(i2)) {
            return;
        }
        if (i2 > (SubsamplingScaleImageView.TILE_SIZE_AUTO - this.zzk) - this.zzi) {
            throw zzvk.zzi();
        }
        throw zzvk.zzj();
    }

    private final boolean zzx(int i2) throws IOException {
        int i3 = this.zzi;
        int i4 = this.zzg;
        if (i3 + i2 > i4) {
            int i5 = this.zzk;
            if (i2 > (SubsamplingScaleImageView.TILE_SIZE_AUTO - i5) - i3 || i5 + i3 + i2 > this.zzl) {
                return false;
            }
            if (i3 > 0) {
                if (i4 > i3) {
                    byte[] bArr = this.zzf;
                    System.arraycopy(bArr, i3, bArr, 0, i4 - i3);
                }
                i5 = this.zzk + i3;
                this.zzk = i5;
                i4 = this.zzg - i3;
                this.zzg = i4;
                this.zzi = 0;
            }
            try {
                int read = this.zze.read(this.zzf, i4, Math.min(4096 - i4, (SubsamplingScaleImageView.TILE_SIZE_AUTO - i5) - i4));
                if (read == 0 || read < -1 || read > 4096) {
                    String valueOf = String.valueOf(this.zze.getClass());
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 91);
                    sb.append(valueOf);
                    sb.append("#read(byte[]) returned invalid result: ");
                    sb.append(read);
                    sb.append("\nThe InputStream implementation is buggy.");
                    throw new IllegalStateException(sb.toString());
                } else if (read <= 0) {
                    return false;
                } else {
                    this.zzg += read;
                    zzv();
                    if (this.zzg >= i2) {
                        return true;
                    }
                    return zzx(i2);
                }
            } catch (zzvk e2) {
                e2.zzk();
                throw e2;
            }
        } else {
            StringBuilder sb2 = new StringBuilder(77);
            sb2.append("refillBuffer() called when ");
            sb2.append(i2);
            sb2.append(" bytes were already available in buffer");
            throw new IllegalStateException(sb2.toString());
        }
    }

    private final byte[] zzy(int i2, boolean z2) throws IOException {
        byte[] zzz = zzz(i2);
        if (zzz != null) {
            return zzz;
        }
        int i3 = this.zzi;
        int i4 = this.zzg;
        int i5 = i4 - i3;
        this.zzk += i4;
        this.zzi = 0;
        this.zzg = 0;
        List<byte[]> zzu = zzu(i2 - i5);
        byte[] bArr = new byte[i2];
        System.arraycopy(this.zzf, i3, bArr, 0, i5);
        for (byte[] next : zzu) {
            int length = next.length;
            System.arraycopy(next, 0, bArr, i5, length);
            i5 += length;
        }
        return bArr;
    }

    private final byte[] zzz(int i2) throws IOException {
        if (i2 == 0) {
            return zzvi.zzc;
        }
        if (i2 >= 0) {
            int i3 = this.zzk;
            int i4 = this.zzi;
            int i5 = i3 + i4 + i2;
            if (-2147483647 + i5 <= 0) {
                int i6 = this.zzl;
                if (i5 <= i6) {
                    int i7 = this.zzg - i4;
                    int i8 = i2 - i7;
                    if (i8 >= 4096) {
                        try {
                            if (i8 > this.zze.available()) {
                                return null;
                            }
                        } catch (zzvk e2) {
                            e2.zzk();
                            throw e2;
                        }
                    }
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.zzf, this.zzi, bArr, 0, i7);
                    this.zzk += this.zzg;
                    this.zzi = 0;
                    this.zzg = 0;
                    while (i7 < i2) {
                        try {
                            int read = this.zze.read(bArr, i7, i2 - i7);
                            if (read != -1) {
                                this.zzk += read;
                                i7 += read;
                            } else {
                                throw zzvk.zzj();
                            }
                        } catch (zzvk e3) {
                            e3.zzk();
                            throw e3;
                        }
                    }
                    return bArr;
                }
                zzr((i6 - i3) - i4);
                throw zzvk.zzj();
            }
            throw zzvk.zzi();
        }
        throw zzvk.zzf();
    }

    public final int zza() {
        return this.zzk + this.zzi;
    }

    public final int zzb(int i2) throws zzvk {
        if (i2 >= 0) {
            int i3 = i2 + this.zzk + this.zzi;
            int i4 = this.zzl;
            if (i3 <= i4) {
                this.zzl = i3;
                zzv();
                return i4;
            }
            throw zzvk.zzj();
        }
        throw zzvk.zzf();
    }

    public final int zzc() throws IOException {
        if (zzi()) {
            this.zzj = 0;
            return 0;
        }
        int zzn = zzn();
        this.zzj = zzn;
        if ((zzn >>> 3) != 0) {
            return zzn;
        }
        throw zzvk.zzc();
    }

    public final zztd zzd() throws IOException {
        int zzn = zzn();
        int i2 = this.zzg;
        int i3 = this.zzi;
        if (zzn <= i2 - i3 && zzn > 0) {
            zztd zzn2 = zztd.zzn(this.zzf, i3, zzn);
            this.zzi += zzn;
            return zzn2;
        } else if (zzn == 0) {
            return zztd.zzb;
        } else {
            byte[] zzz = zzz(zzn);
            if (zzz != null) {
                return zztd.zzm(zzz);
            }
            int i4 = this.zzi;
            int i5 = this.zzg;
            int i6 = i5 - i4;
            this.zzk += i5;
            this.zzi = 0;
            this.zzg = 0;
            List<byte[]> zzu = zzu(zzn - i6);
            byte[] bArr = new byte[zzn];
            System.arraycopy(this.zzf, i4, bArr, 0, i6);
            for (byte[] next : zzu) {
                int length = next.length;
                System.arraycopy(next, 0, bArr, i6, length);
                i6 += length;
            }
            return zztd.zzp(bArr);
        }
    }

    public final String zze() throws IOException {
        int zzn = zzn();
        if (zzn > 0) {
            int i2 = this.zzg;
            int i3 = this.zzi;
            if (zzn <= i2 - i3) {
                String str = new String(this.zzf, i3, zzn, zzvi.zza);
                this.zzi += zzn;
                return str;
            }
        }
        if (zzn == 0) {
            return "";
        }
        if (zzn > this.zzg) {
            return new String(zzy(zzn, false), zzvi.zza);
        }
        zzw(zzn);
        String str2 = new String(this.zzf, this.zzi, zzn, zzvi.zza);
        this.zzi += zzn;
        return str2;
    }

    public final String zzf() throws IOException {
        byte[] bArr;
        int zzn = zzn();
        int i2 = this.zzi;
        int i3 = this.zzg;
        if (zzn <= i3 - i2 && zzn > 0) {
            bArr = this.zzf;
            this.zzi = i2 + zzn;
        } else if (zzn == 0) {
            return "";
        } else {
            if (zzn <= i3) {
                zzw(zzn);
                bArr = this.zzf;
                this.zzi = zzn;
            } else {
                bArr = zzy(zzn, false);
            }
            i2 = 0;
        }
        return zzyd.zzd(bArr, i2, zzn);
    }

    public final void zzg(int i2) throws zzvk {
        if (this.zzj != i2) {
            throw zzvk.zzb();
        }
    }

    public final void zzh(int i2) {
        this.zzl = i2;
        zzv();
    }

    public final boolean zzi() throws IOException {
        return this.zzi == this.zzg && !zzx(1);
    }

    public final boolean zzj() throws IOException {
        return zzp() != 0;
    }

    public final boolean zzk(int i2) throws IOException {
        int zzc;
        int i3 = i2 & 7;
        int i4 = 0;
        if (i3 == 0) {
            if (this.zzg - this.zzi >= 10) {
                while (i4 < 10) {
                    byte[] bArr = this.zzf;
                    int i5 = this.zzi;
                    this.zzi = i5 + 1;
                    if (bArr[i5] < 0) {
                        i4++;
                    }
                }
                throw zzvk.zze();
            }
            while (i4 < 10) {
                if (zzl() < 0) {
                    i4++;
                }
            }
            throw zzvk.zze();
            return true;
        } else if (i3 == 1) {
            zzr(8);
            return true;
        } else if (i3 == 2) {
            zzr(zzn());
            return true;
        } else if (i3 == 3) {
            do {
                zzc = zzc();
                if (zzc == 0 || !zzk(zzc)) {
                    zzg(((i2 >>> 3) << 3) | 4);
                }
                zzc = zzc();
                break;
            } while (!zzk(zzc));
            zzg(((i2 >>> 3) << 3) | 4);
            return true;
        } else if (i3 == 4) {
            return false;
        } else {
            if (i3 == 5) {
                zzr(4);
                return true;
            }
            throw zzvk.zza();
        }
    }

    public final byte zzl() throws IOException {
        if (this.zzi == this.zzg) {
            zzw(1);
        }
        byte[] bArr = this.zzf;
        int i2 = this.zzi;
        this.zzi = i2 + 1;
        return bArr[i2];
    }

    public final int zzm() throws IOException {
        int i2 = this.zzi;
        if (this.zzg - i2 < 4) {
            zzw(4);
            i2 = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i2 + 4;
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0067, code lost:
        if (r2[r3] >= 0) goto L_0x0069;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzn() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.zzi
            int r1 = r5.zzg
            if (r1 != r0) goto L_0x0007
            goto L_0x006c
        L_0x0007:
            byte[] r2 = r5.zzf
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0012
            r5.zzi = r3
            return r0
        L_0x0012:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x006c
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0023
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x0069
        L_0x0023:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0030
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x002e:
            r1 = r3
            goto L_0x0069
        L_0x0030:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x003e
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0069
        L_0x003e:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L_0x002e
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0069
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002e
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0069
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002e
            int r1 = r3 + 1
            byte r2 = r2[r3]
            if (r2 < 0) goto L_0x006c
        L_0x0069:
            r5.zzi = r1
            return r0
        L_0x006c:
            long r0 = r5.zzq()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzth.zzn():int");
    }

    public final long zzo() throws IOException {
        int i2 = this.zzi;
        if (this.zzg - i2 < 8) {
            zzw(8);
            i2 = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i2 + 8;
        return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
    }

    public final long zzp() throws IOException {
        long j2;
        long j3;
        long j4;
        long j5;
        byte b2;
        int i2 = this.zzi;
        int i3 = this.zzg;
        if (i3 != i2) {
            byte[] bArr = this.zzf;
            int i4 = i2 + 1;
            byte b3 = bArr[i2];
            if (b3 >= 0) {
                this.zzi = i4;
                return (long) b3;
            } else if (i3 - i4 >= 9) {
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
                                                    this.zzi = i5;
                                                    return j2;
                                                }
                                            }
                                        }
                                    }
                                }
                                j2 = j4 ^ j7;
                                i5 = i7;
                                this.zzi = i5;
                                return j2;
                            }
                            j3 = j6 ^ j5;
                        }
                    }
                    i5 = i6;
                    j2 = j3;
                    this.zzi = i5;
                    return j2;
                }
                j2 = (long) b2;
                this.zzi = i5;
                return j2;
            }
        }
        return zzq();
    }

    /* access modifiers changed from: package-private */
    public final long zzq() throws IOException {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte zzl2 = zzl();
            j2 |= ((long) (zzl2 & Byte.MAX_VALUE)) << i2;
            if ((zzl2 & 128) == 0) {
                return j2;
            }
        }
        throw zzvk.zze();
    }

    public final void zzr(int i2) throws IOException {
        int i3 = this.zzg;
        int i4 = this.zzi;
        int i5 = i3 - i4;
        if (i2 <= i5 && i2 >= 0) {
            this.zzi = i4 + i2;
        } else if (i2 >= 0) {
            int i6 = this.zzk;
            int i7 = i6 + i4;
            int i8 = this.zzl;
            if (i7 + i2 <= i8) {
                this.zzk = i7;
                this.zzg = 0;
                this.zzi = 0;
                while (i5 < i2) {
                    try {
                        long j2 = (long) (i2 - i5);
                        long skip = this.zze.skip(j2);
                        if (skip < 0 || skip > j2) {
                            String valueOf = String.valueOf(this.zze.getClass());
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 92);
                            sb.append(valueOf);
                            sb.append("#skip returned invalid result: ");
                            sb.append(skip);
                            sb.append("\nThe InputStream implementation is buggy.");
                            throw new IllegalStateException(sb.toString());
                        } else if (skip == 0) {
                            break;
                        } else {
                            i5 += (int) skip;
                        }
                    } catch (zzvk e2) {
                        e2.zzk();
                        throw e2;
                    } catch (Throwable th) {
                        this.zzk += i5;
                        zzv();
                        throw th;
                    }
                }
                this.zzk += i5;
                zzv();
                if (i5 < i2) {
                    int i9 = this.zzg;
                    int i10 = i9 - this.zzi;
                    this.zzi = i9;
                    while (true) {
                        zzw(1);
                        int i11 = i2 - i10;
                        int i12 = this.zzg;
                        if (i11 > i12) {
                            i10 += i12;
                            this.zzi = i12;
                        } else {
                            this.zzi = i11;
                            return;
                        }
                    }
                }
            } else {
                zzr((i8 - i6) - i4);
                throw zzvk.zzj();
            }
        } else {
            throw zzvk.zzf();
        }
    }
}
