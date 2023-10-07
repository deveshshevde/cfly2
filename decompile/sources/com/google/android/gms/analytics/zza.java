package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.internal.gtm.zzbe;
import com.google.android.gms.internal.gtm.zzbi;
import com.google.android.gms.internal.gtm.zzbv;
import java.util.ListIterator;

public class zza extends zzk<zza> {
    private final zzbv zzb;
    private boolean zzc;

    public zza(zzbv zzbv) {
        super(zzbv.zzd(), zzbv.zzr());
        this.zzb = zzbv;
    }

    public final zzh zza() {
        zzh zzh = new zzh(this.zza);
        zzh.zzg(this.zzb.zzh().zza());
        zzh.zzg(this.zzb.zzk().zza());
        zzn(zzh);
        return zzh;
    }

    /* access modifiers changed from: package-private */
    public final zzbv zzb() {
        return this.zzb;
    }

    public final void zzc(String str) {
        m.a(str);
        Uri zza = zzb.zza(str);
        ListIterator<zzt> listIterator = this.zza.zzf().listIterator();
        while (listIterator.hasNext()) {
            if (zza.equals(listIterator.next().zzb())) {
                listIterator.remove();
            }
        }
        this.zza.zzf().add(new zzb(this.zzb, str));
    }

    public final void zzd(boolean z2) {
        this.zzc = z2;
    }

    /* access modifiers changed from: protected */
    public final void zze(zzh zzh) {
        zzbe zzbe = (zzbe) zzh.zzb(zzbe.class);
        if (TextUtils.isEmpty(zzbe.zze())) {
            zzbe.zzj(this.zzb.zzi().zzb());
        }
        if (this.zzc && TextUtils.isEmpty(zzbe.zzd())) {
            zzbi zze = this.zzb.zze();
            zzbe.zzi(zze.zza());
            zzbe.zzh(zze.zzb());
        }
    }
}
