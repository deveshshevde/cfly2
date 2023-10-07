package com.google.android.gms.internal.gtm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

public final class zzfu {
    public static final int zza;

    static {
        int i2 = 33554432;
        if (Build.VERSION.SDK_INT < 31 && (Build.VERSION.SDK_INT < 30 || Build.VERSION.CODENAME.length() != 1 || Build.VERSION.CODENAME.charAt(0) < 'S' || Build.VERSION.CODENAME.charAt(0) > 'Z')) {
            i2 = 0;
        }
        zza = i2;
    }

    public static PendingIntent zza(Context context, int i2, Intent intent, int i3) {
        return PendingIntent.getBroadcast(context, 0, intent, i3);
    }
}
