package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.Locale;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public final class zzft extends zzbs {
    protected String zza;
    protected String zzb;
    protected boolean zzc;
    protected int zzd;
    protected boolean zze;
    protected boolean zzf;

    public zzft(zzbv zzbv) {
        super(zzbv);
    }

    public final String zza() {
        zzW();
        return this.zzb;
    }

    public final String zzb() {
        zzW();
        return this.zza;
    }

    public final boolean zzc() {
        zzW();
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final void zzd() {
        ApplicationInfo applicationInfo;
        int i2;
        Context zzo = zzo();
        try {
            applicationInfo = zzo.getPackageManager().getApplicationInfo(zzo.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e2) {
            zzS("PackageManager doesn't know about the app package", e2);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            zzR("Couldn't get ApplicationInfo to load global config");
            return;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null && (i2 = bundle.getInt("com.google.android.gms.analytics.globalConfigResource")) > 0) {
            zzbv zzt = zzt();
            zzew zzew = (zzew) new zzcs(zzt, new zzev(zzt)).zza(i2);
            if (zzew != null) {
                zzO("Loading global XML config values");
                String str = zzew.zza;
                if (str != null) {
                    this.zzb = str;
                    zzG("XML config - app name", str);
                }
                String str2 = zzew.zzb;
                if (str2 != null) {
                    this.zza = str2;
                    zzG("XML config - app version", str2);
                }
                String str3 = zzew.zzc;
                boolean z2 = false;
                if (str3 != null) {
                    String lowerCase = str3.toLowerCase(Locale.US);
                    int i3 = "verbose".equals(lowerCase) ? 0 : "info".equals(lowerCase) ? 1 : "warning".equals(lowerCase) ? 2 : IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR.equals(lowerCase) ? 3 : -1;
                    if (i3 >= 0) {
                        zzP("XML config - log level", Integer.valueOf(i3));
                    }
                }
                int i4 = zzew.zzd;
                if (i4 >= 0) {
                    this.zzd = i4;
                    this.zzc = true;
                    zzG("XML config - dispatch period (sec)", Integer.valueOf(i4));
                }
                int i5 = zzew.zze;
                if (i5 != -1) {
                    if (1 == i5) {
                        z2 = true;
                    }
                    this.zzf = z2;
                    this.zze = true;
                    zzG("XML config - dry run", Boolean.valueOf(z2));
                }
            }
        }
    }

    public final boolean zze() {
        zzW();
        return this.zze;
    }

    public final boolean zzf() {
        zzW();
        return false;
    }
}
