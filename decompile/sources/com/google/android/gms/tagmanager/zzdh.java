package com.google.android.gms.tagmanager;

import android.util.Log;

public final class zzdh {
    static final zzbg zzb = new zzbg();

    public static void zza(String str) {
        Log.e("GoogleTagManager", str);
    }

    public static void zzb(String str, Throwable th) {
        Log.e("GoogleTagManager", str, th);
    }

    public static void zzc(String str) {
        Log.w("GoogleTagManager", str);
    }

    public static void zzd(String str, Throwable th) {
        Log.w("GoogleTagManager", str, th);
    }
}
