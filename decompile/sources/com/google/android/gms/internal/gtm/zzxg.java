package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.Map;

final class zzxg implements Iterator<Map.Entry> {
    final /* synthetic */ zzxk zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator<Map.Entry> zzd;

    /* synthetic */ zzxg(zzxk zzxk, zzxf zzxf) {
        this.zza = zzxk;
    }

    private final Iterator<Map.Entry> zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzc.entrySet().iterator();
        }
        return this.zzd;
    }

    public final boolean hasNext() {
        if (this.zzb + 1 >= this.zza.zzb.size()) {
            return !this.zza.zzc.isEmpty() && zza().hasNext();
        }
        return true;
    }

    public final /* synthetic */ Object next() {
        this.zzc = true;
        int i2 = this.zzb + 1;
        this.zzb = i2;
        return (Map.Entry) (i2 < this.zza.zzb.size() ? this.zza.zzb.get(this.zzb) : zza().next());
    }

    public final void remove() {
        if (this.zzc) {
            this.zzc = false;
            this.zza.zzn();
            if (this.zzb < this.zza.zzb.size()) {
                zzxk zzxk = this.zza;
                int i2 = this.zzb;
                this.zzb = i2 - 1;
                Object unused = zzxk.zzl(i2);
                return;
            }
            zza().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
