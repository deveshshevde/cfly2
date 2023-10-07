package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LogPrinter;
import com.amap.api.maps.AMap;
import java.util.ArrayList;
import java.util.Collections;

public final class zzg implements zzt {
    private static final Uri zza;
    private final LogPrinter zzb = new LogPrinter(4, "GA/LogCatTransport");

    static {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("uri");
        builder.authority(AMap.LOCAL);
        zza = builder.build();
    }

    public final Uri zzb() {
        return zza;
    }

    public final void zze(zzh zzh) {
        ArrayList arrayList = new ArrayList(zzh.zze());
        Collections.sort(arrayList, new zzf(this));
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            String obj = ((zzj) arrayList.get(i2)).toString();
            if (!TextUtils.isEmpty(obj)) {
                if (sb.length() != 0) {
                    sb.append(", ");
                }
                sb.append(obj);
            }
        }
        this.zzb.println(sb.toString());
    }
}
