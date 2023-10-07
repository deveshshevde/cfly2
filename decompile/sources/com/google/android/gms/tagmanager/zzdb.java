package com.google.android.gms.tagmanager;

import android.util.LruCache;

final class zzdb<K, V> {
    private final LruCache<K, V> zza;

    public final V zza(K k2) {
        return this.zza.get(k2);
    }

    public final void zzb(K k2, V v2) {
        this.zza.put(k2, v2);
    }
}
