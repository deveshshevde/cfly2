package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.d;

public final class zzbt {
    public static final String zza;
    public static final String zzb;

    static {
        String replaceAll = String.valueOf(d.f17673b / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
        zza = replaceAll;
        String valueOf = String.valueOf(replaceAll);
        zzb = valueOf.length() != 0 ? "ma".concat(valueOf) : new String("ma");
    }
}
