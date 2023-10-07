package com.google.android.gms.internal.gtm;

import java.io.IOException;

final class zzsm {
    static int zza(byte[] bArr, int i2, zzsl zzsl) throws zzvk {
        int zzj = zzj(bArr, i2, zzsl);
        int i3 = zzsl.zza;
        if (i3 < 0) {
            throw zzvk.zzf();
        } else if (i3 > bArr.length - zzj) {
            throw zzvk.zzj();
        } else if (i3 == 0) {
            zzsl.zzc = zztd.zzb;
            return zzj;
        } else {
            zzsl.zzc = zztd.zzn(bArr, zzj, i3);
            return zzj + i3;
        }
    }

    static int zzb(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    static int zzc(zzwx zzwx, byte[] bArr, int i2, int i3, int i4, zzsl zzsl) throws IOException {
        zzwn zzwn = (zzwn) zzwx;
        Object zze = zzwn.zze();
        int zzc = zzwn.zzc(zze, bArr, i2, i3, i4, zzsl);
        zzwn.zzf(zze);
        zzsl.zzc = zze;
        return zzc;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zzd(com.google.android.gms.internal.gtm.zzwx r6, byte[] r7, int r8, int r9, com.google.android.gms.internal.gtm.zzsl r10) throws java.io.IOException {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = zzk(r8, r7, r0, r10)
            int r8 = r10.zza
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.zze()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.zzi(r1, r2, r3, r4, r5)
            r6.zzf(r9)
            r10.zzc = r9
            return r8
        L_0x0025:
            com.google.android.gms.internal.gtm.zzvk r6 = com.google.android.gms.internal.gtm.zzvk.zzj()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzsm.zzd(com.google.android.gms.internal.gtm.zzwx, byte[], int, int, com.google.android.gms.internal.gtm.zzsl):int");
    }

    static int zze(zzwx<?> zzwx, int i2, byte[] bArr, int i3, int i4, zzvh<?> zzvh, zzsl zzsl) throws IOException {
        int zzd = zzd(zzwx, bArr, i3, i4, zzsl);
        while (true) {
            zzvh.add(zzsl.zzc);
            if (zzd >= i4) {
                break;
            }
            int zzj = zzj(bArr, zzd, zzsl);
            if (i2 != zzsl.zza) {
                break;
            }
            zzd = zzd(zzwx, bArr, zzj, i4, zzsl);
        }
        return zzd;
    }

    static int zzf(byte[] bArr, int i2, zzvh<?> zzvh, zzsl zzsl) throws IOException {
        zzva zzva = (zzva) zzvh;
        int zzj = zzj(bArr, i2, zzsl);
        int i3 = zzsl.zza + zzj;
        while (zzj < i3) {
            zzj = zzj(bArr, zzj, zzsl);
            zzva.zzh(zzsl.zza);
        }
        if (zzj == i3) {
            return zzj;
        }
        throw zzvk.zzj();
    }

    static int zzg(byte[] bArr, int i2, zzsl zzsl) throws zzvk {
        int zzj = zzj(bArr, i2, zzsl);
        int i3 = zzsl.zza;
        if (i3 < 0) {
            throw zzvk.zzf();
        } else if (i3 == 0) {
            zzsl.zzc = "";
            return zzj;
        } else {
            zzsl.zzc = new String(bArr, zzj, i3, zzvi.zza);
            return zzj + i3;
        }
    }

    static int zzh(byte[] bArr, int i2, zzsl zzsl) throws zzvk {
        int zzj = zzj(bArr, i2, zzsl);
        int i3 = zzsl.zza;
        if (i3 < 0) {
            throw zzvk.zzf();
        } else if (i3 == 0) {
            zzsl.zzc = "";
            return zzj;
        } else {
            zzsl.zzc = zzyd.zzd(bArr, zzj, i3);
            return zzj + i3;
        }
    }

    static int zzi(int i2, byte[] bArr, int i3, int i4, zzxp zzxp, zzsl zzsl) throws zzvk {
        if ((i2 >>> 3) != 0) {
            int i5 = i2 & 7;
            if (i5 == 0) {
                int zzm = zzm(bArr, i3, zzsl);
                zzxp.zzh(i2, Long.valueOf(zzsl.zzb));
                return zzm;
            } else if (i5 == 1) {
                zzxp.zzh(i2, Long.valueOf(zzo(bArr, i3)));
                return i3 + 8;
            } else if (i5 == 2) {
                int zzj = zzj(bArr, i3, zzsl);
                int i6 = zzsl.zza;
                if (i6 < 0) {
                    throw zzvk.zzf();
                } else if (i6 <= bArr.length - zzj) {
                    zzxp.zzh(i2, i6 == 0 ? zztd.zzb : zztd.zzn(bArr, zzj, i6));
                    return zzj + i6;
                } else {
                    throw zzvk.zzj();
                }
            } else if (i5 == 3) {
                int i7 = (i2 & -8) | 4;
                zzxp zze = zzxp.zze();
                int i8 = 0;
                while (true) {
                    if (i3 >= i4) {
                        break;
                    }
                    int zzj2 = zzj(bArr, i3, zzsl);
                    int i9 = zzsl.zza;
                    i8 = i9;
                    if (i9 == i7) {
                        i3 = zzj2;
                        break;
                    }
                    int zzi = zzi(i8, bArr, zzj2, i4, zze, zzsl);
                    i8 = i9;
                    i3 = zzi;
                }
                if (i3 > i4 || i8 != i7) {
                    throw zzvk.zzg();
                }
                zzxp.zzh(i2, zze);
                return i3;
            } else if (i5 == 5) {
                zzxp.zzh(i2, Integer.valueOf(zzb(bArr, i3)));
                return i3 + 4;
            } else {
                throw zzvk.zzc();
            }
        } else {
            throw zzvk.zzc();
        }
    }

    static int zzj(byte[] bArr, int i2, zzsl zzsl) {
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 < 0) {
            return zzk(b2, bArr, i3, zzsl);
        }
        zzsl.zza = b2;
        return i3;
    }

    static int zzk(int i2, byte[] bArr, int i3, zzsl zzsl) {
        int i4;
        int i5;
        int i6 = i2 & 127;
        int i7 = i3 + 1;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            i5 = b2 << 7;
        } else {
            int i8 = i6 | ((b2 & Byte.MAX_VALUE) << 7);
            int i9 = i7 + 1;
            byte b3 = bArr[i7];
            if (b3 >= 0) {
                i4 = b3 << 14;
            } else {
                i6 = i8 | ((b3 & Byte.MAX_VALUE) << 14);
                i7 = i9 + 1;
                byte b4 = bArr[i9];
                if (b4 >= 0) {
                    i5 = b4 << 21;
                } else {
                    i8 = i6 | ((b4 & Byte.MAX_VALUE) << 21);
                    i9 = i7 + 1;
                    byte b5 = bArr[i7];
                    if (b5 >= 0) {
                        i4 = b5 << 28;
                    } else {
                        int i10 = i8 | ((b5 & Byte.MAX_VALUE) << 28);
                        while (true) {
                            int i11 = i9 + 1;
                            if (bArr[i9] < 0) {
                                i9 = i11;
                            } else {
                                zzsl.zza = i10;
                                return i11;
                            }
                        }
                    }
                }
            }
            zzsl.zza = i8 | i4;
            return i9;
        }
        zzsl.zza = i6 | i5;
        return i7;
    }

    static int zzl(int i2, byte[] bArr, int i3, int i4, zzvh<?> zzvh, zzsl zzsl) {
        zzva zzva = (zzva) zzvh;
        int zzj = zzj(bArr, i3, zzsl);
        while (true) {
            zzva.zzh(zzsl.zza);
            if (zzj >= i4) {
                break;
            }
            int zzj2 = zzj(bArr, zzj, zzsl);
            if (i2 != zzsl.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zzsl);
        }
        return zzj;
    }

    static int zzm(byte[] bArr, int i2, zzsl zzsl) {
        int i3 = i2 + 1;
        long j2 = (long) bArr[i2];
        if (j2 < 0) {
            int i4 = i3 + 1;
            byte b2 = bArr[i3];
            long j3 = (j2 & 127) | (((long) (b2 & Byte.MAX_VALUE)) << 7);
            int i5 = 7;
            while (b2 < 0) {
                int i6 = i4 + 1;
                byte b3 = bArr[i4];
                i5 += 7;
                j3 |= ((long) (b3 & Byte.MAX_VALUE)) << i5;
                int i7 = i6;
                b2 = b3;
                i4 = i7;
            }
            zzsl.zzb = j3;
            return i4;
        }
        zzsl.zzb = j2;
        return i3;
    }

    static int zzn(int i2, byte[] bArr, int i3, int i4, zzsl zzsl) throws zzvk {
        if ((i2 >>> 3) != 0) {
            int i5 = i2 & 7;
            if (i5 == 0) {
                return zzm(bArr, i3, zzsl);
            }
            if (i5 == 1) {
                return i3 + 8;
            }
            if (i5 == 2) {
                return zzj(bArr, i3, zzsl) + zzsl.zza;
            }
            if (i5 == 3) {
                int i6 = (i2 & -8) | 4;
                int i7 = 0;
                while (i3 < i4) {
                    i3 = zzj(bArr, i3, zzsl);
                    i7 = zzsl.zza;
                    if (i7 == i6) {
                        break;
                    }
                    i3 = zzn(i7, bArr, i3, i4, zzsl);
                }
                if (i3 <= i4 && i7 == i6) {
                    return i3;
                }
                throw zzvk.zzg();
            } else if (i5 == 5) {
                return i3 + 4;
            } else {
                throw zzvk.zzc();
            }
        } else {
            throw zzvk.zzc();
        }
    }

    static long zzo(byte[] bArr, int i2) {
        return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
    }
}
