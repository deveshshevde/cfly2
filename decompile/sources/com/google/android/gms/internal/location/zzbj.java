package com.google.android.gms.internal.location;

import android.os.Looper;
import com.google.android.gms.common.internal.m;

public final class zzbj {
    public static Looper zza() {
        m.b(Looper.myLooper() != null, "Can't create handler inside thread that has not called Looper.prepare()");
        return Looper.myLooper();
    }

    public static Looper zza(Looper looper) {
        return looper != null ? looper : zza();
    }
}
