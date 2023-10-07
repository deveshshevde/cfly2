package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.m;
import java.util.Map;

public final class zzfb extends zzbs {
    private static zzfb zza;

    public zzfb(zzbv zzbv) {
        super(zzbv);
    }

    public static zzfb zza() {
        return zza;
    }

    protected static final String zzf(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf((long) ((Integer) obj).intValue());
        }
        String str = "-";
        if (!(obj instanceof Long)) {
            return obj instanceof Boolean ? String.valueOf(obj) : obj instanceof Throwable ? obj.getClass().getCanonicalName() : str;
        }
        Long l2 = (Long) obj;
        int i2 = (Math.abs(l2.longValue()) > 100 ? 1 : (Math.abs(l2.longValue()) == 100 ? 0 : -1));
        String valueOf = String.valueOf(obj);
        if (i2 < 0) {
            return valueOf;
        }
        if (valueOf.charAt(0) != '-') {
            str = "";
        }
        String valueOf2 = String.valueOf(Math.abs(l2.longValue()));
        return str + Math.round(Math.pow(10.0d, (double) (valueOf2.length() - 1))) + "..." + str + Math.round(Math.pow(10.0d, (double) valueOf2.length()) - 4.0d);
    }

    public final void zzb(zzex zzex, String str) {
        zzS(str.length() != 0 ? "Discarding hit. ".concat(str) : new String("Discarding hit. "), zzex != null ? zzex.toString() : "no hit data");
    }

    public final void zzc(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append(',');
            }
            sb.append((String) next.getKey());
            sb.append('=');
            sb.append((String) next.getValue());
        }
        zzS(str.length() != 0 ? "Discarding hit. ".concat(str) : new String("Discarding hit. "), sb.toString());
    }

    /* access modifiers changed from: protected */
    public final void zzd() {
        synchronized (zzfb.class) {
            zza = this;
        }
    }

    public final synchronized void zze(int i2, String str, Object obj, Object obj2, Object obj3) {
        char c2;
        m.a(str);
        if (zzw().zzb()) {
            zzw();
            c2 = 'C';
        } else {
            zzw();
            c2 = 'c';
        }
        char charAt = "01VDIWEA?".charAt(i2);
        String str2 = zzbt.zza;
        String zzD = zzD(str, zzf(obj), zzf(obj2), zzf(obj3));
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 4 + String.valueOf(zzD).length());
        sb.append("3");
        sb.append(charAt);
        sb.append(c2);
        sb.append(str2);
        sb.append(":");
        sb.append(zzD);
        String sb2 = sb.toString();
        if (sb2.length() > 1024) {
            sb2 = sb2.substring(0, 1024);
        }
        zzfh zzp = zzt().zzp();
        if (zzp != null) {
            zzp.zze().zzc(sb2);
        }
    }
}
