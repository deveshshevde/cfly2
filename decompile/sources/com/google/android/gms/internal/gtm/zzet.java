package com.google.android.gms.internal.gtm;

public final class zzet<V> {
    private final zzes<V> zza;
    private final V zzb;
    private final V zzc;
    private final Object zzd = new Object();

    private zzet(V v2, V v3, zzes<V> zzes) {
        this.zzb = v2;
        this.zzc = v3;
        this.zza = zzes;
    }

    static <T> zzet<T> zza(T t2, T t3, zzes<T> zzes) {
        return new zzet<>(t2, t3, zzes);
    }

    public final V zzb() {
        synchronized (this.zzd) {
        }
        return this.zzb;
    }
}
