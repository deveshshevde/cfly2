package com.google.android.gms.internal.gtm;

import com.xeagle.android.login.common.NetworkUtil;

final class zzxz {
    static /* synthetic */ void zza(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i2) {
        if (zze(b3) || (((b2 << 28) + (b3 + 112)) >> 30) != 0 || zze(b4) || zze(b5)) {
            throw zzvk.zzd();
        }
        byte b6 = ((b2 & 7) << 18) | ((b3 & 63) << NetworkUtil.CURRENT_NETWORK_TYPE_CM) | ((b4 & 63) << 6) | (b5 & 63);
        cArr[i2] = (char) ((b6 >>> 10) + 55232);
        cArr[i2 + 1] = (char) ((b6 & 1023) + 56320);
    }

    static /* synthetic */ void zzb(byte b2, byte b3, byte b4, char[] cArr, int i2) {
        if (!zze(b3)) {
            if (b2 == -32) {
                if (b3 >= -96) {
                    b2 = -32;
                }
            }
            if (b2 == -19) {
                if (b3 < -96) {
                    b2 = -19;
                }
            }
            if (!zze(b4)) {
                cArr[i2] = (char) (((b2 & 15) << NetworkUtil.CURRENT_NETWORK_TYPE_CM) | ((b3 & 63) << 6) | (b4 & 63));
                return;
            }
        }
        throw zzvk.zzd();
    }

    static /* synthetic */ void zzc(byte b2, byte b3, char[] cArr, int i2) {
        if (b2 < -62 || zze(b3)) {
            throw zzvk.zzd();
        }
        cArr[i2] = (char) (((b2 & 31) << 6) | (b3 & 63));
    }

    static /* bridge */ /* synthetic */ boolean zzd(byte b2) {
        return b2 >= 0;
    }

    private static boolean zze(byte b2) {
        return b2 > -65;
    }
}
