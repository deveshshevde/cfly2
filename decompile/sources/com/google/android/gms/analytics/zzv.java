package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.internal.gtm.zzbs;
import com.google.android.gms.internal.gtm.zzbv;
import com.google.android.gms.internal.gtm.zzfr;
import java.util.HashMap;

final class zzv extends zzbs {
    final /* synthetic */ Tracker zza;
    private boolean zzb;
    private int zzc;
    private long zzd = -1;
    private boolean zze;
    private long zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected zzv(Tracker tracker, zzbv zzbv) {
        super(zzbv);
        this.zza = tracker;
    }

    private final void zzg() {
        if (this.zzd >= 0 || this.zzb) {
            zzp().zzk(this.zza.zze);
        } else {
            zzp().zzl(this.zza.zze);
        }
    }

    public final void zza(Activity activity) {
        String str;
        if (this.zzc == 0 && zzC().b() >= this.zzf + Math.max(1000, this.zzd)) {
            this.zze = true;
        }
        this.zzc++;
        if (this.zzb) {
            Intent intent = activity.getIntent();
            if (intent != null) {
                this.zza.setCampaignParamsOnNextHit(intent.getData());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("&t", "screenview");
            Tracker tracker = this.zza;
            if (tracker.zzg != null) {
                zzfr zzl = this.zza.zzg;
                str = activity.getClass().getCanonicalName();
                String str2 = zzl.zzg.get(str);
                if (str2 != null) {
                    str = str2;
                }
            } else {
                str = activity.getClass().getCanonicalName();
            }
            tracker.set("&cd", str);
            if (TextUtils.isEmpty((CharSequence) hashMap.get("&dr"))) {
                m.a(activity);
                Intent intent2 = activity.getIntent();
                String str3 = null;
                if (intent2 != null) {
                    String stringExtra = intent2.getStringExtra("android.intent.extra.REFERRER_NAME");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        str3 = stringExtra;
                    }
                }
                if (!TextUtils.isEmpty(str3)) {
                    hashMap.put("&dr", str3);
                }
            }
            this.zza.send(hashMap);
        }
    }

    public final void zzb(Activity activity) {
        int i2 = this.zzc - 1;
        this.zzc = i2;
        int max = Math.max(0, i2);
        this.zzc = max;
        if (max == 0) {
            this.zzf = zzC().b();
        }
    }

    public final void zzc(boolean z2) {
        this.zzb = z2;
        zzg();
    }

    /* access modifiers changed from: protected */
    public final void zzd() {
    }

    public final void zze(long j2) {
        this.zzd = j2;
        zzg();
    }

    public final synchronized boolean zzf() {
        boolean z2;
        z2 = this.zze;
        this.zze = false;
        return z2;
    }
}
