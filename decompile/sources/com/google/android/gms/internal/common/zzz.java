package com.google.android.gms.internal.common;

import java.util.NoSuchElementException;

abstract class zzz<E> extends zzak<E> {
    private final int zza;
    private int zzb;

    protected zzz(int i2, int i3) {
        zzs.zzb(i3, i2, "index");
        this.zza = i2;
        this.zzb = i3;
    }

    public final boolean hasNext() {
        return this.zzb < this.zza;
    }

    public final boolean hasPrevious() {
        return this.zzb > 0;
    }

    public final E next() {
        if (hasNext()) {
            int i2 = this.zzb;
            this.zzb = i2 + 1;
            return zza(i2);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.zzb;
    }

    public final E previous() {
        if (hasPrevious()) {
            int i2 = this.zzb - 1;
            this.zzb = i2;
            return zza(i2);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.zzb - 1;
    }

    /* access modifiers changed from: protected */
    public abstract E zza(int i2);
}
