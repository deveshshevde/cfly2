package com.google.android.gms.analytics;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.internal.gtm.zzfm;
import com.google.android.gms.internal.gtm.zzfn;

public final class AnalyticsJobService extends JobService implements zzfm {
    private zzfn<AnalyticsJobService> zza;

    private final zzfn<AnalyticsJobService> zzb() {
        if (this.zza == null) {
            this.zza = new zzfn<>(this);
        }
        return this.zza;
    }

    public boolean callServiceStopSelfResult(int i2) {
        return stopSelfResult(i2);
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

    public boolean onStartJob(JobParameters jobParameters) {
        zzb().zzi(jobParameters);
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    public final void zza(JobParameters jobParameters, boolean z2) {
        jobFinished(jobParameters, false);
    }
}
