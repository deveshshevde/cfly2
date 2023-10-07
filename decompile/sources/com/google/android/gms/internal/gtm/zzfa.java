package com.google.android.gms.internal.gtm;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

@Deprecated
public final class zzfa {
    private static volatile Logger zza = new zzcu();

    public static Logger zza() {
        return zza;
    }

    public static void zzb(String str, Object obj) {
        String str2;
        zzfb zza2 = zzfb.zza();
        if (zza2 != null) {
            zza2.zzK(str, obj);
        } else if (zzf(3)) {
            if (obj != null) {
                String str3 = (String) obj;
                StringBuilder sb = new StringBuilder(str.length() + 1 + str3.length());
                sb.append(str);
                sb.append(":");
                sb.append(str3);
                str2 = sb.toString();
            } else {
                str2 = str;
            }
            Log.e(zzeu.zzc.zzb(), str2);
        }
        Logger logger = zza;
        if (logger != null) {
            logger.error(str);
        }
    }

    public static void zzc(Logger logger) {
        zza = logger;
    }

    public static void zzd(String str) {
        zzfb zza2 = zzfb.zza();
        if (zza2 != null) {
            zza2.zzO(str);
        } else if (zzf(0)) {
            Log.v(zzeu.zzc.zzb(), str);
        }
        Logger logger = zza;
        if (logger != null) {
            logger.verbose(str);
        }
    }

    public static void zze(String str) {
        zzfb zza2 = zzfb.zza();
        if (zza2 != null) {
            zza2.zzR(str);
        } else if (zzf(2)) {
            Log.w(zzeu.zzc.zzb(), str);
        }
        Logger logger = zza;
        if (logger != null) {
            logger.warn(str);
        }
    }

    public static boolean zzf(int i2) {
        return zza != null && zza.getLogLevel() <= i2;
    }
}
