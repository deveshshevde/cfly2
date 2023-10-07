package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.util.d;
import fg.i;

public final class zzez {
    private double zza = 60.0d;
    private long zzb;
    private final Object zzc = new Object();
    private final String zzd = "tracking";
    private final d zze;

    public zzez(int i2, long j2, String str, d dVar) {
        this.zze = dVar;
    }

    public final boolean zza() {
        synchronized (this.zzc) {
            long a2 = this.zze.a();
            double d2 = this.zza;
            if (d2 < 60.0d) {
                double d3 = (double) (a2 - this.zzb);
                Double.isNaN(d3);
                double d4 = d3 / 2000.0d;
                if (d4 > i.f27244a) {
                    d2 = Math.min(60.0d, d2 + d4);
                    this.zza = d2;
                }
            }
            this.zzb = a2;
            if (d2 >= 1.0d) {
                this.zza = d2 - 4.0d;
                return true;
            }
            String str = this.zzd;
            StringBuilder sb = new StringBuilder(str.length() + 34);
            sb.append("Excessive ");
            sb.append(str);
            sb.append(" detected; call ignored.");
            zzfa.zze(sb.toString());
            return false;
        }
    }
}
