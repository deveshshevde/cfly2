package com.google.android.gms.internal.common;

public final class zzah {
    static Object[] zza(Object[] objArr, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            if (objArr[i3] != null) {
                i3++;
            } else {
                StringBuilder sb = new StringBuilder(20);
                sb.append("at index ");
                sb.append(i3);
                throw new NullPointerException(sb.toString());
            }
        }
        return objArr;
    }
}
