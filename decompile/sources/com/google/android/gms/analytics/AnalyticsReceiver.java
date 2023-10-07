package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.gtm.zzfi;

public final class AnalyticsReceiver extends BroadcastReceiver {
    private zzfi zza;

    public void onReceive(Context context, Intent intent) {
        if (this.zza == null) {
            this.zza = new zzfi();
        }
        zzfi.zzb(context, intent);
    }
}
