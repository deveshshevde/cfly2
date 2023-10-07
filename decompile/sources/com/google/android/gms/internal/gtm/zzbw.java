package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.internal.m;

public final class zzbw {
    private final Context zza;
    private final Context zzb;

    public zzbw(Context context) {
        m.a(context);
        Context applicationContext = context.getApplicationContext();
        m.a(applicationContext, (Object) "Application context can't be null");
        this.zza = applicationContext;
        this.zzb = applicationContext;
    }

    public final Context zza() {
        return this.zza;
    }

    public final Context zzb() {
        return this.zzb;
    }
}
