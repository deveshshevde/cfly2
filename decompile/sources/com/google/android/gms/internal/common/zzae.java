package com.google.android.gms.internal.common;

final class zzae<E> extends zzz<E> {
    private final zzag<E> zza;

    zzae(zzag<E> zzag, int i2) {
        super(zzag.size(), i2);
        this.zza = zzag;
    }

    /* access modifiers changed from: protected */
    public final E zza(int i2) {
        return this.zza.get(i2);
    }
}
