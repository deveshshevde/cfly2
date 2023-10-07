package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import android.util.Log;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.analytics.zzj;
import com.google.android.gms.common.internal.m;
import java.util.HashMap;
import java.util.UUID;

public final class zzbf extends zzj<zzbf> {
    private int zza;

    public zzbf() {
        UUID randomUUID = UUID.randomUUID();
        int leastSignificantBits = (int) (randomUUID.getLeastSignificantBits() & 2147483647L);
        if (leastSignificantBits == 0 && (leastSignificantBits = (int) (randomUUID.getMostSignificantBits() & 2147483647L)) == 0) {
            Log.e("GAv4", "UUID.randomUUID() returned 0.");
            leastSignificantBits = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        }
        m.a(leastSignificantBits);
        this.zza = leastSignificantBits;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("screenName", (Object) null);
        hashMap.put("interstitial", false);
        hashMap.put("automatic", false);
        hashMap.put("screenId", Integer.valueOf(this.zza));
        hashMap.put("referrerScreenId", 0);
        hashMap.put("referrerScreenName", (Object) null);
        hashMap.put("referrerUri", (Object) null);
        return zza(hashMap);
    }

    public final /* synthetic */ void zzc(zzj zzj) {
        zzbf zzbf = (zzbf) zzj;
        TextUtils.isEmpty((CharSequence) null);
        int i2 = this.zza;
        if (i2 != 0) {
            zzbf.zza = i2;
        }
        TextUtils.isEmpty((CharSequence) null);
        if (!TextUtils.isEmpty((CharSequence) null)) {
            TextUtils.isEmpty((CharSequence) null);
        }
    }

    public final int zzd() {
        return this.zza;
    }
}
