package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzj;
import java.util.HashMap;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public final class zzba extends zzj<zzba> {
    public int zza;
    public int zzb;
    private String zzc;

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, this.zzc);
        hashMap.put("screenColors", 0);
        hashMap.put("screenWidth", Integer.valueOf(this.zza));
        hashMap.put("screenHeight", Integer.valueOf(this.zzb));
        hashMap.put("viewportWidth", 0);
        hashMap.put("viewportHeight", 0);
        return zza(hashMap);
    }

    public final /* synthetic */ void zzc(zzj zzj) {
        zzba zzba = (zzba) zzj;
        int i2 = this.zza;
        if (i2 != 0) {
            zzba.zza = i2;
        }
        int i3 = this.zzb;
        if (i3 != 0) {
            zzba.zzb = i3;
        }
        if (!TextUtils.isEmpty(this.zzc)) {
            zzba.zzc = this.zzc;
        }
    }

    public final String zzd() {
        return this.zzc;
    }

    public final void zze(String str) {
        this.zzc = str;
    }
}
