package com.google.android.gms.internal.gtm;

import android.content.ComponentName;
import android.os.RemoteException;
import com.google.android.gms.analytics.zzr;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.stats.a;
import java.util.Collections;

public final class zzcc extends zzbs {
    /* access modifiers changed from: private */
    public final zzcb zza = new zzcb(this);
    private final zzcw zzb;
    private final zzfo zzc;
    private zzey zzd;

    protected zzcc(zzbv zzbv) {
        super(zzbv);
        this.zzc = new zzfo(zzbv.zzr());
        this.zzb = new zzby(this, zzbv);
    }

    static /* synthetic */ void zzb(zzcc zzcc, ComponentName componentName) {
        zzr.zzh();
        if (zzcc.zzd != null) {
            zzcc.zzd = null;
            zzcc.zzP("Disconnected from device AnalyticsService", componentName);
            zzcc.zzs().zzk();
        }
    }

    static /* synthetic */ void zzi(zzcc zzcc, zzey zzey) {
        zzr.zzh();
        zzcc.zzd = zzey;
        zzcc.zzj();
        zzcc.zzs().zzj();
    }

    private final void zzj() {
        this.zzc.zzb();
        zzcw zzcw = this.zzb;
        zzw();
        zzcw.zzg(zzeu.zzK.zzb().longValue());
    }

    public final void zzc() {
        zzr.zzh();
        zzW();
        try {
            a.a().a(zzo(), this.zza);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        if (this.zzd != null) {
            this.zzd = null;
            zzs().zzk();
        }
    }

    /* access modifiers changed from: protected */
    public final void zzd() {
    }

    public final boolean zze() {
        zzr.zzh();
        zzW();
        zzey zzey = this.zzd;
        if (zzey == null) {
            return false;
        }
        try {
            zzey.zze();
            zzj();
            return true;
        } catch (RemoteException unused) {
            zzO("Failed to clear hits from AnalyticsService");
            return false;
        }
    }

    public final boolean zzf() {
        zzr.zzh();
        zzW();
        if (this.zzd != null) {
            return true;
        }
        zzey zza2 = this.zza.zza();
        if (zza2 == null) {
            return false;
        }
        this.zzd = zza2;
        zzj();
        return true;
    }

    public final boolean zzg() {
        zzr.zzh();
        zzW();
        return this.zzd != null;
    }

    public final boolean zzh(zzex zzex) {
        m.a(zzex);
        zzr.zzh();
        zzW();
        zzey zzey = this.zzd;
        if (zzey == null) {
            return false;
        }
        boolean zzh = zzex.zzh();
        zzw();
        try {
            zzey.zzf(zzex.zzg(), zzex.zzd(), zzh ? zzct.zzi() : zzct.zzk(), Collections.emptyList());
            zzj();
            return true;
        } catch (RemoteException unused) {
            zzO("Failed to send hits to AnalyticsService");
            return false;
        }
    }
}
