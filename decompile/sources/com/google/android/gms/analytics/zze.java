package com.google.android.gms.analytics;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

final class zze implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ GoogleAnalytics zza;

    zze(GoogleAnalytics googleAnalytics) {
        this.zza = googleAnalytics;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        this.zza.zzh(activity);
    }

    public final void onActivityStopped(Activity activity) {
        this.zza.zzi(activity);
    }
}
