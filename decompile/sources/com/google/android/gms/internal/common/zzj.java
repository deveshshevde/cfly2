package com.google.android.gms.internal.common;

import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class zzj<T> implements Iterator<T> {
    private T zza;
    private int zzb = 2;

    protected zzj() {
    }

    public final boolean hasNext() {
        int i2 = this.zzb;
        if (i2 != 4) {
            int i3 = i2 - 1;
            if (i2 == 0) {
                throw null;
            } else if (i3 == 0) {
                return true;
            } else {
                if (i3 != 2) {
                    this.zzb = 4;
                    this.zza = zza();
                    if (this.zzb != 3) {
                        this.zzb = 1;
                        return true;
                    }
                }
                return false;
            }
        } else {
            throw new IllegalStateException();
        }
    }

    public final T next() {
        if (hasNext()) {
            this.zzb = 2;
            T t2 = this.zza;
            this.zza = null;
            return t2;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: protected */
    public abstract T zza();

    /* access modifiers changed from: protected */
    public final T zzb() {
        this.zzb = 3;
        return null;
    }
}
