package com.google.android.gms.tagmanager;

import com.google.android.gms.common.internal.m;
import java.util.Arrays;

final class zzau {
    public final String zza;
    public final Object zzb;

    zzau(String str, Object obj) {
        this.zza = str;
        this.zzb = obj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzau)) {
            return false;
        }
        zzau zzau = (zzau) obj;
        if (!this.zza.equals(zzau.zza)) {
            return false;
        }
        Object obj2 = this.zzb;
        if (obj2 == null && zzau.zzb == null) {
            return true;
        }
        return obj2 != null && obj2.equals(zzau.zzb);
    }

    public final int hashCode() {
        m.a(this.zzb);
        return Arrays.hashCode(new Integer[]{Integer.valueOf(this.zza.hashCode()), Integer.valueOf(this.zzb.hashCode())});
    }

    public final String toString() {
        String str = this.zza;
        String valueOf = String.valueOf(this.zzb);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(valueOf).length());
        sb.append("Key: ");
        sb.append(str);
        sb.append(" value: ");
        sb.append(valueOf);
        return sb.toString();
    }
}
