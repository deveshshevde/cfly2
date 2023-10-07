package com.google.android.gms.analytics;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.internal.gtm.zzfm;
import com.google.android.gms.internal.gtm.zzfn;

public final class AnalyticsService extends Service implements zzfm {
    private zzfn<AnalyticsService> zza;

    private final zzfn<AnalyticsService> zzb() {
        if (this.zza == null) {
            this.zza = new zzfn<>(this);
        }
        return this.zza;
    }

    public boolean callServiceStopSelfResult(int i2) {
        return stopSelfResult(i2);
    }

    public IBinder onBind(Intent intent) {
        zzb();
        return null;
    }

    public final void onCreate() {
        super.onCreate();
        zzb().zze();
    }

    public final void onDestroy() {
        zzb().zzf();
        super.onDestroy();
    }

    public final int onStartCommand(Intent intent, int i2, int i3) {
        zzb().zza(intent, i2, i3);
        return 2;
    }

    public final void zza(JobParameters jobParameters, boolean z2) {
        throw new UnsupportedOperationException();
    }
}
