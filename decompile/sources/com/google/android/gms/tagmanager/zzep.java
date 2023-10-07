package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzro;
import com.google.android.gms.internal.gtm.zzrw;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class zzep implements zzer {
    final /* synthetic */ Map zza;
    final /* synthetic */ Map zzb;
    final /* synthetic */ Map zzc;
    final /* synthetic */ Map zzd;

    zzep(zzeu zzeu, Map map, Map map2, Map map3, Map map4) {
        this.zza = map;
        this.zzb = map2;
        this.zzc = map3;
        this.zzd = map4;
    }

    public final void zza(zzrw zzrw, Set<zzro> set, Set<zzro> set2, zzdo zzdo) {
        List list = (List) this.zza.get(zzrw);
        List list2 = (List) this.zzb.get(zzrw);
        if (list != null) {
            set.addAll(list);
        }
        List list3 = (List) this.zzc.get(zzrw);
        List list4 = (List) this.zzd.get(zzrw);
        if (list3 != null) {
            set2.addAll(list3);
        }
    }
}
