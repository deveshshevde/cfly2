package com.google.android.gms.internal.common;

final class zzl extends zzk {
    private final char zza;

    zzl(char c2) {
        this.zza = c2;
    }

    public final String toString() {
        int i2 = this.zza;
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i3 = 0; i3 < 4; i3++) {
            cArr[5 - i3] = "0123456789ABCDEF".charAt(i2 & 15);
            i2 >>= 4;
        }
        String copyValueOf = String.copyValueOf(cArr);
        StringBuilder sb = new StringBuilder(String.valueOf(copyValueOf).length() + 18);
        sb.append("CharMatcher.is('");
        sb.append(copyValueOf);
        sb.append("')");
        return sb.toString();
    }

    public final boolean zza(char c2) {
        return c2 == this.zza;
    }
}
