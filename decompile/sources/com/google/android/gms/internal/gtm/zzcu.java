package com.google.android.gms.internal.gtm;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

final class zzcu implements Logger {
    private int zza = 2;
    private boolean zzb;

    zzcu() {
    }

    public final void error(Exception exc) {
    }

    public final void error(String str) {
    }

    public final int getLogLevel() {
        return this.zza;
    }

    public final void info(String str) {
    }

    public final void setLogLevel(int i2) {
        this.zza = i2;
        if (!this.zzb) {
            String zzb2 = zzeu.zzc.zzb();
            StringBuilder sb = new StringBuilder(zzb2.length() + 91);
            sb.append("Logger is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag.");
            sb.append(zzb2);
            sb.append(" DEBUG");
            Log.i(zzeu.zzc.zzb(), sb.toString());
            this.zzb = true;
        }
    }

    public final void verbose(String str) {
    }

    public final void warn(String str) {
    }
}
