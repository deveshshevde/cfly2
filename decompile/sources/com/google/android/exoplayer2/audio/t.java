package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.ad;

public final class t {
    public static int a(int i2, int i3) {
        if (i2 != 1) {
            if (i2 == 3) {
                return i3 == 32 ? 4 : 0;
            }
            if (i2 != 65534) {
                return 0;
            }
        }
        return ad.c(i3);
    }
}
