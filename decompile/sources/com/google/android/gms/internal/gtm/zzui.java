package com.google.android.gms.internal.gtm;

final class zzui {
    private final Object zza;
    private final int zzb;

    zzui(Object obj, int i2) {
        this.zza = obj;
        this.zzb = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzui)) {
            return false;
        }
        zzui zzui = (zzui) obj;
        return this.zza == zzui.zza && this.zzb == zzui.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
