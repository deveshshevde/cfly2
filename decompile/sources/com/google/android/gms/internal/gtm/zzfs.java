package com.google.android.gms.internal.gtm;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.util.h;
import fg.i;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class zzfs {
    public static long zza(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static zzaw zzb(zzfb zzfb, String str) {
        m.a(zzfb);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        new HashMap();
        try {
            String valueOf = String.valueOf(str);
            Map<String, String> a2 = h.a(new URI(valueOf.length() != 0 ? "?".concat(valueOf) : new String("?")), "UTF-8");
            zzaw zzaw = new zzaw();
            zzaw.zzp(a2.get("utm_content"));
            zzaw.zzu(a2.get("utm_medium"));
            zzaw.zzv(a2.get("utm_campaign"));
            zzaw.zzw(a2.get("utm_source"));
            zzaw.zzt(a2.get("utm_term"));
            zzaw.zzs(a2.get("utm_id"));
            zzaw.zzo(a2.get("anid"));
            zzaw.zzr(a2.get("gclid"));
            zzaw.zzq(a2.get("dclid"));
            zzaw.zzn(a2.get("aclid"));
            return zzaw;
        } catch (URISyntaxException e2) {
            zzfb.zzS("No valid campaign data found", e2);
            return null;
        }
    }

    public static String zzc(boolean z2) {
        return true != z2 ? "0" : "1";
    }

    public static String zzd(Locale locale) {
        if (locale == null) {
            return null;
        }
        String language = locale.getLanguage();
        if (TextUtils.isEmpty(language)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(language.toLowerCase(locale));
        if (!TextUtils.isEmpty(locale.getCountry())) {
            sb.append("-");
            sb.append(locale.getCountry().toLowerCase(locale));
        }
        return sb.toString();
    }

    public static MessageDigest zze(String str) {
        int i2 = 0;
        while (i2 < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                if (instance != null) {
                    return instance;
                }
                i2++;
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    public static Map<String, String> zzf(String str) {
        HashMap hashMap = new HashMap();
        for (String split : str.split("&")) {
            String[] split2 = split.split("=", 3);
            int length = split2.length;
            String str2 = null;
            if (length > 1) {
                hashMap.put(split2[0], TextUtils.isEmpty(split2[1]) ? null : split2[1]);
                if (length == 3 && !TextUtils.isEmpty(split2[1]) && !hashMap.containsKey(split2[1])) {
                    String str3 = split2[1];
                    if (!TextUtils.isEmpty(split2[2])) {
                        str2 = split2[2];
                    }
                    hashMap.put(str3, str2);
                }
            } else if (length == 1 && split2[0].length() != 0) {
                hashMap.put(split2[0], (Object) null);
            }
        }
        return hashMap;
    }

    public static void zzg(Map<String, String> map, String str, String str2) {
        if (str2 != null && !map.containsKey(str)) {
            map.put(str, str2);
        }
    }

    public static void zzh(Map<String, String> map, String str, Map<String, String> map2) {
        zzg(map, str, map2.get(str));
    }

    public static boolean zzi(Context context, String str, boolean z2) {
        try {
            ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, str), 0);
            return receiverInfo != null && receiverInfo.enabled && (!z2 || receiverInfo.exported);
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static boolean zzj(double d2, String str) {
        int i2;
        if (d2 > i.f27244a && d2 < 100.0d) {
            if (!TextUtils.isEmpty(str)) {
                i2 = 0;
                for (int length = str.length() - 1; length >= 0; length--) {
                    char charAt = str.charAt(length);
                    i2 = ((i2 << 6) & 65535) + charAt + (charAt << 14);
                    int i3 = i2 >> 21;
                    if ((266338304 & i2) != 0) {
                        i2 ^= i3 & 127;
                    }
                }
            } else {
                i2 = 1;
            }
            if (((double) (i2 % 10000)) >= d2 * 100.0d) {
                return true;
            }
        }
        return false;
    }
}
