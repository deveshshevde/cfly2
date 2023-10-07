package com.google.android.gms.analytics;

import com.google.android.gms.analytics.zzk;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.util.d;
import java.util.ArrayList;
import java.util.List;

public class zzk<T extends zzk> {
    protected final zzh zza;
    private final zzr zzb;
    private final List<zzi> zzc = new ArrayList();

    protected zzk(zzr zzr, d dVar) {
        m.a(zzr);
        this.zzb = zzr;
        zzh zzh = new zzh(this, dVar);
        zzh.zzh();
        this.zza = zzh;
    }

    /* access modifiers changed from: protected */
    public void zze(zzh zzh) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public final zzr zzm() {
        return this.zzb;
    }

    /* access modifiers changed from: protected */
    public final void zzn(zzh zzh) {
        for (zzi zza2 : this.zzc) {
            zza2.zza();
        }
    }
}
