package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

public final class zzcx {
    static final Map<String, String> zza = new HashMap();
    private static String zzb;

    public static String zza(String str, String str2) {
        if (str2 != null) {
            String valueOf = String.valueOf(str);
            return Uri.parse(valueOf.length() != 0 ? "http://hostname/?".concat(valueOf) : new String("http://hostname/?")).getQueryParameter(str2);
        } else if (str.length() > 0) {
            return str;
        } else {
            return null;
        }
    }

    public static void zzc(Context context, String str) {
        String zza2 = zza(str, "conv");
        if (zza2 != null && zza2.length() > 0) {
            zza.put(zza2, str);
            zzfg.zza(context, "gtm_click_referrers", zza2, str);
        }
    }

    public static void zzd(String str) {
        synchronized (zzcx.class) {
            zzb = str;
        }
    }

    static void zze(Context context, String str) {
        zzfg.zza(context, "gtm_install_referrer", "referrer", str);
        zzc(context, str);
    }
}
