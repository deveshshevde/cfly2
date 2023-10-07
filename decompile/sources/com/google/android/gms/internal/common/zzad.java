package com.google.android.gms.internal.common;

import java.util.Iterator;

public final class zzad<E> extends zzaa<E> {
    public zzad() {
        super(4);
    }

    zzad(int i2) {
        super(4);
    }

    public final zzad<E> zzb(E e2) {
        super.zza(e2);
        return this;
    }

    public final zzad<E> zzc(Iterator<? extends E> it2) {
        while (it2.hasNext()) {
            super.zza(it2.next());
        }
        return this;
    }
}
