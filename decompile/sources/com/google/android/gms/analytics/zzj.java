package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzj;
import fg.i;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class zzj<T extends zzj> {
    public static String zza(Object obj) {
        return zzd(obj, 0);
    }

    public static String zzb(Map map) {
        return zzd(map, 1);
    }

    private static String zzd(Object obj, int i2) {
        if (i2 > 10) {
            return "ERROR: Recursive toString calls";
        }
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return TextUtils.isEmpty((String) obj) ? "" : obj.toString();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue() == 0 ? "" : obj.toString();
        }
        if (obj instanceof Long) {
            return ((Long) obj).longValue() == 0 ? "" : obj.toString();
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue() == i.f27244a ? "" : obj.toString();
        }
        if (obj instanceof Boolean) {
            return !((Boolean) obj).booleanValue() ? "" : obj.toString();
        }
        if (obj instanceof List) {
            StringBuilder sb = new StringBuilder();
            if (i2 > 0) {
                sb.append("[");
            }
            int length = sb.length();
            for (Object next : (List) obj) {
                if (sb.length() > length) {
                    sb.append(", ");
                }
                sb.append(zzd(next, i2 + 1));
            }
            if (i2 > 0) {
                sb.append("]");
            }
            return sb.toString();
        } else if (!(obj instanceof Map)) {
            return obj.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            boolean z2 = false;
            int i3 = 0;
            for (Map.Entry entry : new TreeMap((Map) obj).entrySet()) {
                String zzd = zzd(entry.getValue(), i2 + 1);
                if (!TextUtils.isEmpty(zzd)) {
                    if (i2 > 0 && !z2) {
                        sb2.append("{");
                        i3 = sb2.length();
                        z2 = true;
                    }
                    if (sb2.length() > i3) {
                        sb2.append(", ");
                    }
                    sb2.append((String) entry.getKey());
                    sb2.append('=');
                    sb2.append(zzd);
                }
            }
            if (z2) {
                sb2.append("}");
            }
            return sb2.toString();
        }
    }

    public abstract void zzc(T t2);
}
