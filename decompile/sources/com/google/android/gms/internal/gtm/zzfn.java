package com.google.android.gms.internal.gtm;

import android.app.job.JobParameters;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.internal.gtm.zzfm;
import com.google.android.gms.stats.a;

public final class zzfn<T extends Context & zzfm> {
    private static Boolean zza;
    /* access modifiers changed from: private */
    public final Handler zzb = new zzga();
    private final T zzc;

    public zzfn(T t2) {
        m.a(t2);
        this.zzc = t2;
    }

    public static boolean zzh(Context context) {
        m.a(context);
        Boolean bool = zza;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z2 = false;
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsService"), 0);
            if (serviceInfo != null && serviceInfo.enabled) {
                z2 = true;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        zza = Boolean.valueOf(z2);
        return z2;
    }

    public final int zza(Intent intent, int i2, int i3) {
        try {
            synchronized (zzfi.zza) {
                a aVar = zzfi.zzb;
                if (aVar != null && aVar.b()) {
                    aVar.a();
                }
            }
        } catch (SecurityException unused) {
        }
        zzbv zzg = zzbv.zzg(this.zzc);
        zzfb zzm = zzg.zzm();
        if (intent == null) {
            zzm.zzR("AnalyticsService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zzg.zzj();
        zzm.zzQ("Local AnalyticsService called. startId, action", Integer.valueOf(i3), action);
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            zzg(new zzfj(this, i3, zzm));
        }
        return 2;
    }

    public final /* synthetic */ void zzc(int i2, zzfb zzfb) {
        if (((zzfm) this.zzc).callServiceStopSelfResult(i2)) {
            zzfb.zzO("Local AnalyticsService processed last dispatch request");
        }
    }

    public final /* synthetic */ void zzd(zzfb zzfb, JobParameters jobParameters) {
        zzfb.zzO("AnalyticsJobService processed last dispatch request");
        ((zzfm) this.zzc).zza(jobParameters, false);
    }

    public final void zze() {
        zzbv zzg = zzbv.zzg(this.zzc);
        zzfb zzm = zzg.zzm();
        zzg.zzj();
        zzm.zzO("Local AnalyticsService is starting up");
    }

    public final void zzf() {
        zzbv zzg = zzbv.zzg(this.zzc);
        zzfb zzm = zzg.zzm();
        zzg.zzj();
        zzm.zzO("Local AnalyticsService is shutting down");
    }

    public final void zzg(Runnable runnable) {
        zzbv.zzg(this.zzc).zzf().zze(new zzfl(this, runnable));
    }

    public final boolean zzi(JobParameters jobParameters) {
        zzbv zzg = zzbv.zzg(this.zzc);
        zzfb zzm = zzg.zzm();
        String string = jobParameters.getExtras().getString("action");
        zzg.zzj();
        zzm.zzP("Local AnalyticsJobService called. action", string);
        if (!"com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(string)) {
            return true;
        }
        zzg(new zzfk(this, zzm, jobParameters));
        return true;
    }
}
