package com.google.android.gms.internal.gtm;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.analytics.zzr;

public final class zzfh extends zzbs {
    /* access modifiers changed from: private */
    public SharedPreferences zza;
    private long zzb;
    private long zzc = -1;
    private final zzfg zzd;

    protected zzfh(zzbv zzbv) {
        super(zzbv);
        zzw();
        this.zzd = new zzfg(this, "monitoring", zzeu.zzP.zzb().longValue(), (zzff) null);
    }

    public final long zza() {
        zzr.zzh();
        zzW();
        long j2 = this.zzb;
        if (j2 != 0) {
            return j2;
        }
        long j3 = this.zza.getLong("first_run", 0);
        if (j3 != 0) {
            this.zzb = j3;
            return j3;
        }
        long a2 = zzC().a();
        SharedPreferences.Editor edit = this.zza.edit();
        edit.putLong("first_run", a2);
        if (!edit.commit()) {
            zzR("Failed to commit first run time");
        }
        this.zzb = a2;
        return a2;
    }

    public final long zzb() {
        zzr.zzh();
        zzW();
        long j2 = this.zzc;
        if (j2 != -1) {
            return j2;
        }
        long j3 = this.zza.getLong("last_dispatch", 0);
        this.zzc = j3;
        return j3;
    }

    /* access modifiers changed from: protected */
    public final void zzd() {
        this.zza = zzo().getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
    }

    public final zzfg zze() {
        return this.zzd;
    }

    public final zzfo zzf() {
        return new zzfo(zzC(), zza());
    }

    public final String zzg() {
        zzr.zzh();
        zzW();
        String string = this.zza.getString("installation_campaign", (String) null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string;
    }

    public final void zzh(String str) {
        zzr.zzh();
        zzW();
        SharedPreferences.Editor edit = this.zza.edit();
        if (TextUtils.isEmpty(str)) {
            edit.remove("installation_campaign");
        } else {
            edit.putString("installation_campaign", str);
        }
        if (!edit.commit()) {
            zzR("Failed to commit campaign data");
        }
    }

    public final void zzi() {
        zzr.zzh();
        zzW();
        long a2 = zzC().a();
        SharedPreferences.Editor edit = this.zza.edit();
        edit.putLong("last_dispatch", a2);
        edit.apply();
        this.zzc = a2;
    }
}
